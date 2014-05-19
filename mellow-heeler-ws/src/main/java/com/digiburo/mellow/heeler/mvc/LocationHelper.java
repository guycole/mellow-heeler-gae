package com.digiburo.mellow.heeler.mvc;

import com.digiburo.mellow.heeler.entity.RawGeographicLocation;
import com.digiburo.mellow.heeler.entity.RawGeographicLocationDao;
import com.digiburo.mellow.heeler.json.GeoLocation;
import com.digiburo.mellow.heeler.json.GeoLocationList;
import com.digiburo.mellow.heeler.json.GeoLocationRequest;
import com.google.appengine.api.datastore.GeoPt;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

/**
 *  process a fresh JSON message
 */
public class LocationHelper {

  /**
   * Convert from client JSON format and persist to datastore
   * @param geoLocationRequest
   * @return
   */
  public int persist(GeoLocationRequest geoLocationRequest) {
    int count = 0;
    RawGeographicLocationDao dao = new RawGeographicLocationDao();

    GeoLocationList geoLocationList = geoLocationRequest.getLocationList();
    for (GeoLocation geoLocation : geoLocationList) {
      RawGeographicLocation geographicLocation = new RawGeographicLocation();
      geographicLocation.setAccuracy(geoLocation.getAccuracy());
      geographicLocation.setAltitude(geoLocation.getAltitude());
      geographicLocation.setInstallationUuid(geoLocationRequest.getInstallationId());
      geographicLocation.setLocation(new GeoPt(geoLocation.getLatitude().floatValue(), geoLocation.getLongitude().floatValue()));
      geographicLocation.setLocationUuid(geoLocation.getLocationId());
      geographicLocation.setSortieUuid(geoLocationRequest.getSortieId());

      long timeStampMs = geoLocation.getTimeStampMs();
      geographicLocation.setTimeStampMs(timeStampMs);

      SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");
      sdf.setTimeZone(TimeZone.getTimeZone("UTC"));
      geographicLocation.setTimeStamp(sdf.format(new Date(timeStampMs)));

      dao.save(geographicLocation);
      ++count;
    }

    return count;
  }

  /**
   *
   * @param arg
   * @return
   */
  public List<RawGeographicLocation> selectBySortie(String arg) {
    RawGeographicLocationDao dao = new RawGeographicLocationDao();
    return dao.selectBySortie(arg);
  }
}
/*
 * Copyright 2014 Digital Burro, INC
 * Created on May 17, 2014 by gsc
 */

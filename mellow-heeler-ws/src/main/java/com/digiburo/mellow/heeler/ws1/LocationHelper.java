package com.digiburo.mellow.heeler.ws1;

import com.digiburo.mellow.heeler.datastore.dao.GeographicLocationDao;
import com.digiburo.mellow.heeler.datastore.dao.ReceiptDao;
import com.digiburo.mellow.heeler.datastore.entity.GeographicLocation;
import com.digiburo.mellow.heeler.json.GeoLocation;
import com.digiburo.mellow.heeler.json.GeoLocationList;
import com.digiburo.mellow.heeler.json.GeoLocationRequest1;
import com.digiburo.mellow.heeler.json.GeoLocationResponse1;
import com.google.appengine.api.datastore.GeoPt;

import java.util.Date;
import java.util.logging.Logger;

/**
 *  process a fresh JSON message
 */
public class LocationHelper extends AbstractHelper {
  private final Logger logger = Logger.getLogger(getClass().getName());

  public GeoLocationResponse1 handler(final String ipAddress, final String selfUrl, final GeoLocationRequest1 request) {
    if (!authorizationTest(request.getInstallationId())) {
      logger.info("authorization failure");
      return authorizationFailure(ipAddress, selfUrl, request);
    }

    int rowCount = persist(request);

    return successResponse(rowCount, ipAddress, selfUrl, request);
  }

  private GeoLocationResponse1 authorizationFailure(final String ipAddress, final String selfUrl, final GeoLocationRequest1 request) {
    ReceiptDao receiptDao = new ReceiptDao();
    String receipt = receiptDao.generateReceipt(ipAddress, request.getInstallationId(), "location", "authorize failure");

    GeoLocationResponse1 response = new GeoLocationResponse1();
    response.setRemoteIpAddress(ipAddress);
    response.setReceipt(receipt);
    response.setStatus(AUTH_FAIL);
    response.setSortieId(request.getSortieId());
    response.setRowCount(0);

    GeoLocationResponse1.Self self = new GeoLocationResponse1.Self();
    self.setHref(selfUrl);
    response.getLinks().setSelf(self);

    return response;
  }

  private GeoLocationResponse1 successResponse(int rowCount, final String ipAddress, final String selfUrl, final GeoLocationRequest1 request) {
    ReceiptDao receiptDao = new ReceiptDao();
    String receipt = receiptDao.generateReceipt(ipAddress, request.getInstallationId(), "location", "location success:" + rowCount);

    GeoLocationResponse1 response = new GeoLocationResponse1();
    response.setReceipt(receipt);
    response.setRemoteIpAddress(ipAddress);
    response.setStatus(OK);
    response.setSortieId(request.getSortieId());
    response.setRowCount(rowCount);

    GeoLocationResponse1.Self self = new GeoLocationResponse1.Self();
    self.setHref(selfUrl);
    response.getLinks().setSelf(self);

    return response;
  }

  /**
   * Convert from client JSON format and persist to datastore
   * @param geoLocationRequest1
   * @return
   */
  private int persist(GeoLocationRequest1 request) {
    logger.info("persist:" + request.getLocationList().size());

    int count = 0;
    GeographicLocationDao dao = new GeographicLocationDao();

    GeoLocationList geoLocationList = request.getLocationList();
    for (GeoLocation geoLocation : geoLocationList) {
      GeographicLocation rawGeographicLocation = dao.selectOne(geoLocation.getLocationId());
      if (rawGeographicLocation == null) {
        GeographicLocation geographicLocation = new GeographicLocation();
        geographicLocation.setAccuracy(geoLocation.getAccuracy());
        geographicLocation.setAltitude(geoLocation.getAltitude());
        geographicLocation.setInstallationUuid(request.getInstallationId());
        geographicLocation.setLocation(new GeoPt(geoLocation.getLatitude().floatValue(), geoLocation.getLongitude().floatValue()));
        geographicLocation.setLocationUuid(geoLocation.getLocationId());
        geographicLocation.setSpecialFlag(geoLocation.isSpecialFlag());
        geographicLocation.setSortieUuid(request.getSortieId());

        long timeStampMs = geoLocation.getTimeStampMs();
        geographicLocation.setTimeStamp(new Date(timeStampMs));

        dao.save(geographicLocation);

        ++count;
      } else {
        logger.fine("duplicate location:" + geoLocation.getLocationId());
      }
    }

    return count;
  }
}
/*
 * Copyright 2014 Digital Burro, INC
 * Created on May 17, 2014 by gsc
 */

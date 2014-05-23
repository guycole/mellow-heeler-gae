package com.digiburo.mellow.heeler.mvc;

import com.digiburo.mellow.heeler.entity.RawObservation;
import com.digiburo.mellow.heeler.entity.RawObservationDao;
import com.digiburo.mellow.heeler.json.Observation;
import com.digiburo.mellow.heeler.json.ObservationList;
import com.digiburo.mellow.heeler.json.ObservationRequest1;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

/**
 * process a fresh JSON message
 */
public class ObservationHelper {

  /**
   * Convert from client JSON format and persist to datastore
   * @param observationRequest
   * @return
   */
  public int persist(ObservationRequest1 observationRequest) {
    int count = 0;
    RawObservationDao dao = new RawObservationDao();

    ObservationList observationList = observationRequest.getObservationList();
    for (Observation observation:observationList) {
      RawObservation rawObservation = new RawObservation();
      rawObservation.setSsid(observation.getSsid());
      rawObservation.setBssid(observation.getBssid());
      rawObservation.setCapability(observation.getCapability());
      rawObservation.setFrequency(observation.getFrequency());
      rawObservation.setStrength(observation.getStrength());

      rawObservation.setInstallationUuid(observationRequest.getInstallationId());
      rawObservation.setLocationUuid(observation.getLocationId());
      rawObservation.setSortieUuid(observationRequest.getSortieId());

      long timeStampMs = observation.getTimeStampMs();
      rawObservation.setTimeStampMs(timeStampMs);

      SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");
      sdf.setTimeZone(TimeZone.getTimeZone("UTC"));
      rawObservation.setTimeStamp(sdf.format(new Date(timeStampMs)));

      dao.save(rawObservation);
      ++count;
    }

    return count;
  }

  /**
   *
   * @param arg
   * @return
   */
  public List<RawObservation> selectBySortie(String arg) {
    RawObservationDao dao = new RawObservationDao();
    return dao.selectBySortie(arg);
  }
}
/*
 * Copyright 2014 Digital Burro, INC
 * Created on May 17, 2014 by gsc
 */

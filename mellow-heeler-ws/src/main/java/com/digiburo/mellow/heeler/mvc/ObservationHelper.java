package com.digiburo.mellow.heeler.mvc;

import com.digiburo.mellow.heeler.entity.Observation;
import com.digiburo.mellow.heeler.entity.RawObservationDao;
import com.digiburo.mellow.heeler.json.ObservationList;
import com.digiburo.mellow.heeler.json.ObservationRequest1;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;
import java.util.logging.Logger;

/**
 * process a fresh JSON message
 */
public class ObservationHelper {
  private final Logger logger = Logger.getLogger(getClass().getName());

  /**
   * Convert from client JSON format and persist to datastore
   * @param observationRequest
   * @return
   */
  public int persist(ObservationRequest1 observationRequest) {
    logger.info("persist:" + observationRequest.getObservationList().size());

    int count = 0;
    RawObservationDao dao = new RawObservationDao();

    ObservationList observationList = observationRequest.getObservationList();
    for (com.digiburo.mellow.heeler.json.Observation observation:observationList) {
      Observation rawObservation = dao.selectOne(observation.getObservationId());
      if (rawObservation == null) {
        rawObservation = new Observation();
        rawObservation.setSsid(observation.getSsid());
        rawObservation.setBssid(observation.getBssid());
        rawObservation.setCapability(observation.getCapability());
        rawObservation.setFrequency(observation.getFrequency());
        rawObservation.setStrength(observation.getStrength());

        rawObservation.setInstallationUuid(observationRequest.getInstallationId());
        rawObservation.setLocationUuid(observation.getLocationId());
        rawObservation.setObservationUuid(observation.getObservationId());
        rawObservation.setSortieUuid(observationRequest.getSortieId());

  //      long timeStampMs = observation.getTimeStampMs();
  //      rawObservation.setTimeStampMs(timeStampMs);

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");
        sdf.setTimeZone(TimeZone.getTimeZone("UTC"));
  //      rawObservation.setTimeStamp(sdf.format(new Date(timeStampMs)));

        dao.save(rawObservation);
      } else {
        logger.info("duplicate observation:" + observation.getObservationId());
      }

      ++count;
    }

    return count;
  }

  /**
   *
   * @param arg
   * @return
   */
  public List<Observation> selectBySortie(String arg) {
    RawObservationDao dao = new RawObservationDao();
    return dao.selectBySortie(arg);
  }
}
/*
 * Copyright 2014 Digital Burro, INC
 * Created on May 17, 2014 by gsc
 */

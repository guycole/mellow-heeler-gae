package com.digiburo.mellow.heeler.ws;

import com.digiburo.mellow.heeler.datastore.dao.ObservationDao;
import com.digiburo.mellow.heeler.datastore.dao.ReceiptDao;

import com.digiburo.mellow.heeler.json.Observation;
import com.digiburo.mellow.heeler.json.ObservationList;
import com.digiburo.mellow.heeler.json.ObservationRequest1;
import com.digiburo.mellow.heeler.json.ObservationResponse1;

import java.util.Date;
import java.util.logging.Logger;

/**
 * process a fresh JSON message
 */
public class ObservationHelper extends AbstractHelper {
  private final Logger logger = Logger.getLogger(getClass().getName());

  public ObservationResponse1 handler(final String ipAddress, final String selfUrl, final ObservationRequest1 request) {
    if (!authorizationTest(request.getInstallationId())) {
      logger.info("authorization failure");
      return authorizationFailure(ipAddress, selfUrl, request);
    }

    int rowCount = persist(request);

    return successResponse(rowCount, ipAddress, selfUrl, request);
  }

  private ObservationResponse1 authorizationFailure(final String ipAddress, final String selfUrl, final ObservationRequest1 request) {
    ReceiptDao receiptDao = new ReceiptDao();
    String receipt = receiptDao.generateReceipt(ipAddress, request.getInstallationId(), "observation", "authorize failure");

    ObservationResponse1 response = new ObservationResponse1();
    response.setRemoteIpAddress(ipAddress);
    response.setReceipt(receipt);
    response.setStatus(AUTH_FAIL);
    response.setSortieId(request.getSortieId());
    response.setRowCount(0);

    ObservationResponse1.Self self = new ObservationResponse1.Self();
    self.setHref(selfUrl);
    response.getLinks().setSelf(self);

    return response;
  }

  private ObservationResponse1 successResponse(int rowCount, final String ipAddress, final String selfUrl, final ObservationRequest1 request) {
    ReceiptDao receiptDao = new ReceiptDao();
    String receipt = receiptDao.generateReceipt(ipAddress, request.getInstallationId(), "observation", "observation success:" + rowCount);

    ObservationResponse1 response = new ObservationResponse1();
    response.setReceipt(receipt);
    response.setRemoteIpAddress(ipAddress);
    response.setStatus(OK);
    response.setSortieId(request.getSortieId());
    response.setRowCount(rowCount);

    ObservationResponse1.Self self = new ObservationResponse1.Self();
    self.setHref(selfUrl);
    response.getLinks().setSelf(self);

    return response;
  }

  /**
   * Convert from client JSON format and persist to datastore
   * @param observationRequest
   * @return
   */
  private int persist(ObservationRequest1 request) {
    logger.info("persist:" + request.getObservationList().size());

    int count = 0;
    ObservationDao dao = new ObservationDao();

    ObservationList observationList = request.getObservationList();
    for (Observation jsonObservation:observationList) {
      com.digiburo.mellow.heeler.datastore.entity.Observation dbObservation = dao.selectOne(jsonObservation.getObservationId());
      if (dbObservation == null) {
        dbObservation = new com.digiburo.mellow.heeler.datastore.entity.Observation();
        dbObservation.setSsid(jsonObservation.getSsid());
        dbObservation.setBssid(jsonObservation.getBssid());
        dbObservation.setCapability(jsonObservation.getCapability());
        dbObservation.setFrequency(jsonObservation.getFrequency());
        dbObservation.setStrength(jsonObservation.getStrength());
        dbObservation.setInstallationUuid(request.getInstallationId());
        dbObservation.setLocationUuid(jsonObservation.getLocationId());
        dbObservation.setObservationUuid(jsonObservation.getObservationId());
        dbObservation.setSortieUuid(request.getSortieId());

        long timeStampMs = jsonObservation.getTimeStampMs();
        dbObservation.setTimeStamp(new Date(timeStampMs));

        dao.save(dbObservation);

        ++count;
      } else {
        logger.fine("duplicate observation:" + jsonObservation.getObservationId());
      }
    }

    return count;
  }
}
/*
 * Copyright 2014 Digital Burro, INC
 * Created on May 17, 2014 by gsc
 */

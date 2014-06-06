package com.digiburo.mellow.heeler.ws;

import com.digiburo.mellow.heeler.datastore.dao.ReceiptDao;
import com.digiburo.mellow.heeler.datastore.entity.Sortie;
import com.digiburo.mellow.heeler.datastore.dao.SortieDao;
import com.digiburo.mellow.heeler.json.SortieRequest1;
import com.digiburo.mellow.heeler.json.SortieResponse1;
import java.util.Date;
import java.util.logging.Logger;

/**
 *  process a fresh JSON message
 */
public class SortieHelper extends AbstractHelper {
  private final Logger logger = Logger.getLogger(getClass().getName());

  /**
   *
   * @param ipAddress
   * @param selfUrl
   * @param sortieRequest
   * @return
   */
  public SortieResponse1 handler(final String ipAddress, final String selfUrl, final SortieRequest1 request) {
    if (!authorizationTest(request.getInstallationId())) {
      logger.info("authorization failure");
      return authorizationFailure(ipAddress, selfUrl, request);
    }

    int rowCount = persist(request);

    return successResponse(rowCount, ipAddress, selfUrl, request);
  }

  private SortieResponse1 authorizationFailure(final String ipAddress, final String selfUrl, final SortieRequest1 request) {
    ReceiptDao receiptDao = new ReceiptDao();
    String receipt = receiptDao.generateReceipt(ipAddress, request.getInstallationId(), "sortie", "authorize failure");

    SortieResponse1 response = new SortieResponse1();
    response.setRemoteIpAddress(ipAddress);
    response.setReceipt(receipt);
    response.setStatus(AUTH_FAIL);
    response.setSortieId(request.getSortieId());
    response.setRowCount(0);

    SortieResponse1.Self self = new SortieResponse1.Self();
    self.setHref(selfUrl);
    response.getLinks().setSelf(self);

    return response;
  }

  private SortieResponse1 successResponse(int rowCount, final String ipAddress, final String selfUrl, final SortieRequest1 request) {
    ReceiptDao receiptDao = new ReceiptDao();
    String receipt = receiptDao.generateReceipt(ipAddress, request.getInstallationId(), "sortie", "sortie success:" + rowCount);

    SortieResponse1 response = new SortieResponse1();
    response.setReceipt(receipt);
    response.setRemoteIpAddress(ipAddress);
    response.setStatus(OK);
    response.setSortieId(request.getSortieId());
    response.setRowCount(rowCount);

    SortieResponse1.Self self = new SortieResponse1.Self();
    self.setHref(selfUrl);
    response.getLinks().setSelf(self);

    return response;
  }

  /**
   * Convert from client JSON format and persist to datastore
   * @param request
   * @return row count
   */
  private int persist(final SortieRequest1 request) {
    logger.info("persist");

    int count = 0;
    SortieDao dao = new SortieDao();
    Sortie sortie = dao.selectOne(request.getSortieId());

    if (sortie == null) {
      sortie = new Sortie();
      sortie.setName(request.getSortieName());
      sortie.setSortieUuid(request.getSortieId());
      sortie.setInstallationUuid(request.getInstallationId());

      long timeStampMs = request.getTimeStampMs();
      sortie.setTimeStamp(new Date(timeStampMs));

      dao.save(sortie);

      ++count;
    } else {
      logger.fine("duplicate sortie:" + request.getSortieId());
    }

    return count;
  }
}
/*
 * Copyright 2014 Digital Burro, INC
 * Created on May 23, 2014 by gsc
 */

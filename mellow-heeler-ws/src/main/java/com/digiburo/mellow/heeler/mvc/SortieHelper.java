package com.digiburo.mellow.heeler.mvc;

import com.digiburo.mellow.heeler.entity.Sortie;
import com.digiburo.mellow.heeler.entity.SortieDao;
import com.digiburo.mellow.heeler.json.SortieRequest1;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;
import java.util.logging.Logger;

/**
 *  process a fresh JSON message
 */
public class SortieHelper {
  private final Logger logger = Logger.getLogger(getClass().getName());

  /**
   * Convert from client JSON format and persist to datastore
   * @param sortieRequest
   * @return row count
   */
  public int persist(SortieRequest1 sortieRequest) {
    logger.info("persist");

    SortieDao dao = new SortieDao();
    Sortie sortie = dao.selectOne(sortieRequest.getSortieId());

    if (sortie == null) {
      sortie = new Sortie();
      sortie.setName(sortieRequest.getSortieName());
      sortie.setSortieUuid(sortieRequest.getSortieId());
      sortie.setInstallationUuid(sortieRequest.getInstallationId());

      long timeStampMs = sortieRequest.getTimeStampMs();
//      sortie.setTimeStampMs(timeStampMs);

      SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");
      sdf.setTimeZone(TimeZone.getTimeZone("UTC"));
//      sortie.setTimeStamp(sdf.format(new Date(timeStampMs)));

      dao.save(sortie);
    } else {
      logger.info("duplicate sortie:" + sortieRequest.getSortieId());
    }

    return 1;
  }
}
/*
 * Copyright 2014 Digital Burro, INC
 * Created on May 23, 2014 by gsc
 */

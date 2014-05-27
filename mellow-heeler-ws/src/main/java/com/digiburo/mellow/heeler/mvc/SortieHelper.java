package com.digiburo.mellow.heeler.mvc;

import com.digiburo.mellow.heeler.entity.RawSortie;
import com.digiburo.mellow.heeler.entity.RawSortieDao;
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

    RawSortieDao dao = new RawSortieDao();
    RawSortie rawSortie = dao.selectOne(sortieRequest.getSortieId());

    if (rawSortie == null) {
      rawSortie = new RawSortie();
      rawSortie.setSortieName(sortieRequest.getSortieName());
      rawSortie.setSortieUuid(sortieRequest.getSortieId());
      rawSortie.setInstallationUuid(sortieRequest.getInstallationId());

      long timeStampMs = sortieRequest.getTimeStampMs();
      rawSortie.setTimeStampMs(timeStampMs);

      SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");
      sdf.setTimeZone(TimeZone.getTimeZone("UTC"));
      rawSortie.setTimeStamp(sdf.format(new Date(timeStampMs)));

      dao.save(rawSortie);
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
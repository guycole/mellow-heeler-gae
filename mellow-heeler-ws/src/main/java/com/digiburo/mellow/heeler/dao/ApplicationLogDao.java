package com.digiburo.mellow.heeler.dao;

import com.apple.eawt.Application;
import com.digiburo.mellow.heeler.entity.ApplicationLog;
import com.google.appengine.api.datastore.DatastoreService;
import com.google.appengine.api.datastore.DatastoreServiceFactory;
import com.google.appengine.api.datastore.Entity;
import com.google.appengine.api.datastore.PreparedQuery;
import com.google.appengine.api.datastore.Query;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

/**
 *  log DAO
 */
public class ApplicationLogDao {

  /**
   * persist a single entity
   * @param arg
   */
  public void save(final ApplicationLog arg) {
    DatastoreService datastoreService = DatastoreServiceFactory.getDatastoreService();

    //TODO test for null/bad fields
    Entity entity = new Entity(ApplicationLog.ENTITY_NAME);

    entity.setProperty(ApplicationLog.PROPERTY_TIME_STAMP, arg.getTimeStamp());
 //   entity.setProperty(ApplicationLog.PROPERTY_TIME_STAMP_MS, arg.getTimeStampMs());
    entity.setProperty(ApplicationLog.PROPERTY_NOTE, arg.getNote());

    datastoreService.put(entity);
  }

  /**
   * persist a log entry
   * @param note
   */
  public void writeLog(final String note) {
    ApplicationLog applicationLog = new ApplicationLog();

    Date date = new Date();
//    applicationLog.setTimeStampMs(date.getTime());

    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");
    sdf.setTimeZone(TimeZone.getTimeZone("UTC"));
//    applicationLog.setTimeStamp(sdf.format(date));

    applicationLog.setNote(note);

    save(applicationLog);
  }
}
/*
 * Copyright 2014 Digital Burro, INC
 * Created on May 25, 2014 by gsc
 */

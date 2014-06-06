package com.digiburo.mellow.heeler.datastore.dao;

import com.digiburo.mellow.heeler.datastore.entity.ApplicationLog;
import com.google.appengine.api.datastore.DatastoreService;
import com.google.appengine.api.datastore.DatastoreServiceFactory;
import com.google.appengine.api.datastore.Entity;

/**
 *  log DAO
 */
public class ApplicationLogDao extends AbstractDao {

  /**
   * persist a single entity
   * @param arg
   */
  public void save(final ApplicationLog arg) {
    DatastoreService datastoreService = DatastoreServiceFactory.getDatastoreService();

    Entity entity = new Entity(ApplicationLog.ENTITY_NAME);

    entity.setProperty(ApplicationLog.PROPERTY_TIME_STAMP, arg.getTimeStamp());
    entity.setProperty(ApplicationLog.PROPERTY_NOTE, arg.getNote());

    datastoreService.put(entity);
  }

  /**
   * persist a log entry
   * @param note
   */
  public void writeLog(final String note) {
    ApplicationLog applicationLog = new ApplicationLog();

    applicationLog.setNote(note);

    save(applicationLog);
  }
}
/*
 * Copyright 2014 Digital Burro, INC
 * Created on May 25, 2014 by gsc
 */

package com.digiburo.mellow.heeler.entity;

import com.google.appengine.api.datastore.DatastoreService;
import com.google.appengine.api.datastore.DatastoreServiceFactory;
import com.google.appengine.api.datastore.Entity;
import com.google.appengine.api.datastore.PreparedQuery;
import com.google.appengine.api.datastore.Query;

import java.util.ArrayList;
import java.util.List;

/**
 *  sortie DAO
 */
public class RawSortieDao {

  /**
   * persist a single entity
   * @param arg
   */
  public void save(RawSortie arg) {
    DatastoreService datastoreService = DatastoreServiceFactory.getDatastoreService();

    //TODO test for null/bad fields
    Entity entity = new Entity(RawSortie.ENTITY_NAME);

    entity.setProperty(RawSortie.PROPERTY_TIME_STAMP, arg.getTimeStamp());
    entity.setProperty(RawSortie.PROPERTY_TIME_STAMP_MS, arg.getTimeStampMs());
    entity.setProperty(RawSortie.PROPERTY_INSTALLATION_UUID, arg.getInstallationUuid());
    entity.setProperty(RawSortie.PROPERTY_SORTIE_UUID, arg.getSortieUuid());
    entity.setProperty(RawSortie.PROPERTY_SORTIE_NAME, arg.getSortieName());

    datastoreService.put(entity);
  }
}
/*
 * Copyright 2014 Digital Burro, INC
 * Created on May 23, 2014 by gsc
 */

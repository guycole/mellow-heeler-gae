package com.digiburo.mellow.heeler.entity;

import com.google.appengine.api.datastore.DatastoreService;
import com.google.appengine.api.datastore.DatastoreServiceFactory;
import com.google.appengine.api.datastore.Entity;
import com.google.appengine.api.datastore.PreparedQuery;
import com.google.appengine.api.datastore.Query;

/**
 *  sortie DAO
 */
public class RawSortieDao {

  /**
   * persist a single entity
   * @param arg
   */
  public void save(final RawSortie arg) {
    DatastoreService datastoreService = DatastoreServiceFactory.getDatastoreService();

    //TODO test for null/bad fields
    Entity entity = new Entity(RawSortie.ENTITY_NAME);

    entity.setProperty(RawSortie.PROPERTY_TIME_STAMP, arg.getTimeStamp());
    entity.setProperty(RawSortie.PROPERTY_TIME_STAMP_MS, arg.getTimeStampMs());
    entity.setProperty(RawSortie.PROPERTY_INSTALLATION_UUID, arg.getInstallationUuid());
    entity.setProperty(RawSortie.PROPERTY_SORTIE_UUID, arg.getSortieUuid());
    entity.setProperty(RawSortie.PROPERTY_SORTIE_NAME, arg.getSortieName());

    entity.setProperty(RawSortie.PROPERTY_STUNT1, arg.isStunt1());
    entity.setProperty(RawSortie.PROPERTY_STUNT2, arg.isStunt2());
    entity.setProperty(RawSortie.PROPERTY_STUNT3, arg.isStunt3());
    entity.setProperty(RawSortie.PROPERTY_STUNT4, arg.isStunt4());
    entity.setProperty(RawSortie.PROPERTY_STUNT5, arg.isStunt5());
    entity.setProperty(RawSortie.PROPERTY_STUNT6, arg.isStunt6());
    entity.setProperty(RawSortie.PROPERTY_STUNT7, arg.isStunt7());
    entity.setProperty(RawSortie.PROPERTY_STUNT8, arg.isStunt8());

    datastoreService.put(entity);
  }

  /**
   *
   * @param uuid
   * @return
   */
  public RawSortie selectOne(final String uuid) {
    DatastoreService datastoreService = DatastoreServiceFactory.getDatastoreService();

    Query query = new Query(RawSortie.ENTITY_NAME);
    query.setFilter(new Query.FilterPredicate(RawSortie.PROPERTY_SORTIE_UUID, Query.FilterOperator.EQUAL, uuid));

    RawSortie result = null;
    PreparedQuery preparedQuery = datastoreService.prepare(query);
    for (Entity entity:preparedQuery.asIterable()) {
      result = converter(entity);
    }

    return result;
  }

  /**
   *
   * @param entity
   * @return
   */
  private RawSortie converter(Entity entity) {
    RawSortie result = new RawSortie();
    result.setInstallationUuid((String) entity.getProperty(RawSortie.PROPERTY_INSTALLATION_UUID));
    result.setSortieName((String) entity.getProperty(RawSortie.PROPERTY_SORTIE_NAME));
    result.setSortieUuid((String) entity.getProperty(RawSortie.PROPERTY_SORTIE_UUID));
    result.setTimeStamp((String) entity.getProperty(RawSortie.PROPERTY_TIME_STAMP));
    result.setTimeStampMs((Long) entity.getProperty(RawSortie.PROPERTY_TIME_STAMP_MS));

    result.setStunt1((Boolean) entity.getProperty(RawSortie.PROPERTY_STUNT1));
    result.setStunt2((Boolean) entity.getProperty(RawSortie.PROPERTY_STUNT2));
    result.setStunt3((Boolean) entity.getProperty(RawSortie.PROPERTY_STUNT3));
    result.setStunt4((Boolean) entity.getProperty(RawSortie.PROPERTY_STUNT4));
    result.setStunt5((Boolean) entity.getProperty(RawSortie.PROPERTY_STUNT5));
    result.setStunt6((Boolean) entity.getProperty(RawSortie.PROPERTY_STUNT6));
    result.setStunt7((Boolean) entity.getProperty(RawSortie.PROPERTY_STUNT7));
    result.setStunt8((Boolean) entity.getProperty(RawSortie.PROPERTY_STUNT8));

    return result;
  }
}
/*
 * Copyright 2014 Digital Burro, INC
 * Created on May 23, 2014 by gsc
 */

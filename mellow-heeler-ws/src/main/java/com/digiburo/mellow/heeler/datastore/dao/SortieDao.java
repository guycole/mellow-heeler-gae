package com.digiburo.mellow.heeler.datastore.dao;

import com.digiburo.mellow.heeler.datastore.entity.Sortie;
import com.google.appengine.api.datastore.DatastoreService;
import com.google.appengine.api.datastore.DatastoreServiceFactory;
import com.google.appengine.api.datastore.Entity;
import com.google.appengine.api.datastore.PreparedQuery;
import com.google.appengine.api.datastore.Query;

import java.util.Date;

/**
 *  sortie DAO
 */
public class SortieDao extends AbstractDao {

  /**
   * persist a single entity
   * @param arg
   */
  public void save(final Sortie arg) {
    DatastoreService datastoreService = DatastoreServiceFactory.getDatastoreService();

    Entity entity = new Entity(Sortie.ENTITY_NAME);

    entity.setProperty(Sortie.PROPERTY_TIME_STAMP, arg.getTimeStamp());
    entity.setProperty(Sortie.PROPERTY_INSTALLATION_UUID, arg.getInstallationUuid());
    entity.setProperty(Sortie.PROPERTY_SORTIE_UUID, arg.getSortieUuid());
    entity.setProperty(Sortie.PROPERTY_SORTIE_NAME, arg.getName());
    entity.setProperty(Sortie.PROPERTY_SORTIE_NOTE, arg.getNote());

    entity.setProperty(Sortie.PROPERTY_STUNT1, arg.isStunt1());
    entity.setProperty(Sortie.PROPERTY_STUNT2, arg.isStunt2());
    entity.setProperty(Sortie.PROPERTY_STUNT3, arg.isStunt3());
    entity.setProperty(Sortie.PROPERTY_STUNT4, arg.isStunt4());
    entity.setProperty(Sortie.PROPERTY_STUNT5, arg.isStunt5());
    entity.setProperty(Sortie.PROPERTY_STUNT6, arg.isStunt6());
    entity.setProperty(Sortie.PROPERTY_STUNT7, arg.isStunt7());
    entity.setProperty(Sortie.PROPERTY_STUNT8, arg.isStunt8());

    datastoreService.put(entity);
  }

  public void save(Date date, final String installationId, final String sortieId, final String sortieName) {
    Sortie sortie = new Sortie();

    sortie.setInstallationUuid(installationId);
    sortie.setSortieUuid(sortieId);
    sortie.setName(sortieName);
    sortie.setTimeStamp(date);
  }

  /**
   *
   * @param uuid
   * @return
   */
  public Sortie selectOne(final String uuid) {
    DatastoreService datastoreService = DatastoreServiceFactory.getDatastoreService();

    Query query = new Query(Sortie.ENTITY_NAME);
    query.setFilter(new Query.FilterPredicate(Sortie.PROPERTY_SORTIE_UUID, Query.FilterOperator.EQUAL, uuid));

    Sortie result = null;
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
  private Sortie converter(Entity entity) {
    Sortie result = new Sortie();
    result.setInstallationUuid((String) entity.getProperty(Sortie.PROPERTY_INSTALLATION_UUID));
    result.setName((String) entity.getProperty(Sortie.PROPERTY_SORTIE_NAME));
    result.setNote((String) entity.getProperty(Sortie.PROPERTY_SORTIE_NOTE));
    result.setSortieUuid((String) entity.getProperty(Sortie.PROPERTY_SORTIE_UUID));
    result.setTimeStamp((Date) entity.getProperty(Sortie.PROPERTY_TIME_STAMP));

    result.setStunt1((Boolean) entity.getProperty(Sortie.PROPERTY_STUNT1));
    result.setStunt2((Boolean) entity.getProperty(Sortie.PROPERTY_STUNT2));
    result.setStunt3((Boolean) entity.getProperty(Sortie.PROPERTY_STUNT3));
    result.setStunt4((Boolean) entity.getProperty(Sortie.PROPERTY_STUNT4));
    result.setStunt5((Boolean) entity.getProperty(Sortie.PROPERTY_STUNT5));
    result.setStunt6((Boolean) entity.getProperty(Sortie.PROPERTY_STUNT6));
    result.setStunt7((Boolean) entity.getProperty(Sortie.PROPERTY_STUNT7));
    result.setStunt8((Boolean) entity.getProperty(Sortie.PROPERTY_STUNT8));

    return result;
  }
}
/*
 * Copyright 2014 Digital Burro, INC
 * Created on May 23, 2014 by gsc
 */

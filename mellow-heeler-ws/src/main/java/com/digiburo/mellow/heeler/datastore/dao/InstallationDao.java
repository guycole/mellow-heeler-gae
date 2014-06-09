package com.digiburo.mellow.heeler.datastore.dao;

import com.digiburo.mellow.heeler.datastore.entity.Installation;
import com.google.appengine.api.datastore.DatastoreService;
import com.google.appengine.api.datastore.DatastoreServiceFactory;
import com.google.appengine.api.datastore.Entity;
import com.google.appengine.api.datastore.PreparedQuery;
import com.google.appengine.api.datastore.Query;

/**
 *  installation DAO
 */
public class InstallationDao extends AbstractDao {

  /**
   * persist a single entity
   * @param arg
   */
  public void save(final Installation arg) {
    DatastoreService datastoreService = DatastoreServiceFactory.getDatastoreService();

    Entity entity = new Entity(Installation.ENTITY_NAME);

    entity.setProperty(Installation.PROPERTY_ACTIVE, arg.isActive());
    entity.setProperty(Installation.PROPERTY_INSTALLATION_UUID, arg.getInstallationUuid());
    entity.setProperty(Installation.PROPERTY_NAME, arg.getName());
    entity.setProperty(Installation.PROPERTY_NOTE, arg.getNote());

    datastoreService.put(entity);
  }

  /**
   *
   * @param uuid
   */
  public void save(final String uuid) {
    Installation installation = new Installation();
    installation.setInstallationUuid(uuid);
    save(installation);
  }

  /**
   *
   * @param uuid
   * @return
   */
  public Installation selectOne(final String uuid) {
    DatastoreService datastoreService = DatastoreServiceFactory.getDatastoreService();

    Query query = new Query(Installation.ENTITY_NAME);
    query.setFilter(new Query.FilterPredicate(Installation.PROPERTY_INSTALLATION_UUID, Query.FilterOperator.EQUAL, uuid));

    Installation result = null;
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
  private Installation converter(Entity entity) {
    Installation result = new Installation();
    result.setActive((Boolean) entity.getProperty(Installation.PROPERTY_ACTIVE));
    result.setInstallationUuid((String) entity.getProperty(Installation.PROPERTY_INSTALLATION_UUID));
    result.setName((String) entity.getProperty(Installation.PROPERTY_NAME));
    result.setNote((String) entity.getProperty(Installation.PROPERTY_NOTE));
    return result;
  }
}
/*
 * Copyright 2014 Digital Burro, INC
 * Created on May 23, 2014 by gsc
 */
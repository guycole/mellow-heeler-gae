package com.digiburo.mellow.heeler.entity;

import com.google.appengine.api.datastore.DatastoreService;
import com.google.appengine.api.datastore.DatastoreServiceFactory;
import com.google.appengine.api.datastore.Entity;
import com.google.appengine.api.datastore.PreparedQuery;
import com.google.appengine.api.datastore.Query;

/**
 *  authorization DAO
 */
public class AuthorizationDao {

  /**
   * persist a single entity
   * @param arg
   */
  public void save(final Authorization arg) {
    DatastoreService datastoreService = DatastoreServiceFactory.getDatastoreService();

    //TODO test for null/bad fields
    Entity entity = new Entity(Authorization.ENTITY_NAME);

    entity.setProperty(Authorization.PROPERTY_ACTIVE, arg.isActive());
    entity.setProperty(Authorization.PROPERTY_INSTALLATION_UUID, arg.getInstallationUuid());
    entity.setProperty(Authorization.PROPERTY_NAME, arg.getName());
    entity.setProperty(Authorization.PROPERTY_NOTE, arg.getNote());

    datastoreService.put(entity);
  }

  /**
   *
   * @param uuid
   * @return
   */
  public Authorization selectOne(final String uuid) {
    DatastoreService datastoreService = DatastoreServiceFactory.getDatastoreService();

    Query query = new Query(Authorization.ENTITY_NAME);
    query.setFilter(new Query.FilterPredicate(Authorization.PROPERTY_INSTALLATION_UUID, Query.FilterOperator.EQUAL, uuid));

    Authorization result = null;
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
  private Authorization converter(Entity entity) {
    Authorization result = new Authorization();
    result.setActive((Boolean) entity.getProperty(Authorization.PROPERTY_ACTIVE));
    result.setInstallationUuid((String) entity.getProperty(Authorization.PROPERTY_INSTALLATION_UUID));
    result.setName((String) entity.getProperty(Authorization.PROPERTY_NAME));
    result.setNote((String) entity.getProperty(Authorization.PROPERTY_NOTE));
    return result;
  }
}
/*
 * Copyright 2014 Digital Burro, INC
 * Created on May 23, 2014 by gsc
 */

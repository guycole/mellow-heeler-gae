package com.digiburo.mellow.heeler.entity;

import com.google.appengine.api.datastore.DatastoreService;
import com.google.appengine.api.datastore.DatastoreServiceFactory;
import com.google.appengine.api.datastore.Entity;
import com.google.appengine.api.datastore.GeoPt;
import com.google.appengine.api.datastore.PreparedQuery;
import com.google.appengine.api.datastore.Query;

import java.util.ArrayList;
import java.util.List;

/**
 * location DAO
 */
public class RawGeographicLocationDao {

  /**
   * persist a single entity
   * @param arg
   */
  public void save(RawGeographicLocation arg) {
    DatastoreService datastoreService = DatastoreServiceFactory.getDatastoreService();

    //TODO test for null/bad fields
    Entity entity = new Entity(RawGeographicLocation.ENTITY_NAME);
    entity.setProperty(RawGeographicLocation.PROPERTY_ACCURACY, arg.getAccuracy());
    entity.setProperty(RawGeographicLocation.PROPERTY_ALTITUDE, arg.getAltitude());
    entity.setProperty(RawGeographicLocation.PROPERTY_LOCATION, arg.getLocation());
    entity.setProperty(RawGeographicLocation.PROPERTY_SPECIAL_FLAG, arg.isSpecialFlag());
    entity.setProperty(RawGeographicLocation.PROPERTY_TIME_STAMP, arg.getTimeStamp());
    entity.setProperty(RawGeographicLocation.PROPERTY_TIME_STAMP_MS, arg.getTimeStampMs());
    entity.setProperty(RawGeographicLocation.PROPERTY_INSTALLATION_UUID, arg.getInstallationUuid());
    entity.setProperty(RawGeographicLocation.PROPERTY_LOCATION_UUID, arg.getLocationUuid());
    entity.setProperty(RawGeographicLocation.PROPERTY_SORTIE_UUID, arg.getSortieUuid());

    datastoreService.put(entity);
  }

  /**
   * select sortie locations
   * @param arg
   * @return
   */
  public List<RawGeographicLocation> selectBySortie(String arg) {
    ArrayList<RawGeographicLocation> results = new ArrayList<RawGeographicLocation>();

    DatastoreService datastoreService = DatastoreServiceFactory.getDatastoreService();

    Query query = new Query(RawGeographicLocation.ENTITY_NAME);
    query.setFilter(new Query.FilterPredicate(RawGeographicLocation.PROPERTY_SORTIE_UUID, Query.FilterOperator.EQUAL, arg));
    query.addSort(RawGeographicLocation.PROPERTY_TIME_STAMP_MS);

    PreparedQuery preparedQuery = datastoreService.prepare(query);
    for (Entity entity:preparedQuery.asIterable()) {
      results.add(converter(entity));
    }

    return results;
  }

  /**
   *
   * @param uuid
   * @return
   */
  public RawGeographicLocation selectOne(final String uuid) {
    DatastoreService datastoreService = DatastoreServiceFactory.getDatastoreService();

    Query query = new Query(RawGeographicLocation.ENTITY_NAME);
    query.setFilter(new Query.FilterPredicate(RawGeographicLocation.PROPERTY_LOCATION_UUID, Query.FilterOperator.EQUAL, uuid));

    RawGeographicLocation result = null;
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
  private RawGeographicLocation converter(Entity entity) {
    RawGeographicLocation result = new RawGeographicLocation();
    result.setAccuracy((Double) entity.getProperty(RawGeographicLocation.PROPERTY_ACCURACY));
    result.setAltitude((Double) entity.getProperty(RawGeographicLocation.PROPERTY_ALTITUDE));
    result.setLocation((GeoPt) entity.getProperty(RawGeographicLocation.PROPERTY_LOCATION));
    result.setSpecialFlag((Boolean) entity.getProperty(RawGeographicLocation.PROPERTY_SPECIAL_FLAG));
    result.setTimeStamp((String) entity.getProperty(RawGeographicLocation.PROPERTY_TIME_STAMP));
    result.setTimeStampMs((Long) entity.getProperty(RawGeographicLocation.PROPERTY_TIME_STAMP_MS));
    result.setInstallationUuid((String) entity.getProperty(RawGeographicLocation.PROPERTY_INSTALLATION_UUID));
    result.setLocationUuid((String) entity.getProperty(RawGeographicLocation.PROPERTY_LOCATION_UUID));
    result.setSortieUuid((String) entity.getProperty(RawGeographicLocation.PROPERTY_SORTIE_UUID));
    return result;
  }
}
/*
 * Copyright 2014 Digital Burro, INC
 * Created on May 17, 2014 by gsc
 */

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
  public void save(GeographicLocation arg) {
    DatastoreService datastoreService = DatastoreServiceFactory.getDatastoreService();

    //TODO test for null/bad fields
    Entity entity = new Entity(GeographicLocation.ENTITY_NAME);
    entity.setProperty(GeographicLocation.PROPERTY_ACCURACY, arg.getAccuracy());
    entity.setProperty(GeographicLocation.PROPERTY_ALTITUDE, arg.getAltitude());
    entity.setProperty(GeographicLocation.PROPERTY_LOCATION, arg.getLocation());
    entity.setProperty(GeographicLocation.PROPERTY_SPECIAL_FLAG, arg.isSpecialFlag());
 //   entity.setProperty(GeographicLocation.PROPERTY_TIME_STAMP, arg.getTimeStamp());
 //   entity.setProperty(GeographicLocation.PROPERTY_TIME_STAMP_MS, arg.getTimeStampMs());
    entity.setProperty(GeographicLocation.PROPERTY_INSTALLATION_UUID, arg.getInstallationUuid());
    entity.setProperty(GeographicLocation.PROPERTY_LOCATION_UUID, arg.getLocationUuid());
    entity.setProperty(GeographicLocation.PROPERTY_SORTIE_UUID, arg.getSortieUuid());

    datastoreService.put(entity);
  }

  /**
   * select sortie locations
   * @param arg
   * @return
   */
  public List<GeographicLocation> selectBySortie(String arg) {
    ArrayList<GeographicLocation> results = new ArrayList<GeographicLocation>();

    DatastoreService datastoreService = DatastoreServiceFactory.getDatastoreService();

    Query query = new Query(GeographicLocation.ENTITY_NAME);
    query.setFilter(new Query.FilterPredicate(GeographicLocation.PROPERTY_SORTIE_UUID, Query.FilterOperator.EQUAL, arg));
//    query.addSort(GeographicLocation.PROPERTY_TIME_STAMP_MS);

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
  public GeographicLocation selectOne(final String uuid) {
    DatastoreService datastoreService = DatastoreServiceFactory.getDatastoreService();

    Query query = new Query(GeographicLocation.ENTITY_NAME);
    query.setFilter(new Query.FilterPredicate(GeographicLocation.PROPERTY_LOCATION_UUID, Query.FilterOperator.EQUAL, uuid));

    GeographicLocation result = null;
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
  private GeographicLocation converter(Entity entity) {
    GeographicLocation result = new GeographicLocation();
    result.setAccuracy((Double) entity.getProperty(GeographicLocation.PROPERTY_ACCURACY));
    result.setAltitude((Double) entity.getProperty(GeographicLocation.PROPERTY_ALTITUDE));
    result.setLocation((GeoPt) entity.getProperty(GeographicLocation.PROPERTY_LOCATION));
    result.setSpecialFlag((Boolean) entity.getProperty(GeographicLocation.PROPERTY_SPECIAL_FLAG));
//    result.setTimeStamp((String) entity.getProperty(GeographicLocation.PROPERTY_TIME_STAMP));
//    result.setTimeStampMs((Long) entity.getProperty(GeographicLocation.PROPERTY_TIME_STAMP_MS));
    result.setInstallationUuid((String) entity.getProperty(GeographicLocation.PROPERTY_INSTALLATION_UUID));
    result.setLocationUuid((String) entity.getProperty(GeographicLocation.PROPERTY_LOCATION_UUID));
    result.setSortieUuid((String) entity.getProperty(GeographicLocation.PROPERTY_SORTIE_UUID));
    return result;
  }
}
/*
 * Copyright 2014 Digital Burro, INC
 * Created on May 17, 2014 by gsc
 */

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
      RawGeographicLocation geographicLocation = new RawGeographicLocation();
      geographicLocation.setAccuracy((Double) entity.getProperty(RawGeographicLocation.PROPERTY_ACCURACY));
      geographicLocation.setAltitude((Double) entity.getProperty(RawGeographicLocation.PROPERTY_ALTITUDE));
      geographicLocation.setLocation((GeoPt) entity.getProperty(RawGeographicLocation.PROPERTY_LOCATION));
      geographicLocation.setSpecialFlag((Boolean) entity.getProperty(RawGeographicLocation.PROPERTY_SPECIAL_FLAG));
      geographicLocation.setTimeStamp((String) entity.getProperty(RawGeographicLocation.PROPERTY_TIME_STAMP));
      geographicLocation.setTimeStampMs((Long) entity.getProperty(RawGeographicLocation.PROPERTY_TIME_STAMP_MS));
      geographicLocation.setInstallationUuid((String) entity.getProperty(RawGeographicLocation.PROPERTY_INSTALLATION_UUID));
      geographicLocation.setLocationUuid((String) entity.getProperty(RawGeographicLocation.PROPERTY_LOCATION_UUID));
      geographicLocation.setSortieUuid((String) entity.getProperty(RawGeographicLocation.PROPERTY_SORTIE_UUID));
      results.add(geographicLocation);
    }

    return results;
  }
}
/*
 * Copyright 2014 Digital Burro, INC
 * Created on May 17, 2014 by gsc
 */

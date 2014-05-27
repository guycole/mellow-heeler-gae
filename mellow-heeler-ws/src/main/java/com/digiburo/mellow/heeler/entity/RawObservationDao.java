package com.digiburo.mellow.heeler.entity;

import com.google.appengine.api.datastore.DatastoreService;
import com.google.appengine.api.datastore.DatastoreServiceFactory;
import com.google.appengine.api.datastore.Entity;
import com.google.appengine.api.datastore.PreparedQuery;
import com.google.appengine.api.datastore.Query;

import java.util.ArrayList;
import java.util.List;

/**
 *  observation DAO
 */
public class RawObservationDao {

  /**
   * persist a single entity
   * @param arg
   */
  public void save(final RawObservation arg) {
    DatastoreService datastoreService = DatastoreServiceFactory.getDatastoreService();

    //TODO test for null/bad fields
    Entity entity = new Entity(RawObservation.ENTITY_NAME);

    entity.setProperty(RawObservation.PROPERTY_BSSID, arg.getBssid());
    entity.setProperty(RawObservation.PROPERTY_SSID, arg.getSsid());
    entity.setProperty(RawObservation.PROPERTY_CAPABILITY, arg.getCapability());
    entity.setProperty(RawObservation.PROPERTY_FREQUENCY, arg.getFrequency());
    entity.setProperty(RawObservation.PROPERTY_STRENGTH, arg.getStrength());
    entity.setProperty(RawObservation.PROPERTY_TIME_STAMP, arg.getTimeStamp());
    entity.setProperty(RawObservation.PROPERTY_TIME_STAMP_MS, arg.getTimeStampMs());
    entity.setProperty(RawObservation.PROPERTY_INSTALLATION_UUID, arg.getInstallationUuid());
    entity.setProperty(RawObservation.PROPERTY_LOCATION_UUID, arg.getLocationUuid());
    entity.setProperty(RawObservation.PROPERTY_OBSERVATION_UUID, arg.getObservationUuid());
    entity.setProperty(RawObservation.PROPERTY_SORTIE_UUID, arg.getSortieUuid());

    datastoreService.put(entity);
  }

  /**
   * select sortie locations
   * @param arg
   * @return
   */
  public List<RawObservation> selectBySortie(String arg) {
    ArrayList<RawObservation> results = new ArrayList<RawObservation>();

    DatastoreService datastoreService = DatastoreServiceFactory.getDatastoreService();

    Query query = new Query(RawObservation.ENTITY_NAME);
    query.setFilter(new Query.FilterPredicate(RawObservation.PROPERTY_SORTIE_UUID, Query.FilterOperator.EQUAL, arg));
    query.addSort(RawObservation.PROPERTY_TIME_STAMP_MS);

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
  public RawObservation selectOne(final String uuid) {
    DatastoreService datastoreService = DatastoreServiceFactory.getDatastoreService();

    Query query = new Query(RawObservation.ENTITY_NAME);
    query.setFilter(new Query.FilterPredicate(RawObservation.PROPERTY_OBSERVATION_UUID, Query.FilterOperator.EQUAL, uuid));

    RawObservation result = null;
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
  private RawObservation converter(Entity entity) {
    RawObservation result = new RawObservation();
    result.setBssid((String) entity.getProperty(RawObservation.PROPERTY_BSSID));
    result.setSsid((String) entity.getProperty(RawObservation.PROPERTY_SSID));
    result.setCapability((String) entity.getProperty(RawObservation.PROPERTY_CAPABILITY));
    result.setFrequency((Long) entity.getProperty(RawObservation.PROPERTY_FREQUENCY));
    result.setStrength((Long) entity.getProperty(RawObservation.PROPERTY_STRENGTH));
    result.setTimeStamp((String) entity.getProperty(RawObservation.PROPERTY_TIME_STAMP));
    result.setTimeStampMs((Long) entity.getProperty(RawObservation.PROPERTY_TIME_STAMP_MS));
    result.setInstallationUuid((String) entity.getProperty(RawObservation.PROPERTY_INSTALLATION_UUID));
    result.setLocationUuid((String) entity.getProperty(RawObservation.PROPERTY_LOCATION_UUID));
    result.setObservationUuid((String) entity.getProperty(RawObservation.PROPERTY_OBSERVATION_UUID));
    result.setSortieUuid((String) entity.getProperty(RawObservation.PROPERTY_SORTIE_UUID));
    return result;
  }
}
/*
 * Copyright 2014 Digital Burro, INC
 * Created on May 17, 2014 by gsc
 */

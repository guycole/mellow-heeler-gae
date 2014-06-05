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
  public void save(final Observation arg) {
    DatastoreService datastoreService = DatastoreServiceFactory.getDatastoreService();

    //TODO test for null/bad fields
    Entity entity = new Entity(Observation.ENTITY_NAME);

    entity.setProperty(Observation.PROPERTY_BSSID, arg.getBssid());
    entity.setProperty(Observation.PROPERTY_SSID, arg.getSsid());
    entity.setProperty(Observation.PROPERTY_CAPABILITY, arg.getCapability());
    entity.setProperty(Observation.PROPERTY_FREQUENCY, arg.getFrequency());
    entity.setProperty(Observation.PROPERTY_STRENGTH, arg.getStrength());
    entity.setProperty(Observation.PROPERTY_TIME_STAMP, arg.getTimeStamp());
 //   entity.setProperty(Observation.PROPERTY_TIME_STAMP_MS, arg.getTimeStampMs());
    entity.setProperty(Observation.PROPERTY_INSTALLATION_UUID, arg.getInstallationUuid());
    entity.setProperty(Observation.PROPERTY_LOCATION_UUID, arg.getLocationUuid());
    entity.setProperty(Observation.PROPERTY_OBSERVATION_UUID, arg.getObservationUuid());
    entity.setProperty(Observation.PROPERTY_SORTIE_UUID, arg.getSortieUuid());

    datastoreService.put(entity);
  }

  /**
   * select sortie locations
   * @param arg
   * @return
   */
  public List<Observation> selectBySortie(String arg) {
    ArrayList<Observation> results = new ArrayList<Observation>();

    DatastoreService datastoreService = DatastoreServiceFactory.getDatastoreService();

    Query query = new Query(Observation.ENTITY_NAME);
    query.setFilter(new Query.FilterPredicate(Observation.PROPERTY_SORTIE_UUID, Query.FilterOperator.EQUAL, arg));
    query.addSort(Observation.PROPERTY_TIME_STAMP_MS);

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
  public Observation selectOne(final String uuid) {
    DatastoreService datastoreService = DatastoreServiceFactory.getDatastoreService();

    Query query = new Query(Observation.ENTITY_NAME);
    query.setFilter(new Query.FilterPredicate(Observation.PROPERTY_OBSERVATION_UUID, Query.FilterOperator.EQUAL, uuid));

    Observation result = null;
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
  private Observation converter(Entity entity) {
    Observation result = new Observation();
    result.setBssid((String) entity.getProperty(Observation.PROPERTY_BSSID));
    result.setSsid((String) entity.getProperty(Observation.PROPERTY_SSID));
    result.setCapability((String) entity.getProperty(Observation.PROPERTY_CAPABILITY));
    result.setFrequency((Long) entity.getProperty(Observation.PROPERTY_FREQUENCY));
    result.setStrength((Long) entity.getProperty(Observation.PROPERTY_STRENGTH));
 //   result.setTimeStamp((String) entity.getProperty(Observation.PROPERTY_TIME_STAMP));
 //   result.setTimeStampMs((Long) entity.getProperty(Observation.PROPERTY_TIME_STAMP_MS));
    result.setInstallationUuid((String) entity.getProperty(Observation.PROPERTY_INSTALLATION_UUID));
    result.setLocationUuid((String) entity.getProperty(Observation.PROPERTY_LOCATION_UUID));
    result.setObservationUuid((String) entity.getProperty(Observation.PROPERTY_OBSERVATION_UUID));
    result.setSortieUuid((String) entity.getProperty(Observation.PROPERTY_SORTIE_UUID));
    return result;
  }
}
/*
 * Copyright 2014 Digital Burro, INC
 * Created on May 17, 2014 by gsc
 */

package com.digiburo.mellow.heeler.datastore.entity;

import com.google.appengine.api.datastore.GeoPt;

import java.util.Date;

/**
 * geographic location entity (raw client datum)
 */
public class GeographicLocation extends AbstractEntity {
  public static final String ENTITY_NAME = "GeographicLocation";

  public static final String PROPERTY_ACCURACY = "accuracy";
  public static final String PROPERTY_ALTITUDE = "altitude";
  public static final String PROPERTY_LOCATION = "location";
  public static final String PROPERTY_SPECIAL_FLAG = "specialFlag";
  public static final String PROPERTY_TIME_STAMP = "timeStamp";
  public static final String PROPERTY_INSTALLATION_UUID = "installationUuid";
  public static final String PROPERTY_LOCATION_UUID = "locationUuid";
  public static final String PROPERTY_SORTIE_UUID = "sortieUuid";

  /**
   * error radius in meters
   */
  private Double accuracy = 0.0;

  /**
   * meters above sea level
   */
  private Double altitude = 0.0;

  /**
   * location in decimal degrees, +North, +East
   */
  private GeoPt location = new GeoPt(0f, 0f);

  /**
   * true, this location is flagged for special interest
   */
  private Boolean specialFlag = false;

  /**
   * location time in UTC
   */
  private Date timeStamp = new Date();

  /**
   * installation UUID
   */
  private String installationUuid = DEFAULT_UUID;

  /**
   * row UUID, employed as key
   */
  private String locationUuid = DEFAULT_UUID;

  /**
   * sortie UUID
   */
  private String sortieUuid = DEFAULT_UUID;

  /////

  public Double getAccuracy() {
    return accuracy;
  }

  public void setAccuracy(double accuracy) {
    this.accuracy = accuracy;
  }

  public Double getAltitude() {
    return altitude;
  }

  public void setAltitude(double altitude) {
    this.altitude = altitude;
  }

  public GeoPt getLocation() {
    return location;
  }

  public void setLocation(GeoPt location) {
    if (location == null) {
      throw new NullPointerException("null location");
    }

    this.location = location;
  }

  public Boolean isSpecialFlag() {
    return specialFlag;
  }

  public void setSpecialFlag(boolean flag) {
    specialFlag = flag;
  }

  public Date getTimeStamp() {
    return timeStamp;
  }

  public void setTimeStamp(Date timeStamp) {
    if (timeStamp == null) {
      throw new NullPointerException("null timeStamp");
    }

    this.timeStamp = timeStamp;
  }

  public String getInstallationUuid() {
    return installationUuid;
  }

  public void setInstallationUuid(String installationUuid) {
    this.installationUuid = cleaner(installationUuid, "null installationUuid", "empty installationUuid");
  }

  public String getLocationUuid() {
    return locationUuid;
  }

  public void setLocationUuid(String locationUuid) {
    this.locationUuid = cleaner(locationUuid, "null locationUuid", "empty locationUuid");
  }

  public String getSortieUuid() {
    return sortieUuid;
  }

  public void setSortieUuid(String sortieUuid) {
    this.sortieUuid = cleaner(sortieUuid, "null sortieUuid", "empty sortieUuid");
  }
}
/*
 * Copyright 2014 Digital Burro, INC
 * Created on May 17, 2014 by gsc
 */

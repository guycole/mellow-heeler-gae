package com.digiburo.mellow.heeler.entity;

import com.google.appengine.api.datastore.GeoPt;

import java.util.Date;

/**
 * geographic location entity (raw client datum)
 */
public class GeographicLocation {
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
  private GeoPt location;

  /**
   * true, this location is flagged for special interest
   */
  private Boolean specialFlag = false;

  /**
   * location time in UTC
   */
  private Date timeStamp;

  /**
   * installation UUID
   */
  private String installationUuid;

  /**
   * row UUID, employed as key
   */
  private String locationUuid;

  /**
   * sortie UUID
   */
  private String sortieUuid;

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
    if (installationUuid == null) {
      throw new NullPointerException("null installationUuid");
    }

    this.installationUuid = installationUuid.trim();

    if (installationUuid.isEmpty()) {
      throw new IllegalArgumentException("empty installationUuid");
    }
  }

  public String getLocationUuid() {
    return locationUuid;
  }

  public void setLocationUuid(String locationUuid) {
    if (locationUuid == null) {
      throw new NullPointerException("null locationUuid");
    }

    this.locationUuid = locationUuid.trim();

    if (locationUuid.isEmpty()) {
      throw new IllegalArgumentException("empty locationUuid");
    }
  }

  public String getSortieUuid() {
    return sortieUuid;
  }

  public void setSortieUuid(String sortieUuid) {
    if (sortieUuid == null) {
      throw new NullPointerException("null sortieUuid");
    }

    this.sortieUuid = sortieUuid.trim();

    if (sortieUuid.isEmpty()) {
      throw new IllegalArgumentException("empty sortieUuid");
    }
  }
}
/*
 * Copyright 2014 Digital Burro, INC
 * Created on May 17, 2014 by gsc
 */

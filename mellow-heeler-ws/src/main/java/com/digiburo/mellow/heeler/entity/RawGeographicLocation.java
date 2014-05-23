package com.digiburo.mellow.heeler.entity;

import com.google.appengine.api.datastore.GeoPt;

import java.util.Date;

/**
 * geographic location entity (raw client datum)
 */
public class RawGeographicLocation {
  public static final String ENTITY_NAME = "RawGeographicLocation";

  public static final String PROPERTY_ACCURACY = "accuracy";
  public static final String PROPERTY_ALTITUDE = "altitude";
  public static final String PROPERTY_LOCATION = "location";
  public static final String PROPERTY_SPECIAL_FLAG = "specialFlag";
  public static final String PROPERTY_TIME_STAMP = "timeStamp";
  public static final String PROPERTY_TIME_STAMP_MS = "timeStampMs";
  public static final String PROPERTY_INSTALLATION_UUID = "installationUuid";
  public static final String PROPERTY_LOCATION_UUID = "locationUuid";
  public static final String PROPERTY_SORTIE_UUID = "sortieUuid";

  /**
   * error radius in meters
   */
  private Double accuracy;

  /**
   * meters above sea level
   */
  private Double altitude;

  /**
   * location in decimal degrees, +North, +East
   */
  private GeoPt location;

  /**
   * true, this location is flagged for special interest
   */
  private Boolean specialFlag;

  /**
   * location time as String
   */
  private String timeStamp;

  /**
   * location time in UTC
   */
  private Long timeStampMs;

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

  public Double getAccuracy() {
    return accuracy;
  }

  public void setAccuracy(Double accuracy) {
    this.accuracy = accuracy;
  }

  public Double getAltitude() {
    return altitude;
  }

  public void setAltitude(Double altitude) {
    this.altitude = altitude;
  }

  public GeoPt getLocation() {
    return location;
  }

  public void setLocation(GeoPt location) {
    this.location = location;
  }

  public Boolean isSpecialFlag() {
    return specialFlag;
  }

  public void setSpecialFlag(Boolean flag) {
    specialFlag = flag;
  }

  public String getTimeStamp() {
    return timeStamp;
  }

  public void setTimeStamp(String timeStamp) {
    this.timeStamp = timeStamp;
  }

  public Long getTimeStampMs() {
    return timeStampMs;
  }

  public void setTimeStampMs(Long timeStampMs) {
    this.timeStampMs = timeStampMs;
  }

  public String getInstallationUuid() {
    return installationUuid;
  }

  public void setInstallationUuid(String installationUuid) {
    this.installationUuid = installationUuid;
  }

  public String getLocationUuid() {
    return locationUuid;
  }

  public void setLocationUuid(String locationUuid) {
    this.locationUuid = locationUuid;
  }

  public String getSortieUuid() {
    return sortieUuid;
  }

  public void setSortieUuid(String sortieUuid) {
    this.sortieUuid = sortieUuid;
  }
}
/*
 * Copyright 2014 Digital Burro, INC
 * Created on May 17, 2014 by gsc
 */

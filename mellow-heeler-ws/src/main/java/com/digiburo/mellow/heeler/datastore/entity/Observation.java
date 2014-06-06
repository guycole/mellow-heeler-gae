package com.digiburo.mellow.heeler.datastore.entity;

import java.util.Date;

/**
 * observation entity (raw client datum)
 */
public class Observation extends AbstractEntity {
  public static final String ENTITY_NAME = "Observation";

  //
  public static final String PROPERTY_BSSID = "bssid";
  public static final String PROPERTY_CAPABILITY = "capability";
  public static final String PROPERTY_FREQUENCY = "frequency";
  public static final String PROPERTY_SSID = "ssid";
  public static final String PROPERTY_STRENGTH = "strength";
  public static final String PROPERTY_TIME_STAMP = "timeStamp";
  public static final String PROPERTY_INSTALLATION_UUID = "installationUuid";
  public static final String PROPERTY_LOCATION_UUID = "locationUuid";
  public static final String PROPERTY_OBSERVATION_UUID = "observationUuid";
  public static final String PROPERTY_SORTIE_UUID = "sortieUuid";

  //
  public static final String DEFAULT_CAPABILITY = "Default Capability";
  public static final String DEFAULT_BSSID = "Default BSSID";
  public static final String DEFAULT_SSID = "Default SSID";

  /**
   * WAP BSSID
   */
  private String bssid = DEFAULT_BSSID;

  /**
   * WAP SSID
   */
  private String ssid = DEFAULT_SSID;

  /**
   * WAP capabilities
   */
  private String capability = DEFAULT_CAPABILITY;

  /**
   * observed center frequency
   */
  private Long frequency = 0L;

  /**
   * observed signal strength
   */
  private Long strength = 0L;

  /**
   * location time in UTC
   */
  private Date timeStamp = new Date();

  /**
   * installation UUID
   */
  private String installationUuid = DEFAULT_UUID;

  /**
   * location UUID, employed as key
   */
  private String locationUuid = DEFAULT_UUID;

  /**
   * row UUID, employed as key
   */
  private String observationUuid = DEFAULT_UUID;

  /**
   * sortie UUID
   */
  private String sortieUuid = DEFAULT_UUID;

  /////

  public String getBssid() {
    return bssid;
  }

  public void setBssid(String bssid) {
    this.bssid = cleaner(bssid, "null bssid", "empty bssid");
  }

  public String getSsid() {
    return ssid;
  }

  public void setSsid(String ssid) {
    this.ssid = cleaner(ssid, "null ssid", "empty ssid");
  }

  public String getCapability() {
    return capability;
  }

  public void setCapability(String capability) {
    this.capability = cleaner(capability, "null capability", "empty capability");
  }

  public Long getFrequency() {
    return frequency;
  }

  public void setFrequency(long frequency) {
    this.frequency = frequency;
  }

  public Long getStrength() {
    return strength;
  }

  public void setStrength(long strength) {
    this.strength = strength;
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

  public String getObservationUuid() {
    return observationUuid;
  }

  public void setObservationUuid(String observationUuid) {
    this.observationUuid = cleaner(observationUuid, "null observationUuid", "empty observationUuid");
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

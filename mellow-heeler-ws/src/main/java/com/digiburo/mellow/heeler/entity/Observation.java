package com.digiburo.mellow.heeler.entity;

import java.util.Date;

/**
 * observation entity (raw client datum)
 */
public class Observation {
  public static final String ENTITY_NAME = "RawObservation";

  public static final String PROPERTY_BSSID = "bssid";
  public static final String PROPERTY_CAPABILITY = "capability";
  public static final String PROPERTY_FREQUENCY = "frequency";
  public static final String PROPERTY_SSID = "ssid";
  public static final String PROPERTY_STRENGTH = "strength";
  public static final String PROPERTY_TIME_STAMP = "timeStamp";
  public static final String PROPERTY_TIME_STAMP_MS = "timeStampMs";
  public static final String PROPERTY_INSTALLATION_UUID = "installationUuid";
  public static final String PROPERTY_LOCATION_UUID = "locationUuid";
  public static final String PROPERTY_OBSERVATION_UUID = "observationUuid";
  public static final String PROPERTY_SORTIE_UUID = "sortieUuid";

  //
  public static final String DEFAULT_CAPABILITY = "Default Capability";
  public static final String DEFAULT_SSID = "Default SSID";

  /**
   * WAP BSSID
   */
  private String bssid;

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
  private Date timeStamp;

  /**
   * installation UUID
   */
  private String installationUuid;

  /**
   * location UUID, employed as key
   */
  private String locationUuid;

  /**
   * row UUID, employed as key
   */
  private String observationUuid;

  /**
   * sortie UUID
   */
  private String sortieUuid;

  /////

  public String getBssid() {
    return bssid;
  }

  public void setBssid(String bssid) {
    if (bssid == null) {
      throw new NullPointerException("null bssid");
    }

    this.bssid = bssid.trim();

    if (bssid.isEmpty()) {
      throw new IllegalArgumentException("empty bssid");
    }
  }

  public String getSsid() {
    return ssid;
  }

  public void setSsid(String ssid) {
    if (ssid == null) {
      throw new NullPointerException("null ssid");
    }

    this.ssid = ssid.trim();

    if (ssid.isEmpty()) {
      throw new IllegalArgumentException("empty ssid");
    }
  }

  public String getCapability() {
    return capability;
  }

  public void setCapability(String capability) {
    if (capability == null) {
      throw new NullPointerException("null capability");
    }

    this.capability = capability.trim();

    if (capability.isEmpty()) {
      throw new IllegalArgumentException("empty capability");
    }
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

  public String getObservationUuid() {
    return observationUuid;
  }

  public void setObservationUuid(String observationUuid) {
    if (observationUuid == null) {
      throw new NullPointerException("null observationUuid");
    }

    this.observationUuid = observationUuid.trim();

    if (observationUuid.isEmpty()) {
      throw new IllegalArgumentException("empty observationUuid");
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

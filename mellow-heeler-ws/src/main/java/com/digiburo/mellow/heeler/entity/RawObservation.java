package com.digiburo.mellow.heeler.entity;

/**
 * observation entity (raw client datum)
 */
public class RawObservation {
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

  /**
   * WAP BSSID
   */
  private String bssid;

  /**
   * WAP SSID
   */
  private String ssid;

  /**
   * WAP capabilities
   */
  private String capability;

  /**
   * observed center frequency
   */
  private Integer frequency;

  /**
   * observed signal strength
   */
  private Integer strength;

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

  public String getBssid() {
    return bssid;
  }

  public void setBssid(String bssid) {
    this.bssid = bssid;
  }

  public String getSsid() {
    return ssid;
  }

  public void setSsid(String ssid) {
    this.ssid = ssid;
  }

  public String getCapability() {
    return capability;
  }

  public void setCapability(String capability) {
    this.capability = capability;
  }

  public Integer getFrequency() {
    return frequency;
  }

  public void setFrequency(Integer frequency) {
    this.frequency = frequency;
  }

  public Integer getStrength() {
    return strength;
  }

  public void setStrength(Integer strength) {
    this.strength = strength;
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

  public String getObservationUuid() {
    return observationUuid;
  }

  public void setObservationUuid(String observationUuid) {
    this.observationUuid = observationUuid;
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

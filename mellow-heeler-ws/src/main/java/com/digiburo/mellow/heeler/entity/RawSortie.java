package com.digiburo.mellow.heeler.entity;

/**
 * sortie entity (raw client datum)
 */
public class RawSortie {
  public static final String ENTITY_NAME = "RawSortie";

  public static final String PROPERTY_INSTALLATION_UUID = "installationUuid";
  public static final String PROPERTY_SORTIE_NAME = "sortieName";
  public static final String PROPERTY_SORTIE_UUID = "sortieUuid";
  public static final String PROPERTY_TIME_STAMP = "timeStamp";
  public static final String PROPERTY_TIME_STAMP_MS = "timeStampMs";

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
   * sortie name
   */
  private String sortieName;

  /**
   * sortie UUID
   */
  private String sortieUuid;

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

  public String getSortieUuid() {
    return sortieUuid;
  }

  public void setSortieUuid(String sortieUuid) {
    this.sortieUuid = sortieUuid;
  }

  public String getSortieName() {
    return sortieName;
  }

  public void setSortieName(String arg) {
    sortieName = arg;
  }
}
/*
 * Copyright 2014 Digital Burro, INC
 * Created on May 23, 2014 by gsc
 */

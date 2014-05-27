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

  // reserved reporting flags
  public static final String PROPERTY_STUNT1 = "stunt1";
  public static final String PROPERTY_STUNT2 = "stunt2";
  public static final String PROPERTY_STUNT3 = "stunt3";
  public static final String PROPERTY_STUNT4 = "stunt4";
  public static final String PROPERTY_STUNT5 = "stunt5";
  public static final String PROPERTY_STUNT6 = "stunt6";
  public static final String PROPERTY_STUNT7 = "stunt7";
  public static final String PROPERTY_STUNT8 = "stunt8";

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

  /**
   * reserved reporting flags
   */
  private Boolean stunt1 = false;
  private Boolean stunt2 = false;
  private Boolean stunt3 = false;
  private Boolean stunt4 = false;
  private Boolean stunt5 = false;
  private Boolean stunt6 = false;
  private Boolean stunt7 = false;
  private Boolean stunt8 = false;

  //////////////////////////////

  public String getTimeStamp() {
    return timeStamp;
  }

  public void setTimeStamp(String timeStamp) {
    this.timeStamp = timeStamp;
  }

  public Long getTimeStampMs() {
    return timeStampMs;
  }

  public void setTimeStampMs(long timeStampMs) {
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

  public Boolean isStunt1() {
    return stunt1;
  }

  public void setStunt1(boolean stunt1) {
    this.stunt1 = stunt1;
  }

  public Boolean isStunt2() {
    return stunt2;
  }

  public void setStunt2(boolean stunt2) {
    this.stunt2 = stunt2;
  }

  public Boolean isStunt3() {
    return stunt3;
  }

  public void setStunt3(boolean stunt3) {
    this.stunt3 = stunt3;
  }

  public Boolean isStunt4() {
    return stunt4;
  }

  public void setStunt4(boolean stunt4) {
    this.stunt4 = stunt4;
  }

  public Boolean isStunt5() {
    return stunt5;
  }

  public void setStunt5(boolean stunt5) {
    this.stunt5 = stunt5;
  }

  public Boolean isStunt6() {
    return stunt6;
  }

  public void setStunt6(boolean stunt6) {
    this.stunt6 = stunt6;
  }

  public Boolean isStunt7() {
    return stunt7;
  }

  public void setStunt7(boolean stunt7) {
    this.stunt7 = stunt7;
  }

  public Boolean isStunt8() {
    return stunt8;
  }

  public void setStunt8(boolean stunt8) {
    this.stunt8 = stunt8;
  }
}
/*
 * Copyright 2014 Digital Burro, INC
 * Created on May 23, 2014 by gsc
 */

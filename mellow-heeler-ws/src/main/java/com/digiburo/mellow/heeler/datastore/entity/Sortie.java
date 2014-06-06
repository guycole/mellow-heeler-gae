package com.digiburo.mellow.heeler.datastore.entity;

import java.util.Date;

/**
 * sortie
 */
public class Sortie extends AbstractEntity {
  public static final String ENTITY_NAME = "Sortie";

  public static final String PROPERTY_INSTALLATION_UUID = "installationUuid";
  public static final String PROPERTY_SORTIE_NAME = "name";
  public static final String PROPERTY_SORTIE_NOTE = "note";
  public static final String PROPERTY_TIME_STAMP = "timeStamp";
  public static final String PROPERTY_SORTIE_UUID = "sortieUuid";

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
   * collection time in UTC
   */
  private Date timeStamp = new Date();

  /**
   * installation UUID
   */
  private String installationUuid = DEFAULT_UUID;

  /**
   * sortie name
   */
  private String name = DEFAULT_NAME;

  /**
   * sortie UUID
   */
  private String sortieUuid = DEFAULT_UUID;

  /**
   * short free form note
   */
  private String note = DEFAULT_NOTE;

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

  /////

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

  public String getSortieUuid() {
    return sortieUuid;
  }

  public void setSortieUuid(String sortieUuid) {
    this.sortieUuid = cleaner(sortieUuid, "null sortieUuid", "empty sortieUuid");
  }

  public String getNote() {
    return note;
  }

  public void setNote(String arg) {
    note = cleaner(arg, "null note", "empty note");
  }

  public String getName() {
    return name;
  }

  public void setName(String arg) {
    name = cleaner(arg, "null name", "empty name");
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

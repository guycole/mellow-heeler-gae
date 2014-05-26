package com.digiburo.mellow.heeler.entity;

/**
 * authorization entity
 */
public class Authorization {
  public static final String ENTITY_NAME = "Authorization";

  public static final String PROPERTY_ACTIVE = "active";
  public static final String PROPERTY_INSTALLATION_UUID = "installationUuid";
  public static final String PROPERTY_NAME = "name";
  public static final String PROPERTY_NOTE = "note";

  /**
   * true, active legal user
   */
  private boolean active = false;

  /**
   * installation UUID
   */
  private String installationUuid;

  /**
   * client name
   */
  private String name = "No Name";

  /**
   * free form note
   */
  private String note = "No Note";

  ////////////////

  public Boolean isActive() {
    return active;
  }

  public void setActive(boolean active) {
    this.active = active;
  }

  public String getInstallationUuid() {
    return installationUuid;
  }

  public void setInstallationUuid(String installationUuid) {
    this.installationUuid = installationUuid;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getNote() {
    return note;
  }

  public void setNote(String note) {
    this.note = note;
  }
}
/*
 * Copyright 2014 Digital Burro, INC
 * Created on May 25, 2014 by gsc
 */

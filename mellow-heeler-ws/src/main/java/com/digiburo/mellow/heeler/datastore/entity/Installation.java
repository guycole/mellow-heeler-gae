package com.digiburo.mellow.heeler.datastore.entity;

/**
 * authorization/approved installations entity
 */
public class Installation extends AbstractEntity {
  public static final String ENTITY_NAME = "Installation";

  public static final String PROPERTY_ACTIVE = "active";
  public static final String PROPERTY_INSTALLATION_UUID = "installationUuid";
  public static final String PROPERTY_NAME = "name";
  public static final String PROPERTY_NOTE = "note";

  /**
   * true, active legal installation
   */
  private boolean active = false;

  /**
   * installation UUID
   */
  private String installationUuid = DEFAULT_UUID;

  /**
   * client name
   */
  private String name = DEFAULT_NAME;

  /**
   * free form note
   */
  private String note = DEFAULT_NOTE;

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
    this.installationUuid = cleaner(installationUuid, "null installationUuid", "empty installationUuid");
  }

  public String getName() {
    return name;
  }

  public void setName(String arg) {
    name = cleaner(arg, "null name", "empty name");
  }

  public String getNote() {
    return note;
  }

  public void setNote(String arg) {
    note = cleaner(arg, "null note", "empty note");
  }
}
/*
 * Copyright 2014 Digital Burro, INC
 * Created on May 25, 2014 by gsc
 */

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

  public static final String DEFAULT_NAME = "No Name";
  public static final String DEFAULT_NOTE = "No Note";

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
    if (installationUuid == null) {
      throw new NullPointerException("null installationUuid");
    }

    this.installationUuid = installationUuid.trim();

    if (installationUuid.isEmpty()) {
      throw new IllegalArgumentException("empty installationUuid");
    }
  }

  public String getName() {
    return name;
  }

  public void setName(String arg) {
    if (arg == null) {
      throw new NullPointerException("null sortie name");
    }

    name = arg.trim();

    if (name.isEmpty()) {
      throw new IllegalArgumentException("empty sortie name");
    }
  }

  public String getNote() {
    return note;
  }

  public void setNote(String arg) {
    if (arg == null) {
      throw new NullPointerException("null note");
    }

    note = arg.trim();

    if (note.isEmpty()) {
      throw new IllegalArgumentException("empty note");
    }
  }
}
/*
 * Copyright 2014 Digital Burro, INC
 * Created on May 25, 2014 by gsc
 */

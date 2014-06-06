package com.digiburo.mellow.heeler.datastore.entity;

import java.util.Date;

/**
 * log entity
 */
public class ApplicationLog extends AbstractEntity {
  public static final String ENTITY_NAME = "ApplicationLog";

  public static final String PROPERTY_NOTE = "note";
  public static final String PROPERTY_TIME_STAMP = "timeStamp";

  public static final String DEFAULT_NOTE = "No Note";

  /**
   * free form note
   */
  private String note = DEFAULT_NOTE;

  /**
   * event time in UTC
   */
  private Date timeStamp = new Date();

  //////

  public String getNote() {
    return note;
  }

  public void setNote(String arg) {
    note = cleaner(arg, "null note", "empty note");
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
}
/*
 * Copyright 2014 Digital Burro, INC
 * Created on May 25, 2014 by gsc
 */

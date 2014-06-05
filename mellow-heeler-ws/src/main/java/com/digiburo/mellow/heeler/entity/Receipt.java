package com.digiburo.mellow.heeler.entity;

import java.util.Date;

/**
 * log entity
 */
public class Receipt {
  public static final String ENTITY_NAME = "Receipt";

  public static final String PROPERTY_IP_ADDRESS = "ipAddress";
  public static final String PROPERTY_MESSAGE_TYPE = "messageType";
  public static final String PROPERTY_NOTE = "note";
  public static final String PROPERTY_TIME_STAMP = "timeStamp";

  public static final String PROPERTY_INSTALLATION_UUID = "installationUuid";
  public static final String PROPERTY_RECEIPT_UUID = "receiptUuid";

  public static final String DEFAULT_NOTE = "No Note";

  /**
   * client IP address
   */
  private String ipAddress;

  /**
   * message type
   */
  private String messageType;

  /**
   * free form note
   */
  private String note = DEFAULT_NOTE;

  /**
   * location time in UTC
   */
  private Date timeStamp;

  /**
   * installation UUID
   */
  private String installationUuid;

  /**
   * receipt UUID
   */
  private String receiptUuid;

  //////////////////////////////

  public String getIpAddress() {
    return ipAddress;
  }

  public void setIpAddress(String arg) {
    if (arg == null) {
      throw new NullPointerException("null address");
    }

    ipAddress = arg.trim();

    if (ipAddress.isEmpty()) {
      throw new IllegalArgumentException("empty address");
    }
  }

  public String getMessageType() {
    return messageType;
  }

  public void setMessageType(String arg) {
    if (arg == null) {
      throw new NullPointerException("null message type");
    }

    messageType = arg.trim();

    if (messageType.isEmpty()) {
      throw new IllegalArgumentException("empty message type");
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

  public String getReceiptUuid() {
    return receiptUuid;
  }

  public void setReceiptUuid(String receiptUuid) {
    if (receiptUuid == null) {
      throw new NullPointerException("null receiptUuid");
    }

    this.receiptUuid = receiptUuid.trim();

    if (receiptUuid.isEmpty()) {
      throw new IllegalArgumentException("empty receiptUuid");
    }
  }
}
/*
 * Copyright 2014 Digital Burro, INC
 * Created on May 25, 2014 by gsc
 */
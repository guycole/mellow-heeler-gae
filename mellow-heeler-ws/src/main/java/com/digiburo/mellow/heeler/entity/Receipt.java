package com.digiburo.mellow.heeler.entity;

/**
 * log entity
 */
public class Receipt {
  public static final String ENTITY_NAME = "Receipt";

  public static final String PROPERTY_IP_ADDRESS = "ipAddress";
  public static final String PROPERTY_MESSAGE_TYPE = "messageType";
  public static final String PROPERTY_NOTE = "note";
  public static final String PROPERTY_TIME_STAMP = "timeStamp";
  public static final String PROPERTY_TIME_STAMP_MS = "timeStampMs";

  public static final String PROPERTY_INSTALLATION_UUID = "installationUuid";
  public static final String PROPERTY_RECEIPT_UUID = "receiptUuid";

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
  private String note;

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
   * receipt UUID
   */
  private String receiptUuid;

  //////////////////////////////

  public String getIpAddress() {
    return ipAddress;
  }

  public void setIpAddress(String arg) {
    ipAddress = arg;
  }

  public String getMessageType() {
    return messageType;
  }

  public void setMessageType(String arg) {
    messageType = arg;
  }

  public String getNote() {
    return note;
  }

  public void setNote(String arg) {
    note = arg;
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

  public String getReceiptUuid() {
    return receiptUuid;
  }

  public void setReceiptUuid(String receiptUuid) {
    this.receiptUuid = receiptUuid;
  }
}
/*
 * Copyright 2014 Digital Burro, INC
 * Created on May 25, 2014 by gsc
 */

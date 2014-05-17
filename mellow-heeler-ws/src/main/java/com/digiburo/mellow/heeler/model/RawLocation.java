package com.digiburo.mellow.heeler.model;

import org.codehaus.jackson.map.annotate.JsonSerialize;

import java.util.Date;

/**
 * json raw location response container
 */
public class RawLocation {
  private Double accuracy;
  private Double altitude;
  private Double latitude;
  private Double longitude;
  private Long timeStampMs;
  private Date timeStamp = new Date();
  private String locationId;

  public Double getAccuracy() {
    return accuracy;
  }

  public void setAccuracy(Double accuracy) {
    this.accuracy = accuracy;
  }

  public Double getAltitude() {
    return altitude;
  }

  public void setAltitude(Double altitude) {
    this.altitude = altitude;
  }

  public Double getLatitude() {
    return latitude;
  }

  public void setLatitude(Double latitude) {
    this.latitude = latitude;
  }

  public Double getLongitude() {
    return longitude;
  }

  public void setLongitude(Double longitude) {
    this.longitude = longitude;
  }

  @JsonSerialize(using = Rfc3339DateSerializer.class)
  public Date getTimeStamp() {
    return timeStamp;
  }

  public void setTimeStamp(Date timeStamp) {
    this.timeStamp = timeStamp;
  }

  public Long getTimeStampMs() {
    return timeStampMs;
  }

  public void setTimeStampMs(Long timeStampMs) {
    this.timeStampMs = timeStampMs;
  }

  public String getLocationId() {
    return locationId;
  }

  public void setLocationId(String arg) {
    locationId = arg;
  }
}
/*
 * Copyright 2014 Digital Burro, INC
 * Created on May 17, 2014 by gsc
 */

package com.digiburo.mellow.heeler.json;

import org.codehaus.jackson.map.annotate.JsonSerialize;

import java.util.Date;

/**
 * json raw observation response container
 */
public class Observation {
  private String ssid;
  private String bssid;
  private String capability;
  private Integer frequency;
  private Integer strength;
  private Long timeStampMs;
  private Date timeStamp = new Date();
  private String locationId;

  public String getSsid() {
    return ssid;
  }

  public void setSsid(String ssid) {
    this.ssid = ssid;
  }

  public String getBssid() {
    return bssid;
  }

  public void setBssid(String bssid) {
    this.bssid = bssid;
  }

  public String getCapability() {
    return capability;
  }

  public void setCapability(String capability) {
    this.capability = capability;
  }

  public Integer getFrequency() {
    return frequency;
  }

  public void setFrequency(Integer frequency) {
    this.frequency = frequency;
  }

  public Integer getStrength() {
    return strength;
  }

  public void setStrength(Integer strength) {
    this.strength = strength;
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

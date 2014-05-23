package com.digiburo.mellow.heeler.json;

/**
 * json location request container
 *
 * @author gsc
 */
public class GeoLocationRequest1 {
  private String installationId;
  private String sortieId;
  private Integer messageVersion = 1;
  private GeoLocationList geoLocationList = new GeoLocationList();

  public String getInstallationId() {
    return installationId;
  }

  public void setInstallationId(String installationId) {
    this.installationId = installationId;
  }

  public String getSortieId() {
    return sortieId;
  }

  public void setSortieId(String sortieId) {
    this.sortieId = sortieId;
  }

  public Integer getMessageVersion() {
    return messageVersion;
  }

  public void setMessageVersion(Integer messageVersion) {
    this.messageVersion = messageVersion;
  }

  public GeoLocationList getLocationList() {
    return geoLocationList;
  }

  public void setLocationList(GeoLocationList arg) {
    geoLocationList = arg;
  }
}
/*
 * Copyright 2014 Digital Burro, INC
 * Created on May 16, 2014 by gsc
 */

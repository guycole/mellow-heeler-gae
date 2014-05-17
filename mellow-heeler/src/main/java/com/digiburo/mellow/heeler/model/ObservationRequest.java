package com.digiburo.mellow.heeler.model;

/**
 * json observation request container
 *
 * @author gsc
 */
public class ObservationRequest {

  private String installationId;
  private String sortieId;
  private Integer messageVersion = 1;
  private RawObservationList rawObservationList;

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

  public void setMessageVersion(Integer messageVersion) {
    this.messageVersion = messageVersion;
  }

  public Integer getMessageVersion() {
    return messageVersion;
  }

  public RawObservationList getRawObservationList() {
    return rawObservationList;
  }

  public void setRawObservationList(RawObservationList arg) {
    rawObservationList = arg;
  }
}
/*
 * Copyright 2014 Digital Burro, INC
 * Created on May 16, 2014 by gsc
 */

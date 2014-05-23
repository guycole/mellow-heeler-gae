package com.digiburo.mellow.heeler.json;

/**
 * json observation request container
 *
 * @author gsc
 */
public class ObservationRequest1 {
  private String installationId;
  private String sortieId;
  private Integer messageVersion = 1;
  private ObservationList rawObservationList;

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

  public ObservationList getObservationList() {
    return rawObservationList;
  }

  public void setObservationList(ObservationList arg) {
    rawObservationList = arg;
  }
}
/*
 * Copyright 2014 Digital Burro, INC
 * Created on May 16, 2014 by gsc
 */

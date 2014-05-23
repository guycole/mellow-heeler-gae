package com.digiburo.mellow.heeler.json;

/**
 * json sortie request container
 *
 * @author gsc
 */
public class SortieRequest1 {
  private String installationId;
  private String sortieId;
  private String sortieName;
  private Long timeStampMs;
  private Integer messageVersion = 1;

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

  public String getSortieName() {
    return sortieName;
  }

  public void setSortieName(String arg) {
    sortieName = arg;
  }

  public Long getTimeStampMs() {
    return timeStampMs;
  }

  public void setTimeStampMs(Long timeStampMs) {
    this.timeStampMs = timeStampMs;
  }

  public Integer getMessageVersion() {
    return messageVersion;
  }

  public void setMessageVersion(Integer messageVersion) {
    this.messageVersion = messageVersion;
  }
}
/*
 * Copyright 2014 Digital Burro, INC
 * Created on May 22, 2014 by gsc
 */

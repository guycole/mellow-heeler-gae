package com.digiburo.mellow.heeler.json;

/**
 * json authorize request container
 *
 * @author gsc
 */
public class AuthorizeRequest1 {
  private String installationId;
  private Integer messageVersion = 1;

  public String getInstallationId() {
    return installationId;
  }

  public void setInstallationId(String installationId) {
    this.installationId = installationId;
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
 * Created on May 21, 2014 by gsc
 */

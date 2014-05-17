package com.shastrax.jaded.nomad.model;

import java.util.Date;

/**
 * game score request container
 *
 * @author gsc
 */
public class GameScoreRequest {
  private String applicationName;
  private String installationId;
  private String userName;
  private Long score;
  private Integer messageVersion = 1;

  public String getApplicationName() {
    return applicationName;
  }

  public void setApplicationName(String applicationName) {
    this.applicationName = applicationName;
  }

  public String getInstallationId() {
    return installationId;
  }

  public void setInstallationId(String installationId) {
    this.installationId = installationId;
  }

  public String getUserName() {
    return userName;
  }

  public void setUserName(String userName) {
    this.userName = userName;
  }

  public Long getScore() {
    return score;
  }

  public void setScore(long score) {
    this.score = score;
  }

  public Integer getMessageVersion() {
    return messageVersion;
  }

  public void setMessageVersion(int messageVersion) {
    this.messageVersion = messageVersion;
  }
}
/*
 * Copyright 2014 Shasta Traction, INC
 * Created on April 3, 2014 by gsc
 */

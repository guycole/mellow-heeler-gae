package com.shastrax.jaded.nomad.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.google.appengine.api.datastore.Key;

/**
 * Game score entity
 */
@Entity
public class GameScore {
  private String applicationName;
  private String installationId;
  private String receipt;
  private String userName;

  private Date timeStamp = new Date();

  private Long score;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Key key;

  public Key getKey() {
    return(key);
  }

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

  public String getReceipt() {
    return receipt;
  }

  public void setReceipt(String receipt) {
    this.receipt = receipt;
  }

  public String getUserName() {
    return userName;
  }

  public void setUserName(String userName) {
    this.userName = userName;
  }

  public Date getTimeStamp() {
    return timeStamp;
  }

  public void setTimeStamp(Date timeStamp) {
    this.timeStamp = timeStamp;
  }

  public Long getScore() {
    return score;
  }

  public void setScore(Long score) {
    this.score = score;
  }
}
/*
 * Copyright 2014 Shasta Traction, INC
 * Created on April 27, 2014 by gsc
 */
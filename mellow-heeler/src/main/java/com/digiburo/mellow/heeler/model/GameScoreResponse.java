package com.shastrax.jaded.nomad.model;

import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.map.annotate.JsonSerialize;

import java.util.Date;

/**
 * game score response container
 *
 * @author gsc
 */
public class GameScoreResponse {

  private String ipAddress;
  private String receipt;
  private String status;
  private Date timeStamp = new Date();
  private Integer messageVersion = 1;

  @JsonProperty("_links")
  private Links links = new Links();

  public String getReceipt() {
    return receipt;
  }

  public void setReceipt(String receipt) {
    this.receipt = receipt;
  }

  public String getRemoteIpAddress() {
    return ipAddress;
  }

  public void setRemoteIpAddress(String ipAddress) {
    this.ipAddress = ipAddress;
  }

  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  @JsonSerialize(using = Rfc3339DateSerializer.class)
  public Date getTimeStamp() {
    return timeStamp;
  }

  public void setTimeStamp(Date timeStamp) {
    this.timeStamp = timeStamp;
  }

  public Integer getMessageVersion() {
    return messageVersion;
  }

  public void setVersion(int messageVersion) {
    this.messageVersion = messageVersion;
  }

  public Links getLinks() {
    return links;
  }

  public void setLinks(Links arg) {
    links = arg;
  }

  public static class Links {
    Self self = new Self();

    public Self getSelf() {
      return self;
    }

    public void setSelf(Self self) {
      this.self = self;
    }
  }

  public static class Self {
    private String href = "bogus";

    public String getHref() {
      return href;
    }

    public void setHref(String href) {
      this.href = href;
    }
  }
}
/*
 * Copyright 2014 Shasta Traction, INC
 * Created on April 3, 2014 by gsc
 */

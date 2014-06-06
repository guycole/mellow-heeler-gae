package com.digiburo.mellow.heeler.json;

import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.map.annotate.JsonSerialize;

import java.util.Date;

/**
 * json authorize response container
 *
 * @author gsc
 */
public class AuthorizeResponse1 {
  private String ipAddress;
  private String receipt;
  private String status;
  private Date timeStamp = new Date();

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

  public Links getLinks() {
    return links;
  }

  public void setLinks(Links arg) {
    links = arg;
  }

  public static class Links {
    Self self;

    public Self getSelf() {
      return self;
    }

    public void setSelf(Self self) {
      this.self = self;
    }
  }

  public static class Self extends HrefContainer {
    //empty
  }
}
/*
 * Copyright 2014 Digital Burro, INC
 * Created on May 21, 2014 by gsc
 */

package com.digiburo.mellow.heeler.json;

import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.map.annotate.JsonSerialize;

import java.util.Date;

/**
 * json location response container
 *
 * @author gsc
 */
public class GeoLocationResponse1 {

  private String ipAddress;
  private String receipt;
  private String sortieId;
  private String status;
  private Date timeStamp = new Date();
  private Integer messageVersion = 1;
  private Integer rowCount = 0;
  private Boolean specialFlag = false;

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

  public String getSortieId() {
    return sortieId;
  }

  public void setSortieId(String sortieId) {
    this.sortieId = sortieId;
  }

  public Boolean isSpecialFlag() {
    return specialFlag;
  }

  public void setSpecialFlag(boolean flag) {
    specialFlag = flag;
  }

  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  public Integer getRowCount() {
    return rowCount;
  }

  public void setRowCount(int rowCount) {
    this.rowCount = rowCount;
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
 * Copyright 2014 Digital Burro, INC
 * Created on May 16, 2014 by gsc
 */

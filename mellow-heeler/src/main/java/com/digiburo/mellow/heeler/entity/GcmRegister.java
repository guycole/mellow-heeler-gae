package com.shastrax.jaded.nomad.entity;

import com.google.appengine.api.datastore.Key;

/**
 * Created by gsc on 4/28/14.
 */
public class GcmRegister {

  private String applicationName;
  private String cloudMessageId;
  private String installationId;
  private String receipt;

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

  public String getCloudMessageId() {
    return cloudMessageId;
  }

  public void setCloudMessageId(String cloudMessageId) {
    this.cloudMessageId = cloudMessageId;
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
}

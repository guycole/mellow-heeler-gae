package com.shastrax.jaded.nomad.model;

/**
 * google cloud messaging request container
 *
 * @author gsc
 */
public class GcmRegisterRequest {

  private String applicationName;
  private String installationId;
  private String cloudMessageId;
  private Integer messageVersion = 0;


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

  public String getCloudMessageId() {
    return cloudMessageId;
  }

  public void setCloudMessageId(String gcmId) {
    this.cloudMessageId = gcmId;
  }

  public Integer getMessageVersion() {
    return messageVersion;
  }

  public void setMessageVersion(int version) {
    messageVersion = version;
  }
}

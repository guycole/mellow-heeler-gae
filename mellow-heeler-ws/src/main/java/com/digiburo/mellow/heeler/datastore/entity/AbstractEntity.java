package com.digiburo.mellow.heeler.datastore.entity;

/**
 * Created by gsc on 6/5/14.
 */
public abstract class AbstractEntity {

  public static final String DEFAULT_NAME = "No Name";
  public static final String DEFAULT_NOTE = "No Note";
  public static final String DEFAULT_UUID = "No UUID";

  /**
   * Clean all arriving String arguments
   * @param candidate
   * @param nullMessage
   * @param emptyMessage
   * @return
   */
  protected String cleaner(String candidate, String nullMessage, String emptyMessage) {
    String result = null;

    if (candidate == null) {
      throw new NullPointerException(nullMessage);
    }

    result = candidate.trim();

    if (result.isEmpty()) {
      throw new IllegalArgumentException(emptyMessage);
    }

    return result;
  }
}

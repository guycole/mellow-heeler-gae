package com.digiburo.mellow.heeler.ws1;

import com.digiburo.mellow.heeler.datastore.DataBaseFacade;
import com.digiburo.mellow.heeler.datastore.entity.Installation;

/**
 * Created by gsc on 6/5/14.
 */
public abstract class AbstractHelper {

  public static final String AUTH_FAIL = "AUTH_FAIL";
  public static final String OK = "OK";

  /**
   *
   * @param installationUuid
   * @return true if access authorized
   */
  public boolean authorizationTest(final String installationUuid) {
    DataBaseFacade dataBaseFacade = new DataBaseFacade();
    Installation installation = dataBaseFacade.selectInstallation(installationUuid);
    if (installation == null) {
      // unknown installation, create WhiteList entry for possible approval
      dataBaseFacade.saveInstallation(installationUuid);
      return false;
    }

    if (installation.isActive()) {
      return true;
    }

    return false;
  }
}

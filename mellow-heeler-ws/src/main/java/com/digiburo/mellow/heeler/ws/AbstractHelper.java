package com.digiburo.mellow.heeler.ws;

import com.digiburo.mellow.heeler.datastore.dao.AuthorizationDao;
import com.digiburo.mellow.heeler.datastore.entity.Authorization;

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
    AuthorizationDao authorizationDao = new AuthorizationDao();
    Authorization authorization = authorizationDao.selectOne(installationUuid);
    if (authorization == null) {
      return false;
    }

    if (authorization.isActive()) {
      return true;
    }

    return false;
  }
}

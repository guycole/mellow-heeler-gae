package com.digiburo.mellow.heeler.datastore;

import com.digiburo.mellow.heeler.datastore.dao.InstallationDao;
import com.digiburo.mellow.heeler.datastore.entity.Installation;

/**
 * Created by gsc on 6/6/14.
 */
public class DataBaseFacade {
  //TODO use me instead of access DAO directly

  /**
   * Select for installation.
   * @param uuid installation UUID
   * @return matching entry or null if none
   */
  public Installation selectInstallation(final String uuid) {
    InstallationDao installationDao = new InstallationDao();
    return installationDao.selectOne(uuid);
  }

  /**
   * Add a new installation entry w/active flag false
   * @param uuid installation UUID
   */
  public void saveInstallation(final String uuid) {
    InstallationDao installationDao = new InstallationDao();
    installationDao.save(uuid);
  }
}

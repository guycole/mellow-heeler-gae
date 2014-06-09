package com.digiburo.mellow.heeler.datastore.dao;

import com.digiburo.mellow.heeler.TestHelper;
import com.digiburo.mellow.heeler.datastore.DataBaseFacade;
import com.digiburo.mellow.heeler.datastore.entity.Installation;
import com.google.appengine.tools.development.testing.LocalDatastoreServiceTestConfig;
import com.google.appengine.tools.development.testing.LocalServiceTestHelper;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Created by gsc on 6/5/14.
 */
public class InstallationDaoTest {
  private final TestHelper testHelper = new TestHelper();

  private final LocalServiceTestHelper helper = new LocalServiceTestHelper(new LocalDatastoreServiceTestConfig());

  @Before
  public void setUp() {
    helper.setUp();
  }

  @After
  public void tearDown() {
    helper.tearDown();
  }

  @Test
  public void testDao() {
    String target = testHelper.randomString();

    InstallationDao installationDao = new InstallationDao();
    installationDao.save(target);

    Installation installation = installationDao.selectOne(target);
    assertTrue(target.equals(installation.getInstallationUuid()));
  }

  @Test
  public void testFacade() {
    String target = testHelper.randomString();

    DataBaseFacade dataBaseFacade = new DataBaseFacade();
    dataBaseFacade.saveInstallation(target);

    Installation installation = dataBaseFacade.selectInstallation(target);
    assertTrue(target.equals(installation.getInstallationUuid()));
  }
}

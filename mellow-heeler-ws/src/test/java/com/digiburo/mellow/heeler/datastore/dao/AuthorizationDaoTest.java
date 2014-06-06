package com.digiburo.mellow.heeler.datastore.dao;

import com.digiburo.mellow.heeler.TestHelper;
import com.digiburo.mellow.heeler.datastore.dao.AuthorizationDao;
import com.digiburo.mellow.heeler.datastore.entity.Authorization;
import com.google.appengine.tools.development.testing.LocalDatastoreServiceTestConfig;
import com.google.appengine.tools.development.testing.LocalServiceTestHelper;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Created by gsc on 6/5/14.
 */
public class AuthorizationDaoTest {
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
  public void testSave() {
    String target = testHelper.randomString();

    AuthorizationDao authorizationDao = new AuthorizationDao();
    authorizationDao.save(target);

    Authorization authorization = authorizationDao.selectOne(target);
    assertTrue(target.equals(authorization.getInstallationUuid()));
  }
}

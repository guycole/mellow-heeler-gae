package com.digiburo.mellow.heeler.datastore.dao;

import com.digiburo.mellow.heeler.TestHelper;
import com.digiburo.mellow.heeler.datastore.entity.Sortie;
import com.google.appengine.tools.development.testing.LocalDatastoreServiceTestConfig;
import com.google.appengine.tools.development.testing.LocalServiceTestHelper;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

/**
 * Created by gsc on 6/5/14.
 */
public class SortieDaoTest {
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
    String installationId = testHelper.randomString();
    String sortieId = testHelper.randomString();
    String name = testHelper.randomString();
    String note = testHelper.randomString();

    Sortie sortie = new Sortie();
    sortie.setInstallationUuid(installationId);
    sortie.setSortieUuid(sortieId);
    sortie.setName(name);
    sortie.setNote(note);

    SortieDao sortieDao = new SortieDao();
    sortieDao.save(sortie);

    Sortie selected = sortieDao.selectOne(sortieId);
    assertTrue(sortieId.equals(selected.getSortieUuid()));
  }
}

package com.digiburo.mellow.heeler.datastore.dao;

import com.digiburo.mellow.heeler.TestHelper;
import com.digiburo.mellow.heeler.datastore.entity.Observation;
import com.digiburo.mellow.heeler.utility.ObservationList;
import com.google.appengine.tools.development.testing.LocalDatastoreServiceTestConfig;
import com.google.appengine.tools.development.testing.LocalServiceTestHelper;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by gsc on 6/5/14.
 */
public class ObservationDaoTest {
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
    String locationId = testHelper.randomString();
    String observationId = testHelper.randomString();
    String sortieId = testHelper.randomString();

    String bssid = testHelper.randomString();
    String ssid = testHelper.randomString();
    String capability = testHelper.randomString();

    Long frequency = testHelper.randomLong();
    Long strength = testHelper.randomLong();

    Observation observation = new Observation();
    observation.setBssid(bssid);
    observation.setCapability(capability);
    observation.setFrequency(frequency);
    observation.setInstallationUuid(installationId);
    observation.setLocationUuid(locationId);
    observation.setObservationUuid(observationId);
    observation.setSortieUuid(sortieId);
    observation.setSsid(ssid);
    observation.setStrength(strength);

    ObservationDao observationDao = new ObservationDao();
    observationDao.save(observation);

    Observation selected = observationDao.selectOne(observationId);
    assertTrue(observationId.equals(selected.getObservationUuid()));
  }

  @Test
  public void testSelectBySortie() {
    String installationId = testHelper.randomString();
    String locationId = testHelper.randomString();
    String sortieId = testHelper.randomString();

    String observationId1 = testHelper.randomString();
    String observationId2 = testHelper.randomString();

    String bssid = testHelper.randomString();
    String ssid = testHelper.randomString();
    String capability = testHelper.randomString();

    Long frequency = testHelper.randomLong();
    Long strength = testHelper.randomLong();

    Observation observation1 = new Observation();
    observation1.setBssid(bssid);
    observation1.setCapability(capability);
    observation1.setFrequency(frequency);
    observation1.setInstallationUuid(installationId);
    observation1.setLocationUuid(locationId);
    observation1.setObservationUuid(observationId1);
    observation1.setSortieUuid(sortieId);
    observation1.setSsid(ssid);
    observation1.setStrength(strength);

    Observation observation2 = new Observation();
    observation2.setBssid(bssid);
    observation2.setCapability(capability);
    observation2.setFrequency(frequency);
    observation2.setInstallationUuid(installationId);
    observation2.setLocationUuid(locationId);
    observation2.setObservationUuid(observationId2);
    observation2.setSortieUuid(sortieId);
    observation2.setSsid(ssid);
    observation2.setStrength(strength);

    ObservationDao observationDao = new ObservationDao();
    observationDao.save(observation1);
    observationDao.save(observation2);

    ObservationList sortieList = observationDao.selectBySortie(sortieId);
    assertEquals(2, sortieList.size());
  }
}

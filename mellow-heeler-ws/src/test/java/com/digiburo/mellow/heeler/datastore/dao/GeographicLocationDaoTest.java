package com.digiburo.mellow.heeler.datastore.dao;

import com.digiburo.mellow.heeler.TestHelper;
import com.digiburo.mellow.heeler.datastore.entity.GeographicLocation;
import com.digiburo.mellow.heeler.utility.GeographicLocationList;

import com.google.appengine.api.datastore.GeoPt;
import com.google.appengine.tools.development.testing.LocalDatastoreServiceTestConfig;
import com.google.appengine.tools.development.testing.LocalServiceTestHelper;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

import static org.junit.Assert.assertTrue;

/**
 * Created by gsc on 6/5/14.
 */
public class GeographicLocationDaoTest {
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
    String sortieId = testHelper.randomString();

    Double altitude = testHelper.randomDouble();
    Double accuracy = testHelper.randomDouble();
    GeoPt geoPt = new GeoPt(38.83f, -123.32f);

    GeographicLocation geographicLocation = new GeographicLocation();
    geographicLocation.setAltitude(altitude);
    geographicLocation.setAccuracy(accuracy);
    geographicLocation.setLocation(geoPt);

    geographicLocation.setInstallationUuid(installationId);
    geographicLocation.setLocationUuid(locationId);
    geographicLocation.setSortieUuid(sortieId);

    GeographicLocationDao geographicLocationDao = new GeographicLocationDao();
    geographicLocationDao.save(geographicLocation);

    GeographicLocation selected = geographicLocationDao.selectOne(locationId);
    assertTrue(locationId.equals(selected.getLocationUuid()));
  }

  @Test
  public void testSelectBySortie() {
    String installationId = testHelper.randomString();
    String locationId1 = testHelper.randomString();
    String locationId2 = testHelper.randomString();
    String sortieId = testHelper.randomString();

    Double altitude1 = testHelper.randomDouble();
    Double altitude2 = testHelper.randomDouble();
    Double accuracy1 = testHelper.randomDouble();
    Double accuracy2 = testHelper.randomDouble();
    GeoPt geoPt1 = new GeoPt(38.83f, -123.32f);
    GeoPt geoPt2 = new GeoPt(39.93f, -124.42f);

    GeographicLocation geographicLocation1 = new GeographicLocation();
    geographicLocation1.setAltitude(altitude1);
    geographicLocation1.setAccuracy(accuracy1);
    geographicLocation1.setLocation(geoPt1);

    geographicLocation1.setInstallationUuid(installationId);
    geographicLocation1.setLocationUuid(locationId1);
    geographicLocation1.setSortieUuid(sortieId);

    GeographicLocation geographicLocation2 = new GeographicLocation();
    geographicLocation2.setAltitude(altitude2);
    geographicLocation2.setAccuracy(accuracy2);
    geographicLocation2.setLocation(geoPt2);

    geographicLocation2.setInstallationUuid(installationId);
    geographicLocation2.setLocationUuid(locationId2);
    geographicLocation2.setSortieUuid(sortieId);

    GeographicLocationDao geographicLocationDao = new GeographicLocationDao();
    geographicLocationDao.save(geographicLocation1);
    geographicLocationDao.save(geographicLocation2);

    GeographicLocationList sortieList = geographicLocationDao.selectBySortie(sortieId);
    assertEquals(2, sortieList.size());
  }
}

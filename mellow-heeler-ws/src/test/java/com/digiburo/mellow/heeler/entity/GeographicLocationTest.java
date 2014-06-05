package com.digiburo.mellow.heeler.entity;

import com.digiburo.mellow.heeler.TestHelper;

import com.google.appengine.api.datastore.GeoPt;
import org.junit.Test;

import java.util.Date;

import static org.junit.Assert.*;

/**
 * Created by gsc on 6/4/14.
 */
public class GeographicLocationTest {
  public static final double EPSILON = 0.00001;

  private final TestHelper testHelper = new TestHelper();

  @Test
  public void testDefault() {
    GeographicLocation geographicLocation = new GeographicLocation();

    assertEquals(0.0, geographicLocation.getAccuracy().doubleValue(), EPSILON);
    assertEquals(0.0, geographicLocation.getAltitude().doubleValue(), EPSILON);

    assertFalse(geographicLocation.isSpecialFlag());

    assertNull(geographicLocation.getLocation());
    assertNull(geographicLocation.getTimeStamp());

    assertNull(geographicLocation.getInstallationUuid());
    assertNull(geographicLocation.getLocationUuid());
    assertNull(geographicLocation.getSortieUuid());
  }

  @Test
  public void accuracyTest() {
    Double target = testHelper.randomDouble();

    GeographicLocation geographicLocation = new GeographicLocation();
    geographicLocation.setAccuracy(target);
    assertEquals(target, geographicLocation.getAccuracy(), EPSILON);
  }

  @Test
  public void altitudeTest() {
    Double target = testHelper.randomDouble();

    GeographicLocation geographicLocation = new GeographicLocation();
    geographicLocation.setAltitude(target);
    assertEquals(target, geographicLocation.getAltitude(), EPSILON);
  }

  @Test
  public void specialTest() {
    GeographicLocation geographicLocation = new GeographicLocation();
    geographicLocation.setSpecialFlag(true);
    assertTrue(geographicLocation.isSpecialFlag());
    geographicLocation.setSpecialFlag(false);
    assertFalse(geographicLocation.isSpecialFlag());
  }

  @Test
  public void installationUuidTest() {
    String target = testHelper.randomString();

    GeographicLocation geographicLocation = new GeographicLocation();
    geographicLocation.setInstallationUuid(target);
    assertTrue(target.equals(geographicLocation.getInstallationUuid()));
  }

  @Test(expected = NullPointerException.class)
  public void nullInstallationUuidTest() {
    GeographicLocation geographicLocation = new GeographicLocation();
    geographicLocation.setInstallationUuid(null);
  }

  @Test
  public void locationUuidTest() {
    String target = testHelper.randomString();

    GeographicLocation geographicLocation = new GeographicLocation();
    geographicLocation.setLocationUuid(target);
    assertTrue(target.equals(geographicLocation.getLocationUuid()));
  }

  @Test(expected = NullPointerException.class)
  public void nullLocationUuidTest() {
    GeographicLocation geographicLocation = new GeographicLocation();
    geographicLocation.setLocationUuid(null);
  }

  @Test
  public void sortieUuidTest() {
    String target = testHelper.randomString();
    GeographicLocation geographicLocation = new GeographicLocation();
    geographicLocation.setSortieUuid(target);
    assertTrue(target.equals(geographicLocation.getSortieUuid()));
  }

  @Test(expected = NullPointerException.class)
  public void nullSortieUuidTest() {
    GeographicLocation geographicLocation = new GeographicLocation();
    geographicLocation.setSortieUuid(null);
  }

  @Test
  public void locationTest() {
    GeoPt geoPt = new GeoPt(12.345f, 123.456f);

    GeographicLocation geographicLocation = new GeographicLocation();
    geographicLocation.setLocation(geoPt);
    assertTrue(geoPt.equals(geographicLocation.getLocation()));
  }

  @Test(expected=NullPointerException.class)
  public void nullLocationTest() {
    GeographicLocation geographicLocation = new GeographicLocation();
    geographicLocation.setLocation(null);
  }

  @Test
  public void timeTest() {
    Date date = new Date();

    GeographicLocation geographicLocation = new GeographicLocation();
    geographicLocation.setTimeStamp(date);
    assertTrue(date.equals(geographicLocation.getTimeStamp()));
  }

  @Test(expected=NullPointerException.class)
  public void nullTimeTest() {
    GeographicLocation geographicLocation = new GeographicLocation();
    geographicLocation.setTimeStamp(null);
  }
}


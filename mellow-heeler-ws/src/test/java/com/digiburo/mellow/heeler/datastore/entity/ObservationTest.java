package com.digiburo.mellow.heeler.datastore.entity;

import com.digiburo.mellow.heeler.TestHelper;

import java.util.Date;

import com.digiburo.mellow.heeler.datastore.entity.Observation;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Created by gsc on 6/4/14.
 */
public class ObservationTest {
  private final TestHelper testHelper = new TestHelper();

  @Test
  public void testDefault() {
    Observation observation = new Observation();

    assertNotNull(observation.getTimeStamp());

    assertEquals(0L, observation.getStrength().longValue());
    assertEquals(0L, observation.getFrequency().longValue());

    assertTrue(Observation.DEFAULT_CAPABILITY.equals(observation.getCapability()));
    assertTrue(Observation.DEFAULT_BSSID.equals(observation.getBssid()));
    assertTrue(Observation.DEFAULT_SSID.equals(observation.getSsid()));

    assertTrue(Observation.DEFAULT_UUID.equals(observation.getInstallationUuid()));
    assertTrue(Observation.DEFAULT_UUID.equals(observation.getLocationUuid()));
    assertTrue(Observation.DEFAULT_UUID.equals(observation.getObservationUuid()));
    assertTrue(Observation.DEFAULT_UUID.equals(observation.getSortieUuid()));
  }

  @Test
  public void frequencyTest() {
    Long target = testHelper.randomLong();

    Observation observation = new Observation();
    observation.setFrequency(target);
    assertEquals(target.longValue(), observation.getFrequency().longValue());
  }

  @Test
  public void strengthTest() {
    Long target = testHelper.randomLong();

    Observation observation = new Observation();
    observation.setStrength(target);
    assertEquals(target.longValue(), observation.getStrength().longValue());
  }

  @Test
  public void bssidTest() {
    String target = testHelper.randomString();

    Observation observation = new Observation();
    observation.setBssid(target);
    assertTrue(target.equals(observation.getBssid()));
  }

  @Test(expected=NullPointerException.class)
  public void nullBssidTest() {
    Observation observation = new Observation();
    observation.setBssid(null);
  }

  @Test
  public void ssidTest() {
    String target = testHelper.randomString();

    Observation observation = new Observation();
    observation.setSsid(target);
    assertTrue(target.equals(observation.getSsid()));
  }

  @Test(expected=NullPointerException.class)
  public void nullSsidTest() {
    Observation observation = new Observation();
    observation.setSsid(null);
  }

  @Test
  public void capabilityTest() {
    String target = testHelper.randomString();

    Observation observation = new Observation();
    observation.setCapability(target);
    assertTrue(target.equals(observation.getCapability()));
  }

  @Test(expected=NullPointerException.class)
  public void nullCapabilityTest() {
    Observation observation = new Observation();
    observation.setCapability(null);
  }

  @Test
  public void installationUuidTest() {
    String target = testHelper.randomString();

    Observation observation = new Observation();
    observation.setInstallationUuid(target);
    assertTrue(target.equals(observation.getInstallationUuid()));
  }

  @Test(expected=NullPointerException.class)
  public void nullInstallationUuidTest() {
    Observation observation = new Observation();
    observation.setInstallationUuid(null);
  }

  @Test
  public void locationUuidTest() {
    String target = testHelper.randomString();

    Observation observation = new Observation();
    observation.setLocationUuid(target);
    assertTrue(target.equals(observation.getLocationUuid()));
  }

  @Test(expected = NullPointerException.class)
  public void nullLocationUuidTest() {
    Observation observation = new Observation();
    observation.setLocationUuid(null);
  }

  @Test
  public void observationUuidTest() {
    String target = testHelper.randomString();

    Observation observation = new Observation();
    observation.setObservationUuid(target);
    assertTrue(target.equals(observation.getObservationUuid()));
  }

  @Test(expected = NullPointerException.class)
  public void nullObservationUuidTest() {
    Observation observation = new Observation();
    observation.setObservationUuid(null);
  }

  @Test
  public void sortieUuidTest() {
    String target = testHelper.randomString();

    Observation observation = new Observation();
    observation.setSortieUuid(target);
    assertTrue(target.equals(observation.getSortieUuid()));
  }

  @Test(expected=NullPointerException.class)
  public void nullSortieUuidTest() {
    Observation observation = new Observation();
    observation.setSortieUuid(null);
  }

  @Test
  public void timeTest() {
    Date date = new Date();

    Observation observation = new Observation();
    observation.setTimeStamp(date);
    assertTrue(date.equals(observation.getTimeStamp()));
  }

  @Test(expected=NullPointerException.class)
  public void nullTimeTest() {
    Observation observation = new Observation();
    observation.setTimeStamp(null);
  }
}

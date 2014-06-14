package com.digiburo.mellow.heeler.datastore.entity;

import com.digiburo.mellow.heeler.TestHelper;

import org.junit.Test;

import java.util.Date;

import static org.junit.Assert.*;

/**
 * Created by gsc on 6/4/14.
 */
public class InstallationTest {
  private final TestHelper testHelper = new TestHelper();

  @Test
  public void testDefault() {
    Installation installation = new Installation();

    assertTrue(Installation.DEFAULT_NAME.equals(installation.getName()));
    assertTrue(Installation.DEFAULT_NOTE.equals(installation.getNote()));
    assertTrue(Installation.DEFAULT_UUID.equals(installation.getInstallationUuid()));

    assertFalse(installation.isActive());

    assertNotNull(installation.getCreateTime());
  }

  @Test
  public void installationUuidTest() {
    String target = testHelper.randomString();

    Installation installation = new Installation();
    installation.setInstallationUuid(target);
    assertTrue(target.equals(installation.getInstallationUuid()));
  }

  @Test(expected=NullPointerException.class)
  public void nullInstallationUuidTest() {
    Installation installation = new Installation();
    installation.setInstallationUuid(null);
  }

  @Test
  public void nameTest() {
    String target = testHelper.randomString();

    Installation installation = new Installation();
    installation.setName(target);
    assertTrue(target.equals(installation.getName()));
  }

  @Test(expected=NullPointerException.class)
  public void nullNameTest() {
    Installation installation = new Installation();
    installation.setName(null);
  }

  @Test
  public void noteTest() {
    String target = testHelper.randomString();

    Installation installation = new Installation();
    installation.setNote(target);
    assertTrue(target.equals(installation.getNote()));
  }

  @Test(expected=NullPointerException.class)
  public void nullNoteTest() {
    Installation installation = new Installation();
    installation.setNote(null);
  }

  @Test
  public void activeTest() {
    Sortie sortie = new Sortie();

    Installation installation = new Installation();
    installation.setActive(true);
    assertTrue(installation.isActive());
    installation.setActive(false);
    assertFalse(installation.isActive());
  }

  @Test
  public void timeTest() {
    Date date = new Date();

    Installation installation = new Installation();
    installation.setCreateTime(date);
    assertTrue(date.equals(installation.getCreateTime()));
  }

  @Test(expected=NullPointerException.class)
  public void nullTimeTest() {
    Installation installation = new Installation();
    installation.setCreateTime(null);
  }
}

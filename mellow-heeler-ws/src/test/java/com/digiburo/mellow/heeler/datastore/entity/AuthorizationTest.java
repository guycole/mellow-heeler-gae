package com.digiburo.mellow.heeler.datastore.entity;

import com.digiburo.mellow.heeler.TestHelper;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Created by gsc on 6/4/14.
 */
public class AuthorizationTest {
  private final TestHelper testHelper = new TestHelper();

  @Test
  public void testDefault() {
    Authorization authorization = new Authorization();

    assertTrue(Authorization.DEFAULT_NAME.equals(authorization.getName()));
    assertTrue(Authorization.DEFAULT_NOTE.equals(authorization.getNote()));
    assertTrue(Authorization.DEFAULT_UUID.equals(authorization.getInstallationUuid()));

    assertFalse(authorization.isActive());
  }

  @Test
  public void installationUuidTest() {
    String target = testHelper.randomString();

    Authorization authorization = new Authorization();
    authorization.setInstallationUuid(target);
    assertTrue(target.equals(authorization.getInstallationUuid()));
  }

  @Test(expected=NullPointerException.class)
  public void nullInstallationUuidTest() {
    Authorization authorization = new Authorization();
    authorization.setInstallationUuid(null);
  }

  @Test
  public void nameTest() {
    String target = testHelper.randomString();

    Authorization authorization = new Authorization();
    authorization.setName(target);
    assertTrue(target.equals(authorization.getName()));
  }

  @Test(expected=NullPointerException.class)
  public void nullNameTest() {
    Authorization authorization = new Authorization();
    authorization.setName(null);
  }

  @Test
  public void noteTest() {
    String target = testHelper.randomString();

    Authorization authorization = new Authorization();
    authorization.setNote(target);
    assertTrue(target.equals(authorization.getNote()));
  }

  @Test(expected=NullPointerException.class)
  public void nullNoteTest() {
    Authorization authorization = new Authorization();
    authorization.setNote(null);
  }

  @Test
  public void activeTest() {
    Sortie sortie = new Sortie();

    Authorization authorization = new Authorization();
    authorization.setActive(true);
    assertTrue(authorization.isActive());
    authorization.setActive(false);
    assertFalse(authorization.isActive());
  }
}

package com.digiburo.mellow.heeler.entity;

import com.digiburo.mellow.heeler.TestHelper;

import java.util.Date;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Created by gsc on 6/4/14.
 */
public class SortieTest {
  private final TestHelper testHelper = new TestHelper();

  @Test
  public void testDefault() {
    Sortie sortie = new Sortie();

    assertNull(sortie.getInstallationUuid());
    assertNull(sortie.getSortieUuid());
    assertNull(sortie.getTimeStamp());

    assertTrue(Sortie.DEFAULT_NAME.equals(sortie.getName()));
    assertTrue(Sortie.DEFAULT_NOTE.equals(sortie.getNote()));

    assertFalse(sortie.isStunt1());
    assertFalse(sortie.isStunt2());
    assertFalse(sortie.isStunt3());
    assertFalse(sortie.isStunt4());
    assertFalse(sortie.isStunt5());
    assertFalse(sortie.isStunt6());
    assertFalse(sortie.isStunt7());
    assertFalse(sortie.isStunt8());
  }

  @Test
  public void installationUuidTest() {
    String target = testHelper.randomString();

    Sortie sortie = new Sortie();
    sortie.setInstallationUuid(target);
    assertTrue(target.equals(sortie.getInstallationUuid()));
  }

  @Test(expected=NullPointerException.class)
  public void nullInstallationUuidTest() {
    Sortie sortie = new Sortie();
    sortie.setInstallationUuid(null);
  }

  @Test
  public void sortieUuidTest() {
    String target = testHelper.randomString();

    Sortie sortie = new Sortie();
    sortie.setSortieUuid(target);
    assertTrue(target.equals(sortie.getSortieUuid()));
  }

  @Test(expected=NullPointerException.class)
  public void nullSortieUuidTest() {
    Sortie sortie = new Sortie();
    sortie.setSortieUuid(null);
  }

  @Test
  public void nameTest() {
    String target = testHelper.randomString();

    Sortie sortie = new Sortie();
    sortie.setName(target);
    assertTrue(target.equals(sortie.getName()));
  }

  @Test(expected=NullPointerException.class)
  public void nullNameTest() {
    Sortie sortie = new Sortie();
    sortie.setName(null);
  }

  @Test
  public void noteTest() {
    String target = testHelper.randomString();

    Sortie sortie = new Sortie();
    sortie.setNote(target);
    assertTrue(target.equals(sortie.getNote()));
  }

  @Test(expected=NullPointerException.class)
  public void nullNoteTest() {
    Sortie sortie = new Sortie();
    sortie.setNote(null);
  }

  @Test
  public void timeTest() {
    Date date = new Date();

    Sortie sortie = new Sortie();
    sortie.setTimeStamp(date);
    assertTrue(date.equals(sortie.getTimeStamp()));
  }

  @Test(expected=NullPointerException.class)
  public void nullTimeTest() {
    Sortie sortie = new Sortie();
    sortie.setTimeStamp(null);
  }

  @Test
  public void stuntTest() {
    Sortie sortie = new Sortie();

    sortie.setStunt1(true);
    assertTrue(sortie.isStunt1());
    sortie.setStunt1(false);
    assertFalse(sortie.isStunt1());

    sortie.setStunt2(true);
    assertTrue(sortie.isStunt2());
    sortie.setStunt2(false);
    assertFalse(sortie.isStunt2());

    sortie.setStunt3(true);
    assertTrue(sortie.isStunt3());
    sortie.setStunt3(false);
    assertFalse(sortie.isStunt3());

    sortie.setStunt4(true);
    assertTrue(sortie.isStunt4());
    sortie.setStunt4(false);
    assertFalse(sortie.isStunt4());

    sortie.setStunt5(true);
    assertTrue(sortie.isStunt5());
    sortie.setStunt5(false);
    assertFalse(sortie.isStunt5());

    sortie.setStunt6(true);
    assertTrue(sortie.isStunt6());
    sortie.setStunt6(false);
    assertFalse(sortie.isStunt6());

    sortie.setStunt7(true);
    assertTrue(sortie.isStunt7());
    sortie.setStunt7(false);
    assertFalse(sortie.isStunt7());

    sortie.setStunt8(true);
    assertTrue(sortie.isStunt8());
    sortie.setStunt8(false);
    assertFalse(sortie.isStunt8());
  }
}

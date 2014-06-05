package com.digiburo.mellow.heeler.entity;

import com.digiburo.mellow.heeler.TestHelper;
import org.junit.Test;

import java.util.Date;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

/**
 * Created by gsc on 6/4/14.
 */
public class ApplicationLogTest {
  private final TestHelper testHelper = new TestHelper();

  @Test
  public void testDefault() {
    ApplicationLog applicationLog = new ApplicationLog();

    assertNull(applicationLog.getTimeStamp());
    assertTrue(ApplicationLog.DEFAULT_NOTE.equals(applicationLog.getNote()));
  }

  @Test
  public void noteTest() {
    String target = testHelper.randomString();

    ApplicationLog applicationLog = new ApplicationLog();
    applicationLog.setNote(target);
    assertTrue(target.equals(applicationLog.getNote()));
  }

  @Test(expected=NullPointerException.class)
  public void nullNoteTest() {
    ApplicationLog applicationLog = new ApplicationLog();
    applicationLog.setNote(null);
  }

  @Test
  public void timeTest() {
    Date date = new Date();

    ApplicationLog applicationLog = new ApplicationLog();
    applicationLog.setTimeStamp(date);
    assertTrue(date.equals(applicationLog.getTimeStamp()));
  }

  @Test(expected=NullPointerException.class)
  public void nullTimeTest() {
    ApplicationLog applicationLog = new ApplicationLog();
    applicationLog.setTimeStamp(null);
  }
}

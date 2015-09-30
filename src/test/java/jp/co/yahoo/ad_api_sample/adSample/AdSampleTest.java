package jp.co.yahoo.ad_api_sample.adSample;

import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;

/**
 * Sample TestCase for AdSampleTest. Copyright (C) 2012 Yahoo Japan Corporation. All Rights
 * Reserved.
 */
public class AdSampleTest {

  @Before
  public void setup() {}

  /**
   * Sample TestCase of main method for AdSampleTest.
   */
  @Test
  public void testMain() throws Exception {
    // Run
    try {
      AdSample.main(null);
    } catch (Exception e) {
      fail();
    }
  }
}

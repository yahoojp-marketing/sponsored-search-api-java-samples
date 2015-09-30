package jp.co.yahoo.ad_api_sample.adDisplayOptionSample;

import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;

/**
 * Sample TestCase for AdDisplayOptionSampleTest. Copyright (C) 2012 Yahoo Japan Corporation. All
 * Rights Reserved.
 */
public class AdDisplayOptionSampleTest {

  @Before
  public void setup() {}

  /**
   * Sample TestCase of main method for AdDisplayOptionSample.
   */
  @Test
  public void testMain() throws Exception {
    // Run
    try {
      AdDisplayOptionSample.main(null);
    } catch (Exception e) {
      fail();
    }
  }
}

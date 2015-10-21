package jp.co.yahoo.ad_api_sample.adCustomizerSample;

import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;

/**
 * Sample TestCase for AdCustomizerSampleTest. Copyright (C) 2012 Yahoo Japan Corporation. All
 * Rights Reserved.
 */
public class AdCustomizerSampleTest {

  @Before
  public void setup() {}

  /**
   * Sample TestCase of main method for AdCustomizerSample.
   */
  @Test
  public void testMain() throws Exception {
    // Run
    try {
      AdCustomizerSample.main(null);
    } catch (Exception e) {
      fail();
    }
  }
}

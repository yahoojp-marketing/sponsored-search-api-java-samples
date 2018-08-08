package jp.co.yahoo.ad_api_sample.dynamicAdsForSearchSample;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.fail;

/**
 * Sample TestCase for DynamicAdsForSearchSampleTest. Copyright (C) 2012 Yahoo Japan Corporation. All Rights Reserved.
 */
public class DynamicAdsForSearchSampleTest {

  @Before
  public void setup() {
  }

  /**
   * Sample TestCase of main method for DynamicAdsForSearchSampleTest.
   */
  @Test
  public void testMain() throws Exception {
    // Run
    try {
      DynamicAdsForSearchSample.main(null);
    } catch (Exception e) {
      fail();
    }
  }

}

package jp.co.yahoo.ad_api_sample.siteRetargetingSample;

import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;

/**
 * Sample TestCase for SiteRetargetingSample. Copyright (C) 2012 Yahoo Japan Corporation. All Rights
 * Reserved.
 */
public class SiteRetargetingSampleTest {

  @Before
  public void setup() {}

  /**
   * Sample TestCase of main method for SiteRetargetingSampleTest.
   */
  @Test
  public void testMain() throws Exception {
    // Run
    try {
      SiteRetargetingSample.main(null);
    } catch (Exception e) {
      fail();
    }
  }
}

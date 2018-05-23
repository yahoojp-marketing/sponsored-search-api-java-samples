package jp.co.yahoo.ad_api_sample.structuredSnippetSample;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.fail;

/**
 * Sample TestCase for StructuredSnippetSample. Copyright (C) 2012 Yahoo Japan Corporation. All Rights
 * Reserved.
 */
public class StructuredSnippetSampleTest {

  @Before
  public void setup() {}

  /**
   * Sample TestCase of main method for StructuredSnippetSampleTest.
   */
  @Test
  public void testMain() throws Exception {
    // Run
    try {
      StructuredSnippetSample.main(null);
    } catch (Exception e) {
      fail();
    }
  }
}

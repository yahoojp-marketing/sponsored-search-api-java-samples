package jp.co.yahoo.ad_api_sample.keywordEstimatorSample;

import static org.junit.Assert.fail;

import org.junit.Test;

/**
 * Sample TestCase for KeywordEstimatorSample. Copyright (C) 2012 Yahoo Japan Corporation. All
 * Rights Reserved.
 */
public class KeywordEstimatorSampleTest {

  /**
   * Sample TestCase of main method for KeywordEstimatorSample.
   */
   @Test
   public void testMain() throws Exception {
     try{
       KeywordEstimatorSample.main(null);
     }catch(Exception e){
        fail();
     }
   }
}

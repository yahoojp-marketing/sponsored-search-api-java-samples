package jp.co.yahoo.ad_api_sample.trafficEstimatorSample;

import static org.junit.Assert.fail;

import org.junit.Test;

/**
 * Sample TestCase for TrafficEstimatorSample. Copyright (C) 2012 Yahoo Japan Corporation. All
 * Rights Reserved.
 */
public class TrafficEstimatorSampleTest {

  /**
   * Sample TestCase of main method for TrafficEstimatorSample.
   */
   @Test
   public void testMain() throws Exception {
     try{
       TrafficEstimatorSample.main(null);
     }catch(Exception e){
        fail();
     }
   }
}

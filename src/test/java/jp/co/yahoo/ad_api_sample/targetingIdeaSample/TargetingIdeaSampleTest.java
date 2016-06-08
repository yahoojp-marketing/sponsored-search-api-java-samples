package jp.co.yahoo.ad_api_sample.targetingIdeaSample;

import static org.junit.Assert.fail;

import org.junit.Test;

/**
 * Sample TestCase for TargetingIdeaSample. Copyright (C) 2012 Yahoo Japan Corporation. All Rights
 * Reserved.
 */
public class TargetingIdeaSampleTest {

  /**
   * Sample TestCase of main method for TargetingIdeaSample.
   */
   @Test
   public void testMain() throws Exception {
     try{
       TargetingIdeaSample.main(null);
     }catch(Exception e){
        fail();
     }
   }
}

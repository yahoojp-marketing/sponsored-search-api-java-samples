package jp.co.yahoo.ad_api_sample.reportDownloadSample;

import static org.junit.Assert.*;

import org.junit.Test;

public class ReportDownloadSampleTest {

   @Test
   public void testMain() throws Exception {
     try{
        ReportDownloadSample.main(null);
     }catch(Exception e){
        fail();
     }
   }
}

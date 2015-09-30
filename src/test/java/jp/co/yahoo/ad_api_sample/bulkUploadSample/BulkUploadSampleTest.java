package jp.co.yahoo.ad_api_sample.bulkUploadSample;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNot.not;
import static org.hamcrest.core.IsNull.notNullValue;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;

import java.util.List;

import jp.co.yahoo.ad_api_sample.util.SoapUtils;
import jp.yahooapis.ss.V5.BulkService.BulkEncoding;
import jp.yahooapis.ss.V5.BulkService.BulkLang;
import jp.yahooapis.ss.V5.BulkService.BulkOutput;
import jp.yahooapis.ss.V5.BulkService.BulkUploadStatusSelector;
import jp.yahooapis.ss.V5.BulkService.BulkUploadValues;
import jp.yahooapis.ss.V5.BulkService.Paging;
import jp.yahooapis.ss.V5.BulkService.UploadUrlValue;

import org.junit.Before;
import org.junit.Test;

/**
 * Sample TestCase for BulkUploadSampleTest. Copyright (C) 2012 Yahoo Japan Corporation. All Rights
 * Reserved.
 */
public class BulkUploadSampleTest {

  /**
   * Setting
   */
  private long accountId;

  @Before
  public void setup() {
    accountId = SoapUtils.getAccountId();
  }

  /**
   * Sample TestCase of main method for BulkUploadSample.
   */
  @Test
  public void testMain() throws Exception {
    // Run
    try {
      BulkUploadSample.main(null);
    } catch (Exception e) {
      fail();
    }
  }

  /**
   * Sample TestCase of main getUploadUrl for BulkUploadSample.
   */
  @Test
  public void testGetUploadUrl() throws Exception {
    // Run
    UploadUrlValue uploadUrlValue = null;
    try {
      uploadUrlValue = BulkUploadSample.getUploadUrl(accountId);
    } catch (Exception e) {
      fail();
    }

    // Assert
    assertThat(uploadUrlValue.isAcceptableUploadStatus(), is(true));
    assertThat(uploadUrlValue.getAccountId(), is(notNullValue()));
    assertThat(uploadUrlValue.getUploadUrl(), is(notNullValue()));
  }

  /**
   * Sample TestCase of main upload for BulkUploadSample.
   */
  @Test
  public void testUpload() throws Exception {
    // Run
    long uploadJobId = -1;
    try {
      UploadUrlValue uploadUrlValue = BulkUploadSample.getUploadUrl(accountId);
      uploadJobId = BulkUploadSample.upload(uploadUrlValue.getUploadUrl());
    } catch (Exception e) {
      fail();
    }

    // Assert
    assertThat(uploadJobId, is(not(-1)));
  }

  /**
   * Sample TestCase of main getBulkUploadStatus for BulkUploadSample.
   */
  @Test
  public void testGetBulkUploadStatus() throws Exception {
    // setup
    long uploadJobId = -1;
    try {
      UploadUrlValue uploadUrlValue = BulkUploadSample.getUploadUrl(accountId);
      uploadJobId = BulkUploadSample.upload(uploadUrlValue.getUploadUrl());
    } catch (Exception e) {
      fail();
    }

    // Set Selector
    BulkUploadStatusSelector selector = new BulkUploadStatusSelector();
    selector.setAccountId(accountId);
    selector.getUploadBulkJobIds().add(uploadJobId);
    selector.setLang(BulkLang.JA);
    selector.setOutput(BulkOutput.CSV);
    selector.setEncoding(BulkEncoding.SJIS);
    Paging paging = new Paging();
    paging.setStartIndex(1);
    paging.setNumberResults(20);
    selector.setPaging(paging);

    // Run
    List<BulkUploadValues> getBulkUploadpResponse = null;
    try {
      getBulkUploadpResponse = BulkUploadSample.getBulkUploadStatus(selector);
    } catch (Exception e) {
      fail();
    }

    // Assert
    for (BulkUploadValues bulkUploadValues : getBulkUploadpResponse) {
      assertThat(bulkUploadValues.isOperationSucceeded(), is(true));
      assertThat(bulkUploadValues.getUploadBulkJob().getAccountId(), is(notNullValue()));
    }
  }
}

package jp.co.yahoo.ad_api_sample.bulkDownloadSample;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNull.notNullValue;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;

import java.util.List;

import jp.co.yahoo.ad_api_sample.util.SoapUtils;
import jp.yahooapis.ss.V5.BulkService.ApprovalStatus;
import jp.yahooapis.ss.V5.BulkService.BulkDownloadSelector;
import jp.yahooapis.ss.V5.BulkService.BulkDownloadStatusSelector;
import jp.yahooapis.ss.V5.BulkService.BulkDownloadValues;
import jp.yahooapis.ss.V5.BulkService.BulkEncoding;
import jp.yahooapis.ss.V5.BulkService.BulkEntityType;
import jp.yahooapis.ss.V5.BulkService.BulkLang;
import jp.yahooapis.ss.V5.BulkService.BulkOutput;
import jp.yahooapis.ss.V5.BulkService.UserStatus;

import org.junit.Before;
import org.junit.Test;

/**
 * Sample TestCase for BulkDownloadSampleTest. Copyright (C) 2012 Yahoo Japan Corporation. All
 * Rights Reserved.
 */
public class BulkDownloadSampleTest {

  /**
   * Setting
   */
  private long accountId;

  @Before
  public void setup() {
    accountId = SoapUtils.getAccountId();
  }

  /**
   * Sample TestCase of main method for BulkDownloadSample.
   */
  @Test
  public void testMain() throws Exception {
    // Run
    try {
      BulkDownloadSample.main(null);
    } catch (Exception e) {
      fail();
    }
  }

  /**
   * Sample TestCase of getBulkDownload method for BulkDownloadSample.
   */
  @Test
  public void testGetBulkDownload() throws Exception {
    // Set Selector
    BulkDownloadSelector bulkDownloadSelector = new BulkDownloadSelector();
    bulkDownloadSelector.setAccountId(accountId);
    bulkDownloadSelector.getCampaignUserStatuses().add(UserStatus.ACTIVE);
    bulkDownloadSelector.getAdGroupUserStatuses().add(UserStatus.ACTIVE);
    bulkDownloadSelector.getAdGroupAdUserStatuses().add(UserStatus.ACTIVE);
    bulkDownloadSelector.getAdGroupAdApprovalStatuses().add(ApprovalStatus.APPROVED);
    bulkDownloadSelector.getEntityTypes().add(BulkEntityType.ALL);
    bulkDownloadSelector.setLang(BulkLang.JA);
    bulkDownloadSelector.setEncoding(BulkEncoding.SJIS);
    bulkDownloadSelector.setOutput(BulkOutput.CSV);

    // Run
    List<BulkDownloadValues> getBulkDownloadResponse = null;
    try {
      getBulkDownloadResponse = BulkDownloadSample.getBulkDownload(bulkDownloadSelector);
    } catch (Exception e) {
      fail();
    }

    // Assert
    for (BulkDownloadValues bulkDownloadValues : getBulkDownloadResponse) {
      assertThat(bulkDownloadValues.isOperationSucceeded(), is(true));
      assertThat(bulkDownloadValues.getDownloadBulkJob().getAccountId(), is(notNullValue()));
    }
  }

  /**
   * Sample TestCase of getBulkDownloadStatus method for BulkDownloadSample.
   */
  @Test
  public void testGetBulkDownloadStatus() throws Exception {
    // =================================================================
    // BulkService::getBulkDownload
    // =================================================================
    // Set Selector
    BulkDownloadSelector bulkDownloadSelector = new BulkDownloadSelector();
    bulkDownloadSelector.setAccountId(accountId);
    bulkDownloadSelector.getCampaignUserStatuses().add(UserStatus.ACTIVE);
    bulkDownloadSelector.getAdGroupUserStatuses().add(UserStatus.ACTIVE);
    bulkDownloadSelector.getAdGroupAdUserStatuses().add(UserStatus.ACTIVE);
    bulkDownloadSelector.getAdGroupAdApprovalStatuses().add(ApprovalStatus.APPROVED);
    bulkDownloadSelector.getEntityTypes().add(BulkEntityType.ALL);
    bulkDownloadSelector.setLang(BulkLang.JA);
    bulkDownloadSelector.setEncoding(BulkEncoding.SJIS);
    bulkDownloadSelector.setOutput(BulkOutput.CSV);

    // Run
    List<BulkDownloadValues> getBulkDownloadResponse = null;
    try {
      getBulkDownloadResponse = BulkDownloadSample.getBulkDownload(bulkDownloadSelector);
    } catch (Exception e) {
      fail();
    }

    // =================================================================
    // BulkService::getBulkDownloadStatus
    // =================================================================
    // Set Selector
    BulkDownloadStatusSelector bulkDownloadStatusSelector = new BulkDownloadStatusSelector();
    bulkDownloadStatusSelector.setAccountId(accountId);
    bulkDownloadStatusSelector.getDownloadBulkJobIds().add(Long.valueOf(getBulkDownloadResponse.get(0).getDownloadBulkJob().getDownloadBulkJobId()));

    // Run
    List<BulkDownloadValues> getBulkDownloadStatusResponse = null;
    try {
      getBulkDownloadStatusResponse = BulkDownloadSample.getBulkDownloadStatus(bulkDownloadStatusSelector);
    } catch (Exception e) {
      fail();
    }

    // Assert
    for (BulkDownloadValues bulkDownloadValues : getBulkDownloadStatusResponse) {
      assertThat(bulkDownloadValues.isOperationSucceeded(), is(true));
      assertThat(bulkDownloadValues.getDownloadBulkJob().getAccountId(), is(notNullValue()));
    }
  }
}

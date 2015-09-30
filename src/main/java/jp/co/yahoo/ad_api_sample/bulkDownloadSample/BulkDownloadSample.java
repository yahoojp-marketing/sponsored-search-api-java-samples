package jp.co.yahoo.ad_api_sample.bulkDownloadSample;

import java.util.List;

import javax.xml.ws.Holder;

import jp.co.yahoo.ad_api_sample.error.impl.BulkServiceErrorEntityFactory;
import jp.co.yahoo.ad_api_sample.util.SoapUtils;
import jp.yahooapis.ss.V5.BulkService.ApprovalStatus;
import jp.yahooapis.ss.V5.BulkService.BulkDownloadReturnValue;
import jp.yahooapis.ss.V5.BulkService.BulkDownloadSelector;
import jp.yahooapis.ss.V5.BulkService.BulkDownloadStatusPage;
import jp.yahooapis.ss.V5.BulkService.BulkDownloadStatusSelector;
import jp.yahooapis.ss.V5.BulkService.BulkDownloadValues;
import jp.yahooapis.ss.V5.BulkService.BulkEncoding;
import jp.yahooapis.ss.V5.BulkService.BulkEntityType;
import jp.yahooapis.ss.V5.BulkService.BulkLang;
import jp.yahooapis.ss.V5.BulkService.BulkOutput;
import jp.yahooapis.ss.V5.BulkService.BulkService;
import jp.yahooapis.ss.V5.BulkService.BulkServiceInterface;
import jp.yahooapis.ss.V5.BulkService.DownloadBulkJob;
import jp.yahooapis.ss.V5.BulkService.DownloadBulkJobStatus;
import jp.yahooapis.ss.V5.BulkService.Error;
import jp.yahooapis.ss.V5.BulkService.UserStatus;

/**
 * Sample Program for Bulk Download. Copyright (C) 2012 Yahoo Japan Corporation. All Rights
 * Reserved.
 */
public class BulkDownloadSample {

  /**
   * main method for BulkDownloadSample
   * 
   * @param args command line arguments
   * @exception Exception
   */
  public static void main(String[] args) throws Exception {
    try {
      // =================================================================
      // Setting
      // =================================================================
      long accountId = SoapUtils.getAccountId();

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
      List<BulkDownloadValues> getBulkDownloadResponse = getBulkDownload(bulkDownloadSelector);

      // =================================================================
      // BulkService::getBulkDownloadStatus
      // =================================================================
      // Set Selector
      BulkDownloadStatusSelector bulkDownloadStatusSelector = new BulkDownloadStatusSelector();
      bulkDownloadStatusSelector.setAccountId(accountId);
      bulkDownloadStatusSelector.getDownloadBulkJobIds().add(Long.valueOf(getBulkDownloadResponse.get(0).getDownloadBulkJob().getDownloadBulkJobId()));

      // Run
      List<BulkDownloadValues> getBulkDownloadStatusResponse = getBulkDownloadStatus(bulkDownloadStatusSelector);

      // =================================================================
      // download bulk
      // =================================================================
      // filename
      String bulkDownloadFileName = null;
      if (bulkDownloadSelector.getOutput().equals(BulkOutput.ZIPPED_CSV)) {
        bulkDownloadFileName = "BulkDownload_" + "_" + getBulkDownloadResponse.get(0).getDownloadBulkJob().getDownloadBulkJobId() + ".zip";
      } else {
        bulkDownloadFileName = "BulkDownload_" + "_" + getBulkDownloadResponse.get(0).getDownloadBulkJob().getDownloadBulkJobId() + ".csv";
      }

      // execute
      downloadBulk(getBulkDownloadStatusResponse.get(0), bulkDownloadFileName);

    } catch (Exception e) {
      e.printStackTrace();
      throw e;
    }
  }

  /**
   * Sample Program for BulkDownloadService GetBulkDownload.
   * 
   * @param selector BulkDownloadSelector
   * @return BulkDownloadValues
   * @throws Exception
   */
  public static List<BulkDownloadValues> getBulkDownload(BulkDownloadSelector selector) throws Exception {

    // call API
    System.out.println("############################################");
    System.out.println("BulkService::getBulkDownload");
    System.out.println("############################################");

    Holder<BulkDownloadReturnValue> bulkDownloadReturnValueHolder = new Holder<BulkDownloadReturnValue>();
    Holder<List<Error>> bulkDownloadError = new Holder<List<Error>>();
    BulkServiceInterface bulkService = SoapUtils.createServiceInterface(BulkServiceInterface.class, BulkService.class);
    bulkService.getBulkDownload(selector, bulkDownloadReturnValueHolder, bulkDownloadError);

    // Error
    if (bulkDownloadError.value != null && bulkDownloadError.value.size() > 0) {
      SoapUtils.displayErrors(new BulkServiceErrorEntityFactory(bulkDownloadError.value), true);
    }
    if (bulkDownloadError.value == null) {
      throw new Exception("NoDataResponse:BulkDownloadService GetBulkDownload");
    }

    // Display
    for (BulkDownloadValues bulkDownloadValues : bulkDownloadReturnValueHolder.value.getValues()) {
      if (bulkDownloadValues.isOperationSucceeded()) {
        display(bulkDownloadValues.getDownloadBulkJob());
      } else {
        SoapUtils.displayErrors(new BulkServiceErrorEntityFactory(bulkDownloadError.value), true);
      }
    }

    // Response
    return bulkDownloadReturnValueHolder.value.getValues();
  }

  /**
   * Sample Program for BulkDownloadService GetBulkDownloadStatus.
   * 
   * @param selector BulkDownloadStatusSelector
   * @return BulkDownloadValues
   * @throws Exception
   */
  public static List<BulkDownloadValues> getBulkDownloadStatus(BulkDownloadStatusSelector selector) throws Exception {

    // call 30sec sleep * 30 = 15minute
    Holder<BulkDownloadStatusPage> bulkDownloadStatusPageHolder = null;
    Holder<List<Error>> bulkDownloadStatusError = null;
    DownloadBulkJobStatus jobStatus = null;
    for (int i = 0; i < 30; i++) {

      // sleep 30 second.
      System.out.println("\n***** sleep 30 seconds for Bulk Download Job *****\n");
      Thread.sleep(300);

      // call API
      System.out.println("############################################");
      System.out.println("BulkService::getBulkDownloadStatus");
      System.out.println("############################################");

      bulkDownloadStatusPageHolder = new Holder<BulkDownloadStatusPage>();
      bulkDownloadStatusError = new Holder<List<Error>>();
      BulkServiceInterface bulkService = SoapUtils.createServiceInterface(BulkServiceInterface.class, BulkService.class);
      bulkService.getBulkDownloadStatus(selector, bulkDownloadStatusPageHolder, bulkDownloadStatusError);

      // Error
      if (bulkDownloadStatusError.value != null && bulkDownloadStatusError.value.size() > 0) {
        SoapUtils.displayErrors(new BulkServiceErrorEntityFactory(bulkDownloadStatusError.value), true);
      }
      if (bulkDownloadStatusError.value == null) {
        throw new Exception("NoDataResponse:BulkDownloadService GetBulkDownloadStatus");
      }

      // Display
      if (bulkDownloadStatusPageHolder.value.getValues().get(0).isOperationSucceeded()) {
        display(bulkDownloadStatusPageHolder.value.getValues().get(0).getDownloadBulkJob());

        // status
        jobStatus = bulkDownloadStatusPageHolder.value.getValues().get(0).getDownloadBulkJob().getDownloadJobStatus();
        if (jobStatus.equals(DownloadBulkJobStatus.COMPLETED)) {
          break;
        } else {
          if (jobStatus.equals(DownloadBulkJobStatus.IN_PROGRESS)) {
            continue;
          } else {
            System.out.println("Error : Job Status failed.");
            System.exit(0);
          }
        }

      } else {
        SoapUtils.displayErrors(new BulkServiceErrorEntityFactory(bulkDownloadStatusError.value), true);
      }
    }

    // Response
    return bulkDownloadStatusPageHolder.value.getValues();
  }

  /**
   * download bulk.
   * 
   * @param getBulkDownloadStatusResponse BulkDownloadValues
   * @param bulkDownloadFileName String
   * @throws Exception
   */
  public static void downloadBulk(BulkDownloadValues getBulkDownloadStatusResponse, String bulkDownloadFileName) throws Exception {

    // check status
    if (getBulkDownloadStatusResponse.getDownloadBulkJob().getDownloadJobStatus() != null && bulkDownloadFileName != null) {
      SoapUtils.download(getBulkDownloadStatusResponse.getDownloadBulkJob().getDownloadBulkDownloadUrl(), bulkDownloadFileName);
    } else {
      System.out.println("BulkDownload job in process on long time. please wait.");
    }
  }

  /**
   * display downloadBulkJob entity to stdout.
   *
   * @param values DownloadBulkJob entity for display.
   */
  private static void display(DownloadBulkJob downloadBulkJob) {
    System.out.println("accountId = " + downloadBulkJob.getAccountId());
    System.out.println("downloadBulkJobId = " + downloadBulkJob.getDownloadBulkJobId());
    System.out.println("downloadBulkJobName = " + downloadBulkJob.getDownloadBulkJobName());
    System.out.println("downloadBulkUserName = " + downloadBulkJob.getDownloadBulkUserName());
    System.out.println("downloadBulkStartDate = " + downloadBulkJob.getDownloadBulkStartDate());
    System.out.println("downloadJobStatus = " + downloadBulkJob.getDownloadJobStatus());
    System.out.println("progress = " + downloadBulkJob.getProgress());
    System.out.println("---------");
  }
}

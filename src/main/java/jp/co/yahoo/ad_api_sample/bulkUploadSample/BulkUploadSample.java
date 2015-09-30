package jp.co.yahoo.ad_api_sample.bulkUploadSample;

import java.io.StringReader;
import java.util.List;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.ws.Holder;

import jp.co.yahoo.ad_api_sample.error.impl.BulkServiceErrorEntityFactory;
import jp.co.yahoo.ad_api_sample.util.SoapUtils;
import jp.yahooapis.ss.V5.BulkService.BulkEncoding;
import jp.yahooapis.ss.V5.BulkService.BulkLang;
import jp.yahooapis.ss.V5.BulkService.BulkOutput;
import jp.yahooapis.ss.V5.BulkService.BulkService;
import jp.yahooapis.ss.V5.BulkService.BulkServiceInterface;
import jp.yahooapis.ss.V5.BulkService.BulkUploadStatusPage;
import jp.yahooapis.ss.V5.BulkService.BulkUploadStatusSelector;
import jp.yahooapis.ss.V5.BulkService.BulkUploadValues;
import jp.yahooapis.ss.V5.BulkService.Error;
import jp.yahooapis.ss.V5.BulkService.Paging;
import jp.yahooapis.ss.V5.BulkService.UploadBulkJob;
import jp.yahooapis.ss.V5.BulkService.UploadBulkJobStatus;
import jp.yahooapis.ss.V5.BulkService.UploadUrlValue;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;


/**
 * Sample Program for Bulk Upload. Copyright (C) 2012 Yahoo Japan Corporation. All Rights Reserved.
 */
public class BulkUploadSample {

  /**
   * main method for BulkUploadSample
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
      // BulkService::getUploadUrl
      // =================================================================
      // Run
      UploadUrlValue uploadUrlValue = getUploadUrl(accountId);

      // =================================================================
      // BulkService::upload
      // =================================================================
      // Run
      long uploadJobId = upload(uploadUrlValue.getUploadUrl());

      // =================================================================
      // BulkService::getBulkUploadStatus
      // =================================================================
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
      List<BulkUploadValues> getBulkUploadStatusResponse = getBulkUploadStatus(selector);

      // =================================================================
      // download bulk
      // =================================================================
      // execute
      downloadBulk(getBulkUploadStatusResponse.get(0));

    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  /**
   * Sample Program for BulkUploadService GetUploadUrl.
   * 
   * @param accountId long
   * @return UploadUrlValue
   * @throws Exception
   */
  public static UploadUrlValue getUploadUrl(long accountId) throws Exception {

    // call API
    System.out.println("############################################");
    System.out.println("BulkService::getUploadUrl");
    System.out.println("############################################");

    Holder<UploadUrlValue> getUploadUrlValueHolder = new Holder<UploadUrlValue>();
    Holder<List<Error>> getUploadUrlErrorHolder = new Holder<List<Error>>();
    BulkServiceInterface bulkService = SoapUtils.createServiceInterface(BulkServiceInterface.class, BulkService.class);
    bulkService.getUploadUrl(accountId, getUploadUrlValueHolder, getUploadUrlErrorHolder);

    // Error
    if (getUploadUrlErrorHolder.value != null && getUploadUrlErrorHolder.value.size() > 0) {
      SoapUtils.displayErrors(new BulkServiceErrorEntityFactory(getUploadUrlErrorHolder.value), true);
    }
    if (getUploadUrlErrorHolder.value == null) {
      throw new Exception("NoDataResponse:BulkDownloadService GetBulkDownload");
    }

    // Display
    String uploadUrlStr = null;
    if (getUploadUrlValueHolder.value.isAcceptableUploadStatus()) {
      displayGetUploadUrlResponse(getUploadUrlValueHolder.value);
    } else {
      System.out.println("AcceptableUploadStatus is false at this accountId. Please wait a minute.");
      System.exit(0);
    }

    return getUploadUrlValueHolder.value;
  }

  /**
   * Sample Program for BulkUploadService Upload.
   * 
   * @param uploadUrl String
   * @return uploadJobId long
   * @throws Exception
   */
  public static long upload(String uploadUrl) throws Exception {

    // file upload
    System.out.println("############################################");
    System.out.println("BulkService::upload");
    System.out.println("############################################");

    String response = SoapUtils.upload(uploadUrl, "SampleBulkUpload.csv", "text/csv");

    // get upload bulk job ID
    long uploadJobId = -1;
    Document responseDOM = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(new InputSource(new StringReader(response)));
    NodeList nodeList = responseDOM.getElementsByTagName("uploadBulkJobId");
    if (nodeList.getLength() > 0) {
      uploadJobId = Long.parseLong(nodeList.item(0).getFirstChild().getNodeValue());
      System.out.println("uploadJobId = " + uploadJobId);
      System.out.println("----------");
    } else {
      throw new RuntimeException("Fail to upload to Bulk. response=" + response);
    }

    // return
    return uploadJobId;
  }

  /**
   * Sample Program for BulkUploadService GetBulkUploadStatus.
   * 
   * @param selector BulkUploadStatusSelector
   * @return BulkUploadValues
   * @throws Exception
   */
  public static List<BulkUploadValues> getBulkUploadStatus(BulkUploadStatusSelector selector) throws Exception {

    // call 30sec sleep * 30 = 15minute
    Holder<BulkUploadStatusPage> getBulkUploadStatusPageHolder = null;
    Holder<List<Error>> getBulkUploadStatusErrorHolder = null;
    Holder<List<Error>> getUploadUrlErrorHolder = null;
    UploadBulkJobStatus jobStatus = null;
    for (int i = 0; i < 30; i++) {

      // sleep 30 second.
      System.out.println("\n***** sleep 30 seconds for Bulk Upload Job *****\n");
      Thread.sleep(30000);

      // call API
      System.out.println("############################################");
      System.out.println("BulkService::getBulkUploadStatus");
      System.out.println("############################################");

      getBulkUploadStatusPageHolder = new Holder<BulkUploadStatusPage>();
      getBulkUploadStatusErrorHolder = new Holder<List<Error>>();
      getUploadUrlErrorHolder = new Holder<List<Error>>();
      BulkServiceInterface bulkService = SoapUtils.createServiceInterface(BulkServiceInterface.class, BulkService.class);
      bulkService.getBulkUploadStatus(selector, getBulkUploadStatusPageHolder, getBulkUploadStatusErrorHolder);

      // Error
      if (getBulkUploadStatusErrorHolder.value != null && getBulkUploadStatusErrorHolder.value.size() > 0) {
        SoapUtils.displayErrors(new BulkServiceErrorEntityFactory(getUploadUrlErrorHolder.value), true);
      }
      if (getBulkUploadStatusErrorHolder.value == null) {
        throw new Exception("NoDataResponse:BulkDownloadService GetBulkUploadStatus");
      }

      // Display
      if (getBulkUploadStatusPageHolder.value.getValues().get(0).isOperationSucceeded()) {
        display(getBulkUploadStatusPageHolder.value.getValues().get(0).getUploadBulkJob());

        // status
        jobStatus = getBulkUploadStatusPageHolder.value.getValues().get(0).getUploadBulkJob().getUploadBulkJobStatus();
        if (jobStatus.equals(UploadBulkJobStatus.COMPLETED)) {
          System.out.println("\nSuccess to upload Bulk Sheet.");
          break;
        } else {
          if (jobStatus.equals(UploadBulkJobStatus.IN_PROGRESS)) {
            continue;
          } else {
            System.out.println("\nError : Job Status failed.");
            System.exit(0);
          }
        }

      } else {
        SoapUtils.displayErrors(new BulkServiceErrorEntityFactory(getUploadUrlErrorHolder.value), true);
      }
    }

    // Response
    return getBulkUploadStatusPageHolder.value.getValues();
  }

  /**
   * download bulk.
   * 
   * @param getBulkUploadStatusResponse BulkUploadValues
   * @throws Exception
   */
  public static void downloadBulk(BulkUploadValues getBulkUploadStatusResponse) throws Exception {

    // check status
    if (getBulkUploadStatusResponse.getUploadBulkJob().getUploadBulkJobStatus() != null) {

      // -----------------------------------------------
      // BulkService::downloadBulkUploadFile
      // -----------------------------------------------
      if (getBulkUploadStatusResponse.getUploadBulkJob().getDownloadBulkUploadFileUrl() != null) {
        System.out.println("\n############################################");
        System.out.println("BulkService::downloadBulkUploadFile");
        System.out.println("############################################");
        SoapUtils.download(getBulkUploadStatusResponse.getUploadBulkJob().getDownloadBulkUploadFileUrl(), "SampleBulkUploadFile.csv");
      }

      // -----------------------------------------------
      // BulkService::downloadBulkUploadErrorFile
      // -----------------------------------------------
      if (getBulkUploadStatusResponse.getUploadBulkJob().getDownloadBulkUploadErrorFileUrl() != null) {
        System.out.println("\n############################################");
        System.out.println("BulkService::downloadBulkUploadErrorFile");
        System.out.println("############################################");
        SoapUtils.download(getBulkUploadStatusResponse.getUploadBulkJob().getDownloadBulkUploadErrorFileUrl(), "SampleBulkUploadErrorFile.csv");
      }

    } else {
      System.out.println("BulkUpload job in process on long time. please wait.");
    }
  }

  /**
   * display uploadUrlValue entity to stdout.
   *
   * @param values UploadUrlValue entity for display.
   */
  private static void displayGetUploadUrlResponse(UploadUrlValue uploadUrlValue) {
    System.out.println("accountId = " + uploadUrlValue.getAccountId());
    System.out.println("uploadUrl = " + uploadUrlValue.getUploadUrl());
    System.out.println("acceptableUploadStatus = " + uploadUrlValue.isAcceptableUploadStatus());
    if (!uploadUrlValue.isAcceptableUploadStatus()) {
      System.out.println("AcceptableUploadStatus is false at this accountId. Please wait a minute.");
      System.exit(0);
    }
    System.out.println("----------");
  }

  /**
   * display uploadBulkJob entity to stdout.
   *
   * @param values UploadBulkJob entity for display.
   */
  private static void display(UploadBulkJob uploadBulkJob) {
    System.out.println("accountId = " + uploadBulkJob.getAccountId());
    System.out.println("uploadBulkJobId = " + uploadBulkJob.getUploadBulkJobId());
    System.out.println("uploadBulkJobName = " + uploadBulkJob.getUploadBulkJobName());
    System.out.println("uploadBulkUserName = " + uploadBulkJob.getUploadBulkUserName());
    System.out.println("uploadBulkStartDate = " + uploadBulkJob.getUploadBulkStartDate());
    System.out.println("uploadBulkEndDate = " + uploadBulkJob.getUploadBulkEndDate());
    System.out.println("uploadBulkJobStatus = " + uploadBulkJob.getUploadBulkJobStatus());
    System.out.println("progress = " + uploadBulkJob.getProgress());
    if (uploadBulkJob.getProcessingItemsCount() != null) {
      System.out.println("processingItemsCount/campaignCount = " + uploadBulkJob.getProcessingItemsCount().getCampaignCount());
      System.out.println("processingItemsCount/campaignErrorCount = " + uploadBulkJob.getProcessingItemsCount().getCampaignErrorCount());
      System.out.println("processingItemsCount/negativeCampaignCriterionCount = " + uploadBulkJob.getProcessingItemsCount().getNegativeCampaignCriterionCount());
      System.out.println("processingItemsCount/negativeCampaignCriterionErrorCount = " + uploadBulkJob.getProcessingItemsCount().getNegativeCampaignCriterionErrorCount());
      System.out.println("processingItemsCount/adGroupCount = " + uploadBulkJob.getProcessingItemsCount().getAdGroupCount());
      System.out.println("processingItemsCount/adGroupErrorCount = " + uploadBulkJob.getProcessingItemsCount().getAdGroupErrorCount());
      System.out.println("processingItemsCount/negativeAdGroupCriterionCount = " + uploadBulkJob.getProcessingItemsCount().getNegativeAdGroupCriterionCount());
      System.out.println("processingItemsCount/negativeAdGroupCriterionErrorCount = " + uploadBulkJob.getProcessingItemsCount().getNegativeAdGroupCriterionErrorCount());
      System.out.println("processingItemsCount/biddableAdGroupCriterionCount = " + uploadBulkJob.getProcessingItemsCount().getBiddableAdGroupCriterionCount());
      System.out.println("processingItemsCount/biddableAdGroupCriterionErrorCount = " + uploadBulkJob.getProcessingItemsCount().getBiddableAdGroupCriterionErrorCount());
      System.out.println("processingItemsCount/adGroupAdCount = " + uploadBulkJob.getProcessingItemsCount().getAdGroupAdCount());
      System.out.println("processingItemsCount/adGroupAdErrorCount = " + uploadBulkJob.getProcessingItemsCount().getAdGroupAdErrorCount());
    }
    if (uploadBulkJob.getDownloadBulkUploadFileUrl() != null) {
      System.out.println("downloadBulkUploadFileUrl = " + uploadBulkJob.getDownloadBulkUploadFileUrl());
    }
    if (uploadBulkJob.getDownloadBulkUploadErrorFileUrl() != null) {
      System.out.println("downloadBulkUploadErrorFileUrl = " + uploadBulkJob.getDownloadBulkUploadErrorFileUrl());
    }
    System.out.println("----------");
  }
}

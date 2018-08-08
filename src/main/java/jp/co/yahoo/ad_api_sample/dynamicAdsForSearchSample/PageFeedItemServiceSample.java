package jp.co.yahoo.ad_api_sample.dynamicAdsForSearchSample;

import com.fasterxml.jackson.databind.ObjectMapper;

import jp.co.yahoo.ad_api_sample.adCustomizerSample.FeedFolderServiceSample;
import jp.co.yahoo.ad_api_sample.error.impl.PageFeedItemServiceErrorEntityFactory;
import jp.co.yahoo.ad_api_sample.util.SoapUtils;
import jp.yahooapis.ss.v201808.Error;
import jp.yahooapis.ss.v201808.feedfolder.FeedFolderOperation;
import jp.yahooapis.ss.v201808.feedfolder.FeedFolderPlaceholderType;
import jp.yahooapis.ss.v201808.feedfolder.FeedFolderValues;
import jp.yahooapis.ss.v201808.pagefeeditem.BulkEncoding;
import jp.yahooapis.ss.v201808.pagefeeditem.PageFeedItemDownloadJob;
import jp.yahooapis.ss.v201808.pagefeeditem.PageFeedItemDownloadJobOperation;
import jp.yahooapis.ss.v201808.pagefeeditem.PageFeedItemDownloadJobReturnValue;
import jp.yahooapis.ss.v201808.pagefeeditem.PageFeedItemDownloadJobStatus;
import jp.yahooapis.ss.v201808.pagefeeditem.PageFeedItemDownloadJobValues;
import jp.yahooapis.ss.v201808.pagefeeditem.PageFeedItemJob;
import jp.yahooapis.ss.v201808.pagefeeditem.PageFeedItemJobStatusPage;
import jp.yahooapis.ss.v201808.pagefeeditem.PageFeedItemJobStatusSelector;
import jp.yahooapis.ss.v201808.pagefeeditem.PageFeedItemJobType;
import jp.yahooapis.ss.v201808.pagefeeditem.PageFeedItemJobValues;
import jp.yahooapis.ss.v201808.pagefeeditem.PageFeedItemPage;
import jp.yahooapis.ss.v201808.pagefeeditem.PageFeedItemReturnValues;
import jp.yahooapis.ss.v201808.pagefeeditem.PageFeedItemReviewSummaryPage;
import jp.yahooapis.ss.v201808.pagefeeditem.PageFeedItemReviewSummarySelector;
import jp.yahooapis.ss.v201808.pagefeeditem.PageFeedItemReviewSummaryValues;
import jp.yahooapis.ss.v201808.pagefeeditem.PageFeedItemSelector;
import jp.yahooapis.ss.v201808.pagefeeditem.PageFeedItemServiceInterface;
import jp.yahooapis.ss.v201808.pagefeeditem.PageFeedItemServiceService;
import jp.yahooapis.ss.v201808.pagefeeditem.PageFeedItemUploadJob;
import jp.yahooapis.ss.v201808.pagefeeditem.PageFeedItemUploadJobStatus;
import jp.yahooapis.ss.v201808.pagefeeditem.PageFeedItemUploadType;
import jp.yahooapis.ss.v201808.pagefeeditem.PageFeedItemUploadUrl;
import jp.yahooapis.ss.v201808.pagefeeditem.PageFeedItemUploadUrlOperation;
import jp.yahooapis.ss.v201808.pagefeeditem.PageFeedItemUploadUrlPage;
import jp.yahooapis.ss.v201808.pagefeeditem.PageFeedItemUploadUrlValues;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import javax.xml.ws.Holder;

/**
 * Sample Program for PageFeedItemService. Copyright (C) 2012 Yahoo Japan Corporation. All Rights Reserved.
 */
public class PageFeedItemServiceSample {
  /**
   * main method for PageFeedItemService
   *
   * @param args command line arguments
   */
  public static void main(String[] args) throws Exception {
    try {
      // =================================================================
      // Setting
      // =================================================================
      long accountId = SoapUtils.getAccountId();
      long feedFolderId = -1L;
      String uploadUrl = null;
      String downloadUrl = null;
      String fileName = "pageFeedItemUploadSample.csv";

      // =================================================================
      // FeedFolderService ADD FOR DSA
      // =================================================================
      FeedFolderOperation addFeedFolderOperation = FeedFolderServiceSample.createSampleDasAddRequest(null, accountId);
      List<FeedFolderValues> feedFolderValues = FeedFolderServiceSample.add(addFeedFolderOperation);
      for (FeedFolderValues values : feedFolderValues) {
        if (values.getFeedFolder().getPlaceholderType().equals(FeedFolderPlaceholderType.DYNAMIC_AD_FOR_SEARCH_PAGE_FEEDS)) {
          feedFolderId = values.getFeedFolder().getFeedFolderId();
        }
      }

      //=================================================================
      // PageFeedItemService
      //=================================================================
      // getUploadUrl
      PageFeedItemUploadUrlOperation pageFeedItemUploadUrlOperation = createSampleUploadRequest(accountId, feedFolderId);
      PageFeedItemUploadUrlPage pageFeedItemUploadUrlPage = getUploadUrl(pageFeedItemUploadUrlOperation);
      for (PageFeedItemUploadUrlValues value : pageFeedItemUploadUrlPage.getValues()) {
        uploadUrl = value.getUploadUrl().getUrl();
      }

      // upload
      // call API
      long uploadJobId = upload(uploadUrl, fileName);

      // checkJobStatus
      PageFeedItemJobStatusSelector pageFeedItemJobStatusSelector = createGetJobStatusRequest(accountId, PageFeedItemJobType.UPLOAD, uploadJobId);
      checkJobStatus(pageFeedItemJobStatusSelector);

      // getReviewSummary
      PageFeedItemReviewSummarySelector pageFeedItemReviewSummarySelector = createGetReviewSummaryRequest(accountId, Arrays.asList(feedFolderId));
      List<PageFeedItemReviewSummaryValues> reviewSummaryValues = getReviewSummary(pageFeedItemReviewSummarySelector);

      // get
      PageFeedItemSelector pageFeedItemSelector = createGetRequest(accountId, Arrays.asList(feedFolderId));
      List<PageFeedItemReturnValues> getValues = get(pageFeedItemSelector);

      // addDownloadJob
      PageFeedItemDownloadJobOperation operation = createAddDownloadJobRequest(accountId, feedFolderId);
      List<PageFeedItemDownloadJobValues> pageFeedItemDownloadJobValues = addDownloadJob(operation);
      long jobId = -1L;
      for (PageFeedItemDownloadJobValues values : pageFeedItemDownloadJobValues) {
        jobId = values.getJob().getJobId();
      }

      // checkJobStatus
      pageFeedItemJobStatusSelector = createGetJobStatusRequest(accountId, PageFeedItemJobType.DOWNLOAD, jobId);
      List<PageFeedItemJobValues> pageFeedItemJobValues = checkJobStatus(pageFeedItemJobStatusSelector);
      // downloadUrl取得
      for (PageFeedItemJobValues values : pageFeedItemJobValues) {
        if (values.getJob() instanceof PageFeedItemDownloadJob) {
          downloadUrl = ((PageFeedItemDownloadJob) values.getJob()).getDownloadUrl();
        }
      }

      // download
      download(downloadUrl, fileName);

      //=================================================================
      // remove FeedFolderService
      //=================================================================
      // FeedFolderService
      FeedFolderOperation removeFeedFolderOperation = FeedFolderServiceSample.createSampleRemoveRequest(accountId, feedFolderValues);
      FeedFolderServiceSample.remove(removeFeedFolderOperation);


    } catch (Exception e) {
      e.printStackTrace();
      throw e;
    }
  }

  /**
   * create sample request.
   *
   * @param accountId    Account ID
   * @param feedFolderId FeedFolderID
   * @return PageFeedItemUploadUrlOperation
   */
  public static PageFeedItemUploadUrlOperation createSampleUploadRequest(long accountId, long feedFolderId) {
    // Set Operation
    PageFeedItemUploadUrlOperation operation = new PageFeedItemUploadUrlOperation();
    operation.setAccountId(accountId);
    PageFeedItemUploadUrl pageFeedItemUploadUrl = new PageFeedItemUploadUrl();
    pageFeedItemUploadUrl.setFeedFolderId(feedFolderId);
    pageFeedItemUploadUrl.setUploadType(PageFeedItemUploadType.NEW_OR_REPLACE);
    operation.getOperand().add(pageFeedItemUploadUrl);

    return operation;
  }

  /**
   * create sample request.
   *
   * @param accountId   Account ID
   * @param jobType     PageFeedItemJobType
   * @param uploadJobId UploadJobId
   * @return PageFeedItemUploadUrlOperation
   */
  public static PageFeedItemJobStatusSelector createGetJobStatusRequest(long accountId, PageFeedItemJobType jobType, long uploadJobId) {
    // Set selector
    PageFeedItemJobStatusSelector selector = new PageFeedItemJobStatusSelector();
    selector.setAccountId(accountId);
    selector.getJobIds().add(uploadJobId);
    selector.setJobType(jobType);

    return selector;
  }

  /**
   * create sample request.
   *
   * @param accountId     Account ID
   * @param feedFolderIds List<Long>
   * @return PageFeedItemReviewSummarySelector
   */
  public static PageFeedItemReviewSummarySelector createGetReviewSummaryRequest(long accountId, List<Long> feedFolderIds) {
    // Set selector
    PageFeedItemReviewSummarySelector selector = new PageFeedItemReviewSummarySelector();
    selector.setAccountId(accountId);
    selector.getFeedFolderIds().addAll(feedFolderIds);

    return selector;
  }

  /**
   * create sample request.
   *
   * @param accountId     Account ID
   * @param feedFolderIds List<Long>
   * @return PageFeedItemSelector
   */
  public static PageFeedItemSelector createGetRequest(long accountId, List<Long> feedFolderIds) {
    // Set selector
    PageFeedItemSelector selector = new PageFeedItemSelector();
    selector.setAccountId(accountId);
    selector.getFeedFolderIds().addAll(feedFolderIds);

    return selector;
  }

  /**
   * create sample request.
   *
   * @param accountId    Account ID
   * @param feedFolderId FeedFolderID
   * @return PageFeedItemDownloadJobOperation
   */
  public static PageFeedItemDownloadJobOperation createAddDownloadJobRequest(long accountId, long feedFolderId) {
    // Set Operation
    PageFeedItemDownloadJobOperation operation = new PageFeedItemDownloadJobOperation();
    operation.setAccountId(accountId);
    PageFeedItemDownloadJob operand = new PageFeedItemDownloadJob();
    operand.getFeedFolderIds().add(feedFolderId);
    operand.setEncoding(BulkEncoding.UTF_8);
    operation.getOperand().add(operand);

    return operation;
  }


  /**
   * Sample Program for PageFeedItemService Upload.
   *
   * @param uploadUrl String
   * @param fileName  String
   * @return uploadJobId long
   */
  public static long upload(String uploadUrl, String fileName) throws Exception {

    // file upload
    System.out.println("############################################");
    System.out.println("PageFeedItemService::upload");
    System.out.println("############################################");
    String response = SoapUtils.upload(uploadUrl, fileName, "text/csv");

    // get upload PageFeedItem job ID
    long uploadJobId = -1;
    ObjectMapper objectMapper = new ObjectMapper();
    Map<String, Map<String, ArrayList<Map<String, Map<String, String>>>>> object = objectMapper.readValue(response, Map.class);
    if (object != null) {
      Object jobId = object.get("ResultSet").get("Result").get(0).get("pageFeedItemUploadJob").get("jobId");
      uploadJobId = (Integer) jobId;
    } else {
      throw new RuntimeException("Fail to upload to PageFeedItem. response=" + response);
    }
    return uploadJobId;
  }

  /**
   * Sample Program for PageFeedItemService Upload.
   *
   * @param downloadUrl String
   * @param fileName    String
   */
  public static void download(String downloadUrl, String fileName) throws Exception {

    System.out.println("############################################");
    System.out.println("PageFeedItemService::download");
    System.out.println("############################################");
    if (downloadUrl != null) {
      SoapUtils.download(downloadUrl, fileName);
    } else {
      System.out.println("downloadUrl = null");
      System.out.println("download didn't start because of empty url");
    }

    return;
  }

  /**
   * Sample Program for PageFeedItemService GetUploadUrl.
   *
   * @param pageFeedItemUploadUrlOperation PageFeedItemUploadUrlOperation
   * @return PageFeedItemUploadUrlPage
   */
  public static PageFeedItemUploadUrlPage getUploadUrl(PageFeedItemUploadUrlOperation pageFeedItemUploadUrlOperation) throws Exception {

    // =================================================================
    // PageFeedItemService
    // =================================================================
    PageFeedItemServiceInterface pageFeedItemService = SoapUtils.createServiceInterface(PageFeedItemServiceInterface.class, PageFeedItemServiceService.class);

    // -----------------------------------------------
    // PageFeedItemService::getUploadUrl
    // -----------------------------------------------
    // call API
    System.out.println("############################################");
    System.out.println("PageFeedItemService::getUploadUrl");
    System.out.println("############################################");

    List<PageFeedItemUploadUrlOperation> pageFeedItemUploadUrlOperationList = new ArrayList<>();
    pageFeedItemUploadUrlOperationList.add(pageFeedItemUploadUrlOperation);

    Holder<PageFeedItemUploadUrlPage> getGetUploadUrlHolder = new Holder<>();
    Holder<List<Error>> errorHolder = new Holder<List<Error>>();
    pageFeedItemService.getUploadUrl(pageFeedItemUploadUrlOperationList, getGetUploadUrlHolder, errorHolder);

    // if error
    if (errorHolder.value != null && errorHolder.value.size() > 0) {
      SoapUtils.displayErrors(new PageFeedItemServiceErrorEntityFactory(errorHolder.value), true);
    }

    // response
    if (getGetUploadUrlHolder.value != null) {
      PageFeedItemUploadUrlPage pageFeedItemUploadUrlPage = getGetUploadUrlHolder.value;
      displayGetUploadUrlResponse(pageFeedItemUploadUrlPage);
    }

    return getGetUploadUrlHolder.value;
  }

  /**
   * Sample Program for PageFeedItemService GetPageFeedItemStatus.
   *
   * @param selector PageFeedItemStatusSelector
   * @return List<PageFeedItemJobValues>
   */
  public static List<PageFeedItemJobValues> checkJobStatus(PageFeedItemJobStatusSelector selector) throws Exception {

    // =================================================================
    // PageFeedItemService
    // =================================================================
    PageFeedItemServiceInterface pageFeedItemService = SoapUtils.createServiceInterface(PageFeedItemServiceInterface.class, PageFeedItemServiceService.class);


    // call 30sec sleep * 60 = 30minute
    Holder<PageFeedItemJobStatusPage> getPageFeedItemJobStatusPageHolder = null;
    Holder<List<Error>> errorHolder = null;

    PageFeedItemUploadJobStatus uploadJobStatus = null;
    PageFeedItemDownloadJobStatus downloadJobStatus = null;

    for (int wait_count = 0; wait_count < 60; wait_count++) {
      // sleep 30 second.
      System.out.println("\n***** sleep 30 seconds for Upload/Download Job *****\n");
      Thread.sleep(30000);

      // call API
      System.out.println("############################################");
      System.out.println("PageFeedItemService::getPageFeedItemStatus");
      System.out.println("############################################");
      getPageFeedItemJobStatusPageHolder = new Holder<>();
      errorHolder = new Holder<>();
      pageFeedItemService.getJobStatus(selector, getPageFeedItemJobStatusPageHolder, errorHolder);

      // if error
      if (errorHolder.value != null && errorHolder.value.size() > 0) {
        SoapUtils.displayErrors(new PageFeedItemServiceErrorEntityFactory(errorHolder.value), true);
      }

      // response
      if (getPageFeedItemJobStatusPageHolder.value != null) {
        PageFeedItemJobStatusPage page = getPageFeedItemJobStatusPageHolder.value;
        if (page.getValues() != null && page.getValues().size() > 0) {
          List<PageFeedItemJobValues> values = page.getValues();
          for (int i = 0; i < values.size(); i++) {
            if (values.get(i).isOperationSucceeded()) {
              if (values.get(i).getJob() instanceof PageFeedItemUploadJob) {
                PageFeedItemUploadJob uploadPageFeedItemJob = (PageFeedItemUploadJob) values.get(i).getJob();
                uploadJobStatus = uploadPageFeedItemJob.getUploadJobStatus();

              } else if (values.get(i).getJob() instanceof PageFeedItemDownloadJob) {
                PageFeedItemDownloadJob downloadPageFeedItemJob = (PageFeedItemDownloadJob) values.get(i).getJob();
                downloadJobStatus = downloadPageFeedItemJob.getDownloadJobStatus();

              }
              displayPageFeedItemJob(values.get(i).getJob());
            } else {
              SoapUtils.displayErrors(new PageFeedItemServiceErrorEntityFactory(values.get(i).getError()), true);
            }
          }
        }
      }

      if (uploadJobStatus != null) {
        if (uploadJobStatus.equals(PageFeedItemUploadJobStatus.COMPLETED)) {
          break;
        } else {
          if (uploadJobStatus.equals(PageFeedItemUploadJobStatus.IN_PROGRESS)) {
            continue;
          } else {
            System.out.println("\nError :Upload Job Status failed.");
            System.exit(0);
          }
        }
      }

      if (downloadJobStatus != null) {
        if (downloadJobStatus.equals(PageFeedItemDownloadJobStatus.COMPLETED)) {
          break;
        } else {
          if (downloadJobStatus.equals(PageFeedItemDownloadJobStatus.IN_PROGRESS)) {
            continue;
          } else {
            System.out.println("\nError :Download Job Status failed.");
            System.exit(0);
          }
        }
      }
    }

    return getPageFeedItemJobStatusPageHolder.value.getValues();
  }

  /**
   * Sample Program for PageFeedItemService GetReviewSummary.
   *
   * @param selector PageFeedItemReviewSummarySelector
   * @return List<PageFeedItemReviewSummaryValues>
   */
  public static List<PageFeedItemReviewSummaryValues> getReviewSummary(PageFeedItemReviewSummarySelector selector) throws Exception {

    // =================================================================
    // PageFeedItemService
    // =================================================================
    PageFeedItemServiceInterface pageFeedItemService = SoapUtils.createServiceInterface(PageFeedItemServiceInterface.class, PageFeedItemServiceService.class);

    // -----------------------------------------------
    // PageFeedItemService::getUploadUrl
    // -----------------------------------------------
    // call API
    System.out.println("############################################");
    System.out.println("PageFeedItemService::getReviewSummary");
    System.out.println("############################################");


    Holder<PageFeedItemReviewSummaryPage> getReviewSummaryPageHolder = new Holder<>();
    Holder<List<Error>> errorHolder = new Holder<>();
    pageFeedItemService.getReviewSummary(selector, getReviewSummaryPageHolder, errorHolder);

    // if error
    if (errorHolder.value != null && errorHolder.value.size() > 0) {
      SoapUtils.displayErrors(new PageFeedItemServiceErrorEntityFactory(errorHolder.value), true);
    }

    // response
    if (getReviewSummaryPageHolder.value != null) {
      List<PageFeedItemReviewSummaryValues> pageFeedItemReviewSummaryValues = getReviewSummaryPageHolder.value.getValues();
      displayPageFeedItemReview(pageFeedItemReviewSummaryValues);

    }

    return getReviewSummaryPageHolder.value.getValues();
  }

  /**
   * Sample Program for PageFeedItemService Get.
   *
   * @param selector PageFeedItemSelector
   * @return List<PageFeedItemReturnValues>
   */
  public static List<PageFeedItemReturnValues> get(PageFeedItemSelector selector) throws Exception {

    // =================================================================
    // PageFeedItemService
    // =================================================================
    PageFeedItemServiceInterface pageFeedItemService = SoapUtils.createServiceInterface(PageFeedItemServiceInterface.class, PageFeedItemServiceService.class);

    // -----------------------------------------------
    // PageFeedItemService::getUploadUrl
    // -----------------------------------------------
    // call API
    System.out.println("############################################");
    System.out.println("PageFeedItemService::get");
    System.out.println("############################################");


    Holder<PageFeedItemPage> getPageHolder = new Holder<>();
    Holder<List<Error>> errorHolder = new Holder<>();
    pageFeedItemService.get(selector, getPageHolder, errorHolder);

    // if error
    if (errorHolder.value != null && errorHolder.value.size() > 0) {
      SoapUtils.displayErrors(new PageFeedItemServiceErrorEntityFactory(errorHolder.value), true);
    }

    // response
    if (getPageHolder.value != null) {
      List<PageFeedItemReturnValues> pageFeedItemReturnValues = getPageHolder.value.getValues();
      displayPageFeedItem(pageFeedItemReturnValues);

    }

    return getPageHolder.value.getValues();
  }

  /**
   * Sample Program for PageFeedItemService Get.
   *
   * @param operation PageFeedItemDownloadJobOperation
   * @return List<PageFeedItemDownloadJobValues>
   */
  public static List<PageFeedItemDownloadJobValues> addDownloadJob(PageFeedItemDownloadJobOperation operation) throws Exception {

    // =================================================================
    // PageFeedItemService
    // =================================================================
    PageFeedItemServiceInterface pageFeedItemService = SoapUtils.createServiceInterface(PageFeedItemServiceInterface.class, PageFeedItemServiceService.class);

    // -----------------------------------------------
    // PageFeedItemService::getUploadUrl
    // -----------------------------------------------
    // call API
    System.out.println("############################################");
    System.out.println("PageFeedItemService::addDownloadJob");
    System.out.println("############################################");


    Holder<PageFeedItemDownloadJobReturnValue> pageFeedItemDownloadJobReturnValue = new Holder<>();
    Holder<List<Error>> errorHolder = new Holder<>();
    pageFeedItemService.addDownloadJob(operation, pageFeedItemDownloadJobReturnValue, errorHolder);

    // if error
    if (errorHolder.value != null && errorHolder.value.size() > 0) {
      SoapUtils.displayErrors(new PageFeedItemServiceErrorEntityFactory(errorHolder.value), true);
    }

    // response
    if (pageFeedItemDownloadJobReturnValue.value != null) {
      List<PageFeedItemDownloadJobValues> pageFeedItemDownloadJobValues = pageFeedItemDownloadJobReturnValue.value.getValues();

      for (PageFeedItemDownloadJobValues value : pageFeedItemDownloadJobValues) {
        if (value.getJob() == null) {
          throw new Exception("Fail to addDownloadJob PageFeedItemService.");

        }
        display(value);
      }
    }

    return pageFeedItemDownloadJobReturnValue.value.getValues();
  }

  /**
   * display uploadUrlValue entity to stdout.
   *
   * @param pageFeedItemUploadUrlPage PageFeedItemUploadUrlPageentity for display.
   */
  private static void displayGetUploadUrlResponse(PageFeedItemUploadUrlPage pageFeedItemUploadUrlPage) {
    for (PageFeedItemUploadUrlValues value : pageFeedItemUploadUrlPage.getValues()) {
      System.out.println("accountId = " + value.getUploadUrl().getAccountId());
      System.out.println("uploadUrl = " + value.getUploadUrl().getUrl());
      System.out.println("uploadType = " + value.getUploadUrl().getUploadType().toString());
    }
    System.out.println("----------");
  }

  private static void display(PageFeedItemDownloadJobValues value) {
    System.out.println("JobId = " + value.getJob().getJobId());
    System.out.println("downloadUrl = " + value.getJob().getDownloadUrl());
    System.out.println("encoding = " + value.getJob().getEncoding());
    System.out.println("downloadJobStatus = " + value.getJob().getDownloadJobStatus().value());
  }

  private static void displayPageFeedItem(List<PageFeedItemReturnValues> pageFeedItemReturnValues) {
    int index = 0;
    for (PageFeedItemReturnValues value : pageFeedItemReturnValues) {
      System.out.println("pageFeedItemReturnValues[" + index + "]/accountId = " + value.getPageFeedItem().getAccountId());
      System.out.println("pageFeedItemReturnValues[" + index + "]/feedFolderId = " + value.getPageFeedItem().getFeedFolderId());
      System.out.println("pageFeedItemReturnValues[" + index + "]/pageFeedItemId = " + value.getPageFeedItem().getPageFeedItemId());
      System.out.println("pageFeedItemReturnValues[" + index + "]/approvalStatus = " + value.getPageFeedItem().getApprovalStatus());
      System.out.println("pageFeedItemReturnValues[" + index + "]/disapprovalReasonCodes = " + value.getPageFeedItem().getDisapprovalReasonCodes());
      System.out.println("pageFeedItemReturnValues[" + index + "]/disapprovalReasonComment = " + value.getPageFeedItem().getDisapprovalReasonComment());
      System.out.println("pageFeedItemReturnValues[" + index + "]/pageFeedUrl = " + value.getPageFeedItem().getPageFeedUrl());
      System.out.println("pageFeedItemReturnValues[" + index + "]/pageFeedCustomLabel = " + value.getPageFeedItem().getPageFeedCustomLabel());
      index++;
    }
  }

  private static void displayPageFeedItemReview(List<PageFeedItemReviewSummaryValues> pageFeedItemReviewSummaryValues) {
    int index = 0;
    for (PageFeedItemReviewSummaryValues value : pageFeedItemReviewSummaryValues) {
      System.out.println("pageFeedItemReviewSummaryValues[" + index + "]/accountId = " + value.getReviewSummary().getAccountId());
      System.out.println("pageFeedItemReviewSummaryValues[" + index + "]/feedFolderId = " + value.getReviewSummary().getFeedFolderId());
      System.out.println("pageFeedItemReviewSummaryValues[" + index + "]/entityCount = " + value.getReviewSummary().getEntityCount());
      System.out.println("pageFeedItemReviewSummaryValues[" + index + "]/approvedCount = " + value.getReviewSummary().getApprovedCount());
      System.out.println("pageFeedItemReviewSummaryValues[" + index + "]/approvedWithReviewCountCount = " + value.getReviewSummary().getApprovedWithReviewCount());
      System.out.println("pageFeedItemReviewSummaryValues[" + index + "]/reviewCount = " + value.getReviewSummary().getReviewCount());
      System.out.println("pageFeedItemReviewSummaryValues[" + index + "]/preDisapprovedCount = " + value.getReviewSummary().getPreDisapprovedCount());
      System.out.println("pageFeedItemReviewSummaryValues[" + index + "]/postDisapprovedCount = " + value.getReviewSummary().getPostDisapprovedCount());
      index++;
    }
  }

  private static void displayPageFeedItemJob(PageFeedItemJob pageFeedItemJob) {

    System.out.println("accountId = " + pageFeedItemJob.getAccountId());
    System.out.println("jobId = " + pageFeedItemJob.getJobId());
    System.out.println("startDate = " + pageFeedItemJob.getStartDate());
    System.out.println("endDate = " + pageFeedItemJob.getEndDate());
    System.out.println("progress = " + pageFeedItemJob.getProgress());
    if (pageFeedItemJob instanceof PageFeedItemUploadJob) {
      PageFeedItemUploadJob uploadJob = (PageFeedItemUploadJob) pageFeedItemJob;

      System.out.println("uploadJobStatus = " + uploadJob.getUploadJobStatus());
      System.out.println("errorFileUrl = " + uploadJob.getErrorFileUrl());
      System.out.println("errorCount = " + uploadJob.getErrorCount());
    } else if (pageFeedItemJob instanceof PageFeedItemDownloadJob) {
      PageFeedItemDownloadJob downloadJob = (PageFeedItemDownloadJob) pageFeedItemJob;

      System.out.println("downloadJobStatus = " + downloadJob.getDownloadJobStatus());
      System.out.println("encoding = " + downloadJob.getEncoding());
      System.out.println("downloadUrl = " + downloadJob.getDownloadUrl());
      System.out.println("lang = " + downloadJob.getLang());
      System.out.println("output = " + downloadJob.getOutput());
    }
  }

}

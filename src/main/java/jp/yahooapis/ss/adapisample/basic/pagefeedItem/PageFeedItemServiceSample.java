/**
 * Copyright (C) 2019 Yahoo Japan Corporation. All Rights Reserved.
 */
package jp.yahooapis.ss.adapisample.basic.pagefeedItem;

import com.fasterxml.jackson.databind.ObjectMapper;

import jp.yahooapis.ss.adapisample.basic.feedfolder.FeedFolderServiceSample;
import jp.yahooapis.ss.adapisample.repository.ValuesRepositoryFacade;
import jp.yahooapis.ss.adapisample.util.SoapUtils;
import jp.yahooapis.ss.adapisample.util.ValuesHolder;
import jp.yahooapis.ss.v201901.Error;
import jp.yahooapis.ss.v201901.feedfolder.FeedFolderPlaceholderType;
import jp.yahooapis.ss.v201901.pagefeeditem.PageFeedItemDownloadJob;
import jp.yahooapis.ss.v201901.pagefeeditem.PageFeedItemDownloadJobOperation;
import jp.yahooapis.ss.v201901.pagefeeditem.PageFeedItemDownloadJobReturnValue;
import jp.yahooapis.ss.v201901.pagefeeditem.PageFeedItemDownloadJobValues;
import jp.yahooapis.ss.v201901.pagefeeditem.PageFeedItemJobStatusPage;
import jp.yahooapis.ss.v201901.pagefeeditem.PageFeedItemJobStatusSelector;
import jp.yahooapis.ss.v201901.pagefeeditem.PageFeedItemJobType;
import jp.yahooapis.ss.v201901.pagefeeditem.PageFeedItemJobValues;
import jp.yahooapis.ss.v201901.pagefeeditem.PageFeedItemPage;
import jp.yahooapis.ss.v201901.pagefeeditem.PageFeedItemReturnValues;
import jp.yahooapis.ss.v201901.pagefeeditem.PageFeedItemReviewSummaryPage;
import jp.yahooapis.ss.v201901.pagefeeditem.PageFeedItemReviewSummarySelector;
import jp.yahooapis.ss.v201901.pagefeeditem.PageFeedItemReviewSummaryValues;
import jp.yahooapis.ss.v201901.pagefeeditem.PageFeedItemSelector;
import jp.yahooapis.ss.v201901.pagefeeditem.PageFeedItemService;
import jp.yahooapis.ss.v201901.pagefeeditem.PageFeedItemServiceInterface;
import jp.yahooapis.ss.v201901.pagefeeditem.PageFeedItemUploadJob;
import jp.yahooapis.ss.v201901.pagefeeditem.PageFeedItemUploadType;
import jp.yahooapis.ss.v201901.pagefeeditem.PageFeedItemUploadUrl;
import jp.yahooapis.ss.v201901.pagefeeditem.PageFeedItemUploadUrlOperation;
import jp.yahooapis.ss.v201901.pagefeeditem.PageFeedItemUploadUrlPage;
import jp.yahooapis.ss.v201901.pagefeeditem.PageFeedItemUploadUrlValues;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import javax.xml.ws.Holder;

/**
 * example PageFeedItemService operation and Utility method collection.
 */
public class PageFeedItemServiceSample {
  /**
   * main method for PageFeedItemService
   *
   * @param args command line arguments
   */
  public static void main(String[] args) throws Exception {
    ValuesHolder valuesHolder = new ValuesHolder();
    try {
      // =================================================================
      // Setting
      // =================================================================
      long accountId = SoapUtils.getAccountId();
      String uploadUrl = null;
      String downloadUrl = null;
      String uploadFileName = "pageFeedItemUploadSample.csv";
      String downloadFileName = "pageFeedItemDownloadSample.csv";
      valuesHolder = setup();
      ValuesRepositoryFacade valuesRepositoryFacade = new ValuesRepositoryFacade(valuesHolder);
      Long feedFolderId = valuesRepositoryFacade.getFeedFolderValuesRepository().findFeedFolderId(FeedFolderPlaceholderType.DYNAMIC_AD_FOR_SEARCH_PAGE_FEEDS);

      //=================================================================
      // PageFeedItemService getUploadUrl
      //=================================================================
      // create request.
      PageFeedItemUploadUrlOperation pageFeedItemUploadUrlOperation = buildExampleGetUploadUrl(accountId, feedFolderId);

      // run
      PageFeedItemUploadUrlPage pageFeedItemUploadUrlPage = getUploadUrl(pageFeedItemUploadUrlOperation);
      for (PageFeedItemUploadUrlValues value : pageFeedItemUploadUrlPage.getValues()) {
        uploadUrl = value.getUploadUrl().getUrl();
      }

      //=================================================================
      // PageFeedItemService upload
      //=================================================================
      // run
      long uploadJobId = upload(uploadUrl, uploadFileName);

      //=================================================================
      // PageFeedItemService getJobStatus
      //=================================================================
      // check job status
      checkJobStatus(accountId, PageFeedItemJobType.UPLOAD, Arrays.asList(uploadJobId));

      //=================================================================
      // PageFeedItemService getReviewSummary
      //=================================================================
      // create request.
      PageFeedItemReviewSummarySelector pageFeedItemReviewSummarySelector = buildExampleGetReviewSummary(accountId, Arrays.asList(feedFolderId));

      // run
      getReviewSummary(pageFeedItemReviewSummarySelector);

      //=================================================================
      // PageFeedItemService get
      //=================================================================
      // create request.
      PageFeedItemSelector pageFeedItemSelector = buildExampleGetRequest(accountId, Arrays.asList(feedFolderId));

      // run
      get(pageFeedItemSelector);

      //=================================================================
      // PageFeedItemService addDownloadJob
      //=================================================================
      // create request.
      PageFeedItemDownloadJobOperation operation = buildExampleAddDownloadJob(accountId, Arrays.asList(feedFolderId));

      // run
      List<PageFeedItemDownloadJobValues> pageFeedItemDownloadJobValues = addDownloadJob(operation);
      long jobId = -1L;
      for (PageFeedItemDownloadJobValues values : pageFeedItemDownloadJobValues) {
        jobId = values.getJob().getJobId();
      }

      //=================================================================
      // PageFeedItemService getJobStatus
      //=================================================================
      // check job status
      checkJobStatus(accountId, PageFeedItemJobType.DOWNLOAD, Arrays.asList(jobId));

      // create request.
      PageFeedItemJobStatusSelector selector = buildExampleGetJobStatus(accountId, PageFeedItemJobType.DOWNLOAD, Arrays.asList(jobId));

      // run
      List<PageFeedItemJobValues> pageFeedItemJobValues = getJobStatus(selector);

      // get downloadUrl
      for (PageFeedItemJobValues values : pageFeedItemJobValues) {
        if (values.getJob() instanceof PageFeedItemDownloadJob) {
          downloadUrl = ((PageFeedItemDownloadJob) values.getJob()).getDownloadUrl();
        }
      }

      //=================================================================
      // PageFeedItemService download (http request)
      //=================================================================
      download(downloadUrl, downloadFileName);

    } catch (Exception e) {
      e.printStackTrace();
      throw e;
    } finally {
      cleanup(valuesHolder);
    }
  }

  /**
   * check & create upper service object.
   *
   * @return ValuesHolder
   */
  private static ValuesHolder setup() throws Exception {
    return FeedFolderServiceSample.create();
  }

  /**
   * cleanup service object.
   *
   * @param valuesHolder ValuesHolder
   */
  public static void cleanup(ValuesHolder valuesHolder) throws Exception {
    FeedFolderServiceSample.cleanup(valuesHolder);
  }

  /**
   * example getUploadUrl request.
   *
   * @param accountId    Account ID
   * @param feedFolderId FeedFolderID
   * @return PageFeedItemUploadUrlOperation
   */
  public static PageFeedItemUploadUrlOperation buildExampleGetUploadUrl(long accountId, long feedFolderId) {
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
   * example getJobStatus request.
   *
   * @param accountId Account ID
   * @param jobType   PageFeedItemJobType
   * @param jobIds    List<Long>
   * @return PageFeedItemUploadUrlOperation
   */
  public static PageFeedItemJobStatusSelector buildExampleGetJobStatus(long accountId, PageFeedItemJobType jobType, List<Long> jobIds) {
    // Set selector
    PageFeedItemJobStatusSelector selector = new PageFeedItemJobStatusSelector();
    selector.setAccountId(accountId);
    if (!jobIds.isEmpty()) {
      selector.getJobIds().addAll(jobIds);
    }
    selector.setJobType(jobType);

    return selector;
  }

  /**
   * example getReviewSummary request.
   *
   * @param accountId     Account ID
   * @param feedFolderIds List<Long>
   * @return PageFeedItemReviewSummarySelector
   */
  public static PageFeedItemReviewSummarySelector buildExampleGetReviewSummary(long accountId, List<Long> feedFolderIds) {
    // Set selector
    PageFeedItemReviewSummarySelector selector = new PageFeedItemReviewSummarySelector();
    selector.setAccountId(accountId);
    if (!feedFolderIds.isEmpty()) {
      selector.getFeedFolderIds().addAll(feedFolderIds);
    }
    return selector;
  }

  /**
   * example get request.
   *
   * @param accountId     Account ID
   * @param feedFolderIds List<Long>
   * @return PageFeedItemSelector
   */
  public static PageFeedItemSelector buildExampleGetRequest(long accountId, List<Long> feedFolderIds) {
    // Set selector
    PageFeedItemSelector selector = new PageFeedItemSelector();
    selector.setAccountId(accountId);
    if (!feedFolderIds.isEmpty()) {
      selector.getFeedFolderIds().addAll(feedFolderIds);
    }
    return selector;
  }

  /**
   * example addDownloadJob request.
   *
   * @param accountId     Account ID
   * @param feedFolderIds FeedFolderID
   * @return PageFeedItemDownloadJobOperation
   */
  public static PageFeedItemDownloadJobOperation buildExampleAddDownloadJob(long accountId, List<Long> feedFolderIds) {
    PageFeedItemDownloadJobOperation operation = new PageFeedItemDownloadJobOperation();
    operation.setAccountId(accountId);
    PageFeedItemDownloadJob operand = new PageFeedItemDownloadJob();

    if (!feedFolderIds.isEmpty()) {
      operand.getFeedFolderIds().addAll(feedFolderIds);
    }
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
   * example getUploadUrl pageFeedItems.
   *
   * @param pageFeedItemUploadUrlOperation PageFeedItemUploadUrlOperation
   * @return PageFeedItemUploadUrlPage
   */
  public static PageFeedItemUploadUrlPage getUploadUrl(PageFeedItemUploadUrlOperation pageFeedItemUploadUrlOperation) throws Exception {

    // =================================================================
    // PageFeedItemService
    // =================================================================
    PageFeedItemServiceInterface pageFeedItemService = SoapUtils.createServiceInterface(PageFeedItemServiceInterface.class, PageFeedItemService.class);

    // -----------------------------------------------
    // PageFeedItemService::getUploadUrl
    // -----------------------------------------------
    // call API
    System.out.println("############################################");
    System.out.println("PageFeedItemService::getUploadUrl");
    System.out.println("############################################");

    Holder<PageFeedItemUploadUrlPage> getGetUploadUrlHolder = new Holder<>();
    Holder<List<Error>> errorHolder = new Holder<List<Error>>();
    pageFeedItemService.getUploadUrl(pageFeedItemUploadUrlOperation, getGetUploadUrlHolder, errorHolder);

    SoapUtils.checkSoapError(errorHolder, getGetUploadUrlHolder.value.getValues());

    return getGetUploadUrlHolder.value;
  }

  /**
   * example check pageFeedItem job status.
   *
   * @param accountId long
   * @param jobType   PageFeedItemJobType
   * @param jobIds    List<Long>
   */
  public static void checkJobStatus(long accountId, PageFeedItemJobType jobType, List<Long> jobIds) throws Exception {

    // call 30sec sleep * 60 = 30minute
    for (int wait_count = 0; wait_count < 60; wait_count++) {
      // sleep 30 second.
      System.out.println("\n***** sleep 30 seconds for PageFeedItem " + jobType + " Job *****\n");
      Thread.sleep(30000);

      // call API
      PageFeedItemJobStatusSelector selector = buildExampleGetJobStatus(accountId, jobType, jobIds);
      // run
      List<PageFeedItemJobValues> pageFeedItemJobValues = getJobStatus(selector);

      // status check
      if (jobType == PageFeedItemJobType.UPLOAD) {
        if (checkUploadJob(pageFeedItemJobValues)) {
          return;
        }
      } else if (jobType == PageFeedItemJobType.DOWNLOAD) {
        if (checkDownloadJob(pageFeedItemJobValues)) {
          return;
        }
      }
    }
  }

  /**
   * @param pageFeedItemJobValues List<PageFeedItemJobValues>
   * @return Boolean
   */
  private static Boolean checkUploadJob(List<PageFeedItemJobValues> pageFeedItemJobValues) throws Exception {
    int completedCount = 0;

    // check status
    for (PageFeedItemJobValues values : pageFeedItemJobValues) {
      if (values.getJob() instanceof PageFeedItemUploadJob) {
        PageFeedItemUploadJob uploadJob = (PageFeedItemUploadJob) values.getJob();
        if (uploadJob.getUploadJobStatus() == null) {
          throw new Exception("Fail to getJobStatus PageFeedItemService.");
        }
        switch (uploadJob.getUploadJobStatus()) {
          default:
          case COMPLETED_WITH_VALIDATION_ERROR:
          case FILE_FORMAT_ERROR:
          case FILE_ENCODING_ERROR:
          case COLUMN_HEADER_ERROR:
          case EXCEED_ROW_LINES:
          case EXCEED_FILE_COUNTS:
          case INVALID_FEED_FOLDER_ID:
          case TIMEOUT:
          case SYSTEM_ERROR:
            throw new Exception("check upload Status failed.");
          case IN_PROGRESS:
            continue;
          case COMPLETED:
            completedCount++;
            continue;
        }
      }
    }

    if (pageFeedItemJobValues.size() == completedCount) {
      return true;
    }

    throw new Exception("Fail to getJobStatus PageFeedItemService.");
  }

  /**
   * @param pageFeedItemJobValues List<PageFeedItemJobValues>
   * @return Boolean
   */
  private static Boolean checkDownloadJob(List<PageFeedItemJobValues> pageFeedItemJobValues) throws Exception {
    int completedCount = 0;

    // check status
    for (PageFeedItemJobValues values : pageFeedItemJobValues) {
      if (values.getJob() instanceof PageFeedItemDownloadJob) {
        PageFeedItemDownloadJob downloadJob = (PageFeedItemDownloadJob) values.getJob();
        if (downloadJob.getDownloadJobStatus() == null) {
          throw new Exception("Fail to getJobStatus PageFeedItemService.");
        }
        switch (downloadJob.getDownloadJobStatus()) {
          default:
          case FIELDS_ERROR:
          case TIMEOUT:
          case SYSTEM_ERROR:
            throw new Exception("check download Status failed.");
          case IN_PROGRESS:
            continue;
          case COMPLETED:
            completedCount++;
            continue;
        }
      }
    }

    if (pageFeedItemJobValues.size() == completedCount) {
      return true;
    }

    throw new Exception("Fail to getJobStatus PageFeedItemService.");
  }

  /**
   * example getReviewSummary pageFeedItems.
   *
   * @param selector PageFeedItemReviewSummarySelector
   * @return List<PageFeedItemReviewSummaryValues>
   * @throws Exception exception
   */
  public static List<PageFeedItemReviewSummaryValues> getReviewSummary(PageFeedItemReviewSummarySelector selector) throws Exception {

    // =================================================================
    // PageFeedItemService
    // =================================================================
    PageFeedItemServiceInterface pageFeedItemService = SoapUtils.createServiceInterface(PageFeedItemServiceInterface.class, PageFeedItemService.class);

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

    SoapUtils.checkSoapError(errorHolder, getReviewSummaryPageHolder.value.getValues());

    return getReviewSummaryPageHolder.value.getValues();
  }

  /**
   * example get pageFeedItems.
   *
   * @param selector PageFeedItemSelector
   * @return List<PageFeedItemReturnValues>
   */
  public static List<PageFeedItemReturnValues> get(PageFeedItemSelector selector) throws Exception {

    // =================================================================
    // PageFeedItemService
    // =================================================================
    PageFeedItemServiceInterface pageFeedItemService = SoapUtils.createServiceInterface(PageFeedItemServiceInterface.class, PageFeedItemService.class);

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

    SoapUtils.checkSoapError(errorHolder, getPageHolder.value.getValues());

    return getPageHolder.value.getValues();
  }

  /**
   * example getJobStatus pageFeedItems.
   *
   * @param selector PageFeedItemJobStatusSelector
   * @return List<PageFeedItemJobValues>
   */
  public static List<PageFeedItemJobValues> getJobStatus(PageFeedItemJobStatusSelector selector) throws Exception {

    // =================================================================
    // PageFeedItemService
    // =================================================================
    PageFeedItemServiceInterface pageFeedItemService = SoapUtils.createServiceInterface(PageFeedItemServiceInterface.class, PageFeedItemService.class);

    // -----------------------------------------------
    // PageFeedItemService::getPageFeedItemStatus
    // -----------------------------------------------
    // call API
    System.out.println("############################################");
    System.out.println("PageFeedItemService::getPageFeedItemStatus");
    System.out.println("############################################");


    Holder<PageFeedItemJobStatusPage> getPageFeedItemJobStatusPageHolder = new Holder<>();
    Holder<List<Error>> errorHolder = new Holder<>();

    pageFeedItemService.getJobStatus(selector, getPageFeedItemJobStatusPageHolder, errorHolder);

    SoapUtils.checkSoapError(errorHolder, getPageFeedItemJobStatusPageHolder.value.getValues());

    return getPageFeedItemJobStatusPageHolder.value.getValues();
  }


  /**
   * example addDownloadJob pageFeedItems.
   *
   * @param operation PageFeedItemDownloadJobOperation
   * @return List<PageFeedItemDownloadJobValues>
   */
  public static List<PageFeedItemDownloadJobValues> addDownloadJob(PageFeedItemDownloadJobOperation operation) throws Exception {

    // =================================================================
    // PageFeedItemService
    // =================================================================
    PageFeedItemServiceInterface pageFeedItemService = SoapUtils.createServiceInterface(PageFeedItemServiceInterface.class, PageFeedItemService.class);

    // -----------------------------------------------
    // PageFeedItemService::addDownloadJob
    // -----------------------------------------------
    // call API
    System.out.println("############################################");
    System.out.println("PageFeedItemService::addDownloadJob");
    System.out.println("############################################");


    Holder<PageFeedItemDownloadJobReturnValue> pageFeedItemDownloadJobReturnValue = new Holder<>();
    Holder<List<Error>> errorHolder = new Holder<>();
    pageFeedItemService.addDownloadJob(operation, pageFeedItemDownloadJobReturnValue, errorHolder);

    SoapUtils.checkSoapError(errorHolder, pageFeedItemDownloadJobReturnValue.value.getValues());

    // response
    if (pageFeedItemDownloadJobReturnValue.value != null) {
      List<PageFeedItemDownloadJobValues> pageFeedItemDownloadJobValues = pageFeedItemDownloadJobReturnValue.value.getValues();

      for (PageFeedItemDownloadJobValues value : pageFeedItemDownloadJobValues) {
        if (value.getJob() == null) {
          throw new Exception("Fail to addDownloadJob PageFeedItemService.");
        }
      }
    }
    return pageFeedItemDownloadJobReturnValue.value.getValues();
  }
}

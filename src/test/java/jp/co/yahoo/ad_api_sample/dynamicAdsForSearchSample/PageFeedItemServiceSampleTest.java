package jp.co.yahoo.ad_api_sample.dynamicAdsForSearchSample;

import jp.co.yahoo.ad_api_sample.util.SoapUtils;
import jp.yahooapis.ss.v201808.pagefeeditem.PageFeedItemDownloadJob;
import jp.yahooapis.ss.v201808.pagefeeditem.PageFeedItemDownloadJobOperation;
import jp.yahooapis.ss.v201808.pagefeeditem.PageFeedItemDownloadJobStatus;
import jp.yahooapis.ss.v201808.pagefeeditem.PageFeedItemDownloadJobValues;
import jp.yahooapis.ss.v201808.pagefeeditem.PageFeedItemJobStatusSelector;
import jp.yahooapis.ss.v201808.pagefeeditem.PageFeedItemJobType;
import jp.yahooapis.ss.v201808.pagefeeditem.PageFeedItemJobValues;
import jp.yahooapis.ss.v201808.pagefeeditem.PageFeedItemReturnValues;
import jp.yahooapis.ss.v201808.pagefeeditem.PageFeedItemReviewSummarySelector;
import jp.yahooapis.ss.v201808.pagefeeditem.PageFeedItemReviewSummaryValues;
import jp.yahooapis.ss.v201808.pagefeeditem.PageFeedItemSelector;
import jp.yahooapis.ss.v201808.pagefeeditem.PageFeedItemUploadJob;
import jp.yahooapis.ss.v201808.pagefeeditem.PageFeedItemUploadJobStatus;
import jp.yahooapis.ss.v201808.pagefeeditem.PageFeedItemUploadUrlOperation;
import jp.yahooapis.ss.v201808.pagefeeditem.PageFeedItemUploadUrlPage;
import jp.yahooapis.ss.v201808.pagefeeditem.PageFeedItemUploadUrlValues;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsInstanceOf.any;
import static org.hamcrest.core.IsInstanceOf.instanceOf;
import static org.hamcrest.core.IsNot.not;
import static org.hamcrest.core.IsNull.notNullValue;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;

/**
 * Sample TestCase for PageFeedItemServiceSampleTest. Copyright (C) 2012 Yahoo Japan Corporation. All Rights Reserved.
 */
public class PageFeedItemServiceSampleTest {
  /**
   * Setting
   */
  private long accountId;
  private long dasFeedFolderId;

  private String fileName;
  //  private String uploadUrl;
  //  private String downloadUrl;



  @Before
  public void setup() {
    accountId = SoapUtils.getAccountId();
    dasFeedFolderId = SoapUtils.getDasFeedFolderId();

    fileName = "pageFeedItemUploadSample.csv";
  }

  /**
   * Sample TestCase of main method for PageFeedItemServiceSample.
   */
  @Test
  public void testMain() throws Exception {
    // Run
    try {
      PageFeedItemServiceSample.main(null);
    } catch (Exception e) {
      fail();
    }
  }

  /**
   * Sample TestCase of getUploadUrl method for PageFeedItemServiceSample.
   */
  @Test
  public void testGetUploadUrl() throws Exception {

    PageFeedItemUploadUrlPage pageFeedItemUploadUrlPage = null;

    // getUploadUrl
    PageFeedItemUploadUrlOperation pageFeedItemUploadUrlOperation = PageFeedItemServiceSample.createSampleUploadRequest(accountId, dasFeedFolderId);
    try {
      pageFeedItemUploadUrlPage = PageFeedItemServiceSample.getUploadUrl(pageFeedItemUploadUrlOperation);
    } catch (Exception e) {
      fail();
    }

    // Assert
    for (PageFeedItemUploadUrlValues value : pageFeedItemUploadUrlPage.getValues()) {
      assertThat(value.isOperationSucceeded(), is(true));
      assertThat(value.getUploadUrl().getAccountId(), is(notNullValue()));
      assertThat(value.getUploadUrl().getUrl(), is(notNullValue()));
    }

  }

  /**
   * Sample TestCase of upload method for PageFeedItemServiceSample.
   */
  @Test
  public void testUpload() throws Exception {

    long uploadJobId = -1;

    try {
      PageFeedItemUploadUrlOperation pageFeedItemUploadUrlOperation = PageFeedItemServiceSample.createSampleUploadRequest(accountId, dasFeedFolderId);
      PageFeedItemUploadUrlPage pageFeedItemUploadUrlPage = PageFeedItemServiceSample.getUploadUrl(pageFeedItemUploadUrlOperation);
      uploadJobId = PageFeedItemServiceSample.upload(pageFeedItemUploadUrlPage.getValues().get(0).getUploadUrl().getUrl(), fileName);
    } catch (Exception e) {
      fail();
    }
    // Assert
    assertThat(uploadJobId, is(not(-1)));

  }

  /**
   * Sample TestCase of checkJobStatus upload method for PageFeedItemServiceSample.
   */
  @Test
  public void testCheckJobStatusUpload() throws Exception {

    long uploadJobId = -1;

    try {
      PageFeedItemUploadUrlOperation pageFeedItemUploadUrlOperation = PageFeedItemServiceSample.createSampleUploadRequest(accountId, dasFeedFolderId);
      PageFeedItemUploadUrlPage pageFeedItemUploadUrlPage = PageFeedItemServiceSample.getUploadUrl(pageFeedItemUploadUrlOperation);
      uploadJobId = PageFeedItemServiceSample.upload(pageFeedItemUploadUrlPage.getValues().get(0).getUploadUrl().getUrl(), fileName);
    } catch (Exception e) {
      fail();
    }

    PageFeedItemJobStatusSelector pageFeedItemJobStatusSelector = PageFeedItemServiceSample.createGetJobStatusRequest(accountId, PageFeedItemJobType.UPLOAD, uploadJobId);
    List<PageFeedItemJobValues> pageFeedItemJobValuesList = PageFeedItemServiceSample.checkJobStatus(pageFeedItemJobStatusSelector);

    assertThat(pageFeedItemJobValuesList, is(notNullValue()));
    for (PageFeedItemJobValues values : pageFeedItemJobValuesList) {
      assertThat(values.isOperationSucceeded(), is(true));
      assertThat(values.getJob(), is(notNullValue()));
      assertThat(values.getJob().getAccountId(), is(notNullValue()));
      assertThat(values.getJob(), is(instanceOf(PageFeedItemUploadJob.class)));

      PageFeedItemUploadJob uploadJob = (PageFeedItemUploadJob) values.getJob();
      assertThat(uploadJob.getUploadJobStatus(), is(PageFeedItemUploadJobStatus.COMPLETED));
    }

  }

  /**
   * Sample TestCase of addDownloadJob method for PageFeedItemServiceSample.
   */
  @Test
  public void testAddDownloadJob() throws Exception {

    try {
      PageFeedItemUploadUrlOperation pageFeedItemUploadUrlOperation = PageFeedItemServiceSample.createSampleUploadRequest(accountId, dasFeedFolderId);
      PageFeedItemUploadUrlPage pageFeedItemUploadUrlPage = PageFeedItemServiceSample.getUploadUrl(pageFeedItemUploadUrlOperation);
      long uploadJobId = PageFeedItemServiceSample.upload(pageFeedItemUploadUrlPage.getValues().get(0).getUploadUrl().getUrl(), fileName);

      PageFeedItemJobStatusSelector pageFeedItemJobStatusSelector = PageFeedItemServiceSample.createGetJobStatusRequest(accountId, PageFeedItemJobType.UPLOAD, uploadJobId);
      PageFeedItemServiceSample.checkJobStatus(pageFeedItemJobStatusSelector);
    } catch (Exception e) {
      fail();
    }

    List<PageFeedItemDownloadJobValues> pageFeedItemDownloadJobValues = null;
    // addDownloadJob
    PageFeedItemDownloadJobOperation operation = PageFeedItemServiceSample.createAddDownloadJobRequest(accountId, dasFeedFolderId);
    pageFeedItemDownloadJobValues = PageFeedItemServiceSample.addDownloadJob(operation);

    for (PageFeedItemDownloadJobValues values : pageFeedItemDownloadJobValues) {
      assertThat(values.isOperationSucceeded(), is(true));
      assertThat(values.getJob(), is(notNullValue()));
      assertThat(values.getJob().getAccountId(), is(notNullValue()));
      assertThat(values.getJob().getJobId(), is(notNullValue()));
    }

  }

  /**
   * Sample TestCase of checkJobStatus download method for PageFeedItemServiceSample.
   */
  @Test
  public void testCheckJobStatusDownload() throws Exception {

    long downloadJobId = -1;

    try {
      // addDownloadJob
      PageFeedItemDownloadJobOperation operation = PageFeedItemServiceSample.createAddDownloadJobRequest(accountId, dasFeedFolderId);
      List<PageFeedItemDownloadJobValues> pageFeedItemDownloadJobValues = PageFeedItemServiceSample.addDownloadJob(operation);
      for (PageFeedItemDownloadJobValues values : pageFeedItemDownloadJobValues) {
        downloadJobId = values.getJob().getJobId();
      }
    } catch (Exception e) {
      fail();
    }

    PageFeedItemJobStatusSelector pageFeedItemJobStatusSelector = PageFeedItemServiceSample.createGetJobStatusRequest(accountId, PageFeedItemJobType.DOWNLOAD, downloadJobId);
    List<PageFeedItemJobValues> pageFeedItemJobValuesList = PageFeedItemServiceSample.checkJobStatus(pageFeedItemJobStatusSelector);

    assertThat(pageFeedItemJobValuesList, is(notNullValue()));
    for (PageFeedItemJobValues values : pageFeedItemJobValuesList) {
      assertThat(values.isOperationSucceeded(), is(true));
      assertThat(values.getJob(), is(notNullValue()));
      assertThat(values.getJob().getAccountId(), is(notNullValue()));
      assertThat(values.getJob(), is(instanceOf(PageFeedItemDownloadJob.class)));

      PageFeedItemDownloadJob downloadJob = (PageFeedItemDownloadJob) values.getJob();
      assertThat(downloadJob.getDownloadJobStatus(), is(PageFeedItemDownloadJobStatus.COMPLETED));
      assertThat(downloadJob.getDownloadUrl(), is(notNullValue()));
    }

  }


  /**
   * Sample TestCase of download method for PageFeedItemServiceSample.
   */
  @Test
  public void testDownload() throws Exception {

    long downloadJobId = -1L;
    String downloadUrl = null;
    try {
      // addDownloadJob
      PageFeedItemDownloadJobOperation operation = PageFeedItemServiceSample.createAddDownloadJobRequest(accountId, dasFeedFolderId);
      List<PageFeedItemDownloadJobValues> pageFeedItemDownloadJobValues = PageFeedItemServiceSample.addDownloadJob(operation);
      for (PageFeedItemDownloadJobValues values : pageFeedItemDownloadJobValues) {
        downloadJobId = values.getJob().getJobId();
      }
      PageFeedItemJobStatusSelector pageFeedItemJobStatusSelector = PageFeedItemServiceSample.createGetJobStatusRequest(accountId, PageFeedItemJobType.DOWNLOAD, downloadJobId);
      List<PageFeedItemJobValues> pageFeedItemJobValuesList = PageFeedItemServiceSample.checkJobStatus(pageFeedItemJobStatusSelector);
      // downloadUrl取得
      for (PageFeedItemJobValues values : pageFeedItemJobValuesList) {
        if (values.getJob() instanceof PageFeedItemDownloadJob) {
          downloadUrl = ((PageFeedItemDownloadJob) values.getJob()).getDownloadUrl();
        }
      }
      PageFeedItemServiceSample.download(downloadUrl, fileName);

    } catch (Exception e) {
      fail();
    }

    assertThat(downloadUrl, is(notNullValue()));
    assertThat(downloadJobId, is(not(-1L)));


  }

  /**
   * Sample TestCase of getReviewSummary method for PageFeedItemServiceSample.
   */
  @Test
  public void testGetReviewSummary() throws Exception {
    List<PageFeedItemReviewSummaryValues> reviewSummaryValues = null;
    // getReviewSummary
    try {
      PageFeedItemReviewSummarySelector pageFeedItemReviewSummarySelector = PageFeedItemServiceSample.createGetReviewSummaryRequest(accountId, Arrays.asList(dasFeedFolderId));
      reviewSummaryValues = PageFeedItemServiceSample.getReviewSummary(pageFeedItemReviewSummarySelector);
    } catch (Exception e) {
      fail();
    }

    assertThat(reviewSummaryValues, is(notNullValue()));
    for (PageFeedItemReviewSummaryValues value : reviewSummaryValues) {
      assertThat(value.isOperationSucceeded(), is(true));
      assertThat(value.getReviewSummary().getAccountId(), is(notNullValue()));
    }
  }

  /**
   * Sample TestCase of get method for PageFeedItemServiceSample.
   */
  @Test
  public void testGet() throws Exception {
    List<PageFeedItemReturnValues> getValues = null;
    // get
    try {
      PageFeedItemSelector pageFeedItemSelector = PageFeedItemServiceSample.createGetRequest(accountId, Arrays.asList(dasFeedFolderId));
      getValues = PageFeedItemServiceSample.get(pageFeedItemSelector);
    } catch (Exception e) {
      fail();
    }
    assertThat(getValues, is(notNullValue()));
    for (PageFeedItemReturnValues value : getValues) {
      assertThat(value.isOperationSucceeded(), is(true));
      assertThat(value.getPageFeedItem().getAccountId(), is(notNullValue()));
    }

  }



  //  /**
  //   * clean
  //   */
  //  public void clean(List<PageFeedItemValues> PageFeedItemValues) {
  //    try {
  //      PageFeedItemOperation removePageFeedItemOperation = PageFeedItemServiceSample.createSampleRemoveRequest(accountId, PageFeedItemValues);
  //      PageFeedItemServiceSample.remove(removePageFeedItemOperation);
  //    } catch (Exception e) {
  //      fail();
  //    }
  //  }

}

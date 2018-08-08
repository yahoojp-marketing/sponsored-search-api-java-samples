package jp.co.yahoo.ad_api_sample.dynamicAdsForSearchSample;

import jp.co.yahoo.ad_api_sample.adCustomizerSample.FeedFolderServiceSample;
import jp.co.yahoo.ad_api_sample.adSample.AdGroupAdServiceSample;
import jp.co.yahoo.ad_api_sample.adSample.AdGroupServiceSample;
import jp.co.yahoo.ad_api_sample.adSample.CampaignServiceSample;
import jp.co.yahoo.ad_api_sample.util.SoapUtils;
import jp.yahooapis.ss.v201808.adgroup.AdGroupOperation;
import jp.yahooapis.ss.v201808.adgroup.AdGroupValues;
import jp.yahooapis.ss.v201808.adgroupad.AdGroupAdOperation;
import jp.yahooapis.ss.v201808.adgroupad.AdGroupAdValues;
import jp.yahooapis.ss.v201808.adgroupwebpage.AdGroupWebpageOperation;
import jp.yahooapis.ss.v201808.adgroupwebpage.AdGroupWebpageValues;
import jp.yahooapis.ss.v201808.campaign.CampaignOperation;
import jp.yahooapis.ss.v201808.campaign.CampaignValues;
import jp.yahooapis.ss.v201808.campaignwebpage.CampaignWebpageOperation;
import jp.yahooapis.ss.v201808.campaignwebpage.CampaignWebpageValues;
import jp.yahooapis.ss.v201808.feedfolder.FeedFolderOperation;
import jp.yahooapis.ss.v201808.feedfolder.FeedFolderPlaceholderType;
import jp.yahooapis.ss.v201808.feedfolder.FeedFolderValues;
import jp.yahooapis.ss.v201808.pagefeeditem.PageFeedItemDownloadJob;
import jp.yahooapis.ss.v201808.pagefeeditem.PageFeedItemDownloadJobOperation;
import jp.yahooapis.ss.v201808.pagefeeditem.PageFeedItemDownloadJobValues;
import jp.yahooapis.ss.v201808.pagefeeditem.PageFeedItemJobStatusSelector;
import jp.yahooapis.ss.v201808.pagefeeditem.PageFeedItemJobType;
import jp.yahooapis.ss.v201808.pagefeeditem.PageFeedItemJobValues;
import jp.yahooapis.ss.v201808.pagefeeditem.PageFeedItemReturnValues;
import jp.yahooapis.ss.v201808.pagefeeditem.PageFeedItemReviewSummarySelector;
import jp.yahooapis.ss.v201808.pagefeeditem.PageFeedItemReviewSummaryValues;
import jp.yahooapis.ss.v201808.pagefeeditem.PageFeedItemSelector;
import jp.yahooapis.ss.v201808.pagefeeditem.PageFeedItemUploadUrlOperation;
import jp.yahooapis.ss.v201808.pagefeeditem.PageFeedItemUploadUrlPage;
import jp.yahooapis.ss.v201808.pagefeeditem.PageFeedItemUploadUrlValues;

import java.util.Arrays;
import java.util.List;

/**
 * Sample Program for DynamicAdsForSearchService. Copyright (C) 2012 Yahoo Japan Corporation. All Rights Reserved.
 */
public class DynamicAdsForSearchSample {
  /**
   * main method for DynamicAdsForSearchService
   *
   * @param args command line arguments
   * @throws Exception
   */
  public static void main(String[] args) throws Exception {
    try {
      // =================================================================
      // Setting
      // =================================================================
      long accountId = SoapUtils.getAccountId();
      long campaignId = 0;
      long adGroupId = 0;
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
      PageFeedItemUploadUrlOperation pageFeedItemUploadUrlOperation = PageFeedItemServiceSample.createSampleUploadRequest(accountId, feedFolderId);
      PageFeedItemUploadUrlPage pageFeedItemUploadUrlPage = PageFeedItemServiceSample.getUploadUrl(pageFeedItemUploadUrlOperation);
      for (PageFeedItemUploadUrlValues value : pageFeedItemUploadUrlPage.getValues()) {
        uploadUrl = value.getUploadUrl().getUrl();
      }

      // upload
      // call API
      long uploadJobId = PageFeedItemServiceSample.upload(uploadUrl, fileName);

      // checkJobStatus
      PageFeedItemJobStatusSelector pageFeedItemJobStatusSelector = PageFeedItemServiceSample.createGetJobStatusRequest(accountId, PageFeedItemJobType.UPLOAD, uploadJobId);
      PageFeedItemServiceSample.checkJobStatus(pageFeedItemJobStatusSelector);

      // getReviewSummary
      PageFeedItemReviewSummarySelector pageFeedItemReviewSummarySelector = PageFeedItemServiceSample.createGetReviewSummaryRequest(accountId, Arrays.asList(feedFolderId));
      List<PageFeedItemReviewSummaryValues> reviewSummaryValues = PageFeedItemServiceSample.getReviewSummary(pageFeedItemReviewSummarySelector);

      // get
      PageFeedItemSelector pageFeedItemSelector = PageFeedItemServiceSample.createGetRequest(accountId, Arrays.asList(feedFolderId));
      List<PageFeedItemReturnValues> getValues = PageFeedItemServiceSample.get(pageFeedItemSelector);

      // addDownloadJob
      PageFeedItemDownloadJobOperation operation = PageFeedItemServiceSample.createAddDownloadJobRequest(accountId, feedFolderId);
      List<PageFeedItemDownloadJobValues> pageFeedItemDownloadJobValues = PageFeedItemServiceSample.addDownloadJob(operation);
      long jobId = -1L;
      for (PageFeedItemDownloadJobValues values : pageFeedItemDownloadJobValues) {
        jobId = values.getJob().getJobId();
      }

      // checkJobStatus
      pageFeedItemJobStatusSelector = PageFeedItemServiceSample.createGetJobStatusRequest(accountId, PageFeedItemJobType.DOWNLOAD, jobId);
      List<PageFeedItemJobValues> pageFeedItemJobValues = PageFeedItemServiceSample.checkJobStatus(pageFeedItemJobStatusSelector);
      // downloadUrl取得
      for(PageFeedItemJobValues values : pageFeedItemJobValues){
        if(values.getJob() instanceof PageFeedItemDownloadJob) {
          downloadUrl = ((PageFeedItemDownloadJob) values.getJob()).getDownloadUrl();
        }
      }

      // download
      PageFeedItemServiceSample.download(downloadUrl, fileName);

      // =================================================================
      // CampaignService::ADD FOR DSA
      // =================================================================
      // Set Operation
      CampaignOperation addCampaignOperation = CampaignServiceSample.createSampleDasAddRequest(null, accountId, feedFolderId);

      // Run
      List<CampaignValues> addCampaignValues = CampaignServiceSample.add(addCampaignOperation);
      // set CampaignId
      for (CampaignValues value : addCampaignValues) {
        campaignId = value.getCampaign().getCampaignId();
      }

      // =================================================================
      // AdGroupService ADD For DSA
      // =================================================================
      // Set Operation
      AdGroupOperation addAdGroupOperation = AdGroupServiceSample.createSampleDasAddRequest(null, accountId, campaignId);

      // Run
      List<AdGroupValues> adGroupValues = AdGroupServiceSample.add(addAdGroupOperation);
      // set adGroupId
      for (AdGroupValues value : adGroupValues) {
        adGroupId = value.getAdGroup().getAdGroupId();
      }

      // =================================================================
      // AdGroupAdService
      // =================================================================
      AdGroupAdOperation addAdGroupAdOperation = AdGroupAdServiceSample.createSampleDasAddRequest(null, accountId, campaignId, adGroupId);
      List<AdGroupAdValues> adGroupAdValues =  AdGroupAdServiceSample.add(addAdGroupAdOperation);

      // =================================================================
      // CampaignWebpageService
      // =================================================================
      // add
      CampaignWebpageOperation addCampaignWebpageOperation = CampaignWebpageServiceSample.createSampleAddRequest(accountId, campaignId);
      List<CampaignWebpageValues> campaignWebpageValues = CampaignWebpageServiceSample.add(addCampaignWebpageOperation);

      // =================================================================
      // AdGroupWebpageService
      // =================================================================
      // add
      AdGroupWebpageOperation addAdGroupWebpageOperation = AdGroupWebpageServiceSample.createSampleAddRequest(accountId, campaignId, adGroupId);
      List<AdGroupWebpageValues> adGroupWebpageValues = AdGroupWebpageServiceSample.add(addAdGroupWebpageOperation);

      // set
      AdGroupWebpageOperation setAdGroupWebpageOperation = AdGroupWebpageServiceSample.createSampleSetRequest(accountId, adGroupWebpageValues);
      adGroupWebpageValues = AdGroupWebpageServiceSample.set(setAdGroupWebpageOperation);

      // remove
      AdGroupWebpageOperation removeAdGroupWebpageOperation = AdGroupWebpageServiceSample.createSampleRemoveRequest(accountId, adGroupWebpageValues);
      adGroupWebpageValues = AdGroupWebpageServiceSample.remove(removeAdGroupWebpageOperation);

      // =================================================================
      // CampaignWebpageService
      // =================================================================
      // remove
      CampaignWebpageOperation removeCampaignWebpageOperation = CampaignWebpageServiceSample.createSampleRemoveRequest(accountId, campaignWebpageValues);
      campaignWebpageValues = CampaignWebpageServiceSample.remove(removeCampaignWebpageOperation);

      //=================================================================
      // remove AdGroupAd, AdGroup, Campaign, FeedFolderService
      //=================================================================
      // AdGroupAdService
      AdGroupAdOperation removeAdGroupAdOperation = AdGroupAdServiceSample.createSampleRemoveRequest(accountId, adGroupAdValues);

      // Run
      AdGroupAdServiceSample.remove(removeAdGroupAdOperation);

      // =================================================================
      // AdGroupService REMOVE
      // =================================================================
      // Set Operation
      AdGroupOperation removeAdGroupOperation = AdGroupServiceSample.createSampleRemoveRequest(accountId, adGroupValues);

      // Run
      AdGroupServiceSample.remove(removeAdGroupOperation);

      // =================================================================
      // CampaignService::REMOVE
      // =================================================================
      // Set Operation
      CampaignOperation removeCampaignOperation = CampaignServiceSample.createSampleRemoveRequest(accountId, addCampaignValues);

      // Run
      CampaignServiceSample.remove(removeCampaignOperation);

      // =================================================================
      // FeedFolderService REMOVE
      // =================================================================
      // Set Operation
      FeedFolderOperation removeFeedFolderOperation = FeedFolderServiceSample.createSampleRemoveRequest(accountId, feedFolderValues);

      // Run
      FeedFolderServiceSample.remove(removeFeedFolderOperation);

    } catch (Exception e) {
      e.printStackTrace();
      throw e;
    }
  }
}

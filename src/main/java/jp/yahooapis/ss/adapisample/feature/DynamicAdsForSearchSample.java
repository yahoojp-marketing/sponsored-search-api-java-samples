/**
 * Copyright (C) 2019 Yahoo Japan Corporation. All Rights Reserved.
 */
package jp.yahooapis.ss.adapisample.feature;

import jp.yahooapis.ss.adapisample.basic.adgroup.AdGroupServiceSample;
import jp.yahooapis.ss.adapisample.basic.adgroupad.AdGroupAdServiceSample;
import jp.yahooapis.ss.adapisample.basic.adgroupwebpage.AdGroupWebpageServiceSample;
import jp.yahooapis.ss.adapisample.basic.campaign.CampaignServiceSample;
import jp.yahooapis.ss.adapisample.basic.campaignwebpage.CampaignWebpageServiceSample;
import jp.yahooapis.ss.adapisample.basic.feedfolder.FeedFolderServiceSample;
import jp.yahooapis.ss.adapisample.basic.pagefeedItem.PageFeedItemServiceSample;
import jp.yahooapis.ss.adapisample.repository.ValuesRepositoryFacade;
import jp.yahooapis.ss.adapisample.util.SoapUtils;
import jp.yahooapis.ss.adapisample.util.ValuesHolder;
import jp.yahooapis.ss.v201901.adgroup.AdGroupOperation;
import jp.yahooapis.ss.v201901.adgroup.AdGroupValues;
import jp.yahooapis.ss.v201901.adgroupad.AdGroupAdOperation;
import jp.yahooapis.ss.v201901.adgroupad.AdGroupAdSelector;
import jp.yahooapis.ss.v201901.adgroupad.AdGroupAdValues;
import jp.yahooapis.ss.v201901.adgroupwebpage.AdGroupWebpage;
import jp.yahooapis.ss.v201901.adgroupwebpage.AdGroupWebpageOperation;
import jp.yahooapis.ss.v201901.adgroupwebpage.AdGroupWebpageSelector;
import jp.yahooapis.ss.v201901.adgroupwebpage.AdGroupWebpageValues;
import jp.yahooapis.ss.v201901.campaign.CampaignOperation;
import jp.yahooapis.ss.v201901.campaign.CampaignType;
import jp.yahooapis.ss.v201901.campaign.CampaignValues;
import jp.yahooapis.ss.v201901.campaignwebpage.CampaignWebpage;
import jp.yahooapis.ss.v201901.campaignwebpage.CampaignWebpageOperation;
import jp.yahooapis.ss.v201901.campaignwebpage.CampaignWebpageSelector;
import jp.yahooapis.ss.v201901.campaignwebpage.CampaignWebpageValues;
import jp.yahooapis.ss.v201901.feedfolder.FeedFolderOperation;
import jp.yahooapis.ss.v201901.feedfolder.FeedFolderPlaceholderType;
import jp.yahooapis.ss.v201901.feedfolder.FeedFolderSelector;
import jp.yahooapis.ss.v201901.feedfolder.FeedFolderValues;
import jp.yahooapis.ss.v201901.feedfolder.Operator;
import jp.yahooapis.ss.v201901.pagefeeditem.PageFeedItemDownloadJob;
import jp.yahooapis.ss.v201901.pagefeeditem.PageFeedItemDownloadJobOperation;
import jp.yahooapis.ss.v201901.pagefeeditem.PageFeedItemDownloadJobValues;
import jp.yahooapis.ss.v201901.pagefeeditem.PageFeedItemJobStatusSelector;
import jp.yahooapis.ss.v201901.pagefeeditem.PageFeedItemJobType;
import jp.yahooapis.ss.v201901.pagefeeditem.PageFeedItemJobValues;
import jp.yahooapis.ss.v201901.pagefeeditem.PageFeedItemReviewSummarySelector;
import jp.yahooapis.ss.v201901.pagefeeditem.PageFeedItemSelector;
import jp.yahooapis.ss.v201901.pagefeeditem.PageFeedItemUploadUrlOperation;
import jp.yahooapis.ss.v201901.pagefeeditem.PageFeedItemUploadUrlPage;
import jp.yahooapis.ss.v201901.pagefeeditem.PageFeedItemUploadUrlValues;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * example DynamicAdsForSearch operation and Utility method collection.
 */
public class DynamicAdsForSearchSample {

  /**
   * example DynamicAdsForSearch operation.
   *
   * @param args command line arguments
   */
  public static void main(String[] args) throws Exception {

    // =================================================================
    // Setting
    // =================================================================
    ValuesHolder valuesHolder = new ValuesHolder();
    ValuesRepositoryFacade valuesRepositoryFacade = new ValuesRepositoryFacade(valuesHolder);
    long accountId = SoapUtils.getAccountId();
    String uploadUrl = null;
    String downloadUrl = null;
    String uploadFileName = "pageFeedItemUploadSample.csv";
    String downloadFileName = "pageFeedItemDownloadSample.csv";

    try {

      // =================================================================
      // FeedFolderService
      // =================================================================
      // ADD
      FeedFolderOperation addRequestFeedFolder = FeedFolderServiceSample.buildExampleMutateRequest( //
          Operator.ADD, accountId, Arrays.asList(FeedFolderServiceSample.createExampleDynamicAdForSearchFeedFolder(accountId)));

      List<FeedFolderValues> addResponseFeedFolder = FeedFolderServiceSample.mutate(addRequestFeedFolder);
      valuesRepositoryFacade.getValuesHolder().setFeedFolderValuesList(addResponseFeedFolder);
      Long feedFolderId = valuesRepositoryFacade.getFeedFolderValuesRepository().findFeedFolderId(FeedFolderPlaceholderType.DYNAMIC_AD_FOR_SEARCH_PAGE_FEEDS);

      // GET
      FeedFolderSelector getRequestFeedFolder = FeedFolderServiceSample.buildExampleGetRequest(accountId, Arrays.asList(feedFolderId));
      FeedFolderServiceSample.get(getRequestFeedFolder);

      //=================================================================
      // PageFeedItemService
      //=================================================================
      // getUploadUrl
      PageFeedItemUploadUrlOperation getUploadUrlRequest = PageFeedItemServiceSample.buildExampleGetUploadUrl(accountId, feedFolderId);
      PageFeedItemUploadUrlPage getUploadUrlResponse = PageFeedItemServiceSample.getUploadUrl(getUploadUrlRequest);
      for (PageFeedItemUploadUrlValues value : getUploadUrlResponse.getValues()) {
        uploadUrl = value.getUploadUrl().getUrl();
      }

      // upload
      long uploadJobId = PageFeedItemServiceSample.upload(uploadUrl, uploadFileName);

      // check job status
      PageFeedItemServiceSample.checkJobStatus(accountId, PageFeedItemJobType.UPLOAD, Arrays.asList(uploadJobId));

      // getReviewSummary
      PageFeedItemReviewSummarySelector getReviewSummaryRequest = PageFeedItemServiceSample.buildExampleGetReviewSummary(accountId, Arrays.asList(feedFolderId));
      PageFeedItemServiceSample.getReviewSummary(getReviewSummaryRequest);

      // get
      PageFeedItemSelector getRequest = PageFeedItemServiceSample.buildExampleGetRequest(accountId, Arrays.asList(feedFolderId));
      PageFeedItemServiceSample.get(getRequest);

      // addDownloadJob
      PageFeedItemDownloadJobOperation addDownloadJobRequest = PageFeedItemServiceSample.buildExampleAddDownloadJob(accountId, Arrays.asList(feedFolderId));
      List<PageFeedItemDownloadJobValues> addDownloadJobResponse = PageFeedItemServiceSample.addDownloadJob(addDownloadJobRequest);
      long jobId = -1L;
      for (PageFeedItemDownloadJobValues values : addDownloadJobResponse) {
        jobId = values.getJob().getJobId();
      }

      // check job status
      PageFeedItemServiceSample.checkJobStatus(accountId, PageFeedItemJobType.DOWNLOAD, Arrays.asList(jobId));

      // getJobStatus
      PageFeedItemJobStatusSelector getJobStatusRequest = PageFeedItemServiceSample.buildExampleGetJobStatus(accountId, PageFeedItemJobType.DOWNLOAD, Arrays.asList(jobId));
      List<PageFeedItemJobValues> getJobStatusResponse = PageFeedItemServiceSample.getJobStatus(getJobStatusRequest);
      for (PageFeedItemJobValues values : getJobStatusResponse) {
        if (values.getJob() instanceof PageFeedItemDownloadJob) {
          downloadUrl = ((PageFeedItemDownloadJob) values.getJob()).getDownloadUrl();
        }
      }

      // download
      PageFeedItemServiceSample.download(downloadUrl, downloadFileName);

      // =================================================================
      // CampaignService
      // =================================================================
      // ADD
      CampaignOperation addRequestCampaign = CampaignServiceSample.buildExampleMutateRequest( //
          jp.yahooapis.ss.v201901.campaign.Operator.ADD, //
          accountId, //
          Arrays.asList(CampaignServiceSample.createExampleDynamicAdsForSearchCampaign( //
              "SampleManualCpcDynamicAdsForSearchCampaign_", //
              Arrays.asList(feedFolderId), //
              CampaignServiceSample.createManualBiddingCampaignBiddingStrategy()) //
          ));
      List<CampaignValues> addResponseCampaign = CampaignServiceSample.mutate(addRequestCampaign);
      valuesRepositoryFacade.getValuesHolder().setCampaignValuesList(addResponseCampaign);
      Long campaignId = valuesRepositoryFacade.getCampaignValuesRepository().findCampaignId(CampaignType.DYNAMIC_ADS_FOR_SEARCH);

      // GET
      CampaignServiceSample.checkStatus(Arrays.asList(campaignId));

      // SET
      CampaignOperation setRequestCampaign = CampaignServiceSample.buildExampleMutateRequest( //
          jp.yahooapis.ss.v201901.campaign.Operator.SET, //
          accountId, //
          CampaignServiceSample.createExampleSetRequest(valuesRepositoryFacade.getCampaignValuesRepository().getCampaigns()) //
      );
      CampaignServiceSample.mutate(setRequestCampaign);

      // =================================================================
      // AdGroupService
      // =================================================================
      // ADD
      AdGroupOperation addRequestAdGroup = AdGroupServiceSample.buildExampleMutateRequest( //
          jp.yahooapis.ss.v201901.adgroup.Operator.ADD, //
          accountId, //
          Arrays.asList(AdGroupServiceSample.createExampleStandardAdGroup(campaignId)) //
      );
      List<AdGroupValues> addResponseAdGroup = AdGroupServiceSample.mutate(addRequestAdGroup);
      valuesRepositoryFacade.getValuesHolder().setAdGroupValuesList(addResponseAdGroup);
      Long adGroupId = valuesRepositoryFacade.getAdGroupValuesRepository().findAdGroupId(campaignId);

      // GET
      AdGroupServiceSample.checkStatus(valuesRepositoryFacade.getAdGroupValuesRepository().getAdGroups());

      // SET
      AdGroupOperation setRequestAdGroup = AdGroupServiceSample.buildExampleMutateRequest( //
          jp.yahooapis.ss.v201901.adgroup.Operator.SET, //
          accountId, //
          AdGroupServiceSample.createExampleSetRequest(valuesRepositoryFacade.getAdGroupValuesRepository().getAdGroups()) //
      );
      AdGroupServiceSample.mutate(setRequestAdGroup);

      // =================================================================
      // AdGroupAdService
      // =================================================================
      // ADD
      AdGroupAdOperation addRequestAdGroupAd = AdGroupAdServiceSample.buildExampleMutateRequest( //
          jp.yahooapis.ss.v201901.adgroupad.Operator.ADD, //
          accountId, //
          Arrays.asList(AdGroupAdServiceSample.createExampleDynamicSearchLinkedAd(campaignId, adGroupId)) //
      );
      List<AdGroupAdValues> addResponseAdGroupAd = AdGroupAdServiceSample.mutate(addRequestAdGroupAd);
      valuesRepositoryFacade.getValuesHolder().setAdGroupAdValuesList(addResponseAdGroupAd);

      // SET
      AdGroupAdOperation setRequestAdGroupAd = AdGroupAdServiceSample.buildExampleMutateRequest( //
          jp.yahooapis.ss.v201901.adgroupad.Operator.SET, //
          accountId, //
          AdGroupAdServiceSample.createExampleSetRequest(valuesRepositoryFacade.getAdGroupAdValuesRepository().getAdGroupAds())  //
      );
      AdGroupAdServiceSample.mutate(setRequestAdGroupAd);

      // GET
      AdGroupAdSelector getRequestAdGroupAd = AdGroupAdServiceSample.buildExampleGetRequest(accountId, valuesRepositoryFacade.getAdGroupAdValuesRepository().getAdGroupAds());
      AdGroupAdServiceSample.get(getRequestAdGroupAd);

      // =================================================================
      // CampaignWebpageService
      // =================================================================
      // ADD
      CampaignWebpageOperation addRequestCampaignWebpage = CampaignWebpageServiceSample.buildExampleMutateRequest( //
          jp.yahooapis.ss.v201901.campaignwebpage.Operator.ADD, //
          accountId, //
          Arrays.asList(CampaignWebpageServiceSample.createExampleCampaignWebpage(campaignId)) //
      );
      List<CampaignWebpageValues> addResponseCampaignWebpage = CampaignWebpageServiceSample.mutate(addRequestCampaignWebpage);
      List<CampaignWebpage> campaignWebpages = new ArrayList<>();
      for (CampaignWebpageValues values : addResponseCampaignWebpage) {
        campaignWebpages.add(values.getCampaignWebpage());
      }

      // GET
      CampaignWebpageSelector getRequestCampaignWebpage = CampaignWebpageServiceSample.buildExampleGetRequest(accountId, campaignWebpages);
      CampaignWebpageServiceSample.get(getRequestCampaignWebpage);

      // =================================================================
      // AdGroupWebpageService
      // =================================================================
      // ADD
      AdGroupWebpageOperation addRequestAdGroupWebpage = AdGroupWebpageServiceSample.buildExampleMutateRequest( //
          jp.yahooapis.ss.v201901.adgroupwebpage.Operator.ADD, //
          accountId, //
          Arrays.asList(AdGroupWebpageServiceSample.createExampleAdGroupWebpage(campaignId, adGroupId)) //
      );

      List<AdGroupWebpageValues> addResponseAdGroupWebpage = AdGroupWebpageServiceSample.mutate(addRequestAdGroupWebpage);
      List<AdGroupWebpage> adGourpWebpages = new ArrayList<>();
      for (AdGroupWebpageValues values : addResponseAdGroupWebpage) {
        adGourpWebpages.add(values.getAdGroupWebpage());
      }

      // SET
      AdGroupWebpageOperation setRequestAdGroupWebpage = AdGroupWebpageServiceSample.buildExampleMutateRequest( //
          jp.yahooapis.ss.v201901.adgroupwebpage.Operator.SET, //
          accountId, //
          AdGroupWebpageServiceSample.createExampleSetRequest(adGourpWebpages) //
      );
      AdGroupWebpageServiceSample.mutate(setRequestAdGroupWebpage);

      // GET
      AdGroupWebpageSelector getRequestAdGroupWebpage = AdGroupWebpageServiceSample.buildExampleGetRequest(accountId, adGourpWebpages);
      AdGroupWebpageServiceSample.get(getRequestAdGroupWebpage);

    } catch (Exception e) {
      e.printStackTrace();
      throw e;
    } finally {
      // =================================================================
      // Cleanup
      // =================================================================
      CampaignServiceSample.cleanup(valuesHolder);
    }
  }
}

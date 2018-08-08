package jp.co.yahoo.ad_api_sample.adDisplayOptionSample;

import jp.co.yahoo.ad_api_sample.adCustomizerSample.FeedItemServiceSample;
import jp.co.yahoo.ad_api_sample.util.SoapUtils;
import jp.yahooapis.ss.v201808.Paging;
import jp.yahooapis.ss.v201808.adgroupfeed.AdGroupFeedOperation;
import jp.yahooapis.ss.v201808.adgroupfeed.AdGroupFeedSelector;
import jp.yahooapis.ss.v201808.adgroupfeed.AdGroupFeedValues;
import jp.yahooapis.ss.v201808.campaignfeed.CampaignFeedOperation;
import jp.yahooapis.ss.v201808.campaignfeed.CampaignFeedSelector;
import jp.yahooapis.ss.v201808.campaignfeed.CampaignFeedValues;
import jp.yahooapis.ss.v201808.feeditem.ApprovalStatus;
import jp.yahooapis.ss.v201808.feeditem.FeedItemOperation;
import jp.yahooapis.ss.v201808.feeditem.FeedItemPlaceholderType;
import jp.yahooapis.ss.v201808.feeditem.FeedItemSelector;
import jp.yahooapis.ss.v201808.feeditem.FeedItemValues;

import java.util.ArrayList;
import java.util.List;

/**
 * Sample Program for FeedItemService,CampaignFeedService,AdGroupFeedService Copyright (C) 2013
 * Yahoo Japan Corporation. All Rights Reserved.
 */
public class AdDisplayOptionSample {

  /**
   * main method for AdDisplayOptionSample
   *
   * @param args command line arguments
   */
  public static void main(String[] args) throws Exception {
    try {
      // =================================================================
      // Setting
      // =================================================================
      long accountId = SoapUtils.getAccountId();
      long campaignId = SoapUtils.getCampaignId();
      long adGroupId = SoapUtils.getAdGroupId();
      long feedItemId1 = -1;
      long feedItemId2 = -1;

      // =================================================================
      // FeedItemService
      // =================================================================
      // ADD QUICKLINK
      FeedItemOperation addFeedItemOperation_quicklink = FeedItemServiceSample.QuicklinkSampleFeedItem.createSampleAddRequest(accountId);
      List<FeedItemValues> addfeedItemValues_quicklink = FeedItemServiceSample.add(addFeedItemOperation_quicklink);
      // GET QUICKLINK
      FeedItemSelector feedItemSelector1 = FeedItemServiceSample.createSampleGetRequest(accountId, addfeedItemValues_quicklink);
      FeedItemServiceSample.get(feedItemSelector1);
      // wait for sandbox review
      Thread.sleep(30000);
      // ADD CALLEXTENSION
      FeedItemOperation addFeedItemOperation_callextension = FeedItemServiceSample.CallextensionSampleFeedItem.createSampleAddRequest(accountId);
      List<FeedItemValues> addfeedItemValues_callextension = FeedItemServiceSample.add(addFeedItemOperation_callextension);
      // GET CALLEXTENSION
      FeedItemSelector feedItemSelector2 = FeedItemServiceSample.createSampleGetRequest(accountId, addfeedItemValues_callextension);
      FeedItemServiceSample.get(feedItemSelector2);

      // =================================================================
      // FeedItemService GET
      // =================================================================
      // Run
      boolean allApproved = true;
      List<Long> feedItemIds = new ArrayList<>();
      addfeedItemValues_quicklink.stream().forEach(feedItemValues -> feedItemIds.add(feedItemValues.getFeedItem().getFeedItemId()));
      addfeedItemValues_callextension.stream().forEach(feedItemValues -> feedItemIds.add(feedItemValues.getFeedItem().getFeedItemId()));
      // call 30sec sleep * 30 = 15minute
      for (int i = 0; i < 30; i++) {
        // sleep 30 second.
        System.out.println("\n***** sleep 30 seconds for Get FeedItem  *****\n");
        Thread.sleep(30000);

        // Set Selector
        FeedItemSelector selector = new FeedItemSelector();
        selector.setAccountId(accountId);
        selector.getFeedItemIds().addAll(feedItemIds);
        Paging feedItemPaging = new Paging();
        feedItemPaging.setStartIndex(1);
        feedItemPaging.setNumberResults(20);
        selector.setPaging(feedItemPaging);

        // Run
        List<FeedItemValues> getFeedItemValues = null;
        try {
          getFeedItemValues = FeedItemServiceSample.get(selector);
        } catch (Exception e) {
          throw e;
        }
        allApproved = true;
        for (FeedItemValues feedItemValue : getFeedItemValues) {
          if (!ApprovalStatus.APPROVED.equals(feedItemValue.getFeedItem().getApprovalStatus())) {
            allApproved = false;
          } else if (ApprovalStatus.PRE_DISAPPROVED.equals(feedItemValue.getFeedItem().getApprovalStatus())
              || ApprovalStatus.POST_DISAPPROVED.equals(feedItemValue.getFeedItem().getApprovalStatus())) {
            System.out.println("Error : This FeedItem was denied.");
            feedItemValue.getFeedItem().getDisapprovalReasonCodes().stream().forEach(
                disapprovalReasonCode -> System.out.println("disapprovalReasonCode:[" + disapprovalReasonCode + "]")
            );
            System.exit(0);
          }
        }
        if (allApproved) {
          break;
        }
      }

      if (!allApproved) {
        System.out.println("Error : The review did not end.");
        System.exit(0);
      }

      // SET QUICKLINK
      FeedItemOperation setFeedItemOperation_quicklink = FeedItemServiceSample.QuicklinkSampleFeedItem.createSampleSetRequest(accountId, addfeedItemValues_quicklink);
      List<FeedItemValues> setFeedItemValues_quicklink = FeedItemServiceSample.set(setFeedItemOperation_quicklink);
      for (FeedItemValues feedItemValues : setFeedItemValues_quicklink) {
        if (feedItemValues.getFeedItem().getFeedItemId() != null) {
          feedItemId1 = feedItemValues.getFeedItem().getFeedItemId();
        }
      }

      // SET CALLEXTENSION
      FeedItemOperation setFeedItemOperation_callextension = FeedItemServiceSample.CallextensionSampleFeedItem.createSampleSetRequest(accountId, addfeedItemValues_callextension);
      List<FeedItemValues> setFeedItemValues_callextension = FeedItemServiceSample.set(setFeedItemOperation_callextension);
      for (FeedItemValues feedItemValues : setFeedItemValues_callextension) {
        if (feedItemValues.getFeedItem().getFeedItemId() != null) {
          feedItemId2 = feedItemValues.getFeedItem().getFeedItemId();
        }
      }

      // =================================================================
      // CampaignFeedService::mutate(SET)
      // =================================================================
      CampaignFeedOperation setCampaignFeedOperation = CampaignFeedServiceSample.createSampleSetRequest(accountId, campaignId, feedItemId1);
      List<CampaignFeedValues> setCampaignFeedResponse = CampaignFeedServiceSample.set(setCampaignFeedOperation);

      // =================================================================
      // CampaignFeedService::get
      // =================================================================
      CampaignFeedSelector campaignFeedSelector = CampaignFeedServiceSample.createSampleGetRequest(accountId, campaignId, feedItemId1);
      List<CampaignFeedValues> getCampaignFeedResponse = CampaignFeedServiceSample.get(campaignFeedSelector);

      System.out.println("\n***** sleep 60 seconds for Approval  *****\n");
      Thread.sleep(60000);

      // =================================================================
      // AdGroupFeedService::mutate(SET)
      // =================================================================
      AdGroupFeedOperation setAdGroupFeedOperation = AdGroupFeedServiceSample.createSampleSetRequest(accountId, campaignId, adGroupId, feedItemId2);
      List<AdGroupFeedValues> setAdGroupFeedResponse = AdGroupFeedServiceSample.set(setAdGroupFeedOperation);

      // =================================================================
      // AdGroupFeedService::get
      // =================================================================
      AdGroupFeedSelector adGroupFeedSelector = AdGroupFeedServiceSample.createSampleGetRequest(accountId, campaignId, feedItemId2);
      List<AdGroupFeedValues> getAdGroupFeedResponse = AdGroupFeedServiceSample.get(adGroupFeedSelector);

      // =================================================================
      // remove FeedItemService
      // =================================================================
      FeedItemOperation removeFeedItemOperation_quicklink = FeedItemServiceSample.createSampleRemoveRequest(accountId, setFeedItemValues_quicklink);
      removeFeedItemOperation_quicklink.setPlaceholderType(FeedItemPlaceholderType.QUICKLINK);
      FeedItemServiceSample.remove(removeFeedItemOperation_quicklink);
      FeedItemOperation removeFeedItemOperation_callextension = FeedItemServiceSample.createSampleRemoveRequest(accountId, setFeedItemValues_callextension);
      removeFeedItemOperation_callextension.setPlaceholderType(FeedItemPlaceholderType.CALLEXTENSION);
      FeedItemServiceSample.remove(removeFeedItemOperation_callextension);

    } catch (Exception e) {
      e.printStackTrace();
      throw e;
    }
  }
}

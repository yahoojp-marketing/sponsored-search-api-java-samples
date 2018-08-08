package jp.co.yahoo.ad_api_sample.structuredSnippetSample;

import jp.co.yahoo.ad_api_sample.adCustomizerSample.FeedItemServiceSample;
import jp.co.yahoo.ad_api_sample.adDisplayOptionSample.AdGroupFeedServiceSample;
import jp.co.yahoo.ad_api_sample.adDisplayOptionSample.CampaignFeedServiceSample;
import jp.co.yahoo.ad_api_sample.adSample.AdGroupServiceSample;
import jp.co.yahoo.ad_api_sample.adSample.BiddingStrategyServiceSample;
import jp.co.yahoo.ad_api_sample.adSample.CampaignServiceSample;
import jp.co.yahoo.ad_api_sample.util.SoapUtils;
import jp.yahooapis.ss.v201808.Paging;
import jp.yahooapis.ss.v201808.adgroup.AdGroupOperation;
import jp.yahooapis.ss.v201808.adgroup.AdGroupValues;
import jp.yahooapis.ss.v201808.adgroupfeed.AdGroupFeed;
import jp.yahooapis.ss.v201808.adgroupfeed.AdGroupFeedList;
import jp.yahooapis.ss.v201808.adgroupfeed.AdGroupFeedOperation;
import jp.yahooapis.ss.v201808.adgroupfeed.AdGroupFeedPlaceholderType;
import jp.yahooapis.ss.v201808.adgroupfeed.AdGroupFeedSelector;
import jp.yahooapis.ss.v201808.adgroupfeed.AdGroupFeedValues;
import jp.yahooapis.ss.v201808.biddingstrategy.BiddingStrategyOperation;
import jp.yahooapis.ss.v201808.biddingstrategy.BiddingStrategyValues;
import jp.yahooapis.ss.v201808.biddingstrategy.PageOnePromotedBiddingScheme;
import jp.yahooapis.ss.v201808.campaign.CampaignOperation;
import jp.yahooapis.ss.v201808.campaign.CampaignType;
import jp.yahooapis.ss.v201808.campaign.CampaignValues;
import jp.yahooapis.ss.v201808.campaignfeed.CampaignFeed;
import jp.yahooapis.ss.v201808.campaignfeed.CampaignFeedList;
import jp.yahooapis.ss.v201808.campaignfeed.CampaignFeedOperation;
import jp.yahooapis.ss.v201808.campaignfeed.CampaignFeedPlaceholderType;
import jp.yahooapis.ss.v201808.campaignfeed.CampaignFeedSelector;
import jp.yahooapis.ss.v201808.campaignfeed.CampaignFeedValues;
import jp.yahooapis.ss.v201808.feeditem.ApprovalStatus;
import jp.yahooapis.ss.v201808.feeditem.FeedItemOperation;
import jp.yahooapis.ss.v201808.feeditem.FeedItemPlaceholderType;
import jp.yahooapis.ss.v201808.feeditem.FeedItemSelector;
import jp.yahooapis.ss.v201808.feeditem.FeedItemValues;

import java.util.List;

/**
 * Sample Program for StructuredSnippetSample. Copyright (C) 2012 Yahoo Japan Corporation. All Rights
 * Reserved.
 */
public class StructuredSnippetSample {

  /**
   * main method for StructuredSnippetSample
   *
   * @param args command line arguments
   */
  public static void main(String[] args) {
    try {
      // =================================================================
      // Setting
      // =================================================================
      long accountId = SoapUtils.getAccountId();
      long biddingStrategyId = SoapUtils.getBiddingStrategyId();
      long campaignId = SoapUtils.getCampaignId();
      long appCampaignId = SoapUtils.getAppCampaignId();
      long adGroupId = SoapUtils.getAdGroupId();

      // =================================================================
      // BiddingStrategyService::mutate(ADD)
      // =================================================================
      List<BiddingStrategyValues> biddingStrategyValues = null;
      if (biddingStrategyId == 9999999999l) {
        BiddingStrategyOperation addBiddingStrategyOperation = BiddingStrategyServiceSample.createSampleAddRequest(accountId);
        biddingStrategyValues = BiddingStrategyServiceSample.mutate(addBiddingStrategyOperation);
        for (BiddingStrategyValues value : biddingStrategyValues) {
          if (value.getBiddingStrategy().getBiddingScheme() instanceof PageOnePromotedBiddingScheme) {
            biddingStrategyId = value.getBiddingStrategy().getBiddingStrategyId();
          }
        }
      }

      // sleep 30 second.
      System.out.println("\n***** sleep 30 seconds *****\n");
      Thread.sleep(30000);

      // =================================================================
      // CampaignService::mutate(ADD)
      // =================================================================
      List<CampaignValues> campaignValues = null;
      if (campaignId == 9999999999l || appCampaignId == 9999999999l) {
        CampaignOperation addCampaignOperation = CampaignServiceSample.createSampleAddRequest(accountId, biddingStrategyId);
        campaignValues = CampaignServiceSample.add(addCampaignOperation);
        for (CampaignValues value : campaignValues) {
          if (CampaignType.STANDARD.equals(value.getCampaign().getCampaignType())) {
            campaignId = value.getCampaign().getCampaignId();
          } else if (CampaignType.MOBILE_APP.equals(value.getCampaign().getCampaignType())) {
            appCampaignId = value.getCampaign().getCampaignId();
          }
        }
      }

      // =================================================================
      // AdGroupService::mutate(ADD)
      // =================================================================
      List<AdGroupValues> adGroupValues = null;
      if (adGroupId == 9999999999l) {
        AdGroupOperation addAdGroupOperation = AdGroupServiceSample.createSampleAddRequest(accountId, campaignId, appCampaignId);
        adGroupValues = AdGroupServiceSample.add(addAdGroupOperation);
        for (AdGroupValues value : adGroupValues) {
          if (value.getAdGroup().getCampaignId() == campaignId) {
            adGroupId = value.getAdGroup().getAdGroupId();
          }
        }
      }

      // =================================================================
      // FeedItemService
      // =================================================================
      // ADD
      FeedItemOperation addFeedItemOperation = FeedItemServiceSample.StructuredSnippetSampleFeedItem.createSampleAddRequest(accountId);
      List<FeedItemValues> feedItemValues = FeedItemServiceSample.add(addFeedItemOperation);

      // =================================================================
      // FeedItemService GET
      // =================================================================
      // Run
      boolean feedItemAllApproved = true;

      // call 30sec sleep * 30 = 15minute
      for (int i = 0; i < 30; i++) {
        // sleep 30 second.
        System.out.println("\n***** sleep 30 seconds for Get FeedItem  *****\n");
        Thread.sleep(30000);

        FeedItemSelector feedItemSelector1 = FeedItemServiceSample.createSampleGetRequest(accountId, feedItemValues);
        List<FeedItemValues> getFeedItemValues = FeedItemServiceSample.get(feedItemSelector1);

        feedItemAllApproved = true;
        for (FeedItemValues feedItemValue : getFeedItemValues) {
          if (!ApprovalStatus.APPROVED.equals(feedItemValue.getFeedItem().getApprovalStatus())) {
            feedItemAllApproved = false;
          } else if (ApprovalStatus.PRE_DISAPPROVED.equals(feedItemValue.getFeedItem().getApprovalStatus())
              || ApprovalStatus.POST_DISAPPROVED.equals(feedItemValue.getFeedItem().getApprovalStatus())) {
            System.out.println("Error : This FeedItem was denied.");
            feedItemValue.getFeedItem().getDisapprovalReasonCodes().stream().forEach(
                disapprovalReasonCode -> System.out.println("disapprovalReasonCode:[" + disapprovalReasonCode + "]")
            );
          }
        }
        if (feedItemAllApproved) {
          break;
        }
      }

      // SET
      FeedItemOperation setFeedItemOperation = FeedItemServiceSample.StructuredSnippetSampleFeedItem.createSampleSetRequest(accountId, feedItemValues);
      feedItemValues = FeedItemServiceSample.set(setFeedItemOperation);

      // =================================================================
      // CampaignFeedService
      // =================================================================
      // SET
      CampaignFeedOperation campaignFeedOperation = createSampleCampaignFeedSetRequest(accountId, campaignId, feedItemValues);
      List<CampaignFeedValues> campaignFeedValues = CampaignFeedServiceSample.set(campaignFeedOperation);

      // GET
      CampaignFeedSelector campaignFeedSelector = createSampleCampaignFeedGetRequest(accountId, campaignFeedValues);
      CampaignFeedServiceSample.get(campaignFeedSelector);

      // =================================================================
      // AdGroupFeedService
      // =================================================================
      // SET
      AdGroupFeedOperation adGroupFeedOperation = createSampleAdGroupFeedSetRequest(accountId, campaignId, adGroupId, feedItemValues);
      List<AdGroupFeedValues> adGroupFeedValues = AdGroupFeedServiceSample.set(adGroupFeedOperation);

      // GET
      AdGroupFeedSelector adGroupFeedSelector = createSampleAdGroupFeedGetRequest(accountId, adGroupFeedValues);
      AdGroupFeedServiceSample.get(adGroupFeedSelector);

      // =================================================================
      // remove FeefItemService, AdGroupService, Campaign, BiddingStrategy
      // =================================================================
      // FeefItemService
      FeedItemOperation removeFeedItemOperation = FeedItemServiceSample.createSampleRemoveRequest(accountId, feedItemValues);
      removeFeedItemOperation.setPlaceholderType(FeedItemPlaceholderType.STRUCTURED_SNIPPET);
      FeedItemServiceSample.remove(removeFeedItemOperation);

      // AdGroupService
      if (adGroupValues != null) {
        AdGroupOperation removeAdGroupOperation = AdGroupServiceSample.createSampleRemoveRequest(accountId, adGroupValues);
        AdGroupServiceSample.remove(removeAdGroupOperation);
      }

      // Campaign
      if (campaignValues != null) {
        CampaignOperation removeCampaignOperation = CampaignServiceSample.createSampleRemoveRequest(accountId, campaignValues);
        CampaignServiceSample.remove(removeCampaignOperation);
      }

      // BiddingStrategy
      if (biddingStrategyValues != null) {
        BiddingStrategyOperation removeBiddingStrategyOperation = BiddingStrategyServiceSample.createSampleRemoveRequest(accountId, biddingStrategyValues);
        BiddingStrategyServiceSample.mutate(removeBiddingStrategyOperation);
      }
    } catch (Exception ex) {
      ex.printStackTrace();
    }
  }

  /**
   * Sample Request for CampaignFeedService SET.
   *
   * @return CampaignFeedOperation
   */
  private static CampaignFeedOperation createSampleCampaignFeedSetRequest(long accountId, long campaignId, List<FeedItemValues> feedItemValues) {

    // Set Operation
    CampaignFeedOperation campaignFeedOperation = new CampaignFeedOperation();
    campaignFeedOperation.setOperator(jp.yahooapis.ss.v201808.campaignfeed.Operator.SET);
    campaignFeedOperation.setAccountId(accountId);

    // Set CampaignFeedList
    CampaignFeedList campaignFeedList = new CampaignFeedList();
    campaignFeedList.setAccountId(accountId);
    campaignFeedList.setCampaignId(campaignId);
    campaignFeedList.setPlaceholderType(CampaignFeedPlaceholderType.STRUCTURED_SNIPPET);

    // Set CampaignFeed
    CampaignFeed campaignFeed = new CampaignFeed();
    campaignFeed.setFeedItemId(feedItemValues.get(0).getFeedItem().getFeedItemId());

    campaignFeedList.getCampaignFeed().add(campaignFeed);
    campaignFeedOperation.getOperand().add(campaignFeedList);
    return campaignFeedOperation;
  }

  /**
   * Sample Request for CampaignFeedService GET.
   *
   * @return CampaignFeedSelector
   */
  private static CampaignFeedSelector createSampleCampaignFeedGetRequest(long accountId, List<CampaignFeedValues> campaignFeedValues) {

    // Set Selector
    CampaignFeedSelector campaignFeedSelector = new CampaignFeedSelector();
    campaignFeedSelector.setAccountId(accountId);
    campaignFeedSelector.getCampaignIds().add(campaignFeedValues.get(0).getCampaignFeedList().getCampaignFeed().get(0).getCampaignId());
    campaignFeedSelector.getFeedItemIds().add(campaignFeedValues.get(0).getCampaignFeedList().getCampaignFeed().get(0).getFeedItemId());
    campaignFeedSelector.getPlaceholderTypes().add(CampaignFeedPlaceholderType.STRUCTURED_SNIPPET);
    Paging paging = new Paging();
    paging.setStartIndex(1);
    paging.setNumberResults(20);
    campaignFeedSelector.setPaging(paging);

    return campaignFeedSelector;
  }

  /**
   * Sample Request for AdGroupFeedService SET.
   *
   * @return AdGroupFeedOperation
   */
  private static AdGroupFeedOperation createSampleAdGroupFeedSetRequest(long accountId, long campaignId, long adGroupId, List<FeedItemValues> feedItemValues) {

    // Set Operation
    AdGroupFeedOperation adGroupFeedOperation = new AdGroupFeedOperation();
    adGroupFeedOperation.setOperator(jp.yahooapis.ss.v201808.adgroupfeed.Operator.SET);
    adGroupFeedOperation.setAccountId(accountId);

    // Set AdGroupFeedList
    AdGroupFeedList adGroupFeedList = new AdGroupFeedList();
    adGroupFeedList.setAccountId(accountId);
    adGroupFeedList.setCampaignId(campaignId);
    adGroupFeedList.setAdGroupId(adGroupId);
    adGroupFeedList.setPlaceholderType(AdGroupFeedPlaceholderType.STRUCTURED_SNIPPET);

    // Set AdGroupFeed
    AdGroupFeed adGroupFeed = new AdGroupFeed();
    adGroupFeed.setFeedItemId(feedItemValues.get(0).getFeedItem().getFeedItemId());

    adGroupFeedList.getAdGroupFeed().add(adGroupFeed);
    adGroupFeedOperation.getOperand().add(adGroupFeedList);
    return adGroupFeedOperation;
  }

  /**
   * Sample Request for AdGroupFeedService GET.
   *
   * @return AdGroupFeedSelector
   */
  private static AdGroupFeedSelector createSampleAdGroupFeedGetRequest(long accountId, List<AdGroupFeedValues> adGroupFeedValues) {

    // Set Selector
    AdGroupFeedSelector adGroupFeedSelector = new AdGroupFeedSelector();
    adGroupFeedSelector.setAccountId(accountId);
    adGroupFeedSelector.getCampaignIds().add(adGroupFeedValues.get(0).getAdGroupFeedList().getAdGroupFeed().get(0).getCampaignId());
    adGroupFeedSelector.getFeedItemIds().add(adGroupFeedValues.get(0).getAdGroupFeedList().getAdGroupFeed().get(0).getFeedItemId());
    adGroupFeedSelector.getPlaceholderTypes().add(AdGroupFeedPlaceholderType.STRUCTURED_SNIPPET);
    Paging paging = new Paging();
    paging.setStartIndex(1);
    paging.setNumberResults(20);
    adGroupFeedSelector.setPaging(paging);

    return adGroupFeedSelector;
  }
}

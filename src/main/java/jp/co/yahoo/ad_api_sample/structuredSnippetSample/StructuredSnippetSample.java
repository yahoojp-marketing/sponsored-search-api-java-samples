package jp.co.yahoo.ad_api_sample.structuredSnippetSample;

import jp.co.yahoo.ad_api_sample.adCustomizerSample.FeedItemServiceSample;
import jp.co.yahoo.ad_api_sample.adDisplayOptionSample.AdGroupFeedServiceSample;
import jp.co.yahoo.ad_api_sample.adDisplayOptionSample.CampaignFeedServiceSample;
import jp.co.yahoo.ad_api_sample.adSample.AdGroupServiceSample;
import jp.co.yahoo.ad_api_sample.adSample.BiddingStrategyServiceSample;
import jp.co.yahoo.ad_api_sample.adSample.CampaignServiceSample;
import jp.co.yahoo.ad_api_sample.error.impl.AdGroupFeedServiceErrorEntityFactory;
import jp.co.yahoo.ad_api_sample.error.impl.CampaignFeedServiceErrorEntityFactory;
import jp.co.yahoo.ad_api_sample.util.SoapUtils;
import jp.yahooapis.ss.v201805.Paging;
import jp.yahooapis.ss.v201805.adgroup.AdGroupOperation;
import jp.yahooapis.ss.v201805.adgroup.AdGroupValues;
import jp.yahooapis.ss.v201805.adgroupfeed.AdGroupFeed;
import jp.yahooapis.ss.v201805.adgroupfeed.AdGroupFeedList;
import jp.yahooapis.ss.v201805.adgroupfeed.AdGroupFeedOperation;
import jp.yahooapis.ss.v201805.adgroupfeed.AdGroupFeedPage;
import jp.yahooapis.ss.v201805.adgroupfeed.AdGroupFeedPlaceholderType;
import jp.yahooapis.ss.v201805.adgroupfeed.AdGroupFeedReturnValue;
import jp.yahooapis.ss.v201805.adgroupfeed.AdGroupFeedSelector;
import jp.yahooapis.ss.v201805.adgroupfeed.AdGroupFeedService;
import jp.yahooapis.ss.v201805.adgroupfeed.AdGroupFeedServiceInterface;
import jp.yahooapis.ss.v201805.adgroupfeed.AdGroupFeedValues;
import jp.yahooapis.ss.v201805.biddingstrategy.BiddingStrategyOperation;
import jp.yahooapis.ss.v201805.biddingstrategy.BiddingStrategyValues;
import jp.yahooapis.ss.v201805.biddingstrategy.PageOnePromotedBiddingScheme;
import jp.yahooapis.ss.v201805.campaign.CampaignOperation;
import jp.yahooapis.ss.v201805.campaign.CampaignType;
import jp.yahooapis.ss.v201805.campaign.CampaignValues;
import jp.yahooapis.ss.v201805.campaignfeed.CampaignFeed;
import jp.yahooapis.ss.v201805.campaignfeed.CampaignFeedList;
import jp.yahooapis.ss.v201805.campaignfeed.CampaignFeedOperation;
import jp.yahooapis.ss.v201805.campaignfeed.CampaignFeedPage;
import jp.yahooapis.ss.v201805.campaignfeed.CampaignFeedPlaceholderType;
import jp.yahooapis.ss.v201805.campaignfeed.CampaignFeedReturnValue;
import jp.yahooapis.ss.v201805.campaignfeed.CampaignFeedSelector;
import jp.yahooapis.ss.v201805.campaignfeed.CampaignFeedService;
import jp.yahooapis.ss.v201805.campaignfeed.CampaignFeedServiceInterface;
import jp.yahooapis.ss.v201805.campaignfeed.CampaignFeedValues;
import jp.yahooapis.ss.v201805.feeditem.DayOfWeek;
import jp.yahooapis.ss.v201805.feeditem.FeedAttributeValue;
import jp.yahooapis.ss.v201805.feeditem.FeedItem;
import jp.yahooapis.ss.v201805.feeditem.FeedItemOperation;
import jp.yahooapis.ss.v201805.feeditem.FeedItemPlaceholderField;
import jp.yahooapis.ss.v201805.feeditem.FeedItemPlaceholderType;
import jp.yahooapis.ss.v201805.feeditem.FeedItemSchedule;
import jp.yahooapis.ss.v201805.feeditem.FeedItemScheduling;
import jp.yahooapis.ss.v201805.feeditem.FeedItemSelector;
import jp.yahooapis.ss.v201805.feeditem.FeedItemValues;
import jp.yahooapis.ss.v201805.feeditem.MinuteOfHour;
import jp.yahooapis.ss.v201805.feeditem.MultipleFeedItemAttribute;
import jp.yahooapis.ss.v201805.feeditem.Operator;
import jp.yahooapis.ss.v201805.feeditem.SimpleFeedItemAttribute;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;

import javax.xml.ws.Holder;

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

      // GET
      FeedItemSelector feedItemSelector = FeedItemServiceSample.createSampleGetRequest(accountId, feedItemValues);
      feedItemValues = FeedItemServiceSample.get(feedItemSelector);

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
    campaignFeedOperation.setOperator(jp.yahooapis.ss.v201805.campaignfeed.Operator.SET);
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
    adGroupFeedOperation.setOperator(jp.yahooapis.ss.v201805.adgroupfeed.Operator.SET);
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

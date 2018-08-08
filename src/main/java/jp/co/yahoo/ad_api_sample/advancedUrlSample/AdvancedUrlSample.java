package jp.co.yahoo.ad_api_sample.advancedUrlSample;

import jp.co.yahoo.ad_api_sample.adCustomizerSample.FeedItemServiceSample;
import jp.co.yahoo.ad_api_sample.adDisplayOptionSample.AdGroupFeedServiceSample;
import jp.co.yahoo.ad_api_sample.adDisplayOptionSample.CampaignFeedServiceSample;
import jp.co.yahoo.ad_api_sample.adSample.AdGroupAdServiceSample;
import jp.co.yahoo.ad_api_sample.adSample.AdGroupBidMultiplierServiceSample;
import jp.co.yahoo.ad_api_sample.adSample.AdGroupCriterionServiceSample;
import jp.co.yahoo.ad_api_sample.adSample.AdGroupServiceSample;
import jp.co.yahoo.ad_api_sample.adSample.BiddingStrategyServiceSample;
import jp.co.yahoo.ad_api_sample.adSample.CampaignCriterionServiceSample;
import jp.co.yahoo.ad_api_sample.adSample.CampaignServiceSample;
import jp.co.yahoo.ad_api_sample.adSample.CampaignTargetServiceSample;
import jp.co.yahoo.ad_api_sample.util.SoapUtils;
import jp.yahooapis.ss.v201808.adgroup.AdGroupOperation;
import jp.yahooapis.ss.v201808.adgroup.AdGroupSelector;
import jp.yahooapis.ss.v201808.adgroup.AdGroupValues;
import jp.yahooapis.ss.v201808.adgroupad.AdGroupAd;
import jp.yahooapis.ss.v201808.adgroupad.AdGroupAdOperation;
import jp.yahooapis.ss.v201808.adgroupad.AdGroupAdSelector;
import jp.yahooapis.ss.v201808.adgroupad.AdGroupAdValues;
import jp.yahooapis.ss.v201808.adgroupad.AdType;
import jp.yahooapis.ss.v201808.adgroupad.DevicePreference;
import jp.yahooapis.ss.v201808.adgroupad.ExtendedTextAd;
import jp.yahooapis.ss.v201808.adgroupad.Operator;
import jp.yahooapis.ss.v201808.adgroupad.UserStatus;
import jp.yahooapis.ss.v201808.adgroupbidmultiplier.AdGroupBidMultiplierOperation;
import jp.yahooapis.ss.v201808.adgroupbidmultiplier.AdGroupBidMultiplierSelector;
import jp.yahooapis.ss.v201808.adgroupcriterion.AdGroupCriterionOperation;
import jp.yahooapis.ss.v201808.adgroupcriterion.AdGroupCriterionSelector;
import jp.yahooapis.ss.v201808.adgroupcriterion.AdGroupCriterionValues;
import jp.yahooapis.ss.v201808.adgroupcriterion.BiddableAdGroupCriterion;
import jp.yahooapis.ss.v201808.adgroupfeed.AdGroupFeedOperation;
import jp.yahooapis.ss.v201808.adgroupfeed.AdGroupFeedSelector;
import jp.yahooapis.ss.v201808.adgroupfeed.AdGroupFeedValues;
import jp.yahooapis.ss.v201808.biddingstrategy.BiddingStrategyOperation;
import jp.yahooapis.ss.v201808.biddingstrategy.BiddingStrategySelector;
import jp.yahooapis.ss.v201808.biddingstrategy.BiddingStrategyValues;
import jp.yahooapis.ss.v201808.biddingstrategy.PageOnePromotedBiddingScheme;
import jp.yahooapis.ss.v201808.campaign.CampaignOperation;
import jp.yahooapis.ss.v201808.campaign.CampaignSelector;
import jp.yahooapis.ss.v201808.campaign.CampaignType;
import jp.yahooapis.ss.v201808.campaign.CampaignValues;
import jp.yahooapis.ss.v201808.campaigncriterion.CampaignCriterionOperation;
import jp.yahooapis.ss.v201808.campaigncriterion.CampaignCriterionSelector;
import jp.yahooapis.ss.v201808.campaigncriterion.CampaignCriterionValues;
import jp.yahooapis.ss.v201808.campaignfeed.CampaignFeedOperation;
import jp.yahooapis.ss.v201808.campaignfeed.CampaignFeedSelector;
import jp.yahooapis.ss.v201808.campaignfeed.CampaignFeedValues;
import jp.yahooapis.ss.v201808.campaigntarget.CampaignTargetOperation;
import jp.yahooapis.ss.v201808.campaigntarget.CampaignTargetSelector;
import jp.yahooapis.ss.v201808.campaigntarget.CampaignTargetValues;
import jp.yahooapis.ss.v201808.feeditem.ApprovalStatus;
import jp.yahooapis.ss.v201808.feeditem.FeedItemOperation;
import jp.yahooapis.ss.v201808.feeditem.FeedItemPlaceholderType;
import jp.yahooapis.ss.v201808.feeditem.FeedItemSelector;
import jp.yahooapis.ss.v201808.feeditem.FeedItemValues;

import java.util.Arrays;
import java.util.List;

/**
 * Adavanced Url Sample Program for BiddingStrategyService,CampaignService,CampaignTargetService,
 * CampaignCriterionService,AdGroupService,AdGroupCriterionService,AdGroupAdService,
 * FeedItemService,CampaignFeedService,AdGroupFeedService. Copyright (C) 2016 Yahoo Japan
 * Corporation. All Rights Reserved.
 */
public class AdvancedUrlSample {

  /**
   * main method for AdSample
   *
   * @param args command line arguments
   */
  public static void main(String[] args) throws Exception {
    try {
      // =================================================================
      // Setting
      // =================================================================
      long accountId = SoapUtils.getAccountId();
      long biddingStrategyId = 0;
      long campaignId = 0;
      long adGroupId = 0;
      long appCampaignId = 0;
      long appAdGroupId = 0;
      long feedItemId1 = -1;
      long feedItemId2 = -1;

      // =================================================================
      // BiddingStrategyService
      // =================================================================
      // ADD
      BiddingStrategyOperation addBiddingStrategyOperation = BiddingStrategyServiceSample.createSampleAddRequest(accountId);
      List<BiddingStrategyValues> biddingStrategyValues = BiddingStrategyServiceSample.mutate(addBiddingStrategyOperation);

      // sleep 30 second.
      System.out.println("\n***** sleep 30 seconds *****\n");
      Thread.sleep(30000);

      // GET
      BiddingStrategySelector biddingStrategySelector = BiddingStrategyServiceSample.createSampleGetRequest(accountId, biddingStrategyValues);
      BiddingStrategyServiceSample.get(biddingStrategySelector);
      // SET
      BiddingStrategyOperation setBiddingStrategyOperation = BiddingStrategyServiceSample.createSampleSetRequest(accountId, biddingStrategyValues);
      BiddingStrategyServiceSample.mutate(setBiddingStrategyOperation);

      for (BiddingStrategyValues value : biddingStrategyValues) {
        if (value.getBiddingStrategy().getBiddingScheme() instanceof PageOnePromotedBiddingScheme) {
          biddingStrategyId = value.getBiddingStrategy().getBiddingStrategyId();
        }
      }

      // sleep 30 second.
      System.out.println("\n***** sleep 30 seconds *****\n");
      Thread.sleep(30000);

      // =================================================================
      // CampaignService
      // =================================================================
      // ADD
      CampaignOperation addCampaignOperation = CampaignServiceSample.createSampleAddRequest(accountId, biddingStrategyId);
      List<CampaignValues> campaignValues = CampaignServiceSample.add(addCampaignOperation);
      // GET
      CampaignSelector campaignSelector = CampaignServiceSample.createSampleGetRequest(accountId, campaignValues);
      CampaignServiceSample.get(campaignSelector);
      // SET
      CampaignOperation setCampaignOperation = CampaignServiceSample.createSampleSetRequest(accountId, biddingStrategyId, campaignValues);
      CampaignServiceSample.set(setCampaignOperation);

      for (CampaignValues value : campaignValues) {
        if (CampaignType.STANDARD.equals(value.getCampaign().getCampaignType())) {
          if (campaignId == 0) {
            campaignId = value.getCampaign().getCampaignId();
          }
        } else if (CampaignType.MOBILE_APP.equals(value.getCampaign().getCampaignType())) {
          if (appCampaignId == 0) {
            appCampaignId = value.getCampaign().getCampaignId();
          }
        }
      }

      // =================================================================
      // CampaignTargetService
      // =================================================================
      // ADD
      CampaignTargetOperation addCampaignTargetOperation = CampaignTargetServiceSample.createSampleAddRequest(accountId, campaignId, appCampaignId);
      List<CampaignTargetValues> campaignTargetValues = CampaignTargetServiceSample.add(addCampaignTargetOperation);
      // GET
      CampaignTargetSelector campaignTargetSelector = CampaignTargetServiceSample.createSampleGetRequest(accountId, campaignTargetValues);
      CampaignTargetServiceSample.get(campaignTargetSelector);
      // SET
      CampaignTargetOperation setCampaignTargetOperation = CampaignTargetServiceSample.createSampleSetRequest(accountId, campaignTargetValues);
      CampaignTargetServiceSample.set(setCampaignTargetOperation);

      // =================================================================
      // CampaignCriterionService
      // =================================================================
      // ADD
      CampaignCriterionOperation addCampaignCriterionOperation = CampaignCriterionServiceSample.createSampleAddRequest(accountId, campaignId);
      List<CampaignCriterionValues> campaignCriterionValues = CampaignCriterionServiceSample.add(addCampaignCriterionOperation);
      // GET
      CampaignCriterionSelector campaignCriterionSelector = CampaignCriterionServiceSample.createSampleGetRequest(accountId, campaignCriterionValues);
      CampaignCriterionServiceSample.get(campaignCriterionSelector);

      // =================================================================
      // AdGroupService
      // =================================================================
      // ADD
      AdGroupOperation addAdGroupOperation = AdGroupServiceSample.createSampleAddRequest(accountId, campaignId, appCampaignId);
      List<AdGroupValues> adGroupValues = AdGroupServiceSample.add(addAdGroupOperation);
      // GET
      AdGroupSelector adGroupSelector = AdGroupServiceSample.createSampleGetRequest(accountId, adGroupValues);
      AdGroupServiceSample.get(adGroupSelector);
      // SET
      AdGroupOperation setAdGroupOperation = AdGroupServiceSample.createSampleSetRequest(accountId, adGroupValues);
      AdGroupServiceSample.set(setAdGroupOperation);

      for (AdGroupValues value : adGroupValues) {
        if (value.getAdGroup().getCampaignId() == campaignId) {
          if (adGroupId == 0) {
            adGroupId = value.getAdGroup().getAdGroupId();
          }
        } else if (value.getAdGroup().getCampaignId() == appCampaignId) {
          if (appAdGroupId == 0) {
            appAdGroupId = value.getAdGroup().getAdGroupId();
          }
        }
      }

      // =================================================================
      // AdGroupCriterionService
      // =================================================================
      // ADD
      AdGroupCriterionOperation addAdGroupCriterionOperation = AdGroupCriterionServiceSample.createSampleAddRequest(accountId, campaignId, adGroupId);
      List<AdGroupCriterionValues> adGroupCriterionValues = AdGroupCriterionServiceSample.add(addAdGroupCriterionOperation);


      boolean allApproved = true;
      // call 30sec sleep * 30 = 15minute
      for (int i = 0; i < 30; i++) {
        // sleep 30 second.
        System.out.println("\n***** sleep 30 seconds *****\n");
        Thread.sleep(30000);

        // GET
        AdGroupCriterionSelector adGroupCriterionSelector = AdGroupCriterionServiceSample.createSampleGetRequest(accountId, campaignId, adGroupId, adGroupCriterionValues);
        List<AdGroupCriterionValues> getAdGroupCriterionValues = AdGroupCriterionServiceSample.get(adGroupCriterionSelector);

        allApproved = true;
        for (AdGroupCriterionValues adGroupCriterionValue : getAdGroupCriterionValues) {
          if (!jp.yahooapis.ss.v201808.adgroupcriterion.ApprovalStatus.APPROVED.equals(((BiddableAdGroupCriterion) adGroupCriterionValue.getAdGroupCriterion()).getApprovalStatus())) {
            allApproved = false;
          } else if (jp.yahooapis.ss.v201808.adgroupcriterion.ApprovalStatus.POST_DISAPPROVED.equals(((BiddableAdGroupCriterion) adGroupCriterionValue.getAdGroupCriterion()).getApprovalStatus())
              || jp.yahooapis.ss.v201808.adgroupcriterion.ApprovalStatus.PRE_DISAPPROVED.equals(((BiddableAdGroupCriterion) adGroupCriterionValue.getAdGroupCriterion()).getApprovalStatus())) {
            System.out.println("Error : This AdGroupCriterion was denied.");
            ((BiddableAdGroupCriterion) adGroupCriterionValue.getAdGroupCriterion()).getDisapprovalReasonCodes().stream().forEach(
                disapprovalReasonCode -> System.out.println("disapprovalReasonCode:[" + disapprovalReasonCode + "]")
            );
          }
        }
        if (allApproved) {
          break;
        }
      }

      // SET
      AdGroupCriterionOperation setAdGroupCriterionOperation = AdGroupCriterionServiceSample.createSampleSetRequest(accountId, campaignId, adGroupId, adGroupCriterionValues);
      AdGroupCriterionServiceSample.set(setAdGroupCriterionOperation);

      // =================================================================
      // AdGroupBidMultiplierService
      // =================================================================
      // SET
      AdGroupBidMultiplierOperation adGroupBidMultiplierOperation = AdGroupBidMultiplierServiceSample.createSampleSetRequest(accountId, campaignId, adGroupId);
      AdGroupBidMultiplierServiceSample.set(adGroupBidMultiplierOperation);
      // GET
      AdGroupBidMultiplierSelector adGroupBidMultiplierSelector = AdGroupBidMultiplierServiceSample.createSampleGetRequest(accountId, campaignId, adGroupId);
      AdGroupBidMultiplierServiceSample.get(adGroupBidMultiplierSelector);

      // =================================================================
      // AdGroupAdService
      // =================================================================
      // ADD
      AdGroupAdOperation addAdGroupAdOperation = createAdGroupAdSampleAddRequest(accountId, campaignId, adGroupId, appCampaignId, appAdGroupId);
      List<AdGroupAdValues> adGroupAdValues = AdGroupAdServiceSample.add(addAdGroupAdOperation);
      // GET
      AdGroupAdSelector adGroupAdSelector = AdGroupAdServiceSample.createSampleGetRequest(accountId, adGroupAdValues);
      AdGroupAdServiceSample.get(adGroupAdSelector);
      // SET
      AdGroupAdOperation setAdGroupAdOperation = AdGroupAdServiceSample.createSampleSetRequest(accountId, adGroupAdValues);
      AdGroupAdServiceSample.set(setAdGroupAdOperation);


      // =================================================================
      // FeedItemService
      // =================================================================
      // ADD QUICKLINK
      FeedItemOperation addFeedItemOperation_quicklink = FeedItemServiceSample.QuicklinkSampleFeedItem.createSampleAddRequest(accountId);
      List<FeedItemValues> addfeedItemValues_quicklink = FeedItemServiceSample.add(addFeedItemOperation_quicklink);

      // ADD CALLEXTENSION
      FeedItemOperation addFeedItemOperation_callextension = FeedItemServiceSample.CallextensionSampleFeedItem.createSampleAddRequest(accountId);
      List<FeedItemValues> addfeedItemValues_callextension = FeedItemServiceSample.add(addFeedItemOperation_callextension);

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

        // GET QUICKLINK
        FeedItemSelector feedItemSelector1 = FeedItemServiceSample.createSampleGetRequest(accountId, addfeedItemValues_quicklink);
        List<FeedItemValues> getFeedItemValues = FeedItemServiceSample.get(feedItemSelector1);

        // GET CALLEXTENSION
        FeedItemSelector feedItemSelector2 = FeedItemServiceSample.createSampleGetRequest(accountId, addfeedItemValues_callextension);
        getFeedItemValues.addAll(FeedItemServiceSample.get(feedItemSelector2));

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

      // =================================================================
      // remove AdGroupAdService, AdGroupCriterionService, AdGroupService,
      // CampaignCriterionService, CampaignTarget, BiddingStrategy, Campaign
      // =================================================================
      // AdGroupAdService
      AdGroupAdOperation removeAdGroupAdOperation = AdGroupAdServiceSample.createSampleRemoveRequest(accountId, adGroupAdValues);
      AdGroupAdServiceSample.remove(removeAdGroupAdOperation);

      // AdGroupCriterionService
      AdGroupCriterionOperation removeAdGroupCriterionOperation = AdGroupCriterionServiceSample.createSampleRemoveRequest(accountId, campaignId, adGroupId, adGroupCriterionValues);
      AdGroupCriterionServiceSample.remove(removeAdGroupCriterionOperation);

      // AdGroupService
      AdGroupOperation removeAdGroupOperation = AdGroupServiceSample.createSampleRemoveRequest(accountId, adGroupValues);
      AdGroupServiceSample.remove(removeAdGroupOperation);

      // CampaignCriterionService
      CampaignCriterionOperation removeCampaignCriterionOperation = CampaignCriterionServiceSample.createSampleRemoveRequest(accountId, campaignId, campaignCriterionValues);
      CampaignCriterionServiceSample.remove(removeCampaignCriterionOperation);

      // CampaignTarget
      CampaignTargetOperation removeCampaignTargetOperation = CampaignTargetServiceSample.createSampleRemoveRequest(accountId, campaignTargetValues);
      CampaignTargetServiceSample.remove(removeCampaignTargetOperation);

      // Campaign
      CampaignOperation removeCampaignOperation = CampaignServiceSample.createSampleRemoveRequest(accountId, campaignValues);
      CampaignServiceSample.remove(removeCampaignOperation);

      // BiddingStrategy
      BiddingStrategyOperation removeBiddingStrategyOperation = BiddingStrategyServiceSample.createSampleRemoveRequest(accountId, biddingStrategyValues);
      BiddingStrategyServiceSample.mutate(removeBiddingStrategyOperation);

    } catch (Exception e) {
      e.printStackTrace();
      throw e;
    }
  }

  /**
   * create sample request.
   *
   * @param accountId long
   * @param campaignId long
   * @param adGroupId long
   * @param appCampaignId long
   * @param appAdGroupId long
   * @return AdGroupAdOperation
   */
  private static AdGroupAdOperation createAdGroupAdSampleAddRequest(long accountId, long campaignId, long adGroupId, long appCampaignId, long appAdGroupId) {
    // Set Operation
    AdGroupAdOperation operation = new AdGroupAdOperation();
    operation.setOperator(Operator.ADD);
    operation.setAccountId(accountId);

    // Set CustomParamaters
    jp.yahooapis.ss.v201808.adgroupad.CustomParameters customParameters = new jp.yahooapis.ss.v201808.adgroupad.CustomParameters();
    jp.yahooapis.ss.v201808.adgroupad.CustomParameter parameter1 = new jp.yahooapis.ss.v201808.adgroupad.CustomParameter();
    parameter1.setKey("id1");
    parameter1.setValue("1234");
    customParameters.getParameters().addAll(Arrays.asList(parameter1));

    // Set ExtendedTextAd
    ExtendedTextAd extendedTextAd = new ExtendedTextAd();
    extendedTextAd.setType(AdType.EXTENDED_TEXT_AD);
    extendedTextAd.setHeadline("sample headline");
    extendedTextAd.setHeadline2("sample headline");
    extendedTextAd.setDescription("sample ad desc");
    extendedTextAd.setDisplayUrl("www.yahoo.co.jp");
    extendedTextAd.setDevicePreference(DevicePreference.SMART_PHONE);
    extendedTextAd.setAdvancedUrl("http://www.yahoo.co.jp");
    extendedTextAd.setAdvancedMobileUrl("http://www.yahoo.co.jp/mobile");
    extendedTextAd.setTrackingUrl("http://www.yahoo.co.jp/?url={lpurl}&amp;a={creative}&amp;pid={_id1}");
    extendedTextAd.setCustomParameters(customParameters);

    AdGroupAd extendedTextAdAdGroupAd = new AdGroupAd();
    extendedTextAdAdGroupAd.setAccountId(accountId);
    extendedTextAdAdGroupAd.setCampaignId(campaignId);
    extendedTextAdAdGroupAd.setAdGroupId(adGroupId);
    extendedTextAdAdGroupAd.setAdName("SampleExtendedTextAd_CreateOn_" + SoapUtils.getCurrentTimestamp());
    extendedTextAdAdGroupAd.setAd(extendedTextAd);
    extendedTextAdAdGroupAd.setUserStatus(UserStatus.ACTIVE);

    operation.getOperand().addAll(Arrays.asList(extendedTextAdAdGroupAd));

    return operation;
  }
}

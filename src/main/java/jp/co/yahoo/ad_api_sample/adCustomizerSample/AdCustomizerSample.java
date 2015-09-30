package jp.co.yahoo.ad_api_sample.adCustomizerSample;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import jp.co.yahoo.ad_api_sample.adSample.AdGroupAdServiceSample;
import jp.co.yahoo.ad_api_sample.adSample.AdGroupCriterionServiceSample;
import jp.co.yahoo.ad_api_sample.adSample.AdGroupServiceSample;
import jp.co.yahoo.ad_api_sample.adSample.BiddingStrategyServiceSample;
import jp.co.yahoo.ad_api_sample.adSample.CampaignServiceSample;
import jp.co.yahoo.ad_api_sample.util.SoapUtils;
import jp.yahooapis.ss.V5.AdGroupAdService.AdGroupAd;
import jp.yahooapis.ss.V5.AdGroupAdService.AdGroupAdOperation;
import jp.yahooapis.ss.V5.AdGroupAdService.AdGroupAdSelector;
import jp.yahooapis.ss.V5.AdGroupAdService.AdGroupAdValues;
import jp.yahooapis.ss.V5.AdGroupAdService.AdType;
import jp.yahooapis.ss.V5.AdGroupAdService.DevicePreference;
import jp.yahooapis.ss.V5.AdGroupAdService.Operator;
import jp.yahooapis.ss.V5.AdGroupAdService.TextAd2;
import jp.yahooapis.ss.V5.AdGroupAdService.UserStatus;
import jp.yahooapis.ss.V5.AdGroupCriterionService.AdGroupCriterionOperation;
import jp.yahooapis.ss.V5.AdGroupCriterionService.AdGroupCriterionValues;
import jp.yahooapis.ss.V5.AdGroupService.AdGroupOperation;
import jp.yahooapis.ss.V5.AdGroupService.AdGroupValues;
import jp.yahooapis.ss.V5.BiddingStrategyService.BiddingStrategyOperation;
import jp.yahooapis.ss.V5.BiddingStrategyService.BiddingStrategyValues;
import jp.yahooapis.ss.V5.BiddingStrategyService.PageOnePromotedBiddingScheme;
import jp.yahooapis.ss.V5.CampaignService.CampaignOperation;
import jp.yahooapis.ss.V5.CampaignService.CampaignValues;
import jp.yahooapis.ss.V5.FeedFolderService.FeedAttribute;
import jp.yahooapis.ss.V5.FeedFolderService.FeedFolderOperation;
import jp.yahooapis.ss.V5.FeedFolderService.FeedFolderSelector;
import jp.yahooapis.ss.V5.FeedFolderService.FeedFolderValues;
import jp.yahooapis.ss.V5.FeedFolderService.PlaceholderField;
import jp.yahooapis.ss.V5.FeedItemService.FeedItemOperation;
import jp.yahooapis.ss.V5.FeedItemService.FeedItemSelector;
import jp.yahooapis.ss.V5.FeedItemService.FeedItemValues;

/**
 * Sample Program for AdCustomizerSample. Copyright (C) 2012 Yahoo Japan Corporation. All Rights
 * Reserved.
 */
public class AdCustomizerSample {

  /**
   * main method for AdCustomizerSample
   *
   * @param args command line arguments
   */
  public static void main(String[] args) {
    try {
      // =================================================================
      // Setting
      // =================================================================
      long accountId = SoapUtils.getAccountId();
      long biddingStrategyId = 0;
      long campaignId = 0;
      long adGroupId = 0;
      long feedFolderId = 0;
      Map<String, Long> feedAttributeIds = new HashMap<String, Long>();
      feedAttributeIds.put("AD_CUSTOMIZER_INTEGER", 0L);
      feedAttributeIds.put("AD_CUSTOMIZER_PRICE", 0L);
      feedAttributeIds.put("AD_CUSTOMIZER_DATE", 0L);
      feedAttributeIds.put("AD_CUSTOMIZER_STRING", 0L);

      // =================================================================
      // BiddingStrategyService::mutate(ADD)
      // =================================================================
      List<BiddingStrategyValues> biddingStrategyValues = null;
      if (biddingStrategyId == 0) {
        BiddingStrategyOperation addBiddingStrategyOperation = BiddingStrategyServiceSample.createSampleAddRequest(accountId);
        biddingStrategyValues = BiddingStrategyServiceSample.add(addBiddingStrategyOperation);
        for (BiddingStrategyValues value : biddingStrategyValues) {
          if (value.getBiddingStrategy().getBiddingScheme() instanceof PageOnePromotedBiddingScheme) {
            biddingStrategyId = value.getBiddingStrategy().getBiddingStrategyId();
          }
        }
      } else {
        biddingStrategyId = SoapUtils.getBiddingStrategyId();
      }

      // =================================================================
      // CampaignService::mutate(ADD)
      // =================================================================
      List<CampaignValues> campaignValues = null;
      if (campaignId == 0) {
        CampaignOperation addCampaignOperation = CampaignServiceSample.createSampleAddRequest(accountId, biddingStrategyId);
        campaignValues = CampaignServiceSample.add(addCampaignOperation);
        for (CampaignValues value : campaignValues) {
          campaignId = value.getCampaign().getCampaignId();
        }
      } else {
        campaignId = SoapUtils.getCampaignId();
      }

      // =================================================================
      // AdGroupService::mutate(ADD)
      // =================================================================
      List<AdGroupValues> adGroupValues = null;
      if (adGroupId == 0) {
        AdGroupOperation addAdGroupOperation = AdGroupServiceSample.createSampleAddRequest(accountId, campaignId, biddingStrategyId);
        adGroupValues = AdGroupServiceSample.add(addAdGroupOperation);
        for (AdGroupValues value : adGroupValues) {
          adGroupId = value.getAdGroup().getAdGroupId();
        }
      } else {
        adGroupId = SoapUtils.getAdGroupId();
      }

      // =================================================================
      // AdGroupCriterionService::mutate(ADD)
      // =================================================================
      AdGroupCriterionOperation addAdGroupCriterionOperation = AdGroupCriterionServiceSample.createSampleAddRequest(accountId, campaignId, adGroupId);
      List<AdGroupCriterionValues> adGroupCriterionValues = AdGroupCriterionServiceSample.add(addAdGroupCriterionOperation);

      // =================================================================
      // FeedFolderService
      // =================================================================
      // ADD
      FeedFolderOperation addFeedFolderOperation = FeedFolderServiceSample.createSampleAddRequest(accountId);
      List<FeedFolderValues> feedFolderValues = FeedFolderServiceSample.add(addFeedFolderOperation);
      for (FeedFolderValues value : feedFolderValues) {
        feedFolderId = value.getFeedFolder().getFeedFolderId();
        for (FeedAttribute feedAttribute : value.getFeedFolder().getFeedAttribute()) {
          switch (feedAttribute.getPlaceholderField()) {
            case AD_CUSTOMIZER_INTEGER:
              feedAttributeIds.replace("AD_CUSTOMIZER_INTEGER", feedAttribute.getFeedAttributeId());
              break;
            case AD_CUSTOMIZER_PRICE:
              feedAttributeIds.replace("AD_CUSTOMIZER_PRICE", feedAttribute.getFeedAttributeId());
              break;
            case AD_CUSTOMIZER_DATE:
              feedAttributeIds.replace("AD_CUSTOMIZER_DATE", feedAttribute.getFeedAttributeId());
              break;
            case AD_CUSTOMIZER_STRING:
              feedAttributeIds.replace("AD_CUSTOMIZER_STRING", feedAttribute.getFeedAttributeId());
              break;
            default:
              break;
          }
        }
      }
      // GET
      FeedFolderSelector feedFolderSelector = FeedFolderServiceSample.createSampleGetRequest(accountId, feedFolderValues);
      FeedFolderServiceSample.get(feedFolderSelector);
      // SET
      FeedFolderOperation setFeedFolderOperation = FeedFolderServiceSample.createSampleSetRequest(accountId, feedFolderValues);
      FeedFolderServiceSample.set(setFeedFolderOperation);

      // =================================================================
      // FeedItemService
      // =================================================================
      // ADD
      FeedItemOperation addFeedItemOperation = FeedItemServiceSample.createSampleAddRequest(accountId, campaignId, adGroupId, feedFolderId, feedAttributeIds);
      List<FeedItemValues> feedItemValues = FeedItemServiceSample.add(addFeedItemOperation);
      // GET
      FeedItemSelector feedItemSelector = FeedItemServiceSample.createSampleGetRequest(accountId, feedItemValues);
      FeedItemServiceSample.get(feedItemSelector);
      // wait for sandbox review
      Thread.sleep(20000);
      // SET
      FeedItemOperation setFeedItemOperation = FeedItemServiceSample.createSampleSetRequest(accountId, feedItemValues);
      FeedItemServiceSample.set(setFeedItemOperation);

      // =================================================================
      // AdGroupAdService
      // =================================================================
      // ADD
      AdGroupAdOperation adGroupAdOperation = createSampleAdGroupAdRequest(accountId, campaignId, adGroupId, feedFolderValues);
      List<AdGroupAdValues> adGroupAdValues = AdGroupAdServiceSample.add(adGroupAdOperation);
      // GET
      AdGroupAdSelector adGroupAdSelector = AdGroupAdServiceSample.createSampleGetRequest(accountId, campaignId, adGroupId, adGroupAdValues);
      AdGroupAdServiceSample.get(adGroupAdSelector);

      // =================================================================
      // remove AdGroupAdService,FeefItemService, FeedFolderService,
      // AdGroupCriterionService, AdGroupService, Campaign, BiddingStrategy
      // =================================================================
      // AdGroupAdService
      AdGroupAdOperation removeAdGroupAdOperation = AdGroupAdServiceSample.createSampleRemoveRequest(accountId, campaignId, adGroupId, adGroupAdValues);
      AdGroupAdServiceSample.remove(removeAdGroupAdOperation);

      // FeefItemService
      FeedItemOperation removeFeedItemOperation = FeedItemServiceSample.createSampleRemoveRequest(accountId, feedItemValues);
      FeedItemServiceSample.remove(removeFeedItemOperation);

      // FeedFolderService
      FeedFolderOperation removeFeedFolderOperation = FeedFolderServiceSample.createSampleRemoveRequest(accountId, feedFolderValues);
      FeedFolderServiceSample.remove(removeFeedFolderOperation);

      // AdGroupCriterionService
      AdGroupCriterionOperation removeAdGroupCriterionOperation = AdGroupCriterionServiceSample.createSampleRemoveRequest(accountId, campaignId, adGroupId, adGroupCriterionValues);
      AdGroupCriterionServiceSample.remove(removeAdGroupCriterionOperation);

      // AdGroupService
      if (adGroupValues != null) {
        AdGroupOperation removeAdGroupOperation = AdGroupServiceSample.createSampleRemoveRequest(accountId, campaignId, adGroupValues);
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
        BiddingStrategyServiceSample.remove(removeBiddingStrategyOperation);
      }
    } catch (Exception ex) {
      ex.printStackTrace();
    }
  }

  /**
   * Sample Request for AdGroupAdService ADD(AdCustomizer).
   *
   * @param accountId Account ID
   * @param campaignId Campaign ID
   * @param adGroupId Ad group ID
   * @param feedFolderValues
   * @return AdGroupAdOperation
   * @throws Exception
   */
  public static AdGroupAdOperation createSampleAdGroupAdRequest(long accountId, long campaignId, long adGroupId, List<FeedFolderValues> feedFolderValues) throws Exception {
    // Set Operation
    AdGroupAdOperation adGroupAdOperation = new AdGroupAdOperation();
    adGroupAdOperation.setOperator(Operator.ADD);
    adGroupAdOperation.setAccountId(accountId);

    // Set TextAd2(Keyword)
    AdGroupAd adGroupAd1 = new AdGroupAd();
    adGroupAd1.setAccountId(accountId);
    adGroupAd1.setCampaignId(campaignId);
    adGroupAd1.setAdGroupId(adGroupId);
    adGroupAd1.setAdName("SampleTextAd2_CreateOn_" + SoapUtils.getCurrentTimestamp());
    TextAd2 keywordAd = new TextAd2();
    keywordAd.setType(AdType.TEXT_AD_2);
    keywordAd.setHeadline("sample headline");
    keywordAd.setDescription("sample {KEYWORD:keyword}");
    keywordAd.setDescription2("sample {KEYWORD:keyword}");
    keywordAd.setUrl("http://www.yahoo.co.jp/");
    keywordAd.setDisplayUrl("www.yahoo.co.jp");
    keywordAd.setDevicePreference(DevicePreference.SMART_PHONE);
    adGroupAd1.setAd(keywordAd);
    adGroupAd1.setUserStatus(UserStatus.ACTIVE);

    // Set TextAd2(CountdownOption)
    AdGroupAd adGroupAd2 = new AdGroupAd();
    adGroupAd2.setAccountId(accountId);
    adGroupAd2.setCampaignId(campaignId);
    adGroupAd2.setAdGroupId(adGroupId);
    adGroupAd2.setAdName("SampleCountdownOptionAd_" + SoapUtils.getCurrentTimestamp());
    TextAd2 countdownOptionAd1 = new TextAd2();
    countdownOptionAd1.setType(AdType.TEXT_AD_2);
    countdownOptionAd1.setHeadline("sample headline");
    countdownOptionAd1.setDescription("{=COUNTDOWN(\"2016/12/15 18:00:00\",\"ja\")}");
    countdownOptionAd1.setDescription2("sample ad desc");
    countdownOptionAd1.setUrl("http://www.yahoo.co.jp/");
    countdownOptionAd1.setDisplayUrl("www.yahoo.co.jp");
    countdownOptionAd1.setDevicePreference(DevicePreference.SMART_PHONE);
    adGroupAd2.setAd(countdownOptionAd1);
    adGroupAd2.setUserStatus(UserStatus.ACTIVE);

    // Set TextAd2(CountdownOption&AD_CUSTOMIZER_DATE)
    AdGroupAd adGroupAd3 = new AdGroupAd();
    adGroupAd3.setAccountId(accountId);
    adGroupAd3.setCampaignId(campaignId);
    adGroupAd3.setAdGroupId(adGroupId);
    adGroupAd3.setAdName("SampleCountdownOfAdCustomizer_" + SoapUtils.getCurrentTimestamp());
    TextAd2 countdownOptionAd2 = new TextAd2();
    countdownOptionAd2.setType(AdType.TEXT_AD_2);
    countdownOptionAd2.setHeadline("sample headline");

    String feedFolderName1 = null;
    String feedAttributeName1 = null;
    for (FeedFolderValues feedFolderValue : feedFolderValues) {
      feedFolderName1 = feedFolderValue.getFeedFolder().getFeedFolderName();
      for (FeedAttribute feedAttribute : feedFolderValue.getFeedFolder().getFeedAttribute()) {
        if (feedAttribute.getPlaceholderField() == PlaceholderField.AD_CUSTOMIZER_DATE) {
          feedAttributeName1 = feedAttribute.getFeedAttributeName();
        }
      }
    }

    countdownOptionAd2.setDescription("{=COUNTDOWN(" + feedFolderName1 + "." + feedAttributeName1 + ",\"ja\")}");
    countdownOptionAd2.setDescription2("sample ad desc");
    countdownOptionAd2.setUrl("http://www.yahoo.co.jp/");
    countdownOptionAd2.setDisplayUrl("www.yahoo.co.jp");
    countdownOptionAd2.setDevicePreference(DevicePreference.SMART_PHONE);
    adGroupAd3.setAd(countdownOptionAd2);
    adGroupAd3.setUserStatus(UserStatus.ACTIVE);

    // Set TextAd2(adCustomizer)
    AdGroupAd adGroupAd4 = new AdGroupAd();
    adGroupAd4.setAccountId(accountId);
    adGroupAd4.setCampaignId(campaignId);
    adGroupAd4.setAdGroupId(adGroupId);
    adGroupAd4.setAdName("SampleAdCustomizer_" + SoapUtils.getCurrentTimestamp());
    TextAd2 adCustomizerAd = new TextAd2();
    adCustomizerAd.setType(AdType.TEXT_AD_2);
    adCustomizerAd.setHeadline("sample headline");

    String feedFolderName2 = null;
    String feedAttributeName2 = null;
    for (FeedFolderValues feedFolderValue : feedFolderValues) {
      feedFolderName2 = feedFolderValue.getFeedFolder().getFeedFolderName();
      for (FeedAttribute feedAttribute : feedFolderValue.getFeedFolder().getFeedAttribute()) {
        if (feedAttribute.getPlaceholderField() == PlaceholderField.AD_CUSTOMIZER_STRING) {
          feedAttributeName2 = feedAttribute.getFeedAttributeName();
        }
      }
    }

    adCustomizerAd.setDescription("sample desc:{=" + feedFolderName2 + "." + feedAttributeName2 + "}");
    adCustomizerAd.setDescription2("sample ad desc");
    adCustomizerAd.setUrl("http://www.yahoo.co.jp/");
    adCustomizerAd.setDisplayUrl("www.yahoo.co.jp");
    adCustomizerAd.setDevicePreference(DevicePreference.SMART_PHONE);
    adGroupAd4.setAd(adCustomizerAd);
    adGroupAd4.setUserStatus(UserStatus.ACTIVE);

    adGroupAdOperation.getOperand().addAll(Arrays.asList(adGroupAd1, adGroupAd2, adGroupAd4));

    return adGroupAdOperation;
  }
}

package jp.co.yahoo.ad_api_sample.adCustomizerSample;

import jp.co.yahoo.ad_api_sample.adSample.AdGroupAdServiceSample;
import jp.co.yahoo.ad_api_sample.adSample.AdGroupCriterionServiceSample;
import jp.co.yahoo.ad_api_sample.adSample.AdGroupServiceSample;
import jp.co.yahoo.ad_api_sample.adSample.BiddingStrategyServiceSample;
import jp.co.yahoo.ad_api_sample.adSample.CampaignServiceSample;
import jp.co.yahoo.ad_api_sample.util.SoapUtils;
import jp.yahooapis.ss.v201805.adgroup.AdGroupOperation;
import jp.yahooapis.ss.v201805.adgroup.AdGroupValues;
import jp.yahooapis.ss.v201805.adgroupad.AdGroupAd;
import jp.yahooapis.ss.v201805.adgroupad.AdGroupAdOperation;
import jp.yahooapis.ss.v201805.adgroupad.AdGroupAdSelector;
import jp.yahooapis.ss.v201805.adgroupad.AdGroupAdValues;
import jp.yahooapis.ss.v201805.adgroupad.AdType;
import jp.yahooapis.ss.v201805.adgroupad.CustomParameter;
import jp.yahooapis.ss.v201805.adgroupad.CustomParameters;
import jp.yahooapis.ss.v201805.adgroupad.DevicePreference;
import jp.yahooapis.ss.v201805.adgroupad.ExtendedTextAd;
import jp.yahooapis.ss.v201805.adgroupad.Operator;
import jp.yahooapis.ss.v201805.adgroupad.UserStatus;
import jp.yahooapis.ss.v201805.adgroupcriterion.AdGroupCriterionOperation;
import jp.yahooapis.ss.v201805.adgroupcriterion.AdGroupCriterionValues;
import jp.yahooapis.ss.v201805.biddingstrategy.BiddingStrategyOperation;
import jp.yahooapis.ss.v201805.biddingstrategy.BiddingStrategyValues;
import jp.yahooapis.ss.v201805.biddingstrategy.PageOnePromotedBiddingScheme;
import jp.yahooapis.ss.v201805.campaign.CampaignOperation;
import jp.yahooapis.ss.v201805.campaign.CampaignType;
import jp.yahooapis.ss.v201805.campaign.CampaignValues;
import jp.yahooapis.ss.v201805.feedfolder.FeedAttribute;
import jp.yahooapis.ss.v201805.feedfolder.FeedFolderOperation;
import jp.yahooapis.ss.v201805.feedfolder.FeedFolderPlaceholderField;
import jp.yahooapis.ss.v201805.feedfolder.FeedFolderSelector;
import jp.yahooapis.ss.v201805.feedfolder.FeedFolderValues;
import jp.yahooapis.ss.v201805.feeditem.FeedItemOperation;
import jp.yahooapis.ss.v201805.feeditem.FeedItemSelector;
import jp.yahooapis.ss.v201805.feeditem.FeedItemValues;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
      long biddingStrategyId = SoapUtils.getBiddingStrategyId();
      long campaignId = SoapUtils.getCampaignId();
      long appCampaignId = SoapUtils.getAppCampaignId();
      long adGroupId = SoapUtils.getAdGroupId();
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
      if (biddingStrategyId == 9999999999l) {
        BiddingStrategyOperation addBiddingStrategyOperation = BiddingStrategyServiceSample.createSampleAddRequest(accountId);
        biddingStrategyValues = BiddingStrategyServiceSample.mutate(addBiddingStrategyOperation);
        for (BiddingStrategyValues value : biddingStrategyValues) {
          if (value.getBiddingStrategy().getBiddingScheme() instanceof PageOnePromotedBiddingScheme) {
            biddingStrategyId = value.getBiddingStrategy().getBiddingStrategyId();
          }
        }

        // sleep 30 second.
        System.out.println("\n***** sleep 30 seconds *****\n");
        Thread.sleep(30000);
      }
      
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
      // AdGroupAdService
      // =================================================================
      // ADD
      AdGroupAdOperation adGroupAdOperation = createSampleAdGroupAdRequest(accountId, campaignId, adGroupId, feedFolderValues);
      List<AdGroupAdValues> adGroupAdValues = AdGroupAdServiceSample.add(adGroupAdOperation);
      // GET
      AdGroupAdSelector adGroupAdSelector = AdGroupAdServiceSample.createSampleGetRequest(accountId, adGroupAdValues);
      AdGroupAdServiceSample.get(adGroupAdSelector);
      
      // =================================================================
      // FeedItemService
      // =================================================================
      // ADD
      FeedItemOperation addFeedItemOperation = FeedItemServiceSample.AdCustomizerSampleFeedItem.createSampleAddRequest(accountId, campaignId, adGroupId, feedFolderId, feedAttributeIds);
      List<FeedItemValues> feedItemValues = FeedItemServiceSample.add(addFeedItemOperation);
      // GET
      FeedItemSelector feedItemSelector = FeedItemServiceSample.createSampleGetRequest(accountId, feedItemValues);
      FeedItemServiceSample.get(feedItemSelector);

      // wait for sandbox review
      Thread.sleep(20000);

      // SET
      FeedItemOperation setFeedItemOperation = FeedItemServiceSample.AdCustomizerSampleFeedItem.createSampleSetRequest(accountId, feedItemValues);
      FeedItemServiceSample.set(setFeedItemOperation);

      // =================================================================
      // remove AdGroupAdService,FeefItemService, FeedFolderService,
      // AdGroupCriterionService, AdGroupService, Campaign, BiddingStrategy
      // =================================================================
      // AdGroupAdService
      AdGroupAdOperation removeAdGroupAdOperation = AdGroupAdServiceSample.createSampleRemoveRequest(accountId, adGroupAdValues);
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
    
    // Set CustomParamaters
    CustomParameters customParameters = new CustomParameters();
    CustomParameter parameter1 = new CustomParameter();
    parameter1.setKey("id1");
    parameter1.setValue("1234");
    customParameters.getParameters().addAll(Arrays.asList(parameter1));
    
    // Set Operation
    AdGroupAdOperation adGroupAdOperation = new AdGroupAdOperation();
    adGroupAdOperation.setOperator(Operator.ADD);
    adGroupAdOperation.setAccountId(accountId);

    // Set ExtendedTextAd(Keyword)
    AdGroupAd adGroupAd1 = new AdGroupAd();
    adGroupAd1.setAccountId(accountId);
    adGroupAd1.setCampaignId(campaignId);
    adGroupAd1.setAdGroupId(adGroupId);
    adGroupAd1.setAdName("SampleExtendedTextAd_CreateOn_" + SoapUtils.getCurrentTimestamp());
    ExtendedTextAd keywordAd = new ExtendedTextAd();
    keywordAd.setType(AdType.EXTENDED_TEXT_AD);
    keywordAd.setHeadline("sample headline");
    keywordAd.setHeadline2("sample headline2");
    keywordAd.setDescription("sample {KEYWORD:keyword}");
    keywordAd.setDisplayUrl("www.yahoo.co.jp");
    keywordAd.setDevicePreference(DevicePreference.SMART_PHONE);
    keywordAd.setAdvancedUrl("http://www.yahoo.co.jp");
    keywordAd.setAdvancedMobileUrl("http://www.yahoo.co.jp/mobile");
    keywordAd.setTrackingUrl("http://www.yahoo.co.jp/?url={lpurl}&amp;a={creative}&amp;pid={_id1}");
    keywordAd.setCustomParameters(customParameters);
    adGroupAd1.setAd(keywordAd);
    adGroupAd1.setUserStatus(UserStatus.ACTIVE);

    // Set ExtendedTextAd(CountdownOption)
    AdGroupAd adGroupAd2 = new AdGroupAd();
    adGroupAd2.setAccountId(accountId);
    adGroupAd2.setCampaignId(campaignId);
    adGroupAd2.setAdGroupId(adGroupId);
    adGroupAd2.setAdName("SampleCountdownOptionAd_" + SoapUtils.getCurrentTimestamp());
    ExtendedTextAd countdownOptionAd1 = new ExtendedTextAd();
    countdownOptionAd1.setType(AdType.EXTENDED_TEXT_AD);
    countdownOptionAd1.setHeadline("sample headline");
    countdownOptionAd1.setHeadline2("sample headline2");
    countdownOptionAd1.setDescription("{=COUNTDOWN(\"2018/12/15 18:00:00\",\"ja\")}");
    countdownOptionAd1.setDisplayUrl("www.yahoo.co.jp");
    countdownOptionAd1.setDevicePreference(DevicePreference.SMART_PHONE);
    countdownOptionAd1.setAdvancedUrl("http://www.yahoo.co.jp");
    countdownOptionAd1.setAdvancedMobileUrl("http://www.yahoo.co.jp/mobile");
    countdownOptionAd1.setTrackingUrl("http://www.yahoo.co.jp/?url={lpurl}&amp;a={creative}&amp;pid={_id1}");
    countdownOptionAd1.setCustomParameters(customParameters);
    adGroupAd2.setAd(countdownOptionAd1);
    adGroupAd2.setUserStatus(UserStatus.ACTIVE);

    // Set ExtendedTextAd(CountdownOption&AD_CUSTOMIZER_DATE)
    AdGroupAd adGroupAd3 = new AdGroupAd();
    adGroupAd3.setAccountId(accountId);
    adGroupAd3.setCampaignId(campaignId);
    adGroupAd3.setAdGroupId(adGroupId);
    adGroupAd3.setAdName("SampleCountdownOfAdCustomizer_" + SoapUtils.getCurrentTimestamp());
    ExtendedTextAd countdownOptionAd2 = new ExtendedTextAd();
    countdownOptionAd2.setType(AdType.EXTENDED_TEXT_AD);
    countdownOptionAd2.setHeadline("sample headline");

    String feedFolderName1 = null;
    String feedAttributeName1 = null;
    for (FeedFolderValues feedFolderValue : feedFolderValues) {
      feedFolderName1 = feedFolderValue.getFeedFolder().getFeedFolderName();
      for (FeedAttribute feedAttribute : feedFolderValue.getFeedFolder().getFeedAttribute()) {
        if (feedAttribute.getPlaceholderField() == FeedFolderPlaceholderField.AD_CUSTOMIZER_DATE) {
          feedAttributeName1 = feedAttribute.getFeedAttributeName();
        }
      }
    }

    countdownOptionAd2.setDescription("{=COUNTDOWN(" + feedFolderName1 + "." + feedAttributeName1 + ",\"ja\")}");
    countdownOptionAd2.setHeadline2("sample ad headline2");
    countdownOptionAd2.setDisplayUrl("www.yahoo.co.jp");
    countdownOptionAd2.setDevicePreference(DevicePreference.SMART_PHONE);
    countdownOptionAd2.setAdvancedUrl("http://www.yahoo.co.jp");
    countdownOptionAd2.setAdvancedMobileUrl("http://www.yahoo.co.jp/mobile");
    countdownOptionAd2.setTrackingUrl("http://www.yahoo.co.jp/?url={lpurl}&amp;a={creative}&amp;pid={_id1}");
    adGroupAd3.setAd(countdownOptionAd2);
    adGroupAd3.setUserStatus(UserStatus.ACTIVE);

    // Set ExtendedTextAd(adCustomizer)
    AdGroupAd adGroupAd4 = new AdGroupAd();
    adGroupAd4.setAccountId(accountId);
    adGroupAd4.setCampaignId(campaignId);
    adGroupAd4.setAdGroupId(adGroupId);
    adGroupAd4.setAdName("SampleAdCustomizer_" + SoapUtils.getCurrentTimestamp());
    ExtendedTextAd adCustomizerAd = new ExtendedTextAd();
    adCustomizerAd.setType(AdType.EXTENDED_TEXT_AD);
    adCustomizerAd.setHeadline("sample headline");

    String feedFolderName2 = null;
    String feedAttributeName2 = null;
    for (FeedFolderValues feedFolderValue : feedFolderValues) {
      feedFolderName2 = feedFolderValue.getFeedFolder().getFeedFolderName();
      for (FeedAttribute feedAttribute : feedFolderValue.getFeedFolder().getFeedAttribute()) {
        if (feedAttribute.getPlaceholderField() == FeedFolderPlaceholderField.AD_CUSTOMIZER_STRING) {
          feedAttributeName2 = feedAttribute.getFeedAttributeName();
        }
      }
    }

    adCustomizerAd.setDescription("sample desc:{=" + feedFolderName2 + "." + feedAttributeName2 + "}");
    adCustomizerAd.setHeadline2("sample ad headline2");
    adCustomizerAd.setDisplayUrl("www.yahoo.co.jp");
    adCustomizerAd.setDevicePreference(DevicePreference.SMART_PHONE);
    adCustomizerAd.setAdvancedUrl("http://www.yahoo.co.jp");
    adCustomizerAd.setAdvancedMobileUrl("http://www.yahoo.co.jp/mobile");
    adCustomizerAd.setTrackingUrl("http://www.yahoo.co.jp/?url={lpurl}&amp;a={creative}&amp;pid={_id1}");
    adGroupAd4.setAd(adCustomizerAd);
    adGroupAd4.setUserStatus(UserStatus.ACTIVE);

    // Set ExtendedTextAd(adCustomizer defaultText)
    AdGroupAd adGroupAd5 = new AdGroupAd();
    adGroupAd5.setAccountId(accountId);
    adGroupAd5.setCampaignId(campaignId);
    adGroupAd5.setAdGroupId(adGroupId);
    adGroupAd5.setAdName("SampleAdCustomizer_DefaultText_" + SoapUtils.getCurrentTimestamp());
    ExtendedTextAd adCustomizerAd2 = new ExtendedTextAd();
    adCustomizerAd2.setType(AdType.EXTENDED_TEXT_AD);

    adCustomizerAd2.setHeadline("{=" + feedFolderName2 + "." + feedAttributeName2 + ":default}headline");
    adCustomizerAd2.setHeadline2("{=" + feedFolderName2 + "." + feedAttributeName2 + ":default}headline2");
    adCustomizerAd2.setDescription("{=" + feedFolderName2 + "." + feedAttributeName2 + ":default}Description");

    adCustomizerAd2.setDisplayUrl("www.yahoo.co.jp");
    adCustomizerAd2.setDevicePreference(DevicePreference.SMART_PHONE);
    adCustomizerAd2.setAdvancedUrl("http://www.yahoo.co.jp");
    adCustomizerAd2.setAdvancedMobileUrl("http://www.yahoo.co.jp/mobile");
    adCustomizerAd2.setTrackingUrl("http://www.yahoo.co.jp/?url={lpurl}&amp;a={creative}&amp;pid={_id1}");
    adGroupAd5.setAd(adCustomizerAd2);
    adGroupAd5.setUserStatus(UserStatus.ACTIVE);

    // Set ExtendedTextAd(adCustomizer Mobile specification with IF function)
    AdGroupAd adGroupAd6 = new AdGroupAd();
    adGroupAd6.setAccountId(accountId);
    adGroupAd6.setCampaignId(campaignId);
    adGroupAd6.setAdGroupId(adGroupId);
    adGroupAd6.setAdName("SampleAdCustomizer_IF_function_" + SoapUtils.getCurrentTimestamp());
    ExtendedTextAd adCustomizerAd3 = new ExtendedTextAd();
    adCustomizerAd3.setType(AdType.EXTENDED_TEXT_AD);

    adCustomizerAd3.setHeadline("{=IF(device=mobile, MOBILE):PC}Headline");
    adCustomizerAd3.setHeadline2("{=IF(device=mobile, MOBILE):PC}Headline2");
    adCustomizerAd3.setDescription("{=IF(device=mobile, MOBILE):PC}Description");

    adCustomizerAd3.setDisplayUrl("www.yahoo.co.jp");
    adCustomizerAd3.setDevicePreference(DevicePreference.SMART_PHONE);
    adCustomizerAd3.setAdvancedUrl("http://www.yahoo.co.jp");
    adCustomizerAd3.setAdvancedMobileUrl("http://www.yahoo.co.jp/mobile");
    adCustomizerAd3.setTrackingUrl("http://www.yahoo.co.jp/?url={lpurl}&amp;a={creative}&amp;pid={_id1}");
    adGroupAd6.setAd(adCustomizerAd3);
    adGroupAd6.setUserStatus(UserStatus.ACTIVE);

    // Set ExtendedTextAd(adCustomizer Mobile specification with IF function and DefaultText)
    AdGroupAd adGroupAd7 = new AdGroupAd();
    adGroupAd7.setAccountId(accountId);
    adGroupAd7.setCampaignId(campaignId);
    adGroupAd7.setAdGroupId(adGroupId);
    adGroupAd7.setAdName("SampleAdCustomizer_IF_And_Default" + SoapUtils.getCurrentTimestamp());
    ExtendedTextAd adCustomizerAd4 = new ExtendedTextAd();
    adCustomizerAd4.setType(AdType.EXTENDED_TEXT_AD);

    adCustomizerAd4.setHeadline("{=IF(device=mobile, MOBILE):PC}test + {=" + feedFolderName2 + "." + feedAttributeName2 + ":default}headline");
    adCustomizerAd4.setHeadline2("{=IF(device=mobile, MOBILE):PC}test + {=" + feedFolderName2 + "." + feedAttributeName2 + ":default}headline2");
    adCustomizerAd4.setDescription("{=IF(device=mobile, MOBILE):PC}test + {=" + feedFolderName2 + "." + feedAttributeName2 + ":default}description");

    adCustomizerAd4.setDisplayUrl("www.yahoo.co.jp");
    adCustomizerAd4.setDevicePreference(DevicePreference.SMART_PHONE);
    adCustomizerAd4.setAdvancedUrl("http://www.yahoo.co.jp");
    adCustomizerAd4.setAdvancedMobileUrl("http://www.yahoo.co.jp/mobile");
    adCustomizerAd4.setTrackingUrl("http://www.yahoo.co.jp/?url={lpurl}&amp;a={creative}&amp;pid={_id1}");
    adGroupAd7.setAd(adCustomizerAd4);
    adGroupAd7.setUserStatus(UserStatus.ACTIVE);

    adGroupAdOperation.getOperand().addAll(Arrays.asList(adGroupAd1, adGroupAd2, adGroupAd4, adGroupAd5, adGroupAd6, adGroupAd7));

    return adGroupAdOperation;
  }
}

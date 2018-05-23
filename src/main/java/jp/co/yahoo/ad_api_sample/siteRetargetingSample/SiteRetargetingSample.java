package jp.co.yahoo.ad_api_sample.siteRetargetingSample;

import java.util.List;

import jp.co.yahoo.ad_api_sample.adSample.AdGroupServiceSample;
import jp.co.yahoo.ad_api_sample.adSample.BiddingStrategyServiceSample;
import jp.co.yahoo.ad_api_sample.adSample.CampaignServiceSample;
import jp.co.yahoo.ad_api_sample.util.SoapUtils;
import jp.yahooapis.ss.v201805.adgroupretargetinglist.AdGroupRetargetingListOperation;
import jp.yahooapis.ss.v201805.adgroupretargetinglist.AdGroupRetargetingListSelector;
import jp.yahooapis.ss.v201805.adgroupretargetinglist.AdGroupRetargetingListValues;
import jp.yahooapis.ss.v201805.adgroup.AdGroupOperation;
import jp.yahooapis.ss.v201805.adgroup.AdGroupValues;
import jp.yahooapis.ss.v201805.biddingstrategy.BiddingStrategyOperation;
import jp.yahooapis.ss.v201805.biddingstrategy.BiddingStrategyValues;
import jp.yahooapis.ss.v201805.biddingstrategy.PageOnePromotedBiddingScheme;
import jp.yahooapis.ss.v201805.campaignretargetinglist.ExcludedType;
import jp.yahooapis.ss.v201805.campaign.CampaignOperation;
import jp.yahooapis.ss.v201805.campaign.CampaignType;
import jp.yahooapis.ss.v201805.campaign.CampaignValues;
import jp.yahooapis.ss.v201805.campaignretargetinglist.CampaignRetargetingListOperation;
import jp.yahooapis.ss.v201805.campaignretargetinglist.CampaignRetargetingListSelector;
import jp.yahooapis.ss.v201805.retargetinglist.RetargetingListOperation;
import jp.yahooapis.ss.v201805.retargetinglist.RetargetingListSelector;
import jp.yahooapis.ss.v201805.retargetinglist.RetargetingListValues;

/**
 * Sample Program for RetargetingListService,CampaignService,CampaignRetargetingListService
 * AdGroupService,AdGroupRetargetingListServiceService. Copyright (C) 2012 Yahoo Japan Corporation.
 * All Rights Reserved.
 */
public class SiteRetargetingSample {

  /**
   * main method for SiteRetargetingSample
   *
   * @param args command line arguments
   */
  public static void main(String[] args) throws Exception {
    try {
      // =================================================================
      // Setting
      // =================================================================
      long accountId = SoapUtils.getAccountId();
      long biddingStrategyId = SoapUtils.getBiddingStrategyId();
      long campaignId = SoapUtils.getCampaignId();
      long appCampaignId = SoapUtils.getAppCampaignId();
      long adGroupId = SoapUtils.getAdGroupId();
      long targetListId = 0;

      // =================================================================
      // BiddingStrategyService
      // =================================================================
      List<BiddingStrategyValues> biddingStrategyValues = null;
      if (biddingStrategyId == 9999999999l) {
        // ADD
        BiddingStrategyOperation addBiddingStrategyOperation = BiddingStrategyServiceSample.createSampleAddRequest(accountId);
        biddingStrategyValues = BiddingStrategyServiceSample.mutate(addBiddingStrategyOperation);
        for (BiddingStrategyValues value : biddingStrategyValues) {
          if (value.getBiddingStrategy().getBiddingScheme() instanceof PageOnePromotedBiddingScheme) {
            biddingStrategyId = value.getBiddingStrategy().getBiddingStrategyId();
          }
        }
      }

      // =================================================================
      // RetargetingListService
      // =================================================================
      // ADD
      RetargetingListOperation addRetargetingListOperation = RetargetingListServiceSample.createSampleAddRequestOfRuleBase(accountId);
      List<RetargetingListValues> retargetingListValues = RetargetingListServiceSample.add(addRetargetingListOperation);
      // GET
      RetargetingListSelector retargetingListSelector = RetargetingListServiceSample.createSampleGetRequest(accountId, retargetingListValues);
      RetargetingListServiceSample.get(retargetingListSelector);
      // SET
      RetargetingListOperation setRetargetingListOperation = RetargetingListServiceSample.createSampleSetRequest(accountId, retargetingListValues);
      RetargetingListServiceSample.set(setRetargetingListOperation);

      for (RetargetingListValues value : retargetingListValues) {
        if (targetListId == 0) {
          targetListId = value.getTargetList().getTargetListId();
        }
      }

      // =================================================================
      // CampaignService
      // =================================================================
      List<CampaignValues> campaignValues = null;
      if (campaignId == 9999999999l || appCampaignId == 9999999999l) {
        // ADD
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
      // CampaignRetargetingListService
      // =================================================================
      // ADD
      CampaignRetargetingListOperation addCampaignRetargetingListOperation = CampaignRetargetingListServiceSample.createSampleAddRequest(accountId, campaignId, targetListId, ExcludedType.INCLUDED, 1.0d);
      CampaignRetargetingListServiceSample.add(addCampaignRetargetingListOperation);
      // GET
      CampaignRetargetingListSelector campaignRetargetingListSelector = CampaignRetargetingListServiceSample.createSampleGetRequest(accountId, campaignId, targetListId);
      CampaignRetargetingListServiceSample.get(campaignRetargetingListSelector);

      // =================================================================
      // AdGroupService
      // =================================================================
      List<AdGroupValues> adGroupValues = null;
      if (adGroupId == 9999999999l) {
        // ADD
        AdGroupOperation addAdGroupOperation = AdGroupServiceSample.createSampleAddRequest(accountId, campaignId, appCampaignId);
        adGroupValues = AdGroupServiceSample.add(addAdGroupOperation);
        for (AdGroupValues value : adGroupValues) {
          if (value.getAdGroup().getCampaignId() == campaignId) {
            adGroupId = value.getAdGroup().getAdGroupId();
          }
        }
      }

      // =================================================================
      // AdGroupRetargetingListServiceService
      // =================================================================
      // ADD
      AdGroupRetargetingListOperation addAdGroupRetargetingListOperation = AdGroupRetargetingListServiceSample.createSampleAddRequest(accountId, campaignId, targetListId, adGroupId);
      List<AdGroupRetargetingListValues> adGroupRetargetingListValues = AdGroupRetargetingListServiceSample.add(addAdGroupRetargetingListOperation);
      // GET
      AdGroupRetargetingListSelector adGroupRetargetingListSelector = AdGroupRetargetingListServiceSample.createSampleGetRequest(accountId, campaignId, targetListId, adGroupId);
      AdGroupRetargetingListServiceSample.get(adGroupRetargetingListSelector);
      // SET
      AdGroupRetargetingListOperation setOperation = AdGroupRetargetingListServiceSample.createSampleSetRequest(accountId, adGroupRetargetingListValues);
      AdGroupRetargetingListServiceSample.set(setOperation);

      // =================================================================
      // remove AdGroupRetargetingListServiceService, AdGroupService,
      // CampaignRetargetingListService, CampaignService
      // =================================================================
      // AdGroupRetargetingListServiceService
      AdGroupRetargetingListOperation removeAdGroupRetargetingListOperation = AdGroupRetargetingListServiceSample.createSampleRemoveRequest(accountId, adGroupRetargetingListValues);
      AdGroupRetargetingListServiceSample.remove(removeAdGroupRetargetingListOperation);

      // AdGroupService
      if (adGroupValues != null) {
        AdGroupOperation removeAdGroupOperation = AdGroupServiceSample.createSampleRemoveRequest(accountId, adGroupValues);
        AdGroupServiceSample.remove(removeAdGroupOperation);
      }

      // CampaignRetargetingListService
      CampaignRetargetingListOperation removeCampaignRetargetingListOperation = CampaignRetargetingListServiceSample.createSampleRemoveRequest(accountId, campaignId, targetListId, ExcludedType.INCLUDED);
      CampaignRetargetingListServiceSample.remove(removeCampaignRetargetingListOperation);

      // CampaignService
      if (campaignValues != null) {
        CampaignOperation removeCampaignOperation = CampaignServiceSample.createSampleRemoveRequest(accountId, campaignValues);
        CampaignServiceSample.remove(removeCampaignOperation);
      }

      // BiddingStrategy
      if (biddingStrategyValues != null) {
        BiddingStrategyOperation removeBiddingStrategyOperation = BiddingStrategyServiceSample.createSampleRemoveRequest(accountId, biddingStrategyValues);
        BiddingStrategyServiceSample.mutate(removeBiddingStrategyOperation);
      }
    } catch (Exception e) {
      e.printStackTrace();
      throw e;
    }
  }
}

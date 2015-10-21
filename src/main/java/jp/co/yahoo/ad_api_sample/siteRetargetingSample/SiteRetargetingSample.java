package jp.co.yahoo.ad_api_sample.siteRetargetingSample;

import java.util.List;

import jp.co.yahoo.ad_api_sample.adSample.AdGroupServiceSample;
import jp.co.yahoo.ad_api_sample.adSample.BiddingStrategyServiceSample;
import jp.co.yahoo.ad_api_sample.adSample.CampaignServiceSample;
import jp.co.yahoo.ad_api_sample.util.SoapUtils;
import jp.yahooapis.ss.V5.AdGroupRetargetingListService.AdGroupRetargetingListOperation;
import jp.yahooapis.ss.V5.AdGroupRetargetingListService.AdGroupRetargetingListSelector;
import jp.yahooapis.ss.V5.AdGroupRetargetingListService.AdGroupRetargetingListValues;
import jp.yahooapis.ss.V5.AdGroupService.AdGroupOperation;
import jp.yahooapis.ss.V5.AdGroupService.AdGroupValues;
import jp.yahooapis.ss.V5.BiddingStrategyService.BiddingStrategyOperation;
import jp.yahooapis.ss.V5.BiddingStrategyService.BiddingStrategyValues;
import jp.yahooapis.ss.V5.BiddingStrategyService.PageOnePromotedBiddingScheme;
import jp.yahooapis.ss.V5.CampaignService.CampaignOperation;
import jp.yahooapis.ss.V5.CampaignService.CampaignType;
import jp.yahooapis.ss.V5.CampaignService.CampaignValues;
import jp.yahooapis.ss.V5.NegativeCampaignRetargetingListService.NegativeCampaignRetargetingListOperation;
import jp.yahooapis.ss.V5.NegativeCampaignRetargetingListService.NegativeCampaignRetargetingListSelector;
import jp.yahooapis.ss.V5.RetargetingListService.RetargetingListOperation;
import jp.yahooapis.ss.V5.RetargetingListService.RetargetingListSelector;
import jp.yahooapis.ss.V5.RetargetingListService.RetargetingListValues;

/**
 * Sample Program for RetargetingListService,CampaignService,NegativeCampaignRetargetingListService
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
        biddingStrategyValues = BiddingStrategyServiceSample.add(addBiddingStrategyOperation);
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
      // NegativeCampaignRetargetingListService
      // =================================================================
      // ADD
      NegativeCampaignRetargetingListOperation addNegativeCampaignRetargetingListOperation = NegativeCampaignRetargetingListServiceSample.createSampleAddRequest(accountId, campaignId, targetListId);
      NegativeCampaignRetargetingListServiceSample.add(addNegativeCampaignRetargetingListOperation);
      // GET
      NegativeCampaignRetargetingListSelector negativeCampaignRetargetingListSelector = NegativeCampaignRetargetingListServiceSample.createSampleGetRequest(accountId, campaignId, targetListId);
      NegativeCampaignRetargetingListServiceSample.get(negativeCampaignRetargetingListSelector);

      // =================================================================
      // AdGroupService
      // =================================================================
      List<AdGroupValues> adGroupValues = null;
      if (adGroupId == 9999999999l) {
        // ADD
        AdGroupOperation addAdGroupOperation = AdGroupServiceSample.createSampleAddRequest(accountId, campaignId, appCampaignId, biddingStrategyId);
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
      // NegativeCampaignRetargetingListService, CampaignService
      // =================================================================
      // AdGroupRetargetingListServiceService
      AdGroupRetargetingListOperation removeAdGroupRetargetingListOperation = AdGroupRetargetingListServiceSample.createSampleRemoveRequest(accountId, adGroupRetargetingListValues);
      AdGroupRetargetingListServiceSample.remove(removeAdGroupRetargetingListOperation);

      // AdGroupService
      if (adGroupValues != null) {
        AdGroupOperation removeAdGroupOperation = AdGroupServiceSample.createSampleRemoveRequest(accountId, adGroupValues);
        AdGroupServiceSample.remove(removeAdGroupOperation);
      }

      // NegativeCampaignRetargetingListService
      NegativeCampaignRetargetingListOperation removeNegativeCampaignRetargetingListOperation = NegativeCampaignRetargetingListServiceSample.createSampleRemoveRequest(accountId, campaignId, targetListId);
      NegativeCampaignRetargetingListServiceSample.remove(removeNegativeCampaignRetargetingListOperation);

      // CampaignService
      if (campaignValues != null) {
        CampaignOperation removeCampaignOperation = CampaignServiceSample.createSampleRemoveRequest(accountId, campaignValues);
        CampaignServiceSample.remove(removeCampaignOperation);
      }

      // BiddingStrategy
      if (biddingStrategyValues != null) {
        BiddingStrategyOperation removeBiddingStrategyOperation = BiddingStrategyServiceSample.createSampleRemoveRequest(accountId, biddingStrategyValues);
        BiddingStrategyServiceSample.remove(removeBiddingStrategyOperation);
      }
    } catch (Exception e) {
      e.printStackTrace();
      throw e;
    }
  }

}

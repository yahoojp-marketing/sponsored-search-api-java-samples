package jp.co.yahoo.ad_api_sample.adSample;

import jp.co.yahoo.ad_api_sample.util.SoapUtils;
import jp.yahooapis.ss.v201808.adgroup.AdGroupOperation;
import jp.yahooapis.ss.v201808.adgroup.AdGroupSelector;
import jp.yahooapis.ss.v201808.adgroup.AdGroupValues;
import jp.yahooapis.ss.v201808.adgroupad.AdGroupAdOperation;
import jp.yahooapis.ss.v201808.adgroupad.AdGroupAdSelector;
import jp.yahooapis.ss.v201808.adgroupad.AdGroupAdValues;
import jp.yahooapis.ss.v201808.adgroupbidmultiplier.AdGroupBidMultiplierOperation;
import jp.yahooapis.ss.v201808.adgroupbidmultiplier.AdGroupBidMultiplierSelector;
import jp.yahooapis.ss.v201808.adgroupcriterion.AdGroupCriterionOperation;
import jp.yahooapis.ss.v201808.adgroupcriterion.AdGroupCriterionSelector;
import jp.yahooapis.ss.v201808.adgroupcriterion.AdGroupCriterionValues;
import jp.yahooapis.ss.v201808.adgroupcriterion.ApprovalStatus;
import jp.yahooapis.ss.v201808.adgroupcriterion.BiddableAdGroupCriterion;
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
import jp.yahooapis.ss.v201808.campaigntarget.CampaignTargetOperation;
import jp.yahooapis.ss.v201808.campaigntarget.CampaignTargetSelector;
import jp.yahooapis.ss.v201808.campaigntarget.CampaignTargetValues;

import java.util.List;


/**
 * Sample Program for BiddingStrategyService,CampaignService,CampaignTargetService,
 * CampaignCriterionService,AdGroupService,AdGroupCriterionService,AdGroupAdService. Copyright (C)
 * 2012 Yahoo Japan Corporation. All Rights Reserved.
 */
public class AdSample {

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

        // =================================================================
        // AdGroupCriterionService GET
        // =================================================================
        // Set Selector
        AdGroupCriterionSelector adGroupCriterionSelector = AdGroupCriterionServiceSample.createSampleGetRequest(accountId, campaignId, adGroupId, adGroupCriterionValues);

        // Run
        List<AdGroupCriterionValues> getAdGroupCriterionValues = AdGroupCriterionServiceSample.get(adGroupCriterionSelector);

        allApproved = true;
        for (AdGroupCriterionValues adGroupCriterionValue : getAdGroupCriterionValues) {
          if (!ApprovalStatus.APPROVED.equals(((BiddableAdGroupCriterion) adGroupCriterionValue.getAdGroupCriterion()).getApprovalStatus())) {
            allApproved = false;
          } else if (ApprovalStatus.POST_DISAPPROVED.equals(((BiddableAdGroupCriterion) adGroupCriterionValue.getAdGroupCriterion()).getApprovalStatus())
              || ApprovalStatus.PRE_DISAPPROVED.equals(((BiddableAdGroupCriterion) adGroupCriterionValue.getAdGroupCriterion()).getApprovalStatus())) {
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
      if (!allApproved) {
        System.out.println("Error : The review did not end.");
        // =================================================================
        // REMOVE
        // =================================================================
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

        System.exit(1);
      }

      // GET
      AdGroupCriterionSelector adGroupCriterionSelector = AdGroupCriterionServiceSample.createSampleGetRequest(accountId, campaignId, adGroupId, adGroupCriterionValues);
      AdGroupCriterionServiceSample.get(adGroupCriterionSelector);
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
      AdGroupAdOperation addAdGroupAdOperation = AdGroupAdServiceSample.createSampleAddRequest(accountId, campaignId, adGroupId, appCampaignId, appAdGroupId);
      List<AdGroupAdValues> adGroupAdValues = AdGroupAdServiceSample.add(addAdGroupAdOperation);
      // GET
      AdGroupAdSelector adGroupAdSelector = AdGroupAdServiceSample.createSampleGetRequest(accountId, adGroupAdValues);
      AdGroupAdServiceSample.get(adGroupAdSelector);
      // SET
      AdGroupAdOperation setAdGroupAdOperation = AdGroupAdServiceSample.createSampleSetRequest(accountId, adGroupAdValues);
      AdGroupAdServiceSample.set(setAdGroupAdOperation);


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
}

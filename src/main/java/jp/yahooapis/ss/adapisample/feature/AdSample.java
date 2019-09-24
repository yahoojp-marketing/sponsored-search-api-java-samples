/**
 * Copyright (C) 2019 Yahoo Japan Corporation. All Rights Reserved.
 */
package jp.yahooapis.ss.adapisample.feature;

import jp.yahooapis.ss.adapisample.basic.adgroup.AdGroupServiceSample;
import jp.yahooapis.ss.adapisample.basic.adgroupad.AdGroupAdServiceSample;
import jp.yahooapis.ss.adapisample.basic.adgroupbidmultiplier.AdGroupBidMultiplierServiceSample;
import jp.yahooapis.ss.adapisample.basic.adgroupcriterion.AdGroupCriterionServiceSample;
import jp.yahooapis.ss.adapisample.basic.adgroupfeed.AdGroupFeedServiceSample;
import jp.yahooapis.ss.adapisample.basic.biddingstrategy.BiddingStrategyServiceSample;
import jp.yahooapis.ss.adapisample.basic.campaign.CampaignServiceSample;
import jp.yahooapis.ss.adapisample.basic.campaigncriterion.CampaignCriterionServiceSample;
import jp.yahooapis.ss.adapisample.basic.campaignfeed.CampaignFeedServiceSample;
import jp.yahooapis.ss.adapisample.basic.campaigntarget.CampaignTargetServiceSample;
import jp.yahooapis.ss.adapisample.basic.feeditem.FeedItemServiceSample;
import jp.yahooapis.ss.adapisample.repository.ValuesRepositoryFacade;
import jp.yahooapis.ss.adapisample.util.SoapUtils;
import jp.yahooapis.ss.adapisample.util.ValuesHolder;
import jp.yahooapis.ss.v201909.adgroup.AdGroup;
import jp.yahooapis.ss.v201909.adgroup.AdGroupOperation;
import jp.yahooapis.ss.v201909.adgroup.AdGroupValues;
import jp.yahooapis.ss.v201909.adgroupad.AdGroupAd;
import jp.yahooapis.ss.v201909.adgroupad.AdGroupAdOperation;
import jp.yahooapis.ss.v201909.adgroupad.AdGroupAdSelector;
import jp.yahooapis.ss.v201909.adgroupad.AdGroupAdValues;
import jp.yahooapis.ss.v201909.adgroupbidmultiplier.AdGroupBidMultiplierOperation;
import jp.yahooapis.ss.v201909.adgroupbidmultiplier.AdGroupBidMultiplierSelector;
import jp.yahooapis.ss.v201909.adgroupcriterion.AdGroupCriterion;
import jp.yahooapis.ss.v201909.adgroupcriterion.AdGroupCriterionOperation;
import jp.yahooapis.ss.v201909.adgroupcriterion.AdGroupCriterionSelector;
import jp.yahooapis.ss.v201909.adgroupcriterion.AdGroupCriterionUse;
import jp.yahooapis.ss.v201909.adgroupcriterion.AdGroupCriterionValues;
import jp.yahooapis.ss.v201909.adgroupfeed.AdGroupFeedOperation;
import jp.yahooapis.ss.v201909.adgroupfeed.AdGroupFeedPlaceholderType;
import jp.yahooapis.ss.v201909.adgroupfeed.AdGroupFeedSelector;
import jp.yahooapis.ss.v201909.biddingstrategy.BiddingStrategyOperation;
import jp.yahooapis.ss.v201909.biddingstrategy.BiddingStrategySelector;
import jp.yahooapis.ss.v201909.biddingstrategy.BiddingStrategyType;
import jp.yahooapis.ss.v201909.biddingstrategy.BiddingStrategyValues;
import jp.yahooapis.ss.v201909.biddingstrategy.Operator;
import jp.yahooapis.ss.v201909.campaign.AppStore;
import jp.yahooapis.ss.v201909.campaign.Campaign;
import jp.yahooapis.ss.v201909.campaign.CampaignOperation;
import jp.yahooapis.ss.v201909.campaign.CampaignType;
import jp.yahooapis.ss.v201909.campaign.CampaignValues;
import jp.yahooapis.ss.v201909.campaigncriterion.CampaignCriterion;
import jp.yahooapis.ss.v201909.campaigncriterion.CampaignCriterionOperation;
import jp.yahooapis.ss.v201909.campaigncriterion.CampaignCriterionSelector;
import jp.yahooapis.ss.v201909.campaigncriterion.CampaignCriterionValues;
import jp.yahooapis.ss.v201909.campaignfeed.CampaignFeedOperation;
import jp.yahooapis.ss.v201909.campaignfeed.CampaignFeedPlaceholderType;
import jp.yahooapis.ss.v201909.campaignfeed.CampaignFeedSelector;
import jp.yahooapis.ss.v201909.campaigntarget.CampaignTarget;
import jp.yahooapis.ss.v201909.campaigntarget.CampaignTargetOperation;
import jp.yahooapis.ss.v201909.campaigntarget.CampaignTargetSelector;
import jp.yahooapis.ss.v201909.campaigntarget.CampaignTargetValues;
import jp.yahooapis.ss.v201909.feeditem.FeedItemOperation;
import jp.yahooapis.ss.v201909.feeditem.FeedItemPlaceholderType;
import jp.yahooapis.ss.v201909.feeditem.FeedItemSelector;
import jp.yahooapis.ss.v201909.feeditem.FeedItemValues;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


/**
 * example Ad operation and Utility method collection.
 */
public class AdSample {

  /**
   * main method for AdSample
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

    try {

      // =================================================================
      // BiddingStrategyService
      // =================================================================
      // ADD
      BiddingStrategyOperation addRequestBiddingStrategy =
          BiddingStrategyServiceSample.buildExampleMutateRequest(Operator.ADD, accountId, Collections.singletonList(BiddingStrategyServiceSample.createExampleTargetSpendBidding()));
      List<BiddingStrategyValues> addResponseBiddingStrategy = BiddingStrategyServiceSample.mutate(addRequestBiddingStrategy);
      valuesRepositoryFacade.getValuesHolder().setBiddingStrategyValuesList(addResponseBiddingStrategy);

      Long biddingStrategyId = valuesRepositoryFacade.getBiddingStrategyValuesRepository().findBiddingStrategyId(BiddingStrategyType.TARGET_SPEND);

      // sleep 30 second.
      System.out.println("\n***** sleep 30 seconds *****\n");
      Thread.sleep(30000);

      // SET
      BiddingStrategyOperation setRequestBiddingStrategy = BiddingStrategyServiceSample
          .buildExampleMutateRequest(Operator.SET, accountId, BiddingStrategyServiceSample.createExampleSetRequest(valuesRepositoryFacade.getBiddingStrategyValuesRepository().getBiddingStrategies()));
      BiddingStrategyServiceSample.mutate(setRequestBiddingStrategy);

      // GET
      BiddingStrategySelector getRequestBiddingStrategy =
          BiddingStrategyServiceSample.buildExampleGetRequest(accountId, valuesRepositoryFacade.getBiddingStrategyValuesRepository().getBiddingStrategyIds());
      BiddingStrategyServiceSample.get(getRequestBiddingStrategy);

      // sleep 30 second.
      System.out.println("\n***** sleep 30 seconds *****\n");
      Thread.sleep(30000);

      // =================================================================
      // CampaignService
      // =================================================================
      // ADD
      CampaignOperation addRequestCampaign = CampaignServiceSample.buildExampleMutateRequest(jp.yahooapis.ss.v201909.campaign.Operator.ADD, accountId, new ArrayList<Campaign>() {{
        add(CampaignServiceSample.createExampleStandardCampaign("SampleStandardCampaign_", CampaignServiceSample.createPortfolioBiddingCampaignBiddingStrategy(biddingStrategyId)));
        add(CampaignServiceSample.createExampleMobileAppCampaignForIOS("SampleMobileAppCampaignForIOS_", CampaignServiceSample.createPortfolioBiddingCampaignBiddingStrategy(biddingStrategyId)));
        add(CampaignServiceSample
            .createExampleMobileAppCampaignForANDROID("SampleMobileAppCampaignForANDROID_", CampaignServiceSample.createPortfolioBiddingCampaignBiddingStrategy(biddingStrategyId)));
      }});
      List<CampaignValues> addResponseCampaign = CampaignServiceSample.mutate(addRequestCampaign);
      valuesRepositoryFacade.getValuesHolder().setCampaignValuesList(addResponseCampaign);

      Long campaignIdStandard = valuesRepositoryFacade.getCampaignValuesRepository().findCampaignId(CampaignType.STANDARD);
      Long campaignIdMobileAppIOS = valuesRepositoryFacade.getCampaignValuesRepository().findCampaignId(AppStore.IOS);
      String appIdIOS = valuesRepositoryFacade.getCampaignValuesRepository().findAppId(campaignIdMobileAppIOS);
      Long campaignIdMobileAppAndroid = valuesRepositoryFacade.getCampaignValuesRepository().findCampaignId(AppStore.ANDROID);
      String appIdAndroid = valuesRepositoryFacade.getCampaignValuesRepository().findAppId(campaignIdMobileAppAndroid);

      // Check Status
      CampaignServiceSample.checkStatus(valuesRepositoryFacade.getCampaignValuesRepository().getCampaignIds());

      // SET
      CampaignOperation setRequestCampaign = CampaignServiceSample.buildExampleMutateRequest(jp.yahooapis.ss.v201909.campaign.Operator.SET, accountId,
          CampaignServiceSample.createExampleSetRequest(valuesRepositoryFacade.getCampaignValuesRepository().getCampaigns()));
      CampaignServiceSample.mutate(setRequestCampaign);

      // =================================================================
      // CampaignTargetService
      // =================================================================
      // ADD
      CampaignTargetOperation addRequestCampaignTarget =
          CampaignTargetServiceSample.buildExampleMutateRequest(jp.yahooapis.ss.v201909.campaigntarget.Operator.ADD, accountId, new ArrayList<CampaignTarget>() {{
            add(CampaignTargetServiceSample.createExampleScheduleTarget(accountId, campaignIdStandard));
            add(CampaignTargetServiceSample.createExampleLocationTarget(accountId, campaignIdStandard));
            add(CampaignTargetServiceSample.createExampleNetworkTarget(accountId, campaignIdStandard));
          }});
      List<CampaignTargetValues> addResponseCampaignTarget = CampaignTargetServiceSample.mutate(addRequestCampaignTarget);
      List<CampaignTarget> campaignTargets = new ArrayList<>();
      for (CampaignTargetValues values : addResponseCampaignTarget) {
        campaignTargets.add(values.getCampaignTarget());
      }

      // SET
      CampaignTargetOperation setRequestCampaignTarget =
          CampaignTargetServiceSample.buildExampleMutateRequest(jp.yahooapis.ss.v201909.campaigntarget.Operator.SET, accountId, CampaignTargetServiceSample.createExampleSetRequest(campaignTargets));
      CampaignTargetServiceSample.mutate(setRequestCampaignTarget);

      // GET
      CampaignTargetSelector getRequestCampaignTarget = CampaignTargetServiceSample.buildExampleGetRequest(accountId, campaignTargets);
      CampaignTargetServiceSample.get(getRequestCampaignTarget);

      // =================================================================
      // CampaignCriterionService
      // =================================================================
      // ADD
      CampaignCriterionOperation addRequestCampaignCriterion = CampaignCriterionServiceSample.buildExampleMutateRequest(jp.yahooapis.ss.v201909.campaigncriterion.Operator.ADD, accountId,
          Collections.singletonList(CampaignCriterionServiceSample.createExampleNegativeCampaignCriterion(campaignIdStandard)));
      List<CampaignCriterionValues> addResponseCampaignCriterion = CampaignCriterionServiceSample.mutate(addRequestCampaignCriterion);
      List<CampaignCriterion> campaignCriterions = new ArrayList<>();
      for (CampaignCriterionValues values : addResponseCampaignCriterion) {
        campaignCriterions.add(values.getCampaignCriterion());
      }

      // GET
      CampaignCriterionSelector getRequestCampaignCriterion = CampaignCriterionServiceSample.buildExampleGetRequest(accountId, campaignCriterions);
      CampaignCriterionServiceSample.get(getRequestCampaignCriterion);

      // =================================================================
      // AdGroupService
      // =================================================================
      // ADD
      AdGroupOperation addRequestAdGroup = AdGroupServiceSample.buildExampleMutateRequest(jp.yahooapis.ss.v201909.adgroup.Operator.ADD, accountId, new ArrayList<AdGroup>() {{
        add(AdGroupServiceSample.createExampleStandardAdGroup(campaignIdStandard));
        add(AdGroupServiceSample.createExampleMobileAppIOSAdGroup(campaignIdMobileAppIOS));
        add(AdGroupServiceSample.createExampleMobileAppANDROIDAdGroup(campaignIdMobileAppAndroid));
      }});
      List<AdGroupValues> addResponseAdGroup = AdGroupServiceSample.mutate(addRequestAdGroup);
      valuesRepositoryFacade.getValuesHolder().setAdGroupValuesList(addResponseAdGroup);

      Long adGroupIdStandard = valuesRepositoryFacade.getAdGroupValuesRepository().findAdGroupId(campaignIdStandard);
      Long adGroupIdMobileAppIOS = valuesRepositoryFacade.getAdGroupValuesRepository().findAdGroupId(campaignIdMobileAppIOS);
      Long adGroupIdMobileAppAndroid = valuesRepositoryFacade.getAdGroupValuesRepository().findAdGroupId(campaignIdMobileAppAndroid);

      // Check Status
      AdGroupServiceSample.checkStatus(valuesRepositoryFacade.getAdGroupValuesRepository().getAdGroups());

      // SET
      AdGroupOperation setRequestAdGroup = AdGroupServiceSample.buildExampleMutateRequest(jp.yahooapis.ss.v201909.adgroup.Operator.SET, accountId,
          AdGroupServiceSample.createExampleSetRequest(valuesRepositoryFacade.getAdGroupValuesRepository().getAdGroups()));
      AdGroupServiceSample.mutate(setRequestAdGroup);

      // =================================================================
      // AdGroupCriterionService
      // =================================================================
      // ADD
      AdGroupCriterionOperation addRequestAdGroupCriterion =
          AdGroupCriterionServiceSample.buildExampleMutateRequest(jp.yahooapis.ss.v201909.adgroupcriterion.Operator.ADD, accountId, new ArrayList<AdGroupCriterion>() {{
            add(AdGroupCriterionServiceSample.createExampleBiddableAdGroupCriterion(campaignIdStandard, adGroupIdStandard));
            add(AdGroupCriterionServiceSample.createExampleNegativeAdGroupCriterion(campaignIdStandard, adGroupIdStandard));
          }});
      List<AdGroupCriterionValues> addResponseAdGroupCriterion = AdGroupCriterionServiceSample.mutate(addRequestAdGroupCriterion);
      valuesRepositoryFacade.getValuesHolder().setAdGroupCriterionValuesList(addResponseAdGroupCriterion);

      // GET
      AdGroupCriterionSelector getRequestAdGroupCriterion =
          AdGroupCriterionServiceSample.buildExampleGetRequest(accountId, AdGroupCriterionUse.BIDDABLE, valuesRepositoryFacade.getAdGroupCriterionValuesRepository().getAdGroupCriterions());
      AdGroupCriterionServiceSample.get(getRequestAdGroupCriterion);

      // SET
      AdGroupCriterionOperation setRequestAdGroupCriterion = AdGroupCriterionServiceSample.buildExampleMutateRequest(jp.yahooapis.ss.v201909.adgroupcriterion.Operator.SET, accountId,
          AdGroupCriterionServiceSample.createExampleSetRequest(valuesRepositoryFacade.getAdGroupCriterionValuesRepository().getAdGroupCriterions()));
      AdGroupCriterionServiceSample.mutate(setRequestAdGroupCriterion);

      // =================================================================
      // AdGroupBidMultiplierService
      // =================================================================
      // SET
      AdGroupBidMultiplierOperation setRequestAdGroupBidMultiplier = AdGroupBidMultiplierServiceSample.buildExampleMutateRequest(jp.yahooapis.ss.v201909.adgroupbidmultiplier.Operator.SET, accountId,
          AdGroupBidMultiplierServiceSample.createExampleSetRequest(campaignIdStandard, adGroupIdStandard));
      AdGroupBidMultiplierServiceSample.mutate(setRequestAdGroupBidMultiplier);

      // GET
      AdGroupBidMultiplierSelector getRequestAdGroupBidMultiplier = AdGroupBidMultiplierServiceSample.buildExampleGetRequest(accountId, campaignIdStandard, adGroupIdStandard);
      AdGroupBidMultiplierServiceSample.get(getRequestAdGroupBidMultiplier);

      // =================================================================
      // AdGroupAdService
      // =================================================================
      // ADD
      AdGroupAdOperation addRequestAdGroupAd = AdGroupAdServiceSample.buildExampleMutateRequest(jp.yahooapis.ss.v201909.adgroupad.Operator.ADD, accountId, new ArrayList<AdGroupAd>() {{
        add(AdGroupAdServiceSample.createExampleExtendedTextAd(campaignIdStandard, adGroupIdStandard));
        add(AdGroupAdServiceSample.createExampleAppAdIOS(campaignIdMobileAppIOS, appIdIOS, adGroupIdMobileAppIOS));
        add(AdGroupAdServiceSample.createExampleAppAdANDROID(campaignIdMobileAppAndroid, appIdAndroid, adGroupIdMobileAppAndroid));
      }});
      List<AdGroupAdValues> addResponseAdGroupAd = AdGroupAdServiceSample.mutate(addRequestAdGroupAd);
      valuesRepositoryFacade.getValuesHolder().setAdGroupAdValuesList(addResponseAdGroupAd);

      // SET
      AdGroupAdOperation setRequestAdGroupAd = AdGroupAdServiceSample.buildExampleMutateRequest(jp.yahooapis.ss.v201909.adgroupad.Operator.SET, accountId,
          AdGroupAdServiceSample.createExampleSetRequest(valuesRepositoryFacade.getAdGroupAdValuesRepository().getAdGroupAds()));
      AdGroupAdServiceSample.mutate(setRequestAdGroupAd);

      // GET
      AdGroupAdSelector getRequestAdGroupAd = AdGroupAdServiceSample.buildExampleGetRequest(accountId, valuesRepositoryFacade.getAdGroupAdValuesRepository().getAdGroupAds());
      AdGroupAdServiceSample.get(getRequestAdGroupAd);

      // =================================================================
      // FeedItemService
      // =================================================================
      // ADD
      FeedItemOperation addRequestFeedItem = FeedItemServiceSample.buildExampleMutateRequest(jp.yahooapis.ss.v201909.feeditem.Operator.ADD, accountId, FeedItemPlaceholderType.QUICKLINK,
          Collections.singletonList(FeedItemServiceSample.createExampleQuicklink()));
      List<FeedItemValues> addResponseFeedItem = FeedItemServiceSample.mutate(addRequestFeedItem);
      valuesRepositoryFacade.getValuesHolder().setFeedItemValuesList(addResponseFeedItem);

      Long feedItemId = valuesRepositoryFacade.getFeedItemValuesRepository().findFeedItemId(FeedItemPlaceholderType.QUICKLINK);

      // GET
      FeedItemSelector getRequestFeedItem = FeedItemServiceSample.buildExampleGetRequest( //
          accountId, //
          valuesRepositoryFacade.getFeedItemValuesRepository().getFeedItemIds(), //
          Collections.emptyList() //
      );
      FeedItemServiceSample.get(getRequestFeedItem);

      // SET
      FeedItemOperation setRequestFeedItem = FeedItemServiceSample.buildExampleMutateRequest(jp.yahooapis.ss.v201909.feeditem.Operator.SET, accountId, FeedItemPlaceholderType.QUICKLINK,
          FeedItemServiceSample.createExampleSetRequest(valuesRepositoryFacade.getFeedItemValuesRepository().getFeedItems()));
      FeedItemServiceSample.mutate(setRequestFeedItem);

      // =================================================================
      // CampaignFeedService
      // =================================================================
      // SET
      CampaignFeedOperation setRequestCampaignFeed = CampaignFeedServiceSample.buildExampleMutateRequest(jp.yahooapis.ss.v201909.campaignfeed.Operator.SET, accountId,
          Collections.singletonList(CampaignFeedServiceSample.createExampleSetRequest(accountId, campaignIdStandard, feedItemId, CampaignFeedPlaceholderType.QUICKLINK)));
      CampaignFeedServiceSample.mutate(setRequestCampaignFeed);

      // GET
      CampaignFeedSelector getRequestCampaignFeed = CampaignFeedServiceSample.buildExampleGetRequest(accountId, Collections.singletonList(campaignIdStandard), Collections.singletonList(feedItemId));
      CampaignFeedServiceSample.get(getRequestCampaignFeed);

      // =================================================================
      // AdGroupFeedService
      // =================================================================
      // SET
      AdGroupFeedOperation setRequestAdGroupFeed = AdGroupFeedServiceSample.buildExampleMutateRequest(jp.yahooapis.ss.v201909.adgroupfeed.Operator.SET, accountId,
          Collections.singletonList(AdGroupFeedServiceSample.createExampleSetRequest(accountId, campaignIdStandard, adGroupIdStandard, feedItemId, AdGroupFeedPlaceholderType.QUICKLINK)));
      AdGroupFeedServiceSample.mutate(setRequestAdGroupFeed);

      // GET
      AdGroupFeedSelector getRequestAdGroupFeed = AdGroupFeedServiceSample.buildExampleGetRequest(accountId, campaignIdStandard, adGroupIdStandard, feedItemId);
      AdGroupFeedServiceSample.get(getRequestAdGroupFeed);

    } catch (Exception e) {
      e.printStackTrace();
      throw e;

    } finally {
      FeedItemServiceSample.cleanup(valuesHolder);
    }
  }
}

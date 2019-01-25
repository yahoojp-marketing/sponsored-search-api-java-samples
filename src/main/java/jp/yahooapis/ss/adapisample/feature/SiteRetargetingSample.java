/**
 * Copyright (C) 2019 Yahoo Japan Corporation. All Rights Reserved.
 */
package jp.yahooapis.ss.adapisample.feature;

import jp.yahooapis.ss.adapisample.basic.adgroup.AdGroupServiceSample;
import jp.yahooapis.ss.adapisample.basic.adgroupretargetinglist.AdGroupRetargetingListServiceSample;
import jp.yahooapis.ss.adapisample.basic.campaign.CampaignServiceSample;
import jp.yahooapis.ss.adapisample.basic.campaignretargetinglist.CampaignRetargetingListServiceSample;
import jp.yahooapis.ss.adapisample.basic.retargetinglist.RetargetingListServiceSample;
import jp.yahooapis.ss.adapisample.repository.ValuesRepositoryFacade;
import jp.yahooapis.ss.adapisample.util.SoapUtils;
import jp.yahooapis.ss.adapisample.util.ValuesHolder;
import jp.yahooapis.ss.v201901.adgroup.AdGroupOperation;
import jp.yahooapis.ss.v201901.adgroup.AdGroupValues;
import jp.yahooapis.ss.v201901.adgroupretargetinglist.AdGroupRetargetingList;
import jp.yahooapis.ss.v201901.adgroupretargetinglist.AdGroupRetargetingListOperation;
import jp.yahooapis.ss.v201901.adgroupretargetinglist.AdGroupRetargetingListSelector;
import jp.yahooapis.ss.v201901.adgroupretargetinglist.AdGroupRetargetingListValues;
import jp.yahooapis.ss.v201901.campaign.AppStore;
import jp.yahooapis.ss.v201901.campaign.CampaignOperation;
import jp.yahooapis.ss.v201901.campaign.CampaignType;
import jp.yahooapis.ss.v201901.campaign.CampaignValues;
import jp.yahooapis.ss.v201901.campaignretargetinglist.CampaignRetargetingList;
import jp.yahooapis.ss.v201901.campaignretargetinglist.CampaignRetargetingListOperation;
import jp.yahooapis.ss.v201901.campaignretargetinglist.CampaignRetargetingListSelector;
import jp.yahooapis.ss.v201901.campaignretargetinglist.CampaignRetargetingListValues;
import jp.yahooapis.ss.v201901.retargetinglist.CustomKey;
import jp.yahooapis.ss.v201901.retargetinglist.GetCustomKeySelector;
import jp.yahooapis.ss.v201901.retargetinglist.RetargetingListOperation;
import jp.yahooapis.ss.v201901.retargetinglist.RetargetingListSelector;
import jp.yahooapis.ss.v201901.retargetinglist.RetargetingListValues;
import jp.yahooapis.ss.v201901.retargetinglist.TargetListType;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * example SiteRetargeting operation and Utility method collection.
 */
public class SiteRetargetingSample {

  /**
   * example SiteRetargeting operation.
   *
   * @param args
   * @throws Exception
   */
  public static void main(String[] args) throws Exception {
    // =================================================================
    // Setup
    // =================================================================
    ValuesHolder valuesHolder = new ValuesHolder();
    ValuesRepositoryFacade valuesRepositoryFacade = new ValuesRepositoryFacade(valuesHolder);
    long accountId = SoapUtils.getAccountId();
    Long campaignIdStandard = null;
    Long campaignIdMobileApp = null;
    Long adGroupIdStandard = null;
    Long adGroupIdMobileApp = null;
    Long targetListIdDefault = null;

    try {
      // =================================================================
      // CampaignService
      // =================================================================
      // ADD
      CampaignOperation addCampaignOperation = CampaignServiceSample.buildExampleMutateRequest( //
          jp.yahooapis.ss.v201901.campaign.Operator.ADD,  //
          accountId,  //
          Arrays.asList( //
              CampaignServiceSample.createExampleStandardCampaign( //
                  "SampleStandardCampaign_",  //
                  CampaignServiceSample.createManualBiddingCampaignBiddingStrategy() //
              ), //
              CampaignServiceSample.createExampleMobileAppCampaignForIOS( //
                  "SampleMobileAppCampaignForIOS_",  //
                  CampaignServiceSample.createManualBiddingCampaignBiddingStrategy() //
              ) //
          ) //
      );
      List<CampaignValues> addCampaignValuesList = CampaignServiceSample.mutate(addCampaignOperation);

      valuesHolder.setCampaignValuesList(addCampaignValuesList);
      campaignIdStandard = valuesRepositoryFacade.getCampaignValuesRepository().findCampaignId(CampaignType.STANDARD);
      campaignIdMobileApp = valuesRepositoryFacade.getCampaignValuesRepository().findCampaignId(AppStore.IOS);


      // =================================================================
      // AdGroupService
      // =================================================================
      // ADD
      AdGroupOperation addAdGroupOperation = AdGroupServiceSample.buildExampleMutateRequest( //
          jp.yahooapis.ss.v201901.adgroup.Operator.ADD, //
          accountId, //
          Arrays.asList( //
              AdGroupServiceSample.createExampleStandardAdGroup(campaignIdStandard), //
              AdGroupServiceSample.createExampleStandardAdGroup(campaignIdMobileApp) //
          ) //
      );
      List<AdGroupValues> addAdGroupValuesList = AdGroupServiceSample.mutate(addAdGroupOperation);

      valuesHolder.setAdGroupValuesList(addAdGroupValuesList);
      adGroupIdStandard = valuesRepositoryFacade.getAdGroupValuesRepository().findAdGroupId(campaignIdStandard);
      adGroupIdMobileApp = valuesRepositoryFacade.getAdGroupValuesRepository().findAdGroupId(campaignIdMobileApp);


      // =================================================================
      // RetargetingListService
      // =================================================================
      // GET (DefaultTargetList)
      RetargetingListSelector getRetargetingListSelector = RetargetingListServiceSample.buildExampleGetRequest(accountId, Arrays.asList());
      getRetargetingListSelector.getTargetListTypes().clear();
      getRetargetingListSelector.getTargetListTypes().add(TargetListType.DEFAULT);
      List<RetargetingListValues> getRetargetingListValuesList = RetargetingListServiceSample.get(getRetargetingListSelector);

      valuesHolder.setRetargetingListValuesList(getRetargetingListValuesList);
      targetListIdDefault = valuesRepositoryFacade.getRetargetingListValuesRepository().findTargetListId(TargetListType.DEFAULT);

      // GetCustomKey
      GetCustomKeySelector getCustomKeySelector = RetargetingListServiceSample.buildExampleGetCustomKeyRequest(accountId);
      CustomKey customKey = RetargetingListServiceSample.getCustomKey(getCustomKeySelector);

      // ADD (RuleBaseTargetList)
      RetargetingListOperation addRetargetingListOperationRuleBase = RetargetingListServiceSample.buildExampleMutateRequest( //
          jp.yahooapis.ss.v201901.retargetinglist.Operator.ADD, //
          accountId, //
          Arrays.asList( //
              RetargetingListServiceSample.createExampleRuleBaseTargetListUrlRuleItem(accountId), //
              RetargetingListServiceSample.createExampleRuleBaseTargetListCustomKeyRuleItem(accountId, customKey.getTextKey()) //
          ) //
      );
      List<RetargetingListValues> addRetargetingListValuesListRuleBase = RetargetingListServiceSample.mutate(addRetargetingListOperationRuleBase);

      valuesHolder.setRetargetingListValuesList(addRetargetingListValuesListRuleBase);
      List<Long> ruleBaseTargetListIds = new ArrayList<>();
      for (Long targetListId : valuesRepositoryFacade.getRetargetingListValuesRepository().getTargetListIds()) {
        if (!targetListId.equals(targetListIdDefault)) {
          ruleBaseTargetListIds.add(targetListId);
        }
      }

      // ADD (LogicalTargetList)
      RetargetingListOperation addRetargetingListOperationLogical = RetargetingListServiceSample.buildExampleMutateRequest( //
          jp.yahooapis.ss.v201901.retargetinglist.Operator.ADD, //
          accountId, //
          Arrays.asList(RetargetingListServiceSample.createExampleLogicalTargetList(accountId, targetListIdDefault, ruleBaseTargetListIds)) //
      );
      List<RetargetingListValues> addRetargetingListValuesListLogical = RetargetingListServiceSample.mutate(addRetargetingListOperationLogical);

      valuesHolder.setRetargetingListValuesList(addRetargetingListValuesListLogical);
      List<Long> targetListIds = valuesRepositoryFacade.getRetargetingListValuesRepository().getTargetListIds();

      // GET
      getRetargetingListSelector = RetargetingListServiceSample.buildExampleGetRequest(accountId, targetListIds);
      RetargetingListServiceSample.get(getRetargetingListSelector);

      // SET
      RetargetingListOperation retargetingListOperation = RetargetingListServiceSample.buildExampleMutateRequest( //
          jp.yahooapis.ss.v201901.retargetinglist.Operator.SET, //
          accountId, //
          RetargetingListServiceSample.createExampleSetRequest(valuesRepositoryFacade.getRetargetingListValuesRepository().getTargetLists()) //
      );
      RetargetingListServiceSample.mutate(retargetingListOperation);

      // =================================================================
      // CampaignRetargetingListService
      // =================================================================
      // ADD
      CampaignRetargetingListOperation addCampaignRetargetingListOperation = CampaignRetargetingListServiceSample.buildExampleMutateRequest( //
          jp.yahooapis.ss.v201901.campaignretargetinglist.Operator.ADD, //
          accountId, //
          Arrays.asList( //
              CampaignRetargetingListServiceSample.createExampleIncludedCampaignRetargetingList(campaignIdStandard, targetListIdDefault), //
              CampaignRetargetingListServiceSample.createExampleExcludedCampaignRetargetingList(campaignIdMobileApp, targetListIdDefault) //
          ) //
      );
      List<CampaignRetargetingListValues> addCampaignRetargetingListValuesList = CampaignRetargetingListServiceSample.mutate(addCampaignRetargetingListOperation);

      List<CampaignRetargetingList> campaignRetargetingLists = new ArrayList<>();
      for (CampaignRetargetingListValues campaignRetargetingListValues : addCampaignRetargetingListValuesList) {
        campaignRetargetingLists.add(campaignRetargetingListValues.getCampaignRetargetingList());
      }

      // SET
      CampaignRetargetingListOperation setCampaignRetargetingListOperation = CampaignRetargetingListServiceSample.buildExampleMutateRequest( //
          jp.yahooapis.ss.v201901.campaignretargetinglist.Operator.SET, //
          accountId, CampaignRetargetingListServiceSample.createExampleSetRequest(campaignRetargetingLists) //
      );
      CampaignRetargetingListServiceSample.mutate(setCampaignRetargetingListOperation);

      // GET
      CampaignRetargetingListSelector campaignRetargetingListSelector = CampaignRetargetingListServiceSample.buildExampleGetRequest( //
          accountId, //
          Arrays.asList(campaignIdStandard, campaignIdMobileApp), //
          Arrays.asList(targetListIdDefault) //
      );
      CampaignRetargetingListServiceSample.get(campaignRetargetingListSelector);

      // REMOVE
      CampaignRetargetingListOperation removeCampaignRetargetingListOperation = CampaignRetargetingListServiceSample.buildExampleMutateRequest( //
          jp.yahooapis.ss.v201901.campaignretargetinglist.Operator.REMOVE, accountId, //
          campaignRetargetingLists //
      );
      CampaignRetargetingListServiceSample.mutate(removeCampaignRetargetingListOperation);


      // =================================================================
      // AdGroupRetargetingListService
      // =================================================================
      // ADD
      AdGroupRetargetingListOperation addAdGroupRetargetingListOperation = AdGroupRetargetingListServiceSample.buildExampleMutateRequest( //
          jp.yahooapis.ss.v201901.adgroupretargetinglist.Operator.ADD, //
          accountId, //
          Arrays.asList( //
              AdGroupRetargetingListServiceSample.createExampleIncludedAdGroupRetargetingList( //
                  campaignIdStandard, //
                  adGroupIdStandard, //
                  targetListIdDefault //
              ), //
              AdGroupRetargetingListServiceSample.createExampleExcludedAdGroupRetargetingList( //
                  campaignIdMobileApp, //
                  adGroupIdMobileApp, //
                  targetListIdDefault //
              ) //
          ) //
      );
      List<AdGroupRetargetingListValues> addAdGroupRetargetingListValuesList = AdGroupRetargetingListServiceSample.mutate(addAdGroupRetargetingListOperation);

      List<AdGroupRetargetingList> adGroupRetargetingLists = new ArrayList<>();
      for (AdGroupRetargetingListValues adGroupRetargetingListValues : addAdGroupRetargetingListValuesList) {
        adGroupRetargetingLists.add(adGroupRetargetingListValues.getAdGroupRetargetingList());
      }

      // SET
      AdGroupRetargetingListOperation setAdGroupRetargetingListOperation = AdGroupRetargetingListServiceSample.buildExampleMutateRequest( //
          jp.yahooapis.ss.v201901.adgroupretargetinglist.Operator.SET, //
          accountId, //
          AdGroupRetargetingListServiceSample.createExampleSetRequest(adGroupRetargetingLists) //
      );
      AdGroupRetargetingListServiceSample.mutate(setAdGroupRetargetingListOperation);

      // GET
      AdGroupRetargetingListSelector adGroupRetargetingListSelector = AdGroupRetargetingListServiceSample.buildExampleGetRequest( //
          accountId, //
          Arrays.asList(campaignIdStandard, campaignIdMobileApp), //
          Arrays.asList(adGroupIdStandard, adGroupIdMobileApp), //
          Arrays.asList(targetListIdDefault) //
      );
      AdGroupRetargetingListServiceSample.get(adGroupRetargetingListSelector);

      // REMOVE
      AdGroupRetargetingListOperation removeAdGroupRetargetingListOperation = AdGroupRetargetingListServiceSample.buildExampleMutateRequest( //
          jp.yahooapis.ss.v201901.adgroupretargetinglist.Operator.REMOVE, //
          accountId, //
          adGroupRetargetingLists //
      );
      AdGroupRetargetingListServiceSample.mutate(removeAdGroupRetargetingListOperation);

    } catch (Exception e) {
      e.printStackTrace();
      throw e;

    } finally {
      // =================================================================
      // Cleanup
      // =================================================================
      AdGroupServiceSample.cleanup(valuesHolder);
    }
  }
}

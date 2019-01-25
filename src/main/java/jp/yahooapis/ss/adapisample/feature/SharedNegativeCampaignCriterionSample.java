/**
 * Copyright (C) 2019 Yahoo Japan Corporation. All Rights Reserved.
 */
package jp.yahooapis.ss.adapisample.feature;

import jp.yahooapis.ss.adapisample.basic.accountshared.AccountSharedServiceSample;
import jp.yahooapis.ss.adapisample.basic.campaign.CampaignServiceSample;
import jp.yahooapis.ss.adapisample.basic.campaignsharedset.CampaignSharedSetServiceSample;
import jp.yahooapis.ss.adapisample.basic.sharedcriterion.SharedCriterionServiceSample;
import jp.yahooapis.ss.adapisample.repository.ValuesRepositoryFacade;
import jp.yahooapis.ss.adapisample.util.SoapUtils;
import jp.yahooapis.ss.adapisample.util.ValuesHolder;
import jp.yahooapis.ss.v201901.accountshared.AccountShared;
import jp.yahooapis.ss.v201901.accountshared.AccountSharedOperation;
import jp.yahooapis.ss.v201901.accountshared.AccountSharedSelector;
import jp.yahooapis.ss.v201901.accountshared.AccountSharedValues;
import jp.yahooapis.ss.v201901.campaign.Campaign;
import jp.yahooapis.ss.v201901.campaign.CampaignOperation;
import jp.yahooapis.ss.v201901.campaign.CampaignType;
import jp.yahooapis.ss.v201901.campaign.CampaignValues;
import jp.yahooapis.ss.v201901.campaign.Operator;
import jp.yahooapis.ss.v201901.campaignsharedset.CampaignSharedSet;
import jp.yahooapis.ss.v201901.campaignsharedset.CampaignSharedSetOperation;
import jp.yahooapis.ss.v201901.campaignsharedset.CampaignSharedSetSelector;
import jp.yahooapis.ss.v201901.campaignsharedset.CampaignSharedSetValues;
import jp.yahooapis.ss.v201901.sharedcriterion.SharedCriterion;
import jp.yahooapis.ss.v201901.sharedcriterion.SharedCriterionOperation;
import jp.yahooapis.ss.v201901.sharedcriterion.SharedCriterionSelector;
import jp.yahooapis.ss.v201901.sharedcriterion.SharedCriterionValues;

import java.util.ArrayList;
import java.util.List;

/**
 * example SharedNegativeCampaignCriterion operation and Utility method collection.
 */
public class SharedNegativeCampaignCriterionSample {

  /**
   * example SharedNegativeCampaignCriterion operation.
   * @throws Exception
   */
  public static void main(String[] args) throws Exception {

    // =================================================================
    // Setup
    // =================================================================
    ValuesHolder valuesHolder = new ValuesHolder();
    ValuesRepositoryFacade valuesRepositoryFacade = new ValuesRepositoryFacade(valuesHolder);
    long accountId = SoapUtils.getAccountId();
    long campaignId;
    List<Long> sharedListIds;
    List<Long> criterionIds = new ArrayList<>();

    try {
      // =================================================================
      // CampaignService
      // =================================================================
      // ADD
      CampaignOperation addRequestCampaign = CampaignServiceSample.buildExampleMutateRequest(Operator.ADD, accountId, new ArrayList<Campaign>() {{
        add(CampaignServiceSample.createExampleStandardCampaign("SampleStandardCampaign_", CampaignServiceSample.createManualBiddingCampaignBiddingStrategy()));
      }});

      List<CampaignValues> addResponseCampaign = CampaignServiceSample.mutate(addRequestCampaign);
      valuesRepositoryFacade.getValuesHolder().setCampaignValuesList(addResponseCampaign);
      campaignId = valuesRepositoryFacade.getCampaignValuesRepository().findCampaignId(CampaignType.STANDARD);

      // =================================================================
      // AccountSharedService
      // =================================================================
      // ADD
      AccountSharedOperation addRequestAccountShared =
          AccountSharedServiceSample.buildExampleMutateRequest(jp.yahooapis.ss.v201901.accountshared.Operator.ADD, accountId, new ArrayList<AccountShared>() {{
            add(AccountSharedServiceSample.createExampleAccountShared());
          }});

      List<AccountSharedValues> addResponseAccountShared = AccountSharedServiceSample.mutate(addRequestAccountShared);
      valuesRepositoryFacade.getValuesHolder().setAccountSharedValuesList(addResponseAccountShared);
      sharedListIds = valuesRepositoryFacade.getAccountSharedValuesRepository().getSharedListIds();

      // SET
      AccountSharedOperation setRequestAccountShared = AccountSharedServiceSample.buildExampleMutateRequest(jp.yahooapis.ss.v201901.accountshared.Operator.SET, accountId,
          AccountSharedServiceSample.createExampleSetRequest(valuesRepositoryFacade.getAccountSharedValuesRepository().getAccountShareds()));

      // run
      AccountSharedServiceSample.mutate(setRequestAccountShared);

      // GET
      AccountSharedSelector getRequestAccountSharedSet = AccountSharedServiceSample.buildExampleGetRequest(accountId, sharedListIds);
      AccountSharedServiceSample.get(getRequestAccountSharedSet);

      // =================================================================
      // CampaignSharedSetService
      // =================================================================
      // ADD
      CampaignSharedSetOperation addRequestCampaignSharedSet =
          CampaignSharedSetServiceSample.buildExampleMutateRequest(jp.yahooapis.ss.v201901.campaignsharedset.Operator.ADD, accountId, new ArrayList<CampaignSharedSet>() {{
            add(CampaignSharedSetServiceSample.createExampleCampaignSharedSet(sharedListIds.get(0), campaignId));
          }});
      List<CampaignSharedSetValues> addResponseCampaignSharedSet = CampaignSharedSetServiceSample.mutate(addRequestCampaignSharedSet);

      List<CampaignSharedSet> campaignSharedSets = new ArrayList<>();
      for (CampaignSharedSetValues campaignSharedSetValues : addResponseCampaignSharedSet) {
        campaignSharedSets.add(campaignSharedSetValues.getCampaignSharedSet());
      }

      // GET
      CampaignSharedSetSelector getRequestCampaignSharedSet = CampaignSharedSetServiceSample.buildExampleGetRequest(accountId, sharedListIds, new ArrayList<Long>() {{
        add(campaignId);
      }});
      CampaignSharedSetServiceSample.get(getRequestCampaignSharedSet);

      // =================================================================
      // SharedCriterionService
      // =================================================================
      // ADD
      SharedCriterionOperation addRequestSharedCriterion =
          SharedCriterionServiceSample.buildExampleMutateRequest(jp.yahooapis.ss.v201901.sharedcriterion.Operator.ADD, accountId, new ArrayList<SharedCriterion>() {{
            add(SharedCriterionServiceSample.createExampleSharedCriterion(sharedListIds.get(0)));
          }});
      List<SharedCriterionValues> addResponseSharedCriterion = SharedCriterionServiceSample.mutate(addRequestSharedCriterion);

      for (SharedCriterionValues sharedCriterionValues : addResponseSharedCriterion) {
        criterionIds.add(sharedCriterionValues.getSharedCriterion().getCriterionId());
      }

      // GET
      SharedCriterionSelector getRequestSharedCriterion = SharedCriterionServiceSample.buildExampleGetRequest(accountId, sharedListIds, criterionIds);
      SharedCriterionServiceSample.get(getRequestSharedCriterion);

      // =================================================================
      // CampaignSharedSetService
      // =================================================================
      // REMOVE
      CampaignSharedSetOperation removeRequestCampaignSharedSet =
          CampaignSharedSetServiceSample.buildExampleMutateRequest(jp.yahooapis.ss.v201901.campaignsharedset.Operator.REMOVE, accountId, campaignSharedSets);
      CampaignSharedSetServiceSample.mutate(removeRequestCampaignSharedSet);

      // =================================================================
      // AccountSharedService
      // =================================================================
      // REMOVE
      AccountSharedOperation removeRequestAccountShared = AccountSharedServiceSample
          .buildExampleMutateRequest(jp.yahooapis.ss.v201901.accountshared.Operator.REMOVE, accountId, valuesRepositoryFacade.getAccountSharedValuesRepository().getAccountShareds());
      AccountSharedServiceSample.mutate(removeRequestAccountShared);

    } catch (Exception ex) {
      ex.printStackTrace();
      throw ex;
    } finally {
      // =================================================================
      // Cleanup
      // =================================================================
      CampaignServiceSample.cleanup(valuesHolder);
    }
  }
}

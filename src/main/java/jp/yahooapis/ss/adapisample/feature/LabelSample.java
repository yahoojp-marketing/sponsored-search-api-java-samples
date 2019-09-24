/**
 * Copyright (C) 2019 Yahoo Japan Corporation. All Rights Reserved.
 */
package jp.yahooapis.ss.adapisample.feature;

import jp.yahooapis.ss.adapisample.basic.adgroup.AdGroupServiceSample;
import jp.yahooapis.ss.adapisample.basic.adgroupad.AdGroupAdServiceSample;
import jp.yahooapis.ss.adapisample.basic.adgroupadlabel.AdGroupAdLabelServiceSample;
import jp.yahooapis.ss.adapisample.basic.adgroupcriterion.AdGroupCriterionServiceSample;
import jp.yahooapis.ss.adapisample.basic.adgroupcriterionlabel.AdGroupCriterionLabelServiceSample;
import jp.yahooapis.ss.adapisample.basic.adgrouplabel.AdGroupLabelServiceSample;
import jp.yahooapis.ss.adapisample.basic.campaign.CampaignServiceSample;
import jp.yahooapis.ss.adapisample.basic.campaignlabel.CampaignLabelServiceSample;
import jp.yahooapis.ss.adapisample.basic.label.LabelServiceSample;
import jp.yahooapis.ss.adapisample.repository.ValuesRepositoryFacade;
import jp.yahooapis.ss.adapisample.util.SoapUtils;
import jp.yahooapis.ss.adapisample.util.ValuesHolder;
import jp.yahooapis.ss.v201909.adgroup.AdGroupOperation;
import jp.yahooapis.ss.v201909.adgroup.AdGroupSelector;
import jp.yahooapis.ss.v201909.adgroup.AdGroupValues;
import jp.yahooapis.ss.v201909.adgroupad.AdGroupAdOperation;
import jp.yahooapis.ss.v201909.adgroupad.AdGroupAdSelector;
import jp.yahooapis.ss.v201909.adgroupad.AdGroupAdValues;
import jp.yahooapis.ss.v201909.adgroupad.AdType;
import jp.yahooapis.ss.v201909.adgroupadlabel.AdGroupAdLabelOperation;
import jp.yahooapis.ss.v201909.adgroupcriterion.AdGroupCriterionOperation;
import jp.yahooapis.ss.v201909.adgroupcriterion.AdGroupCriterionSelector;
import jp.yahooapis.ss.v201909.adgroupcriterion.AdGroupCriterionUse;
import jp.yahooapis.ss.v201909.adgroupcriterion.AdGroupCriterionValues;
import jp.yahooapis.ss.v201909.adgroupcriterionlabel.AdGroupCriterionLabelOperation;
import jp.yahooapis.ss.v201909.adgrouplabel.AdGroupLabelOperation;
import jp.yahooapis.ss.v201909.campaign.CampaignOperation;
import jp.yahooapis.ss.v201909.campaign.CampaignSelector;
import jp.yahooapis.ss.v201909.campaign.CampaignType;
import jp.yahooapis.ss.v201909.campaign.CampaignValues;
import jp.yahooapis.ss.v201909.campaign.ContainsLabelId;
import jp.yahooapis.ss.v201909.campaignlabel.CampaignLabelOperation;
import jp.yahooapis.ss.v201909.label.LabelOperation;
import jp.yahooapis.ss.v201909.label.LabelSelector;
import jp.yahooapis.ss.v201909.label.LabelValues;
import jp.yahooapis.ss.v201909.label.Operator;

import java.util.Collections;
import java.util.List;


/**
 * example Label operation and Utility method collection.
 */
public class LabelSample {

  /**
   * example Label operation.
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
      // CampaignService
      // =================================================================
      // ADD
      CampaignOperation addRequestCampaign = CampaignServiceSample.buildExampleMutateRequest(jp.yahooapis.ss.v201909.campaign.Operator.ADD, accountId,
          Collections.singletonList(CampaignServiceSample.createExampleStandardCampaign("SampleStandardCampaign_", CampaignServiceSample.createManualBiddingCampaignBiddingStrategy())));
      List<CampaignValues> addResponseCampaign = CampaignServiceSample.mutate(addRequestCampaign);
      valuesRepositoryFacade.getValuesHolder().setCampaignValuesList(addResponseCampaign);
      Long campaignId = valuesRepositoryFacade.getCampaignValuesRepository().findCampaignId(CampaignType.STANDARD);

      // GET
      CampaignSelector getRequestCampaign = CampaignServiceSample.buildExampleGetRequest(accountId, Collections.singletonList(campaignId));
      getRequestCampaign.setContainsLabelId(ContainsLabelId.TRUE);
      CampaignServiceSample.get(getRequestCampaign);

      // =================================================================
      // AdGroupService
      // =================================================================
      // ADD
      AdGroupOperation addRequestAdGroup = AdGroupServiceSample
          .buildExampleMutateRequest(jp.yahooapis.ss.v201909.adgroup.Operator.ADD, accountId, Collections.singletonList(AdGroupServiceSample.createExampleStandardAdGroup(campaignId)));
      List<AdGroupValues> addResponseAdGroup = AdGroupServiceSample.mutate(addRequestAdGroup);
      valuesRepositoryFacade.getValuesHolder().setAdGroupValuesList(addResponseAdGroup);
      Long adGroupId = valuesRepositoryFacade.getAdGroupValuesRepository().findAdGroupId(campaignId);

      // GET
      AdGroupSelector getRequestAdGroup = AdGroupServiceSample.buildExampleGetRequest(accountId, valuesRepositoryFacade.getAdGroupValuesRepository().getAdGroups());
      getRequestAdGroup.setContainsLabelId(jp.yahooapis.ss.v201909.adgroup.ContainsLabelId.TRUE);
      AdGroupServiceSample.get(getRequestAdGroup);

      // =================================================================
      // AdGroupCriterionService
      // =================================================================
      // ADD
      AdGroupCriterionOperation addRequestAdGroupCriterion = AdGroupCriterionServiceSample.buildExampleMutateRequest(jp.yahooapis.ss.v201909.adgroupcriterion.Operator.ADD, accountId,
          Collections.singletonList(AdGroupCriterionServiceSample.createExampleBiddableAdGroupCriterion(campaignId, adGroupId)));
      List<AdGroupCriterionValues> addResponseAdGroupCriterion = AdGroupCriterionServiceSample.mutate(addRequestAdGroupCriterion);
      valuesRepositoryFacade.getValuesHolder().setAdGroupCriterionValuesList(addResponseAdGroupCriterion);
      Long criterionId = valuesRepositoryFacade.getAdGroupCriterionValuesRepository().findCriterionId(campaignId, adGroupId, AdGroupCriterionUse.BIDDABLE);

      // GET
      AdGroupCriterionSelector getRequestAdGroupCriterion =
          AdGroupCriterionServiceSample.buildExampleGetRequest(accountId, AdGroupCriterionUse.BIDDABLE, valuesRepositoryFacade.getAdGroupCriterionValuesRepository().getAdGroupCriterions());
      getRequestAdGroupCriterion.setContainsLabelId(jp.yahooapis.ss.v201909.adgroupcriterion.ContainsLabelId.TRUE);
      AdGroupCriterionServiceSample.get(getRequestAdGroupCriterion);

      // =================================================================
      // AdGroupAdService
      // =================================================================
      // ADD
      AdGroupAdOperation addRequestAdGroupAd = AdGroupAdServiceSample
          .buildExampleMutateRequest(jp.yahooapis.ss.v201909.adgroupad.Operator.ADD, accountId, Collections.singletonList(AdGroupAdServiceSample.createExampleExtendedTextAd(campaignId, adGroupId)));
      List<AdGroupAdValues> addResponseAdGroupAd = AdGroupAdServiceSample.mutate(addRequestAdGroupAd);
      valuesRepositoryFacade.getValuesHolder().setAdGroupAdValuesList(addResponseAdGroupAd);
      Long adId = valuesRepositoryFacade.getAdGroupAdValuesRepository().findAdId(campaignId, adGroupId, AdType.EXTENDED_TEXT_AD);

      // GET
      AdGroupAdSelector getRequestAdGroupAd = AdGroupAdServiceSample.buildExampleGetRequest(accountId, valuesRepositoryFacade.getAdGroupAdValuesRepository().getAdGroupAds());
      getRequestAdGroupAd.setContainsLabelId(jp.yahooapis.ss.v201909.adgroupad.ContainsLabelId.TRUE);
      AdGroupAdServiceSample.get(getRequestAdGroupAd);

      // =================================================================
      // LabelService
      // =================================================================
      // ADD
      LabelOperation addRequestLabel = LabelServiceSample.buildExampleMutateRequest(Operator.ADD, accountId, Collections.singletonList(LabelServiceSample.createExampleLabel()));
      List<LabelValues> addResponseLabel = LabelServiceSample.mutate(addRequestLabel);
      valuesRepositoryFacade.getValuesHolder().setLabelValuesList(addResponseLabel);
      Long labelId = valuesRepositoryFacade.getLabelValuesRepository().getLabelIds().get(0);

      // SET
      LabelOperation setRequestLabel =
          LabelServiceSample.buildExampleMutateRequest(Operator.SET, accountId, LabelServiceSample.createExampleSetRequest(valuesRepositoryFacade.getLabelValuesRepository().getLabels()));
      LabelServiceSample.mutate(setRequestLabel);

      // GET
      LabelSelector getRequestLabel = LabelServiceSample.buildExampleGetRequest(accountId, valuesRepositoryFacade.getLabelValuesRepository().getLabelIds());
      LabelServiceSample.get(getRequestLabel);

      // =================================================================
      // CampaignLabelService
      // =================================================================
      // ADD
      CampaignLabelOperation addRequestCampaignLabel = CampaignLabelServiceSample.buildExampleMutateRequest(jp.yahooapis.ss.v201909.campaignlabel.Operator.ADD, accountId,
          Collections.singletonList(CampaignLabelServiceSample.createExampleCampaignLabel(campaignId, labelId)));
      CampaignLabelServiceSample.mutate(addRequestCampaignLabel);

      // =================================================================
      // CampaignService
      // =================================================================
      // GET
      CampaignServiceSample.get(getRequestCampaign);

      // =================================================================
      // AdGroupLabelService
      // =================================================================
      // ADD
      AdGroupLabelOperation addRequestAdGroupLabel = AdGroupLabelServiceSample.buildExampleMutateRequest(jp.yahooapis.ss.v201909.adgrouplabel.Operator.ADD, accountId,
          Collections.singletonList(AdGroupLabelServiceSample.createExampleAdGroupLabel(campaignId, adGroupId, labelId)));
      AdGroupLabelServiceSample.mutate(addRequestAdGroupLabel);

      // =================================================================
      // AdGroupService
      // =================================================================
      // GET
      AdGroupServiceSample.get(getRequestAdGroup);

      // =================================================================
      // AdGroupCriterionLabelService
      // =================================================================
      // ADD
      AdGroupCriterionLabelOperation addRequestAdGroupCriterionLabel = AdGroupCriterionLabelServiceSample
          .buildExampleMutateRequest(jp.yahooapis.ss.v201909.adgroupcriterionlabel.Operator.ADD, accountId,
              Collections.singletonList(AdGroupCriterionLabelServiceSample.createExampleAdGroupCriterionLabel(campaignId, adGroupId, criterionId, labelId)));
      AdGroupCriterionLabelServiceSample.mutate(addRequestAdGroupCriterionLabel);

      // =================================================================
      // AdGroupCriterionService
      // =================================================================
      // GET
      AdGroupCriterionServiceSample.get(getRequestAdGroupCriterion);

      // =================================================================
      // AdGroupAdLabelService
      // =================================================================
      // ADD
      AdGroupAdLabelOperation addRequestAdGroupAdLabel = AdGroupAdLabelServiceSample.buildExampleMutateRequest(jp.yahooapis.ss.v201909.adgroupadlabel.Operator.ADD, accountId,
          Collections.singletonList(AdGroupAdLabelServiceSample.createExampleAdGroupAdLabel(campaignId, adGroupId, adId, labelId)));
      AdGroupAdLabelServiceSample.mutate(addRequestAdGroupAdLabel);

      // =================================================================
      // AdGroupAdService
      // =================================================================
      // GET
      AdGroupAdServiceSample.get(getRequestAdGroupAd);

      // =================================================================
      // LabelService
      // =================================================================
      // GET
      LabelServiceSample.get(getRequestLabel);


    } catch (Exception e) {
      e.printStackTrace();
      throw e;

    } finally {
      LabelServiceSample.cleanup(valuesHolder);
      AdGroupAdServiceSample.cleanup(valuesHolder);
    }
  }

}

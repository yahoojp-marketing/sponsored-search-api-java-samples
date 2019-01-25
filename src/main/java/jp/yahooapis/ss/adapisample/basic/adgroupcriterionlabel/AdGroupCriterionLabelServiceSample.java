/**
 * Copyright (C) 2019 Yahoo Japan Corporation. All Rights Reserved.
 */
package jp.yahooapis.ss.adapisample.basic.adgroupcriterionlabel;

import jp.yahooapis.ss.adapisample.basic.adgroupcriterion.AdGroupCriterionServiceSample;
import jp.yahooapis.ss.adapisample.basic.label.LabelServiceSample;
import jp.yahooapis.ss.adapisample.repository.ValuesRepositoryFacade;
import jp.yahooapis.ss.adapisample.util.SoapUtils;
import jp.yahooapis.ss.adapisample.util.ValuesHolder;
import jp.yahooapis.ss.v201901.Error;
import jp.yahooapis.ss.v201901.adgroupcriterion.AdGroupCriterionUse;
import jp.yahooapis.ss.v201901.adgroupcriterionlabel.AdGroupCriterionLabel;
import jp.yahooapis.ss.v201901.adgroupcriterionlabel.AdGroupCriterionLabelOperation;
import jp.yahooapis.ss.v201901.adgroupcriterionlabel.AdGroupCriterionLabelReturnValue;
import jp.yahooapis.ss.v201901.adgroupcriterionlabel.AdGroupCriterionLabelService;
import jp.yahooapis.ss.v201901.adgroupcriterionlabel.AdGroupCriterionLabelServiceInterface;
import jp.yahooapis.ss.v201901.adgroupcriterionlabel.AdGroupCriterionLabelValues;
import jp.yahooapis.ss.v201901.adgroupcriterionlabel.Operator;
import jp.yahooapis.ss.v201901.campaign.CampaignType;

import java.util.ArrayList;
import java.util.List;

import javax.xml.ws.Holder;


/**
 * example AdGroupCriterionLabel operation and Utility method collection.
 */
public class AdGroupCriterionLabelServiceSample {

  /**
   * main method for AdGroupCriterionLabelServiceSample
   *
   * @param args command line arguments
   */
  public static void main(String[] args) throws Exception {

    // =================================================================
    // Setting
    // =================================================================
    ValuesHolder valuesHolder = new ValuesHolder();
    long accountId = SoapUtils.getAccountId();

    try {
      // =================================================================
      // check & create upper service object.
      // =================================================================
      valuesHolder = setup();
      ValuesRepositoryFacade valuesRepositoryFacade = new ValuesRepositoryFacade(valuesHolder);
      Long campaignId = valuesRepositoryFacade.getCampaignValuesRepository().findCampaignId(CampaignType.STANDARD);
      Long adGroupId = valuesRepositoryFacade.getAdGroupValuesRepository().findAdGroupId(campaignId);
      Long criterionId = valuesRepositoryFacade.getAdGroupCriterionValuesRepository().findCriterionId(campaignId, adGroupId, AdGroupCriterionUse.BIDDABLE);
      Long lavelId = valuesRepositoryFacade.getLabelValuesRepository().getLabelIds().get(0);

      // =================================================================
      // AdGroupCriterionLabelService ADD
      // =================================================================
      // create request.
      AdGroupCriterionLabelOperation addRequest = buildExampleMutateRequest(Operator.ADD, accountId, new ArrayList<AdGroupCriterionLabel>() {{
        add(createExampleAdGroupCriterionLabel(campaignId, adGroupId, criterionId, lavelId));
      }});

      // run
      mutate(addRequest);

      // =================================================================
      // AdGroupCriterionLabelService REMOVE
      // =================================================================
      // create request.
      AdGroupCriterionLabelOperation removeRequest = buildExampleMutateRequest(Operator.REMOVE, accountId, addRequest.getOperand());

      // run
      mutate(removeRequest);

    } catch (Exception e) {
      e.printStackTrace();
      throw e;
    } finally {
      cleanup(valuesHolder);
    }
  }

  /**
   * example mutate request.
   */
  public static AdGroupCriterionLabelOperation buildExampleMutateRequest(Operator operator, long accountId, List<AdGroupCriterionLabel> operand) {
    AdGroupCriterionLabelOperation operation = new AdGroupCriterionLabelOperation();
    operation.setOperator(operator);
    operation.setAccountId(accountId);
    operation.getOperand().addAll(operand);

    return operation;
  }

  /**
   * example adGroupCriterion label request.
   *
   * @return AdGroupCriterionLabel
   */
  public static AdGroupCriterionLabel createExampleAdGroupCriterionLabel(Long campaignId, Long adGroupId, Long criterionId, Long labelId) {

    AdGroupCriterionLabel adGroupCriterionLabel = new AdGroupCriterionLabel();
    adGroupCriterionLabel.setCampaignId(campaignId);
    adGroupCriterionLabel.setAdGroupId(adGroupId);
    adGroupCriterionLabel.setCriterionId(criterionId);
    adGroupCriterionLabel.setLabelId(labelId);

    return adGroupCriterionLabel;
  }

  /**
   * example mutate adGroupCriterion labels.
   *
   * @param operation AdGroupCriterionLabelOperation
   * @return AdGroupCriterionLabelValues
   */
  public static List<AdGroupCriterionLabelValues> mutate(AdGroupCriterionLabelOperation operation) throws Exception {
    // Call API
    System.out.println("############################################");
    System.out.println("AdGroupCriterionLabelService::mutate(" + operation.getOperator() + ")");
    System.out.println("############################################");

    Holder<AdGroupCriterionLabelReturnValue> adGroupCriterionLabelReturnValueHolder = new Holder<AdGroupCriterionLabelReturnValue>();
    Holder<List<Error>> errorHolder = new Holder<List<Error>>();
    AdGroupCriterionLabelServiceInterface adGroupCriterionLabelService = SoapUtils.createServiceInterface(AdGroupCriterionLabelServiceInterface.class, AdGroupCriterionLabelService.class);
    adGroupCriterionLabelService.mutate(operation, adGroupCriterionLabelReturnValueHolder, errorHolder);

    SoapUtils.checkSoapError(errorHolder, adGroupCriterionLabelReturnValueHolder.value.getValues());

    // Response
    return adGroupCriterionLabelReturnValueHolder.value.getValues();
  }

  /**
   * check & create upper service object.
   *
   * @return ValuesHolder
   * @throws Exception
   */
  private static ValuesHolder setup() throws Exception {

    ValuesHolder adGroupCriterionValuesHolder = new AdGroupCriterionServiceSample().create();
    ValuesHolder labelValuesHolder = new LabelServiceSample().create();

    ValuesHolder selfValuesHolder = new ValuesHolder();
    selfValuesHolder.setBiddingStrategyValuesList(adGroupCriterionValuesHolder.getBiddingStrategyValuesList());
    selfValuesHolder.setFeedFolderValuesList(adGroupCriterionValuesHolder.getFeedFolderValuesList());
    selfValuesHolder.setCampaignValuesList(adGroupCriterionValuesHolder.getCampaignValuesList());
    selfValuesHolder.setAdGroupValuesList(adGroupCriterionValuesHolder.getAdGroupValuesList());
    selfValuesHolder.setAdGroupAdValuesList(adGroupCriterionValuesHolder.getAdGroupAdValuesList());
    selfValuesHolder.setAdGroupCriterionValuesList(adGroupCriterionValuesHolder.getAdGroupCriterionValuesList());
    selfValuesHolder.setLabelValuesList(labelValuesHolder.getLabelValuesList());

    return selfValuesHolder;
  }

  /**
   * cleanup service object.
   *
   * @param valuesHolder ValuesHolder
   * @throws Exception
   */
  public static void cleanup(ValuesHolder valuesHolder) throws Exception {

    LabelServiceSample.cleanup(valuesHolder);
    AdGroupCriterionServiceSample.cleanup(valuesHolder);
  }

}

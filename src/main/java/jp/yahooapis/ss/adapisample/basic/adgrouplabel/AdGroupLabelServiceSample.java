/**
 * Copyright (C) 2019 Yahoo Japan Corporation. All Rights Reserved.
 */
package jp.yahooapis.ss.adapisample.basic.adgrouplabel;

import jp.yahooapis.ss.adapisample.basic.adgroup.AdGroupServiceSample;
import jp.yahooapis.ss.adapisample.basic.label.LabelServiceSample;
import jp.yahooapis.ss.adapisample.repository.ValuesRepositoryFacade;
import jp.yahooapis.ss.adapisample.util.SoapUtils;
import jp.yahooapis.ss.adapisample.util.ValuesHolder;
import jp.yahooapis.ss.v201901.Error;
import jp.yahooapis.ss.v201901.adgrouplabel.AdGroupLabel;
import jp.yahooapis.ss.v201901.adgrouplabel.AdGroupLabelOperation;
import jp.yahooapis.ss.v201901.adgrouplabel.AdGroupLabelReturnValue;
import jp.yahooapis.ss.v201901.adgrouplabel.AdGroupLabelService;
import jp.yahooapis.ss.v201901.adgrouplabel.AdGroupLabelServiceInterface;
import jp.yahooapis.ss.v201901.adgrouplabel.AdGroupLabelValues;
import jp.yahooapis.ss.v201901.adgrouplabel.Operator;
import jp.yahooapis.ss.v201901.campaign.CampaignType;

import java.util.ArrayList;
import java.util.List;

import javax.xml.ws.Holder;


/**
 * example AdGroupLabel operation and Utility method collection.
 */
public class AdGroupLabelServiceSample {

  /**
   * main method for AdGroupLabelServiceSample
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
      Long lavelId = valuesRepositoryFacade.getLabelValuesRepository().getLabelIds().get(0);

      // =================================================================
      // AdGroupLabelService ADD
      // =================================================================
      // create request.
      AdGroupLabelOperation addRequest = buildExampleMutateRequest(Operator.ADD, accountId, new ArrayList<AdGroupLabel>() {{
        add(createExampleAdGroupLabel(campaignId, adGroupId, lavelId));
      }});

      // run
      mutate(addRequest);

      // =================================================================
      // AdGroupLabelService REMOVE
      // =================================================================
      // create request.
      AdGroupLabelOperation removeRequest = buildExampleMutateRequest(Operator.REMOVE, accountId, addRequest.getOperand());

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
  public static AdGroupLabelOperation buildExampleMutateRequest(Operator operator, long accountId, List<AdGroupLabel> operand) {
    AdGroupLabelOperation operation = new AdGroupLabelOperation();
    operation.setOperator(operator);
    operation.setAccountId(accountId);
    operation.getOperand().addAll(operand);

    return operation;
  }

  /**
   * example adGroup label request.
   *
   * @return AdGroupLabel
   */
  public static AdGroupLabel createExampleAdGroupLabel(Long campaignId, Long adGroupId, Long labelId) {

    AdGroupLabel adGroupLabel = new AdGroupLabel();
    adGroupLabel.setCampaignId(campaignId);
    adGroupLabel.setAdGroupId(adGroupId);
    adGroupLabel.setLabelId(labelId);

    return adGroupLabel;
  }

  /**
   * example mutate adGroup labels.
   *
   * @param operation AdGroupLabelOperation
   * @return AdGroupLabelValues
   */
  public static List<AdGroupLabelValues> mutate(AdGroupLabelOperation operation) throws Exception {
    // Call API
    System.out.println("############################################");
    System.out.println("AdGroupLabelService::mutate(" + operation.getOperator() + ")");
    System.out.println("############################################");

    Holder<AdGroupLabelReturnValue> adGroupLabelReturnValueHolder = new Holder<AdGroupLabelReturnValue>();
    Holder<List<Error>> errorHolder = new Holder<List<Error>>();
    AdGroupLabelServiceInterface adGroupLabelService = SoapUtils.createServiceInterface(AdGroupLabelServiceInterface.class, AdGroupLabelService.class);
    adGroupLabelService.mutate(operation, adGroupLabelReturnValueHolder, errorHolder);

    SoapUtils.checkSoapError(errorHolder, adGroupLabelReturnValueHolder.value.getValues());

    // Response
    return adGroupLabelReturnValueHolder.value.getValues();
  }

  /**
   * check & create upper service object.
   *
   * @return ValuesHolder
   * @throws Exception
   */
  private static ValuesHolder setup() throws Exception {

    ValuesHolder adGroupValuesHolder = new AdGroupServiceSample().create();
    ValuesHolder labelValuesHolder = new LabelServiceSample().create();

    ValuesHolder selfValuesHolder = new ValuesHolder();
    selfValuesHolder.setFeedFolderValuesList(adGroupValuesHolder.getFeedFolderValuesList());
    selfValuesHolder.setCampaignValuesList(adGroupValuesHolder.getCampaignValuesList());
    selfValuesHolder.setAdGroupValuesList(adGroupValuesHolder.getAdGroupValuesList());
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
    AdGroupServiceSample.cleanup(valuesHolder);
  }

}

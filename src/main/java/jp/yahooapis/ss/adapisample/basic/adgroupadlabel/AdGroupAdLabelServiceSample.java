/**
 * Copyright (C) 2019 Yahoo Japan Corporation. All Rights Reserved.
 */
package jp.yahooapis.ss.adapisample.basic.adgroupadlabel;

import jp.yahooapis.ss.adapisample.basic.adgroupad.AdGroupAdServiceSample;
import jp.yahooapis.ss.adapisample.basic.label.LabelServiceSample;
import jp.yahooapis.ss.adapisample.repository.ValuesRepositoryFacade;
import jp.yahooapis.ss.adapisample.util.SoapUtils;
import jp.yahooapis.ss.adapisample.util.ValuesHolder;
import jp.yahooapis.ss.v201901.Error;
import jp.yahooapis.ss.v201901.adgroupad.AdType;
import jp.yahooapis.ss.v201901.adgroupadlabel.AdGroupAdLabel;
import jp.yahooapis.ss.v201901.adgroupadlabel.AdGroupAdLabelOperation;
import jp.yahooapis.ss.v201901.adgroupadlabel.AdGroupAdLabelReturnValue;
import jp.yahooapis.ss.v201901.adgroupadlabel.AdGroupAdLabelService;
import jp.yahooapis.ss.v201901.adgroupadlabel.AdGroupAdLabelServiceInterface;
import jp.yahooapis.ss.v201901.adgroupadlabel.AdGroupAdLabelValues;
import jp.yahooapis.ss.v201901.adgroupadlabel.Operator;
import jp.yahooapis.ss.v201901.campaign.CampaignType;

import java.util.ArrayList;
import java.util.List;

import javax.xml.ws.Holder;


/**
 * example AdGroupAdLabel operation and Utility method collection.
 */
public class AdGroupAdLabelServiceSample {

  /**
   * main method for AdGroupAdLabelServiceSample
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
      Long adId = valuesRepositoryFacade.getAdGroupAdValuesRepository().findAdId(campaignId, adGroupId, AdType.EXTENDED_TEXT_AD);
      Long lavelId = valuesRepositoryFacade.getLabelValuesRepository().getLabelIds().get(0);

      // =================================================================
      // AdGroupAdLabelService ADD
      // =================================================================
      // create request.
      AdGroupAdLabelOperation addRequest = buildExampleMutateRequest(Operator.ADD, accountId, new ArrayList<AdGroupAdLabel>() {{
        add(createExampleAdGroupAdLabel(campaignId, adGroupId, adId, lavelId));
      }});

      // run
      mutate(addRequest);

      // =================================================================
      // AdGroupAdLabelService REMOVE
      // =================================================================
      // create request.
      AdGroupAdLabelOperation removeRequest = buildExampleMutateRequest(Operator.REMOVE, accountId, addRequest.getOperand());

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
  public static AdGroupAdLabelOperation buildExampleMutateRequest(Operator operator, long accountId, List<AdGroupAdLabel> operand) {
    AdGroupAdLabelOperation operation = new AdGroupAdLabelOperation();
    operation.setOperator(operator);
    operation.setAccountId(accountId);
    operation.getOperand().addAll(operand);

    return operation;
  }

  /**
   * example adGroupAd label request.
   *
   * @return AdGroupAdLabel
   */
  public static AdGroupAdLabel createExampleAdGroupAdLabel(Long campaignId, Long adGroupId, Long adId, Long labelId) {

    AdGroupAdLabel adGroupAdLabel = new AdGroupAdLabel();
    adGroupAdLabel.setCampaignId(campaignId);
    adGroupAdLabel.setAdGroupId(adGroupId);
    adGroupAdLabel.setAdId(adId);
    adGroupAdLabel.setLabelId(labelId);

    return adGroupAdLabel;
  }

  /**
   * example mutate adGroupAd labels.
   *
   * @param operation AdGroupAdLabelOperation
   * @return AdGroupAdLabelValues
   */
  public static List<AdGroupAdLabelValues> mutate(AdGroupAdLabelOperation operation) throws Exception {
    // Call API
    System.out.println("############################################");
    System.out.println("AdGroupAdLabelService::mutate(" + operation.getOperator() + ")");
    System.out.println("############################################");

    Holder<AdGroupAdLabelReturnValue> adGroupAdLabelReturnValueHolder = new Holder<AdGroupAdLabelReturnValue>();
    Holder<List<Error>> errorHolder = new Holder<List<Error>>();
    AdGroupAdLabelServiceInterface adGroupAdLabelService = SoapUtils.createServiceInterface(AdGroupAdLabelServiceInterface.class, AdGroupAdLabelService.class);
    adGroupAdLabelService.mutate(operation, adGroupAdLabelReturnValueHolder, errorHolder);

    SoapUtils.checkSoapError(errorHolder, adGroupAdLabelReturnValueHolder.value.getValues());

    // Response
    return adGroupAdLabelReturnValueHolder.value.getValues();
  }

  /**
   * check & create upper service object.
   *
   * @return ValuesHolder
   * @throws Exception
   */
  private static ValuesHolder setup() throws Exception {

    ValuesHolder adGroupAdValuesHolder = new AdGroupAdServiceSample().create();
    ValuesHolder labelValuesHolder = new LabelServiceSample().create();

    ValuesHolder selfValuesHolder = new ValuesHolder();
    selfValuesHolder.setBiddingStrategyValuesList(adGroupAdValuesHolder.getBiddingStrategyValuesList());
    selfValuesHolder.setFeedFolderValuesList(adGroupAdValuesHolder.getFeedFolderValuesList());
    selfValuesHolder.setCampaignValuesList(adGroupAdValuesHolder.getCampaignValuesList());
    selfValuesHolder.setAdGroupValuesList(adGroupAdValuesHolder.getAdGroupValuesList());
    selfValuesHolder.setAdGroupAdValuesList(adGroupAdValuesHolder.getAdGroupAdValuesList());
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
    AdGroupAdServiceSample.cleanup(valuesHolder);
  }

}

/**
 * Copyright (C) 2019 Yahoo Japan Corporation. All Rights Reserved.
 */
package jp.yahooapis.ss.adapisample.basic.campaignlabel;

import jp.yahooapis.ss.adapisample.basic.campaign.CampaignServiceSample;
import jp.yahooapis.ss.adapisample.basic.label.LabelServiceSample;
import jp.yahooapis.ss.adapisample.repository.ValuesRepositoryFacade;
import jp.yahooapis.ss.adapisample.util.SoapUtils;
import jp.yahooapis.ss.adapisample.util.ValuesHolder;
import jp.yahooapis.ss.v201901.Error;
import jp.yahooapis.ss.v201901.campaign.CampaignType;
import jp.yahooapis.ss.v201901.campaignlabel.CampaignLabel;
import jp.yahooapis.ss.v201901.campaignlabel.CampaignLabelOperation;
import jp.yahooapis.ss.v201901.campaignlabel.CampaignLabelReturnValue;
import jp.yahooapis.ss.v201901.campaignlabel.CampaignLabelService;
import jp.yahooapis.ss.v201901.campaignlabel.CampaignLabelServiceInterface;
import jp.yahooapis.ss.v201901.campaignlabel.CampaignLabelValues;
import jp.yahooapis.ss.v201901.campaignlabel.Operator;

import java.util.ArrayList;
import java.util.List;

import javax.xml.ws.Holder;


/**
 * example CampaignLabel operation and Utility method collection.
 */
public class CampaignLabelServiceSample {

  /**
   * main method for CampaignLabelServiceSample
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
      Long lavelId = valuesRepositoryFacade.getLabelValuesRepository().getLabelIds().get(0);

      // =================================================================
      // CampaignLabelService ADD
      // =================================================================
      // create request.
      CampaignLabelOperation addRequest = buildExampleMutateRequest(Operator.ADD, accountId, new ArrayList<CampaignLabel>() {{
        add(createExampleCampaignLabel(campaignId, lavelId));
      }});

      // run
      mutate(addRequest);

      // =================================================================
      // CampaignLabelService REMOVE
      // =================================================================
      // create request.
      CampaignLabelOperation removeRequest = buildExampleMutateRequest(Operator.REMOVE, accountId, addRequest.getOperand());

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
  public static CampaignLabelOperation buildExampleMutateRequest(Operator operator, long accountId, List<CampaignLabel> operand) {
    CampaignLabelOperation operation = new CampaignLabelOperation();
    operation.setOperator(operator);
    operation.setAccountId(accountId);
    operation.getOperand().addAll(operand);

    return operation;
  }

  /**
   * example campaign label request.
   *
   * @return CampaignLabel
   */
  public static CampaignLabel createExampleCampaignLabel(Long campaignId, Long labelId) {

    CampaignLabel campaignLabel = new CampaignLabel();
    campaignLabel.setCampaignId(campaignId);
    campaignLabel.setLabelId(labelId);
    return campaignLabel;
  }

  /**
   * example mutate campaign labels.
   *
   * @param operation CampaignLabelOperation
   * @return CampaignLabelValues
   */
  public static List<CampaignLabelValues> mutate(CampaignLabelOperation operation) throws Exception {
    // Call API
    System.out.println("############################################");
    System.out.println("CampaignLabelService::mutate(" + operation.getOperator() + ")");
    System.out.println("############################################");

    Holder<CampaignLabelReturnValue> campaignLabelReturnValueHolder = new Holder<CampaignLabelReturnValue>();
    Holder<List<Error>> errorHolder = new Holder<List<Error>>();
    CampaignLabelServiceInterface campaignLabelService = SoapUtils.createServiceInterface(CampaignLabelServiceInterface.class, CampaignLabelService.class);
    campaignLabelService.mutate(operation, campaignLabelReturnValueHolder, errorHolder);

    SoapUtils.checkSoapError(errorHolder, campaignLabelReturnValueHolder.value.getValues());

    // Response
    return campaignLabelReturnValueHolder.value.getValues();
  }

  /**
   * check & create upper service object.
   *
   * @return ValuesHolder
   * @throws Exception
   */
  private static ValuesHolder setup() throws Exception {

    ValuesHolder campaignValuesHolder = new CampaignServiceSample().create();
    ValuesHolder labelValuesHolder = new LabelServiceSample().create();

    ValuesHolder selfValuesHolder = new ValuesHolder();
    selfValuesHolder.setFeedFolderValuesList(campaignValuesHolder.getFeedFolderValuesList());
    selfValuesHolder.setCampaignValuesList(campaignValuesHolder.getCampaignValuesList());
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
    CampaignServiceSample.cleanup(valuesHolder);
  }

}

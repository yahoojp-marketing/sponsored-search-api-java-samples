/**
 * Copyright (C) 2019 Yahoo Japan Corporation. All Rights Reserved.
 */
package jp.yahooapis.ss.adapisample.basic.campaigncriterion;

import jp.yahooapis.ss.adapisample.basic.campaign.CampaignServiceSample;
import jp.yahooapis.ss.adapisample.repository.ValuesRepositoryFacade;
import jp.yahooapis.ss.adapisample.util.SoapUtils;
import jp.yahooapis.ss.adapisample.util.ValuesHolder;
import jp.yahooapis.ss.v201901.Error;
import jp.yahooapis.ss.v201901.Paging;
import jp.yahooapis.ss.v201901.campaign.CampaignType;
import jp.yahooapis.ss.v201901.campaigncriterion.CampaignCriterion;
import jp.yahooapis.ss.v201901.campaigncriterion.CampaignCriterionOperation;
import jp.yahooapis.ss.v201901.campaigncriterion.CampaignCriterionPage;
import jp.yahooapis.ss.v201901.campaigncriterion.CampaignCriterionReturnValue;
import jp.yahooapis.ss.v201901.campaigncriterion.CampaignCriterionSelector;
import jp.yahooapis.ss.v201901.campaigncriterion.CampaignCriterionService;
import jp.yahooapis.ss.v201901.campaigncriterion.CampaignCriterionServiceInterface;
import jp.yahooapis.ss.v201901.campaigncriterion.CampaignCriterionUse;
import jp.yahooapis.ss.v201901.campaigncriterion.CampaignCriterionValues;
import jp.yahooapis.ss.v201901.campaigncriterion.CriterionType;
import jp.yahooapis.ss.v201901.campaigncriterion.Keyword;
import jp.yahooapis.ss.v201901.campaigncriterion.KeywordMatchType;
import jp.yahooapis.ss.v201901.campaigncriterion.NegativeCampaignCriterion;
import jp.yahooapis.ss.v201901.campaigncriterion.Operator;

import java.util.ArrayList;
import java.util.List;

import javax.xml.ws.Holder;

/**
 * example CampaignService operation and Utility method collection.
 */
public class CampaignCriterionServiceSample {

  /**
   * main method for CampaignCriterionServiceSample
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

      // =================================================================
      // CampaignCriterionService ADD
      // =================================================================
      // create request.
      CampaignCriterionOperation addCampaignCriterionOperation = buildExampleMutateRequest(Operator.ADD, accountId, new ArrayList<CampaignCriterion>() {{
        add(createExampleNegativeCampaignCriterion(campaignId));
      }});

      // run
      List<CampaignCriterionValues> addCampaignCriterionValues = mutate(addCampaignCriterionOperation);

      List<CampaignCriterion> campaignCriterions = new ArrayList<>();
      for (CampaignCriterionValues campaignCriterionValues: addCampaignCriterionValues) {
        campaignCriterions.add(campaignCriterionValues.getCampaignCriterion());
      }

      // =================================================================
      // CampaignCriterionService GET
      // =================================================================
      // create request.
      CampaignCriterionSelector campaignCriterionSelector = buildExampleGetRequest(accountId, campaignCriterions);

      // run
      get(campaignCriterionSelector);

      // =================================================================
      // CampaignCriterionService REMOVE
      // =================================================================
      // create request.
      CampaignCriterionOperation removeCampaignCriterionOperation = buildExampleMutateRequest(Operator.REMOVE, accountId, campaignCriterions);

      // run
      mutate(removeCampaignCriterionOperation);

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
  public static CampaignCriterionOperation buildExampleMutateRequest(Operator operator, long accountId, List<CampaignCriterion> operand) {
    CampaignCriterionOperation operation = new CampaignCriterionOperation();
    operation.setOperator(operator);
    operation.setAccountId(accountId);
    operation.getOperand().addAll(operand);

    return operation;
  }

  /**
   * example mutate campaignCriterions.
   *
   * @param operation CampaignCriterionOperation
   * @return CampaignCriterionValues
   */
  public static List<CampaignCriterionValues> mutate(CampaignCriterionOperation operation) throws Exception {

    // Call API
    System.out.println("############################################");
    System.out.println("CampaignCriterionService::mutate(" + operation.getOperator() + ")");
    System.out.println("############################################");

    Holder<CampaignCriterionReturnValue> campaignCriterionReturnValueHolder = new Holder<CampaignCriterionReturnValue>();
    Holder<List<Error>> errorHolder = new Holder<List<Error>>();
    CampaignCriterionServiceInterface campaignCriterionService = SoapUtils.createServiceInterface(CampaignCriterionServiceInterface.class, CampaignCriterionService.class);
    campaignCriterionService.mutate(operation, campaignCriterionReturnValueHolder, errorHolder);

    SoapUtils.checkSoapError(errorHolder, campaignCriterionReturnValueHolder.value.getValues());

    // Response
    return campaignCriterionReturnValueHolder.value.getValues();
  }

  /**
   * example get request.
   *
   * @param accountId long
   * @param campaignCriterions CampaignCriterion
   * @return CampaignCriterionSelector
   */
  public static CampaignCriterionSelector buildExampleGetRequest(long accountId, List<CampaignCriterion> campaignCriterions) {
    // Set Selector
    CampaignCriterionSelector selector = new CampaignCriterionSelector();
    selector.setAccountId(accountId);

    for (CampaignCriterion campaignCriterion : campaignCriterions) {
      selector.getCampaignIds().add(campaignCriterion.getCampaignId());
      selector.getCriterionIds().add(campaignCriterion.getCriterion().getCriterionId());
    }
    selector.setCriterionUse(CampaignCriterionUse.NEGATIVE);

    // Set Paging
    Paging paging = new Paging();
    paging.setStartIndex(1);
    paging.setNumberResults(20);
    selector.setPaging(paging);

    return selector;
  }

  /**
   * check & create upper service object.
   *
   * @return ValuesHolder
   * @throws Exception
   */
  private static ValuesHolder setup() throws Exception {

    return CampaignServiceSample.create();
  }

  /**
   * cleanup service object.
   *
   * @param valuesHolder ValuesHolder
   * @throws Exception
   */
  public static void cleanup(ValuesHolder valuesHolder) throws Exception {
    CampaignServiceSample.cleanup(valuesHolder);
  }

  /**
   * Sample Program for CampaignCriterionService GET.
   *
   * @param selector CampaignCriterionSelector
   * @return CampaignCriterionValues
   * @throws Exception
   */
  public static List<CampaignCriterionValues> get(CampaignCriterionSelector selector) throws Exception {

    // Call API
    System.out.println("############################################");
    System.out.println("CampaignCriterionService::get");
    System.out.println("############################################");

    Holder<CampaignCriterionPage> campaignCriterionPageHolder = new Holder<CampaignCriterionPage>();
    Holder<List<Error>> errorHolder = new Holder<List<Error>>();
    CampaignCriterionServiceInterface campaignCriterionService = SoapUtils.createServiceInterface(CampaignCriterionServiceInterface.class, CampaignCriterionService.class);
    campaignCriterionService.get(selector, campaignCriterionPageHolder, errorHolder);

    SoapUtils.checkSoapError(errorHolder, campaignCriterionPageHolder.value.getValues());

    // Response
    return campaignCriterionPageHolder.value.getValues();
  }

  /**
   * example campaign criterion request.
   *
   * @param campaignId long
   * @return CampaignCriterion
   */
  public static CampaignCriterion createExampleNegativeCampaignCriterion(long campaignId) {

    // Set Keyword
    Keyword keyword = new Keyword();
    keyword.setType(CriterionType.KEYWORD);
    keyword.setText("sample text");
    keyword.setMatchType(KeywordMatchType.PHRASE);

    // Set Operand
    NegativeCampaignCriterion negativeCampaignCriterion = new NegativeCampaignCriterion();
    negativeCampaignCriterion.setCampaignId(campaignId);
    negativeCampaignCriterion.setCriterionUse(CampaignCriterionUse.NEGATIVE);
    negativeCampaignCriterion.setCriterion(keyword);

    return negativeCampaignCriterion;
  }

}

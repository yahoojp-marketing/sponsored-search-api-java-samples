/**
 * Copyright (C) 2019 Yahoo Japan Corporation. All Rights Reserved.
 */
package jp.yahooapis.ss.adapisample.basic.campaignsharedset;

import jp.yahooapis.ss.adapisample.basic.accountshared.AccountSharedServiceSample;
import jp.yahooapis.ss.adapisample.basic.campaign.CampaignServiceSample;
import jp.yahooapis.ss.adapisample.repository.ValuesRepositoryFacade;
import jp.yahooapis.ss.adapisample.util.SoapUtils;
import jp.yahooapis.ss.adapisample.util.ValuesHolder;
import jp.yahooapis.ss.v201901.Error;
import jp.yahooapis.ss.v201901.Paging;
import jp.yahooapis.ss.v201901.campaign.CampaignType;
import jp.yahooapis.ss.v201901.campaignsharedset.CampaignSharedSet;
import jp.yahooapis.ss.v201901.campaignsharedset.CampaignSharedSetOperation;
import jp.yahooapis.ss.v201901.campaignsharedset.CampaignSharedSetPage;
import jp.yahooapis.ss.v201901.campaignsharedset.CampaignSharedSetReturnValue;
import jp.yahooapis.ss.v201901.campaignsharedset.CampaignSharedSetSelector;
import jp.yahooapis.ss.v201901.campaignsharedset.CampaignSharedSetService;
import jp.yahooapis.ss.v201901.campaignsharedset.CampaignSharedSetServiceInterface;
import jp.yahooapis.ss.v201901.campaignsharedset.CampaignSharedSetValues;
import jp.yahooapis.ss.v201901.campaignsharedset.Operator;

import java.util.ArrayList;
import java.util.List;

import javax.xml.ws.Holder;

/**
 * example CampaignSharedSetService operation and Utility method collection.
 */
public class CampaignSharedSetServiceSample {

  /**
   * main method for CampaignSharedSetServiceSample
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
      Long sharedListId = valuesRepositoryFacade.getAccountSharedValuesRepository().getSharedListIds().get(0);
      Long campaignId = valuesRepositoryFacade.getCampaignValuesRepository().findCampaignId(CampaignType.STANDARD);

      // =================================================================
      // CampaignSharedSetService ADD
      // =================================================================
      // create request.
      CampaignSharedSetOperation addRequest = buildExampleMutateRequest(Operator.ADD, accountId, new ArrayList<CampaignSharedSet>() {{
        add(createExampleCampaignSharedSet(sharedListId, campaignId));
      }});

      // run
      List<CampaignSharedSetValues> addResponse = mutate(addRequest);
      List<CampaignSharedSet> campaignSharedSets = new ArrayList<>();
      for (CampaignSharedSetValues values : addResponse) {
        campaignSharedSets.add(values.getCampaignSharedSet());
      }

      // =================================================================
      // CampaignSharedSetService GET
      // =================================================================
      // create request.
      CampaignSharedSetSelector getRequest = buildExampleGetRequest(accountId, new ArrayList<Long>(){{add(sharedListId);}}, new ArrayList<Long>(){{add(campaignId);}});

      // run
      get(getRequest);

      // =================================================================
      // CampaignSharedSetService REMOVE
      // =================================================================
      // create request.
      CampaignSharedSetOperation removeRequest = buildExampleMutateRequest(Operator.REMOVE, accountId, campaignSharedSets);

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
   * example mutate campaignSharedSet.
   *
   * @param operation SharedCriterionOperation
   * @return SharedCriterionValues
   */
  public static List<CampaignSharedSetValues> mutate(CampaignSharedSetOperation operation) throws Exception {

    // Call API
    System.out.println("############################################");
    System.out.println("CampaignSharedSetService::mutate(" + operation.getOperator() + ")");
    System.out.println("############################################");

    Holder<CampaignSharedSetReturnValue> campaignSharedSetReturnValueHolder = new Holder<CampaignSharedSetReturnValue>();
    Holder<List<Error>> errorHolder = new Holder<List<Error>>();
    CampaignSharedSetServiceInterface campaignSharedSetService = SoapUtils.createServiceInterface(CampaignSharedSetServiceInterface.class, CampaignSharedSetService.class);
    campaignSharedSetService.mutate(operation, campaignSharedSetReturnValueHolder, errorHolder);

    SoapUtils.checkSoapError(errorHolder, campaignSharedSetReturnValueHolder.value.getValues());

    // Response
    return campaignSharedSetReturnValueHolder.value.getValues();
  }

  /**
   * Sample Program for CampaignSharedSetService GET.
   *
   * @param selector CampaignSharedSetSelector
   * @return CampaignSharedSetValues
   */
  public static List<CampaignSharedSetValues> get(CampaignSharedSetSelector selector) throws Exception {

    // Call API
    System.out.println("############################################");
    System.out.println("CampaignSharedSetService::get");
    System.out.println("############################################");

    Holder<CampaignSharedSetPage> campaignSharedSetPageHolder = new Holder<CampaignSharedSetPage>();
    Holder<List<Error>> errorHolder = new Holder<List<Error>>();
    CampaignSharedSetServiceInterface campaignSharedSetService = SoapUtils.createServiceInterface(CampaignSharedSetServiceInterface.class, CampaignSharedSetService.class);
    campaignSharedSetService.get(selector, campaignSharedSetPageHolder, errorHolder);

    SoapUtils.checkSoapError(errorHolder, campaignSharedSetPageHolder.value.getValues());

    // Response
    return campaignSharedSetPageHolder.value.getValues();
  }

  /**
   * example mutate request.
   */
  public static CampaignSharedSetOperation buildExampleMutateRequest(Operator operator, long accountId, List<CampaignSharedSet> operand) {
    CampaignSharedSetOperation operation = new CampaignSharedSetOperation();
    operation.setOperator(operator);
    operation.setAccountId(accountId);
    operation.getOperand().addAll(operand);

    return operation;
  }

  /**
   * example get request.
   *
   * @param accountId long
   * @param sharedListIds Long
   * @param campaignIds Long
   * @return CampaignSharedSetSelector
   */
  public static CampaignSharedSetSelector buildExampleGetRequest(long accountId, List<Long> sharedListIds, List<Long> campaignIds) {
    // Set Selector
    CampaignSharedSetSelector selector = new CampaignSharedSetSelector();
    selector.setAccountId(accountId);

    if (sharedListIds.size() > 0) {
      selector.getSharedListIds().addAll(sharedListIds);
    }
    if (campaignIds.size() > 0) {
      selector.getCampaignIds().addAll(campaignIds);
    }

    // Set Paging
    Paging paging = new Paging();
    paging.setStartIndex(1);
    paging.setNumberResults(20);
    selector.setPaging(paging);

    return selector;
  }

  /**
   * example campaignSharedSet request.
   *
   * @param sharedListId Long
   * @param campaignId Long
   * @return CampaignSharedSet
   */
  public static CampaignSharedSet createExampleCampaignSharedSet(Long sharedListId, Long campaignId) {

    // Set Operand
    CampaignSharedSet operand = new CampaignSharedSet();
    operand.setSharedListId(sharedListId);
    operand.setCampaignId(campaignId);

    return operand;
  }

  /**
   * check & create upper service object.
   *
   * @return ValuesHolder
   * @throws Exception
   */
  private static ValuesHolder setup() throws Exception {

    ValuesHolder accountSharedValuesHolder = AccountSharedServiceSample.create();
    ValuesHolder campaignValuesHolder = CampaignServiceSample.create();
    ValuesHolder selfValuesHOlder = new ValuesHolder();
    selfValuesHOlder.setAccountSharedValuesList(accountSharedValuesHolder.getAccountSharedValuesList());
    selfValuesHOlder.setCampaignValuesList(campaignValuesHolder.getCampaignValuesList());
    return selfValuesHOlder;
  }

  /**
   * cleanup service object.
   *
   * @param valuesHolder ValuesHolder
   * @throws Exception
   */
  public static void cleanup(ValuesHolder valuesHolder) throws Exception {

    CampaignServiceSample.cleanup(valuesHolder);
    AccountSharedServiceSample.cleanup(valuesHolder);
  }

}
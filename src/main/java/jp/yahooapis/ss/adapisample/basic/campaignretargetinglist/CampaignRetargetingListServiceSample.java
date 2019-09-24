/**
 * Copyright (C) 2019 Yahoo Japan Corporation. All Rights Reserved.
 */
package jp.yahooapis.ss.adapisample.basic.campaignretargetinglist;

import jp.yahooapis.ss.adapisample.basic.campaign.CampaignServiceSample;
import jp.yahooapis.ss.adapisample.basic.retargetinglist.RetargetingListServiceSample;
import jp.yahooapis.ss.adapisample.repository.ValuesRepositoryFacade;
import jp.yahooapis.ss.adapisample.util.SoapUtils;
import jp.yahooapis.ss.adapisample.util.ValuesHolder;
import jp.yahooapis.ss.v201909.Error;
import jp.yahooapis.ss.v201909.Paging;
import jp.yahooapis.ss.v201909.campaign.CampaignType;
import jp.yahooapis.ss.v201909.campaignretargetinglist.CampaignRetargetingList;
import jp.yahooapis.ss.v201909.campaignretargetinglist.CampaignRetargetingListOperation;
import jp.yahooapis.ss.v201909.campaignretargetinglist.CampaignRetargetingListPage;
import jp.yahooapis.ss.v201909.campaignretargetinglist.CampaignRetargetingListReturnValue;
import jp.yahooapis.ss.v201909.campaignretargetinglist.CampaignRetargetingListSelector;
import jp.yahooapis.ss.v201909.campaignretargetinglist.CampaignRetargetingListService;
import jp.yahooapis.ss.v201909.campaignretargetinglist.CampaignRetargetingListServiceInterface;
import jp.yahooapis.ss.v201909.campaignretargetinglist.CampaignRetargetingListValues;
import jp.yahooapis.ss.v201909.campaignretargetinglist.CriterionTargetList;
import jp.yahooapis.ss.v201909.campaignretargetinglist.ExcludedType;
import jp.yahooapis.ss.v201909.campaignretargetinglist.Operator;
import jp.yahooapis.ss.v201909.retargetinglist.TargetListType;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.xml.ws.Holder;

/**
 * example CampaignRetargetingListService operation and Utility method collection.
 */
public class CampaignRetargetingListServiceSample  {

  /**
   * main method for CampaignRetargetingListServiceSample
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
      Long campaignIdStandard = valuesRepositoryFacade.getCampaignValuesRepository().findCampaignId(CampaignType.STANDARD);
      Long campaignIdMobileApp = valuesRepositoryFacade.getCampaignValuesRepository().findCampaignId(CampaignType.MOBILE_APP);
      Long targetListId = valuesRepositoryFacade.getRetargetingListValuesRepository().findTargetListId(TargetListType.DEFAULT);

      // =================================================================
      // CampaignRetargetingListService ADD
      // =================================================================
      // create request.
      CampaignRetargetingListOperation addRequest = buildExampleMutateRequest(Operator.ADD, accountId, new ArrayList<CampaignRetargetingList>() {{
        add(createExampleIncludedCampaignRetargetingList(campaignIdStandard, targetListId));
        add(createExampleExcludedCampaignRetargetingList(campaignIdMobileApp, targetListId));
      }});

      // run
      List<CampaignRetargetingListValues> addResponse = mutate(addRequest);
      List<CampaignRetargetingList> campaignRetargetingLists = new ArrayList<>();
      for (CampaignRetargetingListValues values : addResponse) {
        campaignRetargetingLists.add(values.getCampaignRetargetingList());
      }

      // =================================================================
      // CampaignRetargetingListServiceService SET
      // =================================================================
      // create request.
      CampaignRetargetingListOperation setRequest = buildExampleMutateRequest(Operator.SET, accountId, createExampleSetRequest(campaignRetargetingLists));

      // run
      mutate(setRequest);

      // =================================================================
      // CampaignRetargetingListService GET
      // =================================================================
      // create request.
      CampaignRetargetingListSelector getRequest = buildExampleGetRequest(accountId, Arrays.asList(campaignIdStandard, campaignIdMobileApp), Arrays.asList(targetListId));

      // run
      get(getRequest);

      // =================================================================
      // CampaignRetargetingListService REMOVE
      // =================================================================
      // create request.
      CampaignRetargetingListOperation removeRequest = buildExampleMutateRequest(Operator.REMOVE, accountId, campaignRetargetingLists);

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
   * example mutate campaignRetargetingList.
   *
   * @param operation CampaignRetargetingListOperation
   * @return CampaignRetargetingListValues
   */
  public static List<CampaignRetargetingListValues> mutate(CampaignRetargetingListOperation operation) throws Exception {
    // Call API
    System.out.println("############################################");
    System.out.println("CampaignRetargetingListService::mutate(" + operation.getOperator() + ")");
    System.out.println("############################################");

    Holder<CampaignRetargetingListReturnValue> campaignRetargetingListReturnValueHolder = new Holder<CampaignRetargetingListReturnValue>();
    Holder<List<Error>> errorHolder = new Holder<List<Error>>();
    CampaignRetargetingListServiceInterface campaignRetargetingListService = SoapUtils.createServiceInterface(CampaignRetargetingListServiceInterface.class, CampaignRetargetingListService.class);
    campaignRetargetingListService.mutate(operation, campaignRetargetingListReturnValueHolder, errorHolder);

    SoapUtils.checkSoapError(errorHolder, campaignRetargetingListReturnValueHolder.value.getValues());

    // Response
    return campaignRetargetingListReturnValueHolder.value.getValues();
  }

  /**
   * Sample Program for CampaignRetargetingListService GET.
   *
   * @param selector CampaignRetargetingListSelector
   * @return CampaignRetargetingListValues
   * @throws Exception
   */
  public static List<CampaignRetargetingListValues> get(CampaignRetargetingListSelector selector) throws Exception {

    // Call API
    System.out.println("############################################");
    System.out.println("CampaignRetargetingListService::get");
    System.out.println("############################################");

    Holder<CampaignRetargetingListPage> CampaignRetargetingListPage = new Holder<CampaignRetargetingListPage>();
    Holder<List<Error>> errorHolder = new Holder<List<Error>>();
    CampaignRetargetingListServiceInterface CampaignRetargetingListService = SoapUtils.createServiceInterface(CampaignRetargetingListServiceInterface.class, CampaignRetargetingListService.class);
    CampaignRetargetingListService.get(selector, CampaignRetargetingListPage, errorHolder);

    SoapUtils.checkSoapError(errorHolder, CampaignRetargetingListPage.value.getValues());

    // Response
    return CampaignRetargetingListPage.value.getValues();
  }

  /**
   * example mutate request.
   */
  public static CampaignRetargetingListOperation buildExampleMutateRequest(Operator operator, long accountId, List<CampaignRetargetingList> operand) {
    CampaignRetargetingListOperation operation = new CampaignRetargetingListOperation();
    operation.setOperator(operator);
    operation.setAccountId(accountId);
    operation.getOperand().addAll(operand);

    return operation;
  }

  /**
   * example get request.
   *
   * @param accountId
   * @param campaignIds
   * @param targetListIds
   * @return CampaignRetargetingListSelector
   */
  public static CampaignRetargetingListSelector buildExampleGetRequest(long accountId, List<Long> campaignIds, List<Long> targetListIds) {

    // Set Selector
    CampaignRetargetingListSelector selector = new CampaignRetargetingListSelector();
    selector.setAccountId(accountId);

    if (campaignIds.size() > 0) {
      selector.getCampaignIds().addAll(campaignIds);
    }
    if (targetListIds.size() > 0) {
      selector.getTargetListIds().addAll(targetListIds);
    }

    Paging paging = new Paging();
    paging.setStartIndex(1);
    paging.setNumberResults(20);
    selector.setPaging(paging);

    return selector;
  }

  /**
   * example INCLUDED CampaignRetargetingList request.
   *
   * @param campaignId Long
   * @param targetListId Long
   * @return CampaignRetargetingList
   */
  public static CampaignRetargetingList createExampleIncludedCampaignRetargetingList(Long campaignId, Long targetListId) {

    CriterionTargetList targetList = new CriterionTargetList();
    targetList.setTargetListId(targetListId);

    CampaignRetargetingList operand = new CampaignRetargetingList();
    operand.setCampaignId(campaignId);
    operand.setCriterionTargetList(targetList);
    operand.setExcludedType(ExcludedType.INCLUDED);
    operand.setBidMultiplier(1.00);

    return operand;
  }

  /**
   * example EXCLUDED CampaignRetargetingList request.
   *
   * @param campaignId Long
   * @param targetListId Long
   * @return CampaignRetargetingList
   */
  public static CampaignRetargetingList createExampleExcludedCampaignRetargetingList(Long campaignId, Long targetListId) {

    CriterionTargetList targetList = new CriterionTargetList();
    targetList.setTargetListId(targetListId);

    CampaignRetargetingList operand = new CampaignRetargetingList();
    operand.setCampaignId(campaignId);
    operand.setCriterionTargetList(targetList);
    operand.setExcludedType(ExcludedType.EXCLUDED);

    return operand;
  }

  /**
   * example campaignRetargetingList set request.
   *
   * @param campaignRetargetingLists
   * @return CampaignRetargetingList
   */
  public static List<CampaignRetargetingList> createExampleSetRequest(List<CampaignRetargetingList> campaignRetargetingLists) {

    // create operands
    List<CampaignRetargetingList> operands = new ArrayList<>();

    for (CampaignRetargetingList campaignRetargetingList : campaignRetargetingLists) {

      if (campaignRetargetingList.getExcludedType().equals(ExcludedType.INCLUDED)) {
        CriterionTargetList targetList = new CriterionTargetList();
        targetList.setTargetListId(campaignRetargetingList.getCriterionTargetList().getTargetListId());

        CampaignRetargetingList operand = new CampaignRetargetingList();
        operand.setCampaignId(campaignRetargetingList.getCampaignId());
        operand.setCriterionTargetList(targetList);
        operand.setBidMultiplier(10.00);
        operands.add(operand);
      }
    }
    return operands;
  }

  /**
   * check & create upper service object.
   *
   * @return ValuesHolder
   * @throws Exception
   */
  private static ValuesHolder setup() throws Exception {

    ValuesHolder retargetingListValuesHolder = RetargetingListServiceSample.create();
    ValuesHolder campaignValuesHolder = CampaignServiceSample.create();

    ValuesHolder selfValuesHolder = new ValuesHolder();
    selfValuesHolder.setRetargetingListValuesList(retargetingListValuesHolder.getRetargetingListValuesList());
    selfValuesHolder.setBiddingStrategyValuesList(campaignValuesHolder.getBiddingStrategyValuesList());
    selfValuesHolder.setFeedFolderValuesList(campaignValuesHolder.getFeedFolderValuesList());
    selfValuesHolder.setCampaignValuesList(campaignValuesHolder.getCampaignValuesList());

    return selfValuesHolder;
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

}
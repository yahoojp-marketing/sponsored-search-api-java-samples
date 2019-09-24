/**
 * Copyright (C) 2019 Yahoo Japan Corporation. All Rights Reserved.
 */
package jp.yahooapis.ss.adapisample.basic.adgroupretargetinglist;

import jp.yahooapis.ss.adapisample.basic.adgroup.AdGroupServiceSample;
import jp.yahooapis.ss.adapisample.basic.retargetinglist.RetargetingListServiceSample;
import jp.yahooapis.ss.adapisample.repository.ValuesRepositoryFacade;
import jp.yahooapis.ss.adapisample.util.SoapUtils;
import jp.yahooapis.ss.adapisample.util.ValuesHolder;
import jp.yahooapis.ss.v201909.Error;
import jp.yahooapis.ss.v201909.Paging;
import jp.yahooapis.ss.v201909.adgroupretargetinglist.AdGroupRetargetingList;
import jp.yahooapis.ss.v201909.adgroupretargetinglist.AdGroupRetargetingListOperation;
import jp.yahooapis.ss.v201909.adgroupretargetinglist.AdGroupRetargetingListPage;
import jp.yahooapis.ss.v201909.adgroupretargetinglist.AdGroupRetargetingListReturnValue;
import jp.yahooapis.ss.v201909.adgroupretargetinglist.AdGroupRetargetingListSelector;
import jp.yahooapis.ss.v201909.adgroupretargetinglist.AdGroupRetargetingListService;
import jp.yahooapis.ss.v201909.adgroupretargetinglist.AdGroupRetargetingListServiceInterface;
import jp.yahooapis.ss.v201909.adgroupretargetinglist.AdGroupRetargetingListValues;
import jp.yahooapis.ss.v201909.adgroupretargetinglist.CriterionTargetList;
import jp.yahooapis.ss.v201909.adgroupretargetinglist.ExcludedType;
import jp.yahooapis.ss.v201909.adgroupretargetinglist.Operator;
import jp.yahooapis.ss.v201909.campaign.CampaignType;
import jp.yahooapis.ss.v201909.retargetinglist.TargetListType;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.xml.ws.Holder;

/**
 * example AdGroupRetargetingListService operation and Utility method collection.
 */
public class AdGroupRetargetingListServiceSample {

  /**
   * main method for AdGroupRetargetingListServiceSample
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
      Long adGroupIdStandard = valuesRepositoryFacade.getAdGroupValuesRepository().findAdGroupId(campaignIdStandard);
      Long adGroupIdMobileApp = valuesRepositoryFacade.getAdGroupValuesRepository().findAdGroupId(campaignIdMobileApp);

      // =================================================================
      // AdGroupRetargetingListServiceService ADD
      // =================================================================
      // create request.
      AdGroupRetargetingListOperation addRequest = buildExampleMutateRequest(Operator.ADD, accountId, new ArrayList<AdGroupRetargetingList>() {{
        add(createExampleIncludedAdGroupRetargetingList(campaignIdStandard, adGroupIdStandard, targetListId));
        add(createExampleExcludedAdGroupRetargetingList(campaignIdMobileApp, adGroupIdMobileApp, targetListId));
      }});

      // run
      List<AdGroupRetargetingListValues> addResponse = mutate(addRequest);
      List<AdGroupRetargetingList> adGroupRetargetingLists = new ArrayList<>();
      for (AdGroupRetargetingListValues values : addResponse) {
        adGroupRetargetingLists.add(values.getAdGroupRetargetingList());
      }

      // =================================================================
      // AdGroupRetargetingListServiceService SET
      // =================================================================
      // create request.
      AdGroupRetargetingListOperation setRequest = buildExampleMutateRequest(Operator.SET, accountId, createExampleSetRequest(adGroupRetargetingLists));

      // run
      mutate(setRequest);

      // =================================================================
      // AdGroupRetargetingListServiceService GET
      // =================================================================
      // create request.
      AdGroupRetargetingListSelector getRequest = buildExampleGetRequest(accountId, Arrays.asList(campaignIdStandard, campaignIdMobileApp), Arrays.asList(adGroupIdStandard, adGroupIdMobileApp), Arrays.asList(targetListId));

      // run
      get(getRequest);

      // =================================================================
      // AdGroupRetargetingListServiceService REMOVE
      // =================================================================
      // create request.
      AdGroupRetargetingListOperation removeRequest = buildExampleMutateRequest(Operator.REMOVE, accountId, adGroupRetargetingLists);

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
   * example mutate adGroupRetargetingList.
   *
   * @param operation AdGroupRetargetingListOperation
   * @return AdGroupRetargetingListValues
   */
  public static List<AdGroupRetargetingListValues> mutate(AdGroupRetargetingListOperation operation) throws Exception {
    // Call API
    System.out.println("############################################");
    System.out.println("AdGroupRetargetingListService::mutate(" + operation.getOperator() + ")");
    System.out.println("############################################");

    Holder<AdGroupRetargetingListReturnValue> adGroupRetargetingListReturnValueHolder = new Holder<AdGroupRetargetingListReturnValue>();
    Holder<List<Error>> errorHolder = new Holder<List<Error>>();
    AdGroupRetargetingListServiceInterface adGroupRetargetingListService = SoapUtils.createServiceInterface(AdGroupRetargetingListServiceInterface.class, AdGroupRetargetingListService.class);
    adGroupRetargetingListService.mutate(operation, adGroupRetargetingListReturnValueHolder, errorHolder);

    SoapUtils.checkSoapError(errorHolder, adGroupRetargetingListReturnValueHolder.value.getValues());

    // Response
    return adGroupRetargetingListReturnValueHolder.value.getValues();
  }

  /**
   * Sample Program for AdGroupRetargetingListService GET.
   *
   * @param selector AdGroupRetargetingListSelector
   * @return AdGroupRetargetingListValues
   * @throws Exception
   */
  public static List<AdGroupRetargetingListValues> get(AdGroupRetargetingListSelector selector) throws Exception {

    // Call API
    System.out.println("############################################");
    System.out.println("AdGroupRetargetingListService::get");
    System.out.println("############################################");

    Holder<AdGroupRetargetingListPage> adGroupRetargetingListPage = new Holder<AdGroupRetargetingListPage>();
    Holder<List<Error>> errorHolder = new Holder<List<Error>>();
    AdGroupRetargetingListServiceInterface adGroupRetargetingListService = SoapUtils.createServiceInterface(AdGroupRetargetingListServiceInterface.class, AdGroupRetargetingListService.class);
    adGroupRetargetingListService.get(selector, adGroupRetargetingListPage, errorHolder);

    SoapUtils.checkSoapError(errorHolder, adGroupRetargetingListPage.value.getValues());

    // Response
    return adGroupRetargetingListPage.value.getValues();
  }

  /**
   * example mutate request.
   */
  public static AdGroupRetargetingListOperation buildExampleMutateRequest(Operator operator, long accountId, List<AdGroupRetargetingList> operand) {
    AdGroupRetargetingListOperation operation = new AdGroupRetargetingListOperation();
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
   * @param adGroupIds
   * @param targetListIds
   * @return AdGroupRetargetingListSelector
   */
  public static AdGroupRetargetingListSelector buildExampleGetRequest(long accountId, List<Long> campaignIds, List<Long> adGroupIds, List<Long> targetListIds) {

    // Set Selector
    AdGroupRetargetingListSelector selector = new AdGroupRetargetingListSelector();
    selector.setAccountId(accountId);

    if (campaignIds.size() > 0) {
      selector.getCampaignIds().addAll(campaignIds);
    }
    if (adGroupIds.size() > 0) {
      selector.getAdGroupIds().addAll(adGroupIds);
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
   * example INCLUDED AdGroupRetargetingList request.
   *
   * @param campaignId Long
   * @param adGroupId Long
   * @param targetListId Long
   * @return AdGroupRetargetingList
   */
  public static AdGroupRetargetingList createExampleIncludedAdGroupRetargetingList(Long campaignId, Long adGroupId, Long targetListId) {

    CriterionTargetList targetList = new CriterionTargetList();
    targetList.setTargetListId(targetListId);

    AdGroupRetargetingList operand = new AdGroupRetargetingList();
    operand.setCampaignId(campaignId);
    operand.setAdGroupId(adGroupId);
    operand.setCriterionTargetList(targetList);
    operand.setExcludedType(ExcludedType.INCLUDED);
    operand.setBidMultiplier(1.00);

    return operand;
  }

  /**
   * example EXCLUDED AdGroupRetargetingList request.
   *
   * @param campaignId Long
   * @param adGroupId Long
   * @param targetListId Long
   * @return AdGroupRetargetingList
   */
  public static AdGroupRetargetingList createExampleExcludedAdGroupRetargetingList(Long campaignId, Long adGroupId, Long targetListId) {

    CriterionTargetList targetList = new CriterionTargetList();
    targetList.setTargetListId(targetListId);

    AdGroupRetargetingList operand = new AdGroupRetargetingList();
    operand.setCampaignId(campaignId);
    operand.setAdGroupId(adGroupId);
    operand.setCriterionTargetList(targetList);
    operand.setExcludedType(ExcludedType.EXCLUDED);

    return operand;
  }

  /**
   * example adGroupRetargetingList set request.
   *
   * @param adGroupRetargetingLists
   * @return AdGroupRetargetingList
   */
  public static List<AdGroupRetargetingList> createExampleSetRequest(List<AdGroupRetargetingList> adGroupRetargetingLists) {

    // create operands
    List<AdGroupRetargetingList> operands = new ArrayList<>();

    for (AdGroupRetargetingList adGroupRetargetingList : adGroupRetargetingLists) {

      if (adGroupRetargetingList.getExcludedType().equals(ExcludedType.INCLUDED)) {
        CriterionTargetList targetList = new CriterionTargetList();
        targetList.setTargetListId(adGroupRetargetingList.getCriterionTargetList().getTargetListId());

        AdGroupRetargetingList operand = new AdGroupRetargetingList();
        operand.setCampaignId(adGroupRetargetingList.getCampaignId());
        operand.setAdGroupId(adGroupRetargetingList.getAdGroupId());
        operand.setCriterionTargetList(targetList);
        operand.setBidMultiplier(10.00);
        operands.add(operand);
      }
    }
    return operands;
  }

  /**
   * check & vreate upper service object.
   *
   * @return
   * @throws Exception
   */
  private static ValuesHolder setup() throws Exception {

    ValuesHolder retargetingListValuesHolder = RetargetingListServiceSample.create();
    ValuesHolder adGroupValuesHolder = AdGroupServiceSample.create();

    ValuesHolder selfValuesHolder = new ValuesHolder();
    selfValuesHolder.setRetargetingListValuesList(retargetingListValuesHolder.getRetargetingListValuesList());
    selfValuesHolder.setBiddingStrategyValuesList(adGroupValuesHolder.getBiddingStrategyValuesList());
    selfValuesHolder.setFeedFolderValuesList(adGroupValuesHolder.getFeedFolderValuesList());
    selfValuesHolder.setCampaignValuesList(adGroupValuesHolder.getCampaignValuesList());
    selfValuesHolder.setAdGroupValuesList(adGroupValuesHolder.getAdGroupValuesList());

    return selfValuesHolder;
  }

  /**
   * cleanup service object.
   *
   * @param valuesHolder
   * @throws Exception
   */
  public static void cleanup(ValuesHolder valuesHolder) throws Exception {
    AdGroupServiceSample.cleanup(valuesHolder);
  }

}
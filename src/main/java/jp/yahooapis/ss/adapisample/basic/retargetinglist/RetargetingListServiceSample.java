/**
 * Copyright (C) 2019 Yahoo Japan Corporation. All Rights Reserved.
 */
package jp.yahooapis.ss.adapisample.basic.retargetinglist;

import jp.yahooapis.ss.adapisample.repository.ValuesRepositoryFacade;
import jp.yahooapis.ss.adapisample.util.SoapUtils;
import jp.yahooapis.ss.adapisample.util.ValuesHolder;
import jp.yahooapis.ss.v201901.Error;
import jp.yahooapis.ss.v201901.Paging;
import jp.yahooapis.ss.v201901.retargetinglist.CustomKey;
import jp.yahooapis.ss.v201901.retargetinglist.CustomKeyRuleItem;
import jp.yahooapis.ss.v201901.retargetinglist.DefaultTargetList;
import jp.yahooapis.ss.v201901.retargetinglist.GetCustomKeySelector;
import jp.yahooapis.ss.v201901.retargetinglist.IsAllVisitorRule;
import jp.yahooapis.ss.v201901.retargetinglist.IsDateSpecificRule;
import jp.yahooapis.ss.v201901.retargetinglist.LogicalCondition;
import jp.yahooapis.ss.v201901.retargetinglist.LogicalGroup;
import jp.yahooapis.ss.v201901.retargetinglist.LogicalRuleOperand;
import jp.yahooapis.ss.v201901.retargetinglist.LogicalTargetList;
import jp.yahooapis.ss.v201901.retargetinglist.Operator;
import jp.yahooapis.ss.v201901.retargetinglist.ReachStorageStatus;
import jp.yahooapis.ss.v201901.retargetinglist.RetargetingListCustomKeyPage;
import jp.yahooapis.ss.v201901.retargetinglist.RetargetingListOperation;
import jp.yahooapis.ss.v201901.retargetinglist.RetargetingListPage;
import jp.yahooapis.ss.v201901.retargetinglist.RetargetingListReturnValue;
import jp.yahooapis.ss.v201901.retargetinglist.RetargetingListSelector;
import jp.yahooapis.ss.v201901.retargetinglist.RetargetingListService;
import jp.yahooapis.ss.v201901.retargetinglist.RetargetingListServiceInterface;
import jp.yahooapis.ss.v201901.retargetinglist.RetargetingListValues;
import jp.yahooapis.ss.v201901.retargetinglist.RuleBaseTargetList;
import jp.yahooapis.ss.v201901.retargetinglist.RuleGroup;
import jp.yahooapis.ss.v201901.retargetinglist.RuleOperator;
import jp.yahooapis.ss.v201901.retargetinglist.RuleType;
import jp.yahooapis.ss.v201901.retargetinglist.TargetListType;
import jp.yahooapis.ss.v201901.retargetinglist.TargetingList;
import jp.yahooapis.ss.v201901.retargetinglist.UrlRuleItem;
import jp.yahooapis.ss.v201901.retargetinglist.UrlRuleKey;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collections;
import java.util.List;

import javax.xml.ws.Holder;

/**
 * example RetargetingListService operation and Utility method collection.
 */
public class RetargetingListServiceSample {

  /**
   * example RetargetingListService operation.
   *
   * @param args command line arguments
   * @throws Exception
   */
  public static void main(String[] args) throws Exception {

    // =================================================================
    // Setup
    // =================================================================
    ValuesHolder valuesHolder = new ValuesHolder();
    long accountId = SoapUtils.getAccountId();

    try {

      // =================================================================
      // check & create upper service object.
      // =================================================================
      ValuesRepositoryFacade valuesRepositoryFacade = new ValuesRepositoryFacade(valuesHolder);

      // get DefaultTargetList
      RetargetingListSelector defaultTargetListSelector = buildExampleGetRequest(accountId, Arrays.asList());
      defaultTargetListSelector.getTargetListTypes().clear();
      defaultTargetListSelector.getTargetListTypes().add(TargetListType.DEFAULT);
      List<RetargetingListValues> retargetingListValuesList = get(defaultTargetListSelector);
      valuesHolder.setRetargetingListValuesList(retargetingListValuesList);
      Long defaultTargetListId = valuesRepositoryFacade.getRetargetingListValuesRepository().findTargetListId(TargetListType.DEFAULT);

      // =================================================================
      // RetargetingListService GetCustomKey
      // =================================================================
      // create request.
      GetCustomKeySelector getCustomKeySelector = buildExampleGetCustomKeyRequest(accountId);

      // run
      CustomKey customKey = getCustomKey(getCustomKeySelector);

      List<String> textKeys = customKey.getTextKey();

      // =================================================================
      // RetargetingListService ADD(RuleBaseTargetList)
      // =================================================================
      // create request.
      RetargetingListOperation addOperationRuleBaseTargetList = buildExampleMutateRequest( //
          Operator.ADD, //
          accountId, //
          Arrays.asList( //
              createExampleRuleBaseTargetListUrlRuleItem(accountId), //
              createExampleRuleBaseTargetListCustomKeyRuleItem(accountId, textKeys) //
          ) //
      );

      // run
      List<RetargetingListValues> addRetargetingListValuesListRuleBase = mutate(addOperationRuleBaseTargetList);

      valuesHolder.setRetargetingListValuesList(addRetargetingListValuesListRuleBase);
      List<Long> targetListIds = valuesRepositoryFacade.getRetargetingListValuesRepository().getTargetListIds();
      List<Long> ruleBaseTargetListIds = new ArrayList<>();
      for (Long targetListId : targetListIds) {
        if (!targetListId.equals(defaultTargetListId)) {
          ruleBaseTargetListIds.add(targetListId);
        }
      }


      // =================================================================
      // RetargetingListService ADD(LogicalTargetList)
      // =================================================================
      // create request.
      RetargetingListOperation addOperationLogicalTargetList = buildExampleMutateRequest( //
          Operator.ADD, //
          accountId, //
          Arrays.asList(createExampleLogicalTargetList(accountId, defaultTargetListId, ruleBaseTargetListIds)) //
      );

      // run
      List<RetargetingListValues> addRetargetingListValuesListLogical = mutate(addOperationLogicalTargetList);
      valuesHolder.setRetargetingListValuesList(addRetargetingListValuesListLogical);
      targetListIds = valuesRepositoryFacade.getRetargetingListValuesRepository().getTargetListIds();


      // =================================================================
      // RetargetingListService GET
      // =================================================================
      // create request.
      RetargetingListSelector selector = buildExampleGetRequest(accountId, targetListIds);

      // run
      get(selector);

      // =================================================================
      // RetargetingListService SET
      // =================================================================
      // create request.
      RetargetingListOperation setOperation = buildExampleMutateRequest( //
          Operator.SET, //
          accountId, //
          createExampleSetRequest(valuesRepositoryFacade.getRetargetingListValuesRepository().getTargetLists()) //
      );

      // run
      mutate(setOperation);

    } catch (Exception e) {
      e.printStackTrace();
      throw e;
    }
  }

  /**
   * example targetLists set request.
   *
   * @param targetLists List<TargetingList>
   * @return List<TargetingList>
   */
  public static List<TargetingList> createExampleSetRequest(List<TargetingList> targetLists) {

    List<TargetingList> operands = new ArrayList<>();
    for (TargetingList targetingList : targetLists) {
      switch (targetingList.getTargetListType()) {
        default:
          break;
        // DefaultTargetList
        case DEFAULT:
          DefaultTargetList setDefaultTargetList = new DefaultTargetList();
          setDefaultTargetList.setAccountId(targetingList.getAccountId());
          setDefaultTargetList.setTargetListType(targetingList.getTargetListType());
          setDefaultTargetList.setTargetListId(targetingList.getTargetListId());
          setDefaultTargetList.setTargetListName("SampleDefaultTargetList_UpdateOn_" + targetingList.getTargetListId() + "_" + SoapUtils.getCurrentTimestamp());
          setDefaultTargetList.setTargetListDescription("SampleDefaultTargetList_Update");
          operands.add(setDefaultTargetList);
          break;

        // RuleBaseTargetList
        case RULE:
          RuleBaseTargetList setRuleBaseTargetList = new RuleBaseTargetList();
          setRuleBaseTargetList.setAccountId(targetingList.getAccountId());
          setRuleBaseTargetList.setTargetListType(targetingList.getTargetListType());
          setRuleBaseTargetList.setTargetListId(targetingList.getTargetListId());
          setRuleBaseTargetList.setTargetListName("SampleRuleBaseTargetList_UpdateOn_" + targetingList.getTargetListId() + "_" + SoapUtils.getCurrentTimestamp());
          setRuleBaseTargetList.setTargetListDescription("SampleRuleBaseTargetList_Update");
          setRuleBaseTargetList.setReachStorageStatus(ReachStorageStatus.CLOSED);
          setRuleBaseTargetList.setReachStorageSpan(Long.valueOf(100));
          setRuleBaseTargetList.setIsDateSpecific(IsDateSpecificRule.FALSE);
          setRuleBaseTargetList.setIsAllVisitor(IsAllVisitorRule.TRUE);
          operands.add(setRuleBaseTargetList);
          break;

        // LogicalTargetList
        case LOGICAL:
          LogicalTargetList logicalTargetList = (LogicalTargetList) targetingList;
          LogicalTargetList setLogicalTargetList = new LogicalTargetList();
          setLogicalTargetList.setAccountId(logicalTargetList.getAccountId());
          setLogicalTargetList.setTargetListType(logicalTargetList.getTargetListType());
          setLogicalTargetList.setTargetListId(logicalTargetList.getTargetListId());
          setLogicalTargetList.getLogicalGroup().addAll(logicalTargetList.getLogicalGroup());
          setLogicalTargetList.setTargetListName("SampleLogicalTargetList_UpdateOn_" + targetingList.getTargetListId() + "_" + SoapUtils.getCurrentTimestamp());
          setLogicalTargetList.setTargetListDescription("SampleLogicalTargetList_Update");
          operands.add(setLogicalTargetList);
          break;
      }
    }
    return operands;
  }

  /**
   * example Logical TargetList request.
   *
   * @param accountId long
   * @param defaultTargetListId Long
   * @param ruleBaseTargetListIds List<Long>
   * @return LogicalTargetList
   */
  public static LogicalTargetList createExampleLogicalTargetList(long accountId, Long defaultTargetListId, List<Long> ruleBaseTargetListIds) {
    // default
    LogicalGroup defaultLogicalGroup = new LogicalGroup();
    LogicalRuleOperand logicalRuleOperand = new LogicalRuleOperand();
    logicalRuleOperand.setTargetListId(defaultTargetListId);
    defaultLogicalGroup.getLogicalOperand().add(logicalRuleOperand);
    defaultLogicalGroup.setCondition(LogicalCondition.NOT);

    // rule
    LogicalGroup ruleLogicalGroup = new LogicalGroup();
    for (Long ruleBaseTargetListId : ruleBaseTargetListIds) {
      LogicalRuleOperand operand = new LogicalRuleOperand();
      operand.setTargetListId(ruleBaseTargetListId);
      ruleLogicalGroup.getLogicalOperand().add(operand);
    }
    ruleLogicalGroup.setCondition(LogicalCondition.OR);

    LogicalTargetList operand = new LogicalTargetList();
    operand.setAccountId(accountId);
    operand.setTargetListId(defaultTargetListId);
    operand.setTargetListType(TargetListType.LOGICAL);
    operand.getLogicalGroup().add(defaultLogicalGroup);
    operand.getLogicalGroup().add(ruleLogicalGroup);
    operand.setTargetListName("SampleLogicalTargetList_CreateOn_" + SoapUtils.getCurrentTimestamp());
    operand.setTargetListDescription("SampleLogicalTargetList");
    return operand;
  }

  /**
   * example mutate request.
   *
   * @param operator Operator
   * @param accountId long
   * @param ruleBaseTargetLists List<TargetingList>
   * @return RetargetingListOperation
   */
  public static RetargetingListOperation buildExampleMutateRequest(Operator operator, long accountId, List<TargetingList> ruleBaseTargetLists) {
    RetargetingListOperation operation = new RetargetingListOperation();
    operation.setAccountId(accountId);
    operation.setOperator(operator);
    operation.getOperand().addAll(ruleBaseTargetLists);
    return operation;
  }

  /**
   * example RuleBase TargetList (CustomKeyRuleItem) request.
   *
   * @param accountId long
   * @param textKeys List<String>
   * @return RuleBaseTargetList
   */
  public static RuleBaseTargetList createExampleRuleBaseTargetListCustomKeyRuleItem(long accountId, List<String> textKeys) {
    RuleBaseTargetList operand = new RuleBaseTargetList();
    operand.setAccountId(accountId);
    operand.setTargetListType(TargetListType.RULE);
    operand.setIsAllVisitor(IsAllVisitorRule.FALSE);
    operand.setTargetListName("SampleRuleBaseTargetList_CreateOn_CustomKeyRule_" + SoapUtils.getCurrentTimestamp());
    operand.setTargetListDescription("SampleRuleBaseTargetList");
    operand.setReachStorageStatus(ReachStorageStatus.OPEN);
    operand.setReachStorageSpan(180L);
    operand.setIsDateSpecific(IsDateSpecificRule.TRUE);
    SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
    Calendar calendar = Calendar.getInstance();
    calendar.getTime();
    operand.setStartDate(format.format(calendar.getTime()));
    calendar.add(Calendar.MONTH, 1);
    operand.setEndDate(format.format(calendar.getTime()));

    RuleGroup ruleGroup = new RuleGroup();
    for (String text : textKeys) {
      CustomKeyRuleItem customKeyRuleItem = new CustomKeyRuleItem();
      customKeyRuleItem.setRuleType(RuleType.CUSTOM_KEY_RULE);
      customKeyRuleItem.setOperator(RuleOperator.EQUALS);
      customKeyRuleItem.setValue(text + "_sample");
      customKeyRuleItem.setTextKey(text);
      ruleGroup.getRuleItems().add(customKeyRuleItem);
    }

    operand.getRules().add(ruleGroup);
    return operand;
  }

  /**
   * example RuleBase TargetList (UrlRuleItem) request.
   *
   * @param accountId long
   * @return RuleBaseTargetList
   */
  public static RuleBaseTargetList createExampleRuleBaseTargetListUrlRuleItem(long accountId) {
    RuleBaseTargetList operand = new RuleBaseTargetList();
    operand.setAccountId(accountId);
    operand.setTargetListType(TargetListType.RULE);
    operand.setIsAllVisitor(IsAllVisitorRule.TRUE);
    operand.setTargetListName("SampleRuleBaseTargetList_CreateOn_UrlRule_" + SoapUtils.getCurrentTimestamp());
    operand.setTargetListDescription("SampleRuleBaseTargetList");
    operand.setReachStorageStatus(ReachStorageStatus.OPEN);
    operand.setReachStorageSpan(180L);
    operand.setIsDateSpecific(IsDateSpecificRule.TRUE);
    SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
    Calendar calendar = Calendar.getInstance();
    calendar.getTime();
    operand.setStartDate(format.format(calendar.getTime()));
    calendar.add(Calendar.MONTH, 1);
    operand.setEndDate(format.format(calendar.getTime()));

    UrlRuleItem urlRuleItem1 = new UrlRuleItem();
    urlRuleItem1.setRuleType(RuleType.URL_RULE);
    urlRuleItem1.setOperator(RuleOperator.CONTAINS);
    urlRuleItem1.setValue("yahoo.co.jp");
    urlRuleItem1.setUrlKey(UrlRuleKey.REFFER_URL);
    UrlRuleItem urlRuleItem2 = new UrlRuleItem();
    urlRuleItem2.setRuleType(RuleType.URL_RULE);
    urlRuleItem2.setOperator(RuleOperator.EQUALS);
    urlRuleItem2.setValue("http://promotionalads.yahoo.co.jp/");
    urlRuleItem2.setUrlKey(UrlRuleKey.URL);
    RuleGroup ruleGroup = new RuleGroup();
    ruleGroup.getRuleItems().add(urlRuleItem1);
    ruleGroup.getRuleItems().add(urlRuleItem2);

    operand.getRules().add(ruleGroup);
    return operand;
  }

  /**
   * example getCustomKeys.
   *
   * @param selector GetCustomKeySelector
   * @return CustomKey
   * @throws Exception
   */
  public static CustomKey getCustomKey(GetCustomKeySelector selector) throws Exception {
    // call API
    System.out.println("############################################");
    System.out.println("RetargetingListService::getCustomKey");
    System.out.println("############################################");

    Holder<RetargetingListCustomKeyPage> retargetingListPageHolder = new Holder<>();
    Holder<List<Error>> errorHolder = new Holder<List<Error>>();
    RetargetingListServiceInterface retargetingListService = SoapUtils.createServiceInterface(RetargetingListServiceInterface.class, RetargetingListService.class);
    retargetingListService.getCustomKey(selector, retargetingListPageHolder, errorHolder);

    SoapUtils.checkSoapError(errorHolder);
    if (retargetingListPageHolder.value.getCustomKeys() == null) {
      throw new Exception("NoDataResponse");
    }

    // Response
    return retargetingListPageHolder.value.getCustomKeys();
  }

  /**
   * example get request.
   *
   * @param accountId long
   * @return GetCustomKeySelector
   */
  public static GetCustomKeySelector buildExampleGetCustomKeyRequest(long accountId) {
    GetCustomKeySelector selector = new GetCustomKeySelector();
    selector.setAccountId(accountId);
    return selector;
  }

  /**
   * example get request.
   *
   * @param accountId long
   * @param targetListIds List<Long>
   * @return RetargetingListSelector
   */
  public static RetargetingListSelector buildExampleGetRequest(long accountId, List<Long> targetListIds) {
    RetargetingListSelector selector = new RetargetingListSelector();
    selector.getTargetListIds().addAll(targetListIds);
    selector.getTargetListTypes().addAll(Arrays.asList(TargetListType.DEFAULT, TargetListType.RULE, TargetListType.LOGICAL));
    Paging paging = new Paging();
    paging.setStartIndex(1);
    paging.setNumberResults(20);
    selector.setAccountId(accountId);
    selector.setPaging(paging);
    return selector;
  }

  /**
   * create basic retargeting lists.
   *
   * @return ValuesHolder
   * @throws Exception
   */
  public static ValuesHolder create() throws Exception {
    long accountId = SoapUtils.getAccountId();
    ValuesHolder valuesHolder = new ValuesHolder();
    RetargetingListSelector selector = buildExampleGetRequest(accountId, Collections.emptyList());
    selector.getTargetListTypes().clear();
    selector.getTargetListTypes().addAll(Collections.singletonList(TargetListType.DEFAULT));
    List<RetargetingListValues> getResponse = get(selector);
    valuesHolder.setRetargetingListValuesList(getResponse);
    return valuesHolder;
  }

  /**
   * example mutate retargeting lists.
   *
   * @param operation RetargetingListOperation
   * @return List<RetargetingListValues>
   * @throws Exception
   */
  public static List<RetargetingListValues> mutate(RetargetingListOperation operation) throws Exception {

    // call API
    System.out.println("############################################");
    System.out.println("RetargetingListService::mutate(" + operation.getOperator() + ")");
    System.out.println("############################################");

    Holder<RetargetingListReturnValue> retargetingListReturnValueHolder = new Holder<RetargetingListReturnValue>();
    Holder<List<Error>> errorHolder = new Holder<List<Error>>();
    RetargetingListServiceInterface retargetingListService = SoapUtils.createServiceInterface(RetargetingListServiceInterface.class, RetargetingListService.class);
    retargetingListService.mutate(operation, retargetingListReturnValueHolder, errorHolder);

    SoapUtils.checkSoapError(errorHolder, retargetingListReturnValueHolder.value.getValues());

    // Response
    return retargetingListReturnValueHolder.value.getValues();
  }

  /**
   * example get retargeting lists.
   *
   * @param selector RetargetingListSelector
   * @return List<RetargetingListValues>
   * @throws Exception
   */
  public static List<RetargetingListValues> get(RetargetingListSelector selector) throws Exception {

    // call API
    System.out.println("############################################");
    System.out.println("RetargetingListService::get");
    System.out.println("############################################");

    Holder<RetargetingListPage> retargetingListPageHolder = new Holder<>();
    Holder<List<Error>> errorHolder = new Holder<List<Error>>();
    RetargetingListServiceInterface retargetingListService = SoapUtils.createServiceInterface(RetargetingListServiceInterface.class, RetargetingListService.class);
    retargetingListService.get(selector, retargetingListPageHolder, errorHolder);

    SoapUtils.checkSoapError(errorHolder, retargetingListPageHolder.value.getValues());

    // Response
    return retargetingListPageHolder.value.getValues();
  }
}
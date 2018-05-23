package jp.co.yahoo.ad_api_sample.siteRetargetingSample;

import jp.co.yahoo.ad_api_sample.error.impl.RetargetingListServiceErrorEntityFactory;
import jp.co.yahoo.ad_api_sample.util.SoapUtils;
import jp.yahooapis.ss.v201805.retargetinglist.DefaultTargetList;
import jp.yahooapis.ss.v201805.Error;
import jp.yahooapis.ss.v201805.retargetinglist.IsAllVisitorRule;
import jp.yahooapis.ss.v201805.retargetinglist.IsDateSpecificRule;
import jp.yahooapis.ss.v201805.retargetinglist.LogicalCondition;
import jp.yahooapis.ss.v201805.retargetinglist.LogicalGroup;
import jp.yahooapis.ss.v201805.retargetinglist.LogicalRuleOperand;
import jp.yahooapis.ss.v201805.retargetinglist.LogicalTargetList;
import jp.yahooapis.ss.v201805.retargetinglist.Operator;
import jp.yahooapis.ss.v201805.Paging;
import jp.yahooapis.ss.v201805.retargetinglist.ReachStorageStatus;
import jp.yahooapis.ss.v201805.retargetinglist.RetargetingListOperation;
import jp.yahooapis.ss.v201805.retargetinglist.RetargetingListPage;
import jp.yahooapis.ss.v201805.retargetinglist.RetargetingListReturnValue;
import jp.yahooapis.ss.v201805.retargetinglist.RetargetingListSelector;
import jp.yahooapis.ss.v201805.retargetinglist.RetargetingListService;
import jp.yahooapis.ss.v201805.retargetinglist.RetargetingListServiceInterface;
import jp.yahooapis.ss.v201805.retargetinglist.RetargetingListValues;
import jp.yahooapis.ss.v201805.retargetinglist.RuleBaseTargetList;
import jp.yahooapis.ss.v201805.retargetinglist.RuleGroup;
import jp.yahooapis.ss.v201805.retargetinglist.RuleItem;
import jp.yahooapis.ss.v201805.retargetinglist.RuleOperator;
import jp.yahooapis.ss.v201805.retargetinglist.RuleType;
import jp.yahooapis.ss.v201805.retargetinglist.TargetListOwner;
import jp.yahooapis.ss.v201805.retargetinglist.TargetListType;
import jp.yahooapis.ss.v201805.retargetinglist.TargetingList;
import jp.yahooapis.ss.v201805.retargetinglist.UrlRuleItem;
import jp.yahooapis.ss.v201805.retargetinglist.UrlRuleKey;

import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import javax.xml.ws.Holder;

/**
 * Sample Program for RetargetingListService. Copyright (C) 2012 Yahoo Japan Corporation. All
 * Rights Reserved.
 */
public class RetargetingListServiceSample {

  /**
   * main method for RetargetingListServiceSample
   *
   * @param args command line arguments
   */
  public static void main(String[] args) throws Exception {
    try {
      // =================================================================
      // Setting
      // =================================================================
      long accountId = SoapUtils.getAccountId();

      // =================================================================
      // RetargetingListService::mutate(ADD)
      // =================================================================
      // - DefaultTargetList
      // Set Operation
      RetargetingListOperation addOperation1 = createSampleAddRequestOfDefault(accountId);

      // Run
      List<RetargetingListValues> addResponse = add(addOperation1);

      // - RuleBaseTargetList
      // Set Operation
      RetargetingListOperation addOperation2 = createSampleAddRequestOfRuleBase(accountId);

      // Run
      addResponse.addAll(add(addOperation2));

      // - LogicalTargetList
      // Set Operation
      RetargetingListOperation addOperation3 = createSampleAddRequestOfLogical(accountId, addResponse);

      // Run
      addResponse.addAll(add(addOperation3));


      // =================================================================
      // RetargetingListService::get
      // =================================================================
      // Set Selector
      RetargetingListSelector selector = createSampleGetRequest(accountId, addResponse);

      // Run
      List<RetargetingListValues> getResponse = get(selector);


      // =================================================================
      // RetargetingListService::mutate(SET)
      // =================================================================
      // Set Operation
      RetargetingListOperation setOperation = createSampleSetRequest(accountId, getResponse);

      // Run
      set(setOperation);

    } catch (Exception e) {
      e.printStackTrace();
      throw e;
    }
  }

  /**
   * Sample Program for RetargetingListService ADD.
   *
   * @param operation RetargetingListOperation
   * @return RetargetingListValues
   * @throws Exception
   */
  public static List<RetargetingListValues> add(RetargetingListOperation operation) throws Exception {

    // call API
    System.out.println("############################################");
    System.out.println("RetargetingListService::mutate(ADD)");
    System.out.println("############################################");

    Holder<RetargetingListReturnValue> addRetargetingListReturnValueHolder = new Holder<RetargetingListReturnValue>();
    Holder<List<Error>> addErrorArrayHolder = new Holder<List<Error>>();
    RetargetingListServiceInterface retargetingListService = SoapUtils.createServiceInterface(RetargetingListServiceInterface.class, RetargetingListService.class);
    retargetingListService.mutate(operation, addRetargetingListReturnValueHolder, addErrorArrayHolder);

    // Error
    if (addErrorArrayHolder.value != null && addErrorArrayHolder.value.size() > 0) {
      SoapUtils.displayErrors(new RetargetingListServiceErrorEntityFactory(addErrorArrayHolder.value), true);
    }
    if (addErrorArrayHolder.value == null) {
      throw new Exception("NoDataResponse:RetargetingListService mutate(ADD)");
    }

    // Display
    if (addRetargetingListReturnValueHolder.value != null) {
      if (addRetargetingListReturnValueHolder.value.getValues() != null) {
        for (RetargetingListValues values : addRetargetingListReturnValueHolder.value.getValues()) {
          if (values.isOperationSucceeded()) {
            display(values.getTargetList());
          } else {
            for (Error error : values.getError()) {
              if (!"210804".equals(error.getCode())) {
                SoapUtils.displayErrors(new RetargetingListServiceErrorEntityFactory(values.getError()), true);
              }
            }
          }
        }
      }
    }

    // Response
    return addRetargetingListReturnValueHolder.value.getValues();
  }

  /**
   * Sample Program for RetargetingListService GET.
   *
   * @param selector RetargetingListSelector
   * @return RetargetingListValues
   * @throws Exception
   */
  public static List<RetargetingListValues> get(RetargetingListSelector selector) throws Exception {

    // call API
    System.out.println("############################################");
    System.out.println("RetargetingListService::get");
    System.out.println("############################################");

    Holder<RetargetingListPage> retargetingListPageHolder = new Holder<RetargetingListPage>();
    Holder<List<Error>> getErrorArrayHolder = new Holder<List<Error>>();
    RetargetingListServiceInterface retargetingListService = SoapUtils.createServiceInterface(RetargetingListServiceInterface.class, RetargetingListService.class);
    retargetingListService.get(selector, retargetingListPageHolder, getErrorArrayHolder);

    // Error
    if (getErrorArrayHolder.value != null && getErrorArrayHolder.value.size() > 0) {
      SoapUtils.displayErrors(new RetargetingListServiceErrorEntityFactory(getErrorArrayHolder.value), true);
    }
    if (getErrorArrayHolder.value == null) {
      throw new Exception("NoDataResponse:RetargetingListService Get");
    }

    // Display
    if (retargetingListPageHolder.value != null) {
      if (retargetingListPageHolder.value.getValues() != null) {
        for (RetargetingListValues values : retargetingListPageHolder.value.getValues()) {
          if (values.isOperationSucceeded()) {
            display(values.getTargetList());
          } else {
            SoapUtils.displayErrors(new RetargetingListServiceErrorEntityFactory(values.getError()), true);
          }
        }
      }
    }

    // Response
    return retargetingListPageHolder.value.getValues();
  }

  /**
   * Sample Program for RetargetingListService SET.
   *
   * @param operation RetargetingListOperation
   * @return RetargetingListValues
   * @throws Exception
   */
  public static List<RetargetingListValues> set(RetargetingListOperation operation) throws Exception {

    // call API
    System.out.println("############################################");
    System.out.println("RetargetingListService::mutate(SET)");
    System.out.println("############################################");

    Holder<RetargetingListReturnValue> setRetargetingListReturnValueHolder = new Holder<RetargetingListReturnValue>();
    Holder<List<Error>> setErrorArrayHolder = new Holder<List<Error>>();
    RetargetingListServiceInterface retargetingListService = SoapUtils.createServiceInterface(RetargetingListServiceInterface.class, RetargetingListService.class);
    retargetingListService.mutate(operation, setRetargetingListReturnValueHolder, setErrorArrayHolder);

    // Error
    if (setErrorArrayHolder.value != null && setErrorArrayHolder.value.size() > 0) {
      SoapUtils.displayErrors(new RetargetingListServiceErrorEntityFactory(setErrorArrayHolder.value), true);
    }
    if (setErrorArrayHolder.value == null) {
      throw new Exception("NoDataResponse:RetargetingListService mutate(SET)");
    }

    // Display
    if (setRetargetingListReturnValueHolder.value != null) {
      if (setRetargetingListReturnValueHolder.value.getValues() != null) {
        for (RetargetingListValues values : setRetargetingListReturnValueHolder.value.getValues()) {
          if (values.isOperationSucceeded()) {
            display(values.getTargetList());
          } else {
            SoapUtils.displayErrors(new RetargetingListServiceErrorEntityFactory(values.getError()), true);
          }
        }
      }
    }

    // Response
    return setRetargetingListReturnValueHolder.value.getValues();
  }

  /**
   * * display TargetingList entity to stdout.
   *
   * @param targetingList TargetingList entity for display.
   */
  private static void display(TargetingList targetingList) {
    System.out.println("accountId = " + targetingList.getAccountId());
    if (targetingList.getRetargetingAccountStatus() != null) {
      System.out.println("retargetingAccountStatus/agreeDate = " + targetingList.getRetargetingAccountStatus().getAgreeDate());
      System.out.println("retargetingAccountStatus/reviewStatus = " + targetingList.getRetargetingAccountStatus().getReviewStatus());
      System.out.println("retargetingAccountStatus/reviewRequestDate = " + targetingList.getRetargetingAccountStatus().getReviewRequestDate());
    }
    System.out.println("targetListId = " + targetingList.getTargetListId());
    System.out.println("targetListType = " + targetingList.getTargetListType());
    System.out.println("targetListName = " + targetingList.getTargetListName());
    System.out.println("targetListDescription = " + targetingList.getTargetListDescription());
    System.out.println("closingReason = " + targetingList.getClosingReason());
    System.out.println("reachStorageStatus = " + targetingList.getReachStorageStatus());
    System.out.println("reachStorageSpan = " + targetingList.getReachStorageSpan());
    System.out.println("reach = " + targetingList.getReach());
    System.out.println("targetListTrackId = " + targetingList.getTargetListTrackId());

    if (targetingList instanceof DefaultTargetList) {
      // DefaultTargetList
      System.out.println("snippet = " + ((DefaultTargetList)targetingList).getTag().getSnippet());

    } else if (targetingList instanceof RuleBaseTargetList) {
      // RuleBaseTargetList
      int ruleIndex = 0;
      for (RuleGroup ruleGroup : ((RuleBaseTargetList)targetingList).getRules()) {
        int ruleItemIndex = 0;
        for (RuleItem ruleItem : ruleGroup.getRuleItems()) {
          System.out.println("rules[" + ruleIndex + "]/ruleItems[" + ruleItemIndex + "]/ruleType = " + ruleItem.getRuleType());
          System.out.println("rules[" + ruleIndex + "]/ruleItems[" + ruleItemIndex + "]/operator = " + ruleItem.getOperator());
          System.out.println("rules[" + ruleIndex + "]/ruleItems[" + ruleItemIndex + "]/value = " + ruleItem.getValue());
          ruleItemIndex++;
        }
        ruleIndex++;
      }
      System.out.println("isAllVisitor = " + ((RuleBaseTargetList)targetingList).getIsAllVisitor());
      System.out.println("isDateSpecific = " + ((RuleBaseTargetList)targetingList).getIsDateSpecific());
      System.out.println("startDate = " + ((RuleBaseTargetList)targetingList).getStartDate());
      System.out.println("endDate = " + ((RuleBaseTargetList)targetingList).getEndDate());

    } else if (targetingList instanceof LogicalTargetList) {
      // LogicalTargetList
      int logicalGroupIndex = 0;
      for (LogicalGroup logicalGroup : ((LogicalTargetList)targetingList).getLogicalGroup()) {
        System.out.println("logicalGroup[" + logicalGroupIndex + "]/condition = " + logicalGroup.getCondition());
        int logicalRuleOperandIndex = 0;
        for (LogicalRuleOperand logicalRuleOperand : logicalGroup.getLogicalOperand()) {
          System.out.println("logicalGroup[" + logicalGroupIndex + "]/logicalRuleOperand[" + logicalRuleOperandIndex + "]/targetListId = " + logicalRuleOperand.getTargetListId());
          logicalRuleOperandIndex++;
        }
        logicalGroupIndex++;
      }

    }
    System.out.println("---------");
  }

  /**
   * create sample request.
   *
   * @param accountId long
   * @return RetargetingListOperation
   */
  public static RetargetingListOperation createSampleAddRequestOfDefault(long accountId) throws Exception {
    // DefaultTargetList
    DefaultTargetList defaultTargetList = new DefaultTargetList();
    defaultTargetList.setAccountId(accountId);
    defaultTargetList.setTargetListType(TargetListType.DEFAULT);
    defaultTargetList.setTargetListName("SampleDefaultTargetList_CreateOn_" + SoapUtils.getCurrentTimestamp());
    defaultTargetList.setTargetListDescription("SampleDefaultTargetList");
    defaultTargetList.setReachStorageStatus(ReachStorageStatus.OPEN);
    defaultTargetList.setReachStorageSpan(Long.valueOf(180));

    RetargetingListOperation addOperation = new RetargetingListOperation();
    addOperation.setOperator(Operator.ADD);
    addOperation.setAccountId(accountId);
    addOperation.setOwner(TargetListOwner.OWNER);
    addOperation.getOperand().add(defaultTargetList);

    return addOperation;
  }

  /**
   * create sample request.
   *
   * @param accountId long
   * @return RetargetingListOperation
   */
  public static RetargetingListOperation createSampleAddRequestOfRuleBase(long accountId) {
    List<RuleBaseTargetList> ruleBaseTargetListList = new ArrayList<RuleBaseTargetList>();
    for (int i = 0; i < 3; i++) {
      // RuleBaseTargetList
      RuleBaseTargetList ruleBaseTargetList = new RuleBaseTargetList();
      ruleBaseTargetList.setAccountId(accountId);
      ruleBaseTargetList.setTargetListType(TargetListType.RULE);
      ruleBaseTargetList.setTargetListName("SampleRuleBaseTargetList" + (i + 1) + "_CreateOn_" + SoapUtils.getCurrentTimestamp());
      ruleBaseTargetList.setTargetListDescription("SampleRuleBaseTargetList");
      ruleBaseTargetList.setReachStorageStatus(ReachStorageStatus.OPEN);
      ruleBaseTargetList.setReachStorageSpan(Long.valueOf(180));
      ruleBaseTargetList.setIsAllVisitor(IsAllVisitorRule.FALSE);
      ruleBaseTargetList.setIsDateSpecific(IsDateSpecificRule.TRUE);

      DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyyMMdd");
      String today = dateTimeFormatter.format(ZonedDateTime.now());
      String endDay = dateTimeFormatter.format(ZonedDateTime.now().plusYears(1));
      ruleBaseTargetList.setStartDate(today);
      ruleBaseTargetList.setEndDate(endDay);

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
      ruleBaseTargetList.getRules().add(ruleGroup);

      ruleBaseTargetListList.add(ruleBaseTargetList);
    }

    RetargetingListOperation addOperation = new RetargetingListOperation();
    addOperation.setOperator(Operator.ADD);
    addOperation.setAccountId(accountId);
    addOperation.setOwner(TargetListOwner.OWNER);
    addOperation.getOperand().addAll(ruleBaseTargetListList);

    return addOperation;
  }

  /**
   * create sample request.
   *
   * @param accountId long
   * @param retargetingListValuesList RetargetingListValues
   * @return RetargetingListOperation
   */
  public static RetargetingListOperation createSampleAddRequestOfLogical(long accountId, List<RetargetingListValues> retargetingListValuesList) {
    // LogicalTargetList
    LogicalTargetList logicalTargetList = new LogicalTargetList();
    logicalTargetList.setAccountId(accountId);
    logicalTargetList.setTargetListType(TargetListType.LOGICAL);
    logicalTargetList.setTargetListName("SampleLogicalTargetList_CreateOn_" + SoapUtils.getCurrentTimestamp());
    logicalTargetList.setTargetListDescription("SampleLogicalTargetList");

    // Get targetListIds
    List<LogicalRuleOperand> logicalRuleOperands = new ArrayList<LogicalRuleOperand>();
    for (RetargetingListValues retargetingListValues : retargetingListValuesList) {
      if (retargetingListValues.getTargetList() != null) {
        LogicalRuleOperand logicalRuleOperand = new LogicalRuleOperand();
        logicalRuleOperand.setTargetListId(retargetingListValues.getTargetList().getTargetListId());
        logicalRuleOperands.add(logicalRuleOperand);
      }
    }

    // LogicalGroup
    LogicalGroup logicalGroup1 = new LogicalGroup();
    logicalGroup1.setCondition(LogicalCondition.AND);
    logicalGroup1.getLogicalOperand().addAll(logicalRuleOperands);
    logicalTargetList.getLogicalGroup().add(logicalGroup1);

    LogicalGroup logicalGroup2 = new LogicalGroup();
    logicalGroup2.setCondition(LogicalCondition.NOT);
    logicalGroup2.getLogicalOperand().add(logicalRuleOperands.get(0));
    logicalTargetList.getLogicalGroup().add(logicalGroup2);

    RetargetingListOperation addOperation = new RetargetingListOperation();
    addOperation.setOperator(Operator.ADD);
    addOperation.setAccountId(accountId);
    addOperation.setOwner(TargetListOwner.OWNER);
    addOperation.getOperand().add(logicalTargetList);

    return addOperation;
  }

  /**
   * create sample request.
   *
   * @param accountId long
   * @param retargetingListValuesList RetargetingListValues
   * @return RetargetingListSelector
   */
  public static RetargetingListSelector createSampleGetRequest(long accountId, List<RetargetingListValues> retargetingListValuesList) {
    RetargetingListSelector selector = new RetargetingListSelector();
    selector.setAccountId(accountId);
    for (RetargetingListValues retargetingListValues : retargetingListValuesList) {
      if (retargetingListValues.getTargetList() != null) {
        selector.getTargetListIds().add(retargetingListValues.getTargetList().getTargetListId());
      }
    }
    selector.getTargetListTypes().add(TargetListType.DEFAULT);
    selector.getTargetListTypes().add(TargetListType.RULE);
    selector.getTargetListTypes().add(TargetListType.LOGICAL);

    Paging paging = new Paging();
    paging.setStartIndex(1);
    paging.setNumberResults(20);
    selector.setPaging(paging);


    return selector;
  }

  /**
   * create sample request.
   *
   * @param accountId long
   * @param retargetingListValuesList RetargetingListValues
   * @return RetargetingListOperation
   */
  public static RetargetingListOperation createSampleSetRequest(long accountId, List<RetargetingListValues> retargetingListValuesList) {
    RetargetingListOperation setOperation = new RetargetingListOperation();
    setOperation.setOperator(Operator.SET);
    setOperation.setAccountId(accountId);
    setOperation.setOwner(TargetListOwner.OWNER);

    int ruleIndex = 0;
    for (RetargetingListValues retargetingListValues : retargetingListValuesList) {
      switch (retargetingListValues.getTargetList().getTargetListType()) {
      // DefaultTargetList
        case DEFAULT:
          DefaultTargetList setDefaultTargetList = new DefaultTargetList();
          setDefaultTargetList.setAccountId(accountId);
          setDefaultTargetList.setTargetListType(TargetListType.DEFAULT);
          setDefaultTargetList.setTargetListName("SampleDefaultTargetList_UpdateOn_" + SoapUtils.getCurrentTimestamp());
          setDefaultTargetList.setTargetListDescription("SampleDefaultTargetList_Update");
          setDefaultTargetList.setTargetListId(retargetingListValues.getTargetList().getTargetListId());
          setOperation.getOperand().add(setDefaultTargetList);
          break;

        // RuleBaseTargetList
        case RULE:
          RuleBaseTargetList setRuleBaseTargetList = new RuleBaseTargetList();
          setRuleBaseTargetList.setAccountId(accountId);
          setRuleBaseTargetList.setTargetListId(retargetingListValues.getTargetList().getTargetListId());
          setRuleBaseTargetList.setTargetListType(TargetListType.RULE);
          setRuleBaseTargetList.setTargetListName("SampleRuleBaseTargetList" + (ruleIndex + 1) + "_UpdateOn_" + SoapUtils.getCurrentTimestamp());
          setRuleBaseTargetList.setTargetListDescription("SampleRuleBaseTargetList_Update");
          setRuleBaseTargetList.setReachStorageStatus(ReachStorageStatus.CLOSED);
          setRuleBaseTargetList.setReachStorageSpan(Long.valueOf(100));
          setRuleBaseTargetList.setIsAllVisitor(IsAllVisitorRule.TRUE);
          setOperation.getOperand().add(setRuleBaseTargetList);
          ruleIndex++;
          break;

        // LogicalTargetList
        case LOGICAL:
          LogicalTargetList setLogicalTargetList = new LogicalTargetList();
          setLogicalTargetList.setAccountId(accountId);
          setLogicalTargetList.setTargetListId(retargetingListValues.getTargetList().getTargetListId());
          setLogicalTargetList.setTargetListType(TargetListType.LOGICAL);
          setLogicalTargetList.setTargetListName("SampleLogicalTargetList_UpdateOn_" + SoapUtils.getCurrentTimestamp());
          setLogicalTargetList.setTargetListDescription("SampleLogicalTargetList_Update");

          List<LogicalRuleOperand> setLogicalRuleOperands = new ArrayList<LogicalRuleOperand>();
          for (RetargetingListValues values : retargetingListValuesList) {
            if (values.getTargetList().getTargetListType() != TargetListType.LOGICAL) {
              LogicalRuleOperand logicalRuleOperand = new LogicalRuleOperand();
              logicalRuleOperand.setTargetListId(values.getTargetList().getTargetListId());
              setLogicalRuleOperands.add(logicalRuleOperand);
            }
          }
          LogicalGroup setLogicalGroup = new LogicalGroup();
          setLogicalGroup.setCondition(LogicalCondition.OR);
          setLogicalGroup.getLogicalOperand().addAll(setLogicalRuleOperands);
          setLogicalTargetList.getLogicalGroup().add(setLogicalGroup);
          setOperation.getOperand().add(setLogicalTargetList);
          break;

        default:
          break;
      }
    }
    return setOperation;
  }
}

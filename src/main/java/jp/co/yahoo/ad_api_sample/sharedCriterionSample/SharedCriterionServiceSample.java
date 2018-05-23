package jp.co.yahoo.ad_api_sample.sharedCriterionSample;

import jp.co.yahoo.ad_api_sample.error.impl.SharedCriterionServiceErrorEntityFactory;
import jp.co.yahoo.ad_api_sample.util.SoapUtils;
import jp.yahooapis.ss.v201805.accountshared.AccountSharedOperation;
import jp.yahooapis.ss.v201805.accountshared.AccountSharedValues;
import jp.yahooapis.ss.v201805.Error;
import jp.yahooapis.ss.v201805.sharedcriterion.KeywordMatchType;
import jp.yahooapis.ss.v201805.sharedcriterion.Operator;
import jp.yahooapis.ss.v201805.Paging;
import jp.yahooapis.ss.v201805.sharedcriterion.SharedCriterion;
import jp.yahooapis.ss.v201805.sharedcriterion.SharedCriterionOperation;
import jp.yahooapis.ss.v201805.sharedcriterion.SharedCriterionPage;
import jp.yahooapis.ss.v201805.sharedcriterion.SharedCriterionReturnValue;
import jp.yahooapis.ss.v201805.sharedcriterion.SharedCriterionSelector;
import jp.yahooapis.ss.v201805.sharedcriterion.SharedCriterionService;
import jp.yahooapis.ss.v201805.sharedcriterion.SharedCriterionServiceInterface;
import jp.yahooapis.ss.v201805.sharedcriterion.SharedCriterionValues;

import java.util.ArrayList;
import java.util.List;

import javax.xml.ws.Holder;

/**
 * Sample Program for SharedCriterionService. Copyright (C) 2012 Yahoo Japan Corporation. All Rights Reserved.
 */
public class SharedCriterionServiceSample {

  /**
   * main method for SharedCriterionServiceSample
   *
   * @param args command line arguments
   */
  public static void main(String[] args) throws Exception {
    try {
      // =================================================================
      // Setting
      // =================================================================
      AccountSharedServiceSample accountSharedServiceSample = new AccountSharedServiceSample();
      long accountId = SoapUtils.getAccountId();

      // =================================================================
      // AccountSharedService::add
      // =================================================================
      // Set Operation
      AccountSharedOperation accountSharedOperation = accountSharedServiceSample.createSampleAddRequest(accountId);

      // Run
      List<AccountSharedValues> accountSharedValues = accountSharedServiceSample.add(accountSharedOperation);

      // Get SharedListId
      List<Long> sharedListIds = new ArrayList<>();
      if (!accountSharedValues.isEmpty() && accountSharedValues.size() > 0) {
        for (AccountSharedValues accountSharedValue : accountSharedValues) {
          sharedListIds.add(accountSharedValue.getAccountShared().getSharedListId());
        }
      }

      // =================================================================
      // SharedCriterionService::add
      // =================================================================
      // Set Operation
      SharedCriterionOperation addSharedCriterionOperation = createSampleAddRequest(accountId, sharedListIds);

      // Run
      List<SharedCriterionValues> addSharedCriterionValues = add(addSharedCriterionOperation);

      // =================================================================
      // SharedCriterionService::get
      // =================================================================
      // Set Operation
      SharedCriterionSelector sharedCriterionSelector = createSampleGetRequest(accountId, addSharedCriterionValues);

      // Run
      get(sharedCriterionSelector);

      // =================================================================
      // SharedCriterionService::remove
      // =================================================================
      // Set Operation
      SharedCriterionOperation removeSharedCriterionOperation = createSampleRemoveRequest(accountId, addSharedCriterionValues);

      // Run
      remove(removeSharedCriterionOperation);

      // =================================================================
      // AccountSharedService::remove
      // =================================================================
      // Set Operation
      AccountSharedOperation removeAccountSharedOperation = accountSharedServiceSample.createSampleRemoveRequest(accountId, accountSharedValues);

      // Run
      accountSharedServiceSample.remove(removeAccountSharedOperation);

    } catch (Exception e) {
      e.printStackTrace();
      throw e;
    }
  }

  /**
   * Sample Program for SharedCriterionService ADD.
   *
   * @param operation SharedCriterionOperation
   * @return List<SharedCriterionValues>
   */
  public static List<SharedCriterionValues> add(SharedCriterionOperation operation) throws Exception {

    // call API
    System.out.println("############################################");
    System.out.println("SharedCriterionService::mutate(ADD)");
    System.out.println("############################################");

    Holder<SharedCriterionReturnValue> sharedCriterionReturnValueHolder = new Holder<SharedCriterionReturnValue>();
    Holder<List<Error>> sharedCriterionErrorHolder = new Holder<List<Error>>();
    SharedCriterionServiceInterface sharedCriterionService = SoapUtils.createServiceInterface(SharedCriterionServiceInterface.class, SharedCriterionService.class);
    sharedCriterionService.mutate(operation, sharedCriterionReturnValueHolder, sharedCriterionErrorHolder);

    // Error
    if (sharedCriterionErrorHolder.value != null && sharedCriterionErrorHolder.value.size() > 0) {
      SoapUtils.displayErrors(new SharedCriterionServiceErrorEntityFactory(sharedCriterionErrorHolder.value), true);
    }
    if (sharedCriterionErrorHolder.value == null) {
      throw new Exception("NoDataResponse:SharedCriterionService mutate(add)");
    }

    // Display
    for (SharedCriterionValues sharedCriterionValues : sharedCriterionReturnValueHolder.value.getValues()) {
      if (sharedCriterionValues.isOperationSucceeded()) {
        display(sharedCriterionValues.getSharedCriterion());
      } else {
        SoapUtils.displayErrors(new SharedCriterionServiceErrorEntityFactory(sharedCriterionValues.getError()), true);
      }
    }

    // Response
    return sharedCriterionReturnValueHolder.value.getValues();
  }

  /**
   * Sample Program for SharedCriterionService REMOVE.
   *
   * @param operation SharedCriterionOperation
   * @return SharedCriterionValues
   */
  public static List<SharedCriterionValues> remove(SharedCriterionOperation operation) throws Exception {

    // call API
    System.out.println("############################################");
    System.out.println("SharedCriterionService::mutate(REMOVE)");
    System.out.println("############################################");

    Holder<SharedCriterionReturnValue> sharedCriterionReturnValueHolder = new Holder<SharedCriterionReturnValue>();
    Holder<List<Error>> sharedCriterionErrorHolder = new Holder<List<Error>>();
    SharedCriterionServiceInterface sharedCriterionService = SoapUtils.createServiceInterface(SharedCriterionServiceInterface.class, SharedCriterionService.class);
    sharedCriterionService.mutate(operation, sharedCriterionReturnValueHolder, sharedCriterionErrorHolder);

    // Error
    if (sharedCriterionErrorHolder.value != null && sharedCriterionErrorHolder.value.size() > 0) {
      SoapUtils.displayErrors(new SharedCriterionServiceErrorEntityFactory(sharedCriterionErrorHolder.value), true);
    }
    if (sharedCriterionErrorHolder.value == null) {
      throw new Exception("NoDataResponse:SharedCriterionService mutate(remove)");
    }

    // Display
    for (SharedCriterionValues sharedCriterionValues : sharedCriterionReturnValueHolder.value.getValues()) {
      if (sharedCriterionValues.isOperationSucceeded()) {
        display(sharedCriterionValues.getSharedCriterion());
      } else {
        SoapUtils.displayErrors(new SharedCriterionServiceErrorEntityFactory(sharedCriterionValues.getError()), true);
      }
    }

    // Response
    return sharedCriterionReturnValueHolder.value.getValues();
  }

  /**
   * Sample Program for SharedCriterionService GET.
   *
   * @param selector SharedCriterionSelector
   * @return SharedCriterionValues
   */
  public static List<SharedCriterionValues> get(SharedCriterionSelector selector) throws Exception {

    // Call API
    System.out.println("############################################");
    System.out.println("SharedCriterionService::get");
    System.out.println("############################################");

    Holder<SharedCriterionPage> sharedCriterionPageHolder = new Holder<SharedCriterionPage>();
    Holder<List<Error>> errorHolder = new Holder<List<Error>>();
    SharedCriterionServiceInterface sharedCriterionService = SoapUtils.createServiceInterface(SharedCriterionServiceInterface.class, SharedCriterionService.class);
    sharedCriterionService.get(selector, sharedCriterionPageHolder, errorHolder);

    // Error
    if (errorHolder.value != null && errorHolder.value.size() > 0) {
      SoapUtils.displayErrors(new SharedCriterionServiceErrorEntityFactory(errorHolder.value), true);
    }
    if (sharedCriterionPageHolder.value == null) {
      throw new Exception("NoDataResponse:SharedCriterionService Get");
    }

    // Display
    for (SharedCriterionValues sharedCriterionValues : sharedCriterionPageHolder.value.getValues()) {
      if (sharedCriterionValues.isOperationSucceeded()) {
        display(sharedCriterionValues.getSharedCriterion());
      } else {
        SoapUtils.displayErrors(new SharedCriterionServiceErrorEntityFactory(sharedCriterionValues.getError()), true);
      }
    }

    // Response
    return sharedCriterionPageHolder.value.getValues();
  }

  /**
   * create sample request.
   *
   * @param accountId long
   * @param sharedListIds List<Long>
   * @return SharedCriterionOperation
   */
  public static SharedCriterionOperation createSampleAddRequest(long accountId, List<Long> sharedListIds) {

    // Set Operation
    SharedCriterionOperation operation = new SharedCriterionOperation();
    operation.setOperator(Operator.ADD);
    operation.setAccountId(accountId);

    // Set Operand
    for (long sharedListId : sharedListIds) {
      SharedCriterion operand = new SharedCriterion();
      operand.setSharedListId(sharedListId);
      operand.setText("sample text " + SoapUtils.getCurrentTimestamp() + " " + sharedListId);
      operand.setMatchType(KeywordMatchType.EXACT);
      operation.getOperand().add(operand);
    }

    return operation;
  }

  /**
   * create sample request.
   *
   * @param accountId           long
   * @param sharedCriterionValues List<SharedCriterionValues>
   * @return SharedCriterionOperation
   */
  public static SharedCriterionOperation createSampleRemoveRequest(long accountId, List<SharedCriterionValues> sharedCriterionValues) {

    // Set Operation
    SharedCriterionOperation operation = new SharedCriterionOperation();
    operation.setOperator(Operator.REMOVE);
    operation.setAccountId(accountId);

    // Set Operand
    for (SharedCriterionValues sharedCriterionValue : sharedCriterionValues) {
      SharedCriterion operand = new SharedCriterion();
      operand.setSharedListId(sharedCriterionValue.getSharedCriterion().getSharedListId());
      operand.setCriterionId(sharedCriterionValue.getSharedCriterion().getCriterionId());
      operation.getOperand().add(operand);
    }

    return operation;
  }

  /**
   * create sample request.
   *
   * @param accountId           long
   * @param sharedCriterionValues List<SharedCriterionValues>
   * @return SharedCriterionSelector
   */
  public static SharedCriterionSelector createSampleGetRequest(long accountId, List<SharedCriterionValues> sharedCriterionValues) {

    // Set Selector
    SharedCriterionSelector selector = new SharedCriterionSelector();
    selector.setAccountId(accountId);

    // Set AccountSharedID
    for (SharedCriterionValues sharedCriterionValue : sharedCriterionValues) {
      selector.getCriterionIds().add((sharedCriterionValue.getSharedCriterion().getCriterionId()));
    }

    // Set Paging
    Paging paging = new Paging();
    paging.setStartIndex(1);
    paging.setNumberResults(20);
    selector.setPaging(paging);

    return selector;
  }

  /**
   * display sharedCriterion entity to stdout.
   *
   * @param sharedCriterion SharedCriterion entity for display.
   */
  private static void display(SharedCriterion sharedCriterion) {
    System.out.println("accountId = " + sharedCriterion.getAccountId());
    System.out.println("sharedListId = " + sharedCriterion.getSharedListId());
    System.out.println("criterionId = " + sharedCriterion.getCriterionId());
    System.out.println("text = " + sharedCriterion.getText());
    System.out.println("matchType = " + sharedCriterion.getMatchType());
    System.out.println("criterionUseType = " + sharedCriterion.getCriterionUseType());
    System.out.println("---------");
  }
}

package jp.co.yahoo.ad_api_sample.sharedCriterionSample;

import jp.co.yahoo.ad_api_sample.error.impl.AccountSharedServiceErrorEntityFactory;
import jp.co.yahoo.ad_api_sample.util.SoapUtils;
import jp.yahooapis.ss.v201808.accountshared.AccountShared;
import jp.yahooapis.ss.v201808.accountshared.AccountSharedOperation;
import jp.yahooapis.ss.v201808.accountshared.AccountSharedPage;
import jp.yahooapis.ss.v201808.accountshared.AccountSharedReturnValue;
import jp.yahooapis.ss.v201808.accountshared.AccountSharedSelector;
import jp.yahooapis.ss.v201808.accountshared.AccountSharedService;
import jp.yahooapis.ss.v201808.accountshared.AccountSharedServiceInterface;
import jp.yahooapis.ss.v201808.accountshared.AccountSharedValues;
import jp.yahooapis.ss.v201808.Error;
import jp.yahooapis.ss.v201808.accountshared.Operator;
import jp.yahooapis.ss.v201808.Paging;

import java.util.List;

import javax.xml.ws.Holder;

/**
 * Sample Program for AccountSharedService. Copyright (C) 2012 Yahoo Japan Corporation. All Rights Reserved.
 */
public class AccountSharedServiceSample {

  /**
   * main method for AccountSharedServiceSample
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
      // AccountSharedService::add
      // =================================================================
      // Set Operation
      AccountSharedOperation addAccountSharedOperation = createSampleAddRequest(accountId);

      // Run
      List<AccountSharedValues> addAccountSharedValues = add(addAccountSharedOperation);

      // =================================================================
      // AccountSharedService::get
      // =================================================================
      // Set Operation
      AccountSharedSelector accountSharedSelector = createSampleGetRequest(accountId, addAccountSharedValues);

      // Run
      get(accountSharedSelector);

      // =================================================================
      // AccountSharedService::set
      // =================================================================
      // Set Operation
      AccountSharedOperation setAccountSharedOperation = createSampleSetRequest(accountId, addAccountSharedValues);

      // Run
      set(setAccountSharedOperation);

      // =================================================================
      // AccountSharedService::remove
      // =================================================================
      // Set Operation
      AccountSharedOperation removeAccountSharedOperation = createSampleRemoveRequest(accountId, addAccountSharedValues);

      // Run
      remove(removeAccountSharedOperation);

    } catch (Exception e) {
      e.printStackTrace();
      throw e;
    }
  }

  /**
   * Sample Program for AccountSharedService ADD.
   *
   * @param operation AccountSharedOperation
   * @return List<AccountSharedValues>
   */
  public static List<AccountSharedValues> add(AccountSharedOperation operation) throws Exception {

    // call API
    System.out.println("############################################");
    System.out.println("AccountSharedService::mutate(ADD)");
    System.out.println("############################################");

    Holder<AccountSharedReturnValue> accountSharedReturnValueHolder = new Holder<AccountSharedReturnValue>();
    Holder<List<Error>> accountSharedErrorHolder = new Holder<List<Error>>();
    AccountSharedServiceInterface accountSharedService = SoapUtils.createServiceInterface(AccountSharedServiceInterface.class, AccountSharedService.class);
    accountSharedService.mutate(operation, accountSharedReturnValueHolder, accountSharedErrorHolder);

    // Error
    if (accountSharedErrorHolder.value != null && accountSharedErrorHolder.value.size() > 0) {
      SoapUtils.displayErrors(new AccountSharedServiceErrorEntityFactory(accountSharedErrorHolder.value), true);
    }
    if (accountSharedErrorHolder.value == null) {
      throw new Exception("NoDataResponse:AccountSharedService mutate(add)");
    }

    // Display
    for (AccountSharedValues accountSharedValues : accountSharedReturnValueHolder.value.getValues()) {
      if (accountSharedValues.isOperationSucceeded()) {
        display(accountSharedValues.getAccountShared());
      } else {
        SoapUtils.displayErrors(new AccountSharedServiceErrorEntityFactory(accountSharedValues.getError()), true);
      }
    }

    // Response
    return accountSharedReturnValueHolder.value.getValues();
  }

  /**
   * Sample Program for AccountSharedService SET.
   *
   * @param operation AccountSharedOperation
   * @return List<AccountSharedValues>
   */
  public static List<AccountSharedValues> set(AccountSharedOperation operation) throws Exception {

    // call API
    System.out.println("############################################");
    System.out.println("AccountSharedService::mutate(SET)");
    System.out.println("############################################");

    Holder<AccountSharedReturnValue> accountSharedReturnValueHolder = new Holder<AccountSharedReturnValue>();
    Holder<List<Error>> accountSharedErrorHolder = new Holder<List<Error>>();
    AccountSharedServiceInterface accountSharedService = SoapUtils.createServiceInterface(AccountSharedServiceInterface.class, AccountSharedService.class);
    accountSharedService.mutate(operation, accountSharedReturnValueHolder, accountSharedErrorHolder);

    // Error
    if (accountSharedErrorHolder.value != null && accountSharedErrorHolder.value.size() > 0) {
      SoapUtils.displayErrors(new AccountSharedServiceErrorEntityFactory(accountSharedErrorHolder.value), true);
    }
    if (accountSharedErrorHolder.value == null) {
      throw new Exception("NoDataResponse:AccountSharedService mutate(set)");
    }

    // Display
    for (AccountSharedValues accountSharedValues : accountSharedReturnValueHolder.value.getValues()) {
      if (accountSharedValues.isOperationSucceeded()) {
        display(accountSharedValues.getAccountShared());
      } else {
        SoapUtils.displayErrors(new AccountSharedServiceErrorEntityFactory(accountSharedValues.getError()), true);
      }
    }

    // Response
    return accountSharedReturnValueHolder.value.getValues();
  }

  /**
   * Sample Program for AccountSharedService REMOVE.
   *
   * @param operation AccountSharedOperation
   * @return List<AccountSharedValues>
   */
  public static List<AccountSharedValues> remove(AccountSharedOperation operation) throws Exception {

    // call API
    System.out.println("############################################");
    System.out.println("AccountSharedService::mutate(REMOVE)");
    System.out.println("############################################");

    Holder<AccountSharedReturnValue> accountSharedReturnValueHolder = new Holder<AccountSharedReturnValue>();
    Holder<List<Error>> accountSharedErrorHolder = new Holder<List<Error>>();
    AccountSharedServiceInterface accountSharedService = SoapUtils.createServiceInterface(AccountSharedServiceInterface.class, AccountSharedService.class);
    accountSharedService.mutate(operation, accountSharedReturnValueHolder, accountSharedErrorHolder);

    // Error
    if (accountSharedErrorHolder.value != null && accountSharedErrorHolder.value.size() > 0) {
      SoapUtils.displayErrors(new AccountSharedServiceErrorEntityFactory(accountSharedErrorHolder.value), true);
    }
    if (accountSharedErrorHolder.value == null) {
      throw new Exception("NoDataResponse:AccountSharedService mutate(remove)");
    }

    // Display
    for (AccountSharedValues accountSharedValues : accountSharedReturnValueHolder.value.getValues()) {
      if (accountSharedValues.isOperationSucceeded()) {
        display(accountSharedValues.getAccountShared());
      } else {
        SoapUtils.displayErrors(new AccountSharedServiceErrorEntityFactory(accountSharedValues.getError()), true);
      }
    }

    // Response
    return accountSharedReturnValueHolder.value.getValues();
  }

  /**
   * Sample Program for AccountSharedService GET.
   *
   * @param selector AccountSharedSelector
   * @return List<AccountSharedValues>
   */
  public static List<AccountSharedValues> get(AccountSharedSelector selector) throws Exception {

    // Call API
    System.out.println("############################################");
    System.out.println("AccountSharedService::get");
    System.out.println("############################################");

    Holder<AccountSharedPage> accountSharedPageHolder = new Holder<AccountSharedPage>();
    Holder<List<Error>> errorHolder = new Holder<List<Error>>();
    AccountSharedServiceInterface accountSharedService = SoapUtils.createServiceInterface(AccountSharedServiceInterface.class, AccountSharedService.class);
    accountSharedService.get(selector, accountSharedPageHolder, errorHolder);

    // Error
    if (errorHolder.value != null && errorHolder.value.size() > 0) {
      SoapUtils.displayErrors(new AccountSharedServiceErrorEntityFactory(errorHolder.value), true);
    }
    if (accountSharedPageHolder.value == null) {
      throw new Exception("NoDataResponse:AccountSharedService Get");
    }

    // Display
    for (AccountSharedValues accountSharedValues : accountSharedPageHolder.value.getValues()) {
      if (accountSharedValues.isOperationSucceeded()) {
        display(accountSharedValues.getAccountShared());
      } else {
        SoapUtils.displayErrors(new AccountSharedServiceErrorEntityFactory(accountSharedValues.getError()), true);
      }
    }

    // Response
    return accountSharedPageHolder.value.getValues();
  }

  /**
   * create sample request.
   *
   * @param accountId long
   * @return AccountSharedOperation
   */
  public static AccountSharedOperation createSampleAddRequest(long accountId) {

    // Set Operation
    AccountSharedOperation operation = new AccountSharedOperation();
    operation.setOperator(Operator.ADD);
    operation.setAccountId(accountId);

    // Set Operand
    AccountShared operand = new AccountShared();
    operand.setName("SampleSharedAccount_" + SoapUtils.getCurrentTimestamp());
    operation.getOperand().add(operand);

    return operation;
  }

  /**
   * create sample request.
   *
   * @param accountId           long
   * @param accountSharedValues List<AccountSharedValues>
   * @return AccountSharedOperation
   */
  public static AccountSharedOperation createSampleSetRequest(long accountId, List<AccountSharedValues> accountSharedValues) {

    // Set Operation
    AccountSharedOperation operation = new AccountSharedOperation();
    operation.setOperator(Operator.SET);
    operation.setAccountId(accountId);

    // Set Operand
    for (AccountSharedValues accountSharedValue : accountSharedValues) {
      AccountShared operand = new AccountShared();
      operand.setSharedListId(accountSharedValue.getAccountShared().getSharedListId());
      operand.setName("SampleSharedAccount_UpdateOn_" + SoapUtils.getCurrentTimestamp());
      operation.getOperand().add(operand);
    }

    return operation;
  }

  /**
   * create sample request.
   *
   * @param accountId           long
   * @param accountSharedValues List<AccountSharedValues>
   * @return AccountSharedOperation
   */
  public static AccountSharedOperation createSampleRemoveRequest(long accountId, List<AccountSharedValues> accountSharedValues) {

    // Set Operation
    AccountSharedOperation operation = new AccountSharedOperation();
    operation.setOperator(Operator.REMOVE);
    operation.setAccountId(accountId);

    // Set Operand
    for (AccountSharedValues accountSharedValue : accountSharedValues) {
      AccountShared operand = new AccountShared();
      operand.setSharedListId(accountSharedValue.getAccountShared().getSharedListId());
      operation.getOperand().add(operand);
    }

    return operation;
  }

  /**
   * create sample request.
   *
   * @param accountId           long
   * @param accountSharedValues List<AccountSharedValues>
   * @return AccountSharedSelector
   */
  public static AccountSharedSelector createSampleGetRequest(long accountId, List<AccountSharedValues> accountSharedValues) {

    // Set Selector
    AccountSharedSelector selector = new AccountSharedSelector();
    selector.setAccountId(accountId);

    // Set AccountSharedID
    for (AccountSharedValues accountSharedValue : accountSharedValues) {
      selector.getSharedListIds().add((accountSharedValue.getAccountShared().getSharedListId()));
    }

    // Set Paging
    Paging paging = new Paging();
    paging.setStartIndex(1);
    paging.setNumberResults(20);
    selector.setPaging(paging);

    return selector;
  }

  /**
   * display accountShared entity to stdout.
   *
   * @param accountShared AccountShared entity for display.
   */
  private static void display(AccountShared accountShared) {
    System.out.println("accountId = " + accountShared.getAccountId());
    System.out.println("sharedListId = " + accountShared.getSharedListId());
    System.out.println("name = " + accountShared.getName());
    System.out.println("memberCount = " + accountShared.getMemberCount());
    System.out.println("referenceCount = " + accountShared.getReferenceCount());
    System.out.println("---------");
  }
}

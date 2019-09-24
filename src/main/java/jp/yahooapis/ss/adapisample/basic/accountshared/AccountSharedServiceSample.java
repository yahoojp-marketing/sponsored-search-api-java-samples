/**
 * Copyright (C) 2019 Yahoo Japan Corporation. All Rights Reserved.
 */
package jp.yahooapis.ss.adapisample.basic.accountshared;

import jp.yahooapis.ss.adapisample.repository.ValuesRepositoryFacade;
import jp.yahooapis.ss.adapisample.util.SoapUtils;
import jp.yahooapis.ss.adapisample.util.ValuesHolder;
import jp.yahooapis.ss.v201909.Error;
import jp.yahooapis.ss.v201909.Paging;
import jp.yahooapis.ss.v201909.accountshared.AccountShared;
import jp.yahooapis.ss.v201909.accountshared.AccountSharedOperation;
import jp.yahooapis.ss.v201909.accountshared.AccountSharedPage;
import jp.yahooapis.ss.v201909.accountshared.AccountSharedReturnValue;
import jp.yahooapis.ss.v201909.accountshared.AccountSharedSelector;
import jp.yahooapis.ss.v201909.accountshared.AccountSharedService;
import jp.yahooapis.ss.v201909.accountshared.AccountSharedServiceInterface;
import jp.yahooapis.ss.v201909.accountshared.AccountSharedValues;
import jp.yahooapis.ss.v201909.accountshared.Operator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.xml.ws.Holder;

/**
 * example AccountSharedService operation and Utility method collection.
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
      ValuesHolder valuesHolder = new ValuesHolder();
      long accountId = SoapUtils.getAccountId();
      ValuesRepositoryFacade valuesRepositoryFacade = new ValuesRepositoryFacade(valuesHolder);

      // =================================================================
      // AccountSharedService ADD
      // =================================================================
      // create request.
      AccountSharedOperation addRequest = buildExampleMutateRequest( //
          Operator.ADD, accountId, Collections.singletonList(createExampleAccountShared()) //
      );

      // Run
      List<AccountSharedValues> addResponse = mutate(addRequest);
      valuesRepositoryFacade.getValuesHolder().setAccountSharedValuesList(addResponse);

      // =================================================================
      // AccountSharedService SET
      // =================================================================
      // create request.
      AccountSharedOperation setRequest = buildExampleMutateRequest(Operator.SET, accountId, createExampleSetRequest(valuesRepositoryFacade.getAccountSharedValuesRepository().getAccountShareds()));

      // Run
      mutate(setRequest);

      // =================================================================
      // AccountSharedService GET
      // =================================================================
      // create request.
      AccountSharedSelector getRequest = buildExampleGetRequest(accountId, valuesRepositoryFacade.getAccountSharedValuesRepository().getSharedListIds());

      // Run
      get(getRequest);

      // =================================================================
      // AccountSharedService REMOVE
      // =================================================================
      // create request.
      AccountSharedOperation removeRequest = buildExampleMutateRequest(Operator.REMOVE, accountId, valuesRepositoryFacade.getAccountSharedValuesRepository().getAccountShareds());

      // Run
      mutate(removeRequest);

    } catch (Exception e) {
      e.printStackTrace();
      throw e;
    }
  }

  /**
   * check & create upper service object.
   *
   * @return ValuesHolder
   */
  public static ValuesHolder create() throws Exception {
    long accountId = SoapUtils.getAccountId();
    ValuesHolder valuesHolder = new ValuesHolder();

    AccountSharedOperation request = buildExampleMutateRequest( //
        Operator.ADD, accountId, Collections.singletonList(createExampleAccountShared())
    );

    List<AccountSharedValues> response = mutate(request);
    valuesHolder.setAccountSharedValuesList(response);
    return valuesHolder;
  }

  /**
   * cleanup service object.
   */
  public static void cleanup(ValuesHolder valuesHolder) throws Exception {
    long accountId = SoapUtils.getAccountId();
    if (valuesHolder.getAccountSharedValuesList().size() > 0) {

      ValuesRepositoryFacade valuesRepositoryFacade = new ValuesRepositoryFacade(valuesHolder);

      AccountSharedOperation removeAccountSharedOperation = buildExampleMutateRequest(Operator.REMOVE, accountId, valuesRepositoryFacade.getAccountSharedValuesRepository().getAccountShareds());

      mutate(removeAccountSharedOperation);
    }
  }

  /**
   * example mutate request.
   */
  public static AccountSharedOperation buildExampleMutateRequest(Operator operator, long accountId, List<AccountShared> operand) {
    AccountSharedOperation operation = new AccountSharedOperation();
    operation.setOperator(operator);
    operation.setAccountId(accountId);
    operation.getOperand().addAll(operand);

    return operation;
  }

  /**
   * create sample AccountShared request.
   *
   * @return AccountShared
   */
  public static AccountShared createExampleAccountShared() {
    AccountShared operand = new AccountShared();
    operand.setName("SampleSharedAccount_" + SoapUtils.getCurrentTimestamp());

    return operand;
  }

  /**
   * example mutate account shared lists.
   *
   * @param operation AccountSharedOperation
   * @return List<AccountSharedValues>
   */
  public static List<AccountSharedValues> mutate(AccountSharedOperation operation) throws Exception {
    // Call API
    System.out.println("############################################");
    System.out.println("AccountSharedService::mutate(" + operation.getOperator() + ")");
    System.out.println("############################################");

    Holder<AccountSharedReturnValue> accountSharedReturnValueHolder = new Holder<>();
    Holder<List<Error>> errorHolder = new Holder<>();
    AccountSharedServiceInterface accountSharedService = SoapUtils.createServiceInterface(AccountSharedServiceInterface.class, AccountSharedService.class);
    accountSharedService.mutate(operation, accountSharedReturnValueHolder, errorHolder);

    SoapUtils.checkSoapError(errorHolder, accountSharedReturnValueHolder.value.getValues());

    // Response
    return accountSharedReturnValueHolder.value.getValues();
  }

  /**
   * example get account shared lists.
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

    SoapUtils.checkSoapError(errorHolder, accountSharedPageHolder.value.getValues());

    // Response
    return accountSharedPageHolder.value.getValues();
  }

  /**
   * example shared account list set request.
   *
   * @return List<AccountShared>
   */
  public static List<AccountShared> createExampleSetRequest(List<AccountShared> accountShareds) {
    // create operands
    List<AccountShared> operands = new ArrayList<>();

    for (AccountShared accountShared : accountShareds) {
      AccountShared operand = new AccountShared();
      operand.setSharedListId(accountShared.getSharedListId());
      operand.setName("SampleSharedAccount_UpdateOn_" + accountShared.getSharedListId() + "_" + SoapUtils.getCurrentTimestamp());

      operands.add(operand);
    }

    return operands;
  }

  /**
   * example get request.
   *
   * @param accountId     long
   * @param sharedListIds long
   * @return AccountSharedSelector
   */
  public static AccountSharedSelector buildExampleGetRequest(long accountId, List<Long> sharedListIds) {

    // Set Selector
    AccountSharedSelector selector = new AccountSharedSelector();
    selector.setAccountId(accountId);

    // Set AccountSharedID
    for (long sharedListId : sharedListIds) {
      selector.getSharedListIds().add(sharedListId);
    }

    Paging paging = new Paging();
    paging.setStartIndex(1);
    paging.setNumberResults(20);
    selector.setPaging(paging);

    return selector;
  }
}

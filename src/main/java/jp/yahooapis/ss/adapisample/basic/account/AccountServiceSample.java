/**
 * Copyright (C) 2019 Yahoo Japan Corporation. All Rights Reserved.
 */
package jp.yahooapis.ss.adapisample.basic.account;

import jp.yahooapis.ss.adapisample.util.SoapUtils;
import jp.yahooapis.ss.v201901.Error;
import jp.yahooapis.ss.v201901.Paging;
import jp.yahooapis.ss.v201901.account.Account;
import jp.yahooapis.ss.v201901.account.AccountOperation;
import jp.yahooapis.ss.v201901.account.AccountPage;
import jp.yahooapis.ss.v201901.account.AccountReturnValue;
import jp.yahooapis.ss.v201901.account.AccountSelector;
import jp.yahooapis.ss.v201901.account.AccountService;
import jp.yahooapis.ss.v201901.account.AccountServiceInterface;
import jp.yahooapis.ss.v201901.account.AccountStatus;
import jp.yahooapis.ss.v201901.account.AccountType;
import jp.yahooapis.ss.v201901.account.AccountValues;
import jp.yahooapis.ss.v201901.account.AutoTaggingEnabled;
import jp.yahooapis.ss.v201901.account.DeliveryStatus;
import jp.yahooapis.ss.v201901.account.Operator;

import java.util.Arrays;
import java.util.List;

import javax.xml.ws.Holder;

/**
 * example AccountService operation and Utility method collection.
 */
public class AccountServiceSample {

  /**
   * example AccountService operation.
   *
   * @param args command line arguments
   * @throws Exception
   */
  public static void main(String[] args) throws Exception {
    try {
      // =================================================================
      // Setting
      // =================================================================
      long accountId = SoapUtils.getAccountId();

      // =================================================================
      // AccountService GET
      // =================================================================
      // create request.
      AccountSelector selector = new AccountSelector();
      selector.getAccountTypes().addAll(Arrays.asList(
          AccountType.INVOICE,
          AccountType.PREPAY
      ));
      selector.getAccountStatuses().addAll(Arrays.asList(
          AccountStatus.INPROGRESS,
          AccountStatus.WAIT_DECIDE,
          AccountStatus.SUSPENDED,
          AccountStatus.SERVING,
          AccountStatus.ENDED,
          AccountStatus.CANCELED
      ));
      Paging paging = new Paging();
      paging.setStartIndex(1);
      paging.setNumberResults(20);
      selector.setPaging(paging);

      // run
      get(selector);

      // =================================================================
      // AccountService SET
      // =================================================================
      // create request.
      Account operand = new Account();
      operand.setAccountId(accountId);
      operand.setAccountName("SampleAccount_UpdateOn_" + SoapUtils.getCurrentTimestamp());
      operand.setDeliveryStatus(DeliveryStatus.PAUSED);
      operand.setAutoTaggingEnabled(AutoTaggingEnabled.FALSE);

      AccountOperation operation = new AccountOperation();
      operation.setOperator(Operator.SET);
      operation.getOperand().add(operand);

      // run
      mutate(operation);

    } catch (Exception e) {
      e.printStackTrace();
      throw e;
    }
  }

  /**
   * example mutate accounts.
   *
   * @param operation AccountOperation
   * @return List<AccountValues>
   * @throws Exception
   */
  public static List<AccountValues> mutate(AccountOperation operation) throws Exception {

    // call API
    System.out.println("############################################");
    System.out.println("AccountService::mutate(" + operation.getOperator() +")");
    System.out.println("############################################");

    Holder<AccountReturnValue> accountReturnValueHolder = new Holder<AccountReturnValue>();
    Holder<List<Error>> errorHolder = new Holder<List<Error>>();
    AccountServiceInterface accountService = SoapUtils.createServiceInterface(AccountServiceInterface.class, AccountService.class);
    accountService.mutate(operation, accountReturnValueHolder, errorHolder);

    SoapUtils.checkSoapError(errorHolder, accountReturnValueHolder.value.getValues());

    // Response
    return accountReturnValueHolder.value.getValues();
  }

  /**
   * example get accounts.
   *
   * @param selector AccountSelector
   * @return List<AccountValues>
   * @throws Exception
   */
  public static List<AccountValues> get(AccountSelector selector) throws Exception {

    // call API
    System.out.println("############################################");
    System.out.println("AccountService::get");
    System.out.println("############################################");

    Holder<AccountPage> accountPageHolder = new Holder<AccountPage>();
    Holder<List<Error>> errorHolder = new Holder<List<Error>>();
    AccountServiceInterface accountService = SoapUtils.createServiceInterface(AccountServiceInterface.class, AccountService.class);
    accountService.get(selector, accountPageHolder, errorHolder);

    SoapUtils.checkSoapError(errorHolder, accountPageHolder.value.getValues());

    // Response
    return accountPageHolder.value.getValues();
  }
}
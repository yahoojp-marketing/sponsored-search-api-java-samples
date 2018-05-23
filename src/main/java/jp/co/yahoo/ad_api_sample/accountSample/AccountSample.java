package jp.co.yahoo.ad_api_sample.accountSample;

import java.util.Arrays;
import java.util.List;

import javax.xml.ws.Holder;

import jp.co.yahoo.ad_api_sample.error.impl.AccountServiceErrorEntityFactory;
import jp.co.yahoo.ad_api_sample.util.SoapUtils;
import jp.yahooapis.ss.v201805.account.Account;
import jp.yahooapis.ss.v201805.account.AccountOperation;
import jp.yahooapis.ss.v201805.account.AccountPage;
import jp.yahooapis.ss.v201805.account.AccountReturnValue;
import jp.yahooapis.ss.v201805.account.AccountSelector;
import jp.yahooapis.ss.v201805.account.AccountService;
import jp.yahooapis.ss.v201805.account.AccountServiceInterface;
import jp.yahooapis.ss.v201805.account.AccountStatus;
import jp.yahooapis.ss.v201805.account.AccountType;
import jp.yahooapis.ss.v201805.account.AccountValues;
import jp.yahooapis.ss.v201805.account.DeliveryStatus;
import jp.yahooapis.ss.v201805.Error;
import jp.yahooapis.ss.v201805.account.Operator;
import jp.yahooapis.ss.v201805.Paging;

/**
 * Sample Program for AccountService. Copyright (C) 2012 Yahoo Japan Corporation. All Rights
 * Reserved.
 */
public class AccountSample {

  /**
   * main method for AccountSample
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
      // AccountService::get
      // =================================================================
      // Set Selector(without accountIds)
      AccountSelector selector = new AccountSelector();
      selector.getAccountStatuses().addAll(Arrays.asList(AccountStatus.SERVING, AccountStatus.ENDED));
      selector.getAccountTypes().addAll(Arrays.asList(AccountType.INVOICE, AccountType.PREPAY));
      Paging paging = new Paging();
      paging.setStartIndex(1);
      paging.setNumberResults(20);
      selector.setPaging(paging);

      // Run
      get(selector);

      // Set Selector(with accountIds)
      selector.getAccountIds().add(new Long(accountId));

      // Run
      get(selector);

      // =================================================================
      // AccountService::mutate(SET)
      // =================================================================
      // Set Operation
      AccountOperation operation = new AccountOperation();
      operation.setOperator(Operator.SET);

      // Set Operand
      Account operand = new Account();
      operand.setAccountId(accountId);
      operand.setAccountName("SampleAccount_UpdateOn_" + SoapUtils.getCurrentTimestamp());
      operand.setDeliveryStatus(DeliveryStatus.PAUSED);
      operation.getOperand().add(operand);

      // Run
      mutate(operation);

    } catch (Exception e) {
      e.printStackTrace();
      throw e;
    }
  }

  /**
   * Sample Program for AccountService MUTATE.
   * 
   * @param operation AccountOperation
   * @return AccountValues
   * @throws Exception
   */
  public static List<AccountValues> mutate(AccountOperation operation) throws Exception {

    // call API
    System.out.println("############################################");
    System.out.println("AccountService::mutate(" + operation.getOperator() +")");
    System.out.println("############################################");

    Holder<AccountReturnValue> accountReturnValueHolder = new Holder<AccountReturnValue>();
    Holder<List<Error>> accountErrorHolder = new Holder<List<Error>>();
    AccountServiceInterface accountService = SoapUtils.createServiceInterface(AccountServiceInterface.class, AccountService.class);
    accountService.mutate(operation, accountReturnValueHolder, accountErrorHolder);

    // Error
    if (accountErrorHolder.value != null && accountErrorHolder.value.size() > 0) {
      SoapUtils.displayErrors(new AccountServiceErrorEntityFactory(accountErrorHolder.value), true);
    }
    if (accountErrorHolder.value == null) {
      throw new Exception("NoDataResponse:AccountService " + operation.getOperator());
    }

    // Display
    for (AccountValues accountValues : accountReturnValueHolder.value.getValues()) {
      if (accountValues.isOperationSucceeded()) {
        display(accountValues.getAccount());
      } else {
        SoapUtils.displayErrors(new AccountServiceErrorEntityFactory(accountValues.getError()), true);
      }
    }

    // Response
    return accountReturnValueHolder.value.getValues();
  }

  /**
   * Sample Program for AccountService GET.
   * 
   * @param selector AccountSelector
   * @return AccountValues
   * @throws Exception
   */
  public static List<AccountValues> get(AccountSelector selector) throws Exception {

    // call API
    System.out.println("############################################");
    System.out.println("AccountService::get");
    System.out.println("############################################");

    Holder<AccountPage> accountPageHolder = new Holder<AccountPage>();
    Holder<List<Error>> accountErrorHolder = new Holder<List<Error>>();
    AccountServiceInterface accountService = SoapUtils.createServiceInterface(AccountServiceInterface.class, AccountService.class);
    accountService.get(selector, accountPageHolder, accountErrorHolder);

    // Error
    if (accountErrorHolder.value != null && accountErrorHolder.value.size() > 0) {
      SoapUtils.displayErrors(new AccountServiceErrorEntityFactory(accountErrorHolder.value), true);
    }
    if (accountErrorHolder.value == null) {
      throw new Exception("NoDataResponse:AccountService Get");
    }

    // Display
    for (AccountValues accountValues : accountPageHolder.value.getValues()) {
      if (accountValues.isOperationSucceeded()) {
        display(accountValues.getAccount());
      } else {
        SoapUtils.displayErrors(new AccountServiceErrorEntityFactory(accountValues.getError()), true);
      }
    }

    // Response
    return accountPageHolder.value.getValues();
  }

  /**
   * display account entity to stdout.
   *
   * @param account Account entity for display.
   */
  private static void display(Account account) {
    System.out.println("accountId = " + account.getAccountId());
    System.out.println("accountName = " + account.getAccountName());
    System.out.println("accountType = " + account.getAccountType().toString());
    System.out.println("accountStatus = " + account.getAccountStatus().toString());
    System.out.println("deliverStatus = " + account.getDeliveryStatus().toString());
    if (account.getBudget() != null) {
      System.out.println("budget/amount = " + account.getBudget().getAmount());
      System.out.println("budget/limitChargeType = " + account.getBudget().getLimitChargeType());
      System.out.println("budget/startDate = " + account.getBudget().getStartDate());
      System.out.println("budget/endDate = " + account.getBudget().getEndDate());
    }
    System.out.println("---------");
  }
}

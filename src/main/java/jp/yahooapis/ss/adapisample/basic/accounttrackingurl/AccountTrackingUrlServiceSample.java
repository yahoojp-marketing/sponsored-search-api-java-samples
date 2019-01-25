/**
 * Copyright (C) 2019 Yahoo Japan Corporation. All Rights Reserved.
 */
package jp.yahooapis.ss.adapisample.basic.accounttrackingurl;

import jp.yahooapis.ss.adapisample.util.SoapUtils;
import jp.yahooapis.ss.v201901.Error;
import jp.yahooapis.ss.v201901.Paging;
import jp.yahooapis.ss.v201901.accounttrackingurl.AccountTrackingUrl;
import jp.yahooapis.ss.v201901.accounttrackingurl.AccountTrackingUrlOperation;
import jp.yahooapis.ss.v201901.accounttrackingurl.AccountTrackingUrlPage;
import jp.yahooapis.ss.v201901.accounttrackingurl.AccountTrackingUrlReturnValue;
import jp.yahooapis.ss.v201901.accounttrackingurl.AccountTrackingUrlSelector;
import jp.yahooapis.ss.v201901.accounttrackingurl.AccountTrackingUrlService;
import jp.yahooapis.ss.v201901.accounttrackingurl.AccountTrackingUrlServiceInterface;
import jp.yahooapis.ss.v201901.accounttrackingurl.AccountTrackingUrlValues;
import jp.yahooapis.ss.v201901.accounttrackingurl.Operator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.xml.ws.Holder;

/**
 * example AccountTrackingUrlService operation and Utility method collection.
 */
public class AccountTrackingUrlServiceSample {

  /**
   * main method for AccountTrackingURLSample
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
      // AccountTrackingUrlService GET
      // =================================================================
      // create request.
      AccountTrackingUrlSelector getRequest = buildExampleGetRequest(new ArrayList<Long>(){{
        add(accountId);
      }});

      // Run
      get(getRequest);

      // =================================================================
      // AccountTrackingUrlService SET
      // =================================================================
      // create request.
      AccountTrackingUrlOperation setRequest = buildExampleMutateRequest(Operator.SET, new ArrayList<AccountTrackingUrl>() {{
        add(createExampleSetRequest(accountId));
      }});

      // Run
      mutate(setRequest);

    } catch (Exception e) {
      e.printStackTrace();
      throw e;
    }
  }

  /**
   * example get request.
   *
   * @param accountIds long
   * @return AccountTrackingUrlSelector
   */
  public static AccountTrackingUrlSelector buildExampleGetRequest(List<Long> accountIds) {

    // Set Selector
    AccountTrackingUrlSelector selector = new AccountTrackingUrlSelector();
    for (long accountId : accountIds) {
      selector.getAccountIds().add(accountId);
    }

    Paging paging = new Paging();
    paging.setStartIndex(1);
    paging.setNumberResults(20);
    selector.setPaging(paging);

    return selector;
  }

  /**
   * example mutate request.
   */
  public static AccountTrackingUrlOperation buildExampleMutateRequest(Operator operator, List<AccountTrackingUrl> operand) {
    AccountTrackingUrlOperation operation = new AccountTrackingUrlOperation();
    operation.setOperator(operator);
    operation.getOperand().addAll(operand);

    return operation;
  }

  /**
   * example shared account list set request.
   *
   * @param accountId long
   * @return AccountTrackingUrl
   */
  public static AccountTrackingUrl createExampleSetRequest(long accountId) {
    // create operand
    AccountTrackingUrl operand = new AccountTrackingUrl();

    operand.setAccountId(accountId);
    operand.setTrackingUrl("http://www.yahoo.co.jp?url={lpurl}&amp;id={_id1}");

    return operand;
  }

  /**
   * example mutate account trackingUrls.
   *
   * @param operation AccountTrackingUrlOperation
   * @return AccountTrackingUrlValues
   * @throws Exception
   */
  public static List<AccountTrackingUrlValues> mutate(AccountTrackingUrlOperation operation) throws Exception {

    // call API
    System.out.println("############################################");
    System.out.println("AccountTrackingUrlService::mutate(" + operation.getOperator() + ")");
    System.out.println("############################################");

    Holder<AccountTrackingUrlReturnValue> accountReturnValueHolder = new Holder<AccountTrackingUrlReturnValue>();
    Holder<List<Error>> errorHolder = new Holder<List<Error>>();
    AccountTrackingUrlServiceInterface AccountTrackingUrlService = SoapUtils.createServiceInterface(AccountTrackingUrlServiceInterface.class, AccountTrackingUrlService.class);
    AccountTrackingUrlService.mutate(operation, accountReturnValueHolder, errorHolder);

    SoapUtils.checkSoapError(errorHolder, accountReturnValueHolder.value.getValues());

    // Response
    return accountReturnValueHolder.value.getValues();
  }

  /**
   * example get account trackingUrls.
   *
   * @param selector AccountTrackingUrlSelector
   * @return AccountTrackingUrlValues
   * @throws Exception
   */
  public static List<AccountTrackingUrlValues> get(AccountTrackingUrlSelector selector) throws Exception {

    // call API
    System.out.println("############################################");
    System.out.println("AccountTrackingUrlService::get");
    System.out.println("############################################");

    Holder<AccountTrackingUrlPage> accountPageHolder = new Holder<AccountTrackingUrlPage>();
    Holder<List<Error>> errorHolder = new Holder<List<Error>>();
    AccountTrackingUrlServiceInterface AccountTrackingUrlService = SoapUtils.createServiceInterface(AccountTrackingUrlServiceInterface.class, AccountTrackingUrlService.class);
    AccountTrackingUrlService.get(selector, accountPageHolder, errorHolder);

    SoapUtils.checkSoapError(errorHolder, accountPageHolder.value.getValues());

    // Response
    return accountPageHolder.value.getValues();
  }
}
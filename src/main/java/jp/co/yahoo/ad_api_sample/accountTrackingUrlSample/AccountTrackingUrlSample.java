package jp.co.yahoo.ad_api_sample.accountTrackingUrlSample;

import java.util.Arrays;
import java.util.List;

import javax.xml.ws.Holder;

import jp.co.yahoo.ad_api_sample.error.impl.AccountTrackingURLServiceErrorEntityFactory;
import jp.co.yahoo.ad_api_sample.util.SoapUtils;
import jp.yahooapis.ss.V6.AccountTrackingURLService.AccountTrackingUrl;
import jp.yahooapis.ss.V6.AccountTrackingURLService.AccountTrackingUrlOperation;
import jp.yahooapis.ss.V6.AccountTrackingURLService.AccountTrackingUrlPage;
import jp.yahooapis.ss.V6.AccountTrackingURLService.AccountTrackingUrlReturnValue;
import jp.yahooapis.ss.V6.AccountTrackingURLService.AccountTrackingUrlSelector;
import jp.yahooapis.ss.V6.AccountTrackingURLService.AccountTrackingUrlService;
import jp.yahooapis.ss.V6.AccountTrackingURLService.AccountTrackingUrlServiceInterface;
import jp.yahooapis.ss.V6.AccountTrackingURLService.AccountTrackingUrlValues;
import jp.yahooapis.ss.V6.AccountTrackingURLService.Error;
import jp.yahooapis.ss.V6.AccountTrackingURLService.Operator;
import jp.yahooapis.ss.V6.AccountTrackingURLService.Paging;

/**
 * Sample Program for AccountTrackingUrlService. Copyright (C) 2012 Yahoo Japan Corporation. All
 * Rights Reserved.
 */
public class AccountTrackingUrlSample {

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
      // AccountTrackingUrlService::get
      // =================================================================
      // Set Selector(without accountIds)
      AccountTrackingUrlSelector selector = new AccountTrackingUrlSelector();
      selector.getAccountIds().addAll(Arrays.asList(accountId));
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
      // AccountTrackingUrlService::mutate(SET)
      // =================================================================
      // Set Operation
      AccountTrackingUrlOperation operation = new AccountTrackingUrlOperation();
      operation.setOperator(Operator.SET);

      // Set Operand
      AccountTrackingUrl operand = new AccountTrackingUrl();
      operand.setAccountId(accountId);
      operand.setTrackingUrl("http://www.yahoo.co.jp?url={lpurl}&amp;id={_id1}");

      operation.getOperand().add(operand);

      // sleep 30 second.
      System.out.println("\n***** sleep 30 seconds *****\n");
      Thread.sleep(30000);

      // Run
      set(operation);

    } catch (Exception e) {
      e.printStackTrace();
      throw e;
    }
  }

  /**
   * Sample Program for AccountTrackingUrlService SET.
   * 
   * @param operation AccountTrackingUrlOperation
   * @return AccountTrackingUrlValues
   * @throws Exception
   */
  public static List<AccountTrackingUrlValues> set(AccountTrackingUrlOperation operation) throws Exception {

    // call API
    System.out.println("############################################");
    System.out.println("AccountTrackingUrlService::mutate(SET)");
    System.out.println("############################################");

    Holder<AccountTrackingUrlReturnValue> accountReturnValueHolder = new Holder<AccountTrackingUrlReturnValue>();
    Holder<List<Error>> accountErrorHolder = new Holder<List<Error>>();
    AccountTrackingUrlServiceInterface AccountTrackingUrlService = SoapUtils.createServiceInterface(AccountTrackingUrlServiceInterface.class, AccountTrackingUrlService.class);
    AccountTrackingUrlService.mutate(operation, accountReturnValueHolder, accountErrorHolder);

    // Error
    if (accountErrorHolder.value != null && accountErrorHolder.value.size() > 0) {
      SoapUtils.displayErrors(new AccountTrackingURLServiceErrorEntityFactory(accountErrorHolder.value), true);
    }
    if (accountErrorHolder.value == null) {
      throw new Exception("NoDataResponse:AccountTrackingUrlService mutate(set)");
    }

    // Display
    for (AccountTrackingUrlValues accountTrackingUrlValues : accountReturnValueHolder.value.getValues()) {
      if (accountTrackingUrlValues.isOperationSucceeded()) {
        display(accountTrackingUrlValues.getAccountTrackingUrl());
      } else {
        if (accountTrackingUrlValues.getError().get(0).getCode().equals("210905")) {
          System.out.println("******* Skip. *******");
          System.out.println("code = " + accountTrackingUrlValues.getError().get(0).getCode());
          System.out.println("message = " + accountTrackingUrlValues.getError().get(0).getMessage());
        } else {
          SoapUtils.displayErrors(new AccountTrackingURLServiceErrorEntityFactory(accountTrackingUrlValues.getError()), true);
        }
      }
    }

    // Response
    return accountReturnValueHolder.value.getValues();
  }

  /**
   * Sample Program for AccountTrackingUrlService GET.
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
    Holder<List<Error>> accountErrorHolder = new Holder<List<Error>>();
    AccountTrackingUrlServiceInterface AccountTrackingUrlService = SoapUtils.createServiceInterface(AccountTrackingUrlServiceInterface.class, AccountTrackingUrlService.class);
    AccountTrackingUrlService.get(selector, accountPageHolder, accountErrorHolder);

    // Error
    if (accountErrorHolder.value != null && accountErrorHolder.value.size() > 0) {
      SoapUtils.displayErrors(new AccountTrackingURLServiceErrorEntityFactory(accountErrorHolder.value), true);
    }
    if (accountErrorHolder.value == null) {
      throw new Exception("NoDataResponse:AccountTrackingUrlService Get");
    }

    // Display
    for (AccountTrackingUrlValues accountTrackingUrlValues : accountPageHolder.value.getValues()) {
      if (accountTrackingUrlValues.isOperationSucceeded()) {
        display(accountTrackingUrlValues.getAccountTrackingUrl());
      } else {
        SoapUtils.displayErrors(new AccountTrackingURLServiceErrorEntityFactory(accountTrackingUrlValues.getError()), true);
      }
    }

    // Response
    return accountPageHolder.value.getValues();
  }

  /**
   * display accountTrackingUrl entity to stdout.
   *
   * @param values AccountTrackingUrl entity for display.
   */
  private static void display(AccountTrackingUrl accountTrackingUrl) {
    System.out.println("accountId = " + accountTrackingUrl.getAccountId());
    System.out.println("accountName = " + accountTrackingUrl.getAccountName());
    System.out.println("trackingUrl = " + accountTrackingUrl.getTrackingUrl());
    System.out.println("inReviewUrl = " + accountTrackingUrl.getInReviewUrl());
    System.out.println("disapprovalReviewUrl = " + accountTrackingUrl.getDisapprovalReviewUrl());
    System.out.println("urlApprovalStatus = " + accountTrackingUrl.getUrlApprovalStatus().toString());

    if (null != accountTrackingUrl.getDisapprovalReasonCodes()) {
      for (String disapprovalReasonCode : accountTrackingUrl.getDisapprovalReasonCodes()) {
        System.out.println("disapprovalReasonCodes = " + disapprovalReasonCode);
      }
    }

    System.out.println("---------");
  }
}

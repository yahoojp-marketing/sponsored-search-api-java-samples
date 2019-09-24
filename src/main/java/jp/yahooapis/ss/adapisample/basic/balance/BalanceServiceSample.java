/**
 * Copyright (C) 2019 Yahoo Japan Corporation. All Rights Reserved.
 */
package jp.yahooapis.ss.adapisample.basic.balance;

import jp.yahooapis.ss.adapisample.util.SoapUtils;
import jp.yahooapis.ss.v201909.Error;
import jp.yahooapis.ss.v201909.Paging;
import jp.yahooapis.ss.v201909.balance.BalancePage;
import jp.yahooapis.ss.v201909.balance.BalanceSelector;
import jp.yahooapis.ss.v201909.balance.BalanceService;
import jp.yahooapis.ss.v201909.balance.BalanceServiceInterface;
import jp.yahooapis.ss.v201909.balance.BalanceValues;

import java.util.List;

import javax.xml.ws.Holder;


/**
 * example BalanceService operation and Utility method collection.
 */
public class BalanceServiceSample {

  /**
   * example BalanceService operation.
   * 
   * @param args command line arguments
   * @throws Exception
   */
  public static void main(String[] args) throws Exception {
    try {
      // =================================================================
      // Setup
      // =================================================================
      long accountId = SoapUtils.getAccountId();

      // =================================================================
      // BalanceService GET
      // =================================================================
      // create request.
      BalanceSelector selector = buildExampleGetRequest(accountId);

      // run
      get(selector);

    } catch (Exception e) {
      e.printStackTrace();
      throw e;
    }
  }

  /**
   * example get request.
   *
   * @param accountId long
   * @return BalanceSelector
   */
  public static BalanceSelector buildExampleGetRequest(long accountId) {
    BalanceSelector selector = new BalanceSelector();
    Paging paging = new Paging();
    paging.setStartIndex(1);
    paging.setNumberResults(20);
    selector.getAccountIds().add(accountId);
    selector.setPaging(paging);
    return selector;
  }

  /**
   * example get balance.
   *
   * @param selector BalanceSelector
   * @return List<BalanceValues>
   * @throws Exception
   */
  public static List<BalanceValues> get(BalanceSelector selector) throws Exception {

    // call API
    System.out.println("############################################");
    System.out.println("BalanceService::get");
    System.out.println("############################################");

    Holder<BalancePage> balancePageHolder = new Holder<BalancePage>();
    Holder<List<Error>> errorHolder = new Holder<List<Error>>();
    BalanceServiceInterface balanceService = SoapUtils.createServiceInterface(BalanceServiceInterface.class, BalanceService.class);
    balanceService.get(selector, balancePageHolder, errorHolder);

    SoapUtils.checkSoapError(errorHolder, balancePageHolder.value.getValues());

    // Response
    return balancePageHolder.value.getValues();
  }
}

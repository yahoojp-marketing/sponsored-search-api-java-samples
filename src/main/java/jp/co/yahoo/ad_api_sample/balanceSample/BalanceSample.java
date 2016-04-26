package jp.co.yahoo.ad_api_sample.balanceSample;

import java.util.List;

import javax.xml.ws.Holder;

import jp.co.yahoo.ad_api_sample.error.impl.BalanceServiceErrorEntityFactory;
import jp.co.yahoo.ad_api_sample.util.SoapUtils;
import jp.yahooapis.ss.V6.BalanceService.BalancePage;
import jp.yahooapis.ss.V6.BalanceService.BalanceSelector;
import jp.yahooapis.ss.V6.BalanceService.BalanceService;
import jp.yahooapis.ss.V6.BalanceService.BalanceServiceInterface;
import jp.yahooapis.ss.V6.BalanceService.BalanceValues;
import jp.yahooapis.ss.V6.BalanceService.Error;


/**
 * Sample Program for BalanceService. Copyright (C) 2012 Yahoo Japan Corporation. All Rights
 * Reserved.
 */
public class BalanceSample {

  /**
   * main method for BalanceSample
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
      // BalanceService::get
      // =================================================================
      // Set Selector
      BalanceSelector selector = new BalanceSelector();
      selector.getAccountIds().add(accountId);

      // Run
      get(selector);

    } catch (Exception e) {
      e.printStackTrace();
      throw e;
    }
  }

  /**
   * Sample Program for BalanceService GET.
   * 
   * @param selector BalanceSelector
   * @return BalanceValues
   * @throws Exception
   */
  public static List<BalanceValues> get(BalanceSelector selector) throws Exception {

    // call API
    System.out.println("############################################");
    System.out.println("BalanceService::get");
    System.out.println("############################################");

    Holder<BalancePage> balancePageHolder = new Holder<BalancePage>();
    Holder<List<Error>> balanceErrorHolder = new Holder<List<Error>>();
    BalanceServiceInterface balanceService = SoapUtils.createServiceInterface(BalanceServiceInterface.class, BalanceService.class);
    balanceService.get(selector, balancePageHolder, balanceErrorHolder);

    // Error
    if (balanceErrorHolder.value != null && balanceErrorHolder.value.size() > 0) {
      SoapUtils.displayErrors(new BalanceServiceErrorEntityFactory(balanceErrorHolder.value), true);
    }
    if (balanceErrorHolder.value == null) {
      throw new Exception("NoDataResponse:BalanceService Get");
    }

    // Display
    for (BalanceValues balanceValues : balancePageHolder.value.getValues()) {
      if (balanceValues.isOperationSucceeded()) {
        dispaly(balanceValues);
      } else {
        SoapUtils.displayErrors(new BalanceServiceErrorEntityFactory(balanceValues.getError()), true);
      }
    }

    // Response
    return balancePageHolder.value.getValues();
  }

  /**
   * display balance entity to stdout.
   *
   * @param values BidLandscape entity for display.
   */
  private static void dispaly(BalanceValues values) {
    System.out.println("accountId = " + values.getBalance().getAccountId());
    System.out.println("balance = " + values.getBalance().getBalance());
    System.out.println("---------");
  }
}

package jp.co.yahoo.ad_api_sample.balanceSample;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNull.notNullValue;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;

import java.util.List;

import jp.co.yahoo.ad_api_sample.util.SoapUtils;
import jp.yahooapis.ss.v201808.balance.BalanceSelector;
import jp.yahooapis.ss.v201808.balance.BalanceValues;

import org.junit.Before;
import org.junit.Test;

/**
 * Sample TestCase for BalanceSampleTest. Copyright (C) 2012 Yahoo Japan Corporation. All Rights
 * Reserved.
 */
public class BalanceSampleTest {

  /**
   * Setting
   */
  private long accountId;

  @Before
  public void setup() {
    accountId = SoapUtils.getAccountId();
  }

  /**
   * Sample TestCase of main method for BalanceSample.
   */
  @Test
  public void testMain() {
    // Run
    try {
      BalanceSample.main(null);
    } catch (Exception e) {
      fail();
    }
  }

  /**
   * Sample TestCase of get method for BalanceSample.
   */
  @Test
  public void testGet() {
    // Set Selector
    BalanceSelector selector = new BalanceSelector();
    selector.getAccountIds().add(accountId);

    // Run
    List<BalanceValues> balanceValues = null;
    try {
      balanceValues = BalanceSample.get(selector);
    } catch (Exception e) {
      fail();
    }

    // Assert
    for (BalanceValues balanceValue : balanceValues) {
      assertThat(balanceValue.isOperationSucceeded(), is(true));
      assertThat(balanceValue.getBalance().getAccountId(), is(notNullValue()));
    }
  }
}

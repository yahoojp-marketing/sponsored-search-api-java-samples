package jp.co.yahoo.ad_api_sample.accountTrackingUrlSample;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNull.notNullValue;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;

import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import jp.co.yahoo.ad_api_sample.accountTrackingUrlSample.AccountTrackingUrlSample;
import jp.co.yahoo.ad_api_sample.util.SoapUtils;
import jp.yahooapis.ss.v201805.accounttrackingurl.AccountTrackingUrl;
import jp.yahooapis.ss.v201805.accounttrackingurl.AccountTrackingUrlOperation;
import jp.yahooapis.ss.v201805.accounttrackingurl.AccountTrackingUrlSelector;
import jp.yahooapis.ss.v201805.accounttrackingurl.AccountTrackingUrlValues;
import jp.yahooapis.ss.v201805.accounttrackingurl.Operator;
import jp.yahooapis.ss.v201805.Paging;

/**
 * Sample TestCase for AccountTrackingUrlSampleTest. Copyright (C) 2012 Yahoo Japan Corporation. All Rights
 * Reserved.
 */
public class AccountTrackingUrlSampleTest {

  /**
   * Setting
   */
  private long accountId;

  @Before
  public void setup() {
    accountId = SoapUtils.getAccountId();
  }

  /**
   * Sample TestCase of main method for AccountSample.
   */
  @Test
  public void testMain() throws Exception {
    // Run
    try {
      AccountTrackingUrlSample.main(null);
    } catch (Exception e) {
      fail();
    }
  }

  /**
   * Sample TestCase of get method for AccountSample.
   */
  @Test
  public void testGet() throws Exception {
    // Set Selector
    AccountTrackingUrlSelector selector = new AccountTrackingUrlSelector();
    selector.getAccountIds().addAll(Arrays.asList(accountId));
    Paging paging = new Paging();
    paging.setStartIndex(1);
    paging.setNumberResults(20);
    selector.setPaging(paging);

    // Run
    List<AccountTrackingUrlValues> accountValues = null;
    try {
      accountValues = AccountTrackingUrlSample.get(selector);
    } catch (Exception e) {
      fail();
    }

    // Assert
    for (AccountTrackingUrlValues accountValue : accountValues) {
      assertThat(accountValue.isOperationSucceeded(), is(true));
      assertThat(accountValue.getAccountTrackingUrl().getAccountId(), is(notNullValue()));
    }
  }

  /**
   * Sample TestCase of set method for AccountSample.
   */
  @Test
  public void testSet() throws Exception {
    // Set Operation
    AccountTrackingUrlOperation operation = new AccountTrackingUrlOperation();
    operation.setOperator(Operator.SET);
    AccountTrackingUrl operand = new AccountTrackingUrl();
    operand.setAccountId(accountId);
    operand.setTrackingUrl("http://www.yahoo.co.jp?url={lpurl}&amp;id={_id1}");
    operation.getOperand().add(operand);
    
    // Run
    List<AccountTrackingUrlValues> accountTrackingUrlValues = null;
    try {
      accountTrackingUrlValues = AccountTrackingUrlSample.mutate(operation);
    } catch (Exception e) {
      fail();
    }

    // Assert
    for (AccountTrackingUrlValues accountTrackingUrlValue : accountTrackingUrlValues) {
      assertThat(accountTrackingUrlValue.isOperationSucceeded(), is(true));
      assertThat(accountTrackingUrlValue.getAccountTrackingUrl().getAccountId(), is(notNullValue()));
    }
  }
}

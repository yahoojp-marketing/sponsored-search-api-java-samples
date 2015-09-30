package jp.co.yahoo.ad_api_sample.accountSample;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNull.notNullValue;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;

import java.util.Arrays;
import java.util.List;

import jp.co.yahoo.ad_api_sample.util.SoapUtils;
import jp.yahooapis.ss.V5.AccountService.Account;
import jp.yahooapis.ss.V5.AccountService.AccountOperation;
import jp.yahooapis.ss.V5.AccountService.AccountSelector;
import jp.yahooapis.ss.V5.AccountService.AccountStatus;
import jp.yahooapis.ss.V5.AccountService.AccountType;
import jp.yahooapis.ss.V5.AccountService.AccountValues;
import jp.yahooapis.ss.V5.AccountService.DeliveryStatus;
import jp.yahooapis.ss.V5.AccountService.Operator;
import jp.yahooapis.ss.V5.AccountService.Paging;

import org.junit.Before;
import org.junit.Test;

/**
 * Sample TestCase for AccountSampleTest. Copyright (C) 2012 Yahoo Japan Corporation. All Rights
 * Reserved.
 */
public class AccountSampleTest {

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
      AccountSample.main(null);
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
    AccountSelector selector = new AccountSelector();
    selector.getAccountIds().add(new Long(accountId));
    selector.getAccountStatuses().addAll(Arrays.asList(AccountStatus.SERVING, AccountStatus.ENDED));
    selector.getAccountTypes().addAll(Arrays.asList(AccountType.INVOICE, AccountType.PREPAY));
    Paging paging = new Paging();
    paging.setStartIndex(1);
    paging.setNumberResults(20);
    selector.setPaging(paging);

    // Run
    List<AccountValues> accountValues = null;
    try {
      accountValues = AccountSample.get(selector);
    } catch (Exception e) {
      fail();
    }

    // Assert
    for (AccountValues accountValue : accountValues) {
      assertThat(accountValue.isOperationSucceeded(), is(true));
      assertThat(accountValue.getAccount().getAccountId(), is(notNullValue()));
    }
  }

  /**
   * Sample TestCase of set method for AccountSample.
   */
  @Test
  public void testSet() throws Exception {
    // Set Operation
    AccountOperation operation = new AccountOperation();
    operation.setOperator(Operator.SET);
    Account operand = new Account();
    operand.setAccountId(accountId);
    operand.setAccountName("SampleAccount_UpdateOn_" + SoapUtils.getCurrentTimestamp());
    operand.setDeliveryStatus(DeliveryStatus.PAUSED);
    operation.getOperand().add(operand);

    // Run
    List<AccountValues> accountValues = null;
    try {
      accountValues = AccountSample.set(operation);
    } catch (Exception e) {
      fail();
    }

    // Assert
    for (AccountValues accountValue : accountValues) {
      assertThat(accountValue.isOperationSucceeded(), is(true));
      assertThat(accountValue.getAccount().getAccountId(), is(notNullValue()));
    }
  }
}

package jp.co.yahoo.ad_api_sample.customerSyncSample;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNull.notNullValue;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;

import java.util.List;

import jp.co.yahoo.ad_api_sample.util.SoapUtils;
import jp.yahooapis.ss.V5.CustomerSyncService.Auditlog;
import jp.yahooapis.ss.V5.CustomerSyncService.ChangeDataValues;
import jp.yahooapis.ss.V5.CustomerSyncService.CustomerSyncSelector;
import jp.yahooapis.ss.V5.CustomerSyncService.DateRange;
import jp.yahooapis.ss.V5.CustomerSyncService.IncludeUnset;
import jp.yahooapis.ss.V5.CustomerSyncService.SourceType;

import org.junit.Before;
import org.junit.Test;

/**
 * Sample TestCase for CustomerSyncSampleTest. Copyright (C) 2012 Yahoo Japan Corporation. All
 * Rights Reserved.
 */
public class CustomerSyncSampleTest {

  /**
   * Setting
   */
  private long accountId;

  @Before
  public void setup() {
    accountId = SoapUtils.getAccountId();
  }

  /**
   * Sample TestCase of main method for CustomerSyncSample.
   */
  @Test
  public void testMain() throws Exception {
    // Run
    try {
      CustomerSyncSample.main(null);
    } catch (Exception e) {
      fail();
    }
  }

  /**
   * Sample TestCase of get method for CustomerSyncSample.
   */
  @Test
  public void testGet() throws Exception {
    // Set Selector(with accountIds)
    CustomerSyncSelector selector = new CustomerSyncSelector();
    selector.setAccountId(accountId);
    selector.getSourceTypes().add(SourceType.API);
    DateRange dateRange = new DateRange();
    dateRange.setStartDate("-4 day 00:00:00");
    dateRange.setEndDate("+0 day 00:00:00");
    dateRange.setIncludeUnset(IncludeUnset.INCLUDED);
    selector.setDateRange(dateRange);

    // Run
    List<ChangeDataValues> changeDataValues = null;
    try {
      changeDataValues = CustomerSyncSample.get(selector);
    } catch (Exception e) {
      fail();
    }

    // Assert
    for (ChangeDataValues changeDataValue : changeDataValues) {
      assertThat(changeDataValue.isOperationSucceeded(), is(true));
      for (Auditlog auditlog : changeDataValue.getAuditlog()) {
        assertThat(auditlog.getAccountId(), is(notNullValue()));
      }
    }
  }
}

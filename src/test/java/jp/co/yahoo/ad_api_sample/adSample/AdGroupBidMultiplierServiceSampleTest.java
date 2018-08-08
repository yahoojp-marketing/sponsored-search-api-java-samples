package jp.co.yahoo.ad_api_sample.adSample;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNull.notNullValue;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;

import java.util.List;

import jp.co.yahoo.ad_api_sample.util.SoapUtils;
import jp.yahooapis.ss.v201808.adgroupbidmultiplier.AdGroupBidMultiplierOperation;
import jp.yahooapis.ss.v201808.adgroupbidmultiplier.AdGroupBidMultiplierSelector;
import jp.yahooapis.ss.v201808.adgroupbidmultiplier.AdGroupBidMultiplierValues;

import org.junit.Before;
import org.junit.Test;

/**
 * Sample TestCase for AdGroupBidMultiplierServiceSampleTest. Copyright (C) 2012 Yahoo Japan
 * Corporation. All Rights Reserved.
 */
public class AdGroupBidMultiplierServiceSampleTest {

  /**
   * Setting
   */
  private long accountId;
  private long campaignId;
  private long adGroupId;

  @Before
  public void setup() {
    accountId = SoapUtils.getAccountId();
    campaignId = SoapUtils.getCampaignId();
    adGroupId = SoapUtils.getAdGroupId();
  }

  /**
   * Sample TestCase of main method for AdGroupBidMultiplierServiceSample.
   */
  @Test
  public void testMain() throws Exception {
    // Run
    try {
      AdGroupBidMultiplierServiceSample.main(null);
    } catch (Exception e) {
      fail();
    }
  }

  /**
   * Sample TestCase of set method for AdGroupBidMultiplierServiceSample.
   */
  @Test
  public void testSet() throws Exception {
    // Set Operation
    AdGroupBidMultiplierOperation adGroupBidMultiplierOperation = AdGroupBidMultiplierServiceSample.createSampleSetRequest(accountId, campaignId, adGroupId);

    // Run
    List<AdGroupBidMultiplierValues> adGroupBidMultiplierValues = null;
    try {
      adGroupBidMultiplierValues = AdGroupBidMultiplierServiceSample.set(adGroupBidMultiplierOperation);
    } catch (Exception e) {
      fail();
    }

    // Assert
    for (AdGroupBidMultiplierValues adGroupBidMultiplierValue : adGroupBidMultiplierValues) {
      assertThat(adGroupBidMultiplierValue.isOperationSucceeded(), is(true));
      assertThat(adGroupBidMultiplierValue.getAdGroupBidMultiplier().getAccountId(), is(notNullValue()));
    }
  }

  /**
   * Sample TestCase of get method for AdGroupBidMultiplierServiceSample.
   */
  @Test
  public void testGet() throws Exception {
    // Set Selector
    AdGroupBidMultiplierSelector adGroupBidMultiplierSelector = AdGroupBidMultiplierServiceSample.createSampleGetRequest(accountId, campaignId, adGroupId);

    // Run
    List<AdGroupBidMultiplierValues> adGroupBidMultiplierValues = null;
    try {
      adGroupBidMultiplierValues = AdGroupBidMultiplierServiceSample.get(adGroupBidMultiplierSelector);
    } catch (Exception e) {
      fail();
    }

    // Assert
    for (AdGroupBidMultiplierValues adGroupBidMultiplierValue : adGroupBidMultiplierValues) {
      assertThat(adGroupBidMultiplierValue.isOperationSucceeded(), is(true));
      assertThat(adGroupBidMultiplierValue.getAdGroupBidMultiplier().getAccountId(), is(notNullValue()));
    }
  }

  /**
   * Sample TestCase of remove method for AdGroupBidMultiplierServiceSample.
   */
  @Test
  public void testRemove() throws Exception {
    // Set Operation
    AdGroupBidMultiplierOperation adGroupBidMultiplierOperation = AdGroupBidMultiplierServiceSample.createSampleRemoveRequest(accountId, campaignId, adGroupId);

    // Run
    List<AdGroupBidMultiplierValues> adGroupBidMultiplierValues = null;
    try {
      adGroupBidMultiplierValues = AdGroupBidMultiplierServiceSample.remove(adGroupBidMultiplierOperation);
    } catch (Exception e) {
      fail();
    }

    // Assert
    for (AdGroupBidMultiplierValues adGroupBidMultiplierValue : adGroupBidMultiplierValues) {
      assertThat(adGroupBidMultiplierValue.isOperationSucceeded(), is(true));
      assertThat(adGroupBidMultiplierValue.getAdGroupBidMultiplier().getAccountId(), is(notNullValue()));
    }
  }
}

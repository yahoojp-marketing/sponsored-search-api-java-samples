package jp.co.yahoo.ad_api_sample.adSample;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNull.notNullValue;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;

import java.util.List;

import jp.co.yahoo.ad_api_sample.util.SoapUtils;
import jp.yahooapis.ss.V6.AdGroupService.AdGroupOperation;
import jp.yahooapis.ss.V6.AdGroupService.AdGroupValues;

import org.junit.Before;
import org.junit.Test;

/**
 * Sample TestCase for AdGroupServiceSampleTest. Copyright (C) 2012 Yahoo Japan Corporation. All
 * Rights Reserved.
 */
public class AdGroupServiceSampleTest {

  /**
   * Setting
   */
  private long accountId;
  private long campaignId;
  private long appCampaignId;
  private long biddingStrategyId;

  @Before
  public void setup() {
    accountId = SoapUtils.getAccountId();
    campaignId = SoapUtils.getCampaignId();
    appCampaignId = SoapUtils.getAppCampaignId();
    biddingStrategyId = SoapUtils.getBiddingStrategyId();
  }

  /**
   * Sample TestCase of main method for AdGroupServiceSample.
   */
  @Test
  public void testMain() throws Exception {
    // Run
    try {
      AdGroupServiceSample.main(null);
    } catch (Exception e) {
      fail();
    }
  }

  /**
   * Sample TestCase of add method for AdGroupServiceSample.
   */
  @Test
  public void testAdd() throws Exception {
    // Set Operation
    AdGroupOperation addAdGroupOperation = AdGroupServiceSample.createSampleAddRequest(accountId, campaignId, appCampaignId, biddingStrategyId);

    // Run
    List<AdGroupValues> addAdGroupValues = null;
    try {
      addAdGroupValues = AdGroupServiceSample.add(addAdGroupOperation);
    } catch (Exception e) {
      fail();
    }

    // Assert
    for (AdGroupValues adGroupValues : addAdGroupValues) {
      assertThat(adGroupValues.isOperationSucceeded(), is(true));
      assertThat(adGroupValues.getAdGroup().getAccountId(), is(notNullValue()));
    }

    clean(addAdGroupValues);
  }

  /**
   * Sample TestCase of set method for AdGroupServiceSample.
   */
  @Test
  public void testSet() throws Exception {
    // =================================================================
    // AdGroupService ADD
    // =================================================================
    List<AdGroupValues> addAdGroupValues = null;
    try {
      AdGroupOperation addAdGroupOperation = AdGroupServiceSample.createSampleAddRequest(accountId, campaignId, appCampaignId, biddingStrategyId);
      addAdGroupValues = AdGroupServiceSample.add(addAdGroupOperation);
    } catch (Exception e) {
      fail();
    }

    // =================================================================
    // AdGroupService SET
    // =================================================================
    // Set Operation
    AdGroupOperation setAdGroupOperation = AdGroupServiceSample.createSampleSetRequest(accountId, biddingStrategyId, addAdGroupValues);

    // Run
    List<AdGroupValues> setAdGroupValues = null;
    try {
      setAdGroupValues = AdGroupServiceSample.set(setAdGroupOperation);
    } catch (Exception e) {
      fail();
    }

    // Assert
    for (AdGroupValues adGroupValues : setAdGroupValues) {
      assertThat(adGroupValues.isOperationSucceeded(), is(true));
      assertThat(adGroupValues.getAdGroup().getAccountId(), is(notNullValue()));
    }

    clean(setAdGroupValues);
  }

  /**
   * Sample TestCase of remove method for AdGroupServiceSample.
   */
  @Test
  public void testRemove() throws Exception {
    // =================================================================
    // AdGroupService ADD
    // =================================================================
    List<AdGroupValues> addAdGroupValues = null;
    try {
      AdGroupOperation addAdGroupOperation = AdGroupServiceSample.createSampleAddRequest(accountId, campaignId, appCampaignId, biddingStrategyId);
      addAdGroupValues = AdGroupServiceSample.add(addAdGroupOperation);
    } catch (Exception e) {
      fail();
    }

    // =================================================================
    // AdGroupService REMOVE
    // =================================================================
    // Set Operation
    AdGroupOperation removeAdGroupOperation = AdGroupServiceSample.createSampleRemoveRequest(accountId, addAdGroupValues);

    // Run
    List<AdGroupValues> removeAdGroupValues = null;
    try {
      removeAdGroupValues = AdGroupServiceSample.set(removeAdGroupOperation);
    } catch (Exception e) {
      fail();
    }

    // Assert
    for (AdGroupValues adGroupValues : removeAdGroupValues) {
      assertThat(adGroupValues.isOperationSucceeded(), is(true));
      assertThat(adGroupValues.getAdGroup().getAccountId(), is(notNullValue()));
    }
  }

  /**
   * clean
   */
  public void clean(List<AdGroupValues> adGroupValues) {
    try {
      AdGroupOperation removeAdGroupOperation = AdGroupServiceSample.createSampleRemoveRequest(accountId, adGroupValues);
      AdGroupServiceSample.set(removeAdGroupOperation);
    } catch (Exception e) {
      fail();
    }
  }
}

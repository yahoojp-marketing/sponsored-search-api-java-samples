package jp.co.yahoo.ad_api_sample.dynamicAdsForSearchSample;

import jp.co.yahoo.ad_api_sample.util.SoapUtils;
import jp.yahooapis.ss.v201808.adgroupwebpage.AdGroupWebpageOperation;
import jp.yahooapis.ss.v201808.adgroupwebpage.AdGroupWebpageValues;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNull.notNullValue;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;

/**
 * Sample TestCase for AdGroupWebpageServiceSampleTest. Copyright (C) 2012 Yahoo Japan Corporation. All Rights Reserved.
 */
public class AdGroupWebpageServiceSampleTest {

  /**
   * Setting
   */
  private long accountId;
  private long dasFeedFolderId;
  private long dasCampaignId;
  private long dasAdGroupId;

  @Before
  public void setup() {
    accountId = SoapUtils.getAccountId();
    dasFeedFolderId = SoapUtils.getDasFeedFolderId();
    dasCampaignId = SoapUtils.getDasCampaignId();
    dasAdGroupId = SoapUtils.getDasAdGroupId();
  }

  /**
   * Sample TestCase of main method for AdGroupWebpageServiceSample.
   */
  @Test
  public void testMain() throws Exception {
    // Run
    try {
      AdGroupWebpageServiceSample.main(null);
    } catch (Exception e) {
      fail();
    }
  }

  /**
   * Sample TestCase of add method for AdGroupWebpageServiceSample.
   */
  @Test
  public void testAdd() throws Exception {
    // Set Operation
    AdGroupWebpageOperation addAdGroupWebpageOperation = AdGroupWebpageServiceSample.createSampleAddRequest(accountId, dasCampaignId, dasAdGroupId);

    // Run
    List<AdGroupWebpageValues> addAdGroupWebpageValues = null;
    try {
      addAdGroupWebpageValues = AdGroupWebpageServiceSample.add(addAdGroupWebpageOperation);
    } catch (Exception e) {
      fail();
    }

    // Assert
    for (AdGroupWebpageValues AdGroupWebpageValues : addAdGroupWebpageValues) {
      assertThat(AdGroupWebpageValues.isOperationSucceeded(), is(true));
      assertThat(AdGroupWebpageValues.getAdGroupWebpage().getAccountId(), is(notNullValue()));
    }

    clean(addAdGroupWebpageValues);
  }

  /**
   * Sample TestCase of set method for AdGroupWebpageServiceSample.
   */
  @Test
  public void testSet() throws Exception {
    // =================================================================
    // AdGroupWebpageService ADD
    // =================================================================
    List<AdGroupWebpageValues> addAdGroupWebpageValues = null;
    try {
      AdGroupWebpageOperation addAdGroupWebpageOperation = AdGroupWebpageServiceSample.createSampleAddRequest(accountId, dasCampaignId, dasAdGroupId);
      addAdGroupWebpageValues = AdGroupWebpageServiceSample.add(addAdGroupWebpageOperation);
    } catch (Exception e) {
      fail();
    }

    // =================================================================
    // AdGroupWebpageService SET
    // =================================================================
    // Set Operation
    AdGroupWebpageOperation setAdGroupWebpageOperation = AdGroupWebpageServiceSample.createSampleSetRequest(accountId, addAdGroupWebpageValues);

    // Run
    List<AdGroupWebpageValues> setAdGroupWebpageValues = null;
    try {
      setAdGroupWebpageValues = AdGroupWebpageServiceSample.set(setAdGroupWebpageOperation);
    } catch (Exception e) {
      fail();
    }

    // Assert
    for (AdGroupWebpageValues AdGroupWebpageValues : setAdGroupWebpageValues) {
      assertThat(AdGroupWebpageValues.isOperationSucceeded(), is(true));
      assertThat(AdGroupWebpageValues.getAdGroupWebpage().getAccountId(), is(notNullValue()));
    }

    clean(setAdGroupWebpageValues);
  }

  /**
   * Sample TestCase of remove method for AdGroupWebpageServiceSample.
   */
  @Test
  public void testRemove() throws Exception {
    // =================================================================
    // AdGroupWebpageService ADD
    // =================================================================
    List<AdGroupWebpageValues> addAdGroupWebpageValues = null;
    try {
      AdGroupWebpageOperation addAdGroupWebpageOperation = AdGroupWebpageServiceSample.createSampleAddRequest(accountId, dasCampaignId, dasAdGroupId);
      addAdGroupWebpageValues = AdGroupWebpageServiceSample.add(addAdGroupWebpageOperation);
    } catch (Exception e) {
      fail();
    }

    // =================================================================
    // AdGroupWebpageService REMOVE
    // =================================================================
    // Set Operation
    AdGroupWebpageOperation removeAdGroupWebpageOperation = AdGroupWebpageServiceSample.createSampleRemoveRequest(accountId, addAdGroupWebpageValues);

    // Run
    List<AdGroupWebpageValues> removeAdGroupWebpageValues = null;
    try {
      removeAdGroupWebpageValues = AdGroupWebpageServiceSample.remove(removeAdGroupWebpageOperation);
    } catch (Exception e) {
      fail();
    }

    // Assert
    for (AdGroupWebpageValues AdGroupWebpageValues : removeAdGroupWebpageValues) {
      assertThat(AdGroupWebpageValues.isOperationSucceeded(), is(true));
      assertThat(AdGroupWebpageValues.getAdGroupWebpage().getAccountId(), is(notNullValue()));
    }
  }


  /**
   * clean
   */
  public void clean(List<AdGroupWebpageValues> AdGroupWebpageValues) {
    try {
      AdGroupWebpageOperation removeAdGroupWebpageOperation = AdGroupWebpageServiceSample.createSampleRemoveRequest(accountId, AdGroupWebpageValues);
      AdGroupWebpageServiceSample.remove(removeAdGroupWebpageOperation);
    } catch (Exception e) {
      fail();
    }
  }
}

package jp.co.yahoo.ad_api_sample.adSample;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNull.notNullValue;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;

import java.util.List;

import jp.co.yahoo.ad_api_sample.util.SoapUtils;
import jp.yahooapis.ss.V5.CampaignTargetService.CampaignTargetOperation;
import jp.yahooapis.ss.V5.CampaignTargetService.CampaignTargetSelector;
import jp.yahooapis.ss.V5.CampaignTargetService.CampaignTargetValues;
import jp.yahooapis.ss.V5.CampaignTargetService.Paging;

import org.junit.Before;
import org.junit.Test;

/**
 * Sample TestCase for CampaignTargetServiceSampleTest. Copyright (C) 2012 Yahoo Japan Corporation.
 * All Rights Reserved.
 */
public class CampaignTargetServiceSampleTest {

  /**
   * Setting
   */
  private long accountId;
  private long campaignId;

  @Before
  public void setup() {
    accountId = SoapUtils.getAccountId();
    campaignId = SoapUtils.getCampaignId();
  }

  /**
   * Sample TestCase of main method for CampaignTargetServiceSample.
   */
  @Test
  public void testMain() throws Exception {
    // Run
    try {
      CampaignTargetServiceSample.main(null);
    } catch (Exception e) {
      fail();
    }
  }

  /**
   * Sample TestCase of add method for CampaignTargetServiceSample.
   */
  @Test
  public void testAdd() throws Exception {
    // Set Operation
    CampaignTargetOperation addCampaignTargetOperation = CampaignTargetServiceSample.createSampleAddRequest(accountId, campaignId);

    // Run
    List<CampaignTargetValues> addCampaignTargetValues = null;
    try {
      addCampaignTargetValues = CampaignTargetServiceSample.add(addCampaignTargetOperation);
    } catch (Exception e) {
      fail();
    }

    // Assert
    for (CampaignTargetValues campaignTargetValue : addCampaignTargetValues) {
      assertThat(campaignTargetValue.isOperationSucceeded(), is(true));
      assertThat(campaignTargetValue.getCampaignTarget().getAccountId(), is(notNullValue()));
    }

    // Clean
    clean(addCampaignTargetValues);
  }

  /**
   * Sample TestCase of set method for CampaignTargetServiceSample.
   */
  @Test
  public void testSet() throws Exception {
    // =================================================================
    // CampaignTargetService::ADD
    // =================================================================
    List<CampaignTargetValues> addCampaignTargetValues = null;
    CampaignTargetOperation addCampaignTargetOperation = CampaignTargetServiceSample.createSampleAddRequest(accountId, campaignId);
    try {
      addCampaignTargetValues = CampaignTargetServiceSample.add(addCampaignTargetOperation);
    } catch (Exception e) {
      fail();
    }

    // =================================================================
    // CampaignTargetService::SET
    // =================================================================
    // Set Operation
    CampaignTargetOperation setCampaignTargetOperation = CampaignTargetServiceSample.createSampleSetRequest(accountId, addCampaignTargetValues);

    // Run
    List<CampaignTargetValues> setCampaignTargetValues = null;
    try {
      setCampaignTargetValues = CampaignTargetServiceSample.set(setCampaignTargetOperation);
    } catch (Exception e) {
      fail();
    }

    // Assert
    for (CampaignTargetValues campaignTargetValue : setCampaignTargetValues) {
      assertThat(campaignTargetValue.isOperationSucceeded(), is(true));
      assertThat(campaignTargetValue.getCampaignTarget().getAccountId(), is(notNullValue()));
    }

    // Clean
    clean(setCampaignTargetValues);
  }

  /**
   * Sample TestCase of remove method for CampaignTargetServiceSample.
   */
  @Test
  public void testRemove() throws Exception {
    // =================================================================
    // CampaignTargetService::ADD
    // =================================================================
    List<CampaignTargetValues> addCampaignTargetValues = null;
    try {
      CampaignTargetOperation addCampaignTargetOperation = CampaignTargetServiceSample.createSampleAddRequest(accountId, campaignId);
      addCampaignTargetValues = CampaignTargetServiceSample.add(addCampaignTargetOperation);
    } catch (Exception e) {
      fail();
    }

    // =================================================================
    // CampaignTargetService::REMOVE
    // =================================================================
    // Set Operation
    CampaignTargetOperation removeCampaignTargetOperation = CampaignTargetServiceSample.createSampleRemoveRequest(accountId, addCampaignTargetValues);

    // Run
    List<CampaignTargetValues> removeCampaignTargetValues = null;
    try {
      removeCampaignTargetValues = CampaignTargetServiceSample.remove(removeCampaignTargetOperation);
    } catch (Exception e) {
      fail();
    }

    // Assert
    for (CampaignTargetValues campaignTargetValue : removeCampaignTargetValues) {
      assertThat(campaignTargetValue.isOperationSucceeded(), is(true));
      assertThat(campaignTargetValue.getCampaignTarget().getAccountId(), is(notNullValue()));
    }
  }

  /**
   * Sample TestCase of get method for CampaignTargetServiceSample.
   */
  @Test
  public void testGet() throws Exception {
    // Set Selector
    CampaignTargetSelector campaignTargetSelector = new CampaignTargetSelector();
    campaignTargetSelector.setAccountId(accountId);
    Paging paging = new Paging();
    paging.setStartIndex(1);
    paging.setNumberResults(20);
    campaignTargetSelector.setPaging(paging);

    // Run
    List<CampaignTargetValues> getCampaignTargetValues = null;
    try {
      getCampaignTargetValues = CampaignTargetServiceSample.get(campaignTargetSelector);
    } catch (Exception e) {
      fail();
    }

    // Assert
    for (CampaignTargetValues campaignTargetValue : getCampaignTargetValues) {
      assertThat(campaignTargetValue.isOperationSucceeded(), is(true));
      assertThat(campaignTargetValue.getCampaignTarget().getAccountId(), is(notNullValue()));
    }
  }

  /**
   * clean
   */
  public void clean(List<CampaignTargetValues> campaignTargetValues) {
    try {
      CampaignTargetOperation removeCampaignTargetOperation = CampaignTargetServiceSample.createSampleRemoveRequest(accountId, campaignTargetValues);
      CampaignTargetServiceSample.remove(removeCampaignTargetOperation);
    } catch (Exception e) {
      fail();
    }
  }
}

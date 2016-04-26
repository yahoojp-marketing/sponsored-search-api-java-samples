package jp.co.yahoo.ad_api_sample.adSample;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNull.notNullValue;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;

import java.util.List;

import jp.co.yahoo.ad_api_sample.util.SoapUtils;
import jp.yahooapis.ss.V6.CampaignCriterionService.CampaignCriterionOperation;
import jp.yahooapis.ss.V6.CampaignCriterionService.CampaignCriterionSelector;
import jp.yahooapis.ss.V6.CampaignCriterionService.CampaignCriterionValues;
import jp.yahooapis.ss.V6.CampaignCriterionService.CriterionUse;
import jp.yahooapis.ss.V6.CampaignCriterionService.Paging;

import org.junit.Before;
import org.junit.Test;

/**
 * Sample TestCase for CampaignCriterionServiceSampleTest. Copyright (C) 2012 Yahoo Japan
 * Corporation. All Rights Reserved.
 */
public class CampaignCriterionServiceSampleTest {

  /**
   * Setting
   */
  private long accountId;
  long campaignId;

  @Before
  public void setup() {
    accountId = SoapUtils.getAccountId();
    campaignId = SoapUtils.getCampaignId();
  }

  /**
   * Sample TestCase of main method for CampaignCriterionServiceSample.
   */
  @Test
  public void testMain() throws Exception {
    // Run
    try {
      CampaignCriterionServiceSample.main(null);
    } catch (Exception e) {
      fail();
    }
  }

  /**
   * Sample TestCase of add method for CampaignCriterionServiceSample.
   */
  @Test
  public void testAdd() throws Exception {
    // Set Operation
    CampaignCriterionOperation addCampaignCriterionOperation = CampaignCriterionServiceSample.createSampleAddRequest(accountId, campaignId);

    // Run
    List<CampaignCriterionValues> campaignCriterionValues = null;
    try {
      campaignCriterionValues = CampaignCriterionServiceSample.add(addCampaignCriterionOperation);
    } catch (Exception e) {
      fail();
    }

    // Assert
    for (CampaignCriterionValues campaignCriterionValue : campaignCriterionValues) {
      assertThat(campaignCriterionValue.isOperationSucceeded(), is(true));
      assertThat(campaignCriterionValue.getCampaignCriterion().getAccountId(), is(notNullValue()));
    }

    // clean
    clean(campaignCriterionValues);
  }

  /**
   * Sample TestCase of remove method for CampaignCriterionServiceSample.
   */
  @Test
  public void testRemove() throws Exception {
    // =================================================================
    // CampaignCriterionService ADD
    // =================================================================
    List<CampaignCriterionValues> campaignCriterionValues = null;
    try {
      CampaignCriterionOperation addCampaignCriterionOperation = CampaignCriterionServiceSample.createSampleAddRequest(accountId, campaignId);
      campaignCriterionValues = CampaignCriterionServiceSample.add(addCampaignCriterionOperation);
    } catch (Exception e) {
      fail();
    }

    // =================================================================
    // CampaignCriterionService REMOVE
    // =================================================================
    // Set Operation
    CampaignCriterionOperation removeCampaignCriterionOperation = CampaignCriterionServiceSample.createSampleRemoveRequest(accountId, campaignId, campaignCriterionValues);

    // Run
    List<CampaignCriterionValues> removeCampaignCriterionValues = null;
    try {
      removeCampaignCriterionValues = CampaignCriterionServiceSample.remove(removeCampaignCriterionOperation);
    } catch (Exception e) {
      fail();
    }

    // Assert
    for (CampaignCriterionValues campaignCriterionValue : removeCampaignCriterionValues) {
      assertThat(campaignCriterionValue.isOperationSucceeded(), is(true));
      assertThat(campaignCriterionValue.getCampaignCriterion().getAccountId(), is(notNullValue()));
    }
  }

  /**
   * Sample TestCase of get method for CampaignCriterionServiceSample.
   */
  @Test
  public void testGet() throws Exception {
    // Set Selector
    CampaignCriterionSelector campaignCriterionSelector = new CampaignCriterionSelector();
    campaignCriterionSelector.setAccountId(accountId);
    campaignCriterionSelector.getCampaignIds().add(campaignId);
    campaignCriterionSelector.setCriterionUse(CriterionUse.NEGATIVE);
    Paging paging = new Paging();
    paging.setStartIndex(1);
    paging.setNumberResults(20);
    campaignCriterionSelector.setPaging(paging);

    // Run
    List<CampaignCriterionValues> getCampaignCriterionValues = null;
    try {
      getCampaignCriterionValues = CampaignCriterionServiceSample.get(campaignCriterionSelector);
    } catch (Exception e) {
      fail();
    }

    // Assert
    for (CampaignCriterionValues campaignCriterionValue : getCampaignCriterionValues) {
      assertThat(campaignCriterionValue.isOperationSucceeded(), is(true));
      assertThat(campaignCriterionValue.getCampaignCriterion().getAccountId(), is(notNullValue()));
    }
  }

  /**
   * clean
   */
  public void clean(List<CampaignCriterionValues> campaignCriterionValues) {
    try {
      CampaignCriterionOperation removeCampaignCriterionOperation = CampaignCriterionServiceSample.createSampleRemoveRequest(accountId, campaignId, campaignCriterionValues);
      CampaignCriterionServiceSample.remove(removeCampaignCriterionOperation);
    } catch (Exception e) {
      fail();
    }
  }
}

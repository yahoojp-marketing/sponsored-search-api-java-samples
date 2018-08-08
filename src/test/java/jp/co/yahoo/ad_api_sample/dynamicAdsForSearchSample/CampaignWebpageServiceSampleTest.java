package jp.co.yahoo.ad_api_sample.dynamicAdsForSearchSample;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

import jp.co.yahoo.ad_api_sample.util.SoapUtils;
import jp.yahooapis.ss.v201808.campaignwebpage.CampaignWebpageOperation;
import jp.yahooapis.ss.v201808.campaignwebpage.CampaignWebpageValues;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNull.notNullValue;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;

/**
 * Sample TestCase for CampaignWebpageServiceSampleTest. Copyright (C) 2012 Yahoo Japan Corporation. All Rights Reserved.
 */
public class CampaignWebpageServiceSampleTest {

  /**
   * Setting
   */
  private long accountId;
  private long dasFeedFolderId;
  private long dasCampaignId;

  @Before
  public void setup() {
    accountId = SoapUtils.getAccountId();
    dasFeedFolderId = SoapUtils.getDasFeedFolderId();
    dasCampaignId = SoapUtils.getDasCampaignId();
  }

  /**
   * Sample TestCase of main method for CampaignWebpageServiceSample.
   */
  @Test
  public void testMain() throws Exception {
    // Run
    try {
      CampaignWebpageServiceSample.main(null);
    } catch (Exception e) {
      fail();
    }
  }

  /**
   * Sample TestCase of add method for CampaignWebpageServiceSample.
   */
  @Test
  public void testAdd() throws Exception {
    // Set Operation
    CampaignWebpageOperation addCampaignWebpageOperation = CampaignWebpageServiceSample.createSampleAddRequest(accountId, dasCampaignId);

    // Run
    List<CampaignWebpageValues> addCampaignWebpageValues = null;
    try {
      addCampaignWebpageValues = CampaignWebpageServiceSample.add(addCampaignWebpageOperation);
    } catch (Exception e) {
      fail();
    }

    // Assert
    for (CampaignWebpageValues CampaignWebpageValues : addCampaignWebpageValues) {
      assertThat(CampaignWebpageValues.isOperationSucceeded(), is(true));
      assertThat(CampaignWebpageValues.getCampaignWebpage().getAccountId(), is(notNullValue()));
    }

    clean(addCampaignWebpageValues);
  }

  /**
   * Sample TestCase of remove method for CampaignWebpageServiceSample.
   */
  @Test
  public void testRemove() throws Exception {
    // =================================================================
    // CampaignWebpageService ADD
    // =================================================================
    List<CampaignWebpageValues> addCampaignWebpageValues = null;
    try {
      CampaignWebpageOperation addCampaignWebpageOperation = CampaignWebpageServiceSample.createSampleAddRequest(accountId, dasCampaignId);
      addCampaignWebpageValues = CampaignWebpageServiceSample.add(addCampaignWebpageOperation);
    } catch (Exception e) {
      fail();
    }

    // =================================================================
    // CampaignWebpageService REMOVE
    // =================================================================
    // Set Operation
    CampaignWebpageOperation removeCampaignWebpageOperation = CampaignWebpageServiceSample.createSampleRemoveRequest(accountId, addCampaignWebpageValues);

    // Run
    List<CampaignWebpageValues> removeCampaignWebpageValues = null;
    try {
      removeCampaignWebpageValues = CampaignWebpageServiceSample.remove(removeCampaignWebpageOperation);
    } catch (Exception e) {
      fail();
    }

    // Assert
    for (CampaignWebpageValues CampaignWebpageValues : removeCampaignWebpageValues) {
      assertThat(CampaignWebpageValues.isOperationSucceeded(), is(true));
      assertThat(CampaignWebpageValues.getCampaignWebpage().getAccountId(), is(notNullValue()));
    }
  }


  /**
   * clean
   */
  public void clean(List<CampaignWebpageValues> CampaignWebpageValues) {
    try {
      CampaignWebpageOperation removeCampaignWebpageOperation = CampaignWebpageServiceSample.createSampleRemoveRequest(accountId, CampaignWebpageValues);
      CampaignWebpageServiceSample.remove(removeCampaignWebpageOperation);
    } catch (Exception e) {
      fail();
    }
  }
}

package jp.co.yahoo.ad_api_sample.siteRetargetingSample;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNull.notNullValue;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

import jp.co.yahoo.ad_api_sample.util.SoapUtils;
import jp.yahooapis.ss.V6.CampaignRetargetingListService.CampaignRetargetingListOperation;
import jp.yahooapis.ss.V6.CampaignRetargetingListService.CampaignRetargetingListSelector;
import jp.yahooapis.ss.V6.CampaignRetargetingListService.CampaignRetargetingListValues;
import jp.yahooapis.ss.V6.CampaignRetargetingListService.ExcludedType;

/**
 * Sample TestCase for CampaignRetargetingListServiceSample. Copyright (C) 2012 Yahoo Japan
 * Corporation. All Rights Reserved.
 */
public class CampaignRetargetingListServiceSampleTest {

  /**
   * Setting
   */
  private long accountId;
  private long campaignId;
  private long targetListId;

  @Before
  public void setup() {
    accountId = SoapUtils.getAccountId();
    campaignId = SoapUtils.getCampaignId();
    targetListId = SoapUtils.getTargetListId();

  }

  /**
   * Sample TestCase of main method for CampaignRetargetingListServiceSample.
   */
  @Test
  public void testMain() throws Exception {
    // Run
    try {
      CampaignRetargetingListServiceSample.main(null);
    } catch (Exception e) {
      fail();
    }
  }

  /**
   * Sample TestCase of add method for CampaignRetargetingListServiceSample.
   */
  @Test
  public void testAdd() throws Exception {
    // =================================================================
    // eCampaignRetargetingListService::mutate(ADD)
    // =================================================================
    CampaignRetargetingListOperation operation = CampaignRetargetingListServiceSample.createSampleAddRequest(accountId, campaignId, targetListId, ExcludedType.INCLUDED, 1.0d);

    // Run
    List<CampaignRetargetingListValues> campaignRetargetingListValues = null;
    try {
      campaignRetargetingListValues = CampaignRetargetingListServiceSample.add(operation);
    } catch (Exception e) {
      fail();
    }

    // Assert
    for (CampaignRetargetingListValues campaignRetargetingListValue : campaignRetargetingListValues) {
      assertThat(campaignRetargetingListValue.isOperationSucceeded(), is(true));
      assertThat(campaignRetargetingListValue.getCampaignRetargetingList().getAccountId(), is(notNullValue()));
    }

    clean(ExcludedType.INCLUDED);
  }

  /**
   * Sample TestCase of get method for CampaignRetargetingListServiceSample.
   */
  @Test
  public void testGet() throws Exception {
    // =================================================================
    // CampaignRetargetingListService::mutate(ADD)
    // =================================================================
    CampaignRetargetingListOperation addOperation = CampaignRetargetingListServiceSample.createSampleAddRequest(accountId, campaignId, targetListId, ExcludedType.INCLUDED, 1.0d);

    // Run
    try {
      CampaignRetargetingListServiceSample.add(addOperation);
    } catch (Exception e) {
      fail();
    }

    // =================================================================
    // CampaignRetargetingListService::get
    // =================================================================
    // Set Selector
    CampaignRetargetingListSelector selector = CampaignRetargetingListServiceSample.createSampleGetRequest(accountId, campaignId, targetListId);

    // Run
    List<CampaignRetargetingListValues> getResponse = null;
    try {
      getResponse = CampaignRetargetingListServiceSample.get(selector);
    } catch (Exception e) {
      fail();
    }

    // Assert
    for (CampaignRetargetingListValues campaignRetargetingListValue : getResponse) {
      assertThat(campaignRetargetingListValue.isOperationSucceeded(), is(true));
      assertThat(campaignRetargetingListValue.getCampaignRetargetingList().getAccountId(), is(notNullValue()));
    }

    clean(ExcludedType.INCLUDED);
  }

  /**
   * Sample TestCase of get method for CampaignRetargetingListServiceSample.
   */
  @Test
  public void testRemove() throws Exception {
    // =================================================================
    // CampaignRetargetingListService::mutate(ADD)
    // =================================================================
    CampaignRetargetingListOperation addOperation = CampaignRetargetingListServiceSample.createSampleAddRequest(accountId, campaignId, targetListId, ExcludedType.INCLUDED, 1.0d);

    // Run
    try {
      CampaignRetargetingListServiceSample.add(addOperation);
    } catch (Exception e) {
      fail();
    }

    // =================================================================
    // CampaignRetargetingListService::mutate(REMOVE)
    // =================================================================
    // Set Operation
    CampaignRetargetingListOperation removeOperation = CampaignRetargetingListServiceSample.createSampleRemoveRequest(accountId, campaignId, targetListId, ExcludedType.INCLUDED);

    // Run
    List<CampaignRetargetingListValues> removeResponse = null;
    try {
      removeResponse = CampaignRetargetingListServiceSample.remove(removeOperation);
    } catch (Exception e) {
      fail();
    }

    // Assert
    for (CampaignRetargetingListValues campaignRetargetingListValue : removeResponse) {
      assertThat(campaignRetargetingListValue.isOperationSucceeded(), is(true));
      assertThat(campaignRetargetingListValue.getCampaignRetargetingList().getAccountId(), is(notNullValue()));
    }
  }

  /**
   * clean
   */
  public void clean(ExcludedType excludedType) {
    try {
      CampaignRetargetingListOperation removeOperation = CampaignRetargetingListServiceSample.createSampleRemoveRequest(accountId, campaignId, targetListId, excludedType);
      CampaignRetargetingListServiceSample.remove(removeOperation);

    } catch (Exception e) {
      fail();
    }
  }
}

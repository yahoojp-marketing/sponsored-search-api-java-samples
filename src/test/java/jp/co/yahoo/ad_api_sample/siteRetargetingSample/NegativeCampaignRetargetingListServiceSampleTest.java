package jp.co.yahoo.ad_api_sample.siteRetargetingSample;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNull.notNullValue;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

import jp.co.yahoo.ad_api_sample.util.SoapUtils;
import jp.yahooapis.ss.V5.NegativeCampaignRetargetingListService.NegativeCampaignRetargetingListOperation;
import jp.yahooapis.ss.V5.NegativeCampaignRetargetingListService.NegativeCampaignRetargetingListSelector;
import jp.yahooapis.ss.V5.NegativeCampaignRetargetingListService.NegativeCampaignRetargetingListValues;

/**
 * Sample TestCase for NegativeCampaignRetargetingListServiceSample. Copyright (C) 2012 Yahoo Japan
 * Corporation. All Rights Reserved.
 */
public class NegativeCampaignRetargetingListServiceSampleTest {

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
   * Sample TestCase of main method for NegativeCampaignRetargetingListServiceSample.
   */
  @Test
  public void testMain() throws Exception {
    // Run
    try {
      NegativeCampaignRetargetingListServiceSample.main(null);
    } catch (Exception e) {
      fail();
    }
  }

  /**
   * Sample TestCase of add method for NegativeCampaignRetargetingListServiceSample.
   */
  @Test
  public void testAdd() throws Exception {
    // =================================================================
    // NegativeCampaignRetargetingListService::mutate(ADD)
    // =================================================================
    NegativeCampaignRetargetingListOperation operation = NegativeCampaignRetargetingListServiceSample.createSampleAddRequest(accountId, campaignId, targetListId);

    // Run
    List<NegativeCampaignRetargetingListValues> negativeCampaignRetargetingListValues = null;
    try {
      negativeCampaignRetargetingListValues = NegativeCampaignRetargetingListServiceSample.add(operation);
    } catch (Exception e) {
      fail();
    }

    // Assert
    for (NegativeCampaignRetargetingListValues negativeCampaignRetargetingListValue : negativeCampaignRetargetingListValues) {
      assertThat(negativeCampaignRetargetingListValue.isOperationSucceeded(), is(true));
      assertThat(negativeCampaignRetargetingListValue.getNegativeCampaignRetargetingList().getAccountId(), is(notNullValue()));
    }

    clean();
  }

  /**
   * Sample TestCase of get method for NegativeCampaignRetargetingListServiceSample.
   */
  @Test
  public void testGet() throws Exception {
    // =================================================================
    // NegativeCampaignRetargetingListService::mutate(ADD)
    // =================================================================
    NegativeCampaignRetargetingListOperation addOperation = NegativeCampaignRetargetingListServiceSample.createSampleAddRequest(accountId, campaignId, targetListId);

    // Run
    try {
      NegativeCampaignRetargetingListServiceSample.add(addOperation);
    } catch (Exception e) {
      fail();
    }

    // =================================================================
    // NegativeCampaignRetargetingListService::get
    // =================================================================
    // Set Selector
    NegativeCampaignRetargetingListSelector selector = NegativeCampaignRetargetingListServiceSample.createSampleGetRequest(accountId, campaignId, targetListId);

    // Run
    List<NegativeCampaignRetargetingListValues> getResponse = null;
    try {
      getResponse = NegativeCampaignRetargetingListServiceSample.get(selector);
    } catch (Exception e) {
      fail();
    }

    // Assert
    for (NegativeCampaignRetargetingListValues negativeCampaignRetargetingListValue : getResponse) {
      assertThat(negativeCampaignRetargetingListValue.isOperationSucceeded(), is(true));
      assertThat(negativeCampaignRetargetingListValue.getNegativeCampaignRetargetingList().getAccountId(), is(notNullValue()));
    }

    clean();
  }

  /**
   * Sample TestCase of get method for NegativeCampaignRetargetingListServiceSample.
   */
  @Test
  public void testRemove() throws Exception {
    // =================================================================
    // NegativeCampaignRetargetingListService::mutate(ADD)
    // =================================================================
    NegativeCampaignRetargetingListOperation addOperation = NegativeCampaignRetargetingListServiceSample.createSampleAddRequest(accountId, campaignId, targetListId);

    // Run
    try {
      NegativeCampaignRetargetingListServiceSample.add(addOperation);
    } catch (Exception e) {
      fail();
    }

    // =================================================================
    // NegativeCampaignRetargetingListService::mutate(REMOVE)
    // =================================================================
    // Set Operation
    NegativeCampaignRetargetingListOperation removeOperation = NegativeCampaignRetargetingListServiceSample.createSampleRemoveRequest(accountId, campaignId, targetListId);

    // Run
    List<NegativeCampaignRetargetingListValues> removeResponse = null;
    try {
      removeResponse = NegativeCampaignRetargetingListServiceSample.remove(removeOperation);
    } catch (Exception e) {
      fail();
    }

    // Assert
    for (NegativeCampaignRetargetingListValues negativeCampaignRetargetingListValue : removeResponse) {
      assertThat(negativeCampaignRetargetingListValue.isOperationSucceeded(), is(true));
      assertThat(negativeCampaignRetargetingListValue.getNegativeCampaignRetargetingList().getAccountId(), is(notNullValue()));
    }
  }

  /**
   * clean
   */
  public void clean() {
    try {
      NegativeCampaignRetargetingListOperation removeOperation = NegativeCampaignRetargetingListServiceSample.createSampleRemoveRequest(accountId, campaignId, targetListId);
      NegativeCampaignRetargetingListServiceSample.remove(removeOperation);
    } catch (Exception e) {
      fail();
    }
  }
}

package jp.co.yahoo.ad_api_sample.siteRetargetingSample;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNull.notNullValue;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

import jp.co.yahoo.ad_api_sample.util.SoapUtils;
import jp.yahooapis.ss.V6.AdGroupRetargetingListService.AdGroupRetargetingListOperation;
import jp.yahooapis.ss.V6.AdGroupRetargetingListService.AdGroupRetargetingListSelector;
import jp.yahooapis.ss.V6.AdGroupRetargetingListService.AdGroupRetargetingListValues;

/**
 * Sample TestCase for AdGroupRetargetingListServiceSample. Copyright (C) 2012 Yahoo Japan Corporation. All
 * Rights Reserved.
 */
public class AdGroupRetargetingListServiceSampleTest {

  /**
   * Setting
   */
  private long accountId;
  private long campaignId;
  private long targetListId;
  private long adGroupId;

  @Before
  public void setup() {
    accountId = SoapUtils.getAccountId();
    campaignId = SoapUtils.getCampaignId();
    targetListId = SoapUtils.getTargetListId();
    adGroupId = SoapUtils.getAdGroupId();
  }

  /**
   * Sample TestCase of main method for AdGroupRetargetingListServiceSample.
   */
  @Test
  public void testMain() throws Exception {
    // Run
    try {
      AdGroupRetargetingListServiceSample.main(null);
    } catch (Exception e) {
      fail();
    }
  }

  /**
   * Sample TestCase of add method for AdGroupRetargetingListServiceSample.
   */
  @Test
  public void testAdd() throws Exception {
    // =================================================================
    // AdGroupRetargetingListService::mutate(ADD)
    // =================================================================
    AdGroupRetargetingListOperation operation = AdGroupRetargetingListServiceSample.createSampleAddRequest(accountId, campaignId, targetListId, adGroupId);

    // Run
    List<AdGroupRetargetingListValues> adGroupRetargetingListValues = null;
    try {
      adGroupRetargetingListValues = AdGroupRetargetingListServiceSample.add(operation);
    } catch (Exception e) {
      fail();
    }

    // Assert
    for (AdGroupRetargetingListValues adGroupRetargetingListValue : adGroupRetargetingListValues) {
      assertThat(adGroupRetargetingListValue.isOperationSucceeded(), is(true));
      assertThat(adGroupRetargetingListValue.getAdGroupRetargetingList().getAccountId(), is(notNullValue()));
    }

    clean(adGroupRetargetingListValues);
  }

  /**
   * Sample TestCase of get method for AdGroupRetargetingListServiceSample.
   */
  @Test
  public void testGet() throws Exception {
    // =================================================================
    // AdGroupRetargetingListService::mutate(ADD)
    // =================================================================
    AdGroupRetargetingListOperation addOperation = AdGroupRetargetingListServiceSample.createSampleAddRequest(accountId, campaignId, targetListId, adGroupId);

    // Run
    List<AdGroupRetargetingListValues> addResponse = null;
    try {
      addResponse = AdGroupRetargetingListServiceSample.add(addOperation);
    } catch (Exception e) {
      fail();
    }

    // =================================================================
    // AdGroupRetargetingListService::get
    // =================================================================
    // Set Selector
    AdGroupRetargetingListSelector selector = AdGroupRetargetingListServiceSample.createSampleGetRequest(accountId, campaignId, targetListId, adGroupId);

    // Run
    List<AdGroupRetargetingListValues> getResponse = null;
    try {
      getResponse = AdGroupRetargetingListServiceSample.get(selector);
    } catch (Exception e) {
      fail();
    }

    // Assert
    for (AdGroupRetargetingListValues adGroupRetargetingListValue : getResponse) {
      assertThat(adGroupRetargetingListValue.isOperationSucceeded(), is(true));
      assertThat(adGroupRetargetingListValue.getAdGroupRetargetingList().getAccountId(), is(notNullValue()));
    }

    clean(addResponse);
  }

  /**
   * Sample TestCase of get method for AdGroupRetargetingListServiceSample.
   */
  @Test
  public void testRemove() throws Exception {
    // =================================================================
    // AdGroupRetargetingListService::mutate(ADD)
    // =================================================================
    AdGroupRetargetingListOperation addOperation = AdGroupRetargetingListServiceSample.createSampleAddRequest(accountId, campaignId, targetListId, adGroupId);

    // Run
    List<AdGroupRetargetingListValues> addResponse = null;
    try {
      addResponse = AdGroupRetargetingListServiceSample.add(addOperation);
    } catch (Exception e) {
      fail();
    }

    // =================================================================
    // AdGroupRetargetingListService::mutate(REMOVE)
    // =================================================================
    // Set Operation
    AdGroupRetargetingListOperation removeOperation = AdGroupRetargetingListServiceSample.createSampleRemoveRequest(accountId, addResponse);

    // Run
    List<AdGroupRetargetingListValues> removeResponse = null;
    try {
      removeResponse = AdGroupRetargetingListServiceSample.remove(removeOperation);
    } catch (Exception e) {
      fail();
    }

    // Assert
    for (AdGroupRetargetingListValues adGroupRetargetingListValue : removeResponse) {
      assertThat(adGroupRetargetingListValue.isOperationSucceeded(), is(true));
      assertThat(adGroupRetargetingListValue.getAdGroupRetargetingList().getAccountId(), is(notNullValue()));
    }
  }

  /**
   * clean
   */
  public void clean(List<AdGroupRetargetingListValues> adGroupRetargetingListValuesList) {
    try {
      AdGroupRetargetingListOperation removeOperation = AdGroupRetargetingListServiceSample.createSampleRemoveRequest(accountId, adGroupRetargetingListValuesList);
      AdGroupRetargetingListServiceSample.remove(removeOperation);
    } catch (Exception e) {
      fail();
    }
  }
}

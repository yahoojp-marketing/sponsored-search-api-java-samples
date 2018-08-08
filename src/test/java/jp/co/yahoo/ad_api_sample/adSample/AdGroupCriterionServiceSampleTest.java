package jp.co.yahoo.ad_api_sample.adSample;

import jp.co.yahoo.ad_api_sample.util.SoapUtils;
import jp.yahooapis.ss.v201808.adgroupcriterion.AdGroupCriterionOperation;
import jp.yahooapis.ss.v201808.adgroupcriterion.AdGroupCriterionSelector;
import jp.yahooapis.ss.v201808.adgroupcriterion.AdGroupCriterionUse;
import jp.yahooapis.ss.v201808.adgroupcriterion.AdGroupCriterionValues;
import jp.yahooapis.ss.v201808.adgroupcriterion.ApprovalStatus;
import jp.yahooapis.ss.v201808.Paging;
import jp.yahooapis.ss.v201808.adgroupcriterion.UserStatus;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNull.notNullValue;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;

/**
 * Sample TestCase for AdGroupCriterionServiceSampleTest. Copyright (C) 2012 Yahoo Japan
 * Corporation. All Rights Reserved.
 */
public class AdGroupCriterionServiceSampleTest {

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
   * Sample TestCase of main method for AdGroupCriterionServiceSample.
   */
  @Test
  public void testMain() throws Exception {
    // Run
    try {
      AdGroupCriterionServiceSample.main(null);
    } catch (Exception e) {
      fail();
    }
  }

  /**
   * Sample TestCase of add method for AdGroupCriterionServiceSample.
   */
  @Test
  public void testAdd() throws Exception {
    // Set Operation
    AdGroupCriterionOperation adGroupCriterionOperation = AdGroupCriterionServiceSample.createSampleAddRequest(accountId, campaignId, adGroupId);

    // Run
    List<AdGroupCriterionValues> addAdGroupCriterionValues = null;
    try {
      addAdGroupCriterionValues = AdGroupCriterionServiceSample.add(adGroupCriterionOperation);
    } catch (Exception e) {
      fail();
    }

    // Assert
    for (AdGroupCriterionValues adGroupCriterionValue : addAdGroupCriterionValues) {
      assertThat(adGroupCriterionValue.isOperationSucceeded(), is(true));
      assertThat(adGroupCriterionValue.getAdGroupCriterion().getAccountId(), is(notNullValue()));
    }

    clean(addAdGroupCriterionValues);
  }

  /**
   * Sample TestCase of set method for AdGroupCriterionServiceSample.
   */
  @Test
  public void testSet() throws Exception {
    // =================================================================
    // CampaignService::ADD
    // =================================================================
    List<AdGroupCriterionValues> addAdGroupCriterionValues = null;
    try {
      AdGroupCriterionOperation adGroupCriterionOperation = AdGroupCriterionServiceSample.createSampleAddRequest(accountId, campaignId, adGroupId);
      addAdGroupCriterionValues = AdGroupCriterionServiceSample.add(adGroupCriterionOperation);
    } catch (Exception e) {
      fail();
    }

    // =================================================================
    // CampaignService::SET
    // =================================================================
    // Set Operation
    AdGroupCriterionOperation setAdGroupCriterionOperation = AdGroupCriterionServiceSample.createSampleSetRequest(accountId, campaignId, adGroupId, addAdGroupCriterionValues);

    // Run
    List<AdGroupCriterionValues> setAdGroupCriterionValues = null;
    try {
      setAdGroupCriterionValues = AdGroupCriterionServiceSample.set(setAdGroupCriterionOperation);
    } catch (Exception e) {
      fail();
    }

    // Assert
    for (AdGroupCriterionValues adGroupCriterionValue : setAdGroupCriterionValues) {
      assertThat(adGroupCriterionValue.isOperationSucceeded(), is(true));
      assertThat(adGroupCriterionValue.getAdGroupCriterion().getAccountId(), is(notNullValue()));
    }

    clean(setAdGroupCriterionValues);
  }

  /**
   * Sample TestCase of remove method for AdGroupCriterionServiceSample.
   */
  @Test
  public void testRemove() throws Exception {
    // =================================================================
    // CampaignService::ADD
    // =================================================================
    List<AdGroupCriterionValues> addAdGroupCriterionValues = null;
    try {
      AdGroupCriterionOperation adGroupCriterionOperation = AdGroupCriterionServiceSample.createSampleAddRequest(accountId, campaignId, adGroupId);
      addAdGroupCriterionValues = AdGroupCriterionServiceSample.add(adGroupCriterionOperation);
    } catch (Exception e) {
      fail();
    }

    // =================================================================
    // CampaignService::REMOVE
    // =================================================================
    // Set Operation
    AdGroupCriterionOperation removeAdGroupCriterionOperation = AdGroupCriterionServiceSample.createSampleRemoveRequest(accountId, campaignId, adGroupId, addAdGroupCriterionValues);

    // Run
    List<AdGroupCriterionValues> removeAdGroupCriterionValues = null;
    try {
      removeAdGroupCriterionValues = AdGroupCriterionServiceSample.remove(removeAdGroupCriterionOperation);
    } catch (Exception e) {
      fail();
    }

    // Assert
    for (AdGroupCriterionValues adGroupCriterionValue : removeAdGroupCriterionValues) {
      assertThat(adGroupCriterionValue.isOperationSucceeded(), is(true));
      assertThat(adGroupCriterionValue.getAdGroupCriterion().getAccountId(), is(notNullValue()));
    }
  }

  /**
   * Sample TestCase of get method for AdGroupCriterionServiceSample.
   */
  @Test
  public void testGet() throws Exception {
    // Set Selector
    AdGroupCriterionSelector selector = new AdGroupCriterionSelector();
    selector.setAccountId(accountId);
    selector.getCampaignIds().add(campaignId);
    selector.getAdGroupIds().add(adGroupId);
    selector.getUserStatuses().addAll(Arrays.asList(UserStatus.ACTIVE, UserStatus.PAUSED));
    selector.setCriterionUse(AdGroupCriterionUse.BIDDABLE);
    selector.getApprovalStatuses().addAll(
        Arrays.asList(ApprovalStatus.APPROVED, ApprovalStatus.APPROVED_WITH_REVIEW, ApprovalStatus.REVIEW, ApprovalStatus.POST_DISAPPROVED, ApprovalStatus.PRE_DISAPPROVED));
    Paging paging = new Paging();
    paging.setStartIndex(1);
    paging.setNumberResults(20);
    selector.setPaging(paging);

    // Run
    List<AdGroupCriterionValues> getAdGroupCriterionValues = null;
    try {
      getAdGroupCriterionValues = AdGroupCriterionServiceSample.get(selector);
    } catch (Exception e) {
      fail();
    }

    // Assert
    for (AdGroupCriterionValues adGroupCriterionValue : getAdGroupCriterionValues) {
      assertThat(adGroupCriterionValue.isOperationSucceeded(), is(true));
      assertThat(adGroupCriterionValue.getAdGroupCriterion().getAccountId(), is(notNullValue()));
    }
  }

  /**
   * clean
   */
  public void clean(List<AdGroupCriterionValues> adGroupCriterionValues) {
    try {
      AdGroupCriterionOperation removeAdGroupCriterionOperation = AdGroupCriterionServiceSample.createSampleRemoveRequest(accountId, campaignId, adGroupId, adGroupCriterionValues);
      AdGroupCriterionServiceSample.remove(removeAdGroupCriterionOperation);
    } catch (Exception e) {
    }
  }
}

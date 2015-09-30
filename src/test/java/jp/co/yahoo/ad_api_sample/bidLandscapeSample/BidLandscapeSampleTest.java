package jp.co.yahoo.ad_api_sample.bidLandscapeSample;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNull.notNullValue;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;

import java.util.List;

import jp.co.yahoo.ad_api_sample.util.SoapUtils;
import jp.yahooapis.ss.V5.BidLandscapeService.BidLandscapeSelector;
import jp.yahooapis.ss.V5.BidLandscapeService.BidLandscapeValues;
import jp.yahooapis.ss.V5.BidLandscapeService.SimType;

import org.junit.Before;
import org.junit.Test;

/**
 * Sample TestCase for BidLandscapeSampleTest. Copyright (C) 2012 Yahoo Japan Corporation. All
 * Rights Reserved.
 */
public class BidLandscapeSampleTest {

  /**
   * Setting
   */
  private long accountId;
  private long campaignId;
  private long adGroupId;
  List<Long> adGroupCriterionIds;

  @Before
  public void setup() {
    accountId = SoapUtils.getAccountId();
    campaignId = SoapUtils.getCampaignId();
    adGroupId = SoapUtils.getAdGroupId();
    adGroupCriterionIds = SoapUtils.getAdGroupCriterionIds();
  }

  /**
   * Sample TestCase of main method for BidLandscapeSample.
   */
  @Test
  public void testMain() {
    // Run
    try {
      BidLandscapeSample.main(null);
    } catch (Exception e) {
      fail();
    }
  }

  /**
   * Sample TestCase of get method for BidLandscapeSample.
   */
  @Test
  public void testGet() {
    // Set Selector
    BidLandscapeSelector selector = new BidLandscapeSelector();
    selector.setAccountId(accountId);
    selector.setCampaignId(campaignId);
    selector.setAdGroupId(adGroupId);
    if (adGroupCriterionIds != null && adGroupCriterionIds.size() > 0) {
      selector.getCriterionIds().addAll(adGroupCriterionIds);
      selector.setSimType(SimType.CRITERION);
    } else {
      selector.setSimType(SimType.ADGROUP);
    }

    // Run
    List<BidLandscapeValues> bidLandscapeValues = null;
    try {
      bidLandscapeValues = BidLandscapeSample.get(selector);
    } catch (Exception e) {
      fail();
    }

    // Assert
    for (BidLandscapeValues bidLandscapeValue : bidLandscapeValues) {
      assertThat(bidLandscapeValue.isOperationSucceeded(), is(true));
      assertThat(bidLandscapeValue.getData().getCampaignId(), is(notNullValue()));
      assertThat(bidLandscapeValue.getData().getAdGroupId(), is(notNullValue()));
    }
  }
}

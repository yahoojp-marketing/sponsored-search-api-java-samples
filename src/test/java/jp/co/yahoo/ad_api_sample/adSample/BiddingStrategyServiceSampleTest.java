package jp.co.yahoo.ad_api_sample.adSample;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNull.notNullValue;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;

import java.util.Arrays;
import java.util.List;

import jp.co.yahoo.ad_api_sample.util.SoapUtils;
import jp.yahooapis.ss.V6.BiddingStrategyService.BiddingStrategyOperation;
import jp.yahooapis.ss.V6.BiddingStrategyService.BiddingStrategySelector;
import jp.yahooapis.ss.V6.BiddingStrategyService.BiddingStrategyType;
import jp.yahooapis.ss.V6.BiddingStrategyService.BiddingStrategyValues;
import jp.yahooapis.ss.V6.BiddingStrategyService.Paging;

import org.junit.Before;
import org.junit.Test;

/**
 * Sample TestCase for BiddingStrategyServiceSampleTest. Copyright (C) 2012 Yahoo Japan Corporation.
 * All Rights Reserved.
 */
public class BiddingStrategyServiceSampleTest {

  /**
   * Setting
   */
  private long accountId;

  @Before
  public void setup() {
    accountId = SoapUtils.getAccountId();
  }

  /**
   * Sample TestCase of main method for BiddingStrategyServiceSample.
   */
  @Test
  public void testMain() throws Exception {
    // Run
    try {
      BiddingStrategyServiceSample.main(null);
    } catch (Exception e) {
      fail();
    }
  }

  /**
   * Sample TestCase of add method for BiddingStrategyServiceSample.
   */
  @Test
  public void testAdd() throws Exception {
    // Set Operation
    BiddingStrategyOperation addBiddingStrategyOperation = BiddingStrategyServiceSample.createSampleAddRequest(accountId);

    // Run
    List<BiddingStrategyValues> biddingStrategyValues = null;
    try {
      biddingStrategyValues = BiddingStrategyServiceSample.add(addBiddingStrategyOperation);
    } catch (Exception e) {
      fail();
    }

    // Assert
    for (BiddingStrategyValues biddingStrategyValue : biddingStrategyValues) {
      assertThat(biddingStrategyValue.isOperationSucceeded(), is(true));
      assertThat(biddingStrategyValue.getBiddingStrategy().getAccountId(), is(notNullValue()));
    }
  }

  /**
   * Sample TestCase of set method for BiddingStrategyServiceSample.
   */
  @Test
  public void testSet() throws Exception {
    // =================================================================
    // BiddingStrategyService::ADD
    // =================================================================
    List<BiddingStrategyValues> biddingStrategyValues = null;
    try {
      BiddingStrategyOperation addBiddingStrategyOperation = BiddingStrategyServiceSample.createSampleAddRequest(accountId);
      biddingStrategyValues = BiddingStrategyServiceSample.add(addBiddingStrategyOperation);
    } catch (Exception e) {
      fail();
    }

    // =================================================================
    // BiddingStrategyService::SET
    // =================================================================
    // Set Operation
    BiddingStrategyOperation setBiddingStrategyOperation = BiddingStrategyServiceSample.createSampleSetRequest(accountId, biddingStrategyValues);

    // Run
    List<BiddingStrategyValues> setBiddingStrategyValues = null;
    try {
      setBiddingStrategyValues = BiddingStrategyServiceSample.set(setBiddingStrategyOperation);
    } catch (Exception e) {
      fail();
    }

    // Assert
    for (BiddingStrategyValues biddingStrategyValue : setBiddingStrategyValues) {
      assertThat(biddingStrategyValue.isOperationSucceeded(), is(true));
      assertThat(biddingStrategyValue.getBiddingStrategy().getAccountId(), is(notNullValue()));
    }
  }

  /**
   * Sample TestCase of remove method for BiddingStrategyServiceSample.
   */
  @Test
  public void testRemove() throws Exception {
    // =================================================================
    // BiddingStrategyService::ADD
    // =================================================================
    List<BiddingStrategyValues> biddingStrategyValues = null;
    try {
      BiddingStrategyOperation addBiddingStrategyOperation = BiddingStrategyServiceSample.createSampleAddRequest(accountId);
      biddingStrategyValues = BiddingStrategyServiceSample.add(addBiddingStrategyOperation);
    } catch (Exception e) {
      fail();
    }

    // =================================================================
    // BiddingStrategyService::REMOVE
    // =================================================================
    // Set Operation
    BiddingStrategyOperation removeBiddingStrategyOperation = BiddingStrategyServiceSample.createSampleRemoveRequest(accountId, biddingStrategyValues);

    // Run
    List<BiddingStrategyValues> removeBiddingStrategyValues = null;
    try {
      removeBiddingStrategyValues = BiddingStrategyServiceSample.remove(removeBiddingStrategyOperation);
    } catch (Exception e) {
      fail();
    }

    // Assert
    for (BiddingStrategyValues biddingStrategyValue : removeBiddingStrategyValues) {
      assertThat(biddingStrategyValue.isOperationSucceeded(), is(true));
      assertThat(biddingStrategyValue.getBiddingStrategy().getAccountId(), is(notNullValue()));
    }
  }

  /**
   * Sample TestCase of get method for BiddingStrategyServiceSample.
   */
  @Test
  public void testGet() throws Exception {
    // Set Selector
    BiddingStrategySelector biddingStrategySelector = new BiddingStrategySelector();
    biddingStrategySelector.setAccountId(accountId);
    biddingStrategySelector.getBiddingStrategyTypes().addAll(
        Arrays.asList(BiddingStrategyType.ENHANCED_CPC, BiddingStrategyType.PAGE_ONE_PROMOTED, BiddingStrategyType.TARGET_CPA, BiddingStrategyType.TARGET_SPEND, BiddingStrategyType.TARGET_ROAS));
    Paging paging = new Paging();
    paging.setStartIndex(1);
    paging.setNumberResults(20);
    biddingStrategySelector.setPaging(paging);

    // Run
    List<BiddingStrategyValues> getBiddingStrategyValues = null;
    try {
      getBiddingStrategyValues = BiddingStrategyServiceSample.get(biddingStrategySelector);
    } catch (Exception e) {
      fail();
    }

    // Assert
    for (BiddingStrategyValues biddingStrategyValue : getBiddingStrategyValues) {
      assertThat(biddingStrategyValue.isOperationSucceeded(), is(true));
      assertThat(biddingStrategyValue.getBiddingStrategy().getAccountId(), is(notNullValue()));
    }
  }
}

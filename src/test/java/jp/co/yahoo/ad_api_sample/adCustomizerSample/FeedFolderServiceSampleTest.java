package jp.co.yahoo.ad_api_sample.adCustomizerSample;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNull.notNullValue;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;

import java.util.List;

import jp.co.yahoo.ad_api_sample.util.SoapUtils;
import jp.yahooapis.ss.V6.FeedFolderService.FeedFolderOperation;
import jp.yahooapis.ss.V6.FeedFolderService.FeedFolderSelector;
import jp.yahooapis.ss.V6.FeedFolderService.FeedFolderValues;
import jp.yahooapis.ss.V6.FeedFolderService.Paging;

import org.junit.Before;
import org.junit.Test;

/**
 * Sample TestCase for FeedFolderServiceSampleTest. Copyright (C) 2012 Yahoo Japan Corporation. All
 * Rights Reserved.
 */
public class FeedFolderServiceSampleTest {

  /**
   * Setting
   */
  private long accountId;

  @Before
  public void setup() {
    accountId = SoapUtils.getAccountId();
  }

  /**
   * Sample TestCase of main method for FeedFolderServiceSample.
   */
  @Test
  public void testMain() throws Exception {
    // Run
    try {
      FeedFolderServiceSample.main(null);
    } catch (Exception e) {
      fail();
    }
  }

  /**
   * Sample TestCase of add method for FeedFolderServiceSample.
   */
  @Test
  public void testAdd() throws Exception {
    // Set Operation
    FeedFolderOperation addFeedFolderOperation = FeedFolderServiceSample.createSampleAddRequest(accountId);

    // Run
    List<FeedFolderValues> addFeedFolderValues = null;
    try {
      addFeedFolderValues = FeedFolderServiceSample.add(addFeedFolderOperation);
    } catch (Exception e) {
      fail();
    }

    // Assert
    for (FeedFolderValues feedFolderValues : addFeedFolderValues) {
      assertThat(feedFolderValues.isOperationSucceeded(), is(true));
      assertThat(feedFolderValues.getFeedFolder().getAccountId(), is(notNullValue()));
    }

    // clean(addFeedFolderValues);
  }

  /**
   * Sample TestCase of set method for FeedFolderServiceSample.
   */
  @Test
  public void testSet() throws Exception {
    // =================================================================
    // FeedFolderService ADD
    // =================================================================
    List<FeedFolderValues> addFeedFolderValues = null;
    try {
      FeedFolderOperation addFeedFolderOperation = FeedFolderServiceSample.createSampleAddRequest(accountId);
      addFeedFolderValues = FeedFolderServiceSample.add(addFeedFolderOperation);
    } catch (Exception e) {
      fail();
    }

    // =================================================================
    // FeefFolderService SET
    // =================================================================
    // Set Operation
    FeedFolderOperation setFeedFolderOperation = FeedFolderServiceSample.createSampleSetRequest(accountId, addFeedFolderValues);

    // Run
    List<FeedFolderValues> setFeedFolderValues = null;
    try {
      setFeedFolderValues = FeedFolderServiceSample.set(setFeedFolderOperation);
    } catch (Exception e) {
      fail();
    }

    // Assert
    for (FeedFolderValues feedFolderValues : setFeedFolderValues) {
      assertThat(feedFolderValues.isOperationSucceeded(), is(true));
      assertThat(feedFolderValues.getFeedFolder().getAccountId(), is(notNullValue()));
    }

    clean(setFeedFolderValues);
  }

  /**
   * Sample TestCase of remove method for FeedFolderServiceSample.
   */
  @Test
  public void testRemoev() throws Exception {
    // =================================================================
    // FeedFolderService ADD
    // =================================================================
    List<FeedFolderValues> addFeedFolderValues = null;
    try {
      FeedFolderOperation addFeedFolderOperation = FeedFolderServiceSample.createSampleAddRequest(accountId);
      addFeedFolderValues = FeedFolderServiceSample.add(addFeedFolderOperation);
    } catch (Exception e) {
      fail();
    }

    // =================================================================
    // FeefFolderService REMOVE
    // =================================================================
    // Set Operation
    FeedFolderOperation removeFeedFolderOperation = FeedFolderServiceSample.createSampleRemoveRequest(accountId, addFeedFolderValues);

    // Run
    List<FeedFolderValues> removeFeedFolderValues = null;
    try {
      removeFeedFolderValues = FeedFolderServiceSample.remove(removeFeedFolderOperation);
    } catch (Exception e) {
      fail();
    }

    // Assert
    for (FeedFolderValues feedFolderValues : removeFeedFolderValues) {
      assertThat(feedFolderValues.isOperationSucceeded(), is(true));
      assertThat(feedFolderValues.getFeedFolder().getAccountId(), is(notNullValue()));
    }
  }

  /**
   * Sample TestCase of get method for FeedFolderServiceSample.
   */
  @Test
  public void testGet() throws Exception {
    // Set Selector
    FeedFolderSelector selector = new FeedFolderSelector();
    selector.setAccountId(accountId);
    Paging paging = new Paging();
    paging.setStartIndex(1);
    paging.setNumberResults(20);
    selector.setPaging(paging);

    // Run
    List<FeedFolderValues> getFeedFolderValues = null;
    try {
      getFeedFolderValues = FeedFolderServiceSample.get(selector);
    } catch (Exception e) {
      fail();
    }

    // Assert
    for (FeedFolderValues feedFolderValues : getFeedFolderValues) {
      assertThat(feedFolderValues.isOperationSucceeded(), is(true));
      assertThat(feedFolderValues.getFeedFolder().getAccountId(), is(notNullValue()));
    }
  }

  /**
   * clean
   */
  public void clean(List<FeedFolderValues> feedFolderValues) {
    try {
      FeedFolderOperation removeFeedFolderOperation = FeedFolderServiceSample.createSampleRemoveRequest(accountId, feedFolderValues);
      FeedFolderServiceSample.remove(removeFeedFolderOperation);
    } catch (Exception e) {
      fail();
    }
  }
}

package jp.co.yahoo.ad_api_sample.adCustomizerSample;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNull.notNullValue;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import jp.co.yahoo.ad_api_sample.util.SoapUtils;
import jp.yahooapis.ss.V5.FeedItemService.ApprovalStatus;
import jp.yahooapis.ss.V5.FeedItemService.FeedItemOperation;
import jp.yahooapis.ss.V5.FeedItemService.FeedItemSelector;
import jp.yahooapis.ss.V5.FeedItemService.FeedItemValues;
import jp.yahooapis.ss.V5.FeedItemService.Paging;
import jp.yahooapis.ss.V5.FeedItemService.PlaceholderType;

import org.junit.Before;
import org.junit.Test;

/**
 * Sample TestCase for FeedItemServiceSampleTest. Copyright (C) 2012 Yahoo Japan Corporation. All
 * Rights Reserved.
 */
public class FeedItemServiceSampleTest {

  /**
   * Setting
   */
  private long accountId;
  private long campaignId;
  private long adGroupId;
  private long feedFolderId;
  private Map<String, Long> feedAttributeIds;

  @Before
  public void setup() {
    accountId = SoapUtils.getAccountId();
    campaignId = SoapUtils.getCampaignId();
    adGroupId = SoapUtils.getAdGroupId();
    feedFolderId = SoapUtils.getFeedFolderId();
    feedAttributeIds = new HashMap<String, Long>();
    feedAttributeIds.put("AD_CUSTOMIZER_INTEGER", SoapUtils.getIntegerFeedAttributeId());
    feedAttributeIds.put("AD_CUSTOMIZER_PRICE", SoapUtils.getPriceFeedAttributeId());
    feedAttributeIds.put("AD_CUSTOMIZER_DATE", SoapUtils.getDateFeedAttributeId());
    feedAttributeIds.put("AD_CUSTOMIZER_STRING", SoapUtils.getStringFeedAttributeId());
  }

  /**
   * Sample TestCase of main method for FeedItemServiceSample.
   */
  @Test
  public void testMain() throws Exception {
    // Run
    try {
      FeedItemServiceSample.main(null);
    } catch (Exception e) {
      fail();
    }
  }

  /**
   * Sample TestCase of add method for FeedItemServiceSample.
   */
  @Test
  public void testAdd() throws Exception {
    // Set Operation
    FeedItemOperation addFeedItemOperation = FeedItemServiceSample.createSampleAddRequest(accountId, campaignId, adGroupId, feedFolderId, feedAttributeIds);

    // Run
    List<FeedItemValues> addFeedItemValues = null;
    try {
      addFeedItemValues = FeedItemServiceSample.add(addFeedItemOperation);
    } catch (Exception e) {
      fail();
    }

    // Assert
    for (FeedItemValues feedItemValues : addFeedItemValues) {
      assertThat(feedItemValues.isOperationSucceeded(), is(true));
      assertThat(feedItemValues.getFeedItem().getAccountId(), is(notNullValue()));
    }

    clean(addFeedItemValues);
  }

  /**
   * Sample TestCase of set method for FeedItemServiceSample.
   */
  @Test
  public void testSet() throws Exception {
    // =================================================================
    // FeedItemService ADD
    // =================================================================
    List<FeedItemValues> addFeedItemValues = null;
    try {
      FeedItemOperation addFeedItemOperation = FeedItemServiceSample.createSampleAddRequest(accountId, campaignId, adGroupId, feedFolderId, feedAttributeIds);
      addFeedItemValues = FeedItemServiceSample.add(addFeedItemOperation);
    } catch (Exception e) {
      fail();
    }

    // wait for sandbox review
    Thread.sleep(20000);

    // =================================================================
    // FeefItemService SET
    // =================================================================
    // Set Operation
    FeedItemOperation setFeedItemOperation = FeedItemServiceSample.createSampleSetRequest(accountId, addFeedItemValues);

    // Run
    List<FeedItemValues> setFeedItemValues = null;
    try {
      setFeedItemValues = FeedItemServiceSample.set(setFeedItemOperation);
    } catch (Exception e) {
      fail();
    }

    // Assert
    for (FeedItemValues feedItemValues : setFeedItemValues) {
      assertThat(feedItemValues.isOperationSucceeded(), is(true));
      assertThat(feedItemValues.getFeedItem().getAccountId(), is(notNullValue()));
    }

    clean(setFeedItemValues);
  }

  /**
   * Sample TestCase of remove method for FeedItemServiceSample.
   */
  @Test
  public void testRemove() throws Exception {
    // =================================================================
    // FeedItemService ADD
    // =================================================================
    List<FeedItemValues> addFeedItemValues = null;
    try {
      FeedItemOperation addFeedItemOperation = FeedItemServiceSample.createSampleAddRequest(accountId, campaignId, adGroupId, feedFolderId, feedAttributeIds);
      addFeedItemValues = FeedItemServiceSample.add(addFeedItemOperation);
    } catch (Exception e) {
      fail();
    }

    // wait for sandbox review
    Thread.sleep(20000);

    // =================================================================
    // FeefItemService REMOVE
    // =================================================================
    // Set Operation
    FeedItemOperation removeFeedItemOperation = FeedItemServiceSample.createSampleRemoveRequest(accountId, addFeedItemValues);

    // Run
    List<FeedItemValues> removeFeedItemValues = null;
    try {
      removeFeedItemValues = FeedItemServiceSample.remove(removeFeedItemOperation);
    } catch (Exception e) {
      fail();
    }

    // Assert
    for (FeedItemValues feedItemValues : removeFeedItemValues) {
      assertThat(feedItemValues.isOperationSucceeded(), is(true));
      assertThat(feedItemValues.getFeedItem().getAccountId(), is(notNullValue()));
    }
  }

  /**
   * Sample TestCase of get method for FeedItemServiceSample.
   */
  @Test
  public void testGet() throws Exception {
    // Set Selector
    FeedItemSelector selector = new FeedItemSelector();
    selector.setAccountId(accountId);
    selector.getPlaceholderTypes().add(PlaceholderType.QUICKLINK);
    selector.getPlaceholderTypes().add(PlaceholderType.CALLEXTENSION);
    selector.getPlaceholderTypes().add(PlaceholderType.AD_CUSTOMIZER);
    selector.getApprovalStatuses().add(ApprovalStatus.APPROVED);
    selector.getApprovalStatuses().add(ApprovalStatus.REVIEW);
    selector.getApprovalStatuses().add(ApprovalStatus.PRE_DISAPPROVED);
    selector.getApprovalStatuses().add(ApprovalStatus.APPROVED_WITH_REVIEW);
    selector.getApprovalStatuses().add(ApprovalStatus.POST_DISAPPROVED);
    Paging feedItemPaging = new Paging();
    feedItemPaging.setStartIndex(1);
    feedItemPaging.setNumberResults(20);
    selector.setPaging(feedItemPaging);

    // Run
    List<FeedItemValues> getFeedItemValues = null;
    try {
      getFeedItemValues = FeedItemServiceSample.get(selector);
    } catch (Exception e) {
      fail();
    }

    // Assert
    for (FeedItemValues feedItemValues : getFeedItemValues) {
      assertThat(feedItemValues.isOperationSucceeded(), is(true));
      assertThat(feedItemValues.getFeedItem().getAccountId(), is(notNullValue()));
    }
  }

  /**
   * clean
   */
  public void clean(List<FeedItemValues> feedItemValues) throws Exception {
    try {
      // wait for sandbox review
      Thread.sleep(20000);
      FeedItemOperation removeFeedItemOperation = FeedItemServiceSample.createSampleRemoveRequest(accountId, feedItemValues);
      FeedItemServiceSample.remove(removeFeedItemOperation);
    } catch (Exception e) {
      fail();
    }
  }
}

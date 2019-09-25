/**
 * Copyright (C) 2019 Yahoo Japan Corporation. All Rights Reserved.
 */
package jp.yahooapis.ss.adapisample.repository;

import jp.yahooapis.ss.adapisample.util.ValuesHolder;
import jp.yahooapis.ss.v201909.feeditem.FeedItem;
import jp.yahooapis.ss.v201909.feeditem.FeedItemPlaceholderType;
import jp.yahooapis.ss.v201909.feeditem.FeedItemValues;

import java.util.ArrayList;
import java.util.List;

/**
 * Utility method collection for Java Sample Program.
 */
public class FeedItemValuesRepository {

  private ValuesHolder valuesHolder;

  /**
   * FeedItemValuesRepository constructor.
   *
   * @param valuesHolder ValuesHolder
   */
  public FeedItemValuesRepository(ValuesHolder valuesHolder) {
    this.valuesHolder = valuesHolder;
  }

  /**
   * @return FeedItems
   */
  public List<FeedItem> getFeedItems(){
    List<FeedItem> feedItems = new ArrayList<>();
    if (this.valuesHolder.getFeedItemValuesList().size() == 0) {
      return feedItems;
    }
    for (FeedItemValues value : this.valuesHolder.getFeedItemValuesList()) {
      feedItems.add(value.getFeedItem());
    }
    return feedItems;
  }
  /**
   * @return feedItemIds
   */
  public List<Long> getFeedItemIds(){
    List<Long> feedItemIds = new ArrayList<>();
    if (this.valuesHolder.getFeedItemValuesList().size() == 0) {
      return feedItemIds;
    }
    for (FeedItemValues value : this.valuesHolder.getFeedItemValuesList()) {
      feedItemIds.add(value.getFeedItem().getFeedItemId());
    }
    return feedItemIds;
  }

  /**
   * @param feedItemPlaceholderType FeedItemPlaceholderType
   * @return FeedItem
   */
  public FeedItem findFeedItem(FeedItemPlaceholderType feedItemPlaceholderType) {
    if (this.valuesHolder.getFeedItemValuesList().size() == 0) {
      return null;
    }
    for (FeedItemValues values : this.valuesHolder.getFeedItemValuesList()) {
      if (values.getFeedItem().getPlaceholderType().equals(feedItemPlaceholderType)) {
        return values.getFeedItem();
      }
    }
    return null;
  }

  /**
   * @param feedItemPlaceholderType feedItemPlaceholderType
   * @return Long|null
   */
  public Long findFeedItemId(FeedItemPlaceholderType feedItemPlaceholderType) {
    if (this.valuesHolder.getFeedItemValuesList().size() == 0) {
      return null;
    }
    for (FeedItemValues value : this.valuesHolder.getFeedItemValuesList()) {
      if (value.getFeedItem().getPlaceholderType().equals(feedItemPlaceholderType)) {
        return value.getFeedItem().getFeedItemId();
      }
    }
    return null;
  }
}

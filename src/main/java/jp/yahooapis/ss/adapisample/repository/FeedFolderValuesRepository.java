/**
 * Copyright (C) 2019 Yahoo Japan Corporation. All Rights Reserved.
 */
package jp.yahooapis.ss.adapisample.repository;

import jp.yahooapis.ss.adapisample.util.ValuesHolder;
import jp.yahooapis.ss.v201909.feedfolder.FeedAttribute;
import jp.yahooapis.ss.v201909.feedfolder.FeedFolder;
import jp.yahooapis.ss.v201909.feedfolder.FeedFolderPlaceholderField;
import jp.yahooapis.ss.v201909.feedfolder.FeedFolderPlaceholderType;
import jp.yahooapis.ss.v201909.feedfolder.FeedFolderValues;

import java.util.ArrayList;
import java.util.List;

/**
 * Utility method collection for Java Sample Program.
 */
public class FeedFolderValuesRepository {

  private ValuesHolder valuesHolder;

  /**
   * FeedFolderValuesRepository constructor.
   *
   * @param valuesHolder ValuesHolder
   */
  public FeedFolderValuesRepository(ValuesHolder valuesHolder) {
    this.valuesHolder = valuesHolder;
  }

  /**
   * @return FeedFolders
   */
  public List<FeedFolder> getFeedFolders(){
    List<FeedFolder> feedFolders = new ArrayList<>();
    if (this.valuesHolder.getFeedFolderValuesList().size() == 0) {
      return feedFolders;
    }
    for (FeedFolderValues value : this.valuesHolder.getFeedFolderValuesList()) {
      feedFolders.add(value.getFeedFolder());
    }
    return feedFolders;
  }

  /**
   * @return FeedFolderIds
   */
  public List<Long> getFeedFolderIds(){
    List<Long> feedFolderIds = new ArrayList<>();
    if (this.valuesHolder.getFeedFolderValuesList().size() == 0) {
      return feedFolderIds;
    }
    for (FeedFolderValues value : this.valuesHolder.getFeedFolderValuesList()) {
      feedFolderIds.add(value.getFeedFolder().getFeedFolderId());
    }
    return feedFolderIds;
  }

  /**
   * @param feedFolderPlaceholderType FeedFolderPlaceholderType
   * @return Long|null
   */
  public Long findFeedFolderId(FeedFolderPlaceholderType feedFolderPlaceholderType) {
    if (this.valuesHolder.getFeedFolderValuesList().size() == 0) {
      return null;
    }
    for (FeedFolderValues value : this.valuesHolder.getFeedFolderValuesList()) {
      if (value.getFeedFolder().getPlaceholderType().equals(feedFolderPlaceholderType)) {
        return value.getFeedFolder().getFeedFolderId();
      }
    }
    return null;
  }

  /**
   * @param feedFolderId Long
   * @return String|null
   */
  public String findFeedFolderName(Long feedFolderId) {
    if (this.valuesHolder.getFeedFolderValuesList().size() == 0) {
      return null;
    }
    for (FeedFolderValues value : this.valuesHolder.getFeedFolderValuesList()) {
      if (value.getFeedFolder().getFeedFolderId().equals(feedFolderId)) {
        return value.getFeedFolder().getFeedFolderName();
      }
    }
    return null;
  }

  /**
   * @param feedFolderId Long
   * @param feedFolderPlaceholderField FeedFolderPlaceholderField
   * @return Long|null
   */
  public Long findFeedAttributeId(Long feedFolderId, FeedFolderPlaceholderField feedFolderPlaceholderField) {
    if (this.valuesHolder.getFeedFolderValuesList().size() == 0) {
      return null;
    }
    for (FeedFolderValues value : this.valuesHolder.getFeedFolderValuesList()) {
      if (value.getFeedFolder().getFeedFolderId().equals(feedFolderId)) {
        for (FeedAttribute feedAttribute :value.getFeedFolder().getFeedAttribute()) {
          if (feedAttribute.getPlaceholderField().equals(feedFolderPlaceholderField)) {
            return feedAttribute.getFeedAttributeId();
          }
        }
      }
    }
    return null;
  }

  /**
   * @param feedFolderId Long
   * @param feedFolderPlaceholderField FeedFolderPlaceholderField
   * @return String|null
   */
  public String  findFeedAttributeName(Long feedFolderId, FeedFolderPlaceholderField feedFolderPlaceholderField) {
    if (this.valuesHolder.getFeedFolderValuesList().size() == 0) {
      return null;
    }
    for (FeedFolderValues value : this.valuesHolder.getFeedFolderValuesList()) {
      if (value.getFeedFolder().getFeedFolderId().equals(feedFolderId)) {
        for (FeedAttribute feedAttribute :value.getFeedFolder().getFeedAttribute()) {
          if (feedAttribute.getPlaceholderField().equals(feedFolderPlaceholderField)) {
            return feedAttribute.getFeedAttributeName();
          }
        }
      }
    }
    return null;
  }
}

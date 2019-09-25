/**
 * Copyright (C) 2019 Yahoo Japan Corporation. All Rights Reserved.
 */
package jp.yahooapis.ss.adapisample.repository;

import jp.yahooapis.ss.adapisample.util.ValuesHolder;
import jp.yahooapis.ss.v201909.retargetinglist.RetargetingListValues;
import jp.yahooapis.ss.v201909.retargetinglist.TargetListType;
import jp.yahooapis.ss.v201909.retargetinglist.TargetingList;

import java.util.ArrayList;
import java.util.List;

/**
 * Utility method collection for Java Sample Program.
 */
public class RetargetingListValuesRepository {

  private ValuesHolder valuesHolder;

  /**
   * RetargetingListValuesRepository constructor.
   *
   * @param valuesHolder ValuesHolder
   */
  public RetargetingListValuesRepository(ValuesHolder valuesHolder) {
    this.valuesHolder = valuesHolder;
  }

  /**
   * @return TargetingLists
   */
  public List<TargetingList> getTargetLists() {
    List<TargetingList> targetingLists = new ArrayList<>();
    if (this.valuesHolder.getRetargetingListValuesList().size() == 0) {
      return targetingLists;
    }
    for (RetargetingListValues value : this.valuesHolder.getRetargetingListValuesList()) {
      targetingLists.add(value.getTargetList());
    }
    return targetingLists;
  }

  /**
   * @return TargetListIds
   */
  public List<Long> getTargetListIds() {
    List<Long> targetListIds = new ArrayList<>();
    if (this.valuesHolder.getRetargetingListValuesList().size() == 0) {
      return targetListIds;
    }
    for (RetargetingListValues value : this.valuesHolder.getRetargetingListValuesList()) {
      targetListIds.add(value.getTargetList().getTargetListId());
    }
    return targetListIds;
  }

  /**
   * @param targetListType TargetListType
   * @return Long|null
   */
  public Long findTargetListId(TargetListType targetListType) {
    if (this.valuesHolder.getRetargetingListValuesList().size() == 0) {
      return null;
    }
    for (RetargetingListValues value : this.valuesHolder.getRetargetingListValuesList()) {
      if (value.getTargetList().getTargetListType().equals(targetListType)) {
        return value.getTargetList().getTargetListId();
      }
    }
    return null;
  }
}

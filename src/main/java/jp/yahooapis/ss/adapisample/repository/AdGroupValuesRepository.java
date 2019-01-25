/**
 * Copyright (C) 2019 Yahoo Japan Corporation. All Rights Reserved.
 */
package jp.yahooapis.ss.adapisample.repository;

import jp.yahooapis.ss.adapisample.util.ValuesHolder;
import jp.yahooapis.ss.v201901.adgroup.AdGroup;
import jp.yahooapis.ss.v201901.adgroup.AdGroupValues;

import java.util.ArrayList;
import java.util.List;

/**
 * Utility method collection for Java Sample Program.
 */
public class AdGroupValuesRepository {

  private ValuesHolder valuesHolder;

  /**
   * AdGroupValuesRepository constructor.
   *
   * @param valuesHolder ValuesHolder
   */
  public AdGroupValuesRepository(ValuesHolder valuesHolder) {
    this.valuesHolder = valuesHolder;
  }

  /**
   * @return AdGroups
   */
  public List<AdGroup> getAdGroups(){
    List<AdGroup> adGroups = new ArrayList<>();
    if (this.valuesHolder.getAdGroupValuesList().size() == 0) {
      return adGroups;
    }
    for (AdGroupValues value : this.valuesHolder.getAdGroupValuesList()) {
      adGroups.add(value.getAdGroup());
    }
    return adGroups;
  }

  /**
   * @return AdGroupIds
   */
  public List<Long> getAdGroupIds(){
    List<Long> adGroupIds = new ArrayList<>();
    if (this.valuesHolder.getAdGroupValuesList().size() == 0) {
      return adGroupIds;
    }
    for (AdGroupValues value : this.valuesHolder.getAdGroupValuesList()) {
      adGroupIds.add(value.getAdGroup().getAdGroupId());
    }
    return adGroupIds;
  }

  /**
   * @param campaignId Long
   * @return Long|null
   */
  public Long findAdGroupId(Long campaignId) {
    if (this.valuesHolder.getAdGroupValuesList().size() == 0) {
      return null;
    }
    for (AdGroupValues value : this.valuesHolder.getAdGroupValuesList()) {
      if (value.getAdGroup().getCampaignId() == campaignId) {
        return value.getAdGroup().getAdGroupId();
      }
    }
    return null;
  }
}

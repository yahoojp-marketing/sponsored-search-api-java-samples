/**
 * Copyright (C) 2019 Yahoo Japan Corporation. All Rights Reserved.
 */
package jp.yahooapis.ss.adapisample.repository;

import jp.yahooapis.ss.adapisample.util.ValuesHolder;
import jp.yahooapis.ss.v201901.adgroupcriterion.AdGroupCriterion;
import jp.yahooapis.ss.v201901.adgroupcriterion.AdGroupCriterionUse;
import jp.yahooapis.ss.v201901.adgroupcriterion.AdGroupCriterionValues;

import java.util.ArrayList;
import java.util.List;

/**
 * Utility method collection for Java Sample Program.
 */
public class AdGroupCriterionValuesRepository {

  private ValuesHolder valuesHolder;

  /**
   * AdGroupCriterionValuesRepository constructor.
   *
   * @param valuesHolder ValuesHolder
   */
  public AdGroupCriterionValuesRepository(ValuesHolder valuesHolder) {
    this.valuesHolder = valuesHolder;
  }

  /**
   * @return AdGroupCriterions
   */
  public List<AdGroupCriterion> getAdGroupCriterions(){
    List<AdGroupCriterion> adGroupCriterions = new ArrayList<>();
    if (this.valuesHolder.getAdGroupCriterionValuesList().size() == 0) {
      return adGroupCriterions;
    }
    for (AdGroupCriterionValues value : this.valuesHolder.getAdGroupCriterionValuesList()) {
      adGroupCriterions.add(value.getAdGroupCriterion());
    }
    return adGroupCriterions;
  }

  /**
   * @return CriterionIds
   */
  public List<Long> getCriterionIds(){
    List<Long> criterionIds = new ArrayList<>();
    if (this.valuesHolder.getAdGroupCriterionValuesList().size() == 0) {
      return criterionIds;
    }
    for (AdGroupCriterionValues value : this.valuesHolder.getAdGroupCriterionValuesList()) {
      criterionIds.add(value.getAdGroupCriterion().getCriterion().getCriterionId());
    }
    return criterionIds;
  }

  /**
   * @param campaignId CampaignId
   * @param adGroupId AdGroupId
   * @param adGroupCriterionUse AdGroupCriterionUse
   * @return CriterionId
   */
  public Long findCriterionId(Long campaignId, Long adGroupId, AdGroupCriterionUse adGroupCriterionUse){
    if (this.valuesHolder.getAdGroupCriterionValuesList().size() == 0) {
      return null;
    }
    for (AdGroupCriterionValues value : this.valuesHolder.getAdGroupCriterionValuesList()) {
      if(value.getAdGroupCriterion().getCampaignId().equals(campaignId)
          && value.getAdGroupCriterion().getAdGroupId().equals(adGroupId)
          && value.getAdGroupCriterion().getCriterionUse() == adGroupCriterionUse){
        return value.getAdGroupCriterion().getCriterion().getCriterionId();
      }
    }
    return null;
  }
}
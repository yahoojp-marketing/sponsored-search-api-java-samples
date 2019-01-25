/**
 * Copyright (C) 2019 Yahoo Japan Corporation. All Rights Reserved.
 */
package jp.yahooapis.ss.adapisample.repository;

import jp.yahooapis.ss.adapisample.util.ValuesHolder;
import jp.yahooapis.ss.v201901.adgroupad.AdGroupAd;
import jp.yahooapis.ss.v201901.adgroupad.AdGroupAdValues;
import jp.yahooapis.ss.v201901.adgroupad.AdType;

import java.util.ArrayList;
import java.util.List;

/**
 * Utility method collection for Java Sample Program.
 */
public class AdGroupAdValuesRepository {

  private ValuesHolder valuesHolder;

  /**
   * AdGroupAdValuesRepository constructor.
   *
   * @param valuesHolder ValuesHolder
   */
  public AdGroupAdValuesRepository(ValuesHolder valuesHolder) {
    this.valuesHolder = valuesHolder;
  }

  /**
   * @return AdGroupAds
   */
  public List<AdGroupAd> getAdGroupAds(){
    List<AdGroupAd> adGroupAds = new ArrayList<>();
    if (this.valuesHolder.getAdGroupAdValuesList().size() == 0) {
      return adGroupAds;
    }
    for (AdGroupAdValues value : this.valuesHolder.getAdGroupAdValuesList()) {
      adGroupAds.add(value.getAdGroupAd());
    }
    return adGroupAds;
  }

  /**
   * @return AdIds
   */
  public List<Long> getAdIds(){
    List<Long> adIds = new ArrayList<>();
    if (this.valuesHolder.getAdGroupAdValuesList().size() == 0) {
      return adIds;
    }
    for (AdGroupAdValues value : this.valuesHolder.getAdGroupAdValuesList()) {
      adIds.add(value.getAdGroupAd().getAdId());
    }
    return adIds;
  }

  /**
   * @param campaignId CampaignId
   * @param adGroupId AdGroupId
   * @param adType AdType
   * @return Long|null
   */
  public Long findAdId(Long campaignId, Long adGroupId, AdType adType){
    if (this.valuesHolder.getAdGroupAdValuesList().size() == 0) {
      return null;
    }
    for (AdGroupAdValues value : this.valuesHolder.getAdGroupAdValuesList()) {
      if(value.getAdGroupAd().getCampaignId() == campaignId
      && value.getAdGroupAd().getAdGroupId() == adGroupId
      && value.getAdGroupAd().getAd().getType().equals(adType)){
        return value.getAdGroupAd().getAdId();
      }
    }
    return null;
  }
}

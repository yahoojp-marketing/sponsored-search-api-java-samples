/**
 * Copyright (C) 2019 Yahoo Japan Corporation. All Rights Reserved.
 */
package jp.yahooapis.ss.adapisample.repository;

import jp.yahooapis.ss.adapisample.util.ValuesHolder;
import jp.yahooapis.ss.v201901.campaign.AppStore;
import jp.yahooapis.ss.v201901.campaign.Campaign;
import jp.yahooapis.ss.v201901.campaign.CampaignType;
import jp.yahooapis.ss.v201901.campaign.CampaignValues;

import java.util.ArrayList;
import java.util.List;

/**
 * Utility method collection for Java Sample Program.
 */
public class CampaignValuesRepository {

  private ValuesHolder valuesHolder;

  /**
   * CampaignValuesRepository constructor.
   *
   * @param valuesHolder ValuesHolder
   */
  public CampaignValuesRepository(ValuesHolder valuesHolder) {
    this.valuesHolder = valuesHolder;
  }

  /**
   * @return Campaigns
   */
  public List<Campaign> getCampaigns(){
    List<Campaign> campaigns = new ArrayList<>();
    if (this.valuesHolder.getCampaignValuesList().size() == 0) {
      return campaigns;
    }
    for (CampaignValues value : this.valuesHolder.getCampaignValuesList()) {
      campaigns.add(value.getCampaign());
    }
    return campaigns;
  }

  /**
   * @return CampaignIds
   */
  public List<Long> getCampaignIds(){
    List<Long> campaignIds = new ArrayList<>();
    if (this.valuesHolder.getCampaignValuesList().size() == 0) {
      return campaignIds;
    }
    for (CampaignValues value : this.valuesHolder.getCampaignValuesList()) {
        campaignIds.add(value.getCampaign().getCampaignId());
    }
    return campaignIds;
  }

  /**
   * @param campaignType CampaignType
   * @return Long|null
   */
  public Long findCampaignId(CampaignType campaignType) {
    if (this.valuesHolder.getCampaignValuesList().size() == 0) {
      return null;
    }
    for (CampaignValues value : this.valuesHolder.getCampaignValuesList()) {
      if (value.getCampaign().getCampaignType().equals(campaignType)) {
        return value.getCampaign().getCampaignId();
      }
    }
    return null;
  }

  /**
   * @param appStore AppStore
   * @return Long|null
   */
  public Long findCampaignId(AppStore appStore) {
    if (this.valuesHolder.getCampaignValuesList().size() == 0) {
      return null;
    }
    for (CampaignValues value : this.valuesHolder.getCampaignValuesList()) {
      if (value.getCampaign().getCampaignType().equals(CampaignType.MOBILE_APP) && value.getCampaign().getAppStore().equals(appStore)) {
        return value.getCampaign().getCampaignId();
      }
    }
    return null;
  }

  /**
   * @param campaignId Long
   * @return String|null
   */
  public String findAppId(Long campaignId) {
    if (this.valuesHolder.getCampaignValuesList().size() == 0) {
      return null;
    }
    for (CampaignValues value : this.valuesHolder.getCampaignValuesList()) {
      if (value.getCampaign().getCampaignId().equals(campaignId)) {
        return value.getCampaign().getAppId();
      }
    }
    return null;
  }
}

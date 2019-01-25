/**
 * Copyright (C) 2019 Yahoo Japan Corporation. All Rights Reserved.
 */
package jp.yahooapis.ss.adapisample.util;

import jp.yahooapis.ss.v201901.accountshared.AccountSharedValues;
import jp.yahooapis.ss.v201901.adgroup.AdGroupValues;
import jp.yahooapis.ss.v201901.adgroupad.AdGroupAdValues;
import jp.yahooapis.ss.v201901.adgroupcriterion.AdGroupCriterionValues;
import jp.yahooapis.ss.v201901.biddingstrategy.BiddingStrategyValues;
import jp.yahooapis.ss.v201901.campaign.CampaignValues;
import jp.yahooapis.ss.v201901.feedfolder.FeedFolderValues;
import jp.yahooapis.ss.v201901.feeditem.FeedItemValues;
import jp.yahooapis.ss.v201901.label.LabelValues;
import jp.yahooapis.ss.v201901.reportdefinition.ReportDefinitionValues;
import jp.yahooapis.ss.v201901.retargetinglist.RetargetingListValues;

import java.util.ArrayList;
import java.util.List;

/**
 * Utility method collection for Java Sample Program.
 */
public class ValuesHolder {

  private List<AccountSharedValues> accountSharedValuesList = new ArrayList<>();

  /**
   * @return AccountSharedValuesList
   */
  public List<AccountSharedValues> getAccountSharedValuesList() {
    return accountSharedValuesList;
  }

  /**
   * @param accountSharedValuesList AccountSharedValuesList
   */
  public void setAccountSharedValuesList(List<AccountSharedValues> accountSharedValuesList) {
    if (this.accountSharedValuesList.size() == 0) {
      this.accountSharedValuesList = accountSharedValuesList;
    } else {
      this.accountSharedValuesList.addAll(accountSharedValuesList);
    }
  }

  private List<RetargetingListValues> retargetingListValuesList = new ArrayList<>();

  /**
   * @return RetargetingListValuesList
   */
  public List<RetargetingListValues> getRetargetingListValuesList() {
    return retargetingListValuesList;
  }

  /**
   * @param retargetingListValuesList RetargetingListValuesList
   */
  public void setRetargetingListValuesList(List<RetargetingListValues> retargetingListValuesList) {
    if (this.retargetingListValuesList.size() == 0) {
      this.retargetingListValuesList = retargetingListValuesList;
    } else {
      this.retargetingListValuesList.addAll(retargetingListValuesList);
    }
  }

  private List<FeedFolderValues> feedFolderValuesList = new ArrayList<>();

  /**
   * @return FeedFolderValuesList
   */
  public List<FeedFolderValues> getFeedFolderValuesList() {
    return feedFolderValuesList;
  }

  /**
   * @param feedFolderValuesList FeedFolderValuesList
   */
  public void setFeedFolderValuesList(List<FeedFolderValues> feedFolderValuesList) {
    if (this.feedFolderValuesList.size() == 0) {
      this.feedFolderValuesList = feedFolderValuesList;
    } else {
      this.feedFolderValuesList.addAll(feedFolderValuesList);
    }
  }

  private List<LabelValues> labelValuesList = new ArrayList<>();

  /**
   * @return LabelValuesList
   */
  public List<LabelValues> getLabelValuesList() {
    return labelValuesList;
  }

  /**
   * @param labelValuesList LabelValuesList
   */
  public void setLabelValuesList(List<LabelValues> labelValuesList) {
    if (this.labelValuesList.size() == 0) {
      this.labelValuesList = labelValuesList;
    } else {
      this.labelValuesList.addAll(labelValuesList);
    }
  }

  private List<BiddingStrategyValues> biddingStrategyValuesList = new ArrayList<>();

  /**
   * @return BiddingStrategyValuesList
   */
  public List<BiddingStrategyValues> getBiddingStrategyValuesList() {
    return biddingStrategyValuesList;
  }

  /**
   * @param biddingStrategyValuesList BiddingStrategyValuesList
   */
  public void setBiddingStrategyValuesList(List<BiddingStrategyValues> biddingStrategyValuesList) {
    if (this.biddingStrategyValuesList.size() == 0) {
      this.biddingStrategyValuesList = biddingStrategyValuesList;
    } else {
      this.biddingStrategyValuesList.addAll(biddingStrategyValuesList);
    }
  }

  private List<CampaignValues> campaignValuesList = new ArrayList<>();

  /**
   * @return CampaignValueList
   */
  public List<CampaignValues> getCampaignValuesList() {
    return campaignValuesList;
  }

  /**
   * @param campaignValuesList CampaignValueList
   */
  public void setCampaignValuesList(List<CampaignValues> campaignValuesList) {
    if (this.campaignValuesList.size() == 0) {
      this.campaignValuesList = campaignValuesList;
    } else {
      if (campaignValuesList.size() > 0) {
        this.campaignValuesList.addAll(campaignValuesList);
      } else {
        this.campaignValuesList = campaignValuesList;
      }
    }
  }

  private List<AdGroupValues> adGroupValuesList = new ArrayList<>();

  /**
   * @return AdGroupValuesList
   */
  public List<AdGroupValues> getAdGroupValuesList() {
    return adGroupValuesList;
  }

  /**
   * @param adGroupValuesList AdGroupValuesList
   */
  public void setAdGroupValuesList(List<AdGroupValues> adGroupValuesList) {
    if (this.adGroupValuesList.size() == 0) {
      this.adGroupValuesList = adGroupValuesList;
    } else {
      this.adGroupValuesList.addAll(adGroupValuesList);
    }
  }

  private List<AdGroupAdValues> adGroupAdValuesList = new ArrayList<>();

  /**
   * @return AdGroupAdValuesList
   */
  public List<AdGroupAdValues> getAdGroupAdValuesList() {
    return adGroupAdValuesList;
  }

  /**
   * @param adGroupAdValuesList AdGroupAdValuesList
   */
  public void setAdGroupAdValuesList(List<AdGroupAdValues> adGroupAdValuesList) {
    if (this.adGroupAdValuesList.size() == 0) {
      this.adGroupAdValuesList = adGroupAdValuesList;
    } else {
      this.adGroupAdValuesList.addAll(adGroupAdValuesList);
    }
  }

  private List<AdGroupCriterionValues> adGroupCriterionValuesList = new ArrayList<>();

  /**
   * @return AdGroupCriterionValuesList
   */
  public List<AdGroupCriterionValues> getAdGroupCriterionValuesList() {
    return adGroupCriterionValuesList;
  }

  /**
   * @param adGroupCriterionValuesList AdGroupCriterionValuesList
   */
  public void setAdGroupCriterionValuesList(List<AdGroupCriterionValues> adGroupCriterionValuesList) {
    if (this.adGroupCriterionValuesList.size() == 0) {
      this.adGroupCriterionValuesList = adGroupCriterionValuesList;
    } else {
      this.adGroupCriterionValuesList.addAll(adGroupCriterionValuesList);
    }
  }

  private List<FeedItemValues> feedItemValuesList = new ArrayList<>();

  /**
   * @return FeedItemValuesList
   */
  public List<FeedItemValues> getFeedItemValuesList() {
    return feedItemValuesList;
  }

  /**
   * @param feedItemValuesList FeedItemValuesList
   */
  public void setFeedItemValuesList(List<FeedItemValues> feedItemValuesList) {
    if (this.feedItemValuesList.size() == 0) {
      this.feedItemValuesList = feedItemValuesList;
    } else {
      this.feedItemValuesList.addAll(feedItemValuesList);
    }
  }

  private List<ReportDefinitionValues> reportDefinitionValuesList = new ArrayList<>();

  /**
   * @return ReportDefinitionValuesList
   */
  public List<ReportDefinitionValues> getReportDefinitionValuesList() {
    return reportDefinitionValuesList;
  }

  /**
   * @param reportDefinitionValuesList FeedItemValuesList
   */
  public void setReportDefinitionValuesList(List<ReportDefinitionValues> reportDefinitionValuesList) {
    if (this.reportDefinitionValuesList.size() == 0) {
      this.reportDefinitionValuesList = reportDefinitionValuesList;
    } else {
      this.reportDefinitionValuesList.addAll(reportDefinitionValuesList);
    }
  }
}

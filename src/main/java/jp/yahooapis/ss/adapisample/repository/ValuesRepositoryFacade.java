/**
 * Copyright (C) 2019 Yahoo Japan Corporation. All Rights Reserved.
 */
package jp.yahooapis.ss.adapisample.repository;

import jp.yahooapis.ss.adapisample.util.ValuesHolder;

/**
 * Utility method collection for Java Sample Program.
 */
public class ValuesRepositoryFacade {

  private ValuesHolder valuesHolder;
  private AccountSharedValuesRepository accountSharedValuesRepository;
  private RetargetingListValuesRepository retargetingListValuesRepository;
  private FeedFolderValuesRepository feedFolderValuesRepository;
  private LabelValuesRepository labelValuesRepository;
  private BiddingStrategyValuesRepository biddingStrategyValuesRepository;
  private CampaignValuesRepository campaignValuesRepository;
  private AdGroupValuesRepository adGroupValuesRepository;
  private AdGroupAdValuesRepository adGroupAdValuesRepository;
  private AdGroupCriterionValuesRepository adGroupCriterionValuesRepository;
  private FeedItemValuesRepository feedItemValuesRepository;
  private ReportDefinitionValuesRepository reportDefinitionValuesRepository;

  /**
   * ValuesRepositoryFacade constructor.
   *
   * @param valuesHolder ValuesHolder
   */
  public ValuesRepositoryFacade(ValuesHolder valuesHolder) {
    this.valuesHolder = valuesHolder;
    this.accountSharedValuesRepository = new AccountSharedValuesRepository(this.valuesHolder);
    this.retargetingListValuesRepository = new RetargetingListValuesRepository(this.valuesHolder);
    this.feedFolderValuesRepository = new FeedFolderValuesRepository(this.valuesHolder);
    this.labelValuesRepository = new LabelValuesRepository(this.valuesHolder);
    this.biddingStrategyValuesRepository = new BiddingStrategyValuesRepository(this.valuesHolder);
    this.campaignValuesRepository = new CampaignValuesRepository(this.valuesHolder);
    this.adGroupValuesRepository = new AdGroupValuesRepository(this.valuesHolder);
    this.adGroupAdValuesRepository = new AdGroupAdValuesRepository(this.valuesHolder);
    this.adGroupCriterionValuesRepository = new AdGroupCriterionValuesRepository(this.valuesHolder);
    this.feedItemValuesRepository = new FeedItemValuesRepository(this.valuesHolder);
    this.reportDefinitionValuesRepository = new ReportDefinitionValuesRepository(this.valuesHolder);
  }

  /**
   * @return ValuesHolder
   */
  public ValuesHolder getValuesHolder() {
    return this.valuesHolder;
  }

  /**
   * @return AccountSharedValuesRepository
   */
  public AccountSharedValuesRepository getAccountSharedValuesRepository() {
    return this.accountSharedValuesRepository;
  }

  /**
   * @return RetargetingListValuesRepository
   */
  public RetargetingListValuesRepository getRetargetingListValuesRepository() {
    return this.retargetingListValuesRepository;
  }

  /**
   * @return FeedFolderValuesRepository
   */
  public FeedFolderValuesRepository getFeedFolderValuesRepository() {
    return this.feedFolderValuesRepository;
  }

  /**
   * @return LabelValuesRepository
   */
  public LabelValuesRepository getLabelValuesRepository() {
    return this.labelValuesRepository;
  }

  /**
   * @return BiddingStrategyValuesRepository
   */
  public BiddingStrategyValuesRepository getBiddingStrategyValuesRepository() {
    return this.biddingStrategyValuesRepository;
  }

  /**
   * @return CampaignValuesRepository
   */
  public CampaignValuesRepository getCampaignValuesRepository() {
    return this.campaignValuesRepository;
  }

  /**
   * @return AdGroupValuesRepository
   */
  public AdGroupValuesRepository getAdGroupValuesRepository() {
    return this.adGroupValuesRepository;
  }

  /**
   * @return AdGroupAdValuesRepository
   */
  public AdGroupAdValuesRepository getAdGroupAdValuesRepository() {
    return this.adGroupAdValuesRepository;
  }

  /**
   * @return AdGroupCriterionValuesRepository
   */
  public AdGroupCriterionValuesRepository getAdGroupCriterionValuesRepository() {
    return this.adGroupCriterionValuesRepository;
  }

  /**
   * @return FeedItemValuesRepository
   */
  public FeedItemValuesRepository getFeedItemValuesRepository() {
    return this.feedItemValuesRepository;
  }

  /**
   * @return ReportDefinitionValuesRepository
   */
  public ReportDefinitionValuesRepository getReportDefinitionValuesRepository() {
    return this.reportDefinitionValuesRepository;
  }
}

/**
 * Copyright (C) 2019 Yahoo Japan Corporation. All Rights Reserved.
 */
package jp.yahooapis.ss.adapisample.basic.campaign;

import jp.yahooapis.ss.adapisample.basic.biddingstrategy.BiddingStrategyServiceSample;
import jp.yahooapis.ss.adapisample.basic.feedfolder.FeedFolderServiceSample;
import jp.yahooapis.ss.adapisample.repository.ValuesRepositoryFacade;
import jp.yahooapis.ss.adapisample.util.SoapUtils;
import jp.yahooapis.ss.adapisample.util.ValuesHolder;
import jp.yahooapis.ss.v201909.Error;
import jp.yahooapis.ss.v201909.Paging;
import jp.yahooapis.ss.v201909.campaign.AppStore;
import jp.yahooapis.ss.v201909.campaign.BiddingStrategyType;
import jp.yahooapis.ss.v201909.campaign.Budget;
import jp.yahooapis.ss.v201909.campaign.BudgetDeliveryMethod;
import jp.yahooapis.ss.v201909.campaign.BudgetPeriod;
import jp.yahooapis.ss.v201909.campaign.Campaign;
import jp.yahooapis.ss.v201909.campaign.CampaignBiddingStrategy;
import jp.yahooapis.ss.v201909.campaign.CampaignOperation;
import jp.yahooapis.ss.v201909.campaign.CampaignPage;
import jp.yahooapis.ss.v201909.campaign.CampaignReturnValue;
import jp.yahooapis.ss.v201909.campaign.CampaignSelector;
import jp.yahooapis.ss.v201909.campaign.CampaignService;
import jp.yahooapis.ss.v201909.campaign.CampaignServiceInterface;
import jp.yahooapis.ss.v201909.campaign.CampaignType;
import jp.yahooapis.ss.v201909.campaign.CampaignValues;
import jp.yahooapis.ss.v201909.campaign.CustomParameter;
import jp.yahooapis.ss.v201909.campaign.CustomParameters;
import jp.yahooapis.ss.v201909.campaign.DynamicAdsForSearchSetting;
import jp.yahooapis.ss.v201909.campaign.EnhancedCpcEnabled;
import jp.yahooapis.ss.v201909.campaign.GeoTargetType;
import jp.yahooapis.ss.v201909.campaign.GeoTargetTypeSetting;
import jp.yahooapis.ss.v201909.campaign.ManualCpcBiddingScheme;
import jp.yahooapis.ss.v201909.campaign.Operator;
import jp.yahooapis.ss.v201909.campaign.SettingType;
import jp.yahooapis.ss.v201909.campaign.TargetAll;
import jp.yahooapis.ss.v201909.campaign.TargetSpendBiddingScheme;
import jp.yahooapis.ss.v201909.campaign.TargetingSetting;
import jp.yahooapis.ss.v201909.campaign.UserStatus;
import jp.yahooapis.ss.v201909.feedfolder.FeedFolderPlaceholderType;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.xml.ws.Holder;

/**
 * example CampaignService operation and Utility method collection.
 */
public class CampaignServiceSample {

  /**
   * main method for CampaignServiceSample
   *
   * @param args command line arguments
   */
  public static void main(String[] args) throws Exception {

    // =================================================================
    // Setting
    // =================================================================
    ValuesHolder valuesHolder = new ValuesHolder();
    long accountId = SoapUtils.getAccountId();

    try {
      // =================================================================
      // check & create upper service object.
      // =================================================================
      valuesHolder = setup();
      ValuesRepositoryFacade valuesRepositoryFacade = new ValuesRepositoryFacade(valuesHolder);
      Long biddingStrategyId = valuesRepositoryFacade.getBiddingStrategyValuesRepository().findBiddingStrategyId(jp.yahooapis.ss.v201909.biddingstrategy.BiddingStrategyType.TARGET_CPA);

      // =================================================================
      // CampaignService::ADD
      // =================================================================
      // create request.
      CampaignOperation addCampaignOperation = buildExampleMutateRequest(Operator.ADD, accountId, new ArrayList<Campaign>() {{
        // Manual Bidding
        add(createExampleStandardCampaign("SampleManualCpcStandardCampaign_", createManualBiddingCampaignBiddingStrategy()));
        // Portfolio Bidding
        add(createExampleStandardCampaign("SamplePortFolioBiddingStandardCampaign_", createPortfolioBiddingCampaignBiddingStrategy(biddingStrategyId)));
        // Standard Bidding
        add(createExampleStandardCampaign("SampleStandardBiddingStandardCampaign_", createStandardBiddingCampaignBiddingStrategy()));
      }});

      // run
      List<CampaignValues> addCampaignValues = mutate(addCampaignOperation);
      valuesRepositoryFacade.getValuesHolder().setCampaignValuesList(addCampaignValues);

      // =================================================================
      // CampaignService::GET
      // =================================================================
      // create request.
      CampaignSelector campaignSelector = buildExampleGetRequest(accountId, valuesRepositoryFacade.getCampaignValuesRepository().getCampaignIds());

      // run
      get(campaignSelector);

      // check review status
      checkStatus(valuesRepositoryFacade.getCampaignValuesRepository().getCampaignIds());

      // =================================================================
      // CampaignService::SET
      // =================================================================
      // create request.
      CampaignOperation setCampaignOperation = buildExampleMutateRequest(Operator.SET, accountId, createExampleSetRequest(valuesRepositoryFacade.getCampaignValuesRepository().getCampaigns()));

      // run
      mutate(setCampaignOperation);

      // =================================================================
      // CampaignService::REMOVE
      // =================================================================
      // create request.
      CampaignOperation removeCampaignOperation =
          buildExampleMutateRequest(Operator.REMOVE, accountId, valuesRepositoryFacade.getCampaignValuesRepository().getCampaigns());

      // run
      mutate(removeCampaignOperation);
      valuesHolder.setCampaignValuesList(new ArrayList<>());

    } catch (Exception e) {
      e.printStackTrace();
      throw e;
    } finally {
      cleanup(valuesHolder);
    }
  }

  /**
   * example mutate campaigns.
   *
   * @param operation CampaignOperation
   * @return CampaignValues
   */
  public static List<CampaignValues> mutate(CampaignOperation operation) throws Exception {

    // Call API
    System.out.println("############################################");
    System.out.println("CampaignService::mutate(" + operation.getOperator() + ")");
    System.out.println("############################################");

    Holder<CampaignReturnValue> campaignReturnValueHolder = new Holder<CampaignReturnValue>();
    Holder<List<Error>> errorHolder = new Holder<List<Error>>();
    CampaignServiceInterface campaignService = SoapUtils.createServiceInterface(CampaignServiceInterface.class, CampaignService.class);
    campaignService.mutate(operation, campaignReturnValueHolder, errorHolder);

    SoapUtils.checkSoapError(errorHolder, campaignReturnValueHolder.value.getValues());

    // Response
    return campaignReturnValueHolder.value.getValues();
  }

  /**
   * example mutate request.
   */
  public static CampaignOperation buildExampleMutateRequest(Operator operator, long accountId, List<Campaign> operand) {
    CampaignOperation operation = new CampaignOperation();
    operation.setOperator(operator);
    operation.setAccountId(accountId);
    operation.getOperand().addAll(operand);

    return operation;
  }

  /**
   * example Manual Bidding CampaignBiddingStrategy request.
   *
   * @return CampaignBiddingStrategy
   */
  public static CampaignBiddingStrategy createManualBiddingCampaignBiddingStrategy() {

    ManualCpcBiddingScheme manualCpcBiddingScheme = new ManualCpcBiddingScheme();
    manualCpcBiddingScheme.setBiddingStrategyType(BiddingStrategyType.MANUAL_CPC);
    manualCpcBiddingScheme.setEnhancedCpcEnabled(EnhancedCpcEnabled.FALSE);

    CampaignBiddingStrategy campaignBiddingStrategy = new CampaignBiddingStrategy();
    campaignBiddingStrategy.setBiddingStrategyType(BiddingStrategyType.MANUAL_CPC);
    campaignBiddingStrategy.setBiddingScheme(manualCpcBiddingScheme);

    return campaignBiddingStrategy;
  }

  /**
   * example Portfolio Bidding CampaignBiddingStrategy request.
   *
   * @param biddingStrategyId Long
   * @return CampaignBiddingStrategy
   */
  public static CampaignBiddingStrategy createPortfolioBiddingCampaignBiddingStrategy(Long biddingStrategyId) {

    CampaignBiddingStrategy campaignBiddingStrategy = new CampaignBiddingStrategy();
    campaignBiddingStrategy.setBiddingStrategyId(biddingStrategyId);

    return campaignBiddingStrategy;
  }

  /**
   * example Standard Bidding CampaignBiddingStrategy request.
   *
   * @return CampaignBiddingStrategy
   */
  public static CampaignBiddingStrategy createStandardBiddingCampaignBiddingStrategy() {

    TargetSpendBiddingScheme targetSpendBiddingScheme = new TargetSpendBiddingScheme();
    targetSpendBiddingScheme.setBiddingStrategyType(BiddingStrategyType.TARGET_SPEND);
    targetSpendBiddingScheme.setBidCeiling((long) 700);

    CampaignBiddingStrategy campaignBiddingStrategy = new CampaignBiddingStrategy();
    campaignBiddingStrategy.setBiddingStrategyType(BiddingStrategyType.TARGET_SPEND);
    campaignBiddingStrategy.setBiddingScheme(targetSpendBiddingScheme);

    return campaignBiddingStrategy;
  }

  /**
   * example Standard Campaign request.
   *
   * @param campaignNamePrefix String
   * @param campaignBiddingStrategy CampaignBiddingStrategy
   * @return Campaign
   */
  public static Campaign createExampleStandardCampaign(String campaignNamePrefix, CampaignBiddingStrategy campaignBiddingStrategy) {

    // budget
    Budget budget = new Budget();
    budget.setPeriod(BudgetPeriod.DAILY);
    budget.setAmount((long) 1000);
    budget.setDeliveryMethod(BudgetDeliveryMethod.STANDARD);

    // settings
    GeoTargetTypeSetting geoTargetTypeSetting = new GeoTargetTypeSetting();
    geoTargetTypeSetting.setType(SettingType.GEO_TARGET_TYPE_SETTING);
    geoTargetTypeSetting.setNegativeGeoTargetType(GeoTargetType.DONT_CARE);
    geoTargetTypeSetting.setPositiveGeoTargetType(GeoTargetType.AREA_OF_INTENT);
    TargetingSetting targetingSetting = new TargetingSetting();
    targetingSetting.setType(SettingType.TARGET_LIST_SETTING);
    targetingSetting.setTargetAll(TargetAll.ACTIVE);

    // customParameters
    CustomParameter customParameter = new CustomParameter();
    customParameter.setKey("id1");
    customParameter.setValue("1234");
    CustomParameters customParameters = new CustomParameters();
    customParameters.getParameters().add(customParameter);

    Campaign campaign = new Campaign();
    campaign.setCampaignName(campaignNamePrefix + SoapUtils.getCurrentTimestamp());
    campaign.setUserStatus(UserStatus.ACTIVE);
    campaign.setStartDate(DateTimeFormatter.ofPattern("yyyyMMdd").format(LocalDateTime.now()));
    campaign.setEndDate("20301231");
    campaign.setCampaignType(CampaignType.STANDARD);
    campaign.setTrackingUrl("http://www.yahoo.co.jp/?url={lpurl}&amp;a={creative}&amp;pid={_id1}");
    campaign.setBudget(budget);
    campaign.setBiddingStrategyConfiguration(campaignBiddingStrategy);
    campaign.getSettings().addAll(Arrays.asList(geoTargetTypeSetting, targetingSetting));
    campaign.setCustomParameters(customParameters);

    return campaign;
  }

  /**
   * example MobileApp Campaign for IOS request.
   *
   * @param campaignNamePrefix String
   * @param campaignBiddingStrategy CampaignBiddingStrategy
   * @return Campaign
   */
  public static Campaign createExampleMobileAppCampaignForIOS(String campaignNamePrefix, CampaignBiddingStrategy campaignBiddingStrategy) {

    // budget
    Budget budget = new Budget();
    budget.setPeriod(BudgetPeriod.DAILY);
    budget.setAmount((long) 1000);
    budget.setDeliveryMethod(BudgetDeliveryMethod.STANDARD);

    // settings
    GeoTargetTypeSetting geoTargetTypeSetting = new GeoTargetTypeSetting();
    geoTargetTypeSetting.setType(SettingType.GEO_TARGET_TYPE_SETTING);
    geoTargetTypeSetting.setNegativeGeoTargetType(GeoTargetType.DONT_CARE);
    geoTargetTypeSetting.setPositiveGeoTargetType(GeoTargetType.AREA_OF_INTENT);
    TargetingSetting targetingSetting = new TargetingSetting();
    targetingSetting.setType(SettingType.TARGET_LIST_SETTING);
    targetingSetting.setTargetAll(TargetAll.ACTIVE);

    // customParameters
    CustomParameter customParameter = new CustomParameter();
    customParameter.setKey("id1");
    customParameter.setValue("1234");
    CustomParameters customParameters = new CustomParameters();
    customParameters.getParameters().add(customParameter);

    Campaign campaign = new Campaign();
    campaign.setCampaignName(campaignNamePrefix + SoapUtils.getCurrentTimestamp());
    campaign.setUserStatus(UserStatus.ACTIVE);
    campaign.setStartDate(DateTimeFormatter.ofPattern("yyyyMMdd").format(LocalDateTime.now()));
    campaign.setEndDate("20301231");
    campaign.setCampaignType(CampaignType.MOBILE_APP);
    campaign.setAppStore(AppStore.IOS);
    campaign.setAppId(SoapUtils.getCurrentTimestamp());
    campaign.setTrackingUrl("http://www.yahoo.co.jp/?url={lpurl}&amp;a={creative}&amp;pid={_id1}");
    campaign.setBudget(budget);
    campaign.setBiddingStrategyConfiguration(campaignBiddingStrategy);
    campaign.getSettings().addAll(Arrays.asList(geoTargetTypeSetting, targetingSetting));
    campaign.setCustomParameters(customParameters);

    return campaign;
  }

  /**
   * example MobileApp Campaign for ANDROID request.
   *
   * @param campaignNamePrefix String
   * @param campaignBiddingStrategy CampaignBiddingStrategy
   * @return Campaign
   */
  public static Campaign createExampleMobileAppCampaignForANDROID(String campaignNamePrefix, CampaignBiddingStrategy campaignBiddingStrategy) {

    // budget
    Budget budget = new Budget();
    budget.setPeriod(BudgetPeriod.DAILY);
    budget.setAmount((long) 1000);
    budget.setDeliveryMethod(BudgetDeliveryMethod.STANDARD);

    // settings
    GeoTargetTypeSetting geoTargetTypeSetting = new GeoTargetTypeSetting();
    geoTargetTypeSetting.setType(SettingType.GEO_TARGET_TYPE_SETTING);
    geoTargetTypeSetting.setNegativeGeoTargetType(GeoTargetType.DONT_CARE);
    geoTargetTypeSetting.setPositiveGeoTargetType(GeoTargetType.AREA_OF_INTENT);
    TargetingSetting targetingSetting = new TargetingSetting();
    targetingSetting.setType(SettingType.TARGET_LIST_SETTING);
    targetingSetting.setTargetAll(TargetAll.ACTIVE);

    Campaign campaign = new Campaign();
    campaign.setCampaignName(campaignNamePrefix + SoapUtils.getCurrentTimestamp());
    campaign.setUserStatus(UserStatus.ACTIVE);
    campaign.setStartDate(DateTimeFormatter.ofPattern("yyyyMMdd").format(LocalDateTime.now()));
    campaign.setEndDate("20301231");
    campaign.setCampaignType(CampaignType.MOBILE_APP);
    campaign.setAppStore(AppStore.ANDROID);
    campaign.setAppId("jp.co.yahoo." + SoapUtils.getCurrentTimestamp());
    campaign.setBudget(budget);
    campaign.setBiddingStrategyConfiguration(campaignBiddingStrategy);
    campaign.getSettings().addAll(Arrays.asList(geoTargetTypeSetting, targetingSetting));

    return campaign;
  }

  /**
   * example Dynamic Ads for Search Campaign request.
   *
   * @param campaignNamePrefix String
   * @param feedFolderIds Long
   * @param campaignBiddingStrategy CampaignBiddingStrategy
   * @return
   */
  public static Campaign createExampleDynamicAdsForSearchCampaign(String campaignNamePrefix, List<Long> feedFolderIds, CampaignBiddingStrategy campaignBiddingStrategy) {

    // budget
    Budget budget = new Budget();
    budget.setPeriod(BudgetPeriod.DAILY);
    budget.setAmount((long) 1000);
    budget.setDeliveryMethod(BudgetDeliveryMethod.STANDARD);

    // settings
    GeoTargetTypeSetting geoTargetTypeSetting = new GeoTargetTypeSetting();
    geoTargetTypeSetting.setType(SettingType.GEO_TARGET_TYPE_SETTING);
    geoTargetTypeSetting.setNegativeGeoTargetType(GeoTargetType.DONT_CARE);
    geoTargetTypeSetting.setPositiveGeoTargetType(GeoTargetType.AREA_OF_INTENT);
    TargetingSetting targetingSetting = new TargetingSetting();
    targetingSetting.setType(SettingType.TARGET_LIST_SETTING);
    targetingSetting.setTargetAll(TargetAll.ACTIVE);
    DynamicAdsForSearchSetting dynamicAdsForSearchSetting = new DynamicAdsForSearchSetting();
    dynamicAdsForSearchSetting.setType(SettingType.DYNAMIC_ADS_FOR_SEARCH_SETTING);
    dynamicAdsForSearchSetting.getFeedFolderIds().addAll(feedFolderIds);

    // customParameters
    CustomParameter customParameter = new CustomParameter();
    customParameter.setKey("id1");
    customParameter.setValue("1234");
    CustomParameters customParameters = new CustomParameters();
    customParameters.getParameters().add(customParameter);

    Campaign campaign = new Campaign();
    campaign.setCampaignName(campaignNamePrefix + SoapUtils.getCurrentTimestamp());
    campaign.setUserStatus(UserStatus.ACTIVE);
    campaign.setStartDate(DateTimeFormatter.ofPattern("yyyyMMdd").format(LocalDateTime.now()));
    campaign.setEndDate("20301231");
    campaign.setCampaignType(CampaignType.DYNAMIC_ADS_FOR_SEARCH);
    campaign.setTrackingUrl("http://www.yahoo.co.jp/?url={lpurl}&amp;a={creative}&amp;pid={_id1}");
    campaign.setBudget(budget);
    campaign.setBiddingStrategyConfiguration(campaignBiddingStrategy);
    campaign.getSettings().addAll(Arrays.asList(geoTargetTypeSetting, targetingSetting, dynamicAdsForSearchSetting));
    campaign.setCustomParameters(customParameters);

    return campaign;
  }

  /**
   * example check campaign review status.
   *
   * @param campaignIds List<Long>
   * @throws Exception
   */
  public static void checkStatus(List<Long> campaignIds) throws Exception {

    try {
      // call 30sec sleep * 30 = 15minute
      for (int i = 0; i < 30; i++) {
        // sleep 30 second.
        System.out.println("\n***** sleep 30 seconds for Get Campaign  *****\n");
        Thread.sleep(30000);

        CampaignSelector campaignSelector = buildExampleGetRequest(SoapUtils.getAccountId(), campaignIds);
        List<CampaignValues> getCampaignValues = get(campaignSelector);

        int approvalCount = 0;
        for (CampaignValues campaignValues : getCampaignValues) {
          if (campaignValues.getCampaign().getUrlReviewData().getUrlApprovalStatus() != null) {
            switch (campaignValues.getCampaign().getUrlReviewData().getUrlApprovalStatus()) {
              default:
              case REVIEW:
              case APPROVED_WITH_REVIEW:
                continue;
              case DISAPPROVED:
                throw new Exception("Campaign Review Status failed.");
              case NONE:
              case APPROVED:
                approvalCount++;
            }
          } else {
            throw new Exception("Fail to get CampaignService.");
          }
        }

        if (getCampaignValues.size() == approvalCount) {
          return;
        }
      }
    } catch (Exception e) {
      e.printStackTrace();
      throw e;
    }
  }

  /**
   * check & create upper service object.
   *
   * @return ValuesHolder
   * @throws Exception
   */
  private static ValuesHolder setup() throws Exception {

    ValuesHolder valuesHolderBiddingStrategy = BiddingStrategyServiceSample.create();
    ValuesHolder valuesHolderFeedFolder = FeedFolderServiceSample.create();

    ValuesHolder valuesHolder = new ValuesHolder();
    valuesHolder.setBiddingStrategyValuesList(valuesHolderBiddingStrategy.getBiddingStrategyValuesList());
    valuesHolder.setFeedFolderValuesList(valuesHolderFeedFolder.getFeedFolderValuesList());

    // sleep 30 second.
    System.out.println("\n***** sleep 30 seconds *****\n");
    Thread.sleep(30000);

    return valuesHolder;
  }

  /**
   * create basic Campaign.
   *
   * @return ValuesHolder
   * @throws Exception
   */
  public static ValuesHolder create() throws Exception {

    ValuesHolder parentValuesHolder = setup();
    ValuesRepositoryFacade parentValuesRepositoryFacade = new ValuesRepositoryFacade(parentValuesHolder);
    Long feedFolderId = parentValuesRepositoryFacade.getFeedFolderValuesRepository().findFeedFolderId(
        FeedFolderPlaceholderType.DYNAMIC_AD_FOR_SEARCH_PAGE_FEEDS
    );
    long accountId = SoapUtils.getAccountId();

    List<Long> feedFolderIds = new ArrayList<>();
    feedFolderIds.add(feedFolderId);

    CampaignOperation addCampaignOperation = buildExampleMutateRequest(Operator.ADD, accountId, new ArrayList<Campaign>() {{
      // Standard Campaign
      add(createExampleStandardCampaign("SampleManualCpcStandardCampaign_", createManualBiddingCampaignBiddingStrategy()));
      // MobileApp Campaign
      add(createExampleMobileAppCampaignForIOS("SampleManualCpcIOSCampaign_", createManualBiddingCampaignBiddingStrategy()));
      //
      add(createExampleDynamicAdsForSearchCampaign("SampleManualCpcDynamicAdsForSearchCampaign_", feedFolderIds, createManualBiddingCampaignBiddingStrategy()));
    }});

    List<CampaignValues> addCampaignValues = mutate(addCampaignOperation);

    ValuesHolder selfValuesHolder = new ValuesHolder();
    selfValuesHolder.setBiddingStrategyValuesList(parentValuesHolder.getBiddingStrategyValuesList());
    selfValuesHolder.setFeedFolderValuesList(parentValuesHolder.getFeedFolderValuesList());
    selfValuesHolder.setCampaignValuesList(addCampaignValues);

    return selfValuesHolder;
  }

  /**
   * cleanup service object.
   *
   * @param valuesHolder ValuesHolder
   * @throws Exception
   */
  public static void cleanup(ValuesHolder valuesHolder) throws Exception {
    long accountId = SoapUtils.getAccountId();

    if (valuesHolder.getCampaignValuesList().size() > 0) {
      ValuesRepositoryFacade valuesRepositoryFacade = new ValuesRepositoryFacade(valuesHolder);
      CampaignOperation removeCampaignOperation =
          buildExampleMutateRequest(Operator.REMOVE, accountId, valuesRepositoryFacade.getCampaignValuesRepository().getCampaigns());

      mutate(removeCampaignOperation);
    }
    BiddingStrategyServiceSample.cleanup(valuesHolder);
    FeedFolderServiceSample.cleanup(valuesHolder);
  }

  /**
   * Sample Program for CampaignService GET.
   *
   * @param selector CampaignSelector
   * @return CampaignValues
   */
  public static List<CampaignValues> get(CampaignSelector selector) throws Exception {

    // Call API
    System.out.println("############################################");
    System.out.println("CampaignService::get");
    System.out.println("############################################");

    Holder<CampaignPage> campaignPageHolder = new Holder<CampaignPage>();
    Holder<List<Error>> errorHolder = new Holder<List<Error>>();
    CampaignServiceInterface CampaignService = SoapUtils.createServiceInterface(CampaignServiceInterface.class, CampaignService.class);
    CampaignService.get(selector, campaignPageHolder, errorHolder);

    SoapUtils.checkSoapError(errorHolder, campaignPageHolder.value.getValues());

    // Response
    return campaignPageHolder.value.getValues();
  }

  /**
   * example campaigns set request.
   *
   * @param campaigns
   * @return List<Campaign>
   */
  public static List<Campaign> createExampleSetRequest(List<Campaign> campaigns) {
    // create operands
    List<Campaign> operands = new ArrayList<>();

    for (Campaign campaign : campaigns) {

      Campaign operand = new Campaign();
      operand.setCampaignId(campaign.getCampaignId());
      operand.setCampaignName("Sample_UpdateOn_" + campaign.getCampaignId() + "_" + SoapUtils.getCurrentTimestamp());
      operand.setUserStatus(UserStatus.PAUSED);
      operand.setEndDate("20371231");

      // set budget
      Budget budget = new Budget();
      budget.setAmount((long) 2000);
      budget.setDeliveryMethod(BudgetDeliveryMethod.ACCELERATED);
      operand.setBudget(budget);

      // set trackingUrl & customParameters
      if (CampaignType.STANDARD.equals(campaign.getCampaignType()) || CampaignType.DYNAMIC_ADS_FOR_SEARCH.equals(campaign.getCampaignType()) || (CampaignType.MOBILE_APP.equals(campaign.getCampaignType()) && AppStore.IOS.equals(campaign.getAppStore()))) {
        operand.setTrackingUrl("http://yahoo.co.jp?url={lpurl}&amp;a={creative}&amp;pid={_id2}");

        // set customParameters
        CustomParameter customParameter = new CustomParameter();
        customParameter.setKey("id2");
        customParameter.setValue("5678");
        CustomParameters customParameters = new CustomParameters();
        customParameters.getParameters().add(customParameter);
        operand.setCustomParameters(customParameters);
      }
      operands.add(operand);
    }

    return operands;
  }

  /**
   * create sample request.
   *
   * @param accountId      long
   * @param campaignValues CampaignValues
   * @return CampaignOperation
   */
  public static CampaignOperation createSampleRemoveRequest(long accountId, List<CampaignValues> campaignValues) {
    // Set Operation
    CampaignOperation operation = new CampaignOperation();
    operation.setOperator(Operator.REMOVE);
    operation.setAccountId(accountId);

    // Set Operand
    for (CampaignValues campaignValue : campaignValues) {

      Campaign campaign = new Campaign();
      campaign.setAccountId(campaignValue.getCampaign().getAccountId());
      campaign.setCampaignId(campaignValue.getCampaign().getCampaignId());

      operation.getOperand().add(campaign);
    }

    return operation;
  }

  /**
   * example get request.
   *
   * @param accountId   long
   * @param campaignIds List<Long>
   * @return CampaignSelector
   */
  public static CampaignSelector buildExampleGetRequest(long accountId, List<Long> campaignIds) {

    CampaignSelector selector = new CampaignSelector();
    selector.setAccountId(accountId);

    if (campaignIds.size() > 0) {
      selector.getCampaignIds().addAll(campaignIds);
    }
    selector.getUserStatuses().addAll(Arrays.asList(UserStatus.ACTIVE, UserStatus.PAUSED));

    // Set Paging
    Paging paging = new Paging();
    paging.setStartIndex(1);
    paging.setNumberResults(20);
    selector.setPaging(paging);

    return selector;
  }
}

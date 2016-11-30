package jp.co.yahoo.ad_api_sample.adSample;

import jp.co.yahoo.ad_api_sample.error.impl.CampaignServiceErrorEntityFactory;
import jp.co.yahoo.ad_api_sample.util.SoapUtils;
import jp.yahooapis.ss.V6.CampaignService.AdServingOptimizationStatus;
import jp.yahooapis.ss.V6.CampaignService.AppStore;
import jp.yahooapis.ss.V6.CampaignService.BiddingStrategyType;
import jp.yahooapis.ss.V6.CampaignService.Budget;
import jp.yahooapis.ss.V6.CampaignService.BudgetDeliveryMethod;
import jp.yahooapis.ss.V6.CampaignService.BudgetOptimizerBiddingScheme;
import jp.yahooapis.ss.V6.CampaignService.BudgetPeriod;
import jp.yahooapis.ss.V6.CampaignService.Campaign;
import jp.yahooapis.ss.V6.CampaignService.CampaignBiddingStrategy;
import jp.yahooapis.ss.V6.CampaignService.CampaignOperation;
import jp.yahooapis.ss.V6.CampaignService.CampaignPage;
import jp.yahooapis.ss.V6.CampaignService.CampaignReturnValue;
import jp.yahooapis.ss.V6.CampaignService.CampaignSelector;
import jp.yahooapis.ss.V6.CampaignService.CampaignService;
import jp.yahooapis.ss.V6.CampaignService.CampaignServiceInterface;
import jp.yahooapis.ss.V6.CampaignService.CampaignSettings;
import jp.yahooapis.ss.V6.CampaignService.CampaignType;
import jp.yahooapis.ss.V6.CampaignService.CampaignValues;
import jp.yahooapis.ss.V6.CampaignService.CustomParameter;
import jp.yahooapis.ss.V6.CampaignService.CustomParameters;
import jp.yahooapis.ss.V6.CampaignService.EnhancedCpcBiddingScheme;
import jp.yahooapis.ss.V6.CampaignService.Error;
import jp.yahooapis.ss.V6.CampaignService.GeoTargetType;
import jp.yahooapis.ss.V6.CampaignService.GeoTargetTypeSetting;
import jp.yahooapis.ss.V6.CampaignService.ManualCpcBiddingScheme;
import jp.yahooapis.ss.V6.CampaignService.Operator;
import jp.yahooapis.ss.V6.CampaignService.PageOnePromotedBiddingScheme;
import jp.yahooapis.ss.V6.CampaignService.Paging;
import jp.yahooapis.ss.V6.CampaignService.ReviewUrl;
import jp.yahooapis.ss.V6.CampaignService.SettingType;
import jp.yahooapis.ss.V6.CampaignService.TargetCpaBiddingScheme;
import jp.yahooapis.ss.V6.CampaignService.TargetRoasBiddingScheme;
import jp.yahooapis.ss.V6.CampaignService.TargetSpendBiddingScheme;
import jp.yahooapis.ss.V6.CampaignService.UrlApprovalStatus;
import jp.yahooapis.ss.V6.CampaignService.UrlReviewData;
import jp.yahooapis.ss.V6.CampaignService.UserStatus;

import java.util.Arrays;
import java.util.List;

import javax.xml.ws.Holder;

/**
 * Sample Program for CampaignService. Copyright (C) 2012 Yahoo Japan Corporation. All Rights
 * Reserved.
 */
public class CampaignServiceSample {

  /**
   * main method for CampaignServiceSample
   *
   * @param args command line arguments
   */
  public static void main(String[] args) throws Exception {
    try {
      // =================================================================
      // Setting
      // =================================================================
      long accountId = SoapUtils.getAccountId();
      long biddingStrategyId = SoapUtils.getBiddingStrategyId();

      // =================================================================
      // CampaignService::ADD
      // =================================================================
      // Set Operation
      CampaignOperation addCampaignOperation = createSampleAddRequest(accountId, biddingStrategyId);

      // Run
      List<CampaignValues> addCampaignValues = add(addCampaignOperation);

      boolean allApproved = true;
      // call 30sec sleep * 30 = 15minute
      for (int i = 0; i < 30; i++) {
        // sleep 30 second.
        System.out.println("\n***** sleep 30 seconds for Get Campaign  *****\n");
        Thread.sleep(30000);

        // =================================================================
        // CampaignService::GET
        // =================================================================
        // Set Selector
        CampaignSelector campaignSelector = createSampleGetRequest(accountId, addCampaignValues);

        // Run
        List<CampaignValues> getCampaignValues = get(campaignSelector);

        allApproved = true;
        for (CampaignValues campaignValues : getCampaignValues) {
          if (!UrlApprovalStatus.APPROVED.equals(campaignValues.getCampaign().getUrlReviewData().getUrlApprovalStatus())
              && !UrlApprovalStatus.NONE.equals(campaignValues.getCampaign().getUrlReviewData().getUrlApprovalStatus())) {
            allApproved = false;
          } else if(UrlApprovalStatus.DISAPPROVED.equals(campaignValues.getCampaign().getUrlReviewData().getUrlApprovalStatus())){
            System.out.println("Error : This campaign was denied.");
            campaignValues.getCampaign().getUrlReviewData().getDisapprovalReasonCodes().stream().forEach(
                disapprovalReasonCode -> System.out.println("disapprovalReasonCode:[" + disapprovalReasonCode + "]")
            );

          }
        }
        if (allApproved) {
          break;
        }
      }

      if (!allApproved) {

        // =================================================================
        // CampaignService::REMOVE
        // =================================================================
        // Set Operation
        CampaignOperation removeCampaignOperation = createSampleRemoveRequest(accountId, addCampaignValues);
        // Run
        remove(removeCampaignOperation);
        System.exit(5);
      } else {
        // =================================================================
        // CampaignService::SET
        // =================================================================
        // Set Operation
        CampaignOperation setCampaignOperation = createSampleSetRequest(accountId, biddingStrategyId, addCampaignValues);

        // Run
        set(setCampaignOperation);
      }

      // =================================================================
      // CampaignService::REMOVE
      // =================================================================
      // Set Operation
      CampaignOperation removeCampaignOperation = createSampleRemoveRequest(accountId, addCampaignValues);

      // Run
      remove(removeCampaignOperation);

    } catch (Exception e) {
      e.printStackTrace();
      throw e;
    }
  }

  /**
   * Sample Program for CampaignService ADD.
   *
   * @param operation CampaignOperation
   * @return CampaignValues
   */
  public static List<CampaignValues> add(CampaignOperation operation) throws Exception {

    // Call API
    System.out.println("############################################");
    System.out.println("CampaignService::mutate(ADD)");
    System.out.println("############################################");

    Holder<CampaignReturnValue> campaignReturnValueHolder = new Holder<CampaignReturnValue>();
    Holder<List<Error>> errorHolder = new Holder<List<Error>>();
    CampaignServiceInterface campaignService = SoapUtils.createServiceInterface(CampaignServiceInterface.class, CampaignService.class);
    campaignService.mutate(operation, campaignReturnValueHolder, errorHolder);

    // Error
    if (errorHolder.value != null && errorHolder.value.size() > 0) {
      SoapUtils.displayErrors(new CampaignServiceErrorEntityFactory(errorHolder.value), true);
    }
    if (campaignReturnValueHolder.value == null) {
      throw new Exception("NoDataResponse:CampaignService Add");
    }

    // Display
    for (CampaignValues campaignValues : campaignReturnValueHolder.value.getValues()) {
      if (campaignValues.isOperationSucceeded()) {
        display(campaignValues.getCampaign());
      } else {
        SoapUtils.displayErrors(new CampaignServiceErrorEntityFactory(campaignValues.getError()), true);
      }
    }

    // Response
    return campaignReturnValueHolder.value.getValues();
  }

  /**
   * Sample Program for CampaignService SET.
   *
   * @param operation CampaignOperation
   * @return CampaignValues
   */
  public static List<CampaignValues> set(CampaignOperation operation) throws Exception {

    // Call API
    System.out.println("############################################");
    System.out.println("CampaignService::mutate(SET)");
    System.out.println("############################################");

    Holder<CampaignReturnValue> campaignReturnValueHolder = new Holder<CampaignReturnValue>();
    Holder<List<Error>> errorHolder = new Holder<List<Error>>();
    CampaignServiceInterface campaignService = SoapUtils.createServiceInterface(CampaignServiceInterface.class, CampaignService.class);
    campaignService.mutate(operation, campaignReturnValueHolder, errorHolder);

    // Error
    if (errorHolder.value != null && errorHolder.value.size() > 0) {
      SoapUtils.displayErrors(new CampaignServiceErrorEntityFactory(errorHolder.value), true);
    }
    if (campaignReturnValueHolder.value == null) {
      throw new Exception("NoDataResponse:CampaignService Set");
    }

    // Display
    for (CampaignValues campaignValues : campaignReturnValueHolder.value.getValues()) {
      if (campaignValues.isOperationSucceeded()) {
        display(campaignValues.getCampaign());
      } else {
        SoapUtils.displayErrors(new CampaignServiceErrorEntityFactory(campaignValues.getError()), true);
      }
    }

    // Response
    return campaignReturnValueHolder.value.getValues();
  }

  /**
   * Sample Program for CampaignService REMOVE.
   *
   * @param operation CampaignOperation
   * @return CampaignValues
   */
  public static List<CampaignValues> remove(CampaignOperation operation) throws Exception {

    // Call API
    System.out.println("############################################");
    System.out.println("CampaignService::mutate(REMOVE)");
    System.out.println("############################################");

    Holder<CampaignReturnValue> campaignReturnValueHolder = new Holder<CampaignReturnValue>();
    Holder<List<Error>> errorHolder = new Holder<List<Error>>();
    CampaignServiceInterface campaignService = SoapUtils.createServiceInterface(CampaignServiceInterface.class, CampaignService.class);
    campaignService.mutate(operation, campaignReturnValueHolder, errorHolder);

    // Error
    if (errorHolder.value != null && errorHolder.value.size() > 0) {
      SoapUtils.displayErrors(new CampaignServiceErrorEntityFactory(errorHolder.value), true);
    }
    if (campaignReturnValueHolder.value == null) {
      throw new Exception("NoDataResponse:CampaignService Remove");
    }

    // Display
    for (CampaignValues campaignValues : campaignReturnValueHolder.value.getValues()) {
      if (campaignValues.isOperationSucceeded()) {
        display(campaignValues.getCampaign());
      } else {
        SoapUtils.displayErrors(new CampaignServiceErrorEntityFactory(campaignValues.getError()), true);
      }
    }

    // Response
    return campaignReturnValueHolder.value.getValues();
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

    // Error
    if (errorHolder.value != null && errorHolder.value.size() > 0) {
      SoapUtils.displayErrors(new CampaignServiceErrorEntityFactory(errorHolder.value), true);
    }
    if (campaignPageHolder.value == null) {
      throw new Exception("NoDataResponse:CampaignService Get");
    }

    // Display
    for (CampaignValues CampaignValues : campaignPageHolder.value.getValues()) {
      if (CampaignValues.isOperationSucceeded()) {
        display(CampaignValues.getCampaign());
      } else {
        SoapUtils.displayErrors(new CampaignServiceErrorEntityFactory(CampaignValues.getError()), true);
      }
    }

    // Response
    return campaignPageHolder.value.getValues();
  }

  /**
   * display Campaign entity to stdout.
   *
   * @param campaign Campaign entity for display.
   */
  public static void display(Campaign campaign) {

    System.out.println("accountId = " + campaign.getAccountId());
    System.out.println("campaignId = " + campaign.getCampaignId());
    System.out.println("campaignTrackId = " + campaign.getCampaignTrackId());
    System.out.println("campaignName = " + campaign.getCampaignName());
    System.out.println("userStatus = " + campaign.getUserStatus());
    System.out.println("startDate = " + campaign.getStartDate());
    System.out.println("endDate = " + campaign.getEndDate());
    if (campaign.getBudget() != null) {
      System.out.println("budget/period = " + campaign.getBudget().getPeriod());
      System.out.println("budget/amount = " + campaign.getBudget().getAmount());
      System.out.println("budget/deliveryMethod = " + campaign.getBudget().getDeliveryMethod());
    }
    if (campaign.getBiddingStrategyConfiguration() != null) {
      System.out.println("biddingStrategyConfiguration/biddingStrategyId = " + campaign.getBiddingStrategyConfiguration().getBiddingStrategyId());
      System.out.println("biddingStrategyConfiguration/biddingStrategyName = " + campaign.getBiddingStrategyConfiguration().getBiddingStrategyName());
      System.out.println("biddingStrategyConfiguration/biddingStrategyType = " + campaign.getBiddingStrategyConfiguration().getBiddingStrategyType());
      System.out.println("biddingStrategyConfiguration/biddingStrategySource = " + campaign.getBiddingStrategyConfiguration().getBiddingStrategySource());

      if (campaign.getBiddingStrategyConfiguration().getBiddingScheme() instanceof EnhancedCpcBiddingScheme) {
        EnhancedCpcBiddingScheme enhancedCpcBiddingScheme = (EnhancedCpcBiddingScheme) campaign.getBiddingStrategyConfiguration().getBiddingScheme();
        System.out.println("biddingStrategyConfiguration/biddingScheme(EnhancedCpcBiddingScheme)/biddingStrategyType = " + enhancedCpcBiddingScheme.getBiddingStrategyType());
      } else if (campaign.getBiddingStrategyConfiguration().getBiddingScheme() instanceof PageOnePromotedBiddingScheme) {
        PageOnePromotedBiddingScheme pageOnePromotedBiddingScheme = (PageOnePromotedBiddingScheme) campaign.getBiddingStrategyConfiguration().getBiddingScheme();
        System.out.println("biddingStrategyConfiguration/biddingScheme(PageOnePromotedBiddingScheme)/biddingStrategyType = " + pageOnePromotedBiddingScheme.getBiddingStrategyType());
        System.out.println("biddingStrategyConfiguration/biddingScheme(PageOnePromotedBiddingScheme)/bidCeiling = " + pageOnePromotedBiddingScheme.getBidCeiling());
        System.out.println("biddingStrategyConfiguration/biddingScheme(PageOnePromotedBiddingScheme)/bidMultiplier = " + pageOnePromotedBiddingScheme.getBidMultiplier());
        System.out.println("biddingStrategyConfiguration/biddingScheme(PageOnePromotedBiddingScheme)/bidChangesForRaisesOnly = " + pageOnePromotedBiddingScheme.getBidChangesForRaisesOnly());
        System.out.println("biddingStrategyConfiguration/biddingScheme(PageOnePromotedBiddingScheme)/raiseBidWhenBudgetConstrained = "
            + pageOnePromotedBiddingScheme.getRaiseBidWhenBudgetConstrained());
        System.out.println("biddingStrategyConfiguration/biddingScheme(PageOnePromotedBiddingScheme)/raiseBidWhenLowQualityScore = " + pageOnePromotedBiddingScheme.getRaiseBidWhenLowQualityScore());
      } else if (campaign.getBiddingStrategyConfiguration().getBiddingScheme() instanceof TargetCpaBiddingScheme) {
        TargetCpaBiddingScheme targetCpaBiddingScheme = (TargetCpaBiddingScheme) campaign.getBiddingStrategyConfiguration().getBiddingScheme();
        System.out.println("biddingStrategyConfiguration/biddingScheme(TargetCpaBiddingScheme)/biddingStrategyType = " + targetCpaBiddingScheme.getBiddingStrategyType());
        System.out.println("biddingStrategyConfiguration/biddingScheme(TargetCpaBiddingScheme)/targetCpa = " + targetCpaBiddingScheme.getTargetCpa());
        System.out.println("biddingStrategyConfiguration/biddingScheme(TargetCpaBiddingScheme)/bidCeiling = " + targetCpaBiddingScheme.getBidCeiling());
        System.out.println("biddingStrategyConfiguration/biddingScheme(TargetCpaBiddingScheme)/bidFloor = " + targetCpaBiddingScheme.getBidFloor());
      } else if (campaign.getBiddingStrategyConfiguration().getBiddingScheme() instanceof TargetSpendBiddingScheme) {
        TargetSpendBiddingScheme targetSpendBiddingScheme = (TargetSpendBiddingScheme) campaign.getBiddingStrategyConfiguration().getBiddingScheme();
        System.out.println("biddingStrategyConfiguration/biddingScheme(TargetSpendBiddingScheme)/biddingStrategyType = " + targetSpendBiddingScheme.getBiddingStrategyType());
        System.out.println("biddingStrategyConfiguration/biddingScheme(TargetSpendBiddingScheme)/bidCeiling = " + targetSpendBiddingScheme.getBidCeiling());
        System.out.println("biddingStrategyConfiguration/biddingScheme(TargetSpendBiddingScheme)/spendTarget = " + targetSpendBiddingScheme.getSpendTarget());
      } else if (campaign.getBiddingStrategyConfiguration().getBiddingScheme() instanceof TargetRoasBiddingScheme) {
        TargetRoasBiddingScheme targetRoasBiddingScheme = (TargetRoasBiddingScheme) campaign.getBiddingStrategyConfiguration().getBiddingScheme();
        System.out.println("biddingStrategyConfiguration/biddingScheme(TargetRoasBiddingScheme)/biddingStrategyType = " + targetRoasBiddingScheme.getBiddingStrategyType());
        System.out.println("biddingStrategyConfiguration/biddingScheme(TargetRoasBiddingScheme)/targetRoas = " + targetRoasBiddingScheme.getTargetRoas());
        System.out.println("biddingStrategyConfiguration/biddingScheme(TargetRoasBiddingScheme)/bidCeiling = " + targetRoasBiddingScheme.getBidCeiling());
        System.out.println("biddingStrategyConfiguration/biddingScheme(TargetRoasBiddingScheme)/bidFloor = " + targetRoasBiddingScheme.getBidFloor());
      } else if (campaign.getBiddingStrategyConfiguration().getBiddingScheme() instanceof ManualCpcBiddingScheme) {
        ManualCpcBiddingScheme manualCpcBiddingScheme = (ManualCpcBiddingScheme) campaign.getBiddingStrategyConfiguration().getBiddingScheme();
        System.out.println("biddingStrategyConfiguration/biddingScheme(ManualCpcBiddingScheme)/biddingStrategyType = " + manualCpcBiddingScheme.getBiddingStrategyType());
      } else if (campaign.getBiddingStrategyConfiguration().getBiddingScheme() instanceof BudgetOptimizerBiddingScheme) {
        BudgetOptimizerBiddingScheme budgetOptimizerBiddingScheme = (BudgetOptimizerBiddingScheme) campaign.getBiddingStrategyConfiguration().getBiddingScheme();
        System.out.println("biddingStrategyConfiguration/biddingScheme(BudgetOptimizerBiddingScheme)/biddingStrategyType = " + budgetOptimizerBiddingScheme.getBiddingStrategyType());
        System.out.println("biddingStrategyConfiguration/biddingScheme(BudgetOptimizerBiddingScheme)/bidCeiling = " + budgetOptimizerBiddingScheme.getBidCeiling());
      }
    }

    System.out.println("conversionOptimizerEligibility = " + campaign.getConversionOptimizerEligibility());
    System.out.println("adServingOptimizationStatus = " + campaign.getAdServingOptimizationStatus());

    if (campaign.getSettings() != null) {
      for (CampaignSettings settings : campaign.getSettings()) {
        if (settings instanceof GeoTargetTypeSetting) {
          System.out.println("settings(GeoTargetTypeSetting)/type = " + settings.getType());
          GeoTargetTypeSetting geoTargetTypeSetting = (GeoTargetTypeSetting) settings;
          System.out.println("settings(GeoTargetTypeSetting)/positiveGeoTargetType = " + geoTargetTypeSetting.getPositiveGeoTargetType());
          System.out.println("settings(GeoTargetTypeSetting)/negativeGeoTargetType = " + geoTargetTypeSetting.getNegativeGeoTargetType());

        }
      }
    }

    System.out.println("campaignType = " + campaign.getCampaignType());
    System.out.println("appStore = " + campaign.getAppStore());
    System.out.println("appId = " + campaign.getAppId());

    System.out.println("trackingUrl = " + campaign.getTrackingUrl());
    if (null != campaign.getCustomParameters()) {
      CustomParameters customParameters = campaign.getCustomParameters();
      System.out.println("customParameters/isRemove = " + customParameters.getIsRemove());

      if (null != customParameters.getParameters()) {
        int index = 0;
        for (CustomParameter parameter : customParameters.getParameters()) {
          System.out.println("customParameters/parameters[" + index + "]/key = " + parameter.getKey());
          System.out.println("customParameters/parameters[" + index + "]/value = " + parameter.getValue());
          index++;
        }
      }
    }

    if (null != campaign.getUrlReviewData()) {
      UrlReviewData urlReviewData = campaign.getUrlReviewData();
      if (null != urlReviewData.getInReviewUrl()) {
        ReviewUrl inReviewUrl = urlReviewData.getInReviewUrl();
        if (null != inReviewUrl) {
          System.out.println("urlReviewData/inReviewUrl/trackingUrl = " + inReviewUrl.getTrackingUrl());
          if (null != inReviewUrl.getParameters()) {
            int index = 0;
            for (CustomParameter parameter : inReviewUrl.getParameters()) {
              System.out.println("urlReviewData/inReviewUrl/parameters[" + index + "]/key = " + parameter.getKey());
              System.out.println("urlReviewData/inReviewUrl/parameters[" + index + "]/value = " + parameter.getValue());
              index++;
            }
          }
        }
      }

      if (null != urlReviewData.getInReviewUrl()) {
        ReviewUrl disapprovalReviewUrl = urlReviewData.getDisapprovalReviewUrl();
        if (null != disapprovalReviewUrl) {
          System.out.println("urlReviewData/disapprovalReviewUrl/trackingUrl = " + disapprovalReviewUrl.getTrackingUrl());
          if (null != disapprovalReviewUrl.getParameters()) {
            int index = 0;
            for (CustomParameter parameter : disapprovalReviewUrl.getParameters()) {
              System.out.println("urlReviewData/disapprovalReviewUrl/parameters[" + index + "]/key = " + parameter.getKey());
              System.out.println("urlReviewData/disapprovalReviewUrl/parameters[" + index + "]/value = " + parameter.getValue());
              index++;
            }
          }
        }
      }

      System.out.println("urlReviewData/urlApprovalStatus = " + urlReviewData.getUrlApprovalStatus());

      if (null != urlReviewData.getDisapprovalReasonCodes()) {
        for (String disapprovalReasonCode : urlReviewData.getDisapprovalReasonCodes()) {
          System.out.println("urlReviewData/disapprovalReasonCodes = " + disapprovalReasonCode);
        }
      }

    }

    System.out.println("---------");
  }

  /**
   * create sample request.
   *
   * @param accountId         long
   * @param biddingStrategyId long
   * @return CampaignOperation
   */
  public static CampaignOperation createSampleAddRequest(long accountId, long biddingStrategyId) {
    // Set Operation
    CampaignOperation operation = new CampaignOperation();
    operation.setOperator(Operator.ADD);
    operation.setAccountId(accountId);

    // Set Budget
    Budget budget = new Budget();
    budget.setPeriod(BudgetPeriod.DAILY);
    budget.setAmount((long) 1000);
    budget.setDeliveryMethod(BudgetDeliveryMethod.STANDARD);

    // Set GeoTargetTypeSetting
    GeoTargetTypeSetting geoTargetTypeSetting = new GeoTargetTypeSetting();
    geoTargetTypeSetting.setType(SettingType.GEO_TARGET_TYPE_SETTING);
    geoTargetTypeSetting.setPositiveGeoTargetType(GeoTargetType.AREA_OF_INTENT);
    geoTargetTypeSetting.setNegativeGeoTargetType(GeoTargetType.LOCATION_OF_PRESENCE);

    // Set AutoBidding
    CampaignBiddingStrategy autoBiddingStrategy = new CampaignBiddingStrategy();
    autoBiddingStrategy.setBiddingStrategyId(biddingStrategyId);

    // Set ManualCpc
    CampaignBiddingStrategy manualCpcStrategy = new CampaignBiddingStrategy();
    manualCpcStrategy.setBiddingStrategyType(BiddingStrategyType.MANUAL_CPC);

    // Set CustomParameters
    CustomParameters customParameters = new CustomParameters();
    CustomParameter parameter1 = new CustomParameter();
    parameter1.setKey("id1");
    parameter1.setValue("1234");
    customParameters.getParameters().addAll(Arrays.asList(parameter1));

    // Set AutoBidding Campaign
    Campaign autoBiddingCampaign = new Campaign();
    autoBiddingCampaign.setAccountId(accountId);
    autoBiddingCampaign.setCampaignName("SampleAutoBiddingCampaign_CreateOn_" + SoapUtils.getCurrentTimestamp());
    autoBiddingCampaign.setUserStatus(UserStatus.ACTIVE);
    autoBiddingCampaign.setStartDate("20300101");
    autoBiddingCampaign.setEndDate("20301231");
    autoBiddingCampaign.setBudget(budget);
    autoBiddingCampaign.setBiddingStrategyConfiguration(autoBiddingStrategy);
    autoBiddingCampaign.setAdServingOptimizationStatus(AdServingOptimizationStatus.CONVERSION_OPTIMIZE);
    autoBiddingCampaign.getSettings().add(geoTargetTypeSetting);
    autoBiddingCampaign.setCampaignType(CampaignType.STANDARD);

    autoBiddingCampaign.setTrackingUrl("http://yahoo.co.jp?url={lpurl}&amp;a={creative}&amp;pid={_id1}");
    autoBiddingCampaign.setCustomParameters(customParameters);


    // Set ManualCpc Campaign
    Campaign manualCpcCampaign = new Campaign();
    manualCpcCampaign.setAccountId(accountId);
    manualCpcCampaign.setCampaignName("SampleManualCpcCampaign_CreateOn_" + SoapUtils.getCurrentTimestamp());
    manualCpcCampaign.setUserStatus(UserStatus.ACTIVE);
    manualCpcCampaign.setStartDate("20300101");
    manualCpcCampaign.setEndDate("20301231");
    manualCpcCampaign.setBudget(budget);
    manualCpcCampaign.setBiddingStrategyConfiguration(manualCpcStrategy);
    manualCpcCampaign.setAdServingOptimizationStatus(AdServingOptimizationStatus.CONVERSION_OPTIMIZE);
    manualCpcCampaign.getSettings().add(geoTargetTypeSetting);
    manualCpcCampaign.setCampaignType(CampaignType.STANDARD);

    manualCpcCampaign.setTrackingUrl("http://yahoo.co.jp?url={lpurl}&amp;a={creative}&amp;pid={_id1}");
    manualCpcCampaign.setCustomParameters(customParameters);

    // Set App Campaign
    Campaign appCampaign = new Campaign();
    appCampaign.setAccountId(accountId);
    appCampaign.setCampaignName("SampleAppCampaign_CreateOn_" + SoapUtils.getCurrentTimestamp());
    appCampaign.setUserStatus(UserStatus.ACTIVE);
    appCampaign.setStartDate("20300101");
    appCampaign.setEndDate("20301231");
    appCampaign.setBudget(budget);
    appCampaign.setBiddingStrategyConfiguration(manualCpcStrategy);
    appCampaign.setAdServingOptimizationStatus(AdServingOptimizationStatus.CONVERSION_OPTIMIZE);
    appCampaign.getSettings().add(geoTargetTypeSetting);
    appCampaign.setCampaignType(CampaignType.MOBILE_APP);
    appCampaign.setAppStore(AppStore.IOS);
    appCampaign.setAppId(SoapUtils.getCurrentTimestamp());

    operation.getOperand().addAll(Arrays.asList(autoBiddingCampaign, manualCpcCampaign, appCampaign));

    return operation;
  }

  /**
   * create sample request.
   *
   * @param accountId         long
   * @param biddingStrategyId long
   * @param campaignValues    CampaignValues
   * @return CampaignOperation
   */
  public static CampaignOperation createSampleSetRequest(long accountId, long biddingStrategyId, List<CampaignValues> campaignValues) {
    // Set Operation
    CampaignOperation operation = new CampaignOperation();
    operation.setOperator(Operator.SET);
    operation.setAccountId(accountId);

    // Set Operand
    for (CampaignValues campaignValue : campaignValues) {

      // Set Budget
      Budget budget = new Budget();
      budget.setPeriod(BudgetPeriod.DAILY);
      budget.setAmount((long) 2000);
      budget.setDeliveryMethod(BudgetDeliveryMethod.STANDARD);

      // Set AutoBidding
      CampaignBiddingStrategy autoBiddingStrategy = new CampaignBiddingStrategy();
      autoBiddingStrategy.setBiddingStrategyId(biddingStrategyId);

      Campaign campaign = new Campaign();
      campaign.setAccountId(campaignValue.getCampaign().getAccountId());
      campaign.setCampaignId(campaignValue.getCampaign().getCampaignId());
      campaign.setCampaignName("Sample_UpdateOn_" + campaignValue.getCampaign().getCampaignId() + "_" + SoapUtils.getCurrentTimestamp());
      campaign.setUserStatus(UserStatus.PAUSED);
      campaign.setStartDate("20300101");
      campaign.setEndDate("20301231");
      campaign.setBudget(budget);
      campaign.setAdServingOptimizationStatus(AdServingOptimizationStatus.OPTIMIZE);

      // Change Auto Bidding Strategy
      campaign.setBiddingStrategyConfiguration(autoBiddingStrategy);

      if (CampaignType.STANDARD.equals(campaign.getCampaignType())) {
        campaign.setTrackingUrl("http://yahoo.co.jp?url={lpurl}&amp;a={creative}&amp;pid={_id2}");
        // Set CustomParameters
        CustomParameters customParameters = new CustomParameters();
        CustomParameter parameter1 = new CustomParameter();
        parameter1.setKey("id2");
        parameter1.setValue("5678");
        customParameters.getParameters().addAll(Arrays.asList(parameter1));
        campaign.setCustomParameters(customParameters);
      }
      operation.getOperand().add(campaign);
    }

    return operation;
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
   * create sample request.
   *
   * @param accountId      long
   * @param campaignValues CampaignValues
   * @return CampaignSelector
   */
  public static CampaignSelector createSampleGetRequest(long accountId, List<CampaignValues> campaignValues) {
    // Set Selector
    CampaignSelector selector = new CampaignSelector();
    selector.setAccountId(accountId);
    for (CampaignValues campaignValue : campaignValues) {
      selector.getCampaignIds().add((campaignValue.getCampaign().getCampaignId()));
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

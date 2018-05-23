package jp.co.yahoo.ad_api_sample.adSample;

import jp.co.yahoo.ad_api_sample.error.impl.AdGroupCriterionServiceErrorEntityFactory;
import jp.co.yahoo.ad_api_sample.util.SoapUtils;
import jp.yahooapis.ss.v201805.Error;
import jp.yahooapis.ss.v201805.Paging;
import jp.yahooapis.ss.v201805.adgroupcriterion.AdGroupCriterion;
import jp.yahooapis.ss.v201805.adgroupcriterion.AdGroupCriterionAdditionalAdvancedMobileUrls;
import jp.yahooapis.ss.v201805.adgroupcriterion.AdGroupCriterionAdditionalAdvancedUrls;
import jp.yahooapis.ss.v201805.adgroupcriterion.AdGroupCriterionAdditionalUrl;
import jp.yahooapis.ss.v201805.adgroupcriterion.AdGroupCriterionBiddingStrategy;
import jp.yahooapis.ss.v201805.adgroupcriterion.AdGroupCriterionOperation;
import jp.yahooapis.ss.v201805.adgroupcriterion.AdGroupCriterionPage;
import jp.yahooapis.ss.v201805.adgroupcriterion.AdGroupCriterionReturnValue;
import jp.yahooapis.ss.v201805.adgroupcriterion.AdGroupCriterionSelector;
import jp.yahooapis.ss.v201805.adgroupcriterion.AdGroupCriterionService;
import jp.yahooapis.ss.v201805.adgroupcriterion.AdGroupCriterionServiceInterface;
import jp.yahooapis.ss.v201805.adgroupcriterion.AdGroupCriterionUse;
import jp.yahooapis.ss.v201805.adgroupcriterion.AdGroupCriterionValues;
import jp.yahooapis.ss.v201805.adgroupcriterion.ApprovalStatus;
import jp.yahooapis.ss.v201805.adgroupcriterion.Bid;
import jp.yahooapis.ss.v201805.adgroupcriterion.BiddableAdGroupCriterion;
import jp.yahooapis.ss.v201805.adgroupcriterion.BudgetOptimizerBiddingScheme;
import jp.yahooapis.ss.v201805.adgroupcriterion.Criterion;
import jp.yahooapis.ss.v201805.adgroupcriterion.CriterionType;
import jp.yahooapis.ss.v201805.adgroupcriterion.CustomParameter;
import jp.yahooapis.ss.v201805.adgroupcriterion.CustomParameters;
import jp.yahooapis.ss.v201805.adgroupcriterion.EnhancedCpcBiddingScheme;
import jp.yahooapis.ss.v201805.adgroupcriterion.IsRemove;
import jp.yahooapis.ss.v201805.adgroupcriterion.Keyword;
import jp.yahooapis.ss.v201805.adgroupcriterion.KeywordMatchType;
import jp.yahooapis.ss.v201805.adgroupcriterion.ManualCpcBiddingScheme;
import jp.yahooapis.ss.v201805.adgroupcriterion.Operator;
import jp.yahooapis.ss.v201805.adgroupcriterion.PageOnePromotedBiddingScheme;
import jp.yahooapis.ss.v201805.adgroupcriterion.TargetCpaBiddingScheme;
import jp.yahooapis.ss.v201805.adgroupcriterion.TargetRoasBiddingScheme;
import jp.yahooapis.ss.v201805.adgroupcriterion.TargetSpendBiddingScheme;
import jp.yahooapis.ss.v201805.adgroupcriterion.UserStatus;

import java.util.Arrays;
import java.util.List;

import javax.xml.ws.Holder;


/**
 * Sample Program for AdGroupCriterionService. Copyright (C) 2012 Yahoo Japan Corporation. All
 * Rights Reserved.
 */
public class AdGroupCriterionServiceSample {

  /**
   * main method for AdGroupCriterionServiceSample
   *
   * @param args command line arguments
   */
  public static void main(String[] args) throws Exception {
    try {
      // =================================================================
      // Setting
      // =================================================================
      long accountId = SoapUtils.getAccountId();
      long campaignId = SoapUtils.getCampaignId();
      long adGroupId = SoapUtils.getAdGroupId();

      // =================================================================
      // AdGroupCriterionService ADD
      // =================================================================
      // Set Operation
      AdGroupCriterionOperation addAdGroupCriterionOperation = createSampleAddRequest(accountId, campaignId, adGroupId);

      // Run
      List<AdGroupCriterionValues> adGroupCriterionValues = add(addAdGroupCriterionOperation);

      boolean allApproved = true;
      // call 30sec sleep * 30 = 15minute
      for (int i = 0; i < 30; i++) {
        // sleep 30 second.
        System.out.println("\n***** sleep 30 seconds *****\n");
        Thread.sleep(30000);

        // =================================================================
        // AdGroupCriterionService GET
        // =================================================================
        // Set Selector
        AdGroupCriterionSelector adGroupCriterionSelector = createSampleGetRequest(accountId, campaignId, adGroupId, adGroupCriterionValues);

        // Run
        List<AdGroupCriterionValues> getAdGroupCriterionValues = get(adGroupCriterionSelector);

        allApproved = true;
        for (AdGroupCriterionValues adGroupCriterionValue : getAdGroupCriterionValues) {
            if (!ApprovalStatus.APPROVED.equals(((BiddableAdGroupCriterion) adGroupCriterionValue.getAdGroupCriterion()).getApprovalStatus())) {
              allApproved = false;
            } else if (ApprovalStatus.POST_DISAPPROVED.equals(((BiddableAdGroupCriterion) adGroupCriterionValue.getAdGroupCriterion()).getApprovalStatus())
                || ApprovalStatus.PRE_DISAPPROVED.equals(((BiddableAdGroupCriterion) adGroupCriterionValue.getAdGroupCriterion()).getApprovalStatus())) {
              System.out.println("Error : This AdGroupCriterion was denied.");
              ((BiddableAdGroupCriterion) adGroupCriterionValue.getAdGroupCriterion()).getDisapprovalReasonCodes().stream().forEach(
                  disapprovalReasonCode -> System.out.println("disapprovalReasonCode:[" + disapprovalReasonCode + "]")
              );
            }
        }
        if (allApproved) {
          break;
        }
      }

      if (!allApproved) {
        System.out.println("Error : The review did not end.");
        // =================================================================
        // AdGroupCriterionService REMOVE
        // =================================================================
        // Set Operation
        AdGroupCriterionOperation removeAdGroupCriterionOperation = createSampleRemoveRequest(accountId, campaignId, adGroupId, adGroupCriterionValues);

        // Run
        remove(removeAdGroupCriterionOperation);
        System.exit(1);
      } else {
        // =================================================================
        // AdGroupCriterionService SET
        // =================================================================
        // Set Operation
        AdGroupCriterionOperation setAdGroupCriterionOperation = createSampleSetRequest(accountId, campaignId, adGroupId, adGroupCriterionValues);

        // Run
        set(setAdGroupCriterionOperation);

        // =================================================================
        // AdGroupCriterionService REMOVE
        // =================================================================
        // Set Operation
        AdGroupCriterionOperation removeAdGroupCriterionOperation = createSampleRemoveRequest(accountId, campaignId, adGroupId, adGroupCriterionValues);

        // Run
        remove(removeAdGroupCriterionOperation);
      }

    } catch (Exception ex) {
      ex.printStackTrace();
    }
  }

  /**
   * Sample Program for AdGroupCriterionService ADD.
   *
   * @param operation AdGroupCriterionOperation
   * @return AdGroupCriterionValues
   * @throws Exception
   */
  public static List<AdGroupCriterionValues> add(AdGroupCriterionOperation operation) throws Exception {

    // Call API
    System.out.println("############################################");
    System.out.println("AdGroupCriterionService::mutate(ADD)");
    System.out.println("############################################");

    Holder<AdGroupCriterionReturnValue> adGroupCriterionReturnValueHolder = new Holder<AdGroupCriterionReturnValue>();
    Holder<List<Error>> errorHolder = new Holder<List<Error>>();
    AdGroupCriterionServiceInterface adGroupCriterionService = SoapUtils.createServiceInterface(AdGroupCriterionServiceInterface.class, AdGroupCriterionService.class);
    adGroupCriterionService.mutate(operation, adGroupCriterionReturnValueHolder, errorHolder);

    // Error
    if (errorHolder.value != null && errorHolder.value.size() > 0) {
      SoapUtils.displayErrors(new AdGroupCriterionServiceErrorEntityFactory(errorHolder.value), true);
    }
    if (adGroupCriterionReturnValueHolder.value == null) {
      throw new Exception("NoDataResponse:AdGroupCriterionService Add");
    }

    // Display
    for (AdGroupCriterionValues adGroupCriterionValues : adGroupCriterionReturnValueHolder.value.getValues()) {
      if (adGroupCriterionValues.isOperationSucceeded()) {
        display(adGroupCriterionValues.getAdGroupCriterion());
      } else {
        SoapUtils.displayErrors(new AdGroupCriterionServiceErrorEntityFactory(adGroupCriterionValues.getError()), true);
      }
    }

    // Response
    return adGroupCriterionReturnValueHolder.value.getValues();
  }

  /**
   * Sample Program for AdGroupCriterionService SET.
   *
   * @param operation AdGroupCriterionOperation
   * @return AdGroupCriterionValues
   * @throws Exception
   */
  public static List<AdGroupCriterionValues> set(AdGroupCriterionOperation operation) throws Exception {

    // Call API
    System.out.println("############################################");
    System.out.println("AdGroupCriterionService::mutate(SET)");
    System.out.println("############################################");

    Holder<AdGroupCriterionReturnValue> adGroupCriterionReturnValueHolder = new Holder<AdGroupCriterionReturnValue>();
    Holder<List<Error>> errorHolder = new Holder<List<Error>>();
    AdGroupCriterionServiceInterface adGroupCriterionService = SoapUtils.createServiceInterface(AdGroupCriterionServiceInterface.class, AdGroupCriterionService.class);
    adGroupCriterionService.mutate(operation, adGroupCriterionReturnValueHolder, errorHolder);

    // Error
    if (errorHolder.value != null && errorHolder.value.size() > 0) {
      SoapUtils.displayErrors(new AdGroupCriterionServiceErrorEntityFactory(errorHolder.value), true);
    }
    if (adGroupCriterionReturnValueHolder.value == null) {
      throw new Exception("NoDataResponse:AdGroupCriterionService Set");
    }

    // Display
    for (AdGroupCriterionValues adGroupCriterionValues : adGroupCriterionReturnValueHolder.value.getValues()) {
      if (adGroupCriterionValues.isOperationSucceeded()) {
        display(adGroupCriterionValues.getAdGroupCriterion());
      } else {
        if(adGroupCriterionValues.getError().get(0).getCode().equals("210508")){
          System.out.println("******* Skip. *******");
          System.out.println("code = " + adGroupCriterionValues.getError().get(0).getCode());
          System.out.println("message = " + adGroupCriterionValues.getError().get(0).getMessage());
        }else {
          SoapUtils.displayErrors(new AdGroupCriterionServiceErrorEntityFactory(adGroupCriterionValues.getError()), true);
        }
      }
    }

    // Response
    return adGroupCriterionReturnValueHolder.value.getValues();
  }

  /**
   * Sample Program for AdGroupCriterionService REMOVE.
   *
   * @param operation AdGroupCriterionOperation
   * @return AdGroupCriterionValues
   * @throws Exception
   */
  public static List<AdGroupCriterionValues> remove(AdGroupCriterionOperation operation) throws Exception {

    // Call API
    System.out.println("############################################");
    System.out.println("AdGroupCriterionService::mutate(REMOVE)");
    System.out.println("############################################");

    Holder<AdGroupCriterionReturnValue> adGroupCriterionReturnValueHolder = new Holder<AdGroupCriterionReturnValue>();
    Holder<List<Error>> errorHolder = new Holder<List<Error>>();
    AdGroupCriterionServiceInterface adGroupCriterionService = SoapUtils.createServiceInterface(AdGroupCriterionServiceInterface.class, AdGroupCriterionService.class);
    adGroupCriterionService.mutate(operation, adGroupCriterionReturnValueHolder, errorHolder);

    // Error
    if (errorHolder.value != null && errorHolder.value.size() > 0) {
      SoapUtils.displayErrors(new AdGroupCriterionServiceErrorEntityFactory(errorHolder.value), true);
    }
    if (adGroupCriterionReturnValueHolder.value == null) {
      throw new Exception("NoDataResponse:AdGroupCriterionService Remove");
    }

    // Display
    for (AdGroupCriterionValues adGroupCriterionValues : adGroupCriterionReturnValueHolder.value.getValues()) {
      if (adGroupCriterionValues.isOperationSucceeded()) {
        display(adGroupCriterionValues.getAdGroupCriterion());
      } else {
        SoapUtils.displayErrors(new AdGroupCriterionServiceErrorEntityFactory(adGroupCriterionValues.getError()), true);
      }
    }

    // Response
    return adGroupCriterionReturnValueHolder.value.getValues();
  }

  /**
   * Sample Program for AdGroupCriterionService GET.
   *
   * @param selector AdGroupCriterionSelector
   * @return AdGroupCriterionValues
   * @throws Exception
   */
  public static List<AdGroupCriterionValues> get(AdGroupCriterionSelector selector) throws Exception {

    // Call API
    System.out.println("############################################");
    System.out.println("AdGroupCriterionService::get");
    System.out.println("############################################");

    Holder<AdGroupCriterionPage> adGroupCriterionPage = new Holder<AdGroupCriterionPage>();
    Holder<List<Error>> errorHolder = new Holder<List<Error>>();
    AdGroupCriterionServiceInterface adGroupCriterionService = SoapUtils.createServiceInterface(AdGroupCriterionServiceInterface.class, AdGroupCriterionService.class);
    adGroupCriterionService.get(selector, adGroupCriterionPage, errorHolder);

    // Error
    if (errorHolder.value != null && errorHolder.value.size() > 0) {
      SoapUtils.displayErrors(new AdGroupCriterionServiceErrorEntityFactory(errorHolder.value), true);
    }
    if (adGroupCriterionPage.value == null) {
      throw new Exception("NoDataResponse:AdGroupCriterionService Get");
    }

    // Display
    for (AdGroupCriterionValues adGroupCriterionValues : adGroupCriterionPage.value.getValues()) {
      if (adGroupCriterionValues.isOperationSucceeded()) {
        display(adGroupCriterionValues.getAdGroupCriterion());
      } else {
        SoapUtils.displayErrors(new AdGroupCriterionServiceErrorEntityFactory(adGroupCriterionValues.getError()), true);
      }
    }

    // Response
    return adGroupCriterionPage.value.getValues();
  }

  /**
   * display AdGroupCriterion entity to stdout.
   *
   * @param adGroupCriterion AdGroupCriterion entity for display.
   */
  public static void display(AdGroupCriterion adGroupCriterion) {

    System.out.println("accountId = " + adGroupCriterion.getAccountId());
    System.out.println("campaignId = " + adGroupCriterion.getCampaignId());
    System.out.println("campaignTrackId = " + adGroupCriterion.getCampaignTrackId());
    System.out.println("campaignName = " + adGroupCriterion.getCampaignName());
    System.out.println("adGroupId = " + adGroupCriterion.getAdGroupId());
    System.out.println("adGroupTrackId = " + adGroupCriterion.getAdGroupTrackId());
    System.out.println("adGroupName = " + adGroupCriterion.getAdGroupName());
    System.out.println("criterionUse = " + adGroupCriterion.getCriterionUse());
    if (adGroupCriterion.getCriterion() != null) {
      Criterion criterion = adGroupCriterion.getCriterion();
      System.out.println("criterion/criterionId = " + criterion.getCriterionId());
      System.out.println("criterion/criterionTrackId = " + criterion.getCriterionTrackId());
      System.out.println("criterion/type = " + criterion.getType());
    }

    if (adGroupCriterion instanceof BiddableAdGroupCriterion) {
      BiddableAdGroupCriterion biddableAdGroupCriterion = (BiddableAdGroupCriterion) adGroupCriterion;
      System.out.println("userStatus = " + biddableAdGroupCriterion.getUserStatus());
      System.out.println("approvalStatus = " + biddableAdGroupCriterion.getApprovalStatus());
      if (biddableAdGroupCriterion.getDisapprovalReasonCodes() != null) {
        for (String disapprovalReasonCode : biddableAdGroupCriterion.getDisapprovalReasonCodes()) {
          System.out.println("disapprovalReasonCode = " + disapprovalReasonCode);
        }
      }
      System.out.println("destinationUrl = " + biddableAdGroupCriterion.getDestinationUrl());
      System.out.println("reviewDestinationUrl = " + biddableAdGroupCriterion.getReviewDestinationUrl());

      if (biddableAdGroupCriterion.getBiddingStrategyConfiguration() != null) {
        System.out.println("biddingStrategyConfiguration/biddingStrategyId = " + biddableAdGroupCriterion.getBiddingStrategyConfiguration().getBiddingStrategyId());
        System.out.println("biddingStrategyConfiguration/biddingStrategyName = " + biddableAdGroupCriterion.getBiddingStrategyConfiguration().getBiddingStrategyName());
        System.out.println("biddingStrategyConfiguration/biddingStrategyType = " + biddableAdGroupCriterion.getBiddingStrategyConfiguration().getBiddingStrategyType());
        System.out.println("biddingStrategyConfiguration/biddingStrategySource = " + biddableAdGroupCriterion.getBiddingStrategyConfiguration().getBiddingStrategySource());

        if (biddableAdGroupCriterion.getBiddingStrategyConfiguration().getBiddingScheme() instanceof EnhancedCpcBiddingScheme) {
          EnhancedCpcBiddingScheme enhancedCpcBiddingScheme = (EnhancedCpcBiddingScheme) biddableAdGroupCriterion.getBiddingStrategyConfiguration().getBiddingScheme();
          System.out.println("biddingStrategyConfiguration/biddingScheme(EnhancedCpcBiddingScheme)/biddingStrategyType = " + enhancedCpcBiddingScheme.getBiddingStrategyType());
        } else if (biddableAdGroupCriterion.getBiddingStrategyConfiguration().getBiddingScheme() instanceof PageOnePromotedBiddingScheme) {
          PageOnePromotedBiddingScheme pageOnePromotedBiddingScheme = (PageOnePromotedBiddingScheme) biddableAdGroupCriterion.getBiddingStrategyConfiguration().getBiddingScheme();
          System.out.println("biddingStrategyConfiguration/biddingScheme(PageOnePromotedBiddingScheme)/biddingStrategyType = " + pageOnePromotedBiddingScheme.getBiddingStrategyType());
          System.out.println("biddingStrategyConfiguration/biddingScheme(PageOnePromotedBiddingScheme)/bidCeiling = " + pageOnePromotedBiddingScheme.getBidCeiling());
          System.out.println("biddingStrategyConfiguration/biddingScheme(PageOnePromotedBiddingScheme)/bidMultiplier = " + pageOnePromotedBiddingScheme.getBidMultiplier());
          System.out.println("biddingStrategyConfiguration/biddingScheme(PageOnePromotedBiddingScheme)/bidChangesForRaisesOnly = " + pageOnePromotedBiddingScheme.getBidChangesForRaisesOnly());
          System.out.println("biddingStrategyConfiguration/biddingScheme(PageOnePromotedBiddingScheme)/raiseBidWhenBudgetConstrained = "
              + pageOnePromotedBiddingScheme.getRaiseBidWhenBudgetConstrained());
          System.out.println("biddingStrategyConfiguration/biddingScheme(PageOnePromotedBiddingScheme)/raiseBidWhenLowQualityScore = " + pageOnePromotedBiddingScheme.getRaiseBidWhenLowQualityScore());
        } else if (biddableAdGroupCriterion.getBiddingStrategyConfiguration().getBiddingScheme() instanceof TargetCpaBiddingScheme) {
          TargetCpaBiddingScheme targetCpaBiddingScheme = (TargetCpaBiddingScheme) biddableAdGroupCriterion.getBiddingStrategyConfiguration().getBiddingScheme();
          System.out.println("biddingStrategyConfiguration/biddingScheme(TargetCpaBiddingScheme)/biddingStrategyType = " + targetCpaBiddingScheme.getBiddingStrategyType());
          System.out.println("biddingStrategyConfiguration/biddingScheme(TargetCpaBiddingScheme)/targetCpa = " + targetCpaBiddingScheme.getTargetCpa());
          System.out.println("biddingStrategyConfiguration/biddingScheme(TargetCpaBiddingScheme)/bidCeiling = " + targetCpaBiddingScheme.getBidCeiling());
          System.out.println("biddingStrategyConfiguration/biddingScheme(TargetCpaBiddingScheme)/bidFloor = " + targetCpaBiddingScheme.getBidFloor());
        } else if (biddableAdGroupCriterion.getBiddingStrategyConfiguration().getBiddingScheme() instanceof TargetSpendBiddingScheme) {
          TargetSpendBiddingScheme targetSpendBiddingScheme = (TargetSpendBiddingScheme) biddableAdGroupCriterion.getBiddingStrategyConfiguration().getBiddingScheme();
          System.out.println("biddingStrategyConfiguration/biddingScheme(TargetSpendBiddingScheme)/biddingStrategyType = " + targetSpendBiddingScheme.getBiddingStrategyType());
          System.out.println("biddingStrategyConfiguration/biddingScheme(TargetSpendBiddingScheme)/bidCeiling = " + targetSpendBiddingScheme.getBidCeiling());
          System.out.println("biddingStrategyConfiguration/biddingScheme(TargetSpendBiddingScheme)/spendTarget = " + targetSpendBiddingScheme.getSpendTarget());
        } else if (biddableAdGroupCriterion.getBiddingStrategyConfiguration().getBiddingScheme() instanceof TargetRoasBiddingScheme) {
          TargetRoasBiddingScheme targetRoasBiddingScheme = (TargetRoasBiddingScheme) biddableAdGroupCriterion.getBiddingStrategyConfiguration().getBiddingScheme();
          System.out.println("biddingStrategyConfiguration/biddingScheme(TargetRoasBiddingScheme)/biddingStrategyType = " + targetRoasBiddingScheme.getBiddingStrategyType());
          System.out.println("biddingStrategyConfiguration/biddingScheme(TargetRoasBiddingScheme)/targetRoas = " + targetRoasBiddingScheme.getTargetRoas());
          System.out.println("biddingStrategyConfiguration/biddingScheme(TargetRoasBiddingScheme)/bidCeiling = " + targetRoasBiddingScheme.getBidCeiling());
          System.out.println("biddingStrategyConfiguration/biddingScheme(TargetRoasBiddingScheme)/bidFloor = " + targetRoasBiddingScheme.getBidFloor());
        } else if (biddableAdGroupCriterion.getBiddingStrategyConfiguration().getBiddingScheme() instanceof ManualCpcBiddingScheme) {
          ManualCpcBiddingScheme manualCpcBiddingScheme = (ManualCpcBiddingScheme) biddableAdGroupCriterion.getBiddingStrategyConfiguration().getBiddingScheme();
          System.out.println("biddingStrategyConfiguration/biddingScheme(ManualCpcBiddingScheme)/biddingStrategyType = " + manualCpcBiddingScheme.getBiddingStrategyType());
        } else if (biddableAdGroupCriterion.getBiddingStrategyConfiguration().getBiddingScheme() instanceof BudgetOptimizerBiddingScheme) {
          BudgetOptimizerBiddingScheme budgetOptimizerBiddingScheme = (BudgetOptimizerBiddingScheme) biddableAdGroupCriterion.getBiddingStrategyConfiguration().getBiddingScheme();
          System.out.println("biddingStrategyConfiguration/biddingScheme(BudgetOptimizerBiddingScheme)/biddingStrategyType = " + budgetOptimizerBiddingScheme.getBiddingStrategyType());
          System.out.println("biddingStrategyConfiguration/biddingScheme(BudgetOptimizerBiddingScheme)/bidCeiling = " + budgetOptimizerBiddingScheme.getBidCeiling());
        }

        if (biddableAdGroupCriterion.getBiddingStrategyConfiguration().getBid() != null) {
          System.out.println("biddingStrategyConfiguration/bid/maxCpc = " + biddableAdGroupCriterion.getBiddingStrategyConfiguration().getBid().getMaxCpc());
          System.out.println("biddingStrategyConfiguration/bid/bidSource = " + biddableAdGroupCriterion.getBiddingStrategyConfiguration().getBid().getBidSource());
          System.out.println("biddingStrategyConfiguration/bid/adGroupMaxCpc = " + biddableAdGroupCriterion.getBiddingStrategyConfiguration().getBid().getAdGroupMaxCpc());
          System.out.println("biddingStrategyConfiguration/bid/keywordMaxCpc = " + biddableAdGroupCriterion.getBiddingStrategyConfiguration().getBid().getKeywordMaxCpc());

        }

        if (biddableAdGroupCriterion.getBiddingStrategyConfiguration().getParentBiddingStrategyConfigurations() != null) {
          for (AdGroupCriterionBiddingStrategy biddingStrategy : biddableAdGroupCriterion.getBiddingStrategyConfiguration().getParentBiddingStrategyConfigurations()) {
            System.out.println("biddingStrategyConfiguration/parentBiddingStrategyConfigurations/biddingStrategyId = " + biddingStrategy.getBiddingStrategyId());
            System.out.println("biddingStrategyConfiguration/parentBiddingStrategyConfigurations/biddingStrategyName = " + biddingStrategy.getBiddingStrategyName());
            System.out.println("biddingStrategyConfiguration/parentBiddingStrategyConfigurations/biddingStrategyType = " + biddingStrategy.getBiddingStrategyType());
            System.out.println("biddingStrategyConfiguration/parentBiddingStrategyConfigurations/biddingStrategySource = " + biddingStrategy.getBiddingStrategySource());

            if (biddingStrategy.getBiddingScheme() instanceof EnhancedCpcBiddingScheme) {
              EnhancedCpcBiddingScheme enhancedCpcBiddingScheme = (EnhancedCpcBiddingScheme) biddingStrategy.getBiddingScheme();
              System.out.println("biddingStrategyConfiguration/parentBiddingStrategyConfigurations/biddingScheme(EnhancedCpcBiddingScheme)/biddingStrategyType = "
                  + enhancedCpcBiddingScheme.getBiddingStrategyType());
            } else if (biddingStrategy.getBiddingScheme() instanceof PageOnePromotedBiddingScheme) {
              PageOnePromotedBiddingScheme pageOnePromotedBiddingScheme = (PageOnePromotedBiddingScheme) biddingStrategy.getBiddingScheme();
              System.out.println("biddingStrategyConfiguration/parentBiddingStrategyConfigurations/biddingScheme(PageOnePromotedBiddingScheme)/biddingStrategyType = "
                  + pageOnePromotedBiddingScheme.getBiddingStrategyType());
              System.out.println("biddingStrategyConfiguration/parentBiddingStrategyConfigurations/biddingScheme(PageOnePromotedBiddingScheme)/bidCeiling = "
                  + pageOnePromotedBiddingScheme.getBidCeiling());
              System.out.println("biddingStrategyConfiguration/parentBiddingStrategyConfigurations/biddingScheme(PageOnePromotedBiddingScheme)/bidMultiplier = "
                  + pageOnePromotedBiddingScheme.getBidMultiplier());
              System.out.println("biddingStrategyConfiguration/parentBiddingStrategyConfigurations/biddingScheme(PageOnePromotedBiddingScheme)/bidChangesForRaisesOnly = "
                  + pageOnePromotedBiddingScheme.getBidChangesForRaisesOnly());
              System.out.println("biddingStrategyConfiguration/parentBiddingStrategyConfigurations/biddingScheme(PageOnePromotedBiddingScheme)/raiseBidWhenBudgetConstrained = "
                  + pageOnePromotedBiddingScheme.getRaiseBidWhenBudgetConstrained());
              System.out.println("biddingStrategyConfiguration/parentBiddingStrategyConfigurations/biddingScheme(PageOnePromotedBiddingScheme)/raiseBidWhenLowQualityScore = "
                  + pageOnePromotedBiddingScheme.getRaiseBidWhenLowQualityScore());
            } else if (biddingStrategy.getBiddingScheme() instanceof TargetCpaBiddingScheme) {
              TargetCpaBiddingScheme targetCpaBiddingScheme = (TargetCpaBiddingScheme) biddingStrategy.getBiddingScheme();
              System.out.println("biddingStrategyConfiguration/parentBiddingStrategyConfigurations/biddingScheme(TargetCpaBiddingScheme)/biddingStrategyType = "
                  + targetCpaBiddingScheme.getBiddingStrategyType());
              System.out.println("biddingStrategyConfiguration/parentBiddingStrategyConfigurations/biddingScheme(TargetCpaBiddingScheme)/targetCpa = " + targetCpaBiddingScheme.getTargetCpa());
              System.out.println("biddingStrategyConfiguration/parentBiddingStrategyConfigurations/biddingScheme(TargetCpaBiddingScheme)/bidCeiling = " + targetCpaBiddingScheme.getBidCeiling());
              System.out.println("biddingStrategyConfiguration/parentBiddingStrategyConfigurations/biddingScheme(TargetCpaBiddingScheme)/bidFloor = " + targetCpaBiddingScheme.getBidFloor());
            } else if (biddingStrategy.getBiddingScheme() instanceof TargetSpendBiddingScheme) {
              TargetSpendBiddingScheme targetSpendBiddingScheme = (TargetSpendBiddingScheme) biddingStrategy.getBiddingScheme();
              System.out.println("biddingStrategyConfiguration/parentBiddingStrategyConfigurations/biddingScheme(TargetSpendBiddingScheme)/biddingStrategyType = "
                  + targetSpendBiddingScheme.getBiddingStrategyType());
              System.out.println("biddingStrategyConfiguration/parentBiddingStrategyConfigurations/biddingScheme(TargetSpendBiddingScheme)/bidCeiling = " + targetSpendBiddingScheme.getBidCeiling());
            } else if (biddingStrategy.getBiddingScheme() instanceof TargetRoasBiddingScheme) {
              TargetRoasBiddingScheme targetRoasBiddingScheme = (TargetRoasBiddingScheme) biddingStrategy.getBiddingScheme();
              System.out.println("biddingStrategyConfiguration/parentBiddingStrategyConfigurations/biddingScheme(TargetRoasBiddingScheme)/biddingStrategyType = "
                  + targetRoasBiddingScheme.getBiddingStrategyType());
              System.out.println("biddingStrategyConfiguration/parentBiddingStrategyConfigurations/biddingScheme(TargetRoasBiddingScheme)/targetRoas = " + targetRoasBiddingScheme.getTargetRoas());
              System.out.println("biddingStrategyConfiguration/parentBiddingStrategyConfigurations/biddingScheme(TargetRoasBiddingScheme)/bidCeiling = " + targetRoasBiddingScheme.getBidCeiling());
              System.out.println("biddingStrategyConfiguration/parentBiddingStrategyConfigurations/biddingScheme(TargetRoasBiddingScheme)/bidFloor = " + targetRoasBiddingScheme.getBidFloor());
            } else if (biddingStrategy.getBiddingScheme() instanceof ManualCpcBiddingScheme) {
              ManualCpcBiddingScheme manualCpcBiddingScheme = (ManualCpcBiddingScheme) biddingStrategy.getBiddingScheme();
              System.out.println("biddingStrategyConfiguration/parentBiddingStrategyConfigurations/biddingScheme(ManualCpcBiddingScheme)/biddingStrategyType = "
                  + manualCpcBiddingScheme.getBiddingStrategyType());
            } else if (biddingStrategy.getBiddingScheme() instanceof BudgetOptimizerBiddingScheme) {
              BudgetOptimizerBiddingScheme budgetOptimizerBiddingScheme = (BudgetOptimizerBiddingScheme) biddingStrategy.getBiddingScheme();
              System.out.println("biddingStrategyConfiguration/parentBiddingStrategyConfigurations/biddingScheme(BudgetOptimizerBiddingScheme)/biddingStrategyType = "
                  + budgetOptimizerBiddingScheme.getBiddingStrategyType());
              System.out.println("biddingStrategyConfiguration/parentBiddingStrategyConfigurations/biddingScheme(BudgetOptimizerBiddingScheme)/bidCeiling = "
                  + budgetOptimizerBiddingScheme.getBidCeiling());
            }
          }
        }
        System.out.println("advancedUrl = " + biddableAdGroupCriterion.getAdvancedUrl());
        System.out.println("reviewAdvancedUrl = " + biddableAdGroupCriterion.getReviewAdvancedUrl());
        System.out.println("advancedMobileUrl = " + biddableAdGroupCriterion.getAdvancedMobileUrl());
        System.out.println("reviewAdvancedMobileUrl = " + biddableAdGroupCriterion.getReviewAdvancedMobileUrl());

        if(null != biddableAdGroupCriterion.getAdditionalAdvancedUrls()){
          AdGroupCriterionAdditionalAdvancedUrls additionalAdvancedUrls = biddableAdGroupCriterion.getAdditionalAdvancedUrls();
          System.out.println("additionalAdvancedUrls/isRemove = " + additionalAdvancedUrls.getIsRemove());

          if (null != additionalAdvancedUrls.getAdditionalAdvancedUrl()) {
            int index = 0;
            for (AdGroupCriterionAdditionalUrl additionalAdvancedUrl : additionalAdvancedUrls.getAdditionalAdvancedUrl()) {
              System.out.println("additionalAdvancedUrls/additionalAdvancedUrl[" + index + "]/url = " + additionalAdvancedUrl.getUrl());
              System.out.println("additionalAdvancedUrls/additionalAdvancedUrl[" + index + "]/reviewUrl = " + additionalAdvancedUrl.getReviewUrl());
              System.out.println("additionalAdvancedUrls/additionalAdvancedUrl[" + index + "]/disapprovalReasonCodes = " + additionalAdvancedUrl.getDisapprovalReasonCodes());
              index++;
            }
          }
        }

        if(null != biddableAdGroupCriterion.getAdditionalAdvancedMobileUrls()){
          AdGroupCriterionAdditionalAdvancedMobileUrls additionalAdvancedMobileUrls = biddableAdGroupCriterion.getAdditionalAdvancedMobileUrls();
          System.out.println("additionalAdvancedMobileUrls/isRemove = " + additionalAdvancedMobileUrls.getIsRemove());

          if (null != additionalAdvancedMobileUrls.getAdditionalAdvancedMobileUrl()) {
            int index = 0;
            for (AdGroupCriterionAdditionalUrl additionalAdvancedMobileUrl : additionalAdvancedMobileUrls.getAdditionalAdvancedMobileUrl()) {
              System.out.println("additionalAdvancedMobileUrls/additionalAdvancedMobileUrl[" + index + "]/url = " + additionalAdvancedMobileUrl.getUrl());
              System.out.println("additionalAdvancedMobileUrls/additionalAdvancedMobileUrl[" + index + "]/reviewUrl = " + additionalAdvancedMobileUrl.getReviewUrl());
              System.out.println("additionalAdvancedMobileUrls/additionalAdvancedMobileUrl[" + index + "]/disapprovalReasonCodes = " + additionalAdvancedMobileUrl.getDisapprovalReasonCodes());
              index++;
            }
          }
        }

        System.out.println("trackingUrl = " + biddableAdGroupCriterion.getTrackingUrl());
        System.out.println("reviewTrackingUrl = " + biddableAdGroupCriterion.getReviewTrackingUrl());

        if (null != biddableAdGroupCriterion.getCustomParameters()) {
          CustomParameters customParameters = biddableAdGroupCriterion.getCustomParameters();
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

        if (null != biddableAdGroupCriterion.getReviewCustomParameters()) {
          CustomParameters reviewCustomParameters = biddableAdGroupCriterion.getReviewCustomParameters();
          System.out.println("reviewCustomParameters/isRemove = " + reviewCustomParameters.getIsRemove());

          if (null != reviewCustomParameters.getParameters()) {
            for (CustomParameter parameter : reviewCustomParameters.getParameters()) {
              int index = 0;
              System.out.println("reviewCustomParameters/parameters[" + index + "]/key = " + parameter.getKey());
              System.out.println("reviewCustomParameters/parameters[" + index + "]/value = " + parameter.getValue());
              index++;
            }
          }
        }
      }
    }

    System.out.println("---------");
  }

  /**
   * create sample request.
   *
   * @param accountId long
   * @param campaignId long
   * @param adGroupId long
   * @return AdGroupCriterionOperation
   */
  public static AdGroupCriterionOperation createSampleAddRequest(long accountId, long campaignId, long adGroupId) {
    // Set Operation
    AdGroupCriterionOperation operation = new AdGroupCriterionOperation();
    operation.setOperator(Operator.ADD);
    operation.setAccountId(accountId);

    // Set Keyword
    Keyword keyword = new Keyword();
    keyword.setType(CriterionType.KEYWORD);
    keyword.setText("sample text");
    keyword.setMatchType(KeywordMatchType.PHRASE);

    // Set Bid
    Bid bit = new Bid();
    bit.setMaxCpc((long) 100);
    AdGroupCriterionBiddingStrategy biddingStrategy = new AdGroupCriterionBiddingStrategy();
    biddingStrategy.setBid(bit);

    // Set CustomParamaters
    CustomParameters customParameters = new CustomParameters();
    CustomParameter parameter1 = new CustomParameter();
    parameter1.setKey("id1");
    parameter1.setValue("1234");
    customParameters.getParameters().addAll(Arrays.asList(parameter1));

    // Set BiddableAdGroupCriterion
    BiddableAdGroupCriterion biddableAdGroupCriterion = new BiddableAdGroupCriterion();
    biddableAdGroupCriterion.setAccountId(accountId);
    biddableAdGroupCriterion.setCampaignId(campaignId);
    biddableAdGroupCriterion.setAdGroupId(adGroupId);
    biddableAdGroupCriterion.setCriterionUse(AdGroupCriterionUse.BIDDABLE);
    biddableAdGroupCriterion.setCriterion(keyword);
    biddableAdGroupCriterion.setDestinationUrl("http://www.yahoo.co.jp/");
    biddableAdGroupCriterion.setUserStatus(UserStatus.ACTIVE);
    biddableAdGroupCriterion.setBiddingStrategyConfiguration(biddingStrategy);

    biddableAdGroupCriterion.setAdvancedUrl("http://www.yahoo.co.jp");
    biddableAdGroupCriterion.setAdvancedMobileUrl("http://www.yahoo.co.jp/mobile");

    AdGroupCriterionAdditionalAdvancedUrls additionalAdvancedUrls = new AdGroupCriterionAdditionalAdvancedUrls();
    AdGroupCriterionAdditionalUrl adGroupCriterionAdditionalUrl1 = new AdGroupCriterionAdditionalUrl();
    AdGroupCriterionAdditionalUrl adGroupCriterionAdditionalUrl2 = new AdGroupCriterionAdditionalUrl();
    AdGroupCriterionAdditionalUrl adGroupCriterionAdditionalUrl3 = new AdGroupCriterionAdditionalUrl();
    adGroupCriterionAdditionalUrl1.setUrl("http://www1.yahoo.co.jp");
    adGroupCriterionAdditionalUrl2.setUrl("http://www2.yahoo.co.jp");
    adGroupCriterionAdditionalUrl3.setUrl("http://www3.yahoo.co.jp");
    additionalAdvancedUrls.getAdditionalAdvancedUrl().add(adGroupCriterionAdditionalUrl1);
    additionalAdvancedUrls.getAdditionalAdvancedUrl().add(adGroupCriterionAdditionalUrl2);
    additionalAdvancedUrls.getAdditionalAdvancedUrl().add(adGroupCriterionAdditionalUrl3);
    biddableAdGroupCriterion.setAdditionalAdvancedUrls(additionalAdvancedUrls);

    AdGroupCriterionAdditionalAdvancedMobileUrls adGroupCriterionAdditionalAdvancedMobileUrls = new AdGroupCriterionAdditionalAdvancedMobileUrls();
    AdGroupCriterionAdditionalUrl adGroupCriterionAdditionalMobileUrl1 = new AdGroupCriterionAdditionalUrl();
    AdGroupCriterionAdditionalUrl adGroupCriterionAdditionalMobileUrl2 = new AdGroupCriterionAdditionalUrl();
    AdGroupCriterionAdditionalUrl adGroupCriterionAdditionalMobileUrl3 = new AdGroupCriterionAdditionalUrl();
    adGroupCriterionAdditionalMobileUrl1.setUrl("http://www1.yahoo.co.jp/mobile");
    adGroupCriterionAdditionalMobileUrl2.setUrl("http://www2.yahoo.co.jp/mobile");
    adGroupCriterionAdditionalMobileUrl3.setUrl("http://www3.yahoo.co.jp/mobile");
    adGroupCriterionAdditionalAdvancedMobileUrls.getAdditionalAdvancedMobileUrl().add(adGroupCriterionAdditionalMobileUrl1);
    adGroupCriterionAdditionalAdvancedMobileUrls.getAdditionalAdvancedMobileUrl().add(adGroupCriterionAdditionalMobileUrl2);
    adGroupCriterionAdditionalAdvancedMobileUrls.getAdditionalAdvancedMobileUrl().add(adGroupCriterionAdditionalMobileUrl3);
    biddableAdGroupCriterion.setAdditionalAdvancedMobileUrls(adGroupCriterionAdditionalAdvancedMobileUrls);

    biddableAdGroupCriterion.setTrackingUrl("http://www.yahoo.co.jp/?url={lpurl}&amp;a={creative}&amp;pid={_id1}");
    biddableAdGroupCriterion.setCustomParameters(customParameters);

    operation.getOperand().add(biddableAdGroupCriterion);

    return operation;
  }

  /**
   * create sample request.
   *
   * @param accountId long
   * @param campaignId long
   * @param adGroupId long
   * @param adGroupCriterionValues AdGroupCriterionValues
   * @return AdGroupCriterionOperation
   */
  public static AdGroupCriterionOperation createSampleSetRequest(long accountId, long campaignId, long adGroupId, List<AdGroupCriterionValues> adGroupCriterionValues) {
    // Set Operation
    AdGroupCriterionOperation operation = new AdGroupCriterionOperation();
    operation.setOperator(Operator.SET);
    operation.setAccountId(accountId);

    // Set Operand
    for (AdGroupCriterionValues adGroupCriterionValue : adGroupCriterionValues) {

      // Set Keyword
      Keyword keyword = new Keyword();
      keyword.setCriterionId(adGroupCriterionValue.getAdGroupCriterion().getCriterion().getCriterionId());
      keyword.setType(adGroupCriterionValue.getAdGroupCriterion().getCriterion().getType());

      // Set Bid
      Bid bit = new Bid();
      bit.setMaxCpc((long) 150);
      AdGroupCriterionBiddingStrategy biddingStrategy = new AdGroupCriterionBiddingStrategy();
      biddingStrategy.setBid(bit);

      // Set CustomParamaters
      CustomParameters customParameters = new CustomParameters();
      CustomParameter parameter1 = new CustomParameter();
      parameter1.setKey("id1");
      parameter1.setValue("5678");
      customParameters.getParameters().addAll(Arrays.asList(parameter1));

      // Set BiddableAdGroupCriterion
      BiddableAdGroupCriterion biddableAdGroupCriterion = new BiddableAdGroupCriterion();
      biddableAdGroupCriterion.setAccountId(adGroupCriterionValue.getAdGroupCriterion().getAccountId());
      biddableAdGroupCriterion.setCampaignId(adGroupCriterionValue.getAdGroupCriterion().getCampaignId());
      biddableAdGroupCriterion.setAdGroupId(adGroupCriterionValue.getAdGroupCriterion().getAdGroupId());
      biddableAdGroupCriterion.setCriterion(keyword);
      biddableAdGroupCriterion.setUserStatus(UserStatus.PAUSED);
      biddableAdGroupCriterion.setCriterionUse(AdGroupCriterionUse.BIDDABLE);
      biddableAdGroupCriterion.setBiddingStrategyConfiguration(biddingStrategy);

      biddableAdGroupCriterion.setAdvancedUrl("http://www.yahoo2.co.jp");
      biddableAdGroupCriterion.setAdvancedMobileUrl("http://www.yahoo2.co.jp/mobile");

      AdGroupCriterionAdditionalAdvancedUrls additionalAdvancedUrls = new AdGroupCriterionAdditionalAdvancedUrls();
      additionalAdvancedUrls.setIsRemove(IsRemove.TRUE);
      biddableAdGroupCriterion.setAdditionalAdvancedUrls(additionalAdvancedUrls);
      AdGroupCriterionAdditionalAdvancedMobileUrls adGroupCriterionAdditionalAdvancedMobileUrls = new AdGroupCriterionAdditionalAdvancedMobileUrls();
      additionalAdvancedUrls.setIsRemove(IsRemove.TRUE);
      biddableAdGroupCriterion.setAdditionalAdvancedMobileUrls(adGroupCriterionAdditionalAdvancedMobileUrls);

      biddableAdGroupCriterion.setTrackingUrl("http://www.yahoo2.co.jp/?url={lpurl}&amp;a={creative}&amp;pid={_id1}");
      biddableAdGroupCriterion.setCustomParameters(customParameters);

      operation.getOperand().add(biddableAdGroupCriterion);
    }

    return operation;
  }

  /**
   * create sample request.
   *
   * @param accountId long
   * @param campaignId long
   * @param adGroupId long
   * @param adGroupCriterionValues AdGroupCriterionValues
   * @return AdGroupCriterionOperation
   */
  public static AdGroupCriterionOperation createSampleRemoveRequest(long accountId, long campaignId, long adGroupId, List<AdGroupCriterionValues> adGroupCriterionValues) {
    // Set Operation
    AdGroupCriterionOperation operation = new AdGroupCriterionOperation();
    operation.setOperator(Operator.REMOVE);
    operation.setAccountId(accountId);

    // Set Operand
    for (AdGroupCriterionValues adGroupCriterionValue : adGroupCriterionValues) {

      // Set Keyword
      Keyword keyword = new Keyword();
      keyword.setCriterionId(adGroupCriterionValue.getAdGroupCriterion().getCriterion().getCriterionId());
      keyword.setType(adGroupCriterionValue.getAdGroupCriterion().getCriterion().getType());

      AdGroupCriterion adGroupCriterion = new AdGroupCriterion();
      adGroupCriterion.setAccountId(adGroupCriterionValue.getAdGroupCriterion().getAccountId());
      adGroupCriterion.setCampaignId(adGroupCriterionValue.getAdGroupCriterion().getCampaignId());
      adGroupCriterion.setAdGroupId(adGroupCriterionValue.getAdGroupCriterion().getAdGroupId());
      adGroupCriterion.setCriterionUse(adGroupCriterionValue.getAdGroupCriterion().getCriterionUse());
      adGroupCriterion.setCriterion(keyword);

      operation.getOperand().add(adGroupCriterion);
    }

    return operation;
  }

  /**
   * create sample request.
   *
   * @param accountId long
   * @param campaignId long
   * @param adGroupId long
   * @param adGroupCriterionValues AdGroupCriterionValues
   * @return AdGroupCriterionSelector
   */
  public static AdGroupCriterionSelector createSampleGetRequest(long accountId, long campaignId, long adGroupId, List<AdGroupCriterionValues> adGroupCriterionValues) {

    // Set Selector
    AdGroupCriterionSelector selector = new AdGroupCriterionSelector();
    selector.setAccountId(accountId);
    selector.getCampaignIds().add(campaignId);
    selector.getAdGroupIds().add(adGroupId);
    for (AdGroupCriterionValues adGroupCriterionValue : adGroupCriterionValues) {
      selector.getCriterionIds().add((adGroupCriterionValue.getAdGroupCriterion().getCriterion().getCriterionId()));
    }
    selector.getUserStatuses().addAll(Arrays.asList(UserStatus.ACTIVE, UserStatus.PAUSED));
    selector.setCriterionUse(AdGroupCriterionUse.BIDDABLE);
    selector.getApprovalStatuses().addAll(
        Arrays.asList(ApprovalStatus.APPROVED, ApprovalStatus.APPROVED_WITH_REVIEW, ApprovalStatus.REVIEW, ApprovalStatus.POST_DISAPPROVED, ApprovalStatus.PRE_DISAPPROVED));
    Paging paging = new Paging();
    paging.setStartIndex(1);
    paging.setNumberResults(20);
    selector.setPaging(paging);

    return selector;
  }
}

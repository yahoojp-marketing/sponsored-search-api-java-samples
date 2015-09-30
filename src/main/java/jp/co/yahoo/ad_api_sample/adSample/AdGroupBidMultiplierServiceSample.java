package jp.co.yahoo.ad_api_sample.adSample;

import java.util.List;

import javax.xml.ws.Holder;

import jp.co.yahoo.ad_api_sample.error.impl.AdGroupBidMultiplierServiceErrorEntityFactory;
import jp.co.yahoo.ad_api_sample.util.SoapUtils;
import jp.yahooapis.ss.V5.AdGroupBidMultiplierService.AdGroupBidMultiplier;
import jp.yahooapis.ss.V5.AdGroupBidMultiplierService.AdGroupBidMultiplierOperation;
import jp.yahooapis.ss.V5.AdGroupBidMultiplierService.AdGroupBidMultiplierPage;
import jp.yahooapis.ss.V5.AdGroupBidMultiplierService.AdGroupBidMultiplierReturnValue;
import jp.yahooapis.ss.V5.AdGroupBidMultiplierService.AdGroupBidMultiplierSelector;
import jp.yahooapis.ss.V5.AdGroupBidMultiplierService.AdGroupBidMultiplierService;
import jp.yahooapis.ss.V5.AdGroupBidMultiplierService.AdGroupBidMultiplierServiceInterface;
import jp.yahooapis.ss.V5.AdGroupBidMultiplierService.AdGroupBidMultiplierValues;
import jp.yahooapis.ss.V5.AdGroupBidMultiplierService.BidMultiplierList;
import jp.yahooapis.ss.V5.AdGroupBidMultiplierService.BidMultiplierType;
import jp.yahooapis.ss.V5.AdGroupBidMultiplierService.Error;
import jp.yahooapis.ss.V5.AdGroupBidMultiplierService.Operator;
import jp.yahooapis.ss.V5.AdGroupBidMultiplierService.Paging;
import jp.yahooapis.ss.V5.AdGroupBidMultiplierService.PlatformBidMultiplier;
import jp.yahooapis.ss.V5.AdGroupBidMultiplierService.PlatformBidMultiplierList;
import jp.yahooapis.ss.V5.AdGroupBidMultiplierService.PlatformType;

/**
 * Sample Program for AdGroupBidMultiplierService. Copyright (C) 2012 Yahoo Japan Corporation. All
 * Rights Reserved.
 */
public class AdGroupBidMultiplierServiceSample {

  /**
   * main method for AdGroupBidMultiplierServiceSample
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
      // AdGroupBidMultiplierService SET
      // =================================================================
      // Set Operation
      AdGroupBidMultiplierOperation adGroupBidMultiplierOperation = createSampleSetRequest(accountId, campaignId, adGroupId);

      // Run
      set(adGroupBidMultiplierOperation);

      // =================================================================
      // AdGroupBidMultiplierService GET
      // =================================================================
      // Set Selector
      AdGroupBidMultiplierSelector adGroupBidMultiplierSelector = createSampleGetRequest(accountId, campaignId, adGroupId);

      // Run
      get(adGroupBidMultiplierSelector);

    } catch (Exception e) {
      e.printStackTrace();
      throw e;
    }
  }

  /**
   * Sample Program for AdGroupBidMultiplierService SET.
   *
   * @param operation AdGroupBidMultiplierOperation
   * @return AdGroupBidMultiplierValues
   * @throws Exception
   */
  public static List<AdGroupBidMultiplierValues> set(AdGroupBidMultiplierOperation operation) throws Exception {

    // Call API
    System.out.println("############################################");
    System.out.println("AdGroupBidMultiplierService::mutate(SET)");
    System.out.println("############################################");

    Holder<AdGroupBidMultiplierReturnValue> adGroupBidMultiplierReturnValueHolder = new Holder<AdGroupBidMultiplierReturnValue>();
    Holder<List<Error>> errorHolder = new Holder<List<Error>>();
    AdGroupBidMultiplierServiceInterface adGroupBidMultiplierService = SoapUtils.createServiceInterface(AdGroupBidMultiplierServiceInterface.class, AdGroupBidMultiplierService.class);
    adGroupBidMultiplierService.mutate(operation, adGroupBidMultiplierReturnValueHolder, errorHolder);

    // Error
    if (errorHolder.value != null && errorHolder.value.size() > 0) {
      SoapUtils.displayErrors(new AdGroupBidMultiplierServiceErrorEntityFactory(errorHolder.value), true);
    }
    if (adGroupBidMultiplierReturnValueHolder.value == null) {
      throw new Exception("NoDataResponse:AdGroupBidMultiplierService Add");
    }

    // Display
    for (AdGroupBidMultiplierValues adGroupBidMultiplierValues : adGroupBidMultiplierReturnValueHolder.value.getValues()) {
      if (adGroupBidMultiplierValues.isOperationSucceeded()) {
        display(adGroupBidMultiplierValues.getAdGroupBidMultiplier());
      } else {
        SoapUtils.displayErrors(new AdGroupBidMultiplierServiceErrorEntityFactory(adGroupBidMultiplierValues.getError()), true);
      }
    }

    // Response
    return adGroupBidMultiplierReturnValueHolder.value.getValues();
  }

  /**
   * Sample Program for AdGroupBidMultiplierService GET.
   *
   * @param adGroupBidMultiplierSelector AdGroupBidMultiplierSelector
   * @return AdGroupBidMultiplierValues
   * @throws Exception
   */
  public static List<AdGroupBidMultiplierValues> get(AdGroupBidMultiplierSelector adGroupBidMultiplierSelector) throws Exception {

    // Call API
    System.out.println("############################################");
    System.out.println("AdGroupBidMultiplierService::get");
    System.out.println("############################################");

    Holder<AdGroupBidMultiplierPage> adGroupBidMultiplierPage = new Holder<AdGroupBidMultiplierPage>();
    Holder<List<Error>> errorHolder = new Holder<List<Error>>();
    AdGroupBidMultiplierServiceInterface adGroupBidMultiplierService = SoapUtils.createServiceInterface(AdGroupBidMultiplierServiceInterface.class, AdGroupBidMultiplierService.class);
    adGroupBidMultiplierService.get(adGroupBidMultiplierSelector, adGroupBidMultiplierPage, errorHolder);

    // Error
    if (errorHolder.value != null && errorHolder.value.size() > 0) {
      SoapUtils.displayErrors(new AdGroupBidMultiplierServiceErrorEntityFactory(errorHolder.value), true);
    }
    if (adGroupBidMultiplierPage.value == null) {
      throw new Exception("NoDataResponse:AdGroupBidMultiplierService Get");
    }

    // Display
    for (AdGroupBidMultiplierValues adGroupBidMultiplierValues : adGroupBidMultiplierPage.value.getValues()) {
      if (adGroupBidMultiplierValues.isOperationSucceeded()) {
        display(adGroupBidMultiplierValues.getAdGroupBidMultiplier());
      } else {
        SoapUtils.displayErrors(new AdGroupBidMultiplierServiceErrorEntityFactory(adGroupBidMultiplierValues.getError()), true);
      }
    }

    // Response
    return adGroupBidMultiplierPage.value.getValues();
  }

  /**
   * display AdGroupBidMultiplier entity to stdout.
   *
   * @param adGroupBidMultiplier AdGroupBidMultiplier entity for display.
   */
  public static void display(AdGroupBidMultiplier adGroupBidMultiplier) {

    System.out.println("accountId = " + adGroupBidMultiplier.getAccountId());
    System.out.println("campaignId = " + adGroupBidMultiplier.getCampaignId());
    System.out.println("adGroupId = " + adGroupBidMultiplier.getAdGroupId());

    if (adGroupBidMultiplier.getBidMultipliers() != null) {
      for (BidMultiplierList bidMultiplier : adGroupBidMultiplier.getBidMultipliers()) {
        System.out.println("bidMultipliers/type = " + bidMultiplier.getType());
        if (bidMultiplier instanceof PlatformBidMultiplierList) {
          for (PlatformBidMultiplier platformBidMultiplier : ((PlatformBidMultiplierList) bidMultiplier).getBidMultipliers()) {
            System.out.println("bidMultipliers/bidMultipliers/type = " + platformBidMultiplier.getType());
            System.out.println("bidMultipliers/bidMultipliers/type = " + platformBidMultiplier.getPlatformName());
            System.out.println("bidMultipliers/bidMultipliers/type = " + platformBidMultiplier.getBidMultiplier());
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
   * @return AdGroupBidMultiplierOperation
   */
  public static AdGroupBidMultiplierOperation createSampleSetRequest(long accountId, long campaignId, long adGroupId) {
    // Set Operation
    AdGroupBidMultiplierOperation operation = new AdGroupBidMultiplierOperation();
    operation.setOperator(Operator.SET);
    operation.setAccountId(accountId);
    operation.setCampaignId(campaignId);

    // Set PlatformBidMultiplier
    PlatformBidMultiplier platformBidMultiplier = new PlatformBidMultiplier();
    platformBidMultiplier.setType(BidMultiplierType.PLATFORM);
    platformBidMultiplier.setPlatformName(PlatformType.SMART_PHONE);
    platformBidMultiplier.setBidMultiplier(3.2);

    // Set PlatformBidMultiplierList
    PlatformBidMultiplierList platformBidMultiplierList = new PlatformBidMultiplierList();
    platformBidMultiplierList.setType(BidMultiplierType.PLATFORM);
    platformBidMultiplierList.getBidMultipliers().add(platformBidMultiplier);

    // Set Operand
    AdGroupBidMultiplier adGroupBidMultiplier = new AdGroupBidMultiplier();
    adGroupBidMultiplier.setAdGroupId(adGroupId);
    adGroupBidMultiplier.getBidMultipliers().add(platformBidMultiplierList);

    operation.getOperand().add(adGroupBidMultiplier);

    return operation;
  }

  /**
   * create sample request.
   * 
   * @param accountId long
   * @param campaignId long
   * @param adGroupId long
   * @return AdGroupCriterionSelector
   */
  public static AdGroupBidMultiplierSelector createSampleGetRequest(long accountId, long campaignId, long adGroupId) {
    // Set Selector
    AdGroupBidMultiplierSelector selector = new AdGroupBidMultiplierSelector();
    selector.setAccountId(accountId);
    selector.getCampaignIds().add(campaignId);
    selector.getAdGroupIds().add(adGroupId);
    Paging paging = new Paging();
    paging.setStartIndex(1);
    paging.setNumberResults(20);
    selector.setPaging(paging);

    return selector;
  }
}

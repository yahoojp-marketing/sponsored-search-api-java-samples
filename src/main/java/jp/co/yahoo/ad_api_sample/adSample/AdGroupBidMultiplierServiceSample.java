package jp.co.yahoo.ad_api_sample.adSample;

import jp.co.yahoo.ad_api_sample.error.impl.AdGroupBidMultiplierServiceErrorEntityFactory;
import jp.co.yahoo.ad_api_sample.util.SoapUtils;
import jp.yahooapis.ss.V6.AdGroupBidMultiplierService.AdGroupBidMultiplier;
import jp.yahooapis.ss.V6.AdGroupBidMultiplierService.AdGroupBidMultiplierOperation;
import jp.yahooapis.ss.V6.AdGroupBidMultiplierService.AdGroupBidMultiplierPage;
import jp.yahooapis.ss.V6.AdGroupBidMultiplierService.AdGroupBidMultiplierReturnValue;
import jp.yahooapis.ss.V6.AdGroupBidMultiplierService.AdGroupBidMultiplierSelector;
import jp.yahooapis.ss.V6.AdGroupBidMultiplierService.AdGroupBidMultiplierService;
import jp.yahooapis.ss.V6.AdGroupBidMultiplierService.AdGroupBidMultiplierServiceInterface;
import jp.yahooapis.ss.V6.AdGroupBidMultiplierService.AdGroupBidMultiplierValues;
import jp.yahooapis.ss.V6.AdGroupBidMultiplierService.Error;
import jp.yahooapis.ss.V6.AdGroupBidMultiplierService.Operator;
import jp.yahooapis.ss.V6.AdGroupBidMultiplierService.Paging;
import jp.yahooapis.ss.V6.AdGroupBidMultiplierService.PlatformType;

import java.util.Arrays;
import java.util.List;

import javax.xml.ws.Holder;

/**
 * Sample Program for AdGroupBidMultiplierService.
 * Copyright (C) 2012 Yahoo Japan Corporation. All Rights Reserved.
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

      // =================================================================
      // AdGroupBidMultiplierService REMOVE
      // =================================================================
      // Set Selector
      AdGroupBidMultiplierOperation removeAdGroupBidMultiplierOperation = createSampleSetRequest(accountId, campaignId, adGroupId);

      // Run
      remove(removeAdGroupBidMultiplierOperation);

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
      throw new Exception("NoDataResponse:AdGroupBidMultiplierService Set");
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
   * Sample Program for AdGroupBidMultiplierService REMOVE.
   *
   * @param operation AdGroupBidMultiplierOperation
   * @return AdGroupBidMultiplierValues
   */
  public static List<AdGroupBidMultiplierValues> remove(AdGroupBidMultiplierOperation operation) throws Exception {

    // Call API
    System.out.println("############################################");
    System.out.println("AdGroupBidMultiplierService::mutate(REMOVE)");
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
      throw new Exception("NoDataResponse:AdGroupBidMultiplierService Remove");
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
   * display AdGroupBidMultiplier entity to stdout.
   *
   * @param adGroupBidMultiplier AdGroupBidMultiplier entity for display.
   */
  public static void display(AdGroupBidMultiplier adGroupBidMultiplier) {

    System.out.println("accountId = " + adGroupBidMultiplier.getAccountId());
    System.out.println("campaignId = " + adGroupBidMultiplier.getCampaignId());
    System.out.println("adGroupId = " + adGroupBidMultiplier.getAdGroupId());

    System.out.println("---------");
  }

  /**
   * create sample request.
   *
   * @param accountId  long
   * @param campaignId long
   * @param adGroupId  long
   * @return AdGroupBidMultiplierOperation
   */
  public static AdGroupBidMultiplierOperation createSampleSetRequest(long accountId, long campaignId, long adGroupId) {
    // Set Operation
    AdGroupBidMultiplierOperation operation = new AdGroupBidMultiplierOperation();
    operation.setOperator(Operator.SET);
    operation.setAccountId(accountId);

    // Set Operand
    AdGroupBidMultiplier adGroupBidMultiplierSmartPhone = new AdGroupBidMultiplier();
    adGroupBidMultiplierSmartPhone.setAdGroupId(adGroupId);
    adGroupBidMultiplierSmartPhone.setCampaignId(campaignId);
    adGroupBidMultiplierSmartPhone.setPlatformType(PlatformType.SMART_PHONE);
    adGroupBidMultiplierSmartPhone.setBidMultiplier(3.2);

    AdGroupBidMultiplier adGroupBidMultiplierTablet = new AdGroupBidMultiplier();
    adGroupBidMultiplierTablet.setAdGroupId(adGroupId);
    adGroupBidMultiplierTablet.setCampaignId(campaignId);
    adGroupBidMultiplierTablet.setPlatformType(PlatformType.TABLET);
    adGroupBidMultiplierTablet.setBidMultiplier(4.2);

    AdGroupBidMultiplier adGroupBidMultiplierDesktop = new AdGroupBidMultiplier();
    adGroupBidMultiplierDesktop.setAdGroupId(adGroupId);
    adGroupBidMultiplierDesktop.setCampaignId(campaignId);
    adGroupBidMultiplierDesktop.setPlatformType(PlatformType.DESKTOP);
    adGroupBidMultiplierDesktop.setBidMultiplier(5.2);

    operation.getOperand().addAll(Arrays.asList(adGroupBidMultiplierSmartPhone, adGroupBidMultiplierTablet, adGroupBidMultiplierDesktop));

    return operation;
  }

  /**
   * create sample request.
   *
   * @param accountId  long
   * @param campaignId long
   * @param adGroupId  long
   * @return AdGroupCriterionSelector
   */
  public static AdGroupBidMultiplierSelector createSampleGetRequest(long accountId, long campaignId, long adGroupId) {
    // Set Selector
    AdGroupBidMultiplierSelector selector = new AdGroupBidMultiplierSelector();
    selector.setAccountId(accountId);
    selector.getCampaignIds().add(campaignId);
    selector.getAdGroupIds().add(adGroupId);
    selector.getPlatformTypes().addAll(Arrays.asList(PlatformType.SMART_PHONE, PlatformType.TABLET, PlatformType.DESKTOP));
    Paging paging = new Paging();
    paging.setStartIndex(1);
    paging.setNumberResults(20);
    selector.setPaging(paging);

    return selector;
  }

  /**
   * create sample request.
   *
   * @param accountId  long
   * @param campaignId long
   * @param adGroupId  long
   * @return AdGroupBidMultiplierOperation
   */
  public static AdGroupBidMultiplierOperation createSampleRemoveRequest(long accountId, long campaignId, long adGroupId) {
    // Set Operation
    AdGroupBidMultiplierOperation operation = new AdGroupBidMultiplierOperation();
    operation.setOperator(Operator.REMOVE);
    operation.setAccountId(accountId);

    // Set Operand
    AdGroupBidMultiplier adGroupBidMultiplierSmartPhone = new AdGroupBidMultiplier();
    adGroupBidMultiplierSmartPhone.setAdGroupId(adGroupId);
    adGroupBidMultiplierSmartPhone.setCampaignId(campaignId);
    adGroupBidMultiplierSmartPhone.setPlatformType(PlatformType.SMART_PHONE);

    AdGroupBidMultiplier adGroupBidMultiplierTablet = new AdGroupBidMultiplier();
    adGroupBidMultiplierTablet.setAdGroupId(adGroupId);
    adGroupBidMultiplierTablet.setCampaignId(campaignId);
    adGroupBidMultiplierTablet.setPlatformType(PlatformType.TABLET);

    AdGroupBidMultiplier adGroupBidMultiplierDesktop = new AdGroupBidMultiplier();
    adGroupBidMultiplierDesktop.setAdGroupId(adGroupId);
    adGroupBidMultiplierDesktop.setCampaignId(campaignId);
    adGroupBidMultiplierDesktop.setPlatformType(PlatformType.DESKTOP);

    operation.getOperand().addAll(Arrays.asList(adGroupBidMultiplierSmartPhone, adGroupBidMultiplierTablet, adGroupBidMultiplierDesktop));

    return operation;
  }
}

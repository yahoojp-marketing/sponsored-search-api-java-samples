/**
 * Copyright (C) 2019 Yahoo Japan Corporation. All Rights Reserved.
 */
package jp.yahooapis.ss.adapisample.basic.adgroupbidmultiplier;

import jp.yahooapis.ss.adapisample.basic.adgroup.AdGroupServiceSample;
import jp.yahooapis.ss.adapisample.repository.ValuesRepositoryFacade;
import jp.yahooapis.ss.adapisample.util.SoapUtils;
import jp.yahooapis.ss.adapisample.util.ValuesHolder;
import jp.yahooapis.ss.v201909.Error;
import jp.yahooapis.ss.v201909.Paging;
import jp.yahooapis.ss.v201909.adgroupbidmultiplier.AdGroupBidMultiplier;
import jp.yahooapis.ss.v201909.adgroupbidmultiplier.AdGroupBidMultiplierOperation;
import jp.yahooapis.ss.v201909.adgroupbidmultiplier.AdGroupBidMultiplierPage;
import jp.yahooapis.ss.v201909.adgroupbidmultiplier.AdGroupBidMultiplierReturnValue;
import jp.yahooapis.ss.v201909.adgroupbidmultiplier.AdGroupBidMultiplierSelector;
import jp.yahooapis.ss.v201909.adgroupbidmultiplier.AdGroupBidMultiplierService;
import jp.yahooapis.ss.v201909.adgroupbidmultiplier.AdGroupBidMultiplierServiceInterface;
import jp.yahooapis.ss.v201909.adgroupbidmultiplier.AdGroupBidMultiplierValues;
import jp.yahooapis.ss.v201909.adgroupbidmultiplier.Operator;
import jp.yahooapis.ss.v201909.adgroupbidmultiplier.PlatformType;
import jp.yahooapis.ss.v201909.campaign.CampaignType;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.xml.ws.Holder;

/**
 * example AdGroupBidMultiplierService operation and Utility method collection.
 */
public class AdGroupBidMultiplierServiceSample {

  /**
   * main method for AdGroupBidMultiplierServiceSample
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
      Long campaignId = valuesRepositoryFacade.getCampaignValuesRepository().findCampaignId(CampaignType.STANDARD);
      Long adGroupId = valuesRepositoryFacade.getAdGroupValuesRepository().findAdGroupId(campaignId);

      // =================================================================
      // AdGroupBidMultiplierService SET
      // =================================================================
      // create request.
      AdGroupBidMultiplierOperation setRequest = buildExampleMutateRequest(Operator.SET, accountId, createExampleSetRequest(campaignId, adGroupId));

      // run
      List<AdGroupBidMultiplierValues> setResponse = mutate(setRequest);

      List<AdGroupBidMultiplier> adGroupBidMultipliers = new ArrayList<>();
      for (AdGroupBidMultiplierValues adGroupBidMultiplierValue: setResponse) {
        adGroupBidMultipliers.add(adGroupBidMultiplierValue.getAdGroupBidMultiplier());
      }

      // =================================================================
      // AdGroupBidMultiplierService GET
      // =================================================================
      // create request.
      AdGroupBidMultiplierSelector adGroupBidMultiplierSelector = buildExampleGetRequest(accountId, campaignId, adGroupId);

      // run
      get(adGroupBidMultiplierSelector);

      // =================================================================
      // AdGroupBidMultiplierService REMOVE
      // =================================================================
      // create request.
      AdGroupBidMultiplierOperation removeRequest = buildExampleMutateRequest(Operator.REMOVE, accountId, adGroupBidMultipliers);

      // run
      mutate(removeRequest);

    } catch (Exception e) {
      e.printStackTrace();
      throw e;
    } finally {
      cleanup(valuesHolder);
    }
  }

  /**
   * example mutate request.
   */
  public static AdGroupBidMultiplierOperation buildExampleMutateRequest(Operator operator, long accountId, List<AdGroupBidMultiplier> operand) {
    AdGroupBidMultiplierOperation operation = new AdGroupBidMultiplierOperation();
    operation.setOperator(operator);
    operation.setAccountId(accountId);
    operation.getOperand().addAll(operand);

    return operation;
  }

  /**
   * example adGroupCriterion set request.
   *
   * @param campaignId Long
   * @param adGroupId Long
   * @return List<AdGroupBidMultiplier>
   */
  public static List<AdGroupBidMultiplier> createExampleSetRequest(Long campaignId, Long adGroupId) {

    // create operands
    List<AdGroupBidMultiplier> operands = new ArrayList<>();

    AdGroupBidMultiplier smartPhone = new AdGroupBidMultiplier();
    smartPhone.setCampaignId(campaignId);
    smartPhone.setAdGroupId(adGroupId);
    smartPhone.setPlatformType(PlatformType.SMART_PHONE);
    smartPhone.setBidMultiplier(3.2);

    AdGroupBidMultiplier tablet = new AdGroupBidMultiplier();
    tablet.setCampaignId(campaignId);
    tablet.setAdGroupId(adGroupId);
    tablet.setPlatformType(PlatformType.TABLET);
    tablet.setBidMultiplier(5.2);

    AdGroupBidMultiplier desktop = new AdGroupBidMultiplier();
    desktop.setCampaignId(campaignId);
    desktop.setAdGroupId(adGroupId);
    desktop.setPlatformType(PlatformType.DESKTOP);
    desktop.setBidMultiplier(9.2);

    operands.addAll(Arrays.asList(smartPhone, tablet, desktop));

    return operands;
  }

  /**
   * create get request.
   *
   * @param accountId long
   * @param campaignId long
   * @param adGroupId long
   * @returna AdGroupBidMultiplierSelector
   */
  public static AdGroupBidMultiplierSelector buildExampleGetRequest(long accountId, long campaignId, long adGroupId) {
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
   * example mutate adGroupCriterions.
   *
   * @param operation AdGroupCriterionOperation
   * @return AdGroupCriterionValues
   */
  public static List<AdGroupBidMultiplierValues> mutate(AdGroupBidMultiplierOperation operation) throws Exception {
    // Call API
    System.out.println("############################################");
    System.out.println("AdGroupBidMultiplierService::mutate(" + operation.getOperator() + ")");
    System.out.println("############################################");

    Holder<AdGroupBidMultiplierReturnValue> adGroupBidMultiplierReturnValueHolder = new Holder<AdGroupBidMultiplierReturnValue>();
    Holder<List<Error>> errorHolder = new Holder<List<Error>>();
    AdGroupBidMultiplierServiceInterface adGroupBidMultiplierService = SoapUtils.createServiceInterface(AdGroupBidMultiplierServiceInterface.class, AdGroupBidMultiplierService.class);
    adGroupBidMultiplierService.mutate(operation, adGroupBidMultiplierReturnValueHolder, errorHolder);

    SoapUtils.checkSoapError(errorHolder, adGroupBidMultiplierReturnValueHolder.value.getValues());

    // Response
    return adGroupBidMultiplierReturnValueHolder.value.getValues();
  }

  /**
   * check & create upper service object.
   *
   * @return ValuesHolder
   * @throws Exception
   */
  private static ValuesHolder setup() throws Exception {

    return AdGroupServiceSample.create();
  }

  /**
   * cleanup service object.
   *
   * @param valuesHolder ValuesHolder
   * @throws Exception
   */
  public static void cleanup(ValuesHolder valuesHolder) throws Exception {

    AdGroupServiceSample.cleanup(valuesHolder);
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

    SoapUtils.checkSoapError(errorHolder, adGroupBidMultiplierPage.value.getValues());

    // Response
    return adGroupBidMultiplierPage.value.getValues();
  }

}

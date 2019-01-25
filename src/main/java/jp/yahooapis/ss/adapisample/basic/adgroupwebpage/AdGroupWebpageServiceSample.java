/**
 * Copyright (C) 2019 Yahoo Japan Corporation. All Rights Reserved.
 */
package jp.yahooapis.ss.adapisample.basic.adgroupwebpage;

import jp.yahooapis.ss.adapisample.basic.adgroup.AdGroupServiceSample;
import jp.yahooapis.ss.adapisample.repository.ValuesRepositoryFacade;
import jp.yahooapis.ss.adapisample.util.SoapUtils;
import jp.yahooapis.ss.adapisample.util.ValuesHolder;
import jp.yahooapis.ss.v201901.Error;
import jp.yahooapis.ss.v201901.Paging;
import jp.yahooapis.ss.v201901.adgroupwebpage.AdGroupWebpage;
import jp.yahooapis.ss.v201901.adgroupwebpage.AdGroupWebpageOperation;
import jp.yahooapis.ss.v201901.adgroupwebpage.AdGroupWebpagePage;
import jp.yahooapis.ss.v201901.adgroupwebpage.AdGroupWebpageReturnValue;
import jp.yahooapis.ss.v201901.adgroupwebpage.AdGroupWebpageSelector;
import jp.yahooapis.ss.v201901.adgroupwebpage.AdGroupWebpageService;
import jp.yahooapis.ss.v201901.adgroupwebpage.AdGroupWebpageServiceInterface;
import jp.yahooapis.ss.v201901.adgroupwebpage.AdGroupWebpageValues;
import jp.yahooapis.ss.v201901.adgroupwebpage.Bid;
import jp.yahooapis.ss.v201901.adgroupwebpage.ExcludedType;
import jp.yahooapis.ss.v201901.adgroupwebpage.Operator;
import jp.yahooapis.ss.v201901.adgroupwebpage.UserStatus;
import jp.yahooapis.ss.v201901.adgroupwebpage.Webpage;
import jp.yahooapis.ss.v201901.adgroupwebpage.WebpageCondition;
import jp.yahooapis.ss.v201901.adgroupwebpage.WebpageConditionType;
import jp.yahooapis.ss.v201901.adgroupwebpage.WebpageParameter;
import jp.yahooapis.ss.v201901.campaign.CampaignType;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import javax.xml.ws.Holder;

/**
 * example AdGroupWebpageService operation and Utility method collection.
 */
public class AdGroupWebpageServiceSample {
  /**
   * main method for AdGroupWebpageService
   *
   * @param args command line arguments
   */
  public static void main(String[] args) throws Exception {
    ValuesHolder valuesHolder = new ValuesHolder();

    try {
      // =================================================================
      // Setting
      // =================================================================
      long accountId = SoapUtils.getAccountId();
      valuesHolder = setup();
      ValuesRepositoryFacade valuesRepositoryFacade = new ValuesRepositoryFacade(valuesHolder);
      Long campaignId = valuesRepositoryFacade.getCampaignValuesRepository().findCampaignId(CampaignType.DYNAMIC_ADS_FOR_SEARCH);
      Long adGroupId = valuesRepositoryFacade.getAdGroupValuesRepository().findAdGroupId(campaignId);


      // =================================================================
      // AdGroupWebpageService ADD
      // =================================================================
      // create request.
      AdGroupWebpageOperation addAdGroupWebpageOperation = buildExampleMutateRequest( //
          Operator.ADD, accountId, Collections.singletonList(createExampleAdGroupWebpage(campaignId, adGroupId)));

      // run
      List<AdGroupWebpageValues> adGroupWebpageValues = mutate(addAdGroupWebpageOperation);

      List<AdGroupWebpage> adGourpWebpages = new ArrayList<>();
      for (AdGroupWebpageValues values : adGroupWebpageValues) {
        adGourpWebpages.add(values.getAdGroupWebpage());
      }

      // =================================================================
      // AdGroupWebpageService SET
      // =================================================================
      // create request.
      AdGroupWebpageOperation setAdGroupWebpageOperation = buildExampleMutateRequest(Operator.SET, accountId, createExampleSetRequest(adGourpWebpages));

      // run
      mutate(setAdGroupWebpageOperation);

      // =================================================================
      // AdGroupWebpageService GET
      // =================================================================
      // create request.
      AdGroupWebpageSelector selector = buildExampleGetRequest(accountId, adGourpWebpages);

      // run
      get(selector);

      // =================================================================
      // AdGroupWebpageService::remove
      // =================================================================
      // create request.
      AdGroupWebpageOperation removeAdGroupWebpageOperation = buildExampleMutateRequest(Operator.REMOVE, accountId, adGourpWebpages);

      // Run
      mutate(removeAdGroupWebpageOperation);

    } catch (Exception e) {
      e.printStackTrace();
      throw e;
    } finally {
      cleanup(valuesHolder);
    }
  }

  public static void cleanup(ValuesHolder valuesHolder) throws Exception {
    AdGroupServiceSample.cleanup(valuesHolder);
  }

  private static ValuesHolder setup() throws Exception {
    return AdGroupServiceSample.create();
  }

  /**
   * example get adGroup webpages.
   *
   * @param adGroupWebpageSelector AdGroupWebpageSelector
   * @return AdGroupWebpageValues
   */
  public static List<AdGroupWebpageValues> get(AdGroupWebpageSelector adGroupWebpageSelector) throws Exception {

    // Call API
    System.out.println("############################################");
    System.out.println("AdGroupWebpageService::GET");
    System.out.println("############################################");

    Holder<AdGroupWebpagePage> adGroupWebpagePage = new Holder<AdGroupWebpagePage>();
    Holder<List<Error>> errorHolder = new Holder<List<Error>>();
    AdGroupWebpageServiceInterface adGroupWebpageService = SoapUtils.createServiceInterface(AdGroupWebpageServiceInterface.class, AdGroupWebpageService.class);
    adGroupWebpageService.get(adGroupWebpageSelector, adGroupWebpagePage, errorHolder);

    SoapUtils.checkSoapError(errorHolder, adGroupWebpagePage.value.getValues());

    // Response
    return adGroupWebpagePage.value.getValues();
  }

  /**
   * example mutate adGroup webpages.
   *
   * @param operation AdGroupWebpageOperation
   * @return AdGroupWebpageValues
   */
  public static List<AdGroupWebpageValues> mutate(AdGroupWebpageOperation operation) throws Exception {

    // Call API
    System.out.println("############################################");
    System.out.println("AdGroupWebpageService::mutate(" + operation.getOperator() + ")");
    System.out.println("############################################");

    Holder<AdGroupWebpageReturnValue> adGroupAdReturnValueHolder = new Holder<AdGroupWebpageReturnValue>();
    Holder<List<Error>> errorHolder = new Holder<List<Error>>();
    AdGroupWebpageServiceInterface adGroupWebpageService = SoapUtils.createServiceInterface(AdGroupWebpageServiceInterface.class, AdGroupWebpageService.class);
    adGroupWebpageService.mutate(operation, adGroupAdReturnValueHolder, errorHolder);

    SoapUtils.checkSoapError(errorHolder, adGroupAdReturnValueHolder.value.getValues());

    // Response
    return adGroupAdReturnValueHolder.value.getValues();
  }

  /**
   * example get request.
   *
   * @param accountId       long
   * @param adGroupWebpages List<AdGroupWebpage>
   * @return AdGroupWebpageSelector
   */
  public static AdGroupWebpageSelector buildExampleGetRequest(long accountId, List<AdGroupWebpage> adGroupWebpages) {
    AdGroupWebpageSelector selector = new AdGroupWebpageSelector();
    selector.setAccountId(accountId);

    if (!adGroupWebpages.isEmpty()) {
      List<Long> campaignIds = new ArrayList<>();
      List<Long> adGroupIds = new ArrayList<>();
      List<Long> targetIds = new ArrayList<>();
      for (AdGroupWebpage value : adGroupWebpages) {
        campaignIds.add(value.getCampaignId());
        adGroupIds.add(value.getAdGroupId());
        targetIds.add(value.getWebpage().getTargetId());
      }
      selector.getCampaignIds().addAll(campaignIds);
      selector.getAdGroupIds().addAll(adGroupIds);
      selector.getTargetIds().addAll(targetIds);

    }
    Paging paging = new Paging();
    paging.setStartIndex(1);
    paging.setNumberResults(20);
    selector.setPaging(paging);

    return selector;
  }

  /**
   * create sample request.
   *
   * @param operator        Operator
   * @param accountId       long
   * @param adGroupWebpages List<AdGroupWebpage>
   * @return AdGroupWebpageOperation
   */
  public static AdGroupWebpageOperation buildExampleMutateRequest(Operator operator, long accountId, List<AdGroupWebpage> adGroupWebpages) {
    // Set Operation
    AdGroupWebpageOperation operation = new AdGroupWebpageOperation();
    operation.setOperator(operator);
    operation.setAccountId(accountId);
    operation.getOperand().addAll(adGroupWebpages);

    return operation;
  }

  /**
   * example Campaign Webpage request.
   *
   * @param campaignId Long
   * @param adGroupId  Long
   * @return AdGroupWebpage
   */
  public static AdGroupWebpage createExampleAdGroupWebpage(Long campaignId, Long adGroupId) {

    AdGroupWebpage adGroupWebpage = new AdGroupWebpage();
    adGroupWebpage.setCampaignId(campaignId);
    adGroupWebpage.setAdGroupId(adGroupId);

    adGroupWebpage.setUserStatus(UserStatus.ACTIVE);
    adGroupWebpage.setExcludedType(ExcludedType.INCLUDED);

    WebpageCondition condition1 = new WebpageCondition();
    condition1.setType(WebpageConditionType.URL);
    condition1.setArgument("yahoo.co.jp");

    WebpageCondition condition2 = new WebpageCondition();
    condition2.setType(WebpageConditionType.PAGE_TITLE);
    condition2.setArgument("YahooJapan");

    WebpageCondition condition3 = new WebpageCondition();
    condition3.setType(WebpageConditionType.CUSTOM_LABEL);
    condition3.setArgument("sample");

    WebpageParameter webpageParameter = new WebpageParameter();
    webpageParameter.getConditions().addAll(Arrays.asList(condition1, condition2, condition3));

    Webpage webpage = new Webpage();
    webpage.setParameter(webpageParameter);

    adGroupWebpage.setWebpage(webpage);

    Bid bid = new Bid();
    bid.setMaxCpc(100L);
    adGroupWebpage.setBid(bid);

    return adGroupWebpage;
  }

  /**
   * example AdGroup Webpage set request.
   *
   * @param adGourpWebpages List<AdGroupWebpage>
   * @return List<AdGroupWebpage>
   */
  public static List<AdGroupWebpage> createExampleSetRequest(List<AdGroupWebpage> adGourpWebpages) {

    List<AdGroupWebpage> operands = new ArrayList<>();
    for (AdGroupWebpage value : adGourpWebpages) {
      AdGroupWebpage adGroupWebpage = new AdGroupWebpage();
      adGroupWebpage.setCampaignId(value.getCampaignId());
      adGroupWebpage.setAdGroupId(value.getAdGroupId());
      adGroupWebpage.setWebpage(value.getWebpage());

      Bid bid = new Bid();
      bid.setMaxCpc(150L);
      adGroupWebpage.setBid(bid);

      operands.add(adGroupWebpage);
    }

    return operands;
  }

}
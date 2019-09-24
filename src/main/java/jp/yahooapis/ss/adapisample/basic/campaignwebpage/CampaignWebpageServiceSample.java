/**
 * Copyright (C) 2019 Yahoo Japan Corporation. All Rights Reserved.
 */
package jp.yahooapis.ss.adapisample.basic.campaignwebpage;

import jp.yahooapis.ss.adapisample.basic.campaign.CampaignServiceSample;
import jp.yahooapis.ss.adapisample.repository.ValuesRepositoryFacade;
import jp.yahooapis.ss.adapisample.util.SoapUtils;
import jp.yahooapis.ss.adapisample.util.ValuesHolder;
import jp.yahooapis.ss.v201909.Error;
import jp.yahooapis.ss.v201909.Paging;
import jp.yahooapis.ss.v201909.campaign.CampaignType;
import jp.yahooapis.ss.v201909.campaignwebpage.CampaignWebpage;
import jp.yahooapis.ss.v201909.campaignwebpage.CampaignWebpageOperation;
import jp.yahooapis.ss.v201909.campaignwebpage.CampaignWebpagePage;
import jp.yahooapis.ss.v201909.campaignwebpage.CampaignWebpageReturnValue;
import jp.yahooapis.ss.v201909.campaignwebpage.CampaignWebpageSelector;
import jp.yahooapis.ss.v201909.campaignwebpage.CampaignWebpageService;
import jp.yahooapis.ss.v201909.campaignwebpage.CampaignWebpageServiceInterface;
import jp.yahooapis.ss.v201909.campaignwebpage.CampaignWebpageValues;
import jp.yahooapis.ss.v201909.campaignwebpage.Operator;
import jp.yahooapis.ss.v201909.campaignwebpage.Webpage;
import jp.yahooapis.ss.v201909.campaignwebpage.WebpageCondition;
import jp.yahooapis.ss.v201909.campaignwebpage.WebpageConditionType;
import jp.yahooapis.ss.v201909.campaignwebpage.WebpageParameter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import javax.xml.ws.Holder;

/**
 * example CampaignWebpageService operation and Utility method collection.
 */
public class CampaignWebpageServiceSample {
  /**
   * main method for CampaignWebpageService
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

      // =================================================================
      // CampaignWebpageService ADD
      // =================================================================
      // create request.
      CampaignWebpageOperation addCampaignWebpageOperation = buildExampleMutateRequest( //
          Operator.ADD, accountId, Collections.singletonList(createExampleCampaignWebpage(campaignId)));

      // run
      List<CampaignWebpageValues> campaignWebpageValues = mutate(addCampaignWebpageOperation);

      List<CampaignWebpage> campaignWebpages = new ArrayList<>();
      for (CampaignWebpageValues values : campaignWebpageValues) {
        campaignWebpages.add(values.getCampaignWebpage());
      }

      // =================================================================
      // CampaignWebpageService GET
      // =================================================================
      // create request.
      CampaignWebpageSelector selector = buildExampleGetRequest(accountId, campaignWebpages);

      // run
      get(selector);

      // =================================================================
      // CampaignWebpageService REMOVE
      // =================================================================
      // create request.
      CampaignWebpageOperation removeCampaignWebpageOperation = buildExampleMutateRequest(Operator.REMOVE, accountId, campaignWebpages);

      // run
      mutate(removeCampaignWebpageOperation);

    } catch (Exception e) {
      e.printStackTrace();
      throw e;
    } finally {
      cleanup(valuesHolder);
    }
  }

  public static void cleanup(ValuesHolder valuesHolder) throws Exception {
    CampaignServiceSample.cleanup(valuesHolder);
  }

  private static ValuesHolder setup() throws Exception {
    return CampaignServiceSample.create();
  }

  /**
   * example get campaign webpages.
   *
   * @param campaignWebpageSelector CampaignWebpageSelector
   * @return CampaignWebpageValues
   */
  public static List<CampaignWebpageValues> get(CampaignWebpageSelector campaignWebpageSelector) throws Exception {

    // Call API
    System.out.println("############################################");
    System.out.println("CampaignWebpageService::GET");
    System.out.println("############################################");

    Holder<CampaignWebpagePage> campaignWebpagePage = new Holder<CampaignWebpagePage>();
    Holder<List<Error>> errorHolder = new Holder<List<Error>>();
    CampaignWebpageServiceInterface campaignWebpageService = SoapUtils.createServiceInterface(CampaignWebpageServiceInterface.class, CampaignWebpageService.class);
    campaignWebpageService.get(campaignWebpageSelector, campaignWebpagePage, errorHolder);

    SoapUtils.checkSoapError(errorHolder, campaignWebpagePage.value.getValues());

    // Response
    return campaignWebpagePage.value.getValues();
  }

  /**
   * example mutate campaign webpages.
   *
   * @param operation CampaignWebpageOperation
   * @return CampaignWebpageValues
   */
  public static List<CampaignWebpageValues> mutate(CampaignWebpageOperation operation) throws Exception {

    // Call API
    System.out.println("############################################");
    System.out.println("CampaignWebpageService::mutate(" + operation.getOperator() + ")");
    System.out.println("############################################");

    Holder<CampaignWebpageReturnValue> campaignWebpageReturnValue = new Holder<CampaignWebpageReturnValue>();
    Holder<List<Error>> errorHolder = new Holder<List<Error>>();
    CampaignWebpageServiceInterface campaignWebpageService = SoapUtils.createServiceInterface(CampaignWebpageServiceInterface.class, CampaignWebpageService.class);
    campaignWebpageService.mutate(operation, campaignWebpageReturnValue, errorHolder);

    SoapUtils.checkSoapError(errorHolder, campaignWebpageReturnValue.value.getValues());

    // Response
    return campaignWebpageReturnValue.value.getValues();
  }

  /**
   * example get request.
   *
   * @param accountId        long
   * @param campaignWebpages List<CampaignWebpage>
   * @return CampaignWebpageSelector
   */
  public static CampaignWebpageSelector buildExampleGetRequest(long accountId, List<CampaignWebpage> campaignWebpages) {
    CampaignWebpageSelector selector = new CampaignWebpageSelector();
    selector.setAccountId(accountId);

    if (!campaignWebpages.isEmpty()) {
      List<Long> campaignIds = new ArrayList<>();
      List<Long> targetIds = new ArrayList<>();
      for (CampaignWebpage value : campaignWebpages) {
        campaignIds.add(value.getCampaignId());
        targetIds.add(value.getWebpage().getTargetId());
      }
      selector.getCampaignIds().addAll(campaignIds);
      selector.getTargetIds().addAll(targetIds);

    }
    Paging paging = new Paging();
    paging.setStartIndex(1);
    paging.setNumberResults(20);
    selector.setPaging(paging);

    return selector;
  }

  /**
   * example mutate request.
   *
   * @param operator            Operator
   * @param accountId           long
   * @param campaignWebpageList List<CampaignWebpage>
   * @return CampaignWebpageOperation
   */
  public static CampaignWebpageOperation buildExampleMutateRequest(Operator operator, long accountId, List<CampaignWebpage> campaignWebpageList) {
    CampaignWebpageOperation operation = new CampaignWebpageOperation();
    operation.setOperator(operator);
    operation.setAccountId(accountId);

    operation.getOperand().addAll(campaignWebpageList);

    return operation;
  }

  /**
   * example Campaign Webpage request.
   *
   * @param campaignId Long
   * @return CampaignWebpage
   */
  public static CampaignWebpage createExampleCampaignWebpage(Long campaignId) {

    CampaignWebpage campaignWebpage = new CampaignWebpage();
    campaignWebpage.setCampaignId(campaignId);

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

    campaignWebpage.setWebpage(webpage);

    return campaignWebpage;
  }
}
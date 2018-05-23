package jp.co.yahoo.ad_api_sample.keywordEstimatorSample;

import jp.co.yahoo.ad_api_sample.error.impl.KeywordEstimatorServiceErrorEntityFactory;
import jp.co.yahoo.ad_api_sample.util.SoapUtils;
import jp.yahooapis.ss.v201805.Error;
import jp.yahooapis.ss.v201805.keywordestimator.AdGroupEstimateRequest;
import jp.yahooapis.ss.v201805.keywordestimator.CampaignEstimateRequest;
import jp.yahooapis.ss.v201805.keywordestimator.EstimateKeyword;
import jp.yahooapis.ss.v201805.keywordestimator.IsNegativeBool;
import jp.yahooapis.ss.v201805.keywordestimator.KeywordEstimateRequest;
import jp.yahooapis.ss.v201805.keywordestimator.KeywordEstimateResult;
import jp.yahooapis.ss.v201805.keywordestimator.KeywordEstimateValues;
import jp.yahooapis.ss.v201805.keywordestimator.KeywordEstimatorPage;
import jp.yahooapis.ss.v201805.keywordestimator.KeywordEstimatorSelector;
import jp.yahooapis.ss.v201805.keywordestimator.KeywordEstimatorService;
import jp.yahooapis.ss.v201805.keywordestimator.KeywordEstimatorServiceInterface;
import jp.yahooapis.ss.v201805.keywordestimator.KeywordMatchType;

import java.util.Arrays;
import java.util.List;

import javax.xml.ws.Holder;

/**
 * Sample Program for KeywordEstimatorService. Copyright (C) 2012 Yahoo Japan Corporation. All
 * Rights Reserved.
 */
public class KeywordEstimatorSample {

  /**
   * main method for KeywordEstimatorSample
   *
   * @param args command line arguments
   * @throws Exception
   */
  public static void main(String[] args) throws Exception {
    try {
      // =================================================================
      // Setting
      // =================================================================
      long accountId = SoapUtils.getAccountId();

      // -----------------------------------------------
      // KeywordEstimatorService::get
      // -----------------------------------------------
      // Set Selector
      KeywordEstimateRequest keyword1 = new KeywordEstimateRequest();
      EstimateKeyword estimateKeyword1 = new EstimateKeyword();
      estimateKeyword1.setText("sample1");
      estimateKeyword1.setMatchType(KeywordMatchType.EXACT);
      keyword1.setKeyword(estimateKeyword1);
      keyword1.setMaxCpc(Long.valueOf(100));
      keyword1.setIsNegative(IsNegativeBool.FALSE);
      KeywordEstimateRequest keyword2 = new KeywordEstimateRequest();
      EstimateKeyword estimateKeyword2 = new EstimateKeyword();
      estimateKeyword2.setText("sample2");
      estimateKeyword2.setMatchType(KeywordMatchType.PHRASE);
      keyword2.setKeyword(estimateKeyword2);
      keyword2.setMaxCpc(Long.valueOf(150));

      AdGroupEstimateRequest adGroupEstimateRequest1 = new AdGroupEstimateRequest();
      adGroupEstimateRequest1.getKeywordEstimateRequests().add(keyword1);
      adGroupEstimateRequest1.setMaxCpc(Long.valueOf(500));

      AdGroupEstimateRequest adGroupEstimateRequest2 = new AdGroupEstimateRequest();
      adGroupEstimateRequest2.getKeywordEstimateRequests().add(keyword2);
      adGroupEstimateRequest2.setMaxCpc(Long.valueOf(300));

      CampaignEstimateRequest campaignEstimateRequest = new CampaignEstimateRequest();
      campaignEstimateRequest.getAdGroupEstimateRequests().addAll(Arrays.asList(adGroupEstimateRequest1, adGroupEstimateRequest2));
      KeywordEstimatorSelector selector = new KeywordEstimatorSelector();
      selector.setAccountId(accountId);
      selector.setCampaignEstimateRequest(campaignEstimateRequest);

      // Run
      get(selector);

    } catch (Exception e) {
      e.printStackTrace();
      throw e;
    }
  }

  /**
   * Sample Program for KeywordEstimatorService GET.
   *
   * @param selector KeywordEstimatorSelector
   * @return KeywordEstimateValues
   * @throws Exception
   */
  public static List<KeywordEstimateValues> get(KeywordEstimatorSelector selector) throws Exception {

    // call API
    System.out.println("############################################");
    System.out.println("KeywordEstimatorService::get");
    System.out.println("############################################");

    Holder<KeywordEstimatorPage> keywordEstimatorPageHolder = new Holder<KeywordEstimatorPage>();
    Holder<List<Error>> errorArrayHolder = new Holder<List<Error>>();
    KeywordEstimatorServiceInterface keywordEstimatorService = SoapUtils.createServiceInterface(KeywordEstimatorServiceInterface.class, KeywordEstimatorService.class);
    keywordEstimatorService.get(selector, keywordEstimatorPageHolder, errorArrayHolder);

    // Error
    if (errorArrayHolder.value != null && errorArrayHolder.value.size() > 0) {
      SoapUtils.displayErrors(new KeywordEstimatorServiceErrorEntityFactory(errorArrayHolder.value), true);
    }
    if (errorArrayHolder.value == null) {
      throw new Exception("NoDataResponse:KeywordEstimatorService Get");
    }

    // Display
    for (KeywordEstimateValues values : keywordEstimatorPageHolder.value.getValues()) {
      if (values.isOperationSucceeded()) {
        display(values.getData());
      } else {
        SoapUtils.displayErrors(new KeywordEstimatorServiceErrorEntityFactory(errorArrayHolder.value), true);
      }
    }

    // Response
    return keywordEstimatorPageHolder.value.getValues();
  }

  /**
   * display KeywordEstimateResult entity to stdout.
   * 
   * @param data KeywordEstimateResult entity for display.
   */
  private static void display(KeywordEstimateResult data) {
    System.out.println("keyword = " + data.getKeyword());
    if (data.getMin() != null) {
      System.out.println("min/clicks = " + data.getMin().getClicks());
      System.out.println("min/rank = " + data.getMin().getRank());
      System.out.println("min/cpc = " + data.getMin().getCpc());
      System.out.println("min/cost = " + data.getMin().getCost());
    }
    if (data.getMax() != null) {
      System.out.println("max/clicks = " + data.getMax().getClicks());
      System.out.println("max/rank = " + data.getMax().getRank());
      System.out.println("max/cpc = " + data.getMax().getCpc());
      System.out.println("min/cost = " + data.getMax().getCost());
    }
    System.out.println("---------");

  }
}

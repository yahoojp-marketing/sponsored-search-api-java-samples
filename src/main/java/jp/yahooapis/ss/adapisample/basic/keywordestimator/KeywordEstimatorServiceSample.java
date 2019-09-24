/**
 * Copyright (C) 2019 Yahoo Japan Corporation. All Rights Reserved.
 */
package jp.yahooapis.ss.adapisample.basic.keywordestimator;

import jp.yahooapis.ss.adapisample.util.SoapUtils;
import jp.yahooapis.ss.v201909.Error;
import jp.yahooapis.ss.v201909.keywordestimator.AdGroupEstimateRequest;
import jp.yahooapis.ss.v201909.keywordestimator.CampaignEstimateRequest;
import jp.yahooapis.ss.v201909.keywordestimator.EstimateKeyword;
import jp.yahooapis.ss.v201909.keywordestimator.IsNegativeBool;
import jp.yahooapis.ss.v201909.keywordestimator.KeywordEstimateRequest;
import jp.yahooapis.ss.v201909.keywordestimator.KeywordEstimateValues;
import jp.yahooapis.ss.v201909.keywordestimator.KeywordEstimatorPage;
import jp.yahooapis.ss.v201909.keywordestimator.KeywordEstimatorSelector;
import jp.yahooapis.ss.v201909.keywordestimator.KeywordEstimatorService;
import jp.yahooapis.ss.v201909.keywordestimator.KeywordEstimatorServiceInterface;
import jp.yahooapis.ss.v201909.keywordestimator.KeywordMatchType;

import java.util.Arrays;
import java.util.List;

import javax.xml.ws.Holder;

/**
 * example KeywordEstimatorService operation and Utility method collection.
 */
public class KeywordEstimatorServiceSample {

  /**
   * example KeywordEstimatorService operation.
   *
   * @param args command line arguments
   * @throws Exception
   */
  public static void main(String[] args) throws Exception {
    try {
      // =================================================================
      // Setup
      // =================================================================
      long accountId = SoapUtils.getAccountId();


      // =================================================================
      // KeywordEstimatorService GET
      // =================================================================
      // create request.
      KeywordEstimatorSelector selector = buildExampleGetRequest(accountId);

      // run
      get(selector);

    } catch (Exception e) {
      e.printStackTrace();
      throw e;
    }
  }

  /**
   * example get request.
   *
   * @param accountId long
   * @return KeywordEstimatorSelector
   */
  public static KeywordEstimatorSelector buildExampleGetRequest(long accountId) {
    EstimateKeyword estimateKeyword1 = new EstimateKeyword();
    estimateKeyword1.setText("sample1");
    estimateKeyword1.setMatchType(KeywordMatchType.EXACT);
    KeywordEstimateRequest keywordEstimateRequest1 = new KeywordEstimateRequest();
    keywordEstimateRequest1.setKeyword(estimateKeyword1);
    keywordEstimateRequest1.setMaxCpc(100L);
    AdGroupEstimateRequest adGroupEstimateRequest1 = new AdGroupEstimateRequest();
    adGroupEstimateRequest1.getKeywordEstimateRequests().add(keywordEstimateRequest1);
    adGroupEstimateRequest1.setMaxCpc(500L);

    EstimateKeyword estimateKeyword2 = new EstimateKeyword();
    estimateKeyword2.setText("sample2");
    estimateKeyword2.setMatchType(KeywordMatchType.EXACT);
    KeywordEstimateRequest keywordEstimateRequest2 = new KeywordEstimateRequest();
    keywordEstimateRequest2.setKeyword(estimateKeyword2);
    keywordEstimateRequest2.setMaxCpc(100L);
    AdGroupEstimateRequest adGroupEstimateRequest2 = new AdGroupEstimateRequest();
    adGroupEstimateRequest2.getKeywordEstimateRequests().add(keywordEstimateRequest2);
    adGroupEstimateRequest2.setMaxCpc(500L);

    CampaignEstimateRequest campaignEstimateRequest = new CampaignEstimateRequest();
    campaignEstimateRequest.getAdGroupEstimateRequests().add(adGroupEstimateRequest1);
    campaignEstimateRequest.getAdGroupEstimateRequests().add(adGroupEstimateRequest2);
    KeywordEstimatorSelector selector = new KeywordEstimatorSelector();
    selector.setAccountId(accountId);
    selector.setCampaignEstimateRequest(campaignEstimateRequest);
    return selector;
  }

  /**
   * example get keywordEstimator.
   *
   * @param selector KeywordEstimatorSelector
   * @return List<KeywordEstimateValues>
   * @throws Exception
   */
  public static List<KeywordEstimateValues> get(KeywordEstimatorSelector selector) throws Exception {

    // call API
    System.out.println("############################################");
    System.out.println("KeywordEstimatorService::get");
    System.out.println("############################################");

    Holder<KeywordEstimatorPage> keywordEstimatorPageHolder = new Holder<KeywordEstimatorPage>();
    Holder<List<Error>> errorHolder = new Holder<List<Error>>();
    KeywordEstimatorServiceInterface keywordEstimatorService = SoapUtils.createServiceInterface(KeywordEstimatorServiceInterface.class, KeywordEstimatorService.class);
    keywordEstimatorService.get(selector, keywordEstimatorPageHolder, errorHolder);

    SoapUtils.checkSoapError(errorHolder, keywordEstimatorPageHolder.value.getValues());

    // Response
    return keywordEstimatorPageHolder.value.getValues();
  }
}

package jp.co.yahoo.ad_api_sample.keywordEstimatorSample;

import java.util.Arrays;
import java.util.List;

import javax.xml.ws.Holder;

import jp.co.yahoo.ad_api_sample.error.impl.KeywordEstimatorServiceErrorEntityFactory;
import jp.co.yahoo.ad_api_sample.util.SoapUtils;
import jp.yahooapis.ss.V5.KeywordEstimatorService.AdGroupEstimateRequest;
import jp.yahooapis.ss.V5.KeywordEstimatorService.CampaignEstimateRequest;
import jp.yahooapis.ss.V5.KeywordEstimatorService.Error;
import jp.yahooapis.ss.V5.KeywordEstimatorService.EstimateKeyword;
import jp.yahooapis.ss.V5.KeywordEstimatorService.IsNegativeBool;
import jp.yahooapis.ss.V5.KeywordEstimatorService.KeywordEstimateRequest;
import jp.yahooapis.ss.V5.KeywordEstimatorService.KeywordEstimateResult;
import jp.yahooapis.ss.V5.KeywordEstimatorService.KeywordEstimateValues;
import jp.yahooapis.ss.V5.KeywordEstimatorService.KeywordEstimatorPage;
import jp.yahooapis.ss.V5.KeywordEstimatorService.KeywordEstimatorSelector;
import jp.yahooapis.ss.V5.KeywordEstimatorService.KeywordEstimatorService;
import jp.yahooapis.ss.V5.KeywordEstimatorService.KeywordEstimatorServiceInterface;
import jp.yahooapis.ss.V5.KeywordEstimatorService.KeywordMatchType;

/**
 * Sample Program for KeywordEstimatorService. Copyright (C) 2012 Yahoo Japan Corporation. All
 * Rights Reserved.
 */
public class KeywordEstimatorSample {

  /**
   * main method for KeywordEstimatorSample
   *
   * @param args command line arguments
   */
  public static void main(String[] args) {
    long accountId = SoapUtils.getAccountId();
    try {
      // =================================================================
      // KeywordEstimatorService
      // =================================================================
      KeywordEstimatorServiceInterface keywordEstimatorService = SoapUtils.createServiceInterface(KeywordEstimatorServiceInterface.class, KeywordEstimatorService.class);

      // -----------------------------------------------
      // KeywordEstimatorService::get
      // -----------------------------------------------
      // request
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
      KeywordEstimatorSelector keywordEstimatorSelector = new KeywordEstimatorSelector();
      keywordEstimatorSelector.setAccountId(accountId);
      keywordEstimatorSelector.setCampaignEstimateRequest(campaignEstimateRequest);

      // call API
      System.out.println("############################################");
      System.out.println("KeywordEstimatorService::get");
      System.out.println("############################################");
      Holder<KeywordEstimatorPage> keywordEstimatorPageHolder = new Holder<KeywordEstimatorPage>();
      Holder<List<Error>> errorArrayHolder = new Holder<List<Error>>();
      keywordEstimatorService.get(keywordEstimatorSelector, keywordEstimatorPageHolder, errorArrayHolder);

      // if error
      if (errorArrayHolder.value != null && errorArrayHolder.value.size() > 0) {
        SoapUtils.displayErrors(new KeywordEstimatorServiceErrorEntityFactory(errorArrayHolder.value), true);

      }

      // response
      if (keywordEstimatorPageHolder.value != null) {
        if (keywordEstimatorPageHolder.value.getValues() != null) {
          for (KeywordEstimateValues values : keywordEstimatorPageHolder.value.getValues()) {
            if (values.isOperationSucceeded()) {
              // display response
              displayKeywordEstimateResult(values.getData());
            } else {
              // if error
              SoapUtils.displayErrors(new KeywordEstimatorServiceErrorEntityFactory(errorArrayHolder.value), true);
            }
          }
        }
      }


    } catch (Exception ex) {
      ex.printStackTrace();
    }
  }

  /**
   * display KeywordEstimateResult entity to stdout.
   * 
   * @param data KeywordEstimateResult entity for display.
   */
  private static void displayKeywordEstimateResult(KeywordEstimateResult data) {
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

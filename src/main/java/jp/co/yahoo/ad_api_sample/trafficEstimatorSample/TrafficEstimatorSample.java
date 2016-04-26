package jp.co.yahoo.ad_api_sample.trafficEstimatorSample;

import java.util.List;

import javax.xml.ws.Holder;

import jp.co.yahoo.ad_api_sample.error.impl.TrafficEstimatorServiceEntityFactory;
import jp.co.yahoo.ad_api_sample.util.SoapUtils;
import jp.yahooapis.ss.V6.TrafficEstimatorService.CarrierName;
import jp.yahooapis.ss.V6.TrafficEstimatorService.CriterionType;
import jp.yahooapis.ss.V6.TrafficEstimatorService.DesktopEstimateResult;
import jp.yahooapis.ss.V6.TrafficEstimatorService.Error;
import jp.yahooapis.ss.V6.TrafficEstimatorService.EstimateNetwork;
import jp.yahooapis.ss.V6.TrafficEstimatorService.EstimateRequest;
import jp.yahooapis.ss.V6.TrafficEstimatorService.EstimateTarget;
import jp.yahooapis.ss.V6.TrafficEstimatorService.EstimateValues;
import jp.yahooapis.ss.V6.TrafficEstimatorService.KeywordMatchType;
import jp.yahooapis.ss.V6.TrafficEstimatorService.ProposalKeyword;
import jp.yahooapis.ss.V6.TrafficEstimatorService.ProposalPlatformTarget;
import jp.yahooapis.ss.V6.TrafficEstimatorService.ProposalPlatformType;
import jp.yahooapis.ss.V6.TrafficEstimatorService.SmartPhoneEstimateResult;
import jp.yahooapis.ss.V6.TrafficEstimatorService.TotalEstimateResult;
import jp.yahooapis.ss.V6.TrafficEstimatorService.TrafficEstimateResult;
import jp.yahooapis.ss.V6.TrafficEstimatorService.TrafficEstimatorPage;
import jp.yahooapis.ss.V6.TrafficEstimatorService.TrafficEstimatorSelector;
import jp.yahooapis.ss.V6.TrafficEstimatorService.TrafficEstimatorService;
import jp.yahooapis.ss.V6.TrafficEstimatorService.TrafficEstimatorServiceInterface;
import jp.yahooapis.ss.V6.TrafficEstimatorService.WapMobileEstimateResult;
import jp.yahooapis.ss.V6.TrafficEstimatorService.WapType;


/**
 * Sample Program for TrafficEstimatorService. Copyright (C) 2012 Yahoo Japan Corporation. All
 * Rights Reserved.
 */
public class TrafficEstimatorSample {

  /**
   * main method for TrafficEstimatorSample
   *
   * @param args command line arguments
   */
  public static void main(String[] args) {
    try {
      // =================================================================
      // TrafficEstimatorService
      // =================================================================
      TrafficEstimatorServiceInterface trafficEstimatorService = SoapUtils.createServiceInterface(TrafficEstimatorServiceInterface.class, TrafficEstimatorService.class);

      // -----------------------------------------------
      // TrafficEstimatorService::get
      // -----------------------------------------------
      // request
      EstimateTarget estimateTarget = new EstimateTarget();
      estimateTarget.setMobileCarrier(CarrierName.ALL);
      estimateTarget.setNetwork(EstimateNetwork.ALL);
      ProposalKeyword proposalKeyword = new ProposalKeyword();
      proposalKeyword.setMatchType(KeywordMatchType.PHRASE);
      proposalKeyword.setText("sample");
      proposalKeyword.setType(CriterionType.KEYWORD);
      ProposalPlatformTarget platform = new ProposalPlatformTarget();
      platform.setPlatformName(ProposalPlatformType.SMART_PHONE);
      platform.setBidMultiplier(new Double(1.0));

      EstimateRequest estimateRequest = new EstimateRequest();
      estimateRequest.setTarget(estimateTarget);
      estimateRequest.setKeyword(proposalKeyword);
      estimateRequest.setBid(100);
      estimateRequest.getPlatform().add(platform);
      estimateRequest.setWap(WapType.WAP_INCLUDED);

      TrafficEstimatorSelector trafficEstimatorSelector = new TrafficEstimatorSelector();
      trafficEstimatorSelector.getEstimateRequest().add(estimateRequest);
      trafficEstimatorSelector.setMonth(1);

      // call API
      System.out.println("############################################");
      System.out.println("TrafficEstimatorService::get");
      System.out.println("############################################");
      Holder<TrafficEstimatorPage> trafficEstimatorPageHolder = new Holder<TrafficEstimatorPage>();
      Holder<List<Error>> errorArrayHolder = new Holder<List<Error>>();
      trafficEstimatorService.get(trafficEstimatorSelector, trafficEstimatorPageHolder, errorArrayHolder);

      // if error
      if (errorArrayHolder.value != null && errorArrayHolder.value.size() > 0) {
        SoapUtils.displayErrors(new TrafficEstimatorServiceEntityFactory(errorArrayHolder.value), true);
      }

      // response
      if (trafficEstimatorPageHolder.value != null) {
        if (trafficEstimatorPageHolder.value.getValues() != null) {
          for (EstimateValues values : trafficEstimatorPageHolder.value.getValues()) {
            if (values.isOperationSucceeded()) {
              // display response
              displayEstimateResult(values.getData());
            } else {
              // if error
              SoapUtils.displayErrors(new TrafficEstimatorServiceEntityFactory(values.getError()), true);
            }
          }
        }
      }


    } catch (Exception ex) {
      ex.printStackTrace();
    }
  }


  /**
   * display EstimateResult entity to stdout.
   * 
   * @param data EstimateResult entity for display.
   */
  private static void displayEstimateResult(List<TrafficEstimateResult> data) {
    for (int i = 0; i < data.size(); i++) {
      if (data.get(i) instanceof TotalEstimateResult) {
        TotalEstimateResult totalResult = (TotalEstimateResult) data.get(i);
        System.out.println("type = " + totalResult.getType());
        System.out.println("keyword = " + totalResult.getKeyword());
        System.out.println("matchType = " + totalResult.getMatchType());
        System.out.println("bid = " + totalResult.getBid());
        System.out.println("impressions = " + totalResult.getImpressions());
        System.out.println("clicks = " + totalResult.getClicks());
        System.out.println("rank = " + totalResult.getRank());
        System.out.println("cpc = " + totalResult.getCpc());
        System.out.println("carrier = " + totalResult.getCarrier());
      }
      if (data.get(i) instanceof DesktopEstimateResult) {
        DesktopEstimateResult desktopResult = (DesktopEstimateResult) data.get(i);
        System.out.println("type = " + desktopResult.getType());
        System.out.println("keyword = " + desktopResult.getKeyword());
        System.out.println("matchType = " + desktopResult.getMatchType());
        System.out.println("bid = " + desktopResult.getBid());
        System.out.println("impressions = " + desktopResult.getImpressions());
        System.out.println("clicks = " + desktopResult.getClicks());
        System.out.println("rank = " + desktopResult.getRank());
        System.out.println("cpc = " + desktopResult.getCpc());
      }
      if (data.get(i) instanceof SmartPhoneEstimateResult) {
        SmartPhoneEstimateResult smartphoneResult = (SmartPhoneEstimateResult) data.get(i);
        System.out.println("type = " + smartphoneResult.getType());
        System.out.println("keyword = " + smartphoneResult.getKeyword());
        System.out.println("matchType = " + smartphoneResult.getMatchType());
        System.out.println("bid = " + smartphoneResult.getBid());
        System.out.println("impressions = " + smartphoneResult.getImpressions());
        System.out.println("clicks = " + smartphoneResult.getClicks());
        System.out.println("rank = " + smartphoneResult.getRank());
        System.out.println("cpc = " + smartphoneResult.getCpc());
      }
      if (data.get(i) instanceof WapMobileEstimateResult) {
        WapMobileEstimateResult wapmobileResult = (WapMobileEstimateResult) data.get(i);
        System.out.println("type = " + wapmobileResult.getType());
        System.out.println("keyword = " + wapmobileResult.getKeyword());
        System.out.println("matchType = " + wapmobileResult.getMatchType());
        System.out.println("bid = " + wapmobileResult.getBid());
        System.out.println("impressions = " + wapmobileResult.getImpressions());
        System.out.println("clicks = " + wapmobileResult.getClicks());
        System.out.println("rank = " + wapmobileResult.getRank());
        System.out.println("cpc = " + wapmobileResult.getCpc());
        System.out.println("carrier = " + wapmobileResult.getCarrier());
      }
      System.out.println("---------");
    }
    System.out.println("=====================");
  }

}

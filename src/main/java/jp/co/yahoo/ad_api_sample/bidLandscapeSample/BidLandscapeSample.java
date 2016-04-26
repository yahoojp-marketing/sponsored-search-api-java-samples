package jp.co.yahoo.ad_api_sample.bidLandscapeSample;

import java.util.List;

import javax.xml.ws.Holder;

import jp.co.yahoo.ad_api_sample.error.impl.BidLandscapeServiceErrorEntityFactory;
import jp.co.yahoo.ad_api_sample.util.SoapUtils;
import jp.yahooapis.ss.V6.BidLandscapeService.AdGroupBidLandscape;
import jp.yahooapis.ss.V6.BidLandscapeService.BidLandscape;
import jp.yahooapis.ss.V6.BidLandscapeService.BidLandscapePage;
import jp.yahooapis.ss.V6.BidLandscapeService.BidLandscapeSelector;
import jp.yahooapis.ss.V6.BidLandscapeService.BidLandscapeService;
import jp.yahooapis.ss.V6.BidLandscapeService.BidLandscapeServiceInterface;
import jp.yahooapis.ss.V6.BidLandscapeService.BidLandscapeValues;
import jp.yahooapis.ss.V6.BidLandscapeService.CriterionBidLandscape;
import jp.yahooapis.ss.V6.BidLandscapeService.Error;
import jp.yahooapis.ss.V6.BidLandscapeService.LandscapePoints;
import jp.yahooapis.ss.V6.BidLandscapeService.SimType;

/**
 * Sample Program for BidLandscapeService. Copyright (C) 2012 Yahoo Japan Corporation. All Rights
 * Reserved.
 */
public class BidLandscapeSample {

  /**
   * main method for BidLandscapeSample
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
      long campaignId = SoapUtils.getCampaignId();
      long adGroupId = SoapUtils.getAdGroupId();
      List<Long> adGroupCriterionIds = SoapUtils.getAdGroupCriterionIds();

      // =================================================================
      // BidLandscapeService::get
      // =================================================================
      // Set Selector
      BidLandscapeSelector selector = new BidLandscapeSelector();
      selector.setAccountId(accountId);
      selector.setCampaignId(campaignId);
      selector.setAdGroupId(adGroupId);
      if (adGroupCriterionIds != null && adGroupCriterionIds.size() > 0) {
        selector.getCriterionIds().addAll(adGroupCriterionIds);
        selector.setSimType(SimType.CRITERION);
      } else {
        selector.setSimType(SimType.ADGROUP);
      }

      // Run
      get(selector);

    } catch (Exception e) {
      e.printStackTrace();
      throw e;
    }
  }

  /**
   * Sample Program for BidLandscapeService GET.
   * 
   * @param selector BidLandscapeSelector
   * @return BidLandscapeValues
   * @throws Exception
   */
  public static List<BidLandscapeValues> get(BidLandscapeSelector selector) throws Exception {

    // call API
    System.out.println("############################################");
    System.out.println("BidLandscapeService::get");
    System.out.println("############################################");

    Holder<BidLandscapePage> bidLandscapePageHolder = new Holder<BidLandscapePage>();
    Holder<List<Error>> bidLandscapeErrorHolder = new Holder<List<Error>>();
    BidLandscapeServiceInterface balanceService = SoapUtils.createServiceInterface(BidLandscapeServiceInterface.class, BidLandscapeService.class);
    balanceService.get(selector, bidLandscapePageHolder, bidLandscapeErrorHolder);

    // Error
    if (bidLandscapeErrorHolder.value != null && bidLandscapeErrorHolder.value.size() > 0) {
      SoapUtils.displayErrors(new BidLandscapeServiceErrorEntityFactory(bidLandscapeErrorHolder.value), true);
    }
    if (bidLandscapeErrorHolder.value == null) {
      throw new Exception("NoDataResponse:BidLandscapeService Get");
    }

    // Display
    for (BidLandscapeValues values : bidLandscapePageHolder.value.getValues()) {
      if (values.isOperationSucceeded()) {
        dispaly(values);
      } else {
        SoapUtils.displayErrors(new BidLandscapeServiceErrorEntityFactory(values.getError()), true);
      }
    }

    return bidLandscapePageHolder.value.getValues();
  }

  /**
   * display BidLandscape entity to stdout.
   *
   * @param values BidLandscape entity for display.
   */
  private static void dispaly(BidLandscapeValues values) {
    if (values.getData() != null) {
      BidLandscape data = values.getData();
      System.out.println("data/campaignId = " + data.getCampaignId());
      System.out.println("data/adGroupId = " + data.getAdGroupId());
      System.out.println("data/startDate = " + data.getStartDate());
      System.out.println("data/endDate = " + data.getEndDate());
      if (data.getLandscapePoints() != null) {
        for (LandscapePoints points : data.getLandscapePoints()) {
          System.out.println("data/landscapePoints/bid = " + points.getBid());
          System.out.println("data/landscapePoints/clicks = " + points.getClicks());
          System.out.println("data/landscapePoints/cost = " + points.getCost());
          System.out.println("data/landscapePoints/marginalCpc = " + points.getMarginalCpc());
          System.out.println("data/landscapePoints/impressions = " + points.getImpressions());
        }
      }
      System.out.println("data/BidLandscape.Type = " + data.getBidLandscapeType());
      if (data instanceof AdGroupBidLandscape) {
        AdGroupBidLandscape adGroup = (AdGroupBidLandscape) data;
        System.out.println("data/type = " + adGroup.getType());
        System.out.println("data/landscapeCurrent = " + adGroup.isLandscapeCurrent());
      } else if (data instanceof CriterionBidLandscape) {
        CriterionBidLandscape criterion = (CriterionBidLandscape) data;
        System.out.println("data/criterionId = " + criterion.getCriterionId());
      }
    }
    System.out.println("---------");
  }

}

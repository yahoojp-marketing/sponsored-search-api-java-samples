/**
 * Copyright (C) 2019 Yahoo Japan Corporation. All Rights Reserved.
 */
package jp.yahooapis.ss.adapisample.basic.bidlandscape;

import jp.yahooapis.ss.adapisample.basic.adgroupcriterion.AdGroupCriterionServiceSample;
import jp.yahooapis.ss.adapisample.repository.ValuesRepositoryFacade;
import jp.yahooapis.ss.adapisample.util.SoapUtils;
import jp.yahooapis.ss.adapisample.util.ValuesHolder;
import jp.yahooapis.ss.v201909.Error;
import jp.yahooapis.ss.v201909.Paging;
import jp.yahooapis.ss.v201909.adgroupcriterion.AdGroupCriterionUse;
import jp.yahooapis.ss.v201909.bidlandscape.BidLandscapePage;
import jp.yahooapis.ss.v201909.bidlandscape.BidLandscapeSelector;
import jp.yahooapis.ss.v201909.bidlandscape.BidLandscapeService;
import jp.yahooapis.ss.v201909.bidlandscape.BidLandscapeServiceInterface;
import jp.yahooapis.ss.v201909.bidlandscape.BidLandscapeValues;
import jp.yahooapis.ss.v201909.bidlandscape.SimType;
import jp.yahooapis.ss.v201909.campaign.CampaignType;

import java.util.Collections;
import java.util.List;

import javax.xml.ws.Holder;

/**
 * example BidLandscapeService operation and Utility method collection.
 */
public class BidLandscapeServiceSample {

  /**
   * example BidLandscapeService operation.
   *
   * @param args command line arguments
   */
  public static void main(String[] args) throws Exception {
    ValuesHolder valuesHolder = new ValuesHolder();
    try {
      // =================================================================
      // Setup
      // =================================================================
      long accountId = SoapUtils.getAccountId();

      // =================================================================
      // check & create upper service object.
      // =================================================================
      // Set Selector
      valuesHolder = setup();
      ValuesRepositoryFacade valuesRepositoryFacade = new ValuesRepositoryFacade(valuesHolder);
      Long campaignId = valuesRepositoryFacade.getCampaignValuesRepository().findCampaignId(CampaignType.STANDARD);
      Long adGroupId = valuesRepositoryFacade.getAdGroupValuesRepository().findAdGroupId(campaignId);
      Long criterionId = valuesRepositoryFacade.getAdGroupCriterionValuesRepository().findCriterionId(campaignId, adGroupId, AdGroupCriterionUse.BIDDABLE);


      // =================================================================
      // BidLandscapeService GET
      // =================================================================
      // create request.
      BidLandscapeSelector selector = buildExampleGetRequest(accountId, campaignId, adGroupId, Collections.singletonList(criterionId));

      // run
      get(selector);

    } catch (Exception e) {
      e.printStackTrace();
      throw e;
    } finally {
      cleanup(valuesHolder);
    }
  }

  /**
   * example get request.
   *
   * @param accountId    long
   * @param campaignId   Long
   * @param adGroupId    Long
   * @param criterionIds List<Long>
   * @return BidLandscapeSelector
   */
  public static BidLandscapeSelector buildExampleGetRequest(long accountId, Long campaignId, Long adGroupId, List<Long> criterionIds) {
    BidLandscapeSelector selector = new BidLandscapeSelector();
    Paging paging = new Paging();
    paging.setStartIndex(1);
    paging.setNumberResults(20);
    selector.setAccountId(accountId);
    selector.setCampaignId(campaignId);
    selector.setAdGroupId(adGroupId);
    selector.getCriterionIds().addAll(criterionIds);
    selector.setSimType(SimType.CRITERION);
    selector.setPaging(paging);
    return selector;
  }

  private static ValuesHolder setup() throws Exception {
    // =================================================================
    // Setting
    // =================================================================
    ValuesHolder valuesHolder = AdGroupCriterionServiceSample.create();
    return valuesHolder;
  }

  public static void cleanup(ValuesHolder valuesHolder) throws Exception {
    AdGroupCriterionServiceSample.cleanup(valuesHolder);
  }

  /**
   * example get bidLandscape.
   *
   * @param selector BidLandscapeSelector
   * @return List<BidLandscapeValues>
   */
  public static List<BidLandscapeValues> get(BidLandscapeSelector selector) throws Exception {

    // call API
    System.out.println("############################################");
    System.out.println("BidLandscapeService::get");
    System.out.println("############################################");

    Holder<BidLandscapePage> bidLandscapePageHolder = new Holder<BidLandscapePage>();
    Holder<List<Error>> errorHolder = new Holder<List<Error>>();
    BidLandscapeServiceInterface balanceService = SoapUtils.createServiceInterface(BidLandscapeServiceInterface.class, BidLandscapeService.class);
    balanceService.get(selector, bidLandscapePageHolder, errorHolder);

    SoapUtils.checkSoapError(errorHolder, bidLandscapePageHolder.value.getValues());

    return bidLandscapePageHolder.value.getValues();
  }
}
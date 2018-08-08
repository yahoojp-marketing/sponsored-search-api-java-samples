package jp.co.yahoo.ad_api_sample.adDisplayOptionSample;

import jp.co.yahoo.ad_api_sample.error.impl.AdGroupFeedServiceErrorEntityFactory;
import jp.co.yahoo.ad_api_sample.util.SoapUtils;
import jp.yahooapis.ss.v201808.Error;
import jp.yahooapis.ss.v201808.Paging;
import jp.yahooapis.ss.v201808.adgroupfeed.AdGroupFeed;
import jp.yahooapis.ss.v201808.adgroupfeed.AdGroupFeedList;
import jp.yahooapis.ss.v201808.adgroupfeed.AdGroupFeedOperation;
import jp.yahooapis.ss.v201808.adgroupfeed.AdGroupFeedPage;
import jp.yahooapis.ss.v201808.adgroupfeed.AdGroupFeedPlaceholderType;
import jp.yahooapis.ss.v201808.adgroupfeed.AdGroupFeedReturnValue;
import jp.yahooapis.ss.v201808.adgroupfeed.AdGroupFeedSelector;
import jp.yahooapis.ss.v201808.adgroupfeed.AdGroupFeedService;
import jp.yahooapis.ss.v201808.adgroupfeed.AdGroupFeedServiceInterface;
import jp.yahooapis.ss.v201808.adgroupfeed.AdGroupFeedValues;
import jp.yahooapis.ss.v201808.adgroupfeed.DevicePlatform;
import jp.yahooapis.ss.v201808.adgroupfeed.Operator;

import java.util.List;

import javax.xml.ws.Holder;

/**
 * Sample Program for AdGroupFeedService Copyright (C) 2013 Yahoo Japan Corporation. All Rights Reserved.
 */
public class AdGroupFeedServiceSample {

  /**
   * Sample Program for AdGroupFeedService SET.
   *
   * @param operation AdGroupFeedOperation
   * @return AdGroupFeedValues
   */
  public static List<AdGroupFeedValues> set(AdGroupFeedOperation operation) throws Exception {

    // call API
    System.out.println("############################################");
    System.out.println("AdGroupFeedService::mutate(SET)");
    System.out.println("############################################");

    Holder<AdGroupFeedReturnValue> adGroupFeedReturnValueHolder = new Holder<AdGroupFeedReturnValue>();
    Holder<List<Error>> errorHolder = new Holder<List<Error>>();
    AdGroupFeedServiceInterface adGroupFeedService = SoapUtils.createServiceInterface(AdGroupFeedServiceInterface.class, AdGroupFeedService.class);
    adGroupFeedService.mutate(operation, adGroupFeedReturnValueHolder, errorHolder);

    // if Error
    if (errorHolder.value != null && errorHolder.value.size() > 0) {
      SoapUtils.displayErrors(new AdGroupFeedServiceErrorEntityFactory(errorHolder.value), true);
    }
    if (adGroupFeedReturnValueHolder.value == null) {
      throw new Exception("NoDataResponse:AdGroupFeedService SET");
    }

    // Display
    for (AdGroupFeedValues adGroupFeedValues : adGroupFeedReturnValueHolder.value.getValues()) {
      if (adGroupFeedValues.isOperationSucceeded()) {
        display(adGroupFeedValues.getAdGroupFeedList());
      } else {
        SoapUtils.displayErrors(new AdGroupFeedServiceErrorEntityFactory(adGroupFeedValues.getError()), true);
      }
    }

    // Response
    return adGroupFeedReturnValueHolder.value.getValues();
  }

  /**
   * Sample Program for AdGroupFeedService GET.
   *
   * @param selector AdGroupFeedSelector
   * @return AdGroupoFeedValues
   */
  public static List<AdGroupFeedValues> get(AdGroupFeedSelector selector) throws Exception {

    // call API
    System.out.println("############################################");
    System.out.println("AdGroupFeedService::get");
    System.out.println("############################################");

    Holder<AdGroupFeedPage> adGroupFeedPageHolder = new Holder<AdGroupFeedPage>();
    Holder<List<Error>> errorHolder = new Holder<List<Error>>();
    AdGroupFeedServiceInterface adGroupFeedService = SoapUtils.createServiceInterface(AdGroupFeedServiceInterface.class, AdGroupFeedService.class);
    adGroupFeedService.get(selector, adGroupFeedPageHolder, errorHolder);

    // Error
    if (errorHolder.value != null && errorHolder.value.size() > 0) {
      SoapUtils.displayErrors(new AdGroupFeedServiceErrorEntityFactory(errorHolder.value), true);
    }
    if (adGroupFeedPageHolder.value == null) {
      throw new Exception("NoDataResponse:CampaignFeedService GET");
    }

    // Display
    for (AdGroupFeedValues values : adGroupFeedPageHolder.value.getValues()) {
      if (values.isOperationSucceeded()) {
        display(values.getAdGroupFeedList());
      } else {
        SoapUtils.displayErrors(new AdGroupFeedServiceErrorEntityFactory(values.getError()), true);
      }
    }

    return adGroupFeedPageHolder.value.getValues();
  }

  /**
   * display AdGroupFeed entity to stdout.
   *
   * @param adGroupFeedList AdGroupFeed entity for display.
   */
  private static void display(AdGroupFeedList adGroupFeedList) {
    System.out.println("accountId = " + adGroupFeedList.getAccountId());
    System.out.println("campaignId = " + adGroupFeedList.getCampaignId());
    System.out.println("adGroupId = " + adGroupFeedList.getAdGroupId());
    System.out.println("placeholderType = " + adGroupFeedList.getPlaceholderType());
    if (adGroupFeedList.getAdGroupFeed() != null) {
      for (AdGroupFeed adGroupFeed : adGroupFeedList.getAdGroupFeed()) {
        System.out.println("adGroupFeed/accountld = " + adGroupFeed.getAccountId());
        System.out.println("adGroupFeed/campaignld = " + adGroupFeed.getCampaignId());
        System.out.println("adGroupFeed/adGroupld = " + adGroupFeed.getAdGroupId());
        System.out.println("adGroupFeed/feedItemld = " + adGroupFeed.getFeedItemId());
        System.out.println("adGroupFeed/placeholderType = " + adGroupFeed.getPlaceholderType());
      }
    }
    System.out.println("---------");
  }

  /**
   * create sample request.
   *
   * @param accountId long
   * @param campaignId long
   * @param adGroupId long
   * @param feedItemId long
   * @return AdGroupFeedOperation
   */
  public static AdGroupFeedOperation createSampleSetRequest(long accountId, long campaignId, long adGroupId, long feedItemId) {
    // Set operation.
    AdGroupFeedOperation operation = new AdGroupFeedOperation();
    operation.setOperator(Operator.SET);
    operation.setAccountId(accountId);

    // Set campaignFeed.
    AdGroupFeedList operand = new AdGroupFeedList();
    operand.setAccountId(accountId);
    operand.setCampaignId(campaignId);
    operand.setAdGroupId(adGroupId);

    operand.setPlaceholderType(AdGroupFeedPlaceholderType.CALLEXTENSION);
    AdGroupFeed setAdGroupFeed = new AdGroupFeed();
    setAdGroupFeed.setFeedItemId(feedItemId);
    operand.getAdGroupFeed().add(setAdGroupFeed);

    operation.getOperand().add(operand);
    return operation;
  }

  /**
   * create sample request.
   *
   * @param accountId long
   * @param campaignId long
   * @param feedItemId long
   * @return AdGroupFeedSelector
   */
  public static AdGroupFeedSelector createSampleGetRequest (long accountId, long campaignId, long feedItemId) {
    AdGroupFeedSelector selector = new AdGroupFeedSelector();
    selector.setAccountId(accountId);
    selector.getCampaignIds().add(campaignId);
    selector.getFeedItemIds().add(feedItemId);
    selector.getPlaceholderTypes().add(AdGroupFeedPlaceholderType.QUICKLINK);
    selector.getPlaceholderTypes().add(AdGroupFeedPlaceholderType.CALLEXTENSION);
    Paging paging = new Paging();
    paging.setStartIndex(1);
    paging.setNumberResults(20);
    selector.setPaging(paging);
    return selector;
  }
}

package jp.co.yahoo.ad_api_sample.adDisplayOptionSample;

import jp.co.yahoo.ad_api_sample.error.impl.CampaignFeedServiceErrorEntityFactory;
import jp.co.yahoo.ad_api_sample.util.SoapUtils;
import jp.yahooapis.ss.v201805.Error;
import jp.yahooapis.ss.v201805.Paging;
import jp.yahooapis.ss.v201805.campaignfeed.CampaignFeed;
import jp.yahooapis.ss.v201805.campaignfeed.CampaignFeedList;
import jp.yahooapis.ss.v201805.campaignfeed.CampaignFeedOperation;
import jp.yahooapis.ss.v201805.campaignfeed.CampaignFeedPage;
import jp.yahooapis.ss.v201805.campaignfeed.CampaignFeedPlaceholderType;
import jp.yahooapis.ss.v201805.campaignfeed.CampaignFeedReturnValue;
import jp.yahooapis.ss.v201805.campaignfeed.CampaignFeedSelector;
import jp.yahooapis.ss.v201805.campaignfeed.CampaignFeedService;
import jp.yahooapis.ss.v201805.campaignfeed.CampaignFeedServiceInterface;
import jp.yahooapis.ss.v201805.campaignfeed.CampaignFeedValues;
import jp.yahooapis.ss.v201805.campaignfeed.DevicePlatform;
import jp.yahooapis.ss.v201805.campaignfeed.Operator;

import java.util.List;

import javax.xml.ws.Holder;

/**
 * Sample Program for CampaignFeedService Copyright (C) 2013 Yahoo Japan Corporation. All Rights Reserved.
 */
public class CampaignFeedServiceSample {

  /**
   * Sample Program for CampaignFeedService SET.
   *
   * @param operation CampaignFeedOperation
   * @return CampaignFeedValues
   */
  public static List<CampaignFeedValues> set(CampaignFeedOperation operation) throws Exception {

    // call API
    System.out.println("############################################");
    System.out.println("CampaignFeedService::mutate(SET)");
    System.out.println("############################################");

    Holder<CampaignFeedReturnValue> campaignFeedReturnValueHolder = new Holder<CampaignFeedReturnValue>();
    Holder<List<Error>> errorHolder = new Holder<List<Error>>();
    CampaignFeedServiceInterface campaignFeedService = SoapUtils.createServiceInterface(CampaignFeedServiceInterface.class, CampaignFeedService.class);
    campaignFeedService.mutate(operation, campaignFeedReturnValueHolder, errorHolder);

    // if Error
    if (errorHolder.value != null && errorHolder.value.size() > 0) {
      SoapUtils.displayErrors(new CampaignFeedServiceErrorEntityFactory(errorHolder.value), true);
    }
    if (campaignFeedReturnValueHolder.value == null) {
      throw new Exception("NoDataResponse:CampaignFeedService SET");
    }

    // Display
    for (CampaignFeedValues campaignFeedValues : campaignFeedReturnValueHolder.value.getValues()) {
      if (campaignFeedValues.isOperationSucceeded()) {
        display(campaignFeedValues.getCampaignFeedList());
      } else {
        SoapUtils.displayErrors(new CampaignFeedServiceErrorEntityFactory(campaignFeedValues.getError()), true);
      }
    }

    // Response
    return campaignFeedReturnValueHolder.value.getValues();
  }

  /**
   * Sample Program for CampaignFeedService GET.
   *
   * @param selector CampaignFeedSelector
   * @return CampaignFeedValues
   */
  public static List<CampaignFeedValues> get(CampaignFeedSelector selector) throws Exception {

    // call API
    System.out.println("############################################");
    System.out.println("CampaignFeedService::get");
    System.out.println("############################################");

    Holder<CampaignFeedPage> campaignFeedPageHolder = new Holder<CampaignFeedPage>();
    Holder<List<Error>> errorHolder = new Holder<List<Error>>();
    CampaignFeedServiceInterface campaignFeedService = SoapUtils.createServiceInterface(CampaignFeedServiceInterface.class, CampaignFeedService.class);
    campaignFeedService.get(selector, campaignFeedPageHolder, errorHolder);

    // Error
    if (errorHolder.value != null && errorHolder.value.size() > 0) {
      SoapUtils.displayErrors(new CampaignFeedServiceErrorEntityFactory(errorHolder.value), true);
    }
    if (campaignFeedPageHolder.value == null) {
      throw new Exception("NoDataResponse:CampaignFeedService GET");
    }

    // Display
    for (CampaignFeedValues values : campaignFeedPageHolder.value.getValues()) {
      if (values.isOperationSucceeded()) {
        display(values.getCampaignFeedList());
      } else {
        SoapUtils.displayErrors(new CampaignFeedServiceErrorEntityFactory(values.getError()), true);
      }
    }

    return campaignFeedPageHolder.value.getValues();
  }

  /**
   * display CampaignFeed entity to stdout.
   *
   * @param campaignFeedList CampaignFeed entity for display.
   */
  private static void display(CampaignFeedList campaignFeedList) {
    System.out.println("accountId = " + campaignFeedList.getAccountId());
    System.out.println("campaignId = " + campaignFeedList.getCampaignId());
    System.out.println("placeholderType = " + campaignFeedList.getPlaceholderType());
    if (campaignFeedList.getCampaignFeed() != null) {
      for (CampaignFeed campaignFeed : campaignFeedList.getCampaignFeed()) {
        System.out.println("campaignFeed/accountld = " + campaignFeed.getAccountId());
        System.out.println("campaignFeed/campaignld = " + campaignFeed.getCampaignId());
        System.out.println("campaignFeed/feedItemld = " + campaignFeed.getFeedItemId());
        System.out.println("campaignFeed/placeholderType = " + campaignFeed.getPlaceholderType());
      }
    }
    System.out.println("---------");
  }

  /**
   * create sample request.
   *
   * @param accountId long
   * @param campaignId long
   * @param feedItemId long
   * @return CampaignFeedOperation
   */
  public static CampaignFeedOperation createSampleSetRequest(long accountId, long campaignId, long feedItemId) {
    // Set operation.
    CampaignFeedOperation operation = new CampaignFeedOperation();
    operation.setOperator(Operator.SET);
    operation.setAccountId(accountId);

    // Set campaignFeed.
    CampaignFeedList operand = new CampaignFeedList();
    operand.setAccountId(accountId);
    operand.setCampaignId(campaignId);
    operand.setPlaceholderType(CampaignFeedPlaceholderType.QUICKLINK);
    CampaignFeed setCampaignFeed = new CampaignFeed();
    setCampaignFeed.setFeedItemId(feedItemId);
    operand.getCampaignFeed().add(setCampaignFeed);
    operand.setDevicePlatform(DevicePlatform.DESKTOP);

    operation.getOperand().add(operand);
    return operation;
  }

  /**
   * create sample request.
   *
   * @param accountId long
   * @param campaignId long
   * @param feedItemId long
   * @return CampaignFeedSelector
   */
  public static CampaignFeedSelector createSampleGetRequest (long accountId, long campaignId, long feedItemId) {
    CampaignFeedSelector selector = new CampaignFeedSelector();
    selector.setAccountId(accountId);
    selector.getCampaignIds().add(campaignId);
    selector.getFeedItemIds().add(feedItemId);
    selector.getPlaceholderTypes().add(CampaignFeedPlaceholderType.QUICKLINK);
    selector.getPlaceholderTypes().add(CampaignFeedPlaceholderType.CALLEXTENSION);
    Paging paging = new Paging();
    paging.setStartIndex(1);
    paging.setNumberResults(20);
    selector.setPaging(paging);
    return selector;
  }
}

/**
 * Copyright (C) 2019 Yahoo Japan Corporation. All Rights Reserved.
 */
package jp.yahooapis.ss.adapisample.basic.adgroupfeed;

import jp.yahooapis.ss.adapisample.basic.feeditem.FeedItemServiceSample;
import jp.yahooapis.ss.adapisample.repository.ValuesRepositoryFacade;
import jp.yahooapis.ss.adapisample.util.SoapUtils;
import jp.yahooapis.ss.adapisample.util.ValuesHolder;
import jp.yahooapis.ss.v201901.Error;
import jp.yahooapis.ss.v201901.Paging;
import jp.yahooapis.ss.v201901.adgroupfeed.AdGroupFeed;
import jp.yahooapis.ss.v201901.adgroupfeed.AdGroupFeedList;
import jp.yahooapis.ss.v201901.adgroupfeed.AdGroupFeedOperation;
import jp.yahooapis.ss.v201901.adgroupfeed.AdGroupFeedPage;
import jp.yahooapis.ss.v201901.adgroupfeed.AdGroupFeedPlaceholderType;
import jp.yahooapis.ss.v201901.adgroupfeed.AdGroupFeedReturnValue;
import jp.yahooapis.ss.v201901.adgroupfeed.AdGroupFeedSelector;
import jp.yahooapis.ss.v201901.adgroupfeed.AdGroupFeedService;
import jp.yahooapis.ss.v201901.adgroupfeed.AdGroupFeedServiceInterface;
import jp.yahooapis.ss.v201901.adgroupfeed.AdGroupFeedValues;
import jp.yahooapis.ss.v201901.adgroupfeed.Operator;
import jp.yahooapis.ss.v201901.campaign.CampaignType;
import jp.yahooapis.ss.v201901.feeditem.FeedItemPlaceholderType;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.xml.ws.Holder;

/**
 * example AdGroupFeedService operation and Utility method collection.
 */
public class AdGroupFeedServiceSample {

  public static void main(String[] args) throws Exception {
    // =================================================================
    // Setting
    // =================================================================
    ValuesHolder valuesHolder = new ValuesHolder();
    long accountId = SoapUtils.getAccountId();

    try {
      // =================================================================
      // check & create upper service object.
      // =================================================================
      valuesHolder = setup();
      ValuesRepositoryFacade valuesRepositoryFacade = new ValuesRepositoryFacade(valuesHolder);
      Long campaignId = valuesRepositoryFacade.getCampaignValuesRepository().findCampaignId(CampaignType.STANDARD);
      Long adGroupId = valuesRepositoryFacade.getAdGroupValuesRepository().findAdGroupId(campaignId);
      Long feedItemId = valuesRepositoryFacade.getFeedItemValuesRepository().findFeedItemId(FeedItemPlaceholderType.QUICKLINK);

      // =================================================================
      // AdGroupFeedServiceSample SET
      // =================================================================
      // create request.
      List<AdGroupFeedList> adGroupFeedLists = new ArrayList<>();
      adGroupFeedLists.add(createExampleSetRequest(accountId, campaignId, adGroupId, feedItemId, AdGroupFeedPlaceholderType.QUICKLINK));
      AdGroupFeedOperation setRequest = buildExampleMutateRequest(Operator.SET, accountId, adGroupFeedLists);

      // run
      mutate(setRequest);

      // =================================================================
      // AdGroupFeedServiceSample GET
      // =================================================================
      // create request.
      AdGroupFeedSelector getRequest = buildExampleGetRequest(accountId, campaignId, adGroupId, feedItemId);

      // run
      get(getRequest);

    } catch (Exception e) {
      e.printStackTrace();
      throw e;
    } finally {
      cleanup(valuesHolder);
    }
  }

  /**
   * example mutate request.
   */
  public static AdGroupFeedOperation buildExampleMutateRequest(Operator operator, long accountId, List<AdGroupFeedList> operand) {
    AdGroupFeedOperation operation = new AdGroupFeedOperation();
    operation.setOperator(operator);
    operation.setAccountId(accountId);
    operation.getOperand().addAll(operand);

    return operation;
  }

  /**
   * example adGroupFeed set request.
   *
   * @param accountId long
   * @param campaignId long
   * @param adGroupId long
   * @param feedItemId long
   * @param adGroupFeedPlaceholderType AdGroupFeedPlaceholderType
   * @return AdGroupFeedList
   */
  public static AdGroupFeedList createExampleSetRequest(long accountId, long campaignId, long adGroupId, long feedItemId, AdGroupFeedPlaceholderType adGroupFeedPlaceholderType) {

    AdGroupFeed adGroupFeed = new AdGroupFeed();
    adGroupFeed.setFeedItemId(feedItemId);

    // Set adGroupFeedList.
    AdGroupFeedList operand = new AdGroupFeedList();
    operand.setAccountId(accountId);
    operand.setCampaignId(campaignId);
    operand.setAdGroupId(adGroupId);
    operand.setPlaceholderType(adGroupFeedPlaceholderType);
    operand.getAdGroupFeed().add(adGroupFeed);

    return operand;
  }

  /**
   * example mutate adGroupFeed.
   *
   * @param operation adGroupFeedOperation
   * @return CampaignFeedValues
   */
  public static List<AdGroupFeedValues> mutate(AdGroupFeedOperation operation) throws Exception {

    // Call API
    System.out.println("############################################");
    System.out.println("AdGroupFeedService::mutate(" + operation.getOperator() + ")");
    System.out.println("############################################");

    Holder<AdGroupFeedReturnValue> adGroupFeedReturnValueHolder = new Holder<AdGroupFeedReturnValue>();
    Holder<List<Error>> errorHolder = new Holder<List<Error>>();
    AdGroupFeedServiceInterface adGroupFeedService = SoapUtils.createServiceInterface(AdGroupFeedServiceInterface.class, AdGroupFeedService.class);
    adGroupFeedService.mutate(operation, adGroupFeedReturnValueHolder, errorHolder);

    SoapUtils.checkSoapError(errorHolder, adGroupFeedReturnValueHolder.value.getValues());

    // Response
    return adGroupFeedReturnValueHolder.value.getValues();
  }

  /**
   * example get request.
   *
   * @param accountId long
   * @param campaignId long
   * @param adGroupId long
   * @param feedItemId long
   * @return AdGroupFeedSelector
   */
  public static AdGroupFeedSelector buildExampleGetRequest(long accountId, long campaignId, long adGroupId, long feedItemId) {

    AdGroupFeedSelector selector = new AdGroupFeedSelector();
    selector.setAccountId(accountId);
    selector.getCampaignIds().add(campaignId);
    selector.getAdGroupIds().add(adGroupId);
    selector.getFeedItemIds().add(feedItemId);
    selector.getPlaceholderTypes().addAll(Arrays.asList( //
        AdGroupFeedPlaceholderType.QUICKLINK, //
        AdGroupFeedPlaceholderType.CALLEXTENSION, //
        AdGroupFeedPlaceholderType.CALLOUT, //
        AdGroupFeedPlaceholderType.STRUCTURED_SNIPPET //
    ));

    Paging paging = new Paging();
    paging.setStartIndex(1);
    paging.setNumberResults(20);
    selector.setPaging(paging);
    return selector;
  }

  /**
   * check & create upper service object.
   *
   * @return ValuesHolder
   * @throws Exception
   */
  public static ValuesHolder setup() throws Exception {
    return FeedItemServiceSample.create();
  }

  /**
   * cleanup service object.
   *
   * @param valuesHolder ValuesHolder
   * @throws Exception
   */
  public static void cleanup(ValuesHolder valuesHolder) throws Exception {
    FeedItemServiceSample.cleanup(valuesHolder);
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

    SoapUtils.checkSoapError(errorHolder, adGroupFeedPageHolder.value.getValues());

    return adGroupFeedPageHolder.value.getValues();
  }

}

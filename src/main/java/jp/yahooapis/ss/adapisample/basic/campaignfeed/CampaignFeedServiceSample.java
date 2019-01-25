/**
 * Copyright (C) 2019 Yahoo Japan Corporation. All Rights Reserved.
 */
package jp.yahooapis.ss.adapisample.basic.campaignfeed;

import jp.yahooapis.ss.adapisample.basic.feeditem.FeedItemServiceSample;
import jp.yahooapis.ss.adapisample.repository.ValuesRepositoryFacade;
import jp.yahooapis.ss.adapisample.util.SoapUtils;
import jp.yahooapis.ss.adapisample.util.ValuesHolder;
import jp.yahooapis.ss.v201901.Error;
import jp.yahooapis.ss.v201901.Paging;
import jp.yahooapis.ss.v201901.campaign.CampaignType;
import jp.yahooapis.ss.v201901.campaignfeed.CampaignFeed;
import jp.yahooapis.ss.v201901.campaignfeed.CampaignFeedList;
import jp.yahooapis.ss.v201901.campaignfeed.CampaignFeedOperation;
import jp.yahooapis.ss.v201901.campaignfeed.CampaignFeedPage;
import jp.yahooapis.ss.v201901.campaignfeed.CampaignFeedPlaceholderType;
import jp.yahooapis.ss.v201901.campaignfeed.CampaignFeedReturnValue;
import jp.yahooapis.ss.v201901.campaignfeed.CampaignFeedSelector;
import jp.yahooapis.ss.v201901.campaignfeed.CampaignFeedService;
import jp.yahooapis.ss.v201901.campaignfeed.CampaignFeedServiceInterface;
import jp.yahooapis.ss.v201901.campaignfeed.CampaignFeedValues;
import jp.yahooapis.ss.v201901.campaignfeed.Operator;
import jp.yahooapis.ss.v201901.feeditem.FeedItemPlaceholderType;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import javax.xml.ws.Holder;

/**
 * example CampaignFeedService operation and Utility method collection.
 */
public class CampaignFeedServiceSample {

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
      Long feedItemId = valuesRepositoryFacade.getFeedItemValuesRepository().findFeedItemId(FeedItemPlaceholderType.QUICKLINK);

      // =================================================================
      // CampaignFeedServiceSample SET
      // =================================================================
      // create request.
      List<CampaignFeedList> campaignFeedLists = new ArrayList<>();
      campaignFeedLists.add(createExampleSetRequest(accountId, campaignId, feedItemId, CampaignFeedPlaceholderType.QUICKLINK));
      CampaignFeedOperation setRequest = buildExampleMutateRequest(Operator.SET, accountId, campaignFeedLists);

      // run
      mutate(setRequest);

      // =================================================================
      // CampaignFeedServiceSample GET
      // =================================================================
      // create request.
      CampaignFeedSelector campaignFeedSelector = buildExampleGetRequest(accountId, Collections.singletonList(campaignId), Collections.singletonList(feedItemId));

      // run
      get(campaignFeedSelector);

    } catch (Exception e) {
      e.printStackTrace();
      throw e;
    } finally {
      cleanup(valuesHolder);
    }
  }

  /**
   * check & create upper service object.
   *
   * @return ValuesHolder
   * @throws Exception
   */
  private static ValuesHolder setup() throws Exception {
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
   * example mutate request.
   */
  public static CampaignFeedOperation buildExampleMutateRequest(Operator operator, long accountId, List<CampaignFeedList> operand) {
    CampaignFeedOperation operation = new CampaignFeedOperation();
    operation.setOperator(operator);
    operation.setAccountId(accountId);
    operation.getOperand().addAll(operand);

    return operation;
  }

  /**
   * example campaignFeed set request.
   *
   * @param accountId long
   * @param campaignId long
   * @param feedItemId long
   * @param campaignFeedPlaceholderType CampaignFeedPlaceholderType
   * @return CampaignFeedList
   */
  public static CampaignFeedList createExampleSetRequest(long accountId, long campaignId, long feedItemId, CampaignFeedPlaceholderType campaignFeedPlaceholderType) {

    CampaignFeed campaignFeed = new CampaignFeed();
    campaignFeed.setFeedItemId(feedItemId);

    // Set campaignFeedList.
    CampaignFeedList operand = new CampaignFeedList();
    operand.setAccountId(accountId);
    operand.setCampaignId(campaignId);
    operand.setPlaceholderType(campaignFeedPlaceholderType);
    operand.getCampaignFeed().add(campaignFeed);

    return operand;
  }

  /**
   * example mutate campaignFeed.
   *
   * @param operation CampaignFeedOperation
   * @return CampaignFeedValues
   */
  public static List<CampaignFeedValues> mutate(CampaignFeedOperation operation) throws Exception {

    // Call API
    System.out.println("############################################");
    System.out.println("CampaignFeedService::mutate(" + operation.getOperator() + ")");
    System.out.println("############################################");

    Holder<CampaignFeedReturnValue> campaignFeedReturnValueHolder = new Holder<CampaignFeedReturnValue>();
    Holder<List<Error>> errorHolder = new Holder<List<Error>>();
    CampaignFeedServiceInterface campaignFeedService = SoapUtils.createServiceInterface(CampaignFeedServiceInterface.class, CampaignFeedService.class);
    campaignFeedService.mutate(operation, campaignFeedReturnValueHolder, errorHolder);

    SoapUtils.checkSoapError(errorHolder, campaignFeedReturnValueHolder.value.getValues());

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

    SoapUtils.checkSoapError(errorHolder, campaignFeedPageHolder.value.getValues());

    return campaignFeedPageHolder.value.getValues();
  }

  /**
   * example get request.
   *
   * @param accountId long
   * @param campaignIds List<Long>
   * @param feedItemIds List<Long>
   * @return CampaignFeedSelector
   */
  public static CampaignFeedSelector buildExampleGetRequest(long accountId, List<Long> campaignIds, List<Long> feedItemIds) {

    CampaignFeedSelector selector = new CampaignFeedSelector();
    selector.setAccountId(accountId);
    selector.getCampaignIds().addAll(campaignIds);
    selector.getFeedItemIds().addAll(feedItemIds);
    selector.getPlaceholderTypes().addAll(Arrays.asList( //
        CampaignFeedPlaceholderType.QUICKLINK, //
        CampaignFeedPlaceholderType.CALLEXTENSION, //
        CampaignFeedPlaceholderType.CALLOUT, //
        CampaignFeedPlaceholderType.STRUCTURED_SNIPPET //
    ));
    Paging paging = new Paging();
    paging.setStartIndex(1);
    paging.setNumberResults(20);
    selector.setPaging(paging);
    return selector;
  }
}

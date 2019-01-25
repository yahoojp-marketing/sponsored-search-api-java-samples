/**
 * Copyright (C) 2019 Yahoo Japan Corporation. All Rights Reserved.
 */
package jp.yahooapis.ss.adapisample.basic.feedfolder;

import jp.yahooapis.ss.adapisample.repository.ValuesRepositoryFacade;
import jp.yahooapis.ss.adapisample.util.SoapUtils;
import jp.yahooapis.ss.adapisample.util.ValuesHolder;
import jp.yahooapis.ss.v201901.Error;
import jp.yahooapis.ss.v201901.Paging;
import jp.yahooapis.ss.v201901.feedfolder.FeedAttribute;
import jp.yahooapis.ss.v201901.feedfolder.FeedFolder;
import jp.yahooapis.ss.v201901.feedfolder.FeedFolderOperation;
import jp.yahooapis.ss.v201901.feedfolder.FeedFolderPage;
import jp.yahooapis.ss.v201901.feedfolder.FeedFolderPlaceholderField;
import jp.yahooapis.ss.v201901.feedfolder.FeedFolderPlaceholderType;
import jp.yahooapis.ss.v201901.feedfolder.FeedFolderReturnValue;
import jp.yahooapis.ss.v201901.feedfolder.FeedFolderSelector;
import jp.yahooapis.ss.v201901.feedfolder.FeedFolderService;
import jp.yahooapis.ss.v201901.feedfolder.FeedFolderServiceInterface;
import jp.yahooapis.ss.v201901.feedfolder.FeedFolderValues;
import jp.yahooapis.ss.v201901.feedfolder.Operator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.xml.ws.Holder;

/**
 * example FeedFolderService operation and Utility method collection.
 */
public class FeedFolderServiceSample {

  /**
   * main method for FeedFolderServiceSample
   *
   * @param args command line arguments
   */
  public static void main(String[] args) throws Exception {
    // =================================================================
    // Setting
    // =================================================================
    ValuesRepositoryFacade valuesRepositoryFacade = new ValuesRepositoryFacade(new ValuesHolder());
    long accountId = SoapUtils.getAccountId();

    try {
      // =================================================================
      // FeedFolderService ADD
      // =================================================================
      // create request.
      FeedFolderOperation addFeedFolderOperation = buildExampleMutateRequest(Operator.ADD, accountId, new ArrayList<FeedFolder>() {{
        add(createExampleAdCustomizerFeedFolder(accountId));
        add(createExampleDynamicAdForSearchFeedFolder(accountId));
      }});

      // run
      List<FeedFolderValues> feedFolderValues = mutate(addFeedFolderOperation);
      valuesRepositoryFacade.getValuesHolder().setFeedFolderValuesList(feedFolderValues);

      // =================================================================
      // FeedFolderService SET
      // =================================================================
      // create request.
      FeedFolderOperation setFeedFolderOperation = buildExampleMutateRequest(Operator.SET, accountId, createExampleSetRequest(valuesRepositoryFacade.getFeedFolderValuesRepository().getFeedFolders()));

      // run
      mutate(setFeedFolderOperation);

      // =================================================================
      // FeedFolderService GET
      // =================================================================
      // create request.
      FeedFolderSelector feedFolderSelector = buildExampleGetRequest(accountId, valuesRepositoryFacade.getFeedFolderValuesRepository().getFeedFolderIds());

      // run
      get(feedFolderSelector);

      // =================================================================
      // FeefFolderService REMOVE
      // =================================================================
      // create request.
      FeedFolderOperation removeFeedFolderOperation = buildExampleMutateRequest(Operator.REMOVE, accountId, valuesRepositoryFacade.getFeedFolderValuesRepository().getFeedFolders());

      // run
      mutate(removeFeedFolderOperation);

    } catch (Exception e) {
      e.printStackTrace();
      throw e;
    }
  }

  public static ValuesHolder create() throws Exception {

    ValuesHolder valuesHolder = new ValuesHolder();
    long accountId = SoapUtils.getAccountId();

    FeedFolderOperation addFeedFolderOperation = buildExampleMutateRequest(Operator.ADD, accountId, new ArrayList<FeedFolder>() {{
      add(createExampleAdCustomizerFeedFolder(accountId));
      add(createExampleDynamicAdForSearchFeedFolder(accountId));
    }});

    // Run
    List<FeedFolderValues> feedFolderValues = mutate(addFeedFolderOperation);
    valuesHolder.setFeedFolderValuesList(feedFolderValues);
    return valuesHolder;
  }

  public static void cleanup(ValuesHolder valuesHolder) throws Exception {

    long accountId = SoapUtils.getAccountId();
    if (valuesHolder.getFeedFolderValuesList().size() == 0) {
      return;
    }
    ValuesRepositoryFacade valuesRepositoryFacade = new ValuesRepositoryFacade(valuesHolder);

    FeedFolderOperation removeFeedFolderOperation =
        buildExampleMutateRequest(Operator.REMOVE, accountId, valuesRepositoryFacade.getFeedFolderValuesRepository().getFeedFolders());

    mutate(removeFeedFolderOperation);
  }

  /**
   * example mutate request.
   */
  public static FeedFolderOperation buildExampleMutateRequest(Operator operator, long accountId, List<FeedFolder> operand) {
    FeedFolderOperation operation = new FeedFolderOperation();
    operation.setOperator(operator);
    operation.setAccountId(accountId);
    operation.getOperand().addAll(operand);

    return operation;
  }

  /**
   * example AdCustomizer request.
   *
   * @param accountId long
   * @return FeedFolder
   */
  public static FeedFolder createExampleAdCustomizerFeedFolder(long accountId) {

    FeedAttribute feedAttributeInteger = new FeedAttribute();
    feedAttributeInteger.setFeedAttributeName("SampleInteger_" + SoapUtils.getCurrentTimestamp());
    feedAttributeInteger.setPlaceholderField(FeedFolderPlaceholderField.AD_CUSTOMIZER_INTEGER);

    FeedAttribute feedAttributePrice = new FeedAttribute();
    feedAttributePrice.setFeedAttributeName("SamplePrice_" + SoapUtils.getCurrentTimestamp());
    feedAttributePrice.setPlaceholderField(FeedFolderPlaceholderField.AD_CUSTOMIZER_PRICE);

    FeedAttribute feedAttributeDate = new FeedAttribute();
    feedAttributeDate.setFeedAttributeName("SampleDate_" + SoapUtils.getCurrentTimestamp());
    feedAttributeDate.setPlaceholderField(FeedFolderPlaceholderField.AD_CUSTOMIZER_DATE);

    FeedAttribute feedAttributeString = new FeedAttribute();
    feedAttributeString.setFeedAttributeName("SampleString_" + SoapUtils.getCurrentTimestamp());
    feedAttributeString.setPlaceholderField(FeedFolderPlaceholderField.AD_CUSTOMIZER_STRING);

    FeedFolder feedFolder = new FeedFolder();
    feedFolder.setAccountId(accountId);
    feedFolder.setFeedFolderName("SampleAdCustomizerFeedFolder_" + SoapUtils.getCurrentTimestamp());
    feedFolder.setPlaceholderType(FeedFolderPlaceholderType.AD_CUSTOMIZER);
    feedFolder.getFeedAttribute().addAll(Arrays.asList(feedAttributeInteger, feedAttributePrice, feedAttributeDate, feedAttributeString));

    return feedFolder;
  }

  /**
   * example DynamicAdForSearch request.
   *
   * @param accountId long
   * @return FeedFolder
   */
  public static FeedFolder createExampleDynamicAdForSearchFeedFolder(long accountId) {

    FeedFolder feedFolder = new FeedFolder();
    feedFolder.setAccountId(accountId);
    feedFolder.setFeedFolderName("SampleDASFeedFolder_" + SoapUtils.getCurrentTimestamp());
    feedFolder.setPlaceholderType(FeedFolderPlaceholderType.DYNAMIC_AD_FOR_SEARCH_PAGE_FEEDS);
    feedFolder.setDomain("https://www.yahoo.co.jp");

    return feedFolder;
  }

  /**
   * Sample Program for BiddingStrategyService MUTATE.
   *
   * @param operation BiddingStrategyOperation
   * @return BiddingStrategyValues
   */
  public static List<FeedFolderValues> mutate(FeedFolderOperation operation) throws Exception {

    // Call API
    System.out.println("############################################");
    System.out.println("FeedFolderService::mutate(" + operation.getOperator() + ")");
    System.out.println("############################################");

    Holder<FeedFolderReturnValue> feedFolderReturnValueHolder = new Holder<FeedFolderReturnValue>();
    Holder<List<Error>> errorHolder = new Holder<List<Error>>();
    FeedFolderServiceInterface feedFolderService = SoapUtils.createServiceInterface(FeedFolderServiceInterface.class, FeedFolderService.class);
    feedFolderService.mutate(operation, feedFolderReturnValueHolder, errorHolder);

    SoapUtils.checkSoapError(errorHolder, feedFolderReturnValueHolder.value.getValues());

    // Response
    return feedFolderReturnValueHolder.value.getValues();
  }

  /**
   * Sample Program for FeedFolderService GET.
   *
   * @param feedFolderSelector FeedFolderSelector
   * @return FeedFolderValues
   */
  public static List<FeedFolderValues> get(FeedFolderSelector feedFolderSelector) throws Exception {

    // Call API
    System.out.println("############################################");
    System.out.println("FeedFolderService::mutate(GET)");
    System.out.println("############################################");

    Holder<FeedFolderPage> feedFolderPage = new Holder<FeedFolderPage>();
    Holder<List<Error>> errorHolder = new Holder<List<Error>>();
    FeedFolderServiceInterface feedFolderService = SoapUtils.createServiceInterface(FeedFolderServiceInterface.class, FeedFolderService.class);
    feedFolderService.get(feedFolderSelector, feedFolderPage, errorHolder);

    SoapUtils.checkSoapError(errorHolder, feedFolderPage.value.getValues());

    // Response
    return feedFolderPage.value.getValues();
  }

  /**
   * example feedHolders set request.
   *
   * @return List<FeedFolder>
   */
  public static List<FeedFolder> createExampleSetRequest(List<FeedFolder> feedFolders) {
    List<FeedFolder> oprands = new ArrayList<>();

    for (FeedFolder feedFolder : feedFolders) {

      // for AdCustomizer
      if (feedFolder.getPlaceholderType() == FeedFolderPlaceholderType.AD_CUSTOMIZER) {

        // Set FeedAttribute
        FeedAttribute feedAttributeInteger = new FeedAttribute();
        feedAttributeInteger.setFeedAttributeName("SampleInteger2_" + SoapUtils.getCurrentTimestamp());
        feedAttributeInteger.setPlaceholderField(FeedFolderPlaceholderField.AD_CUSTOMIZER_INTEGER);

        FeedAttribute feedAttributePrice = new FeedAttribute();
        feedAttributePrice.setFeedAttributeName("SamplePrice2_" + SoapUtils.getCurrentTimestamp());
        feedAttributePrice.setPlaceholderField(FeedFolderPlaceholderField.AD_CUSTOMIZER_PRICE);

        FeedAttribute feedAttributeDate = new FeedAttribute();
        feedAttributeDate.setFeedAttributeName("SampleDate2_" + SoapUtils.getCurrentTimestamp());
        feedAttributeDate.setPlaceholderField(FeedFolderPlaceholderField.AD_CUSTOMIZER_DATE);

        FeedAttribute feedAttributeString = new FeedAttribute();
        feedAttributeString.setFeedAttributeName("SampleString2_" + SoapUtils.getCurrentTimestamp());
        feedAttributeString.setPlaceholderField(FeedFolderPlaceholderField.AD_CUSTOMIZER_STRING);

        // Set Operand
        FeedFolder operand = new FeedFolder();
        operand.setAccountId(feedFolder.getAccountId());
        operand.setFeedFolderId(feedFolder.getFeedFolderId());
        operand.setPlaceholderType(feedFolder.getPlaceholderType());
        operand.getFeedAttribute().addAll(Arrays.asList(feedAttributeInteger, feedAttributePrice, feedAttributeDate, feedAttributeString));

        oprands.add(operand);
      }
    }
    return oprands;
  }

  /**
   * example get request.
   *
   * @param accountId     long
   * @param feedFolderIds List<Long>
   * @return FeedFolderSelector
   */
  public static FeedFolderSelector buildExampleGetRequest(long accountId, List<Long> feedFolderIds) {
    // Set Selector
    FeedFolderSelector selector = new FeedFolderSelector();
    selector.setAccountId(accountId);

    if (feedFolderIds.size() > 0) {
      selector.getFeedFolderIds().addAll(feedFolderIds);
    }

    Paging paging = new Paging();
    paging.setStartIndex(1);
    paging.setNumberResults(20);
    selector.setPaging(paging);

    return selector;
  }

}

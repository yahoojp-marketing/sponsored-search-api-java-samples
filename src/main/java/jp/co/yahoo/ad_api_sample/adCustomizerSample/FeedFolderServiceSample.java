package jp.co.yahoo.ad_api_sample.adCustomizerSample;

import java.util.Arrays;
import java.util.List;

import javax.xml.ws.Holder;

import jp.co.yahoo.ad_api_sample.error.impl.FeedFolderServiceErrorEntityFactory;
import jp.co.yahoo.ad_api_sample.util.SoapUtils;
import jp.yahooapis.ss.V6.FeedFolderService.Error;
import jp.yahooapis.ss.V6.FeedFolderService.FeedAttribute;
import jp.yahooapis.ss.V6.FeedFolderService.FeedFolder;
import jp.yahooapis.ss.V6.FeedFolderService.FeedFolderOperation;
import jp.yahooapis.ss.V6.FeedFolderService.FeedFolderPage;
import jp.yahooapis.ss.V6.FeedFolderService.FeedFolderReturnValue;
import jp.yahooapis.ss.V6.FeedFolderService.FeedFolderSelector;
import jp.yahooapis.ss.V6.FeedFolderService.FeedFolderService;
import jp.yahooapis.ss.V6.FeedFolderService.FeedFolderServiceInterface;
import jp.yahooapis.ss.V6.FeedFolderService.FeedFolderValues;
import jp.yahooapis.ss.V6.FeedFolderService.Operator;
import jp.yahooapis.ss.V6.FeedFolderService.Paging;
import jp.yahooapis.ss.V6.FeedFolderService.PlaceholderField;
import jp.yahooapis.ss.V6.FeedFolderService.PlaceholderType;

/**
 * Sample Program for FeedFolderService. Copyright (C) 2012 Yahoo Japan Corporation. All Rights
 * Reserved.
 */
public class FeedFolderServiceSample {

  /**
   * main method for FeedFolderServiceSample
   *
   * @param args command line arguments
   */
  public static void main(String[] args) throws Exception {
    try {
      // =================================================================
      // Setting
      // =================================================================
      long accountId = SoapUtils.getAccountId();

      // =================================================================
      // FeedFolderService ADD
      // =================================================================
      // Set Operation
      FeedFolderOperation addFeedFolderOperation = createSampleAddRequest(accountId);

      // Run
      List<FeedFolderValues> feedFolderValues = add(addFeedFolderOperation);

      // =================================================================
      // FeedFolderService GET
      // =================================================================
      // Set Selector
      FeedFolderSelector feedFolderSelector = createSampleGetRequest(accountId, feedFolderValues);

      // Run
      get(feedFolderSelector);

      // =================================================================
      // FeefFolderService SET
      // =================================================================
      // Set Operation
      FeedFolderOperation setFeedFolderOperation = createSampleSetRequest(accountId, feedFolderValues);

      // Run
      set(setFeedFolderOperation);

      // =================================================================
      // FeefFolderService REMOVE
      // =================================================================
      // Set Operation
      FeedFolderOperation removeFeedFolderOperation = createSampleRemoveRequest(accountId, feedFolderValues);

      // Run
      remove(removeFeedFolderOperation);

    } catch (Exception e) {
      e.printStackTrace();
      throw e;
    }
  }

  /**
   * Sample Program for FeedFolderService ADD.
   *
   * @param operation FeedFolderOperation
   * @return FeedFolderValues
   * @throws Exception
   */
  public static List<FeedFolderValues> add(FeedFolderOperation operation) throws Exception {

    // Call API
    System.out.println("############################################");
    System.out.println("FeedFolderService::mutate(ADD)");
    System.out.println("############################################");

    Holder<FeedFolderReturnValue> feedFolderReturnValueHolder = new Holder<FeedFolderReturnValue>();
    Holder<List<Error>> errorHolder = new Holder<List<Error>>();
    FeedFolderServiceInterface feedFolderService = SoapUtils.createServiceInterface(FeedFolderServiceInterface.class, FeedFolderService.class);
    feedFolderService.mutate(operation, feedFolderReturnValueHolder, errorHolder);

    // Error
    if (errorHolder.value != null && errorHolder.value.size() > 0) {
      SoapUtils.displayErrors(new FeedFolderServiceErrorEntityFactory(errorHolder.value), true);
    }
    if (feedFolderReturnValueHolder.value == null) {
      throw new Exception("NoDataResponse:FeedFolderService Add");
    }

    // Display
    for (FeedFolderValues feedFolderValues : feedFolderReturnValueHolder.value.getValues()) {
      if (feedFolderValues.isOperationSucceeded()) {
        display(feedFolderValues.getFeedFolder());
      } else {
        SoapUtils.displayErrors(new FeedFolderServiceErrorEntityFactory(feedFolderValues.getError()), true);
      }
    }

    // Response
    return feedFolderReturnValueHolder.value.getValues();
  }

  /**
   * Sample Program for FeedFolderService SET.
   *
   * @param operation FeedFolderOperation
   * @return FeedFolderValues
   * @throws Exception
   */
  public static List<FeedFolderValues> set(FeedFolderOperation operation) throws Exception {

    // Call API
    System.out.println("############################################");
    System.out.println("FeedFolderService::mutate(SET)");
    System.out.println("############################################");

    Holder<FeedFolderReturnValue> feedFolderReturnValueHolder = new Holder<FeedFolderReturnValue>();
    Holder<List<Error>> errorHolder = new Holder<List<Error>>();
    FeedFolderServiceInterface feedFolderService = SoapUtils.createServiceInterface(FeedFolderServiceInterface.class, FeedFolderService.class);
    feedFolderService.mutate(operation, feedFolderReturnValueHolder, errorHolder);

    // Error
    if (errorHolder.value != null && errorHolder.value.size() > 0) {
      SoapUtils.displayErrors(new FeedFolderServiceErrorEntityFactory(errorHolder.value), true);
    }
    if (feedFolderReturnValueHolder.value == null) {
      throw new Exception("NoDataResponse:FeedFolderService Set");
    }

    // Display
    for (FeedFolderValues feedFolderValues : feedFolderReturnValueHolder.value.getValues()) {
      if (feedFolderValues.isOperationSucceeded()) {
        display(feedFolderValues.getFeedFolder());
      } else {
        SoapUtils.displayErrors(new FeedFolderServiceErrorEntityFactory(feedFolderValues.getError()), true);
      }
    }

    // Response
    return feedFolderReturnValueHolder.value.getValues();
  }

  /**
   * Sample Program for FeedFolderService REMOVE.
   *
   * @param operation FeedFolderOperation
   * @return FeedFolderValues
   * @throws Exception
   */
  public static List<FeedFolderValues> remove(FeedFolderOperation operation) throws Exception {

    // Call API
    System.out.println("############################################");
    System.out.println("FeedFolderService::mutate(REMOVE)");
    System.out.println("############################################");

    Holder<FeedFolderReturnValue> feedFolderReturnValueHolder = new Holder<FeedFolderReturnValue>();
    Holder<List<Error>> errorHolder = new Holder<List<Error>>();
    FeedFolderServiceInterface feedFolderService = SoapUtils.createServiceInterface(FeedFolderServiceInterface.class, FeedFolderService.class);
    feedFolderService.mutate(operation, feedFolderReturnValueHolder, errorHolder);

    // Error
    if (errorHolder.value != null && errorHolder.value.size() > 0) {
      SoapUtils.displayErrors(new FeedFolderServiceErrorEntityFactory(errorHolder.value), true);
    }
    if (feedFolderReturnValueHolder.value == null) {
      throw new Exception("NoDataResponse:FeedFolderService Remove");
    }

    // Display
    for (FeedFolderValues feedFolderValues : feedFolderReturnValueHolder.value.getValues()) {
      if (feedFolderValues.isOperationSucceeded()) {
        display(feedFolderValues.getFeedFolder());
      } else {
        SoapUtils.displayErrors(new FeedFolderServiceErrorEntityFactory(feedFolderValues.getError()), true);
      }
    }

    return feedFolderReturnValueHolder.value.getValues();
  }

  /**
   * Sample Program for FeedFolderService GET.
   *
   * @param feedFolderSelector FeedFolderSelector
   * @return FeedFolderValues
   * @throws Exception
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

    // Error
    if (errorHolder.value != null && errorHolder.value.size() > 0) {
      SoapUtils.displayErrors(new FeedFolderServiceErrorEntityFactory(errorHolder.value), true);
    }
    if (feedFolderPage.value == null) {
      throw new Exception("NoDataResponse:FeedFolderService Get");
    }

    // Display
    for (FeedFolderValues feedFolderValues : feedFolderPage.value.getValues()) {
      if (feedFolderValues.isOperationSucceeded()) {
        display(feedFolderValues.getFeedFolder());
      } else {
        SoapUtils.displayErrors(new FeedFolderServiceErrorEntityFactory(feedFolderValues.getError()), true);
      }
    }

    // Response
    return feedFolderPage.value.getValues();
  }

  /**
   * display FeedFolder entity to stdout.
   *
   * @param feedFolder FeedFolder entity for display.
   */
  public static void display(FeedFolder feedFolder) {

    System.out.println("accountId = " + feedFolder.getAccountId());
    System.out.println("feedFolderId = " + feedFolder.getFeedFolderId());
    System.out.println("feedFolderName = " + feedFolder.getFeedFolderName());

    long feedAttributeIndex = 0;
    for (FeedAttribute feedAttribute : feedFolder.getFeedAttribute()) {
      System.out.println("feedAttribute[" + feedAttributeIndex + "]/feedAttributeId = " + feedAttribute.getFeedAttributeId());
      System.out.println("feedAttribute[" + feedAttributeIndex + "]/feedAttributeName = " + feedAttribute.getFeedAttributeName());
      System.out.println("feedAttribute[" + feedAttributeIndex + "]/placeholderField = " + feedAttribute.getPlaceholderField());
      feedAttributeIndex++;
    }

    System.out.println("placeholderType = " + feedFolder.getPlaceholderType());
    System.out.println("---------");
  }

  /**
   * create sample request.
   *
   * @param accountId Account ID
   * @return FeedFolderOperation
   */
  public static FeedFolderOperation createSampleAddRequest(long accountId) {
    // Set Operation
    FeedFolderOperation operation = new FeedFolderOperation();
    operation.setOperator(Operator.ADD);
    operation.setAccountId(accountId);

    // Set FeedAttribute
    FeedAttribute integerTypeFeedAttribute = new FeedAttribute();
    integerTypeFeedAttribute.setFeedAttributeName("SampleInteger_" + SoapUtils.getCurrentTimestamp());
    integerTypeFeedAttribute.setPlaceholderField(PlaceholderField.AD_CUSTOMIZER_INTEGER);
    FeedAttribute priceTypeFeedAttribute = new FeedAttribute();
    priceTypeFeedAttribute.setFeedAttributeName("SamplePrice_" + SoapUtils.getCurrentTimestamp());
    priceTypeFeedAttribute.setPlaceholderField(PlaceholderField.AD_CUSTOMIZER_PRICE);
    FeedAttribute dateTypeFeedAttribute = new FeedAttribute();
    dateTypeFeedAttribute.setFeedAttributeName("SampleDate_" + SoapUtils.getCurrentTimestamp());
    dateTypeFeedAttribute.setPlaceholderField(PlaceholderField.AD_CUSTOMIZER_DATE);
    FeedAttribute stringTypeFeedAttribute = new FeedAttribute();
    stringTypeFeedAttribute.setFeedAttributeName("SampleString_" + SoapUtils.getCurrentTimestamp());
    stringTypeFeedAttribute.setPlaceholderField(PlaceholderField.AD_CUSTOMIZER_STRING);

    // Set Operand
    FeedFolder feedFolder = new FeedFolder();
    feedFolder.setAccountId(accountId);
    feedFolder.setFeedFolderName("SampleFeedFolder_" + SoapUtils.getCurrentTimestamp());
    feedFolder.setPlaceholderType(PlaceholderType.AD_CUSTOMIZER);
    feedFolder.getFeedAttribute().addAll(Arrays.asList(integerTypeFeedAttribute, priceTypeFeedAttribute, dateTypeFeedAttribute, stringTypeFeedAttribute));

    operation.getOperand().add(feedFolder);

    return operation;
  }

  /**
   * create sample request.
   *
   * @param accountId Account ID
   * @param feedFolderValues FeedFolderValues entity for set.
   * @return FeedFolderOperation
   */
  public static FeedFolderOperation createSampleSetRequest(long accountId, List<FeedFolderValues> feedFolderValues) {
    // Set Operation
    FeedFolderOperation operation = new FeedFolderOperation();
    operation.setOperator(Operator.SET);
    operation.setAccountId(accountId);

    // Set Operand
    for (FeedFolderValues feedFolderValue : feedFolderValues) {

      FeedFolder feedFolder = new FeedFolder();
      feedFolder.setAccountId(feedFolderValue.getFeedFolder().getAccountId());
      feedFolder.setFeedFolderId(feedFolderValue.getFeedFolder().getFeedFolderId());
      feedFolder.setPlaceholderType(feedFolderValue.getFeedFolder().getPlaceholderType());

      // Set FeedAttribute
      FeedAttribute integerTypeFeedAttribute = new FeedAttribute();
      integerTypeFeedAttribute.setFeedAttributeName("SampleInteger2_" + SoapUtils.getCurrentTimestamp());
      integerTypeFeedAttribute.setPlaceholderField(PlaceholderField.AD_CUSTOMIZER_INTEGER);
      FeedAttribute priceTypeFeedAttribute = new FeedAttribute();
      priceTypeFeedAttribute.setFeedAttributeName("SamplePrice2_" + SoapUtils.getCurrentTimestamp());
      priceTypeFeedAttribute.setPlaceholderField(PlaceholderField.AD_CUSTOMIZER_PRICE);
      FeedAttribute dateTypeFeedAttribute = new FeedAttribute();
      dateTypeFeedAttribute.setFeedAttributeName("SampleDate2_" + SoapUtils.getCurrentTimestamp());
      dateTypeFeedAttribute.setPlaceholderField(PlaceholderField.AD_CUSTOMIZER_DATE);
      FeedAttribute stringTypeFeedAttribute = new FeedAttribute();
      stringTypeFeedAttribute.setFeedAttributeName("SampleString2_" + SoapUtils.getCurrentTimestamp());
      stringTypeFeedAttribute.setPlaceholderField(PlaceholderField.AD_CUSTOMIZER_STRING);

      feedFolder.getFeedAttribute().addAll(Arrays.asList(integerTypeFeedAttribute, priceTypeFeedAttribute, dateTypeFeedAttribute, stringTypeFeedAttribute));
      operation.getOperand().add(feedFolder);
    }

    return operation;
  }

  /**
   * create sample request.
   *
   * @param accountId Account ID
   * @param feedFolderValues FeedFolderValues entity for remove.
   * @return FeedFolderOperation
   */
  public static FeedFolderOperation createSampleRemoveRequest(long accountId, List<FeedFolderValues> feedFolderValues) {
    // Set Operation
    FeedFolderOperation operation = new FeedFolderOperation();
    operation.setOperator(Operator.REMOVE);
    operation.setAccountId(accountId);

    // Set Operand
    for (FeedFolderValues feedFolderValue : feedFolderValues) {

      FeedFolder feedFolder = new FeedFolder();
      feedFolder.setAccountId(feedFolderValue.getFeedFolder().getAccountId());
      feedFolder.setFeedFolderId(feedFolderValue.getFeedFolder().getFeedFolderId());
      feedFolder.setPlaceholderType(feedFolderValue.getFeedFolder().getPlaceholderType());

      operation.getOperand().add(feedFolder);
    }
    return operation;
  }

  /**
   * create sample request.
   *
   * @param accountId Account ID
   * @param feedFolderValues FeedFolderValues entity for get.
   * @return FeedFolderSelector
   */
  public static FeedFolderSelector createSampleGetRequest(long accountId, List<FeedFolderValues> feedFolderValues) {
    // Set Selector
    FeedFolderSelector selector = new FeedFolderSelector();
    selector.setAccountId(accountId);
    for (FeedFolderValues feedFolderValue : feedFolderValues) {
      selector.getFeedFolderIds().add(feedFolderValue.getFeedFolder().getFeedFolderId());
    }
    Paging paging = new Paging();
    paging.setStartIndex(1);
    paging.setNumberResults(20);
    selector.setPaging(paging);

    return selector;
  }
}

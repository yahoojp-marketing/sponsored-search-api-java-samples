package jp.co.yahoo.ad_api_sample.adCustomizerSample;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.ws.Holder;

import jp.co.yahoo.ad_api_sample.error.impl.FeedItemServiceErrorEntityFactory;
import jp.co.yahoo.ad_api_sample.util.SoapUtils;
import jp.yahooapis.ss.V5.FeedItemService.ApprovalStatus;
import jp.yahooapis.ss.V5.FeedItemService.DayOfWeek;
import jp.yahooapis.ss.V5.FeedItemService.DevicePreference;
import jp.yahooapis.ss.V5.FeedItemService.Error;
import jp.yahooapis.ss.V5.FeedItemService.FeedItem;
import jp.yahooapis.ss.V5.FeedItemService.FeedItemAttribute;
import jp.yahooapis.ss.V5.FeedItemService.FeedItemOperation;
import jp.yahooapis.ss.V5.FeedItemService.FeedItemPage;
import jp.yahooapis.ss.V5.FeedItemService.FeedItemReturnValue;
import jp.yahooapis.ss.V5.FeedItemService.FeedItemSchedule;
import jp.yahooapis.ss.V5.FeedItemService.FeedItemScheduling;
import jp.yahooapis.ss.V5.FeedItemService.FeedItemSelector;
import jp.yahooapis.ss.V5.FeedItemService.FeedItemService;
import jp.yahooapis.ss.V5.FeedItemService.FeedItemServiceInterface;
import jp.yahooapis.ss.V5.FeedItemService.FeedItemValues;
import jp.yahooapis.ss.V5.FeedItemService.KeywordMatchType;
import jp.yahooapis.ss.V5.FeedItemService.MinuteOfHour;
import jp.yahooapis.ss.V5.FeedItemService.Operator;
import jp.yahooapis.ss.V5.FeedItemService.Paging;
import jp.yahooapis.ss.V5.FeedItemService.PlaceholderType;
import jp.yahooapis.ss.V5.FeedItemService.TargetingAdGroup;
import jp.yahooapis.ss.V5.FeedItemService.TargetingCampaign;
import jp.yahooapis.ss.V5.FeedItemService.TargetingKeyword;


/**
 * Sample Program for FeedItemService. Copyright (C) 2012 Yahoo Japan Corporation. All Rights
 * Reserved.
 */
public class FeedItemServiceSample {

  /**
   * main method for FeedItemServiceSample
   *
   * @param args command line arguments
   */
  public static void main(String[] args) throws Exception {
    try {
      // =================================================================
      // Setting
      // =================================================================
      long accountId = SoapUtils.getAccountId();
      long campaignId = SoapUtils.getCampaignId();
      long adGroupId = SoapUtils.getAdGroupId();
      long feedFolderId = SoapUtils.getFeedFolderId();
      Map<String, Long> feedAttributeIds = new HashMap<String, Long>();
      feedAttributeIds.put("AD_CUSTOMIZER_INTEGER", SoapUtils.getIntegerFeedAttributeId());
      feedAttributeIds.put("AD_CUSTOMIZER_PRICE", SoapUtils.getPriceFeedAttributeId());
      feedAttributeIds.put("AD_CUSTOMIZER_DATE", SoapUtils.getDateFeedAttributeId());
      feedAttributeIds.put("AD_CUSTOMIZER_STRING", SoapUtils.getStringFeedAttributeId());

      // =================================================================
      // FeedItemService ADD
      // =================================================================
      // Set Operation
      FeedItemOperation addFeedItemOperation = createSampleAddRequest(accountId, campaignId, adGroupId, feedFolderId, feedAttributeIds);

      // Run
      List<FeedItemValues> feedItemValues = add(addFeedItemOperation);

      // =================================================================
      // FeedItemService GET
      // =================================================================
      // Set Selector
      FeedItemSelector feedItemSelector = createSampleGetRequest(accountId, feedItemValues);

      // Run
      get(feedItemSelector);

      // wait for sandbox review
      Thread.sleep(20000);

      // =================================================================
      // FeefItemService SET
      // =================================================================
      // Set Operation
      FeedItemOperation setFeedItemOperation = createSampleSetRequest(accountId, feedItemValues);

      // Run
      set(setFeedItemOperation);

      // =================================================================
      // FeefItemService REMOVE
      // =================================================================
      // Set Operation
      FeedItemOperation removeFeedItemOperation = createSampleRemoveRequest(accountId, feedItemValues);

      // Run
      remove(removeFeedItemOperation);

    } catch (Exception e) {
      e.printStackTrace();
      throw e;
    }
  }

  /**
   * Sample Program for FeedItemService ADD.
   * 
   * @param operation FeedItemOperation
   * @return FeedItemValues
   * @throws Exception
   */
  public static List<FeedItemValues> add(FeedItemOperation operation) throws Exception {

    // Call API
    System.out.println("############################################");
    System.out.println("FeedItemService::mutate(ADD)");
    System.out.println("############################################");

    Holder<FeedItemReturnValue> feedItemReturnValueHolder = new Holder<FeedItemReturnValue>();
    Holder<List<Error>> errorHolder = new Holder<List<Error>>();
    FeedItemServiceInterface feedItemService = SoapUtils.createServiceInterface(FeedItemServiceInterface.class, FeedItemService.class);
    feedItemService.mutate(operation, feedItemReturnValueHolder, errorHolder);

    // Error
    if (errorHolder.value != null && errorHolder.value.size() > 0) {
      SoapUtils.displayErrors(new FeedItemServiceErrorEntityFactory(errorHolder.value), true);
    }
    if (feedItemReturnValueHolder.value == null) {
      throw new Exception("NoDataResponse:FeedItemService Add");
    }

    // Display
    for (FeedItemValues feedItemValues : feedItemReturnValueHolder.value.getValues()) {
      if (feedItemValues.isOperationSucceeded()) {
        display(feedItemValues.getFeedItem());
      } else {
        SoapUtils.displayErrors(new FeedItemServiceErrorEntityFactory(feedItemValues.getError()), true);
      }
    }

    // Response
    return feedItemReturnValueHolder.value.getValues();
  }

  /**
   * Sample Program for FeedItemService SET.
   *
   * @param operation FeedItemOperation
   * @return FeedFolderValues
   * @throws Exception
   */
  public static List<FeedItemValues> set(FeedItemOperation operation) throws Exception {

    // Call API
    System.out.println("############################################");
    System.out.println("FeedItemService::mutate(SET)");
    System.out.println("############################################");

    Holder<FeedItemReturnValue> feedItemReturnValueHolder = new Holder<FeedItemReturnValue>();
    Holder<List<Error>> errorHolder = new Holder<List<Error>>();
    FeedItemServiceInterface feedItemService = SoapUtils.createServiceInterface(FeedItemServiceInterface.class, FeedItemService.class);
    feedItemService.mutate(operation, feedItemReturnValueHolder, errorHolder);

    // Error
    if (errorHolder.value != null && errorHolder.value.size() > 0) {
      SoapUtils.displayErrors(new FeedItemServiceErrorEntityFactory(errorHolder.value), true);
    }
    if (feedItemReturnValueHolder.value == null) {
      throw new Exception("NoDataResponse:FeedItemService Set");
    }

    // Display
    for (FeedItemValues feedItemValues : feedItemReturnValueHolder.value.getValues()) {
      if (feedItemValues.isOperationSucceeded()) {
        display(feedItemValues.getFeedItem());
      } else {
        SoapUtils.displayErrors(new FeedItemServiceErrorEntityFactory(feedItemValues.getError()), true);
      }
    }

    // Response
    return feedItemReturnValueHolder.value.getValues();
  }

  /**
   * Sample Program for FeedItemService REMOVE.
   *
   * @param operation FeedItemOperation
   * @return FeedFolderValues
   * @throws Exception
   */
  public static List<FeedItemValues> remove(FeedItemOperation operation) throws Exception {

    // Call API
    System.out.println("############################################");
    System.out.println("FeedItemService::mutate(REMOVE)");
    System.out.println("############################################");

    Holder<FeedItemReturnValue> feedItemReturnValueHolder = new Holder<FeedItemReturnValue>();
    Holder<List<Error>> errorHolder = new Holder<List<Error>>();
    FeedItemServiceInterface feedItemService = SoapUtils.createServiceInterface(FeedItemServiceInterface.class, FeedItemService.class);
    feedItemService.mutate(operation, feedItemReturnValueHolder, errorHolder);

    // Error
    if (errorHolder.value != null && errorHolder.value.size() > 0) {
      SoapUtils.displayErrors(new FeedItemServiceErrorEntityFactory(errorHolder.value), true);
    }
    if (feedItemReturnValueHolder.value == null) {
      throw new Exception("NoDataResponse:FeedItemService Remove");
    }

    // Display
    for (FeedItemValues feedItemValues : feedItemReturnValueHolder.value.getValues()) {
      if (feedItemValues.isOperationSucceeded()) {
        display(feedItemValues.getFeedItem());
      } else {
        SoapUtils.displayErrors(new FeedItemServiceErrorEntityFactory(feedItemValues.getError()), true);
      }
    }

    // Response
    return feedItemReturnValueHolder.value.getValues();
  }

  /**
   * Sample Program for FeedItemService GET.
   *
   * @param selector FeedItemSelector
   * @return FeedItemValues
   * @throws Exception
   */
  public static List<FeedItemValues> get(FeedItemSelector selector) throws Exception {

    // Call API
    System.out.println("############################################");
    System.out.println("FeedItemService::get");
    System.out.println("############################################");

    Holder<FeedItemPage> feedItemPage = new Holder<FeedItemPage>();
    Holder<List<Error>> errorHolder = new Holder<List<Error>>();
    FeedItemServiceInterface feedItemService = SoapUtils.createServiceInterface(FeedItemServiceInterface.class, FeedItemService.class);
    feedItemService.get(selector, feedItemPage, errorHolder);

    // Error
    if (errorHolder.value != null && errorHolder.value.size() > 0) {
      SoapUtils.displayErrors(new FeedItemServiceErrorEntityFactory(errorHolder.value), true);
    }
    if (feedItemPage.value == null) {
      throw new Exception("NoDataResponse:FeedItemService Get");
    }

    // Display
    for (FeedItemValues feedItemValues : feedItemPage.value.getValues()) {
      if (feedItemValues.isOperationSucceeded()) {
        display(feedItemValues.getFeedItem());
      } else {
        SoapUtils.displayErrors(new FeedItemServiceErrorEntityFactory(feedItemValues.getError()), true);
      }
    }

    // Response
    return feedItemPage.value.getValues();
  }

  /**
   * display FeedItem entity to stdout.
   * 
   * @param feedItem FeedItem entity for display.
   */
  private static void display(FeedItem feedItem) throws Exception {
    try {
      System.out.println("accountId = " + feedItem.getAccountId());
      System.out.println("feedFolderId = " + feedItem.getFeedFolderId());
      System.out.println("feedItemId = " + feedItem.getFeedItemId());
      System.out.println("approvalStatus = " + feedItem.getApprovalStatus());

      long feedAttributeIndex = 0;
      for (FeedItemAttribute feedAttribute : feedItem.getFeedItemAttribute()) {
        System.out.println("feedAttribute[" + feedAttributeIndex + "]/placeholderField = " + feedAttribute.getPlaceholderField());
        System.out.println("feedAttribute[" + feedAttributeIndex + "]/feedAttributeId = " + feedAttribute.getFeedAttributeId());
        System.out.println("feedAttribute[" + feedAttributeIndex + "]/feedAttributeValue = " + feedAttribute.getFeedAttributeValue());
        feedAttributeIndex++;
      }

      System.out.println("placeholderType = " + feedItem.getPlaceholderType());
      System.out.println("devicePreference = " + feedItem.getDevicePreference());
      System.out.println("startDate = " + feedItem.getStartDate());
      System.out.println("endDate = " + feedItem.getEndDate());

      if (feedItem.getScheduling() != null) {
        long scheduleIndex = 0;
        for (FeedItemSchedule schedules : feedItem.getScheduling().getSchedules()) {
          System.out.println("scheduling/schedules[" + scheduleIndex + "]/dayOfWeek = " + schedules.getDayOfWeek());
          System.out.println("scheduling/schedules[" + scheduleIndex + "]/startHour = " + schedules.getStartHour());
          System.out.println("scheduling/schedules[" + scheduleIndex + "]/startMinute = " + schedules.getStartMinute());
          System.out.println("scheduling/schedules[" + scheduleIndex + "]/endHour = " + schedules.getEndHour());
          System.out.println("scheduling/schedules[" + scheduleIndex + "]/endMinute = " + schedules.getEndMinute());
          scheduleIndex++;
        }
      }

      if (feedItem.getTargetingCampaign() != null) {
        System.out.println("targetingCampaign/targetingCampaignId = " + feedItem.getTargetingCampaign().getTargetingCampaignId());
      }

      if (feedItem.getTargetingAdGroup() != null) {
        System.out.println("targetingAdGroup/targetingAdGroupId = " + feedItem.getTargetingAdGroup().getTargetingAdGroupId());
      }
      if (feedItem.getTargetingKeyword() != null) {
        System.out.println("targetingKeyword/targetingKeywordId = " + feedItem.getTargetingKeyword().getTargetingKeywordId());
        System.out.println("targetingKeyword/text = " + feedItem.getTargetingKeyword().getText());
        System.out.println("targetingKeyword/matchType = " + feedItem.getTargetingKeyword().getMatchType());
      }
      System.out.println("---------");
    } catch (Exception e) {
      e.printStackTrace();
      throw e;
    }
  }

  /**
   * create sample request.
   * 
   * @param accountId Account ID
   * @param campaignId Campaign ID
   * @param adGroupId AdGroup ID
   * @param feedFolderId FeedFolder ID
   * @param feedAttributeIds FeedAttribute IDs
   * @return FeedItemOperation
   */
  public static FeedItemOperation createSampleAddRequest(long accountId, long campaignId, long adGroupId, long feedFolderId, Map<String, Long> feedAttributeIds) {
    // Set Operation
    FeedItemOperation operation = new FeedItemOperation();
    operation.setOperator(Operator.ADD);
    operation.setAccountId(accountId);
    operation.setPlaceholderType(PlaceholderType.AD_CUSTOMIZER);

    // Set FeedItemAttribute
    FeedItemAttribute integerTypeFeedItemAttribute = new FeedItemAttribute();
    integerTypeFeedItemAttribute.setFeedAttributeId(feedAttributeIds.get("AD_CUSTOMIZER_INTEGER"));
    integerTypeFeedItemAttribute.setFeedAttributeValue("1234567890");
    FeedItemAttribute priceTypeFeedItemAttribute = new FeedItemAttribute();
    priceTypeFeedItemAttribute.setFeedAttributeId(feedAttributeIds.get("AD_CUSTOMIZER_PRICE"));
    priceTypeFeedItemAttribute.setFeedAttributeValue("9,999,999.99");
    FeedItemAttribute dateTypeFeedItemAttribute = new FeedItemAttribute();
    dateTypeFeedItemAttribute.setFeedAttributeId(feedAttributeIds.get("AD_CUSTOMIZER_DATE"));
    dateTypeFeedItemAttribute.setFeedAttributeValue("20151231 235959");
    FeedItemAttribute stringTypeFeedItemAttribute = new FeedItemAttribute();
    stringTypeFeedItemAttribute.setFeedAttributeId(feedAttributeIds.get("AD_CUSTOMIZER_STRING"));
    stringTypeFeedItemAttribute.setFeedAttributeValue("sample Value");

    // Set Operand
    FeedItem feedItem = new FeedItem();
    feedItem.setAccountId(accountId);
    feedItem.setFeedFolderId(feedFolderId);
    feedItem.getFeedItemAttribute().addAll(Arrays.asList(integerTypeFeedItemAttribute, priceTypeFeedItemAttribute, dateTypeFeedItemAttribute, stringTypeFeedItemAttribute));
    feedItem.setPlaceholderType(PlaceholderType.AD_CUSTOMIZER);
    feedItem.setDevicePreference(DevicePreference.SMART_PHONE);
    feedItem.setStartDate("20151215");
    feedItem.setEndDate("20161215");

    // Set Schedule
    FeedItemSchedule feedItemSchedule1 = new FeedItemSchedule();
    feedItemSchedule1.setDayOfWeek(DayOfWeek.SUNDAY);
    feedItemSchedule1.setStartHour(14L);
    feedItemSchedule1.setStartMinute(MinuteOfHour.ZERO);
    feedItemSchedule1.setEndHour(15L);
    feedItemSchedule1.setEndMinute(MinuteOfHour.THIRTY);
    FeedItemSchedule feedItemSchedule2 = new FeedItemSchedule();
    feedItemSchedule2.setDayOfWeek(DayOfWeek.MONDAY);
    feedItemSchedule2.setStartHour(14L);
    feedItemSchedule2.setStartMinute(MinuteOfHour.ZERO);
    feedItemSchedule2.setEndHour(15L);
    feedItemSchedule2.setEndMinute(MinuteOfHour.THIRTY);
    FeedItemScheduling scheduling = new FeedItemScheduling();
    scheduling.getSchedules().addAll(Arrays.asList(feedItemSchedule1, feedItemSchedule2));
    feedItem.setScheduling(scheduling);

    // Set Targeting Campaign,AdGroup,Keyword
    TargetingCampaign targetingCampaign = new TargetingCampaign();
    targetingCampaign.setTargetingCampaignId(campaignId);
    feedItem.setTargetingCampaign(targetingCampaign);
    TargetingAdGroup targetingAdGroup = new TargetingAdGroup();
    targetingAdGroup.setTargetingAdGroupId(adGroupId);
    feedItem.setTargetingAdGroup(targetingAdGroup);
    TargetingKeyword targetingKeyword = new TargetingKeyword();
    targetingKeyword.setText("sample keyword");
    targetingKeyword.setMatchType(KeywordMatchType.PHRASE);
    feedItem.setTargetingKeyword(targetingKeyword);

    operation.getOperand().add(feedItem);

    return operation;
  }

  /**
   * create sample request.
   * 
   * @param accountId Account ID
   * @param feedItemValues FeedItemValues entity for set.
   * @return FeedItemOperation
   */
  public static FeedItemOperation createSampleSetRequest(long accountId, List<FeedItemValues> feedItemValues) {
    // Set Operation
    FeedItemOperation operation = new FeedItemOperation();
    operation.setOperator(Operator.SET);
    operation.setAccountId(accountId);
    operation.setPlaceholderType(PlaceholderType.AD_CUSTOMIZER);

    // Set Operand
    for (FeedItemValues feedItemValue : feedItemValues) {

      FeedItem feedItem = new FeedItem();
      feedItem.setAccountId(feedItemValue.getFeedItem().getAccountId());
      feedItem.setFeedItemId(feedItemValue.getFeedItem().getFeedItemId());

      // Set FeedItemAttribute
      for (FeedItemAttribute feedItemAttribute : feedItemValue.getFeedItem().getFeedItemAttribute()) {
        FeedItemAttribute updateFeedItemAttribute = new FeedItemAttribute();
        updateFeedItemAttribute.setFeedAttributeId(feedItemAttribute.getFeedAttributeId());
        switch (feedItemAttribute.getPlaceholderField()) {
          case AD_CUSTOMIZER_INTEGER:
            updateFeedItemAttribute.setFeedAttributeValue("2345678901");
            break;
          case AD_CUSTOMIZER_PRICE:
            updateFeedItemAttribute.setFeedAttributeValue("1,111,111.11");
            break;
          case AD_CUSTOMIZER_DATE:
            updateFeedItemAttribute.setFeedAttributeValue("20160101 235959");
            break;
          case AD_CUSTOMIZER_STRING:
            updateFeedItemAttribute.setFeedAttributeValue("sample edit value");
            break;
          default:
            break;
        }
        feedItem.getFeedItemAttribute().add(updateFeedItemAttribute);
      }

      feedItem.setPlaceholderType(feedItemValue.getFeedItem().getPlaceholderType());
      feedItem.setStartDate(new String());
      feedItem.setEndDate(new String());
      feedItem.setScheduling(new FeedItemScheduling());
      TargetingAdGroup targetingAdGroup = new TargetingAdGroup();
      targetingAdGroup.setTargetingAdGroupId(0L);
      feedItem.setTargetingAdGroup(targetingAdGroup);
      TargetingKeyword targetingKeyword = new TargetingKeyword();
      targetingKeyword.setTargetingKeywordId(0L);
      feedItem.setTargetingKeyword(targetingKeyword);

      operation.getOperand().add(feedItem);
    }

    return operation;
  }

  /**
   * create sample request.
   * 
   * @param accountId Account ID
   * @param feedItemValues FeedItemValues entity for remove.
   * @return FeedItemOperation
   */
  public static FeedItemOperation createSampleRemoveRequest(long accountId, List<FeedItemValues> feedItemValues) {
    // Set Operation
    FeedItemOperation operation = new FeedItemOperation();
    operation.setOperator(Operator.REMOVE);
    operation.setAccountId(accountId);
    operation.setPlaceholderType(PlaceholderType.AD_CUSTOMIZER);

    // Set Operand
    for (FeedItemValues feedItemValue : feedItemValues) {

      FeedItem feedItem = new FeedItem();
      feedItem.setAccountId(feedItemValue.getFeedItem().getAccountId());
      feedItem.setFeedItemId(feedItemValue.getFeedItem().getFeedItemId());
      feedItem.setPlaceholderType(feedItemValue.getFeedItem().getPlaceholderType());

      operation.getOperand().add(feedItem);
    }

    return operation;
  }

  /**
   * create sample request.
   * 
   * @param accountId Account ID
   * @param feedItemValues FeedItemValues entity for get.
   * @return FeedItemSelector
   */
  public static FeedItemSelector createSampleGetRequest(long accountId, List<FeedItemValues> feedItemValues) {
    // Set Selector
    FeedItemSelector selector = new FeedItemSelector();
    selector.setAccountId(accountId);
    for (FeedItemValues feedItemValue : feedItemValues) {
      selector.getFeedItemIds().add(feedItemValue.getFeedItem().getFeedItemId());
    }
    selector.getPlaceholderTypes().add(PlaceholderType.QUICKLINK);
    selector.getPlaceholderTypes().add(PlaceholderType.CALLEXTENSION);
    selector.getPlaceholderTypes().add(PlaceholderType.AD_CUSTOMIZER);
    selector.getApprovalStatuses().add(ApprovalStatus.APPROVED);
    selector.getApprovalStatuses().add(ApprovalStatus.REVIEW);
    selector.getApprovalStatuses().add(ApprovalStatus.PRE_DISAPPROVED);
    selector.getApprovalStatuses().add(ApprovalStatus.APPROVED_WITH_REVIEW);
    selector.getApprovalStatuses().add(ApprovalStatus.POST_DISAPPROVED);
    Paging feedItemPaging = new Paging();
    feedItemPaging.setStartIndex(1);
    feedItemPaging.setNumberResults(20);
    selector.setPaging(feedItemPaging);

    return selector;
  }
}

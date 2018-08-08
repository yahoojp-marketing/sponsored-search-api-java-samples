package jp.co.yahoo.ad_api_sample.adCustomizerSample;

import jp.co.yahoo.ad_api_sample.error.impl.FeedItemServiceErrorEntityFactory;
import jp.co.yahoo.ad_api_sample.util.SoapUtils;
import jp.yahooapis.ss.v201808.Error;
import jp.yahooapis.ss.v201808.Paging;
import jp.yahooapis.ss.v201808.feeditem.ApprovalStatus;
import jp.yahooapis.ss.v201808.feeditem.CriterionTypeFeedItem;
import jp.yahooapis.ss.v201808.feeditem.CustomParameter;
import jp.yahooapis.ss.v201808.feeditem.CustomParameters;
import jp.yahooapis.ss.v201808.feeditem.DayOfWeek;
import jp.yahooapis.ss.v201808.feeditem.DevicePreference;
import jp.yahooapis.ss.v201808.feeditem.FeedAttributeValue;
import jp.yahooapis.ss.v201808.feeditem.FeedItem;
import jp.yahooapis.ss.v201808.feeditem.FeedItemAttribute;
import jp.yahooapis.ss.v201808.feeditem.FeedItemGeoRestriction;
import jp.yahooapis.ss.v201808.feeditem.FeedItemOperation;
import jp.yahooapis.ss.v201808.feeditem.FeedItemPage;
import jp.yahooapis.ss.v201808.feeditem.FeedItemPlaceholderField;
import jp.yahooapis.ss.v201808.feeditem.FeedItemPlaceholderType;
import jp.yahooapis.ss.v201808.feeditem.FeedItemReturnValue;
import jp.yahooapis.ss.v201808.feeditem.FeedItemSchedule;
import jp.yahooapis.ss.v201808.feeditem.FeedItemScheduling;
import jp.yahooapis.ss.v201808.feeditem.FeedItemSelector;
import jp.yahooapis.ss.v201808.feeditem.FeedItemService;
import jp.yahooapis.ss.v201808.feeditem.FeedItemServiceInterface;
import jp.yahooapis.ss.v201808.feeditem.FeedItemValues;
import jp.yahooapis.ss.v201808.feeditem.IsRemove;
import jp.yahooapis.ss.v201808.feeditem.KeywordMatchType;
import jp.yahooapis.ss.v201808.feeditem.Location;
import jp.yahooapis.ss.v201808.feeditem.MinuteOfHour;
import jp.yahooapis.ss.v201808.feeditem.MultipleFeedItemAttribute;
import jp.yahooapis.ss.v201808.feeditem.Operator;
import jp.yahooapis.ss.v201808.feeditem.SimpleFeedItemAttribute;
import jp.yahooapis.ss.v201808.feeditem.TargetingAdGroup;
import jp.yahooapis.ss.v201808.feeditem.TargetingCampaign;
import jp.yahooapis.ss.v201808.feeditem.TargetingKeyword;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.ws.Holder;


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
      FeedItemOperation addFeedItemOperation = AdCustomizerSampleFeedItem.createSampleAddRequest(accountId, campaignId, adGroupId, feedFolderId, feedAttributeIds);

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
      System.out.println("\n***** sleep 20 seconds *****\n");
      Thread.sleep(20000);

      // =================================================================
      // FeefItemService SET
      // =================================================================
      // Set Operation
      FeedItemOperation setFeedItemOperation = AdCustomizerSampleFeedItem.createSampleSetRequest(accountId, feedItemValues);

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
        if (feedItemValues.getError().get(0).getCode().equals("210104")) {
          System.out.println("******* Skip. *******");
          System.out.println("code = " + feedItemValues.getError().get(0).getCode());
          System.out.println("message = " + feedItemValues.getError().get(0).getMessage());
        } else {
          SoapUtils.displayErrors(new FeedItemServiceErrorEntityFactory(feedItemValues.getError()), true);
        }
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
      System.out.println("feedItemTrackId = " + feedItem.getFeedItemTrackId());
      System.out.println("approvalStatus = " + feedItem.getApprovalStatus());

      long feedAttributeIndex = 0;
      for (FeedItemAttribute feedAttribute : feedItem.getFeedItemAttribute()) {
        System.out.println("feedAttribute[" + feedAttributeIndex + "]/placeholderField = " + feedAttribute.getPlaceholderField());
        System.out.println("feedAttribute[" + feedAttributeIndex + "]/feedAttributeId = " + feedAttribute.getFeedAttributeId());
        if(feedAttribute instanceof SimpleFeedItemAttribute) {
          System.out.println("feedAttribute[" + feedAttributeIndex + "]/feedAttributeValue = " + ((SimpleFeedItemAttribute) feedAttribute).getFeedAttributeValue());
          System.out.println("feedAttribute[" + feedAttributeIndex + "]/reviewFeedAttributeValue = " + ((SimpleFeedItemAttribute) feedAttribute).getReviewFeedAttributeValue());
        } else if(feedAttribute instanceof MultipleFeedItemAttribute) {
          MultipleFeedItemAttribute multipleFeedItemAttribute = ((MultipleFeedItemAttribute) feedAttribute);
          long feedAttributeValueIndex = 0;
          for (FeedAttributeValue feedAttributeValue : multipleFeedItemAttribute.getFeedAttributeValues()) {
            System.out.println("feedAttribute[" + feedAttributeIndex + "]/feedAttributeValue[" + feedAttributeValueIndex + "]/feedAttributeValue = " + feedAttributeValue.getFeedAttributeValue());
            System.out.println("feedAttribute[" + feedAttributeIndex + "]/feedAttributeValue[" + feedAttributeValueIndex + "]/reviewFeedAttributeValue = " + feedAttributeValue.getReviewFeedAttributeValue());
            feedAttributeValueIndex++;
          }
        }
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

      if (null != feedItem.getCustomParameters()) {
        CustomParameters customParameters = feedItem.getCustomParameters();
        System.out.println("customParameters/isRemove = " + customParameters.getIsRemove());

        if (null != customParameters.getParameters()) {
          long index = 0;
          for (CustomParameter parameter : customParameters.getParameters()) {
            System.out.println("customParameters/parameters[" + index + "]/key = " + parameter.getKey());
            System.out.println("customParameters/parameters[" + index + "]/value = " + parameter.getValue());
            index++;
          }
        }
      }

      if (null != feedItem.getReviewCustomParameters()) {
        CustomParameters reviewCustomParameters = feedItem.getReviewCustomParameters();
        System.out.println("reviewCustomParameters/isRemove = " + reviewCustomParameters.getIsRemove());

        if (null != reviewCustomParameters.getParameters()) {
          long index = 0;
          for (CustomParameter parameter : reviewCustomParameters.getParameters()) {
            System.out.println("reviewCustomParameters/parameters[" + index + "]/key = " + parameter.getKey());
            System.out.println("reviewCustomParameters/parameters[" + index + "]/value = " + parameter.getValue());
            index++;
          }
        }
      }

      if (feedItem.getGeoTargeting() != null) {
        System.out.println("geoTargeting/targetId = " + feedItem.getGeoTargeting().getTargetId());
        if (feedItem.getGeoTargeting().getType() != null) {
          System.out.println("geoTargeting/type = " + feedItem.getGeoTargeting().getType().name());
        }
        if (feedItem.getGeoTargeting().getGeoTargetingRestriction() != null) {
          System.out.println("geoTargeting/geoTargetingRestriction = " + feedItem.getGeoTargeting().getGeoTargetingRestriction().name());
        }
        if (feedItem.getGeoTargeting().getIsRemove() != null) {
          System.out.println("geoTargeting/isRemove = " + feedItem.getGeoTargeting().getIsRemove().name());
        }
      }

      System.out.println("---------");
    } catch (Exception e) {
      e.printStackTrace();
      throw e;
    }
  }

  /**
   * Sample Request of Quicklink FeedItem.
   */
  public static class QuicklinkSampleFeedItem {

    /**
     * create sample request.
     *
     * @param accountId long
     * @return FeedItemOperation
     */
    public static FeedItemOperation createSampleAddRequest(long accountId) {
      // Set Operation
      FeedItemOperation operation = new FeedItemOperation();
      operation.setOperator(jp.yahooapis.ss.v201808.feeditem.Operator.ADD);
      operation.setAccountId(accountId);
      operation.setPlaceholderType(FeedItemPlaceholderType.QUICKLINK);

      // Set Operand
      FeedItem feedItem = new FeedItem();
      feedItem.setAccountId(accountId);
      feedItem.setPlaceholderType(FeedItemPlaceholderType.QUICKLINK);

      SimpleFeedItemAttribute addLinkText = new SimpleFeedItemAttribute();
      addLinkText.setPlaceholderField(FeedItemPlaceholderField.LINK_TEXT);
      addLinkText.setFeedAttributeValue("samplelink");
      feedItem.getFeedItemAttribute().add(addLinkText);

      SimpleFeedItemAttribute advancedUrl = new SimpleFeedItemAttribute();
      advancedUrl.setPlaceholderField(FeedItemPlaceholderField.ADVANCED_URL);
      advancedUrl.setFeedAttributeValue("http://www.quicklink.sample.co.jp");
      feedItem.getFeedItemAttribute().add(advancedUrl);

      SimpleFeedItemAttribute advancedMobileUrl = new SimpleFeedItemAttribute();
      advancedMobileUrl.setPlaceholderField(FeedItemPlaceholderField.ADVANCED_MOBILE_URL);
      advancedMobileUrl.setFeedAttributeValue("http://www.quicklink.sample.co.jp/mobile");
      feedItem.getFeedItemAttribute().add(advancedMobileUrl);

      SimpleFeedItemAttribute trackingUrl = new SimpleFeedItemAttribute();
      trackingUrl.setPlaceholderField(FeedItemPlaceholderField.TRACKING_URL);
      trackingUrl.setFeedAttributeValue("http://www.quicklink.sample.co.jp?url={lpurl}&amp;pid={_id1}");
      feedItem.getFeedItemAttribute().add(trackingUrl);

      feedItem.setStartDate(DateTimeFormatter.ofPattern("yyyyMMdd").format(LocalDateTime.now()));
      feedItem.setEndDate(DateTimeFormatter.ofPattern("yyyyMMdd").format(LocalDateTime.now().plusMonths(1L)));

      FeedItemSchedule quickLinkSchedule1 = new FeedItemSchedule();
      quickLinkSchedule1.setDayOfWeek(DayOfWeek.SUNDAY);
      quickLinkSchedule1.setStartHour(14L);
      quickLinkSchedule1.setStartMinute(MinuteOfHour.ZERO);
      quickLinkSchedule1.setEndHour(15L);
      quickLinkSchedule1.setEndMinute(MinuteOfHour.THIRTY);

      FeedItemSchedule quickLinkSchedule2 = new FeedItemSchedule();
      quickLinkSchedule2.setDayOfWeek(DayOfWeek.MONDAY);
      quickLinkSchedule2.setStartHour(14L);
      quickLinkSchedule2.setStartMinute(MinuteOfHour.ZERO);
      quickLinkSchedule2.setEndHour(15L);
      quickLinkSchedule2.setEndMinute(MinuteOfHour.THIRTY);

      FeedItemScheduling scheduling = new FeedItemScheduling();
      scheduling.getSchedules().addAll(Arrays.asList(quickLinkSchedule1, quickLinkSchedule2));
      feedItem.setScheduling(scheduling);

      feedItem.setDevicePreference(jp.yahooapis.ss.v201808.feeditem.DevicePreference.SMART_PHONE);

      // Set CustomParameters
      CustomParameter customParameter = new CustomParameter();
      customParameter.setKey("1d1");
      customParameter.setValue("1234");

      CustomParameters customParameters = new CustomParameters();
      customParameters.getParameters().add(customParameter);
      feedItem.setCustomParameters(customParameters);

      operation.getOperand().add(feedItem);

      return operation;
    }

    /**
     * create sample request.
     *
     * @param accountId      long
     * @param feedItemValues FeedItemValues
     * @return FeedItemOperation
     */
    public static FeedItemOperation createSampleSetRequest(long accountId, List<FeedItemValues> feedItemValues) {
      FeedItemOperation operation = new FeedItemOperation();
      operation.setOperator(jp.yahooapis.ss.v201808.feeditem.Operator.SET);
      operation.setAccountId(accountId);
      operation.setPlaceholderType(FeedItemPlaceholderType.QUICKLINK);

      FeedItem operand = new FeedItem();
      operand.setAccountId(accountId);
      for (FeedItemValues feedItemValue : feedItemValues) {
        operand.setFeedItemId(feedItemValue.getFeedItem().getFeedItemId());
        break;
      }
      operand.setPlaceholderType(FeedItemPlaceholderType.QUICKLINK);

      SimpleFeedItemAttribute setLinkText = new SimpleFeedItemAttribute();
      setLinkText.setPlaceholderField(FeedItemPlaceholderField.LINK_TEXT);
      setLinkText.setFeedAttributeValue("editlink");
      operand.getFeedItemAttribute().add(setLinkText);

      SimpleFeedItemAttribute advancedUrl = new SimpleFeedItemAttribute();
      advancedUrl.setPlaceholderField(FeedItemPlaceholderField.ADVANCED_URL);
      advancedUrl.setFeedAttributeValue("http://www.quicklink.sample.co.jp");
      operand.getFeedItemAttribute().add(advancedUrl);

      SimpleFeedItemAttribute advancedMobileUrl = new SimpleFeedItemAttribute();
      advancedMobileUrl.setPlaceholderField(FeedItemPlaceholderField.ADVANCED_MOBILE_URL);
      advancedMobileUrl.setFeedAttributeValue("http://www.quicklink.sample.co.jp/mobile");
      operand.getFeedItemAttribute().add(advancedMobileUrl);

      SimpleFeedItemAttribute trackingUrl = new SimpleFeedItemAttribute();
      trackingUrl.setPlaceholderField(FeedItemPlaceholderField.TRACKING_URL);
      trackingUrl.setFeedAttributeValue("http://www.quicklink.sample.co.jp?url={lpurl}&amp;pid={_id1}");
      operand.getFeedItemAttribute().add(trackingUrl);

      operand.setStartDate("");
      operand.setEndDate("");

      // Set CustomParameters
      CustomParameter customParameter = new CustomParameter();
      customParameter.setKey("1d1");
      customParameter.setValue("5678");

      CustomParameters customParameters = new CustomParameters();
      customParameters.setIsRemove(IsRemove.FALSE);
      customParameters.getParameters().add(customParameter);
      operand.setCustomParameters(customParameters);

      operation.getOperand().add(operand);

      return operation;
    }
  }

  /**
   * Sample Request of Callextension FeedItem.
   */
  public static class CallextensionSampleFeedItem {

    /**
     * create sample request.
     *
     * @param accountId long
     * @return FeedItemOperation
     */
    public static FeedItemOperation createSampleAddRequest(long accountId) {
      // set Operation
      FeedItemOperation operation = new FeedItemOperation();
      operation.setOperator(jp.yahooapis.ss.v201808.feeditem.Operator.ADD);
      operation.setAccountId(accountId);
      operation.setPlaceholderType(FeedItemPlaceholderType.CALLEXTENSION);

      FeedItem operand = new FeedItem();
      operand.setAccountId(accountId);
      operand.setPlaceholderType(FeedItemPlaceholderType.CALLEXTENSION);
      SimpleFeedItemAttribute addCallExtension = new SimpleFeedItemAttribute();
      addCallExtension.setPlaceholderField(FeedItemPlaceholderField.CALL_PHONE_NUMBER);
      addCallExtension.setFeedAttributeValue("0120-123-556");
      operand.getFeedItemAttribute().add(addCallExtension);

      FeedItemSchedule callSchedule1 = new FeedItemSchedule();
      callSchedule1.setDayOfWeek(DayOfWeek.SUNDAY);
      callSchedule1.setStartHour(10L);
      callSchedule1.setStartMinute(MinuteOfHour.ZERO);
      callSchedule1.setEndHour(12L);
      callSchedule1.setEndMinute(MinuteOfHour.THIRTY);

      FeedItemSchedule callSchedule2 = new FeedItemSchedule();
      callSchedule2.setDayOfWeek(DayOfWeek.MONDAY);
      callSchedule2.setStartHour(10L);
      callSchedule2.setStartMinute(MinuteOfHour.ZERO);
      callSchedule2.setEndHour(12L);
      callSchedule2.setEndMinute(MinuteOfHour.THIRTY);

      FeedItemScheduling callScheduling = new FeedItemScheduling();
      callScheduling.getSchedules().addAll(Arrays.asList(callSchedule1, callSchedule2));
      operand.setScheduling(callScheduling);

      operation.getOperand().add(operand);

      return operation;
    }

    /**
     * create sample request.
     *
     * @param accountId      long
     * @param feedItemValues FeedItemValues
     * @return FeedItemOperation
     */
    public static FeedItemOperation createSampleSetRequest(long accountId, List<FeedItemValues> feedItemValues) {
      FeedItemOperation operation = new FeedItemOperation();
      operation.setOperator(jp.yahooapis.ss.v201808.feeditem.Operator.SET);
      operation.setAccountId(accountId);
      operation.setPlaceholderType(FeedItemPlaceholderType.CALLEXTENSION);

      FeedItem operand = new FeedItem();
      operand.setAccountId(accountId);
      for (FeedItemValues feedItemValue : feedItemValues) {
        operand.setFeedItemId(feedItemValue.getFeedItem().getFeedItemId());
        break;
      }
      operand.setPlaceholderType(FeedItemPlaceholderType.CALLEXTENSION);

      SimpleFeedItemAttribute setCallExtension = new SimpleFeedItemAttribute();
      setCallExtension.setPlaceholderField(FeedItemPlaceholderField.CALL_PHONE_NUMBER);
      setCallExtension.setFeedAttributeValue("0120-556-789");
      operand.getFeedItemAttribute().add(setCallExtension);
      operand.setScheduling(new FeedItemScheduling());

      operation.getOperand().add(operand);

      return operation;
    }
  }

  /**
   * Sample Request of AdCustomizer FeedItem.
   */
  public static class AdCustomizerSampleFeedItem {

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
      operation.setPlaceholderType(FeedItemPlaceholderType.AD_CUSTOMIZER);

      // Set FeedItemAttribute
      SimpleFeedItemAttribute integerTypeFeedItemAttribute = new SimpleFeedItemAttribute();
      integerTypeFeedItemAttribute.setFeedAttributeId(feedAttributeIds.get("AD_CUSTOMIZER_INTEGER"));
      integerTypeFeedItemAttribute.setFeedAttributeValue("1234567890");
      SimpleFeedItemAttribute priceTypeFeedItemAttribute = new SimpleFeedItemAttribute();
      priceTypeFeedItemAttribute.setFeedAttributeId(feedAttributeIds.get("AD_CUSTOMIZER_PRICE"));
      priceTypeFeedItemAttribute.setFeedAttributeValue("9,999,999.99");
      SimpleFeedItemAttribute dateTypeFeedItemAttribute = new SimpleFeedItemAttribute();
      dateTypeFeedItemAttribute.setFeedAttributeId(feedAttributeIds.get("AD_CUSTOMIZER_DATE"));
      dateTypeFeedItemAttribute.setFeedAttributeValue("20151231 235959");
      SimpleFeedItemAttribute stringTypeFeedItemAttribute = new SimpleFeedItemAttribute();
      stringTypeFeedItemAttribute.setFeedAttributeId(feedAttributeIds.get("AD_CUSTOMIZER_STRING"));
      stringTypeFeedItemAttribute.setFeedAttributeValue("sample Value");

      // Set Operand
      FeedItem feedItem = new FeedItem();
      feedItem.setAccountId(accountId);
      feedItem.setFeedFolderId(feedFolderId);
      feedItem.getFeedItemAttribute().addAll(Arrays.asList(integerTypeFeedItemAttribute, priceTypeFeedItemAttribute, dateTypeFeedItemAttribute, stringTypeFeedItemAttribute));
      feedItem.setPlaceholderType(FeedItemPlaceholderType.AD_CUSTOMIZER);
      feedItem.setDevicePreference(DevicePreference.SMART_PHONE);
      feedItem.setStartDate(DateTimeFormatter.ofPattern("yyyyMMdd").format(LocalDateTime.now()));
      feedItem.setEndDate(DateTimeFormatter.ofPattern("yyyyMMdd").format(LocalDateTime.now().plusMonths(1L)));

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

      // Set GeoTargeting
      Location location = new Location();
      location.setType(CriterionTypeFeedItem.LOCATION);
      location.setGeoTargetingRestriction(FeedItemGeoRestriction.LOCATION_OF_PRESENCE);
      location.setTargetId("JP-01-0010");
      feedItem.setGeoTargeting(location);

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
      operation.setPlaceholderType(FeedItemPlaceholderType.AD_CUSTOMIZER);

      // Set Operand
      for (FeedItemValues feedItemValue : feedItemValues) {

        FeedItem feedItem = new FeedItem();
        feedItem.setAccountId(feedItemValue.getFeedItem().getAccountId());
        feedItem.setFeedItemId(feedItemValue.getFeedItem().getFeedItemId());

        // Set FeedItemAttribute
        for (FeedItemAttribute feedItemAttribute : feedItemValue.getFeedItem().getFeedItemAttribute()) {
          SimpleFeedItemAttribute updateFeedItemAttribute = new SimpleFeedItemAttribute();
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

        // Set GeoTargeting delete GeoTargeting
        Location location = new Location();
        location.setIsRemove(IsRemove.TRUE);
        feedItem.setGeoTargeting(location);

        operation.getOperand().add(feedItem);
      }

      return operation;
    }
  }

  /**
   * Sample Request of StructuredSnippet FeedItem.
   */
  public static class StructuredSnippetSampleFeedItem {

    /**
     * Sample Request for FeedItemService ADD(StructuredSnippet).
     *
     * @return FeedItemOperation
     */
    public static FeedItemOperation createSampleAddRequest(long accountId) {

      // Set Operation
      FeedItemOperation feedItemOperation = new FeedItemOperation();
      feedItemOperation.setOperator(Operator.ADD);
      feedItemOperation.setAccountId(accountId);
      feedItemOperation.setPlaceholderType(FeedItemPlaceholderType.STRUCTURED_SNIPPET);

      // Set SimpleFeedItemAttribute
      SimpleFeedItemAttribute simpleFeedItemAttribute = new SimpleFeedItemAttribute();
      simpleFeedItemAttribute.setPlaceholderField(FeedItemPlaceholderField.STRUCTURED_SNIPPET_HEADER);
      simpleFeedItemAttribute.setFeedAttributeValue("ブランド");

      // Set MultipleFeedItemAttribute
      MultipleFeedItemAttribute multipleFeedItemAttribute = new MultipleFeedItemAttribute();
      multipleFeedItemAttribute.setPlaceholderField(FeedItemPlaceholderField.STRUCTURED_SNIPPET_VALUES);
      FeedAttributeValue feedAttributeValue1 = new FeedAttributeValue();
      feedAttributeValue1.setFeedAttributeValue("SampleBrand1");
      multipleFeedItemAttribute.getFeedAttributeValues().add(feedAttributeValue1);
      FeedAttributeValue feedAttributeValue2 = new FeedAttributeValue();
      feedAttributeValue2.setFeedAttributeValue("SampleBrand2");
      multipleFeedItemAttribute.getFeedAttributeValues().add(feedAttributeValue2);
      FeedAttributeValue feedAttributeValue3 = new FeedAttributeValue();
      feedAttributeValue3.setFeedAttributeValue("SampleBrand3");
      multipleFeedItemAttribute.getFeedAttributeValues().add(feedAttributeValue3);

      // Set Schedule
      FeedItemSchedule feedItemSchedule = new FeedItemSchedule();
      feedItemSchedule.setDayOfWeek(DayOfWeek.SUNDAY);
      feedItemSchedule.setStartHour(14L);
      feedItemSchedule.setStartMinute(MinuteOfHour.ZERO);
      feedItemSchedule.setEndHour(15L);
      feedItemSchedule.setEndMinute(MinuteOfHour.THIRTY);
      FeedItemScheduling scheduling = new FeedItemScheduling();
      scheduling.getSchedules().add(feedItemSchedule);

      // Set FeedItem
      FeedItem feedItem = new FeedItem();
      feedItem.getFeedItemAttribute().addAll(Arrays.asList(simpleFeedItemAttribute, multipleFeedItemAttribute));
      feedItem.setStartDate(DateTimeFormatter.ofPattern("yyyyMMdd").format(LocalDateTime.now()));
      feedItem.setEndDate(DateTimeFormatter.ofPattern("yyyyMMdd").format(LocalDateTime.now().plusMonths(1L)));
      feedItem.setScheduling(scheduling);

      feedItemOperation.getOperand().add(feedItem);
      return feedItemOperation;
    }

    /**
     * Sample Request for FeedItemService SET(StructuredSnippet).
     *
     * @return FeedItemOperation
     */
    public static FeedItemOperation createSampleSetRequest(long accountId, List<FeedItemValues> feedItemValues) {

      // Set Operation
      FeedItemOperation feedItemOperation = new FeedItemOperation();
      feedItemOperation.setOperator(Operator.SET);
      feedItemOperation.setAccountId(accountId);
      feedItemOperation.setPlaceholderType(FeedItemPlaceholderType.STRUCTURED_SNIPPET);

      // Set SimpleFeedItemAttribute
      SimpleFeedItemAttribute simpleFeedItemAttribute = new SimpleFeedItemAttribute();
      simpleFeedItemAttribute.setPlaceholderField(FeedItemPlaceholderField.STRUCTURED_SNIPPET_HEADER);
      simpleFeedItemAttribute.setFeedAttributeValue("ブランド");

      // Set MultipleFeedItemAttribute
      MultipleFeedItemAttribute multipleFeedItemAttribute = new MultipleFeedItemAttribute();
      multipleFeedItemAttribute.setPlaceholderField(FeedItemPlaceholderField.STRUCTURED_SNIPPET_VALUES);
      FeedAttributeValue feedAttributeValue1 = new FeedAttributeValue();
      feedAttributeValue1.setFeedAttributeValue("SampleBrand4");
      multipleFeedItemAttribute.getFeedAttributeValues().add(feedAttributeValue1);
      FeedAttributeValue feedAttributeValue2 = new FeedAttributeValue();
      feedAttributeValue2.setFeedAttributeValue("SampleBrand5");
      multipleFeedItemAttribute.getFeedAttributeValues().add(feedAttributeValue2);
      FeedAttributeValue feedAttributeValue3 = new FeedAttributeValue();
      feedAttributeValue3.setFeedAttributeValue("SampleBrand6");
      multipleFeedItemAttribute.getFeedAttributeValues().add(feedAttributeValue3);

      // Set FeedItem
      FeedItem feedItem = new FeedItem();
      feedItem.setFeedItemId(feedItemValues.get(0).getFeedItem().getFeedItemId());
      feedItem.getFeedItemAttribute().addAll(Arrays.asList(simpleFeedItemAttribute, multipleFeedItemAttribute));

      feedItemOperation.getOperand().add(feedItem);
      return feedItemOperation;
    }
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
    operation.setPlaceholderType(feedItemValues.get(0).getFeedItem().getPlaceholderType());

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
    selector.getPlaceholderTypes().add(FeedItemPlaceholderType.QUICKLINK);
    selector.getPlaceholderTypes().add(FeedItemPlaceholderType.CALLEXTENSION);
    selector.getPlaceholderTypes().add(FeedItemPlaceholderType.AD_CUSTOMIZER);
    selector.getPlaceholderTypes().add(FeedItemPlaceholderType.STRUCTURED_SNIPPET);
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

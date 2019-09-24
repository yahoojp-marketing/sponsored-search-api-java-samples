/**
 * Copyright (C) 2019 Yahoo Japan Corporation. All Rights Reserved.
 */
package jp.yahooapis.ss.adapisample.basic.feeditem;

import jp.yahooapis.ss.adapisample.basic.adgroup.AdGroupServiceSample;
import jp.yahooapis.ss.adapisample.repository.ValuesRepositoryFacade;
import jp.yahooapis.ss.adapisample.util.SoapUtils;
import jp.yahooapis.ss.adapisample.util.ValuesHolder;
import jp.yahooapis.ss.v201909.Error;
import jp.yahooapis.ss.v201909.Paging;
import jp.yahooapis.ss.v201909.feeditem.ApprovalStatus;
import jp.yahooapis.ss.v201909.feeditem.CriterionTypeFeedItem;
import jp.yahooapis.ss.v201909.feeditem.CustomParameter;
import jp.yahooapis.ss.v201909.feeditem.CustomParameters;
import jp.yahooapis.ss.v201909.feeditem.DayOfWeek;
import jp.yahooapis.ss.v201909.feeditem.DevicePreference;
import jp.yahooapis.ss.v201909.feeditem.FeedAttributeValue;
import jp.yahooapis.ss.v201909.feeditem.FeedItem;
import jp.yahooapis.ss.v201909.feeditem.FeedItemGeoRestriction;
import jp.yahooapis.ss.v201909.feeditem.FeedItemOperation;
import jp.yahooapis.ss.v201909.feeditem.FeedItemPage;
import jp.yahooapis.ss.v201909.feeditem.FeedItemPlaceholderField;
import jp.yahooapis.ss.v201909.feeditem.FeedItemPlaceholderType;
import jp.yahooapis.ss.v201909.feeditem.FeedItemReturnValue;
import jp.yahooapis.ss.v201909.feeditem.FeedItemSchedule;
import jp.yahooapis.ss.v201909.feeditem.FeedItemScheduling;
import jp.yahooapis.ss.v201909.feeditem.FeedItemSelector;
import jp.yahooapis.ss.v201909.feeditem.FeedItemService;
import jp.yahooapis.ss.v201909.feeditem.FeedItemServiceInterface;
import jp.yahooapis.ss.v201909.feeditem.FeedItemValues;
import jp.yahooapis.ss.v201909.feeditem.IsRemove;
import jp.yahooapis.ss.v201909.feeditem.KeywordMatchType;
import jp.yahooapis.ss.v201909.feeditem.Location;
import jp.yahooapis.ss.v201909.feeditem.MinuteOfHour;
import jp.yahooapis.ss.v201909.feeditem.MultipleFeedItemAttribute;
import jp.yahooapis.ss.v201909.feeditem.Operator;
import jp.yahooapis.ss.v201909.feeditem.SimpleFeedItemAttribute;
import jp.yahooapis.ss.v201909.feeditem.TargetingAdGroup;
import jp.yahooapis.ss.v201909.feeditem.TargetingCampaign;
import jp.yahooapis.ss.v201909.feeditem.TargetingKeyword;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import javax.xml.ws.Holder;


/**
 * example FeedItemService operation and Utility method collection.
 */
public class FeedItemServiceSample {

  /**
   * main method for FeedItemServiceSample
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
      // FeedItemService ADD (QUICKLINK)
      // =================================================================
      // create request.
      FeedItemOperation addRequestQuicklink = buildExampleMutateRequest( //
          Operator.ADD, accountId, FeedItemPlaceholderType.QUICKLINK, Collections.singletonList(createExampleQuicklink()) //
      );

      // run
      List<FeedItemValues> addResponseQuicklink = mutate(addRequestQuicklink);
      valuesRepositoryFacade.getValuesHolder().setFeedItemValuesList(addResponseQuicklink);

      // =================================================================
      // FeedItemService ADD (CALLEXTENSION)
      // =================================================================
      // create request.
      FeedItemOperation addRequestCallextension = buildExampleMutateRequest( //
          Operator.ADD, accountId, FeedItemPlaceholderType.CALLEXTENSION, Collections.singletonList(createExampleCallextension()) //
      );

      // run
      List<FeedItemValues> addResponseCallextension = mutate(addRequestCallextension);
      valuesRepositoryFacade.getValuesHolder().setFeedItemValuesList(addResponseCallextension);

      // =================================================================
      // FeedItemService ADD (CALLOUT)
      // =================================================================
      // create request.
      FeedItemOperation addRequestCallout = buildExampleMutateRequest( //
          Operator.ADD, accountId, FeedItemPlaceholderType.CALLOUT, Collections.singletonList(createExampleCallout()) //
      );

      // run
      List<FeedItemValues> addResponseCallout = mutate(addRequestCallout);
      valuesRepositoryFacade.getValuesHolder().setFeedItemValuesList(addResponseCallout);

      //=================================================================
      // FeedItemService SET (QUICKLINK)
      //=================================================================
      // create request.
      List<FeedItem> feedItemsQuicklink = new ArrayList<>();
      feedItemsQuicklink.add(valuesRepositoryFacade.getFeedItemValuesRepository().findFeedItem(FeedItemPlaceholderType.QUICKLINK));
      FeedItemOperation setRequestQuicklink = buildExampleMutateRequest(Operator.SET, accountId, FeedItemPlaceholderType.QUICKLINK, createExampleSetRequest(feedItemsQuicklink));

      // run
      mutate(setRequestQuicklink);

      //=================================================================
      // FeedItemService SET (CALLEXTENSION)
      //=================================================================
      // create request.
      List<FeedItem> feedItemsCallextension = new ArrayList<>();
      feedItemsCallextension.add(valuesRepositoryFacade.getFeedItemValuesRepository().findFeedItem(FeedItemPlaceholderType.CALLEXTENSION));
      FeedItemOperation setRequestCallextension = buildExampleMutateRequest(Operator.SET, accountId, FeedItemPlaceholderType.CALLEXTENSION, createExampleSetRequest(feedItemsCallextension));

      // run
      mutate(setRequestCallextension);

      //=================================================================
      // FeedItemService SET (CALLOUT)
      //=================================================================
      // create request.
      List<FeedItem> feedItemsCallout = new ArrayList<>();
      feedItemsCallout.add(valuesRepositoryFacade.getFeedItemValuesRepository().findFeedItem(FeedItemPlaceholderType.CALLOUT));
      FeedItemOperation setRequestCallout = buildExampleMutateRequest(Operator.SET, accountId, FeedItemPlaceholderType.CALLOUT, createExampleSetRequest(feedItemsCallout));

      // run
      mutate(setRequestCallout);

      // =================================================================
      // FeedItemService GET
      // =================================================================
      // create request.
      FeedItemSelector feedItemSelector = buildExampleGetRequest(accountId, valuesRepositoryFacade.getFeedItemValuesRepository().getFeedItemIds(), Collections.emptyList());

      // run
      get(feedItemSelector);

      // =================================================================
      // FeedItemService REMOVE (QUICKLINK)
      // =================================================================
      // create request.
      FeedItemOperation removeRequestQuicklink = buildExampleMutateRequest( //
          Operator.REMOVE, accountId, FeedItemPlaceholderType.QUICKLINK, Collections.singletonList(valuesRepositoryFacade.getFeedItemValuesRepository().findFeedItem(FeedItemPlaceholderType.QUICKLINK)) //
      );

      // run
      mutate(removeRequestQuicklink);

      // =================================================================
      // FeedItemService REMOVE (CALLEXTENSION)
      // =================================================================
      // create request.
      FeedItemOperation removeRequestCallextension = buildExampleMutateRequest( //
          Operator.REMOVE, accountId, FeedItemPlaceholderType.CALLEXTENSION, Collections.singletonList(valuesRepositoryFacade.getFeedItemValuesRepository().findFeedItem(FeedItemPlaceholderType.CALLEXTENSION)) //
      );

      // run
      mutate(removeRequestCallextension);

      // =================================================================
      // FeedItemService REMOVE (CALLOUT)
      // =================================================================
      // create request.
      FeedItemOperation removeRequestCallout = buildExampleMutateRequest( //
          Operator.REMOVE, accountId, FeedItemPlaceholderType.CALLOUT, Collections.singletonList(valuesRepositoryFacade.getFeedItemValuesRepository().findFeedItem(FeedItemPlaceholderType.CALLOUT)) //
      );

      // run
      mutate(removeRequestCallout);

    } catch (Exception e) {
      e.printStackTrace();
      throw e;
    }
  }

  /**
   * example mutate request.
   */
  public static FeedItemOperation buildExampleMutateRequest(Operator operator, long accountId, FeedItemPlaceholderType feedItemPlaceholderType, List<FeedItem> operand) {
    FeedItemOperation operation = new FeedItemOperation();
    operation.setOperator(operator);
    operation.setAccountId(accountId);
    operation.setPlaceholderType(feedItemPlaceholderType);
    operation.getOperand().addAll(operand);

    return operation;
  }

  /**
   * example AdCustomizer FeedItem request.
   *
   * @param campaignId       long
   * @param adGroupId        long
   * @param feedFolderId     long
   * @param feedAttributeIds Map<String, Long>
   * @return FeedItem
   */
  public static FeedItem createExampleAdCustomizer(long campaignId, long adGroupId, long feedFolderId, Map<String, Long> feedAttributeIds) {

    // set feedItem
    FeedItem feedItem = new FeedItem();
    feedItem.setFeedFolderId(feedFolderId);
    feedItem.setStartDate(DateTimeFormatter.ofPattern("yyyyMMdd").format(LocalDateTime.now()));
    feedItem.setEndDate(DateTimeFormatter.ofPattern("yyyyMMdd").format(LocalDateTime.now().plusMonths(1L)));

    // set feedItemAttribute
    SimpleFeedItemAttribute feedItemAttributeInteger = new SimpleFeedItemAttribute();
    feedItemAttributeInteger.setFeedAttributeId(feedAttributeIds.get("AD_CUSTOMIZER_INTEGER"));
    feedItemAttributeInteger.setFeedAttributeValue("1234567890");

    SimpleFeedItemAttribute feedItemAttributePrice = new SimpleFeedItemAttribute();
    feedItemAttributePrice.setFeedAttributeId(feedAttributeIds.get("AD_CUSTOMIZER_PRICE"));
    feedItemAttributePrice.setFeedAttributeValue("9,999,999.99");

    SimpleFeedItemAttribute feedItemAttributeDate = new SimpleFeedItemAttribute();
    feedItemAttributeDate.setFeedAttributeId(feedAttributeIds.get("AD_CUSTOMIZER_DATE"));
    feedItemAttributeDate.setFeedAttributeValue(DateTimeFormatter.ofPattern("yyyyMMdd HHmmss").format(LocalDateTime.now().plusWeeks(1L)));

    SimpleFeedItemAttribute feedItemAttributeString = new SimpleFeedItemAttribute();
    feedItemAttributeString.setFeedAttributeId(feedAttributeIds.get("AD_CUSTOMIZER_STRING"));
    feedItemAttributeString.setFeedAttributeValue("sample Value");

    feedItem.getFeedItemAttribute().addAll(Arrays.asList( //
        feedItemAttributeInteger, //
        feedItemAttributePrice, //
        feedItemAttributeDate, //
        feedItemAttributeString //
    ));

    // set scheduling
    FeedItemSchedule schedule1 = new FeedItemSchedule();
    schedule1.setDayOfWeek(DayOfWeek.SUNDAY);
    schedule1.setStartHour(14L);
    schedule1.setStartMinute(MinuteOfHour.ZERO);
    schedule1.setEndHour(15L);
    schedule1.setEndMinute(MinuteOfHour.THIRTY);
    FeedItemSchedule schedule2 = new FeedItemSchedule();
    schedule2.setDayOfWeek(DayOfWeek.MONDAY);
    schedule2.setStartHour(14L);
    schedule2.setStartMinute(MinuteOfHour.ZERO);
    schedule2.setEndHour(15L);
    schedule2.setEndMinute(MinuteOfHour.THIRTY);
    FeedItemScheduling scheduling = new FeedItemScheduling();
    scheduling.getSchedules().addAll(Arrays.asList(schedule1, schedule2));

    feedItem.setScheduling(scheduling);

    // set targetCampaign
    TargetingCampaign targetingCampaign = new TargetingCampaign();
    targetingCampaign.setTargetingCampaignId(campaignId);
    feedItem.setTargetingCampaign(targetingCampaign);

    // set targetAdGroup
    TargetingAdGroup targetingAdGroup = new TargetingAdGroup();
    targetingAdGroup.setTargetingAdGroupId(adGroupId);
    feedItem.setTargetingAdGroup(targetingAdGroup);

    // set targetKeyword
    TargetingKeyword targetingKeyword = new TargetingKeyword();
    targetingKeyword.setText("sample keyword");
    targetingKeyword.setMatchType(KeywordMatchType.EXACT);
    feedItem.setTargetingKeyword(targetingKeyword);

    // set geoTargeting
    Location location = new Location();
    location.setType(CriterionTypeFeedItem.LOCATION);
    location.setGeoTargetingRestriction(FeedItemGeoRestriction.LOCATION_OF_PRESENCE);
    location.setTargetId("JP-01-0010");
    feedItem.setGeoTargeting(location);

    return feedItem;
  }


  /**
   * example Quicklink FeedItem request.
   *
   * @return FeedItem
   */
  public static FeedItem createExampleQuicklink() {

    // feedItemAttribute
    SimpleFeedItemAttribute feedItemAttributeLinkText = new SimpleFeedItemAttribute();
    feedItemAttributeLinkText.setPlaceholderField(FeedItemPlaceholderField.LINK_TEXT);
    feedItemAttributeLinkText.setFeedAttributeValue("samplelink");

    SimpleFeedItemAttribute feedItemAttributeAdvancedUrl = new SimpleFeedItemAttribute();
    feedItemAttributeAdvancedUrl.setPlaceholderField(FeedItemPlaceholderField.ADVANCED_URL);
    feedItemAttributeAdvancedUrl.setFeedAttributeValue("http://www.quicklink.sample.co.jp");

    SimpleFeedItemAttribute feedItemAttributeAdvancedMobileUrl = new SimpleFeedItemAttribute();
    feedItemAttributeAdvancedMobileUrl.setPlaceholderField(FeedItemPlaceholderField.ADVANCED_MOBILE_URL);
    feedItemAttributeAdvancedMobileUrl.setFeedAttributeValue("http://www.quicklink.sample.co.jp/mobile");

    SimpleFeedItemAttribute feedItemAttributeTrackingUrl = new SimpleFeedItemAttribute();
    feedItemAttributeTrackingUrl.setPlaceholderField(FeedItemPlaceholderField.TRACKING_URL);
    feedItemAttributeTrackingUrl.setFeedAttributeValue("http://www.quicklink.sample.co.jp?url={lpurl}&amp;pid={_id1}");

    MultipleFeedItemAttribute feedItemAttributeAdditionalAdvancedUrls = new MultipleFeedItemAttribute();
    feedItemAttributeAdditionalAdvancedUrls.setPlaceholderField(FeedItemPlaceholderField.ADDITIONAL_ADVANCED_URLS);
    FeedAttributeValue feedAttributeValue1 = new FeedAttributeValue();
    feedAttributeValue1.setFeedAttributeValue("http://www.quicklink.sample.co.jp/AdditionalAdvanced1/");
    FeedAttributeValue feedAttributeValue2 = new FeedAttributeValue();
    feedAttributeValue2.setFeedAttributeValue("http://www.quicklink.sample.co.jp/AdditionalAdvanced2/");
    FeedAttributeValue feedAttributeValue3 = new FeedAttributeValue();
    feedAttributeValue3.setFeedAttributeValue("http://www.quicklink.sample.co.jp/AdditionalAdvanced3/");
    feedItemAttributeAdditionalAdvancedUrls.getFeedAttributeValues().addAll(Arrays.asList(feedAttributeValue1, feedAttributeValue2, feedAttributeValue3));

    MultipleFeedItemAttribute feedItemAttributeAdditionalAdvancedMobileUrls = new MultipleFeedItemAttribute();
    feedItemAttributeAdditionalAdvancedMobileUrls.setPlaceholderField(FeedItemPlaceholderField.ADDITIONAL_ADVANCED_MOBILE_URLS);
    FeedAttributeValue feedAttributeValue4 = new FeedAttributeValue();
    feedAttributeValue4.setFeedAttributeValue("http://www.quicklink.sample.co.jp/AdditionalAdvanced1/mobile");
    FeedAttributeValue feedAttributeValue5 = new FeedAttributeValue();
    feedAttributeValue5.setFeedAttributeValue("http://www.quicklink.sample.co.jp/AdditionalAdvanced2/mobile");
    FeedAttributeValue feedAttributeValue6 = new FeedAttributeValue();
    feedAttributeValue6.setFeedAttributeValue("http://www.quicklink.sample.co.jp/AdditionalAdvanced3/mobile");
    feedItemAttributeAdditionalAdvancedMobileUrls.getFeedAttributeValues().addAll(Arrays.asList(feedAttributeValue4, feedAttributeValue5, feedAttributeValue6));

    SimpleFeedItemAttribute feedItemAttributeLinkDescription1 = new SimpleFeedItemAttribute();
    feedItemAttributeLinkDescription1.setPlaceholderField(FeedItemPlaceholderField.LINK_DESCRIPTION_1);
    feedItemAttributeLinkDescription1.setFeedAttributeValue("sampledescription1");

    SimpleFeedItemAttribute feedItemAttributeLinkDescription2 = new SimpleFeedItemAttribute();
    feedItemAttributeLinkDescription2.setPlaceholderField(FeedItemPlaceholderField.LINK_DESCRIPTION_2);
    feedItemAttributeLinkDescription2.setFeedAttributeValue("sampledescription2");

    // scheduling
    FeedItemSchedule schedule1 = new FeedItemSchedule();
    schedule1.setDayOfWeek(DayOfWeek.SUNDAY);
    schedule1.setStartHour(14L);
    schedule1.setStartMinute(MinuteOfHour.ZERO);
    schedule1.setEndHour(15L);
    schedule1.setEndMinute(MinuteOfHour.THIRTY);
    FeedItemSchedule schedule2 = new FeedItemSchedule();
    schedule2.setDayOfWeek(DayOfWeek.MONDAY);
    schedule2.setStartHour(14L);
    schedule2.setStartMinute(MinuteOfHour.ZERO);
    schedule2.setEndHour(15L);
    schedule2.setEndMinute(MinuteOfHour.THIRTY);
    FeedItemScheduling scheduling = new FeedItemScheduling();
    scheduling.getSchedules().addAll(Arrays.asList(schedule1, schedule2));

    // CustomParameters
    CustomParameter customParameter = new CustomParameter();
    customParameter.setKey("1d1");
    customParameter.setValue("1234");
    CustomParameters customParameters = new CustomParameters();
    customParameters.getParameters().add(customParameter);


    FeedItem feedItem = new FeedItem();
    feedItem.setStartDate(DateTimeFormatter.ofPattern("yyyyMMdd").format(LocalDateTime.now()));
    feedItem.setEndDate(DateTimeFormatter.ofPattern("yyyyMMdd").format(LocalDateTime.now().plusMonths(1L)));
    feedItem.setDevicePreference(DevicePreference.SMART_PHONE);
    feedItem.getFeedItemAttribute().addAll(Arrays.asList( //
        feedItemAttributeLinkText, //
        feedItemAttributeAdvancedUrl, //
        feedItemAttributeAdvancedMobileUrl, //
        feedItemAttributeTrackingUrl, //
        feedItemAttributeAdditionalAdvancedUrls, //
        feedItemAttributeAdditionalAdvancedMobileUrls, //
        feedItemAttributeLinkDescription1, //
        feedItemAttributeLinkDescription2 //
    ));
    feedItem.setScheduling(scheduling);
    feedItem.setCustomParameters(customParameters);

    return feedItem;
  }

  /**
   * example Callextension FeedItem request.
   *
   * @return FeedItem
   */
  public static FeedItem createExampleCallextension() {

    // feedItemAttribute
    SimpleFeedItemAttribute feedItemAttributeCallPhoneNumber = new SimpleFeedItemAttribute();
    feedItemAttributeCallPhoneNumber.setPlaceholderField(FeedItemPlaceholderField.CALL_PHONE_NUMBER);
    feedItemAttributeCallPhoneNumber.setFeedAttributeValue("0120-123-456");

    // scheduling
    FeedItemSchedule schedule1 = new FeedItemSchedule();
    schedule1.setDayOfWeek(DayOfWeek.SUNDAY);
    schedule1.setStartHour(14L);
    schedule1.setStartMinute(MinuteOfHour.ZERO);
    schedule1.setEndHour(15L);
    schedule1.setEndMinute(MinuteOfHour.THIRTY);
    FeedItemSchedule schedule2 = new FeedItemSchedule();
    schedule2.setDayOfWeek(DayOfWeek.MONDAY);
    schedule2.setStartHour(14L);
    schedule2.setStartMinute(MinuteOfHour.ZERO);
    schedule2.setEndHour(15L);
    schedule2.setEndMinute(MinuteOfHour.THIRTY);
    FeedItemScheduling scheduling = new FeedItemScheduling();
    scheduling.getSchedules().addAll(Arrays.asList(schedule1, schedule2));

    FeedItem feedItem = new FeedItem();
    feedItem.setStartDate(DateTimeFormatter.ofPattern("yyyyMMdd").format(LocalDateTime.now()));
    feedItem.setEndDate(DateTimeFormatter.ofPattern("yyyyMMdd").format(LocalDateTime.now().plusMonths(1L)));
    feedItem.setDevicePreference(DevicePreference.SMART_PHONE);
    feedItem.getFeedItemAttribute().add(feedItemAttributeCallPhoneNumber);
    feedItem.setScheduling(scheduling);

    return feedItem;
  }

  /**
   * example Callout FeedItem request.
   *
   * @return FeedItem
   */
  public static FeedItem createExampleCallout() {

    // feedItemAttribute
    SimpleFeedItemAttribute feedItemAttributeCalloutText = new SimpleFeedItemAttribute();
    feedItemAttributeCalloutText.setPlaceholderField(FeedItemPlaceholderField.CALLOUT_TEXT);
    feedItemAttributeCalloutText.setFeedAttributeValue("sample callout text");

    // scheduling
    FeedItemSchedule schedule1 = new FeedItemSchedule();
    schedule1.setDayOfWeek(DayOfWeek.SUNDAY);
    schedule1.setStartHour(14L);
    schedule1.setStartMinute(MinuteOfHour.ZERO);
    schedule1.setEndHour(15L);
    schedule1.setEndMinute(MinuteOfHour.THIRTY);
    FeedItemSchedule schedule2 = new FeedItemSchedule();
    schedule2.setDayOfWeek(DayOfWeek.MONDAY);
    schedule2.setStartHour(14L);
    schedule2.setStartMinute(MinuteOfHour.ZERO);
    schedule2.setEndHour(15L);
    schedule2.setEndMinute(MinuteOfHour.THIRTY);
    FeedItemScheduling scheduling = new FeedItemScheduling();
    scheduling.getSchedules().addAll(Arrays.asList(schedule1, schedule2));

    FeedItem feedItem = new FeedItem();
    feedItem.setStartDate(DateTimeFormatter.ofPattern("yyyyMMdd").format(LocalDateTime.now()));
    feedItem.setEndDate(DateTimeFormatter.ofPattern("yyyyMMdd").format(LocalDateTime.now().plusMonths(1L)));
    feedItem.setDevicePreference(DevicePreference.SMART_PHONE);
    feedItem.getFeedItemAttribute().add(feedItemAttributeCalloutText);
    feedItem.setScheduling(scheduling);

    return feedItem;
  }

  /**
   * example StructuredSnippet FeedItem request.
   *
   * @return FeedItem
   */
  public static FeedItem createExampleStructuredSnippet() {
    // set feedItem
    FeedItem feedItem = new FeedItem();
    feedItem.setStartDate(DateTimeFormatter.ofPattern("yyyyMMdd").format(LocalDateTime.now()));
    feedItem.setEndDate(DateTimeFormatter.ofPattern("yyyyMMdd").format(LocalDateTime.now().plusMonths(1L)));
    feedItem.setDevicePreference(DevicePreference.SMART_PHONE);

    // set feedItemAttribute
    SimpleFeedItemAttribute feedItemAttributeHeader = new SimpleFeedItemAttribute();
    feedItemAttributeHeader.setPlaceholderField(FeedItemPlaceholderField.STRUCTURED_SNIPPET_HEADER);
    feedItemAttributeHeader.setFeedAttributeValue("ブランド");

    MultipleFeedItemAttribute feedItemAttributeValues = new MultipleFeedItemAttribute();
    feedItemAttributeValues.setPlaceholderField(FeedItemPlaceholderField.STRUCTURED_SNIPPET_VALUES);
    FeedAttributeValue feedAttributeValue1 = new FeedAttributeValue();
    feedAttributeValue1.setFeedAttributeValue("SampleBrand1");
    FeedAttributeValue feedAttributeValue2 = new FeedAttributeValue();
    feedAttributeValue2.setFeedAttributeValue("SampleBrand2");
    FeedAttributeValue feedAttributeValue3 = new FeedAttributeValue();
    feedAttributeValue3.setFeedAttributeValue("SampleBrand3");
    feedItemAttributeValues.getFeedAttributeValues().addAll(Arrays.asList(feedAttributeValue1, feedAttributeValue2, feedAttributeValue3));

    feedItem.getFeedItemAttribute().addAll(Arrays.asList(feedItemAttributeHeader, feedItemAttributeValues));

    // set scheduling
    FeedItemSchedule schedule1 = new FeedItemSchedule();
    schedule1.setDayOfWeek(DayOfWeek.SUNDAY);
    schedule1.setStartHour(14L);
    schedule1.setStartMinute(MinuteOfHour.ZERO);
    schedule1.setEndHour(15L);
    schedule1.setEndMinute(MinuteOfHour.THIRTY);
    FeedItemSchedule schedule2 = new FeedItemSchedule();
    schedule2.setDayOfWeek(DayOfWeek.MONDAY);
    schedule2.setStartHour(14L);
    schedule2.setStartMinute(MinuteOfHour.ZERO);
    schedule2.setEndHour(15L);
    schedule2.setEndMinute(MinuteOfHour.THIRTY);
    FeedItemScheduling scheduling = new FeedItemScheduling();
    scheduling.getSchedules().addAll(Arrays.asList(schedule1, schedule2));
    feedItem.setScheduling(scheduling);

    return feedItem;
  }

  /**
   * example feedItem set request.
   *
   * @param feedItems FeedItem
   * @return FeedItems
   */
  public static List<FeedItem> createExampleSetRequest(List<FeedItem> feedItems) {

    List<FeedItem> operands = new ArrayList<>();

    for (FeedItem feedItem : feedItems) {
      FeedItem operand = new FeedItem();
      operand.setFeedItemId(feedItem.getFeedItemId());

      // clear date
      operand.setStartDate("");
      operand.setEndDate("");

      // clear scheduling
      operand.setScheduling(new FeedItemScheduling());

      // clear getTargeting
      if (feedItem.getPlaceholderType().equals(FeedItemPlaceholderType.AD_CUSTOMIZER)) {
        Location location = new Location();
        location.setIsRemove(IsRemove.TRUE);
        operand.setGeoTargeting(location);
      }
      operands.add(operand);
    }
    return operands;
  }

  /**
   * example get request.
   *
   * @param accountId   long
   * @param feedItemIds Long
   * @param feedFolderIds Long
   * @return FeedItemSelector
   */
  public static FeedItemSelector buildExampleGetRequest(long accountId, List<Long> feedItemIds, List<Long> feedFolderIds) {

    // Set Selector
    FeedItemSelector selector = new FeedItemSelector();
    selector.setAccountId(accountId);

    if (feedItemIds.size() > 0) {
      selector.getFeedItemIds().addAll(feedItemIds);
    }

    if (feedFolderIds.size() > 0) {
      selector.getFeedFolderIds().addAll(feedFolderIds);
    }

    selector.getPlaceholderTypes().addAll(Arrays.asList( //
        FeedItemPlaceholderType.QUICKLINK, //
        FeedItemPlaceholderType.CALLEXTENSION, //
        FeedItemPlaceholderType.AD_CUSTOMIZER, //
        FeedItemPlaceholderType.CALLOUT, //
        FeedItemPlaceholderType.STRUCTURED_SNIPPET //
    ));

    selector.getApprovalStatuses().addAll(Arrays.asList( //
        ApprovalStatus.APPROVED, //
        ApprovalStatus.APPROVED_WITH_REVIEW, //
        ApprovalStatus.REVIEW, //
        ApprovalStatus.PRE_DISAPPROVED, //
        ApprovalStatus.POST_DISAPPROVED //
    ));

    Paging feedItemPaging = new Paging();
    feedItemPaging.setStartIndex(1);
    feedItemPaging.setNumberResults(20);
    selector.setPaging(feedItemPaging);

    return selector;
  }

  /**
   * example mutate campaignTargets.
   *
   * @param operation CampaignTargetOperation
   * @return CampaignTargetValues
   */
  public static List<FeedItemValues> mutate(FeedItemOperation operation) throws Exception {

    // Call API
    System.out.println("############################################");
    System.out.println("FeedItemService::mutate(" + operation.getOperator() + ")");
    System.out.println("############################################");

    Holder<FeedItemReturnValue> feedItemReturnValueHolder = new Holder<FeedItemReturnValue>();
    Holder<List<Error>> errorHolder = new Holder<List<Error>>();
    FeedItemServiceInterface feedItemService = SoapUtils.createServiceInterface(FeedItemServiceInterface.class, FeedItemService.class);
    feedItemService.mutate(operation, feedItemReturnValueHolder, errorHolder);

    SoapUtils.checkSoapError(errorHolder, feedItemReturnValueHolder.value.getValues());

    // Response
    return feedItemReturnValueHolder.value.getValues();
  }

  /**
   * Sample Program for FeedItemService GET.
   *
   * @param selector FeedItemSelector
   * @return FeedItemValues
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

    SoapUtils.checkSoapError(errorHolder, feedItemPage.value.getValues());

    // Response
    return feedItemPage.value.getValues();
  }

  /**
   * check & create upper service object.
   *
   * @return ValuesHolder
   */
  private static ValuesHolder setup() throws Exception {
    return AdGroupServiceSample.create();
  }


  /**
   * cleanup service object.
   *
   * @param valuesHolder ValuesHolder
   */
  public static void cleanup(ValuesHolder valuesHolder) throws Exception {
    if (valuesHolder.getFeedItemValuesList().size() > 0) {
      ValuesRepositoryFacade valuesRepositoryFacade = new ValuesRepositoryFacade(valuesHolder);
      FeedItemOperation removeRequest =
          buildExampleMutateRequest(Operator.REMOVE, SoapUtils.getAccountId(), FeedItemPlaceholderType.QUICKLINK, valuesRepositoryFacade.getFeedItemValuesRepository().getFeedItems());
      mutate(removeRequest);
    }
    AdGroupServiceSample.cleanup(valuesHolder);
  }

  /**
   * create basic FeedItem.
   *
   * @return ValuesHolder
   */
  public static ValuesHolder create() throws Exception {

    ValuesHolder parentValuesHolder = setup();
    long accountId = SoapUtils.getAccountId();

    FeedItemOperation addRequestQuicklink = buildExampleMutateRequest( //
        Operator.ADD, accountId, FeedItemPlaceholderType.QUICKLINK, Collections.singletonList(createExampleQuicklink()) //
    );

    List<FeedItemValues> addResponseQuicklink = mutate(addRequestQuicklink);

    ValuesHolder selfValuesHolder = new ValuesHolder();
    selfValuesHolder.setBiddingStrategyValuesList(parentValuesHolder.getBiddingStrategyValuesList());
    selfValuesHolder.setFeedFolderValuesList(parentValuesHolder.getFeedFolderValuesList());
    selfValuesHolder.setCampaignValuesList(parentValuesHolder.getCampaignValuesList());
    selfValuesHolder.setAdGroupValuesList(parentValuesHolder.getAdGroupValuesList());
    selfValuesHolder.setFeedItemValuesList(addResponseQuicklink);

    return selfValuesHolder;
  }

}

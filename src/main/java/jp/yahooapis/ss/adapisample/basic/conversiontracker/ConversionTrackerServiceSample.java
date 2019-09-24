/**
 * Copyright (C) 2019 Yahoo Japan Corporation. All Rights Reserved.
 */
package jp.yahooapis.ss.adapisample.basic.conversiontracker;

import jp.yahooapis.ss.adapisample.util.SoapUtils;
import jp.yahooapis.ss.v201909.Error;
import jp.yahooapis.ss.v201909.Paging;
import jp.yahooapis.ss.v201909.conversiontracker.AppConversion;
import jp.yahooapis.ss.v201909.conversiontracker.AppConversionType;
import jp.yahooapis.ss.v201909.conversiontracker.AppPlatform;
import jp.yahooapis.ss.v201909.conversiontracker.AppPostbackUrl;
import jp.yahooapis.ss.v201909.conversiontracker.AppPostbackUrlClearFlag;
import jp.yahooapis.ss.v201909.conversiontracker.ConversionCountingType;
import jp.yahooapis.ss.v201909.conversiontracker.ConversionTracker;
import jp.yahooapis.ss.v201909.conversiontracker.ConversionTrackerCategory;
import jp.yahooapis.ss.v201909.conversiontracker.ConversionTrackerOperation;
import jp.yahooapis.ss.v201909.conversiontracker.ConversionTrackerPage;
import jp.yahooapis.ss.v201909.conversiontracker.ConversionTrackerReturnValue;
import jp.yahooapis.ss.v201909.conversiontracker.ConversionTrackerSelector;
import jp.yahooapis.ss.v201909.conversiontracker.ConversionTrackerService;
import jp.yahooapis.ss.v201909.conversiontracker.ConversionTrackerServiceInterface;
import jp.yahooapis.ss.v201909.conversiontracker.ConversionTrackerStatus;
import jp.yahooapis.ss.v201909.conversiontracker.ConversionTrackerType;
import jp.yahooapis.ss.v201909.conversiontracker.ConversionTrackerValues;
import jp.yahooapis.ss.v201909.conversiontracker.ExcludeFromBidding;
import jp.yahooapis.ss.v201909.conversiontracker.MarkupLanguage;
import jp.yahooapis.ss.v201909.conversiontracker.Operator;
import jp.yahooapis.ss.v201909.conversiontracker.TrackingCodeType;
import jp.yahooapis.ss.v201909.conversiontracker.WebConversion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.xml.ws.Holder;

/**
 * example ConversionTrackerService operation and Utility method collection.
 */
public class ConversionTrackerServiceSample {

  /**
   * example CampaignService operation.
   *
   * @param args command line arguments
   * @throws Exception
   */

  public static void main(String[] args) throws Exception {

    try {
      // =================================================================
      // Setup
      // =================================================================
      long accountId = SoapUtils.getAccountId();
      // create request.
      AppPostbackUrl appPostbackUrl = new AppPostbackUrl();
      appPostbackUrl.setUrl("http://yahoo.co.jp?advertising_id={adid}&lat={lat}");

      ConversionTrackerOperation addOperation = buildExampleMutateRequest(
          Operator.ADD,
          accountId,
          Arrays.asList(
            createWebConversionRequest(),
            createAppConversionRequest(
              ConversionCountingType.ONE_PER_CLICK,
              ConversionTrackerCategory.DOWNLOAD,
              AppConversionType.DOWNLOAD
            )
          )
      );

      // run
      List<ConversionTrackerValues> addConversionTrackerValuesList = mutate(addOperation);

      List<ConversionTracker> conversionTrackers = new ArrayList<>();
      List<Long> conversionTrackerIds = new ArrayList<>();
      for (ConversionTrackerValues values : addConversionTrackerValuesList) {
        conversionTrackers.add(values.getConversionTracker());
        conversionTrackerIds.add(values.getConversionTracker().getConversionTrackerId());
      }


      // =================================================================
      // ConversionTrackerService::get
      // =================================================================
      // create request.
      ConversionTrackerSelector selector = buildExampleGetRequest(accountId, conversionTrackerIds);

      // run
      List<ConversionTrackerValues> getConversionTrackerValuesList = get(selector);

      //waiting
      Thread.sleep(180000);

      // =================================================================
      // ConversionTrackerService::mutate(SET)
      // =================================================================
      // create request.
      ConversionTrackerOperation setOperation = buildExampleMutateRequest(
          Operator.SET,
          accountId,
          createExampleSetRequest(conversionTrackers)
      );

      // run
      mutate(setOperation);

    } catch (Exception e) {
      e.printStackTrace();
      throw e;
    }
  }

  /**
   * example conversionTracker set request.
   *
   * @param conversionTrackers List<ConversionTracker>
   * @return List<ConversionTracker>
   */
  public static List<ConversionTracker> createExampleSetRequest(List<ConversionTracker> conversionTrackers) {
    List<ConversionTracker> operands = new ArrayList<>();
    for (ConversionTracker conversionTracker : conversionTrackers) {
      switch (conversionTracker.getConversionTrackerType()) {
        default:
        case WEB_CONVERSION:
          WebConversion webConversion = new WebConversion();
          webConversion.setConversionTrackerId(conversionTracker.getConversionTrackerId());
          webConversion.setConversionTrackerType(conversionTracker.getConversionTrackerType());
          webConversion.setConversionTrackerName("SampleWebConversionTracker_UpdateOn_" + conversionTracker.getConversionTrackerId() + "_" + SoapUtils.getCurrentTimestamp());
          webConversion.setStatus(ConversionTrackerStatus.DISABLED);
          operands.add(webConversion);
          break;
        case APP_CONVERSION:
          AppConversion appConversion = new AppConversion();
          AppConversion appConversionTracker = (AppConversion) conversionTracker;
          appConversion.setConversionTrackerId(conversionTracker.getConversionTrackerId());
          appConversion.setConversionTrackerType(conversionTracker.getConversionTrackerType());
          appConversion.setConversionTrackerName("SampleAppConversionTracker_"
              + appConversionTracker.getCategory() + "_"
              + appConversionTracker.getAppConversionType() + "_"
              + appConversionTracker.getConversionTrackerId() + "_"
              + "_UpdateOn_" + SoapUtils.getCurrentTimestamp());
          appConversion.setStatus(ConversionTrackerStatus.DISABLED);

          switch (appConversionTracker.getAppConversionType()) {
            default:
            case DOWNLOAD:
              break;
            case FIRST_OPEN:
              AppPostbackUrl appPostbackUrl = new AppPostbackUrl();
              appPostbackUrl.setClearFlag(AppPostbackUrlClearFlag.TRUE);
              appConversion.setAppPostbackUrl(appPostbackUrl);
              break;
            case IN_APP_PURCHASE:
              appConversion.setCategory(ConversionTrackerCategory.PURCHASE);
              appConversion.setUserRevenueValue("300");
              break;
          }
          operands.add(appConversion);
          break;
      }
    }
    return operands;
  }

  /**
   * example get request.
   *
   * @param accountId long
   * @param conversionTrackerIds List<Long>
   * @return ConversionTrackerSelector
   */
  public static ConversionTrackerSelector buildExampleGetRequest(long accountId, List<Long> conversionTrackerIds) {
    ConversionTrackerSelector selector = new ConversionTrackerSelector();
    selector.setAccountId(accountId);
    selector.getConversionTrackerIds().addAll(conversionTrackerIds);
    selector.getConversionTrackerTypes().add(ConversionTrackerType.WEB_CONVERSION);
    selector.getConversionTrackerTypes().add(ConversionTrackerType.APP_CONVERSION);
    Paging paging = new Paging();
    paging.setStartIndex(1);
    paging.setNumberResults(20);
    selector.setPaging(paging);
    return selector;
  }

  /**
   * example mutate request.
   *
   * @param operator Operator
   * @param accountId long
   * @param conversionTrackers List<ConversionTracker>
   * @return ConversionTrackerOperation
   */
  public static ConversionTrackerOperation buildExampleMutateRequest(Operator operator, long accountId, List<ConversionTracker> conversionTrackers) {
    ConversionTrackerOperation operation = new ConversionTrackerOperation();
    operation.setAccountId(accountId);
    operation.setOperator(operator);
    operation.getOperand().addAll(conversionTrackers);
    return operation;
  }

  /**
   * example AppConversion request.
   *
   * @param countingType ConversionCountingType
   * @param category ConversionTrackerCategory
   * @param appConversionType AppConversionType
   * @return AppConversion
   */
  public static AppConversion createAppConversionRequest(ConversionCountingType countingType, ConversionTrackerCategory category, AppConversionType appConversionType) {
    AppConversion appConversion = new AppConversion();
    appConversion.setConversionTrackerName("SampleAppConversionTracker_" + category + "_" + appConversionType + "_CreateOn_" + SoapUtils.getCurrentTimestamp());
    appConversion.setStatus(ConversionTrackerStatus.ENABLED);
    appConversion.setCategory(category);
    appConversion.setConversionTrackerType(ConversionTrackerType.APP_CONVERSION);
    appConversion.setUserRevenueValue("100");
    appConversion.setCountingType(countingType);
    appConversion.setExcludeFromBidding(ExcludeFromBidding.TRUE);
    appConversion.setMeasurementPeriod(90);
    appConversion.setAppId("sample123_" + SoapUtils.getCurrentTimestamp());
    appConversion.setAppPlatform(AppPlatform.ANDROID_MARKET);
    appConversion.setAppConversionType(appConversionType);
    return appConversion;
  }

  /**
   * example WebConversion request.
   *
   * @return WebConversion
   */
  public static WebConversion createWebConversionRequest() {
    WebConversion webConversion = new WebConversion();
    webConversion.setConversionTrackerName("SampleWebConversionTracker_CreateOn_" + SoapUtils.getCurrentTimestamp());
    webConversion.setStatus(ConversionTrackerStatus.ENABLED);
    webConversion.setCategory(ConversionTrackerCategory.DEFAULT);
    webConversion.setConversionTrackerType(ConversionTrackerType.WEB_CONVERSION);
    webConversion.setUserRevenueValue("100");
    webConversion.setCountingType(ConversionCountingType.MANY_PER_CLICK);
    webConversion.setExcludeFromBidding(ExcludeFromBidding.TRUE);
    webConversion.setMeasurementPeriod(90);
    webConversion.setMarkupLanguage(MarkupLanguage.HTML);
    webConversion.setTrackingCodeType(TrackingCodeType.CLICK_TO_CALL);
    return webConversion;
  }

  /**
   * example mutate conversions.
   *
   * @param operation ConversionTrackerOperation
   * @return List<ConversionTrackerValues>
   * @throws Exception
   */
  public static List<ConversionTrackerValues> mutate(ConversionTrackerOperation operation) throws Exception {

    // call API
    System.out.println("############################################");
    System.out.println("ConversionTrackerService::mutate("+ operation.getOperator() +")");
    System.out.println("############################################");

    Holder<ConversionTrackerReturnValue> conversionTrackerReturnValueHolder = new Holder<ConversionTrackerReturnValue>();
    Holder<List<Error>> errorHolder = new Holder<List<Error>>();
    ConversionTrackerServiceInterface conversionTrackerService = SoapUtils.createServiceInterface(ConversionTrackerServiceInterface.class, ConversionTrackerService.class);
    conversionTrackerService.mutate(operation, conversionTrackerReturnValueHolder, errorHolder);

    SoapUtils.checkSoapError(errorHolder, conversionTrackerReturnValueHolder.value.getValues());

    // Response
    return conversionTrackerReturnValueHolder.value.getValues();
  }

  /**
   * example get conversions.
   *
   * @param selector ConversionTrackerSelector
   * @return List<ConversionTrackerValues>
   * @throws Exception
   */
  public static List<ConversionTrackerValues> get(ConversionTrackerSelector selector) throws Exception {

    // call API
    System.out.println("############################################");
    System.out.println("ConversionTrackerService::get");
    System.out.println("############################################");

    Holder<ConversionTrackerPage> conversionTrackerPageHolder = new Holder<ConversionTrackerPage>();
    Holder<List<Error>> errorHolder = new Holder<List<Error>>();
    ConversionTrackerServiceInterface conversionTrackerService = SoapUtils.createServiceInterface(ConversionTrackerServiceInterface.class, ConversionTrackerService.class);
    conversionTrackerService.get(selector, conversionTrackerPageHolder, errorHolder);

    SoapUtils.checkSoapError(errorHolder, conversionTrackerPageHolder.value.getValues());

    // Response
    return conversionTrackerPageHolder.value.getValues();
  }
}

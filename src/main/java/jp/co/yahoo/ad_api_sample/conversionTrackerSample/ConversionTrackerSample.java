package jp.co.yahoo.ad_api_sample.conversionTrackerSample;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import javax.xml.ws.Holder;

import jp.co.yahoo.ad_api_sample.error.impl.ConversionTrackerServiceErrorEntityFactory;
import jp.co.yahoo.ad_api_sample.util.SoapUtils;
import jp.yahooapis.ss.V5.ConversionTrackerService.AppConversion;
import jp.yahooapis.ss.V5.ConversionTrackerService.AppConversionType;
import jp.yahooapis.ss.V5.ConversionTrackerService.AppPlatform;
import jp.yahooapis.ss.V5.ConversionTrackerService.AppPostbackUrl;
import jp.yahooapis.ss.V5.ConversionTrackerService.AppPostbackUrlClearFlag;
import jp.yahooapis.ss.V5.ConversionTrackerService.ConversionDateRange;
import jp.yahooapis.ss.V5.ConversionTrackerService.ConversionTracker;
import jp.yahooapis.ss.V5.ConversionTrackerService.ConversionTrackerCategory;
import jp.yahooapis.ss.V5.ConversionTrackerService.ConversionTrackerOperation;
import jp.yahooapis.ss.V5.ConversionTrackerService.ConversionTrackerPage;
import jp.yahooapis.ss.V5.ConversionTrackerService.ConversionTrackerReturnValue;
import jp.yahooapis.ss.V5.ConversionTrackerService.ConversionTrackerSelector;
import jp.yahooapis.ss.V5.ConversionTrackerService.ConversionTrackerService;
import jp.yahooapis.ss.V5.ConversionTrackerService.ConversionTrackerServiceInterface;
import jp.yahooapis.ss.V5.ConversionTrackerService.ConversionTrackerStatus;
import jp.yahooapis.ss.V5.ConversionTrackerService.ConversionTrackerType;
import jp.yahooapis.ss.V5.ConversionTrackerService.ConversionTrackerValues;
import jp.yahooapis.ss.V5.ConversionTrackerService.Error;
import jp.yahooapis.ss.V5.ConversionTrackerService.HttpProtocol;
import jp.yahooapis.ss.V5.ConversionTrackerService.MarkupLanguage;
import jp.yahooapis.ss.V5.ConversionTrackerService.Operator;
import jp.yahooapis.ss.V5.ConversionTrackerService.Paging;
import jp.yahooapis.ss.V5.ConversionTrackerService.TrackingCodeType;
import jp.yahooapis.ss.V5.ConversionTrackerService.WebConversion;


/**
 * Sample Program for ConversionTrackerService. Copyright (C) 2012 Yahoo Japan Corporation. All
 * Rights Reserved.
 */
public class ConversionTrackerSample {

  /**
   * main method for ConversionTrackerSample
   *
   * @param args command line arguments
   */
  public static void main(String[] args) throws Exception {
    try {
      // =================================================================
      // Setting
      // =================================================================
      long accountId = SoapUtils.getAccountId();
      String appId = SoapUtils.getAppId();

      // =================================================================
      // ConversionTrackerService::mutate(ADD)
      // =================================================================
      // Set Operation
      // AppConversionTracker(DOWNLOAD)
      AppConversion appConversion1 = new AppConversion();
      appConversion1.setAppId(appId);
      appConversion1.setAppPlatform(AppPlatform.ANDROID_MARKET);
      appConversion1.setAppConversionType(AppConversionType.DOWNLOAD);
      appConversion1.setAccountId(accountId);
      appConversion1.setConversionTrackerName("SampleAppConversionTracker1_CreateOn_" + SoapUtils.getCurrentTimestamp());
      appConversion1.setStatus(ConversionTrackerStatus.ENABLED);
      appConversion1.setCategory(ConversionTrackerCategory.DOWNLOAD);
      appConversion1.setConversionTrackerType(ConversionTrackerType.APP_CONVERSION);
      appConversion1.setUserRevenueValue("100");

      // AppConversionTracker(FIRST_OPEN)
      AppConversion appConversion2 = new AppConversion();
      appConversion2.setAppId(appId);
      appConversion2.setAppPlatform(AppPlatform.ANDROID_MARKET);
      appConversion2.setAppConversionType(AppConversionType.FIRST_OPEN);
      appConversion2.setAccountId(accountId);
      appConversion2.setConversionTrackerName("SampleAppConversionTracker2_CreateOn_" + SoapUtils.getCurrentTimestamp());
      appConversion2.setStatus(ConversionTrackerStatus.ENABLED);
      appConversion2.setCategory(ConversionTrackerCategory.DOWNLOAD);
      appConversion2.setConversionTrackerType(ConversionTrackerType.APP_CONVERSION);
      appConversion2.setUserRevenueValue("100");
      AppPostbackUrl appPostbackUrl = new AppPostbackUrl();
      appPostbackUrl.setUrl("http://yahoo.co.jp?advertising_id={adid}&lat={lat}");
      appConversion2.setAppPostbackUrl(appPostbackUrl);

      // AppConversionTracker(IN_APP_PURCHASE)
      AppConversion appConversion3 = new AppConversion();
      appConversion3.setAppPlatform(AppPlatform.ANDROID_MARKET);
      appConversion3.setAppConversionType(AppConversionType.IN_APP_PURCHASE);
      appConversion3.setAccountId(accountId);
      appConversion3.setConversionTrackerName("SampleAppConversionTracker3_CreateOn_" + SoapUtils.getCurrentTimestamp());
      appConversion3.setStatus(ConversionTrackerStatus.ENABLED);
      appConversion3.setCategory(ConversionTrackerCategory.DEFAULT);
      appConversion3.setConversionTrackerType(ConversionTrackerType.APP_CONVERSION);
      appConversion3.setUserRevenueValue("100");

      // WebConversionTracker
      WebConversion webConversion = new WebConversion();
      webConversion.setMarkupLanguage(MarkupLanguage.HTML);
      webConversion.setHttpProtocol(HttpProtocol.HTTPS);
      webConversion.setTrackingCodeType(TrackingCodeType.CLICK_TO_CALL);
      webConversion.setAccountId(accountId);
      webConversion.setConversionTrackerName("SampleWebConversionTracker_CreateOn_" + SoapUtils.getCurrentTimestamp());
      webConversion.setStatus(ConversionTrackerStatus.ENABLED);
      webConversion.setCategory(ConversionTrackerCategory.DEFAULT);
      webConversion.setConversionTrackerType(ConversionTrackerType.WEB_CONVERSION);
      webConversion.setUserRevenueValue("100");

      ConversionTrackerOperation addOperation = new ConversionTrackerOperation();
      addOperation.setOperator(Operator.ADD);
      addOperation.setAccountId(accountId);
      addOperation.getOperand().add(appConversion1);
      addOperation.getOperand().add(appConversion2);
      addOperation.getOperand().add(appConversion3);
      addOperation.getOperand().add(webConversion);

      // Run
      List<ConversionTrackerValues> addResponse = add(addOperation);

      // =================================================================
      // ConversionTrackerService::get
      // =================================================================
      // Set Selector
      ConversionTrackerSelector selector = new ConversionTrackerSelector();
      selector.setAccountId(accountId);
      for (ConversionTrackerValues conversionTrackerValue : addResponse) {
        selector.getConversionTrackerIds().add(conversionTrackerValue.getConversionTracker().getConversionTrackerId());
      }
      selector.getStatuses().add(ConversionTrackerStatus.ENABLED);
      selector.getCategories().add(ConversionTrackerCategory.DEFAULT);
      selector.getCategories().add(ConversionTrackerCategory.DOWNLOAD);
      selector.setDateRange(createConversionDateRange());
      Paging paging = new Paging();
      paging.setStartIndex(1);
      paging.setNumberResults(20);
      selector.setPaging(paging);

      // Run
      List<ConversionTrackerValues> getResponse = get(selector);

      // =================================================================
      // ConversionTrackerService::mutate(SET)
      // =================================================================
      // Set Operation
      // AppConversionTracker(DOWNLOAD)
      AppConversion setAppConversion1 = new AppConversion();
      setAppConversion1.setAccountId(accountId);
      setAppConversion1.setConversionTrackerName("SampleAppConversionTracker1_UpdateOn_" + SoapUtils.getCurrentTimestamp());
      setAppConversion1.setStatus(ConversionTrackerStatus.DISABLED);
      setAppConversion1.setConversionTrackerType(ConversionTrackerType.APP_CONVERSION);

      // AppConversionTracker(FIRST_OPEN)
      AppConversion setAppConversion2 = new AppConversion();
      setAppConversion2.setAccountId(accountId);
      setAppConversion2.setConversionTrackerName("SampleAppConversionTracker2_UpdateOn_" + SoapUtils.getCurrentTimestamp());
      setAppConversion2.setStatus(ConversionTrackerStatus.DISABLED);
      setAppConversion2.setConversionTrackerType(ConversionTrackerType.APP_CONVERSION);
      AppPostbackUrl setAppPostbackUrl = new AppPostbackUrl();
      setAppPostbackUrl.setClearFlag(AppPostbackUrlClearFlag.TRUE);
      setAppConversion2.setAppPostbackUrl(setAppPostbackUrl);

      // AppConversionTracker(IN_APP_PURCHASE)
      AppConversion setAppConversion3 = new AppConversion();
      setAppConversion3.setAccountId(accountId);
      setAppConversion3.setConversionTrackerName("SampleAppConversionTracker3_UpdateOn_" + SoapUtils.getCurrentTimestamp());
      setAppConversion3.setCategory(ConversionTrackerCategory.PURCHASE);
      setAppConversion3.setStatus(ConversionTrackerStatus.DISABLED);
      setAppConversion3.setConversionTrackerType(ConversionTrackerType.APP_CONVERSION);
      setAppConversion3.setUserRevenueValue("300");

      // WebConversionTracker
      WebConversion setWebConversion = new WebConversion();
      setWebConversion.setAccountId(accountId);
      setWebConversion.setConversionTrackerName("SampleWebConversionTracker_UpdateOn_" + SoapUtils.getCurrentTimestamp());
      setWebConversion.setCategory(ConversionTrackerCategory.DEFAULT);
      setWebConversion.setStatus(ConversionTrackerStatus.DISABLED);
      setWebConversion.setConversionTrackerType(ConversionTrackerType.WEB_CONVERSION);

      // set conversionTrackerId
      for (ConversionTrackerValues conversionTrackerValues : getResponse) {
        switch (conversionTrackerValues.getConversionTracker().getConversionTrackerType()) {
          case APP_CONVERSION:
            switch (((AppConversion)conversionTrackerValues.getConversionTracker()).getAppConversionType()) {
              case DOWNLOAD:
                setAppConversion1.setConversionTrackerId(conversionTrackerValues.getConversionTracker().getConversionTrackerId());
                break;
              case FIRST_OPEN:
                setAppConversion2.setConversionTrackerId(conversionTrackerValues.getConversionTracker().getConversionTrackerId());
                break;
              case IN_APP_PURCHASE:
                setAppConversion3.setConversionTrackerId(conversionTrackerValues.getConversionTracker().getConversionTrackerId());
                break;
              default:
                break;
            }
            break;
          case WEB_CONVERSION:
            setWebConversion.setConversionTrackerId(conversionTrackerValues.getConversionTracker().getConversionTrackerId());
            break;
          default:
            break;
        }
      }

      ConversionTrackerOperation setOperation = new ConversionTrackerOperation();
      setOperation.setOperator(Operator.SET);
      setOperation.setAccountId(accountId);
      setOperation.getOperand().add(setAppConversion1);
      setOperation.getOperand().add(setAppConversion2);
      setOperation.getOperand().add(setAppConversion3);
      setOperation.getOperand().add(setWebConversion);

      // Run
      set(setOperation);

    } catch (Exception e) {
      e.printStackTrace();
      throw e;
    }
  }

  /**
   * Sample Program for ConversionTrackerService ADD.
   *
   * @param operation ConversionTrackerOperation
   * @return ConversionTrackerValues
   * @throws Exception
   */
  public static List<ConversionTrackerValues> add(ConversionTrackerOperation operation) throws Exception {

    // call API
    System.out.println("############################################");
    System.out.println("ConversionTrackerService::mutate(ADD)");
    System.out.println("############################################");

    Holder<ConversionTrackerReturnValue> addConversionTrackerReturnValueHolder = new Holder<ConversionTrackerReturnValue>();
    Holder<List<Error>> addErrorArrayHolder = new Holder<List<Error>>();
    ConversionTrackerServiceInterface conversionTrackerService = SoapUtils.createServiceInterface(ConversionTrackerServiceInterface.class, ConversionTrackerService.class);
    conversionTrackerService.mutate(operation, addConversionTrackerReturnValueHolder, addErrorArrayHolder);

    // Error
    if (addErrorArrayHolder.value != null && addErrorArrayHolder.value.size() > 0) {
      SoapUtils.displayErrors(new ConversionTrackerServiceErrorEntityFactory(addErrorArrayHolder.value), true);
    }
    if (addErrorArrayHolder.value == null) {
      throw new Exception("NoDataResponse:ConversionTrackerService mutate(ADD)");
    }

    // Display
    if (addConversionTrackerReturnValueHolder.value != null) {
      if (addConversionTrackerReturnValueHolder.value.getValues() != null) {
        for (ConversionTrackerValues values : addConversionTrackerReturnValueHolder.value.getValues()) {
          if (values.isOperationSucceeded()) {
            display(values.getConversionTracker());
          } else {
            SoapUtils.displayErrors(new ConversionTrackerServiceErrorEntityFactory(values.getError()), true);
          }
        }
      }
    }

    // Response
    return addConversionTrackerReturnValueHolder.value.getValues();
  }

  /**
   * Sample Program for ConversionTrackerService SET.
   *
   * @param operation ConversionTrackerOperation
   * @return ConversionTrackerValues
   * @throws Exception
   */
  public static List<ConversionTrackerValues> set(ConversionTrackerOperation operation) throws Exception {

    // call API
    System.out.println("############################################");
    System.out.println("ConversionTrackerService::mutate(SET)");
    System.out.println("############################################");

    Holder<ConversionTrackerReturnValue> setConversionTrackerReturnValueHolder = new Holder<ConversionTrackerReturnValue>();
    Holder<List<Error>> setErrorArrayHolder = new Holder<List<Error>>();
    ConversionTrackerServiceInterface conversionTrackerService = SoapUtils.createServiceInterface(ConversionTrackerServiceInterface.class, ConversionTrackerService.class);
    conversionTrackerService.mutate(operation, setConversionTrackerReturnValueHolder, setErrorArrayHolder);

    // Error
    if (setErrorArrayHolder.value != null && setErrorArrayHolder.value.size() > 0) {
      SoapUtils.displayErrors(new ConversionTrackerServiceErrorEntityFactory(setErrorArrayHolder.value), true);
    }
    if (setErrorArrayHolder.value == null) {
      throw new Exception("NoDataResponse:ConversionTrackerService mutate(SET)");
    }

    // Display
    if (setConversionTrackerReturnValueHolder.value != null) {
      if (setConversionTrackerReturnValueHolder.value.getValues() != null) {
        for (ConversionTrackerValues values : setConversionTrackerReturnValueHolder.value.getValues()) {
          if (values.isOperationSucceeded()) {
            display(values.getConversionTracker());
          } else {
            SoapUtils.displayErrors(new ConversionTrackerServiceErrorEntityFactory(values.getError()), true);
          }
        }
      }
    }

    // Response
    return setConversionTrackerReturnValueHolder.value.getValues();
  }

  /**
   * Sample Program for ConversionTrackerService GET.
   *
   * @param selector ConversionTrackerSelector
   * @return ConversionTrackerValues
   * @throws Exception
   */
  public static List<ConversionTrackerValues> get(ConversionTrackerSelector selector) throws Exception {

    // call API
    System.out.println("############################################");
    System.out.println("ConversionTrackerService::get");
    System.out.println("############################################");

    Holder<ConversionTrackerPage> conversionTrackerPageHolder = new Holder<ConversionTrackerPage>();
    Holder<List<Error>> getErrorArrayHolder = new Holder<List<Error>>();
    ConversionTrackerServiceInterface conversionTrackerService = SoapUtils.createServiceInterface(ConversionTrackerServiceInterface.class, ConversionTrackerService.class);
    conversionTrackerService.get(selector, conversionTrackerPageHolder, getErrorArrayHolder);

    // Error
    if (getErrorArrayHolder.value != null && getErrorArrayHolder.value.size() > 0) {
      SoapUtils.displayErrors(new ConversionTrackerServiceErrorEntityFactory(getErrorArrayHolder.value), true);
    }
    if (getErrorArrayHolder.value == null) {
      throw new Exception("NoDataResponse:ConversionTrackerService Get");
    }

    // Display
    if (conversionTrackerPageHolder.value != null) {
      if (conversionTrackerPageHolder.value.getValues() != null) {
        for (ConversionTrackerValues values : conversionTrackerPageHolder.value.getValues()) {
          if (values.isOperationSucceeded()) {
            display(values.getConversionTracker());
          } else {
            SoapUtils.displayErrors(new ConversionTrackerServiceErrorEntityFactory(values.getError()), true);
          }
        }
      }
    }

    // Response
    return conversionTrackerPageHolder.value.getValues();
  }

  /**
   * createConversionDateRange
   *
   * @return ConversionDateRange
   */
  public static ConversionDateRange createConversionDateRange() {
    SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
    Calendar today = Calendar.getInstance();
    today.add(Calendar.DATE, 10);

    ConversionDateRange conversionDateRange = new ConversionDateRange();
    conversionDateRange.setStartDate(format.format(Calendar.getInstance().getTime()));
    conversionDateRange.setEndDate(format.format(today.getTime()));
    return conversionDateRange;
  }

  /**
   * * display ConversionTracker entity to stdout.
   *
   * @param conversionTracker ConversionTracker entity for display.
   */
  private static void display(ConversionTracker conversionTracker) {
    System.out.println("accountId = " + conversionTracker.getAccountId());
    System.out.println("conversionTrackerId = " + conversionTracker.getConversionTrackerId());
    System.out.println("conversionTrackerName = " + conversionTracker.getConversionTrackerName());
    System.out.println("status = " + conversionTracker.getStatus());
    System.out.println("category = " + conversionTracker.getCategory());
    System.out.println("numConversionEvents = " + conversionTracker.getNumConversionEvents());
    System.out.println("conversionValue = " + conversionTracker.getConversionValue());
    System.out.println("mostRecentConversionDate = " + conversionTracker.getMostRecentConversionDate());
    System.out.println("numConvertedClicks = " + conversionTracker.getNumConvertedClicks());
    System.out.println("conversionTrackerType = " + conversionTracker.getConversionTrackerType());
    System.out.println("userRevenueValue = " + conversionTracker.getUserRevenueValue());

    if (conversionTracker instanceof WebConversion) {
      WebConversion webConversion = (WebConversion) conversionTracker;
      System.out.println("snippet = " + webConversion.getSnippet());
      System.out.println("markupLanguage = " + webConversion.getMarkupLanguage());
      System.out.println("httpProtocol = " + webConversion.getHttpProtocol());
      System.out.println("trackingCodeType = " + webConversion.getTrackingCodeType());

    } if (conversionTracker instanceof AppConversion) {
      AppConversion appConversion = (AppConversion) conversionTracker;
      System.out.println("appId = " + appConversion.getAppId());
      System.out.println("appPlatform = " + appConversion.getAppPlatform());
      System.out.println("appConversionType = " + appConversion.getAppConversionType());
      System.out.println("snippetId = " + appConversion.getSnippetId());
      System.out.println("snippetLabel = " + appConversion.getSnippetLabel());
      if (appConversion.getAppPostbackUrl() != null) {
        System.out.println("appPostbackUrl/url = " + appConversion.getAppPostbackUrl().getUrl());
        System.out.println("appPostbackUrl/clearFlag = " + appConversion.getAppPostbackUrl().getClearFlag());
      }
    }

    System.out.println("---------");
  }
}

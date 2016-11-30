package jp.co.yahoo.ad_api_sample.conversionTrackerSample;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNull.notNullValue;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;

import java.util.Arrays;
import java.util.List;

import jp.co.yahoo.ad_api_sample.util.SoapUtils;
import jp.yahooapis.ss.V6.ConversionTrackerService.AppConversion;
import jp.yahooapis.ss.V6.ConversionTrackerService.AppConversionType;
import jp.yahooapis.ss.V6.ConversionTrackerService.AppPlatform;
import jp.yahooapis.ss.V6.ConversionTrackerService.ConversionCountingType;
import jp.yahooapis.ss.V6.ConversionTrackerService.ConversionTrackerCategory;
import jp.yahooapis.ss.V6.ConversionTrackerService.ConversionTrackerOperation;
import jp.yahooapis.ss.V6.ConversionTrackerService.ConversionTrackerSelector;
import jp.yahooapis.ss.V6.ConversionTrackerService.ConversionTrackerStatus;
import jp.yahooapis.ss.V6.ConversionTrackerService.ConversionTrackerType;
import jp.yahooapis.ss.V6.ConversionTrackerService.ConversionTrackerValues;
import jp.yahooapis.ss.V6.ConversionTrackerService.ExcludeFromBidding;
import jp.yahooapis.ss.V6.ConversionTrackerService.MarkupLanguage;
import jp.yahooapis.ss.V6.ConversionTrackerService.Operator;
import jp.yahooapis.ss.V6.ConversionTrackerService.Paging;
import jp.yahooapis.ss.V6.ConversionTrackerService.TrackingCodeType;
import jp.yahooapis.ss.V6.ConversionTrackerService.WebConversion;

import org.junit.Before;
import org.junit.Test;

/**
 * Sample TestCase for ConversionTrackerSampleTest. Copyright (C) 2012 Yahoo Japan Corporation. All
 * Rights Reserved.
 */
public class ConversionTrackerSampleTest {

  /**
   * Setting
   */
  private long accountId;

  @Before
  public void setup() {
    accountId = SoapUtils.getAccountId();
  }

  /**
   * Sample TestCase of main method for ConversionTrackerSample.
   */
  @Test
  public void testMain() throws Exception {
    // Run
    try {
      ConversionTrackerSample.main(null);
    } catch (Exception e) {
      fail();
    }
  }

  /**
   * Sample TestCase of add method for ConversionTrackerSample.
   */
  @Test
  public void testAdd() throws Exception {
    // Set Operation
    // AppConversionTracker
    AppConversion appConversion = new AppConversion();
    appConversion.setAppId("appid" + SoapUtils.getCurrentTimestamp());
    appConversion.setAppPlatform(AppPlatform.ANDROID_MARKET);
    appConversion.setAppConversionType(AppConversionType.DOWNLOAD);
    appConversion.setAccountId(accountId);
    appConversion.setConversionTrackerName("SampleAppConversionTracker_CreateOn_" + SoapUtils.getCurrentTimestamp());
    appConversion.setStatus(ConversionTrackerStatus.ENABLED);
    appConversion.setCategory(ConversionTrackerCategory.DOWNLOAD);
    appConversion.setConversionTrackerType(ConversionTrackerType.APP_CONVERSION);
    appConversion.setUserRevenueValue("100");
    appConversion.setCountingType(ConversionCountingType.ONE_PER_CLICK);
    appConversion.setExcludeFromBidding(ExcludeFromBidding.FALSE);
    appConversion.setMeasurementPeriod(30);

    // WebConversionTracker
    WebConversion webConversion = new WebConversion();
    webConversion.setMarkupLanguage(MarkupLanguage.HTML);
    webConversion.setTrackingCodeType(TrackingCodeType.CLICK_TO_CALL);
    webConversion.setAccountId(accountId);
    webConversion.setConversionTrackerName("SampleWebConversionTracker_CreateOn_" + SoapUtils.getCurrentTimestamp());
    webConversion.setStatus(ConversionTrackerStatus.ENABLED);
    webConversion.setCategory(ConversionTrackerCategory.DEFAULT);
    webConversion.setConversionTrackerType(ConversionTrackerType.WEB_CONVERSION);
    webConversion.setUserRevenueValue("100");
    webConversion.setCountingType(ConversionCountingType.MANY_PER_CLICK);
    webConversion.setExcludeFromBidding(ExcludeFromBidding.FALSE);
    webConversion.setMeasurementPeriod(7);

    ConversionTrackerOperation operation = new ConversionTrackerOperation();
    operation.setOperator(Operator.ADD);
    operation.setAccountId(accountId);
    operation.getOperand().add(appConversion);
    operation.getOperand().add(webConversion);

    // Run
    List<ConversionTrackerValues> conversionTrackerValues = null;
    try {
      conversionTrackerValues = ConversionTrackerSample.add(operation);
    } catch (Exception e) {
      fail();
    }

    // Assert
    for (ConversionTrackerValues conversionTrackerValue : conversionTrackerValues) {
      assertThat(conversionTrackerValue.isOperationSucceeded(), is(true));
      assertThat(conversionTrackerValue.getConversionTracker().getAccountId(), is(notNullValue()));
    }
  }

  /**
   * Sample TestCase of set method for ConversionTrackerSample.
   */
  @Test
  public void testSet() throws Exception {
    // =================================================================
    // ConversionTrackerService::mutate(ADD)
    // =================================================================
    // Set Operation
    // AppConversionTracker
    AppConversion appConversion = new AppConversion();
    appConversion.setAppId("appid" + SoapUtils.getCurrentTimestamp());
    appConversion.setAppPlatform(AppPlatform.ANDROID_MARKET);
    appConversion.setAppConversionType(AppConversionType.DOWNLOAD);
    appConversion.setAccountId(accountId);
    appConversion.setConversionTrackerName("SampleAppConversionTracker_CreateOn_" + SoapUtils.getCurrentTimestamp());
    appConversion.setStatus(ConversionTrackerStatus.ENABLED);
    appConversion.setCategory(ConversionTrackerCategory.DOWNLOAD);
    appConversion.setConversionTrackerType(ConversionTrackerType.APP_CONVERSION);
    appConversion.setUserRevenueValue("100");

    // WebConversionTracker
    WebConversion webConversion = new WebConversion();
    webConversion.setMarkupLanguage(MarkupLanguage.HTML);
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
    addOperation.getOperand().add(appConversion);
    addOperation.getOperand().add(webConversion);

    // Run
    List<ConversionTrackerValues> addResponse = null;
    try {
      addResponse = ConversionTrackerSample.add(addOperation);
    } catch (Exception e) {
      fail();
    }

    // =================================================================
    // ConversionTrackerService::mutate(SET)
    // =================================================================
    // Set Operation
    // AppConversionTracker
    AppConversion setAppConversion = new AppConversion();
    setAppConversion.setAccountId(accountId);
    setAppConversion.setConversionTrackerName("SampleAppConversionTracker_UpdateOn_" + SoapUtils.getCurrentTimestamp());
    setAppConversion.setCategory(ConversionTrackerCategory.DOWNLOAD);
    setAppConversion.setStatus(ConversionTrackerStatus.DISABLED);
    setAppConversion.setConversionTrackerType(ConversionTrackerType.APP_CONVERSION);
    setAppConversion.setCountingType(ConversionCountingType.MANY_PER_CLICK);

    // WebConversionTracker
    WebConversion setWebConversion = new WebConversion();
    setWebConversion.setAccountId(accountId);
    setWebConversion.setConversionTrackerName("SampleWebConversionTracker_UpdateOn_" + SoapUtils.getCurrentTimestamp());
    setWebConversion.setCategory(ConversionTrackerCategory.DEFAULT);
    setWebConversion.setStatus(ConversionTrackerStatus.DISABLED);
    setWebConversion.setConversionTrackerType(ConversionTrackerType.WEB_CONVERSION);
    setWebConversion.setCountingType(ConversionCountingType.ONE_PER_CLICK);
    setWebConversion.setMeasurementPeriod(17);

    // set conversionTrackerId
    for (ConversionTrackerValues conversionTrackerValues : addResponse) {
      switch (conversionTrackerValues.getConversionTracker().getConversionTrackerType()) {
        case APP_CONVERSION:
          setAppConversion.setConversionTrackerId(conversionTrackerValues.getConversionTracker().getConversionTrackerId());
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
    setOperation.getOperand().add(setWebConversion);

    // Run
    List<ConversionTrackerValues> setResponse = null;
    try {
      setResponse = ConversionTrackerSample.add(setOperation);
    } catch (Exception e) {
      fail();
    }

    // Assert
    for (ConversionTrackerValues conversionTrackerValue : setResponse) {
      assertThat(conversionTrackerValue.isOperationSucceeded(), is(true));
      assertThat(conversionTrackerValue.getConversionTracker().getAccountId(), is(notNullValue()));
    }
  }

  /**
   * Sample TestCase of get method for ConversionTrackerSample.
   */
  @Test
  public void testGet() throws Exception {
    // =================================================================
    // ConversionTrackerService::mutate(ADD)
    // =================================================================
    // Set Operation
    // AppConversionTracker
    AppConversion appConversion = new AppConversion();
    appConversion.setAppId("appid" + SoapUtils.getCurrentTimestamp());
    appConversion.setAppPlatform(AppPlatform.ANDROID_MARKET);
    appConversion.setAppConversionType(AppConversionType.DOWNLOAD);
    appConversion.setAccountId(accountId);
    appConversion.setConversionTrackerName("SampleAppConversionTracker_CreateOn_" + SoapUtils.getCurrentTimestamp());
    appConversion.setStatus(ConversionTrackerStatus.ENABLED);
    appConversion.setCategory(ConversionTrackerCategory.DOWNLOAD);
    appConversion.setConversionTrackerType(ConversionTrackerType.APP_CONVERSION);
    appConversion.setUserRevenueValue("100");

    // WebConversionTracker
    WebConversion webConversion = new WebConversion();
    webConversion.setMarkupLanguage(MarkupLanguage.HTML);
    webConversion.setTrackingCodeType(TrackingCodeType.CLICK_TO_CALL);
    webConversion.setAccountId(accountId);
    webConversion.setConversionTrackerName("SampleWebConversionTracker_CreateOn_" + SoapUtils.getCurrentTimestamp());
    webConversion.setStatus(ConversionTrackerStatus.ENABLED);
    webConversion.setCategory(ConversionTrackerCategory.DEFAULT);
    webConversion.setConversionTrackerType(ConversionTrackerType.WEB_CONVERSION);
    webConversion.setUserRevenueValue("100");

    ConversionTrackerOperation operation = new ConversionTrackerOperation();
    operation.setOperator(Operator.ADD);
    operation.setAccountId(accountId);
    operation.getOperand().add(appConversion);
    operation.getOperand().add(webConversion);

    // Run
    List<ConversionTrackerValues> addResponse = null;
    try {
      addResponse = ConversionTrackerSample.add(operation);
    } catch (Exception e) {
      fail();
    }

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
    selector.getCountingTypes().addAll(Arrays.asList(ConversionCountingType.MANY_PER_CLICK,ConversionCountingType.ONE_PER_CLICK));
    selector.getExcludeFromBiddings().addAll(Arrays.asList(ExcludeFromBidding.TRUE, ExcludeFromBidding.FALSE));
    selector.setDateRange(ConversionTrackerSample.createConversionDateRange());
    Paging paging = new Paging();
    paging.setStartIndex(1);
    paging.setNumberResults(20);
    selector.setPaging(paging);

    // Run
    List<ConversionTrackerValues> getResponse = null;
    try {
      getResponse = ConversionTrackerSample.get(selector);
    } catch (Exception e) {
      fail();
    }

    // Assert
    for (ConversionTrackerValues conversionTrackerValue : getResponse) {
      assertThat(conversionTrackerValue.isOperationSucceeded(), is(true));
      assertThat(conversionTrackerValue.getConversionTracker().getAccountId(), is(notNullValue()));
    }
  }
}

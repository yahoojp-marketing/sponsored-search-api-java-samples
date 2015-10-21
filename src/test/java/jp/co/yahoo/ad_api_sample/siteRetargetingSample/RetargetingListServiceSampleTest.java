package jp.co.yahoo.ad_api_sample.siteRetargetingSample;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNull.notNullValue;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

import jp.co.yahoo.ad_api_sample.util.SoapUtils;
import jp.yahooapis.ss.V5.RetargetingListService.RetargetingListOperation;
import jp.yahooapis.ss.V5.RetargetingListService.RetargetingListSelector;
import jp.yahooapis.ss.V5.RetargetingListService.RetargetingListValues;

/**
 * Sample TestCase for RetargetingListServiceSample. Copyright (C) 2012 Yahoo Japan Corporation. All Rights
 * Reserved.
 */
public class RetargetingListServiceSampleTest {

  /**
   * Setting
   */
  private long accountId;

  @Before
  public void setup() {
    accountId = SoapUtils.getAccountId();
  }

  /**
   * Sample TestCase of main method for RetargetingListServiceSample.
   */
  @Test
  public void testMain() throws Exception {
    // Run
    try {
      RetargetingListServiceSample.main(null);
    } catch (Exception e) {
      fail();
    }
  }

  /**
   * Sample TestCase of add method for RetargetingListServiceSample.
   */
  @Test
  public void testAdd() throws Exception {
    // =================================================================
    // RetargetingListService::mutate(ADD)
    // =================================================================
    // - DefaultTargetList
    RetargetingListOperation operationOfDefault = RetargetingListServiceSample.createSampleAddRequestOfDefault(accountId);

    // Run
    List<RetargetingListValues> retargetingListValues = null;
    try {
      retargetingListValues = RetargetingListServiceSample.add(operationOfDefault);
    } catch (Exception e) {
      fail();
    }

    // =================================================================
    // RetargetingListService::mutate(ADD)
    // =================================================================
    // - RuleBaseTargetList
    RetargetingListOperation operationOfRuleBase = RetargetingListServiceSample.createSampleAddRequestOfRuleBase(accountId);

    // Run
    try {
      retargetingListValues = RetargetingListServiceSample.add(operationOfRuleBase);
    } catch (Exception e) {
      fail();
    }

    // Assert
    for (RetargetingListValues retargetingListValue : retargetingListValues) {
      assertThat(retargetingListValue.isOperationSucceeded(), is(true));
      assertThat(retargetingListValue.getTargetList().getAccountId(), is(notNullValue()));
    }

    // =================================================================
    // RetargetingListService::mutate(ADD)
    // =================================================================
    // - LogicalTargetList
    RetargetingListOperation operationOfLogical = RetargetingListServiceSample.createSampleAddRequestOfLogical(accountId, retargetingListValues);

    // Run
    try {
      retargetingListValues = RetargetingListServiceSample.add(operationOfLogical);
    } catch (Exception e) {
      fail();
    }

    // Assert
    for (RetargetingListValues retargetingListValue : retargetingListValues) {
      assertThat(retargetingListValue.isOperationSucceeded(), is(true));
      assertThat(retargetingListValue.getTargetList().getAccountId(), is(notNullValue()));
    }
  }

  /**
   * Sample TestCase of add method for RetargetingListServiceSample.
   */
  @Test
  public void testAddErrorRegisteredDefaultlist() throws Exception {
    // =================================================================
    // RetargetingListService::mutate(ADD)
    // =================================================================
    // - DefaultTargetList
    // First
    RetargetingListOperation operationOfDefault = RetargetingListServiceSample.createSampleAddRequestOfDefault(accountId);

    // Run
    List<RetargetingListValues> retargetingListValues = null;
    try {
      retargetingListValues = RetargetingListServiceSample.add(operationOfDefault);
    } catch (Exception e) {
      fail();
    }

    // - DefaultTargetList
    // Second
    operationOfDefault = RetargetingListServiceSample.createSampleAddRequestOfDefault(accountId);

    // Run
    try {
      retargetingListValues = RetargetingListServiceSample.add(operationOfDefault);
    } catch (Exception e) {
      fail();
    }

    // Assert
    for (RetargetingListValues retargetingListValue : retargetingListValues) {
      assertThat(retargetingListValue.isOperationSucceeded(), is(false));
      assertThat(retargetingListValue.getError().size(), is(1));
      assertThat(retargetingListValue.getError().get(0).getCode(), is("210804"));
    }
  }

  /**
   * Sample TestCase of set method for RetargetingListServiceSample.
   */
  @Test
  public void testSet() throws Exception {
    // =================================================================
    // RetargetingListService::mutate(ADD)
    // =================================================================
    // Set Operation
    // - DefaultTargetList
    RetargetingListOperation operationOfDefault = RetargetingListServiceSample.createSampleAddRequestOfDefault(accountId);
    // - RuleBaseTargetList
    RetargetingListOperation operationOfRuleBase = RetargetingListServiceSample.createSampleAddRequestOfRuleBase(accountId);

    // Run
    List<RetargetingListValues> addResponse = null;
    try {
      RetargetingListServiceSample.add(operationOfDefault);
      addResponse = RetargetingListServiceSample.add(operationOfRuleBase);
    } catch (Exception e) {
      fail();
    }

    // =================================================================
    // RetargetingListService::get
    // =================================================================
    // Set Selector
    RetargetingListSelector selector = RetargetingListServiceSample.createSampleGetRequest(accountId, addResponse);

    // Run
    List<RetargetingListValues> getResponse = null;
    try {
      getResponse = RetargetingListServiceSample.get(selector);
    } catch (Exception e) {
      fail();
    }


    // =================================================================
    // RetargetingListService::mutate(SET)
    // =================================================================
    // Set Operation
    RetargetingListOperation setOperation = RetargetingListServiceSample.createSampleSetRequest(accountId, getResponse);

    // Run
    List<RetargetingListValues> setResponse = null;
    try {
      setResponse = RetargetingListServiceSample.set(setOperation);
    } catch (Exception e) {
      fail();
    }

    // Assert
    for (RetargetingListValues retargetingListValue : setResponse) {
      assertThat(retargetingListValue.isOperationSucceeded(), is(true));
      assertThat(retargetingListValue.getTargetList().getAccountId(), is(notNullValue()));
    }
  }

  /**
   * Sample TestCase of get method for RetargetingListServiceSample.
   */
  @Test
  public void testGet() throws Exception {
    // =================================================================
    // RetargetingListService::mutate(ADD)
    // =================================================================
    // Set Operation
    // - DefaultTargetList
    RetargetingListOperation operationOfDefault = RetargetingListServiceSample.createSampleAddRequestOfDefault(accountId);
    // - RuleBaseTargetList
    RetargetingListOperation operationOfRuleBase = RetargetingListServiceSample.createSampleAddRequestOfRuleBase(accountId);

    // Run
    List<RetargetingListValues> addResponse = null;
    try {
      RetargetingListServiceSample.add(operationOfDefault);
      addResponse = RetargetingListServiceSample.add(operationOfRuleBase);
    } catch (Exception e) {
      fail();
    }

    // =================================================================
    // RetargetingListService::get
    // =================================================================
    // Set Selector
    RetargetingListSelector selector = RetargetingListServiceSample.createSampleGetRequest(accountId, addResponse);

    // Run
    List<RetargetingListValues> getResponse = null;
    try {
      getResponse = RetargetingListServiceSample.get(selector);
    } catch (Exception e) {
      fail();
    }

    // Assert
    for (RetargetingListValues retargetingListValue : getResponse) {
      assertThat(retargetingListValue.isOperationSucceeded(), is(true));
      assertThat(retargetingListValue.getTargetList().getAccountId(), is(notNullValue()));
    }
  }
}

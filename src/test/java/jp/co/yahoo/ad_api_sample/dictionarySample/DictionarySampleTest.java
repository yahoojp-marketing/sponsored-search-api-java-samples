package jp.co.yahoo.ad_api_sample.dictionarySample;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;

import java.util.List;

import jp.yahooapis.ss.v201805.dictionary.DictionaryLang;
import jp.yahooapis.ss.v201805.dictionary.DisapprovalReasonSelector;
import jp.yahooapis.ss.v201805.dictionary.DisapprovalReasonValues;
import jp.yahooapis.ss.v201805.dictionary.GeographicLocationSelector;
import jp.yahooapis.ss.v201805.dictionary.GeographicLocationValues;

import org.junit.Test;

/**
 * Sample TestCase for DictionarySampleTest. Copyright (C) 2012 Yahoo Japan Corporation. All Rights
 * Reserved.
 */
public class DictionarySampleTest {

  /**
   * Sample TestCase of main method for DictionarySample.
   */
  @Test
  public void testMain() throws Exception {
    // Run
    try {
      DictionarySample.main(null);
    } catch (Exception e) {
      fail();
    }
  }

  /**
   * Sample TestCase of getDisapprovalReason method for DictionarySample.
   */
  @Test
  public void testGetDisapprovalReason() throws Exception {
    // Set Selector
    DisapprovalReasonSelector disapprovalReasonSelector = new DisapprovalReasonSelector();
    disapprovalReasonSelector.setLang(DictionaryLang.EN);

    // Run
    List<DisapprovalReasonValues> disapprovalReasonValues = null;
    try {
      disapprovalReasonValues = DictionarySample.getDisapprovalReason(disapprovalReasonSelector);
    } catch (Exception e) {
      fail();
    }

    // Assert
    for (DisapprovalReasonValues disapprovalreasonvalue : disapprovalReasonValues) {
      assertThat(disapprovalreasonvalue.isOperationSucceeded(), is(true));
    }
  }

  /**
   * Sample TestCase of getGeographicLocation method for DictionarySample.
   */
  @Test
  public void testGetGeographicLocation() throws Exception {
    // Set Selector
    GeographicLocationSelector geographicLocationSelector = new GeographicLocationSelector();
    geographicLocationSelector.setLang(DictionaryLang.JA);

    // Run
    List<GeographicLocationValues> geographicLocationValues = null;
    try {
      geographicLocationValues = DictionarySample.getGeographicLocation(geographicLocationSelector);
    } catch (Exception e) {
      fail();
    }

    // Assert
    for (GeographicLocationValues geographicLocationValue : geographicLocationValues) {
      assertThat(geographicLocationValue.isOperationSucceeded(), is(true));
    }
  }
}

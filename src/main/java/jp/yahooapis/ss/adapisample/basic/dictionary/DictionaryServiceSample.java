/**
 * Copyright (C) 2019 Yahoo Japan Corporation. All Rights Reserved.
 */
package jp.yahooapis.ss.adapisample.basic.dictionary;

import jp.yahooapis.ss.adapisample.util.SoapUtils;
import jp.yahooapis.ss.v201901.Error;
import jp.yahooapis.ss.v201901.dictionary.DictionaryLang;
import jp.yahooapis.ss.v201901.dictionary.DictionaryService;
import jp.yahooapis.ss.v201901.dictionary.DictionaryServiceInterface;
import jp.yahooapis.ss.v201901.dictionary.DisapprovalReasonPage;
import jp.yahooapis.ss.v201901.dictionary.DisapprovalReasonSelector;
import jp.yahooapis.ss.v201901.dictionary.DisapprovalReasonValues;
import jp.yahooapis.ss.v201901.dictionary.GeographicLocationPage;
import jp.yahooapis.ss.v201901.dictionary.GeographicLocationSelector;
import jp.yahooapis.ss.v201901.dictionary.GeographicLocationValues;

import java.util.List;

import javax.xml.ws.Holder;

/**
 * example DictionaryService operation and Utility method collection.
 */
public class DictionaryServiceSample {

  /**
   * example DictionaryService operation.
   *
   * @param args command line arguments
   * @throws Exception
   */
  public static void main(String[] args) throws Exception {
    try {
      // =================================================================
      // DictionaryService GetGeographicLocation
      // =================================================================
      // create request.
      GeographicLocationSelector geographicLocationSelector = buildExampleGetGeographicLocationRequest();

      // run
      getGeographicLocation(geographicLocationSelector);


      // =================================================================
      // DictionaryService GetDisapprovalReason
      // =================================================================
      // create request.
      DisapprovalReasonSelector disapprovalReasonSelector = buildExampleGetDisapprovalReasonRequest();

      // run
      getDisapprovalReason(disapprovalReasonSelector);

    } catch (Exception e) {
      e.printStackTrace();
      throw e;
    }
  }

  /**
   * example getDisapprovalReason request.
   *
   * @return DisapprovalReasonSelector
   */
  public static DisapprovalReasonSelector buildExampleGetDisapprovalReasonRequest() {
    DisapprovalReasonSelector selector = new DisapprovalReasonSelector();
    selector.setLang(DictionaryLang.EN);
    return selector;
  }

  /**
   * example getGeographicLocation request.
   *
   * @return GeographicLocationSelector
   */
  public static GeographicLocationSelector buildExampleGetGeographicLocationRequest() {
    GeographicLocationSelector selector = new GeographicLocationSelector();
    selector.setLang(DictionaryLang.EN);
    return selector;
  }

  /**
   * example getDisapprovalReason.
   *
   * @param selector DisapprovalReasonSelector
   * @return List<DisapprovalReasonValues>
   * @throws Exception
   */
  public static List<DisapprovalReasonValues> getDisapprovalReason(DisapprovalReasonSelector selector) throws Exception {

    // call API
    System.out.println("############################################");
    System.out.println("DictionaryService::getDisapprovalReason");
    System.out.println("############################################");

    Holder<DisapprovalReasonPage> disapprovalReasonPageHolder = new Holder<DisapprovalReasonPage>();
    Holder<List<Error>> errorHolder = new Holder<List<Error>>();
    DictionaryServiceInterface dictionaryService = SoapUtils.createServiceInterface(DictionaryServiceInterface.class, DictionaryService.class);
    dictionaryService.getDisapprovalReason(selector, disapprovalReasonPageHolder, errorHolder);

    SoapUtils.checkSoapError(errorHolder, disapprovalReasonPageHolder.value.getValues());

    // Response
    return disapprovalReasonPageHolder.value.getValues();
  }

  /**
   * example getGeographicLocation.
   *
   * @param selector GeographicLocationSelector
   * @return List<GeographicLocationValues>
   * @throws Exception
   */
  public static List<GeographicLocationValues> getGeographicLocation(GeographicLocationSelector selector) throws Exception {

    // call API
    System.out.println("############################################");
    System.out.println("DictionaryService::getGeographicLocation");
    System.out.println("############################################");

    Holder<GeographicLocationPage> geographicLocationPageHolder = new Holder<GeographicLocationPage>();
    Holder<List<Error>> errorHolder = new Holder<List<Error>>();
    DictionaryServiceInterface dictionaryService = SoapUtils.createServiceInterface(DictionaryServiceInterface.class, DictionaryService.class);
    dictionaryService.getGeographicLocation(selector, geographicLocationPageHolder, errorHolder);

    SoapUtils.checkSoapError(errorHolder, geographicLocationPageHolder.value.getValues());

    // Response
    return geographicLocationPageHolder.value.getValues();
  }
}


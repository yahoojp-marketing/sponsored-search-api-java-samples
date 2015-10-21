package jp.co.yahoo.ad_api_sample.dictionarySample;

import java.util.List;

import javax.xml.ws.Holder;

import jp.co.yahoo.ad_api_sample.error.impl.DictionaryServiceErrorEntityFactory;
import jp.co.yahoo.ad_api_sample.util.SoapUtils;
import jp.yahooapis.ss.V5.DictionaryService.DictionaryLang;
import jp.yahooapis.ss.V5.DictionaryService.DictionaryService;
import jp.yahooapis.ss.V5.DictionaryService.DictionaryServiceInterface;
import jp.yahooapis.ss.V5.DictionaryService.DisapprovalReason;
import jp.yahooapis.ss.V5.DictionaryService.DisapprovalReasonPage;
import jp.yahooapis.ss.V5.DictionaryService.DisapprovalReasonSelector;
import jp.yahooapis.ss.V5.DictionaryService.DisapprovalReasonValues;
import jp.yahooapis.ss.V5.DictionaryService.Error;
import jp.yahooapis.ss.V5.DictionaryService.GeographicLocation;
import jp.yahooapis.ss.V5.DictionaryService.GeographicLocationPage;
import jp.yahooapis.ss.V5.DictionaryService.GeographicLocationSelector;
import jp.yahooapis.ss.V5.DictionaryService.GeographicLocationValues;


/**
 * Sample Program for DictionaryService. Copyright (C) 2012 Yahoo Japan Corporation. All Rights
 * Reserved.
 */
public class DictionarySample {

  /**
   * main method for DictionarySample
   *
   * @param args command line arguments
   */
  public static void main(String[] args) throws Exception {
    try {
      // =================================================================
      // DictionaryService::getDisapprovalReason
      // =================================================================
      // Set Selector
      DisapprovalReasonSelector disapprovalReasonSelector = new DisapprovalReasonSelector();
      disapprovalReasonSelector.setLang(DictionaryLang.EN);

      // Run
      getDisapprovalReason(disapprovalReasonSelector);

      // =================================================================
      // DictionaryService::getGeographicLocation
      // =================================================================
      // Set Selector
      GeographicLocationSelector geographicLocationSelector = new GeographicLocationSelector();
      geographicLocationSelector.setLang(DictionaryLang.JA);

      // Run
      getGeographicLocation(geographicLocationSelector);

    } catch (Exception ex) {
      ex.printStackTrace();
    }
  }

  /**
   * Sample Program for DictionaryService GetDisapprovalReason.
   * 
   * @param selector DisapprovalReasonSelector
   * @return DisapprovalReasonValues
   * @throws Exception
   */
  public static List<DisapprovalReasonValues> getDisapprovalReason(DisapprovalReasonSelector selector) throws Exception {

    // call API
    System.out.println("############################################");
    System.out.println("DictionaryService::getDisapprovalReason");
    System.out.println("############################################");

    Holder<DisapprovalReasonPage> disapprovalReasonPageHolder = new Holder<DisapprovalReasonPage>();
    Holder<List<Error>> errorArrayHolder = new Holder<List<Error>>();
    DictionaryServiceInterface dictionaryService = SoapUtils.createServiceInterface(DictionaryServiceInterface.class, DictionaryService.class);
    dictionaryService.getDisapprovalReason(selector, disapprovalReasonPageHolder, errorArrayHolder);

    // Error
    if (errorArrayHolder.value != null && errorArrayHolder.value.size() > 0) {
      SoapUtils.displayErrors(new DictionaryServiceErrorEntityFactory(errorArrayHolder.value), true);
    }
    if (errorArrayHolder.value == null) {
      throw new Exception("NoDataResponse:DictionaryService GetDisapprovalReason");
    }

    // Display
    for (DisapprovalReasonValues values : disapprovalReasonPageHolder.value.getValues()) {
      if (values.isOperationSucceeded()) {
        displayDisapprovalReason(values.getDisapprovalReason());
      } else {
        SoapUtils.displayErrors(new DictionaryServiceErrorEntityFactory(values.getError()), true);
      }
    }

    // Response
    return disapprovalReasonPageHolder.value.getValues();
  }

  /**
   * Sample Program for DictionaryService GetGeographicLocation.
   * 
   * @param selector GeographicLocationSelector
   * @return GeographicLocationValues
   * @throws Exception
   */
  public static List<GeographicLocationValues> getGeographicLocation(GeographicLocationSelector selector) throws Exception {

    // call API
    System.out.println("############################################");
    System.out.println("DictionaryService::getGeographicLocation");
    System.out.println("############################################");

    Holder<GeographicLocationPage> geographicLocationPageHolder = new Holder<GeographicLocationPage>();
    Holder<List<Error>> errorArrayHolder = new Holder<List<Error>>();
    DictionaryServiceInterface dictionaryService = SoapUtils.createServiceInterface(DictionaryServiceInterface.class, DictionaryService.class);
    dictionaryService.getGeographicLocation(selector, geographicLocationPageHolder, errorArrayHolder);

    // Error
    if (errorArrayHolder.value != null && errorArrayHolder.value.size() > 0) {
      SoapUtils.displayErrors(new DictionaryServiceErrorEntityFactory(errorArrayHolder.value), true);
    }
    if (errorArrayHolder.value == null) {
      throw new Exception("NoDataResponse:DictionaryService GetGeographicLocation");
    }

    // reponse
    for (GeographicLocationValues values : geographicLocationPageHolder.value.getValues()) {
      if (values.isOperationSucceeded()) {
        displayGeographicLocation(values.getGeographicLocation());
      } else {
        SoapUtils.displayErrors(new DictionaryServiceErrorEntityFactory(values.getError()), true);
      }
    }

    // Response
    return geographicLocationPageHolder.value.getValues();
  }

  /**
   * display GeographicLocation entity to stdout.
   *
   * @param geographicLocation GeographicLocation entity for display.
   */
  private static void displayGeographicLocation(GeographicLocation geographicLocation) {
    System.out.println("code = " + geographicLocation.getCode());
    System.out.println("parent = " + geographicLocation.getParent());
    System.out.println("name = " + geographicLocation.getName());
    System.out.println("fullName = " + geographicLocation.getFullName());
    System.out.println("order = " + geographicLocation.getOrder());
    System.out.println("status = " + geographicLocation.getStatus());

    List<GeographicLocation> geographicLocationList = geographicLocation.getChild();
    for (int i = 0; i < geographicLocationList.size(); i++) {
      GeographicLocation childGeographicLocation = geographicLocationList.get(i);
      System.out.println("child[" + i + "]:code = " + childGeographicLocation.getCode());
      System.out.println("child[" + i + "]:parent = " + childGeographicLocation.getParent());
      System.out.println("child[" + i + "]:name = " + childGeographicLocation.getName());
      System.out.println("child[" + i + "]:fullName = " + childGeographicLocation.getFullName());
      System.out.println("child[" + i + "]:order = " + childGeographicLocation.getOrder());
      System.out.println("child[" + i + "]:status = " + childGeographicLocation.getStatus());
    }
    System.out.println("---------");
  }

  /**
   * display DisapprovalReason entity to stdout.
   *
   * @param disapprovalReason DisapprovalReason entity for display.
   */
  private static void displayDisapprovalReason(DisapprovalReason disapprovalReason) {
    System.out.println("disapprovalReasonCode = " + disapprovalReason.getDisapprovalReasonCode());
    System.out.println("lang = " + disapprovalReason.getLang());
    System.out.println("title = " + disapprovalReason.getTitle());
    System.out.println("description = " + disapprovalReason.getDescription());
    System.out.println("recommendation = " + disapprovalReason.getRecommendation());
    System.out.println("---------");
  }
}

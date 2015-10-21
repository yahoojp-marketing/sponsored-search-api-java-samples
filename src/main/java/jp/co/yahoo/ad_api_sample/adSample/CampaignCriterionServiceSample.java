package jp.co.yahoo.ad_api_sample.adSample;

import java.util.ArrayList;
import java.util.List;

import javax.xml.ws.Holder;

import jp.co.yahoo.ad_api_sample.error.impl.CampaignCriterionServiceErrorEntityFactory;
import jp.co.yahoo.ad_api_sample.util.SoapUtils;
import jp.yahooapis.ss.V5.CampaignCriterionService.CampaignCriterion;
import jp.yahooapis.ss.V5.CampaignCriterionService.CampaignCriterionOperation;
import jp.yahooapis.ss.V5.CampaignCriterionService.CampaignCriterionPage;
import jp.yahooapis.ss.V5.CampaignCriterionService.CampaignCriterionReturnValue;
import jp.yahooapis.ss.V5.CampaignCriterionService.CampaignCriterionSelector;
import jp.yahooapis.ss.V5.CampaignCriterionService.CampaignCriterionService;
import jp.yahooapis.ss.V5.CampaignCriterionService.CampaignCriterionServiceInterface;
import jp.yahooapis.ss.V5.CampaignCriterionService.CampaignCriterionValues;
import jp.yahooapis.ss.V5.CampaignCriterionService.Criterion;
import jp.yahooapis.ss.V5.CampaignCriterionService.CriterionType;
import jp.yahooapis.ss.V5.CampaignCriterionService.CriterionUse;
import jp.yahooapis.ss.V5.CampaignCriterionService.Error;
import jp.yahooapis.ss.V5.CampaignCriterionService.Keyword;
import jp.yahooapis.ss.V5.CampaignCriterionService.KeywordMatchType;
import jp.yahooapis.ss.V5.CampaignCriterionService.Operator;
import jp.yahooapis.ss.V5.CampaignCriterionService.Paging;

/**
 * Sample Program for CampaignCriterionService. Copyright (C) 2012 Yahoo Japan Corporation. All
 * Rights Reserved.
 */
public class CampaignCriterionServiceSample {

  /**
   * main method for CampaignCriterionServiceSample
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
      long appCampaignId = SoapUtils.getAppCampaignId();

      // =================================================================
      // CampaignCriterionService ADD
      // =================================================================
      // - Standard campaign
      // Set Operation
      CampaignCriterionOperation addCampaignCriterionOperation = createSampleAddRequest(accountId, campaignId);

      // Run
      List<CampaignCriterionValues> standardCampaignCriterionValues = add(addCampaignCriterionOperation);

      // - App campaign
      // Set Operation
      addCampaignCriterionOperation = createSampleAddRequest(accountId, appCampaignId);

      // Run
      List<CampaignCriterionValues> appCampaignCriterionValues = add(addCampaignCriterionOperation);


      // =================================================================
      // CampaignCriterionService GET
      // =================================================================
      // Set Selector
      List<CampaignCriterionValues> campaignCriterionValues = new ArrayList<>();
      campaignCriterionValues.addAll(standardCampaignCriterionValues);
      campaignCriterionValues.addAll(appCampaignCriterionValues);
      CampaignCriterionSelector campaignCriterionSelector = createSampleGetRequest(accountId, campaignCriterionValues);

      // Run
      get(campaignCriterionSelector);


      // =================================================================
      // CampaignCriterionService REMOVE
      // =================================================================
      // - Standard campaign
      // Set Operation
      CampaignCriterionOperation removeCampaignCriterionOperation = createSampleRemoveRequest(accountId, campaignId, standardCampaignCriterionValues);

      // Run
      remove(removeCampaignCriterionOperation);

      // - App campaign
      removeCampaignCriterionOperation = createSampleRemoveRequest(accountId, appCampaignId, appCampaignCriterionValues);

      // Run
      remove(removeCampaignCriterionOperation);

    } catch (Exception e) {
      e.printStackTrace();
      throw e;
    }
  }

  /**
   * Sample Program for CampaignCriterionService ADD.
   *
   * @param operation CampaignCriterionOperation
   * @return CampaignCriterionValues
   * @throws Exception
   */
  public static List<CampaignCriterionValues> add(CampaignCriterionOperation operation) throws Exception {

    // Call API
    System.out.println("############################################");
    System.out.println("CampaignCriterionService::mutate(ADD)");
    System.out.println("############################################");

    Holder<CampaignCriterionReturnValue> campaignCriterionReturnValueHolder = new Holder<CampaignCriterionReturnValue>();
    Holder<List<Error>> errorHolder = new Holder<List<Error>>();
    CampaignCriterionServiceInterface campaignCriterionService = SoapUtils.createServiceInterface(CampaignCriterionServiceInterface.class, CampaignCriterionService.class);
    campaignCriterionService.mutate(operation, campaignCriterionReturnValueHolder, errorHolder);

    // Error
    if (errorHolder.value != null && errorHolder.value.size() > 0) {
      SoapUtils.displayErrors(new CampaignCriterionServiceErrorEntityFactory(errorHolder.value), true);
    }
    if (campaignCriterionReturnValueHolder.value == null) {
      throw new Exception("NoDataResponse:CampaignCriterionService Add");
    }

    // Display
    for (CampaignCriterionValues campaignCriterionValues : campaignCriterionReturnValueHolder.value.getValues()) {
      if (campaignCriterionValues.isOperationSucceeded()) {
        display(campaignCriterionValues.getCampaignCriterion());
      } else {
        SoapUtils.displayErrors(new CampaignCriterionServiceErrorEntityFactory(campaignCriterionValues.getError()), true);
      }
    }

    // Response
    return campaignCriterionReturnValueHolder.value.getValues();
  }

  /**
   * Sample Program for CampaignCriterionService REMOVE.
   *
   * @param operation CampaignCriterionOperation
   * @return CampaignCriterionValues
   * @throws Exception
   */
  public static List<CampaignCriterionValues> remove(CampaignCriterionOperation operation) throws Exception {

    // Call API
    System.out.println("############################################");
    System.out.println("CampaignCriterionService::mutate(REMOVE)");
    System.out.println("############################################");

    Holder<CampaignCriterionReturnValue> campaignCriterionReturnValueHolder = new Holder<CampaignCriterionReturnValue>();
    Holder<List<Error>> errorHolder = new Holder<List<Error>>();
    CampaignCriterionServiceInterface campaignCriterionService = SoapUtils.createServiceInterface(CampaignCriterionServiceInterface.class, CampaignCriterionService.class);
    campaignCriterionService.mutate(operation, campaignCriterionReturnValueHolder, errorHolder);

    // Error
    if (errorHolder.value != null && errorHolder.value.size() > 0) {
      SoapUtils.displayErrors(new CampaignCriterionServiceErrorEntityFactory(errorHolder.value), true);
    }
    if (campaignCriterionReturnValueHolder.value == null) {
      throw new Exception("NoDataResponse:CampaignCriterionService Remove");
    }

    // Display
    for (CampaignCriterionValues campaignCriterionValues : campaignCriterionReturnValueHolder.value.getValues()) {
      if (campaignCriterionValues.isOperationSucceeded()) {
        display(campaignCriterionValues.getCampaignCriterion());
      } else {
        SoapUtils.displayErrors(new CampaignCriterionServiceErrorEntityFactory(campaignCriterionValues.getError()), true);
      }
    }

    // Response
    return campaignCriterionReturnValueHolder.value.getValues();
  }

  /**
   * Sample Program for CampaignCriterionService GET.
   *
   * @param selector CampaignCriterionSelector
   * @return CampaignCriterionValues
   * @throws Exception
   */
  public static List<CampaignCriterionValues> get(CampaignCriterionSelector selector) throws Exception {

    // Call API
    System.out.println("############################################");
    System.out.println("CampaignCriterionService::get");
    System.out.println("############################################");

    Holder<CampaignCriterionPage> campaignCriterionPageHolder = new Holder<CampaignCriterionPage>();
    Holder<List<Error>> errorHolder = new Holder<List<Error>>();
    CampaignCriterionServiceInterface campaignCriterionService = SoapUtils.createServiceInterface(CampaignCriterionServiceInterface.class, CampaignCriterionService.class);
    campaignCriterionService.get(selector, campaignCriterionPageHolder, errorHolder);

    // Error
    if (errorHolder.value != null && errorHolder.value.size() > 0) {
      SoapUtils.displayErrors(new CampaignCriterionServiceErrorEntityFactory(errorHolder.value), true);
    }
    if (campaignCriterionPageHolder.value == null) {
      throw new Exception("NoDataResponse:CampaignCriterionService Get");
    }

    // Display
    for (CampaignCriterionValues campaignCriterionValues : campaignCriterionPageHolder.value.getValues()) {
      if (campaignCriterionValues.isOperationSucceeded()) {
        display(campaignCriterionValues.getCampaignCriterion());
      } else {
        SoapUtils.displayErrors(new CampaignCriterionServiceErrorEntityFactory(campaignCriterionValues.getError()), true);
      }
    }

    // Response
    return campaignCriterionPageHolder.value.getValues();
  }

  /**
   * display CampaignCriterion entity to stdout.
   *
   * @param campaignCriterion CampaignCriterion entity for display.
   */
  public static void display(CampaignCriterion campaignCriterion) {

    System.out.println("accountId = " + campaignCriterion.getAccountId());
    System.out.println("campaignId = " + campaignCriterion.getCampaignId());
    System.out.println("campaignName = " + campaignCriterion.getCampaignName());
    System.out.println("criterionUse = " + campaignCriterion.getCriterionUse());
    if (campaignCriterion.getCriterion() != null) {
      Criterion criterion = campaignCriterion.getCriterion();
      System.out.println("criterion/criterionId = " + criterion.getCriterionId());
      System.out.println("criterion/type = " + criterion.getType());
    }
    System.out.println("---------");
  }

  /**
   * create sample request.
   *
   * @param accountId long
   * @param campaignId long
   * @return CampaignCriterionOperation
   */
  public static CampaignCriterionOperation createSampleAddRequest(long accountId, long campaignId) {
    // Set Operation
    CampaignCriterionOperation operation = new CampaignCriterionOperation();
    operation.setOperator(Operator.ADD);
    operation.setAccountId(accountId);
    operation.setCampaignId(campaignId);
    operation.setCriterionUse(CriterionUse.NEGATIVE);

    // Set Keyword
    Keyword keyword = new Keyword();
    keyword.setType(CriterionType.KEYWORD);
    keyword.setText("sample text");
    keyword.setMatchType(KeywordMatchType.PHRASE);

    // Set Operand
    CampaignCriterion campaignCriterion = new CampaignCriterion();
    campaignCriterion.setAccountId(accountId);
    campaignCriterion.setCampaignId(campaignId);
    campaignCriterion.setCriterionUse(CriterionUse.NEGATIVE);
    campaignCriterion.setCriterion(keyword);

    operation.getOperand().add(campaignCriterion);

    return operation;
  }

  /**
   * create sample request.
   *
   * @param accountId long
   * @param campaignId long
   * @param campaignCriterionValues CampaignCriterionValues
   * @return CampaignCriterionOperation
   */
  public static CampaignCriterionOperation createSampleRemoveRequest(long accountId, long campaignId, List<CampaignCriterionValues> campaignCriterionValues) {
    // Set Operation
    CampaignCriterionOperation operation = new CampaignCriterionOperation();
    operation.setOperator(Operator.REMOVE);
    operation.setAccountId(accountId);
    operation.setCampaignId(campaignId);

    // Set Operand
    for (CampaignCriterionValues campaignCriterionValue : campaignCriterionValues) {

      CampaignCriterion campaignCriterion = new CampaignCriterion();
      campaignCriterion.setAccountId(campaignCriterionValue.getCampaignCriterion().getAccountId());
      campaignCriterion.setCampaignId(campaignCriterionValue.getCampaignCriterion().getCampaignId());
      campaignCriterion.setCriterionUse(campaignCriterionValue.getCampaignCriterion().getCriterionUse());
      Keyword keyword = new Keyword();
      keyword.setCriterionId(campaignCriterionValue.getCampaignCriterion().getCriterion().getCriterionId());
      keyword.setType(campaignCriterionValue.getCampaignCriterion().getCriterion().getType());
      campaignCriterion.setCriterion(keyword);

      operation.getOperand().add(campaignCriterion);
    }

    return operation;
  }

  /**
   * create sample request.
   *
   * @param accountId long
   * @param campaignCriterionValues CampaignCriterionValues
   * @return CampaignCriterionSelector
   */
  public static CampaignCriterionSelector createSampleGetRequest(long accountId, List<CampaignCriterionValues> campaignCriterionValues) {
    // Set Selector
    CampaignCriterionSelector selector = new CampaignCriterionSelector();
    selector.setAccountId(accountId);
    for (CampaignCriterionValues campaignCriterionValue : campaignCriterionValues) {
      selector.getCampaignIds().add(campaignCriterionValue.getCampaignCriterion().getCampaignId());
      selector.getCriterionIds().add((campaignCriterionValue.getCampaignCriterion().getCriterion().getCriterionId()));
    }
    selector.setCriterionUse(CriterionUse.NEGATIVE);

    // Set Paging
    Paging paging = new Paging();
    paging.setStartIndex(1);
    paging.setNumberResults(20);
    selector.setPaging(paging);

    return selector;
  }
}

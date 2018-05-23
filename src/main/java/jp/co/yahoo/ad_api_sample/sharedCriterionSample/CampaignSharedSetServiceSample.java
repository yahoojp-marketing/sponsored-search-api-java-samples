package jp.co.yahoo.ad_api_sample.sharedCriterionSample;

import jp.co.yahoo.ad_api_sample.adSample.CampaignServiceSample;
import jp.co.yahoo.ad_api_sample.error.impl.CampaignSharedSetServiceErrorEntityFactory;
import jp.co.yahoo.ad_api_sample.util.SoapUtils;
import jp.yahooapis.ss.v201805.accountshared.AccountSharedOperation;
import jp.yahooapis.ss.v201805.accountshared.AccountSharedValues;
import jp.yahooapis.ss.v201805.campaign.BiddingStrategyType;
import jp.yahooapis.ss.v201805.campaign.CampaignOperation;
import jp.yahooapis.ss.v201805.campaign.CampaignType;
import jp.yahooapis.ss.v201805.campaign.CampaignValues;
import jp.yahooapis.ss.v201805.campaignsharedset.CampaignSharedSet;
import jp.yahooapis.ss.v201805.campaignsharedset.CampaignSharedSetOperation;
import jp.yahooapis.ss.v201805.campaignsharedset.CampaignSharedSetPage;
import jp.yahooapis.ss.v201805.campaignsharedset.CampaignSharedSetReturnValue;
import jp.yahooapis.ss.v201805.campaignsharedset.CampaignSharedSetSelector;
import jp.yahooapis.ss.v201805.campaignsharedset.CampaignSharedSetService;
import jp.yahooapis.ss.v201805.campaignsharedset.CampaignSharedSetServiceInterface;
import jp.yahooapis.ss.v201805.campaignsharedset.CampaignSharedSetValues;
import jp.yahooapis.ss.v201805.Error;
import jp.yahooapis.ss.v201805.campaignsharedset.Operator;
import jp.yahooapis.ss.v201805.Paging;

import java.util.ArrayList;
import java.util.List;

import javax.xml.ws.Holder;

/**
 * Sample Program for CampaignSharedSetService. Copyright (C) 2012 Yahoo Japan Corporation. All Rights Reserved.
 */
public class CampaignSharedSetServiceSample {

  /**
   * main method for CampaignSharedSetServiceSample
   *
   * @param args command line arguments
   */
  public static void main(String[] args) throws Exception {
    try {
      // =================================================================
      // Setting
      // =================================================================
      AccountSharedServiceSample accountSharedServiceSample = new AccountSharedServiceSample();
      CampaignServiceSample campaignServiceSample = new CampaignServiceSample();
      long accountId = SoapUtils.getAccountId();
      long biddingStrategyId = SoapUtils.getBiddingStrategyId();

      // =================================================================
      // AccountSharedService::add
      // =================================================================
      // Set Operation
      AccountSharedOperation accountSharedOperation = accountSharedServiceSample.createSampleAddRequest(accountId);

      // Run
      List<AccountSharedValues> accountSharedValues = accountSharedServiceSample.add(accountSharedOperation);

      // Get SharedListId
      List<Long> sharedListIds = new ArrayList<>();
      if (!accountSharedValues.isEmpty() && accountSharedValues.size() > 0) {
        for (AccountSharedValues accountSharedValue : accountSharedValues) {
          sharedListIds.add(accountSharedValue.getAccountShared().getSharedListId());
        }
      }

      // =================================================================
      // CampaignService::ADD
      // =================================================================
      // Set Operation
      CampaignOperation campaignOperation = campaignServiceSample.createSampleAddRequest(accountId, biddingStrategyId);

      // Run
      List<CampaignValues> campaignValues = campaignServiceSample.add(campaignOperation);

      long campaignId = 0;
      for (CampaignValues campaignValue : campaignValues) {
        if (CampaignType.STANDARD.equals(campaignValue.getCampaign().getCampaignType())
            && BiddingStrategyType.TARGET_SPEND.equals(campaignValue.getCampaign().getBiddingStrategyConfiguration().getBiddingStrategyType())) {
          campaignId = campaignValue.getCampaign().getCampaignId();
        }
      }

      // =================================================================
      // CampaignSharedSetService::add
      // =================================================================
      // Set Operation
      CampaignSharedSetOperation addCampaignSharedSetOperation = createSampleAddRequest(accountId, campaignId, sharedListIds);

      // Run
      List<CampaignSharedSetValues> addCampaignSharedSetValues = add(addCampaignSharedSetOperation);

      // =================================================================
      // CampaignSharedSetService::get
      // =================================================================
      // Set Operation
      CampaignSharedSetSelector campaignSharedSetSelector = createSampleGetRequest(accountId, addCampaignSharedSetValues);

      // Run
      get(campaignSharedSetSelector);

      // =================================================================
      // CampaignSharedSetService::remove
      // =================================================================
      // Set Operation
      CampaignSharedSetOperation removeCampaignSharedSetOperation = createSampleRemoveRequest(accountId, addCampaignSharedSetValues);

      // Run
      remove(removeCampaignSharedSetOperation);

      // =================================================================
      // CampaignSharedSetService::remove
      // =================================================================
      // Set Operation
      CampaignOperation removeCampaignOperation = campaignServiceSample.createSampleRemoveRequest(accountId, campaignValues);

      // Run
      campaignServiceSample.remove(removeCampaignOperation);

      // =================================================================
      // AccountSharedService::remove
      // =================================================================
      // Set Operation
      AccountSharedOperation removeAccountSharedOperation = accountSharedServiceSample.createSampleRemoveRequest(accountId, accountSharedValues);

      // Run
      accountSharedServiceSample.remove(removeAccountSharedOperation);

    } catch (Exception e) {
      e.printStackTrace();
      throw e;
    }
  }

  /**
   * Sample Program for CampaignSharedSetService ADD.
   *
   * @param operation CampaignSharedSetOperation
   * @return List<CampaignSharedSetValues>
   */
  public static List<CampaignSharedSetValues> add(CampaignSharedSetOperation operation) throws Exception {

    // call API
    System.out.println("############################################");
    System.out.println("CampaignSharedSetService::mutate(ADD)");
    System.out.println("############################################");

    Holder<CampaignSharedSetReturnValue> campaignSharedSetReturnValueHolder = new Holder<CampaignSharedSetReturnValue>();
    Holder<List<Error>> campaignSharedSetErrorHolder = new Holder<List<Error>>();
    CampaignSharedSetServiceInterface campaignSharedSetService = SoapUtils.createServiceInterface(CampaignSharedSetServiceInterface.class, CampaignSharedSetService.class);
    campaignSharedSetService.mutate(operation, campaignSharedSetReturnValueHolder, campaignSharedSetErrorHolder);

    // Error
    if (campaignSharedSetErrorHolder.value != null && campaignSharedSetErrorHolder.value.size() > 0) {
      SoapUtils.displayErrors(new CampaignSharedSetServiceErrorEntityFactory(campaignSharedSetErrorHolder.value), true);
    }
    if (campaignSharedSetErrorHolder.value == null) {
      throw new Exception("NoDataResponse:CampaignSharedSetService mutate(add)");
    }

    // Display
    for (CampaignSharedSetValues campaignSharedSetValues : campaignSharedSetReturnValueHolder.value.getValues()) {
      if (campaignSharedSetValues.isOperationSucceeded()) {
        display(campaignSharedSetValues.getCampaignSharedSet());
      } else {
        SoapUtils.displayErrors(new CampaignSharedSetServiceErrorEntityFactory(campaignSharedSetValues.getError()), true);
      }
    }

    // Response
    return campaignSharedSetReturnValueHolder.value.getValues();
  }

  /**
   * Sample Program for CampaignSharedSetService REMOVE.
   *
   * @param operation CampaignSharedSetOperation
   * @return CampaignSharedSetValues
   */
  public static List<CampaignSharedSetValues> remove(CampaignSharedSetOperation operation) throws Exception {

    // call API
    System.out.println("############################################");
    System.out.println("CampaignSharedSetService::mutate(REMOVE)");
    System.out.println("############################################");

    Holder<CampaignSharedSetReturnValue> campaignSharedSetReturnValueHolder = new Holder<CampaignSharedSetReturnValue>();
    Holder<List<Error>> campaignSharedSetErrorHolder = new Holder<List<Error>>();
    CampaignSharedSetServiceInterface campaignSharedSetService = SoapUtils.createServiceInterface(CampaignSharedSetServiceInterface.class, CampaignSharedSetService.class);
    campaignSharedSetService.mutate(operation, campaignSharedSetReturnValueHolder, campaignSharedSetErrorHolder);

    // Error
    if (campaignSharedSetErrorHolder.value != null && campaignSharedSetErrorHolder.value.size() > 0) {
      SoapUtils.displayErrors(new CampaignSharedSetServiceErrorEntityFactory(campaignSharedSetErrorHolder.value), true);
    }
    if (campaignSharedSetErrorHolder.value == null) {
      throw new Exception("NoDataResponse:CampaignSharedSetService mutate(remove)");
    }

    // Display
    for (CampaignSharedSetValues campaignSharedSetValues : campaignSharedSetReturnValueHolder.value.getValues()) {
      if (campaignSharedSetValues.isOperationSucceeded()) {
        display(campaignSharedSetValues.getCampaignSharedSet());
      } else {
        SoapUtils.displayErrors(new CampaignSharedSetServiceErrorEntityFactory(campaignSharedSetValues.getError()), true);
      }
    }

    // Response
    return campaignSharedSetReturnValueHolder.value.getValues();
  }

  /**
   * Sample Program for CampaignSharedSetService GET.
   *
   * @param selector CampaignSharedSetSelector
   * @return CampaignSharedSetValues
   */
  public static List<CampaignSharedSetValues> get(CampaignSharedSetSelector selector) throws Exception {

    // Call API
    System.out.println("############################################");
    System.out.println("CampaignSharedSetService::get");
    System.out.println("############################################");

    Holder<CampaignSharedSetPage> campaignSharedSetPageHolder = new Holder<CampaignSharedSetPage>();
    Holder<List<Error>> errorHolder = new Holder<List<Error>>();
    CampaignSharedSetServiceInterface campaignSharedSetService = SoapUtils.createServiceInterface(CampaignSharedSetServiceInterface.class, CampaignSharedSetService.class);
    campaignSharedSetService.get(selector, campaignSharedSetPageHolder, errorHolder);

    // Error
    if (errorHolder.value != null && errorHolder.value.size() > 0) {
      SoapUtils.displayErrors(new CampaignSharedSetServiceErrorEntityFactory(errorHolder.value), true);
    }
    if (campaignSharedSetPageHolder.value == null) {
      throw new Exception("NoDataResponse:CampaignSharedSetService Get");
    }

    // Display
    for (CampaignSharedSetValues campaignSharedSetValues : campaignSharedSetPageHolder.value.getValues()) {
      if (campaignSharedSetValues.isOperationSucceeded()) {
        display(campaignSharedSetValues.getCampaignSharedSet());
      } else {
        SoapUtils.displayErrors(new CampaignSharedSetServiceErrorEntityFactory(campaignSharedSetValues.getError()), true);
      }
    }

    // Response
    return campaignSharedSetPageHolder.value.getValues();
  }

  /**
   * create sample request.
   *
   * @param accountId     long
   * @param campaignId     long
   * @param sharedListIds List<Long>
   * @return CampaignSharedSetOperation
   */
  public static CampaignSharedSetOperation createSampleAddRequest(long accountId, long campaignId, List<Long> sharedListIds) {

    // Set Operation
    CampaignSharedSetOperation operation = new CampaignSharedSetOperation();
    operation.setOperator(Operator.ADD);
    operation.setAccountId(accountId);

    // Set Operand
    for (long sharedListId : sharedListIds) {
      CampaignSharedSet operand = new CampaignSharedSet();
      operand.setSharedListId(sharedListId);
      operand.setCampaignId(campaignId);
      operation.getOperand().add(operand);
    }

    return operation;
  }

  /**
   * create sample request.
   *
   * @param accountId             long
   * @param campaignSharedSetValues List<CampaignSharedSetValues>
   * @return CampaignSharedSetOperation
   */
  public static CampaignSharedSetOperation createSampleRemoveRequest(long accountId, List<CampaignSharedSetValues> campaignSharedSetValues) {

    // Set Operation
    CampaignSharedSetOperation operation = new CampaignSharedSetOperation();
    operation.setOperator(Operator.REMOVE);
    operation.setAccountId(accountId);

    // Set Operand
    for (CampaignSharedSetValues campaignSharedSetValue : campaignSharedSetValues) {
      CampaignSharedSet operand = new CampaignSharedSet();
      operand.setSharedListId(campaignSharedSetValue.getCampaignSharedSet().getSharedListId());
      operand.setCampaignId(campaignSharedSetValue.getCampaignSharedSet().getCampaignId());
      operation.getOperand().add(operand);
    }

    return operation;
  }

  /**
   * create sample request.
   *
   * @param accountId             long
   * @param campaignSharedSetValues List<CampaignSharedSetValues>
   * @return CampaignSharedSetSelector
   */
  public static CampaignSharedSetSelector createSampleGetRequest(long accountId, List<CampaignSharedSetValues> campaignSharedSetValues) {

    // Set Selector
    CampaignSharedSetSelector selector = new CampaignSharedSetSelector();
    selector.setAccountId(accountId);

    // Set AccountSharedID
    for (CampaignSharedSetValues campaignSharedSetValue : campaignSharedSetValues) {
      selector.getCampaignIds().add((campaignSharedSetValue.getCampaignSharedSet().getCampaignId()));
    }

    // Set Paging
    Paging paging = new Paging();
    paging.setStartIndex(1);
    paging.setNumberResults(20);
    selector.setPaging(paging);

    return selector;
  }

  /**
   * display CampaignSharedSet entity to stdout.
   *
   * @param campaignSharedSet CampaignSharedSet entity for display.
   */
  private static void display(CampaignSharedSet campaignSharedSet) {
    System.out.println("accountId = " + campaignSharedSet.getAccountId());
    System.out.println("sharedListId = " + campaignSharedSet.getSharedListId());
    System.out.println("campaignId = " + campaignSharedSet.getCampaignId());
    System.out.println("sharedListName = " + campaignSharedSet.getSharedListName());
    System.out.println("campaignName = " + campaignSharedSet.getCampaignName());
    System.out.println("---------");
  }
}

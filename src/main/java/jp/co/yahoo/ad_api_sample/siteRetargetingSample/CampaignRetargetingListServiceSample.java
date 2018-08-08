package jp.co.yahoo.ad_api_sample.siteRetargetingSample;

import java.util.List;

import javax.xml.ws.Holder;

import jp.co.yahoo.ad_api_sample.error.impl.CampaignRetargetingListServiceErrorEntityFactory;
import jp.co.yahoo.ad_api_sample.util.SoapUtils;
import jp.yahooapis.ss.v201808.campaignretargetinglist.CriterionTargetList;
import jp.yahooapis.ss.v201808.Error;
import jp.yahooapis.ss.v201808.campaignretargetinglist.CampaignRetargetingList;
import jp.yahooapis.ss.v201808.campaignretargetinglist.CampaignRetargetingListOperation;
import jp.yahooapis.ss.v201808.campaignretargetinglist.CampaignRetargetingListPage;
import jp.yahooapis.ss.v201808.campaignretargetinglist.CampaignRetargetingListReturnValue;
import jp.yahooapis.ss.v201808.campaignretargetinglist.CampaignRetargetingListSelector;
import jp.yahooapis.ss.v201808.campaignretargetinglist.CampaignRetargetingListService;
import jp.yahooapis.ss.v201808.campaignretargetinglist.CampaignRetargetingListServiceInterface;
import jp.yahooapis.ss.v201808.campaignretargetinglist.CampaignRetargetingListValues;
import jp.yahooapis.ss.v201808.campaignretargetinglist.ExcludedType;
import jp.yahooapis.ss.v201808.campaignretargetinglist.Operator;
import jp.yahooapis.ss.v201808.Paging;

/**
 * Sample Program for CampaignRetargetingListService. Copyright (C) 2012 Yahoo Japan Corporation. All
 * Rights Reserved.
 */
public class CampaignRetargetingListServiceSample {

  /**
   * main method for CampaignRetargetingListServiceSample
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
      long targetListId = SoapUtils.getTargetListId();
      ExcludedType excludedType = ExcludedType.INCLUDED;

      // =================================================================
      // CampaignRetargetingListService::mutate(ADD)
      // =================================================================
      // Set Operation
      CampaignRetargetingListOperation addOperation = createSampleAddRequest(accountId, campaignId, targetListId, excludedType, 1.0d);

      // Run
      add(addOperation);

      // =================================================================
      // CampaignRetargetingListService::get
      // =================================================================
      // Set Selector
      CampaignRetargetingListSelector selector = createSampleGetRequest(accountId, campaignId, targetListId);

      // Run
      get(selector);

      // =================================================================
      // CampaignRetargetingListService::mutate(REMOVE)
      // =================================================================
      // Set Operation
      CampaignRetargetingListOperation removeOperation = createSampleRemoveRequest(accountId, campaignId, targetListId, excludedType);

      // Run
      remove(removeOperation);

    } catch (Exception e) {
      e.printStackTrace();
      throw e;
    }
  }


  /**
   * Sample Program for CampaignRetargetingListService ADD.
   *
   * @param operation CampaignRetargetingListOperation
   * @return CampaignRetargetingListValues
   * @throws Exception
   */
  public static List<CampaignRetargetingListValues> add(CampaignRetargetingListOperation operation) throws Exception {

    // Call API
    System.out.println("############################################");
    System.out.println("CampaignRetargetingListService::mutate(ADD)");
    System.out.println("############################################");

    Holder<CampaignRetargetingListReturnValue> CampaignRetargetingListReturnValueHolder = new Holder<CampaignRetargetingListReturnValue>();
    Holder<List<Error>> errorHolder = new Holder<List<Error>>();
    CampaignRetargetingListServiceInterface CampaignRetargetingListService = SoapUtils.createServiceInterface(CampaignRetargetingListServiceInterface.class, CampaignRetargetingListService.class);
    CampaignRetargetingListService.mutate(operation, CampaignRetargetingListReturnValueHolder, errorHolder);

    // Error
    if (errorHolder.value != null && errorHolder.value.size() > 0) {
      SoapUtils.displayErrors(new CampaignRetargetingListServiceErrorEntityFactory(errorHolder.value), true);
    }
    if (CampaignRetargetingListReturnValueHolder.value == null) {
      throw new Exception("NoDataResponse:CampaignRetargetingListService Add");
    }

    // Display
    for (CampaignRetargetingListValues CampaignRetargetingListValues : CampaignRetargetingListReturnValueHolder.value.getValues()) {
      if (CampaignRetargetingListValues.isOperationSucceeded()) {
        display(CampaignRetargetingListValues.getCampaignRetargetingList());
      } else {
        SoapUtils.displayErrors(new CampaignRetargetingListServiceErrorEntityFactory(CampaignRetargetingListValues.getError()), true);
      }
    }

    // Response
    return CampaignRetargetingListReturnValueHolder.value.getValues();
  }

  /**
   * Sample Program for CampaignRetargetingListService REMOVE.
   *
   * @param operation CampaignRetargetingListOperation
   * @return CampaignRetargetingListValues
   * @throws Exception
   */
  public static List<CampaignRetargetingListValues> remove(CampaignRetargetingListOperation operation) throws Exception {

    // Call API
    System.out.println("############################################");
    System.out.println("CampaignRetargetingListService::mutate(REMOVE)");
    System.out.println("############################################");

    Holder<CampaignRetargetingListReturnValue> CampaignRetargetingListReturnValueHolder = new Holder<CampaignRetargetingListReturnValue>();
    Holder<List<Error>> errorHolder = new Holder<List<Error>>();
    CampaignRetargetingListServiceInterface CampaignRetargetingListService = SoapUtils.createServiceInterface(CampaignRetargetingListServiceInterface.class, CampaignRetargetingListService.class);
    CampaignRetargetingListService.mutate(operation, CampaignRetargetingListReturnValueHolder, errorHolder);

    // Error
    if (errorHolder.value != null && errorHolder.value.size() > 0) {
      SoapUtils.displayErrors(new CampaignRetargetingListServiceErrorEntityFactory(errorHolder.value), true);
    }
    if (CampaignRetargetingListReturnValueHolder.value == null) {
      throw new Exception("NoDataResponse:CampaignRetargetingListService Remove");
    }

    // Display
    for (CampaignRetargetingListValues CampaignRetargetingListValues : CampaignRetargetingListReturnValueHolder.value.getValues()) {
      if (CampaignRetargetingListValues.isOperationSucceeded()) {
        display(CampaignRetargetingListValues.getCampaignRetargetingList());
      } else {
        SoapUtils.displayErrors(new CampaignRetargetingListServiceErrorEntityFactory(CampaignRetargetingListValues.getError()), true);
      }
    }

    // Response
    return CampaignRetargetingListReturnValueHolder.value.getValues();
  }

  /**
   * Sample Program for CampaignRetargetingListService GET.
   *
   * @param selector CampaignRetargetingListSelector
   * @return CampaignRetargetingListValues
   * @throws Exception
   */
  public static List<CampaignRetargetingListValues> get(CampaignRetargetingListSelector selector) throws Exception {

    // Call API
    System.out.println("############################################");
    System.out.println("CampaignRetargetingListService::get");
    System.out.println("############################################");

    Holder<CampaignRetargetingListPage> CampaignRetargetingListPage = new Holder<CampaignRetargetingListPage>();
    Holder<List<Error>> errorHolder = new Holder<List<Error>>();
    CampaignRetargetingListServiceInterface CampaignRetargetingListService = SoapUtils.createServiceInterface(CampaignRetargetingListServiceInterface.class, CampaignRetargetingListService.class);
    CampaignRetargetingListService.get(selector, CampaignRetargetingListPage, errorHolder);

    // Error
    if (errorHolder.value != null && errorHolder.value.size() > 0) {
      SoapUtils.displayErrors(new CampaignRetargetingListServiceErrorEntityFactory(errorHolder.value), true);
    }
    if (CampaignRetargetingListPage.value == null) {
      throw new Exception("NoDataResponse:CampaignRetargetingListService Get");
    }

    // Display
    for (CampaignRetargetingListValues CampaignRetargetingListValues : CampaignRetargetingListPage.value.getValues()) {
      if (CampaignRetargetingListValues.isOperationSucceeded()) {
        display(CampaignRetargetingListValues.getCampaignRetargetingList());
      } else {
        SoapUtils.displayErrors(new CampaignRetargetingListServiceErrorEntityFactory(CampaignRetargetingListValues.getError()), true);
      }
    }

    // Response
    return CampaignRetargetingListPage.value.getValues();
  }

  /**
   * display CampaignRetargetingList entity to stdout.
   *
   * @param CampaignRetargetingList CampaignRetargetingList entity for display.
   */
  public static void display(CampaignRetargetingList CampaignRetargetingList) {

    System.out.println("accountId = " + CampaignRetargetingList.getAccountId());
    System.out.println("campaignId = " + CampaignRetargetingList.getCampaignId());
    System.out.println("campaignName = " + CampaignRetargetingList.getCampaignName());
    if (CampaignRetargetingList.getCriterionTargetList() != null) {
      System.out.println("criterionTargetList/targetListId = " + CampaignRetargetingList.getCriterionTargetList().getTargetListId());
      System.out.println("criterionTargetList/targetListName = " + CampaignRetargetingList.getCriterionTargetList().getTargetListName());
      System.out.println("criterionTargetList/retargetingTrackId = " + CampaignRetargetingList.getCriterionTargetList().getRetargetingTrackId());
    }

    System.out.println("---------");
  }

  /**
   * create sample request.
   *
   * @param accountId long
   * @param campaignId long
   * @param targetListId long
   * @return CampaignRetargetingListOperation
   */
  public static CampaignRetargetingListOperation createSampleAddRequest(long accountId, long campaignId, long targetListId, ExcludedType excludedType, Double bidMultiplier) {
    CriterionTargetList criterionTargetList = new CriterionTargetList();
    criterionTargetList.setTargetListId(targetListId);

    CampaignRetargetingList campaignRetargetingList = new CampaignRetargetingList();
    campaignRetargetingList.setCampaignId(campaignId);
    campaignRetargetingList.setCriterionTargetList(criterionTargetList);
    campaignRetargetingList.setExcludedType(excludedType);
    campaignRetargetingList.setBidMultiplier(bidMultiplier);

    CampaignRetargetingListOperation addOperation = new CampaignRetargetingListOperation();
    addOperation.setOperator(Operator.ADD);
    addOperation.setAccountId(accountId);
    addOperation.getOperand().add(campaignRetargetingList);

    return addOperation;
  }

  /**
   * create sample request.
   *
   * @param accountId long
   * @param campaignId long
   * @param targetListId long
   * @return CampaignRetargetingListSelector
   */
  public static CampaignRetargetingListSelector createSampleGetRequest(long accountId, long campaignId, long targetListId) {
    CampaignRetargetingListSelector selector = new CampaignRetargetingListSelector();
    selector.setAccountId(accountId);
    selector.getCampaignIds().add(campaignId);
    selector.getTargetListIds().add(targetListId);

    Paging paging = new Paging();
    paging.setStartIndex(1);
    paging.setNumberResults(20);
    selector.setPaging(paging);

    return selector;
  }

  /**
   * create sample request.
   *
   * @param accountId long
   * @param campaignId long
   * @param targetListId long
   * @return CampaignRetargetingListOperation
   */
  public static CampaignRetargetingListOperation createSampleRemoveRequest(long accountId, long campaignId, long targetListId, ExcludedType excludedType) {
    CriterionTargetList setCriterionTargetList = new CriterionTargetList();
    setCriterionTargetList.setTargetListId(targetListId);

    CampaignRetargetingList setCampaignRetargetingList = new CampaignRetargetingList();
    setCampaignRetargetingList.setCampaignId(campaignId);
    setCampaignRetargetingList.setCriterionTargetList(setCriterionTargetList);
    setCampaignRetargetingList.setExcludedType(excludedType);

    CampaignRetargetingListOperation setOperation = new CampaignRetargetingListOperation();
    setOperation.setOperator(Operator.REMOVE);
    setOperation.setAccountId(accountId);
    setOperation.getOperand().add(setCampaignRetargetingList);

    return setOperation;
  }
}

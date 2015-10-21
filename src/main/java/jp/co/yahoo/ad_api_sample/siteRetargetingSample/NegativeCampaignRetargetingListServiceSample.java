package jp.co.yahoo.ad_api_sample.siteRetargetingSample;

import java.util.List;

import javax.xml.ws.Holder;

import jp.co.yahoo.ad_api_sample.error.impl.NegativeCampaignRetargetingListServiceErrorEntityFactory;
import jp.co.yahoo.ad_api_sample.util.SoapUtils;
import jp.yahooapis.ss.V5.NegativeCampaignRetargetingListService.CriterionTargetList;
import jp.yahooapis.ss.V5.NegativeCampaignRetargetingListService.Error;
import jp.yahooapis.ss.V5.NegativeCampaignRetargetingListService.NegativeCampaignRetargetingList;
import jp.yahooapis.ss.V5.NegativeCampaignRetargetingListService.NegativeCampaignRetargetingListOperation;
import jp.yahooapis.ss.V5.NegativeCampaignRetargetingListService.NegativeCampaignRetargetingListPage;
import jp.yahooapis.ss.V5.NegativeCampaignRetargetingListService.NegativeCampaignRetargetingListReturnValue;
import jp.yahooapis.ss.V5.NegativeCampaignRetargetingListService.NegativeCampaignRetargetingListSelector;
import jp.yahooapis.ss.V5.NegativeCampaignRetargetingListService.NegativeCampaignRetargetingListService;
import jp.yahooapis.ss.V5.NegativeCampaignRetargetingListService.NegativeCampaignRetargetingListServiceInterface;
import jp.yahooapis.ss.V5.NegativeCampaignRetargetingListService.NegativeCampaignRetargetingListValues;
import jp.yahooapis.ss.V5.NegativeCampaignRetargetingListService.Operator;
import jp.yahooapis.ss.V5.NegativeCampaignRetargetingListService.Paging;

/**
 * Sample Program for NegativeCampaignRetargetingListService. Copyright (C) 2012 Yahoo Japan Corporation. All
 * Rights Reserved.
 */
public class NegativeCampaignRetargetingListServiceSample {

  /**
   * main method for NegativeCampaignRetargetingListServiceSample
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

      // =================================================================
      // NegativeCampaignRetargetingListService::mutate(ADD)
      // =================================================================
      // Set Operation
      NegativeCampaignRetargetingListOperation addOperation = createSampleAddRequest(accountId, campaignId, targetListId);

      // Run
      add(addOperation);

      // =================================================================
      // NegativeCampaignRetargetingListService::get
      // =================================================================
      // Set Selector
      NegativeCampaignRetargetingListSelector selector = createSampleGetRequest(accountId, campaignId, targetListId);

      // Run
      get(selector);

      // =================================================================
      // NegativeCampaignRetargetingListService::mutate(REMOVE)
      // =================================================================
      // Set Operation
      NegativeCampaignRetargetingListOperation removeOperation = createSampleRemoveRequest(accountId, campaignId, targetListId);

      // Run
      remove(removeOperation);

    } catch (Exception e) {
      e.printStackTrace();
      throw e;
    }
  }


  /**
   * Sample Program for NegativeCampaignRetargetingListService ADD.
   *
   * @param operation NegativeCampaignRetargetingListOperation
   * @return NegativeCampaignRetargetingListValues
   * @throws Exception
   */
  public static List<NegativeCampaignRetargetingListValues> add(NegativeCampaignRetargetingListOperation operation) throws Exception {

    // Call API
    System.out.println("############################################");
    System.out.println("NegativeCampaignRetargetingListService::mutate(ADD)");
    System.out.println("############################################");

    Holder<NegativeCampaignRetargetingListReturnValue> negativeCampaignRetargetingListReturnValueHolder = new Holder<NegativeCampaignRetargetingListReturnValue>();
    Holder<List<Error>> errorHolder = new Holder<List<Error>>();
    NegativeCampaignRetargetingListServiceInterface negativeCampaignRetargetingListService = SoapUtils.createServiceInterface(NegativeCampaignRetargetingListServiceInterface.class, NegativeCampaignRetargetingListService.class);
    negativeCampaignRetargetingListService.mutate(operation, negativeCampaignRetargetingListReturnValueHolder, errorHolder);

    // Error
    if (errorHolder.value != null && errorHolder.value.size() > 0) {
      SoapUtils.displayErrors(new NegativeCampaignRetargetingListServiceErrorEntityFactory(errorHolder.value), true);
    }
    if (negativeCampaignRetargetingListReturnValueHolder.value == null) {
      throw new Exception("NoDataResponse:NegativeCampaignRetargetingListService Add");
    }

    // Display
    for (NegativeCampaignRetargetingListValues negativeCampaignRetargetingListValues : negativeCampaignRetargetingListReturnValueHolder.value.getValues()) {
      if (negativeCampaignRetargetingListValues.isOperationSucceeded()) {
        display(negativeCampaignRetargetingListValues.getNegativeCampaignRetargetingList());
      } else {
        SoapUtils.displayErrors(new NegativeCampaignRetargetingListServiceErrorEntityFactory(negativeCampaignRetargetingListValues.getError()), true);
      }
    }

    // Response
    return negativeCampaignRetargetingListReturnValueHolder.value.getValues();
  }

  /**
   * Sample Program for NegativeCampaignRetargetingListService REMOVE.
   *
   * @param operation NegativeCampaignRetargetingListOperation
   * @return NegativeCampaignRetargetingListValues
   * @throws Exception
   */
  public static List<NegativeCampaignRetargetingListValues> remove(NegativeCampaignRetargetingListOperation operation) throws Exception {

    // Call API
    System.out.println("############################################");
    System.out.println("NegativeCampaignRetargetingListService::mutate(REMOVE)");
    System.out.println("############################################");

    Holder<NegativeCampaignRetargetingListReturnValue> negativeCampaignRetargetingListReturnValueHolder = new Holder<NegativeCampaignRetargetingListReturnValue>();
    Holder<List<Error>> errorHolder = new Holder<List<Error>>();
    NegativeCampaignRetargetingListServiceInterface negativeCampaignRetargetingListService = SoapUtils.createServiceInterface(NegativeCampaignRetargetingListServiceInterface.class, NegativeCampaignRetargetingListService.class);
    negativeCampaignRetargetingListService.mutate(operation, negativeCampaignRetargetingListReturnValueHolder, errorHolder);

    // Error
    if (errorHolder.value != null && errorHolder.value.size() > 0) {
      SoapUtils.displayErrors(new NegativeCampaignRetargetingListServiceErrorEntityFactory(errorHolder.value), true);
    }
    if (negativeCampaignRetargetingListReturnValueHolder.value == null) {
      throw new Exception("NoDataResponse:NegativeCampaignRetargetingListService Remove");
    }

    // Display
    for (NegativeCampaignRetargetingListValues negativeCampaignRetargetingListValues : negativeCampaignRetargetingListReturnValueHolder.value.getValues()) {
      if (negativeCampaignRetargetingListValues.isOperationSucceeded()) {
        display(negativeCampaignRetargetingListValues.getNegativeCampaignRetargetingList());
      } else {
        SoapUtils.displayErrors(new NegativeCampaignRetargetingListServiceErrorEntityFactory(negativeCampaignRetargetingListValues.getError()), true);
      }
    }

    // Response
    return negativeCampaignRetargetingListReturnValueHolder.value.getValues();
  }

  /**
   * Sample Program for NegativeCampaignRetargetingListService GET.
   *
   * @param selector NegativeCampaignRetargetingListSelector
   * @return NegativeCampaignRetargetingListValues
   * @throws Exception
   */
  public static List<NegativeCampaignRetargetingListValues> get(NegativeCampaignRetargetingListSelector selector) throws Exception {

    // Call API
    System.out.println("############################################");
    System.out.println("NegativeCampaignRetargetingListService::get");
    System.out.println("############################################");

    Holder<NegativeCampaignRetargetingListPage> negativeCampaignRetargetingListPage = new Holder<NegativeCampaignRetargetingListPage>();
    Holder<List<Error>> errorHolder = new Holder<List<Error>>();
    NegativeCampaignRetargetingListServiceInterface negativeCampaignRetargetingListService = SoapUtils.createServiceInterface(NegativeCampaignRetargetingListServiceInterface.class, NegativeCampaignRetargetingListService.class);
    negativeCampaignRetargetingListService.get(selector, negativeCampaignRetargetingListPage, errorHolder);

    // Error
    if (errorHolder.value != null && errorHolder.value.size() > 0) {
      SoapUtils.displayErrors(new NegativeCampaignRetargetingListServiceErrorEntityFactory(errorHolder.value), true);
    }
    if (negativeCampaignRetargetingListPage.value == null) {
      throw new Exception("NoDataResponse:NegativeCampaignRetargetingListService Get");
    }

    // Display
    for (NegativeCampaignRetargetingListValues negativeCampaignRetargetingListValues : negativeCampaignRetargetingListPage.value.getValues()) {
      if (negativeCampaignRetargetingListValues.isOperationSucceeded()) {
        display(negativeCampaignRetargetingListValues.getNegativeCampaignRetargetingList());
      } else {
        SoapUtils.displayErrors(new NegativeCampaignRetargetingListServiceErrorEntityFactory(negativeCampaignRetargetingListValues.getError()), true);
      }
    }

    // Response
    return negativeCampaignRetargetingListPage.value.getValues();
  }

  /**
   * display NegativeCampaignRetargetingList entity to stdout.
   *
   * @param negativeCampaignRetargetingList NegativeCampaignRetargetingList entity for display.
   */
  public static void display(NegativeCampaignRetargetingList negativeCampaignRetargetingList) {

    System.out.println("accountId = " + negativeCampaignRetargetingList.getAccountId());
    System.out.println("campaignId = " + negativeCampaignRetargetingList.getCampaignId());
    System.out.println("campaignName = " + negativeCampaignRetargetingList.getCampaignName());
    if (negativeCampaignRetargetingList.getCriterionTargetList() != null) {
      System.out.println("criterionTargetList/targetListId = " + negativeCampaignRetargetingList.getCriterionTargetList().getTargetListId());
      System.out.println("criterionTargetList/targetListName = " + negativeCampaignRetargetingList.getCriterionTargetList().getTargetListName());
    }

    System.out.println("---------");
  }

  /**
   * create sample request.
   *
   * @param accountId long
   * @param campaignId long
   * @param targetListId long
   * @return NegativeCampaignRetargetingListOperation
   */
  public static NegativeCampaignRetargetingListOperation createSampleAddRequest(long accountId, long campaignId, long targetListId) {
    CriterionTargetList criterionTargetList = new CriterionTargetList();
    criterionTargetList.setTargetListId(targetListId);

    NegativeCampaignRetargetingList negativeCampaignRetargetingList = new NegativeCampaignRetargetingList();
    negativeCampaignRetargetingList.setCampaignId(campaignId);
    negativeCampaignRetargetingList.setCriterionTargetList(criterionTargetList);

    NegativeCampaignRetargetingListOperation addOperation = new NegativeCampaignRetargetingListOperation();
    addOperation.setOperator(Operator.ADD);
    addOperation.setAccountId(accountId);
    addOperation.getOperand().add(negativeCampaignRetargetingList);

    return addOperation;
  }

  /**
   * create sample request.
   *
   * @param accountId long
   * @param campaignId long
   * @param targetListId long
   * @return NegativeCampaignRetargetingListSelector
   */
  public static NegativeCampaignRetargetingListSelector createSampleGetRequest(long accountId, long campaignId, long targetListId) {
    NegativeCampaignRetargetingListSelector selector = new NegativeCampaignRetargetingListSelector();
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
   * @return NegativeCampaignRetargetingListOperation
   */
  public static NegativeCampaignRetargetingListOperation createSampleRemoveRequest(long accountId, long campaignId, long targetListId) {
    CriterionTargetList setCriterionTargetList = new CriterionTargetList();
    setCriterionTargetList.setTargetListId(targetListId);

    NegativeCampaignRetargetingList setNegativeCampaignRetargetingList = new NegativeCampaignRetargetingList();
    setNegativeCampaignRetargetingList.setCampaignId(campaignId);
    setNegativeCampaignRetargetingList.setCriterionTargetList(setCriterionTargetList);

    NegativeCampaignRetargetingListOperation setOperation = new NegativeCampaignRetargetingListOperation();
    setOperation.setOperator(Operator.REMOVE);
    setOperation.setAccountId(accountId);
    setOperation.getOperand().add(setNegativeCampaignRetargetingList);

    return setOperation;
  }
}

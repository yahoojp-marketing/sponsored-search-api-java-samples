package jp.co.yahoo.ad_api_sample.siteRetargetingSample;

import java.util.ArrayList;
import java.util.List;

import javax.xml.ws.Holder;

import jp.co.yahoo.ad_api_sample.error.impl.AdGroupRetargetingListServiceErrorEntityFactory;
import jp.co.yahoo.ad_api_sample.util.SoapUtils;
import jp.yahooapis.ss.v201808.adgroupretargetinglist.AdGroupRetargetingList;
import jp.yahooapis.ss.v201808.adgroupretargetinglist.AdGroupRetargetingListOperation;
import jp.yahooapis.ss.v201808.adgroupretargetinglist.AdGroupRetargetingListPage;
import jp.yahooapis.ss.v201808.adgroupretargetinglist.AdGroupRetargetingListReturnValue;
import jp.yahooapis.ss.v201808.adgroupretargetinglist.AdGroupRetargetingListSelector;
import jp.yahooapis.ss.v201808.adgroupretargetinglist.AdGroupRetargetingListService;
import jp.yahooapis.ss.v201808.adgroupretargetinglist.AdGroupRetargetingListServiceInterface;
import jp.yahooapis.ss.v201808.adgroupretargetinglist.AdGroupRetargetingListValues;
import jp.yahooapis.ss.v201808.adgroupretargetinglist.CriterionTargetList;
import jp.yahooapis.ss.v201808.Error;
import jp.yahooapis.ss.v201808.adgroupretargetinglist.ExcludedType;
import jp.yahooapis.ss.v201808.adgroupretargetinglist.Operator;
import jp.yahooapis.ss.v201808.Paging;
import jp.yahooapis.ss.v201808.retargetinglist.RetargetingListSelector;
import jp.yahooapis.ss.v201808.retargetinglist.RetargetingListValues;

/**
 * Sample Program for AdGroupRetargetingListServiceService. Copyright (C) 2012 Yahoo Japan Corporation. All
 * Rights Reserved.
 */
public class AdGroupRetargetingListServiceSample {

  /**
   * main method for AdGroupRetargetingListServiceSample
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
      long adGroupId = SoapUtils.getAdGroupId();
      List<Long> targetListIds = SoapUtils.getTargetListIds();


      // =================================================================
      // AdGroupRetargetingListServiceService::mutate(ADD)
      // =================================================================
      // Set Operation
      AdGroupRetargetingListOperation addOperation = createSampleAddRequest(accountId, campaignId, targetListIds, adGroupId);

      // Run
      add(addOperation);

      // =================================================================
      // AdGroupRetargetingListServiceService::get
      // =================================================================
      // Set Selector
      AdGroupRetargetingListSelector selector = createSampleGetRequest(accountId, campaignId, targetListIds, adGroupId);

      // Run
      List<AdGroupRetargetingListValues> getResponse = get(selector);

      // =================================================================
      // AdGroupRetargetingListServiceService::mutate(SET)
      // =================================================================
      // Set Operation
      AdGroupRetargetingListOperation setOperation = createSampleSetRequest(accountId, getResponse);

      // Run
      set(setOperation);

      // =================================================================
      // AdGroupRetargetingListServiceService::mutate(REMOVE)
      // =================================================================
      // Set Operation
      AdGroupRetargetingListOperation removeOperation = createSampleRemoveRequest(accountId, getResponse);

      // Run
      remove(removeOperation);

    } catch (Exception e) {
      e.printStackTrace();
      throw e;
    }
  }


  /**
   * Sample Program for AdGroupRetargetingListService ADD.
   *
   * @param operation AdGroupRetargetingListOperation
   * @return AdGroupRetargetingListValues
   * @throws Exception
   */
  public static List<AdGroupRetargetingListValues> add(AdGroupRetargetingListOperation operation) throws Exception {

    // Call API
    System.out.println("############################################");
    System.out.println("AdGroupRetargetingListService::mutate(ADD)");
    System.out.println("############################################");

    Holder<AdGroupRetargetingListReturnValue> adGroupRetargetingListReturnValueHolder = new Holder<AdGroupRetargetingListReturnValue>();
    Holder<List<Error>> errorHolder = new Holder<List<Error>>();
    AdGroupRetargetingListServiceInterface adGroupRetargetingListService = SoapUtils.createServiceInterface(AdGroupRetargetingListServiceInterface.class, AdGroupRetargetingListService.class);
    adGroupRetargetingListService.mutate(operation, adGroupRetargetingListReturnValueHolder, errorHolder);

    // Error
    if (errorHolder.value != null && errorHolder.value.size() > 0) {
      SoapUtils.displayErrors(new AdGroupRetargetingListServiceErrorEntityFactory(errorHolder.value), true);
    }
    if (adGroupRetargetingListReturnValueHolder.value == null) {
      throw new Exception("NoDataResponse:AdGroupRetargetingListService Add");
    }

    // Display
    for (AdGroupRetargetingListValues adGroupRetargetingListValues : adGroupRetargetingListReturnValueHolder.value.getValues()) {
      if (adGroupRetargetingListValues.isOperationSucceeded()) {
        display(adGroupRetargetingListValues.getAdGroupRetargetingList());
      } else {
        SoapUtils.displayErrors(new AdGroupRetargetingListServiceErrorEntityFactory(adGroupRetargetingListValues.getError()), true);
      }
    }

    // Response
    return adGroupRetargetingListReturnValueHolder.value.getValues();
  }

  /**
   * Sample Program for AdGroupRetargetingListService SET.
   *
   * @param operation AdGroupRetargetingListOperation
   * @return AdGroupRetargetingListValues
   * @throws Exception
   */
  public static List<AdGroupRetargetingListValues> set(AdGroupRetargetingListOperation operation) throws Exception {

    // Call API
    System.out.println("############################################");
    System.out.println("AdGroupRetargetingListService::mutate(SET)");
    System.out.println("############################################");

    Holder<AdGroupRetargetingListReturnValue> adGroupRetargetingListReturnValueHolder = new Holder<AdGroupRetargetingListReturnValue>();
    Holder<List<Error>> errorHolder = new Holder<List<Error>>();
    AdGroupRetargetingListServiceInterface adGroupRetargetingListService = SoapUtils.createServiceInterface(AdGroupRetargetingListServiceInterface.class, AdGroupRetargetingListService.class);
    adGroupRetargetingListService.mutate(operation, adGroupRetargetingListReturnValueHolder, errorHolder);

    // Error
    if (errorHolder.value != null && errorHolder.value.size() > 0) {
      SoapUtils.displayErrors(new AdGroupRetargetingListServiceErrorEntityFactory(errorHolder.value), true);
    }
    if (adGroupRetargetingListReturnValueHolder.value == null) {
      throw new Exception("NoDataResponse:AdGroupRetargetingListService Set");
    }

    // Display
    for (AdGroupRetargetingListValues adGroupRetargetingListValues : adGroupRetargetingListReturnValueHolder.value.getValues()) {
      if (adGroupRetargetingListValues.isOperationSucceeded()) {
        display(adGroupRetargetingListValues.getAdGroupRetargetingList());
      } else {
        SoapUtils.displayErrors(new AdGroupRetargetingListServiceErrorEntityFactory(adGroupRetargetingListValues.getError()), true);
      }
    }

    // Response
    return adGroupRetargetingListReturnValueHolder.value.getValues();
  }

  /**
   * Sample Program for AdGroupRetargetingListService REMOVE.
   *
   * @param operation AdGroupRetargetingListOperation
   * @return AdGroupRetargetingListValues
   * @throws Exception
   */
  public static List<AdGroupRetargetingListValues> remove(AdGroupRetargetingListOperation operation) throws Exception {

    // Call API
    System.out.println("############################################");
    System.out.println("AdGroupRetargetingListService::mutate(REMOVE)");
    System.out.println("############################################");

    Holder<AdGroupRetargetingListReturnValue> adGroupRetargetingListReturnValueHolder = new Holder<AdGroupRetargetingListReturnValue>();
    Holder<List<Error>> errorHolder = new Holder<List<Error>>();
    AdGroupRetargetingListServiceInterface adGroupRetargetingListService = SoapUtils.createServiceInterface(AdGroupRetargetingListServiceInterface.class, AdGroupRetargetingListService.class);
    adGroupRetargetingListService.mutate(operation, adGroupRetargetingListReturnValueHolder, errorHolder);

    // Error
    if (errorHolder.value != null && errorHolder.value.size() > 0) {
      SoapUtils.displayErrors(new AdGroupRetargetingListServiceErrorEntityFactory(errorHolder.value), true);
    }
    if (adGroupRetargetingListReturnValueHolder.value == null) {
      throw new Exception("NoDataResponse:AdGroupRetargetingListService Remove");
    }

    // Display
    for (AdGroupRetargetingListValues adGroupRetargetingListValues : adGroupRetargetingListReturnValueHolder.value.getValues()) {
      if (adGroupRetargetingListValues.isOperationSucceeded()) {
        display(adGroupRetargetingListValues.getAdGroupRetargetingList());
      } else {
        SoapUtils.displayErrors(new AdGroupRetargetingListServiceErrorEntityFactory(adGroupRetargetingListValues.getError()), true);
      }
    }

    // Response
    return adGroupRetargetingListReturnValueHolder.value.getValues();
  }

  /**
   * Sample Program for AdGroupRetargetingListService GET.
   *
   * @param selector AdGroupRetargetingListSelector
   * @return AdGroupRetargetingListValues
   * @throws Exception
   */
  public static List<AdGroupRetargetingListValues> get(AdGroupRetargetingListSelector selector) throws Exception {

    // Call API
    System.out.println("############################################");
    System.out.println("AdGroupRetargetingListService::get");
    System.out.println("############################################");

    Holder<AdGroupRetargetingListPage> adGroupRetargetingListPage = new Holder<AdGroupRetargetingListPage>();
    Holder<List<Error>> errorHolder = new Holder<List<Error>>();
    AdGroupRetargetingListServiceInterface adGroupRetargetingListService = SoapUtils.createServiceInterface(AdGroupRetargetingListServiceInterface.class, AdGroupRetargetingListService.class);
    adGroupRetargetingListService.get(selector, adGroupRetargetingListPage, errorHolder);

    // Error
    if (errorHolder.value != null && errorHolder.value.size() > 0) {
      SoapUtils.displayErrors(new AdGroupRetargetingListServiceErrorEntityFactory(errorHolder.value), true);
    }
    if (adGroupRetargetingListPage.value == null) {
      throw new Exception("NoDataResponse:AdGroupRetargetingListService Get");
    }

    // Display
    for (AdGroupRetargetingListValues adGroupRetargetingListValues : adGroupRetargetingListPage.value.getValues()) {
      if (adGroupRetargetingListValues.isOperationSucceeded()) {
        display(adGroupRetargetingListValues.getAdGroupRetargetingList());
      } else {
        SoapUtils.displayErrors(new AdGroupRetargetingListServiceErrorEntityFactory(adGroupRetargetingListValues.getError()), true);
      }
    }

    // Response
    return adGroupRetargetingListPage.value.getValues();
  }

  /**
   * display AdGroupRetargetingList entity to stdout.
   *
   * @param adGroupRetargetingList AdGroupRetargetingList entity for display.
   */
  public static void display(AdGroupRetargetingList adGroupRetargetingList) {

    System.out.println("accountId = " + adGroupRetargetingList.getAccountId());
    System.out.println("campaignId = " + adGroupRetargetingList.getCampaignId());
    System.out.println("campaignName = " + adGroupRetargetingList.getCampaignName());
    System.out.println("adGroupId = " + adGroupRetargetingList.getAdGroupId());
    System.out.println("adGroupName = " + adGroupRetargetingList.getAdGroupName());
    System.out.println("criterionTargetList/targetListId = " + adGroupRetargetingList.getCriterionTargetList().getTargetListId());
    System.out.println("criterionTargetList/targetListName = " + adGroupRetargetingList.getCriterionTargetList().getTargetListName());
    System.out.println("criterionTargetList/retargetingTrackId = " + adGroupRetargetingList.getCriterionTargetList().getRetargetingTrackId());
    System.out.println("excludedType = " + adGroupRetargetingList.getExcludedType());
    System.out.println("bidMultiplier = " + adGroupRetargetingList.getBidMultiplier());

    System.out.println("---------");
  }

  /**
   * create sample request.
   *
   * @param accountId long
   * @param campaignId long
   * @param targetListIdList List
   * @param adGroupId long
   * @return CampaignRetargetingListOperation
   */
  public static AdGroupRetargetingListOperation createSampleAddRequest(long accountId, long campaignId, List<Long> targetListIdList, long adGroupId) {
    CriterionTargetList criterionTargetList1 = new CriterionTargetList();
    criterionTargetList1.setTargetListId(targetListIdList.get(0));
    CriterionTargetList criterionTargetList2 = new CriterionTargetList();
    criterionTargetList2.setTargetListId(targetListIdList.get(1));

    AdGroupRetargetingList adGroupRetargetingList1 = new AdGroupRetargetingList();
    adGroupRetargetingList1.setCampaignId(campaignId);
    adGroupRetargetingList1.setAdGroupId(adGroupId);
    adGroupRetargetingList1.setCriterionTargetList(criterionTargetList1);
    adGroupRetargetingList1.setExcludedType(ExcludedType.INCLUDED);
    adGroupRetargetingList1.setBidMultiplier(1.00);

    AdGroupRetargetingList adGroupRetargetingList2 = new AdGroupRetargetingList();
    adGroupRetargetingList2.setCampaignId(campaignId);
    adGroupRetargetingList2.setAdGroupId(adGroupId);
    adGroupRetargetingList2.setCriterionTargetList(criterionTargetList2);
    adGroupRetargetingList2.setExcludedType(ExcludedType.EXCLUDED);

    AdGroupRetargetingListOperation addOperation = new AdGroupRetargetingListOperation();
    addOperation.setOperator(Operator.ADD);
    addOperation.setAccountId(accountId);
    addOperation.getOperand().add(adGroupRetargetingList1);
    addOperation.getOperand().add(adGroupRetargetingList2);

    return addOperation;
  }

  /**
   * create sample request.
   *
   * @param accountId long
   * @param campaignId long
   * @param targetListIdList List
   * @param adGroupId long
   * @return AdGroupRetargetingListSelector
   */
  public static AdGroupRetargetingListSelector createSampleGetRequest(long accountId, long campaignId, List<Long> targetListIdList, long adGroupId) {
    AdGroupRetargetingListSelector selector = new AdGroupRetargetingListSelector();
    selector.setAccountId(accountId);
    selector.getCampaignIds().add(campaignId);
    selector.getTargetListIds().addAll(targetListIdList);
    selector.getAdGroupIds().add(adGroupId);

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
   * @param adGroupRetargetingListValuesList AdGroupRetargetingListValues
   * @return CampaignRetargetingListOperation
   */
  public static AdGroupRetargetingListOperation createSampleSetRequest(long accountId, List<AdGroupRetargetingListValues> adGroupRetargetingListValuesList) {
    List<AdGroupRetargetingList> setAdGroupRetargetingListList = new ArrayList<AdGroupRetargetingList>();
    for (AdGroupRetargetingListValues adGroupRetargetingListValues : adGroupRetargetingListValuesList) {
      CriterionTargetList setCriterionTargetList = new CriterionTargetList();
      setCriterionTargetList.setTargetListId(adGroupRetargetingListValues.getAdGroupRetargetingList().getCriterionTargetList().getTargetListId());

      AdGroupRetargetingList setAdGroupRetargetingList = new AdGroupRetargetingList();
      setAdGroupRetargetingList.setCampaignId(adGroupRetargetingListValues.getAdGroupRetargetingList().getCampaignId());
      setAdGroupRetargetingList.setAdGroupId(adGroupRetargetingListValues.getAdGroupRetargetingList().getAdGroupId());
      setAdGroupRetargetingList.setCriterionTargetList(setCriterionTargetList);
      setAdGroupRetargetingList.setExcludedType(adGroupRetargetingListValues.getAdGroupRetargetingList().getExcludedType());
      if (adGroupRetargetingListValues.getAdGroupRetargetingList().getExcludedType() == ExcludedType.INCLUDED) {
        setAdGroupRetargetingList.setBidMultiplier(Double.valueOf(10.00));
      }

      setAdGroupRetargetingListList.add(setAdGroupRetargetingList);
    }

    AdGroupRetargetingListOperation setOperation = new AdGroupRetargetingListOperation();
    setOperation.setOperator(Operator.SET);
    setOperation.setAccountId(accountId);
    setOperation.getOperand().addAll(setAdGroupRetargetingListList);

    return setOperation;
  }

  /**
   * create sample request.
   *
   * @param accountId long
   * @param adGroupRetargetingListValuesList AdGroupRetargetingListValues
   * @return CampaignRetargetingListOperation
   */
  public static AdGroupRetargetingListOperation createSampleRemoveRequest(long accountId, List<AdGroupRetargetingListValues> adGroupRetargetingListValuesList) {
    List<AdGroupRetargetingList> removeAdGroupRetargetingListList = new ArrayList<AdGroupRetargetingList>();
    for (AdGroupRetargetingListValues adGroupRetargetingListValues : adGroupRetargetingListValuesList) {
      CriterionTargetList removeCriterionTargetList = new CriterionTargetList();
      removeCriterionTargetList.setTargetListId(adGroupRetargetingListValues.getAdGroupRetargetingList().getCriterionTargetList().getTargetListId());

      AdGroupRetargetingList removeAdGroupRetargetingList = new AdGroupRetargetingList();
      removeAdGroupRetargetingList.setCampaignId(adGroupRetargetingListValues.getAdGroupRetargetingList().getCampaignId());
      removeAdGroupRetargetingList.setAdGroupId(adGroupRetargetingListValues.getAdGroupRetargetingList().getAdGroupId());
      removeAdGroupRetargetingList.setCriterionTargetList(removeCriterionTargetList);
      removeAdGroupRetargetingList.setExcludedType(adGroupRetargetingListValues.getAdGroupRetargetingList().getExcludedType());

      removeAdGroupRetargetingListList.add(removeAdGroupRetargetingList);
    }

    AdGroupRetargetingListOperation removeOperation = new AdGroupRetargetingListOperation();
    removeOperation.setOperator(Operator.REMOVE);
    removeOperation.setAccountId(accountId);
    removeOperation.getOperand().addAll(removeAdGroupRetargetingListList);

    return removeOperation;
  }
}

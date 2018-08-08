package jp.co.yahoo.ad_api_sample.dynamicAdsForSearchSample;

import jp.co.yahoo.ad_api_sample.adCustomizerSample.FeedFolderServiceSample;
import jp.co.yahoo.ad_api_sample.adSample.AdGroupServiceSample;
import jp.co.yahoo.ad_api_sample.adSample.CampaignServiceSample;
import jp.co.yahoo.ad_api_sample.error.impl.AdGroupWebpageServiceErrorEntityFactory;
import jp.co.yahoo.ad_api_sample.util.SoapUtils;
import jp.yahooapis.ss.v201808.Error;
import jp.yahooapis.ss.v201808.adgroup.AdGroupOperation;
import jp.yahooapis.ss.v201808.adgroup.AdGroupValues;
import jp.yahooapis.ss.v201808.adgroupwebpage.AdGroupWebpage;
import jp.yahooapis.ss.v201808.adgroupwebpage.AdGroupWebpageOperation;
import jp.yahooapis.ss.v201808.adgroupwebpage.AdGroupWebpageReturnValue;
import jp.yahooapis.ss.v201808.adgroupwebpage.AdGroupWebpageServiceInterface;
import jp.yahooapis.ss.v201808.adgroupwebpage.AdGroupWebpageValues;
import jp.yahooapis.ss.v201808.adgroupwebpage.Bid;
import jp.yahooapis.ss.v201808.adgroupwebpage.CampaignWebpageService;
import jp.yahooapis.ss.v201808.adgroupwebpage.ExcludedType;
import jp.yahooapis.ss.v201808.adgroupwebpage.Operator;
import jp.yahooapis.ss.v201808.adgroupwebpage.UserStatus;
import jp.yahooapis.ss.v201808.adgroupwebpage.Webpage;
import jp.yahooapis.ss.v201808.adgroupwebpage.WebpageCondition;
import jp.yahooapis.ss.v201808.adgroupwebpage.WebpageConditionType;
import jp.yahooapis.ss.v201808.adgroupwebpage.WebpageParameter;
import jp.yahooapis.ss.v201808.campaign.CampaignOperation;
import jp.yahooapis.ss.v201808.campaign.CampaignValues;
import jp.yahooapis.ss.v201808.feedfolder.FeedFolderOperation;
import jp.yahooapis.ss.v201808.feedfolder.FeedFolderPlaceholderType;
import jp.yahooapis.ss.v201808.feedfolder.FeedFolderValues;

import java.util.Arrays;
import java.util.List;

import javax.xml.ws.Holder;

/**
 * Sample Program for AdGroupWebpageService. Copyright (C) 2012 Yahoo Japan Corporation. All Rights Reserved.
 */
public class AdGroupWebpageServiceSample {
  /**
   * main method for AdGroupWebpageService
   *
   * @param args command line arguments
   */
  public static void main(String[] args) throws Exception {
    try {

      // =================================================================
      // Setting
      // =================================================================
      long accountId = SoapUtils.getAccountId();
      long feedFolderId = -1L;
      long campaignId = 0;
      long adGroupId = 0;

      // =================================================================
      // FeedFolderService ADD FOR DSA
      // =================================================================
      FeedFolderOperation addFeedFolderOperation = FeedFolderServiceSample.createSampleDasAddRequest(null, accountId);
      List<FeedFolderValues> feedFolderValues = FeedFolderServiceSample.add(addFeedFolderOperation);
      for (FeedFolderValues values : feedFolderValues) {
        if (values.getFeedFolder().getPlaceholderType().equals(FeedFolderPlaceholderType.DYNAMIC_AD_FOR_SEARCH_PAGE_FEEDS)) {
          feedFolderId = values.getFeedFolder().getFeedFolderId();
        }
      }

      // =================================================================
      // CampaignService::ADD FOR DSA
      // =================================================================
      // Set Operation
      CampaignOperation addCampaignOperation = CampaignServiceSample.createSampleDasAddRequest(null, accountId, feedFolderId);

      // Run
      List<CampaignValues> addCampaignValues = CampaignServiceSample.add(addCampaignOperation);
      // set CampaignId
      for (CampaignValues value : addCampaignValues) {
        campaignId = value.getCampaign().getCampaignId();
      }

      // =================================================================
      // AdGroupService ADD For DSA
      // =================================================================
      // Set Operation
      AdGroupOperation addAdGroupOperation = AdGroupServiceSample.createSampleDasAddRequest(null, accountId, campaignId);

      // Run
      List<AdGroupValues> adGroupValues = AdGroupServiceSample.add(addAdGroupOperation);
      // set adGroupId
      for (AdGroupValues value : adGroupValues) {
        adGroupId = value.getAdGroup().getAdGroupId();
      }

      // =================================================================
      // AdGroupWebpageService
      // =================================================================
      // add
      AdGroupWebpageOperation addAdGroupWebpageOperation = createSampleAddRequest(accountId, campaignId, adGroupId);
      List<AdGroupWebpageValues> adGroupWebpageValues = add(addAdGroupWebpageOperation);

      // set
      AdGroupWebpageOperation setAdGroupWebpageOperation = createSampleSetRequest(accountId, adGroupWebpageValues);
      adGroupWebpageValues = set(setAdGroupWebpageOperation);

      // remove
      AdGroupWebpageOperation removeAdGroupWebpageOperation = createSampleRemoveRequest(accountId, adGroupWebpageValues);
      adGroupWebpageValues = remove(removeAdGroupWebpageOperation);

      // =================================================================
      // AdGroupService REMOVE
      // =================================================================
      // Set Operation
      AdGroupOperation removeAdGroupOperation = AdGroupServiceSample.createSampleRemoveRequest(accountId, adGroupValues);

      // Run
      AdGroupServiceSample.remove(removeAdGroupOperation);

      // =================================================================
      // CampaignService::REMOVE
      // =================================================================
      // Set Operation
      CampaignOperation removeCampaignOperation = CampaignServiceSample.createSampleRemoveRequest(accountId, addCampaignValues);

      // Run
      CampaignServiceSample.remove(removeCampaignOperation);

      // =================================================================
      // FeedFolderService REMOVE
      // =================================================================
      // Set Operation
      FeedFolderOperation removeFeedFolderOperation = FeedFolderServiceSample.createSampleRemoveRequest(accountId, feedFolderValues);

      // Run
      FeedFolderServiceSample.remove(removeFeedFolderOperation);


    } catch (Exception e) {
      e.printStackTrace();
      throw e;
    }
  }

  /**
   * Sample Program for AdGroupWebpageService ADD.
   *
   * @param operation AdGroupWebpageOperation
   * @return AdGroupWebpageValues
   */
  public static List<AdGroupWebpageValues> add(AdGroupWebpageOperation operation) throws Exception {

    // Call API
    System.out.println("############################################");
    System.out.println("AdGroupWebpageService::mutate(ADD)");
    System.out.println("############################################");

    Holder<AdGroupWebpageReturnValue> adGroupAdReturnValueHolder = new Holder<AdGroupWebpageReturnValue>();
    Holder<List<Error>> errorHolder = new Holder<List<Error>>();
    AdGroupWebpageServiceInterface adGroupWebpageService = SoapUtils.createServiceInterface(AdGroupWebpageServiceInterface.class, CampaignWebpageService.class);
    adGroupWebpageService.mutate(operation, adGroupAdReturnValueHolder, errorHolder);

    // Error
    if (errorHolder.value != null && errorHolder.value.size() > 0) {
      SoapUtils.displayErrors(new AdGroupWebpageServiceErrorEntityFactory(errorHolder.value), true);
    }
    if (adGroupAdReturnValueHolder.value == null) {
      throw new Exception("NoDataResponse:AdGroupWebpageService Add");
    }

    // Display
    for (AdGroupWebpageValues adGroupWebpageValues : adGroupAdReturnValueHolder.value.getValues()) {
      if (adGroupWebpageValues.isOperationSucceeded()) {
        display(adGroupWebpageValues.getAdGroupWebpage());
      } else {
        SoapUtils.displayErrors(new AdGroupWebpageServiceErrorEntityFactory(adGroupWebpageValues.getError()), true);
      }
    }

    // Response
    return adGroupAdReturnValueHolder.value.getValues();
  }

  /**
   * Sample Program for AdGroupWebpageService SET.
   *
   * @param operation AdGroupWebpageOperation
   * @return AdGroupWebpageValues
   */
  public static List<AdGroupWebpageValues> set(AdGroupWebpageOperation operation) throws Exception {

    // Call API
    System.out.println("############################################");
    System.out.println("AdGroupWebpageService::mutate(SET)");
    System.out.println("############################################");

    Holder<AdGroupWebpageReturnValue> adGroupAdReturnValueHolder = new Holder<AdGroupWebpageReturnValue>();
    Holder<List<Error>> errorHolder = new Holder<List<Error>>();
    AdGroupWebpageServiceInterface adGroupWebpageService = SoapUtils.createServiceInterface(AdGroupWebpageServiceInterface.class, CampaignWebpageService.class);
    adGroupWebpageService.mutate(operation, adGroupAdReturnValueHolder, errorHolder);

    // Error
    if (errorHolder.value != null && errorHolder.value.size() > 0) {
      SoapUtils.displayErrors(new AdGroupWebpageServiceErrorEntityFactory(errorHolder.value), true);
    }
    if (adGroupAdReturnValueHolder.value == null) {
      throw new Exception("NoDataResponse:AdGroupWebpageService Set");
    }

    // Display
    for (AdGroupWebpageValues adGroupWebpageValues : adGroupAdReturnValueHolder.value.getValues()) {
      if (adGroupWebpageValues.isOperationSucceeded()) {
        display(adGroupWebpageValues.getAdGroupWebpage());
      } else {
        SoapUtils.displayErrors(new AdGroupWebpageServiceErrorEntityFactory(adGroupWebpageValues.getError()), true);
      }
    }

    // Response
    return adGroupAdReturnValueHolder.value.getValues();
  }

  /**
   * Sample Program for AdGroupWebpageService REMOVE.
   *
   * @param operation AdGroupWebpageOperation
   * @return AdGroupWebpageValues
   */
  public static List<AdGroupWebpageValues> remove(AdGroupWebpageOperation operation) throws Exception {

    // Call API
    System.out.println("############################################");
    System.out.println("AdGroupWebpageService::mutate(REMOVE)");
    System.out.println("############################################");

    Holder<AdGroupWebpageReturnValue> adGroupAdReturnValueHolder = new Holder<AdGroupWebpageReturnValue>();
    Holder<List<Error>> errorHolder = new Holder<List<Error>>();
    AdGroupWebpageServiceInterface adGroupWebpageService = SoapUtils.createServiceInterface(AdGroupWebpageServiceInterface.class, CampaignWebpageService.class);
    adGroupWebpageService.mutate(operation, adGroupAdReturnValueHolder, errorHolder);

    // Error
    if (errorHolder.value != null && errorHolder.value.size() > 0) {
      SoapUtils.displayErrors(new AdGroupWebpageServiceErrorEntityFactory(errorHolder.value), true);
    }
    if (adGroupAdReturnValueHolder.value == null) {
      throw new Exception("NoDataResponse:AdGroupWebpageService Remove");
    }

    // Display
    for (AdGroupWebpageValues adGroupWebpageValues : adGroupAdReturnValueHolder.value.getValues()) {
      if (adGroupWebpageValues.isOperationSucceeded()) {
        display(adGroupWebpageValues.getAdGroupWebpage());
      } else {
        SoapUtils.displayErrors(new AdGroupWebpageServiceErrorEntityFactory(adGroupWebpageValues.getError()), true);
      }
    }

    // Response
    return adGroupAdReturnValueHolder.value.getValues();
  }

  /**
   * create sample request.
   *
   * @param accountId     long
   * @param dasCampaignId long
   * @param dasAdGroupId  long
   * @return AdGroupWebpageOperation
   */
  public static AdGroupWebpageOperation createSampleAddRequest(long accountId, long dasCampaignId, long dasAdGroupId) {
    // Set Operation
    AdGroupWebpageOperation operation = new AdGroupWebpageOperation();
    operation.setOperator(Operator.ADD);
    operation.setAccountId(accountId);
    AdGroupWebpage adGroupWebpage = new AdGroupWebpage();
    adGroupWebpage.setAccountId(accountId);
    adGroupWebpage.setCampaignId(dasCampaignId);
    adGroupWebpage.setAdGroupId(dasAdGroupId);
    adGroupWebpage.setUserStatus(UserStatus.ACTIVE);
    adGroupWebpage.setExcludedType(ExcludedType.INCLUDED);

    Webpage webpage = new Webpage();
    WebpageParameter webpageParameter = new WebpageParameter();
    WebpageCondition condition1 = new WebpageCondition();
    condition1.setArgument("yahoo.co.jp");
    condition1.setType(WebpageConditionType.URL);
    WebpageCondition condition2 = new WebpageCondition();
    condition2.setArgument("YahooJapan");
    condition2.setType(WebpageConditionType.PAGE_TITLE);
    WebpageCondition condition3 = new WebpageCondition();
    condition3.setArgument("sample");
    condition3.setType(WebpageConditionType.CUSTOM_LABEL);

    webpageParameter.getConditions().addAll(Arrays.asList(condition1, condition2, condition3));
    webpage.setParameter(webpageParameter);
    adGroupWebpage.setWebpage(webpage);

    Bid bid = new Bid();
    bid.setMaxCpc(100L);
    adGroupWebpage.setBid(bid);

    operation.getOperand().add(adGroupWebpage);

    return operation;
  }

  /**
   * create sample request.
   *
   * @param accountId            long
   * @param adGroupWebpageValues AdGroupWebpageValues
   * @return AdGroupWebpageOperation
   */
  public static AdGroupWebpageOperation createSampleSetRequest(long accountId, List<AdGroupWebpageValues> adGroupWebpageValues) {
    // Set Operation
    AdGroupWebpageOperation operation = new AdGroupWebpageOperation();
    operation.setOperator(Operator.SET);
    operation.setAccountId(accountId);

    for (AdGroupWebpageValues value : adGroupWebpageValues) {
      AdGroupWebpage adGroupWebpage = new AdGroupWebpage();
      adGroupWebpage.setAccountId(value.getAdGroupWebpage().getAccountId());
      adGroupWebpage.setCampaignId(value.getAdGroupWebpage().getCampaignId());
      adGroupWebpage.setAdGroupId(value.getAdGroupWebpage().getAdGroupId());

      Webpage webpage = new Webpage();
      webpage.setTargetId(value.getAdGroupWebpage().getWebpage().getTargetId());

      adGroupWebpage.setWebpage(webpage);

      Bid bid = new Bid();
      bid.setMaxCpc(150L);
      adGroupWebpage.setBid(bid);

      operation.getOperand().add(adGroupWebpage);
    }

    return operation;
  }

  /**
   * create sample request.
   *
   * @param accountId            long
   * @param adGroupWebpageValues AdGroupWebpageValues
   * @return AdGroupWebpageOperation
   */
  public static AdGroupWebpageOperation createSampleRemoveRequest(long accountId, List<AdGroupWebpageValues> adGroupWebpageValues) {
    // Set Operation
    AdGroupWebpageOperation operation = new AdGroupWebpageOperation();
    operation.setOperator(Operator.REMOVE);
    operation.setAccountId(accountId);

    // Set Operand
    for (AdGroupWebpageValues adGroupWebpageValue : adGroupWebpageValues) {

      AdGroupWebpage adGroupWebpage = new AdGroupWebpage();
      adGroupWebpage.setAccountId(adGroupWebpageValue.getAdGroupWebpage().getAccountId());
      adGroupWebpage.setCampaignId(adGroupWebpageValue.getAdGroupWebpage().getCampaignId());
      adGroupWebpage.setAdGroupId(adGroupWebpageValue.getAdGroupWebpage().getAdGroupId());

      Webpage webpage = new Webpage();
      webpage.setTargetId(adGroupWebpageValue.getAdGroupWebpage().getWebpage().getTargetId());

      adGroupWebpage.setWebpage(webpage);

      operation.getOperand().add(adGroupWebpage);
    }

    return operation;
  }

  private static void display(AdGroupWebpage value) {
    System.out.println("accountId = " + value.getAccountId());
    System.out.println("campaignId = " + value.getCampaignId());
    System.out.println("campaignTrackId = " + value.getCampaignTrackId());
    System.out.println("adGroupId = " + value.getAdGroupId());
    System.out.println("adGroupTrackId = " + value.getAdGroupTrackId());
    System.out.println("userStatus = " + value.getUserStatus());
    System.out.println("excludedType = " + value.getExcludedType());
    System.out.println("webpage/targetId = " + value.getWebpage().getTargetId());
    int i = 0;
    for (WebpageCondition condition : value.getWebpage().getParameter().getConditions()) {
      System.out.println("webpage/parameter/conditions[" + i + "]/aurgument = " + condition.getArgument());
      System.out.println("webpage/parameter/conditions[" + i + "]/type = " + condition.getType());
      i++;
    }
    System.out.println("bid/maxCpc = " + value.getBid().getMaxCpc());
  }

}

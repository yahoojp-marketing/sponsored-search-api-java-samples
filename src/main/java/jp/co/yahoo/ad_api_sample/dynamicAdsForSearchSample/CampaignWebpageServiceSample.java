package jp.co.yahoo.ad_api_sample.dynamicAdsForSearchSample;

import jp.co.yahoo.ad_api_sample.adCustomizerSample.FeedFolderServiceSample;
import jp.co.yahoo.ad_api_sample.adSample.CampaignServiceSample;
import jp.co.yahoo.ad_api_sample.error.impl.CampaignWebpageServiceErrorEntityFactory;
import jp.co.yahoo.ad_api_sample.util.SoapUtils;
import jp.yahooapis.ss.v201808.Error;
import jp.yahooapis.ss.v201808.campaign.CampaignOperation;
import jp.yahooapis.ss.v201808.campaign.CampaignValues;
import jp.yahooapis.ss.v201808.campaignwebpage.CampaignWebpage;
import jp.yahooapis.ss.v201808.campaignwebpage.CampaignWebpageOperation;
import jp.yahooapis.ss.v201808.campaignwebpage.CampaignWebpageReturnValue;
import jp.yahooapis.ss.v201808.campaignwebpage.CampaignWebpageService;
import jp.yahooapis.ss.v201808.campaignwebpage.CampaignWebpageServiceInterface;
import jp.yahooapis.ss.v201808.campaignwebpage.CampaignWebpageValues;
import jp.yahooapis.ss.v201808.campaignwebpage.Operator;
import jp.yahooapis.ss.v201808.campaignwebpage.Webpage;
import jp.yahooapis.ss.v201808.campaignwebpage.WebpageCondition;
import jp.yahooapis.ss.v201808.campaignwebpage.WebpageConditionType;
import jp.yahooapis.ss.v201808.campaignwebpage.WebpageParameter;
import jp.yahooapis.ss.v201808.feedfolder.FeedFolderOperation;
import jp.yahooapis.ss.v201808.feedfolder.FeedFolderPlaceholderType;
import jp.yahooapis.ss.v201808.feedfolder.FeedFolderValues;

import java.util.ArrayList;
import java.util.List;

import javax.xml.ws.Holder;

/**
 * Sample Program for CampaignWebpageService. Copyright (C) 2012 Yahoo Japan Corporation. All Rights Reserved.
 */
public class CampaignWebpageServiceSample {
  /**
   * main method for CampaignWebpageService
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
      // CampaignWebpageService
      // =================================================================
      // add
      CampaignWebpageOperation addCampaignWebpageOperation = createSampleAddRequest(accountId, campaignId);
      List<CampaignWebpageValues> campaignWebpageValues = add(addCampaignWebpageOperation);

      // remove
      CampaignWebpageOperation removeCampaignWebpageOperation = createSampleRemoveRequest(accountId, campaignWebpageValues);
      campaignWebpageValues = remove(removeCampaignWebpageOperation);


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
   * Sample Program for CampaignWebpageSelector ADD.
   *
   * @param operation CampaignWebpageOperation
   * @return CampaignWebpageValues
   */
  public static List<CampaignWebpageValues> add(CampaignWebpageOperation operation) throws Exception {

    // Call API
    System.out.println("############################################");
    System.out.println("CampaignWebpageSelector::mutate(ADD)");
    System.out.println("############################################");

    Holder<CampaignWebpageReturnValue> campaignWebpageReturnValue = new Holder<CampaignWebpageReturnValue>();
    Holder<List<Error>> errorHolder = new Holder<List<Error>>();
    CampaignWebpageServiceInterface campaignWebpageService = SoapUtils.createServiceInterface(CampaignWebpageServiceInterface.class, CampaignWebpageService.class);
    campaignWebpageService.mutate(operation, campaignWebpageReturnValue, errorHolder);

    // Error
    if (errorHolder.value != null && errorHolder.value.size() > 0) {
      SoapUtils.displayErrors(new CampaignWebpageServiceErrorEntityFactory(errorHolder.value), true);
    }
    if (campaignWebpageReturnValue.value == null) {
      throw new Exception("NoDataResponse:CampaignWebpageSelector Add");
    }

    // Display
    for (CampaignWebpageValues campaignWebpageValues : campaignWebpageReturnValue.value.getValues()) {
      if (campaignWebpageValues.isOperationSucceeded()) {
        display(campaignWebpageValues.getCampaignWebpage());
      } else {
        SoapUtils.displayErrors(new CampaignWebpageServiceErrorEntityFactory(campaignWebpageValues.getError()), true);
      }
    }

    // Response
    return campaignWebpageReturnValue.value.getValues();
  }

  /**
   * Sample Program for CampaignWebpageSelector REMOVE.
   *
   * @param operation CampaignWebpageOperation
   * @return CampaignWebpageValues
   */
  public static List<CampaignWebpageValues> remove(CampaignWebpageOperation operation) throws Exception {

    // Call API
    System.out.println("############################################");
    System.out.println("CampaignWebpageSelector::mutate(REMOVE)");
    System.out.println("############################################");

    Holder<CampaignWebpageReturnValue> campaignWebpageReturnValue = new Holder<CampaignWebpageReturnValue>();
    Holder<List<Error>> errorHolder = new Holder<List<Error>>();
    CampaignWebpageServiceInterface campaignWebpageService = SoapUtils.createServiceInterface(CampaignWebpageServiceInterface.class, CampaignWebpageService.class);
    campaignWebpageService.mutate(operation, campaignWebpageReturnValue, errorHolder);

    // Error
    if (errorHolder.value != null && errorHolder.value.size() > 0) {
      SoapUtils.displayErrors(new CampaignWebpageServiceErrorEntityFactory(errorHolder.value), true);
    }
    if (campaignWebpageReturnValue.value == null) {
      throw new Exception("NoDataResponse:CampaignWebpageSelector Remove");
    }

    // Display
    for (CampaignWebpageValues campaignWebpageValues : campaignWebpageReturnValue.value.getValues()) {
      if (campaignWebpageValues.isOperationSucceeded()) {
        display(campaignWebpageValues.getCampaignWebpage());
      } else {
        SoapUtils.displayErrors(new CampaignWebpageServiceErrorEntityFactory(campaignWebpageValues.getError()), true);
      }
    }

    // Response
    return campaignWebpageReturnValue.value.getValues();
  }

  /**
   * create sample request.
   *
   * @param accountId     long
   * @param dasCampaignId long
   * @return CampaignWebpageOperation
   */
  public static CampaignWebpageOperation createSampleAddRequest(long accountId, long dasCampaignId) {
    // Set Operation
    CampaignWebpageOperation operation = new CampaignWebpageOperation();
    operation.setOperator(Operator.ADD);
    operation.setAccountId(accountId);
    CampaignWebpage campaignWebpage = new CampaignWebpage();
    campaignWebpage.setAccountId(accountId);
    campaignWebpage.setCampaignId(dasCampaignId);

    Webpage webpage = new Webpage();
    WebpageParameter webpageParameter = new WebpageParameter();
    List<WebpageCondition> conditionList = new ArrayList<>();
    WebpageCondition condition1 = new WebpageCondition();
    condition1.setArgument("yahoo.co.jp");
    condition1.setType(WebpageConditionType.URL);
    WebpageCondition condition2 = new WebpageCondition();
    condition2.setArgument("YahooJapan");
    condition2.setType(WebpageConditionType.PAGE_TITLE);
    WebpageCondition condition3 = new WebpageCondition();
    condition3.setArgument("sample");
    condition3.setType(WebpageConditionType.CUSTOM_LABEL);

    conditionList.add(condition1);
    conditionList.add(condition2);
    conditionList.add(condition3);

    webpageParameter.getConditions().addAll(conditionList);
    webpage.setParameter(webpageParameter);
    campaignWebpage.setWebpage(webpage);

    operation.getOperand().add(campaignWebpage);

    return operation;
  }

  /**
   * create sample request.
   *
   * @param accountId             long
   * @param campaignWebpageValues CampaignWebpageValues
   * @return CampaignWebpageOperation
   */
  public static CampaignWebpageOperation createSampleRemoveRequest(long accountId, List<CampaignWebpageValues> campaignWebpageValues) {
    // Set Operation
    CampaignWebpageOperation operation = new CampaignWebpageOperation();
    operation.setOperator(Operator.REMOVE);
    operation.setAccountId(accountId);

    // Set Operand
    for (CampaignWebpageValues campaignWebpageValue : campaignWebpageValues) {

      CampaignWebpage campaignWebpage = new CampaignWebpage();
      campaignWebpage.setAccountId(campaignWebpageValue.getCampaignWebpage().getAccountId());
      campaignWebpage.setCampaignId(campaignWebpageValue.getCampaignWebpage().getCampaignId());

      Webpage webpage = new Webpage();
      webpage.setTargetId(campaignWebpageValue.getCampaignWebpage().getWebpage().getTargetId());

      campaignWebpage.setWebpage(webpage);

      operation.getOperand().add(campaignWebpage);
    }

    return operation;
  }

  private static void display(CampaignWebpage value) {
    System.out.println("accountId = " + value.getAccountId());
    System.out.println("campaignId = " + value.getCampaignId());
    System.out.println("campaignTrackId = " + value.getCampaignTrackId());
    System.out.println("webpage/targetId = " + value.getWebpage().getTargetId());
    int i = 0;
    for (WebpageCondition condition : value.getWebpage().getParameter().getConditions()) {
      System.out.println("webpage/parameter/conditions[" + i + "]/aurgument = " + condition.getArgument());
      System.out.println("webpage/parameter/conditions[" + i + "]/type = " + condition.getType());
      i++;
    }
  }

}

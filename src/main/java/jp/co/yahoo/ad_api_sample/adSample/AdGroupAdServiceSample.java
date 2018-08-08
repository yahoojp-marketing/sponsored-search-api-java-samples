package jp.co.yahoo.ad_api_sample.adSample;

import jp.co.yahoo.ad_api_sample.adCustomizerSample.FeedFolderServiceSample;
import jp.co.yahoo.ad_api_sample.error.impl.AdGroupAdServiceErrorEntityFactory;
import jp.co.yahoo.ad_api_sample.util.SoapUtils;
import jp.yahooapis.ss.v201808.Error;
import jp.yahooapis.ss.v201808.Paging;
import jp.yahooapis.ss.v201808.adgroup.AdGroupOperation;
import jp.yahooapis.ss.v201808.adgroup.AdGroupValues;
import jp.yahooapis.ss.v201808.adgroupad.Ad;
import jp.yahooapis.ss.v201808.adgroupad.AdGroupAd;
import jp.yahooapis.ss.v201808.adgroupad.AdGroupAdAdditionalAdvancedMobileUrls;
import jp.yahooapis.ss.v201808.adgroupad.AdGroupAdAdditionalAdvancedUrls;
import jp.yahooapis.ss.v201808.adgroupad.AdGroupAdOperation;
import jp.yahooapis.ss.v201808.adgroupad.AdGroupAdPage;
import jp.yahooapis.ss.v201808.adgroupad.AdGroupAdReturnValue;
import jp.yahooapis.ss.v201808.adgroupad.AdGroupAdSelector;
import jp.yahooapis.ss.v201808.adgroupad.AdGroupAdService;
import jp.yahooapis.ss.v201808.adgroupad.AdGroupAdServiceInterface;
import jp.yahooapis.ss.v201808.adgroupad.AdGroupAdValues;
import jp.yahooapis.ss.v201808.adgroupad.AdType;
import jp.yahooapis.ss.v201808.adgroupad.AppAd;
import jp.yahooapis.ss.v201808.adgroupad.ApprovalStatus;
import jp.yahooapis.ss.v201808.adgroupad.CustomParameter;
import jp.yahooapis.ss.v201808.adgroupad.CustomParameters;
import jp.yahooapis.ss.v201808.adgroupad.DevicePreference;
import jp.yahooapis.ss.v201808.adgroupad.DynamicSearchLinkedAd;
import jp.yahooapis.ss.v201808.adgroupad.ExtendedTextAd;
import jp.yahooapis.ss.v201808.adgroupad.Operator;
import jp.yahooapis.ss.v201808.adgroupad.TextAd2;
import jp.yahooapis.ss.v201808.adgroupad.UserStatus;
import jp.yahooapis.ss.v201808.biddingstrategy.BiddingStrategyOperation;
import jp.yahooapis.ss.v201808.biddingstrategy.BiddingStrategyValues;
import jp.yahooapis.ss.v201808.campaign.CampaignOperation;
import jp.yahooapis.ss.v201808.campaign.CampaignSelector;
import jp.yahooapis.ss.v201808.campaign.CampaignValues;
import jp.yahooapis.ss.v201808.campaign.UrlApprovalStatus;
import jp.yahooapis.ss.v201808.feedfolder.FeedFolderOperation;
import jp.yahooapis.ss.v201808.feedfolder.FeedFolderPlaceholderType;
import jp.yahooapis.ss.v201808.feedfolder.FeedFolderValues;

import java.util.Arrays;
import java.util.List;

import javax.xml.ws.Holder;


/**
 * Sample Program for AdGroupAdService. Copyright (C) 2012 Yahoo Japan Corporation. All Rights
 * Reserved.
 */
public class AdGroupAdServiceSample {

  /**
   * main method for AdGroupAdServiceSample
   *
   * @param args command line arguments
   */
  public static void main(String[] args) throws Exception {
    try {
      // =================================================================
      // Setting
      // =================================================================
      long accountId = SoapUtils.getAccountId();
      long biddingStrategyId = SoapUtils.getBiddingStrategyId();
      long campaignId =  -1L;
      long appCampaignId =  -1L;
      long dasCampaignId =  -1L;
      long adGroupId = -1L;
      long appAdGroupId = -1L;
      long dasAdGroupId = -1L;

      // =================================================================
      // BiddingStrategyService::ADD
      // =================================================================
      List<BiddingStrategyValues> biddingStrategyValues = null;
      if (biddingStrategyId == 9999999999l) {
        BiddingStrategyOperation addBiddingStrategyOperation = BiddingStrategyServiceSample.createSampleAddRequest(accountId);
        biddingStrategyValues = BiddingStrategyServiceSample.mutate(addBiddingStrategyOperation);
        for (BiddingStrategyValues value : biddingStrategyValues) {
          if (value.getBiddingStrategy().getBiddingScheme() instanceof jp.yahooapis.ss.v201808.biddingstrategy.PageOnePromotedBiddingScheme) {
            biddingStrategyId = value.getBiddingStrategy().getBiddingStrategyId();
          }
        }

        // sleep 30 second.
        System.out.println("\n***** sleep 30 seconds *****\n");
        Thread.sleep(30000);
      }

      // =================================================================
      // FeedFolderService ADD FOR DSA
      // =================================================================
      long feedFolderId = -1L;
      FeedFolderOperation addFeedFolderOperation = FeedFolderServiceSample.createSampleDasAddRequest(null, accountId);
      List<FeedFolderValues> feedFolderValues = FeedFolderServiceSample.add(addFeedFolderOperation);
      for(FeedFolderValues values: feedFolderValues) {
        if(values.getFeedFolder().getPlaceholderType().equals(FeedFolderPlaceholderType.DYNAMIC_AD_FOR_SEARCH_PAGE_FEEDS)) {
          feedFolderId = values.getFeedFolder().getFeedFolderId();
        }
      }

      // =================================================================
      // CampaignService::ADD
      // =================================================================
      CampaignOperation addCampaignOperation = CampaignServiceSample.createSampleAddRequest(accountId, biddingStrategyId);
      addCampaignOperation =  CampaignServiceSample.createSampleDasAddRequest(addCampaignOperation, accountId, feedFolderId);
      List<CampaignValues> addCampaignValues = CampaignServiceSample.add(addCampaignOperation);
      boolean allApproved = true;
      // call 30sec sleep * 30 = 15minute
      for (int i = 0; i < 30; i++) {
        // sleep 30 second.
        System.out.println("\n***** sleep 30 seconds for Get Campaign  *****\n");
        Thread.sleep(30000);

        // =================================================================
        // CampaignService::GET
        // =================================================================
        // Set Selector
        CampaignSelector campaignSelector = CampaignServiceSample.createSampleGetRequest(accountId, addCampaignValues);

        // Run
        List<CampaignValues> getCampaignValues = CampaignServiceSample.get(campaignSelector);

        allApproved = true;
        for (CampaignValues campaignValues : getCampaignValues) {
          if (!UrlApprovalStatus.APPROVED.equals(campaignValues.getCampaign().getUrlReviewData().getUrlApprovalStatus())
              && !UrlApprovalStatus.NONE.equals(campaignValues.getCampaign().getUrlReviewData().getUrlApprovalStatus())) {
            allApproved = false;
          } else if(UrlApprovalStatus.DISAPPROVED.equals(campaignValues.getCampaign().getUrlReviewData().getUrlApprovalStatus())){
            System.out.println("Error : This campaign was denied.");
            campaignValues.getCampaign().getUrlReviewData().getDisapprovalReasonCodes().stream().forEach(
                disapprovalReasonCode -> System.out.println("disapprovalReasonCode:[" + disapprovalReasonCode + "]")
            );

          }
        }
        if (allApproved) {
          break;
        }
      }

      if (!allApproved) {

        // =================================================================
        // CampaignService::REMOVE
        // =================================================================
        // Set Operation
        CampaignOperation removeCampaignOperation = CampaignServiceSample.createSampleRemoveRequest(accountId, addCampaignValues);
        // Run
        CampaignServiceSample.remove(removeCampaignOperation);

        // =================================================================
        // remove FeedFolderService
        // =================================================================
        // Set Operation
        FeedFolderOperation removeFeedFolderOperation = FeedFolderServiceSample.createSampleRemoveRequest(accountId, feedFolderValues);
        // Run
        FeedFolderServiceSample.remove(removeFeedFolderOperation);

        // =================================================================
        // remove BiddingStrategy
        // =================================================================
        if (biddingStrategyValues != null) {
          BiddingStrategyOperation removeBiddingStrategyOperation = BiddingStrategyServiceSample.createSampleRemoveRequest(accountId, biddingStrategyValues);
          // Run
          BiddingStrategyServiceSample.mutate(removeBiddingStrategyOperation);
        }

        System.exit(5);
      }

      // set CampaignId
      for(CampaignValues value: addCampaignValues) {
        switch(value.getCampaign().getCampaignType()) {
          case STANDARD:
            campaignId = value.getCampaign().getCampaignId();
            break;
          case MOBILE_APP:
            appCampaignId = value.getCampaign().getCampaignId();
            break;
          case DYNAMIC_ADS_FOR_SEARCH:
            dasCampaignId = value.getCampaign().getCampaignId();
            break;
        }
      }

      // =================================================================
      // AdGroupService ADD
      // =================================================================
      // Set Operation
      AdGroupOperation addAdGroupOperation = AdGroupServiceSample.createSampleAddRequest(accountId, campaignId, appCampaignId);
      addAdGroupOperation = AdGroupServiceSample.createSampleDasAddRequest(addAdGroupOperation, accountId, dasCampaignId);

      // Run
      List<AdGroupValues> adGroupValues = AdGroupServiceSample.add(addAdGroupOperation);
      // set adGroupId
      for(AdGroupValues value: adGroupValues) {
        if(value.getAdGroup().getCampaignId() == campaignId) {
          adGroupId = value.getAdGroup().getAdGroupId();
        } else if(value.getAdGroup().getCampaignId() == appCampaignId) {
          appAdGroupId = value.getAdGroup().getAdGroupId();
        } else if(value.getAdGroup().getCampaignId() == dasCampaignId) {
          dasAdGroupId = value.getAdGroup().getAdGroupId();
        }
      }

      // =================================================================
      // AdGroupAdService ADD
      // =================================================================
      // Set Operation
      AdGroupAdOperation addAdGroupAdOperation = createSampleAddRequest(accountId, campaignId, adGroupId, appCampaignId, appAdGroupId);
      addAdGroupAdOperation = createSampleDasAddRequest(addAdGroupAdOperation, accountId, dasCampaignId, dasAdGroupId);

      // Run
      List<AdGroupAdValues> adGroupAdValues = add(addAdGroupAdOperation);

      // =================================================================
      // AdGroupAdService GET
      // =================================================================
      // Set Selector
      AdGroupAdSelector adGroupAdSelector = createSampleGetRequest(accountId, adGroupAdValues);

      // Run
      get(adGroupAdSelector);

      // =================================================================
      // AdGroupAdService SET
      // =================================================================
      // Set Operation
      AdGroupAdOperation setAdGroupAdOperation = createSampleSetRequest(accountId, adGroupAdValues);

      // Run
      set(setAdGroupAdOperation);

      // =================================================================
      // AdGroupAdService REMOVE
      // =================================================================
      // Set Operation
      AdGroupAdOperation removeAdGroupAdOperation = createSampleRemoveRequest(accountId, adGroupAdValues);

      // Run
      remove(removeAdGroupAdOperation);

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
   * Sample Program for AdGroupAdService ADD.
   *
   * @param operation AdGroupAdOperation
   * @return AdGroupAdValues
   */
  public static List<AdGroupAdValues> add(AdGroupAdOperation operation) throws Exception {

    // Call API
    System.out.println("############################################");
    System.out.println("AdGroupAdService::mutate(ADD)");
    System.out.println("############################################");

    Holder<AdGroupAdReturnValue> adGroupAdReturnValueHolder = new Holder<AdGroupAdReturnValue>();
    Holder<List<Error>> errorHolder = new Holder<List<Error>>();
    AdGroupAdServiceInterface adGroupAdService = SoapUtils.createServiceInterface(AdGroupAdServiceInterface.class, AdGroupAdService.class);
    adGroupAdService.mutate(operation, adGroupAdReturnValueHolder, errorHolder);

    // Error
    if (errorHolder.value != null && errorHolder.value.size() > 0) {
      SoapUtils.displayErrors(new AdGroupAdServiceErrorEntityFactory(errorHolder.value), true);
    }
    if (adGroupAdReturnValueHolder.value == null) {
      throw new Exception("NoDataResponse:AdGroupAdService Add");
    }

    // Display
    for (AdGroupAdValues adGroupAdValues : adGroupAdReturnValueHolder.value.getValues()) {
      if (adGroupAdValues.isOperationSucceeded()) {
        display(adGroupAdValues.getAdGroupAd());
      } else {
        SoapUtils.displayErrors(new AdGroupAdServiceErrorEntityFactory(adGroupAdValues.getError()), true);
      }
    }

    // Response
    return adGroupAdReturnValueHolder.value.getValues();
  }

  /**
   * Sample Program for AdGroupAdService SET.
   *
   * @param operation AdGroupAdOperation
   * @return AdGroupAdValues
   */
  public static List<AdGroupAdValues> set(AdGroupAdOperation operation) throws Exception {

    // Call API
    System.out.println("############################################");
    System.out.println("AdGroupAdService::mutate(SET)");
    System.out.println("############################################");

    Holder<AdGroupAdReturnValue> adGroupAdReturnValueHolder = new Holder<AdGroupAdReturnValue>();
    Holder<List<Error>> errorHolder = new Holder<List<Error>>();
    AdGroupAdServiceInterface adGroupAdService = SoapUtils.createServiceInterface(AdGroupAdServiceInterface.class, AdGroupAdService.class);
    adGroupAdService.mutate(operation, adGroupAdReturnValueHolder, errorHolder);

    // Error
    if (errorHolder.value != null && errorHolder.value.size() > 0) {
      SoapUtils.displayErrors(new AdGroupAdServiceErrorEntityFactory(errorHolder.value), true);
    }
    if (adGroupAdReturnValueHolder.value == null) {
      throw new Exception("NoDataResponse:AdGroupAdService Set");
    }

    // Display
    for (AdGroupAdValues adGroupAdValues : adGroupAdReturnValueHolder.value.getValues()) {
      if (adGroupAdValues.isOperationSucceeded()) {
        display(adGroupAdValues.getAdGroupAd());
      } else {
        SoapUtils.displayErrors(new AdGroupAdServiceErrorEntityFactory(adGroupAdValues.getError()), true);
      }
    }

    // Response
    return adGroupAdReturnValueHolder.value.getValues();
  }

  /**
   * Sample Program for AdGroupAdService REMOVE.
   *
   * @param operation AdGroupAdOperation
   * @return AdGroupAdValues
   */
  public static List<AdGroupAdValues> remove(AdGroupAdOperation operation) throws Exception {

    // Call API
    System.out.println("############################################");
    System.out.println("AdGroupAdService::mutate(REMOVE)");
    System.out.println("############################################");

    Holder<AdGroupAdReturnValue> adGroupAdReturnValueHolder = new Holder<AdGroupAdReturnValue>();
    Holder<List<Error>> errorHolder = new Holder<List<Error>>();
    AdGroupAdServiceInterface adGroupAdService = SoapUtils.createServiceInterface(AdGroupAdServiceInterface.class, AdGroupAdService.class);
    adGroupAdService.mutate(operation, adGroupAdReturnValueHolder, errorHolder);

    // Error
    if (errorHolder.value != null && errorHolder.value.size() > 0) {
      SoapUtils.displayErrors(new AdGroupAdServiceErrorEntityFactory(errorHolder.value), true);
    }
    if (adGroupAdReturnValueHolder.value == null) {
      throw new Exception("NoDataResponse:AdGroupAdService Remove");
    }

    // Display
    for (AdGroupAdValues adGroupAdValues : adGroupAdReturnValueHolder.value.getValues()) {
      if (adGroupAdValues.isOperationSucceeded()) {
        display(adGroupAdValues.getAdGroupAd());
      } else {
        SoapUtils.displayErrors(new AdGroupAdServiceErrorEntityFactory(adGroupAdValues.getError()), true);
      }
    }

    // Response
    return adGroupAdReturnValueHolder.value.getValues();
  }

  /**
   * Sample Program for AdGroupAdService GET.
   *
   * @param adGroupAdSelector AdGroupAdSelector
   * @return AdGroupAdValues
   */
  public static List<AdGroupAdValues> get(AdGroupAdSelector adGroupAdSelector) throws Exception {

    // Call API
    System.out.println("############################################");
    System.out.println("AdGroupAdService::get");
    System.out.println("############################################");

    Holder<AdGroupAdPage> adGroupAdPage = new Holder<AdGroupAdPage>();
    Holder<List<Error>> errorHolder = new Holder<List<Error>>();
    AdGroupAdServiceInterface adGroupAdService = SoapUtils.createServiceInterface(AdGroupAdServiceInterface.class, AdGroupAdService.class);
    adGroupAdService.get(adGroupAdSelector, adGroupAdPage, errorHolder);

    // Error
    if (errorHolder.value != null && errorHolder.value.size() > 0) {
      SoapUtils.displayErrors(new AdGroupAdServiceErrorEntityFactory(errorHolder.value), true);
    }
    if (adGroupAdPage.value == null) {
      throw new Exception("NoDataResponse:AdGroupAdService Get");
    }

    // Display
    for (AdGroupAdValues adGroupAdValues : adGroupAdPage.value.getValues()) {
      if (adGroupAdValues.isOperationSucceeded()) {
        display(adGroupAdValues.getAdGroupAd());
      } else {
        SoapUtils.displayErrors(new AdGroupAdServiceErrorEntityFactory(adGroupAdValues.getError()), true);
      }
    }

    // Response
    return adGroupAdPage.value.getValues();
  }

  /**
   * display AdGroupAd entity to stdout.
   *
   * @param adGroupAd AdGroupAd entity for display.
   */
  public static void display(AdGroupAd adGroupAd) {

    System.out.println("accountId = " + adGroupAd.getAccountId());
    System.out.println("campaignId = " + adGroupAd.getCampaignId());
    System.out.println("campaignTrackId = " + adGroupAd.getCampaignTrackId());
    System.out.println("campaignName = " + adGroupAd.getCampaignName());
    System.out.println("adGroupId = " + adGroupAd.getAdGroupId());
    System.out.println("adGroupTrackId = " + adGroupAd.getAdGroupId());
    System.out.println("adGroupName = " + adGroupAd.getAdGroupName());
    System.out.println("adId = " + adGroupAd.getAdId());
    System.out.println("adName = " + adGroupAd.getAdName());
    System.out.println("userStatus = " + adGroupAd.getUserStatus());
    System.out.println("approvalStatus = " + adGroupAd.getApprovalStatus());

    if (adGroupAd.getAd() != null) {
      Ad ad = adGroupAd.getAd();
      if (ad instanceof TextAd2) {
        TextAd2 textAd2 = (TextAd2) ad;
        System.out.println("ad/type = " + textAd2.getType());
        System.out.println("ad/url = " + textAd2.getUrl());
        System.out.println("ad/displayUrl = " + textAd2.getDisplayUrl());
        System.out.println("ad/headline = " + textAd2.getHeadline());
        System.out.println("ad/description = " + textAd2.getDescription());
        System.out.println("ad/description2 = " + textAd2.getDescription2());
        System.out.println("ad/devicePreference = " + textAd2.getDevicePreference());
      } else if (ad instanceof AppAd) {
        AppAd appAd = (AppAd) ad;
        System.out.println("ad/type = " + appAd.getType().toString());
        System.out.println("ad/url = " + appAd.getUrl());
        System.out.println("ad/displayUrl = " + appAd.getDisplayUrl());
        System.out.println("ad/headline = " + appAd.getHeadline());
        System.out.println("ad/description = " + appAd.getDescription());
        System.out.println("ad/description2 = " + appAd.getDescription2());
        System.out.println("ad/appStore = " + appAd.getAppStore());
        System.out.println("ad/appId = " + appAd.getAppId());
        System.out.println("ad/devicePreference = " + appAd.getDevicePreference());
      } else if (ad instanceof ExtendedTextAd) {
        ExtendedTextAd extendedTextAd = (ExtendedTextAd) ad;
        System.out.println("ad/type = " + extendedTextAd.getType().toString());
        System.out.println("ad/url = " + extendedTextAd.getUrl());
        System.out.println("ad/displayUrl = " + extendedTextAd.getDisplayUrl());
        System.out.println("ad/headline = " + extendedTextAd.getHeadline());
        System.out.println("ad/description = " + extendedTextAd.getDescription());
        System.out.println("ad/headline2 = " + extendedTextAd.getHeadline2());
        System.out.println("ad/path1 = " + extendedTextAd.getPath1());
        System.out.println("ad/path2 = " + extendedTextAd.getPath2());
        System.out.println("ad/devicePreference = " + extendedTextAd.getDevicePreference());
      }

      System.out.println("ad/advancedUrl = " + ad.getAdvancedUrl());
      System.out.println("ad/advancedMobileUrl = " + ad.getAdvancedMobileUrl());
      System.out.println("ad/trackingUrl = " + ad.getTrackingUrl());

      if (null != ad.getAdditionalAdvancedUrls()) {
        List<AdGroupAdAdditionalAdvancedUrls> additionalAdvancedUrls = ad.getAdditionalAdvancedUrls();
        int index = 0;
        for (AdGroupAdAdditionalAdvancedUrls additionalAdvancedUrl : additionalAdvancedUrls) {
          System.out.println("additionalAdvancedUrls[" + index + "]/additionalAdvancedUrl/advancedUrl = " + additionalAdvancedUrl.getAdvancedUrl());
          System.out.println("additionalAdvancedUrls[" + index + "]/additionalAdvancedUrl/disapprovalReasonCodes = " + additionalAdvancedUrl.getDisapprovalReasonCodes());
        }
      }

      if (null != ad.getAdditionalAdvancedMobileUrls()) {
        List<AdGroupAdAdditionalAdvancedMobileUrls> additionalAdvancedMobileUrls = ad.getAdditionalAdvancedMobileUrls();
        int index = 0;
        for (AdGroupAdAdditionalAdvancedMobileUrls additionalAdvancedMobileUrl : additionalAdvancedMobileUrls) {
          System.out.println("additionalAdvancedMobileUrls[" + index + "]/additionalAdvancedMobileUrl/advancedMobileUrl = " + additionalAdvancedMobileUrl.getAdvancedMobileUrl());
          System.out.println("additionalAdvancedMobileUrls[" + index + "]/additionalAdvancedMobileUrl/disapprovalReasonCodes = " + additionalAdvancedMobileUrl.getDisapprovalReasonCodes());
        }
      }

      if (null != ad.getCustomParameters()) {
        CustomParameters customParameters = ad.getCustomParameters();
        System.out.println("ad/customParameters/isRemove = " + customParameters.getIsRemove());

        if (null != customParameters.getParameters()) {
          int index = 0;
          for (CustomParameter parameter : customParameters.getParameters()) {
            System.out.println("customParameters/parameters[" + index + "]/key = " + parameter.getKey());
            System.out.println("customParameters/parameters[" + index + "]/value = " + parameter.getValue());
            index++;
          }
        }
      }


    }
    System.out.println("---------");
  }

  /**
   * create sample request.
   *
   * @param accountId     long
   * @param campaignId    long
   * @param adGroupId     long
   * @param appCampaignId long
   * @param appAdGroupId  long
   * @return AdGroupAdOperation
   */
  public static AdGroupAdOperation createSampleAddRequest(long accountId, long campaignId, long adGroupId, long appCampaignId, long appAdGroupId) {
    // Set Operation
    AdGroupAdOperation operation = new AdGroupAdOperation();
    operation.setOperator(Operator.ADD);
    operation.setAccountId(accountId);

    // Set CustomParameters
    CustomParameters customParameters = new CustomParameters();
    CustomParameter parameter1 = new CustomParameter();
    parameter1.setKey("id1");
    parameter1.setValue("1234");
    customParameters.getParameters().addAll(Arrays.asList(parameter1));

    AdGroupAdAdditionalAdvancedUrls additionalAdvancedUrl1 = new AdGroupAdAdditionalAdvancedUrls();
    AdGroupAdAdditionalAdvancedUrls additionalAdvancedUrl2 = new AdGroupAdAdditionalAdvancedUrls();
    AdGroupAdAdditionalAdvancedUrls additionalAdvancedUrl3 = new AdGroupAdAdditionalAdvancedUrls();
    additionalAdvancedUrl1.setAdvancedUrl("http://www1.yahoo.co.jp");
    additionalAdvancedUrl2.setAdvancedUrl("http://www2.yahoo.co.jp");
    additionalAdvancedUrl3.setAdvancedUrl("http://www3.yahoo.co.jp");

    AdGroupAdAdditionalAdvancedMobileUrls adGroupAdAdditionalAdvancedMobileUrls1 = new AdGroupAdAdditionalAdvancedMobileUrls();
    AdGroupAdAdditionalAdvancedMobileUrls adGroupAdAdditionalAdvancedMobileUrls2 = new AdGroupAdAdditionalAdvancedMobileUrls();
    AdGroupAdAdditionalAdvancedMobileUrls adGroupAdAdditionalAdvancedMobileUrls3 = new AdGroupAdAdditionalAdvancedMobileUrls();
    adGroupAdAdditionalAdvancedMobileUrls1.setAdvancedMobileUrl("http://www1.yahoo.co.jp/mobile");
    adGroupAdAdditionalAdvancedMobileUrls2.setAdvancedMobileUrl("http://www2.yahoo.co.jp/mobile");
    adGroupAdAdditionalAdvancedMobileUrls3.setAdvancedMobileUrl("http://www3.yahoo.co.jp/mobile");

    // Set AppAd
    AppAd appAd = new AppAd();
    appAd.setType(AdType.APP_AD);
    appAd.setHeadline("sample");
    appAd.setDescription("sample ad desc");
    appAd.setDescription2("sample ad desc2");
    appAd.setDevicePreference(DevicePreference.SMART_PHONE);
    appAd.setAdvancedUrl("http://www.yahoo.co.jp");
    appAd.setTrackingUrl("http://www.yahoo.co.jp/?url={lpurl}&amp;a={creative}&amp;pid={_id1}");
    appAd.setCustomParameters(customParameters);

    AdGroupAd appAdAdGroupAd = new AdGroupAd();
    appAdAdGroupAd.setAccountId(accountId);
    appAdAdGroupAd.setCampaignId(appCampaignId);
    appAdAdGroupAd.setAdGroupId(appAdGroupId);
    appAdAdGroupAd.setAdName("SampleAppAd_CreateOn_" + SoapUtils.getCurrentTimestamp());
    appAdAdGroupAd.setAd(appAd);
    appAdAdGroupAd.setUserStatus(UserStatus.ACTIVE);

    // Set ExtendedTextAd
    ExtendedTextAd extendedTextAd = new ExtendedTextAd();
    extendedTextAd.setType(AdType.EXTENDED_TEXT_AD);
    extendedTextAd.setHeadline("sample headline");
    extendedTextAd.setDescription("sample ad desc");
    extendedTextAd.setHeadline2("sample headline2");
    extendedTextAd.setPath1("path1");
    extendedTextAd.setPath2("path2");
    extendedTextAd.setDisplayUrl("www.yahoo.co.jp");
    extendedTextAd.setDevicePreference(DevicePreference.SMART_PHONE);
    extendedTextAd.setAdvancedUrl("http://www.yahoo.co.jp");
    extendedTextAd.setAdvancedMobileUrl("http://www.yahoo.co.jp/mobile");
    extendedTextAd.setTrackingUrl("http://www.yahoo.co.jp/?url={lpurl}&amp;a={creative}&amp;pid={_id1}");
    extendedTextAd.setCustomParameters(customParameters);

    additionalAdvancedUrl1.setAdvancedUrl("http://www1.yahoo.co.jp");
    additionalAdvancedUrl2.setAdvancedUrl("http://www2.yahoo.co.jp");
    additionalAdvancedUrl3.setAdvancedUrl("http://www3.yahoo.co.jp");
    extendedTextAd.getAdditionalAdvancedUrls().add(additionalAdvancedUrl1);
    extendedTextAd.getAdditionalAdvancedUrls().add(additionalAdvancedUrl2);
    extendedTextAd.getAdditionalAdvancedUrls().add(additionalAdvancedUrl3);

    adGroupAdAdditionalAdvancedMobileUrls1.setAdvancedMobileUrl("http://www1.yahoo.co.jp/mobile");
    adGroupAdAdditionalAdvancedMobileUrls2.setAdvancedMobileUrl("http://www2.yahoo.co.jp/mobile");
    adGroupAdAdditionalAdvancedMobileUrls3.setAdvancedMobileUrl("http://www3.yahoo.co.jp/mobile");
    extendedTextAd.getAdditionalAdvancedMobileUrls().add(adGroupAdAdditionalAdvancedMobileUrls1);
    extendedTextAd.getAdditionalAdvancedMobileUrls().add(adGroupAdAdditionalAdvancedMobileUrls2);
    extendedTextAd.getAdditionalAdvancedMobileUrls().add(adGroupAdAdditionalAdvancedMobileUrls3);

    AdGroupAd extendedTextAdAdGroupAd = new AdGroupAd();
    extendedTextAdAdGroupAd.setAccountId(accountId);
    extendedTextAdAdGroupAd.setCampaignId(campaignId);
    extendedTextAdAdGroupAd.setAdGroupId(adGroupId);
    extendedTextAdAdGroupAd.setAdName("SampleExtendedTextAd_CreateOn_" + SoapUtils.getCurrentTimestamp());
    extendedTextAdAdGroupAd.setAd(extendedTextAd);
    extendedTextAdAdGroupAd.setUserStatus(UserStatus.ACTIVE);

    operation.getOperand().addAll(Arrays.asList(appAdAdGroupAd, extendedTextAdAdGroupAd));

    return operation;
  }

  /**
   * create sample request.
   *
   * @param operation     AdGroupAdOperation
   * @param accountId     long
   * @param dasCampaignId    long
   * @param dasAdGroupId     long
   * @return AdGroupAdOperation
   */
  public static AdGroupAdOperation createSampleDasAddRequest(AdGroupAdOperation operation, long accountId, long dasCampaignId, long dasAdGroupId) {
    // Set Operation
    if(operation == null) {
      operation = new AdGroupAdOperation();
      operation.setOperator(Operator.ADD);
      operation.setAccountId(accountId);
    } else if( !operation.getOperator().equals(Operator.ADD) || operation.getAccountId() != accountId) {
      return operation;
    }

    // Set CustomParameters
    CustomParameters customParameters = new CustomParameters();
    CustomParameter parameter1 = new CustomParameter();
    parameter1.setKey("id1");
    parameter1.setValue("1234");
    customParameters.getParameters().addAll(Arrays.asList(parameter1));

    // Set DasAd
    DynamicSearchLinkedAd dynamicSearchLinkedAd = new DynamicSearchLinkedAd();
    dynamicSearchLinkedAd.setType(AdType.DYNAMIC_SEARCH_LINKED_AD);
    dynamicSearchLinkedAd.setTrackingUrl("http://www.xxxxx.com/?url={lpurl}&pid={_id1}");
    dynamicSearchLinkedAd.setCustomParameters(customParameters);
    dynamicSearchLinkedAd.setDescription("description");

    AdGroupAd dasAdAdGroupAd = new AdGroupAd();
    dasAdAdGroupAd.setAccountId(accountId);
    dasAdAdGroupAd.setCampaignId(dasCampaignId);
    dasAdAdGroupAd.setAdGroupId(dasAdGroupId);
    dasAdAdGroupAd.setAdName("SampleDasAdAd_CreateOn_" + SoapUtils.getCurrentTimestamp());
    dasAdAdGroupAd.setAd(dynamicSearchLinkedAd);
    dasAdAdGroupAd.setUserStatus(UserStatus.ACTIVE);

    operation.getOperand().addAll(Arrays.asList(dasAdAdGroupAd));

    return operation;
  }

  /**
   * create sample request.
   *
   * @param accountId       long
   * @param adGroupAdValues AdGroupAdValues
   * @return AdGroupAdOperation
   */
  public static AdGroupAdOperation createSampleSetRequest(long accountId, List<AdGroupAdValues> adGroupAdValues) {
    // Set Operation
    AdGroupAdOperation operation = new AdGroupAdOperation();
    operation.setOperator(Operator.SET);
    operation.setAccountId(accountId);

    // Set Operand
    for (AdGroupAdValues adGroupAdValue : adGroupAdValues) {

      AdGroupAd adGroupAd = new AdGroupAd();
      adGroupAd.setAccountId(adGroupAdValue.getAdGroupAd().getAccountId());
      adGroupAd.setCampaignId(adGroupAdValue.getAdGroupAd().getCampaignId());
      adGroupAd.setAdGroupId(adGroupAdValue.getAdGroupAd().getAdGroupId());
      adGroupAd.setAdId(adGroupAdValue.getAdGroupAd().getAdId());
      adGroupAd.setUserStatus(UserStatus.PAUSED);

      if (AdType.APP_AD.equals(adGroupAdValue.getAdGroupAd().getAd().getType())) {

        // Set AppAd
        AppAd appAd = new AppAd();
        appAd.setType(AdType.APP_AD);

        adGroupAd.setAdName("SampleAppAd_UpdateOn_" + SoapUtils.getCurrentTimestamp());
        adGroupAd.setAd(appAd);
      } else if(AdType.EXTENDED_TEXT_AD.equals(adGroupAdValue.getAdGroupAd().getAd().getType())) {
        // Set ExtendedTextAd
        ExtendedTextAd extendedTextAd = new ExtendedTextAd();
        extendedTextAd.setType(AdType.APP_AD);

        adGroupAd.setAdName("SampleAppAd_UpdateOn_" + SoapUtils.getCurrentTimestamp());
        adGroupAd.setAd(extendedTextAd);
      }

      operation.getOperand().add(adGroupAd);
    }

    return operation;
  }

  /**
   * create sample request.
   *
   * @param accountId       long
   * @param adGroupAdValues AdGroupAdValues
   * @return AdGroupAdOperation
   */
  public static AdGroupAdOperation createSampleRemoveRequest(long accountId, List<AdGroupAdValues> adGroupAdValues) {
    // Set Operation
    AdGroupAdOperation operation = new AdGroupAdOperation();
    operation.setOperator(Operator.REMOVE);
    operation.setAccountId(accountId);

    // Set Operand
    for (AdGroupAdValues adGroupAdValue : adGroupAdValues) {

      AdGroupAd adGroupAd = new AdGroupAd();
      adGroupAd.setAccountId(adGroupAdValue.getAdGroupAd().getAccountId());
      adGroupAd.setCampaignId(adGroupAdValue.getAdGroupAd().getCampaignId());
      adGroupAd.setAdGroupId(adGroupAdValue.getAdGroupAd().getAdGroupId());
      adGroupAd.setAdId(adGroupAdValue.getAdGroupAd().getAdId());

      operation.getOperand().add(adGroupAd);
    }

    return operation;
  }

  /**
   * create sample request.
   *
   * @param accountId       long
   * @param adGroupAdValues AdGroupAdValues
   * @return AdGroupAdSelector
   */
  public static AdGroupAdSelector createSampleGetRequest(long accountId, List<AdGroupAdValues> adGroupAdValues) {
    // Set Selector
    AdGroupAdSelector selector = new AdGroupAdSelector();
    selector.setAccountId(accountId);
    for (AdGroupAdValues adGroupAdValue : adGroupAdValues) {
      selector.getCampaignIds().add((adGroupAdValue.getAdGroupAd().getCampaignId()));
      selector.getAdGroupIds().add((adGroupAdValue.getAdGroupAd().getAdGroupId()));
      selector.getAdIds().add((adGroupAdValue.getAdGroupAd().getAdId()));
    }
    selector.getUserStatuses().addAll(Arrays.asList(UserStatus.ACTIVE, UserStatus.PAUSED));
    selector.getApprovalStatuses().addAll(
        Arrays.asList(ApprovalStatus.APPROVED, ApprovalStatus.APPROVED_WITH_REVIEW, ApprovalStatus.REVIEW, ApprovalStatus.POST_DISAPPROVED, ApprovalStatus.PRE_DISAPPROVED));
    Paging paging = new Paging();
    paging.setStartIndex(1);
    paging.setNumberResults(20);
    selector.setPaging(paging);

    return selector;
  }
}

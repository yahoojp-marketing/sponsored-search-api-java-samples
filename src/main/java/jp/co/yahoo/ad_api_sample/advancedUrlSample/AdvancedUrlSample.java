package jp.co.yahoo.ad_api_sample.advancedUrlSample;

import java.util.Arrays;
import java.util.List;

import javax.xml.ws.Holder;

import jp.co.yahoo.ad_api_sample.adCustomizerSample.FeedItemServiceSample;
import jp.co.yahoo.ad_api_sample.adSample.AdGroupAdServiceSample;
import jp.co.yahoo.ad_api_sample.adSample.AdGroupBidMultiplierServiceSample;
import jp.co.yahoo.ad_api_sample.adSample.AdGroupCriterionServiceSample;
import jp.co.yahoo.ad_api_sample.adSample.AdGroupServiceSample;
import jp.co.yahoo.ad_api_sample.adSample.BiddingStrategyServiceSample;
import jp.co.yahoo.ad_api_sample.adSample.CampaignCriterionServiceSample;
import jp.co.yahoo.ad_api_sample.adSample.CampaignServiceSample;
import jp.co.yahoo.ad_api_sample.adSample.CampaignTargetServiceSample;
import jp.co.yahoo.ad_api_sample.error.impl.AdGroupFeedServiceErrorEntityFactory;
import jp.co.yahoo.ad_api_sample.error.impl.CampaignFeedServiceErrorEntityFactory;
import jp.co.yahoo.ad_api_sample.util.SoapUtils;
import jp.yahooapis.ss.V6.AdGroupAdService.AdGroupAd;
import jp.yahooapis.ss.V6.AdGroupAdService.AdGroupAdOperation;
import jp.yahooapis.ss.V6.AdGroupAdService.AdGroupAdSelector;
import jp.yahooapis.ss.V6.AdGroupAdService.AdGroupAdValues;
import jp.yahooapis.ss.V6.AdGroupAdService.AdType;
import jp.yahooapis.ss.V6.AdGroupAdService.DevicePreference;
import jp.yahooapis.ss.V6.AdGroupAdService.Operator;
import jp.yahooapis.ss.V6.AdGroupAdService.TextAd2;
import jp.yahooapis.ss.V6.AdGroupAdService.UserStatus;
import jp.yahooapis.ss.V6.AdGroupBidMultiplierService.AdGroupBidMultiplierOperation;
import jp.yahooapis.ss.V6.AdGroupBidMultiplierService.AdGroupBidMultiplierSelector;
import jp.yahooapis.ss.V6.AdGroupCriterionService.AdGroupCriterionOperation;
import jp.yahooapis.ss.V6.AdGroupCriterionService.AdGroupCriterionSelector;
import jp.yahooapis.ss.V6.AdGroupCriterionService.AdGroupCriterionValues;
import jp.yahooapis.ss.V6.AdGroupFeedService.AdGroupFeed;
import jp.yahooapis.ss.V6.AdGroupFeedService.AdGroupFeedList;
import jp.yahooapis.ss.V6.AdGroupFeedService.AdGroupFeedOperation;
import jp.yahooapis.ss.V6.AdGroupFeedService.AdGroupFeedPage;
import jp.yahooapis.ss.V6.AdGroupFeedService.AdGroupFeedReturnValue;
import jp.yahooapis.ss.V6.AdGroupFeedService.AdGroupFeedSelector;
import jp.yahooapis.ss.V6.AdGroupFeedService.AdGroupFeedService;
import jp.yahooapis.ss.V6.AdGroupFeedService.AdGroupFeedServiceInterface;
import jp.yahooapis.ss.V6.AdGroupFeedService.AdGroupFeedValues;
import jp.yahooapis.ss.V6.AdGroupService.AdGroupOperation;
import jp.yahooapis.ss.V6.AdGroupService.AdGroupSelector;
import jp.yahooapis.ss.V6.AdGroupService.AdGroupValues;
import jp.yahooapis.ss.V6.BiddingStrategyService.BiddingStrategyOperation;
import jp.yahooapis.ss.V6.BiddingStrategyService.BiddingStrategySelector;
import jp.yahooapis.ss.V6.BiddingStrategyService.BiddingStrategyValues;
import jp.yahooapis.ss.V6.BiddingStrategyService.PageOnePromotedBiddingScheme;
import jp.yahooapis.ss.V6.CampaignCriterionService.CampaignCriterionOperation;
import jp.yahooapis.ss.V6.CampaignCriterionService.CampaignCriterionSelector;
import jp.yahooapis.ss.V6.CampaignCriterionService.CampaignCriterionValues;
import jp.yahooapis.ss.V6.CampaignFeedService.CampaignFeed;
import jp.yahooapis.ss.V6.CampaignFeedService.CampaignFeedList;
import jp.yahooapis.ss.V6.CampaignFeedService.CampaignFeedOperation;
import jp.yahooapis.ss.V6.CampaignFeedService.CampaignFeedPage;
import jp.yahooapis.ss.V6.CampaignFeedService.CampaignFeedReturnValue;
import jp.yahooapis.ss.V6.CampaignFeedService.CampaignFeedSelector;
import jp.yahooapis.ss.V6.CampaignFeedService.CampaignFeedService;
import jp.yahooapis.ss.V6.CampaignFeedService.CampaignFeedServiceInterface;
import jp.yahooapis.ss.V6.CampaignFeedService.CampaignFeedValues;
import jp.yahooapis.ss.V6.CampaignFeedService.DevicePlatform;
import jp.yahooapis.ss.V6.CampaignService.CampaignOperation;
import jp.yahooapis.ss.V6.CampaignService.CampaignSelector;
import jp.yahooapis.ss.V6.CampaignService.CampaignType;
import jp.yahooapis.ss.V6.CampaignService.CampaignValues;
import jp.yahooapis.ss.V6.CampaignTargetService.CampaignTargetOperation;
import jp.yahooapis.ss.V6.CampaignTargetService.CampaignTargetSelector;
import jp.yahooapis.ss.V6.CampaignTargetService.CampaignTargetValues;
import jp.yahooapis.ss.V6.FeedItemService.Advanced;
import jp.yahooapis.ss.V6.FeedItemService.ApprovalStatus;
import jp.yahooapis.ss.V6.FeedItemService.CustomParameter;
import jp.yahooapis.ss.V6.FeedItemService.CustomParameters;
import jp.yahooapis.ss.V6.FeedItemService.DayOfWeek;
import jp.yahooapis.ss.V6.FeedItemService.FeedItem;
import jp.yahooapis.ss.V6.FeedItemService.FeedItemAttribute;
import jp.yahooapis.ss.V6.FeedItemService.FeedItemOperation;
import jp.yahooapis.ss.V6.FeedItemService.FeedItemSchedule;
import jp.yahooapis.ss.V6.FeedItemService.FeedItemScheduling;
import jp.yahooapis.ss.V6.FeedItemService.FeedItemSelector;
import jp.yahooapis.ss.V6.FeedItemService.FeedItemValues;
import jp.yahooapis.ss.V6.FeedItemService.IsRemove;
import jp.yahooapis.ss.V6.FeedItemService.MinuteOfHour;
import jp.yahooapis.ss.V6.FeedItemService.Paging;
import jp.yahooapis.ss.V6.FeedItemService.PlaceholderField;
import jp.yahooapis.ss.V6.FeedItemService.PlaceholderType;


/**
 * Adavanced Url Sample Program for BiddingStrategyService,CampaignService,CampaignTargetService,
 * CampaignCriterionService,AdGroupService,AdGroupCriterionService,AdGroupAdService,
 * FeedItemService,CampaignFeedService,AdGroupFeedService. Copyright (C) 2016 Yahoo Japan
 * Corporation. All Rights Reserved.
 */
public class AdvancedUrlSample {

  /**
   * main method for AdSample
   *
   * @param args command line arguments
   */
  public static void main(String[] args) throws Exception {
    try {
      // =================================================================
      // Setting
      // =================================================================
      long accountId = SoapUtils.getAccountId();
      long biddingStrategyId = 0;
      long campaignId = 0;
      long adGroupId = 0;
      long appCampaignId = 0;
      long appAdGroupId = 0;
      long feedItemId1 = -1;

      // =================================================================
      // BiddingStrategyService
      // =================================================================
      // ADD
      BiddingStrategyOperation addBiddingStrategyOperation = BiddingStrategyServiceSample.createSampleAddRequest(accountId);
      List<BiddingStrategyValues> biddingStrategyValues = BiddingStrategyServiceSample.add(addBiddingStrategyOperation);

      // sleep 30 second.
      System.out.println("\n***** sleep 30 seconds *****\n");
      Thread.sleep(30000);

      // GET
      BiddingStrategySelector biddingStrategySelector = BiddingStrategyServiceSample.createSampleGetRequest(accountId, biddingStrategyValues);
      BiddingStrategyServiceSample.get(biddingStrategySelector);
      // SET
      BiddingStrategyOperation setBiddingStrategyOperation = BiddingStrategyServiceSample.createSampleSetRequest(accountId, biddingStrategyValues);
      BiddingStrategyServiceSample.set(setBiddingStrategyOperation);

      for (BiddingStrategyValues value : biddingStrategyValues) {
        if (value.getBiddingStrategy().getBiddingScheme() instanceof PageOnePromotedBiddingScheme) {
          biddingStrategyId = value.getBiddingStrategy().getBiddingStrategyId();
        }
      }

      // sleep 30 second.
      System.out.println("\n***** sleep 30 seconds *****\n");
      Thread.sleep(30000);

      // =================================================================
      // CampaignService
      // =================================================================
      // ADD
      CampaignOperation addCampaignOperation = CampaignServiceSample.createSampleAddRequest(accountId, biddingStrategyId);
      List<CampaignValues> campaignValues = CampaignServiceSample.add(addCampaignOperation);
      // GET
      CampaignSelector campaignSelector = CampaignServiceSample.createSampleGetRequest(accountId, campaignValues);
      CampaignServiceSample.get(campaignSelector);
      // SET
      CampaignOperation setCampaignOperation = CampaignServiceSample.createSampleSetRequest(accountId, biddingStrategyId, campaignValues);
      CampaignServiceSample.set(setCampaignOperation);

      for (CampaignValues value : campaignValues) {
        if (CampaignType.STANDARD.equals(value.getCampaign().getCampaignType())) {
          if (campaignId == 0) {
            campaignId = value.getCampaign().getCampaignId();
          }
        } else if (CampaignType.MOBILE_APP.equals(value.getCampaign().getCampaignType())) {
          if (appCampaignId == 0) {
            appCampaignId = value.getCampaign().getCampaignId();
          }
        }
      }

      // =================================================================
      // CampaignTargetService
      // =================================================================
      // ADD
      CampaignTargetOperation addCampaignTargetOperation = CampaignTargetServiceSample.createSampleAddRequest(accountId, campaignId, appCampaignId);
      List<CampaignTargetValues> campaignTargetValues = CampaignTargetServiceSample.add(addCampaignTargetOperation);
      // GET
      CampaignTargetSelector campaignTargetSelector = CampaignTargetServiceSample.createSampleGetRequest(accountId, campaignTargetValues);
      CampaignTargetServiceSample.get(campaignTargetSelector);
      // SET
      CampaignTargetOperation setCampaignTargetOperation = CampaignTargetServiceSample.createSampleSetRequest(accountId, campaignTargetValues);
      CampaignTargetServiceSample.set(setCampaignTargetOperation);

      // =================================================================
      // CampaignCriterionService
      // =================================================================
      // ADD
      CampaignCriterionOperation addCampaignCriterionOperation = CampaignCriterionServiceSample.createSampleAddRequest(accountId, campaignId);
      List<CampaignCriterionValues> campaignCriterionValues = CampaignCriterionServiceSample.add(addCampaignCriterionOperation);
      // GET
      CampaignCriterionSelector campaignCriterionSelector = CampaignCriterionServiceSample.createSampleGetRequest(accountId, campaignCriterionValues);
      CampaignCriterionServiceSample.get(campaignCriterionSelector);

      // =================================================================
      // AdGroupService
      // =================================================================
      // ADD
      AdGroupOperation addAdGroupOperation = AdGroupServiceSample.createSampleAddRequest(accountId, campaignId, appCampaignId, biddingStrategyId);
      List<AdGroupValues> adGroupValues = AdGroupServiceSample.add(addAdGroupOperation);
      // GET
      AdGroupSelector adGroupSelector = AdGroupServiceSample.createSampleGetRequest(accountId, adGroupValues);
      AdGroupServiceSample.get(adGroupSelector);
      // SET
      AdGroupOperation setAdGroupOperation = AdGroupServiceSample.createSampleSetRequest(accountId, biddingStrategyId, adGroupValues);
      AdGroupServiceSample.set(setAdGroupOperation);

      for (AdGroupValues value : adGroupValues) {
        if (value.getAdGroup().getCampaignId() == campaignId) {
          if (adGroupId == 0) {
            adGroupId = value.getAdGroup().getAdGroupId();
          }
        } else if (value.getAdGroup().getCampaignId() == appCampaignId) {
          if (appAdGroupId == 0) {
            appAdGroupId = value.getAdGroup().getAdGroupId();
          }
        }
      }

      // =================================================================
      // AdGroupCriterionService
      // =================================================================
      // ADD
      AdGroupCriterionOperation addAdGroupCriterionOperation = AdGroupCriterionServiceSample.createSampleAddRequest(accountId, campaignId, adGroupId);
      List<AdGroupCriterionValues> adGroupCriterionValues = AdGroupCriterionServiceSample.add(addAdGroupCriterionOperation);
      // GET
      AdGroupCriterionSelector adGroupCriterionSelector = AdGroupCriterionServiceSample.createSampleGetRequest(accountId, campaignId, adGroupId, adGroupCriterionValues);
      AdGroupCriterionServiceSample.get(adGroupCriterionSelector);
      // SET
      AdGroupCriterionOperation setAdGroupCriterionOperation = AdGroupCriterionServiceSample.createSampleSetRequest(accountId, campaignId, adGroupId, adGroupCriterionValues);
      AdGroupCriterionServiceSample.set(setAdGroupCriterionOperation);

      // =================================================================
      // AdGroupBidMultiplierService
      // =================================================================
      // SET
      AdGroupBidMultiplierOperation adGroupBidMultiplierOperation = AdGroupBidMultiplierServiceSample.createSampleSetRequest(accountId, campaignId, adGroupId);
      AdGroupBidMultiplierServiceSample.set(adGroupBidMultiplierOperation);
      // GET
      AdGroupBidMultiplierSelector adGroupBidMultiplierSelector = AdGroupBidMultiplierServiceSample.createSampleGetRequest(accountId, campaignId, adGroupId);
      AdGroupBidMultiplierServiceSample.get(adGroupBidMultiplierSelector);

      // =================================================================
      // AdGroupAdService
      // =================================================================
      // ADD
      AdGroupAdOperation addAdGroupAdOperation = createAdGroupAdSampleAddRequest(accountId, campaignId, adGroupId, appCampaignId, appAdGroupId);
      List<AdGroupAdValues> adGroupAdValues = AdGroupAdServiceSample.add(addAdGroupAdOperation);
      // GET
      AdGroupAdSelector adGroupAdSelector = AdGroupAdServiceSample.createSampleGetRequest(accountId, adGroupAdValues);
      AdGroupAdServiceSample.get(adGroupAdSelector);
      // SET
      AdGroupAdOperation setAdGroupAdOperation = AdGroupAdServiceSample.createSampleSetRequest(accountId, adGroupAdValues);
      AdGroupAdServiceSample.set(setAdGroupAdOperation);


      // =================================================================
      // FeedItemService
      // =================================================================
      // ADD QUICKLINK
      FeedItemOperation addFeedItemOperation_quicklink = createSampleFeedItemServiceAddRequest_quicklink(accountId);
      List<FeedItemValues> addfeedItemValues_quicklink = FeedItemServiceSample.add(addFeedItemOperation_quicklink);
      // GET QUICKLINK
      FeedItemSelector feedItemSelector1 = createFeedItemSampleGetRequest(accountId, addfeedItemValues_quicklink);
      FeedItemServiceSample.get(feedItemSelector1);
      // wait for sandbox review
      Thread.sleep(30000);

      // SET QUICKLINK
      FeedItemOperation setFeedItemOperation_quicklink = createSampleFeedItemServiceSetRequest_quicklink(accountId, addfeedItemValues_quicklink);
      List<FeedItemValues> setFeedItemValues_quicklink = FeedItemServiceSample.set(setFeedItemOperation_quicklink);
      for (FeedItemValues feedItemValues : setFeedItemValues_quicklink) {
        if (feedItemValues.getFeedItem().getFeedItemId() != null) {
          feedItemId1 = feedItemValues.getFeedItem().getFeedItemId();
        }
      }

      // =================================================================
      // CampaignFeedService
      // =================================================================
      CampaignFeedServiceInterface campaignFeedService = SoapUtils.createServiceInterface(CampaignFeedServiceInterface.class, CampaignFeedService.class);

      // -----------------------------------------------
      // CampaignFeedService::mutate(SET)
      // -----------------------------------------------
      // request add QUICKLINK setting
      CampaignFeedList setCampaignFeedListOperand = new CampaignFeedList();
      setCampaignFeedListOperand.setAccountId(accountId);
      setCampaignFeedListOperand.setCampaignId(campaignId);
      setCampaignFeedListOperand.setPlaceholderType(jp.yahooapis.ss.V6.CampaignFeedService.PlaceholderType.QUICKLINK);
      CampaignFeed setCampaignFeed1 = new CampaignFeed();
      setCampaignFeed1.setFeedItemId(feedItemId1);
      setCampaignFeedListOperand.getCampaignFeed().add(setCampaignFeed1);
      setCampaignFeedListOperand.setDevicePlatform(DevicePlatform.DESKTOP);

      CampaignFeedOperation setCampaignFeedOperation = new CampaignFeedOperation();
      setCampaignFeedOperation.setOperator(jp.yahooapis.ss.V6.CampaignFeedService.Operator.SET);
      setCampaignFeedOperation.setAccountId(accountId);
      setCampaignFeedOperation.getOperand().add(setCampaignFeedListOperand);

      // call API
      System.out.println("############################################");
      System.out.println("CampaignFeedService::mutate(SET)");
      System.out.println("############################################");
      Holder<CampaignFeedReturnValue> setCampaignFeedReturnValueHolder = new Holder<CampaignFeedReturnValue>();
      Holder<List<jp.yahooapis.ss.V6.CampaignFeedService.Error>> setCampaignFeedErrorHolder = new Holder<List<jp.yahooapis.ss.V6.CampaignFeedService.Error>>();
      campaignFeedService.mutate(setCampaignFeedOperation, setCampaignFeedReturnValueHolder, setCampaignFeedErrorHolder);

      // if error
      if (setCampaignFeedErrorHolder.value != null && setCampaignFeedErrorHolder.value.size() > 0) {
        SoapUtils.displayErrors(new CampaignFeedServiceErrorEntityFactory(setCampaignFeedErrorHolder.value), true);
      }

      // response
      if (setCampaignFeedReturnValueHolder.value != null) {
        CampaignFeedReturnValue returnValue = setCampaignFeedReturnValueHolder.value;
        if (returnValue.getValues() != null && returnValue.getValues().size() > 0) {
          List<CampaignFeedValues> values = returnValue.getValues();
          for (int i = 0; i < values.size(); i++) {
            if (values.get(i).isOperationSucceeded()) {
              // display response
              CampaignFeedList campaignFeedList = values.get(i).getCampaignFeedList();
              displayCampaignFeed(campaignFeedList);
            } else {
              // if error
              SoapUtils.displayErrors(new CampaignFeedServiceErrorEntityFactory(values.get(i).getError()), true);
            }
          }
        }
      }

      // -----------------------------------------------
      // CampaignFeedService::get
      // -----------------------------------------------
      // request
      CampaignFeedSelector campaignFeedSelector = new CampaignFeedSelector();
      campaignFeedSelector.setAccountId(accountId);
      campaignFeedSelector.getCampaignIds().add(campaignId);
      campaignFeedSelector.getFeedItemIds().add(feedItemId1);
      campaignFeedSelector.getPlaceholderTypes().add(jp.yahooapis.ss.V6.CampaignFeedService.PlaceholderType.QUICKLINK);
      campaignFeedSelector.getPlaceholderTypes().add(jp.yahooapis.ss.V6.CampaignFeedService.PlaceholderType.CALLEXTENSION);

      jp.yahooapis.ss.V6.CampaignFeedService.Paging campaignFeedPaging = new jp.yahooapis.ss.V6.CampaignFeedService.Paging();
      campaignFeedPaging.setStartIndex(1);
      campaignFeedPaging.setNumberResults(20);
      campaignFeedSelector.setPaging(campaignFeedPaging);

      // call API
      System.out.println("############################################");
      System.out.println("CampaignFeedService::get");
      System.out.println("############################################");
      Holder<CampaignFeedPage> campaignFeedPageHolder = new Holder<CampaignFeedPage>();
      Holder<List<jp.yahooapis.ss.V6.CampaignFeedService.Error>> getCampaignFeedErrorArrayHolder = new Holder<List<jp.yahooapis.ss.V6.CampaignFeedService.Error>>();
      campaignFeedService.get(campaignFeedSelector, campaignFeedPageHolder, getCampaignFeedErrorArrayHolder);

      // if error
      if (getCampaignFeedErrorArrayHolder.value != null && getCampaignFeedErrorArrayHolder.value.size() > 0) {
        SoapUtils.displayErrors(new CampaignFeedServiceErrorEntityFactory(getCampaignFeedErrorArrayHolder.value), true);
      }

      // response
      if (campaignFeedPageHolder.value != null) {
        if (campaignFeedPageHolder.value.getValues() != null) {
          for (CampaignFeedValues values : campaignFeedPageHolder.value.getValues()) {
            if (values.isOperationSucceeded()) {
              // display response
              displayCampaignFeed(values.getCampaignFeedList());
            } else {
              // if error
              SoapUtils.displayErrors(new CampaignFeedServiceErrorEntityFactory(values.getError()), true);
            }
          }
        }
      }


      // =================================================================
      // AdGroupFeedService
      // =================================================================
      AdGroupFeedServiceInterface adGroupFeedService = SoapUtils.createServiceInterface(AdGroupFeedServiceInterface.class, AdGroupFeedService.class);

      // -----------------------------------------------
      // AdGroupFeedService::mutate(SET)
      // -----------------------------------------------
      // request add QUICKLINK setting
      AdGroupFeedList setAdGroupFeedListOperand = new AdGroupFeedList();
      setAdGroupFeedListOperand.setAccountId(accountId);
      setAdGroupFeedListOperand.setCampaignId(campaignId);
      setAdGroupFeedListOperand.setAdGroupId(adGroupId);
      setAdGroupFeedListOperand.setPlaceholderType(jp.yahooapis.ss.V6.AdGroupFeedService.PlaceholderType.QUICKLINK);
      AdGroupFeed setAdGroupFeed1 = new AdGroupFeed();
      setAdGroupFeed1.setFeedItemId(feedItemId1);
      setAdGroupFeedListOperand.getAdGroupFeed().add(setAdGroupFeed1);

      AdGroupFeedOperation setAdGroupFeedOperation = new AdGroupFeedOperation();
      setAdGroupFeedOperation.setOperator(jp.yahooapis.ss.V6.AdGroupFeedService.Operator.SET);
      setAdGroupFeedOperation.setAccountId(accountId);
      setAdGroupFeedOperation.getOperand().add(setAdGroupFeedListOperand);

      // call API
      System.out.println("############################################");
      System.out.println("AdGroupFeedService::mutate(SET)");
      System.out.println("############################################");
      Holder<AdGroupFeedReturnValue> setAdGroupFeedReturnValueHolder = new Holder<AdGroupFeedReturnValue>();
      Holder<List<jp.yahooapis.ss.V6.AdGroupFeedService.Error>> setAdGroupFeedErrorHolder = new Holder<List<jp.yahooapis.ss.V6.AdGroupFeedService.Error>>();
      adGroupFeedService.mutate(setAdGroupFeedOperation, setAdGroupFeedReturnValueHolder, setAdGroupFeedErrorHolder);

      // if error
      if (setAdGroupFeedErrorHolder.value != null && setAdGroupFeedErrorHolder.value.size() > 0) {
        SoapUtils.displayErrors(new AdGroupFeedServiceErrorEntityFactory(setAdGroupFeedErrorHolder.value), true);
      }

      // response
      if (setAdGroupFeedReturnValueHolder.value != null) {
        AdGroupFeedReturnValue returnValue = setAdGroupFeedReturnValueHolder.value;
        if (returnValue.getValues() != null && returnValue.getValues().size() > 0) {
          List<AdGroupFeedValues> values = returnValue.getValues();
          for (int i = 0; i < values.size(); i++) {
            if (values.get(i).isOperationSucceeded()) {
              // display response
              AdGroupFeedList adGroupFeedList = values.get(i).getAdGroupFeedList();
              displayAdGroupFeed(adGroupFeedList);
            } else {
              // if error
              SoapUtils.displayErrors(new AdGroupFeedServiceErrorEntityFactory(values.get(i).getError()), true);
            }
          }
        }
      }


      // -----------------------------------------------
      // AdGroupFeedService::get
      // -----------------------------------------------
      // request
      AdGroupFeedSelector adGroupFeedSelector = new AdGroupFeedSelector();
      adGroupFeedSelector.setAccountId(accountId);
      adGroupFeedSelector.getCampaignIds().add(campaignId);
      adGroupFeedSelector.getFeedItemIds().add(feedItemId1);
      adGroupFeedSelector.getPlaceholderTypes().add(jp.yahooapis.ss.V6.AdGroupFeedService.PlaceholderType.QUICKLINK);
      adGroupFeedSelector.getPlaceholderTypes().add(jp.yahooapis.ss.V6.AdGroupFeedService.PlaceholderType.CALLEXTENSION);
      jp.yahooapis.ss.V6.AdGroupFeedService.Paging adGroupFeedPaging = new jp.yahooapis.ss.V6.AdGroupFeedService.Paging();
      adGroupFeedPaging.setStartIndex(1);
      adGroupFeedPaging.setNumberResults(20);
      adGroupFeedSelector.setPaging(adGroupFeedPaging);

      // call API
      System.out.println("############################################");
      System.out.println("AdGroupFeedService::get");
      System.out.println("############################################");
      Holder<AdGroupFeedPage> adGroupFeedPageHolder = new Holder<AdGroupFeedPage>();
      Holder<List<jp.yahooapis.ss.V6.AdGroupFeedService.Error>> getAdGroupFeedErrorArrayHolder = new Holder<List<jp.yahooapis.ss.V6.AdGroupFeedService.Error>>();
      adGroupFeedService.get(adGroupFeedSelector, adGroupFeedPageHolder, getAdGroupFeedErrorArrayHolder);

      // if error
      if (getAdGroupFeedErrorArrayHolder.value != null && getAdGroupFeedErrorArrayHolder.value.size() > 0) {
        SoapUtils.displayErrors(new AdGroupFeedServiceErrorEntityFactory(getAdGroupFeedErrorArrayHolder.value), true);
      }

      // response
      if (adGroupFeedPageHolder.value != null) {
        if (adGroupFeedPageHolder.value.getValues() != null) {
          for (AdGroupFeedValues values : adGroupFeedPageHolder.value.getValues()) {
            if (values.isOperationSucceeded()) {
              // display response
              displayAdGroupFeed(values.getAdGroupFeedList());
            } else {
              // if error
              SoapUtils.displayErrors(new AdGroupFeedServiceErrorEntityFactory(values.getError()), true);
            }
          }
        }
      }

      // -----------------------------------------------
      // CampaignFeedService::mutate(SET)
      // -----------------------------------------------
      // request remove QUICKLINK setting
      CampaignFeedList setCampaignFeedListOperandForRemove = new CampaignFeedList();
      setCampaignFeedListOperandForRemove.setAccountId(accountId);
      setCampaignFeedListOperandForRemove.setCampaignId(campaignId);
      setCampaignFeedListOperandForRemove.setPlaceholderType(jp.yahooapis.ss.V6.CampaignFeedService.PlaceholderType.QUICKLINK);
      CampaignFeed setCampaignFeed2 = new CampaignFeed();
      setCampaignFeed2.setFeedItemId(null);
      setCampaignFeedListOperandForRemove.getCampaignFeed().add(setCampaignFeed2);

      CampaignFeedOperation setCampaignFeedOperationForRemove = new CampaignFeedOperation();
      setCampaignFeedOperationForRemove.setOperator(jp.yahooapis.ss.V6.CampaignFeedService.Operator.SET);
      setCampaignFeedOperationForRemove.setAccountId(accountId);
      setCampaignFeedOperationForRemove.getOperand().add(setCampaignFeedListOperandForRemove);

      // call API
      System.out.println("############################################");
      System.out.println("CampaignFeedService::mutate(SET) REMOVE");
      System.out.println("############################################");
      Holder<CampaignFeedReturnValue> setCampaignFeedReturnValueHolderForRemove = new Holder<CampaignFeedReturnValue>();
      Holder<List<jp.yahooapis.ss.V6.CampaignFeedService.Error>> setCampaignFeedErrorHolderForRemove = new Holder<List<jp.yahooapis.ss.V6.CampaignFeedService.Error>>();
      campaignFeedService.mutate(setCampaignFeedOperationForRemove, setCampaignFeedReturnValueHolderForRemove, setCampaignFeedErrorHolderForRemove);

      // if error
      if (setCampaignFeedErrorHolderForRemove.value != null && setCampaignFeedErrorHolderForRemove.value.size() > 0) {
        SoapUtils.displayErrors(new CampaignFeedServiceErrorEntityFactory(setCampaignFeedErrorHolderForRemove.value), true);
      }

      // response
      if (setCampaignFeedReturnValueHolderForRemove.value != null) {
        CampaignFeedReturnValue returnValue = setCampaignFeedReturnValueHolderForRemove.value;
        if (returnValue.getValues() != null && returnValue.getValues().size() > 0) {
          List<CampaignFeedValues> values = returnValue.getValues();
          for (int i = 0; i < values.size(); i++) {
            if (values.get(i).isOperationSucceeded()) {
              // display response
              CampaignFeedList campaignFeedList = values.get(i).getCampaignFeedList();
              displayCampaignFeed(campaignFeedList);
            } else {
              // if error
              SoapUtils.displayErrors(new CampaignFeedServiceErrorEntityFactory(values.get(i).getError()), true);
            }
          }
        }
      }


      // -----------------------------------------------
      // AdGroupFeedService::mutate(SET)
      // -----------------------------------------------
      // request remove QUICKLINK setting
      AdGroupFeedList setAdGroupFeedListOperandForRemove = new AdGroupFeedList();
      setAdGroupFeedListOperandForRemove.setAccountId(accountId);
      setAdGroupFeedListOperandForRemove.setCampaignId(campaignId);
      setAdGroupFeedListOperandForRemove.setAdGroupId(adGroupId);
      setAdGroupFeedListOperandForRemove.setPlaceholderType(jp.yahooapis.ss.V6.AdGroupFeedService.PlaceholderType.QUICKLINK);
      AdGroupFeed setAdGroupFeed2 = new AdGroupFeed();
      setAdGroupFeed2.setFeedItemId(null);
      setAdGroupFeedListOperandForRemove.getAdGroupFeed().add(setAdGroupFeed2);

      AdGroupFeedOperation setAdGroupFeedOperationForRemove = new AdGroupFeedOperation();
      setAdGroupFeedOperationForRemove.setOperator(jp.yahooapis.ss.V6.AdGroupFeedService.Operator.SET);
      setAdGroupFeedOperationForRemove.setAccountId(accountId);
      setAdGroupFeedOperationForRemove.getOperand().add(setAdGroupFeedListOperandForRemove);

      // call API
      System.out.println("############################################");
      System.out.println("AdGroupFeedService::mutate(SET) REMOVE");
      System.out.println("############################################");
      Holder<AdGroupFeedReturnValue> setAdGroupFeedReturnValueHolderForRemove = new Holder<AdGroupFeedReturnValue>();
      Holder<List<jp.yahooapis.ss.V6.AdGroupFeedService.Error>> setAdGroupFeedErrorHolderForRemove = new Holder<List<jp.yahooapis.ss.V6.AdGroupFeedService.Error>>();
      adGroupFeedService.mutate(setAdGroupFeedOperationForRemove, setAdGroupFeedReturnValueHolderForRemove, setAdGroupFeedErrorHolderForRemove);

      // if error
      if (setAdGroupFeedErrorHolderForRemove.value != null && setAdGroupFeedErrorHolderForRemove.value.size() > 0) {
        SoapUtils.displayErrors(new AdGroupFeedServiceErrorEntityFactory(setAdGroupFeedErrorHolderForRemove.value), true);
      }

      // response
      if (setAdGroupFeedReturnValueHolderForRemove.value != null) {
        AdGroupFeedReturnValue returnValue = setAdGroupFeedReturnValueHolderForRemove.value;
        if (returnValue.getValues() != null && returnValue.getValues().size() > 0) {
          List<AdGroupFeedValues> values = returnValue.getValues();
          for (int i = 0; i < values.size(); i++) {
            if (values.get(i).isOperationSucceeded()) {
              // display response
              AdGroupFeedList adGroupFeedList = values.get(i).getAdGroupFeedList();
              displayAdGroupFeed(adGroupFeedList);
            } else {
              // if error
              SoapUtils.displayErrors(new AdGroupFeedServiceErrorEntityFactory(values.get(i).getError()), true);
            }
          }
        }
      }

      // =================================================================
      // remove FeedItemService
      // =================================================================
      FeedItemOperation removeFeedItemOperation_quicklink = FeedItemServiceSample.createSampleRemoveRequest(accountId, setFeedItemValues_quicklink);
      removeFeedItemOperation_quicklink.setPlaceholderType(PlaceholderType.QUICKLINK);
      FeedItemServiceSample.remove(removeFeedItemOperation_quicklink);

      // =================================================================
      // remove AdGroupAdService, AdGroupCriterionService, AdGroupService,
      // CampaignCriterionService, CampaignTarget, BiddingStrategy, Campaign
      // =================================================================
      // AdGroupAdService
      AdGroupAdOperation removeAdGroupAdOperation = AdGroupAdServiceSample.createSampleRemoveRequest(accountId, adGroupAdValues);
      AdGroupAdServiceSample.remove(removeAdGroupAdOperation);

      // AdGroupCriterionService
      AdGroupCriterionOperation removeAdGroupCriterionOperation = AdGroupCriterionServiceSample.createSampleRemoveRequest(accountId, campaignId, adGroupId, adGroupCriterionValues);
      AdGroupCriterionServiceSample.remove(removeAdGroupCriterionOperation);

      // AdGroupService
      AdGroupOperation removeAdGroupOperation = AdGroupServiceSample.createSampleRemoveRequest(accountId, adGroupValues);
      AdGroupServiceSample.remove(removeAdGroupOperation);

      // CampaignCriterionService
      CampaignCriterionOperation removeCampaignCriterionOperation = CampaignCriterionServiceSample.createSampleRemoveRequest(accountId, campaignId, campaignCriterionValues);
      CampaignCriterionServiceSample.remove(removeCampaignCriterionOperation);

      // CampaignTarget
      CampaignTargetOperation removeCampaignTargetOperation = CampaignTargetServiceSample.createSampleRemoveRequest(accountId, campaignTargetValues);
      CampaignTargetServiceSample.remove(removeCampaignTargetOperation);

      // Campaign
      CampaignOperation removeCampaignOperation = CampaignServiceSample.createSampleRemoveRequest(accountId, campaignValues);
      CampaignServiceSample.remove(removeCampaignOperation);

      // BiddingStrategy
      BiddingStrategyOperation removeBiddingStrategyOperation = BiddingStrategyServiceSample.createSampleRemoveRequest(accountId, biddingStrategyValues);
      BiddingStrategyServiceSample.remove(removeBiddingStrategyOperation);

    } catch (Exception e) {
      e.printStackTrace();
      throw e;
    }
  }

  /**
   * create sample request.
   *
   * @param accountId long
   * @return FeedItemOperation
   */
  private static FeedItemOperation createSampleFeedItemServiceAddRequest_quicklink(long accountId) {
    // Set Operation
    FeedItemOperation operation = new FeedItemOperation();
    operation.setOperator(jp.yahooapis.ss.V6.FeedItemService.Operator.ADD);
    operation.setAccountId(accountId);
    operation.setPlaceholderType(PlaceholderType.QUICKLINK);

    // Set Operand
    FeedItem feedItem = new FeedItem();
    feedItem.setAccountId(accountId);
    feedItem.setPlaceholderType(PlaceholderType.QUICKLINK);

    FeedItemAttribute addLinkText = new FeedItemAttribute();
    addLinkText.setPlaceholderField(PlaceholderField.LINK_TEXT);
    addLinkText.setFeedAttributeValue("samplelink");
    feedItem.getFeedItemAttribute().add(addLinkText);

    FeedItemAttribute advancedUrl = new FeedItemAttribute();
    advancedUrl.setPlaceholderField(PlaceholderField.ADVANCED_URL);
    advancedUrl.setFeedAttributeValue("http://www.quicklink.sample.co.jp");
    feedItem.getFeedItemAttribute().add(advancedUrl);

    FeedItemAttribute advancedMobileUrl = new FeedItemAttribute();
    advancedMobileUrl.setPlaceholderField(PlaceholderField.ADVANCED_MOBILE_URL);
    advancedMobileUrl.setFeedAttributeValue("http://www.quicklink.sample.co.jp/mobile");
    feedItem.getFeedItemAttribute().add(advancedMobileUrl);

    FeedItemAttribute trackingUrl = new FeedItemAttribute();
    trackingUrl.setPlaceholderField(PlaceholderField.TRACKING_URL);
    trackingUrl.setFeedAttributeValue("http://www.quicklink.sample.co.jp?url={lpurl}&amp;pid={_id1}");
    feedItem.getFeedItemAttribute().add(trackingUrl);

    feedItem.setStartDate("20161215");
    feedItem.setEndDate("20181215");

    FeedItemSchedule quickLinkSchedule1 = new FeedItemSchedule();
    quickLinkSchedule1.setDayOfWeek(DayOfWeek.SUNDAY);
    quickLinkSchedule1.setStartHour(14L);
    quickLinkSchedule1.setStartMinute(MinuteOfHour.ZERO);
    quickLinkSchedule1.setEndHour(15L);
    quickLinkSchedule1.setEndMinute(MinuteOfHour.THIRTY);

    FeedItemSchedule quickLinkSchedule2 = new FeedItemSchedule();
    quickLinkSchedule2.setDayOfWeek(DayOfWeek.MONDAY);
    quickLinkSchedule2.setStartHour(14L);
    quickLinkSchedule2.setStartMinute(MinuteOfHour.ZERO);
    quickLinkSchedule2.setEndHour(15L);
    quickLinkSchedule2.setEndMinute(MinuteOfHour.THIRTY);

    FeedItemScheduling scheduling = new FeedItemScheduling();
    scheduling.getSchedules().addAll(Arrays.asList(quickLinkSchedule1, quickLinkSchedule2));
    feedItem.setScheduling(scheduling);

    feedItem.setDevicePreference(jp.yahooapis.ss.V6.FeedItemService.DevicePreference.SMART_PHONE);

    // Set CustomParameters
    CustomParameter customParameter = new CustomParameter();
    customParameter.setKey("1d1");
    customParameter.setValue("1234");

    CustomParameters customParameters = new CustomParameters();
    customParameters.getParameters().add(customParameter);
    feedItem.setCustomParameters(customParameters);
    feedItem.setAdvanced(Advanced.TRUE);

    operation.getOperand().add(feedItem);

    return operation;
  }

  /**
   * create sample request.
   *
   * @param accountId long
   * @param feedItemValues FeedItemValues
   * @return FeedItemOperation
   */
  private static FeedItemOperation createSampleFeedItemServiceSetRequest_quicklink(long accountId, List<FeedItemValues> feedItemValues) {
    FeedItemOperation operation = new FeedItemOperation();
    operation.setOperator(jp.yahooapis.ss.V6.FeedItemService.Operator.SET);
    operation.setAccountId(accountId);
    operation.setPlaceholderType(PlaceholderType.QUICKLINK);

    FeedItem operand = new FeedItem();
    operand.setAccountId(accountId);
    for (FeedItemValues feedItemValue : feedItemValues) {
      operand.setFeedItemId(feedItemValue.getFeedItem().getFeedItemId());
      break;
    }
    operand.setPlaceholderType(PlaceholderType.QUICKLINK);

    FeedItemAttribute setLinkText = new FeedItemAttribute();
    setLinkText.setPlaceholderField(PlaceholderField.LINK_TEXT);
    setLinkText.setFeedAttributeValue("editlink");
    operand.getFeedItemAttribute().add(setLinkText);

    FeedItemAttribute advancedUrl = new FeedItemAttribute();
    advancedUrl.setPlaceholderField(PlaceholderField.ADVANCED_URL);
    advancedUrl.setFeedAttributeValue("http://www.quicklink.sample.co.jp");
    operand.getFeedItemAttribute().add(advancedUrl);

    FeedItemAttribute advancedMobileUrl = new FeedItemAttribute();
    advancedMobileUrl.setPlaceholderField(PlaceholderField.ADVANCED_MOBILE_URL);
    advancedMobileUrl.setFeedAttributeValue("http://www.quicklink.sample.co.jp/mobile");
    operand.getFeedItemAttribute().add(advancedMobileUrl);

    FeedItemAttribute trackingUrl = new FeedItemAttribute();
    trackingUrl.setPlaceholderField(PlaceholderField.TRACKING_URL);
    trackingUrl.setFeedAttributeValue("http://www.quicklink.sample.co.jp?url={lpurl}&amp;pid={_id1}");
    operand.getFeedItemAttribute().add(trackingUrl);

    operand.setStartDate("");
    operand.setEndDate("");

    // Set CustomParameters
    CustomParameter customParameter = new CustomParameter();
    customParameter.setKey("1d1");
    customParameter.setValue("5678");

    CustomParameters customParameters = new CustomParameters();
    customParameters.setIsRemove(IsRemove.FALSE);
    customParameters.getParameters().add(customParameter);
    operand.setCustomParameters(customParameters);
    operand.setAdvanced(Advanced.TRUE);


    operation.getOperand().add(operand);

    return operation;
  }

  /**
   * display CampaignFeed entity to stdout.
   *
   * @param campaignFeed CampaignFeed entity for display.
   */
  private static void displayCampaignFeed(CampaignFeedList campaignFeedList) {
    System.out.println("accountId = " + campaignFeedList.getAccountId());
    System.out.println("campaignId = " + campaignFeedList.getCampaignId());
    System.out.println("placeholderType = " + campaignFeedList.getPlaceholderType());
    if (campaignFeedList.getCampaignFeed() != null) {
      for (CampaignFeed campaignFeed : campaignFeedList.getCampaignFeed()) {
        System.out.println("campaignFeed/accountld = " + campaignFeed.getAccountId());
        System.out.println("campaignFeed/campaignld = " + campaignFeed.getCampaignId());
        System.out.println("campaignFeed/feedItemld = " + campaignFeed.getFeedItemId());
        System.out.println("campaignFeed/placeholderType = " + campaignFeed.getPlaceholderType());
      }
    }
    System.out.println("---------");
  }

  /**
   * display AdGroupFeed entity to stdout.
   *
   * @param adGroupFeed AdGroupFeed entity for display.
   */
  private static void displayAdGroupFeed(AdGroupFeedList adGroupFeedList) {
    System.out.println("accountId = " + adGroupFeedList.getAccountId());
    System.out.println("campaignId = " + adGroupFeedList.getCampaignId());
    System.out.println("adGroupId = " + adGroupFeedList.getAdGroupId());
    System.out.println("placeholderType = " + adGroupFeedList.getPlaceholderType());
    if (adGroupFeedList.getAdGroupFeed() != null) {
      for (AdGroupFeed adGroupFeed : adGroupFeedList.getAdGroupFeed()) {
        System.out.println("adGroupFeed/accountld = " + adGroupFeed.getAccountId());
        System.out.println("adGroupFeed/campaignld = " + adGroupFeed.getCampaignId());
        System.out.println("adGroupFeed/adGroupld = " + adGroupFeed.getAdGroupId());
        System.out.println("adGroupFeed/feedItemld = " + adGroupFeed.getFeedItemId());
        System.out.println("adGroupFeed/placeholderType = " + adGroupFeed.getPlaceholderType());
      }
    }
    System.out.println("---------");
  }

  /**
   * create sample request.
   *
   * @param accountId long
   * @param campaignId long
   * @param adGroupId long
   * @param appCampaignId long
   * @param appAdGroupId long
   * @return AdGroupAdOperation
   */
  private static AdGroupAdOperation createAdGroupAdSampleAddRequest(long accountId, long campaignId, long adGroupId, long appCampaignId, long appAdGroupId) {
    // Set Operation
    AdGroupAdOperation operation = new AdGroupAdOperation();
    operation.setOperator(Operator.ADD);
    operation.setAccountId(accountId);

    // Set CustomParamaters
    jp.yahooapis.ss.V6.AdGroupAdService.CustomParameters customParameters = new jp.yahooapis.ss.V6.AdGroupAdService.CustomParameters();
    jp.yahooapis.ss.V6.AdGroupAdService.CustomParameter parameter1 = new jp.yahooapis.ss.V6.AdGroupAdService.CustomParameter();
    parameter1.setKey("id1");
    parameter1.setValue("1234");
    customParameters.getParameters().addAll(Arrays.asList(parameter1));

    // Set TextAd2
    TextAd2 textAd2 = new TextAd2();
    textAd2.setType(AdType.TEXT_AD_2);
    textAd2.setHeadline("sample headline");
    textAd2.setDescription("sample ad desc");
    textAd2.setDescription2("sample ad desc2");
    textAd2.setDisplayUrl("www.yahoo.co.jp");
    textAd2.setDevicePreference(DevicePreference.SMART_PHONE);
    textAd2.setAdvancedUrl("http://www.yahoo.co.jp");
    textAd2.setAdvancedMobileUrl("http://www.yahoo.co.jp/mobile");
    textAd2.setTrackingUrl("http://www.yahoo.co.jp/?url={lpurl}&amp;a={creative}&amp;pid={_id1}");
    textAd2.setCustomParameters(customParameters);

    AdGroupAd textAd2AdGroupAd = new AdGroupAd();
    textAd2AdGroupAd.setAccountId(accountId);
    textAd2AdGroupAd.setCampaignId(campaignId);
    textAd2AdGroupAd.setAdGroupId(adGroupId);
    textAd2AdGroupAd.setAdName("SampleTextAd2_CreateOn_" + SoapUtils.getCurrentTimestamp());
    textAd2AdGroupAd.setAd(textAd2);
    textAd2AdGroupAd.setUserStatus(UserStatus.ACTIVE);

    operation.getOperand().addAll(Arrays.asList(textAd2AdGroupAd));

    return operation;
  }

  /**
   * create sample request.
   * 
   * @param accountId Account ID
   * @param feedItemValues FeedItemValues entity for get.
   * @return FeedItemSelector
   */
  private static FeedItemSelector createFeedItemSampleGetRequest(long accountId, List<FeedItemValues> feedItemValues) {
    // Set Selector
    FeedItemSelector selector = new FeedItemSelector();
    selector.setAccountId(accountId);
    for (FeedItemValues feedItemValue : feedItemValues) {
      selector.getFeedItemIds().add(feedItemValue.getFeedItem().getFeedItemId());
    }
    selector.getPlaceholderTypes().add(PlaceholderType.QUICKLINK);
    selector.getPlaceholderTypes().add(PlaceholderType.CALLEXTENSION);
    selector.getPlaceholderTypes().add(PlaceholderType.AD_CUSTOMIZER);
    selector.getApprovalStatuses().add(ApprovalStatus.APPROVED);
    selector.getApprovalStatuses().add(ApprovalStatus.REVIEW);
    selector.getApprovalStatuses().add(ApprovalStatus.PRE_DISAPPROVED);
    selector.getApprovalStatuses().add(ApprovalStatus.APPROVED_WITH_REVIEW);
    selector.getApprovalStatuses().add(ApprovalStatus.POST_DISAPPROVED);
    selector.setAdvanced(Advanced.TRUE);

    Paging feedItemPaging = new Paging();
    feedItemPaging.setStartIndex(1);
    feedItemPaging.setNumberResults(20);
    selector.setPaging(feedItemPaging);

    return selector;
  }
}

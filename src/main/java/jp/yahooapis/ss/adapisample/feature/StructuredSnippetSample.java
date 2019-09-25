/**
 * Copyright (C) 2019 Yahoo Japan Corporation. All Rights Reserved.
 */
package jp.yahooapis.ss.adapisample.feature;

import jp.yahooapis.ss.adapisample.basic.adgroup.AdGroupServiceSample;
import jp.yahooapis.ss.adapisample.basic.adgroupfeed.AdGroupFeedServiceSample;
import jp.yahooapis.ss.adapisample.basic.campaign.CampaignServiceSample;
import jp.yahooapis.ss.adapisample.basic.campaignfeed.CampaignFeedServiceSample;
import jp.yahooapis.ss.adapisample.basic.feeditem.FeedItemServiceSample;
import jp.yahooapis.ss.adapisample.repository.ValuesRepositoryFacade;
import jp.yahooapis.ss.adapisample.util.SoapUtils;
import jp.yahooapis.ss.adapisample.util.ValuesHolder;
import jp.yahooapis.ss.v201909.adgroup.AdGroup;
import jp.yahooapis.ss.v201909.adgroup.AdGroupOperation;
import jp.yahooapis.ss.v201909.adgroup.AdGroupValues;
import jp.yahooapis.ss.v201909.adgroupfeed.AdGroupFeedList;
import jp.yahooapis.ss.v201909.adgroupfeed.AdGroupFeedOperation;
import jp.yahooapis.ss.v201909.adgroupfeed.AdGroupFeedPlaceholderType;
import jp.yahooapis.ss.v201909.adgroupfeed.AdGroupFeedSelector;
import jp.yahooapis.ss.v201909.campaign.Campaign;
import jp.yahooapis.ss.v201909.campaign.CampaignOperation;
import jp.yahooapis.ss.v201909.campaign.CampaignType;
import jp.yahooapis.ss.v201909.campaign.CampaignValues;
import jp.yahooapis.ss.v201909.campaign.Operator;
import jp.yahooapis.ss.v201909.campaignfeed.CampaignFeedList;
import jp.yahooapis.ss.v201909.campaignfeed.CampaignFeedOperation;
import jp.yahooapis.ss.v201909.campaignfeed.CampaignFeedPlaceholderType;
import jp.yahooapis.ss.v201909.campaignfeed.CampaignFeedSelector;
import jp.yahooapis.ss.v201909.feeditem.FeedItem;
import jp.yahooapis.ss.v201909.feeditem.FeedItemOperation;
import jp.yahooapis.ss.v201909.feeditem.FeedItemPlaceholderType;
import jp.yahooapis.ss.v201909.feeditem.FeedItemSelector;
import jp.yahooapis.ss.v201909.feeditem.FeedItemValues;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * example StructuredSnippet operation and Utility method collection.
 */
public class StructuredSnippetSample {

  /**
   * example StructuredSnippet operation.
   */
  public static void main(String[] args) throws Exception {

    // =================================================================
    // Setup
    // =================================================================
    ValuesHolder valuesHolder = new ValuesHolder();
    ValuesRepositoryFacade valuesRepositoryFacade = new ValuesRepositoryFacade(valuesHolder);
    long accountId = SoapUtils.getAccountId();
    long campaignId;
    long adGroupId;
    long feedItemId;

    try {
      // =================================================================
      // CampaignService
      // =================================================================
      // ADD
      CampaignOperation addRequestCampaign = CampaignServiceSample.buildExampleMutateRequest( //
          Operator.ADD, accountId, Collections.singletonList(CampaignServiceSample.createExampleStandardCampaign("SampleStandardCampaign_", CampaignServiceSample.createManualBiddingCampaignBiddingStrategy()))) //
          ;

      List<CampaignValues> addResponseCampaign = CampaignServiceSample.mutate(addRequestCampaign);

      valuesRepositoryFacade.getValuesHolder().setCampaignValuesList(addResponseCampaign);
      campaignId = valuesRepositoryFacade.getCampaignValuesRepository().findCampaignId(CampaignType.STANDARD);

      // GET
      CampaignServiceSample.checkStatus(valuesRepositoryFacade.getCampaignValuesRepository().getCampaignIds());

      // SET
      CampaignOperation setRequestCampaign =
          CampaignServiceSample.buildExampleMutateRequest(Operator.SET, accountId, CampaignServiceSample.createExampleSetRequest(valuesRepositoryFacade.getCampaignValuesRepository().getCampaigns()));
      CampaignServiceSample.mutate(setRequestCampaign);

      // =================================================================
      // AdGroupService
      // =================================================================
      // ADD
      AdGroupOperation addRequestAdGroup = AdGroupServiceSample.buildExampleMutateRequest( //
          jp.yahooapis.ss.v201909.adgroup.Operator.ADD, accountId, Collections.singletonList(AdGroupServiceSample.createExampleStandardAdGroup(campaignId)) //
      );
      List<AdGroupValues> addResponseAdGroup = AdGroupServiceSample.mutate(addRequestAdGroup);

      valuesRepositoryFacade.getValuesHolder().setAdGroupValuesList(addResponseAdGroup);
      adGroupId = valuesRepositoryFacade.getAdGroupValuesRepository().findAdGroupId(campaignId);

      // GET
      AdGroupServiceSample.checkStatus(valuesRepositoryFacade.getAdGroupValuesRepository().getAdGroups());

      // SET
      AdGroupOperation setRequestAdGroup = AdGroupServiceSample.buildExampleMutateRequest(jp.yahooapis.ss.v201909.adgroup.Operator.SET, accountId,
          AdGroupServiceSample.createExampleSetRequest(valuesRepositoryFacade.getAdGroupValuesRepository().getAdGroups()));
      AdGroupServiceSample.mutate(setRequestAdGroup);

      // =================================================================
      // FeedItemService
      // =================================================================
      // ADD
      FeedItemOperation addRequestFeedItem = FeedItemServiceSample.buildExampleMutateRequest( //
          jp.yahooapis.ss.v201909.feeditem.Operator.ADD, accountId, FeedItemPlaceholderType.STRUCTURED_SNIPPET, Collections.singletonList(FeedItemServiceSample.createExampleStructuredSnippet()) //
      );
      List<FeedItemValues> addResponseFeedItem = FeedItemServiceSample.mutate(addRequestFeedItem);

      valuesRepositoryFacade.getValuesHolder().setFeedItemValuesList(addResponseFeedItem);
      feedItemId = valuesRepositoryFacade.getFeedItemValuesRepository().findFeedItemId(FeedItemPlaceholderType.STRUCTURED_SNIPPET);

      // GET
      FeedItemSelector getRequestFeedItem = FeedItemServiceSample.buildExampleGetRequest( //
          accountId, //
          valuesRepositoryFacade.getFeedItemValuesRepository().getFeedItemIds(), //
          Collections.emptyList() //
      );
      FeedItemServiceSample.get(getRequestFeedItem);

      // SET
      FeedItemOperation setRequestFeedItem = FeedItemServiceSample.buildExampleMutateRequest(jp.yahooapis.ss.v201909.feeditem.Operator.SET, accountId, FeedItemPlaceholderType.STRUCTURED_SNIPPET,
          FeedItemServiceSample.createExampleSetRequest(valuesRepositoryFacade.getFeedItemValuesRepository().getFeedItems()));
      FeedItemServiceSample.mutate(setRequestFeedItem);

      // =================================================================
      // CampaignFeedService
      // =================================================================
      // SET
      CampaignFeedOperation setRequestCampaignFeed = CampaignFeedServiceSample.buildExampleMutateRequest( //
          jp.yahooapis.ss.v201909.campaignfeed.Operator.SET, accountId, Collections.singletonList(CampaignFeedServiceSample.createExampleSetRequest(accountId, campaignId, feedItemId, CampaignFeedPlaceholderType.STRUCTURED_SNIPPET)) //
      );
      CampaignFeedServiceSample.mutate(setRequestCampaignFeed);

      // GET
      CampaignFeedSelector getRequestCampaignFeed = CampaignFeedServiceSample.buildExampleGetRequest(accountId, Collections.singletonList(campaignId), Collections.singletonList(feedItemId));
      CampaignFeedServiceSample.get(getRequestCampaignFeed);

      // =================================================================
      // AdGroupFeedService
      // =================================================================
      // SET
      AdGroupFeedOperation setRequestAdGroupFeed = AdGroupFeedServiceSample.buildExampleMutateRequest( //
          jp.yahooapis.ss.v201909.adgroupfeed.Operator.SET, accountId, Collections.singletonList(AdGroupFeedServiceSample.createExampleSetRequest(accountId, campaignId, adGroupId, feedItemId, AdGroupFeedPlaceholderType.STRUCTURED_SNIPPET)) //
      );
      AdGroupFeedServiceSample.mutate(setRequestAdGroupFeed);

      // GET
      AdGroupFeedSelector getRequestAdGroupFeed = AdGroupFeedServiceSample.buildExampleGetRequest(accountId, campaignId, adGroupId, feedItemId);
      AdGroupFeedServiceSample.get(getRequestAdGroupFeed);

      //=================================================================
      // FeedItemService REMOVE
      //=================================================================
      // REMOVE
      FeedItemOperation removeRequestFeedItem = FeedItemServiceSample.buildExampleMutateRequest(jp.yahooapis.ss.v201909.feeditem.Operator.REMOVE, accountId, FeedItemPlaceholderType.STRUCTURED_SNIPPET,
          valuesRepositoryFacade.getFeedItemValuesRepository().getFeedItems());
      FeedItemServiceSample.mutate(removeRequestFeedItem);

    } catch (Exception ex) {
      ex.printStackTrace();
      throw ex;
    } finally {
      // =================================================================
      // Cleanup
      // =================================================================
      CampaignServiceSample.cleanup(valuesHolder);
    }
  }
}

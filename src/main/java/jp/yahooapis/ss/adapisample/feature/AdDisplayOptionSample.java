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
import jp.yahooapis.ss.v201901.adgroup.AdGroup;
import jp.yahooapis.ss.v201901.adgroup.AdGroupOperation;
import jp.yahooapis.ss.v201901.adgroup.AdGroupValues;
import jp.yahooapis.ss.v201901.adgroupfeed.AdGroupFeedList;
import jp.yahooapis.ss.v201901.adgroupfeed.AdGroupFeedOperation;
import jp.yahooapis.ss.v201901.adgroupfeed.AdGroupFeedPlaceholderType;
import jp.yahooapis.ss.v201901.adgroupfeed.AdGroupFeedSelector;
import jp.yahooapis.ss.v201901.campaign.Campaign;
import jp.yahooapis.ss.v201901.campaign.CampaignOperation;
import jp.yahooapis.ss.v201901.campaign.CampaignValues;
import jp.yahooapis.ss.v201901.campaign.Operator;
import jp.yahooapis.ss.v201901.campaignfeed.CampaignFeedList;
import jp.yahooapis.ss.v201901.campaignfeed.CampaignFeedOperation;
import jp.yahooapis.ss.v201901.campaignfeed.CampaignFeedPlaceholderType;
import jp.yahooapis.ss.v201901.campaignfeed.CampaignFeedSelector;
import jp.yahooapis.ss.v201901.feeditem.FeedItem;
import jp.yahooapis.ss.v201901.feeditem.FeedItemOperation;
import jp.yahooapis.ss.v201901.feeditem.FeedItemPlaceholderType;
import jp.yahooapis.ss.v201901.feeditem.FeedItemSelector;
import jp.yahooapis.ss.v201901.feeditem.FeedItemValues;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * example AdDisplayOption operation and Utility method collection.
 */
public class AdDisplayOptionSample {

  /**
   * example AdDisplayOption operation.
   * @throws Exception
   */
  public static void main(String[] args) throws Exception {

    // =================================================================
    // Setup
    // =================================================================
    ValuesHolder valuesHolder = new ValuesHolder();
    ValuesRepositoryFacade valuesRepositoryFacade = new ValuesRepositoryFacade(valuesHolder);
    long accountId = SoapUtils.getAccountId();
    List<Long> campaignIds;
    List<Long> adGroupIds;
    long feedItemIdQuicklink;
    long feedItemIdCallextension;
    long feedItemIdCallout;

    try {
      // =================================================================
      // CampaignService
      // =================================================================
      // ADD
      CampaignOperation addRequestCampaign = CampaignServiceSample.buildExampleMutateRequest(Operator.ADD, accountId, new ArrayList<Campaign>() {{
        add(CampaignServiceSample.createExampleStandardCampaign("SampleStandardCampaign_1_", CampaignServiceSample.createManualBiddingCampaignBiddingStrategy()));
        add(CampaignServiceSample.createExampleStandardCampaign("SampleStandardCampaign_2_", CampaignServiceSample.createManualBiddingCampaignBiddingStrategy()));
        add(CampaignServiceSample.createExampleStandardCampaign("SampleStandardCampaign_3_", CampaignServiceSample.createManualBiddingCampaignBiddingStrategy()));
      }});

      List<CampaignValues> addResponseCampaign = CampaignServiceSample.mutate(addRequestCampaign);
      valuesRepositoryFacade.getValuesHolder().setCampaignValuesList(addResponseCampaign);
      campaignIds = valuesRepositoryFacade.getCampaignValuesRepository().getCampaignIds();

      // GET
      CampaignServiceSample.checkStatus(campaignIds);

      // SET
      CampaignOperation setRequestCampaign = CampaignServiceSample.buildExampleMutateRequest(Operator.SET, accountId,
          CampaignServiceSample.createExampleSetRequest(valuesRepositoryFacade.getCampaignValuesRepository().getCampaigns())
      );
      CampaignServiceSample.mutate(setRequestCampaign);

      // =================================================================
      // AdGroupService
      // =================================================================
      // ADD
      AdGroupOperation addRequestAdGroup = AdGroupServiceSample.buildExampleMutateRequest(
          jp.yahooapis.ss.v201901.adgroup.Operator.ADD, accountId, new ArrayList<AdGroup>() {{
            add(AdGroupServiceSample.createExampleStandardAdGroup(campaignIds.get(0)));
            add(AdGroupServiceSample.createExampleStandardAdGroup(campaignIds.get(1)));
            add(AdGroupServiceSample.createExampleStandardAdGroup(campaignIds.get(2)));
          }}
      );
      List<AdGroupValues> addResponseAdGroup = AdGroupServiceSample.mutate(addRequestAdGroup);

      valuesRepositoryFacade.getValuesHolder().setAdGroupValuesList(addResponseAdGroup);
      adGroupIds = valuesRepositoryFacade.getAdGroupValuesRepository().getAdGroupIds();

      // GET
      AdGroupServiceSample.checkStatus(valuesRepositoryFacade.getAdGroupValuesRepository().getAdGroups());

      // SET
      AdGroupOperation setRequestAdGroup = AdGroupServiceSample.buildExampleMutateRequest(
          jp.yahooapis.ss.v201901.adgroup.Operator.SET, accountId,
          AdGroupServiceSample.createExampleSetRequest(valuesRepositoryFacade.getAdGroupValuesRepository().getAdGroups())
      );
      AdGroupServiceSample.mutate(setRequestAdGroup);

      //=================================================================
      // FeedItemService ADD
      //=================================================================
      // QUICKLINK
      FeedItemOperation addRequestQuicklink = FeedItemServiceSample.buildExampleMutateRequest(
          jp.yahooapis.ss.v201901.feeditem.Operator.ADD, accountId, FeedItemPlaceholderType.QUICKLINK, new ArrayList<FeedItem>() {{
            add(FeedItemServiceSample.createExampleQuicklink());
          }}
      );
      List<FeedItemValues> addResponseQuicklink = FeedItemServiceSample.mutate(addRequestQuicklink);

      // CALLEXTENSION
      FeedItemOperation addRequestCallextension = FeedItemServiceSample.buildExampleMutateRequest(
          jp.yahooapis.ss.v201901.feeditem.Operator.ADD, accountId, FeedItemPlaceholderType.CALLEXTENSION, new ArrayList<FeedItem>() {{
            add(FeedItemServiceSample.createExampleCallextension());
          }}
      );
      List<FeedItemValues> addResponseCallextension = FeedItemServiceSample.mutate(addRequestCallextension);

      // CALLOUT
      FeedItemOperation addRequestCallout = FeedItemServiceSample.buildExampleMutateRequest(
          jp.yahooapis.ss.v201901.feeditem.Operator.ADD, accountId, FeedItemPlaceholderType.CALLOUT, new ArrayList<FeedItem>() {{
            add(FeedItemServiceSample.createExampleCallout());
          }}
      );
      List<FeedItemValues> addResponseCallout = FeedItemServiceSample.mutate(addRequestCallout);

      valuesRepositoryFacade.getValuesHolder().setFeedItemValuesList(addResponseQuicklink);
      valuesRepositoryFacade.getValuesHolder().setFeedItemValuesList(addResponseCallextension);
      valuesRepositoryFacade.getValuesHolder().setFeedItemValuesList(addResponseCallout);

      feedItemIdQuicklink = valuesRepositoryFacade.getFeedItemValuesRepository().findFeedItemId(FeedItemPlaceholderType.QUICKLINK);
      feedItemIdCallextension = valuesRepositoryFacade.getFeedItemValuesRepository().findFeedItemId(FeedItemPlaceholderType.CALLEXTENSION);
      feedItemIdCallout = valuesRepositoryFacade.getFeedItemValuesRepository().findFeedItemId(FeedItemPlaceholderType.CALLOUT);

      //=================================================================
      // FeedItemService GET
      //=================================================================
      FeedItemSelector getRequestFeedItem = FeedItemServiceSample.buildExampleGetRequest(accountId, valuesRepositoryFacade.getFeedItemValuesRepository().getFeedItemIds());
      FeedItemServiceSample.get(getRequestFeedItem);

      //=================================================================
      // FeedItemService SET
      //=================================================================
      // QUICKLINK
      FeedItemOperation setRequestQuicklink = FeedItemServiceSample.buildExampleMutateRequest(
          jp.yahooapis.ss.v201901.feeditem.Operator.SET, accountId, FeedItemPlaceholderType.QUICKLINK, FeedItemServiceSample.createExampleSetRequest(
              new ArrayList<FeedItem>() {{
                add(valuesRepositoryFacade.getFeedItemValuesRepository().findFeedItem(FeedItemPlaceholderType.QUICKLINK));
      }}));
      FeedItemServiceSample.mutate(setRequestQuicklink);

      // CALLEXTENSION
      FeedItemOperation setRequestCallextension = FeedItemServiceSample.buildExampleMutateRequest(
          jp.yahooapis.ss.v201901.feeditem.Operator.SET, accountId, FeedItemPlaceholderType.CALLEXTENSION, FeedItemServiceSample.createExampleSetRequest(
              new ArrayList<FeedItem>() {{
                add(valuesRepositoryFacade.getFeedItemValuesRepository().findFeedItem(FeedItemPlaceholderType.CALLEXTENSION));
      }}));
      FeedItemServiceSample.mutate(setRequestCallextension);

      // CALLOUT
      FeedItemOperation setRequestCallout = FeedItemServiceSample.buildExampleMutateRequest(
          jp.yahooapis.ss.v201901.feeditem.Operator.SET, accountId, FeedItemPlaceholderType.CALLOUT, FeedItemServiceSample.createExampleSetRequest(
              new ArrayList<FeedItem>() {{
                add(valuesRepositoryFacade.getFeedItemValuesRepository().findFeedItem(FeedItemPlaceholderType.CALLOUT));
      }}));
      FeedItemServiceSample.mutate(setRequestCallout);

      // =================================================================
      // CampaignFeedService
      // =================================================================
      // SET
      CampaignFeedOperation setRequestCampaignFeedQuicklink = CampaignFeedServiceSample.buildExampleMutateRequest(
          jp.yahooapis.ss.v201901.campaignfeed.Operator.SET, accountId, new ArrayList<CampaignFeedList>() {{
            add(CampaignFeedServiceSample.createExampleSetRequest(accountId, campaignIds.get(0), feedItemIdQuicklink, CampaignFeedPlaceholderType.QUICKLINK));
            add(CampaignFeedServiceSample.createExampleSetRequest(accountId, campaignIds.get(1), feedItemIdCallextension, CampaignFeedPlaceholderType.CALLEXTENSION));
            add(CampaignFeedServiceSample.createExampleSetRequest(accountId, campaignIds.get(2), feedItemIdCallout, CampaignFeedPlaceholderType.CALLOUT));
          }}
      );
      CampaignFeedServiceSample.mutate(setRequestCampaignFeedQuicklink);

      // GET
      CampaignFeedSelector getRequestCampaignFeed = CampaignFeedServiceSample.buildExampleGetRequest(
          accountId, Collections.singletonList(campaignIds.get(0)), valuesRepositoryFacade.getFeedItemValuesRepository().getFeedItemIds()
      );
      CampaignFeedServiceSample.get(getRequestCampaignFeed);

      //=================================================================
      // AdGroupFeedService
      //=================================================================
      // SET
      AdGroupFeedOperation setRequestAdGroupFeedQuicklink = AdGroupFeedServiceSample.buildExampleMutateRequest(
          jp.yahooapis.ss.v201901.adgroupfeed.Operator.SET, accountId, new ArrayList<AdGroupFeedList>() {{
            add(AdGroupFeedServiceSample.createExampleSetRequest(accountId, campaignIds.get(0), adGroupIds.get(0), feedItemIdQuicklink, AdGroupFeedPlaceholderType.QUICKLINK));
            add(AdGroupFeedServiceSample.createExampleSetRequest(accountId, campaignIds.get(1), adGroupIds.get(1), feedItemIdCallextension, AdGroupFeedPlaceholderType.CALLEXTENSION));
            add(AdGroupFeedServiceSample.createExampleSetRequest(accountId, campaignIds.get(2), adGroupIds.get(2), feedItemIdCallout, AdGroupFeedPlaceholderType.CALLOUT));
          }}
      );
      AdGroupFeedServiceSample.mutate(setRequestAdGroupFeedQuicklink);

      // GET
      AdGroupFeedSelector getRequest = AdGroupFeedServiceSample.buildExampleGetRequest(
          accountId, campaignIds.get(0), adGroupIds.get(0), valuesRepositoryFacade.getFeedItemValuesRepository().getFeedItemIds().get(0)
      );
      AdGroupFeedServiceSample.get(getRequest);

      //=================================================================
      // FeedItemService REMOVE
      //=================================================================
      // QUICKLINK
      FeedItemOperation removeRequestQuicklink = FeedItemServiceSample.buildExampleMutateRequest(
          jp.yahooapis.ss.v201901.feeditem.Operator.REMOVE, accountId, FeedItemPlaceholderType.QUICKLINK, FeedItemServiceSample.createExampleSetRequest(
              new ArrayList<FeedItem>() {{
                add(valuesRepositoryFacade.getFeedItemValuesRepository().findFeedItem(FeedItemPlaceholderType.QUICKLINK));
      }}));
      FeedItemServiceSample.mutate(removeRequestQuicklink);

      // CALLEXTENSION
      FeedItemOperation removeRequestCallextension = FeedItemServiceSample.buildExampleMutateRequest(
          jp.yahooapis.ss.v201901.feeditem.Operator.REMOVE, accountId, FeedItemPlaceholderType.CALLEXTENSION, FeedItemServiceSample.createExampleSetRequest(
              new ArrayList<FeedItem>() {{
                add(valuesRepositoryFacade.getFeedItemValuesRepository().findFeedItem(FeedItemPlaceholderType.CALLEXTENSION));
      }}));
      FeedItemServiceSample.mutate(removeRequestCallextension);

      // CALLOUT
      FeedItemOperation removeRequestCallout = FeedItemServiceSample.buildExampleMutateRequest(
          jp.yahooapis.ss.v201901.feeditem.Operator.REMOVE, accountId, FeedItemPlaceholderType.CALLOUT, FeedItemServiceSample.createExampleSetRequest(
              new ArrayList<FeedItem>() {{
                add(valuesRepositoryFacade.getFeedItemValuesRepository().findFeedItem(FeedItemPlaceholderType.CALLOUT));
      }}));
      FeedItemServiceSample.mutate(removeRequestCallout);

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

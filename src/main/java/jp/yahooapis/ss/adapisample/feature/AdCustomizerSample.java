/**
 * Copyright (C) 2019 Yahoo Japan Corporation. All Rights Reserved.
 */
package jp.yahooapis.ss.adapisample.feature;

import jp.yahooapis.ss.adapisample.basic.adgroup.AdGroupServiceSample;
import jp.yahooapis.ss.adapisample.basic.adgroupad.AdGroupAdServiceSample;
import jp.yahooapis.ss.adapisample.basic.adgroupcriterion.AdGroupCriterionServiceSample;
import jp.yahooapis.ss.adapisample.basic.campaign.CampaignServiceSample;
import jp.yahooapis.ss.adapisample.basic.feedfolder.FeedFolderServiceSample;
import jp.yahooapis.ss.adapisample.basic.feeditem.FeedItemServiceSample;
import jp.yahooapis.ss.adapisample.repository.ValuesRepositoryFacade;
import jp.yahooapis.ss.adapisample.util.SoapUtils;
import jp.yahooapis.ss.adapisample.util.ValuesHolder;
import jp.yahooapis.ss.v201901.adgroup.AdGroupOperation;
import jp.yahooapis.ss.v201901.adgroup.AdGroupValues;
import jp.yahooapis.ss.v201901.adgroupad.AdGroupAdOperation;
import jp.yahooapis.ss.v201901.adgroupad.AdGroupAdSelector;
import jp.yahooapis.ss.v201901.adgroupad.AdGroupAdValues;
import jp.yahooapis.ss.v201901.adgroupcriterion.AdGroupCriterionOperation;
import jp.yahooapis.ss.v201901.adgroupcriterion.AdGroupCriterionSelector;
import jp.yahooapis.ss.v201901.adgroupcriterion.AdGroupCriterionUse;
import jp.yahooapis.ss.v201901.adgroupcriterion.AdGroupCriterionValues;
import jp.yahooapis.ss.v201901.campaign.CampaignOperation;
import jp.yahooapis.ss.v201901.campaign.CampaignType;
import jp.yahooapis.ss.v201901.campaign.CampaignValues;
import jp.yahooapis.ss.v201901.feedfolder.FeedFolderOperation;
import jp.yahooapis.ss.v201901.feedfolder.FeedFolderPlaceholderField;
import jp.yahooapis.ss.v201901.feedfolder.FeedFolderPlaceholderType;
import jp.yahooapis.ss.v201901.feedfolder.FeedFolderSelector;
import jp.yahooapis.ss.v201901.feedfolder.FeedFolderValues;
import jp.yahooapis.ss.v201901.feedfolder.Operator;
import jp.yahooapis.ss.v201901.feeditem.FeedItemOperation;
import jp.yahooapis.ss.v201901.feeditem.FeedItemPlaceholderType;
import jp.yahooapis.ss.v201901.feeditem.FeedItemSelector;
import jp.yahooapis.ss.v201901.feeditem.FeedItemValues;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * example AdCustomizer operation and Utility method collection.
 */
public class AdCustomizerSample {

  /**
   * example AdCustomizer operation.
   *
   * @param args command line arguments
   */
  public static void main(String[] args) throws Exception{
    // =================================================================
    // Setting
    // =================================================================
    ValuesHolder valuesHolder = new ValuesHolder();
    ValuesRepositoryFacade valuesRepositoryFacade = new ValuesRepositoryFacade(valuesHolder);
    long accountId = SoapUtils.getAccountId();

    Map<String, Long> feedAttributeIds = new HashMap<>();
    feedAttributeIds.put("AD_CUSTOMIZER_INTEGER", 0L);
    feedAttributeIds.put("AD_CUSTOMIZER_PRICE", 0L);
    feedAttributeIds.put("AD_CUSTOMIZER_DATE", 0L);
    feedAttributeIds.put("AD_CUSTOMIZER_STRING", 0L);

    Map<String, String> feedAttributeNames = new HashMap<>();
    feedAttributeNames.put("AD_CUSTOMIZER_INTEGER", null);
    feedAttributeNames.put("AD_CUSTOMIZER_PRICE", null);
    feedAttributeNames.put("AD_CUSTOMIZER_DATE", null);
    feedAttributeNames.put("AD_CUSTOMIZER_STRING", null);

    try {
      // =================================================================
      // FeedFolderService
      // =================================================================
      // ADD
      FeedFolderOperation addRequestFeedFolder = FeedFolderServiceSample.buildExampleMutateRequest( //
          Operator.ADD, //
          accountId, //
          Arrays.asList(FeedFolderServiceSample.createExampleAdCustomizerFeedFolder(accountId)) //
      );
      List<FeedFolderValues> addResponseFeedFolder = FeedFolderServiceSample.mutate(addRequestFeedFolder);
      valuesHolder.setFeedFolderValuesList(addResponseFeedFolder);
      Long feedFolderId = valuesRepositoryFacade.getFeedFolderValuesRepository().findFeedFolderId(FeedFolderPlaceholderType.AD_CUSTOMIZER);
      String feedFolderName = valuesRepositoryFacade.getFeedFolderValuesRepository().findFeedFolderName(feedFolderId);

      feedAttributeIds.put("AD_CUSTOMIZER_INTEGER", valuesRepositoryFacade.getFeedFolderValuesRepository().findFeedAttributeId(feedFolderId, FeedFolderPlaceholderField.AD_CUSTOMIZER_INTEGER));
      feedAttributeIds.put("AD_CUSTOMIZER_PRICE", valuesRepositoryFacade.getFeedFolderValuesRepository().findFeedAttributeId(feedFolderId, FeedFolderPlaceholderField.AD_CUSTOMIZER_PRICE));
      feedAttributeIds.put("AD_CUSTOMIZER_DATE", valuesRepositoryFacade.getFeedFolderValuesRepository().findFeedAttributeId(feedFolderId, FeedFolderPlaceholderField.AD_CUSTOMIZER_DATE));
      feedAttributeIds.put("AD_CUSTOMIZER_STRING", valuesRepositoryFacade.getFeedFolderValuesRepository().findFeedAttributeId(feedFolderId, FeedFolderPlaceholderField.AD_CUSTOMIZER_STRING));

      feedAttributeNames.put("AD_CUSTOMIZER_INTEGER", valuesRepositoryFacade.getFeedFolderValuesRepository().findFeedAttributeName(feedFolderId, FeedFolderPlaceholderField.AD_CUSTOMIZER_INTEGER));
      feedAttributeNames.put("AD_CUSTOMIZER_PRICE", valuesRepositoryFacade.getFeedFolderValuesRepository().findFeedAttributeName(feedFolderId, FeedFolderPlaceholderField.AD_CUSTOMIZER_PRICE));
      feedAttributeNames.put("AD_CUSTOMIZER_DATE", valuesRepositoryFacade.getFeedFolderValuesRepository().findFeedAttributeName(feedFolderId, FeedFolderPlaceholderField.AD_CUSTOMIZER_DATE));
      feedAttributeNames.put("AD_CUSTOMIZER_STRING", valuesRepositoryFacade.getFeedFolderValuesRepository().findFeedAttributeName(feedFolderId, FeedFolderPlaceholderField.AD_CUSTOMIZER_STRING));

      // SET
      FeedFolderOperation setRequestFeedFolder = FeedFolderServiceSample.buildExampleMutateRequest( //
          Operator.SET, //
          accountId, //
          FeedFolderServiceSample.createExampleSetRequest(valuesRepositoryFacade.getFeedFolderValuesRepository().getFeedFolders()) //
      );
      FeedFolderServiceSample.mutate(setRequestFeedFolder);

      // GET
      FeedFolderSelector getRequestFeedFolder = FeedFolderServiceSample.buildExampleGetRequest(accountId, Arrays.asList(feedFolderId));
      FeedFolderServiceSample.get(getRequestFeedFolder);

      // =================================================================
      // CampaignService
      // =================================================================
      // ADD
      CampaignOperation addRequestCampaign = CampaignServiceSample.buildExampleMutateRequest( //
          jp.yahooapis.ss.v201901.campaign.Operator.ADD, //
          accountId, //
          Arrays.asList(CampaignServiceSample.createExampleStandardCampaign( //
              "SampleStandardCampaign_", //
              CampaignServiceSample.createManualBiddingCampaignBiddingStrategy()) //
          ));
      List<CampaignValues> addResponseCampaign = CampaignServiceSample.mutate(addRequestCampaign);

      valuesHolder.setCampaignValuesList(addResponseCampaign);
      Long campaignId = valuesRepositoryFacade.getCampaignValuesRepository().findCampaignId(CampaignType.STANDARD);

      // GET
      CampaignServiceSample.checkStatus(Arrays.asList(campaignId));

      // SET
      CampaignOperation setRequestCampaign = CampaignServiceSample.buildExampleMutateRequest( //
          jp.yahooapis.ss.v201901.campaign.Operator.SET, //
          accountId, //
          CampaignServiceSample.createExampleSetRequest(valuesRepositoryFacade.getCampaignValuesRepository().getCampaigns()) //
      );
      CampaignServiceSample.mutate(setRequestCampaign);

      // =================================================================
      // AdGroupService
      // =================================================================
      // ADD
      AdGroupOperation addRequestAdGroup = AdGroupServiceSample.buildExampleMutateRequest( //
          jp.yahooapis.ss.v201901.adgroup.Operator.ADD, //
          accountId, //
          Arrays.asList(AdGroupServiceSample.createExampleStandardAdGroup(campaignId)) //
      );
      List<AdGroupValues> addResponseAdGroup = AdGroupServiceSample.mutate(addRequestAdGroup);
      valuesHolder.setAdGroupValuesList(addResponseAdGroup);
      Long adGroupId = valuesRepositoryFacade.getAdGroupValuesRepository().findAdGroupId(campaignId);

      // GET
      AdGroupServiceSample.checkStatus(valuesRepositoryFacade.getAdGroupValuesRepository().getAdGroups());

      // SET
      AdGroupOperation setRequestAdGroup = AdGroupServiceSample.buildExampleMutateRequest( //
          jp.yahooapis.ss.v201901.adgroup.Operator.SET, //
          accountId, //
          AdGroupServiceSample.createExampleSetRequest(valuesRepositoryFacade.getAdGroupValuesRepository().getAdGroups()) //
      );
      AdGroupServiceSample.mutate(setRequestAdGroup);

      // =================================================================
      // AdGroupCriterionService
      // =================================================================
      // ADD
      AdGroupCriterionOperation addRequestAdGroupCriterion = AdGroupCriterionServiceSample.buildExampleMutateRequest( //
          jp.yahooapis.ss.v201901.adgroupcriterion.Operator.ADD, //
          accountId, //
          Arrays.asList(AdGroupCriterionServiceSample.createExampleBiddableAdGroupCriterion(campaignId, adGroupId)) //
      );
      List<AdGroupCriterionValues> addResponseAdGroupCriterion = AdGroupCriterionServiceSample.mutate(addRequestAdGroupCriterion);
      valuesHolder.setAdGroupCriterionValuesList(addResponseAdGroupCriterion);

      // GET
      AdGroupCriterionSelector getRequest = AdGroupCriterionServiceSample.buildExampleGetRequest( //
          accountId, //
          AdGroupCriterionUse.BIDDABLE, //
          valuesRepositoryFacade.getAdGroupCriterionValuesRepository().getAdGroupCriterions() //
      );
      AdGroupCriterionServiceSample.get(getRequest);

      // SET
      AdGroupCriterionOperation setRequestAdGroupCriterion = AdGroupCriterionServiceSample.buildExampleMutateRequest( //
          jp.yahooapis.ss.v201901.adgroupcriterion.Operator.SET, //
          accountId, //
          AdGroupCriterionServiceSample.createExampleSetRequest(valuesRepositoryFacade.getAdGroupCriterionValuesRepository().getAdGroupCriterions()) //
      );
      AdGroupCriterionServiceSample.mutate(setRequestAdGroupCriterion);

      //=================================================================
      // FeedItemService
      //=================================================================
      // ADD
      FeedItemOperation addRequestFeedItem = FeedItemServiceSample.buildExampleMutateRequest( //
          jp.yahooapis.ss.v201901.feeditem.Operator.ADD, //
          accountId, //
          FeedItemPlaceholderType.AD_CUSTOMIZER, //
          Arrays.asList(FeedItemServiceSample.createExampleAdCustomizer(campaignId, adGroupId, feedFolderId, feedAttributeIds)) //
      );
      List<FeedItemValues> addResponseFeedItem = FeedItemServiceSample.mutate(addRequestFeedItem);
      valuesHolder.setFeedItemValuesList(addResponseFeedItem);

      // GET
      FeedItemSelector getRequestFeedItem = FeedItemServiceSample.buildExampleGetRequest( //
          accountId,
          valuesRepositoryFacade.getFeedItemValuesRepository().getFeedItemIds()
      );
      FeedItemServiceSample.get(getRequestFeedItem);

      // SET
      FeedItemOperation setRequestFeedItem = FeedItemServiceSample.buildExampleMutateRequest( //
          jp.yahooapis.ss.v201901.feeditem.Operator.SET, //
          accountId, //
          FeedItemPlaceholderType.AD_CUSTOMIZER, //
          FeedItemServiceSample.createExampleSetRequest(valuesRepositoryFacade.getFeedItemValuesRepository().getFeedItems()) //
      );
      FeedItemServiceSample.mutate(setRequestFeedItem);

      // =================================================================
      // AdGroupAdService
      // =================================================================
      // ADD
      AdGroupAdOperation addRequestAdGroupAd = AdGroupAdServiceSample.buildExampleMutateRequest( //
          jp.yahooapis.ss.v201901.adgroupad.Operator.ADD, //
          accountId, //
          AdGroupAdServiceSample.createExampleAdCustomizerAds(campaignId, adGroupId, feedFolderName, feedAttributeNames) //
      );
      List<AdGroupAdValues> addResponseAdGroupAd = AdGroupAdServiceSample.mutate(addRequestAdGroupAd);
      valuesHolder.setAdGroupAdValuesList(addResponseAdGroupAd);

      // SET
      AdGroupAdOperation setRequestAdGroupAd = AdGroupAdServiceSample.buildExampleMutateRequest( //
          jp.yahooapis.ss.v201901.adgroupad.Operator.SET, //
          accountId, //
          AdGroupAdServiceSample.createExampleSetRequest(valuesRepositoryFacade.getAdGroupAdValuesRepository().getAdGroupAds())  //
      );
      AdGroupAdServiceSample.mutate(setRequestAdGroupAd);

      // GET
      AdGroupAdSelector getRequestAdGroupAd = AdGroupAdServiceSample.buildExampleGetRequest(accountId, valuesRepositoryFacade.getAdGroupAdValuesRepository().getAdGroupAds());
      AdGroupAdServiceSample.get(getRequestAdGroupAd);

      //=================================================================
      // FeedItemService REMOVE
      //=================================================================
      // REMOVE
      FeedItemOperation removeRequestFeedItem = FeedItemServiceSample.buildExampleMutateRequest( //
          jp.yahooapis.ss.v201901.feeditem.Operator.REMOVE, //
          accountId, //
          FeedItemPlaceholderType.AD_CUSTOMIZER, //
          valuesRepositoryFacade.getFeedItemValuesRepository().getFeedItems() //
      );
      FeedItemServiceSample.mutate(removeRequestFeedItem);

    } catch (Exception ex) {
      ex.printStackTrace();
    } finally {
      // =================================================================
      // Cleanup
      // =================================================================
      CampaignServiceSample.cleanup(valuesHolder);

    }
  }

}

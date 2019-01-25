/**
 * Copyright (C) 2019 Yahoo Japan Corporation. All Rights Reserved.
 */
package jp.yahooapis.ss.adapisample.basic.adgroup;

import jp.yahooapis.ss.adapisample.basic.campaign.CampaignServiceSample;
import jp.yahooapis.ss.adapisample.repository.ValuesRepositoryFacade;
import jp.yahooapis.ss.adapisample.util.SoapUtils;
import jp.yahooapis.ss.adapisample.util.ValuesHolder;
import jp.yahooapis.ss.v201901.Error;
import jp.yahooapis.ss.v201901.Paging;
import jp.yahooapis.ss.v201901.adgroup.AdGroup;
import jp.yahooapis.ss.v201901.adgroup.AdGroupAdRotationMode;
import jp.yahooapis.ss.v201901.adgroup.AdGroupOperation;
import jp.yahooapis.ss.v201901.adgroup.AdGroupPage;
import jp.yahooapis.ss.v201901.adgroup.AdGroupReturnValue;
import jp.yahooapis.ss.v201901.adgroup.AdGroupSelector;
import jp.yahooapis.ss.v201901.adgroup.AdGroupService;
import jp.yahooapis.ss.v201901.adgroup.AdGroupServiceInterface;
import jp.yahooapis.ss.v201901.adgroup.AdGroupValues;
import jp.yahooapis.ss.v201901.adgroup.AdRotationMode;
import jp.yahooapis.ss.v201901.adgroup.Bid;
import jp.yahooapis.ss.v201901.adgroup.CriterionType;
import jp.yahooapis.ss.v201901.adgroup.CustomParameter;
import jp.yahooapis.ss.v201901.adgroup.CustomParameters;
import jp.yahooapis.ss.v201901.adgroup.Operator;
import jp.yahooapis.ss.v201901.adgroup.TargetAll;
import jp.yahooapis.ss.v201901.adgroup.TargetingSetting;
import jp.yahooapis.ss.v201901.adgroup.UrlApprovalStatus;
import jp.yahooapis.ss.v201901.adgroup.UserStatus;
import jp.yahooapis.ss.v201901.campaign.CampaignType;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.xml.ws.Holder;


/**
 * example AdGroupService operation and Utility method collection.
 */
public class AdGroupServiceSample {

  /**
   * main method for AdGroupServiceSample
   *
   * @param args command line arguments
   */
  public static void main(String[] args) throws Exception {

    // =================================================================
    // Setting
    // =================================================================
    ValuesHolder valuesHolder = new ValuesHolder();
    long accountId = SoapUtils.getAccountId();

    try {
      // =================================================================
      // check & create upper service object.
      // =================================================================
      valuesHolder = setup();
      ValuesRepositoryFacade valuesRepositoryFacade = new ValuesRepositoryFacade(valuesHolder);
      Long campaignId = valuesRepositoryFacade.getCampaignValuesRepository().findCampaignId(CampaignType.STANDARD);

      // =================================================================
      // AdGroupService ADD
      // =================================================================
      // create request.
      AdGroupOperation addRequest = buildExampleMutateRequest(Operator.ADD, accountId, new ArrayList<AdGroup>() {{
        add(createExampleStandardAdGroup(campaignId));
      }});

      // run
      List<AdGroupValues> addResponse = mutate(addRequest);
      valuesRepositoryFacade.getValuesHolder().setAdGroupValuesList(addResponse);

      // =================================================================
      // AdGroupService GET
      // =================================================================
      // create request.
      AdGroupSelector getRequest = buildExampleGetRequest(accountId, valuesRepositoryFacade.getAdGroupValuesRepository().getAdGroups());

      // run
      get(getRequest);

      // check review status
      checkStatus(valuesRepositoryFacade.getAdGroupValuesRepository().getAdGroups());

      // =================================================================
      // AdGroupService SET
      // =================================================================
      // create request.
      AdGroupOperation setRequest = buildExampleMutateRequest(Operator.SET, accountId, createExampleSetRequest(valuesRepositoryFacade.getAdGroupValuesRepository().getAdGroups()));

      // run
      mutate(setRequest);

      // =================================================================
      // AdGroupService REMOVE
      // =================================================================
      // create request.
      AdGroupOperation removeRequest = buildExampleMutateRequest(Operator.REMOVE, accountId, valuesRepositoryFacade.getAdGroupValuesRepository().getAdGroups());

      // run
      mutate(removeRequest);
      valuesHolder.setAdGroupValuesList(new ArrayList<>());

    } catch (Exception e) {
      e.printStackTrace();
      throw e;
    } finally {
      cleanup(valuesHolder);
    }
  }

  /**
   * example mutate adGroups.
   *
   * @param operation CampaignOperation
   * @return CampaignValues
   */
  public static List<AdGroupValues> mutate(AdGroupOperation operation) throws Exception {
    // Call API
    System.out.println("############################################");
    System.out.println("AdGroupService::mutate(" + operation.getOperator() + ")");
    System.out.println("############################################");

    Holder<AdGroupReturnValue> adGroupReturnValueHolder = new Holder<AdGroupReturnValue>();
    Holder<List<Error>> errorHolder = new Holder<List<Error>>();
    AdGroupServiceInterface adGroupService = SoapUtils.createServiceInterface(AdGroupServiceInterface.class, AdGroupService.class);
    adGroupService.mutate(operation, adGroupReturnValueHolder, errorHolder);

    SoapUtils.checkSoapError(errorHolder, adGroupReturnValueHolder.value.getValues());

    // Response
    return adGroupReturnValueHolder.value.getValues();
  }

  /**
   * Sample Program for AdGroupService GET.
   *
   * @param selector AdGroupSelector
   * @return AdGroupValues
   * @throws Exception
   */
  public static List<AdGroupValues> get(AdGroupSelector selector) throws Exception {

    // Call API
    System.out.println("############################################");
    System.out.println("AdGroupService::get");
    System.out.println("############################################");

    Holder<AdGroupPage> adGroupPageHolder = new Holder<AdGroupPage>();
    Holder<List<Error>> errorHolder = new Holder<List<Error>>();
    AdGroupServiceInterface adGroupService = SoapUtils.createServiceInterface(AdGroupServiceInterface.class, AdGroupService.class);
    adGroupService.get(selector, adGroupPageHolder, errorHolder);

    SoapUtils.checkSoapError(errorHolder, adGroupPageHolder.value.getValues());

    // Response
    return adGroupPageHolder.value.getValues();
  }

  /**
   * example mutate request.
   */
  public static AdGroupOperation buildExampleMutateRequest(Operator operator, long accountId, List<AdGroup> operand) {
    AdGroupOperation operation = new AdGroupOperation();
    operation.setOperator(operator);
    operation.setAccountId(accountId);
    operation.getOperand().addAll(operand);

    return operation;
  }

  /**
   * example Standard AdGroup request.
   *
   * @param campaignId long
   * @return AdGroupOperation
   */
  public static AdGroup createExampleStandardAdGroup(long campaignId) {

    // bid
    Bid bid = new Bid();
    bid.setMaxCpc((long) 100);

    // settings
    TargetingSetting targetingSetting = new TargetingSetting();
    targetingSetting.setCriterionType(CriterionType.TARGET_LIST);
    targetingSetting.setTargetAll(TargetAll.ACTIVE);

    // customParameters
    CustomParameter customParameter = new CustomParameter();
    customParameter.setKey("id1");
    customParameter.setValue("1234");
    CustomParameters customParameters = new CustomParameters();
    customParameters.getParameters().add(customParameter);

    // ad rotation mode
    AdGroupAdRotationMode adGroupAdRotationMode = new AdGroupAdRotationMode();
    adGroupAdRotationMode.setAdRotationMode(AdRotationMode.ROTATE_FOREVER);

    AdGroup adGroup = new AdGroup();
    adGroup.setCampaignId(campaignId);
    adGroup.setAdGroupName("SampleStandardAdGroup_" + campaignId + "_CreateOn_" + SoapUtils.getCurrentTimestamp());
    adGroup.setUserStatus(UserStatus.ACTIVE);
    adGroup.setTrackingUrl("http://www.yahoo.co.jp/?url={lpurl}&amp;a={creative}&amp;pid={_id1}");
    adGroup.setBid(bid);
    adGroup.setSettings(targetingSetting);
    adGroup.setCustomParameters(customParameters);
    adGroup.setAdGroupAdRotationMode(adGroupAdRotationMode);

    return adGroup;
  }

  /**
   * example MobileApp IOS AdGroup request.
   *
   * @param campaignId long
   * @return AdGroupOperation
   */
  public static AdGroup createExampleMobileAppIOSAdGroup(long campaignId) {

    // bid
    Bid bid = new Bid();
    bid.setMaxCpc((long) 100);

    // settings
    TargetingSetting targetingSetting = new TargetingSetting();
    targetingSetting.setCriterionType(CriterionType.TARGET_LIST);
    targetingSetting.setTargetAll(TargetAll.ACTIVE);

    // customParameters
    CustomParameter customParameter = new CustomParameter();
    customParameter.setKey("id1");
    customParameter.setValue("1234");
    CustomParameters customParameters = new CustomParameters();
    customParameters.getParameters().add(customParameter);

    // ad rotation mode
    AdGroupAdRotationMode adGroupAdRotationMode = new AdGroupAdRotationMode();
    adGroupAdRotationMode.setAdRotationMode(AdRotationMode.ROTATE_FOREVER);

    AdGroup adGroup = new AdGroup();
    adGroup.setCampaignId(campaignId);
    adGroup.setAdGroupName("SampleMobileAppIOSAdGroup_CreateOn_" + SoapUtils.getCurrentTimestamp());
    adGroup.setUserStatus(UserStatus.ACTIVE);
    adGroup.setTrackingUrl("http://www.yahoo.co.jp/?url={lpurl}&amp;a={creative}&amp;pid={_id1}");
    adGroup.setBid(bid);
    adGroup.setSettings(targetingSetting);
    adGroup.setCustomParameters(customParameters);
    adGroup.setAdGroupAdRotationMode(adGroupAdRotationMode);

    return adGroup;
  }

  /**
   * example MobileApp ANDROID AdGroup request.
   *
   * @param campaignId long
   * @return AdGroupOperation
   */
  public static AdGroup createExampleMobileAppANDROIDAdGroup(long campaignId) {

    // bid
    Bid bid = new Bid();
    bid.setMaxCpc((long) 100);

    // settings
    TargetingSetting targetingSetting = new TargetingSetting();
    targetingSetting.setCriterionType(CriterionType.TARGET_LIST);
    targetingSetting.setTargetAll(TargetAll.ACTIVE);

    // ad rotation mode
    AdGroupAdRotationMode adGroupAdRotationMode = new AdGroupAdRotationMode();
    adGroupAdRotationMode.setAdRotationMode(AdRotationMode.ROTATE_FOREVER);

    AdGroup adGroup = new AdGroup();
    adGroup.setCampaignId(campaignId);
    adGroup.setAdGroupName("SampleMobileAppANDROIDAdGroup_CreateOn_" + SoapUtils.getCurrentTimestamp());
    adGroup.setUserStatus(UserStatus.ACTIVE);
    adGroup.setBid(bid);
    adGroup.setSettings(targetingSetting);
    adGroup.setAdGroupAdRotationMode(adGroupAdRotationMode);

    return adGroup;
  }

  /**
   * example DynamicAdsForSearch AdGroup request.
   *
   * @param campaignId long
   * @return AdGroupOperation
   */
  public static AdGroup createExampleDynamicAdsForSearchAdGroup(long campaignId) {

    // bid
    Bid bid = new Bid();
    bid.setMaxCpc((long) 100);

    // settings
    TargetingSetting targetingSetting = new TargetingSetting();
    targetingSetting.setCriterionType(CriterionType.TARGET_LIST);
    targetingSetting.setTargetAll(TargetAll.ACTIVE);

    // customParameters
    CustomParameter customParameter = new CustomParameter();
    customParameter.setKey("id1");
    customParameter.setValue("1234");
    CustomParameters customParameters = new CustomParameters();
    customParameters.getParameters().add(customParameter);

    // ad rotation mode
    AdGroupAdRotationMode adGroupAdRotationMode = new AdGroupAdRotationMode();
    adGroupAdRotationMode.setAdRotationMode(AdRotationMode.ROTATE_FOREVER);

    AdGroup adGroup = new AdGroup();
    adGroup.setCampaignId(campaignId);
    adGroup.setAdGroupName("SampleDynamicAdsForSearchAdGroup_CreateOn_" + SoapUtils.getCurrentTimestamp());
    adGroup.setUserStatus(UserStatus.ACTIVE);
    adGroup.setTrackingUrl("http://www.yahoo.co.jp/?url={lpurl}&amp;a={creative}&amp;pid={_id1}");
    adGroup.setBid(bid);
    adGroup.setSettings(targetingSetting);
    adGroup.setCustomParameters(customParameters);
    adGroup.setAdGroupAdRotationMode(adGroupAdRotationMode);

    return adGroup;
  }

  /**
   * create sample request.
   *
   * @param accountId long
   * @param adGroups AdGroup
   * @return AdGroupSelector
   */
  public static AdGroupSelector buildExampleGetRequest(long accountId, List<AdGroup> adGroups) {

    // Set Selector
    AdGroupSelector selector = new AdGroupSelector();
    selector.setAccountId(accountId);

    for (AdGroup adGroup : adGroups) {
      selector.getCampaignIds().add(adGroup.getCampaignId());
      selector.getAdGroupIds().add(adGroup.getAdGroupId());
    }
    selector.getUserStatuses().addAll(Arrays.asList(UserStatus.ACTIVE, UserStatus.PAUSED));

    Paging paging = new Paging();
    paging.setStartIndex(1);
    paging.setNumberResults(20);
    selector.setPaging(paging);

    return selector;
  }

  /**
   * example adGroup set request.
   *
   * @param adGroups
   * @return List<AdGroup>
   */
  public static List<AdGroup> createExampleSetRequest(List<AdGroup> adGroups) {
    // create operands
    List<AdGroup> operands = new ArrayList<>();

    for (AdGroup adGroup : adGroups) {
      AdGroup operand = new AdGroup();
      operand.setCampaignId(adGroup.getCampaignId());
      operand.setAdGroupId(adGroup.getAdGroupId());
      operand.setAdGroupName("Sample_UpdateOn_" + adGroup.getAdGroupId() + "_" + SoapUtils.getCurrentTimestamp());
      operand.setUserStatus(UserStatus.PAUSED);

      // bid
      Bid bid = new Bid();
      bid.setMaxCpc((long) 150);
      operand.setBid(bid);

      // settings
      TargetingSetting targetingSetting = new TargetingSetting();
      targetingSetting.setCriterionType(CriterionType.TARGET_LIST);
      targetingSetting.setTargetAll(TargetAll.DEACTIVE);
      operand.setSettings(targetingSetting);

      // ad rotation mode
      AdGroupAdRotationMode adGroupAdRotationMode = new AdGroupAdRotationMode();
      adGroupAdRotationMode.setAdRotationMode(AdRotationMode.OPTIMIZE);
      operand.setAdGroupAdRotationMode(adGroupAdRotationMode);

      if (!adGroup.getUrlReviewData().getUrlApprovalStatus().equals(UrlApprovalStatus.NONE)) {
        operand.setTrackingUrl("http://yahoo.co.jp?url={lpurl}&amp;a={creative}&amp;pid={_id2}");

        CustomParameter customParameter = new CustomParameter();
        customParameter.setKey("id2");
        customParameter.setValue("5678");
        CustomParameters customParameters = new CustomParameters();
        customParameters.getParameters().add(customParameter);
        operand.setCustomParameters(customParameters);
      }
      operands.add(operand);
    }

    return operands;
  }

  /**
   * example check adGroup review status.
   *
   * @param adGroups List<AdGroup>
   * @throws Exception
   */
  public static void checkStatus(List<AdGroup> adGroups) throws Exception {

    try {
      // call 30sec sleep * 30 = 15minute
      for (int i = 0; i < 30; i++) {
        // sleep 30 second.
        System.out.println("\n***** sleep 30 seconds for Get AdGroup  *****\n");
        Thread.sleep(30000);

        AdGroupSelector getRequest = buildExampleGetRequest(SoapUtils.getAccountId(), adGroups);

        List<AdGroupValues> getResponse = get(getRequest);

        int approvalCount = 0;
        for (AdGroupValues adGroupValues : getResponse) {
          if (adGroupValues.getAdGroup().getUrlReviewData().getUrlApprovalStatus() != null) {
            switch (adGroupValues.getAdGroup().getUrlReviewData().getUrlApprovalStatus()) {
              default:
              case REVIEW:
              case APPROVED_WITH_REVIEW:
                continue;
              case DISAPPROVED:
                throw new Exception("AdGroup Review Status failed.");
              case NONE:
              case APPROVED:
                approvalCount++;
            }
          } else {
            throw new Exception("Fail to get AdGroupService.");
          }
        }

        if (getResponse.size() == approvalCount) {
          return;
        }
      }
    } catch (Exception e) {
      e.printStackTrace();
      throw e;
    }
  }

  /**
   * check & create upper service object.
   *
   * @return ValuesHolder
   * @throws Exception
   */
  private static ValuesHolder setup() throws Exception {
    return CampaignServiceSample.create();
  }

  /**
   * cleanup service object.
   *
   * @param valuesHolder
   * @throws Exception
   */
  public static void cleanup(ValuesHolder valuesHolder) throws Exception {
    CampaignServiceSample.cleanup(valuesHolder);
  }

  /**
   * create AdGroup.
   *
   * @return
   * @throws Exception
   */
  public static ValuesHolder create() throws Exception {

    ValuesHolder parentValuesHolder = setup();
    ValuesRepositoryFacade parentValuesRepositoryFacade = new ValuesRepositoryFacade(parentValuesHolder);

    long accountId = SoapUtils.getAccountId();
    Long campaignIdStandard = parentValuesRepositoryFacade.getCampaignValuesRepository().findCampaignId(CampaignType.STANDARD);
    Long campaignIdMobileApp = parentValuesRepositoryFacade.getCampaignValuesRepository().findCampaignId(CampaignType.MOBILE_APP);
    Long campaignIdDynamicAdsForSearch = parentValuesRepositoryFacade.getCampaignValuesRepository().findCampaignId(CampaignType.DYNAMIC_ADS_FOR_SEARCH);

    // create request.
    AdGroupOperation addRequest = buildExampleMutateRequest(Operator.ADD, accountId, new ArrayList<AdGroup>() {{
      add(createExampleStandardAdGroup(campaignIdStandard));
      add(createExampleMobileAppIOSAdGroup(campaignIdMobileApp));
      add(createExampleDynamicAdsForSearchAdGroup(campaignIdDynamicAdsForSearch));
    }});

    // run
    List<AdGroupValues> addResponse = mutate(addRequest);

    ValuesHolder selfValuesHolder = new ValuesHolder();
    selfValuesHolder.setBiddingStrategyValuesList(parentValuesHolder.getBiddingStrategyValuesList());
    selfValuesHolder.setFeedFolderValuesList(parentValuesHolder.getFeedFolderValuesList());
    selfValuesHolder.setCampaignValuesList(parentValuesHolder.getCampaignValuesList());
    selfValuesHolder.setAdGroupValuesList(addResponse);

    return selfValuesHolder;
  }

}

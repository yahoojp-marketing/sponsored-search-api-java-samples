/**
 * Copyright (C) 2019 Yahoo Japan Corporation. All Rights Reserved.
 */
package jp.yahooapis.ss.adapisample.basic.adgroupcriterion;

import jp.yahooapis.ss.adapisample.basic.adgroup.AdGroupServiceSample;
import jp.yahooapis.ss.adapisample.repository.ValuesRepositoryFacade;
import jp.yahooapis.ss.adapisample.util.SoapUtils;
import jp.yahooapis.ss.adapisample.util.ValuesHolder;
import jp.yahooapis.ss.v201901.Error;
import jp.yahooapis.ss.v201901.Paging;
import jp.yahooapis.ss.v201901.adgroupcriterion.AdGroupCriterion;
import jp.yahooapis.ss.v201901.adgroupcriterion.AdGroupCriterionAdditionalAdvancedMobileUrls;
import jp.yahooapis.ss.v201901.adgroupcriterion.AdGroupCriterionAdditionalAdvancedUrls;
import jp.yahooapis.ss.v201901.adgroupcriterion.AdGroupCriterionAdditionalUrl;
import jp.yahooapis.ss.v201901.adgroupcriterion.AdGroupCriterionOperation;
import jp.yahooapis.ss.v201901.adgroupcriterion.AdGroupCriterionPage;
import jp.yahooapis.ss.v201901.adgroupcriterion.AdGroupCriterionReturnValue;
import jp.yahooapis.ss.v201901.adgroupcriterion.AdGroupCriterionSelector;
import jp.yahooapis.ss.v201901.adgroupcriterion.AdGroupCriterionService;
import jp.yahooapis.ss.v201901.adgroupcriterion.AdGroupCriterionServiceInterface;
import jp.yahooapis.ss.v201901.adgroupcriterion.AdGroupCriterionUse;
import jp.yahooapis.ss.v201901.adgroupcriterion.AdGroupCriterionValues;
import jp.yahooapis.ss.v201901.adgroupcriterion.ApprovalStatus;
import jp.yahooapis.ss.v201901.adgroupcriterion.Bid;
import jp.yahooapis.ss.v201901.adgroupcriterion.BiddableAdGroupCriterion;
import jp.yahooapis.ss.v201901.adgroupcriterion.CriterionType;
import jp.yahooapis.ss.v201901.adgroupcriterion.CustomParameter;
import jp.yahooapis.ss.v201901.adgroupcriterion.CustomParameters;
import jp.yahooapis.ss.v201901.adgroupcriterion.Keyword;
import jp.yahooapis.ss.v201901.adgroupcriterion.KeywordMatchType;
import jp.yahooapis.ss.v201901.adgroupcriterion.NegativeAdGroupCriterion;
import jp.yahooapis.ss.v201901.adgroupcriterion.Operator;
import jp.yahooapis.ss.v201901.adgroupcriterion.UserStatus;
import jp.yahooapis.ss.v201901.campaign.CampaignType;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.xml.ws.Holder;


/**
 * example AdGroupCriterionService operation and Utility method collection.
 */
public class AdGroupCriterionServiceSample {

  /**
   * main method for AdGroupCriterionServiceSample
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
      Long adGroupId = valuesRepositoryFacade.getAdGroupValuesRepository().findAdGroupId(campaignId);

      // =================================================================
      // AdGroupCriterionService ADD
      // =================================================================
      // create request.
      AdGroupCriterionOperation addRequest = buildExampleMutateRequest(Operator.ADD, accountId, new ArrayList<AdGroupCriterion>() {{
        add(createExampleBiddableAdGroupCriterion(campaignId, adGroupId));
        add(createExampleNegativeAdGroupCriterion(campaignId, adGroupId));
      }});

      // run
      List<AdGroupCriterionValues> addResponse = mutate(addRequest);
      valuesRepositoryFacade.getValuesHolder().setAdGroupCriterionValuesList(addResponse);

      // =================================================================
      // AdGroupCriterionService GET
      // =================================================================
      // create request.
      AdGroupCriterionSelector getRequest = buildExampleGetRequest(accountId, AdGroupCriterionUse.BIDDABLE, valuesRepositoryFacade.getAdGroupCriterionValuesRepository().getAdGroupCriterions());

      // run
      get(getRequest);

      // =================================================================
      // AdGroupCriterionService SET
      // =================================================================
      // create request.
      AdGroupCriterionOperation setRequest =
          buildExampleMutateRequest(Operator.SET, accountId, createExampleSetRequest(valuesRepositoryFacade.getAdGroupCriterionValuesRepository().getAdGroupCriterions()));

      // run
      mutate(setRequest);

      // =================================================================
      // AdGroupCriterionService REMOVE
      // =================================================================
      // create request.
      AdGroupCriterionOperation removeRequest = buildExampleMutateRequest(Operator.REMOVE, accountId, valuesRepositoryFacade.getAdGroupCriterionValuesRepository().getAdGroupCriterions());

      // run
      mutate(removeRequest);

    } catch (Exception ex) {
      ex.printStackTrace();
      throw ex;
    } finally {
      cleanup(valuesHolder);
    }
  }

  /**
   * example mutate adGroupCriterions.
   *
   * @param operation AdGroupCriterionOperation
   * @return AdGroupCriterionValues
   */
  public static List<AdGroupCriterionValues> mutate(AdGroupCriterionOperation operation) throws Exception {
    // Call API
    System.out.println("############################################");
    System.out.println("AdGroupCriterionService::mutate(" + operation.getOperator() + ")");
    System.out.println("############################################");

    Holder<AdGroupCriterionReturnValue> adGroupCriterionReturnValueHolder = new Holder<AdGroupCriterionReturnValue>();
    Holder<List<Error>> errorHolder = new Holder<List<Error>>();
    AdGroupCriterionServiceInterface adGroupCriterionService = SoapUtils.createServiceInterface(AdGroupCriterionServiceInterface.class, AdGroupCriterionService.class);
    adGroupCriterionService.mutate(operation, adGroupCriterionReturnValueHolder, errorHolder);

    SoapUtils.checkSoapError(errorHolder, adGroupCriterionReturnValueHolder.value.getValues());

    // Response
    return adGroupCriterionReturnValueHolder.value.getValues();
  }

  /**
   * Sample Program for AdGroupCriterionService GET.
   *
   * @param selector AdGroupCriterionSelector
   * @return AdGroupCriterionValues
   */
  public static List<AdGroupCriterionValues> get(AdGroupCriterionSelector selector) throws Exception {

    // Call API
    System.out.println("############################################");
    System.out.println("AdGroupCriterionService::get");
    System.out.println("############################################");

    Holder<AdGroupCriterionPage> adGroupCriterionPage = new Holder<AdGroupCriterionPage>();
    Holder<List<Error>> errorHolder = new Holder<List<Error>>();
    AdGroupCriterionServiceInterface adGroupCriterionService = SoapUtils.createServiceInterface(AdGroupCriterionServiceInterface.class, AdGroupCriterionService.class);
    adGroupCriterionService.get(selector, adGroupCriterionPage, errorHolder);

    SoapUtils.checkSoapError(errorHolder, adGroupCriterionPage.value.getValues());

    // Response
    return adGroupCriterionPage.value.getValues();
  }

  /**
   * example mutate request.
   */
  public static AdGroupCriterionOperation buildExampleMutateRequest(Operator operator, long accountId, List<AdGroupCriterion> operand) {
    AdGroupCriterionOperation operation = new AdGroupCriterionOperation();
    operation.setOperator(operator);
    operation.setAccountId(accountId);
    operation.getOperand().addAll(operand);

    return operation;
  }

  /**
   * example biddable adGroupCriterion request.
   *
   * @param campaignId long
   * @param adGroupId  long
   * @return AdGroupCriterion
   */
  public static AdGroupCriterion createExampleBiddableAdGroupCriterion(long campaignId, long adGroupId) {

    // keyword
    Keyword keyword = new Keyword();
    keyword.setType(CriterionType.KEYWORD);
    keyword.setText("sample text" + AdGroupCriterionUse.BIDDABLE.name());
    keyword.setMatchType(KeywordMatchType.PHRASE);

    // bid
    Bid bit = new Bid();
    bit.setMaxCpc((long) 100);

    // advanced url
    AdGroupCriterionAdditionalUrl adGroupCriterionAdditionalUrl1 = new AdGroupCriterionAdditionalUrl();
    adGroupCriterionAdditionalUrl1.setUrl("http://www1.yahoo.co.jp");
    AdGroupCriterionAdditionalUrl adGroupCriterionAdditionalUrl2 = new AdGroupCriterionAdditionalUrl();
    adGroupCriterionAdditionalUrl2.setUrl("http://www2.yahoo.co.jp");
    AdGroupCriterionAdditionalUrl adGroupCriterionAdditionalUrl3 = new AdGroupCriterionAdditionalUrl();
    adGroupCriterionAdditionalUrl3.setUrl("http://www3.yahoo.co.jp");
    AdGroupCriterionAdditionalAdvancedUrls additionalAdvancedUrls = new AdGroupCriterionAdditionalAdvancedUrls();
    additionalAdvancedUrls.getAdditionalAdvancedUrl().addAll(Arrays.asList( //
        adGroupCriterionAdditionalUrl1, adGroupCriterionAdditionalUrl2, adGroupCriterionAdditionalUrl3));

    // advanced mobile url
    AdGroupCriterionAdditionalUrl adGroupCriterionAdditionalMobileUrl1 = new AdGroupCriterionAdditionalUrl();
    adGroupCriterionAdditionalMobileUrl1.setUrl("http://www1.yahoo.co.jp/mobile");
    AdGroupCriterionAdditionalUrl adGroupCriterionAdditionalMobileUrl2 = new AdGroupCriterionAdditionalUrl();
    adGroupCriterionAdditionalMobileUrl2.setUrl("http://www2.yahoo.co.jp/mobile");
    AdGroupCriterionAdditionalUrl adGroupCriterionAdditionalMobileUrl3 = new AdGroupCriterionAdditionalUrl();
    adGroupCriterionAdditionalMobileUrl3.setUrl("http://www3.yahoo.co.jp/mobile");
    AdGroupCriterionAdditionalAdvancedMobileUrls adGroupCriterionAdditionalAdvancedMobileUrls = new AdGroupCriterionAdditionalAdvancedMobileUrls();
    adGroupCriterionAdditionalAdvancedMobileUrls.getAdditionalAdvancedMobileUrl().addAll(Arrays.asList( //
        adGroupCriterionAdditionalMobileUrl1, adGroupCriterionAdditionalMobileUrl2, adGroupCriterionAdditionalMobileUrl3));

    // customParameters
    CustomParameter parameter = new CustomParameter();
    parameter.setKey("id1");
    parameter.setValue("1234");
    CustomParameters customParameters = new CustomParameters();
    customParameters.getParameters().addAll(Arrays.asList(parameter));

    // Set BiddableAdGroupCriterion
    BiddableAdGroupCriterion biddableAdGroupCriterion = new BiddableAdGroupCriterion();
    biddableAdGroupCriterion.setCampaignId(campaignId);
    biddableAdGroupCriterion.setAdGroupId(adGroupId);
    biddableAdGroupCriterion.setCriterionUse(AdGroupCriterionUse.BIDDABLE);
    biddableAdGroupCriterion.setUserStatus(UserStatus.ACTIVE);
    biddableAdGroupCriterion.setTrackingUrl("http://www.yahoo.co.jp/?url={lpurl}&amp;a={creative}&amp;pid={_id1}");
    biddableAdGroupCriterion.setCriterion(keyword);
    biddableAdGroupCriterion.setBid(bit);
    biddableAdGroupCriterion.setAdvancedUrl("http://www.yahoo.co.jp");
    biddableAdGroupCriterion.setAdditionalAdvancedUrls(additionalAdvancedUrls);
    biddableAdGroupCriterion.setAdvancedMobileUrl("http://www.yahoo.co.jp/mobile");
    biddableAdGroupCriterion.setAdditionalAdvancedMobileUrls(adGroupCriterionAdditionalAdvancedMobileUrls);
    biddableAdGroupCriterion.setCustomParameters(customParameters);

    return biddableAdGroupCriterion;
  }

  /**
   * example negative adGroupCriterion request.
   *
   * @param campaignId long
   * @param adGroupId  long
   * @return NegativeAdGroupCriterion
   */
  public static NegativeAdGroupCriterion createExampleNegativeAdGroupCriterion(long campaignId, long adGroupId) {

    // keyword
    Keyword keyword = new Keyword();
    keyword.setType(CriterionType.KEYWORD);
    keyword.setText("sample text" + AdGroupCriterionUse.NEGATIVE.name());
    keyword.setMatchType(KeywordMatchType.PHRASE);

    NegativeAdGroupCriterion negativeAdGroupCriterion = new NegativeAdGroupCriterion();
    negativeAdGroupCriterion.setCampaignId(campaignId);
    negativeAdGroupCriterion.setAdGroupId(adGroupId);
    negativeAdGroupCriterion.setCriterionUse(AdGroupCriterionUse.NEGATIVE);
    negativeAdGroupCriterion.setCriterion(keyword);

    return negativeAdGroupCriterion;
  }

  /**
   * example get request.
   *
   * @param accountId           long
   * @param adGroupCriterionUse AdGroupCriterionUse
   * @param adGroupCriterions   AdGroupCriterion
   */
  public static AdGroupCriterionSelector buildExampleGetRequest(long accountId, AdGroupCriterionUse adGroupCriterionUse, List<AdGroupCriterion> adGroupCriterions) {

    // Set Selector
    AdGroupCriterionSelector selector = new AdGroupCriterionSelector();
    selector.setAccountId(accountId);
    selector.setCriterionUse(adGroupCriterionUse);

    for (AdGroupCriterion adGroupCriterion : adGroupCriterions) {
      selector.getCampaignIds().add(adGroupCriterion.getCampaignId());
      selector.getAdGroupIds().add(adGroupCriterion.getAdGroupId());
      selector.getCriterionIds().add(adGroupCriterion.getCriterion().getCriterionId());
    }
    selector.getUserStatuses().addAll(Arrays.asList(UserStatus.ACTIVE, UserStatus.PAUSED));
    selector.getApprovalStatuses().addAll(Arrays.asList( //
        ApprovalStatus.APPROVED, //
        ApprovalStatus.APPROVED_WITH_REVIEW, //
        ApprovalStatus.REVIEW, //
        ApprovalStatus.PRE_DISAPPROVED, //
        ApprovalStatus.POST_DISAPPROVED //
    ));

    Paging paging = new Paging();
    paging.setStartIndex(1);
    paging.setNumberResults(20);
    selector.setPaging(paging);

    return selector;
  }

  /**
   * example adGroupCriterion set request.
   *
   * @return List<AdGroupCriterion>
   */
  public static List<AdGroupCriterion> createExampleSetRequest(List<AdGroupCriterion> adGroupCriterions) {
    // create operands
    List<AdGroupCriterion> operands = new ArrayList<>();

    for (AdGroupCriterion adGroupCriterion : adGroupCriterions) {
      if (adGroupCriterion.getCriterionUse().equals(AdGroupCriterionUse.BIDDABLE)) {
        // keyword
        Keyword keyword = new Keyword();
        keyword.setCriterionId(adGroupCriterion.getCriterion().getCriterionId());
        keyword.setType(adGroupCriterion.getCriterion().getType());

        // bid
        Bid bid = new Bid();
        bid.setMaxCpc((long) 150);

        BiddableAdGroupCriterion biddableAdGroupCriterion = new BiddableAdGroupCriterion();
        biddableAdGroupCriterion.setCampaignId(adGroupCriterion.getCampaignId());
        biddableAdGroupCriterion.setAdGroupId(adGroupCriterion.getAdGroupId());
        biddableAdGroupCriterion.setCriterionUse(adGroupCriterion.getCriterionUse());
        biddableAdGroupCriterion.setUserStatus(UserStatus.PAUSED);
        biddableAdGroupCriterion.setCriterion(keyword);
        biddableAdGroupCriterion.setBid(bid);

        operands.add(biddableAdGroupCriterion);
      }
    }

    return operands;
  }

  /**
   * check & create upper service object.
   *
   * @return ValuesHolder
   */
  private static ValuesHolder setup() throws Exception {

    return AdGroupServiceSample.create();
  }

  /**
   * cleanup service object.
   *
   * @param valuesHolder ValuesHolder
   */
  public static void cleanup(ValuesHolder valuesHolder) throws Exception {
    AdGroupServiceSample.cleanup(valuesHolder);
  }

  /**
   * create biddable AdGroupCriterion.
   *
   * @return valuesHolder ValuesHolder
   */
  public static ValuesHolder create() throws Exception {

    ValuesHolder parentValuesHolder = setup();
    ValuesRepositoryFacade parentValuesRepositoryFacade = new ValuesRepositoryFacade(parentValuesHolder);

    long accountId = SoapUtils.getAccountId();
    Long campaignId = parentValuesRepositoryFacade.getCampaignValuesRepository().findCampaignId(CampaignType.STANDARD);
    Long adGroupId = parentValuesRepositoryFacade.getAdGroupValuesRepository().findAdGroupId(campaignId);


    // create request.
    AdGroupCriterionOperation addRequest = buildExampleMutateRequest(Operator.ADD, accountId, new ArrayList<AdGroupCriterion>() {{
      add(createExampleBiddableAdGroupCriterion(campaignId, adGroupId));
    }});

    // run
    List<AdGroupCriterionValues> addResponse = mutate(addRequest);

    ValuesHolder seflValuesHolder = new ValuesHolder();
    seflValuesHolder.setBiddingStrategyValuesList(parentValuesHolder.getBiddingStrategyValuesList());
    seflValuesHolder.setFeedFolderValuesList(parentValuesHolder.getFeedFolderValuesList());
    seflValuesHolder.setCampaignValuesList(parentValuesHolder.getCampaignValuesList());
    seflValuesHolder.setAdGroupValuesList(parentValuesHolder.getAdGroupValuesList());
    seflValuesHolder.setAdGroupCriterionValuesList(addResponse);

    return seflValuesHolder;
  }

}

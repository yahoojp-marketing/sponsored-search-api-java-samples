/**
 * Copyright (C) 2019 Yahoo Japan Corporation. All Rights Reserved.
 */
package jp.yahooapis.ss.adapisample.basic.adgroupad;

import jp.yahooapis.ss.adapisample.basic.adgroup.AdGroupServiceSample;
import jp.yahooapis.ss.adapisample.repository.ValuesRepositoryFacade;
import jp.yahooapis.ss.adapisample.util.SoapUtils;
import jp.yahooapis.ss.adapisample.util.ValuesHolder;
import jp.yahooapis.ss.v201909.Error;
import jp.yahooapis.ss.v201909.Paging;
import jp.yahooapis.ss.v201909.adgroupad.AdGroupAd;
import jp.yahooapis.ss.v201909.adgroupad.AdGroupAdAdditionalAdvancedMobileUrls;
import jp.yahooapis.ss.v201909.adgroupad.AdGroupAdAdditionalAdvancedUrls;
import jp.yahooapis.ss.v201909.adgroupad.AdGroupAdOperation;
import jp.yahooapis.ss.v201909.adgroupad.AdGroupAdPage;
import jp.yahooapis.ss.v201909.adgroupad.AdGroupAdReturnValue;
import jp.yahooapis.ss.v201909.adgroupad.AdGroupAdSelector;
import jp.yahooapis.ss.v201909.adgroupad.AdGroupAdService;
import jp.yahooapis.ss.v201909.adgroupad.AdGroupAdServiceInterface;
import jp.yahooapis.ss.v201909.adgroupad.AdGroupAdValues;
import jp.yahooapis.ss.v201909.adgroupad.AdType;
import jp.yahooapis.ss.v201909.adgroupad.AppAd;
import jp.yahooapis.ss.v201909.adgroupad.ApprovalStatus;
import jp.yahooapis.ss.v201909.adgroupad.CustomParameter;
import jp.yahooapis.ss.v201909.adgroupad.CustomParameters;
import jp.yahooapis.ss.v201909.adgroupad.DevicePreference;
import jp.yahooapis.ss.v201909.adgroupad.DynamicSearchLinkedAd;
import jp.yahooapis.ss.v201909.adgroupad.ExtendedTextAd;
import jp.yahooapis.ss.v201909.adgroupad.Operator;
import jp.yahooapis.ss.v201909.adgroupad.UserStatus;
import jp.yahooapis.ss.v201909.campaign.AppStore;
import jp.yahooapis.ss.v201909.campaign.CampaignType;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import javax.xml.ws.Holder;


/**
 * example AdGroupAd operation and Utility method collection.
 */
public class AdGroupAdServiceSample {

  /**
   * main method for AdGroupAdServiceSample
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
      Long campaignIdStandard = valuesRepositoryFacade.getCampaignValuesRepository().findCampaignId(CampaignType.STANDARD);
      Long campaignIdMobileApp = valuesRepositoryFacade.getCampaignValuesRepository().findCampaignId(AppStore.IOS);
      Long campaignIdDynamicAdsForSearch = valuesRepositoryFacade.getCampaignValuesRepository().findCampaignId(CampaignType.DYNAMIC_ADS_FOR_SEARCH);
      String appIdIOS = valuesRepositoryFacade.getCampaignValuesRepository().findAppId(campaignIdMobileApp);
      Long adGroupIdStandard = valuesRepositoryFacade.getAdGroupValuesRepository().findAdGroupId(campaignIdStandard);
      Long adGroupIdMobileApp = valuesRepositoryFacade.getAdGroupValuesRepository().findAdGroupId(campaignIdMobileApp);
      Long adGroupIdDynamicAdsForSearch = valuesRepositoryFacade.getAdGroupValuesRepository().findAdGroupId(campaignIdDynamicAdsForSearch);

      // =================================================================
      // AdGroupAdService ADD
      // =================================================================
      // create request.
      AdGroupAdOperation addRequest = buildExampleMutateRequest(Operator.ADD, accountId, new ArrayList<AdGroupAd>() {{
        add(createExampleExtendedTextAd(campaignIdStandard, adGroupIdStandard));
        add(createExampleAppAdIOS(campaignIdMobileApp, appIdIOS, adGroupIdMobileApp));
        add(createExampleDynamicSearchLinkedAd(campaignIdDynamicAdsForSearch, adGroupIdDynamicAdsForSearch));
      }});

      // run
      List<AdGroupAdValues> addResponse = mutate(addRequest);
      valuesRepositoryFacade.getValuesHolder().setAdGroupAdValuesList(addResponse);

      // =================================================================
      // AdGroupAdService SET
      // =================================================================
      // create request.
      AdGroupAdOperation setRequest = buildExampleMutateRequest(Operator.SET, accountId, createExampleSetRequest(valuesRepositoryFacade.getAdGroupAdValuesRepository().getAdGroupAds()));

      // run
      mutate(setRequest);

      // =================================================================
      // AdGroupAdService GET
      // =================================================================
      // create request.
      AdGroupAdSelector adGroupAdSelector = buildExampleGetRequest(accountId, valuesRepositoryFacade.getAdGroupAdValuesRepository().getAdGroupAds());

      // run
      get(adGroupAdSelector);

      // =================================================================
      // AdGroupAdService REMOVE
      // =================================================================
      // create request.
      AdGroupAdOperation removeRequest = buildExampleMutateRequest(Operator.REMOVE, accountId, valuesRepositoryFacade.getAdGroupAdValuesRepository().getAdGroupAds());

      // run
      mutate(removeRequest);

    } catch (Exception e) {
      e.printStackTrace();
      throw e;
    } finally {
      cleanup(valuesHolder);
    }
  }

  /**
   * example mutate request.
   */
  public static AdGroupAdOperation buildExampleMutateRequest(Operator operator, long accountId, List<AdGroupAd> operand) {
    AdGroupAdOperation operation = new AdGroupAdOperation();
    operation.setOperator(operator);
    operation.setAccountId(accountId);
    operation.getOperand().addAll(operand);

    return operation;
  }

  /**
   * example ExtendedText Ad request.
   *
   * @param campaignId long
   * @param adGroupId  long
   * @return AdGroupAd
   */
  public static AdGroupAd createExampleExtendedTextAd(long campaignId, long adGroupId) {

    // advanced url
    AdGroupAdAdditionalAdvancedUrls additionalAdvancedUrls1 = new AdGroupAdAdditionalAdvancedUrls();
    additionalAdvancedUrls1.setAdvancedUrl("http://www1.yahoo.co.jp");
    AdGroupAdAdditionalAdvancedUrls additionalAdvancedUrls2 = new AdGroupAdAdditionalAdvancedUrls();
    additionalAdvancedUrls2.setAdvancedUrl("http://www2.yahoo.co.jp");
    AdGroupAdAdditionalAdvancedUrls additionalAdvancedUrls3 = new AdGroupAdAdditionalAdvancedUrls();
    additionalAdvancedUrls3.setAdvancedUrl("http://www3.yahoo.co.jp");

    // advanced mobile url
    AdGroupAdAdditionalAdvancedMobileUrls adGroupAdAdditionalAdvancedMobileUrls1 = new AdGroupAdAdditionalAdvancedMobileUrls();
    adGroupAdAdditionalAdvancedMobileUrls1.setAdvancedMobileUrl("http://www1.yahoo.co.jp/mobile");
    AdGroupAdAdditionalAdvancedMobileUrls adGroupAdAdditionalAdvancedMobileUrls2 = new AdGroupAdAdditionalAdvancedMobileUrls();
    adGroupAdAdditionalAdvancedMobileUrls2.setAdvancedMobileUrl("http://www2.yahoo.co.jp/mobile");
    AdGroupAdAdditionalAdvancedMobileUrls adGroupAdAdditionalAdvancedMobileUrls3 = new AdGroupAdAdditionalAdvancedMobileUrls();
    adGroupAdAdditionalAdvancedMobileUrls3.setAdvancedMobileUrl("http://www3.yahoo.co.jp/mobile");

    // customParameters
    CustomParameter customParameter = new CustomParameter();
    customParameter.setKey("id1");
    customParameter.setValue("1234");
    CustomParameters customParameters = new CustomParameters();
    customParameters.getParameters().add(customParameter);

    // ad
    ExtendedTextAd ad = new ExtendedTextAd();
    ad.setType(AdType.EXTENDED_TEXT_AD);
    ad.setHeadline("sample headline");
    ad.setHeadline2("sample headline2");
    ad.setDescription("sample ad desc");
    ad.setPath1("path1");
    ad.setPath2("path2");
    ad.setTrackingUrl("http://www.yahoo.co.jp/?url={lpurl}&amp;a={creative}&amp;pid={_id1}");
    ad.setAdvancedUrl("http://www.yahoo.co.jp");
    ad.getAdditionalAdvancedUrls().addAll(Arrays.asList(additionalAdvancedUrls1, additionalAdvancedUrls2, additionalAdvancedUrls3));
    ad.setAdvancedMobileUrl("http://www.yahoo.co.jp/mobile");
    ad.getAdditionalAdvancedMobileUrls().addAll(Arrays.asList(adGroupAdAdditionalAdvancedMobileUrls1, adGroupAdAdditionalAdvancedMobileUrls2, adGroupAdAdditionalAdvancedMobileUrls3));
    ad.setCustomParameters(customParameters);


    AdGroupAd adGroupAd = new AdGroupAd();
    adGroupAd.setCampaignId(campaignId);
    adGroupAd.setAdGroupId(adGroupId);
    adGroupAd.setAdName("SampleExtendedTextAd_CreateOn_" + SoapUtils.getCurrentTimestamp());
    adGroupAd.setUserStatus(UserStatus.ACTIVE);
    adGroupAd.setAd(ad);

    return adGroupAd;
  }

  /**
   * example App Ad IOS request.
   *
   * @param campaignId long
   * @param adGroupId  long
   * @return AdGroupAd
   */
  public static AdGroupAd createExampleAppAdIOS(long campaignId, String appId, long adGroupId) {

    // customParameters
    CustomParameter customParameter = new CustomParameter();
    customParameter.setKey("id1");
    customParameter.setValue("1234");
    CustomParameters customParameters = new CustomParameters();
    customParameters.getParameters().add(customParameter);

    // ad
    AppAd ad = new AppAd();
    ad.setType(AdType.APP_AD);
    ad.setHeadline("sample headline");
    ad.setDescription("sample ad desc");
    ad.setDescription2("sample ad desc2");
    ad.setDevicePreference(DevicePreference.SMART_PHONE);
    ad.setTrackingUrl("http://www.yahoo.co.jp/?url={lpurl}&amp;a={creative}&amp;pid={_id1}");
    ad.setAdvancedUrl("http://www.apple.com/jp/itunes/app/appname/" + appId);
    ad.setCustomParameters(customParameters);


    AdGroupAd adGroupAd = new AdGroupAd();
    adGroupAd.setCampaignId(campaignId);
    adGroupAd.setAdGroupId(adGroupId);
    adGroupAd.setAdName("SampleAppAdIOS_CreateOn_" + SoapUtils.getCurrentTimestamp());
    adGroupAd.setUserStatus(UserStatus.ACTIVE);
    adGroupAd.setAd(ad);

    return adGroupAd;
  }

  /**
   * example App Ad ANDROID request.
   *
   * @param campaignId long
   * @param adGroupId  long
   * @return AdGroupAd
   */
  public static AdGroupAd createExampleAppAdANDROID(long campaignId, String appId, long adGroupId) {

    // ad
    AppAd ad = new AppAd();
    ad.setType(AdType.APP_AD);
    ad.setHeadline("sample headline");
    ad.setDescription("sample ad desc");
    ad.setDescription2("sample ad desc2");
    ad.setDevicePreference(DevicePreference.SMART_PHONE);
    ad.setAdvancedUrl("https://play.google.com/store/apps/details?id=" + appId);


    AdGroupAd adGroupAd = new AdGroupAd();
    adGroupAd.setCampaignId(campaignId);
    adGroupAd.setAdGroupId(adGroupId);
    adGroupAd.setAdName("SampleAppAdANDROID_CreateOn_" + SoapUtils.getCurrentTimestamp());
    adGroupAd.setUserStatus(UserStatus.ACTIVE);
    adGroupAd.setAd(ad);

    return adGroupAd;
  }

  /**
   * example AdCustomizer request.
   *
   * @param campaignId         long
   * @param adGroupId          long
   * @param feedFolderName     String
   * @param feedAttributeNames Map
   * @return AdGroupAd
   */
  public static List<AdGroupAd> createExampleAdCustomizerAds(long campaignId, long adGroupId, String feedFolderName, Map<String, String> feedAttributeNames) {

    List<AdGroupAd> adGroupAds = new ArrayList<>();

    // example KeywordInsertion
    AdGroupAd keywordInsertion = createExampleExtendedTextAd(campaignId, adGroupId);
    keywordInsertion.setAdName("KeywordInsertion_" + SoapUtils.getCurrentTimestamp());
    keywordInsertion.getAd().setDescription("sample {KEYWORD:keyword}");
    adGroupAds.add(keywordInsertion);

    // example CountdownOption
    AdGroupAd countdownOption = createExampleExtendedTextAd(campaignId, adGroupId);
    countdownOption.setAdName("SampleCountdownOption_" + SoapUtils.getCurrentTimestamp());
    countdownOption.getAd().setDescription("{=COUNTDOWN(\"2020/12/15 18:00:00\",\"ja\")}");
    adGroupAds.add(countdownOption);

    // example CountdownOption & AdCustomizerDate
    AdGroupAd countdownOptionAdOfAdCustomizer = createExampleExtendedTextAd(campaignId, adGroupId);
    countdownOptionAdOfAdCustomizer.setAdName("CountdownOfAdCustomizer_" + SoapUtils.getCurrentTimestamp());
    countdownOptionAdOfAdCustomizer.getAd().setDescription("{=COUNTDOWN(" + feedFolderName + "." + feedAttributeNames.get("AD_CUSTOMIZER_DATE") + ",\"ja\")}");
    adGroupAds.add(countdownOptionAdOfAdCustomizer);

    // example DefaultText & AdCustomizerString
    AdGroupAd defaultTextOfAdCustomizer = createExampleExtendedTextAd(campaignId, adGroupId);
    defaultTextOfAdCustomizer.setAdName("DefaultTextOfAdCustomizer_" + SoapUtils.getCurrentTimestamp());
    defaultTextOfAdCustomizer.getAd().setHeadline("{=" + feedFolderName + "." + feedAttributeNames.get("AD_CUSTOMIZER_STRING") + ":default}headline");
    ((ExtendedTextAd) defaultTextOfAdCustomizer.getAd()).setHeadline2("{=" + feedFolderName + "." + feedAttributeNames.get("AD_CUSTOMIZER_STRING") + ":default}headline2");
    defaultTextOfAdCustomizer.getAd().setDescription("{=" + feedFolderName + "." + feedAttributeNames.get("AD_CUSTOMIZER_STRING") + ":default}Description");
    adGroupAds.add(defaultTextOfAdCustomizer);

    // example Mobile specification with IF function
    AdGroupAd ifFunction = createExampleExtendedTextAd(campaignId, adGroupId);
    ifFunction.setAdName("IF_Function_" + SoapUtils.getCurrentTimestamp());
    ifFunction.getAd().setHeadline("{=IF(device=mobile,MOBILE):PC}Headline");
    ((ExtendedTextAd)ifFunction.getAd()).setHeadline2("{=IF(device=mobile,MOBILE):PC}Headline2");
    ifFunction.getAd().setDescription("{=IF(device=mobile,MOBILE):PC}Description");
    adGroupAds.add(ifFunction);

    // example Mobile specification with IF function & DefaultText AdCustomizerString
    AdGroupAd ifFunctionDefaultTextOfAdCustomizer = createExampleExtendedTextAd(campaignId, adGroupId);
    ifFunctionDefaultTextOfAdCustomizer.setAdName("IF_Function_DefaultTextOfAdCustomizer_" + SoapUtils.getCurrentTimestamp());
    ifFunctionDefaultTextOfAdCustomizer.getAd().setHeadline("{=IF(device=mobile,MOBILE):PC}test {=" + feedFolderName + "." + feedAttributeNames.get("AD_CUSTOMIZER_STRING") + ":default}headline");
    ((ExtendedTextAd)ifFunctionDefaultTextOfAdCustomizer.getAd()).setHeadline2("{=IF(device=mobile,MOBILE):PC}test {=" + feedFolderName + "." + feedAttributeNames.get("AD_CUSTOMIZER_STRING") + ":default}headline2");
    ifFunctionDefaultTextOfAdCustomizer.getAd().setDescription("{=IF(device=mobile,MOBILE):PC}test {=" + feedFolderName + "." + feedAttributeNames.get("AD_CUSTOMIZER_STRING") + ":default}description");
    adGroupAds.add(ifFunctionDefaultTextOfAdCustomizer);

    return adGroupAds;
  }

  /**
   * example DynamicSearchLinkedAd request.
   *
   * @param campaignId long
   * @param adGroupId  long
   * @return AdGroupAd
   */
  public static AdGroupAd createExampleDynamicSearchLinkedAd(long campaignId, long adGroupId) {

    // customParameters
    CustomParameter customParameter = new CustomParameter();
    customParameter.setKey("id1");
    customParameter.setValue("1234");
    CustomParameters customParameters = new CustomParameters();
    customParameters.getParameters().add(customParameter);

    // ad
    DynamicSearchLinkedAd ad = new DynamicSearchLinkedAd();
    ad.setType(AdType.DYNAMIC_SEARCH_LINKED_AD);
    ad.setDescription("sample ad desc");
    ad.setDevicePreference(DevicePreference.SMART_PHONE);
    ad.setTrackingUrl("http://www.yahoo.co.jp/?url={lpurl}&amp;a={creative}&amp;pid={_id1}");
    ad.setCustomParameters(customParameters);


    AdGroupAd adGroupAd = new AdGroupAd();
    adGroupAd.setCampaignId(campaignId);
    adGroupAd.setAdGroupId(adGroupId);
    adGroupAd.setAdName("SampleDynamicSearchLinkedAd_CreateOn_" + SoapUtils.getCurrentTimestamp());
    adGroupAd.setUserStatus(UserStatus.ACTIVE);
    adGroupAd.setAd(ad);

    return adGroupAd;
  }

  /**
   * example adGroupAd set request.
   *
   * @param adGroupAds
   * @return List<AdGroupAd>
   */
  public static List<AdGroupAd> createExampleSetRequest(List<AdGroupAd> adGroupAds) {
    // create operands
    List<AdGroupAd> operands = new ArrayList<>();

    for (AdGroupAd adGroupAd : adGroupAds) {
      AdGroupAd operand = new AdGroupAd();
      operand.setCampaignId(adGroupAd.getCampaignId());
      operand.setAdGroupId(adGroupAd.getAdGroupId());
      operand.setAdId(adGroupAd.getAdId());
      operand.setAdName("UpdateOn_" + adGroupAd.getAdId() + "_" + SoapUtils.getCurrentTimestamp());
      operand.setUserStatus(UserStatus.PAUSED);

      operands.add(operand);
    }

    return operands;
  }

  /**
   * example get request.
   *
   * @param accountId  long
   * @param adGroupAds AdGroupAd
   * @return AdGroupAdSelector
   */
  public static AdGroupAdSelector buildExampleGetRequest(long accountId, List<AdGroupAd> adGroupAds) {
    // Set Selector
    AdGroupAdSelector selector = new AdGroupAdSelector();
    selector.setAccountId(accountId);

    for (AdGroupAd adGroupAd : adGroupAds) {
      selector.getCampaignIds().add((adGroupAd.getCampaignId()));
      selector.getAdGroupIds().add((adGroupAd.getAdGroupId()));
      selector.getAdIds().add((adGroupAd.getAdId()));
    }
    selector.getAdTypes().addAll(Arrays.asList( //
        AdType.APP_AD, //
        AdType.EXTENDED_TEXT_AD, //
        AdType.DYNAMIC_SEARCH_LINKED_AD //
    ));
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
   * example mutate adGroupAds.
   *
   * @param operation AdGroupAdOperation
   * @return AdGroupAdValues
   */
  public static List<AdGroupAdValues> mutate(AdGroupAdOperation operation) throws Exception {
    // Call API
    System.out.println("############################################");
    System.out.println("AdGroupAdService::mutate(" + operation.getOperator() + ")");
    System.out.println("############################################");

    Holder<AdGroupAdReturnValue> adGroupAdReturnValueHolder = new Holder<AdGroupAdReturnValue>();
    Holder<List<Error>> errorHolder = new Holder<List<Error>>();
    AdGroupAdServiceInterface adGroupAdService = SoapUtils.createServiceInterface(AdGroupAdServiceInterface.class, AdGroupAdService.class);
    adGroupAdService.mutate(operation, adGroupAdReturnValueHolder, errorHolder);

    SoapUtils.checkSoapError(errorHolder, adGroupAdReturnValueHolder.value.getValues());

    // Response
    return adGroupAdReturnValueHolder.value.getValues();
  }

  /**
   * Sample Program for AdGroupAdService GET.
   *
   * @param adGroupAdSelector AdGroupAdSelector
   * @return AdGroupAdValues
   * @throws Exception
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

    SoapUtils.checkSoapError(errorHolder, adGroupAdPage.value.getValues());

    // Response
    return adGroupAdPage.value.getValues();
  }

  /**
   * check & create upper service object.
   *
   * @return
   * @throws Exception
   */
  private static ValuesHolder setup() throws Exception {

    return AdGroupServiceSample.create();
  }

  /**
   * cleanup service object.
   *
   * @param valuesHolder ValuesHolder
   * @throws Exception
   */
  public static void cleanup(ValuesHolder valuesHolder) throws Exception {

    AdGroupServiceSample.cleanup(valuesHolder);
  }

  /**
   * create basic AdGroupAd.
   *
   * @return valuesHolder ValuesHolder
   * @throws Exception
   */
  public static ValuesHolder create() throws Exception {

    ValuesHolder parentValuesHolder = setup();
    ValuesRepositoryFacade parentValuesRepositoryFacade = new ValuesRepositoryFacade(parentValuesHolder);

    long accountId = SoapUtils.getAccountId();
    Long campaignId = parentValuesRepositoryFacade.getCampaignValuesRepository().findCampaignId(CampaignType.STANDARD);
    Long adGroupId = parentValuesRepositoryFacade.getAdGroupValuesRepository().findAdGroupId(campaignId);

    // create request.
    AdGroupAdOperation addRequest = buildExampleMutateRequest( //
        Operator.ADD, accountId, Collections.singletonList(createExampleExtendedTextAd(campaignId, adGroupId)) //
    );

    // run
    List<AdGroupAdValues> addResponse = mutate(addRequest);

    ValuesHolder seflValuesHolder = new ValuesHolder();
    seflValuesHolder.setBiddingStrategyValuesList(parentValuesHolder.getBiddingStrategyValuesList());
    seflValuesHolder.setFeedFolderValuesList(parentValuesHolder.getFeedFolderValuesList());
    seflValuesHolder.setCampaignValuesList(parentValuesHolder.getCampaignValuesList());
    seflValuesHolder.setAdGroupValuesList(parentValuesHolder.getAdGroupValuesList());
    seflValuesHolder.setAdGroupAdValuesList(addResponse);

    return seflValuesHolder;
  }

}

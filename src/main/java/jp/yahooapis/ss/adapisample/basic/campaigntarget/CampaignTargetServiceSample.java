/**
 * Copyright (C) 2019 Yahoo Japan Corporation. All Rights Reserved.
 */
package jp.yahooapis.ss.adapisample.basic.campaigntarget;

import jp.yahooapis.ss.adapisample.basic.campaign.CampaignServiceSample;
import jp.yahooapis.ss.adapisample.repository.ValuesRepositoryFacade;
import jp.yahooapis.ss.adapisample.util.SoapUtils;
import jp.yahooapis.ss.adapisample.util.ValuesHolder;
import jp.yahooapis.ss.v201909.Error;
import jp.yahooapis.ss.v201909.Paging;
import jp.yahooapis.ss.v201909.campaign.CampaignType;
import jp.yahooapis.ss.v201909.campaigntarget.CampaignTarget;
import jp.yahooapis.ss.v201909.campaigntarget.CampaignTargetOperation;
import jp.yahooapis.ss.v201909.campaigntarget.CampaignTargetPage;
import jp.yahooapis.ss.v201909.campaigntarget.CampaignTargetReturnValue;
import jp.yahooapis.ss.v201909.campaigntarget.CampaignTargetSelector;
import jp.yahooapis.ss.v201909.campaigntarget.CampaignTargetService;
import jp.yahooapis.ss.v201909.campaigntarget.CampaignTargetServiceInterface;
import jp.yahooapis.ss.v201909.campaigntarget.CampaignTargetValues;
import jp.yahooapis.ss.v201909.campaigntarget.DayOfWeek;
import jp.yahooapis.ss.v201909.campaigntarget.ExcludedType;
import jp.yahooapis.ss.v201909.campaigntarget.LocationTarget;
import jp.yahooapis.ss.v201909.campaigntarget.MinuteOfHour;
import jp.yahooapis.ss.v201909.campaigntarget.NetworkCoverageType;
import jp.yahooapis.ss.v201909.campaigntarget.NetworkTarget;
import jp.yahooapis.ss.v201909.campaigntarget.Operator;
import jp.yahooapis.ss.v201909.campaigntarget.PlatformTarget;
import jp.yahooapis.ss.v201909.campaigntarget.PlatformType;
import jp.yahooapis.ss.v201909.campaigntarget.ScheduleTarget;
import jp.yahooapis.ss.v201909.campaigntarget.TargetType;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.xml.ws.Holder;

/**
 * example CampaignTargetService operation and Utility method collection.
 */
public class CampaignTargetServiceSample {

  /**
   * main method for CampaignTargetServiceSample
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
      // CampaignTargetService::ADD
      // =================================================================
      // create request.
      CampaignTargetOperation addCampaignTargetOperation = buildExampleMutateRequest(Operator.ADD, accountId, new ArrayList<CampaignTarget>() {{
        // Schedule Target
        add(createExampleScheduleTarget(accountId, campaignId));
        // Location Target
        add(createExampleLocationTarget(accountId, campaignId));
        // Network Target
        add(createExampleNetworkTarget(accountId, campaignId));
      }});

      // run
      List<CampaignTargetValues> addCampaignTargetValues = mutate(addCampaignTargetOperation);

      List<CampaignTarget> campaignTargets = new ArrayList<>();
      for (CampaignTargetValues campaignTargetValues: addCampaignTargetValues) {
        campaignTargets.add(campaignTargetValues.getCampaignTarget());
      }

      // =================================================================
      // CampaignTargetService::SET
      // =================================================================
      // create request.
      CampaignTargetOperation setCampaignTargetOperation = buildExampleMutateRequest(Operator.SET, accountId, createExampleSetRequest(campaignTargets));

      // run
      mutate(setCampaignTargetOperation);

      // =================================================================
      // CampaignTargetService::GET
      // =================================================================
      // create request.
      CampaignTargetSelector campaignTargetSelector = buildExampleGetRequest(accountId, campaignTargets);

      // run
      get(campaignTargetSelector);

      // =================================================================
      // CampaignTargetService::REMOVE
      // =================================================================
      // create request.
      CampaignTargetOperation removeCampaignTargetOperation = buildExampleMutateRequest(Operator.REMOVE, accountId, campaignTargets);

      // run
      mutate(removeCampaignTargetOperation);

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
  public static CampaignTargetOperation buildExampleMutateRequest(Operator operator, long accountId, List<CampaignTarget> operand) {
    CampaignTargetOperation operation = new CampaignTargetOperation();
    operation.setOperator(operator);
    operation.setAccountId(accountId);
    operation.getOperand().addAll(operand);

    return operation;
  }

  /**
   * example Schedule Target request.
   *
   * @param accountId long
   * @param campaignId long
   * @return CampaignTarget
   */
  public static CampaignTarget createExampleScheduleTarget(long accountId, long campaignId) {

    // target
    ScheduleTarget scheduleTarget = new ScheduleTarget();
    scheduleTarget.setTargetType(TargetType.SCHEDULE);
    scheduleTarget.setDayOfWeek(DayOfWeek.MONDAY);
    scheduleTarget.setStartHour(10);
    scheduleTarget.setStartMinute(MinuteOfHour.ZERO);
    scheduleTarget.setEndHour(11);
    scheduleTarget.setEndMinute(MinuteOfHour.ZERO);

    CampaignTarget campaignTarget = new CampaignTarget();
    campaignTarget.setAccountId(accountId);
    campaignTarget.setCampaignId(campaignId);
    campaignTarget.setBidMultiplier(1.0);
    campaignTarget.setTarget(scheduleTarget);

    return campaignTarget;
  }

  /**
   * example Location Target request.
   *
   * @param accountId long
   * @param campaignId long
   * @return CampaignTarget
   */
  public static CampaignTarget createExampleLocationTarget(long accountId, long campaignId) {

    // target
    LocationTarget locationTarget = new LocationTarget();
    locationTarget.setTargetType(TargetType.LOCATION);
    locationTarget.setTargetId("JP-13-0048");
    locationTarget.setExcludedType(ExcludedType.INCLUDED);

    CampaignTarget campaignTarget = new CampaignTarget();
    campaignTarget.setAccountId(accountId);
    campaignTarget.setCampaignId(campaignId);
    campaignTarget.setBidMultiplier(0.95);
    campaignTarget.setTarget(locationTarget);

    return campaignTarget;
  }

  /**
   * example Network Target request.
   *
   * @param accountId long
   * @param campaignId long
   * @return CampaignTarget
   */
  public static CampaignTarget createExampleNetworkTarget(long accountId, long campaignId) {

    // target
    NetworkTarget networkTarget = new NetworkTarget();
    networkTarget.setTargetType(TargetType.NETWORK);
    networkTarget.setNetworkCoverageType(NetworkCoverageType.YAHOO_SEARCH);

    CampaignTarget campaignTarget = new CampaignTarget();
    campaignTarget.setAccountId(accountId);
    campaignTarget.setCampaignId(campaignId);
    campaignTarget.setTarget(networkTarget);

    return campaignTarget;
  }

  /**
   * example mutate campaignTargets.
   *
   * @param operation CampaignTargetOperation
   * @return CampaignTargetValues
   */
  public static List<CampaignTargetValues> mutate(CampaignTargetOperation operation) throws Exception {

    // Call API
    System.out.println("############################################");
    System.out.println("CampaignTargetService::mutate(" + operation.getOperator() + ")");
    System.out.println("############################################");

    Holder<CampaignTargetReturnValue> campaignTargetReturnValueHolder = new Holder<CampaignTargetReturnValue>();
    Holder<List<Error>> errorHolder = new Holder<List<Error>>();
    CampaignTargetServiceInterface campaignService = SoapUtils.createServiceInterface(CampaignTargetServiceInterface.class, CampaignTargetService.class);
    campaignService.mutate(operation, campaignTargetReturnValueHolder, errorHolder);

    SoapUtils.checkSoapError(errorHolder, campaignTargetReturnValueHolder.value.getValues());

    // Response
    return campaignTargetReturnValueHolder.value.getValues();
  }

  /**
   * example campaigns set request.
   *
   * @param campaignTargets
   * @return List<CampaignTarget>
   */
  public static List<CampaignTarget> createExampleSetRequest(List<CampaignTarget> campaignTargets) {
    // create operands
    List<CampaignTarget> operands = new ArrayList<>();

    for (CampaignTarget campaignTarget : campaignTargets) {
      // set target
      switch (campaignTarget.getTarget().getTargetType()) {
        case SCHEDULE:
          ScheduleTarget scheduleTarget = new ScheduleTarget();
          scheduleTarget.setTargetType(campaignTarget.getTarget().getTargetType());
          scheduleTarget.setTargetId(campaignTarget.getTarget().getTargetId());

          CampaignTarget scheduleOperand = new CampaignTarget();
          scheduleOperand.setAccountId(campaignTarget.getAccountId());
          scheduleOperand.setCampaignId(campaignTarget.getCampaignId());
          scheduleOperand.setBidMultiplier(0.5);
          scheduleOperand.setTarget(scheduleTarget);

          operands.add(scheduleOperand);
          break;

        case LOCATION:
          LocationTarget locationTarget = new LocationTarget();
          locationTarget.setTargetType(campaignTarget.getTarget().getTargetType());
          locationTarget.setTargetId(campaignTarget.getTarget().getTargetId());

          CampaignTarget locationOperand = new CampaignTarget();
          locationOperand.setAccountId(campaignTarget.getAccountId());
          locationOperand.setCampaignId(campaignTarget.getCampaignId());
          locationOperand.setBidMultiplier(0.5);
          locationOperand.setTarget(locationTarget);

          operands.add(locationOperand);
          break;

        default:
          break;
      }
    }

    // set PlatformTarget for SMART_PHONE
    PlatformTarget smartPhone = new PlatformTarget();
    smartPhone.setTargetType(TargetType.PLATFORM);
    smartPhone.setPlatformType(PlatformType.SMART_PHONE);

    CampaignTarget smartPhoneOprand = new CampaignTarget();
    smartPhoneOprand.setAccountId(campaignTargets.get(0).getAccountId());
    smartPhoneOprand.setCampaignId(campaignTargets.get(0).getCampaignId());
    smartPhoneOprand.setBidMultiplier(0.1);
    smartPhoneOprand.setTarget(smartPhone);

    operands.add(smartPhoneOprand);

    // set PlatformTarget for TABLET
    PlatformTarget tablet = new PlatformTarget();
    tablet.setTargetType(TargetType.PLATFORM);
    tablet.setPlatformType(PlatformType.TABLET);

    CampaignTarget tabletOperand = new CampaignTarget();
    tabletOperand.setAccountId(campaignTargets.get(0).getAccountId());
    tabletOperand.setCampaignId(campaignTargets.get(0).getCampaignId());
    tabletOperand.setBidMultiplier(0.1);
    tabletOperand.setTarget(tablet);

    operands.add(tabletOperand);

    // set PlatformTarget for DESKTOP
    PlatformTarget desktop = new PlatformTarget();
    desktop.setTargetType(TargetType.PLATFORM);
    desktop.setPlatformType(PlatformType.DESKTOP);

    CampaignTarget desktopOperand = new CampaignTarget();
    desktopOperand.setAccountId(campaignTargets.get(0).getAccountId());
    desktopOperand.setCampaignId(campaignTargets.get(0).getCampaignId());
    desktopOperand.setBidMultiplier(0.1);
    desktopOperand.setTarget(desktop);

    operands.add(desktopOperand);

    return operands;
  }

  /**
   * Sample Program for CampaignTargetService GET.
   *
   * @param selector CampaignTargetSelector
   * @return CampaignTargetValues
   */
  public static List<CampaignTargetValues> get(CampaignTargetSelector selector) throws Exception {

    // Call API
    System.out.println("############################################");
    System.out.println("CampaignTargetService::get");
    System.out.println("############################################");

    Holder<CampaignTargetPage> campaignTargetPageHolder = new Holder<CampaignTargetPage>();
    Holder<List<Error>> errorHolder = new Holder<List<Error>>();
    CampaignTargetServiceInterface campaignTargetService = SoapUtils.createServiceInterface(CampaignTargetServiceInterface.class, CampaignTargetService.class);
    campaignTargetService.get(selector, campaignTargetPageHolder, errorHolder);

    SoapUtils.checkSoapError(errorHolder, campaignTargetPageHolder.value.getValues());

    // Response
    return campaignTargetPageHolder.value.getValues();
  }

  /**
   * example get request.
   *
   * @param accountId long
   * @param campaignTargets CampaignTarget
   * @return CampaignTargetSelector
   */
  public static CampaignTargetSelector buildExampleGetRequest(long accountId, List<CampaignTarget> campaignTargets) {
    // Set Selector
    CampaignTargetSelector selector = new CampaignTargetSelector();
    selector.setAccountId(accountId);

    for (CampaignTarget campaignTarget : campaignTargets) {
      selector.getCampaignIds().add(campaignTarget.getCampaignId());
      selector.getTargetIds().add(campaignTarget.getTarget().getTargetId());
    }

    selector.getTargetTypes().addAll(Arrays.asList(//
        TargetType.LOCATION, //
        TargetType.SCHEDULE, //
        TargetType.NETWORK, //
        TargetType.PLATFORM //
    ));
    selector.setExcludedType(ExcludedType.INCLUDED);
    selector.getPlatformTypes().addAll(Arrays.asList( //
        PlatformType.SMART_PHONE, //
        PlatformType.TABLET, //
        PlatformType.DESKTOP //
    ));

    // Set Paging
    Paging paging = new Paging();
    paging.setStartIndex(1);
    paging.setNumberResults(20);
    selector.setPaging(paging);

    return selector;
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
   * @param valuesHolder ValuesHolder
   * @throws Exception
   */
  public static void cleanup(ValuesHolder valuesHolder) throws Exception {
    CampaignServiceSample.cleanup(valuesHolder);
  }

}

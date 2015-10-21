package jp.co.yahoo.ad_api_sample.adSample;

import java.util.Arrays;
import java.util.List;

import javax.xml.ws.Holder;

import jp.co.yahoo.ad_api_sample.error.impl.CampaignTargetServiceErrorEntityFactory;
import jp.co.yahoo.ad_api_sample.util.SoapUtils;
import jp.yahooapis.ss.V5.CampaignTargetService.CampaignTarget;
import jp.yahooapis.ss.V5.CampaignTargetService.CampaignTargetOperation;
import jp.yahooapis.ss.V5.CampaignTargetService.CampaignTargetPage;
import jp.yahooapis.ss.V5.CampaignTargetService.CampaignTargetReturnValue;
import jp.yahooapis.ss.V5.CampaignTargetService.CampaignTargetSelector;
import jp.yahooapis.ss.V5.CampaignTargetService.CampaignTargetService;
import jp.yahooapis.ss.V5.CampaignTargetService.CampaignTargetServiceInterface;
import jp.yahooapis.ss.V5.CampaignTargetService.CampaignTargetValues;
import jp.yahooapis.ss.V5.CampaignTargetService.DayOfWeek;
import jp.yahooapis.ss.V5.CampaignTargetService.Error;
import jp.yahooapis.ss.V5.CampaignTargetService.ExcludedType;
import jp.yahooapis.ss.V5.CampaignTargetService.LocationTarget;
import jp.yahooapis.ss.V5.CampaignTargetService.MinuteOfHour;
import jp.yahooapis.ss.V5.CampaignTargetService.NetworkCoverageType;
import jp.yahooapis.ss.V5.CampaignTargetService.NetworkTarget;
import jp.yahooapis.ss.V5.CampaignTargetService.Operator;
import jp.yahooapis.ss.V5.CampaignTargetService.Paging;
import jp.yahooapis.ss.V5.CampaignTargetService.PlatformTarget;
import jp.yahooapis.ss.V5.CampaignTargetService.ScheduleTarget;
import jp.yahooapis.ss.V5.CampaignTargetService.TargetType;

/**
 * Sample Program for CampaignTargetService. Copyright (C) 2012 Yahoo Japan Corporation. All Rights
 * Reserved.
 */
public class CampaignTargetServiceSample {

  /**
   * main method for CampaignTargetServiceSample
   *
   * @param args command line arguments
   */
  public static void main(String[] args) throws Exception {
    try {
      // =================================================================
      // Setting
      // =================================================================
      long accountId = SoapUtils.getAccountId();
      long campaignId = SoapUtils.getCampaignId();
      long appCampaignId = SoapUtils.getAppCampaignId();

      // =================================================================
      // CampaignTargetService::ADD
      // =================================================================
      // Set Operation
      CampaignTargetOperation addCampaignTargetOperation = createSampleAddRequest(accountId, campaignId, appCampaignId);

      // Run
      List<CampaignTargetValues> campaignTargetValues = add(addCampaignTargetOperation);

      // =================================================================
      // CampaignTargetService::GET
      // =================================================================
      // Set Selector
      CampaignTargetSelector campaignTargetSelector = createSampleGetRequest(accountId, campaignTargetValues);

      // Run
      get(campaignTargetSelector);

      // =================================================================
      // CampaignTargetService::SET
      // =================================================================
      // Set Operation
      CampaignTargetOperation setCampaignTargetOperation = createSampleSetRequest(accountId, campaignTargetValues);

      // Run
      set(setCampaignTargetOperation);

      // =================================================================
      // CampaignTargetService::REMOVE
      // =================================================================
      // Set Operation
      CampaignTargetOperation removeCampaignTargetOperation = createSampleRemoveRequest(accountId, campaignTargetValues);

      // Run
      remove(removeCampaignTargetOperation);

    } catch (Exception e) {
      e.printStackTrace();
      throw e;
    }
  }

  /**
   * Sample Program for CampaignTargetService ADD.
   *
   * @param operation CampaignTargetOperation
   * @return CampaignTargetValues
   * @throws Exception
   */
  public static List<CampaignTargetValues> add(CampaignTargetOperation operation) throws Exception {

    // Call API
    System.out.println("############################################");
    System.out.println("CampaignTargetService::mutate(ADD)");
    System.out.println("############################################");

    Holder<CampaignTargetReturnValue> campaignTargetReturnValueHolder = new Holder<CampaignTargetReturnValue>();
    Holder<List<Error>> errorHolder = new Holder<List<Error>>();
    CampaignTargetServiceInterface campaignTargetService = SoapUtils.createServiceInterface(CampaignTargetServiceInterface.class, CampaignTargetService.class);
    campaignTargetService.mutate(operation, campaignTargetReturnValueHolder, errorHolder);

    // Error
    if (errorHolder.value != null && errorHolder.value.size() > 0) {
      SoapUtils.displayErrors(new CampaignTargetServiceErrorEntityFactory(errorHolder.value), true);
    }
    if (campaignTargetReturnValueHolder.value == null) {
      throw new Exception("NoDataResponse:CampaignTargetService Add");
    }

    // Display
    for (CampaignTargetValues campaignTargetValues : campaignTargetReturnValueHolder.value.getValues()) {
      if (campaignTargetValues.isOperationSucceeded()) {
        display(campaignTargetValues.getCampaignTarget());
      } else {
        SoapUtils.displayErrors(new CampaignTargetServiceErrorEntityFactory(campaignTargetValues.getError()), true);
      }
    }

    // Response
    return campaignTargetReturnValueHolder.value.getValues();
  }

  /**
   * Sample Program for CampaignTargetService SET.
   *
   * @param operation CampaignTargetOperation
   * @return CampaignTargetValues
   * @throws Exception
   */
  public static List<CampaignTargetValues> set(CampaignTargetOperation operation) throws Exception {

    // Call API
    System.out.println("############################################");
    System.out.println("CampaignTargetService::mutate(SET)");
    System.out.println("############################################");

    Holder<CampaignTargetReturnValue> campaignTargetReturnValueHolder = new Holder<CampaignTargetReturnValue>();
    Holder<List<Error>> errorHolder = new Holder<List<Error>>();
    CampaignTargetServiceInterface campaignTargetService = SoapUtils.createServiceInterface(CampaignTargetServiceInterface.class, CampaignTargetService.class);
    campaignTargetService.mutate(operation, campaignTargetReturnValueHolder, errorHolder);

    // Error
    if (errorHolder.value != null && errorHolder.value.size() > 0) {
      SoapUtils.displayErrors(new CampaignTargetServiceErrorEntityFactory(errorHolder.value), true);
    }
    if (campaignTargetReturnValueHolder.value == null) {
      throw new Exception("NoDataResponse:CampaignTargetService Set");
    }

    // Display
    for (CampaignTargetValues campaignTargetValues : campaignTargetReturnValueHolder.value.getValues()) {
      if (campaignTargetValues.isOperationSucceeded()) {
        display(campaignTargetValues.getCampaignTarget());
      } else {
        SoapUtils.displayErrors(new CampaignTargetServiceErrorEntityFactory(campaignTargetValues.getError()), true);
      }
    }

    // Response
    return campaignTargetReturnValueHolder.value.getValues();
  }

  /**
   * Sample Program for CampaignTargetService REMOVE.
   *
   * @param operation CampaignTargetOperation
   * @return CampaignTargetValues
   * @throws Exception
   */
  public static List<CampaignTargetValues> remove(CampaignTargetOperation operation) throws Exception {

    // Call API
    System.out.println("############################################");
    System.out.println("CampaignTargetService::mutate(REMOVE)");
    System.out.println("############################################");

    Holder<CampaignTargetReturnValue> campaignTargetReturnValueHolder = new Holder<CampaignTargetReturnValue>();
    Holder<List<Error>> errorHolder = new Holder<List<Error>>();
    CampaignTargetServiceInterface campaignTargetService = SoapUtils.createServiceInterface(CampaignTargetServiceInterface.class, CampaignTargetService.class);

    campaignTargetService.mutate(operation, campaignTargetReturnValueHolder, errorHolder);
    // Error
    if (errorHolder.value != null && errorHolder.value.size() > 0) {
      SoapUtils.displayErrors(new CampaignTargetServiceErrorEntityFactory(errorHolder.value), true);
    }
    if (campaignTargetReturnValueHolder.value == null) {
      throw new Exception("NoDataResponse:CampaignTargetService Remove");
    }

    // Display
    for (CampaignTargetValues campaignTargetValues : campaignTargetReturnValueHolder.value.getValues()) {
      if (campaignTargetValues.isOperationSucceeded()) {
        display(campaignTargetValues.getCampaignTarget());
      } else {
        SoapUtils.displayErrors(new CampaignTargetServiceErrorEntityFactory(campaignTargetValues.getError()), true);
      }
    }

    // Response
    return campaignTargetReturnValueHolder.value.getValues();
  }

  /**
   * Sample Program for CampaignTargetService GET.
   *
   * @param selector CampaignTargetSelector
   * @return CampaignTargetValues
   * @throws Exception
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

    // Error
    if (errorHolder.value != null && errorHolder.value.size() > 0) {
      SoapUtils.displayErrors(new CampaignTargetServiceErrorEntityFactory(errorHolder.value), true);
    }
    if (campaignTargetPageHolder.value == null) {
      throw new Exception("NoDataResponse:CampaignTargetService Get");
    }

    // Display
    for (CampaignTargetValues campaignTargetValues : campaignTargetPageHolder.value.getValues()) {
      if (campaignTargetValues.isOperationSucceeded()) {
        display(campaignTargetValues.getCampaignTarget());
      } else {
        SoapUtils.displayErrors(new CampaignTargetServiceErrorEntityFactory(campaignTargetValues.getError()), true);
      }
    }

    // Response
    return campaignTargetPageHolder.value.getValues();
  }

  /**
   * display CampaignTarget entity to stdout.
   *
   * @param campaignTarget CampaignTarget entity for display.
   */
  public static void display(CampaignTarget campaignTarget) {

    System.out.println("accountId = " + campaignTarget.getAccountId());
    System.out.println("campaignId = " + campaignTarget.getCampaignId());
    if (campaignTarget.getTarget() != null) {
      System.out.println("campaignTarget---------");
      System.out.println("campaignTarget/accountId = " + campaignTarget.getAccountId());
      System.out.println("campaignTarget/campaignId = " + campaignTarget.getCampaignId());
      System.out.println("campaignTarget/campaignName = " + campaignTarget.getCampaignName());
      System.out.println("campaignTarget/bidMultiplier = " + campaignTarget.getBidMultiplier());
      System.out.println("campaignTarget/target/targetType = " + campaignTarget.getTarget().getTargetType());
      System.out.println("campaignTarget/target/targetId = " + campaignTarget.getTarget().getTargetId());
      if (campaignTarget.getTarget() instanceof ScheduleTarget) {
        ScheduleTarget scheduleTarget = (ScheduleTarget) campaignTarget.getTarget();
        System.out.println("target(ScheduleTarget)---------");
        System.out.println("target(ScheduleTarget)/dayOfWeek = " + scheduleTarget.getDayOfWeek());
        System.out.println("target(ScheduleTarget)/startHour = " + scheduleTarget.getStartHour());
        System.out.println("target(ScheduleTarget)/startMinute = " + scheduleTarget.getStartMinute());
        System.out.println("target(ScheduleTarget)/endHour = " + scheduleTarget.getEndHour());
        System.out.println("target(ScheduleTarget)/endMinute = " + scheduleTarget.getEndMinute());
      } else if (campaignTarget.getTarget() instanceof LocationTarget) {
        LocationTarget locationTarget = (LocationTarget) campaignTarget.getTarget();
        System.out.println("target(LocationTarget)---------");
        System.out.println("target(LocationTarget)/excludedType = " + locationTarget.getExcludedType());
      } else if (campaignTarget.getTarget() instanceof NetworkTarget) {
        NetworkTarget networkTarget = (NetworkTarget) campaignTarget.getTarget();
        System.out.println("target(NetworkTarget)---------");
        System.out.println("target(NetworkTarget)/networkCoverageType = " + networkTarget.getNetworkCoverageType());
      } else if (campaignTarget.getTarget() instanceof PlatformTarget) {
        PlatformTarget platformTarget = (PlatformTarget) campaignTarget.getTarget();
        System.out.println("target(PlatformTarget)---------");
        System.out.println("target(PlatformTarget)/platformType = " + platformTarget.getPlatformType());
      }
    }
    System.out.println("---------");
  }

  /**
   * create sample request.
   *
   * @param accountId long
   * @param campaignId long
   * @param appCampaignId long
   * @return CampaignTargetOperation
   */
  public static CampaignTargetOperation createSampleAddRequest(long accountId, long campaignId, long appCampaignId) {
    // Set Operation
    CampaignTargetOperation operation = new CampaignTargetOperation();
    operation.setAccountId(accountId);
    operation.setOperator(Operator.ADD);

    for (long targetCampaignId : Arrays.asList(campaignId, appCampaignId)) {
      // Set ScheduleTarget
      ScheduleTarget scheduleTarget = new ScheduleTarget();
      scheduleTarget.setTargetType(TargetType.SCHEDULE);
      scheduleTarget.setDayOfWeek(DayOfWeek.MONDAY);
      scheduleTarget.setStartHour(10);
      scheduleTarget.setStartMinute(MinuteOfHour.ZERO);
      scheduleTarget.setEndHour(11);
      scheduleTarget.setEndMinute(MinuteOfHour.THIRTY);

      CampaignTarget campaignScheduleTarget = new CampaignTarget();
      campaignScheduleTarget.setAccountId(accountId);
      campaignScheduleTarget.setCampaignId(targetCampaignId);
      campaignScheduleTarget.setTarget(scheduleTarget);
      campaignScheduleTarget.setBidMultiplier(1.0);

      // Set LocationTarget
      LocationTarget locationTarget = new LocationTarget();
      locationTarget.setTargetId("JP-13-0048");
      locationTarget.setTargetType(TargetType.LOCATION);
      locationTarget.setExcludedType(ExcludedType.INCLUDED);

      CampaignTarget campaignLocationTarget = new CampaignTarget();
      campaignLocationTarget.setAccountId(accountId);
      campaignLocationTarget.setCampaignId(targetCampaignId);
      campaignLocationTarget.setTarget(locationTarget);
      campaignLocationTarget.setBidMultiplier(0.95);

      // Set NetworkTarget
      NetworkTarget networkTarget = new NetworkTarget();
      networkTarget.setTargetType(TargetType.NETWORK);
      networkTarget.setNetworkCoverageType(NetworkCoverageType.YAHOO_SEARCH);

      CampaignTarget campaignNetworkTarget = new CampaignTarget();
      campaignNetworkTarget.setAccountId(accountId);
      campaignNetworkTarget.setCampaignId(targetCampaignId);
      campaignNetworkTarget.setTarget(networkTarget);

      operation.getOperand().addAll(Arrays.asList(campaignScheduleTarget, campaignLocationTarget, campaignNetworkTarget));
    }

    return operation;
  }

  /**
   * create sample request.
   *
   * @param accountId long
   * @param campaignTargetValues CampaignTargetValues
   * @return CampaignTargetOperation
   */
  public static CampaignTargetOperation createSampleSetRequest(long accountId, List<CampaignTargetValues> campaignTargetValues) {
    // Set Operation
    CampaignTargetOperation operation = new CampaignTargetOperation();
    operation.setOperator(Operator.SET);
    operation.setAccountId(accountId);

    // Set Operand
    for (CampaignTargetValues campaignTargetValue : campaignTargetValues) {

      CampaignTarget campaignTarget = new CampaignTarget();

      campaignTarget.setAccountId(campaignTargetValue.getCampaignTarget().getAccountId());
      campaignTarget.setCampaignId(campaignTargetValue.getCampaignTarget().getCampaignId());

      // Set Target
      if (TargetType.SCHEDULE.equals(campaignTargetValue.getCampaignTarget().getTarget().getTargetType())) {

        // Set ScheduleTarget
        ScheduleTarget scheduleTarget = new ScheduleTarget();
        scheduleTarget.setTargetId(campaignTargetValue.getCampaignTarget().getTarget().getTargetId());
        scheduleTarget.setTargetType(TargetType.SCHEDULE);

        campaignTarget.setTarget(scheduleTarget);
        campaignTarget.setBidMultiplier(0.5);

      } else if (TargetType.LOCATION.equals(campaignTargetValue.getCampaignTarget().getTarget().getTargetType())) {

        // Set LocationTarget
        LocationTarget locationTarget = new LocationTarget();
        locationTarget.setTargetId(campaignTargetValue.getCampaignTarget().getTarget().getTargetId());
        locationTarget.setTargetType(TargetType.LOCATION);

        campaignTarget.setTarget(locationTarget);
        campaignTarget.setBidMultiplier(0.5);

      } else if (TargetType.PLATFORM.equals(campaignTargetValue.getCampaignTarget().getTarget().getTargetType())) {

        // Set PlatformTarget
        PlatformTarget platformTarget = new PlatformTarget();
        platformTarget.setTargetId(campaignTargetValue.getCampaignTarget().getTarget().getTargetId());
        platformTarget.setTargetType(TargetType.PLATFORM);

        campaignTarget.setTarget(platformTarget);

      } else if (TargetType.NETWORK.equals(campaignTargetValue.getCampaignTarget().getTarget().getTargetType())) {
        // Can not update NetworkTarget
        campaignTarget = null;
      }

      if (campaignTarget != null) {
        operation.getOperand().add(campaignTarget);
      }
    }

    return operation;
  }

  /**
   * create sample request.
   *
   * @param accountId long
   * @param campaignTargetValues CampaignTargetValues
   * @return CampaignTargetOperation
   */
  public static CampaignTargetOperation createSampleRemoveRequest(long accountId, List<CampaignTargetValues> campaignTargetValues) {
    // Set Operation
    CampaignTargetOperation operation = new CampaignTargetOperation();
    operation.setOperator(Operator.REMOVE);
    operation.setAccountId(accountId);

    // Set Operand
    for (CampaignTargetValues campaignTargetValue : campaignTargetValues) {

      CampaignTarget campaignTarget = new CampaignTarget();

      campaignTarget.setAccountId(campaignTargetValue.getCampaignTarget().getAccountId());
      campaignTarget.setCampaignId(campaignTargetValue.getCampaignTarget().getCampaignId());

      // Set Target
      if (TargetType.SCHEDULE.equals(campaignTargetValue.getCampaignTarget().getTarget().getTargetType())) {

        // Set ScheduleTarget
        ScheduleTarget scheduleTarget = new ScheduleTarget();
        scheduleTarget.setTargetId(campaignTargetValue.getCampaignTarget().getTarget().getTargetId());
        scheduleTarget.setTargetType(TargetType.SCHEDULE);

        campaignTarget.setTarget(scheduleTarget);

      } else if (TargetType.LOCATION.equals(campaignTargetValue.getCampaignTarget().getTarget().getTargetType())) {

        // Set LocationTarget
        LocationTarget locationTarget = new LocationTarget();
        locationTarget.setTargetId(campaignTargetValue.getCampaignTarget().getTarget().getTargetId());
        locationTarget.setTargetType(TargetType.LOCATION);

        campaignTarget.setTarget(locationTarget);

      } else if (TargetType.PLATFORM.equals(campaignTargetValue.getCampaignTarget().getTarget().getTargetType())) {

        // Set PlatformTarget
        PlatformTarget platformTarget = new PlatformTarget();
        platformTarget.setTargetId(campaignTargetValue.getCampaignTarget().getTarget().getTargetId());
        platformTarget.setTargetType(TargetType.PLATFORM);

        campaignTarget.setTarget(platformTarget);

      } else if (TargetType.NETWORK.equals(campaignTargetValue.getCampaignTarget().getTarget().getTargetType())) {

        // Set NetworkTarget
        NetworkTarget removeNetworkTarget = new NetworkTarget();
        removeNetworkTarget.setTargetId(campaignTargetValue.getCampaignTarget().getTarget().getTargetId());
        removeNetworkTarget.setTargetType(TargetType.NETWORK);

        campaignTarget.setTarget(removeNetworkTarget);
      }

      operation.getOperand().add(campaignTarget);
    }

    return operation;
  }

  /**
   * create sample request.
   *
   * @param accountId long
   * @param campaignTargetValues CampaignTargetValues
   * @return CampaignTargetSelector
   */
  public static CampaignTargetSelector createSampleGetRequest(long accountId, List<CampaignTargetValues> campaignTargetValues) {
    // Set Selector
    CampaignTargetSelector selector = new CampaignTargetSelector();
    selector.setAccountId(accountId);
    for (CampaignTargetValues campaignTargetValue : campaignTargetValues) {
      selector.getCampaignIds().add((campaignTargetValue.getCampaignTarget().getCampaignId()));
    }

    // Set Paging
    Paging paging = new Paging();
    paging.setStartIndex(1);
    paging.setNumberResults(20);
    selector.setPaging(paging);

    return selector;
  }
}

package jp.co.yahoo.ad_api_sample.adSample;

import jp.co.yahoo.ad_api_sample.error.impl.CampaignTargetServiceErrorEntityFactory;
import jp.co.yahoo.ad_api_sample.util.SoapUtils;
import jp.yahooapis.ss.v201805.campaign.CampaignOperation;
import jp.yahooapis.ss.v201805.campaign.CampaignSelector;
import jp.yahooapis.ss.v201805.campaign.CampaignValues;
import jp.yahooapis.ss.v201805.campaign.UrlApprovalStatus;
import jp.yahooapis.ss.v201805.campaigntarget.CampaignTarget;
import jp.yahooapis.ss.v201805.campaigntarget.CampaignTargetOperation;
import jp.yahooapis.ss.v201805.campaigntarget.CampaignTargetPage;
import jp.yahooapis.ss.v201805.campaigntarget.CampaignTargetReturnValue;
import jp.yahooapis.ss.v201805.campaigntarget.CampaignTargetSelector;
import jp.yahooapis.ss.v201805.campaigntarget.CampaignTargetService;
import jp.yahooapis.ss.v201805.campaigntarget.CampaignTargetServiceInterface;
import jp.yahooapis.ss.v201805.campaigntarget.CampaignTargetValues;
import jp.yahooapis.ss.v201805.campaigntarget.DayOfWeek;
import jp.yahooapis.ss.v201805.Error;
import jp.yahooapis.ss.v201805.campaigntarget.ExcludedType;
import jp.yahooapis.ss.v201805.campaigntarget.LocationTarget;
import jp.yahooapis.ss.v201805.campaigntarget.MinuteOfHour;
import jp.yahooapis.ss.v201805.campaigntarget.NetworkCoverageType;
import jp.yahooapis.ss.v201805.campaigntarget.NetworkTarget;
import jp.yahooapis.ss.v201805.campaigntarget.Operator;
import jp.yahooapis.ss.v201805.Paging;
import jp.yahooapis.ss.v201805.campaigntarget.PlatformTarget;
import jp.yahooapis.ss.v201805.campaigntarget.PlatformType;
import jp.yahooapis.ss.v201805.campaigntarget.ScheduleTarget;
import jp.yahooapis.ss.v201805.campaigntarget.TargetType;

import java.util.Arrays;
import java.util.List;

import javax.xml.ws.Holder;

/**
 * Sample Program for CampaignTargetService. Copyright (C) 2012 Yahoo Japan Corporation. All Rights
 * Reserved.
 */
public class CampaignTargetServiceSample {

  private long campaignId;
  private long appCampaignId;

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
      long biddingStrategyId = SoapUtils.getBiddingStrategyId();

      // =================================================================
      // CampaignTargetService::ADD
      // =================================================================
      CampaignOperation campaignOperation = CampaignServiceSample.createSampleAddRequest(accountId, biddingStrategyId);
      boolean allApproved = true;

      // Run
      List<CampaignValues> addCampaignValues = null;
      try {
        addCampaignValues = CampaignServiceSample.add(campaignOperation);

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
            } else if (UrlApprovalStatus.DISAPPROVED.equals(campaignValues.getCampaign().getUrlReviewData().getUrlApprovalStatus())) {
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
      } catch (Exception e) {
        throw e;
      }

      if(!allApproved){
        System.out.println("Error : The review did not end.");
        // =================================================================
        // CampaignService::REMOVE
        // =================================================================
        // Set Operation
        CampaignOperation removeCampaignOperation = CampaignServiceSample.createSampleRemoveRequest(accountId, addCampaignValues);
        // Run
        CampaignServiceSample.remove(removeCampaignOperation);

        System.exit(1);
      }

      // get AutoBidding CampaignId
      long campaignId = addCampaignValues.get(0).getCampaign().getCampaignId();
      // get App Campaign
      long appCampaignId = addCampaignValues.get(2).getCampaign().getCampaignId();

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

      // =================================================================
      // CampaignService::REMOVE
      // =================================================================
      // Set Operation
      CampaignOperation removeCampaignOperation = CampaignServiceSample.createSampleRemoveRequest(accountId, addCampaignValues);

      // Run
      CampaignServiceSample.remove(removeCampaignOperation);

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
   * @param accountId     long
   * @param campaignId    long
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
      scheduleTarget.setDayOfWeek(DayOfWeek.SATURDAY);
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
   * @param accountId            long
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
        scheduleTarget.setTargetType(TargetType.SCHEDULE);
        scheduleTarget.setTargetId(campaignTargetValue.getCampaignTarget().getTarget().getTargetId());
        campaignTarget.setTarget(scheduleTarget);
        campaignTarget.setBidMultiplier(0.5);

      } else if (TargetType.LOCATION.equals(campaignTargetValue.getCampaignTarget().getTarget().getTargetType())) {

        // Set LocationTarget
        LocationTarget locationTarget = new LocationTarget();
        locationTarget.setTargetType(TargetType.LOCATION);
        locationTarget.setTargetId(campaignTargetValue.getCampaignTarget().getTarget().getTargetId());
        campaignTarget.setTarget(locationTarget);
        campaignTarget.setBidMultiplier(0.5);

      } else if (TargetType.PLATFORM.equals(campaignTargetValue.getCampaignTarget().getTarget().getTargetType())) {

        PlatformTarget oldPlatformTarget = (PlatformTarget) campaignTargetValue.getCampaignTarget().getTarget();

        // Set PlatformTarget
        PlatformTarget platformTarget = new PlatformTarget();
        platformTarget.setTargetType(TargetType.PLATFORM);
        if (PlatformType.DESKTOP.equals(oldPlatformTarget.getPlatformType())) {

          platformTarget.setPlatformType(PlatformType.DESKTOP);
          campaignTarget.setBidMultiplier(0.3);
          campaignTarget.setTarget(platformTarget);

        } else if (PlatformType.TABLET.equals(oldPlatformTarget.getPlatformType())) {

          platformTarget.setPlatformType(PlatformType.TABLET);
          campaignTarget.setBidMultiplier(0.2);
          campaignTarget.setTarget(platformTarget);

        }
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
   * @param accountId            long
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
        scheduleTarget.setTargetType(TargetType.SCHEDULE);
        scheduleTarget.setTargetId(campaignTargetValue.getCampaignTarget().getTarget().getTargetId());
        campaignTarget.setTarget(scheduleTarget);

      } else if (TargetType.LOCATION.equals(campaignTargetValue.getCampaignTarget().getTarget().getTargetType())) {

        // Set LocationTarget
        LocationTarget locationTarget = new LocationTarget();
        locationTarget.setTargetType(TargetType.LOCATION);
        locationTarget.setTargetId(campaignTargetValue.getCampaignTarget().getTarget().getTargetId());
        campaignTarget.setTarget(locationTarget);

      } else if (TargetType.NETWORK.equals(campaignTargetValue.getCampaignTarget().getTarget().getTargetType())) {

        // Set NetworkTarget
        NetworkTarget removeNetworkTarget = new NetworkTarget();
        removeNetworkTarget.setTargetType(TargetType.NETWORK);
        removeNetworkTarget.setTargetId(campaignTargetValue.getCampaignTarget().getTarget().getTargetId());
        campaignTarget.setTarget(removeNetworkTarget);
      }

      operation.getOperand().add(campaignTarget);
    }

    return operation;
  }

  /**
   * create sample request.
   *
   * @param accountId            long
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

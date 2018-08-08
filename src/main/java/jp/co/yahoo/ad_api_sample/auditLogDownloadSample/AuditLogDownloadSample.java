package jp.co.yahoo.ad_api_sample.auditLogDownloadSample;


import jp.co.yahoo.ad_api_sample.error.impl.AuditLogServiceErrorEntityFactory;
import jp.co.yahoo.ad_api_sample.util.SoapUtils;
import jp.yahooapis.ss.v201808.auditlog.AuditLogEventType;
import jp.yahooapis.ss.v201808.auditlog.AuditLogJob;
import jp.yahooapis.ss.v201808.auditlog.AuditLogJobStatus;
import jp.yahooapis.ss.v201808.auditlog.AuditLogOperation;
import jp.yahooapis.ss.v201808.auditlog.AuditLogPage;
import jp.yahooapis.ss.v201808.auditlog.AuditLogReturnValue;
import jp.yahooapis.ss.v201808.auditlog.AuditLogSelector;
import jp.yahooapis.ss.v201808.auditlog.AuditLogService;
import jp.yahooapis.ss.v201808.auditlog.AuditLogServiceInterface;
import jp.yahooapis.ss.v201808.auditlog.AuditLogValues;
import jp.yahooapis.ss.v201808.auditlog.DateRange;
import jp.yahooapis.ss.v201808.Error;
import jp.yahooapis.ss.v201808.auditlog.EventSelector;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import javax.xml.ws.Holder;

/**
 * Sample Program for AuditLog Download.<br> Copyright (C) 2017 Yahoo Japan Corporation. All Rights
 * Reserved.
 */
public class AuditLogDownloadSample {

  /**
   * main method for AuditLogDownloadSample
   *
   * @param args command line arguments
   */
  public static void main(String[] args) {

    try {

      long accountId = SoapUtils.getAccountId();

      // -----------------------------------------------
      // AuditLogService::addJob
      // -----------------------------------------------
      // request
      DateRange dateRange = new DateRange();
      // It specifies the current month
      dateRange.setStartDate(DateTimeFormatter.ofPattern("yyyyMMddHHmmss").format(LocalDateTime.now().minusDays(7L)));
      dateRange.setEndDate(DateTimeFormatter.ofPattern("yyyyMMddHHmmss").format(LocalDateTime.now().plusDays(7L)));

      EventSelector eventSelector = new EventSelector();
      eventSelector.setEntityType("ALL");
      eventSelector.getEventTypes().add(AuditLogEventType.ALL);

      AuditLogJob auditLogJob = new AuditLogJob();
      auditLogJob.setDateRange(dateRange);
      auditLogJob.getEventSelector().add(eventSelector);

      AuditLogOperation operation = new AuditLogOperation();
      operation.setAccountId(accountId);
      operation.getOperand().add(auditLogJob);

      // call API
      List<AuditLogValues> addJobDownloadResponse = addJob(operation);

      // -----------------------------------------------
      // AuditLogService::get
      // -----------------------------------------------
      // request
      AuditLogSelector selector = new AuditLogSelector();
      selector.setAccountId(accountId);
      selector.getJobIds().add(addJobDownloadResponse.get(0).getJob().getJobId());

      // call API
      List<AuditLogValues> getResponse = get(selector);

      // =================================================================
      // download auditLog
      // =================================================================
      // filename
      String auditLogDownloadFileName = "AuditLogDownload_" + getResponse.get(0).getJob().getJobId() + ".csv";

      // execute
      downloadAuditLog(getResponse.get(0), auditLogDownloadFileName);


    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  /**
   * download auditLog.
   *
   * @param getResponse              AuditLogValues
   * @param auditLogDownloadFileName String
   */
  public static void downloadAuditLog(AuditLogValues getResponse, String auditLogDownloadFileName) throws Exception {

    // check status
    if (getResponse.getJob().getJobStatus() != null && auditLogDownloadFileName != null) {
      SoapUtils.download(getResponse.getJob().getDownloadUrl(), auditLogDownloadFileName);
    } else {
      System.out.println("AuditLogDownload job in process on long time. please wait.");
    }
  }

  /**
   * Sample Program for AuditLogDownloadService AddJob.
   *
   * @param operation AuditLogOperation
   * @return AuditLogValues
   */
  public static List<AuditLogValues> addJob(AuditLogOperation operation) throws Exception {

    // =================================================================
    // AuditLogService
    // =================================================================
    AuditLogServiceInterface auditLogService = SoapUtils.createServiceInterface(AuditLogServiceInterface.class, AuditLogService.class);

    // call API
    System.out.println("############################################");
    System.out.println("AuditLogService::addJob");
    System.out.println("############################################");

    Holder<AuditLogReturnValue> auditLogReturnValueHolder = new Holder<>();
    Holder<List<Error>> auditLogError = new Holder<List<Error>>();
    auditLogService.addJob(operation, auditLogReturnValueHolder, auditLogError);

    // Error
    if (auditLogError.value != null && auditLogError.value.size() > 0) {
      SoapUtils.displayErrors(new AuditLogServiceErrorEntityFactory(auditLogError.value), true);
    }
    if (auditLogReturnValueHolder.value == null) {
      throw new Exception("NoDataResponse:AuditLogService AddJob");
    }

    // Display
    for (AuditLogValues auditLogValues : auditLogReturnValueHolder.value.getValues()) {
      if (auditLogValues.isOperationSucceeded()) {
        display(auditLogValues.getJob());
      } else {
        SoapUtils.displayErrors(new AuditLogServiceErrorEntityFactory(auditLogValues.getError()), true);
      }
    }

    // Response
    return auditLogReturnValueHolder.value.getValues();
  }

  /**
   * Sample Program for AuditLogDownloadService get.
   *
   * @param selector AuditLogSelector
   * @return AuditLogValues
   */
  public static List<AuditLogValues> get(AuditLogSelector selector) throws Exception {

    // =================================================================
    // AuditLogService
    // =================================================================
    AuditLogServiceInterface auditLogService = SoapUtils.createServiceInterface(AuditLogServiceInterface.class, AuditLogService.class);

    // call 30sec sleep * 30 = 15minute
    Holder<AuditLogPage> auditLogPageHolder = null;

    for (int i = 0; i < 30; i++) {
      // sleep 30 second.
      System.out.println("\n***** sleep 30 seconds for AuditLog Download Job *****\n");
      Thread.sleep(30000);
      // call API
      System.out.println("############################################");
      System.out.println("AuditLogService::get");
      System.out.println("############################################");
      auditLogPageHolder = new Holder<AuditLogPage>();
      Holder<List<Error>> auditLogError = new Holder<List<Error>>();
      auditLogService.get(selector, auditLogPageHolder, auditLogError);

      // if error
      if (auditLogError.value != null && auditLogError.value.size() > 0) {
        SoapUtils.displayErrors(new AuditLogServiceErrorEntityFactory(auditLogError.value), true);
      }

      // response
      List<AuditLogValues> auditLogValues = auditLogPageHolder.value.getValues();
      if (auditLogValues.get(0).isOperationSucceeded()) {
        AuditLogJob auditLogJob = auditLogValues.get(0).getJob();

        // display response
        display(auditLogJob);

        if (auditLogJob.getJobStatus().equals(AuditLogJobStatus.COMPLETED)) {
          break;
        } else {
          if (auditLogJob.getJobStatus().equals(AuditLogJobStatus.IN_PROGRESS)) {
            continue;
          } else {
            System.out.println("Error : Job Status failed.");
            System.exit(0);
          }
        }

      } else {
        SoapUtils.displayErrors(new AuditLogServiceErrorEntityFactory(auditLogValues.get(0).getError()), true);
      }
    }

    // Response
    return auditLogPageHolder.value.getValues();
  }

  /**
   * display AuditLogJob entity to stdout.
   *
   * @param auditLogJob AuditLogJob entity for display.
   */
  private static void display(AuditLogJob auditLogJob) {
    System.out.println("accountId = " + auditLogJob.getAccountId());
    System.out.println("jobId = " + auditLogJob.getJobId());
    System.out.println("jobName = " + auditLogJob.getJobName());
    System.out.println("jobStatus = " + auditLogJob.getJobStatus());
    System.out.println("downloadUrl = " + auditLogJob.getDownloadUrl());

    if (!auditLogJob.getEventSelector().isEmpty()) {
      for (EventSelector eventSelector : auditLogJob.getEventSelector()) {
        System.out.println("eventSelector/entityType = " + eventSelector.getEntityType());
        if (!eventSelector.getEventTypes().isEmpty()) {
          for (AuditLogEventType eventType : eventSelector.getEventTypes()) {
            System.out.println("eventSelector/eventTypes = " + eventType.name());
          }
        }
      }
    }

    if (auditLogJob.getDateRange() != null) {
      System.out.println("dateRange/startDate = " + auditLogJob.getDateRange().getStartDate());
      System.out.println("dateRange/endDate = " + auditLogJob.getDateRange().getEndDate());
    }

    System.out.println("sourceType = " + auditLogJob.getSourceType().name());
    System.out.println("output = " + auditLogJob.getOutput().name());
    System.out.println("encoding = " + auditLogJob.getEncoding().name());
    System.out.println("lang = " + auditLogJob.getLang().name());

    System.out.println("---------");
  }

}

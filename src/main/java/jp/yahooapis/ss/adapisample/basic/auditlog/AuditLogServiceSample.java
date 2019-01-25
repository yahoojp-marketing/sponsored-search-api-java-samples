/**
 * Copyright (C) 2019 Yahoo Japan Corporation. All Rights Reserved.
 */
package jp.yahooapis.ss.adapisample.basic.auditlog;

import jp.yahooapis.ss.adapisample.util.SoapUtils;
import jp.yahooapis.ss.v201901.Error;
import jp.yahooapis.ss.v201901.auditlog.AuditLogEncoding;
import jp.yahooapis.ss.v201901.auditlog.AuditLogEventType;
import jp.yahooapis.ss.v201901.auditlog.AuditLogJob;
import jp.yahooapis.ss.v201901.auditlog.AuditLogJobStatus;
import jp.yahooapis.ss.v201901.auditlog.AuditLogLang;
import jp.yahooapis.ss.v201901.auditlog.AuditLogOperation;
import jp.yahooapis.ss.v201901.auditlog.AuditLogOutput;
import jp.yahooapis.ss.v201901.auditlog.AuditLogPage;
import jp.yahooapis.ss.v201901.auditlog.AuditLogReturnValue;
import jp.yahooapis.ss.v201901.auditlog.AuditLogSelector;
import jp.yahooapis.ss.v201901.auditlog.AuditLogService;
import jp.yahooapis.ss.v201901.auditlog.AuditLogServiceInterface;
import jp.yahooapis.ss.v201901.auditlog.AuditLogValues;
import jp.yahooapis.ss.v201901.auditlog.DateRange;
import jp.yahooapis.ss.v201901.auditlog.EventSelector;

import java.util.Arrays;
import java.util.List;

import javax.xml.ws.Holder;

/**
 * example AuditLogService operation and Utility method collection.
 */
public class AuditLogServiceSample {

  /**
   * example AuditLogService operation.
   *
   * @param args command line arguments
   * @throws Exception
   */
  public static void main(String[] args) throws Exception {

    try {
      // =================================================================
      // Setup
      // =================================================================
      long accountId = SoapUtils.getAccountId();

      // =================================================================
      // AuditLogService addJob
      // =================================================================
      // create request.
      AuditLogOperation operation = buildExampleAddJobRequest(accountId, createAuditLogJob());

      // run
      List<AuditLogValues> addResponse = addJob(operation);

      Long jobId = null;
      for (AuditLogValues auditLogValues : addResponse) {
        jobId = auditLogValues.getJob().getJobId();
      }

      // =================================================================
      // AuditLogService GET
      // =================================================================
      // check job status
      checkStatus(Arrays.asList(jobId));

      // create request.
      AuditLogSelector selector = buildExampleGetRequest(accountId, Arrays.asList(jobId));

      // run
      List<AuditLogValues> getResponse = get(selector);

      String downloadUrl = null;
      for (AuditLogValues auditLogValues : getResponse) {
        downloadUrl = auditLogValues.getJob().getDownloadUrl();
      }

      // =================================================================
      // AuditLogService download (http request)
      // =================================================================
      SoapUtils.download(downloadUrl, "auditLogDownloadSample.csv");

    } catch (Exception e) {
      e.printStackTrace();
      throw e;
    }
  }

  /**
   * example check AuditLog job status.
   *
   * @param jobIds List<Long>
   * @throws Exception
   */
  public static void checkStatus(List<Long> jobIds) throws Exception {

    // call 30sec sleep * 30 = 15minute
    for (int i = 0; i < 30; i++) {

      // sleep 30 second.
      System.out.println("\n***** sleep 30 seconds for AuditLog Job Status Check *****\n");
      Thread.sleep(30000);

      AuditLogSelector getRequest = buildExampleGetRequest(SoapUtils.getAccountId(), jobIds);
      List<AuditLogValues> getResponse = get(getRequest);

      int completedCount = 0;

      // check status
      for (AuditLogValues values : getResponse) {
        AuditLogJobStatus status = values.getJob().getJobStatus();
        if (status == null) {
          throw new Exception("Fail to get AuditLog.");
        }
        switch (status) {
          default:
          case IN_PROGRESS:
            continue;
          case TIMEOUT:
          case SYSTEM_ERROR:
            throw new Exception("AuditLog Job Status failed.");
          case COMPLETED:
            completedCount++;
            continue;
        }
      }

      if (getResponse.size() == completedCount) {
        return;
      }
    }
    throw new Exception("Fail to get AuditLog.");
  }

  /**
   * example get request.
   *
   * @param accountId long
   * @param jobIds List<Long>
   * @return AuditLogSelector
   */
  public static AuditLogSelector buildExampleGetRequest(long accountId, List<Long> jobIds) {
    AuditLogSelector selector = new AuditLogSelector();
    selector.setAccountId(accountId);
    if (!jobIds.isEmpty()) {
      selector.getJobIds().addAll(jobIds);
    }
    return selector;
  }

  /**
   * example AuditLogJob request.
   *
   * @return AuditLogJob
   */
  public static AuditLogJob createAuditLogJob() {

    AuditLogJob operand = new AuditLogJob();
    operand.setJobName("sampleAuditLog");
    operand.setLang(AuditLogLang.EN);
    operand.setOutput(AuditLogOutput.CSV);
    operand.setEncoding(AuditLogEncoding.UTF_8);

    EventSelector eventSelector = new EventSelector();
    eventSelector.setEntityType("ALL");
    eventSelector.getEventTypes().add(AuditLogEventType.ALL);
    operand.getEventSelector().add(eventSelector);

    DateRange dateRange = new DateRange();
    dateRange.setStartDate("20190101000000");
    dateRange.setEndDate("20201231000000");
    operand.setDateRange(dateRange);

    return operand;
  }

  /**
   * example mutate request.
   *
   * @param accountId long
   * @param operand AuditLogJob
   * @return AuditLogOperation
   */
  public static AuditLogOperation buildExampleAddJobRequest(long accountId, AuditLogJob operand) {
    AuditLogOperation operation = new AuditLogOperation();
    operation.setAccountId(accountId);
    operation.getOperand().add(operand);
    return operation;
  }

  /**
   * example addJob AuditLog.
   *
   * @param operation AuditLogOperation
   * @return List<AuditLogValues>
   * @throws Exception
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
    Holder<List<Error>> errorHolder = new Holder<List<Error>>();
    auditLogService.addJob(operation, auditLogReturnValueHolder, errorHolder);

    SoapUtils.checkSoapError(errorHolder, auditLogReturnValueHolder.value.getValues());

    // Response
    return auditLogReturnValueHolder.value.getValues();
  }

  /**
   * example get AuditLog.
   *
   * @param selector AuditLogSelector
   * @return List<AuditLogValues>
   * @throws Exception
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

      // response
      List<AuditLogValues> auditLogValues = auditLogPageHolder.value.getValues();
      if (auditLogValues.get(0).isOperationSucceeded()) {
        AuditLogJob auditLogJob = auditLogValues.get(0).getJob();

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
      }
    }

    // Response
    return auditLogPageHolder.value.getValues();
  }
}

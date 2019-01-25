/**
 * Copyright (C) 2019 Yahoo Japan Corporation. All Rights Reserved.
 */
package jp.yahooapis.ss.adapisample.basic.report;

import jp.yahooapis.ss.adapisample.basic.reportdefinition.ReportDefinitionServiceSample;
import jp.yahooapis.ss.adapisample.repository.ValuesRepositoryFacade;
import jp.yahooapis.ss.adapisample.util.SoapUtils;
import jp.yahooapis.ss.adapisample.util.ValuesHolder;
import jp.yahooapis.ss.v201901.Paging;
import jp.yahooapis.ss.v201901.report.Operator;
import jp.yahooapis.ss.v201901.report.ReportOperation;
import jp.yahooapis.ss.v201901.report.ReportPage;
import jp.yahooapis.ss.v201901.report.ReportRecord;
import jp.yahooapis.ss.v201901.report.ReportReturnValue;
import jp.yahooapis.ss.v201901.report.ReportSelector;
import jp.yahooapis.ss.v201901.report.ReportService;
import jp.yahooapis.ss.v201901.report.ReportServiceInterface;
import jp.yahooapis.ss.v201901.report.ReportValues;
import jp.yahooapis.ss.v201901.Error;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.xml.ws.Holder;

/**
 * example ReportService operation and Utility method collection.
 */
public class ReportServiceSample {

  /**
   * main method for ReportService
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
      Long reportId = valuesRepositoryFacade.getReportDefinitionValuesRepository().getReportIds().get(0);

      // =================================================================
      // ReportService ADD
      // =================================================================
      // create request.
      ReportOperation addRequest = buildExampleMutateRequest(Operator.ADD, accountId, new ArrayList<ReportRecord>() {{
        add(createReportRecord(reportId));
      }});

      // run
      List<ReportValues> addResponse = mutate(addRequest);
      List<ReportRecord> reportRecordList = new ArrayList<>();
      List<Long> reportJobIds = new ArrayList<>();
      for (ReportValues values : addResponse) {
        reportRecordList.add(values.getReportRecord());
        reportJobIds.add(values.getReportRecord().getReportJobId());
      }

      // =================================================================
      // ReportService GET
      // =================================================================
      // check job status
      checkStatus(Arrays.asList(reportId), reportJobIds);

      // create request.
      ReportSelector selector = buildExampleGetRequest(accountId, Arrays.asList(reportId), reportJobIds);

      // run
      List<ReportValues> getResponse = get(selector);

      String downloadUrl = null;
      for (ReportValues reportValues : getResponse) {
        downloadUrl = reportValues.getReportRecord().getReportDownloadURL();
      }

      // =================================================================
      // ReportService download (http request)
      // =================================================================
      SoapUtils.download(downloadUrl, "reportDownloadSample.csv");


      // =================================================================
      // ReportService REMOVE
      // =================================================================
      // create request.
      ReportOperation removeRequest = buildExampleMutateRequest(Operator.REMOVE, accountId, reportRecordList);

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
   * check & create upper service object.
   *
   * @return ValuesHolder
   */
  private static ValuesHolder setup() throws Exception {

    return ReportDefinitionServiceSample.create();
  }

  /**
   * cleanup service object.
   *
   * @param valuesHolder ValuesHolder
   */
  public static void cleanup(ValuesHolder valuesHolder) throws Exception {

    ReportDefinitionServiceSample.cleanup(valuesHolder);
  }

  /**
   * example mutate request.
   */
  public static ReportOperation buildExampleMutateRequest(Operator operator, long accountId, List<ReportRecord> operand) {
    ReportOperation operation = new ReportOperation();
    operation.setOperator(operator);
    operation.setAccountId(accountId);
    operation.getOperand().addAll(operand);

    return operation;
  }

  /**
   * example get request.
   *
   * @param accountId    long
   * @param reportIds    List<Long>
   * @param reportJobIds List<Long>
   * @return ReportSelector
   */
  public static ReportSelector buildExampleGetRequest(long accountId, List<Long> reportIds, List<Long> reportJobIds) {
    ReportSelector selector = new ReportSelector();
    selector.setAccountId(accountId);

    if (!reportIds.isEmpty()) {
      selector.getReportIds().addAll(reportIds);
    }

    if (!reportJobIds.isEmpty()) {
      selector.getReportJobIds().addAll(reportJobIds);
    }

    Paging paging = new Paging();
    paging.setStartIndex(1);
    paging.setNumberResults(20);
    selector.setPaging(paging);

    return selector;
  }

  /**
   * example ReportRecord request.
   *
   * @param reportId Long
   * @return ReportRecord
   */
  public static ReportRecord createReportRecord(Long reportId) {
    ReportRecord reportRecord = new ReportRecord();
    reportRecord.setReportId(reportId);
    return reportRecord;
  }

  /**
   * example get report.
   *
   * @param selector ReportSelector
   * @return List<ReportValues>
   */
  public static List<ReportValues> get(ReportSelector selector) throws Exception {

    // call API
    System.out.println("############################################");
    System.out.println("ReportService::get");
    System.out.println("############################################");

    Holder<ReportPage> reportPageHolder = new Holder<ReportPage>();
    Holder<List<Error>> errorHolder = new Holder<List<Error>>();
    ReportServiceInterface reportService = SoapUtils.createServiceInterface(ReportServiceInterface.class, ReportService.class);
    reportService.get(selector, reportPageHolder, errorHolder);

    SoapUtils.checkSoapError(errorHolder, reportPageHolder.value.getValues());

    // Response
    return reportPageHolder.value.getValues();
  }

  /**
   * example mutate report.
   *
   * @param operation ReportOperation
   * @return ReportValues
   */
  public static List<ReportValues> mutate(ReportOperation operation) throws Exception {
    // Call API
    System.out.println("############################################");
    System.out.println("ReportService::mutate(" + operation.getOperator() + ")");
    System.out.println("############################################");

    Holder<ReportReturnValue> reportReturnValueHolder = new Holder<ReportReturnValue>();
    Holder<List<Error>> errorHolder = new Holder<List<Error>>();
    ReportServiceInterface reportService = SoapUtils.createServiceInterface(ReportServiceInterface.class, ReportService.class);
    reportService.mutate(operation, reportReturnValueHolder, errorHolder);

    SoapUtils.checkSoapError(errorHolder, reportReturnValueHolder.value.getValues());

    // Response
    return reportReturnValueHolder.value.getValues();
  }

  /**
   * example check Report job status.
   *
   * @param reportIds List<Long>
   * @param jobIds    List<Long>
   * @return void
   */
  public static void checkStatus(List<Long> reportIds, List<Long> jobIds) throws Exception {

    // call 30sec sleep * 30 = 15minute
    for (int i = 0; i < 30; i++) {

      // sleep 30 second.
      System.out.println("***** sleep 30 seconds for Report Job Status Check *****");
      Thread.sleep(30000);

      // get
      ReportSelector selector = buildExampleGetRequest(SoapUtils.getAccountId(), reportIds, jobIds);
      List<ReportValues> reportValuesList = get(selector);

      int completedCount = 0;

      // check status
      for (ReportValues values : reportValuesList) {
        if (values.getReportRecord().getReportJobStatus() == null) {
          throw new Exception("Fail to get Report.");
        }
        switch (values.getReportRecord().getReportJobStatus()) {
          default:
          case WAIT:
          case IN_PROGRESS:
            continue;
          case FAILED:
            throw new Exception("Report Job Status failed.");
          case COMPLETED:
            completedCount++;
            continue;
        }
      }

      if (reportValuesList.size() == completedCount) {
        return;
      }
    }
    throw new Exception("Fail to get Report.");
  }

}

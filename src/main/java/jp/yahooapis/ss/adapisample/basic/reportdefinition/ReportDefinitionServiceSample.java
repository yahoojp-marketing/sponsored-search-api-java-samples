/**
 * Copyright (C) 2019 Yahoo Japan Corporation. All Rights Reserved.
 */
package jp.yahooapis.ss.adapisample.basic.reportdefinition;

import jp.yahooapis.ss.adapisample.repository.ValuesRepositoryFacade;
import jp.yahooapis.ss.adapisample.util.SoapUtils;
import jp.yahooapis.ss.adapisample.util.ValuesHolder;
import jp.yahooapis.ss.v201909.Error;
import jp.yahooapis.ss.v201909.Paging;
import jp.yahooapis.ss.v201909.reportdefinition.Operator;
import jp.yahooapis.ss.v201909.reportdefinition.ReportCompressType;
import jp.yahooapis.ss.v201909.reportdefinition.ReportDateRangeType;
import jp.yahooapis.ss.v201909.reportdefinition.ReportDefinition;
import jp.yahooapis.ss.v201909.reportdefinition.ReportDefinitionFieldValue;
import jp.yahooapis.ss.v201909.reportdefinition.ReportDefinitionOperation;
import jp.yahooapis.ss.v201909.reportdefinition.ReportDefinitionPage;
import jp.yahooapis.ss.v201909.reportdefinition.ReportDefinitionReturnValue;
import jp.yahooapis.ss.v201909.reportdefinition.ReportDefinitionSelector;
import jp.yahooapis.ss.v201909.reportdefinition.ReportDefinitionService;
import jp.yahooapis.ss.v201909.reportdefinition.ReportDefinitionServiceInterface;
import jp.yahooapis.ss.v201909.reportdefinition.ReportDefinitionValues;
import jp.yahooapis.ss.v201909.reportdefinition.ReportDownloadEncode;
import jp.yahooapis.ss.v201909.reportdefinition.ReportDownloadFormat;
import jp.yahooapis.ss.v201909.reportdefinition.ReportFieldAttribute;
import jp.yahooapis.ss.v201909.reportdefinition.ReportIncludeDeleted;
import jp.yahooapis.ss.v201909.reportdefinition.ReportIncludeZeroImpressions;
import jp.yahooapis.ss.v201909.reportdefinition.ReportLanguage;
import jp.yahooapis.ss.v201909.reportdefinition.ReportSortField;
import jp.yahooapis.ss.v201909.reportdefinition.ReportSortType;
import jp.yahooapis.ss.v201909.reportdefinition.ReportType;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import javax.xml.ws.Holder;

/**
 * example ReportDefinitionService operation and Utility method collection.
 */
public class ReportDefinitionServiceSample {

  private static final List<String> CAMPAIGN_REPORT_FIELDS = Arrays.asList( //
      "CAMPAIGN_ID", //
      "CAMPAIGN_NAME", //
      "CAMPAIGN_DISTRIBUTION_SETTINGS", //
      "CAMPAIGN_DISTRIBUTION_STATUS", //
      "DAILY_SPENDING_LIMIT", //
      "CAMPAIGN_START_DATE", //
      "CAMPAIGN_END_DATE", //
      "TRACKING_URL", //
      "CUSTOM_PARAMETERS", //
      "CAMPAIGN_TRACKING_ID", //
      "CONVERSIONS", //
      "CONV_VALUE", //
      "VALUE_PER_CONV", //
      "CAMPAIGN_MOBILE_BID_MODIFIER", //
      "NETWORK", //
      "CLICK_TYPE", //
      "DEVICE", //
      "DAY", //
      "DAY_OF_WEEK", //
      "QUARTER", //
      "YEAR", //
      "MONTH", //
      "MONTH_OF_YEAR", //
      "WEEK", //
      "HOUR_OF_DAY", //
      "OBJECT_OF_CONVERSION_TRACKING", //
      "CONVERSION_NAME", //
      "CAMPAIGN_TYPE" //
  );

  /**
   * main method for ReportDefinitionService
   *
   * @param args command line arguments
   */
  public static void main(String[] args) throws Exception {

    // =================================================================
    // Setting
    // =================================================================
    long accountId = SoapUtils.getAccountId();

    try {
      // =================================================================
      // ReportDefinitionService getReportFields
      // =================================================================
      // run
      getReportFields(ReportType.CAMPAIGN);

      // =================================================================
      // ReportDefinitionService ADD
      // =================================================================
      // create request.
      ReportDefinitionOperation addRequest = buildExampleMutateRequest( //
          Operator.ADD, accountId, Collections.singletonList(createExampleReportDefinition()) //
      );

      // run
      List<ReportDefinitionValues> addResponse = mutate(addRequest);
      List<ReportDefinition> reportDefinitionList = new ArrayList<>();
      List<Long> reportJobIds = new ArrayList<>();
      for (ReportDefinitionValues values : addResponse) {
        reportDefinitionList.add(values.getReportDefinition());
        reportJobIds.add(values.getReportDefinition().getReportJobId());
      }

      // =================================================================
      // ReportDefinitionService GET
      // =================================================================
      // check job status
      checkStatus(reportJobIds);

      // create request.
      ReportDefinitionSelector selector = buildExampleGetRequest(accountId, reportJobIds);

      // run
      List<ReportDefinitionValues> getResponse = get(selector);

      String downloadUrl = null;
      for (ReportDefinitionValues values : getResponse) {
        downloadUrl = values.getReportDefinition().getReportDownloadURL();
      }

      // =================================================================
      // ReportDefinitionService download (http request)
      // =================================================================
      SoapUtils.download(downloadUrl, "reportDownloadSample.csv");

      // =================================================================
      // ReportDefinitionService REMOVE
      // =================================================================
      // create request.
      ReportDefinitionOperation removeRequest = buildExampleMutateRequest(Operator.REMOVE, accountId, reportDefinitionList);

      // run
      mutate(removeRequest);

    } catch (Exception e) {
      e.printStackTrace();
      throw e;
    }
  }

  /**
   * example getReportFields ReportDefinitions.
   *
   * @param reportType ReportType
   * @return ReportFieldAttribute
   */
  public static List<ReportFieldAttribute> getReportFields(ReportType reportType) throws Exception {
    // Call API
    System.out.println("############################################");
    System.out.println("ReportDefinitionService::getReportFields");
    System.out.println("############################################");

    Holder<ReportDefinitionFieldValue> reportDefinitionFieldValueHolder = new Holder<>();
    Holder<List<Error>> errorHolder = new Holder<List<Error>>();
    ReportDefinitionServiceInterface reportDefinitionService = SoapUtils.createServiceInterface(ReportDefinitionServiceInterface.class, ReportDefinitionService.class);
    reportDefinitionService.getReportFields(reportType, reportDefinitionFieldValueHolder, errorHolder);

    SoapUtils.checkSoapError(errorHolder, Collections.singletonList(reportDefinitionFieldValueHolder.value));

    return reportDefinitionFieldValueHolder.value.getFields();
  }

  /**
   * example get request.
   *
   * @param accountId long
   * @param reportJobIds List<Long>
   * @return get
   */
  public static ReportDefinitionSelector buildExampleGetRequest(long accountId, List<Long> reportJobIds) {
    ReportDefinitionSelector selector = new ReportDefinitionSelector();
    selector.setAccountId(accountId);

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
   * example mutate request.
   */
  public static ReportDefinitionOperation buildExampleMutateRequest(Operator operator, long accountId, List<ReportDefinition> operand) {
    ReportDefinitionOperation operation = new ReportDefinitionOperation();
    operation.setOperator(operator);
    operation.setAccountId(accountId);
    operation.getOperand().addAll(operand);

    return operation;
  }

  /**
   * example ReportDefinition request.
   *
   * @return ReportDefinition
   */
  public static ReportDefinition createExampleReportDefinition() {

    ReportDefinition reportDefinition = new ReportDefinition();
    reportDefinition.setReportName("sampleReport_"+SoapUtils.getCurrentTimestamp());
    reportDefinition.setReportType(ReportType.CAMPAIGN);

    reportDefinition.setDateRangeType(ReportDateRangeType.YESTERDAY);

    reportDefinition.getFields().addAll(CAMPAIGN_REPORT_FIELDS);

    ReportSortField reportSortField = new ReportSortField();
    reportSortField.setType(ReportSortType.ASC);
    reportSortField.setField(CAMPAIGN_REPORT_FIELDS.get(0));
    reportDefinition.setSortFields(reportSortField);

    reportDefinition.setFormat(ReportDownloadFormat.CSV);
    reportDefinition.setEncode(ReportDownloadEncode.UTF_8);
    reportDefinition.setLanguage(ReportLanguage.EN);
    reportDefinition.setCompress(ReportCompressType.NONE);
    reportDefinition.setIncludeZeroImpressions(ReportIncludeZeroImpressions.TRUE);
    reportDefinition.setIncludeDeleted(ReportIncludeDeleted.TRUE);

    return reportDefinition;
  }

  /**
   * example get reportDefinition.
   *
   * @param selector ReportDefinitionSelector
   * @return List<ReportDefinitionValues>
   */
  public static List<ReportDefinitionValues> get(ReportDefinitionSelector selector) throws Exception {

    // call API
    System.out.println("############################################");
    System.out.println("ReportDefinitionService::get");
    System.out.println("############################################");

    Holder<ReportDefinitionPage> reportDefinitionPageHolder = new Holder<ReportDefinitionPage>();
    Holder<List<Error>> errorHolder = new Holder<List<Error>>();
    ReportDefinitionServiceInterface reportDefinitionService = SoapUtils.createServiceInterface(ReportDefinitionServiceInterface.class, ReportDefinitionService.class);
    reportDefinitionService.get(selector, reportDefinitionPageHolder, errorHolder);

    SoapUtils.checkSoapError(errorHolder, reportDefinitionPageHolder.value.getValues());

    // Response
    return reportDefinitionPageHolder.value.getValues();
  }

  /**
   * example mutate reportDefinition.
   *
   * @param operation ReportDefinitionOperation
   * @return ReportDefinitionValues
   */
  public static List<ReportDefinitionValues> mutate(ReportDefinitionOperation operation) throws Exception {
    // Call API
    System.out.println("############################################");
    System.out.println("ReportDefinitionService::mutate(" + operation.getOperator() + ")");
    System.out.println("############################################");

    Holder<ReportDefinitionReturnValue> reportDefinitionReturnValueHolder = new Holder<ReportDefinitionReturnValue>();
    Holder<List<Error>> errorHolder = new Holder<List<Error>>();
    ReportDefinitionServiceInterface reportDefinitionService = SoapUtils.createServiceInterface(ReportDefinitionServiceInterface.class, ReportDefinitionService.class);
    reportDefinitionService.mutate(operation, reportDefinitionReturnValueHolder, errorHolder);

    SoapUtils.checkSoapError(errorHolder, reportDefinitionReturnValueHolder.value.getValues());

    // Response
    return reportDefinitionReturnValueHolder.value.getValues();
  }

  /**
   * example check Report job status.
   *
   * @param reportJobIds    List<Long>
   * @return void
   */
  public static void checkStatus(List<Long> reportJobIds) throws Exception {

    // call 30sec sleep * 30 = 15minute
    for (int i = 0; i < 30; i++) {

      // sleep 30 second.
      System.out.println("***** sleep 30 seconds for Report Job Status Check *****");
      Thread.sleep(30000);

      // get
      ReportDefinitionSelector selector = buildExampleGetRequest(SoapUtils.getAccountId(), reportJobIds);
      List<ReportDefinitionValues> reportDefinitionValues = get(selector);

      int completedCount = 0;

      // check status
      for (ReportDefinitionValues values : reportDefinitionValues) {
        if (values.getReportDefinition().getReportJobStatus() == null) {
          throw new Exception("Fail to get Report.");
        }
        switch (values.getReportDefinition().getReportJobStatus()) {
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

      if (reportDefinitionValues.size() == completedCount) {
        return;
      }
    }
    throw new Exception("Fail to get Report.");
  }
}

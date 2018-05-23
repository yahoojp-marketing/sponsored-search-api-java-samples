package jp.co.yahoo.ad_api_sample.reportDownloadSample;

import jp.co.yahoo.ad_api_sample.error.impl.ReportDefinitionServiceErrorEntityFactory;
import jp.co.yahoo.ad_api_sample.error.impl.ReportServiceErrorEntityFactory;
import jp.co.yahoo.ad_api_sample.util.SoapUtils;
import jp.yahooapis.ss.v201805.Error;
import jp.yahooapis.ss.v201805.Paging;
import jp.yahooapis.ss.v201805.reportdefinition.ReportCompressType;
import jp.yahooapis.ss.v201805.reportdefinition.ReportDateRangeType;
import jp.yahooapis.ss.v201805.reportdefinition.ReportDefinition;
import jp.yahooapis.ss.v201805.reportdefinition.ReportDefinitionFieldValue;
import jp.yahooapis.ss.v201805.reportdefinition.ReportDefinitionOperation;
import jp.yahooapis.ss.v201805.reportdefinition.ReportDefinitionPage;
import jp.yahooapis.ss.v201805.reportdefinition.ReportDefinitionReturnValue;
import jp.yahooapis.ss.v201805.reportdefinition.ReportDefinitionSelector;
import jp.yahooapis.ss.v201805.reportdefinition.ReportDefinitionService;
import jp.yahooapis.ss.v201805.reportdefinition.ReportDefinitionServiceInterface;
import jp.yahooapis.ss.v201805.reportdefinition.ReportDefinitionValues;
import jp.yahooapis.ss.v201805.reportdefinition.ReportDownloadEncode;
import jp.yahooapis.ss.v201805.reportdefinition.ReportDownloadFormat;
import jp.yahooapis.ss.v201805.reportdefinition.ReportFieldAttribute;
import jp.yahooapis.ss.v201805.reportdefinition.ReportIncludeZeroImpressions;
import jp.yahooapis.ss.v201805.reportdefinition.ReportIntervalType;
import jp.yahooapis.ss.v201805.reportdefinition.ReportIsTemplate;
import jp.yahooapis.ss.v201805.reportdefinition.ReportLanguage;
import jp.yahooapis.ss.v201805.reportdefinition.ReportSortField;
import jp.yahooapis.ss.v201805.reportdefinition.ReportSortType;
import jp.yahooapis.ss.v201805.reportdefinition.ReportType;
import jp.yahooapis.ss.v201805.report.ReportJobStatus;
import jp.yahooapis.ss.v201805.report.ReportOperation;
import jp.yahooapis.ss.v201805.report.ReportPage;
import jp.yahooapis.ss.v201805.report.ReportRecord;
import jp.yahooapis.ss.v201805.report.ReportReturnValue;
import jp.yahooapis.ss.v201805.report.ReportSelector;
import jp.yahooapis.ss.v201805.report.ReportService;
import jp.yahooapis.ss.v201805.report.ReportServiceInterface;
import jp.yahooapis.ss.v201805.report.ReportValues;

import java.util.Arrays;
import java.util.List;

import javax.xml.ws.Holder;

/**
 * Sample Program for Report Download. Copyright (C) 2012 Yahoo Japan Corporation. All Rights
 * Reserved.
 */
public class ReportDownloadSample {

  /**
   * main method for ReportDownloadSample
   * 
   * @param args command line arguments
   * @exception Exception
   */
  public static void main(String[] args) throws Exception{
    try {
      // =================================================================
      // Setting
      // =================================================================
      long accountId = SoapUtils.getAccountId();
      long reportId;
      long reportJobId;
      String downloadFileName;

      // =================================================================
      // ReportDefinitionService
      // =================================================================
      // -----------------------------------------------
      // ReportDefinitionService::getReportFields
      // -----------------------------------------------
      // Run
      getReportFields();

      // -----------------------------------------------
      // ReportDefinitionService::mutate(ADD)
      // -----------------------------------------------
      // request
      ReportDefinitionOperation reportDefinitionOperation = new ReportDefinitionOperation();
      reportDefinitionOperation.setAccountId(accountId);
      reportDefinitionOperation.setOperator(jp.yahooapis.ss.v201805.reportdefinition.Operator.ADD);

      ReportDefinition reportDefinition = new ReportDefinition();
      reportDefinition.setAccountId(accountId);
      reportDefinition.setReportType(ReportType.CAMPAIGN);
      reportDefinition.setReportName("TEST_CAMPAIGN_REPORT");
      reportDefinition.setDateRangeType(ReportDateRangeType.YESTERDAY);
      // fields
      String[] fieldNames = new String[]{
          "CAMPAIGN_ID",
          "CAMPAIGN_NAME",
          "CAMPAIGN_DISTRIBUTION_SETTINGS",
          "CAMPAIGN_DISTRIBUTION_STATUS",
          "DAILY_SPENDING_LIMIT",
          "CAMPAIGN_START_DATE",
          "CAMPAIGN_END_DATE",
          "TRACKING_URL",
          "CUSTOM_PARAMETERS",
          "CAMPAIGN_TRACKING_ID",
          "CONVERSIONS",
          "CONV_VALUE",
          "VALUE_PER_CONV",
          "CAMPAIGN_MOBILE_BID_MODIFIER",
          "NETWORK",
      };

      ReportSortField reportSortField = new ReportSortField();
      reportSortField.setField(fieldNames[0]);
      reportSortField.setType(ReportSortType.ASC);
      reportDefinition.setSortFields(reportSortField);
      reportDefinition.getFields().addAll(Arrays.asList(fieldNames));
      reportDefinition.setCompress(ReportCompressType.NONE);
      reportDefinition.setIsTemplate(ReportIsTemplate.TRUE);
      reportDefinition.setIntervalType(ReportIntervalType.ONETIME);
      reportDefinition.setFormat(ReportDownloadFormat.CSV); // format
      reportDefinition.setEncode(ReportDownloadEncode.SJIS);// encode
      reportDefinition.setLanguage(ReportLanguage.JA);
      reportDefinition.setIncludeZeroImpressions(ReportIncludeZeroImpressions.TRUE);

      reportDefinitionOperation.getOperand().add(reportDefinition);

      // Run
      List<ReportDefinitionValues> reportDefinitionValues = mutateReportDefinition(reportDefinitionOperation);
      reportId = reportDefinitionValues.get(0).getReportDefinition().getReportId();
      downloadFileName = "Report_" + reportDefinitionValues.get(0).getReportDefinition().getReportType() + "_" + reportId + "." + reportDefinitionValues.get(0).getReportDefinition().getFormat().toString().toLowerCase();

      // -----------------------------------------------
      // ReportDefinitionService::get
      // -----------------------------------------------
      // Set Selector
      ReportDefinitionSelector reportDefinitionSelector = new ReportDefinitionSelector();
      reportDefinitionSelector.setAccountId(accountId);
      reportDefinitionSelector.getReportIds().add(reportId);
      Paging paging = new Paging();
      paging.setStartIndex(1);
      paging.setNumberResults(20);
      reportDefinitionSelector.setPaging(paging);

      // Run
      getReportDefinition(reportDefinitionSelector);

      // =================================================================
      // ReportService
      // =================================================================
      // -----------------------------------------------
      // call ReportService::mutate(ADD)
      // -----------------------------------------------
      // request
      ReportRecord addReportRecord = new ReportRecord();
      addReportRecord.setAccountId(accountId);
      addReportRecord.setReportId(reportId);

      ReportOperation addReportOperation = new ReportOperation();
      addReportOperation.setOperator(jp.yahooapis.ss.v201805.report.Operator.ADD);
      addReportOperation.setAccountId(SoapUtils.getAccountId());
      addReportOperation.getOperand().add(addReportRecord);

      // Run
      List<ReportValues> reportValues = mutateReport(addReportOperation);
      reportJobId = reportValues.get(0).getReportRecord().getReportJobId();

      // -----------------------------------------------
      // ReportService::get
      // -----------------------------------------------
      // request
      ReportSelector reportSelector = new ReportSelector();
      reportSelector.setAccountId(accountId);
      reportSelector.getReportJobIds().add(reportJobId);

      // call 30sec sleep * 30 = 15minute
      ReportJobStatus jobStatus = null;
      for (int i = 0; i < 30; i++) {
        // sleep 30 second.
        System.out.println("\n***** sleep 30 seconds for Report Download Job *****\n");
        Thread.sleep(30000);

        // Run
        List<ReportValues> getReportValues = getReport(reportSelector);
        if (getReportValues.get(0).isOperationSucceeded()) {
          ReportRecord getReportRecord = getReportValues.get(0).getReportRecord();

          // ReportJob Status
          jobStatus = getReportRecord.getReportJobStatus();
          if (jobStatus.equals(ReportJobStatus.COMPLETED)) {

            // -----------------------------------------------
            // download report
            // -----------------------------------------------
            SoapUtils.download(getReportRecord.getReportDownloadURL(), downloadFileName);
            break;
          } else {
            if (ReportJobStatus.IN_PROGRESS.equals(jobStatus) || ReportJobStatus.WAIT.equals(jobStatus)) {
              continue;
            } else {
              System.out.println("Error : Job Status failed.");
              System.exit(0);
            }
          }
        } else {
          SoapUtils.displayErrors(new ReportServiceErrorEntityFactory(getReportValues.get(0).getError()), true);
        }
      }
      if (jobStatus == null) {
        System.out.println("Report job in process on long time. please wait.");
        System.exit(0);
      }

      // -----------------------------------------------
      // ReportService::mutate(REMOVE)
      // -----------------------------------------------
      // request
      ReportRecord removeReportRecord = new ReportRecord();
      removeReportRecord.setAccountId(accountId);
      removeReportRecord.setReportJobId(reportJobId);
      ReportOperation removeReportOperation = new ReportOperation();
      removeReportOperation.setOperator(jp.yahooapis.ss.v201805.report.Operator.REMOVE);
      removeReportOperation.setAccountId(accountId);
      removeReportOperation.getOperand().add(removeReportRecord);

      // Run
      mutateReport(removeReportOperation);

      // -----------------------------------------------
      // ReportDefinitionService::mutate(REMOVE)
      // -----------------------------------------------
      // request
      ReportDefinition removeReportDefintion = new ReportDefinition();
      removeReportDefintion.setAccountId(accountId);
      removeReportDefintion.setReportId(reportId);

      ReportDefinitionOperation removeReportDefintionOperation = new ReportDefinitionOperation();
      removeReportDefintionOperation.setAccountId(accountId);
      removeReportDefintionOperation.setOperator(jp.yahooapis.ss.v201805.reportdefinition.Operator.REMOVE);
      removeReportDefintionOperation.getOperand().add(removeReportDefintion);

      // Run
      mutateReportDefinition(removeReportDefintionOperation);

    } catch (Exception e) {
      e.printStackTrace();
      throw e;
    }
  }

  /**
   * Sample Program for ReportDefinitionService GetReportFields.
   *
   * @return ReportFieldAttribute
   * @throws Exception
   */
  public static List<ReportFieldAttribute> getReportFields() throws Exception {

    // call API
    System.out.println("############################################");
    System.out.println("ReportDefinitionService::getReportFields");
    System.out.println("############################################");

    Holder<ReportDefinitionFieldValue> fieldsValueHolder = new Holder<ReportDefinitionFieldValue>();
    Holder<List<Error>> fieldsErrorHolder = new Holder<List<Error>>();
    ReportDefinitionServiceInterface reportDefinitionService = SoapUtils.createServiceInterface(ReportDefinitionServiceInterface.class, ReportDefinitionService.class);
    reportDefinitionService.getReportFields(ReportType.ACCOUNT, fieldsValueHolder, fieldsErrorHolder);

    // Error
    if (fieldsErrorHolder.value != null && fieldsErrorHolder.value.size() > 0) {
      SoapUtils.displayErrors(new ReportDefinitionServiceErrorEntityFactory(fieldsErrorHolder.value), true);
    }
    if (fieldsErrorHolder.value == null) {
      throw new Exception("NoDataResponse:ReportDefinitionService GetReportFields");
    }

    // Display
    for (ReportFieldAttribute reportFieldAttribute : fieldsValueHolder.value.getFields()) {
      displayReportFields(reportFieldAttribute);
    }

    // Response
    return fieldsValueHolder.value.getFields();
  }

  /**
   * Sample Program for ReportDefinitionService GET.
   *
   * @param selector ReportDefinitionSelector
   * @return ReportDefinitionValues
   * @throws Exception
   */
  public static List<ReportDefinitionValues> getReportDefinition(ReportDefinitionSelector selector) throws Exception {

    // call API
    System.out.println("############################################");
    System.out.println("ReportDefinitionService::get");
    System.out.println("############################################");

    Holder<ReportDefinitionPage> reportDefinitionPage = new Holder<ReportDefinitionPage>();
    Holder<List<Error>> reportDefinitionError = new Holder<List<Error>>();
    ReportDefinitionServiceInterface reportDefinitionService = SoapUtils.createServiceInterface(ReportDefinitionServiceInterface.class, ReportDefinitionService.class);
    reportDefinitionService.get(selector, reportDefinitionPage, reportDefinitionError);

    // Error
    if (reportDefinitionError.value != null && reportDefinitionError.value.size() > 0) {
      SoapUtils.displayErrors(new ReportDefinitionServiceErrorEntityFactory(reportDefinitionError.value), true);
    }
    if (reportDefinitionError.value == null) {
      throw new Exception("NoDataResponse:ReportDefinitionService Get");
    }

    // Display
    for (ReportDefinitionValues reportDefinitionValues : reportDefinitionPage.value.getValues()) {
      if (reportDefinitionValues.isOperationSucceeded()) {
        displayReportDefintion(reportDefinitionValues.getReportDefinition());
      } else {
        SoapUtils.displayErrors(new ReportDefinitionServiceErrorEntityFactory(reportDefinitionValues.getError()), true);
      }
    }

    // Response
    return reportDefinitionPage.value.getValues();
  }

  /**
   * Sample Program for ReportDefinitionService MUTATE.
   *
   * @param operation ReportDefinitionOperation
   * @return ReportDefinitionValues
   * @throws Exception
   */
  public static List<ReportDefinitionValues> mutateReportDefinition(ReportDefinitionOperation operation) throws Exception {

    // call API
    System.out.println("############################################");
    System.out.println("ReportDefinitionService::mutate(" + operation.getOperator() +")");
    System.out.println("############################################");

    Holder<ReportDefinitionReturnValue> reportDefinitinonReturnValue = new Holder<ReportDefinitionReturnValue>();
    Holder<List<Error>> reportDefinitionError = new Holder<List<Error>>();
    ReportDefinitionServiceInterface reportDefinitionService = SoapUtils.createServiceInterface(ReportDefinitionServiceInterface.class, ReportDefinitionService.class);
    reportDefinitionService.mutate(operation, reportDefinitinonReturnValue, reportDefinitionError);

    // Error
    if (reportDefinitionError.value != null && reportDefinitionError.value.size() > 0) {
      SoapUtils.displayErrors(new ReportDefinitionServiceErrorEntityFactory(reportDefinitionError.value), true);
    }
    if (reportDefinitionError.value == null) {
      throw new Exception("NoDataResponse:ReportDefinitionService " + operation.getOperator());
    }

    // Display
    for (ReportDefinitionValues reportDefinitionValues : reportDefinitinonReturnValue.value.getValues()) {
      if (reportDefinitionValues.isOperationSucceeded()){
        displayReportDefintion(reportDefinitionValues.getReportDefinition());
      } else{
        SoapUtils.displayErrors(new ReportDefinitionServiceErrorEntityFactory(reportDefinitionValues.getError()), true);
      }
    }

    // Response
    return reportDefinitinonReturnValue.value.getValues();
  }

  /**
   * Sample Program for ReportService GET.
   *
   * @param selector ReportSelector
   * @return ReportValues
   * @throws Exception
   */
  public static List<ReportValues> getReport(ReportSelector selector) throws Exception {

    // call API
    System.out.println("############################################");
    System.out.println("ReportService::get");
    System.out.println("############################################");

    Holder<ReportPage> reportPage = new Holder<ReportPage>();
    Holder<List<Error>> reportError = new Holder<List<Error>>();
    ReportServiceInterface reportService = SoapUtils.createServiceInterface(ReportServiceInterface.class, ReportService.class);
    reportService.get(selector, reportPage, reportError);

    // Error
    if (reportError.value != null && reportError.value.size() > 0) {
      SoapUtils.displayErrors(new ReportServiceErrorEntityFactory(reportError.value), true);
    }
    if (reportError.value == null) {
      throw new Exception("NoDataResponse:ReportService Get");
    }

    // Display
    for (ReportValues reportValues : reportPage.value.getValues()) {
      if (reportValues.isOperationSucceeded()) {
        displayReportRecord(reportValues.getReportRecord());
      } else {
        SoapUtils.displayErrors(new ReportDefinitionServiceErrorEntityFactory(reportValues.getError()), true);
      }
    }

    // Response
    return reportPage.value.getValues();
  }

  /**
   * Sample Program for ReportService MUTATE.
   *
   * @param operation ReportOperation
   * @return ReportValues
   * @throws Exception
   */
  public static List<ReportValues> mutateReport(ReportOperation operation) throws Exception {

    // call API
    System.out.println("############################################");
    System.out.println("ReportService::mutate(" + operation.getOperator() +")");
    System.out.println("############################################");

    Holder<ReportReturnValue> addReportReturnValueHolder = new Holder<ReportReturnValue>();
    Holder<List<Error>> addReportError = new Holder<List<Error>>();
    ReportServiceInterface reportService = SoapUtils.createServiceInterface(ReportServiceInterface.class, ReportService.class);
    reportService.mutate(operation, addReportReturnValueHolder, addReportError);

    // Error
    if (addReportError.value != null && addReportError.value.size() > 0) {
      SoapUtils.displayErrors(new ReportServiceErrorEntityFactory(addReportError.value), true);
    }
    if (addReportError.value == null) {
      throw new Exception("NoDataResponse:ReportService " + operation.getOperator());
    }

    // Display
    for (ReportValues reportValues : addReportReturnValueHolder.value.getValues()) {
      if (reportValues.isOperationSucceeded()){
        displayReportRecord(reportValues.getReportRecord());
      } else{
        SoapUtils.displayErrors(new ReportDefinitionServiceErrorEntityFactory(reportValues.getError()), true);
      }
    }

    // Response
    return addReportReturnValueHolder.value.getValues();
  }

  /**
   * diplay ReportDefintion entity
   * 
   * @param reportDefinition
   */
  private static void displayReportDefintion(ReportDefinition reportDefinition) {
    // display response
    System.out.println("accountId = " + reportDefinition.getAccountId());
    System.out.println("reportId = " + reportDefinition.getReportId());
    System.out.println("reportName = " + reportDefinition.getReportName());
    System.out.println("reportType = " + reportDefinition.getReportType());
    System.out.println("dateRangeType = " + reportDefinition.getDateRangeType());
    
    System.out.println("fields = " + SoapUtils.arrayToLine(reportDefinition.getFields().toArray()));
    System.out.println("sortFields/field = " + reportDefinition.getSortFields().getField());
    System.out.println("sortFields/type = " + reportDefinition.getSortFields().getType());
    System.out.println("isTemplate = " + reportDefinition.getIsTemplate());
    System.out.println("intervalType = " + reportDefinition.getIntervalType());
    System.out.println("specifyDay = " + reportDefinition.getSpecifyDay());
    System.out.println("format = " + reportDefinition.getFormat());
    System.out.println("encode = " + reportDefinition.getEncode());
    System.out.println("language = " + reportDefinition.getLanguage());
    System.out.println("compress = " + reportDefinition.getCompress());
    
    System.out.println("---------");
  }

  /**
   * diplay ReportFieldAttribute entity
   *
   * @param reportFieldAttribute
   */
  private static void displayReportFields(ReportFieldAttribute reportFieldAttribute) {
    System.out.println("fieldName = " + reportFieldAttribute.getFieldName());
    System.out.println("displayFieldNameJA = " + reportFieldAttribute.getDisplayFieldNameJA());
    System.out.println("displayFieldNameEN = " + reportFieldAttribute.getDisplayFieldNameEN());
    System.out.println("xmlAttributeName = " + reportFieldAttribute.getXmlAttributeName());
    System.out.println("fieldType = " + reportFieldAttribute.getFieldType());
    System.out.println("canSelect = " + reportFieldAttribute.isCanSelect());
    System.out.println("canFilter = " + reportFieldAttribute.isCanFilter());
    System.out.println("impossibleCombinationFields = " + reportFieldAttribute.getImpossibleCombinationFields());
    System.out.println("---------");
  }

  /**
   * diplay ReportRecord entity
   * 
   * @param reportRecord
   */
  private static void displayReportRecord(ReportRecord reportRecord) {
    System.out.println("accountId = " + reportRecord.getAccountId());
    System.out.println("reportId = " + reportRecord.getReportId());
    System.out.println("reportJobId = " + reportRecord.getReportJobId());
    System.out.println("reportJobStatus = " + reportRecord.getReportJobStatus());
    System.out.println("reportJobErrorDetail = " + reportRecord.getReportJobErrorDetail());
    System.out.println("requestTime = " + reportRecord.getRequestTime());
    System.out.println("completeTime = " + reportRecord.getCompleteTime());
    System.out.println("reportDownloadURL = " + reportRecord.getReportDownloadURL());

    System.out.println("---------");
  }
}

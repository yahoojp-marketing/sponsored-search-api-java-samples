package jp.co.yahoo.ad_api_sample.reportDownloadSample;

import java.util.Arrays;
import java.util.List;

import javax.xml.ws.Holder;

import jp.co.yahoo.ad_api_sample.error.impl.ReportDefinitionServiceErrorEntityFactory;
import jp.co.yahoo.ad_api_sample.error.impl.ReportServiceErrorEntityFactory;
import jp.co.yahoo.ad_api_sample.util.SoapUtils;
import jp.yahooapis.ss.V6.ReportDefinitionService.Error;
import jp.yahooapis.ss.V6.ReportDefinitionService.Operator;
import jp.yahooapis.ss.V6.ReportDefinitionService.ReportCompressType;
import jp.yahooapis.ss.V6.ReportDefinitionService.ReportDateRangeType;
import jp.yahooapis.ss.V6.ReportDefinitionService.ReportDefinition;
import jp.yahooapis.ss.V6.ReportDefinitionService.ReportDefinitionFieldValue;
import jp.yahooapis.ss.V6.ReportDefinitionService.ReportDefinitionOperation;
import jp.yahooapis.ss.V6.ReportDefinitionService.ReportDefinitionReturnValue;
import jp.yahooapis.ss.V6.ReportDefinitionService.ReportDefinitionService;
import jp.yahooapis.ss.V6.ReportDefinitionService.ReportDefinitionServiceInterface;
import jp.yahooapis.ss.V6.ReportDefinitionService.ReportDefinitionValues;
import jp.yahooapis.ss.V6.ReportDefinitionService.ReportDownloadEncode;
import jp.yahooapis.ss.V6.ReportDefinitionService.ReportDownloadFormat;
import jp.yahooapis.ss.V6.ReportDefinitionService.ReportFieldAttribute;
import jp.yahooapis.ss.V6.ReportDefinitionService.ReportIntervalType;
import jp.yahooapis.ss.V6.ReportDefinitionService.ReportIsTemplate;
import jp.yahooapis.ss.V6.ReportDefinitionService.ReportLanguage;
import jp.yahooapis.ss.V6.ReportDefinitionService.ReportSortField;
import jp.yahooapis.ss.V6.ReportDefinitionService.ReportSortType;
import jp.yahooapis.ss.V6.ReportDefinitionService.ReportType;
import jp.yahooapis.ss.V6.ReportService.ReportJobStatus;
import jp.yahooapis.ss.V6.ReportService.ReportOperation;
import jp.yahooapis.ss.V6.ReportService.ReportPage;
import jp.yahooapis.ss.V6.ReportService.ReportRecord;
import jp.yahooapis.ss.V6.ReportService.ReportReturnValue;
import jp.yahooapis.ss.V6.ReportService.ReportSelector;
import jp.yahooapis.ss.V6.ReportService.ReportService;
import jp.yahooapis.ss.V6.ReportService.ReportServiceInterface;
import jp.yahooapis.ss.V6.ReportService.ReportValues;

/**
 * Sample Program for Report Download. Copyright (C) 2012 Yahoo Japan Corporation. All Rights
 * Reserved.
 */
public class ReportDownloadSample {
  /**
   * main method for ReportDownloadSample
   * 
   * @param args command line arguments
   */
  public static void main(String[] args) {

    try {
      // =================================================================
      // ReportDefinitionService
      // =================================================================
      ReportDefinitionServiceInterface reportDefinitionService = SoapUtils.createServiceInterface(ReportDefinitionServiceInterface.class, ReportDefinitionService.class);

      // -----------------------------------------------
      // call ReportDefinitionService::getReportFields
      // -----------------------------------------------
      // call API
      System.out.println("############################################");
      System.out.println("ReportDefinitionService::getReportFields");
      System.out.println("############################################");
      Holder<ReportDefinitionFieldValue> fieldsValueHolder = new Holder<ReportDefinitionFieldValue>();
      Holder<List<Error>> fieldsErrorHolder = new Holder<List<Error>>();
      reportDefinitionService.getReportFields(ReportType.ACCOUNT, fieldsValueHolder, fieldsErrorHolder);

      // if error
      if (fieldsErrorHolder.value != null && fieldsErrorHolder.value.size() > 0) {
        SoapUtils.displayErrors(new ReportDefinitionServiceErrorEntityFactory(fieldsErrorHolder.value), true);
      }

      // response
      if (fieldsValueHolder.value != null) {
        List<ReportFieldAttribute> fields = fieldsValueHolder.value.getFields();
        for (int i = 0; i < fields.size(); i++) {
          System.out.println("fieldName        = " + fields.get(i).getFieldName());
          System.out.println("displayFieldNameJA = " + fields.get(i).getDisplayFieldNameJA());
          System.out.println("displayFieldNameEN = " + fields.get(i).getDisplayFieldNameEN());
          System.out.println("xmlAttributeName = " + fields.get(i).getXmlAttributeName());
          System.out.println("---------");
        }
      }

      // -----------------------------------------------
      // call ReportDefinitionService::mutate(ADD)
      // -----------------------------------------------
      // request
      ReportDefinitionOperation reportDefinitionOperation = new ReportDefinitionOperation();
      reportDefinitionOperation.setAccountId(SoapUtils.getAccountId()); // accountId
      reportDefinitionOperation.setOperator(Operator.ADD); // operator

      ReportDefinition reportDefinition = new ReportDefinition();
      reportDefinition.setAccountId(SoapUtils.getAccountId()); // accountId
      reportDefinition.setReportType(ReportType.ACCOUNT); // reportType
      reportDefinition.setReportName("TEST_ACCOUNT_REPORT"); // reportName
      reportDefinition.setDateRangeType(ReportDateRangeType.YESTERDAY); // dateRangeType
      // fields
      String[] fieldNames = new String[] { "REVENUE", "UNIQUE_CONVERSION",
          "REVENUE_UNIQUE_CONVERSION", "REVENUE_CONVERSION", "CONVERSION", 
          "TRACKING_URL", "NETWORK", "CLICK_TYPE", "DEVICE", "DAY", "DAY_OF_WEEK", "QUARTER", "YEAR",
          "MONTH", "MONTH_OF_YEAR", "WEEK", "HOUR_OF_DAY", "OBJECT_OF_CONVERSION_TRACKING", "CONVERSION_NAME"};

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


      reportDefinitionOperation.getOperand().add(reportDefinition);

      // call API
      System.out.println("############################################");
      System.out.println("ReportDefinitionService::mutate(ADD)");
      System.out.println("############################################");
      Holder<ReportDefinitionReturnValue> reportDefinitinonReturnValue = new Holder<ReportDefinitionReturnValue>();
      Holder<List<Error>> reportDefinitionError = new Holder<List<Error>>();
      reportDefinitionService.mutate(reportDefinitionOperation, reportDefinitinonReturnValue, reportDefinitionError);

      // if error
      if (reportDefinitionError.value != null && reportDefinitionError.value.size() > 0) {
        SoapUtils.displayErrors(new ReportDefinitionServiceErrorEntityFactory(reportDefinitionError.value), true);
      }

      // response
      long reportId = 0;
      String downloadFileName = null;
      List<ReportDefinitionValues> reportDefinitionValues = reportDefinitinonReturnValue.value.getValues();
      if (reportDefinitionValues.get(0).isOperationSucceeded()) {
        ReportDefinition addedReportDefinition = reportDefinitionValues.get(0).getReportDefinition();
        // reportId
        reportId = addedReportDefinition.getReportId();
        // filename
        downloadFileName = "Report_" + addedReportDefinition.getReportType() + "_" + reportId + "." + addedReportDefinition.getFormat().toString().toLowerCase();
        // display Response
        displayReportDefintion(addedReportDefinition);

      } else {
        SoapUtils.displayErrors(new ReportDefinitionServiceErrorEntityFactory(reportDefinitionValues.get(0).getError()), true);
      }


      // =================================================================
      // ReportService
      // =================================================================
      ReportServiceInterface reportService = SoapUtils.createServiceInterface(ReportServiceInterface.class, ReportService.class);

      // -----------------------------------------------
      // call ReportService::mutate(ADD)
      // -----------------------------------------------
      // request
      ReportRecord addReportRecord = new ReportRecord();
      addReportRecord.setAccountId(SoapUtils.getAccountId()); // accountId
      addReportRecord.setReportId(reportId); // reportId

      ReportOperation addReportOperation = new ReportOperation(); // operations
      addReportOperation.setOperator(jp.yahooapis.ss.V6.ReportService.Operator.ADD);
      addReportOperation.setAccountId(SoapUtils.getAccountId());
      addReportOperation.getOperand().add(addReportRecord);

      // call API
      System.out.println("############################################");
      System.out.println("ReportService::mutate(ADD)");
      System.out.println("############################################");
      Holder<ReportReturnValue> addReportReturnValueHolder = new Holder<ReportReturnValue>();
      Holder<List<jp.yahooapis.ss.V6.ReportService.Error>> addReportError = new Holder<List<jp.yahooapis.ss.V6.ReportService.Error>>();
      reportService.mutate(addReportOperation, addReportReturnValueHolder, addReportError);

      // if error
      if (addReportError.value != null && addReportError.value.size() > 0) {
        SoapUtils.displayErrors(new ReportServiceErrorEntityFactory(addReportError.value), true);
      }

      // response
      long reportJobId = 0;
      List<ReportValues> addedReportValues = addReportReturnValueHolder.value.getValues();
      if (addedReportValues.get(0).isOperationSucceeded()) {
        ReportRecord addedReportRecord = addedReportValues.get(0).getReportRecord();
        // reportJobId
        reportJobId = addedReportRecord.getReportJobId();
        // display response
        displayReportRecord(addedReportRecord);
      } else {
        SoapUtils.displayErrors(new ReportServiceErrorEntityFactory(addedReportValues.get(0).getError()), true);
      }

      // -----------------------------------------------
      // call ReportService::get
      // -----------------------------------------------
      // request
      ReportSelector reportSelector = new ReportSelector();
      reportSelector.setAccountId(SoapUtils.getAccountId());
      reportSelector.getReportJobIds().add(reportJobId);

      // call 30sec sleep * 30 = 15minute
      ReportJobStatus jobStatus = null;
      for (int i = 0; i < 30; i++) {
        // sleep 30 second.
        System.out.println("\n***** sleep 30 seconds for Report Download Job *****\n");
        Thread.sleep(30000);
        // call API
        System.out.println("############################################");
        System.out.println("ReportService::get");
        System.out.println("############################################");
        Holder<ReportPage> getReportPageHolder = new Holder<ReportPage>();
        Holder<List<jp.yahooapis.ss.V6.ReportService.Error>> getReportError = new Holder<List<jp.yahooapis.ss.V6.ReportService.Error>>();
        reportService.get(reportSelector, getReportPageHolder, getReportError);

        // if error
        if (getReportError.value != null && getReportError.value.size() > 0) {
          SoapUtils.displayErrors(new ReportServiceErrorEntityFactory(getReportError.value), true);
        }

        // response
        List<ReportValues> getReportValues = getReportPageHolder.value.getValues();
        if (getReportValues.get(0).isOperationSucceeded()) {
          ReportRecord getReportRecord = getReportValues.get(0).getReportRecord();

          // ReportJob Status
          jobStatus = getReportRecord.getReportJobStatus();

          // display response
          displayReportRecord(getReportRecord);
          
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
      // call ReportService::mutate(REMOVE)
      // -----------------------------------------------
      // request
      ReportRecord removeReportRecord = new ReportRecord();
      removeReportRecord.setAccountId(SoapUtils.getAccountId()); // accountId
      removeReportRecord.setReportJobId(reportJobId); // reportJobId
      ReportOperation removeReportOperation = new ReportOperation(); // operations
      removeReportOperation.setOperator(jp.yahooapis.ss.V6.ReportService.Operator.REMOVE);
      removeReportOperation.setAccountId(SoapUtils.getAccountId());
      removeReportOperation.getOperand().add(removeReportRecord);

      // call API
      System.out.println("############################################");
      System.out.println("ReportService::mutate(REMOVE)");
      System.out.println("############################################");
      Holder<ReportReturnValue> removeReportReturnValueHolder = new Holder<ReportReturnValue>();
      Holder<List<jp.yahooapis.ss.V6.ReportService.Error>> removeReportError = new Holder<List<jp.yahooapis.ss.V6.ReportService.Error>>();
      reportService.mutate(removeReportOperation, removeReportReturnValueHolder, removeReportError);

      // if error
      if (removeReportError.value != null && removeReportError.value.size() > 0) {
        SoapUtils.displayErrors(new ReportServiceErrorEntityFactory(removeReportError.value), true);
      }

      // response
      List<ReportValues> removedReportValues = removeReportReturnValueHolder.value.getValues();
      if (removedReportValues.get(0).isOperationSucceeded()) {
        ReportRecord removedReportRecord = removedReportValues.get(0).getReportRecord();
        // display response
        displayReportRecord(removedReportRecord);
      } else {
        SoapUtils.displayErrors(new ReportServiceErrorEntityFactory(removedReportValues.get(0).getError()), true);
      }

      // -----------------------------------------------
      // call ReportDefinitionService::mutate(REMOVE)
      // -----------------------------------------------
      // request
      ReportDefinition removeReportDefintion = new ReportDefinition();
      removeReportDefintion.setAccountId(SoapUtils.getAccountId());
      removeReportDefintion.setReportId(reportId);

      ReportDefinitionOperation removeReportDefintionOperation = new ReportDefinitionOperation();
      removeReportDefintionOperation.setAccountId(SoapUtils.getAccountId());
      removeReportDefintionOperation.setOperator(Operator.REMOVE);
      removeReportDefintionOperation.getOperand().add(removeReportDefintion);

      // call API
      System.out.println("############################################");
      System.out.println("ReportDefintionService::mutate(REMOVE)");
      System.out.println("############################################");
      Holder<ReportDefinitionReturnValue> removeReportDefintionReturnValueHolder = new Holder<ReportDefinitionReturnValue>();
      Holder<List<Error>> removeReportDefintionErrorHolder = new Holder<List<Error>>();
      reportDefinitionService.mutate(removeReportDefintionOperation, removeReportDefintionReturnValueHolder, removeReportDefintionErrorHolder);

      // if error
      if (removeReportDefintionErrorHolder.value != null && removeReportDefintionErrorHolder.value.size() > 0) {
        SoapUtils.displayErrors(new ReportDefinitionServiceErrorEntityFactory(removeReportDefintionErrorHolder.value), true);
      }

      // response
      if (removeReportDefintionReturnValueHolder.value != null) {
        List<ReportDefinitionValues> values = removeReportDefintionReturnValueHolder.value.getValues();
        if (values.get(0).isOperationSucceeded()) {
          displayReportDefintion(values.get(0).getReportDefinition());
        } else {
          SoapUtils.displayErrors(new ReportDefinitionServiceErrorEntityFactory(values.get(0).getError()), true);
        }
      }


    } catch (Exception e) {
      e.printStackTrace();
    }
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

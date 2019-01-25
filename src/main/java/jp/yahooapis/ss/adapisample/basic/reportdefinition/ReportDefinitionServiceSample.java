/**
 * Copyright (C) 2019 Yahoo Japan Corporation. All Rights Reserved.
 */
package jp.yahooapis.ss.adapisample.basic.reportdefinition;

import jp.yahooapis.ss.adapisample.repository.ValuesRepositoryFacade;
import jp.yahooapis.ss.adapisample.util.SoapUtils;
import jp.yahooapis.ss.adapisample.util.ValuesHolder;
import jp.yahooapis.ss.v201901.Error;
import jp.yahooapis.ss.v201901.Paging;
import jp.yahooapis.ss.v201901.reportdefinition.Operator;
import jp.yahooapis.ss.v201901.reportdefinition.ReportCompressType;
import jp.yahooapis.ss.v201901.reportdefinition.ReportDateRangeType;
import jp.yahooapis.ss.v201901.reportdefinition.ReportDefinition;
import jp.yahooapis.ss.v201901.reportdefinition.ReportDefinitionFieldValue;
import jp.yahooapis.ss.v201901.reportdefinition.ReportDefinitionOperation;
import jp.yahooapis.ss.v201901.reportdefinition.ReportDefinitionPage;
import jp.yahooapis.ss.v201901.reportdefinition.ReportDefinitionReturnValue;
import jp.yahooapis.ss.v201901.reportdefinition.ReportDefinitionSelector;
import jp.yahooapis.ss.v201901.reportdefinition.ReportDefinitionService;
import jp.yahooapis.ss.v201901.reportdefinition.ReportDefinitionServiceInterface;
import jp.yahooapis.ss.v201901.reportdefinition.ReportDefinitionValues;
import jp.yahooapis.ss.v201901.reportdefinition.ReportDownloadEncode;
import jp.yahooapis.ss.v201901.reportdefinition.ReportDownloadFormat;
import jp.yahooapis.ss.v201901.reportdefinition.ReportFieldAttribute;
import jp.yahooapis.ss.v201901.reportdefinition.ReportIncludeDeleted;
import jp.yahooapis.ss.v201901.reportdefinition.ReportIncludeZeroImpressions;
import jp.yahooapis.ss.v201901.reportdefinition.ReportIntervalType;
import jp.yahooapis.ss.v201901.reportdefinition.ReportIsTemplate;
import jp.yahooapis.ss.v201901.reportdefinition.ReportLanguage;
import jp.yahooapis.ss.v201901.reportdefinition.ReportSortField;
import jp.yahooapis.ss.v201901.reportdefinition.ReportSortType;
import jp.yahooapis.ss.v201901.reportdefinition.ReportType;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.xml.ws.Holder;

/**
 * example ReportDefinitionService operation and Utility method collection.
 */
public class ReportDefinitionServiceSample {

  private static final List<String> CAMPAIGN_REPORT_FIELDS = Arrays.asList("CAMPAIGN_ID", //
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
    ValuesRepositoryFacade valuesRepositoryFacade = new ValuesRepositoryFacade(new ValuesHolder());
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
      ReportDefinitionOperation addRequest = buildExampleMutateRequest(Operator.ADD, accountId, new ArrayList<ReportDefinition>() {{
        add(createExampleReportDefinition(accountId));
      }});


      // run
      List<ReportDefinitionValues> addResponse = mutate(addRequest);
      valuesRepositoryFacade.getValuesHolder().setReportDefinitionValuesList(addResponse);

      // =================================================================
      // ReportDefinitionService GET
      // =================================================================
      // create request.
      ReportDefinitionSelector selector = buildExampleGetRequest(accountId, valuesRepositoryFacade.getReportDefinitionValuesRepository().getReportIds());

      // run
      get(selector);

      // =================================================================
      // ReportDefinitionService REMOVE
      // =================================================================
      // create request.
      ReportDefinitionOperation removeRequest = buildExampleMutateRequest(Operator.REMOVE, accountId, valuesRepositoryFacade.getReportDefinitionValuesRepository().getReportDefinitions());

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

    SoapUtils.checkSoapError(errorHolder, Arrays.asList(reportDefinitionFieldValueHolder.value));

    return reportDefinitionFieldValueHolder.value.getFields();
  }

  /**
   * example get request.
   *
   * @param accountId long
   * @param reportIds List<Long>
   * @return get
   */
  public static ReportDefinitionSelector buildExampleGetRequest(long accountId, List<Long> reportIds) {
    ReportDefinitionSelector selector = new ReportDefinitionSelector();
    selector.setAccountId(accountId);

    if (!reportIds.isEmpty()) {
      selector.getReportIds().addAll(reportIds);
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
   * @param accountId int
   * @return ReportDefinition
   */
  public static ReportDefinition createExampleReportDefinition(long accountId) {
    ReportDefinition reportDefinition = new ReportDefinition();
    reportDefinition.setAccountId(accountId);
    reportDefinition.setReportName("sampleReport");
    reportDefinition.setReportType(ReportType.CAMPAIGN);
    reportDefinition.setDateRangeType(ReportDateRangeType.YESTERDAY);
    reportDefinition.getFields().addAll(CAMPAIGN_REPORT_FIELDS);

    ReportSortField reportSortField = new ReportSortField();
    reportSortField.setType(ReportSortType.ASC);
    reportSortField.setField(CAMPAIGN_REPORT_FIELDS.get(0));
    reportDefinition.setSortFields(reportSortField);

    reportDefinition.setIsTemplate(ReportIsTemplate.TRUE);
    reportDefinition.setIntervalType(ReportIntervalType.ONETIME);
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
   * create basic ReportDefinition.
   *
   * @return ValuesHolder
   * @throws Exception
   */
  public static ValuesHolder create() throws Exception {

    ValuesHolder valuesHolder = new ValuesHolder();
    long accountId = SoapUtils.getAccountId();
    ReportDefinitionOperation addReportDefinitionOperation = buildExampleMutateRequest(Operator.ADD, accountId, new ArrayList<ReportDefinition>() {{
      add(createExampleReportDefinition(accountId));
    }});

    // Run
    List<ReportDefinitionValues> biddingStrategyValues = mutate(addReportDefinitionOperation);
    valuesHolder.setReportDefinitionValuesList(biddingStrategyValues);
    return valuesHolder;
  }

  /**
   * cleanup service object.
   *
   * @param valuesHolder ValuesHolder
   */
  public static void cleanup(ValuesHolder valuesHolder) throws Exception {

    long accountId = SoapUtils.getAccountId();
    if (valuesHolder.getReportDefinitionValuesList().size() == 0) {
      return;
    }
    ValuesRepositoryFacade valuesRepositoryFacade = new ValuesRepositoryFacade(valuesHolder);

    ReportDefinitionOperation removeReportDefinitionOperation =
        buildExampleMutateRequest(Operator.REMOVE, accountId, valuesRepositoryFacade.getReportDefinitionValuesRepository().getReportDefinitions());

    // Run
    mutate(removeReportDefinitionOperation);
  }

}

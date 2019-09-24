/**
 * Copyright (C) 2019 Yahoo Japan Corporation. All Rights Reserved.
 */
package jp.yahooapis.ss.adapisample.basic.campaignexport;

import jp.yahooapis.ss.adapisample.util.SoapUtils;
import jp.yahooapis.ss.v201909.Error;
import jp.yahooapis.ss.v201909.campaignexport.CampaignExportFieldAttribute;
import jp.yahooapis.ss.v201909.campaignexport.CampaignExportFieldValue;
import jp.yahooapis.ss.v201909.campaignexport.CampaignExportPage;
import jp.yahooapis.ss.v201909.campaignexport.CampaignExportReturnValue;
import jp.yahooapis.ss.v201909.campaignexport.CampaignExportService;
import jp.yahooapis.ss.v201909.campaignexport.CampaignExportServiceInterface;
import jp.yahooapis.ss.v201909.campaignexport.CampaignExportValues;
import jp.yahooapis.ss.v201909.campaignexport.Encoding;
import jp.yahooapis.ss.v201909.campaignexport.EntityType;
import jp.yahooapis.ss.v201909.campaignexport.ExportSetting;
import jp.yahooapis.ss.v201909.campaignexport.JobSelector;
import jp.yahooapis.ss.v201909.campaignexport.Lang;
import jp.yahooapis.ss.v201909.campaignexport.Output;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import javax.xml.ws.Holder;

/**
 * example CampaignExportService operation and Utility method collection.
 */
public class CampaignExportServiceSample {

  /**
   * example CampaignExportService operation.
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
      // CampaignExportService getExportFields
      // =================================================================
      // run
      List<CampaignExportFieldAttribute> campaignExportFieldAttributeList = getExportFields();

      List<String> exportFields = new ArrayList<>();
      for (CampaignExportFieldAttribute attribute : campaignExportFieldAttributeList) {
        exportFields.add(attribute.getFieldName());
      }

      // =================================================================
      // CampaignExportService addJob
      // =================================================================
      // create request.
      ExportSetting exportSetting = buildExampleAddJobRequest(accountId, exportFields);

      // Run
      List<CampaignExportValues> addCampaignExportValuesList = addJob(exportSetting);
      Long jobId = null;
      for (CampaignExportValues values : addCampaignExportValuesList) {
        jobId = values.getJob().getJobId();
      }


      // =================================================================
      // CampaignExportService GET
      // =================================================================
      // check job status
      checkStatus(Collections.singletonList(jobId));

      // create request.
      JobSelector selector = buildExampleGetRequest(accountId, Collections.singletonList(jobId));

      // run
      List<CampaignExportValues> campaignExportValuesList = get(selector);

      String downloadUrl = null;
      for (CampaignExportValues campaignExportValues : campaignExportValuesList) {
        downloadUrl = campaignExportValues.getJob().getDownloadUrl();
      }

      // =================================================================
      // CampaignExportService download (http request)
      // =================================================================
      SoapUtils.download(downloadUrl, "campaignExportDownloadSample.csv");

    } catch (Exception e) {
      e.printStackTrace();
      throw e;
    }
  }

  /**
   * example check CampaignExport job status.
   *
   * @param jobIds List<Long>
   * @throws Exception
   */
  public static void checkStatus(List<Long> jobIds) throws Exception {

    // call 30sec sleep * 30 = 15minute
    for (int i = 0; i < 30; i++) {

      // sleep 30 second.
      System.out.println("***** sleep 30 seconds for CampaignExport Job Status Check *****");
      Thread.sleep(30000);

      // get
      JobSelector selector = buildExampleGetRequest(SoapUtils.getAccountId(), jobIds);
      List<CampaignExportValues> campaignExportValuesList = get(selector);

      int completedCount = 0;

      // check status
      for (CampaignExportValues values : campaignExportValuesList) {
        if (values.getJob().getStatus() == null) {
          throw new Exception("Fail to get CampaignExport.");
        }
        switch (values.getJob().getStatus()) {
          default:
          case IN_PROGRESS:
            continue;
          case TIMEOUT:
          case SYSTEM_ERROR:
            throw new Exception("CampaignExport Job Status failed.");
          case COMPLETED:
            completedCount++;
            continue;
        }
      }

      if (campaignExportValuesList.size() == completedCount) {
        return;
      }
    }
    throw new Exception("Fail to get CampaignExport.");
  }

  /**
   * example get request.
   *
   * @param accountId long
   * @param jobIds List<Long>
   * @return JobSelector
   */
  public static JobSelector buildExampleGetRequest(long accountId, List<Long> jobIds) {
    JobSelector selector = new JobSelector();
    selector.setAccountId(accountId);
    selector.getJobIds().addAll(jobIds);
    return selector;
  }

  /**
   * example mutate request.
   *
   * @param accountId long
   * @param exportFields List<String>
   * @return ExportSetting
   */
  public static ExportSetting buildExampleAddJobRequest(long accountId, List<String> exportFields) {
    ExportSetting exportSetting = new ExportSetting();
    exportSetting.setAccountId(accountId);
    exportSetting.setJobName("sampleExport");
    exportSetting.setLang(Lang.EN);
    exportSetting.setOutput(Output.CSV);
    exportSetting.setEncoding(Encoding.UTF_8);
    exportSetting.getEntityTypes().add(EntityType.CAMPAIGN);
    exportSetting.getEntityTypes().add(EntityType.BIDDABLE_AD_GROUP_CRITERION);
    exportSetting.getExportFields().addAll(exportFields);
    return exportSetting;
  }

  /**
   * example addJob CampaignExport.
   *
   * @param exportSetting ExportSetting
   * @return List<CampaignExportValues>
   * @throws Exception
   */
  public static List<CampaignExportValues> addJob(ExportSetting exportSetting) throws Exception {
    // call API
    System.out.println("############################################");
    System.out.println("CampaignExportService::addJob");
    System.out.println("############################################");

    Holder<CampaignExportReturnValue> campaignExportReturnValueHolder = new Holder<>();
    Holder<List<Error>> errorHolder = new Holder<>();
    CampaignExportServiceInterface campaignExportService = SoapUtils.createServiceInterface(CampaignExportServiceInterface.class, CampaignExportService.class);
    campaignExportService.addJob(exportSetting,campaignExportReturnValueHolder,errorHolder);

    SoapUtils.checkSoapError(errorHolder, campaignExportReturnValueHolder.value.getValues());

    return campaignExportReturnValueHolder.value.getValues();
  }

  /**
   * example get CampaignExport.
   *
   * @param selector JobSelector
   * @return List<CampaignExportValues>
   * @throws Exception
   */
  public static List<CampaignExportValues> get(JobSelector selector) throws Exception {

    System.out.println("############################################");
    System.out.println("CampaignExportService::get");
    System.out.println("############################################");

    Holder<CampaignExportPage> campaignExportPageHolder = new Holder<>();
    Holder<List<Error>> errorHolder = new Holder<>();
    CampaignExportServiceInterface campaignExportService = SoapUtils.createServiceInterface(CampaignExportServiceInterface.class, CampaignExportService.class);
    campaignExportService.get(selector, campaignExportPageHolder, errorHolder);

    SoapUtils.checkSoapError(errorHolder, campaignExportPageHolder.value.getValues());

    return campaignExportPageHolder.value.getValues();
  }

  /**
   * example get CampaignExport.
   *
   * @return List<CampaignExportFieldAttribute>
   * @throws Exception
   */
  public static List<CampaignExportFieldAttribute> getExportFields() throws Exception {
    System.out.println("############################################");
    System.out.println("CampaignExportService::getExportFields");
    System.out.println("############################################");
    Holder<CampaignExportFieldValue> campaignExportFieldValueHolder = new Holder<>();
    Holder<List<Error>> errorHolder = new Holder<>();
    CampaignExportServiceInterface campaignExportService = SoapUtils.createServiceInterface(CampaignExportServiceInterface.class, CampaignExportService.class);
    campaignExportService.getExportFields(campaignExportFieldValueHolder,errorHolder);

    SoapUtils.checkSoapError(errorHolder, new ArrayList<>());

    return campaignExportFieldValueHolder.value.getFields();
  }
}

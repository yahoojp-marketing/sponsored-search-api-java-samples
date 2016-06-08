package jp.co.yahoo.ad_api_sample.campaignExportSample;

import jp.co.yahoo.ad_api_sample.error.impl.CampaignExportServiceErrorEntityFactory;
import jp.co.yahoo.ad_api_sample.util.JobTimeoutException;
import jp.co.yahoo.ad_api_sample.util.SoapUtils;
import jp.yahooapis.ss.V6.CampaignExportService.Advanced;
import jp.yahooapis.ss.V6.CampaignExportService.CampaignExportPage;
import jp.yahooapis.ss.V6.CampaignExportService.CampaignExportReturnValue;
import jp.yahooapis.ss.V6.CampaignExportService.CampaignExportService;
import jp.yahooapis.ss.V6.CampaignExportService.CampaignExportServiceInterface;
import jp.yahooapis.ss.V6.CampaignExportService.Encoding;
import jp.yahooapis.ss.V6.CampaignExportService.EntityType;
import jp.yahooapis.ss.V6.CampaignExportService.Error;
import jp.yahooapis.ss.V6.CampaignExportService.ExportSetting;
import jp.yahooapis.ss.V6.CampaignExportService.Job;
import jp.yahooapis.ss.V6.CampaignExportService.JobSelector;
import jp.yahooapis.ss.V6.CampaignExportService.JobStatus;
import jp.yahooapis.ss.V6.CampaignExportService.Lang;
import jp.yahooapis.ss.V6.CampaignExportService.Output;

import java.util.Arrays;
import java.util.List;

import javax.xml.ws.Holder;

/**
 * Sample Program for Campaign Export. Copyright (C) 2016 Yahoo Japan Corporation. All Rights
 * Reserved.
 */
public class CampaignExportSample {

  private CampaignExportServiceInterface service;

  private Long jobId;

  private String jobName;

  private String downloadUrl;

  /**
   * main method for CampaignExportSample
   *
   * @param args command line arguments
   */
  public static void main(String[] args) throws Exception {
    CampaignExportSample exportSample = new CampaignExportSample();
    exportSample.addJob().get().download();
  }

  public CampaignExportSample() throws Exception {
    this.service = SoapUtils.createServiceInterface(CampaignExportServiceInterface.class, CampaignExportService.class);
  }

  /**
   * execute CampaignExportService::addJob
   * @return
   * @throws Exception
   */
  public CampaignExportSample addJob() throws Exception {
    long accountId = SoapUtils.getAccountId();
    this.jobName = "sampleExport";
    ExportSetting setting = new ExportSetting();
    setting.setAccountId(accountId);
    setting.setAdvanced(Advanced.FALSE);
    setting.setJobName(this.jobName);
    setting.getEntityTypes().addAll(Arrays.asList(EntityType.CAMPAIGN,EntityType.BIDDABLE_AD_GROUP_CRITERION));
    setting.setLang(Lang.EN);
    setting.setEncoding(Encoding.UTF_8);
    setting.setOutput(Output.CSV);

    return this.addJob(setting);
  }

  /**
   * execute CampaignExportService::addJob
   * @param setting
   * @return
   * @throws Exception
   */
  public CampaignExportSample addJob(ExportSetting setting) throws Exception{
    System.out.println("############################################");
    System.out.println("CampaignExportService::addJob");
    System.out.println("############################################");

    Holder<CampaignExportReturnValue> returnValue = new Holder<>();
    Holder<List<Error>> errorHolder = new Holder<>();

    this.service.addJob(setting,returnValue,errorHolder);

    if (errorHolder.value != null && errorHolder.value.size() > 0) {
      SoapUtils.displayErrors(new CampaignExportServiceErrorEntityFactory(errorHolder.value));
    } else {
      display(returnValue.value.getValues().get(0).getJob());
    }

    this.jobId = returnValue.value.getValues().get(0).getJob().getJobId();

    return this;
  }

  /**
   * execute CampaignExportService::get
   * @return
   * @throws Exception
   */
  public CampaignExportSample get() throws Exception {

    long accountId = SoapUtils.getAccountId();
    JobSelector selector = new JobSelector();
    selector.setAccountId(accountId);
    selector.getJobIds().add(this.getJobId());

    return this.get(selector);
  }

  /**
   * execute CampaignExportService::get
   * @param selector
   * @return
   * @throws Exception
   */
  public CampaignExportSample get(JobSelector selector) throws Exception {

    System.out.println("############################################");
    System.out.println("CampaignExportService::get");
    System.out.println("############################################");


    for (int i = 0; i < 30; i++) {
      Holder<CampaignExportPage> returnValue = new Holder<>();
      Holder<List<Error>> errorHolder = new Holder<>();
      this.service.get(selector, returnValue, errorHolder);

      if (errorHolder.value != null && errorHolder.value.size() > 0) {
        SoapUtils.displayErrors(new CampaignExportServiceErrorEntityFactory(errorHolder.value));
      } else if (returnValue.value.getValues().size() == 0) {
        throw new IllegalStateException("add job is not exists. jobId=" + this.jobId);
      } else {
        display(returnValue.value.getValues().get(0).getJob());
      }

      if (returnValue.value.getValues().get(0).getJob().getStatus() == JobStatus.COMPLETED) {
        this.jobId = returnValue.value.getValues().get(0).getJob().getJobId();
        this.jobName = returnValue.value.getValues().get(0).getJob().getJobName();
        this.downloadUrl = returnValue.value.getValues().get(0).getJob().getDownloadUrl();
        break;
      }else if(returnValue.value.getValues().get(0).getJob().getStatus() == JobStatus.SYSTEM_ERROR){
        throw new IllegalStateException("export job fail.");
      }
      // sleep 10 second.
      System.out.println("\n***** sleep 10 seconds for Export Job *****\n");
      Thread.sleep(10000);
    }

    if (this.getDownloadUrl() == null) {
      throw new JobTimeoutException("campaign export job is timeout.");
    }
    return this;
  }

  /**
   * execute CampaignExportService::download
   * @throws Exception
   */
  public void download() throws Exception {
    String fileName = "CampaignExport_" + this.getJobName() + "_" + this.getJobId() + ".csv";
    System.out.println("############################################");
    System.out.println("CampaignExportService::download");
    System.out.println("fileName = [" + fileName + "]");
    System.out.println("############################################");
    SoapUtils.download(this.downloadUrl, fileName);
  }

  private void display(Job job) {
    System.out.println("accountId = " + job.getAccountId());
    System.out.println("jobId = " + job.getJobId());
    System.out.println("jobName = " + job.getJobName());
    System.out.println("userName = " + job.getUserName());
    System.out.println("advanced = " + job.getAdvanced());
    System.out.println("status = " + job.getStatus());
    System.out.println("startDate = " + job.getStartDate());
    System.out.println("endDate = " + job.getEndDate());
    System.out.println("progress = " + job.getProgress());
    System.out.println("downloadUrl = " + job.getDownloadUrl());


  }

  public String getDownloadUrl() {
    return downloadUrl;
  }

  public String getJobName() {
    return jobName;
  }

  public Long getJobId() {
    return jobId;
  }
}

package jp.co.yahoo.ad_api_sample.campaignExportSample;

import jp.co.yahoo.ad_api_sample.util.SoapUtils;
import jp.yahooapis.ss.V6.CampaignExportService.CampaignExportFieldAttribute;
import jp.yahooapis.ss.V6.CampaignExportService.Encoding;
import jp.yahooapis.ss.V6.CampaignExportService.EntityType;
import jp.yahooapis.ss.V6.CampaignExportService.ExportSetting;
import jp.yahooapis.ss.V6.CampaignExportService.JobSelector;
import jp.yahooapis.ss.V6.CampaignExportService.Lang;
import jp.yahooapis.ss.V6.CampaignExportService.Output;

import org.junit.Ignore;
import org.junit.Test;

import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNull.notNullValue;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

/**
 * Sample TestCase for AccountSampleTest.
 * Copyright (C) 2016 Yahoo Japan Corporation. All Rights Reserved.
 */
public class CampaignExportSampleTest {

  @Test
  public void testMain() throws Exception{
     CampaignExportSample.main(null);
  }

  @Test
  public void testAddJob() throws Exception{
    Long accountId = SoapUtils.getAccountId();
    ExportSetting setting = new ExportSetting();
    setting.setAccountId(accountId);
    setting.setJobName("Sample_Advanced_Export");
    setting.getEntityTypes().add(EntityType.BIDDABLE_AD_GROUP_CRITERION);
    setting.setOutput(Output.CSV);
    setting.setLang(Lang.EN);
    setting.setEncoding(Encoding.UTF_8);

    CampaignExportSample sample = new CampaignExportSample();
    sample.addJob(setting);

    assertThat(sample.getJobId(),is(notNullValue(Long.class)));

  }

  @Ignore
  @Test
  public void testGet() throws Exception{
    Long accountId = SoapUtils.getAccountId();
    Long jobId = 9999L; // specify jobId
    JobSelector selector = new JobSelector();
    selector.setAccountId(accountId);
    selector.getJobIds().add(jobId);
    CampaignExportSample sample = new CampaignExportSample();
    sample.get(selector);
    assertThat(sample.getDownloadUrl(),is(notNullValue(String.class)));

  }

  @Ignore
  @Test
  public void testGetAndDownload() throws Exception{
    Long accountId = SoapUtils.getAccountId();
    Long jobId = 9999L; // specify jobId
    JobSelector selector = new JobSelector();
    selector.setAccountId(accountId);
    selector.getJobIds().add(jobId);
    CampaignExportSample sample = new CampaignExportSample();
    sample.get(selector).download();
  }

  @Ignore
  @Test
  public void testGetExportFields() throws Exception{
    CampaignExportSample sample = new CampaignExportSample();
    List<CampaignExportFieldAttribute> exportFieldValueList = sample.getExportFields();
    assertTrue(!exportFieldValueList.isEmpty());
  }

}

package jp.co.yahoo.ad_api_sample.auditLogDownloadSample;

import jp.co.yahoo.ad_api_sample.util.SoapUtils;
import jp.yahooapis.ss.v201805.auditlog.AuditLogEncoding;
import jp.yahooapis.ss.v201805.auditlog.AuditLogEventType;
import jp.yahooapis.ss.v201805.auditlog.AuditLogJob;
import jp.yahooapis.ss.v201805.auditlog.AuditLogLang;
import jp.yahooapis.ss.v201805.auditlog.AuditLogOperation;
import jp.yahooapis.ss.v201805.auditlog.AuditLogOutput;
import jp.yahooapis.ss.v201805.auditlog.AuditLogSelector;
import jp.yahooapis.ss.v201805.auditlog.AuditLogValues;
import jp.yahooapis.ss.v201805.auditlog.DateRange;
import jp.yahooapis.ss.v201805.auditlog.EventSelector;

import org.junit.Ignore;
import org.junit.Test;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNull.notNullValue;
import static org.junit.Assert.assertThat;

/**
 * AuditLogDownloadSampleTest
 */
public class AuditLogDownloadSampleTest {

  @Test
  public void testMain() throws Exception {
    AuditLogDownloadSample.main(null);
  }

  @Test
  public void testAddJob() throws Exception {
    Long accountId = SoapUtils.getAccountId();
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
    auditLogJob.setOutput(AuditLogOutput.CSV);
    auditLogJob.setLang(AuditLogLang.EN);
    auditLogJob.setEncoding(AuditLogEncoding.UTF_8);

    AuditLogOperation operation = new AuditLogOperation();
    operation.setAccountId(accountId);
    operation.getOperand().add(auditLogJob);

    List<AuditLogValues> auditLogValues = AuditLogDownloadSample.addJob(operation);
    assertThat(auditLogValues.get(0).getJob().getJobId(), is(notNullValue(Long.class)));

  }

  @Ignore
  @Test
  public void testGet() throws Exception {
    Long accountId = SoapUtils.getAccountId();
    Long jobId = 9999L; // specify jobId
    AuditLogSelector selector = new AuditLogSelector();
    selector.setAccountId(accountId);
    selector.getJobIds().add(jobId);
    List<AuditLogValues> result = AuditLogDownloadSample.get(selector);
    assertThat(result.get(0).getJob().getJobId(), is(notNullValue(Long.class)));

  }

  @Ignore
  @Test
  public void testGetAndDownload() throws Exception {
    String fileName = "AuditLog.log";
    Long accountId = SoapUtils.getAccountId();
    Long jobId = 9999L; // specify jobId
    AuditLogSelector selector = new AuditLogSelector();
    selector.setAccountId(accountId);
    selector.getJobIds().add(jobId);
    List<AuditLogValues> result = AuditLogDownloadSample.get(selector);
    assertThat(result.get(0).getJob().getJobId(), is(notNullValue(Long.class)));
    AuditLogDownloadSample.downloadAuditLog(result.get(0), fileName);
  }

}

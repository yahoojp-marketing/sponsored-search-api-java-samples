package jp.co.yahoo.ad_api_sample.customerSyncSample;

import java.util.List;

import javax.xml.ws.Holder;

import jp.co.yahoo.ad_api_sample.error.impl.CustomerSyncServiceErrorEntityFactory;
import jp.co.yahoo.ad_api_sample.util.SoapUtils;
import jp.yahooapis.ss.V6.CustomerSyncService.Auditlog;
import jp.yahooapis.ss.V6.CustomerSyncService.ChangeDataValues;
import jp.yahooapis.ss.V6.CustomerSyncService.CustomerChangeData;
import jp.yahooapis.ss.V6.CustomerSyncService.CustomerSyncSelector;
import jp.yahooapis.ss.V6.CustomerSyncService.CustomerSyncService;
import jp.yahooapis.ss.V6.CustomerSyncService.CustomerSyncServiceInterface;
import jp.yahooapis.ss.V6.CustomerSyncService.DateRange;
import jp.yahooapis.ss.V6.CustomerSyncService.Error;
import jp.yahooapis.ss.V6.CustomerSyncService.EventType;
import jp.yahooapis.ss.V6.CustomerSyncService.IncludeUnset;
import jp.yahooapis.ss.V6.CustomerSyncService.SourceType;


/**
 * Sample Program for CustomerSyncService. Copyright (C) 2012 Yahoo Japan Corporation. All Rights
 * Reserved.
 */
public class CustomerSyncSample {

  /**
   * main method for CustomerSyncSample
   *
   * @param args command line arguments
   */
  public static void main(String[] args) throws Exception {
    try {
      // =================================================================
      // Setting
      // =================================================================
      long accountId = SoapUtils.getAccountId();

      // =================================================================
      // CustomerSyncService::get
      // =================================================================
      // Set Selector(with accountIds)
      CustomerSyncSelector selector = new CustomerSyncSelector();
      selector.setAccountId(accountId);
      selector.getSourceTypes().add(SourceType.API);
      DateRange dateRange = new DateRange();
      dateRange.setStartDate("-4 day 00:00:00");
      dateRange.setEndDate("+0 day 00:00:00");
      dateRange.setIncludeUnset(IncludeUnset.INCLUDED);
      selector.setDateRange(dateRange);

      // Run
      get(selector);

    } catch (Exception e) {
      e.printStackTrace();
      throw e;
    }
  }

  /**
   * Sample Program for CustomerSyncService GET.
   *
   * @param selector CustomerSyncSelector
   * @return ChangeDataValues
   * @throws Exception
   */
  public static List<ChangeDataValues> get(CustomerSyncSelector selector) throws Exception {

    // call API
    System.out.println("############################################");
    System.out.println("CustomerSyncService::get");
    System.out.println("############################################");

    Holder<CustomerChangeData> customerChangeDataHolder = new Holder<CustomerChangeData>();
    Holder<List<Error>> customerSyncErrorHolder = new Holder<List<Error>>();
    CustomerSyncServiceInterface customerSyncService = SoapUtils.createServiceInterface(CustomerSyncServiceInterface.class, CustomerSyncService.class);
    customerSyncService.get(selector, customerChangeDataHolder, customerSyncErrorHolder);

    // Error
    if (customerSyncErrorHolder.value != null && customerSyncErrorHolder.value.size() > 0) {
      SoapUtils.displayErrors(new CustomerSyncServiceErrorEntityFactory(customerSyncErrorHolder.value), true);
    }
    if (customerSyncErrorHolder.value == null) {
      throw new Exception("NoDataResponse:CustomerSyncService Get");
    }

    // Display
    for (ChangeDataValues changeDataValues : customerChangeDataHolder.value.getValues()) {
      if (changeDataValues.isOperationSucceeded()) {
        for (Auditlog auditlog : changeDataValues.getAuditlog()) {
          display(auditlog);
        }
      } else {
        SoapUtils.displayErrors(new CustomerSyncServiceErrorEntityFactory(changeDataValues.getError()), false);
      }
    }

    // Response
    return customerChangeDataHolder.value.getValues();
  }

  /**
   * display auditlog entity to stdout.
   *
   * @param auditlog account entity for display.
   */
  private static void display(Auditlog auditlog) {
    System.out.println("updatedTime = " + auditlog.getUpdatedTime());
    System.out.println("entityType = " + auditlog.getEntityType());
    if (auditlog.getEventType() != null) {
      for (EventType eventType : auditlog.getEventType()) {
        System.out.println("eventType = " + eventType);
      }
    }
    System.out.println("sourceType = " + auditlog.getSourceType());
    System.out.println("accountId = " + auditlog.getAccountId());
    System.out.println("campaignId = " + auditlog.getCampaignId());
    System.out.println("adGroupId = " + auditlog.getAdGroupId());
    System.out.println("criterionId = " + auditlog.getCriterionId());
    System.out.println("adId = " + auditlog.getAdId());
    System.out.println("feedItemId = " + auditlog.getFeedItemId());
    System.out.println("biddingStrategyId = " + auditlog.getBiddingStrategyId());
    System.out.println("feedFolderId = " + auditlog.getFeedFolderId());
    System.out.println("targetListId = " + auditlog.getTargetListId());
    System.out.println("---------");
  }
}

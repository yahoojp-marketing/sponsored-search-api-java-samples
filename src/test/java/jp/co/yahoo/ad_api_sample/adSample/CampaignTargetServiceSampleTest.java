package jp.co.yahoo.ad_api_sample.adSample;

import jp.co.yahoo.ad_api_sample.util.SoapUtils;
import jp.yahooapis.ss.V6.CampaignService.CampaignOperation;
import jp.yahooapis.ss.V6.CampaignService.CampaignSelector;
import jp.yahooapis.ss.V6.CampaignService.CampaignValues;
import jp.yahooapis.ss.V6.CampaignService.UrlApprovalStatus;
import jp.yahooapis.ss.V6.CampaignTargetService.CampaignTargetOperation;
import jp.yahooapis.ss.V6.CampaignTargetService.CampaignTargetSelector;
import jp.yahooapis.ss.V6.CampaignTargetService.CampaignTargetValues;
import jp.yahooapis.ss.V6.CampaignTargetService.Paging;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNull.notNullValue;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;

/**
 * Sample TestCase for CampaignTargetServiceSampleTest. Copyright (C) 2012 Yahoo Japan Corporation.
 * All Rights Reserved.
 */
public class CampaignTargetServiceSampleTest {

  /**
   * Setting
   */
  private long accountId;
  private long campaignId;
  private long appCampaignId;
  private List<CampaignValues> addCampaignValues;

  @Before
  public void setup() {
    accountId = SoapUtils.getAccountId();
    long biddingStrategyId = SoapUtils.getBiddingStrategyId();

    // Create Campaign
    CampaignOperation campaignOperation = CampaignServiceSample.createSampleAddRequest(accountId, biddingStrategyId);

    // Run
    addCampaignValues = null;
    try {
      addCampaignValues = CampaignServiceSample.add(campaignOperation);

      boolean allApproved = true;
      // call 30sec sleep * 30 = 15minute
      for (int i = 0; i < 30; i++) {
        // sleep 30 second.
        System.out.println("\n***** sleep 30 seconds for Get Campaign  *****\n");
        Thread.sleep(30000);

        // =================================================================
        // CampaignService::GET
        // =================================================================
        // Set Selector
        CampaignSelector campaignSelector = CampaignServiceSample.createSampleGetRequest(accountId, addCampaignValues);

        // Run
        List<CampaignValues> getCampaignValues = CampaignServiceSample.get(campaignSelector);

        allApproved = true;
        for (CampaignValues campaignValues : getCampaignValues) {
          if (!UrlApprovalStatus.APPROVED.equals(campaignValues.getCampaign().getUrlReviewData().getUrlApprovalStatus())
              && !UrlApprovalStatus.NONE.equals(campaignValues.getCampaign().getUrlReviewData().getUrlApprovalStatus())) {
            allApproved = false;
          } else if (UrlApprovalStatus.DISAPPROVED.equals(campaignValues.getCampaign().getUrlReviewData().getUrlApprovalStatus())) {
            System.out.println("Error : This campaign was denied.");
            campaignValues.getCampaign().getUrlReviewData().getDisapprovalReasonCodes().stream().forEach(
                disapprovalReasonCode -> System.out.println("disapprovalReasonCode:[" + disapprovalReasonCode + "]")
            );
          }
        }
        if (allApproved) {
          break;
        }
      }
    } catch (Exception e) {
      fail();
    }

    // get AutoBidding CampaignId
    campaignId = addCampaignValues.get(0).getCampaign().getCampaignId();
    // get App Campaign
    appCampaignId = addCampaignValues.get(2).getCampaign().getCampaignId();

  }

  @After
  public void teardown() {
    try {
      // =================================================================
      // CampaignService::REMOVE
      // =================================================================
      // Set Operation
      CampaignOperation removeCampaignOperation = CampaignServiceSample.createSampleRemoveRequest(accountId, addCampaignValues);

      // Run
      CampaignServiceSample.remove(removeCampaignOperation);
    } catch (Exception e) {
      fail();
    }
  }

  /**
   * Sample TestCase of main method for CampaignTargetServiceSample.
   */
  @Test
  public void testMain() throws Exception {
    // Run
    try {
      CampaignTargetServiceSample.main(new String[]{String.valueOf(campaignId), String.valueOf(appCampaignId)});
    } catch (Exception e) {
      fail();
    }
  }

  /**
   * Sample TestCase of add method for CampaignTargetServiceSample.
   */
  @Test
  public void testAdd() throws Exception {


    // Set Operation
    CampaignTargetOperation addCampaignTargetOperation = CampaignTargetServiceSample.createSampleAddRequest(accountId, campaignId, appCampaignId);

    // Run
    List<CampaignTargetValues> addCampaignTargetValues = null;
    try {
      addCampaignTargetValues = CampaignTargetServiceSample.add(addCampaignTargetOperation);
    } catch (Exception e) {
      fail();
    }

    // Assert
    for (CampaignTargetValues campaignTargetValue : addCampaignTargetValues) {
      assertThat(campaignTargetValue.isOperationSucceeded(), is(true));
      assertThat(campaignTargetValue.getCampaignTarget().getAccountId(), is(notNullValue()));
    }

  }

  /**
   * Sample TestCase of set method for CampaignTargetServiceSample.
   */
  @Test
  public void testSet() throws Exception {
    // =================================================================
    // CampaignTargetService::ADD
    // =================================================================
    List<CampaignTargetValues> addCampaignTargetValues = null;
    CampaignTargetOperation addCampaignTargetOperation = CampaignTargetServiceSample.createSampleAddRequest(accountId, campaignId, appCampaignId);
    try {
      addCampaignTargetValues = CampaignTargetServiceSample.add(addCampaignTargetOperation);
    } catch (Exception e) {
      fail();
    }

    // =================================================================
    // CampaignTargetService::SET
    // =================================================================
    // Set Operation
    CampaignTargetOperation setCampaignTargetOperation = CampaignTargetServiceSample.createSampleSetRequest(accountId, addCampaignTargetValues);

    // Run
    List<CampaignTargetValues> setCampaignTargetValues = null;
    try {
      setCampaignTargetValues = CampaignTargetServiceSample.set(setCampaignTargetOperation);
    } catch (Exception e) {
      fail();
    }

    // Assert
    for (CampaignTargetValues campaignTargetValue : setCampaignTargetValues) {
      assertThat(campaignTargetValue.isOperationSucceeded(), is(true));
      assertThat(campaignTargetValue.getCampaignTarget().getAccountId(), is(notNullValue()));
    }
  }

  /**
   * Sample TestCase of remove method for CampaignTargetServiceSample.
   */
  @Test
  public void testRemove() throws Exception {
    // =================================================================
    // CampaignTargetService::ADD
    // =================================================================
    List<CampaignTargetValues> addCampaignTargetValues = null;
    try {
      CampaignTargetOperation addCampaignTargetOperation = CampaignTargetServiceSample.createSampleAddRequest(accountId, campaignId, appCampaignId);
      addCampaignTargetValues = CampaignTargetServiceSample.add(addCampaignTargetOperation);
    } catch (Exception e) {
      fail();
    }

    // =================================================================
    // CampaignTargetService::REMOVE
    // =================================================================
    // Set Operation
    CampaignTargetOperation removeCampaignTargetOperation = CampaignTargetServiceSample.createSampleRemoveRequest(accountId, addCampaignTargetValues);

    // Run
    List<CampaignTargetValues> removeCampaignTargetValues = null;
    try {
      removeCampaignTargetValues = CampaignTargetServiceSample.remove(removeCampaignTargetOperation);
    } catch (Exception e) {
      fail();
    }

    // Assert
    for (CampaignTargetValues campaignTargetValue : removeCampaignTargetValues) {
      assertThat(campaignTargetValue.isOperationSucceeded(), is(true));
      assertThat(campaignTargetValue.getCampaignTarget().getAccountId(), is(notNullValue()));
    }
  }

  /**
   * Sample TestCase of get method for CampaignTargetServiceSample.
   */
  @Test
  public void testGet() throws Exception {
    // Set Selector
    CampaignTargetSelector campaignTargetSelector = new CampaignTargetSelector();
    campaignTargetSelector.setAccountId(accountId);

    Paging paging = new Paging();
    paging.setStartIndex(1);
    paging.setNumberResults(20);
    campaignTargetSelector.setPaging(paging);

    // Run
    List<CampaignTargetValues> getCampaignTargetValues = null;
    try {
      getCampaignTargetValues = CampaignTargetServiceSample.get(campaignTargetSelector);
    } catch (Exception e) {
      fail();
    }

    // Assert
    for (CampaignTargetValues campaignTargetValue : getCampaignTargetValues) {
      assertThat(campaignTargetValue.isOperationSucceeded(), is(true));
      assertThat(campaignTargetValue.getCampaignTarget().getAccountId(), is(notNullValue()));
    }
  }
}

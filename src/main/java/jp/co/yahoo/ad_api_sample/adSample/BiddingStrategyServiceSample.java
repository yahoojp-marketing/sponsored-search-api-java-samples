package jp.co.yahoo.ad_api_sample.adSample;

import java.util.Arrays;
import java.util.List;

import javax.xml.ws.Holder;

import jp.co.yahoo.ad_api_sample.error.impl.BiddingStrategyServiceErrorEntityFactory;
import jp.co.yahoo.ad_api_sample.util.SoapUtils;
import jp.yahooapis.ss.v201805.biddingstrategy.BidChangesForRaisesOnly;
import jp.yahooapis.ss.v201805.biddingstrategy.BiddingStrategy;
import jp.yahooapis.ss.v201805.biddingstrategy.BiddingStrategyOperation;
import jp.yahooapis.ss.v201805.biddingstrategy.BiddingStrategyPage;
import jp.yahooapis.ss.v201805.biddingstrategy.BiddingStrategyReturnValue;
import jp.yahooapis.ss.v201805.biddingstrategy.BiddingStrategySelector;
import jp.yahooapis.ss.v201805.biddingstrategy.BiddingStrategyService;
import jp.yahooapis.ss.v201805.biddingstrategy.BiddingStrategyServiceInterface;
import jp.yahooapis.ss.v201805.biddingstrategy.BiddingStrategyType;
import jp.yahooapis.ss.v201805.biddingstrategy.BiddingStrategyValues;
import jp.yahooapis.ss.v201805.biddingstrategy.EnhancedCpcBiddingScheme;
import jp.yahooapis.ss.v201805.Error;
import jp.yahooapis.ss.v201805.biddingstrategy.Operator;
import jp.yahooapis.ss.v201805.biddingstrategy.PageOnePromotedBiddingScheme;
import jp.yahooapis.ss.v201805.Paging;
import jp.yahooapis.ss.v201805.biddingstrategy.RaiseBidWhenBudgetConstrained;
import jp.yahooapis.ss.v201805.biddingstrategy.RaiseBidWhenLowQualityScore;
import jp.yahooapis.ss.v201805.biddingstrategy.TargetCpaBiddingScheme;
import jp.yahooapis.ss.v201805.biddingstrategy.TargetRoasBiddingScheme;
import jp.yahooapis.ss.v201805.biddingstrategy.TargetSpendBiddingScheme;

/**
 * Sample Program for BiddingStrategyService. Copyright (C) 2012 Yahoo Japan Corporation. All Rights
 * Reserved.
 */
public class BiddingStrategyServiceSample {

  /**
   * main method for BiddingStrategyServiceSample
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
      // BiddingStrategyService::ADD
      // =================================================================
      // Set Operation
      BiddingStrategyOperation addBiddingStrategyOperation = createSampleAddRequest(accountId);

      // Run
      List<BiddingStrategyValues> biddingStrategyValues = mutate(addBiddingStrategyOperation);

      // =================================================================
      // BiddingStrategyService::GET
      // =================================================================
      // Set Selector
      BiddingStrategySelector biddingStrategySelector = createSampleGetRequest(accountId, biddingStrategyValues);

      // Run
      get(biddingStrategySelector);

      // =================================================================
      // BiddingStrategyService::SET
      // =================================================================
      // Set Operation
      BiddingStrategyOperation setBiddingStrategyOperation = createSampleSetRequest(accountId, biddingStrategyValues);

      // Run
      mutate(setBiddingStrategyOperation);

      // =================================================================
      // BiddingStrategyService::REMOVE
      // =================================================================
      // Set Operation
      BiddingStrategyOperation removeBiddingStrategyOperation = createSampleRemoveRequest(accountId, biddingStrategyValues);

      // Run
      mutate(removeBiddingStrategyOperation);

    } catch (Exception e) {
      e.printStackTrace();
      throw e;
    }
  }

  /**
   * Sample Program for BiddingStrategyService MUTATE.
   *
   * @param operation BiddingStrategyOperation
   * @return BiddingStrategyValues
   * @throws Exception
   */
  public static List<BiddingStrategyValues> mutate(BiddingStrategyOperation operation) throws Exception {

    // Call API
    System.out.println("############################################");
    System.out.println("BiddingStrategyService::mutate(" + operation.getOperator() + ")");
    System.out.println("############################################");

    Holder<BiddingStrategyReturnValue> biddingStrategyReturnValueHolder = new Holder<BiddingStrategyReturnValue>();
    Holder<List<Error>> errorHolder = new Holder<List<Error>>();
    BiddingStrategyServiceInterface biddingStrategyService = SoapUtils.createServiceInterface(BiddingStrategyServiceInterface.class, BiddingStrategyService.class);
    biddingStrategyService.mutate(operation, biddingStrategyReturnValueHolder, errorHolder);

    // Error
    if (errorHolder.value != null && errorHolder.value.size() > 0) {
      SoapUtils.displayErrors(new BiddingStrategyServiceErrorEntityFactory(errorHolder.value), true);
    }
    if (biddingStrategyReturnValueHolder.value == null) {
      throw new Exception("NoDataResponse:BiddingStrategyService " + operation.getOperator());
    }

    // Display
    for (BiddingStrategyValues biddingStrategyValues : biddingStrategyReturnValueHolder.value.getValues()) {
      if (biddingStrategyValues.isOperationSucceeded()) {
        display(biddingStrategyValues.getBiddingStrategy());
      } else {
        SoapUtils.displayErrors(new BiddingStrategyServiceErrorEntityFactory(biddingStrategyValues.getError()), true);
      }
    }

    // Response
    return biddingStrategyReturnValueHolder.value.getValues();
  }

  /**
   * Sample Program for BiddingStrategyService GET.
   *
   * @param selector BiddingStrategySelector
   * @return BiddingStrategyValues
   * @throws Exception
   */
  public static List<BiddingStrategyValues> get(BiddingStrategySelector selector) throws Exception {

    // Call API
    System.out.println("############################################");
    System.out.println("BiddingStrategyService::get");
    System.out.println("############################################");

    Holder<BiddingStrategyPage> biddingStrategyPageHolder = new Holder<BiddingStrategyPage>();
    Holder<List<Error>> errorHolder = new Holder<List<Error>>();
    BiddingStrategyServiceInterface biddingStrategyService = SoapUtils.createServiceInterface(BiddingStrategyServiceInterface.class, BiddingStrategyService.class);
    biddingStrategyService.get(selector, biddingStrategyPageHolder, errorHolder);

    // Error
    if (errorHolder.value != null && errorHolder.value.size() > 0) {
      SoapUtils.displayErrors(new BiddingStrategyServiceErrorEntityFactory(errorHolder.value), true);
    }
    if (biddingStrategyPageHolder.value == null) {
      throw new Exception("NoDataResponse:BiddingStrategyService Get");
    }

    // Display
    for (BiddingStrategyValues biddingStrategyValues : biddingStrategyPageHolder.value.getValues()) {
      if (biddingStrategyValues.isOperationSucceeded()) {
        display(biddingStrategyValues.getBiddingStrategy());
      } else {
        SoapUtils.displayErrors(new BiddingStrategyServiceErrorEntityFactory(biddingStrategyValues.getError()), true);
      }
    }

    // Response
    return biddingStrategyPageHolder.value.getValues();
  }

  /**
   * display BiddingStrategy entity to stdout.
   *
   * @param biddingStrategy BiddingStrategy entity for display.
   */
  public static void display(BiddingStrategy biddingStrategy) {

    System.out.println("accountId = " + biddingStrategy.getAccountId());
    System.out.println("biddingStrategyId = " + biddingStrategy.getBiddingStrategyId());
    System.out.println("biddingStrategyName = " + biddingStrategy.getBiddingStrategyName());
    System.out.println("biddingStrategyType = " + biddingStrategy.getBiddingStrategyType());

    if (biddingStrategy.getBiddingScheme() instanceof EnhancedCpcBiddingScheme) {
      EnhancedCpcBiddingScheme enhancedCpcBiddingScheme = (EnhancedCpcBiddingScheme) biddingStrategy.getBiddingScheme();
      System.out.println("biddingScheme(EnhancedCpcBiddingScheme)/biddingStrategyType = " + enhancedCpcBiddingScheme.getBiddingStrategyType());
    } else if (biddingStrategy.getBiddingScheme() instanceof PageOnePromotedBiddingScheme) {
      PageOnePromotedBiddingScheme pageOnePromotedBiddingScheme = (PageOnePromotedBiddingScheme) biddingStrategy.getBiddingScheme();
      System.out.println("biddingScheme(PageOnePromotedBiddingScheme)/biddingStrategyType = " + pageOnePromotedBiddingScheme.getBiddingStrategyType());
      System.out.println("biddingScheme(PageOnePromotedBiddingScheme)/bidCeiling = " + pageOnePromotedBiddingScheme.getBidCeiling());
      System.out.println("biddingScheme(PageOnePromotedBiddingScheme)/bidMultiplier = " + pageOnePromotedBiddingScheme.getBidMultiplier());
      System.out.println("biddingScheme(PageOnePromotedBiddingScheme)/bidChangesForRaisesOnly = " + pageOnePromotedBiddingScheme.getBidChangesForRaisesOnly());
      System.out.println("biddingScheme(PageOnePromotedBiddingScheme)/raiseBidWhenBudgetConstrained = " + pageOnePromotedBiddingScheme.getRaiseBidWhenBudgetConstrained());
      System.out.println("biddingScheme(PageOnePromotedBiddingScheme)/raiseBidWhenLowQualityScore = " + pageOnePromotedBiddingScheme.getRaiseBidWhenLowQualityScore());
    } else if (biddingStrategy.getBiddingScheme() instanceof TargetCpaBiddingScheme) {
      TargetCpaBiddingScheme targetCpaBiddingScheme = (TargetCpaBiddingScheme) biddingStrategy.getBiddingScheme();
      System.out.println("biddingScheme(TargetCpaBiddingScheme)/biddingStrategyType = " + targetCpaBiddingScheme.getBiddingStrategyType());
      System.out.println("biddingScheme(TargetCpaBiddingScheme)/targetCpa = " + targetCpaBiddingScheme.getTargetCpa());
      System.out.println("biddingScheme(TargetCpaBiddingScheme)/bidCeiling = " + targetCpaBiddingScheme.getBidCeiling());
      System.out.println("biddingScheme(TargetCpaBiddingScheme)/bidFloor = " + targetCpaBiddingScheme.getBidFloor());
    } else if (biddingStrategy.getBiddingScheme() instanceof TargetSpendBiddingScheme) {
      TargetSpendBiddingScheme targetSpendBiddingScheme = (TargetSpendBiddingScheme) biddingStrategy.getBiddingScheme();
      System.out.println("biddingScheme(TargetSpendBiddingScheme)/biddingStrategyType = " + targetSpendBiddingScheme.getBiddingStrategyType());
      System.out.println("biddingScheme(TargetSpendBiddingScheme)/bidCeiling = " + targetSpendBiddingScheme.getBidCeiling());
      System.out.println("biddingScheme(TargetSpendBiddingScheme)/spendTarget = " + targetSpendBiddingScheme.getSpendTarget());
    } else if (biddingStrategy.getBiddingScheme() instanceof TargetRoasBiddingScheme) {
      TargetRoasBiddingScheme targetRoasBiddingScheme = (TargetRoasBiddingScheme) biddingStrategy.getBiddingScheme();
      System.out.println("biddingScheme(TargetRoasBiddingScheme)/biddingStrategyType = " + targetRoasBiddingScheme.getBiddingStrategyType());
      System.out.println("biddingScheme(TargetRoasBiddingScheme)/targetRoas = " + targetRoasBiddingScheme.getTargetRoas());
      System.out.println("biddingScheme(TargetRoasBiddingScheme)/bidCeiling = " + targetRoasBiddingScheme.getBidCeiling());
      System.out.println("biddingScheme(TargetRoasBiddingScheme)/bidFloor = " + targetRoasBiddingScheme.getBidFloor());
    }

    System.out.println("---------");
  }

  /**
   * create sample request.
   * 
   * @param accountId long
   * @return BiddingStrategyOperation
   */
  public static BiddingStrategyOperation createSampleAddRequest(long accountId) {
    // Set Operation
    BiddingStrategyOperation operation = new BiddingStrategyOperation();
    operation.setOperator(Operator.ADD);
    operation.setAccountId(accountId);

    // Set EnhancedCpcBidding
    EnhancedCpcBiddingScheme addEnhancedCpcBiddingScheme = new EnhancedCpcBiddingScheme();
    addEnhancedCpcBiddingScheme.setBiddingStrategyType(BiddingStrategyType.ENHANCED_CPC);

    BiddingStrategy enhancedCpcBidding = new BiddingStrategy();
    enhancedCpcBidding.setAccountId(accountId);
    enhancedCpcBidding.setBiddingStrategyName("SampleEnhancedCpc_CreateOn_" + SoapUtils.getCurrentTimestamp());
    enhancedCpcBidding.setBiddingScheme(addEnhancedCpcBiddingScheme);

    // Set PageOnePromotedBidding
    PageOnePromotedBiddingScheme addPageOnePromotedBiddingScheme = new PageOnePromotedBiddingScheme();
    addPageOnePromotedBiddingScheme.setBiddingStrategyType(BiddingStrategyType.PAGE_ONE_PROMOTED);
    addPageOnePromotedBiddingScheme.setBidCeiling((long) 500);
    addPageOnePromotedBiddingScheme.setBidMultiplier(1.00);
    addPageOnePromotedBiddingScheme.setBidChangesForRaisesOnly(BidChangesForRaisesOnly.ACTIVE);
    addPageOnePromotedBiddingScheme.setRaiseBidWhenBudgetConstrained(RaiseBidWhenBudgetConstrained.ACTIVE);
    addPageOnePromotedBiddingScheme.setRaiseBidWhenLowQualityScore(RaiseBidWhenLowQualityScore.ACTIVE);

    BiddingStrategy pageOnePromotedBidding = new BiddingStrategy();
    pageOnePromotedBidding.setAccountId(accountId);
    pageOnePromotedBidding.setBiddingStrategyName("SamplePageOnePromoted_CreateOn_" + SoapUtils.getCurrentTimestamp());
    pageOnePromotedBidding.setBiddingScheme(addPageOnePromotedBiddingScheme);

    // Set TargetCpaBidding
    TargetCpaBiddingScheme addTargetCpaBiddingScheme = new TargetCpaBiddingScheme();
    addTargetCpaBiddingScheme.setBiddingStrategyType(BiddingStrategyType.TARGET_CPA);
    addTargetCpaBiddingScheme.setTargetCpa((long) 500);
    addTargetCpaBiddingScheme.setBidCeiling((long) 700);

    BiddingStrategy targetCpaBidding = new BiddingStrategy();
    targetCpaBidding.setAccountId(accountId);
    targetCpaBidding.setBiddingStrategyName("SampleTargetCpa_CreateOn_" + SoapUtils.getCurrentTimestamp());
    targetCpaBidding.setBiddingScheme(addTargetCpaBiddingScheme);

    // Set TargetSpendBidding
    TargetSpendBiddingScheme addTargetSpendBiddingScheme = new TargetSpendBiddingScheme();
    addTargetSpendBiddingScheme.setBiddingStrategyType(BiddingStrategyType.TARGET_SPEND);
    addTargetSpendBiddingScheme.setBidCeiling((long) 700);
    addTargetSpendBiddingScheme.setSpendTarget((long) 10);

    BiddingStrategy targetSpendBidding = new BiddingStrategy();
    targetSpendBidding.setAccountId(accountId);
    targetSpendBidding.setBiddingStrategyName("SampleTargetSpend_CreateOn_" + SoapUtils.getCurrentTimestamp());
    targetSpendBidding.setBiddingScheme(addTargetSpendBiddingScheme);

    // Set TargetRoasBidding
    TargetRoasBiddingScheme addTargetRoasBiddingScheme = new TargetRoasBiddingScheme();
    addTargetRoasBiddingScheme.setBiddingStrategyType(BiddingStrategyType.TARGET_ROAS);
    addTargetRoasBiddingScheme.setTargetRoas(10.00);
    addTargetRoasBiddingScheme.setBidCeiling((long) 700);
    addTargetRoasBiddingScheme.setBidFloor((long) 600);

    BiddingStrategy targetRoasBidding = new BiddingStrategy();
    targetRoasBidding.setAccountId(accountId);
    targetRoasBidding.setBiddingStrategyName("SampleTargetRoas_CreateOn_" + SoapUtils.getCurrentTimestamp());
    targetRoasBidding.setBiddingScheme(addTargetRoasBiddingScheme);

    operation.getOperand().addAll(Arrays.asList(enhancedCpcBidding, pageOnePromotedBidding, targetCpaBidding, targetSpendBidding, targetRoasBidding));

    return operation;
  }

  /**
   * create sample request.
   * 
   * @param accountId long
   * @param biddingStrategyValues BiddingStrategyValues
   * @return BiddingStrategyOperation
   */
  public static BiddingStrategyOperation createSampleSetRequest(long accountId, List<BiddingStrategyValues> biddingStrategyValues) {
    // Set Operation
    BiddingStrategyOperation operation = new BiddingStrategyOperation();
    operation.setOperator(Operator.SET);
    operation.setAccountId(accountId);

    // Set Operand
    for (BiddingStrategyValues biddingStrategyValue : biddingStrategyValues) {

      BiddingStrategy biddingStrategy = new BiddingStrategy();

      biddingStrategy.setAccountId(biddingStrategyValue.getBiddingStrategy().getAccountId());
      biddingStrategy.setBiddingStrategyId(biddingStrategyValue.getBiddingStrategy().getBiddingStrategyId());

      // Set BiddingScheme
      if (biddingStrategyValue.getBiddingStrategy().getBiddingScheme() instanceof EnhancedCpcBiddingScheme) {

        // Set EnhancedCpcBidding
        biddingStrategy.setBiddingStrategyName("SampleEnhancedCpc_UpdateOn_" + SoapUtils.getCurrentTimestamp());

        EnhancedCpcBiddingScheme setEnhancedCpcBiddingScheme = new EnhancedCpcBiddingScheme();
        setEnhancedCpcBiddingScheme.setBiddingStrategyType(BiddingStrategyType.ENHANCED_CPC);
        biddingStrategy.setBiddingScheme(setEnhancedCpcBiddingScheme);

      } else if (biddingStrategyValue.getBiddingStrategy().getBiddingScheme() instanceof PageOnePromotedBiddingScheme) {

        // Set PageOnePromotedBidding
        biddingStrategy.setBiddingStrategyName("SamplePageOnePromoted_UpdateOn_" + SoapUtils.getCurrentTimestamp());

        PageOnePromotedBiddingScheme setPageOnePromotedBiddingScheme = new PageOnePromotedBiddingScheme();
        setPageOnePromotedBiddingScheme.setBiddingStrategyType(BiddingStrategyType.PAGE_ONE_PROMOTED);
        setPageOnePromotedBiddingScheme.setBidCeiling((long) 550);
        setPageOnePromotedBiddingScheme.setBidMultiplier(5.00);
        setPageOnePromotedBiddingScheme.setBidChangesForRaisesOnly(BidChangesForRaisesOnly.DEACTIVE);
        setPageOnePromotedBiddingScheme.setRaiseBidWhenBudgetConstrained(RaiseBidWhenBudgetConstrained.DEACTIVE);
        setPageOnePromotedBiddingScheme.setRaiseBidWhenLowQualityScore(RaiseBidWhenLowQualityScore.DEACTIVE);
        biddingStrategy.setBiddingScheme(setPageOnePromotedBiddingScheme);

      } else if (biddingStrategyValue.getBiddingStrategy().getBiddingScheme() instanceof TargetCpaBiddingScheme) {

        // Set TargetCpaBidding
        biddingStrategy.setBiddingStrategyName("SampleTargetCpa_UpdateOn_" + SoapUtils.getCurrentTimestamp());

        TargetCpaBiddingScheme setTargetCpaBiddingScheme = new TargetCpaBiddingScheme();
        setTargetCpaBiddingScheme.setBiddingStrategyType(BiddingStrategyType.TARGET_CPA);
        setTargetCpaBiddingScheme.setTargetCpa((long) 550);
        setTargetCpaBiddingScheme.setBidCeiling((long) 750);
        biddingStrategy.setBiddingScheme(setTargetCpaBiddingScheme);

      } else if (biddingStrategyValue.getBiddingStrategy().getBiddingScheme() instanceof TargetSpendBiddingScheme) {

        // Set TargetSpendBidding
        biddingStrategy.setBiddingStrategyName("SampleTargetSpend_UpdateOn_" + SoapUtils.getCurrentTimestamp());

        TargetSpendBiddingScheme setTargetSpendBiddingScheme = new TargetSpendBiddingScheme();
        setTargetSpendBiddingScheme.setBiddingStrategyType(BiddingStrategyType.TARGET_SPEND);
        setTargetSpendBiddingScheme.setBidCeiling((long) 750);
        setTargetSpendBiddingScheme.setSpendTarget((long) 15);
        biddingStrategy.setBiddingScheme(setTargetSpendBiddingScheme);

      } else if (biddingStrategyValue.getBiddingStrategy().getBiddingScheme() instanceof TargetRoasBiddingScheme) {

        // Set TargetRoasBidding
        biddingStrategy.setBiddingStrategyName("SampleTargetRoas_UpdateOn_" + SoapUtils.getCurrentTimestamp());

        TargetRoasBiddingScheme setTargetRoasBiddingScheme = new TargetRoasBiddingScheme();
        setTargetRoasBiddingScheme.setBiddingStrategyType(BiddingStrategyType.TARGET_ROAS);
        setTargetRoasBiddingScheme.setTargetRoas(15.00);
        setTargetRoasBiddingScheme.setBidCeiling((long) 750);
        setTargetRoasBiddingScheme.setBidFloor((long) 650);
        biddingStrategy.setBiddingScheme(setTargetRoasBiddingScheme);
      }

      operation.getOperand().add(biddingStrategy);
    }

    return operation;
  }

  /**
   * create sample request.
   * 
   * @param accountId long
   * @param biddingStrategyValues BiddingStrategyValues
   * @return BiddingStrategyOperation
   */
  public static BiddingStrategyOperation createSampleRemoveRequest(long accountId, List<BiddingStrategyValues> biddingStrategyValues) {
    // Set Operation
    BiddingStrategyOperation operation = new BiddingStrategyOperation();
    operation.setOperator(Operator.REMOVE);
    operation.setAccountId(accountId);

    // Set Operand
    for (BiddingStrategyValues biddingStrategyValue : biddingStrategyValues) {

      BiddingStrategy biddingStrategy = new BiddingStrategy();

      biddingStrategy.setAccountId(biddingStrategyValue.getBiddingStrategy().getAccountId());
      biddingStrategy.setBiddingStrategyId(biddingStrategyValue.getBiddingStrategy().getBiddingStrategyId());

      operation.getOperand().add(biddingStrategy);
    }

    return operation;
  }

  /**
   * create sample request.
   * 
   * @param accountId long
   * @param biddingStrategyValues BiddingStrategyValues
   * @return BiddingStrategySelector
   */
  public static BiddingStrategySelector createSampleGetRequest(long accountId, List<BiddingStrategyValues> biddingStrategyValues) {
    // Set Selector
    BiddingStrategySelector selector = new BiddingStrategySelector();
    selector.setAccountId(accountId);
    for (BiddingStrategyValues biddingStrategyValue : biddingStrategyValues) {
      selector.getBiddingStrategyIds().add((biddingStrategyValue.getBiddingStrategy().getBiddingStrategyId()));
    }
    selector.getBiddingStrategyTypes().addAll(
        Arrays.asList(BiddingStrategyType.ENHANCED_CPC, BiddingStrategyType.PAGE_ONE_PROMOTED, BiddingStrategyType.TARGET_CPA, BiddingStrategyType.TARGET_SPEND, BiddingStrategyType.TARGET_ROAS));
    Paging paging = new Paging();
    paging.setStartIndex(1);
    paging.setNumberResults(20);
    selector.setPaging(paging);

    return selector;
  }
}

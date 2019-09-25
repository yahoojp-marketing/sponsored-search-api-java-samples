/**
 * Copyright (C) 2019 Yahoo Japan Corporation. All Rights Reserved.
 */
package jp.yahooapis.ss.adapisample.basic.biddingstrategy;

import jp.yahooapis.ss.adapisample.repository.ValuesRepositoryFacade;
import jp.yahooapis.ss.adapisample.util.SoapUtils;
import jp.yahooapis.ss.adapisample.util.ValuesHolder;
import jp.yahooapis.ss.v201909.Error;
import jp.yahooapis.ss.v201909.Paging;
import jp.yahooapis.ss.v201909.biddingstrategy.BiddingStrategy;
import jp.yahooapis.ss.v201909.biddingstrategy.BiddingStrategyOperation;
import jp.yahooapis.ss.v201909.biddingstrategy.BiddingStrategyPage;
import jp.yahooapis.ss.v201909.biddingstrategy.BiddingStrategyReturnValue;
import jp.yahooapis.ss.v201909.biddingstrategy.BiddingStrategySelector;
import jp.yahooapis.ss.v201909.biddingstrategy.BiddingStrategyService;
import jp.yahooapis.ss.v201909.biddingstrategy.BiddingStrategyServiceInterface;
import jp.yahooapis.ss.v201909.biddingstrategy.BiddingStrategyType;
import jp.yahooapis.ss.v201909.biddingstrategy.BiddingStrategyValues;
import jp.yahooapis.ss.v201909.biddingstrategy.Operator;
import jp.yahooapis.ss.v201909.biddingstrategy.TargetCpaBiddingScheme;
import jp.yahooapis.ss.v201909.biddingstrategy.TargetRoasBiddingScheme;
import jp.yahooapis.ss.v201909.biddingstrategy.TargetSpendBiddingScheme;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import javax.xml.ws.Holder;

/**
 * example BiddingStrategyService operation and Utility method collection.
 */
public class BiddingStrategyServiceSample {

  /**
   * main method for BiddingStrategyServiceSample
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
      // BiddingStrategyService::ADD
      // =================================================================
      // create request.
      BiddingStrategyOperation addBiddingStrategyOperation = buildExampleMutateRequest( //
          Operator.ADD, accountId, Collections.singletonList(createExampleTargetCpaBidding()) //
      );

      // run
      List<BiddingStrategyValues> biddingStrategyValues = mutate(addBiddingStrategyOperation);
      valuesRepositoryFacade.getValuesHolder().setBiddingStrategyValuesList(biddingStrategyValues);

      // =================================================================
      // BiddingStrategyService::SET
      // =================================================================
      // create request.
      BiddingStrategyOperation setBiddingStrategyOperation =
          buildExampleMutateRequest(Operator.SET, accountId, createExampleSetRequest(valuesRepositoryFacade.getBiddingStrategyValuesRepository().getBiddingStrategies()));

      // run
      mutate(setBiddingStrategyOperation);

      // =================================================================
      // BiddingStrategyService::GET
      // =================================================================
      // create request.
      BiddingStrategySelector biddingStrategySelector = buildExampleGetRequest(accountId, valuesRepositoryFacade.getBiddingStrategyValuesRepository().getBiddingStrategyIds());

      // run
      get(biddingStrategySelector);

      // =================================================================
      // BiddingStrategyService::REMOVE
      // =================================================================
      // create request.
      BiddingStrategyOperation removeBiddingStrategyOperation =
          buildExampleMutateRequest(Operator.REMOVE, accountId, valuesRepositoryFacade.getBiddingStrategyValuesRepository().getBiddingStrategies());

      // run
      mutate(removeBiddingStrategyOperation);

    } catch (Exception e) {
      e.printStackTrace();
      throw e;
    }
  }

  /**
   * create basic BiddingStrategy.
   *
   * @return
   * @throws Exception
   */
  public static ValuesHolder create() throws Exception {

    ValuesHolder valuesHolder = new ValuesHolder();
    long accountId = SoapUtils.getAccountId();
    BiddingStrategyOperation addBiddingStrategyOperation = buildExampleMutateRequest( //
        Operator.ADD, accountId, Collections.singletonList(createExampleTargetCpaBidding()) //
    );

    // Run
    List<BiddingStrategyValues> biddingStrategyValues = mutate(addBiddingStrategyOperation);
    valuesHolder.setBiddingStrategyValuesList(biddingStrategyValues);
    return valuesHolder;
  }

  /**
   * cleanup service object.
   *
   * @param valuesHolder
   * @throws Exception
   */
  public static void cleanup(ValuesHolder valuesHolder) throws Exception {

    long accountId = SoapUtils.getAccountId();
    if (valuesHolder.getBiddingStrategyValuesList().size() == 0) {
      return;
    }
    ValuesRepositoryFacade valuesRepositoryFacade = new ValuesRepositoryFacade(valuesHolder);

    BiddingStrategyOperation removeBiddingStrategyOperation =
        buildExampleMutateRequest(Operator.REMOVE, accountId, valuesRepositoryFacade.getBiddingStrategyValuesRepository().getBiddingStrategies());

    // Run
    mutate(removeBiddingStrategyOperation);
  }

  /**
   * Sample Program for BiddingStrategyService MUTATE.
   *
   * @param operation BiddingStrategyOperation
   * @return BiddingStrategyValues
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

    SoapUtils.checkSoapError(errorHolder, biddingStrategyReturnValueHolder.value.getValues());

    // Response
    return biddingStrategyReturnValueHolder.value.getValues();
  }

  /**
   * example get biddingStrategies.
   *
   * @param selector BiddingStrategySelector
   * @return BiddingStrategyValues
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

    SoapUtils.checkSoapError(errorHolder, biddingStrategyPageHolder.value.getValues());

    // Response
    return biddingStrategyPageHolder.value.getValues();
  }

  /**
   * example mutate request.
   */
  public static BiddingStrategyOperation buildExampleMutateRequest(Operator operator, long accountId, List<BiddingStrategy> operand) {
    BiddingStrategyOperation operation = new BiddingStrategyOperation();
    operation.setOperator(operator);
    operation.setAccountId(accountId);
    operation.getOperand().addAll(operand);

    return operation;
  }

  /**
   * example TargetCpaBidding request.
   *
   * @return BiddingStrategy
   */
  public static BiddingStrategy createExampleTargetCpaBidding() {
    TargetCpaBiddingScheme addTargetCpaBiddingScheme = new TargetCpaBiddingScheme();
    addTargetCpaBiddingScheme.setBiddingStrategyType(BiddingStrategyType.TARGET_CPA);
    addTargetCpaBiddingScheme.setTargetCpa((long) 500);
    addTargetCpaBiddingScheme.setBidCeiling((long) 700);
    addTargetCpaBiddingScheme.setBidFloor((long) 200);

    BiddingStrategy targetCpaBidding = new BiddingStrategy();
    targetCpaBidding.setBiddingStrategyName("SampleTargetCpa_CreateOn_" + SoapUtils.getCurrentTimestamp());
    targetCpaBidding.setBiddingScheme(addTargetCpaBiddingScheme);

    return targetCpaBidding;
  }

  /**
   * example TargetSpendBidding request.
   *
   * @return BiddingStrategy
   */
  public static BiddingStrategy createExampleTargetSpendBidding() {
    TargetSpendBiddingScheme addTargetSpendBiddingScheme = new TargetSpendBiddingScheme();
    addTargetSpendBiddingScheme.setBiddingStrategyType(BiddingStrategyType.TARGET_SPEND);
    addTargetSpendBiddingScheme.setBidCeiling((long) 700);

    BiddingStrategy targetSpendBidding = new BiddingStrategy();
    targetSpendBidding.setBiddingStrategyName("SampleTargetSpend_CreateOn_" + SoapUtils.getCurrentTimestamp());
    targetSpendBidding.setBiddingScheme(addTargetSpendBiddingScheme);

    return targetSpendBidding;
  }

  /**
   * example TargetRoasBidding request.
   *
   * @return BiddingStrategy
   */
  public static BiddingStrategy createExampleTargetRoasBidding() {
    TargetRoasBiddingScheme addTargetRoasBiddingScheme = new TargetRoasBiddingScheme();
    addTargetRoasBiddingScheme.setBiddingStrategyType(BiddingStrategyType.TARGET_ROAS);
    addTargetRoasBiddingScheme.setTargetRoas(10.00);
    addTargetRoasBiddingScheme.setBidCeiling((long) 700);
    addTargetRoasBiddingScheme.setBidFloor((long) 600);

    BiddingStrategy targetRoasBidding = new BiddingStrategy();
    targetRoasBidding.setBiddingStrategyName("SampleTargetRoas_CreateOn_" + SoapUtils.getCurrentTimestamp());
    targetRoasBidding.setBiddingScheme(addTargetRoasBiddingScheme);

    return targetRoasBidding;
  }

  /**
   * example biddingStrategies set request.
   *
   * @return List<BiddingStrategy>
   */
  public static List<BiddingStrategy> createExampleSetRequest(List<BiddingStrategy> biddingStrategies) {
    List<BiddingStrategy> operands = new ArrayList<>();

    for (BiddingStrategy biddingStrategy : biddingStrategies) {
      // Set Operand
      BiddingStrategy operand = new BiddingStrategy();
      operand.setBiddingStrategyId(biddingStrategy.getBiddingStrategyId());
      operand.setBiddingStrategyName("Sample_UpdateOn_" + biddingStrategy.getBiddingStrategyId() + "_" + SoapUtils.getCurrentTimestamp());

      // TargetCpaBiddingScheme
      if (biddingStrategy.getBiddingScheme() instanceof TargetCpaBiddingScheme) {
        TargetCpaBiddingScheme setTargetCpaBiddingScheme = new TargetCpaBiddingScheme();
        setTargetCpaBiddingScheme.setBiddingStrategyType(BiddingStrategyType.TARGET_CPA);
        setTargetCpaBiddingScheme.setTargetCpa((long) 550);
        setTargetCpaBiddingScheme.setBidCeiling((long) 750);
        setTargetCpaBiddingScheme.setBidFloor((long) 250);
        operand.setBiddingScheme(setTargetCpaBiddingScheme);

        // TargetSpendBiddingScheme
      } else if (biddingStrategy.getBiddingScheme() instanceof TargetSpendBiddingScheme) {
        TargetSpendBiddingScheme setTargetSpendBiddingScheme = new TargetSpendBiddingScheme();
        setTargetSpendBiddingScheme.setBiddingStrategyType(BiddingStrategyType.TARGET_SPEND);
        setTargetSpendBiddingScheme.setBidCeiling((long) 750);
        operand.setBiddingScheme(setTargetSpendBiddingScheme);

        // TargetRoasBiddingScheme
      } else if (biddingStrategy.getBiddingScheme() instanceof TargetRoasBiddingScheme) {
        TargetRoasBiddingScheme setTargetRoasBiddingScheme = new TargetRoasBiddingScheme();
        setTargetRoasBiddingScheme.setBiddingStrategyType(BiddingStrategyType.TARGET_ROAS);
        setTargetRoasBiddingScheme.setTargetRoas(15.00);
        setTargetRoasBiddingScheme.setBidCeiling((long) 750);
        setTargetRoasBiddingScheme.setBidFloor((long) 650);
        operand.setBiddingScheme(setTargetRoasBiddingScheme);
      }
      operands.add(operand);
    }
    return operands;
  }

  /**
   * example get request.
   *
   * @param accountId          long
   * @param biddingStrategyIds List<Long>
   * @return BiddingStrategySelector
   */
  public static BiddingStrategySelector buildExampleGetRequest(long accountId, List<Long> biddingStrategyIds) {
    // Set Selector
    BiddingStrategySelector selector = new BiddingStrategySelector();
    selector.setAccountId(accountId);

    if (biddingStrategyIds.size() > 0) {
      selector.getBiddingStrategyIds().addAll(biddingStrategyIds);
    }
    selector.getBiddingStrategyTypes().addAll(Arrays.asList( //
        BiddingStrategyType.TARGET_CPA, //
        BiddingStrategyType.TARGET_SPEND, //
        BiddingStrategyType.TARGET_ROAS //
    ));
    Paging paging = new Paging();
    paging.setStartIndex(1);
    paging.setNumberResults(20);
    selector.setPaging(paging);

    return selector;
  }
}

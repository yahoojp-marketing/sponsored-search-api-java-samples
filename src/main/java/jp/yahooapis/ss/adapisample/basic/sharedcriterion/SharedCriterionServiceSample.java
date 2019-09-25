/**
 * Copyright (C) 2019 Yahoo Japan Corporation. All Rights Reserved.
 */
package jp.yahooapis.ss.adapisample.basic.sharedcriterion;

import jp.yahooapis.ss.adapisample.basic.accountshared.AccountSharedServiceSample;
import jp.yahooapis.ss.adapisample.repository.ValuesRepositoryFacade;
import jp.yahooapis.ss.adapisample.util.SoapUtils;
import jp.yahooapis.ss.adapisample.util.ValuesHolder;
import jp.yahooapis.ss.v201909.Error;
import jp.yahooapis.ss.v201909.Paging;
import jp.yahooapis.ss.v201909.sharedcriterion.KeywordMatchType;
import jp.yahooapis.ss.v201909.sharedcriterion.Operator;
import jp.yahooapis.ss.v201909.sharedcriterion.SharedCriterion;
import jp.yahooapis.ss.v201909.sharedcriterion.SharedCriterionOperation;
import jp.yahooapis.ss.v201909.sharedcriterion.SharedCriterionPage;
import jp.yahooapis.ss.v201909.sharedcriterion.SharedCriterionReturnValue;
import jp.yahooapis.ss.v201909.sharedcriterion.SharedCriterionSelector;
import jp.yahooapis.ss.v201909.sharedcriterion.SharedCriterionService;
import jp.yahooapis.ss.v201909.sharedcriterion.SharedCriterionServiceInterface;
import jp.yahooapis.ss.v201909.sharedcriterion.SharedCriterionValues;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.xml.ws.Holder;

/**
 * example SharedCriterionService operation and Utility method collection.
 */
public class SharedCriterionServiceSample {

  /**
   * main method for SharedCriterionServiceSample
   *
   * @param args command line arguments
   */
  public static void main(String[] args) throws Exception {

    // =================================================================
    // Setting
    // =================================================================
    ValuesHolder valuesHolder = new ValuesHolder();
    long accountId = SoapUtils.getAccountId();

    try {
      // =================================================================
      // check & create upper service object.
      // =================================================================
      valuesHolder = setup();
      ValuesRepositoryFacade valuesRepositoryFacade = new ValuesRepositoryFacade(valuesHolder);
      Long sharedListId = valuesRepositoryFacade.getAccountSharedValuesRepository().getSharedListIds().get(0);

      // =================================================================
      // SharedCriterionService ADD
      // =================================================================
      // create request.
      SharedCriterionOperation addRequest = buildExampleMutateRequest( //
          Operator.ADD, accountId, Collections.singletonList(createExampleSharedCriterion(sharedListId)) //
      );

      // run
      List<SharedCriterionValues> addResponse = mutate(addRequest);
      List<SharedCriterion> sharedCriterions = new ArrayList<>();
      List<Long> criterionIds = new ArrayList<>();
      for (SharedCriterionValues values : addResponse) {
        sharedCriterions.add(values.getSharedCriterion());
        criterionIds.add(values.getSharedCriterion().getCriterionId());
      }

      // =================================================================
      // SharedCriterionService GET
      // =================================================================
      // create request.
      SharedCriterionSelector getRequest = buildExampleGetRequest(accountId, Collections.singletonList(sharedListId), criterionIds);

      // run
      get(getRequest);

      // =================================================================
      // SharedCriterionService REMOVE
      // =================================================================
      // create request.
      SharedCriterionOperation removeRequest = buildExampleMutateRequest(Operator.REMOVE, accountId, sharedCriterions);

      // run
      mutate(removeRequest);

    } catch (Exception e) {
      e.printStackTrace();
      throw e;
    } finally {
      cleanup(valuesHolder);
    }
  }

  /**
   * example mutate sharedCriterions.
   *
   * @param operation SharedCriterionOperation
   * @return SharedCriterionValues
   */
  public static List<SharedCriterionValues> mutate(SharedCriterionOperation operation) throws Exception {

    // Call API
    System.out.println("############################################");
    System.out.println("SharedCriterionService::mutate(" + operation.getOperator() + ")");
    System.out.println("############################################");

    Holder<SharedCriterionReturnValue> sharedCriterionReturnValueHolder = new Holder<SharedCriterionReturnValue>();
    Holder<List<Error>> errorHolder = new Holder<List<Error>>();
    SharedCriterionServiceInterface sharedCriterionService = SoapUtils.createServiceInterface(SharedCriterionServiceInterface.class, SharedCriterionService.class);
    sharedCriterionService.mutate(operation, sharedCriterionReturnValueHolder, errorHolder);

    SoapUtils.checkSoapError(errorHolder, sharedCriterionReturnValueHolder.value.getValues());

    // Response
    return sharedCriterionReturnValueHolder.value.getValues();
  }

  /**
   * Sample Program for SharedCriterionService GET.
   *
   * @param selector SharedCriterionSelector
   * @return SharedCriterionValues
   */
  public static List<SharedCriterionValues> get(SharedCriterionSelector selector) throws Exception {

    // Call API
    System.out.println("############################################");
    System.out.println("SharedCriterionService::get");
    System.out.println("############################################");

    Holder<SharedCriterionPage> sharedCriterionPageHolder = new Holder<SharedCriterionPage>();
    Holder<List<Error>> errorHolder = new Holder<List<Error>>();
    SharedCriterionServiceInterface sharedCriterionService = SoapUtils.createServiceInterface(SharedCriterionServiceInterface.class, SharedCriterionService.class);
    sharedCriterionService.get(selector, sharedCriterionPageHolder, errorHolder);

    SoapUtils.checkSoapError(errorHolder, sharedCriterionPageHolder.value.getValues());

    // Response
    return sharedCriterionPageHolder.value.getValues();
  }

  /**
   * example mutate request.
   */
  public static SharedCriterionOperation buildExampleMutateRequest(Operator operator, long accountId, List<SharedCriterion> operand) {
    SharedCriterionOperation operation = new SharedCriterionOperation();
    operation.setOperator(operator);
    operation.setAccountId(accountId);
    operation.getOperand().addAll(operand);

    return operation;
  }

  /**
   * example get request.
   *
   * @param accountId long
   * @param sharedListIds Long
   * @param criterionIds Long
   * @return SharedCriterionSelector
   */
  public static SharedCriterionSelector buildExampleGetRequest(long accountId, List<Long> sharedListIds, List<Long> criterionIds) {
    // Set Selector
    SharedCriterionSelector selector = new SharedCriterionSelector();
    selector.setAccountId(accountId);

    if (sharedListIds.size() > 0) {
      selector.getSharedListIds().addAll(sharedListIds);
    }
    if (criterionIds.size() > 0) {
      selector.getCriterionIds().addAll(criterionIds);
    }

    // Set Paging
    Paging paging = new Paging();
    paging.setStartIndex(1);
    paging.setNumberResults(20);
    selector.setPaging(paging);

    return selector;
  }

  /**
   * example sharedCriterion request.
   *
   * @param sharedListId
   * @return
   */
  public static SharedCriterion createExampleSharedCriterion(Long sharedListId) {

    // Set Operand
    SharedCriterion operand = new SharedCriterion();
    operand.setSharedListId(sharedListId);
    operand.setText("sample text " + SoapUtils.getCurrentTimestamp() + " " + sharedListId);
    operand.setMatchType(KeywordMatchType.BROAD);

    return operand;
  }

  /**
   * check & create upper service object.
   *
   * @return ValuesHolder
   * @throws Exception
   */
  private static ValuesHolder setup() throws Exception {

    return AccountSharedServiceSample.create();
  }

  /**
   * cleanup service object.
   *
   * @param valuesHolder ValuesHolder
   * @throws Exception
   */
  public static void cleanup(ValuesHolder valuesHolder) throws Exception {
    AccountSharedServiceSample.cleanup(valuesHolder);
  }

}

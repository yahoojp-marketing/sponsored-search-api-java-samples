/**
 * Copyright (C) 2019 Yahoo Japan Corporation. All Rights Reserved.
 */
package jp.yahooapis.ss.adapisample.basic.label;

import jp.yahooapis.ss.adapisample.repository.ValuesRepositoryFacade;
import jp.yahooapis.ss.adapisample.util.SoapUtils;
import jp.yahooapis.ss.adapisample.util.ValuesHolder;
import jp.yahooapis.ss.v201901.Error;
import jp.yahooapis.ss.v201901.Paging;
import jp.yahooapis.ss.v201901.label.CountLabeledEntity;
import jp.yahooapis.ss.v201901.label.Label;
import jp.yahooapis.ss.v201901.label.LabelOperation;
import jp.yahooapis.ss.v201901.label.LabelPage;
import jp.yahooapis.ss.v201901.label.LabelReturnValue;
import jp.yahooapis.ss.v201901.label.LabelSelector;
import jp.yahooapis.ss.v201901.label.LabelService;
import jp.yahooapis.ss.v201901.label.LabelServiceInterface;
import jp.yahooapis.ss.v201901.label.LabelValues;
import jp.yahooapis.ss.v201901.label.Operator;

import java.util.ArrayList;
import java.util.List;

import javax.xml.ws.Holder;


/**
 * example Label operation and Utility method collection.
 */
public class LabelServiceSample {

  /**
   * main method for LabelServiceSample
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
      ValuesRepositoryFacade valuesRepositoryFacade = new ValuesRepositoryFacade(valuesHolder);

      // =================================================================
      // LabelService ADD
      // =================================================================
      // create request.
      LabelOperation addRequest = buildExampleMutateRequest(Operator.ADD, accountId, new ArrayList<Label>() {{
        add(createExampleLabel());
      }});

      // run
      List<LabelValues> addResponse = mutate(addRequest);
      valuesRepositoryFacade.getValuesHolder().setLabelValuesList(addResponse);

      // =================================================================
      // LabelService GET
      // =================================================================
      // create request.
      LabelSelector labelSelector = buildExampleGetRequest(accountId, valuesRepositoryFacade.getLabelValuesRepository().getLabelIds());

      // run
      get(labelSelector);

      // =================================================================
      // LabelService SET
      // =================================================================
      // create request.
      LabelOperation setRequest = buildExampleMutateRequest(Operator.SET, accountId, createExampleSetRequest(valuesRepositoryFacade.getLabelValuesRepository().getLabels()));

      // run
      mutate(setRequest);

      // =================================================================
      // LabelService REMOVE
      // =================================================================
      // create request.
      LabelOperation removeRequest = buildExampleMutateRequest(Operator.REMOVE, accountId, valuesRepositoryFacade.getLabelValuesRepository().getLabels());

      // run
      mutate(removeRequest);

    } catch (Exception e) {
      e.printStackTrace();
      throw e;
    }
  }

  /**
   * example mutate request.
   */
  public static LabelOperation buildExampleMutateRequest(Operator operator, long accountId, List<Label> operand) {
    LabelOperation operation = new LabelOperation();
    operation.setOperator(operator);
    operation.setAccountId(accountId);
    operation.getOperand().addAll(operand);

    return operation;
  }

  /**
   * example get request.
   *
   * @param accountId long
   * @param labelIds Long
   * @return LabelSelector
   */
  public static LabelSelector buildExampleGetRequest(long accountId, List<Long> labelIds) {
    // Set Selector
    LabelSelector selector = new LabelSelector();
    selector.setAccountId(accountId);

    if (labelIds.size() > 0) {
      selector.getLabelIds().addAll(labelIds);
    }
    selector.setCountLabeledEntity(CountLabeledEntity.TRUE);

    Paging paging = new Paging();
    paging.setStartIndex(1);
    paging.setNumberResults(20);
    selector.setPaging(paging);

    return selector;
  }

  /**
   * example label request.
   *
   * @return Label
   */
  public static Label createExampleLabel() {

    Label label = new Label();
    label.setLabelName("Sample_Label_" + SoapUtils.getCurrentTimestamp());
    label.setDescription("sample label");
    label.setColor("#000000");

    return label;
  }

  /**
   * example label set request.
   *
   * @param labels
   * @return List<Label>
   */
  public static List<Label> createExampleSetRequest(List<Label> labels) {
    // create operands
    List<Label> operands = new ArrayList<>();

    for (Label label : labels) {
      Label operand = new Label();
      operand.setLabelId(label.getLabelId());
      operand.setLabelName("Sample_UpdateOn_" + SoapUtils.getCurrentTimestamp());
      operand.setDescription("sample label update");
      operand.setColor("#0000FF");

      operands.add(operand);
    }

    return operands;
  }

  /**
   * example mutate labels.
   *
   * @param operation LabelOperation
   * @return LabelValues
   */
  public static List<LabelValues> mutate(LabelOperation operation) throws Exception {
    // Call API
    System.out.println("############################################");
    System.out.println("LabelService::mutate(" + operation.getOperator() + ")");
    System.out.println("############################################");

    Holder<LabelReturnValue> labelReturnValueHolder = new Holder<LabelReturnValue>();
    Holder<List<Error>> errorHolder = new Holder<List<Error>>();
    LabelServiceInterface labelService = SoapUtils.createServiceInterface(LabelServiceInterface.class, LabelService.class);
    labelService.mutate(operation, labelReturnValueHolder, errorHolder);

    SoapUtils.checkSoapError(errorHolder, labelReturnValueHolder.value.getValues());

    // Response
    return labelReturnValueHolder.value.getValues();
  }

  /**
   * Sample Program for LabelService GET.
   *
   * @param labelSelector LabelSelector
   * @return LabelValues
   */
  public static List<LabelValues> get(LabelSelector labelSelector) throws Exception {

    // Call API
    System.out.println("############################################");
    System.out.println("LabelService::get");
    System.out.println("############################################");

    Holder<LabelPage> labelPage = new Holder<LabelPage>();
    Holder<List<Error>> errorHolder = new Holder<List<Error>>();
    LabelServiceInterface labelService = SoapUtils.createServiceInterface(LabelServiceInterface.class, LabelService.class);
    labelService.get(labelSelector, labelPage, errorHolder);

    SoapUtils.checkSoapError(errorHolder, labelPage.value.getValues());

    // Response
    return labelPage.value.getValues();
  }

  /**
   * cleanup service object.
   *
   * @param valuesHolder ValuesHolder
   * @throws Exception
   */
  public static void cleanup(ValuesHolder valuesHolder) throws Exception {

    if (valuesHolder.getLabelValuesList().size() > 0) {
      ValuesRepositoryFacade valuesRepositoryFacade = new ValuesRepositoryFacade(valuesHolder);
      mutate(buildExampleMutateRequest(Operator.REMOVE, SoapUtils.getAccountId(), valuesRepositoryFacade.getLabelValuesRepository().getLabels()));
    }
  }

  /**
   * create basic Label.
   *
   * @return valuesHolder ValuesHolder
   * @throws Exception
   */
  public static ValuesHolder create() throws Exception {

    ValuesHolder valuesHolder = new ValuesHolder();

    LabelOperation addRequest = buildExampleMutateRequest(Operator.ADD, SoapUtils.getAccountId(), new ArrayList<Label>() {{
      add(createExampleLabel());
    }});

    // run
    List<LabelValues> addResponse = mutate(addRequest);
    valuesHolder.setLabelValuesList(addResponse);

    return valuesHolder;
  }

}

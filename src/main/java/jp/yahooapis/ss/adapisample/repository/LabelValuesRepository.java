/**
 * Copyright (C) 2019 Yahoo Japan Corporation. All Rights Reserved.
 */
package jp.yahooapis.ss.adapisample.repository;

import jp.yahooapis.ss.adapisample.util.ValuesHolder;
import jp.yahooapis.ss.v201909.label.Label;
import jp.yahooapis.ss.v201909.label.LabelValues;

import java.util.ArrayList;
import java.util.List;

/**
 * Utility method collection for Java Sample Program.
 */
public class LabelValuesRepository {

  private ValuesHolder valuesHolder;

  /**
   * LabelValuesRepository constructor.
   *
   * @param valuesHolder ValuesHolder
   */
  public LabelValuesRepository(ValuesHolder valuesHolder) {
    this.valuesHolder = valuesHolder;
  }

  /**
   * @return Labels
   */
  public List<Label> getLabels(){
    List<Label> labels = new ArrayList<>();
    if (this.valuesHolder.getLabelValuesList().size() == 0) {
      return labels;
    }
    for (LabelValues value : this.valuesHolder.getLabelValuesList()) {
      labels.add(value.getLabel());
    }
    return labels;
  }

  /**
   * @return LabelIds
   */
  public List<Long> getLabelIds(){
    List<Long> labelIds = new ArrayList<>();
    if (this.valuesHolder.getLabelValuesList().size() == 0) {
      return labelIds;
    }
    for (LabelValues value : this.valuesHolder.getLabelValuesList()) {
      labelIds.add(value.getLabel().getLabelId());
    }
    return labelIds;
  }
}

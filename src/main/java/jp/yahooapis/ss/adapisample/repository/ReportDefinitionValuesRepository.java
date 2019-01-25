/**
 * Copyright (C) 2019 Yahoo Japan Corporation. All Rights Reserved.
 */
package jp.yahooapis.ss.adapisample.repository;

import jp.yahooapis.ss.adapisample.util.ValuesHolder;
import jp.yahooapis.ss.v201901.reportdefinition.ReportDefinition;
import jp.yahooapis.ss.v201901.reportdefinition.ReportDefinitionValues;

import java.util.ArrayList;
import java.util.List;

/**
 * Utility method collection for Java Sample Program.
 */
public class ReportDefinitionValuesRepository {

  private ValuesHolder valuesHolder;

  /**
   * ReportDefinitionValuesRepository constructor.
   *
   * @param valuesHolder ValuesHolder
   */
  public ReportDefinitionValuesRepository(ValuesHolder valuesHolder) {
    this.valuesHolder = valuesHolder;
  }

  /**
   * @return ReportDefinitions
   */
  public List<ReportDefinition> getReportDefinitions() {
    List<ReportDefinition> reportDefinitions = new ArrayList<>();
    if (this.valuesHolder.getReportDefinitionValuesList().size() == 0) {
      return reportDefinitions;
    }
    for (ReportDefinitionValues value : this.valuesHolder.getReportDefinitionValuesList()) {
      reportDefinitions.add(value.getReportDefinition());
    }
    return reportDefinitions;
  }

  /**
   * @return ReportIds
   */
  public List<Long> getReportIds() {
    List<Long> reportIds = new ArrayList<>();
    if (this.valuesHolder.getReportDefinitionValuesList().size() == 0) {
      return reportIds;
    }
    for (ReportDefinitionValues value : this.valuesHolder.getReportDefinitionValuesList()) {
      reportIds.add(value.getReportDefinition().getReportId());
    }
    return reportIds;
  }
}

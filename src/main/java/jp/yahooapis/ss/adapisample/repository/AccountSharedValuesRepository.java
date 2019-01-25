/**
 * Copyright (C) 2019 Yahoo Japan Corporation. All Rights Reserved.
 */
package jp.yahooapis.ss.adapisample.repository;

import jp.yahooapis.ss.adapisample.util.ValuesHolder;
import jp.yahooapis.ss.v201901.accountshared.AccountShared;
import jp.yahooapis.ss.v201901.accountshared.AccountSharedValues;

import java.util.ArrayList;
import java.util.List;

/**
 * Utility method collection for Java Sample Program.
 */
public class AccountSharedValuesRepository {

  private ValuesHolder valuesHolder;

  /**
   * AccountSharedValuesRepository constructor.
   *
   * @param valuesHolder ValuesHolder
   */
  public AccountSharedValuesRepository(ValuesHolder valuesHolder) {
    this.valuesHolder = valuesHolder;
  }

  /**
   * @return AccountShareds
   */
  public List<AccountShared> getAccountShareds() {
    List<AccountShared> accountShareds = new ArrayList<>();
    if (this.valuesHolder.getAccountSharedValuesList().size() == 0) {
      return accountShareds;
    }
    for (AccountSharedValues value : this.valuesHolder.getAccountSharedValuesList()) {
      accountShareds.add(value.getAccountShared());
    }
    return accountShareds;
  }

  /**
   * @return SharedListIds
   */
  public List<Long> getSharedListIds() {
    List<Long> sharedListIds = new ArrayList<>();
    if (this.valuesHolder.getAccountSharedValuesList().size() == 0) {
      return sharedListIds;
    }
    for (AccountSharedValues value : this.valuesHolder.getAccountSharedValuesList()) {
      sharedListIds.add(value.getAccountShared().getSharedListId());
    }
    return sharedListIds;
  }
}

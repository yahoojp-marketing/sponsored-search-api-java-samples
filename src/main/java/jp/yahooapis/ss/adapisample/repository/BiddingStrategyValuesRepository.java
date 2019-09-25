/**
 * Copyright (C) 2019 Yahoo Japan Corporation. All Rights Reserved.
 */
package jp.yahooapis.ss.adapisample.repository;

import jp.yahooapis.ss.adapisample.util.ValuesHolder;
import jp.yahooapis.ss.v201909.biddingstrategy.BiddingStrategy;
import jp.yahooapis.ss.v201909.biddingstrategy.BiddingStrategyType;
import jp.yahooapis.ss.v201909.biddingstrategy.BiddingStrategyValues;

import java.util.ArrayList;
import java.util.List;

/**
 * Utility method collection for Java Sample Program.
 */
public class BiddingStrategyValuesRepository {

  private ValuesHolder valuesHolder;

  /**
   * BiddingStrategyValuesRepository constructor.
   *
   * @param valuesHolder ValuesHolder
   */
  public BiddingStrategyValuesRepository(ValuesHolder valuesHolder) {
    this.valuesHolder = valuesHolder;
  }

  /**
   * @return BiddingStrategies
   */
  public List<BiddingStrategy> getBiddingStrategies() {
    List<BiddingStrategy> biddingStrategies = new ArrayList<>();
    if (this.valuesHolder.getBiddingStrategyValuesList().size() == 0) {
      return biddingStrategies;
    }
    for (BiddingStrategyValues value : this.valuesHolder.getBiddingStrategyValuesList()) {
      biddingStrategies.add(value.getBiddingStrategy());
    }
    return biddingStrategies;
  }

  /**
   * @return BiddingStrategyIds
   */
  public List<Long> getBiddingStrategyIds() {
    List<Long> biddingStrategyIds = new ArrayList<>();
    if (this.valuesHolder.getBiddingStrategyValuesList().size() == 0) {
      return biddingStrategyIds;
    }
    for (BiddingStrategyValues value : this.valuesHolder.getBiddingStrategyValuesList()) {
      biddingStrategyIds.add(value.getBiddingStrategy().getBiddingStrategyId());
    }
    return biddingStrategyIds;
  }

  /**
   * @param biddingStrategyType BiddingStrategyType
   * @return BiddingStrategy/null
   */
  public BiddingStrategy findBiddingStrategy(BiddingStrategyType biddingStrategyType) {
    if (this.valuesHolder.getBiddingStrategyValuesList().size() == 0) {
      return null;
    }
    for (BiddingStrategyValues value : this.valuesHolder.getBiddingStrategyValuesList()) {
      if (value.getBiddingStrategy().getBiddingStrategyType().equals(biddingStrategyType)) {
        return value.getBiddingStrategy();
      }
    }
    return null;
  }

  /**
   * @param biddingStrategyType BiddingStrategyType
   * @return Long/null
   */
  public Long findBiddingStrategyId(BiddingStrategyType biddingStrategyType) {
    if (this.valuesHolder.getBiddingStrategyValuesList().size() == 0) {
      return null;
    }
    for (BiddingStrategyValues value : this.valuesHolder.getBiddingStrategyValuesList()) {
      if (value.getBiddingStrategy().getBiddingStrategyType().equals(biddingStrategyType)) {
        return value.getBiddingStrategy().getBiddingStrategyId();
      }
    }
    return null;
  }
}

package jp.co.yahoo.ad_api_sample.targetingIdeaSample;

import jp.co.yahoo.ad_api_sample.util.SoapUtils;
import jp.yahooapis.ss.v201808.Paging;
import jp.yahooapis.ss.v201808.targetingidea.CriterionType;
import jp.yahooapis.ss.v201808.targetingidea.KeywordMatchType;
import jp.yahooapis.ss.v201808.targetingidea.ProposalKeyword;
import jp.yahooapis.ss.v201808.targetingidea.RelatedToKeywordSearchParameter;
import jp.yahooapis.ss.v201808.targetingidea.SearchParameterUse;
import jp.yahooapis.ss.v201808.targetingidea.TargetingIdeaSelector;
import jp.yahooapis.ss.v201808.targetingidea.TargetingIdeaValues;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNull.notNullValue;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;

/**
 * Sample TestCase for TargetingIdeaSample. Copyright (C) 2012 Yahoo Japan Corporation. All Rights Reserved.
 */
public class TargetingIdeaSampleTest {

  /**
   * Setting
   */
  private long accountId;

  @Before
  public void setup() {
    accountId = SoapUtils.getAccountId();
  }

  /**
   * Sample TestCase of main method for TargetingIdeaSample.
   */
  @Test
  public void testMain() throws Exception {
    try {
      TargetingIdeaSample.main(null);
    } catch (Exception e) {
      fail();
    }
  }

  /**
   * Sample TestCase of get method for TargetingIdeaSample.
   */
  @Test
  public void testGet() throws Exception {
    // Set Selector
    TargetingIdeaSelector selector = new TargetingIdeaSelector();
    selector.setAccountId(new Long(accountId));

    RelatedToKeywordSearchParameter relateKeyword = new RelatedToKeywordSearchParameter();
    relateKeyword.setSearchParameterUse(SearchParameterUse.RELATED_TO_KEYWORD);
    ProposalKeyword proposalKeyword1 = new ProposalKeyword();
    proposalKeyword1.setType(CriterionType.KEYWORD);
    proposalKeyword1.setText("sample1");
    proposalKeyword1.setMatchType(KeywordMatchType.PHRASE);
    relateKeyword.getKeywords().add(proposalKeyword1);
    selector.getSearchParameter().addAll(Arrays.asList(relateKeyword));

    Paging paging = new Paging();
    paging.setStartIndex(1);
    paging.setNumberResults(2);
    selector.setPaging(paging);

    // Run
    List<TargetingIdeaValues> targetingIdeaValues = null;
    try {
      targetingIdeaValues = TargetingIdeaSample.get(selector);
    } catch (Exception e) {
      fail();
    }

    // Assert
    for (TargetingIdeaValues targetingIdeaValue : targetingIdeaValues) {
      assertThat(targetingIdeaValue.getAccountId(), is(notNullValue()));
      assertThat(targetingIdeaValue.getData(), is(notNullValue()));
    }
  }

}

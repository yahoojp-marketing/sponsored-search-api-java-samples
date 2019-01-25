/**
 * Copyright (C) 2019 Yahoo Japan Corporation. All Rights Reserved.
 */
package jp.yahooapis.ss.adapisample.basic.targetingidea;

import jp.yahooapis.ss.adapisample.util.SoapUtils;
import jp.yahooapis.ss.v201901.Error;
import jp.yahooapis.ss.v201901.Paging;
import jp.yahooapis.ss.v201901.targetingidea.CriterionType;
import jp.yahooapis.ss.v201901.targetingidea.KeywordMatchType;
import jp.yahooapis.ss.v201901.targetingidea.ProposalKeyword;
import jp.yahooapis.ss.v201901.targetingidea.RelatedToKeywordSearchParameter;
import jp.yahooapis.ss.v201901.targetingidea.RelatedToUrlSearchParameter;
import jp.yahooapis.ss.v201901.targetingidea.SearchParameterUse;
import jp.yahooapis.ss.v201901.targetingidea.TargetingIdeaPage;
import jp.yahooapis.ss.v201901.targetingidea.TargetingIdeaSelector;
import jp.yahooapis.ss.v201901.targetingidea.TargetingIdeaService;
import jp.yahooapis.ss.v201901.targetingidea.TargetingIdeaServiceInterface;
import jp.yahooapis.ss.v201901.targetingidea.TargetingIdeaValues;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.xml.ws.Holder;

/**
 * example KeywordEstimatorService operation and Utility method collection.
 */
public class TargetingIdeaServiceSample {

  /**
   * example TargetingIdeaService operation.
   *
   * @param args command line arguments
   * @throws Exception
   */
  public static void main(String[] args) throws Exception {
    try {
      // =================================================================
      // Setup
      // =================================================================
      long accountId = SoapUtils.getAccountId();

      // =================================================================
      // TargetingIdeaService GET
      // =================================================================
      // create request.
      TargetingIdeaSelector selector = buildExampleGetRequest(accountId);

      // run
      get(selector);

    } catch (Exception ex) {
      ex.printStackTrace();
      throw ex;
    }
  }

  /**
   * example get request.
   *
   * @param accountId long
   * @return TargetingIdeaSelector
   */
  public static TargetingIdeaSelector buildExampleGetRequest(long accountId) {
    ProposalKeyword proposalKeyword = new ProposalKeyword();
    proposalKeyword.setType(CriterionType.KEYWORD);
    proposalKeyword.setText("sample1");
    proposalKeyword.setMatchType(KeywordMatchType.PHRASE);
    RelatedToKeywordSearchParameter relatedToKeywordSearchParameter = new RelatedToKeywordSearchParameter();
    relatedToKeywordSearchParameter.setSearchParameterUse(SearchParameterUse.RELATED_TO_KEYWORD);
    relatedToKeywordSearchParameter.getKeywords().add(proposalKeyword);

    RelatedToUrlSearchParameter relatedToUrlSearchParameter = new RelatedToUrlSearchParameter();
    relatedToUrlSearchParameter.setSearchParameterUse(SearchParameterUse.RELATED_TO_URL);
    relatedToUrlSearchParameter.setUrl("http://yahoo.co.jp");

    TargetingIdeaSelector selector = new TargetingIdeaSelector();
    selector.setAccountId(accountId);
    selector.getSearchParameter().add(relatedToKeywordSearchParameter);
    selector.getSearchParameter().add(relatedToUrlSearchParameter);

    Paging paging = new Paging();
    paging.setStartIndex(1);
    paging.setNumberResults(20);
    selector.setPaging(paging);

    return selector;
  }

  /**
   * example get targetingIdea.
   *
   * @param selector TargetingIdeaSelector
   * @return List<TargetingIdeaValues>
   * @throws Exception
   */
  public static List<TargetingIdeaValues> get(TargetingIdeaSelector selector) throws Exception {

    // call API
    System.out.println("############################################");
    System.out.println("TargetingIdeaService::get");
    System.out.println("############################################");

    Holder<TargetingIdeaPage> targetingIdeaPageHolder = new Holder<TargetingIdeaPage>();
    Holder<List<Error>> errorHolder = new Holder<List<Error>>();
    TargetingIdeaServiceInterface targetingIdeaService = SoapUtils.createServiceInterface(TargetingIdeaServiceInterface.class, TargetingIdeaService.class);
    targetingIdeaService.get(selector, targetingIdeaPageHolder, errorHolder);

    SoapUtils.checkSoapError(errorHolder, new ArrayList<>());

    // Response
    return targetingIdeaPageHolder.value.getValues();
  }
}

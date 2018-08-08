package jp.co.yahoo.ad_api_sample.targetingIdeaSample;

import jp.co.yahoo.ad_api_sample.error.impl.TargetingIdeaServiceErrorEntityFactory;
import jp.co.yahoo.ad_api_sample.util.SoapUtils;
import jp.yahooapis.ss.v201808.Error;
import jp.yahooapis.ss.v201808.Paging;
import jp.yahooapis.ss.v201808.targetingidea.Attribute;
import jp.yahooapis.ss.v201808.targetingidea.CriterionType;
import jp.yahooapis.ss.v201808.targetingidea.KeywordAttribute;
import jp.yahooapis.ss.v201808.targetingidea.KeywordMatchType;
import jp.yahooapis.ss.v201808.targetingidea.ProposalKeyword;
import jp.yahooapis.ss.v201808.targetingidea.RelatedToKeywordSearchParameter;
import jp.yahooapis.ss.v201808.targetingidea.SearchParameterUse;
import jp.yahooapis.ss.v201808.targetingidea.TargetingIdeaPage;
import jp.yahooapis.ss.v201808.targetingidea.TargetingIdeaSelector;
import jp.yahooapis.ss.v201808.targetingidea.TargetingIdeaService;
import jp.yahooapis.ss.v201808.targetingidea.TargetingIdeaServiceInterface;
import jp.yahooapis.ss.v201808.targetingidea.TargetingIdeaValues;

import java.util.Arrays;
import java.util.List;

import javax.xml.ws.Holder;

/**
 * Sample Program for TargetingIdeaService. Copyright (C) 2012 Yahoo Japan Corporation. All Rights
 * Reserved.
 */
public class TargetingIdeaSample {

  /**
   * main method for TargetingIdeaSample
   *
   * @param args command line arguments
   */
  public static void main(String[] args) {
    try {
      // =================================================================
      // Setting
      // =================================================================
      long accountId = SoapUtils.getAccountId();

      // -----------------------------------------------
      // TargetingIdeaService::get
      // -----------------------------------------------
      // Set SearchParameter
      RelatedToKeywordSearchParameter relateKeyword = new RelatedToKeywordSearchParameter();
      relateKeyword.setSearchParameterUse(SearchParameterUse.RELATED_TO_KEYWORD);
      ProposalKeyword proposalKeyword1 = new ProposalKeyword();
      proposalKeyword1.setType(CriterionType.KEYWORD);
      proposalKeyword1.setText("sample1");
      proposalKeyword1.setMatchType(KeywordMatchType.PHRASE);
      relateKeyword.getKeywords().add(proposalKeyword1);

      // Set Selector
      TargetingIdeaSelector selector = new TargetingIdeaSelector();
      selector.setAccountId(new Long(accountId));
      selector.getSearchParameter().addAll(Arrays.asList(relateKeyword));
      Paging paging = new Paging();
      paging.setStartIndex(1);
      paging.setNumberResults(2);
      selector.setPaging(paging);

      // Run
      get(selector);

    } catch (Exception ex) {
      ex.printStackTrace();
    }
  }

  /**
   * Sample Program for TargetingIdeaService GET.
   *
   * @param selector TargetingIdeaSelector
   * @return TargetingIdeaValues
   * @throws Exception
   */
  public static List<TargetingIdeaValues> get(TargetingIdeaSelector selector) throws Exception {

    // call API
    System.out.println("############################################");
    System.out.println("TargetingIdeaService::get");
    System.out.println("############################################");

    Holder<TargetingIdeaPage> targetingIdeaPageHolder = new Holder<TargetingIdeaPage>();
    Holder<List<Error>> errorArrayHolder = new Holder<List<Error>>();
    TargetingIdeaServiceInterface targetingIdeaService = SoapUtils.createServiceInterface(TargetingIdeaServiceInterface.class, TargetingIdeaService.class);
    targetingIdeaService.get(selector, targetingIdeaPageHolder, errorArrayHolder);

    // error
    if (errorArrayHolder.value != null && errorArrayHolder.value.size() > 0) {
      SoapUtils.displayErrors(new TargetingIdeaServiceErrorEntityFactory(errorArrayHolder.value), true);
    }
    if (errorArrayHolder.value == null) {
      throw new Exception("NoDataResponse:TargetingIdeaService Get");
    }

    // Display
    for (TargetingIdeaValues values : targetingIdeaPageHolder.value.getValues()) {
      // reponse display
      display(values);
    }

    // Response
    return targetingIdeaPageHolder.value.getValues();
  }

  /**
   * display TargetingIdea entity to stdout.
   *
   * @param values TargetingIdea entity for display.
   */
  private static void display(TargetingIdeaValues values) {
    System.out.println("data/accountId = " + values.getAccountId());
    if (values.getData() != null) {
      System.out.println("data/key = " + values.getData().getKey());
      Attribute attribute = values.getData().getValue();
      if (attribute != null) {
        System.out.println("data/value/attributeType = " + attribute.getAttributeType());
        if (attribute instanceof KeywordAttribute) {
          KeywordAttribute keywordAttribute = (KeywordAttribute) attribute;
          System.out.println("data/value/value/type = " + keywordAttribute.getValue().getType());
          System.out.println("data/value/value/text = " + keywordAttribute.getValue().getText());
          System.out.println("data/value/value/matchType = " + keywordAttribute.getValue().getMatchType());
        }
      }
    }
    System.out.println("---------");
  }
}

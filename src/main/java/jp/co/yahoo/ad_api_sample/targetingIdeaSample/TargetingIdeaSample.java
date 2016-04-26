package jp.co.yahoo.ad_api_sample.targetingIdeaSample;

import java.util.Arrays;
import java.util.List;

import javax.xml.ws.Holder;

import jp.co.yahoo.ad_api_sample.error.impl.TargetingIdeaServiceErrorEntityFactory;
import jp.co.yahoo.ad_api_sample.util.SoapUtils;
import jp.yahooapis.ss.V6.TargetingIdeaService.Attribute;
import jp.yahooapis.ss.V6.TargetingIdeaService.CriterionType;
import jp.yahooapis.ss.V6.TargetingIdeaService.Error;
import jp.yahooapis.ss.V6.TargetingIdeaService.KeywordAttribute;
import jp.yahooapis.ss.V6.TargetingIdeaService.KeywordMatchType;
import jp.yahooapis.ss.V6.TargetingIdeaService.Paging;
import jp.yahooapis.ss.V6.TargetingIdeaService.ProposalKeyword;
import jp.yahooapis.ss.V6.TargetingIdeaService.RelatedToKeywordSearchParameter;
import jp.yahooapis.ss.V6.TargetingIdeaService.SearchParameterUse;
import jp.yahooapis.ss.V6.TargetingIdeaService.TargetingIdeaPage;
import jp.yahooapis.ss.V6.TargetingIdeaService.TargetingIdeaSelector;
import jp.yahooapis.ss.V6.TargetingIdeaService.TargetingIdeaService;
import jp.yahooapis.ss.V6.TargetingIdeaService.TargetingIdeaServiceInterface;
import jp.yahooapis.ss.V6.TargetingIdeaService.TargetingIdeaValues;

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
      // TargetingIdeaService
      // =================================================================
      TargetingIdeaServiceInterface targetingIdeaService = SoapUtils.createServiceInterface(TargetingIdeaServiceInterface.class, TargetingIdeaService.class);

      // -----------------------------------------------
      // TargetingIdeaService::get
      // -----------------------------------------------
      // request
      RelatedToKeywordSearchParameter relateKewyrod = new RelatedToKeywordSearchParameter();
      relateKewyrod.setSearchParameterUse(SearchParameterUse.RELATED_TO_KEYWORD);
      ProposalKeyword proposalKeyword1 = new ProposalKeyword();
      proposalKeyword1.setType(CriterionType.KEYWORD);
      proposalKeyword1.setText("sample1");
      proposalKeyword1.setMatchType(KeywordMatchType.PHRASE);
      relateKewyrod.getKeywords().add(proposalKeyword1);


      TargetingIdeaSelector targetingIdeaSelector = new TargetingIdeaSelector();
      targetingIdeaSelector.getSearchParameter().addAll(Arrays.asList(relateKewyrod));
      Paging paging = new Paging();
      paging.setStartIndex(1);
      paging.setNumberResults(2);
      targetingIdeaSelector.setPaging(paging);

      // call API
      System.out.println("############################################");
      System.out.println("TargetingIdeaService::get");
      System.out.println("############################################");
      Holder<TargetingIdeaPage> targetingIdeaPageHolder = new Holder<TargetingIdeaPage>();
      Holder<List<Error>> errorArrayHolder = new Holder<List<Error>>();
      targetingIdeaService.get(targetingIdeaSelector, targetingIdeaPageHolder, errorArrayHolder);

      // if error
      if (errorArrayHolder.value != null && errorArrayHolder.value.size() > 0) {
        SoapUtils.displayErrors(new TargetingIdeaServiceErrorEntityFactory(errorArrayHolder.value), true);
      }

      // reponse
      if (targetingIdeaPageHolder.value != null) {
        for (TargetingIdeaValues values : targetingIdeaPageHolder.value.getValues()) {
          // reponse display
          displayTargetingIdea(values);
        }
      }
    } catch (Exception ex) {
      ex.printStackTrace();
    }
  }

  /**
   * display TargetingIdea entity to stdout.
   * 
   * @param values TargetingIdea entity for display.
   */
  private static void displayTargetingIdea(TargetingIdeaValues values) {
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

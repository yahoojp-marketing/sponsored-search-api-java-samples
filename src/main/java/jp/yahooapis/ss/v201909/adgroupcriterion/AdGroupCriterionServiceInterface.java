
package jp.yahooapis.ss.v201909.adgroupcriterion;

import java.util.List;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.Holder;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;
import jp.yahooapis.ss.v201909.Error;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.9-b130926.1035
 * Generated source version: 2.2
 * 
 */
@WebService(name = "AdGroupCriterionServiceInterface", targetNamespace = "http://ss.yahooapis.jp/V201909/AdGroupCriterion")
@XmlSeeAlso({
    jp.yahooapis.ss.v201909.ObjectFactory.class,
    jp.yahooapis.ss.v201909.adgroupcriterion.ObjectFactory.class
})
public interface AdGroupCriterionServiceInterface {


    /**
     * 
     * @param selector
     * @param rval
     * @param error
     * @throws ApiException
     */
    @WebMethod
    @RequestWrapper(localName = "get", targetNamespace = "http://ss.yahooapis.jp/V201909/AdGroupCriterion", className = "jp.yahooapis.ss.v201909.adgroupcriterion.Get")
    @ResponseWrapper(localName = "getResponse", targetNamespace = "http://ss.yahooapis.jp/V201909/AdGroupCriterion", className = "jp.yahooapis.ss.v201909.adgroupcriterion.GetResponse")
    public void get(
        @WebParam(name = "selector", targetNamespace = "http://ss.yahooapis.jp/V201909/AdGroupCriterion")
        AdGroupCriterionSelector selector,
        @WebParam(name = "rval", targetNamespace = "http://ss.yahooapis.jp/V201909/AdGroupCriterion", mode = WebParam.Mode.OUT)
        Holder<AdGroupCriterionPage> rval,
        @WebParam(name = "error", targetNamespace = "http://ss.yahooapis.jp/V201909/AdGroupCriterion", mode = WebParam.Mode.OUT)
        Holder<List<Error>> error)
        throws ApiException
    ;

    /**
     * 
     * @param operations
     * @param rval
     * @param error
     * @throws ApiException
     */
    @WebMethod
    @RequestWrapper(localName = "mutate", targetNamespace = "http://ss.yahooapis.jp/V201909/AdGroupCriterion", className = "jp.yahooapis.ss.v201909.adgroupcriterion.Mutate")
    @ResponseWrapper(localName = "mutateResponse", targetNamespace = "http://ss.yahooapis.jp/V201909/AdGroupCriterion", className = "jp.yahooapis.ss.v201909.adgroupcriterion.MutateResponse")
    public void mutate(
        @WebParam(name = "operations", targetNamespace = "http://ss.yahooapis.jp/V201909/AdGroupCriterion")
        AdGroupCriterionOperation operations,
        @WebParam(name = "rval", targetNamespace = "http://ss.yahooapis.jp/V201909/AdGroupCriterion", mode = WebParam.Mode.OUT)
        Holder<AdGroupCriterionReturnValue> rval,
        @WebParam(name = "error", targetNamespace = "http://ss.yahooapis.jp/V201909/AdGroupCriterion", mode = WebParam.Mode.OUT)
        Holder<List<Error>> error)
        throws ApiException
    ;

}

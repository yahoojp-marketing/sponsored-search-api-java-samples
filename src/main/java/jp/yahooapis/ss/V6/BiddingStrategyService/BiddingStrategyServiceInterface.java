
package jp.yahooapis.ss.V6.BiddingStrategyService;

import java.util.List;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.Holder;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.9-b130926.1035
 * Generated source version: 2.2
 * 
 */
@WebService(name = "BiddingStrategyServiceInterface", targetNamespace = "http://ss.yahooapis.jp/V6")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface BiddingStrategyServiceInterface {


    /**
     * 
     * @param selector
     * @param rval
     * @param error
     * @throws ApiException
     */
    @WebMethod
    @RequestWrapper(localName = "get", targetNamespace = "http://ss.yahooapis.jp/V6", className = "jp.yahooapis.ss.V6.BiddingStrategyService.Get")
    @ResponseWrapper(localName = "getResponse", targetNamespace = "http://ss.yahooapis.jp/V6", className = "jp.yahooapis.ss.V6.BiddingStrategyService.GetResponse")
    public void get(
        @WebParam(name = "selector", targetNamespace = "http://ss.yahooapis.jp/V6")
        BiddingStrategySelector selector,
        @WebParam(name = "rval", targetNamespace = "http://ss.yahooapis.jp/V6", mode = WebParam.Mode.OUT)
        Holder<BiddingStrategyPage> rval,
        @WebParam(name = "error", targetNamespace = "http://ss.yahooapis.jp/V6", mode = WebParam.Mode.OUT)
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
    @RequestWrapper(localName = "mutate", targetNamespace = "http://ss.yahooapis.jp/V6", className = "jp.yahooapis.ss.V6.BiddingStrategyService.Mutate")
    @ResponseWrapper(localName = "mutateResponse", targetNamespace = "http://ss.yahooapis.jp/V6", className = "jp.yahooapis.ss.V6.BiddingStrategyService.MutateResponse")
    public void mutate(
        @WebParam(name = "operations", targetNamespace = "http://ss.yahooapis.jp/V6")
        BiddingStrategyOperation operations,
        @WebParam(name = "rval", targetNamespace = "http://ss.yahooapis.jp/V6", mode = WebParam.Mode.OUT)
        Holder<BiddingStrategyReturnValue> rval,
        @WebParam(name = "error", targetNamespace = "http://ss.yahooapis.jp/V6", mode = WebParam.Mode.OUT)
        Holder<List<Error>> error)
        throws ApiException
    ;

}

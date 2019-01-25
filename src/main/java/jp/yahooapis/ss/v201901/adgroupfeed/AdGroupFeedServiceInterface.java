
package jp.yahooapis.ss.v201901.adgroupfeed;

import java.util.List;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.Holder;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;
import jp.yahooapis.ss.v201901.Error;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.9-b130926.1035
 * Generated source version: 2.2
 * 
 */
@WebService(name = "AdGroupFeedServiceInterface", targetNamespace = "http://ss.yahooapis.jp/V201901/AdGroupFeed")
@XmlSeeAlso({
    jp.yahooapis.ss.v201901.ObjectFactory.class,
    jp.yahooapis.ss.v201901.adgroupfeed.ObjectFactory.class
})
public interface AdGroupFeedServiceInterface {


    /**
     * 
     * @param selector
     * @param rval
     * @param error
     * @throws ApiException
     */
    @WebMethod
    @RequestWrapper(localName = "get", targetNamespace = "http://ss.yahooapis.jp/V201901/AdGroupFeed", className = "jp.yahooapis.ss.v201901.adgroupfeed.Get")
    @ResponseWrapper(localName = "getResponse", targetNamespace = "http://ss.yahooapis.jp/V201901/AdGroupFeed", className = "jp.yahooapis.ss.v201901.adgroupfeed.GetResponse")
    public void get(
        @WebParam(name = "selector", targetNamespace = "http://ss.yahooapis.jp/V201901/AdGroupFeed")
        AdGroupFeedSelector selector,
        @WebParam(name = "rval", targetNamespace = "http://ss.yahooapis.jp/V201901/AdGroupFeed", mode = WebParam.Mode.OUT)
        Holder<AdGroupFeedPage> rval,
        @WebParam(name = "error", targetNamespace = "http://ss.yahooapis.jp/V201901/AdGroupFeed", mode = WebParam.Mode.OUT)
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
    @RequestWrapper(localName = "mutate", targetNamespace = "http://ss.yahooapis.jp/V201901/AdGroupFeed", className = "jp.yahooapis.ss.v201901.adgroupfeed.Mutate")
    @ResponseWrapper(localName = "mutateResponse", targetNamespace = "http://ss.yahooapis.jp/V201901/AdGroupFeed", className = "jp.yahooapis.ss.v201901.adgroupfeed.MutateResponse")
    public void mutate(
        @WebParam(name = "operations", targetNamespace = "http://ss.yahooapis.jp/V201901/AdGroupFeed")
        AdGroupFeedOperation operations,
        @WebParam(name = "rval", targetNamespace = "http://ss.yahooapis.jp/V201901/AdGroupFeed", mode = WebParam.Mode.OUT)
        Holder<AdGroupFeedReturnValue> rval,
        @WebParam(name = "error", targetNamespace = "http://ss.yahooapis.jp/V201901/AdGroupFeed", mode = WebParam.Mode.OUT)
        Holder<List<Error>> error)
        throws ApiException
    ;

}
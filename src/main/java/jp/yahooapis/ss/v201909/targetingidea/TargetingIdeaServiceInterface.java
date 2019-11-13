
package jp.yahooapis.ss.v201909.targetingidea;

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
@WebService(name = "TargetingIdeaServiceInterface", targetNamespace = "http://ss.yahooapis.jp/V201909/TargetingIdea")
@XmlSeeAlso({
    jp.yahooapis.ss.v201909.ObjectFactory.class,
    jp.yahooapis.ss.v201909.targetingidea.ObjectFactory.class
})
public interface TargetingIdeaServiceInterface {


    /**
     * 
     * @param selector
     * @param rval
     * @param error
     * @throws ApiException
     */
    @WebMethod
    @RequestWrapper(localName = "get", targetNamespace = "http://ss.yahooapis.jp/V201909/TargetingIdea", className = "jp.yahooapis.ss.v201909.targetingidea.Get")
    @ResponseWrapper(localName = "getResponse", targetNamespace = "http://ss.yahooapis.jp/V201909/TargetingIdea", className = "jp.yahooapis.ss.v201909.targetingidea.GetResponse")
    public void get(
        @WebParam(name = "selector", targetNamespace = "http://ss.yahooapis.jp/V201909/TargetingIdea")
        TargetingIdeaSelector selector,
        @WebParam(name = "rval", targetNamespace = "http://ss.yahooapis.jp/V201909/TargetingIdea", mode = WebParam.Mode.OUT)
        Holder<TargetingIdeaPage> rval,
        @WebParam(name = "error", targetNamespace = "http://ss.yahooapis.jp/V201909/TargetingIdea", mode = WebParam.Mode.OUT)
        Holder<List<Error>> error)
        throws ApiException
    ;

}
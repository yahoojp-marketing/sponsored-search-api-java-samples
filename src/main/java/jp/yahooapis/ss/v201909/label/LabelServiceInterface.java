
package jp.yahooapis.ss.v201909.label;

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
@WebService(name = "LabelServiceInterface", targetNamespace = "http://ss.yahooapis.jp/V201909/Label")
@XmlSeeAlso({
    jp.yahooapis.ss.v201909.ObjectFactory.class,
    jp.yahooapis.ss.v201909.label.ObjectFactory.class
})
public interface LabelServiceInterface {


    /**
     * 
     * @param selector
     * @param rval
     * @param error
     * @throws ApiException
     */
    @WebMethod
    @RequestWrapper(localName = "get", targetNamespace = "http://ss.yahooapis.jp/V201909/Label", className = "jp.yahooapis.ss.v201909.label.Get")
    @ResponseWrapper(localName = "getResponse", targetNamespace = "http://ss.yahooapis.jp/V201909/Label", className = "jp.yahooapis.ss.v201909.label.GetResponse")
    public void get(
        @WebParam(name = "selector", targetNamespace = "http://ss.yahooapis.jp/V201909/Label")
        LabelSelector selector,
        @WebParam(name = "rval", targetNamespace = "http://ss.yahooapis.jp/V201909/Label", mode = WebParam.Mode.OUT)
        Holder<LabelPage> rval,
        @WebParam(name = "error", targetNamespace = "http://ss.yahooapis.jp/V201909/Label", mode = WebParam.Mode.OUT)
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
    @RequestWrapper(localName = "mutate", targetNamespace = "http://ss.yahooapis.jp/V201909/Label", className = "jp.yahooapis.ss.v201909.label.Mutate")
    @ResponseWrapper(localName = "mutateResponse", targetNamespace = "http://ss.yahooapis.jp/V201909/Label", className = "jp.yahooapis.ss.v201909.label.MutateResponse")
    public void mutate(
        @WebParam(name = "operations", targetNamespace = "http://ss.yahooapis.jp/V201909/Label")
        LabelOperation operations,
        @WebParam(name = "rval", targetNamespace = "http://ss.yahooapis.jp/V201909/Label", mode = WebParam.Mode.OUT)
        Holder<LabelReturnValue> rval,
        @WebParam(name = "error", targetNamespace = "http://ss.yahooapis.jp/V201909/Label", mode = WebParam.Mode.OUT)
        Holder<List<Error>> error)
        throws ApiException
    ;

}
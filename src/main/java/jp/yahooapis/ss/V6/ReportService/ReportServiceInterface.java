
package jp.yahooapis.ss.V6.ReportService;

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
@WebService(name = "ReportServiceInterface", targetNamespace = "http://ss.yahooapis.jp/V6")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface ReportServiceInterface {


    /**
     * 
     * @param selector
     * @param rval
     * @param error
     * @throws ApiException
     */
    @WebMethod
    @RequestWrapper(localName = "get", targetNamespace = "http://ss.yahooapis.jp/V6", className = "jp.yahooapis.ss.V6.ReportService.Get")
    @ResponseWrapper(localName = "getResponse", targetNamespace = "http://ss.yahooapis.jp/V6", className = "jp.yahooapis.ss.V6.ReportService.GetResponse")
    public void get(
        @WebParam(name = "selector", targetNamespace = "http://ss.yahooapis.jp/V6")
        ReportSelector selector,
        @WebParam(name = "rval", targetNamespace = "http://ss.yahooapis.jp/V6", mode = WebParam.Mode.OUT)
        Holder<ReportPage> rval,
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
    @RequestWrapper(localName = "mutate", targetNamespace = "http://ss.yahooapis.jp/V6", className = "jp.yahooapis.ss.V6.ReportService.Mutate")
    @ResponseWrapper(localName = "mutateResponse", targetNamespace = "http://ss.yahooapis.jp/V6", className = "jp.yahooapis.ss.V6.ReportService.MutateResponse")
    public void mutate(
        @WebParam(name = "operations", targetNamespace = "http://ss.yahooapis.jp/V6")
        ReportOperation operations,
        @WebParam(name = "rval", targetNamespace = "http://ss.yahooapis.jp/V6", mode = WebParam.Mode.OUT)
        Holder<ReportReturnValue> rval,
        @WebParam(name = "error", targetNamespace = "http://ss.yahooapis.jp/V6", mode = WebParam.Mode.OUT)
        Holder<List<Error>> error)
        throws ApiException
    ;

}

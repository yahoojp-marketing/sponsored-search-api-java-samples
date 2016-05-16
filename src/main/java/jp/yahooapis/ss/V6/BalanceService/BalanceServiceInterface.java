
package jp.yahooapis.ss.V6.BalanceService;

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
@WebService(name = "BalanceServiceInterface", targetNamespace = "http://ss.yahooapis.jp/V6")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface BalanceServiceInterface {


    /**
     * 
     * @param selector
     * @param rval
     * @param error
     * @throws ApiException
     */
    @WebMethod
    @RequestWrapper(localName = "get", targetNamespace = "http://ss.yahooapis.jp/V6", className = "jp.yahooapis.ss.V6.BalanceService.Get")
    @ResponseWrapper(localName = "getResponse", targetNamespace = "http://ss.yahooapis.jp/V6", className = "jp.yahooapis.ss.V6.BalanceService.GetResponse")
    public void get(
        @WebParam(name = "selector", targetNamespace = "http://ss.yahooapis.jp/V6")
        BalanceSelector selector,
        @WebParam(name = "rval", targetNamespace = "http://ss.yahooapis.jp/V6", mode = WebParam.Mode.OUT)
        Holder<BalancePage> rval,
        @WebParam(name = "error", targetNamespace = "http://ss.yahooapis.jp/V6", mode = WebParam.Mode.OUT)
        Holder<List<Error>> error)
        throws ApiException
    ;

}
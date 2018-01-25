
package jp.yahooapis.ss.V6.AccountSharedService;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceException;
import javax.xml.ws.WebServiceFeature;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.9-b130926.1035
 * Generated source version: 2.2
 * 
 */
@WebServiceClient(name = "AccountSharedService", targetNamespace = "http://ss.yahooapis.jp/V6", wsdlLocation = "https://sandbox.ss.yahooapis.jp/services/V6.5/AccountSharedService?wsdl")
public class AccountSharedService
    extends Service
{

    private final static URL ACCOUNTSHAREDSERVICE_WSDL_LOCATION;
    private final static WebServiceException ACCOUNTSHAREDSERVICE_EXCEPTION;
    private final static QName ACCOUNTSHAREDSERVICE_QNAME = new QName("http://ss.yahooapis.jp/V6", "AccountSharedService");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("https://sandbox.ss.yahooapis.jp/services/V6.5/AccountSharedService?wsdl");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        ACCOUNTSHAREDSERVICE_WSDL_LOCATION = url;
        ACCOUNTSHAREDSERVICE_EXCEPTION = e;
    }

    public AccountSharedService() {
        super(__getWsdlLocation(), ACCOUNTSHAREDSERVICE_QNAME);
    }

    public AccountSharedService(WebServiceFeature... features) {
        super(__getWsdlLocation(), ACCOUNTSHAREDSERVICE_QNAME, features);
    }

    public AccountSharedService(URL wsdlLocation) {
        super(wsdlLocation, ACCOUNTSHAREDSERVICE_QNAME);
    }

    public AccountSharedService(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, ACCOUNTSHAREDSERVICE_QNAME, features);
    }

    public AccountSharedService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public AccountSharedService(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     * 
     * @return
     *     returns AccountSharedServiceInterface
     */
    @WebEndpoint(name = "AccountSharedService")
    public AccountSharedServiceInterface getAccountSharedService() {
        return super.getPort(new QName("http://ss.yahooapis.jp/V6", "AccountSharedService"), AccountSharedServiceInterface.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns AccountSharedServiceInterface
     */
    @WebEndpoint(name = "AccountSharedService")
    public AccountSharedServiceInterface getAccountSharedService(WebServiceFeature... features) {
        return super.getPort(new QName("http://ss.yahooapis.jp/V6", "AccountSharedService"), AccountSharedServiceInterface.class, features);
    }

    private static URL __getWsdlLocation() {
        if (ACCOUNTSHAREDSERVICE_EXCEPTION!= null) {
            throw ACCOUNTSHAREDSERVICE_EXCEPTION;
        }
        return ACCOUNTSHAREDSERVICE_WSDL_LOCATION;
    }

}

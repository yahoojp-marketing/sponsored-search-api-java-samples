
package jp.yahooapis.ss.V6.CustomerSyncService;

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
@WebServiceClient(name = "CustomerSyncService", targetNamespace = "http://ss.yahooapis.jp/V6", wsdlLocation = "https://sandbox.ss.yahooapis.jp/services/V6.0/CustomerSyncService?wsdl")
public class CustomerSyncService
    extends Service
{

    private final static URL CUSTOMERSYNCSERVICE_WSDL_LOCATION;
    private final static WebServiceException CUSTOMERSYNCSERVICE_EXCEPTION;
    private final static QName CUSTOMERSYNCSERVICE_QNAME = new QName("http://ss.yahooapis.jp/V6", "CustomerSyncService");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("https://sandbox.ss.yahooapis.jp/services/V6.0/CustomerSyncService?wsdl");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        CUSTOMERSYNCSERVICE_WSDL_LOCATION = url;
        CUSTOMERSYNCSERVICE_EXCEPTION = e;
    }

    public CustomerSyncService() {
        super(__getWsdlLocation(), CUSTOMERSYNCSERVICE_QNAME);
    }

    public CustomerSyncService(WebServiceFeature... features) {
        super(__getWsdlLocation(), CUSTOMERSYNCSERVICE_QNAME, features);
    }

    public CustomerSyncService(URL wsdlLocation) {
        super(wsdlLocation, CUSTOMERSYNCSERVICE_QNAME);
    }

    public CustomerSyncService(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, CUSTOMERSYNCSERVICE_QNAME, features);
    }

    public CustomerSyncService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public CustomerSyncService(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     * 
     * @return
     *     returns CustomerSyncServiceInterface
     */
    @WebEndpoint(name = "CustomerSyncService")
    public CustomerSyncServiceInterface getCustomerSyncService() {
        return super.getPort(new QName("http://ss.yahooapis.jp/V6", "CustomerSyncService"), CustomerSyncServiceInterface.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns CustomerSyncServiceInterface
     */
    @WebEndpoint(name = "CustomerSyncService")
    public CustomerSyncServiceInterface getCustomerSyncService(WebServiceFeature... features) {
        return super.getPort(new QName("http://ss.yahooapis.jp/V6", "CustomerSyncService"), CustomerSyncServiceInterface.class, features);
    }

    private static URL __getWsdlLocation() {
        if (CUSTOMERSYNCSERVICE_EXCEPTION!= null) {
            throw CUSTOMERSYNCSERVICE_EXCEPTION;
        }
        return CUSTOMERSYNCSERVICE_WSDL_LOCATION;
    }

}

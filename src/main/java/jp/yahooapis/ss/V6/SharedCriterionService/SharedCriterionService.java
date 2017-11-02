
package jp.yahooapis.ss.V6.SharedCriterionService;

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
@WebServiceClient(name = "SharedCriterionService", targetNamespace = "http://ss.yahooapis.jp/V6", wsdlLocation = "https://sandbox.ss.yahooapis.jp/services/V6.4/SharedCriterionService?wsdl")
public class SharedCriterionService
    extends Service
{

    private final static URL SHAREDCRITERIONSERVICE_WSDL_LOCATION;
    private final static WebServiceException SHAREDCRITERIONSERVICE_EXCEPTION;
    private final static QName SHAREDCRITERIONSERVICE_QNAME = new QName("http://ss.yahooapis.jp/V6", "SharedCriterionService");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("https://sandbox.ss.yahooapis.jp/services/V6.4/SharedCriterionService?wsdl");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        SHAREDCRITERIONSERVICE_WSDL_LOCATION = url;
        SHAREDCRITERIONSERVICE_EXCEPTION = e;
    }

    public SharedCriterionService() {
        super(__getWsdlLocation(), SHAREDCRITERIONSERVICE_QNAME);
    }

    public SharedCriterionService(WebServiceFeature... features) {
        super(__getWsdlLocation(), SHAREDCRITERIONSERVICE_QNAME, features);
    }

    public SharedCriterionService(URL wsdlLocation) {
        super(wsdlLocation, SHAREDCRITERIONSERVICE_QNAME);
    }

    public SharedCriterionService(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, SHAREDCRITERIONSERVICE_QNAME, features);
    }

    public SharedCriterionService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public SharedCriterionService(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     * 
     * @return
     *     returns SharedCriterionServiceInterface
     */
    @WebEndpoint(name = "SharedCriterionService")
    public SharedCriterionServiceInterface getSharedCriterionService() {
        return super.getPort(new QName("http://ss.yahooapis.jp/V6", "SharedCriterionService"), SharedCriterionServiceInterface.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns SharedCriterionServiceInterface
     */
    @WebEndpoint(name = "SharedCriterionService")
    public SharedCriterionServiceInterface getSharedCriterionService(WebServiceFeature... features) {
        return super.getPort(new QName("http://ss.yahooapis.jp/V6", "SharedCriterionService"), SharedCriterionServiceInterface.class, features);
    }

    private static URL __getWsdlLocation() {
        if (SHAREDCRITERIONSERVICE_EXCEPTION!= null) {
            throw SHAREDCRITERIONSERVICE_EXCEPTION;
        }
        return SHAREDCRITERIONSERVICE_WSDL_LOCATION;
    }

}

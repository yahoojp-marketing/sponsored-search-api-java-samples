
package jp.yahooapis.ss.v201909.label;

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
@WebServiceClient(name = "LabelService", targetNamespace = "http://ss.yahooapis.jp/V201909/Label", wsdlLocation = "https://sandbox.ss.yahooapis.jp/services/V201909/LabelService?wsdl")
public class LabelService
    extends Service
{

    private final static URL LABELSERVICE_WSDL_LOCATION;
    private final static WebServiceException LABELSERVICE_EXCEPTION;
    private final static QName LABELSERVICE_QNAME = new QName("http://ss.yahooapis.jp/V201909/Label", "LabelService");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("https://sandbox.ss.yahooapis.jp/services/V201909/LabelService?wsdl");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        LABELSERVICE_WSDL_LOCATION = url;
        LABELSERVICE_EXCEPTION = e;
    }

    public LabelService() {
        super(__getWsdlLocation(), LABELSERVICE_QNAME);
    }

    public LabelService(WebServiceFeature... features) {
        super(__getWsdlLocation(), LABELSERVICE_QNAME, features);
    }

    public LabelService(URL wsdlLocation) {
        super(wsdlLocation, LABELSERVICE_QNAME);
    }

    public LabelService(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, LABELSERVICE_QNAME, features);
    }

    public LabelService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public LabelService(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     * 
     * @return
     *     returns LabelServiceInterface
     */
    @WebEndpoint(name = "LabelService")
    public LabelServiceInterface getLabelService() {
        return super.getPort(new QName("http://ss.yahooapis.jp/V201909/Label", "LabelService"), LabelServiceInterface.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns LabelServiceInterface
     */
    @WebEndpoint(name = "LabelService")
    public LabelServiceInterface getLabelService(WebServiceFeature... features) {
        return super.getPort(new QName("http://ss.yahooapis.jp/V201909/Label", "LabelService"), LabelServiceInterface.class, features);
    }

    private static URL __getWsdlLocation() {
        if (LABELSERVICE_EXCEPTION!= null) {
            throw LABELSERVICE_EXCEPTION;
        }
        return LABELSERVICE_WSDL_LOCATION;
    }

}

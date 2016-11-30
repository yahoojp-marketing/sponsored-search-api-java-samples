
package jp.yahooapis.ss.V6.BidLandscapeService;

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
@WebServiceClient(name = "BidLandscapeService", targetNamespace = "http://ss.yahooapis.jp/V6", wsdlLocation = "https://sandbox.ss.yahooapis.jp/services/V6.2/BidLandscapeService?wsdl")
public class BidLandscapeService
    extends Service
{

    private final static URL BIDLANDSCAPESERVICE_WSDL_LOCATION;
    private final static WebServiceException BIDLANDSCAPESERVICE_EXCEPTION;
    private final static QName BIDLANDSCAPESERVICE_QNAME = new QName("http://ss.yahooapis.jp/V6", "BidLandscapeService");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("https://sandbox.ss.yahooapis.jp/services/V6.2/BidLandscapeService?wsdl");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        BIDLANDSCAPESERVICE_WSDL_LOCATION = url;
        BIDLANDSCAPESERVICE_EXCEPTION = e;
    }

    public BidLandscapeService() {
        super(__getWsdlLocation(), BIDLANDSCAPESERVICE_QNAME);
    }

    public BidLandscapeService(WebServiceFeature... features) {
        super(__getWsdlLocation(), BIDLANDSCAPESERVICE_QNAME, features);
    }

    public BidLandscapeService(URL wsdlLocation) {
        super(wsdlLocation, BIDLANDSCAPESERVICE_QNAME);
    }

    public BidLandscapeService(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, BIDLANDSCAPESERVICE_QNAME, features);
    }

    public BidLandscapeService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public BidLandscapeService(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     * 
     * @return
     *     returns BidLandscapeServiceInterface
     */
    @WebEndpoint(name = "BidLandscapeService")
    public BidLandscapeServiceInterface getBidLandscapeService() {
        return super.getPort(new QName("http://ss.yahooapis.jp/V6", "BidLandscapeService"), BidLandscapeServiceInterface.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns BidLandscapeServiceInterface
     */
    @WebEndpoint(name = "BidLandscapeService")
    public BidLandscapeServiceInterface getBidLandscapeService(WebServiceFeature... features) {
        return super.getPort(new QName("http://ss.yahooapis.jp/V6", "BidLandscapeService"), BidLandscapeServiceInterface.class, features);
    }

    private static URL __getWsdlLocation() {
        if (BIDLANDSCAPESERVICE_EXCEPTION!= null) {
            throw BIDLANDSCAPESERVICE_EXCEPTION;
        }
        return BIDLANDSCAPESERVICE_WSDL_LOCATION;
    }

}

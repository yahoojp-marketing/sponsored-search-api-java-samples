
package jp.yahooapis.ss.V6.AdGroupBidMultiplierService;

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
@WebServiceClient(name = "AdGroupBidMultiplierService", targetNamespace = "http://ss.yahooapis.jp/V6", wsdlLocation = "https://sandbox.ss.yahooapis.jp/services/V6.4/AdGroupBidMultiplierService?wsdl")
public class AdGroupBidMultiplierService
    extends Service
{

    private final static URL ADGROUPBIDMULTIPLIERSERVICE_WSDL_LOCATION;
    private final static WebServiceException ADGROUPBIDMULTIPLIERSERVICE_EXCEPTION;
    private final static QName ADGROUPBIDMULTIPLIERSERVICE_QNAME = new QName("http://ss.yahooapis.jp/V6", "AdGroupBidMultiplierService");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("https://sandbox.ss.yahooapis.jp/services/V6.4/AdGroupBidMultiplierService?wsdl");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        ADGROUPBIDMULTIPLIERSERVICE_WSDL_LOCATION = url;
        ADGROUPBIDMULTIPLIERSERVICE_EXCEPTION = e;
    }

    public AdGroupBidMultiplierService() {
        super(__getWsdlLocation(), ADGROUPBIDMULTIPLIERSERVICE_QNAME);
    }

    public AdGroupBidMultiplierService(WebServiceFeature... features) {
        super(__getWsdlLocation(), ADGROUPBIDMULTIPLIERSERVICE_QNAME, features);
    }

    public AdGroupBidMultiplierService(URL wsdlLocation) {
        super(wsdlLocation, ADGROUPBIDMULTIPLIERSERVICE_QNAME);
    }

    public AdGroupBidMultiplierService(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, ADGROUPBIDMULTIPLIERSERVICE_QNAME, features);
    }

    public AdGroupBidMultiplierService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public AdGroupBidMultiplierService(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     * 
     * @return
     *     returns AdGroupBidMultiplierServiceInterface
     */
    @WebEndpoint(name = "AdGroupBidMultiplierService")
    public AdGroupBidMultiplierServiceInterface getAdGroupBidMultiplierService() {
        return super.getPort(new QName("http://ss.yahooapis.jp/V6", "AdGroupBidMultiplierService"), AdGroupBidMultiplierServiceInterface.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns AdGroupBidMultiplierServiceInterface
     */
    @WebEndpoint(name = "AdGroupBidMultiplierService")
    public AdGroupBidMultiplierServiceInterface getAdGroupBidMultiplierService(WebServiceFeature... features) {
        return super.getPort(new QName("http://ss.yahooapis.jp/V6", "AdGroupBidMultiplierService"), AdGroupBidMultiplierServiceInterface.class, features);
    }

    private static URL __getWsdlLocation() {
        if (ADGROUPBIDMULTIPLIERSERVICE_EXCEPTION!= null) {
            throw ADGROUPBIDMULTIPLIERSERVICE_EXCEPTION;
        }
        return ADGROUPBIDMULTIPLIERSERVICE_WSDL_LOCATION;
    }

}

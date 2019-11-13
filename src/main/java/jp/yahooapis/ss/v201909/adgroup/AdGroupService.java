
package jp.yahooapis.ss.v201909.adgroup;

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
@WebServiceClient(name = "AdGroupService", targetNamespace = "http://ss.yahooapis.jp/V201909/AdGroup", wsdlLocation = "https://sandbox.ss.yahooapis.jp/services/V201909/AdGroupService?wsdl")
public class AdGroupService
    extends Service
{

    private final static URL ADGROUPSERVICE_WSDL_LOCATION;
    private final static WebServiceException ADGROUPSERVICE_EXCEPTION;
    private final static QName ADGROUPSERVICE_QNAME = new QName("http://ss.yahooapis.jp/V201909/AdGroup", "AdGroupService");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("https://sandbox.ss.yahooapis.jp/services/V201909/AdGroupService?wsdl");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        ADGROUPSERVICE_WSDL_LOCATION = url;
        ADGROUPSERVICE_EXCEPTION = e;
    }

    public AdGroupService() {
        super(__getWsdlLocation(), ADGROUPSERVICE_QNAME);
    }

    public AdGroupService(WebServiceFeature... features) {
        super(__getWsdlLocation(), ADGROUPSERVICE_QNAME, features);
    }

    public AdGroupService(URL wsdlLocation) {
        super(wsdlLocation, ADGROUPSERVICE_QNAME);
    }

    public AdGroupService(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, ADGROUPSERVICE_QNAME, features);
    }

    public AdGroupService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public AdGroupService(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     * 
     * @return
     *     returns AdGroupServiceInterface
     */
    @WebEndpoint(name = "AdGroupService")
    public AdGroupServiceInterface getAdGroupService() {
        return super.getPort(new QName("http://ss.yahooapis.jp/V201909/AdGroup", "AdGroupService"), AdGroupServiceInterface.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns AdGroupServiceInterface
     */
    @WebEndpoint(name = "AdGroupService")
    public AdGroupServiceInterface getAdGroupService(WebServiceFeature... features) {
        return super.getPort(new QName("http://ss.yahooapis.jp/V201909/AdGroup", "AdGroupService"), AdGroupServiceInterface.class, features);
    }

    private static URL __getWsdlLocation() {
        if (ADGROUPSERVICE_EXCEPTION!= null) {
            throw ADGROUPSERVICE_EXCEPTION;
        }
        return ADGROUPSERVICE_WSDL_LOCATION;
    }

}
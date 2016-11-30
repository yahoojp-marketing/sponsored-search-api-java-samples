
package jp.yahooapis.ss.V6.CampaignSharedSetService;

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
@WebServiceClient(name = "CampaignSharedSetService", targetNamespace = "http://ss.yahooapis.jp/V6", wsdlLocation = "https://sandbox.ss.yahooapis.jp/services/V6.2/CampaignSharedSetService?wsdl")
public class CampaignSharedSetService
    extends Service
{

    private final static URL CAMPAIGNSHAREDSETSERVICE_WSDL_LOCATION;
    private final static WebServiceException CAMPAIGNSHAREDSETSERVICE_EXCEPTION;
    private final static QName CAMPAIGNSHAREDSETSERVICE_QNAME = new QName("http://ss.yahooapis.jp/V6", "CampaignSharedSetService");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("https://sandbox.ss.yahooapis.jp/services/V6.2/CampaignSharedSetService?wsdl");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        CAMPAIGNSHAREDSETSERVICE_WSDL_LOCATION = url;
        CAMPAIGNSHAREDSETSERVICE_EXCEPTION = e;
    }

    public CampaignSharedSetService() {
        super(__getWsdlLocation(), CAMPAIGNSHAREDSETSERVICE_QNAME);
    }

    public CampaignSharedSetService(WebServiceFeature... features) {
        super(__getWsdlLocation(), CAMPAIGNSHAREDSETSERVICE_QNAME, features);
    }

    public CampaignSharedSetService(URL wsdlLocation) {
        super(wsdlLocation, CAMPAIGNSHAREDSETSERVICE_QNAME);
    }

    public CampaignSharedSetService(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, CAMPAIGNSHAREDSETSERVICE_QNAME, features);
    }

    public CampaignSharedSetService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public CampaignSharedSetService(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     * 
     * @return
     *     returns CampaignSharedSetServiceInterface
     */
    @WebEndpoint(name = "CampaignSharedSetService")
    public CampaignSharedSetServiceInterface getCampaignSharedSetService() {
        return super.getPort(new QName("http://ss.yahooapis.jp/V6", "CampaignSharedSetService"), CampaignSharedSetServiceInterface.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns CampaignSharedSetServiceInterface
     */
    @WebEndpoint(name = "CampaignSharedSetService")
    public CampaignSharedSetServiceInterface getCampaignSharedSetService(WebServiceFeature... features) {
        return super.getPort(new QName("http://ss.yahooapis.jp/V6", "CampaignSharedSetService"), CampaignSharedSetServiceInterface.class, features);
    }

    private static URL __getWsdlLocation() {
        if (CAMPAIGNSHAREDSETSERVICE_EXCEPTION!= null) {
            throw CAMPAIGNSHAREDSETSERVICE_EXCEPTION;
        }
        return CAMPAIGNSHAREDSETSERVICE_WSDL_LOCATION;
    }

}

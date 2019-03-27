
package jp.yahooapis.ss.v201901.campaign;

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
@WebServiceClient(name = "CampaignService", targetNamespace = "http://ss.yahooapis.jp/V201901/Campaign", wsdlLocation = "https://ss.yahooapis.jp/services/V201901/CampaignService?wsdl")
public class CampaignService
    extends Service
{

    private final static URL CAMPAIGNSERVICE_WSDL_LOCATION;
    private final static WebServiceException CAMPAIGNSERVICE_EXCEPTION;
    private final static QName CAMPAIGNSERVICE_QNAME = new QName("http://ss.yahooapis.jp/V201901/Campaign", "CampaignService");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("https://ss.yahooapis.jp/services/V201901/CampaignService?wsdl");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        CAMPAIGNSERVICE_WSDL_LOCATION = url;
        CAMPAIGNSERVICE_EXCEPTION = e;
    }

    public CampaignService() {
        super(__getWsdlLocation(), CAMPAIGNSERVICE_QNAME);
    }

    public CampaignService(WebServiceFeature... features) {
        super(__getWsdlLocation(), CAMPAIGNSERVICE_QNAME, features);
    }

    public CampaignService(URL wsdlLocation) {
        super(wsdlLocation, CAMPAIGNSERVICE_QNAME);
    }

    public CampaignService(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, CAMPAIGNSERVICE_QNAME, features);
    }

    public CampaignService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public CampaignService(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     * 
     * @return
     *     returns CampaignServiceInterface
     */
    @WebEndpoint(name = "CampaignService")
    public CampaignServiceInterface getCampaignService() {
        return super.getPort(new QName("http://ss.yahooapis.jp/V201901/Campaign", "CampaignService"), CampaignServiceInterface.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns CampaignServiceInterface
     */
    @WebEndpoint(name = "CampaignService")
    public CampaignServiceInterface getCampaignService(WebServiceFeature... features) {
        return super.getPort(new QName("http://ss.yahooapis.jp/V201901/Campaign", "CampaignService"), CampaignServiceInterface.class, features);
    }

    private static URL __getWsdlLocation() {
        if (CAMPAIGNSERVICE_EXCEPTION!= null) {
            throw CAMPAIGNSERVICE_EXCEPTION;
        }
        return CAMPAIGNSERVICE_WSDL_LOCATION;
    }

}

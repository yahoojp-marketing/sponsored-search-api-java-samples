
package jp.yahooapis.ss.v201808.campaigntarget;

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
@WebServiceClient(name = "CampaignTargetService", targetNamespace = "http://ss.yahooapis.jp/V201808/CampaignTarget", wsdlLocation = "https://sandbox.ss.yahooapis.jp/services/V201808/CampaignTargetService?wsdl")
public class CampaignTargetService
    extends Service
{

    private final static URL CAMPAIGNTARGETSERVICE_WSDL_LOCATION;
    private final static WebServiceException CAMPAIGNTARGETSERVICE_EXCEPTION;
    private final static QName CAMPAIGNTARGETSERVICE_QNAME = new QName("http://ss.yahooapis.jp/V201808/CampaignTarget", "CampaignTargetService");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("https://sandbox.ss.yahooapis.jp/services/V201808/CampaignTargetService?wsdl");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        CAMPAIGNTARGETSERVICE_WSDL_LOCATION = url;
        CAMPAIGNTARGETSERVICE_EXCEPTION = e;
    }

    public CampaignTargetService() {
        super(__getWsdlLocation(), CAMPAIGNTARGETSERVICE_QNAME);
    }

    public CampaignTargetService(WebServiceFeature... features) {
        super(__getWsdlLocation(), CAMPAIGNTARGETSERVICE_QNAME, features);
    }

    public CampaignTargetService(URL wsdlLocation) {
        super(wsdlLocation, CAMPAIGNTARGETSERVICE_QNAME);
    }

    public CampaignTargetService(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, CAMPAIGNTARGETSERVICE_QNAME, features);
    }

    public CampaignTargetService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public CampaignTargetService(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     * 
     * @return
     *     returns CampaignTargetServiceInterface
     */
    @WebEndpoint(name = "CampaignTargetService")
    public CampaignTargetServiceInterface getCampaignTargetService() {
        return super.getPort(new QName("http://ss.yahooapis.jp/V201808/CampaignTarget", "CampaignTargetService"), CampaignTargetServiceInterface.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns CampaignTargetServiceInterface
     */
    @WebEndpoint(name = "CampaignTargetService")
    public CampaignTargetServiceInterface getCampaignTargetService(WebServiceFeature... features) {
        return super.getPort(new QName("http://ss.yahooapis.jp/V201808/CampaignTarget", "CampaignTargetService"), CampaignTargetServiceInterface.class, features);
    }

    private static URL __getWsdlLocation() {
        if (CAMPAIGNTARGETSERVICE_EXCEPTION!= null) {
            throw CAMPAIGNTARGETSERVICE_EXCEPTION;
        }
        return CAMPAIGNTARGETSERVICE_WSDL_LOCATION;
    }

}
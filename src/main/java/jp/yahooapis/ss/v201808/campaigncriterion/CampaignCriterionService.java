
package jp.yahooapis.ss.v201808.campaigncriterion;

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
@WebServiceClient(name = "CampaignCriterionService", targetNamespace = "http://ss.yahooapis.jp/V201808/CampaignCriterion", wsdlLocation = "https://sandbox.ss.yahooapis.jp/services/V201808/CampaignCriterionService?wsdl")
public class CampaignCriterionService
    extends Service
{

    private final static URL CAMPAIGNCRITERIONSERVICE_WSDL_LOCATION;
    private final static WebServiceException CAMPAIGNCRITERIONSERVICE_EXCEPTION;
    private final static QName CAMPAIGNCRITERIONSERVICE_QNAME = new QName("http://ss.yahooapis.jp/V201808/CampaignCriterion", "CampaignCriterionService");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("https://sandbox.ss.yahooapis.jp/services/V201808/CampaignCriterionService?wsdl");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        CAMPAIGNCRITERIONSERVICE_WSDL_LOCATION = url;
        CAMPAIGNCRITERIONSERVICE_EXCEPTION = e;
    }

    public CampaignCriterionService() {
        super(__getWsdlLocation(), CAMPAIGNCRITERIONSERVICE_QNAME);
    }

    public CampaignCriterionService(WebServiceFeature... features) {
        super(__getWsdlLocation(), CAMPAIGNCRITERIONSERVICE_QNAME, features);
    }

    public CampaignCriterionService(URL wsdlLocation) {
        super(wsdlLocation, CAMPAIGNCRITERIONSERVICE_QNAME);
    }

    public CampaignCriterionService(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, CAMPAIGNCRITERIONSERVICE_QNAME, features);
    }

    public CampaignCriterionService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public CampaignCriterionService(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     * 
     * @return
     *     returns CampaignCriterionServiceInterface
     */
    @WebEndpoint(name = "CampaignCriterionService")
    public CampaignCriterionServiceInterface getCampaignCriterionService() {
        return super.getPort(new QName("http://ss.yahooapis.jp/V201808/CampaignCriterion", "CampaignCriterionService"), CampaignCriterionServiceInterface.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns CampaignCriterionServiceInterface
     */
    @WebEndpoint(name = "CampaignCriterionService")
    public CampaignCriterionServiceInterface getCampaignCriterionService(WebServiceFeature... features) {
        return super.getPort(new QName("http://ss.yahooapis.jp/V201808/CampaignCriterion", "CampaignCriterionService"), CampaignCriterionServiceInterface.class, features);
    }

    private static URL __getWsdlLocation() {
        if (CAMPAIGNCRITERIONSERVICE_EXCEPTION!= null) {
            throw CAMPAIGNCRITERIONSERVICE_EXCEPTION;
        }
        return CAMPAIGNCRITERIONSERVICE_WSDL_LOCATION;
    }

}

package jp.yahooapis.ss.V6.CampaignExportService;

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
@WebServiceClient(name = "CampaignExportService", targetNamespace = "http://ss.yahooapis.jp/V6", wsdlLocation = "https://sandbox.ss.yahooapis.jp/services/V6.3/CampaignExportService?wsdl")
public class CampaignExportService
    extends Service
{

    private final static URL CAMPAIGNEXPORTSERVICE_WSDL_LOCATION;
    private final static WebServiceException CAMPAIGNEXPORTSERVICE_EXCEPTION;
    private final static QName CAMPAIGNEXPORTSERVICE_QNAME = new QName("http://ss.yahooapis.jp/V6", "CampaignExportService");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("https://sandbox.ss.yahooapis.jp/services/V6.3/CampaignExportService?wsdl");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        CAMPAIGNEXPORTSERVICE_WSDL_LOCATION = url;
        CAMPAIGNEXPORTSERVICE_EXCEPTION = e;
    }

    public CampaignExportService() {
        super(__getWsdlLocation(), CAMPAIGNEXPORTSERVICE_QNAME);
    }

    public CampaignExportService(WebServiceFeature... features) {
        super(__getWsdlLocation(), CAMPAIGNEXPORTSERVICE_QNAME, features);
    }

    public CampaignExportService(URL wsdlLocation) {
        super(wsdlLocation, CAMPAIGNEXPORTSERVICE_QNAME);
    }

    public CampaignExportService(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, CAMPAIGNEXPORTSERVICE_QNAME, features);
    }

    public CampaignExportService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public CampaignExportService(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     * 
     * @return
     *     returns CampaignExportServiceInterface
     */
    @WebEndpoint(name = "CampaignExportService")
    public CampaignExportServiceInterface getCampaignExportService() {
        return super.getPort(new QName("http://ss.yahooapis.jp/V6", "CampaignExportService"), CampaignExportServiceInterface.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns CampaignExportServiceInterface
     */
    @WebEndpoint(name = "CampaignExportService")
    public CampaignExportServiceInterface getCampaignExportService(WebServiceFeature... features) {
        return super.getPort(new QName("http://ss.yahooapis.jp/V6", "CampaignExportService"), CampaignExportServiceInterface.class, features);
    }

    private static URL __getWsdlLocation() {
        if (CAMPAIGNEXPORTSERVICE_EXCEPTION!= null) {
            throw CAMPAIGNEXPORTSERVICE_EXCEPTION;
        }
        return CAMPAIGNEXPORTSERVICE_WSDL_LOCATION;
    }

}


package jp.yahooapis.ss.V6.ReportDefinitionService;

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
@WebServiceClient(name = "ReportDefinitionService", targetNamespace = "http://ss.yahooapis.jp/V6", wsdlLocation = "https://sandbox.ss.yahooapis.jp/services/V6.1/ReportDefinitionService?wsdl")
public class ReportDefinitionService
    extends Service
{

    private final static URL REPORTDEFINITIONSERVICE_WSDL_LOCATION;
    private final static WebServiceException REPORTDEFINITIONSERVICE_EXCEPTION;
    private final static QName REPORTDEFINITIONSERVICE_QNAME = new QName("http://ss.yahooapis.jp/V6", "ReportDefinitionService");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("https://sandbox.ss.yahooapis.jp/services/V6.1/ReportDefinitionService?wsdl");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        REPORTDEFINITIONSERVICE_WSDL_LOCATION = url;
        REPORTDEFINITIONSERVICE_EXCEPTION = e;
    }

    public ReportDefinitionService() {
        super(__getWsdlLocation(), REPORTDEFINITIONSERVICE_QNAME);
    }

    public ReportDefinitionService(WebServiceFeature... features) {
        super(__getWsdlLocation(), REPORTDEFINITIONSERVICE_QNAME, features);
    }

    public ReportDefinitionService(URL wsdlLocation) {
        super(wsdlLocation, REPORTDEFINITIONSERVICE_QNAME);
    }

    public ReportDefinitionService(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, REPORTDEFINITIONSERVICE_QNAME, features);
    }

    public ReportDefinitionService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public ReportDefinitionService(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     * 
     * @return
     *     returns ReportDefinitionServiceInterface
     */
    @WebEndpoint(name = "ReportDefinitionService")
    public ReportDefinitionServiceInterface getReportDefinitionService() {
        return super.getPort(new QName("http://ss.yahooapis.jp/V6", "ReportDefinitionService"), ReportDefinitionServiceInterface.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns ReportDefinitionServiceInterface
     */
    @WebEndpoint(name = "ReportDefinitionService")
    public ReportDefinitionServiceInterface getReportDefinitionService(WebServiceFeature... features) {
        return super.getPort(new QName("http://ss.yahooapis.jp/V6", "ReportDefinitionService"), ReportDefinitionServiceInterface.class, features);
    }

    private static URL __getWsdlLocation() {
        if (REPORTDEFINITIONSERVICE_EXCEPTION!= null) {
            throw REPORTDEFINITIONSERVICE_EXCEPTION;
        }
        return REPORTDEFINITIONSERVICE_WSDL_LOCATION;
    }

}

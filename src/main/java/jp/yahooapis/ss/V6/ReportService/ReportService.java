
package jp.yahooapis.ss.V6.ReportService;

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
@WebServiceClient(name = "ReportService", targetNamespace = "http://ss.yahooapis.jp/V6", wsdlLocation = "https://sandbox.ss.yahooapis.jp/services/V6.3/ReportService?wsdl")
public class ReportService
    extends Service
{

    private final static URL REPORTSERVICE_WSDL_LOCATION;
    private final static WebServiceException REPORTSERVICE_EXCEPTION;
    private final static QName REPORTSERVICE_QNAME = new QName("http://ss.yahooapis.jp/V6", "ReportService");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("https://sandbox.ss.yahooapis.jp/services/V6.3/ReportService?wsdl");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        REPORTSERVICE_WSDL_LOCATION = url;
        REPORTSERVICE_EXCEPTION = e;
    }

    public ReportService() {
        super(__getWsdlLocation(), REPORTSERVICE_QNAME);
    }

    public ReportService(WebServiceFeature... features) {
        super(__getWsdlLocation(), REPORTSERVICE_QNAME, features);
    }

    public ReportService(URL wsdlLocation) {
        super(wsdlLocation, REPORTSERVICE_QNAME);
    }

    public ReportService(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, REPORTSERVICE_QNAME, features);
    }

    public ReportService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public ReportService(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     * 
     * @return
     *     returns ReportServiceInterface
     */
    @WebEndpoint(name = "ReportService")
    public ReportServiceInterface getReportService() {
        return super.getPort(new QName("http://ss.yahooapis.jp/V6", "ReportService"), ReportServiceInterface.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns ReportServiceInterface
     */
    @WebEndpoint(name = "ReportService")
    public ReportServiceInterface getReportService(WebServiceFeature... features) {
        return super.getPort(new QName("http://ss.yahooapis.jp/V6", "ReportService"), ReportServiceInterface.class, features);
    }

    private static URL __getWsdlLocation() {
        if (REPORTSERVICE_EXCEPTION!= null) {
            throw REPORTSERVICE_EXCEPTION;
        }
        return REPORTSERVICE_WSDL_LOCATION;
    }

}

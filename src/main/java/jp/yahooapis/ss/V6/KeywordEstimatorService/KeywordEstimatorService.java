
package jp.yahooapis.ss.V6.KeywordEstimatorService;

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
@WebServiceClient(name = "KeywordEstimatorService", targetNamespace = "http://ss.yahooapis.jp/V6", wsdlLocation = "https://sandbox.ss.yahooapis.jp/services/V6.2/KeywordEstimatorService?wsdl")
public class KeywordEstimatorService
    extends Service
{

    private final static URL KEYWORDESTIMATORSERVICE_WSDL_LOCATION;
    private final static WebServiceException KEYWORDESTIMATORSERVICE_EXCEPTION;
    private final static QName KEYWORDESTIMATORSERVICE_QNAME = new QName("http://ss.yahooapis.jp/V6", "KeywordEstimatorService");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("https://sandbox.ss.yahooapis.jp/services/V6.2/KeywordEstimatorService?wsdl");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        KEYWORDESTIMATORSERVICE_WSDL_LOCATION = url;
        KEYWORDESTIMATORSERVICE_EXCEPTION = e;
    }

    public KeywordEstimatorService() {
        super(__getWsdlLocation(), KEYWORDESTIMATORSERVICE_QNAME);
    }

    public KeywordEstimatorService(WebServiceFeature... features) {
        super(__getWsdlLocation(), KEYWORDESTIMATORSERVICE_QNAME, features);
    }

    public KeywordEstimatorService(URL wsdlLocation) {
        super(wsdlLocation, KEYWORDESTIMATORSERVICE_QNAME);
    }

    public KeywordEstimatorService(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, KEYWORDESTIMATORSERVICE_QNAME, features);
    }

    public KeywordEstimatorService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public KeywordEstimatorService(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     * 
     * @return
     *     returns KeywordEstimatorServiceInterface
     */
    @WebEndpoint(name = "KeywordEstimatorService")
    public KeywordEstimatorServiceInterface getKeywordEstimatorService() {
        return super.getPort(new QName("http://ss.yahooapis.jp/V6", "KeywordEstimatorService"), KeywordEstimatorServiceInterface.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns KeywordEstimatorServiceInterface
     */
    @WebEndpoint(name = "KeywordEstimatorService")
    public KeywordEstimatorServiceInterface getKeywordEstimatorService(WebServiceFeature... features) {
        return super.getPort(new QName("http://ss.yahooapis.jp/V6", "KeywordEstimatorService"), KeywordEstimatorServiceInterface.class, features);
    }

    private static URL __getWsdlLocation() {
        if (KEYWORDESTIMATORSERVICE_EXCEPTION!= null) {
            throw KEYWORDESTIMATORSERVICE_EXCEPTION;
        }
        return KEYWORDESTIMATORSERVICE_WSDL_LOCATION;
    }

}

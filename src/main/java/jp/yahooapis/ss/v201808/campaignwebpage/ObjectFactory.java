
package jp.yahooapis.ss.v201808.campaignwebpage;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;
import jp.yahooapis.ss.v201808.SoapHeader;
import jp.yahooapis.ss.v201808.SoapResponseHeader;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the jp.yahooapis.ss.v201808.campaignwebpage package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _ResponseHeader_QNAME = new QName("http://ss.yahooapis.jp/V201808/CampaignWebpage", "ResponseHeader");
    private final static QName _RequestHeader_QNAME = new QName("http://ss.yahooapis.jp/V201808/CampaignWebpage", "RequestHeader");
    private final static QName _ApiExceptionFault_QNAME = new QName("http://ss.yahooapis.jp/V201808/CampaignWebpage", "ApiExceptionFault");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: jp.yahooapis.ss.v201808.campaignwebpage
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link Mutate }
     * 
     */
    public Mutate createMutate() {
        return new Mutate();
    }

    /**
     * Create an instance of {@link CampaignWebpageOperation }
     * 
     */
    public CampaignWebpageOperation createCampaignWebpageOperation() {
        return new CampaignWebpageOperation();
    }

    /**
     * Create an instance of {@link GetResponse }
     * 
     */
    public GetResponse createGetResponse() {
        return new GetResponse();
    }

    /**
     * Create an instance of {@link CampaignWebpagePage }
     * 
     */
    public CampaignWebpagePage createCampaignWebpagePage() {
        return new CampaignWebpagePage();
    }

    /**
     * Create an instance of {@link Get }
     * 
     */
    public Get createGet() {
        return new Get();
    }

    /**
     * Create an instance of {@link CampaignWebpageSelector }
     * 
     */
    public CampaignWebpageSelector createCampaignWebpageSelector() {
        return new CampaignWebpageSelector();
    }

    /**
     * Create an instance of {@link MutateResponse }
     * 
     */
    public MutateResponse createMutateResponse() {
        return new MutateResponse();
    }

    /**
     * Create an instance of {@link CampaignWebpageReturnValue }
     * 
     */
    public CampaignWebpageReturnValue createCampaignWebpageReturnValue() {
        return new CampaignWebpageReturnValue();
    }

    /**
     * Create an instance of {@link Webpage }
     * 
     */
    public Webpage createWebpage() {
        return new Webpage();
    }

    /**
     * Create an instance of {@link CampaignWebpageValues }
     * 
     */
    public CampaignWebpageValues createCampaignWebpageValues() {
        return new CampaignWebpageValues();
    }

    /**
     * Create an instance of {@link CampaignWebpage }
     * 
     */
    public CampaignWebpage createCampaignWebpage() {
        return new CampaignWebpage();
    }

    /**
     * Create an instance of {@link WebpageParameter }
     * 
     */
    public WebpageParameter createWebpageParameter() {
        return new WebpageParameter();
    }

    /**
     * Create an instance of {@link WebpageCondition }
     * 
     */
    public WebpageCondition createWebpageCondition() {
        return new WebpageCondition();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SoapResponseHeader }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ss.yahooapis.jp/V201808/CampaignWebpage", name = "ResponseHeader")
    public JAXBElement<SoapResponseHeader> createResponseHeader(SoapResponseHeader value) {
        return new JAXBElement<SoapResponseHeader>(_ResponseHeader_QNAME, SoapResponseHeader.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SoapHeader }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ss.yahooapis.jp/V201808/CampaignWebpage", name = "RequestHeader")
    public JAXBElement<SoapHeader> createRequestHeader(SoapHeader value) {
        return new JAXBElement<SoapHeader>(_RequestHeader_QNAME, SoapHeader.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ss.yahooapis.jp/V201808/CampaignWebpage", name = "ApiExceptionFault")
    public JAXBElement<String> createApiExceptionFault(String value) {
        return new JAXBElement<String>(_ApiExceptionFault_QNAME, String.class, null, value);
    }

}

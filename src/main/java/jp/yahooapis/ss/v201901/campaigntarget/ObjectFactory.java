
package jp.yahooapis.ss.v201901.campaigntarget;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;
import jp.yahooapis.ss.v201901.SoapHeader;
import jp.yahooapis.ss.v201901.SoapResponseHeader;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the jp.yahooapis.ss.v201901.campaigntarget package. 
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

    private final static QName _ApiExceptionFault_QNAME = new QName("http://ss.yahooapis.jp/V201901/CampaignTarget", "ApiExceptionFault");
    private final static QName _RequestHeader_QNAME = new QName("http://ss.yahooapis.jp/V201901/CampaignTarget", "RequestHeader");
    private final static QName _ResponseHeader_QNAME = new QName("http://ss.yahooapis.jp/V201901/CampaignTarget", "ResponseHeader");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: jp.yahooapis.ss.v201901.campaigntarget
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
     * Create an instance of {@link CampaignTargetOperation }
     * 
     */
    public CampaignTargetOperation createCampaignTargetOperation() {
        return new CampaignTargetOperation();
    }

    /**
     * Create an instance of {@link GetResponse }
     * 
     */
    public GetResponse createGetResponse() {
        return new GetResponse();
    }

    /**
     * Create an instance of {@link CampaignTargetPage }
     * 
     */
    public CampaignTargetPage createCampaignTargetPage() {
        return new CampaignTargetPage();
    }

    /**
     * Create an instance of {@link Get }
     * 
     */
    public Get createGet() {
        return new Get();
    }

    /**
     * Create an instance of {@link CampaignTargetSelector }
     * 
     */
    public CampaignTargetSelector createCampaignTargetSelector() {
        return new CampaignTargetSelector();
    }

    /**
     * Create an instance of {@link MutateResponse }
     * 
     */
    public MutateResponse createMutateResponse() {
        return new MutateResponse();
    }

    /**
     * Create an instance of {@link CampaignTargetReturnValue }
     * 
     */
    public CampaignTargetReturnValue createCampaignTargetReturnValue() {
        return new CampaignTargetReturnValue();
    }

    /**
     * Create an instance of {@link ScheduleTarget }
     * 
     */
    public ScheduleTarget createScheduleTarget() {
        return new ScheduleTarget();
    }

    /**
     * Create an instance of {@link PlatformTarget }
     * 
     */
    public PlatformTarget createPlatformTarget() {
        return new PlatformTarget();
    }

    /**
     * Create an instance of {@link NetworkTarget }
     * 
     */
    public NetworkTarget createNetworkTarget() {
        return new NetworkTarget();
    }

    /**
     * Create an instance of {@link LocationTarget }
     * 
     */
    public LocationTarget createLocationTarget() {
        return new LocationTarget();
    }

    /**
     * Create an instance of {@link CampaignTargetValues }
     * 
     */
    public CampaignTargetValues createCampaignTargetValues() {
        return new CampaignTargetValues();
    }

    /**
     * Create an instance of {@link Target }
     * 
     */
    public Target createTarget() {
        return new Target();
    }

    /**
     * Create an instance of {@link CampaignTarget }
     * 
     */
    public CampaignTarget createCampaignTarget() {
        return new CampaignTarget();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ss.yahooapis.jp/V201901/CampaignTarget", name = "ApiExceptionFault")
    public JAXBElement<String> createApiExceptionFault(String value) {
        return new JAXBElement<String>(_ApiExceptionFault_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SoapHeader }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ss.yahooapis.jp/V201901/CampaignTarget", name = "RequestHeader")
    public JAXBElement<SoapHeader> createRequestHeader(SoapHeader value) {
        return new JAXBElement<SoapHeader>(_RequestHeader_QNAME, SoapHeader.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SoapResponseHeader }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ss.yahooapis.jp/V201901/CampaignTarget", name = "ResponseHeader")
    public JAXBElement<SoapResponseHeader> createResponseHeader(SoapResponseHeader value) {
        return new JAXBElement<SoapResponseHeader>(_ResponseHeader_QNAME, SoapResponseHeader.class, null, value);
    }

}

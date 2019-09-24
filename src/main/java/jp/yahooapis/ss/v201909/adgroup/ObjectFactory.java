
package jp.yahooapis.ss.v201909.adgroup;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;
import jp.yahooapis.ss.v201909.SoapHeader;
import jp.yahooapis.ss.v201909.SoapResponseHeader;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the jp.yahooapis.ss.v201909.adgroup package. 
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

    private final static QName _ResponseHeader_QNAME = new QName("http://ss.yahooapis.jp/V201909/AdGroup", "ResponseHeader");
    private final static QName _RequestHeader_QNAME = new QName("http://ss.yahooapis.jp/V201909/AdGroup", "RequestHeader");
    private final static QName _ApiExceptionFault_QNAME = new QName("http://ss.yahooapis.jp/V201909/AdGroup", "ApiExceptionFault");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: jp.yahooapis.ss.v201909.adgroup
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
     * Create an instance of {@link AdGroupOperation }
     * 
     */
    public AdGroupOperation createAdGroupOperation() {
        return new AdGroupOperation();
    }

    /**
     * Create an instance of {@link GetResponse }
     * 
     */
    public GetResponse createGetResponse() {
        return new GetResponse();
    }

    /**
     * Create an instance of {@link AdGroupPage }
     * 
     */
    public AdGroupPage createAdGroupPage() {
        return new AdGroupPage();
    }

    /**
     * Create an instance of {@link Get }
     * 
     */
    public Get createGet() {
        return new Get();
    }

    /**
     * Create an instance of {@link AdGroupSelector }
     * 
     */
    public AdGroupSelector createAdGroupSelector() {
        return new AdGroupSelector();
    }

    /**
     * Create an instance of {@link MutateResponse }
     * 
     */
    public MutateResponse createMutateResponse() {
        return new MutateResponse();
    }

    /**
     * Create an instance of {@link AdGroupReturnValue }
     * 
     */
    public AdGroupReturnValue createAdGroupReturnValue() {
        return new AdGroupReturnValue();
    }

    /**
     * Create an instance of {@link ReviewUrl }
     * 
     */
    public ReviewUrl createReviewUrl() {
        return new ReviewUrl();
    }

    /**
     * Create an instance of {@link Label }
     * 
     */
    public Label createLabel() {
        return new Label();
    }

    /**
     * Create an instance of {@link AdGroup }
     * 
     */
    public AdGroup createAdGroup() {
        return new AdGroup();
    }

    /**
     * Create an instance of {@link AdGroupAdRotationMode }
     * 
     */
    public AdGroupAdRotationMode createAdGroupAdRotationMode() {
        return new AdGroupAdRotationMode();
    }

    /**
     * Create an instance of {@link UrlReviewData }
     * 
     */
    public UrlReviewData createUrlReviewData() {
        return new UrlReviewData();
    }

    /**
     * Create an instance of {@link TargetingSetting }
     * 
     */
    public TargetingSetting createTargetingSetting() {
        return new TargetingSetting();
    }

    /**
     * Create an instance of {@link AdGroupValues }
     * 
     */
    public AdGroupValues createAdGroupValues() {
        return new AdGroupValues();
    }

    /**
     * Create an instance of {@link Bid }
     * 
     */
    public Bid createBid() {
        return new Bid();
    }

    /**
     * Create an instance of {@link CustomParameter }
     * 
     */
    public CustomParameter createCustomParameter() {
        return new CustomParameter();
    }

    /**
     * Create an instance of {@link CustomParameters }
     * 
     */
    public CustomParameters createCustomParameters() {
        return new CustomParameters();
    }

    /**
     * Create an instance of {@link AdGroupSettings }
     * 
     */
    public AdGroupSettings createAdGroupSettings() {
        return new AdGroupSettings();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SoapResponseHeader }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ss.yahooapis.jp/V201909/AdGroup", name = "ResponseHeader")
    public JAXBElement<SoapResponseHeader> createResponseHeader(SoapResponseHeader value) {
        return new JAXBElement<SoapResponseHeader>(_ResponseHeader_QNAME, SoapResponseHeader.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SoapHeader }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ss.yahooapis.jp/V201909/AdGroup", name = "RequestHeader")
    public JAXBElement<SoapHeader> createRequestHeader(SoapHeader value) {
        return new JAXBElement<SoapHeader>(_RequestHeader_QNAME, SoapHeader.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ss.yahooapis.jp/V201909/AdGroup", name = "ApiExceptionFault")
    public JAXBElement<String> createApiExceptionFault(String value) {
        return new JAXBElement<String>(_ApiExceptionFault_QNAME, String.class, null, value);
    }

}

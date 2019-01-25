
package jp.yahooapis.ss.v201901.adgroupad;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;
import jp.yahooapis.ss.v201901.SoapHeader;
import jp.yahooapis.ss.v201901.SoapResponseHeader;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the jp.yahooapis.ss.v201901.adgroupad package. 
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

    private final static QName _ApiExceptionFault_QNAME = new QName("http://ss.yahooapis.jp/V201901/AdGroupAd", "ApiExceptionFault");
    private final static QName _RequestHeader_QNAME = new QName("http://ss.yahooapis.jp/V201901/AdGroupAd", "RequestHeader");
    private final static QName _ResponseHeader_QNAME = new QName("http://ss.yahooapis.jp/V201901/AdGroupAd", "ResponseHeader");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: jp.yahooapis.ss.v201901.adgroupad
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
     * Create an instance of {@link AdGroupAdOperation }
     * 
     */
    public AdGroupAdOperation createAdGroupAdOperation() {
        return new AdGroupAdOperation();
    }

    /**
     * Create an instance of {@link GetResponse }
     * 
     */
    public GetResponse createGetResponse() {
        return new GetResponse();
    }

    /**
     * Create an instance of {@link AdGroupAdPage }
     * 
     */
    public AdGroupAdPage createAdGroupAdPage() {
        return new AdGroupAdPage();
    }

    /**
     * Create an instance of {@link Get }
     * 
     */
    public Get createGet() {
        return new Get();
    }

    /**
     * Create an instance of {@link AdGroupAdSelector }
     * 
     */
    public AdGroupAdSelector createAdGroupAdSelector() {
        return new AdGroupAdSelector();
    }

    /**
     * Create an instance of {@link MutateResponse }
     * 
     */
    public MutateResponse createMutateResponse() {
        return new MutateResponse();
    }

    /**
     * Create an instance of {@link AdGroupAdReturnValue }
     * 
     */
    public AdGroupAdReturnValue createAdGroupAdReturnValue() {
        return new AdGroupAdReturnValue();
    }

    /**
     * Create an instance of {@link DynamicSearchLinkedAd }
     * 
     */
    public DynamicSearchLinkedAd createDynamicSearchLinkedAd() {
        return new DynamicSearchLinkedAd();
    }

    /**
     * Create an instance of {@link Ad }
     * 
     */
    public Ad createAd() {
        return new Ad();
    }

    /**
     * Create an instance of {@link Label }
     * 
     */
    public Label createLabel() {
        return new Label();
    }

    /**
     * Create an instance of {@link AdGroupAdAdditionalAdvancedMobileUrls }
     * 
     */
    public AdGroupAdAdditionalAdvancedMobileUrls createAdGroupAdAdditionalAdvancedMobileUrls() {
        return new AdGroupAdAdditionalAdvancedMobileUrls();
    }

    /**
     * Create an instance of {@link AppAd }
     * 
     */
    public AppAd createAppAd() {
        return new AppAd();
    }

    /**
     * Create an instance of {@link AdGroupAdAdditionalAdvancedUrls }
     * 
     */
    public AdGroupAdAdditionalAdvancedUrls createAdGroupAdAdditionalAdvancedUrls() {
        return new AdGroupAdAdditionalAdvancedUrls();
    }

    /**
     * Create an instance of {@link TextAd2 }
     * 
     */
    public TextAd2 createTextAd2() {
        return new TextAd2();
    }

    /**
     * Create an instance of {@link CustomParameter }
     * 
     */
    public CustomParameter createCustomParameter() {
        return new CustomParameter();
    }

    /**
     * Create an instance of {@link AdGroupAdValues }
     * 
     */
    public AdGroupAdValues createAdGroupAdValues() {
        return new AdGroupAdValues();
    }

    /**
     * Create an instance of {@link CustomParameters }
     * 
     */
    public CustomParameters createCustomParameters() {
        return new CustomParameters();
    }

    /**
     * Create an instance of {@link ExtendedTextAd }
     * 
     */
    public ExtendedTextAd createExtendedTextAd() {
        return new ExtendedTextAd();
    }

    /**
     * Create an instance of {@link AdGroupAd }
     * 
     */
    public AdGroupAd createAdGroupAd() {
        return new AdGroupAd();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ss.yahooapis.jp/V201901/AdGroupAd", name = "ApiExceptionFault")
    public JAXBElement<String> createApiExceptionFault(String value) {
        return new JAXBElement<String>(_ApiExceptionFault_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SoapHeader }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ss.yahooapis.jp/V201901/AdGroupAd", name = "RequestHeader")
    public JAXBElement<SoapHeader> createRequestHeader(SoapHeader value) {
        return new JAXBElement<SoapHeader>(_RequestHeader_QNAME, SoapHeader.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SoapResponseHeader }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ss.yahooapis.jp/V201901/AdGroupAd", name = "ResponseHeader")
    public JAXBElement<SoapResponseHeader> createResponseHeader(SoapResponseHeader value) {
        return new JAXBElement<SoapResponseHeader>(_ResponseHeader_QNAME, SoapResponseHeader.class, null, value);
    }

}

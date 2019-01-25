
package jp.yahooapis.ss.v201901.targetingidea;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;
import jp.yahooapis.ss.v201901.SoapHeader;
import jp.yahooapis.ss.v201901.SoapResponseHeader;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the jp.yahooapis.ss.v201901.targetingidea package. 
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

    private final static QName _ResponseHeader_QNAME = new QName("http://ss.yahooapis.jp/V201901/TargetingIdea", "ResponseHeader");
    private final static QName _RequestHeader_QNAME = new QName("http://ss.yahooapis.jp/V201901/TargetingIdea", "RequestHeader");
    private final static QName _ApiExceptionFault_QNAME = new QName("http://ss.yahooapis.jp/V201901/TargetingIdea", "ApiExceptionFault");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: jp.yahooapis.ss.v201901.targetingidea
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GetResponse }
     * 
     */
    public GetResponse createGetResponse() {
        return new GetResponse();
    }

    /**
     * Create an instance of {@link TargetingIdeaPage }
     * 
     */
    public TargetingIdeaPage createTargetingIdeaPage() {
        return new TargetingIdeaPage();
    }

    /**
     * Create an instance of {@link Get }
     * 
     */
    public Get createGet() {
        return new Get();
    }

    /**
     * Create an instance of {@link TargetingIdeaSelector }
     * 
     */
    public TargetingIdeaSelector createTargetingIdeaSelector() {
        return new TargetingIdeaSelector();
    }

    /**
     * Create an instance of {@link KeywordAttribute }
     * 
     */
    public KeywordAttribute createKeywordAttribute() {
        return new KeywordAttribute();
    }

    /**
     * Create an instance of {@link RelatedToUrlSearchParameter }
     * 
     */
    public RelatedToUrlSearchParameter createRelatedToUrlSearchParameter() {
        return new RelatedToUrlSearchParameter();
    }

    /**
     * Create an instance of {@link ProposalKeyword }
     * 
     */
    public ProposalKeyword createProposalKeyword() {
        return new ProposalKeyword();
    }

    /**
     * Create an instance of {@link TypeAttributeMapEntry }
     * 
     */
    public TypeAttributeMapEntry createTypeAttributeMapEntry() {
        return new TypeAttributeMapEntry();
    }

    /**
     * Create an instance of {@link RelatedToKeywordSearchParameter }
     * 
     */
    public RelatedToKeywordSearchParameter createRelatedToKeywordSearchParameter() {
        return new RelatedToKeywordSearchParameter();
    }

    /**
     * Create an instance of {@link TargetingIdeaValues }
     * 
     */
    public TargetingIdeaValues createTargetingIdeaValues() {
        return new TargetingIdeaValues();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SoapResponseHeader }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ss.yahooapis.jp/V201901/TargetingIdea", name = "ResponseHeader")
    public JAXBElement<SoapResponseHeader> createResponseHeader(SoapResponseHeader value) {
        return new JAXBElement<SoapResponseHeader>(_ResponseHeader_QNAME, SoapResponseHeader.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SoapHeader }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ss.yahooapis.jp/V201901/TargetingIdea", name = "RequestHeader")
    public JAXBElement<SoapHeader> createRequestHeader(SoapHeader value) {
        return new JAXBElement<SoapHeader>(_RequestHeader_QNAME, SoapHeader.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ss.yahooapis.jp/V201901/TargetingIdea", name = "ApiExceptionFault")
    public JAXBElement<String> createApiExceptionFault(String value) {
        return new JAXBElement<String>(_ApiExceptionFault_QNAME, String.class, null, value);
    }

}


package jp.yahooapis.ss.v201901.feeditem;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;
import jp.yahooapis.ss.v201901.SoapHeader;
import jp.yahooapis.ss.v201901.SoapResponseHeader;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the jp.yahooapis.ss.v201901.feeditem package. 
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

    private final static QName _RequestHeader_QNAME = new QName("http://ss.yahooapis.jp/V201901/FeedItem", "RequestHeader");
    private final static QName _ApiExceptionFault_QNAME = new QName("http://ss.yahooapis.jp/V201901/FeedItem", "ApiExceptionFault");
    private final static QName _ResponseHeader_QNAME = new QName("http://ss.yahooapis.jp/V201901/FeedItem", "ResponseHeader");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: jp.yahooapis.ss.v201901.feeditem
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
     * Create an instance of {@link FeedItemOperation }
     * 
     */
    public FeedItemOperation createFeedItemOperation() {
        return new FeedItemOperation();
    }

    /**
     * Create an instance of {@link GetResponse }
     * 
     */
    public GetResponse createGetResponse() {
        return new GetResponse();
    }

    /**
     * Create an instance of {@link FeedItemPage }
     * 
     */
    public FeedItemPage createFeedItemPage() {
        return new FeedItemPage();
    }

    /**
     * Create an instance of {@link Get }
     * 
     */
    public Get createGet() {
        return new Get();
    }

    /**
     * Create an instance of {@link FeedItemSelector }
     * 
     */
    public FeedItemSelector createFeedItemSelector() {
        return new FeedItemSelector();
    }

    /**
     * Create an instance of {@link MutateResponse }
     * 
     */
    public MutateResponse createMutateResponse() {
        return new MutateResponse();
    }

    /**
     * Create an instance of {@link FeedItemReturnValue }
     * 
     */
    public FeedItemReturnValue createFeedItemReturnValue() {
        return new FeedItemReturnValue();
    }

    /**
     * Create an instance of {@link TargetingAdGroup }
     * 
     */
    public TargetingAdGroup createTargetingAdGroup() {
        return new TargetingAdGroup();
    }

    /**
     * Create an instance of {@link TargetingCampaign }
     * 
     */
    public TargetingCampaign createTargetingCampaign() {
        return new TargetingCampaign();
    }

    /**
     * Create an instance of {@link SimpleFeedItemAttribute }
     * 
     */
    public SimpleFeedItemAttribute createSimpleFeedItemAttribute() {
        return new SimpleFeedItemAttribute();
    }

    /**
     * Create an instance of {@link FeedAttributeValue }
     * 
     */
    public FeedAttributeValue createFeedAttributeValue() {
        return new FeedAttributeValue();
    }

    /**
     * Create an instance of {@link FeedItem }
     * 
     */
    public FeedItem createFeedItem() {
        return new FeedItem();
    }

    /**
     * Create an instance of {@link TargetingKeyword }
     * 
     */
    public TargetingKeyword createTargetingKeyword() {
        return new TargetingKeyword();
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
     * Create an instance of {@link FeedItemSchedule }
     * 
     */
    public FeedItemSchedule createFeedItemSchedule() {
        return new FeedItemSchedule();
    }

    /**
     * Create an instance of {@link FeedItemValues }
     * 
     */
    public FeedItemValues createFeedItemValues() {
        return new FeedItemValues();
    }

    /**
     * Create an instance of {@link FeedItemScheduling }
     * 
     */
    public FeedItemScheduling createFeedItemScheduling() {
        return new FeedItemScheduling();
    }

    /**
     * Create an instance of {@link MultipleFeedItemAttribute }
     * 
     */
    public MultipleFeedItemAttribute createMultipleFeedItemAttribute() {
        return new MultipleFeedItemAttribute();
    }

    /**
     * Create an instance of {@link Location }
     * 
     */
    public Location createLocation() {
        return new Location();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SoapHeader }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ss.yahooapis.jp/V201901/FeedItem", name = "RequestHeader")
    public JAXBElement<SoapHeader> createRequestHeader(SoapHeader value) {
        return new JAXBElement<SoapHeader>(_RequestHeader_QNAME, SoapHeader.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ss.yahooapis.jp/V201901/FeedItem", name = "ApiExceptionFault")
    public JAXBElement<String> createApiExceptionFault(String value) {
        return new JAXBElement<String>(_ApiExceptionFault_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SoapResponseHeader }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ss.yahooapis.jp/V201901/FeedItem", name = "ResponseHeader")
    public JAXBElement<SoapResponseHeader> createResponseHeader(SoapResponseHeader value) {
        return new JAXBElement<SoapResponseHeader>(_ResponseHeader_QNAME, SoapResponseHeader.class, null, value);
    }

}

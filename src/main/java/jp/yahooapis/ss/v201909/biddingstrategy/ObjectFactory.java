
package jp.yahooapis.ss.v201909.biddingstrategy;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;
import jp.yahooapis.ss.v201909.SoapHeader;
import jp.yahooapis.ss.v201909.SoapResponseHeader;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the jp.yahooapis.ss.v201909.biddingstrategy package. 
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

    private final static QName _RequestHeader_QNAME = new QName("http://ss.yahooapis.jp/V201909/BiddingStrategy", "RequestHeader");
    private final static QName _ApiExceptionFault_QNAME = new QName("http://ss.yahooapis.jp/V201909/BiddingStrategy", "ApiExceptionFault");
    private final static QName _ResponseHeader_QNAME = new QName("http://ss.yahooapis.jp/V201909/BiddingStrategy", "ResponseHeader");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: jp.yahooapis.ss.v201909.biddingstrategy
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
     * Create an instance of {@link BiddingStrategyOperation }
     * 
     */
    public BiddingStrategyOperation createBiddingStrategyOperation() {
        return new BiddingStrategyOperation();
    }

    /**
     * Create an instance of {@link GetResponse }
     * 
     */
    public GetResponse createGetResponse() {
        return new GetResponse();
    }

    /**
     * Create an instance of {@link BiddingStrategyPage }
     * 
     */
    public BiddingStrategyPage createBiddingStrategyPage() {
        return new BiddingStrategyPage();
    }

    /**
     * Create an instance of {@link Get }
     * 
     */
    public Get createGet() {
        return new Get();
    }

    /**
     * Create an instance of {@link BiddingStrategySelector }
     * 
     */
    public BiddingStrategySelector createBiddingStrategySelector() {
        return new BiddingStrategySelector();
    }

    /**
     * Create an instance of {@link MutateResponse }
     * 
     */
    public MutateResponse createMutateResponse() {
        return new MutateResponse();
    }

    /**
     * Create an instance of {@link BiddingStrategyReturnValue }
     * 
     */
    public BiddingStrategyReturnValue createBiddingStrategyReturnValue() {
        return new BiddingStrategyReturnValue();
    }

    /**
     * Create an instance of {@link BiddingStrategy }
     * 
     */
    public BiddingStrategy createBiddingStrategy() {
        return new BiddingStrategy();
    }

    /**
     * Create an instance of {@link TargetCpaBiddingScheme }
     * 
     */
    public TargetCpaBiddingScheme createTargetCpaBiddingScheme() {
        return new TargetCpaBiddingScheme();
    }

    /**
     * Create an instance of {@link TargetRoasBiddingScheme }
     * 
     */
    public TargetRoasBiddingScheme createTargetRoasBiddingScheme() {
        return new TargetRoasBiddingScheme();
    }

    /**
     * Create an instance of {@link BiddingStrategyValues }
     * 
     */
    public BiddingStrategyValues createBiddingStrategyValues() {
        return new BiddingStrategyValues();
    }

    /**
     * Create an instance of {@link TargetSpendBiddingScheme }
     * 
     */
    public TargetSpendBiddingScheme createTargetSpendBiddingScheme() {
        return new TargetSpendBiddingScheme();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SoapHeader }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ss.yahooapis.jp/V201909/BiddingStrategy", name = "RequestHeader")
    public JAXBElement<SoapHeader> createRequestHeader(SoapHeader value) {
        return new JAXBElement<SoapHeader>(_RequestHeader_QNAME, SoapHeader.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ss.yahooapis.jp/V201909/BiddingStrategy", name = "ApiExceptionFault")
    public JAXBElement<String> createApiExceptionFault(String value) {
        return new JAXBElement<String>(_ApiExceptionFault_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SoapResponseHeader }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ss.yahooapis.jp/V201909/BiddingStrategy", name = "ResponseHeader")
    public JAXBElement<SoapResponseHeader> createResponseHeader(SoapResponseHeader value) {
        return new JAXBElement<SoapResponseHeader>(_ResponseHeader_QNAME, SoapResponseHeader.class, null, value);
    }

}

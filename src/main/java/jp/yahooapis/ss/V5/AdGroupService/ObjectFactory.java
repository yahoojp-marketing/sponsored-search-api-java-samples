
package jp.yahooapis.ss.V5.AdGroupService;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the jp.yahooapis.ss.V5.AdGroupService package. 
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

    private final static QName _ResponseHeader_QNAME = new QName("http://ss.yahooapis.jp/V5", "ResponseHeader");
    private final static QName _ApiExceptionFault_QNAME = new QName("http://ss.yahooapis.jp/V5", "ApiExceptionFault");
    private final static QName _RequestHeader_QNAME = new QName("http://ss.yahooapis.jp/V5", "RequestHeader");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: jp.yahooapis.ss.V5.AdGroupService
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
     * Create an instance of {@link SoapResponseHeader }
     * 
     */
    public SoapResponseHeader createSoapResponseHeader() {
        return new SoapResponseHeader();
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
     * Create an instance of {@link Error }
     * 
     */
    public Error createError() {
        return new Error();
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
     * Create an instance of {@link SoapHeader }
     * 
     */
    public SoapHeader createSoapHeader() {
        return new SoapHeader();
    }

    /**
     * Create an instance of {@link BiddingStrategy }
     * 
     */
    public BiddingStrategy createBiddingStrategy() {
        return new BiddingStrategy();
    }

    /**
     * Create an instance of {@link AdGroup }
     * 
     */
    public AdGroup createAdGroup() {
        return new AdGroup();
    }

    /**
     * Create an instance of {@link TargetCpaBiddingScheme }
     * 
     */
    public TargetCpaBiddingScheme createTargetCpaBiddingScheme() {
        return new TargetCpaBiddingScheme();
    }

    /**
     * Create an instance of {@link ManualCpcBiddingScheme }
     * 
     */
    public ManualCpcBiddingScheme createManualCpcBiddingScheme() {
        return new ManualCpcBiddingScheme();
    }

    /**
     * Create an instance of {@link PageOnePromotedBiddingScheme }
     * 
     */
    public PageOnePromotedBiddingScheme createPageOnePromotedBiddingScheme() {
        return new PageOnePromotedBiddingScheme();
    }

    /**
     * Create an instance of {@link ErrorDetail }
     * 
     */
    public ErrorDetail createErrorDetail() {
        return new ErrorDetail();
    }

    /**
     * Create an instance of {@link BudgetOptimizerBiddingScheme }
     * 
     */
    public BudgetOptimizerBiddingScheme createBudgetOptimizerBiddingScheme() {
        return new BudgetOptimizerBiddingScheme();
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
     * Create an instance of {@link Paging }
     * 
     */
    public Paging createPaging() {
        return new Paging();
    }

    /**
     * Create an instance of {@link EnhancedCpcBiddingScheme }
     * 
     */
    public EnhancedCpcBiddingScheme createEnhancedCpcBiddingScheme() {
        return new EnhancedCpcBiddingScheme();
    }

    /**
     * Create an instance of {@link TargetRoasBiddingScheme }
     * 
     */
    public TargetRoasBiddingScheme createTargetRoasBiddingScheme() {
        return new TargetRoasBiddingScheme();
    }

    /**
     * Create an instance of {@link TargetSpendBiddingScheme }
     * 
     */
    public TargetSpendBiddingScheme createTargetSpendBiddingScheme() {
        return new TargetSpendBiddingScheme();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SoapResponseHeader }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ss.yahooapis.jp/V5", name = "ResponseHeader")
    public JAXBElement<SoapResponseHeader> createResponseHeader(SoapResponseHeader value) {
        return new JAXBElement<SoapResponseHeader>(_ResponseHeader_QNAME, SoapResponseHeader.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ss.yahooapis.jp/V5", name = "ApiExceptionFault")
    public JAXBElement<String> createApiExceptionFault(String value) {
        return new JAXBElement<String>(_ApiExceptionFault_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SoapHeader }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ss.yahooapis.jp/V5", name = "RequestHeader")
    public JAXBElement<SoapHeader> createRequestHeader(SoapHeader value) {
        return new JAXBElement<SoapHeader>(_RequestHeader_QNAME, SoapHeader.class, null, value);
    }

}

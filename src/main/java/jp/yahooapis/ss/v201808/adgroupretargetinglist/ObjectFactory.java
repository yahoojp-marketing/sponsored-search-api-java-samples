
package jp.yahooapis.ss.v201808.adgroupretargetinglist;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;
import jp.yahooapis.ss.v201808.SoapHeader;
import jp.yahooapis.ss.v201808.SoapResponseHeader;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the jp.yahooapis.ss.v201808.adgroupretargetinglist package. 
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

    private final static QName _ApiExceptionFault_QNAME = new QName("http://ss.yahooapis.jp/V201808/AdGroupRetargetingList", "ApiExceptionFault");
    private final static QName _RequestHeader_QNAME = new QName("http://ss.yahooapis.jp/V201808/AdGroupRetargetingList", "RequestHeader");
    private final static QName _ResponseHeader_QNAME = new QName("http://ss.yahooapis.jp/V201808/AdGroupRetargetingList", "ResponseHeader");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: jp.yahooapis.ss.v201808.adgroupretargetinglist
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
     * Create an instance of {@link AdGroupRetargetingListOperation }
     * 
     */
    public AdGroupRetargetingListOperation createAdGroupRetargetingListOperation() {
        return new AdGroupRetargetingListOperation();
    }

    /**
     * Create an instance of {@link GetResponse }
     * 
     */
    public GetResponse createGetResponse() {
        return new GetResponse();
    }

    /**
     * Create an instance of {@link AdGroupRetargetingListPage }
     * 
     */
    public AdGroupRetargetingListPage createAdGroupRetargetingListPage() {
        return new AdGroupRetargetingListPage();
    }

    /**
     * Create an instance of {@link Get }
     * 
     */
    public Get createGet() {
        return new Get();
    }

    /**
     * Create an instance of {@link AdGroupRetargetingListSelector }
     * 
     */
    public AdGroupRetargetingListSelector createAdGroupRetargetingListSelector() {
        return new AdGroupRetargetingListSelector();
    }

    /**
     * Create an instance of {@link MutateResponse }
     * 
     */
    public MutateResponse createMutateResponse() {
        return new MutateResponse();
    }

    /**
     * Create an instance of {@link AdGroupRetargetingListReturnValue }
     * 
     */
    public AdGroupRetargetingListReturnValue createAdGroupRetargetingListReturnValue() {
        return new AdGroupRetargetingListReturnValue();
    }

    /**
     * Create an instance of {@link CriterionTargetList }
     * 
     */
    public CriterionTargetList createCriterionTargetList() {
        return new CriterionTargetList();
    }

    /**
     * Create an instance of {@link AdGroupRetargetingListValues }
     * 
     */
    public AdGroupRetargetingListValues createAdGroupRetargetingListValues() {
        return new AdGroupRetargetingListValues();
    }

    /**
     * Create an instance of {@link AdGroupRetargetingList }
     * 
     */
    public AdGroupRetargetingList createAdGroupRetargetingList() {
        return new AdGroupRetargetingList();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ss.yahooapis.jp/V201808/AdGroupRetargetingList", name = "ApiExceptionFault")
    public JAXBElement<String> createApiExceptionFault(String value) {
        return new JAXBElement<String>(_ApiExceptionFault_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SoapHeader }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ss.yahooapis.jp/V201808/AdGroupRetargetingList", name = "RequestHeader")
    public JAXBElement<SoapHeader> createRequestHeader(SoapHeader value) {
        return new JAXBElement<SoapHeader>(_RequestHeader_QNAME, SoapHeader.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SoapResponseHeader }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ss.yahooapis.jp/V201808/AdGroupRetargetingList", name = "ResponseHeader")
    public JAXBElement<SoapResponseHeader> createResponseHeader(SoapResponseHeader value) {
        return new JAXBElement<SoapResponseHeader>(_ResponseHeader_QNAME, SoapResponseHeader.class, null, value);
    }

}

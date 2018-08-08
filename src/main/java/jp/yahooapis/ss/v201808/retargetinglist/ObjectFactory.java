
package jp.yahooapis.ss.v201808.retargetinglist;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;
import jp.yahooapis.ss.v201808.SoapHeader;
import jp.yahooapis.ss.v201808.SoapResponseHeader;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the jp.yahooapis.ss.v201808.retargetinglist package. 
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

    private final static QName _ResponseHeader_QNAME = new QName("http://ss.yahooapis.jp/V201808/RetargetingList", "ResponseHeader");
    private final static QName _RequestHeader_QNAME = new QName("http://ss.yahooapis.jp/V201808/RetargetingList", "RequestHeader");
    private final static QName _ApiExceptionFault_QNAME = new QName("http://ss.yahooapis.jp/V201808/RetargetingList", "ApiExceptionFault");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: jp.yahooapis.ss.v201808.retargetinglist
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
     * Create an instance of {@link RetargetingListOperation }
     * 
     */
    public RetargetingListOperation createRetargetingListOperation() {
        return new RetargetingListOperation();
    }

    /**
     * Create an instance of {@link GetResponse }
     * 
     */
    public GetResponse createGetResponse() {
        return new GetResponse();
    }

    /**
     * Create an instance of {@link RetargetingListPage }
     * 
     */
    public RetargetingListPage createRetargetingListPage() {
        return new RetargetingListPage();
    }

    /**
     * Create an instance of {@link Get }
     * 
     */
    public Get createGet() {
        return new Get();
    }

    /**
     * Create an instance of {@link RetargetingListSelector }
     * 
     */
    public RetargetingListSelector createRetargetingListSelector() {
        return new RetargetingListSelector();
    }

    /**
     * Create an instance of {@link MutateResponse }
     * 
     */
    public MutateResponse createMutateResponse() {
        return new MutateResponse();
    }

    /**
     * Create an instance of {@link RetargetingListReturnValue }
     * 
     */
    public RetargetingListReturnValue createRetargetingListReturnValue() {
        return new RetargetingListReturnValue();
    }

    /**
     * Create an instance of {@link UrlRuleItem }
     * 
     */
    public UrlRuleItem createUrlRuleItem() {
        return new UrlRuleItem();
    }

    /**
     * Create an instance of {@link RetargetingAccountStatus }
     * 
     */
    public RetargetingAccountStatus createRetargetingAccountStatus() {
        return new RetargetingAccountStatus();
    }

    /**
     * Create an instance of {@link RetargetingListValues }
     * 
     */
    public RetargetingListValues createRetargetingListValues() {
        return new RetargetingListValues();
    }

    /**
     * Create an instance of {@link RuleItem }
     * 
     */
    public RuleItem createRuleItem() {
        return new RuleItem();
    }

    /**
     * Create an instance of {@link RuleBaseTargetList }
     * 
     */
    public RuleBaseTargetList createRuleBaseTargetList() {
        return new RuleBaseTargetList();
    }

    /**
     * Create an instance of {@link TargetingList }
     * 
     */
    public TargetingList createTargetingList() {
        return new TargetingList();
    }

    /**
     * Create an instance of {@link LogicalGroup }
     * 
     */
    public LogicalGroup createLogicalGroup() {
        return new LogicalGroup();
    }

    /**
     * Create an instance of {@link LogicalTargetList }
     * 
     */
    public LogicalTargetList createLogicalTargetList() {
        return new LogicalTargetList();
    }

    /**
     * Create an instance of {@link RuleGroup }
     * 
     */
    public RuleGroup createRuleGroup() {
        return new RuleGroup();
    }

    /**
     * Create an instance of {@link DefaultTargetList }
     * 
     */
    public DefaultTargetList createDefaultTargetList() {
        return new DefaultTargetList();
    }

    /**
     * Create an instance of {@link Tag }
     * 
     */
    public Tag createTag() {
        return new Tag();
    }

    /**
     * Create an instance of {@link LogicalRuleOperand }
     * 
     */
    public LogicalRuleOperand createLogicalRuleOperand() {
        return new LogicalRuleOperand();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SoapResponseHeader }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ss.yahooapis.jp/V201808/RetargetingList", name = "ResponseHeader")
    public JAXBElement<SoapResponseHeader> createResponseHeader(SoapResponseHeader value) {
        return new JAXBElement<SoapResponseHeader>(_ResponseHeader_QNAME, SoapResponseHeader.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SoapHeader }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ss.yahooapis.jp/V201808/RetargetingList", name = "RequestHeader")
    public JAXBElement<SoapHeader> createRequestHeader(SoapHeader value) {
        return new JAXBElement<SoapHeader>(_RequestHeader_QNAME, SoapHeader.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ss.yahooapis.jp/V201808/RetargetingList", name = "ApiExceptionFault")
    public JAXBElement<String> createApiExceptionFault(String value) {
        return new JAXBElement<String>(_ApiExceptionFault_QNAME, String.class, null, value);
    }

}


package jp.yahooapis.ss.v201909.reportdefinition;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;
import jp.yahooapis.ss.v201909.SoapHeader;
import jp.yahooapis.ss.v201909.SoapResponseHeader;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the jp.yahooapis.ss.v201909.reportdefinition package. 
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

    private final static QName _ResponseHeader_QNAME = new QName("http://ss.yahooapis.jp/V201909/ReportDefinition", "ResponseHeader");
    private final static QName _RequestHeader_QNAME = new QName("http://ss.yahooapis.jp/V201909/ReportDefinition", "RequestHeader");
    private final static QName _ApiExceptionFault_QNAME = new QName("http://ss.yahooapis.jp/V201909/ReportDefinition", "ApiExceptionFault");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: jp.yahooapis.ss.v201909.reportdefinition
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GetReportFieldsResponse }
     * 
     */
    public GetReportFieldsResponse createGetReportFieldsResponse() {
        return new GetReportFieldsResponse();
    }

    /**
     * Create an instance of {@link ReportDefinitionFieldValue }
     * 
     */
    public ReportDefinitionFieldValue createReportDefinitionFieldValue() {
        return new ReportDefinitionFieldValue();
    }

    /**
     * Create an instance of {@link Mutate }
     * 
     */
    public Mutate createMutate() {
        return new Mutate();
    }

    /**
     * Create an instance of {@link ReportDefinitionOperation }
     * 
     */
    public ReportDefinitionOperation createReportDefinitionOperation() {
        return new ReportDefinitionOperation();
    }

    /**
     * Create an instance of {@link GetResponse }
     * 
     */
    public GetResponse createGetResponse() {
        return new GetResponse();
    }

    /**
     * Create an instance of {@link ReportDefinitionPage }
     * 
     */
    public ReportDefinitionPage createReportDefinitionPage() {
        return new ReportDefinitionPage();
    }

    /**
     * Create an instance of {@link Get }
     * 
     */
    public Get createGet() {
        return new Get();
    }

    /**
     * Create an instance of {@link ReportDefinitionSelector }
     * 
     */
    public ReportDefinitionSelector createReportDefinitionSelector() {
        return new ReportDefinitionSelector();
    }

    /**
     * Create an instance of {@link MutateResponse }
     * 
     */
    public MutateResponse createMutateResponse() {
        return new MutateResponse();
    }

    /**
     * Create an instance of {@link ReportDefinitionReturnValue }
     * 
     */
    public ReportDefinitionReturnValue createReportDefinitionReturnValue() {
        return new ReportDefinitionReturnValue();
    }

    /**
     * Create an instance of {@link GetReportFields }
     * 
     */
    public GetReportFields createGetReportFields() {
        return new GetReportFields();
    }

    /**
     * Create an instance of {@link ReportDefinitionValues }
     * 
     */
    public ReportDefinitionValues createReportDefinitionValues() {
        return new ReportDefinitionValues();
    }

    /**
     * Create an instance of {@link ReportDateRange }
     * 
     */
    public ReportDateRange createReportDateRange() {
        return new ReportDateRange();
    }

    /**
     * Create an instance of {@link ReportFilter }
     * 
     */
    public ReportFilter createReportFilter() {
        return new ReportFilter();
    }

    /**
     * Create an instance of {@link ReportFieldAttribute }
     * 
     */
    public ReportFieldAttribute createReportFieldAttribute() {
        return new ReportFieldAttribute();
    }

    /**
     * Create an instance of {@link ReportDefinition }
     * 
     */
    public ReportDefinition createReportDefinition() {
        return new ReportDefinition();
    }

    /**
     * Create an instance of {@link ReportSortField }
     * 
     */
    public ReportSortField createReportSortField() {
        return new ReportSortField();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SoapResponseHeader }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ss.yahooapis.jp/V201909/ReportDefinition", name = "ResponseHeader")
    public JAXBElement<SoapResponseHeader> createResponseHeader(SoapResponseHeader value) {
        return new JAXBElement<SoapResponseHeader>(_ResponseHeader_QNAME, SoapResponseHeader.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SoapHeader }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ss.yahooapis.jp/V201909/ReportDefinition", name = "RequestHeader")
    public JAXBElement<SoapHeader> createRequestHeader(SoapHeader value) {
        return new JAXBElement<SoapHeader>(_RequestHeader_QNAME, SoapHeader.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ss.yahooapis.jp/V201909/ReportDefinition", name = "ApiExceptionFault")
    public JAXBElement<String> createApiExceptionFault(String value) {
        return new JAXBElement<String>(_ApiExceptionFault_QNAME, String.class, null, value);
    }

}

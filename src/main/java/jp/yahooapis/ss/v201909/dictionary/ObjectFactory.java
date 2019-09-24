
package jp.yahooapis.ss.v201909.dictionary;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;
import jp.yahooapis.ss.v201909.SoapHeader;
import jp.yahooapis.ss.v201909.SoapResponseHeader;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the jp.yahooapis.ss.v201909.dictionary package. 
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

    private final static QName _ApiExceptionFault_QNAME = new QName("http://ss.yahooapis.jp/V201909/Dictionary", "ApiExceptionFault");
    private final static QName _RequestHeader_QNAME = new QName("http://ss.yahooapis.jp/V201909/Dictionary", "RequestHeader");
    private final static QName _ResponseHeader_QNAME = new QName("http://ss.yahooapis.jp/V201909/Dictionary", "ResponseHeader");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: jp.yahooapis.ss.v201909.dictionary
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GetDisapprovalReasonResponse }
     * 
     */
    public GetDisapprovalReasonResponse createGetDisapprovalReasonResponse() {
        return new GetDisapprovalReasonResponse();
    }

    /**
     * Create an instance of {@link DisapprovalReasonPage }
     * 
     */
    public DisapprovalReasonPage createDisapprovalReasonPage() {
        return new DisapprovalReasonPage();
    }

    /**
     * Create an instance of {@link GetGeographicLocation }
     * 
     */
    public GetGeographicLocation createGetGeographicLocation() {
        return new GetGeographicLocation();
    }

    /**
     * Create an instance of {@link GeographicLocationSelector }
     * 
     */
    public GeographicLocationSelector createGeographicLocationSelector() {
        return new GeographicLocationSelector();
    }

    /**
     * Create an instance of {@link GetGeographicLocationResponse }
     * 
     */
    public GetGeographicLocationResponse createGetGeographicLocationResponse() {
        return new GetGeographicLocationResponse();
    }

    /**
     * Create an instance of {@link GeographicLocationPage }
     * 
     */
    public GeographicLocationPage createGeographicLocationPage() {
        return new GeographicLocationPage();
    }

    /**
     * Create an instance of {@link GetDisapprovalReason }
     * 
     */
    public GetDisapprovalReason createGetDisapprovalReason() {
        return new GetDisapprovalReason();
    }

    /**
     * Create an instance of {@link DisapprovalReasonSelector }
     * 
     */
    public DisapprovalReasonSelector createDisapprovalReasonSelector() {
        return new DisapprovalReasonSelector();
    }

    /**
     * Create an instance of {@link DisapprovalReason }
     * 
     */
    public DisapprovalReason createDisapprovalReason() {
        return new DisapprovalReason();
    }

    /**
     * Create an instance of {@link DisapprovalReasonValues }
     * 
     */
    public DisapprovalReasonValues createDisapprovalReasonValues() {
        return new DisapprovalReasonValues();
    }

    /**
     * Create an instance of {@link GeographicLocation }
     * 
     */
    public GeographicLocation createGeographicLocation() {
        return new GeographicLocation();
    }

    /**
     * Create an instance of {@link GeographicLocationValues }
     * 
     */
    public GeographicLocationValues createGeographicLocationValues() {
        return new GeographicLocationValues();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ss.yahooapis.jp/V201909/Dictionary", name = "ApiExceptionFault")
    public JAXBElement<String> createApiExceptionFault(String value) {
        return new JAXBElement<String>(_ApiExceptionFault_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SoapHeader }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ss.yahooapis.jp/V201909/Dictionary", name = "RequestHeader")
    public JAXBElement<SoapHeader> createRequestHeader(SoapHeader value) {
        return new JAXBElement<SoapHeader>(_RequestHeader_QNAME, SoapHeader.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SoapResponseHeader }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ss.yahooapis.jp/V201909/Dictionary", name = "ResponseHeader")
    public JAXBElement<SoapResponseHeader> createResponseHeader(SoapResponseHeader value) {
        return new JAXBElement<SoapResponseHeader>(_ResponseHeader_QNAME, SoapResponseHeader.class, null, value);
    }

}

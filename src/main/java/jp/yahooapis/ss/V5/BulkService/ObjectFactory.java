
package jp.yahooapis.ss.V5.BulkService;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the jp.yahooapis.ss.V5.BulkService package. 
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
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: jp.yahooapis.ss.V5.BulkService
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GetUploadUrl }
     * 
     */
    public GetUploadUrl createGetUploadUrl() {
        return new GetUploadUrl();
    }

    /**
     * Create an instance of {@link SoapResponseHeader }
     * 
     */
    public SoapResponseHeader createSoapResponseHeader() {
        return new SoapResponseHeader();
    }

    /**
     * Create an instance of {@link GetBulkDownload }
     * 
     */
    public GetBulkDownload createGetBulkDownload() {
        return new GetBulkDownload();
    }

    /**
     * Create an instance of {@link BulkDownloadSelector }
     * 
     */
    public BulkDownloadSelector createBulkDownloadSelector() {
        return new BulkDownloadSelector();
    }

    /**
     * Create an instance of {@link GetBulkDownloadStatus }
     * 
     */
    public GetBulkDownloadStatus createGetBulkDownloadStatus() {
        return new GetBulkDownloadStatus();
    }

    /**
     * Create an instance of {@link BulkDownloadStatusSelector }
     * 
     */
    public BulkDownloadStatusSelector createBulkDownloadStatusSelector() {
        return new BulkDownloadStatusSelector();
    }

    /**
     * Create an instance of {@link GetBulkDownloadStatusResponse }
     * 
     */
    public GetBulkDownloadStatusResponse createGetBulkDownloadStatusResponse() {
        return new GetBulkDownloadStatusResponse();
    }

    /**
     * Create an instance of {@link BulkDownloadStatusPage }
     * 
     */
    public BulkDownloadStatusPage createBulkDownloadStatusPage() {
        return new BulkDownloadStatusPage();
    }

    /**
     * Create an instance of {@link Error }
     * 
     */
    public Error createError() {
        return new Error();
    }

    /**
     * Create an instance of {@link GetUploadUrlResponse }
     * 
     */
    public GetUploadUrlResponse createGetUploadUrlResponse() {
        return new GetUploadUrlResponse();
    }

    /**
     * Create an instance of {@link UploadUrlValue }
     * 
     */
    public UploadUrlValue createUploadUrlValue() {
        return new UploadUrlValue();
    }

    /**
     * Create an instance of {@link GetBulkUploadStatusResponse }
     * 
     */
    public GetBulkUploadStatusResponse createGetBulkUploadStatusResponse() {
        return new GetBulkUploadStatusResponse();
    }

    /**
     * Create an instance of {@link BulkUploadStatusPage }
     * 
     */
    public BulkUploadStatusPage createBulkUploadStatusPage() {
        return new BulkUploadStatusPage();
    }

    /**
     * Create an instance of {@link SoapHeader }
     * 
     */
    public SoapHeader createSoapHeader() {
        return new SoapHeader();
    }

    /**
     * Create an instance of {@link GetBulkUploadStatus }
     * 
     */
    public GetBulkUploadStatus createGetBulkUploadStatus() {
        return new GetBulkUploadStatus();
    }

    /**
     * Create an instance of {@link BulkUploadStatusSelector }
     * 
     */
    public BulkUploadStatusSelector createBulkUploadStatusSelector() {
        return new BulkUploadStatusSelector();
    }

    /**
     * Create an instance of {@link GetBulkDownloadResponse }
     * 
     */
    public GetBulkDownloadResponse createGetBulkDownloadResponse() {
        return new GetBulkDownloadResponse();
    }

    /**
     * Create an instance of {@link BulkDownloadReturnValue }
     * 
     */
    public BulkDownloadReturnValue createBulkDownloadReturnValue() {
        return new BulkDownloadReturnValue();
    }

    /**
     * Create an instance of {@link DownloadBulkJob }
     * 
     */
    public DownloadBulkJob createDownloadBulkJob() {
        return new DownloadBulkJob();
    }

    /**
     * Create an instance of {@link ErrorDetail }
     * 
     */
    public ErrorDetail createErrorDetail() {
        return new ErrorDetail();
    }

    /**
     * Create an instance of {@link BulkDownloadValues }
     * 
     */
    public BulkDownloadValues createBulkDownloadValues() {
        return new BulkDownloadValues();
    }

    /**
     * Create an instance of {@link BulkUploadValues }
     * 
     */
    public BulkUploadValues createBulkUploadValues() {
        return new BulkUploadValues();
    }

    /**
     * Create an instance of {@link Paging }
     * 
     */
    public Paging createPaging() {
        return new Paging();
    }

    /**
     * Create an instance of {@link ProcessingItemsCount }
     * 
     */
    public ProcessingItemsCount createProcessingItemsCount() {
        return new ProcessingItemsCount();
    }

    /**
     * Create an instance of {@link UploadBulkJob }
     * 
     */
    public UploadBulkJob createUploadBulkJob() {
        return new UploadBulkJob();
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

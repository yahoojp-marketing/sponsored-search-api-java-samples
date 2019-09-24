
package jp.yahooapis.ss.v201909.pagefeeditem;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;
import jp.yahooapis.ss.v201909.SoapHeader;
import jp.yahooapis.ss.v201909.SoapResponseHeader;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the jp.yahooapis.ss.v201909.pagefeeditem package. 
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

    private final static QName _ResponseHeader_QNAME = new QName("http://ss.yahooapis.jp/V201909/PageFeedItem", "ResponseHeader");
    private final static QName _ApiExceptionFault_QNAME = new QName("http://ss.yahooapis.jp/V201909/PageFeedItem", "ApiExceptionFault");
    private final static QName _RequestHeader_QNAME = new QName("http://ss.yahooapis.jp/V201909/PageFeedItem", "RequestHeader");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: jp.yahooapis.ss.v201909.pagefeeditem
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link AddDownloadJob }
     * 
     */
    public AddDownloadJob createAddDownloadJob() {
        return new AddDownloadJob();
    }

    /**
     * Create an instance of {@link PageFeedItemDownloadJobOperation }
     * 
     */
    public PageFeedItemDownloadJobOperation createPageFeedItemDownloadJobOperation() {
        return new PageFeedItemDownloadJobOperation();
    }

    /**
     * Create an instance of {@link GetJobStatus }
     * 
     */
    public GetJobStatus createGetJobStatus() {
        return new GetJobStatus();
    }

    /**
     * Create an instance of {@link PageFeedItemJobStatusSelector }
     * 
     */
    public PageFeedItemJobStatusSelector createPageFeedItemJobStatusSelector() {
        return new PageFeedItemJobStatusSelector();
    }

    /**
     * Create an instance of {@link GetResponse }
     * 
     */
    public GetResponse createGetResponse() {
        return new GetResponse();
    }

    /**
     * Create an instance of {@link PageFeedItemPage }
     * 
     */
    public PageFeedItemPage createPageFeedItemPage() {
        return new PageFeedItemPage();
    }

    /**
     * Create an instance of {@link GetUploadUrl }
     * 
     */
    public GetUploadUrl createGetUploadUrl() {
        return new GetUploadUrl();
    }

    /**
     * Create an instance of {@link PageFeedItemUploadUrlOperation }
     * 
     */
    public PageFeedItemUploadUrlOperation createPageFeedItemUploadUrlOperation() {
        return new PageFeedItemUploadUrlOperation();
    }

    /**
     * Create an instance of {@link GetReviewSummaryResponse }
     * 
     */
    public GetReviewSummaryResponse createGetReviewSummaryResponse() {
        return new GetReviewSummaryResponse();
    }

    /**
     * Create an instance of {@link PageFeedItemReviewSummaryPage }
     * 
     */
    public PageFeedItemReviewSummaryPage createPageFeedItemReviewSummaryPage() {
        return new PageFeedItemReviewSummaryPage();
    }

    /**
     * Create an instance of {@link AddDownloadJobResponse }
     * 
     */
    public AddDownloadJobResponse createAddDownloadJobResponse() {
        return new AddDownloadJobResponse();
    }

    /**
     * Create an instance of {@link PageFeedItemDownloadJobReturnValue }
     * 
     */
    public PageFeedItemDownloadJobReturnValue createPageFeedItemDownloadJobReturnValue() {
        return new PageFeedItemDownloadJobReturnValue();
    }

    /**
     * Create an instance of {@link Get }
     * 
     */
    public Get createGet() {
        return new Get();
    }

    /**
     * Create an instance of {@link PageFeedItemSelector }
     * 
     */
    public PageFeedItemSelector createPageFeedItemSelector() {
        return new PageFeedItemSelector();
    }

    /**
     * Create an instance of {@link GetUploadUrlResponse }
     * 
     */
    public GetUploadUrlResponse createGetUploadUrlResponse() {
        return new GetUploadUrlResponse();
    }

    /**
     * Create an instance of {@link PageFeedItemUploadUrlPage }
     * 
     */
    public PageFeedItemUploadUrlPage createPageFeedItemUploadUrlPage() {
        return new PageFeedItemUploadUrlPage();
    }

    /**
     * Create an instance of {@link GetJobStatusResponse }
     * 
     */
    public GetJobStatusResponse createGetJobStatusResponse() {
        return new GetJobStatusResponse();
    }

    /**
     * Create an instance of {@link PageFeedItemJobStatusPage }
     * 
     */
    public PageFeedItemJobStatusPage createPageFeedItemJobStatusPage() {
        return new PageFeedItemJobStatusPage();
    }

    /**
     * Create an instance of {@link GetReviewSummary }
     * 
     */
    public GetReviewSummary createGetReviewSummary() {
        return new GetReviewSummary();
    }

    /**
     * Create an instance of {@link PageFeedItemReviewSummarySelector }
     * 
     */
    public PageFeedItemReviewSummarySelector createPageFeedItemReviewSummarySelector() {
        return new PageFeedItemReviewSummarySelector();
    }

    /**
     * Create an instance of {@link PageFeedItemDownloadJobValues }
     * 
     */
    public PageFeedItemDownloadJobValues createPageFeedItemDownloadJobValues() {
        return new PageFeedItemDownloadJobValues();
    }

    /**
     * Create an instance of {@link PageFeedItemDownloadJob }
     * 
     */
    public PageFeedItemDownloadJob createPageFeedItemDownloadJob() {
        return new PageFeedItemDownloadJob();
    }

    /**
     * Create an instance of {@link PageFeedItemReviewSummaryValues }
     * 
     */
    public PageFeedItemReviewSummaryValues createPageFeedItemReviewSummaryValues() {
        return new PageFeedItemReviewSummaryValues();
    }

    /**
     * Create an instance of {@link PageFeedItemJobValues }
     * 
     */
    public PageFeedItemJobValues createPageFeedItemJobValues() {
        return new PageFeedItemJobValues();
    }

    /**
     * Create an instance of {@link PageFeedItemUploadJob }
     * 
     */
    public PageFeedItemUploadJob createPageFeedItemUploadJob() {
        return new PageFeedItemUploadJob();
    }

    /**
     * Create an instance of {@link PageFeedItemUploadUrlValues }
     * 
     */
    public PageFeedItemUploadUrlValues createPageFeedItemUploadUrlValues() {
        return new PageFeedItemUploadUrlValues();
    }

    /**
     * Create an instance of {@link PageFeedUrl }
     * 
     */
    public PageFeedUrl createPageFeedUrl() {
        return new PageFeedUrl();
    }

    /**
     * Create an instance of {@link PageFeedItemUploadUrl }
     * 
     */
    public PageFeedItemUploadUrl createPageFeedItemUploadUrl() {
        return new PageFeedItemUploadUrl();
    }

    /**
     * Create an instance of {@link PageFeedItem }
     * 
     */
    public PageFeedItem createPageFeedItem() {
        return new PageFeedItem();
    }

    /**
     * Create an instance of {@link PageFeedItemReviewSummary }
     * 
     */
    public PageFeedItemReviewSummary createPageFeedItemReviewSummary() {
        return new PageFeedItemReviewSummary();
    }

    /**
     * Create an instance of {@link PageFeedItemReturnValues }
     * 
     */
    public PageFeedItemReturnValues createPageFeedItemReturnValues() {
        return new PageFeedItemReturnValues();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SoapResponseHeader }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ss.yahooapis.jp/V201909/PageFeedItem", name = "ResponseHeader")
    public JAXBElement<SoapResponseHeader> createResponseHeader(SoapResponseHeader value) {
        return new JAXBElement<SoapResponseHeader>(_ResponseHeader_QNAME, SoapResponseHeader.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ss.yahooapis.jp/V201909/PageFeedItem", name = "ApiExceptionFault")
    public JAXBElement<String> createApiExceptionFault(String value) {
        return new JAXBElement<String>(_ApiExceptionFault_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SoapHeader }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ss.yahooapis.jp/V201909/PageFeedItem", name = "RequestHeader")
    public JAXBElement<SoapHeader> createRequestHeader(SoapHeader value) {
        return new JAXBElement<SoapHeader>(_RequestHeader_QNAME, SoapHeader.class, null, value);
    }

}

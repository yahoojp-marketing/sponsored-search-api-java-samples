
package jp.yahooapis.ss.v201901.pagefeeditem;

import java.util.List;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.Holder;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;
import jp.yahooapis.ss.v201901.Error;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.9-b130926.1035
 * Generated source version: 2.2
 * 
 */
@WebService(name = "PageFeedItemServiceInterface", targetNamespace = "http://ss.yahooapis.jp/V201901/PageFeedItem")
@XmlSeeAlso({
    jp.yahooapis.ss.v201901.ObjectFactory.class,
    jp.yahooapis.ss.v201901.pagefeeditem.ObjectFactory.class
})
public interface PageFeedItemServiceInterface {


    /**
     * 
     * @param operations
     * @param rval
     * @param error
     * @throws ApiException
     */
    @WebMethod
    @RequestWrapper(localName = "addDownloadJob", targetNamespace = "http://ss.yahooapis.jp/V201901/PageFeedItem", className = "jp.yahooapis.ss.v201901.pagefeeditem.AddDownloadJob")
    @ResponseWrapper(localName = "addDownloadJobResponse", targetNamespace = "http://ss.yahooapis.jp/V201901/PageFeedItem", className = "jp.yahooapis.ss.v201901.pagefeeditem.AddDownloadJobResponse")
    public void addDownloadJob(
        @WebParam(name = "operations", targetNamespace = "http://ss.yahooapis.jp/V201901/PageFeedItem")
        PageFeedItemDownloadJobOperation operations,
        @WebParam(name = "rval", targetNamespace = "http://ss.yahooapis.jp/V201901/PageFeedItem", mode = WebParam.Mode.OUT)
        Holder<PageFeedItemDownloadJobReturnValue> rval,
        @WebParam(name = "error", targetNamespace = "http://ss.yahooapis.jp/V201901/PageFeedItem", mode = WebParam.Mode.OUT)
        Holder<List<Error>> error)
        throws ApiException
    ;

    /**
     * 
     * @param selector
     * @param rval
     * @param error
     * @throws ApiException
     */
    @WebMethod
    @RequestWrapper(localName = "getJobStatus", targetNamespace = "http://ss.yahooapis.jp/V201901/PageFeedItem", className = "jp.yahooapis.ss.v201901.pagefeeditem.GetJobStatus")
    @ResponseWrapper(localName = "getJobStatusResponse", targetNamespace = "http://ss.yahooapis.jp/V201901/PageFeedItem", className = "jp.yahooapis.ss.v201901.pagefeeditem.GetJobStatusResponse")
    public void getJobStatus(
        @WebParam(name = "selector", targetNamespace = "http://ss.yahooapis.jp/V201901/PageFeedItem")
        PageFeedItemJobStatusSelector selector,
        @WebParam(name = "rval", targetNamespace = "http://ss.yahooapis.jp/V201901/PageFeedItem", mode = WebParam.Mode.OUT)
        Holder<PageFeedItemJobStatusPage> rval,
        @WebParam(name = "error", targetNamespace = "http://ss.yahooapis.jp/V201901/PageFeedItem", mode = WebParam.Mode.OUT)
        Holder<List<Error>> error)
        throws ApiException
    ;

    /**
     * 
     * @param operations
     * @param rval
     * @param error
     * @throws ApiException
     */
    @WebMethod
    @RequestWrapper(localName = "getUploadUrl", targetNamespace = "http://ss.yahooapis.jp/V201901/PageFeedItem", className = "jp.yahooapis.ss.v201901.pagefeeditem.GetUploadUrl")
    @ResponseWrapper(localName = "getUploadUrlResponse", targetNamespace = "http://ss.yahooapis.jp/V201901/PageFeedItem", className = "jp.yahooapis.ss.v201901.pagefeeditem.GetUploadUrlResponse")
    public void getUploadUrl(
        @WebParam(name = "operations", targetNamespace = "http://ss.yahooapis.jp/V201901/PageFeedItem")
        PageFeedItemUploadUrlOperation operations,
        @WebParam(name = "rval", targetNamespace = "http://ss.yahooapis.jp/V201901/PageFeedItem", mode = WebParam.Mode.OUT)
        Holder<PageFeedItemUploadUrlPage> rval,
        @WebParam(name = "error", targetNamespace = "http://ss.yahooapis.jp/V201901/PageFeedItem", mode = WebParam.Mode.OUT)
        Holder<List<Error>> error)
        throws ApiException
    ;

    /**
     * 
     * @param selector
     * @param rval
     * @param error
     * @throws ApiException
     */
    @WebMethod
    @RequestWrapper(localName = "getReviewSummary", targetNamespace = "http://ss.yahooapis.jp/V201901/PageFeedItem", className = "jp.yahooapis.ss.v201901.pagefeeditem.GetReviewSummary")
    @ResponseWrapper(localName = "getReviewSummaryResponse", targetNamespace = "http://ss.yahooapis.jp/V201901/PageFeedItem", className = "jp.yahooapis.ss.v201901.pagefeeditem.GetReviewSummaryResponse")
    public void getReviewSummary(
        @WebParam(name = "selector", targetNamespace = "http://ss.yahooapis.jp/V201901/PageFeedItem")
        PageFeedItemReviewSummarySelector selector,
        @WebParam(name = "rval", targetNamespace = "http://ss.yahooapis.jp/V201901/PageFeedItem", mode = WebParam.Mode.OUT)
        Holder<PageFeedItemReviewSummaryPage> rval,
        @WebParam(name = "error", targetNamespace = "http://ss.yahooapis.jp/V201901/PageFeedItem", mode = WebParam.Mode.OUT)
        Holder<List<Error>> error)
        throws ApiException
    ;

    /**
     * 
     * @param selector
     * @param rval
     * @param error
     * @throws ApiException
     */
    @WebMethod
    @RequestWrapper(localName = "get", targetNamespace = "http://ss.yahooapis.jp/V201901/PageFeedItem", className = "jp.yahooapis.ss.v201901.pagefeeditem.Get")
    @ResponseWrapper(localName = "getResponse", targetNamespace = "http://ss.yahooapis.jp/V201901/PageFeedItem", className = "jp.yahooapis.ss.v201901.pagefeeditem.GetResponse")
    public void get(
        @WebParam(name = "selector", targetNamespace = "http://ss.yahooapis.jp/V201901/PageFeedItem")
        PageFeedItemSelector selector,
        @WebParam(name = "rval", targetNamespace = "http://ss.yahooapis.jp/V201901/PageFeedItem", mode = WebParam.Mode.OUT)
        Holder<PageFeedItemPage> rval,
        @WebParam(name = "error", targetNamespace = "http://ss.yahooapis.jp/V201901/PageFeedItem", mode = WebParam.Mode.OUT)
        Holder<List<Error>> error)
        throws ApiException
    ;

}

package jp.yahooapis.ss.v201808.campaignexport;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;
import jp.yahooapis.ss.v201808.SoapHeader;
import jp.yahooapis.ss.v201808.SoapResponseHeader;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the jp.yahooapis.ss.v201808.campaignexport package. 
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

    private final static QName _ResponseHeader_QNAME = new QName("http://ss.yahooapis.jp/V201808/CampaignExport", "ResponseHeader");
    private final static QName _RequestHeader_QNAME = new QName("http://ss.yahooapis.jp/V201808/CampaignExport", "RequestHeader");
    private final static QName _ApiExceptionFault_QNAME = new QName("http://ss.yahooapis.jp/V201808/CampaignExport", "ApiExceptionFault");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: jp.yahooapis.ss.v201808.campaignexport
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GetResponse }
     * 
     */
    public GetResponse createGetResponse() {
        return new GetResponse();
    }

    /**
     * Create an instance of {@link CampaignExportPage }
     * 
     */
    public CampaignExportPage createCampaignExportPage() {
        return new CampaignExportPage();
    }

    /**
     * Create an instance of {@link GetExportFieldsResponse }
     * 
     */
    public GetExportFieldsResponse createGetExportFieldsResponse() {
        return new GetExportFieldsResponse();
    }

    /**
     * Create an instance of {@link CampaignExportFieldValue }
     * 
     */
    public CampaignExportFieldValue createCampaignExportFieldValue() {
        return new CampaignExportFieldValue();
    }

    /**
     * Create an instance of {@link Get }
     * 
     */
    public Get createGet() {
        return new Get();
    }

    /**
     * Create an instance of {@link JobSelector }
     * 
     */
    public JobSelector createJobSelector() {
        return new JobSelector();
    }

    /**
     * Create an instance of {@link AddJob }
     * 
     */
    public AddJob createAddJob() {
        return new AddJob();
    }

    /**
     * Create an instance of {@link ExportSetting }
     * 
     */
    public ExportSetting createExportSetting() {
        return new ExportSetting();
    }

    /**
     * Create an instance of {@link AddJobResponse }
     * 
     */
    public AddJobResponse createAddJobResponse() {
        return new AddJobResponse();
    }

    /**
     * Create an instance of {@link CampaignExportReturnValue }
     * 
     */
    public CampaignExportReturnValue createCampaignExportReturnValue() {
        return new CampaignExportReturnValue();
    }

    /**
     * Create an instance of {@link GetExportFields }
     * 
     */
    public GetExportFields createGetExportFields() {
        return new GetExportFields();
    }

    /**
     * Create an instance of {@link CampaignExportFieldAttribute }
     * 
     */
    public CampaignExportFieldAttribute createCampaignExportFieldAttribute() {
        return new CampaignExportFieldAttribute();
    }

    /**
     * Create an instance of {@link CampaignExportValues }
     * 
     */
    public CampaignExportValues createCampaignExportValues() {
        return new CampaignExportValues();
    }

    /**
     * Create an instance of {@link Job }
     * 
     */
    public Job createJob() {
        return new Job();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SoapResponseHeader }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ss.yahooapis.jp/V201808/CampaignExport", name = "ResponseHeader")
    public JAXBElement<SoapResponseHeader> createResponseHeader(SoapResponseHeader value) {
        return new JAXBElement<SoapResponseHeader>(_ResponseHeader_QNAME, SoapResponseHeader.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SoapHeader }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ss.yahooapis.jp/V201808/CampaignExport", name = "RequestHeader")
    public JAXBElement<SoapHeader> createRequestHeader(SoapHeader value) {
        return new JAXBElement<SoapHeader>(_RequestHeader_QNAME, SoapHeader.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ss.yahooapis.jp/V201808/CampaignExport", name = "ApiExceptionFault")
    public JAXBElement<String> createApiExceptionFault(String value) {
        return new JAXBElement<String>(_ApiExceptionFault_QNAME, String.class, null, value);
    }

}

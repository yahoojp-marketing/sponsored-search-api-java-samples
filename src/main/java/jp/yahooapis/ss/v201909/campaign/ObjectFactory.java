
package jp.yahooapis.ss.v201909.campaign;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;
import jp.yahooapis.ss.v201909.SoapHeader;
import jp.yahooapis.ss.v201909.SoapResponseHeader;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the jp.yahooapis.ss.v201909.campaign package. 
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

    private final static QName _RequestHeader_QNAME = new QName("http://ss.yahooapis.jp/V201909/Campaign", "RequestHeader");
    private final static QName _ApiExceptionFault_QNAME = new QName("http://ss.yahooapis.jp/V201909/Campaign", "ApiExceptionFault");
    private final static QName _ResponseHeader_QNAME = new QName("http://ss.yahooapis.jp/V201909/Campaign", "ResponseHeader");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: jp.yahooapis.ss.v201909.campaign
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
     * Create an instance of {@link CampaignOperation }
     * 
     */
    public CampaignOperation createCampaignOperation() {
        return new CampaignOperation();
    }

    /**
     * Create an instance of {@link GetResponse }
     * 
     */
    public GetResponse createGetResponse() {
        return new GetResponse();
    }

    /**
     * Create an instance of {@link CampaignPage }
     * 
     */
    public CampaignPage createCampaignPage() {
        return new CampaignPage();
    }

    /**
     * Create an instance of {@link Get }
     * 
     */
    public Get createGet() {
        return new Get();
    }

    /**
     * Create an instance of {@link CampaignSelector }
     * 
     */
    public CampaignSelector createCampaignSelector() {
        return new CampaignSelector();
    }

    /**
     * Create an instance of {@link MutateResponse }
     * 
     */
    public MutateResponse createMutateResponse() {
        return new MutateResponse();
    }

    /**
     * Create an instance of {@link CampaignReturnValue }
     * 
     */
    public CampaignReturnValue createCampaignReturnValue() {
        return new CampaignReturnValue();
    }

    /**
     * Create an instance of {@link ReviewUrl }
     * 
     */
    public ReviewUrl createReviewUrl() {
        return new ReviewUrl();
    }

    /**
     * Create an instance of {@link MaximizeConversionsBiddingScheme }
     * 
     */
    public MaximizeConversionsBiddingScheme createMaximizeConversionsBiddingScheme() {
        return new MaximizeConversionsBiddingScheme();
    }

    /**
     * Create an instance of {@link Label }
     * 
     */
    public Label createLabel() {
        return new Label();
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
     * Create an instance of {@link UrlReviewData }
     * 
     */
    public UrlReviewData createUrlReviewData() {
        return new UrlReviewData();
    }

    /**
     * Create an instance of {@link CampaignBiddingStrategy }
     * 
     */
    public CampaignBiddingStrategy createCampaignBiddingStrategy() {
        return new CampaignBiddingStrategy();
    }

    /**
     * Create an instance of {@link TargetingSetting }
     * 
     */
    public TargetingSetting createTargetingSetting() {
        return new TargetingSetting();
    }

    /**
     * Create an instance of {@link Budget }
     * 
     */
    public Budget createBudget() {
        return new Budget();
    }

    /**
     * Create an instance of {@link CustomParameter }
     * 
     */
    public CustomParameter createCustomParameter() {
        return new CustomParameter();
    }

    /**
     * Create an instance of {@link CustomParameters }
     * 
     */
    public CustomParameters createCustomParameters() {
        return new CustomParameters();
    }

    /**
     * Create an instance of {@link DynamicAdsForSearchSetting }
     * 
     */
    public DynamicAdsForSearchSetting createDynamicAdsForSearchSetting() {
        return new DynamicAdsForSearchSetting();
    }

    /**
     * Create an instance of {@link GeoTargetTypeSetting }
     * 
     */
    public GeoTargetTypeSetting createGeoTargetTypeSetting() {
        return new GeoTargetTypeSetting();
    }

    /**
     * Create an instance of {@link CampaignValues }
     * 
     */
    public CampaignValues createCampaignValues() {
        return new CampaignValues();
    }

    /**
     * Create an instance of {@link TargetRoasBiddingScheme }
     * 
     */
    public TargetRoasBiddingScheme createTargetRoasBiddingScheme() {
        return new TargetRoasBiddingScheme();
    }

    /**
     * Create an instance of {@link Campaign }
     * 
     */
    public Campaign createCampaign() {
        return new Campaign();
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
    @XmlElementDecl(namespace = "http://ss.yahooapis.jp/V201909/Campaign", name = "RequestHeader")
    public JAXBElement<SoapHeader> createRequestHeader(SoapHeader value) {
        return new JAXBElement<SoapHeader>(_RequestHeader_QNAME, SoapHeader.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ss.yahooapis.jp/V201909/Campaign", name = "ApiExceptionFault")
    public JAXBElement<String> createApiExceptionFault(String value) {
        return new JAXBElement<String>(_ApiExceptionFault_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SoapResponseHeader }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ss.yahooapis.jp/V201909/Campaign", name = "ResponseHeader")
    public JAXBElement<SoapResponseHeader> createResponseHeader(SoapResponseHeader value) {
        return new JAXBElement<SoapResponseHeader>(_ResponseHeader_QNAME, SoapResponseHeader.class, null, value);
    }

}

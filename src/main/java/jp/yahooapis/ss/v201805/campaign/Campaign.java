
package jp.yahooapis.ss.v201805.campaign;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for Campaign complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Campaign">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="accountId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="campaignId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="campaignTrackId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="campaignName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="userStatus" type="{http://ss.yahooapis.jp/V201805/Campaign}UserStatus" minOccurs="0"/>
 *         &lt;element name="servingStatus" type="{http://ss.yahooapis.jp/V201805/Campaign}CampaignServingStatus" minOccurs="0"/>
 *         &lt;element name="startDate" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="endDate" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="budget" type="{http://ss.yahooapis.jp/V201805/Campaign}Budget" minOccurs="0"/>
 *         &lt;element name="biddingStrategyConfiguration" type="{http://ss.yahooapis.jp/V201805/Campaign}CampaignBiddingStrategy" minOccurs="0"/>
 *         &lt;element name="biddingStrategyFailedReason" type="{http://ss.yahooapis.jp/V201805/Campaign}BiddingStrategyFailedReason" minOccurs="0"/>
 *         &lt;element name="failedBiddingStrategyConfiguration" type="{http://ss.yahooapis.jp/V201805/Campaign}CampaignBiddingStrategy" minOccurs="0"/>
 *         &lt;element name="conversionOptimizerEligibility" type="{http://ss.yahooapis.jp/V201805/Campaign}ConversionOptimizerEligibility" minOccurs="0"/>
 *         &lt;element name="adServingOptimizationStatus" type="{http://ss.yahooapis.jp/V201805/Campaign}AdServingOptimizationStatus" minOccurs="0"/>
 *         &lt;element name="settings" type="{http://ss.yahooapis.jp/V201805/Campaign}CampaignSettings" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="campaignType" type="{http://ss.yahooapis.jp/V201805/Campaign}CampaignType" minOccurs="0"/>
 *         &lt;element name="appStore" type="{http://ss.yahooapis.jp/V201805/Campaign}AppStore" minOccurs="0"/>
 *         &lt;element name="appId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="trackingUrl" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="customParameters" type="{http://ss.yahooapis.jp/V201805/Campaign}CustomParameters" minOccurs="0"/>
 *         &lt;element name="urlReviewData" type="{http://ss.yahooapis.jp/V201805/Campaign}UrlReviewData" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Campaign", propOrder = {
    "accountId",
    "campaignId",
    "campaignTrackId",
    "campaignName",
    "userStatus",
    "servingStatus",
    "startDate",
    "endDate",
    "budget",
    "biddingStrategyConfiguration",
    "biddingStrategyFailedReason",
    "failedBiddingStrategyConfiguration",
    "conversionOptimizerEligibility",
    "adServingOptimizationStatus",
    "settings",
    "campaignType",
    "appStore",
    "appId",
    "trackingUrl",
    "customParameters",
    "urlReviewData"
})
public class Campaign {

    protected Long accountId;
    protected Long campaignId;
    protected Long campaignTrackId;
    protected String campaignName;
    @XmlSchemaType(name = "string")
    protected UserStatus userStatus;
    @XmlSchemaType(name = "string")
    protected CampaignServingStatus servingStatus;
    protected String startDate;
    protected String endDate;
    protected Budget budget;
    protected CampaignBiddingStrategy biddingStrategyConfiguration;
    @XmlSchemaType(name = "string")
    protected BiddingStrategyFailedReason biddingStrategyFailedReason;
    protected CampaignBiddingStrategy failedBiddingStrategyConfiguration;
    @XmlSchemaType(name = "string")
    protected ConversionOptimizerEligibility conversionOptimizerEligibility;
    @XmlSchemaType(name = "string")
    protected AdServingOptimizationStatus adServingOptimizationStatus;
    protected List<CampaignSettings> settings;
    @XmlSchemaType(name = "string")
    protected CampaignType campaignType;
    @XmlSchemaType(name = "string")
    protected AppStore appStore;
    protected String appId;
    protected String trackingUrl;
    protected CustomParameters customParameters;
    protected UrlReviewData urlReviewData;

    /**
     * Gets the value of the accountId property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getAccountId() {
        return accountId;
    }

    /**
     * Sets the value of the accountId property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setAccountId(Long value) {
        this.accountId = value;
    }

    /**
     * Gets the value of the campaignId property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getCampaignId() {
        return campaignId;
    }

    /**
     * Sets the value of the campaignId property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setCampaignId(Long value) {
        this.campaignId = value;
    }

    /**
     * Gets the value of the campaignTrackId property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getCampaignTrackId() {
        return campaignTrackId;
    }

    /**
     * Sets the value of the campaignTrackId property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setCampaignTrackId(Long value) {
        this.campaignTrackId = value;
    }

    /**
     * Gets the value of the campaignName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCampaignName() {
        return campaignName;
    }

    /**
     * Sets the value of the campaignName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCampaignName(String value) {
        this.campaignName = value;
    }

    /**
     * Gets the value of the userStatus property.
     * 
     * @return
     *     possible object is
     *     {@link UserStatus }
     *     
     */
    public UserStatus getUserStatus() {
        return userStatus;
    }

    /**
     * Sets the value of the userStatus property.
     * 
     * @param value
     *     allowed object is
     *     {@link UserStatus }
     *     
     */
    public void setUserStatus(UserStatus value) {
        this.userStatus = value;
    }

    /**
     * Gets the value of the servingStatus property.
     * 
     * @return
     *     possible object is
     *     {@link CampaignServingStatus }
     *     
     */
    public CampaignServingStatus getServingStatus() {
        return servingStatus;
    }

    /**
     * Sets the value of the servingStatus property.
     * 
     * @param value
     *     allowed object is
     *     {@link CampaignServingStatus }
     *     
     */
    public void setServingStatus(CampaignServingStatus value) {
        this.servingStatus = value;
    }

    /**
     * Gets the value of the startDate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStartDate() {
        return startDate;
    }

    /**
     * Sets the value of the startDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStartDate(String value) {
        this.startDate = value;
    }

    /**
     * Gets the value of the endDate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEndDate() {
        return endDate;
    }

    /**
     * Sets the value of the endDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEndDate(String value) {
        this.endDate = value;
    }

    /**
     * Gets the value of the budget property.
     * 
     * @return
     *     possible object is
     *     {@link Budget }
     *     
     */
    public Budget getBudget() {
        return budget;
    }

    /**
     * Sets the value of the budget property.
     * 
     * @param value
     *     allowed object is
     *     {@link Budget }
     *     
     */
    public void setBudget(Budget value) {
        this.budget = value;
    }

    /**
     * Gets the value of the biddingStrategyConfiguration property.
     * 
     * @return
     *     possible object is
     *     {@link CampaignBiddingStrategy }
     *     
     */
    public CampaignBiddingStrategy getBiddingStrategyConfiguration() {
        return biddingStrategyConfiguration;
    }

    /**
     * Sets the value of the biddingStrategyConfiguration property.
     * 
     * @param value
     *     allowed object is
     *     {@link CampaignBiddingStrategy }
     *     
     */
    public void setBiddingStrategyConfiguration(CampaignBiddingStrategy value) {
        this.biddingStrategyConfiguration = value;
    }

    /**
     * Gets the value of the biddingStrategyFailedReason property.
     * 
     * @return
     *     possible object is
     *     {@link BiddingStrategyFailedReason }
     *     
     */
    public BiddingStrategyFailedReason getBiddingStrategyFailedReason() {
        return biddingStrategyFailedReason;
    }

    /**
     * Sets the value of the biddingStrategyFailedReason property.
     * 
     * @param value
     *     allowed object is
     *     {@link BiddingStrategyFailedReason }
     *     
     */
    public void setBiddingStrategyFailedReason(BiddingStrategyFailedReason value) {
        this.biddingStrategyFailedReason = value;
    }

    /**
     * Gets the value of the failedBiddingStrategyConfiguration property.
     * 
     * @return
     *     possible object is
     *     {@link CampaignBiddingStrategy }
     *     
     */
    public CampaignBiddingStrategy getFailedBiddingStrategyConfiguration() {
        return failedBiddingStrategyConfiguration;
    }

    /**
     * Sets the value of the failedBiddingStrategyConfiguration property.
     * 
     * @param value
     *     allowed object is
     *     {@link CampaignBiddingStrategy }
     *     
     */
    public void setFailedBiddingStrategyConfiguration(CampaignBiddingStrategy value) {
        this.failedBiddingStrategyConfiguration = value;
    }

    /**
     * Gets the value of the conversionOptimizerEligibility property.
     * 
     * @return
     *     possible object is
     *     {@link ConversionOptimizerEligibility }
     *     
     */
    public ConversionOptimizerEligibility getConversionOptimizerEligibility() {
        return conversionOptimizerEligibility;
    }

    /**
     * Sets the value of the conversionOptimizerEligibility property.
     * 
     * @param value
     *     allowed object is
     *     {@link ConversionOptimizerEligibility }
     *     
     */
    public void setConversionOptimizerEligibility(ConversionOptimizerEligibility value) {
        this.conversionOptimizerEligibility = value;
    }

    /**
     * Gets the value of the adServingOptimizationStatus property.
     * 
     * @return
     *     possible object is
     *     {@link AdServingOptimizationStatus }
     *     
     */
    public AdServingOptimizationStatus getAdServingOptimizationStatus() {
        return adServingOptimizationStatus;
    }

    /**
     * Sets the value of the adServingOptimizationStatus property.
     * 
     * @param value
     *     allowed object is
     *     {@link AdServingOptimizationStatus }
     *     
     */
    public void setAdServingOptimizationStatus(AdServingOptimizationStatus value) {
        this.adServingOptimizationStatus = value;
    }

    /**
     * Gets the value of the settings property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the settings property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSettings().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link CampaignSettings }
     * 
     * 
     */
    public List<CampaignSettings> getSettings() {
        if (settings == null) {
            settings = new ArrayList<CampaignSettings>();
        }
        return this.settings;
    }

    /**
     * Gets the value of the campaignType property.
     * 
     * @return
     *     possible object is
     *     {@link CampaignType }
     *     
     */
    public CampaignType getCampaignType() {
        return campaignType;
    }

    /**
     * Sets the value of the campaignType property.
     * 
     * @param value
     *     allowed object is
     *     {@link CampaignType }
     *     
     */
    public void setCampaignType(CampaignType value) {
        this.campaignType = value;
    }

    /**
     * Gets the value of the appStore property.
     * 
     * @return
     *     possible object is
     *     {@link AppStore }
     *     
     */
    public AppStore getAppStore() {
        return appStore;
    }

    /**
     * Sets the value of the appStore property.
     * 
     * @param value
     *     allowed object is
     *     {@link AppStore }
     *     
     */
    public void setAppStore(AppStore value) {
        this.appStore = value;
    }

    /**
     * Gets the value of the appId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAppId() {
        return appId;
    }

    /**
     * Sets the value of the appId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAppId(String value) {
        this.appId = value;
    }

    /**
     * Gets the value of the trackingUrl property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTrackingUrl() {
        return trackingUrl;
    }

    /**
     * Sets the value of the trackingUrl property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTrackingUrl(String value) {
        this.trackingUrl = value;
    }

    /**
     * Gets the value of the customParameters property.
     * 
     * @return
     *     possible object is
     *     {@link CustomParameters }
     *     
     */
    public CustomParameters getCustomParameters() {
        return customParameters;
    }

    /**
     * Sets the value of the customParameters property.
     * 
     * @param value
     *     allowed object is
     *     {@link CustomParameters }
     *     
     */
    public void setCustomParameters(CustomParameters value) {
        this.customParameters = value;
    }

    /**
     * Gets the value of the urlReviewData property.
     * 
     * @return
     *     possible object is
     *     {@link UrlReviewData }
     *     
     */
    public UrlReviewData getUrlReviewData() {
        return urlReviewData;
    }

    /**
     * Sets the value of the urlReviewData property.
     * 
     * @param value
     *     allowed object is
     *     {@link UrlReviewData }
     *     
     */
    public void setUrlReviewData(UrlReviewData value) {
        this.urlReviewData = value;
    }

}

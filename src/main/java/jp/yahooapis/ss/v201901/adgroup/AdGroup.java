
package jp.yahooapis.ss.v201901.adgroup;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for AdGroup complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="AdGroup">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="accountId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="campaignId" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="campaignTrackId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="campaignName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="adGroupId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="adGroupTrackId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="adGroupName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="userStatus" type="{http://ss.yahooapis.jp/V201901/AdGroup}UserStatus" minOccurs="0"/>
 *         &lt;element name="bid" type="{http://ss.yahooapis.jp/V201901/AdGroup}Bid" minOccurs="0"/>
 *         &lt;element name="settings" type="{http://ss.yahooapis.jp/V201901/AdGroup}AdGroupSettings" minOccurs="0"/>
 *         &lt;element name="trackingUrl" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="customParameters" type="{http://ss.yahooapis.jp/V201901/AdGroup}CustomParameters" minOccurs="0"/>
 *         &lt;element name="urlReviewData" type="{http://ss.yahooapis.jp/V201901/AdGroup}UrlReviewData" minOccurs="0"/>
 *         &lt;element name="adGroupAdRotationMode" type="{http://ss.yahooapis.jp/V201901/AdGroup}AdGroupAdRotationMode" minOccurs="0"/>
 *         &lt;element name="labels" type="{http://ss.yahooapis.jp/V201901/AdGroup}Label" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AdGroup", propOrder = {
    "accountId",
    "campaignId",
    "campaignTrackId",
    "campaignName",
    "adGroupId",
    "adGroupTrackId",
    "adGroupName",
    "userStatus",
    "bid",
    "settings",
    "trackingUrl",
    "customParameters",
    "urlReviewData",
    "adGroupAdRotationMode",
    "labels"
})
public class AdGroup {

    protected Long accountId;
    protected long campaignId;
    protected Long campaignTrackId;
    protected String campaignName;
    protected Long adGroupId;
    protected Long adGroupTrackId;
    protected String adGroupName;
    @XmlSchemaType(name = "string")
    protected UserStatus userStatus;
    protected Bid bid;
    protected AdGroupSettings settings;
    protected String trackingUrl;
    protected CustomParameters customParameters;
    protected UrlReviewData urlReviewData;
    protected AdGroupAdRotationMode adGroupAdRotationMode;
    protected List<Label> labels;

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
     */
    public long getCampaignId() {
        return campaignId;
    }

    /**
     * Sets the value of the campaignId property.
     * 
     */
    public void setCampaignId(long value) {
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
     * Gets the value of the adGroupId property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getAdGroupId() {
        return adGroupId;
    }

    /**
     * Sets the value of the adGroupId property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setAdGroupId(Long value) {
        this.adGroupId = value;
    }

    /**
     * Gets the value of the adGroupTrackId property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getAdGroupTrackId() {
        return adGroupTrackId;
    }

    /**
     * Sets the value of the adGroupTrackId property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setAdGroupTrackId(Long value) {
        this.adGroupTrackId = value;
    }

    /**
     * Gets the value of the adGroupName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAdGroupName() {
        return adGroupName;
    }

    /**
     * Sets the value of the adGroupName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAdGroupName(String value) {
        this.adGroupName = value;
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
     * Gets the value of the bid property.
     * 
     * @return
     *     possible object is
     *     {@link Bid }
     *     
     */
    public Bid getBid() {
        return bid;
    }

    /**
     * Sets the value of the bid property.
     * 
     * @param value
     *     allowed object is
     *     {@link Bid }
     *     
     */
    public void setBid(Bid value) {
        this.bid = value;
    }

    /**
     * Gets the value of the settings property.
     * 
     * @return
     *     possible object is
     *     {@link AdGroupSettings }
     *     
     */
    public AdGroupSettings getSettings() {
        return settings;
    }

    /**
     * Sets the value of the settings property.
     * 
     * @param value
     *     allowed object is
     *     {@link AdGroupSettings }
     *     
     */
    public void setSettings(AdGroupSettings value) {
        this.settings = value;
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

    /**
     * Gets the value of the adGroupAdRotationMode property.
     * 
     * @return
     *     possible object is
     *     {@link AdGroupAdRotationMode }
     *     
     */
    public AdGroupAdRotationMode getAdGroupAdRotationMode() {
        return adGroupAdRotationMode;
    }

    /**
     * Sets the value of the adGroupAdRotationMode property.
     * 
     * @param value
     *     allowed object is
     *     {@link AdGroupAdRotationMode }
     *     
     */
    public void setAdGroupAdRotationMode(AdGroupAdRotationMode value) {
        this.adGroupAdRotationMode = value;
    }

    /**
     * Gets the value of the labels property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the labels property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getLabels().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Label }
     * 
     * 
     */
    public List<Label> getLabels() {
        if (labels == null) {
            labels = new ArrayList<Label>();
        }
        return this.labels;
    }

}

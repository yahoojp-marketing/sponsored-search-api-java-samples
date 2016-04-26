
package jp.yahooapis.ss.V6.FeedItemService;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for FeedItem complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="FeedItem">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="accountId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="feedFolderId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="feedItemId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="feedItemTrackId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="approvalStatus" type="{http://ss.yahooapis.jp/V6}ApprovalStatus" minOccurs="0"/>
 *         &lt;element name="disapprovalReasonCodes" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="feedItemAttribute" type="{http://ss.yahooapis.jp/V6}FeedItemAttribute" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="placeholderType" type="{http://ss.yahooapis.jp/V6}PlaceholderType" minOccurs="0"/>
 *         &lt;element name="devicePreference" type="{http://ss.yahooapis.jp/V6}DevicePreference" minOccurs="0"/>
 *         &lt;element name="startDate" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="endDate" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="scheduling" type="{http://ss.yahooapis.jp/V6}FeedItemScheduling" minOccurs="0"/>
 *         &lt;element name="targetingCampaign" type="{http://ss.yahooapis.jp/V6}TargetingCampaign" minOccurs="0"/>
 *         &lt;element name="targetingAdGroup" type="{http://ss.yahooapis.jp/V6}TargetingAdGroup" minOccurs="0"/>
 *         &lt;element name="targetingKeyword" type="{http://ss.yahooapis.jp/V6}TargetingKeyword" minOccurs="0"/>
 *         &lt;element name="customParameters" type="{http://ss.yahooapis.jp/V6}CustomParameters" minOccurs="0"/>
 *         &lt;element name="reviewCustomParameters" type="{http://ss.yahooapis.jp/V6}CustomParameters" minOccurs="0"/>
 *         &lt;element name="advanced" type="{http://ss.yahooapis.jp/V6}Advanced" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "FeedItem", propOrder = {
    "accountId",
    "feedFolderId",
    "feedItemId",
    "feedItemTrackId",
    "approvalStatus",
    "disapprovalReasonCodes",
    "feedItemAttribute",
    "placeholderType",
    "devicePreference",
    "startDate",
    "endDate",
    "scheduling",
    "targetingCampaign",
    "targetingAdGroup",
    "targetingKeyword",
    "customParameters",
    "reviewCustomParameters",
    "advanced"
})
public class FeedItem {

    protected Long accountId;
    protected Long feedFolderId;
    protected Long feedItemId;
    protected Long feedItemTrackId;
    @XmlSchemaType(name = "string")
    protected ApprovalStatus approvalStatus;
    protected List<String> disapprovalReasonCodes;
    protected List<FeedItemAttribute> feedItemAttribute;
    @XmlSchemaType(name = "string")
    protected PlaceholderType placeholderType;
    @XmlSchemaType(name = "string")
    protected DevicePreference devicePreference;
    protected String startDate;
    protected String endDate;
    protected FeedItemScheduling scheduling;
    protected TargetingCampaign targetingCampaign;
    protected TargetingAdGroup targetingAdGroup;
    protected TargetingKeyword targetingKeyword;
    protected CustomParameters customParameters;
    protected CustomParameters reviewCustomParameters;
    @XmlSchemaType(name = "string")
    protected Advanced advanced;

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
     * Gets the value of the feedFolderId property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getFeedFolderId() {
        return feedFolderId;
    }

    /**
     * Sets the value of the feedFolderId property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setFeedFolderId(Long value) {
        this.feedFolderId = value;
    }

    /**
     * Gets the value of the feedItemId property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getFeedItemId() {
        return feedItemId;
    }

    /**
     * Sets the value of the feedItemId property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setFeedItemId(Long value) {
        this.feedItemId = value;
    }

    /**
     * Gets the value of the feedItemTrackId property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getFeedItemTrackId() {
        return feedItemTrackId;
    }

    /**
     * Sets the value of the feedItemTrackId property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setFeedItemTrackId(Long value) {
        this.feedItemTrackId = value;
    }

    /**
     * Gets the value of the approvalStatus property.
     * 
     * @return
     *     possible object is
     *     {@link ApprovalStatus }
     *     
     */
    public ApprovalStatus getApprovalStatus() {
        return approvalStatus;
    }

    /**
     * Sets the value of the approvalStatus property.
     * 
     * @param value
     *     allowed object is
     *     {@link ApprovalStatus }
     *     
     */
    public void setApprovalStatus(ApprovalStatus value) {
        this.approvalStatus = value;
    }

    /**
     * Gets the value of the disapprovalReasonCodes property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the disapprovalReasonCodes property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getDisapprovalReasonCodes().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getDisapprovalReasonCodes() {
        if (disapprovalReasonCodes == null) {
            disapprovalReasonCodes = new ArrayList<String>();
        }
        return this.disapprovalReasonCodes;
    }

    /**
     * Gets the value of the feedItemAttribute property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the feedItemAttribute property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getFeedItemAttribute().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link FeedItemAttribute }
     * 
     * 
     */
    public List<FeedItemAttribute> getFeedItemAttribute() {
        if (feedItemAttribute == null) {
            feedItemAttribute = new ArrayList<FeedItemAttribute>();
        }
        return this.feedItemAttribute;
    }

    /**
     * Gets the value of the placeholderType property.
     * 
     * @return
     *     possible object is
     *     {@link PlaceholderType }
     *     
     */
    public PlaceholderType getPlaceholderType() {
        return placeholderType;
    }

    /**
     * Sets the value of the placeholderType property.
     * 
     * @param value
     *     allowed object is
     *     {@link PlaceholderType }
     *     
     */
    public void setPlaceholderType(PlaceholderType value) {
        this.placeholderType = value;
    }

    /**
     * Gets the value of the devicePreference property.
     * 
     * @return
     *     possible object is
     *     {@link DevicePreference }
     *     
     */
    public DevicePreference getDevicePreference() {
        return devicePreference;
    }

    /**
     * Sets the value of the devicePreference property.
     * 
     * @param value
     *     allowed object is
     *     {@link DevicePreference }
     *     
     */
    public void setDevicePreference(DevicePreference value) {
        this.devicePreference = value;
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
     * Gets the value of the scheduling property.
     * 
     * @return
     *     possible object is
     *     {@link FeedItemScheduling }
     *     
     */
    public FeedItemScheduling getScheduling() {
        return scheduling;
    }

    /**
     * Sets the value of the scheduling property.
     * 
     * @param value
     *     allowed object is
     *     {@link FeedItemScheduling }
     *     
     */
    public void setScheduling(FeedItemScheduling value) {
        this.scheduling = value;
    }

    /**
     * Gets the value of the targetingCampaign property.
     * 
     * @return
     *     possible object is
     *     {@link TargetingCampaign }
     *     
     */
    public TargetingCampaign getTargetingCampaign() {
        return targetingCampaign;
    }

    /**
     * Sets the value of the targetingCampaign property.
     * 
     * @param value
     *     allowed object is
     *     {@link TargetingCampaign }
     *     
     */
    public void setTargetingCampaign(TargetingCampaign value) {
        this.targetingCampaign = value;
    }

    /**
     * Gets the value of the targetingAdGroup property.
     * 
     * @return
     *     possible object is
     *     {@link TargetingAdGroup }
     *     
     */
    public TargetingAdGroup getTargetingAdGroup() {
        return targetingAdGroup;
    }

    /**
     * Sets the value of the targetingAdGroup property.
     * 
     * @param value
     *     allowed object is
     *     {@link TargetingAdGroup }
     *     
     */
    public void setTargetingAdGroup(TargetingAdGroup value) {
        this.targetingAdGroup = value;
    }

    /**
     * Gets the value of the targetingKeyword property.
     * 
     * @return
     *     possible object is
     *     {@link TargetingKeyword }
     *     
     */
    public TargetingKeyword getTargetingKeyword() {
        return targetingKeyword;
    }

    /**
     * Sets the value of the targetingKeyword property.
     * 
     * @param value
     *     allowed object is
     *     {@link TargetingKeyword }
     *     
     */
    public void setTargetingKeyword(TargetingKeyword value) {
        this.targetingKeyword = value;
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
     * Gets the value of the reviewCustomParameters property.
     * 
     * @return
     *     possible object is
     *     {@link CustomParameters }
     *     
     */
    public CustomParameters getReviewCustomParameters() {
        return reviewCustomParameters;
    }

    /**
     * Sets the value of the reviewCustomParameters property.
     * 
     * @param value
     *     allowed object is
     *     {@link CustomParameters }
     *     
     */
    public void setReviewCustomParameters(CustomParameters value) {
        this.reviewCustomParameters = value;
    }

    /**
     * Gets the value of the advanced property.
     * 
     * @return
     *     possible object is
     *     {@link Advanced }
     *     
     */
    public Advanced getAdvanced() {
        return advanced;
    }

    /**
     * Sets the value of the advanced property.
     * 
     * @param value
     *     allowed object is
     *     {@link Advanced }
     *     
     */
    public void setAdvanced(Advanced value) {
        this.advanced = value;
    }

}

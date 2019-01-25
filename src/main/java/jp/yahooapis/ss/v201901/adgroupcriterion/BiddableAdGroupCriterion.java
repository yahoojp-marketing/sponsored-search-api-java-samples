
package jp.yahooapis.ss.v201901.adgroupcriterion;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for BiddableAdGroupCriterion complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="BiddableAdGroupCriterion">
 *   &lt;complexContent>
 *     &lt;extension base="{http://ss.yahooapis.jp/V201901/AdGroupCriterion}AdGroupCriterion">
 *       &lt;sequence>
 *         &lt;element name="userStatus" type="{http://ss.yahooapis.jp/V201901/AdGroupCriterion}UserStatus" minOccurs="0"/>
 *         &lt;element name="approvalStatus" type="{http://ss.yahooapis.jp/V201901/AdGroupCriterion}ApprovalStatus" minOccurs="0"/>
 *         &lt;element name="disapprovalReasonCodes" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="destinationUrl" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="reviewDestinationUrl" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="bid" type="{http://ss.yahooapis.jp/V201901/AdGroupCriterion}Bid" minOccurs="0"/>
 *         &lt;element name="advancedUrl" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="reviewAdvancedUrl" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="additionalAdvancedUrls" type="{http://ss.yahooapis.jp/V201901/AdGroupCriterion}AdGroupCriterionAdditionalAdvancedUrls" minOccurs="0"/>
 *         &lt;element name="advancedMobileUrl" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="reviewAdvancedMobileUrl" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="additionalAdvancedMobileUrls" type="{http://ss.yahooapis.jp/V201901/AdGroupCriterion}AdGroupCriterionAdditionalAdvancedMobileUrls" minOccurs="0"/>
 *         &lt;element name="trackingUrl" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="reviewTrackingUrl" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="customParameters" type="{http://ss.yahooapis.jp/V201901/AdGroupCriterion}CustomParameters" minOccurs="0"/>
 *         &lt;element name="reviewCustomParameters" type="{http://ss.yahooapis.jp/V201901/AdGroupCriterion}CustomParameters" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "BiddableAdGroupCriterion", propOrder = {
    "userStatus",
    "approvalStatus",
    "disapprovalReasonCodes",
    "destinationUrl",
    "reviewDestinationUrl",
    "bid",
    "advancedUrl",
    "reviewAdvancedUrl",
    "additionalAdvancedUrls",
    "advancedMobileUrl",
    "reviewAdvancedMobileUrl",
    "additionalAdvancedMobileUrls",
    "trackingUrl",
    "reviewTrackingUrl",
    "customParameters",
    "reviewCustomParameters"
})
public class BiddableAdGroupCriterion
    extends AdGroupCriterion
{

    @XmlSchemaType(name = "string")
    protected UserStatus userStatus;
    @XmlSchemaType(name = "string")
    protected ApprovalStatus approvalStatus;
    protected List<String> disapprovalReasonCodes;
    protected String destinationUrl;
    protected String reviewDestinationUrl;
    protected Bid bid;
    protected String advancedUrl;
    protected String reviewAdvancedUrl;
    protected AdGroupCriterionAdditionalAdvancedUrls additionalAdvancedUrls;
    protected String advancedMobileUrl;
    protected String reviewAdvancedMobileUrl;
    protected AdGroupCriterionAdditionalAdvancedMobileUrls additionalAdvancedMobileUrls;
    protected String trackingUrl;
    protected String reviewTrackingUrl;
    protected CustomParameters customParameters;
    protected CustomParameters reviewCustomParameters;

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
     * Gets the value of the destinationUrl property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDestinationUrl() {
        return destinationUrl;
    }

    /**
     * Sets the value of the destinationUrl property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDestinationUrl(String value) {
        this.destinationUrl = value;
    }

    /**
     * Gets the value of the reviewDestinationUrl property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getReviewDestinationUrl() {
        return reviewDestinationUrl;
    }

    /**
     * Sets the value of the reviewDestinationUrl property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setReviewDestinationUrl(String value) {
        this.reviewDestinationUrl = value;
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
     * Gets the value of the advancedUrl property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAdvancedUrl() {
        return advancedUrl;
    }

    /**
     * Sets the value of the advancedUrl property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAdvancedUrl(String value) {
        this.advancedUrl = value;
    }

    /**
     * Gets the value of the reviewAdvancedUrl property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getReviewAdvancedUrl() {
        return reviewAdvancedUrl;
    }

    /**
     * Sets the value of the reviewAdvancedUrl property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setReviewAdvancedUrl(String value) {
        this.reviewAdvancedUrl = value;
    }

    /**
     * Gets the value of the additionalAdvancedUrls property.
     * 
     * @return
     *     possible object is
     *     {@link AdGroupCriterionAdditionalAdvancedUrls }
     *     
     */
    public AdGroupCriterionAdditionalAdvancedUrls getAdditionalAdvancedUrls() {
        return additionalAdvancedUrls;
    }

    /**
     * Sets the value of the additionalAdvancedUrls property.
     * 
     * @param value
     *     allowed object is
     *     {@link AdGroupCriterionAdditionalAdvancedUrls }
     *     
     */
    public void setAdditionalAdvancedUrls(AdGroupCriterionAdditionalAdvancedUrls value) {
        this.additionalAdvancedUrls = value;
    }

    /**
     * Gets the value of the advancedMobileUrl property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAdvancedMobileUrl() {
        return advancedMobileUrl;
    }

    /**
     * Sets the value of the advancedMobileUrl property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAdvancedMobileUrl(String value) {
        this.advancedMobileUrl = value;
    }

    /**
     * Gets the value of the reviewAdvancedMobileUrl property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getReviewAdvancedMobileUrl() {
        return reviewAdvancedMobileUrl;
    }

    /**
     * Sets the value of the reviewAdvancedMobileUrl property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setReviewAdvancedMobileUrl(String value) {
        this.reviewAdvancedMobileUrl = value;
    }

    /**
     * Gets the value of the additionalAdvancedMobileUrls property.
     * 
     * @return
     *     possible object is
     *     {@link AdGroupCriterionAdditionalAdvancedMobileUrls }
     *     
     */
    public AdGroupCriterionAdditionalAdvancedMobileUrls getAdditionalAdvancedMobileUrls() {
        return additionalAdvancedMobileUrls;
    }

    /**
     * Sets the value of the additionalAdvancedMobileUrls property.
     * 
     * @param value
     *     allowed object is
     *     {@link AdGroupCriterionAdditionalAdvancedMobileUrls }
     *     
     */
    public void setAdditionalAdvancedMobileUrls(AdGroupCriterionAdditionalAdvancedMobileUrls value) {
        this.additionalAdvancedMobileUrls = value;
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
     * Gets the value of the reviewTrackingUrl property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getReviewTrackingUrl() {
        return reviewTrackingUrl;
    }

    /**
     * Sets the value of the reviewTrackingUrl property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setReviewTrackingUrl(String value) {
        this.reviewTrackingUrl = value;
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

}

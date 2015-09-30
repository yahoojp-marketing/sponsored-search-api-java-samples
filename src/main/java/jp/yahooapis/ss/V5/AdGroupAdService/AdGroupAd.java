
package jp.yahooapis.ss.V5.AdGroupAdService;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for AdGroupAd complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="AdGroupAd">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="accountId" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="campaignId" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="campaignName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="adGroupId" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="adGroupName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="adId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="adTrackId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="adName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="userStatus" type="{http://ss.yahooapis.jp/V5}UserStatus" minOccurs="0"/>
 *         &lt;element name="approvalStatus" type="{http://ss.yahooapis.jp/V5}ApprovalStatus" minOccurs="0"/>
 *         &lt;element name="disapprovalReasonCodes" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="ad" type="{http://ss.yahooapis.jp/V5}Ad" minOccurs="0"/>
 *         &lt;element name="feedFolderId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AdGroupAd", propOrder = {
    "accountId",
    "campaignId",
    "campaignName",
    "adGroupId",
    "adGroupName",
    "adId",
    "adTrackId",
    "adName",
    "userStatus",
    "approvalStatus",
    "disapprovalReasonCodes",
    "ad",
    "feedFolderId"
})
public class AdGroupAd {

    protected long accountId;
    protected long campaignId;
    protected String campaignName;
    protected long adGroupId;
    protected String adGroupName;
    protected Long adId;
    protected Long adTrackId;
    protected String adName;
    @XmlSchemaType(name = "string")
    protected UserStatus userStatus;
    @XmlSchemaType(name = "string")
    protected ApprovalStatus approvalStatus;
    protected List<String> disapprovalReasonCodes;
    protected Ad ad;
    protected Long feedFolderId;

    /**
     * Gets the value of the accountId property.
     * 
     */
    public long getAccountId() {
        return accountId;
    }

    /**
     * Sets the value of the accountId property.
     * 
     */
    public void setAccountId(long value) {
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
     */
    public long getAdGroupId() {
        return adGroupId;
    }

    /**
     * Sets the value of the adGroupId property.
     * 
     */
    public void setAdGroupId(long value) {
        this.adGroupId = value;
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
     * Gets the value of the adId property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getAdId() {
        return adId;
    }

    /**
     * Sets the value of the adId property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setAdId(Long value) {
        this.adId = value;
    }

    /**
     * Gets the value of the adTrackId property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getAdTrackId() {
        return adTrackId;
    }

    /**
     * Sets the value of the adTrackId property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setAdTrackId(Long value) {
        this.adTrackId = value;
    }

    /**
     * Gets the value of the adName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAdName() {
        return adName;
    }

    /**
     * Sets the value of the adName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAdName(String value) {
        this.adName = value;
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
     * Gets the value of the ad property.
     * 
     * @return
     *     possible object is
     *     {@link Ad }
     *     
     */
    public Ad getAd() {
        return ad;
    }

    /**
     * Sets the value of the ad property.
     * 
     * @param value
     *     allowed object is
     *     {@link Ad }
     *     
     */
    public void setAd(Ad value) {
        this.ad = value;
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

}

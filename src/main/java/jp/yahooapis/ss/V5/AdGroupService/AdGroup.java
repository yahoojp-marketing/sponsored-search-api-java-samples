
package jp.yahooapis.ss.V5.AdGroupService;

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
 *         &lt;element name="accountId" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="campaignId" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="campaignName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="adGroupId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="adGroupName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="userStatus" type="{http://ss.yahooapis.jp/V5}UserStatus" minOccurs="0"/>
 *         &lt;element name="biddingStrategyConfiguration" type="{http://ss.yahooapis.jp/V5}BiddingStrategy" minOccurs="0"/>
 *         &lt;element name="biddingStrategyFailedReason" type="{http://ss.yahooapis.jp/V5}BiddingStrategyFailedReason" minOccurs="0"/>
 *         &lt;element name="failedBiddingStrategyConfiguration" type="{http://ss.yahooapis.jp/V5}BiddingStrategy" minOccurs="0"/>
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
    "campaignName",
    "adGroupId",
    "adGroupName",
    "userStatus",
    "biddingStrategyConfiguration",
    "biddingStrategyFailedReason",
    "failedBiddingStrategyConfiguration"
})
public class AdGroup {

    protected long accountId;
    protected long campaignId;
    protected String campaignName;
    protected Long adGroupId;
    protected String adGroupName;
    @XmlSchemaType(name = "string")
    protected UserStatus userStatus;
    protected BiddingStrategy biddingStrategyConfiguration;
    @XmlSchemaType(name = "string")
    protected BiddingStrategyFailedReason biddingStrategyFailedReason;
    protected BiddingStrategy failedBiddingStrategyConfiguration;

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
     * Gets the value of the biddingStrategyConfiguration property.
     * 
     * @return
     *     possible object is
     *     {@link BiddingStrategy }
     *     
     */
    public BiddingStrategy getBiddingStrategyConfiguration() {
        return biddingStrategyConfiguration;
    }

    /**
     * Sets the value of the biddingStrategyConfiguration property.
     * 
     * @param value
     *     allowed object is
     *     {@link BiddingStrategy }
     *     
     */
    public void setBiddingStrategyConfiguration(BiddingStrategy value) {
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
     *     {@link BiddingStrategy }
     *     
     */
    public BiddingStrategy getFailedBiddingStrategyConfiguration() {
        return failedBiddingStrategyConfiguration;
    }

    /**
     * Sets the value of the failedBiddingStrategyConfiguration property.
     * 
     * @param value
     *     allowed object is
     *     {@link BiddingStrategy }
     *     
     */
    public void setFailedBiddingStrategyConfiguration(BiddingStrategy value) {
        this.failedBiddingStrategyConfiguration = value;
    }

}

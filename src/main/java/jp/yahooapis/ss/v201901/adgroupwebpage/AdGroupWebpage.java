
package jp.yahooapis.ss.v201901.adgroupwebpage;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for AdGroupWebpage complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="AdGroupWebpage">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="accountId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="campaignId" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="campaignTrackId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="adGroupId" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="adGroupTrackId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="userStatus" type="{http://ss.yahooapis.jp/V201901/AdGroupWebpage}UserStatus" minOccurs="0"/>
 *         &lt;element name="excludedType" type="{http://ss.yahooapis.jp/V201901/AdGroupWebpage}ExcludedType" minOccurs="0"/>
 *         &lt;element name="webpage" type="{http://ss.yahooapis.jp/V201901/AdGroupWebpage}Webpage"/>
 *         &lt;element name="bid" type="{http://ss.yahooapis.jp/V201901/AdGroupWebpage}Bid" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AdGroupWebpage", propOrder = {
    "accountId",
    "campaignId",
    "campaignTrackId",
    "adGroupId",
    "adGroupTrackId",
    "userStatus",
    "excludedType",
    "webpage",
    "bid"
})
public class AdGroupWebpage {

    protected Long accountId;
    protected long campaignId;
    protected Long campaignTrackId;
    protected long adGroupId;
    protected Long adGroupTrackId;
    @XmlSchemaType(name = "string")
    protected UserStatus userStatus;
    @XmlSchemaType(name = "string")
    protected ExcludedType excludedType;
    @XmlElement(required = true)
    protected Webpage webpage;
    protected Bid bid;

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
     * Gets the value of the excludedType property.
     * 
     * @return
     *     possible object is
     *     {@link ExcludedType }
     *     
     */
    public ExcludedType getExcludedType() {
        return excludedType;
    }

    /**
     * Sets the value of the excludedType property.
     * 
     * @param value
     *     allowed object is
     *     {@link ExcludedType }
     *     
     */
    public void setExcludedType(ExcludedType value) {
        this.excludedType = value;
    }

    /**
     * Gets the value of the webpage property.
     * 
     * @return
     *     possible object is
     *     {@link Webpage }
     *     
     */
    public Webpage getWebpage() {
        return webpage;
    }

    /**
     * Sets the value of the webpage property.
     * 
     * @param value
     *     allowed object is
     *     {@link Webpage }
     *     
     */
    public void setWebpage(Webpage value) {
        this.webpage = value;
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

}

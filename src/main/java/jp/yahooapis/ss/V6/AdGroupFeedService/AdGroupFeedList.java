
package jp.yahooapis.ss.V6.AdGroupFeedService;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for AdGroupFeedList complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="AdGroupFeedList">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="accountId" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="campaignId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="adGroupId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="placeholderType" type="{http://ss.yahooapis.jp/V6}PlaceholderType" minOccurs="0"/>
 *         &lt;element name="adGroupFeed" type="{http://ss.yahooapis.jp/V6}AdGroupFeed" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="devicePlatform" type="{http://ss.yahooapis.jp/V6}DevicePlatform" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AdGroupFeedList", propOrder = {
    "accountId",
    "campaignId",
    "adGroupId",
    "placeholderType",
    "adGroupFeed",
    "devicePlatform"
})
public class AdGroupFeedList {

    protected long accountId;
    protected Long campaignId;
    protected Long adGroupId;
    @XmlSchemaType(name = "string")
    protected PlaceholderType placeholderType;
    protected List<AdGroupFeed> adGroupFeed;
    @XmlSchemaType(name = "string")
    protected DevicePlatform devicePlatform;

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
     * Gets the value of the adGroupFeed property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the adGroupFeed property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAdGroupFeed().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link AdGroupFeed }
     * 
     * 
     */
    public List<AdGroupFeed> getAdGroupFeed() {
        if (adGroupFeed == null) {
            adGroupFeed = new ArrayList<AdGroupFeed>();
        }
        return this.adGroupFeed;
    }

    /**
     * Gets the value of the devicePlatform property.
     * 
     * @return
     *     possible object is
     *     {@link DevicePlatform }
     *     
     */
    public DevicePlatform getDevicePlatform() {
        return devicePlatform;
    }

    /**
     * Sets the value of the devicePlatform property.
     * 
     * @param value
     *     allowed object is
     *     {@link DevicePlatform }
     *     
     */
    public void setDevicePlatform(DevicePlatform value) {
        this.devicePlatform = value;
    }

}

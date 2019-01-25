
package jp.yahooapis.ss.v201901.campaignwebpage;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for CampaignWebpage complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="CampaignWebpage">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="accountId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="campaignId" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="campaignTrackId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="webpage" type="{http://ss.yahooapis.jp/V201901/CampaignWebpage}Webpage"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CampaignWebpage", propOrder = {
    "accountId",
    "campaignId",
    "campaignTrackId",
    "webpage"
})
public class CampaignWebpage {

    protected Long accountId;
    protected long campaignId;
    protected Long campaignTrackId;
    @XmlElement(required = true)
    protected Webpage webpage;

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

}

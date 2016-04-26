
package jp.yahooapis.ss.V6.AdGroupBidMultiplierService;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for PlatformBidMultiplier complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="PlatformBidMultiplier">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="type" type="{http://ss.yahooapis.jp/V6}BidMultiplierType" minOccurs="0"/>
 *         &lt;element name="platformName" type="{http://ss.yahooapis.jp/V6}PlatformType" minOccurs="0"/>
 *         &lt;element name="bidMultiplier" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PlatformBidMultiplier", propOrder = {
    "type",
    "platformName",
    "bidMultiplier"
})
public class PlatformBidMultiplier {

    @XmlSchemaType(name = "string")
    protected BidMultiplierType type;
    @XmlSchemaType(name = "string")
    protected PlatformType platformName;
    protected Double bidMultiplier;

    /**
     * Gets the value of the type property.
     * 
     * @return
     *     possible object is
     *     {@link BidMultiplierType }
     *     
     */
    public BidMultiplierType getType() {
        return type;
    }

    /**
     * Sets the value of the type property.
     * 
     * @param value
     *     allowed object is
     *     {@link BidMultiplierType }
     *     
     */
    public void setType(BidMultiplierType value) {
        this.type = value;
    }

    /**
     * Gets the value of the platformName property.
     * 
     * @return
     *     possible object is
     *     {@link PlatformType }
     *     
     */
    public PlatformType getPlatformName() {
        return platformName;
    }

    /**
     * Sets the value of the platformName property.
     * 
     * @param value
     *     allowed object is
     *     {@link PlatformType }
     *     
     */
    public void setPlatformName(PlatformType value) {
        this.platformName = value;
    }

    /**
     * Gets the value of the bidMultiplier property.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getBidMultiplier() {
        return bidMultiplier;
    }

    /**
     * Sets the value of the bidMultiplier property.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setBidMultiplier(Double value) {
        this.bidMultiplier = value;
    }

}

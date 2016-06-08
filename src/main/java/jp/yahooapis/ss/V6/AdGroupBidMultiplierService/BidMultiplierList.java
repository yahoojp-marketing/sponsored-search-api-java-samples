
package jp.yahooapis.ss.V6.AdGroupBidMultiplierService;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for BidMultiplierList complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="BidMultiplierList">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="type" type="{http://ss.yahooapis.jp/V6}BidMultiplierType" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "BidMultiplierList", propOrder = {
    "type"
})
@XmlSeeAlso({
    PlatformBidMultiplierList.class
})
public abstract class BidMultiplierList {

    @XmlSchemaType(name = "string")
    protected BidMultiplierType type;

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

}

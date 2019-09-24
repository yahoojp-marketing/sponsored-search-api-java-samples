
package jp.yahooapis.ss.v201909.biddingstrategy;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for BiddingScheme complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="BiddingScheme">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="biddingStrategyType" type="{http://ss.yahooapis.jp/V201909/BiddingStrategy}BiddingStrategyType" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "BiddingScheme", propOrder = {
    "biddingStrategyType"
})
@XmlSeeAlso({
    TargetCpaBiddingScheme.class,
    TargetRoasBiddingScheme.class,
    TargetSpendBiddingScheme.class
})
public abstract class BiddingScheme {

    @XmlSchemaType(name = "string")
    protected BiddingStrategyType biddingStrategyType;

    /**
     * Gets the value of the biddingStrategyType property.
     * 
     * @return
     *     possible object is
     *     {@link BiddingStrategyType }
     *     
     */
    public BiddingStrategyType getBiddingStrategyType() {
        return biddingStrategyType;
    }

    /**
     * Sets the value of the biddingStrategyType property.
     * 
     * @param value
     *     allowed object is
     *     {@link BiddingStrategyType }
     *     
     */
    public void setBiddingStrategyType(BiddingStrategyType value) {
        this.biddingStrategyType = value;
    }

}

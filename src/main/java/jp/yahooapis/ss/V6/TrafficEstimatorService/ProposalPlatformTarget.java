
package jp.yahooapis.ss.V6.TrafficEstimatorService;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ProposalPlatformTarget complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ProposalPlatformTarget">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="platformName" type="{http://ss.yahooapis.jp/V6}ProposalPlatformType" minOccurs="0"/>
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
@XmlType(name = "ProposalPlatformTarget", propOrder = {
    "platformName",
    "bidMultiplier"
})
public class ProposalPlatformTarget {

    @XmlSchemaType(name = "string")
    protected ProposalPlatformType platformName;
    protected Double bidMultiplier;

    /**
     * Gets the value of the platformName property.
     * 
     * @return
     *     possible object is
     *     {@link ProposalPlatformType }
     *     
     */
    public ProposalPlatformType getPlatformName() {
        return platformName;
    }

    /**
     * Sets the value of the platformName property.
     * 
     * @param value
     *     allowed object is
     *     {@link ProposalPlatformType }
     *     
     */
    public void setPlatformName(ProposalPlatformType value) {
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

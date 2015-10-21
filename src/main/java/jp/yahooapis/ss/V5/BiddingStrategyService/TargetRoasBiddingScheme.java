
package jp.yahooapis.ss.V5.BiddingStrategyService;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for TargetRoasBiddingScheme complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="TargetRoasBiddingScheme">
 *   &lt;complexContent>
 *     &lt;extension base="{http://ss.yahooapis.jp/V5}BiddingScheme">
 *       &lt;sequence>
 *         &lt;element name="targetRoas" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *         &lt;element name="bidCeiling" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="bidFloor" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TargetRoasBiddingScheme", propOrder = {
    "targetRoas",
    "bidCeiling",
    "bidFloor"
})
public class TargetRoasBiddingScheme
    extends BiddingScheme
{

    protected Double targetRoas;
    protected Long bidCeiling;
    protected Long bidFloor;

    /**
     * Gets the value of the targetRoas property.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getTargetRoas() {
        return targetRoas;
    }

    /**
     * Sets the value of the targetRoas property.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setTargetRoas(Double value) {
        this.targetRoas = value;
    }

    /**
     * Gets the value of the bidCeiling property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getBidCeiling() {
        return bidCeiling;
    }

    /**
     * Sets the value of the bidCeiling property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setBidCeiling(Long value) {
        this.bidCeiling = value;
    }

    /**
     * Gets the value of the bidFloor property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getBidFloor() {
        return bidFloor;
    }

    /**
     * Sets the value of the bidFloor property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setBidFloor(Long value) {
        this.bidFloor = value;
    }

}


package jp.yahooapis.ss.v201805.biddingstrategy;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for TargetCpaBiddingScheme complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="TargetCpaBiddingScheme">
 *   &lt;complexContent>
 *     &lt;extension base="{http://ss.yahooapis.jp/V201805/BiddingStrategy}BiddingScheme">
 *       &lt;sequence>
 *         &lt;element name="targetCpa" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
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
@XmlType(name = "TargetCpaBiddingScheme", propOrder = {
    "targetCpa",
    "bidCeiling",
    "bidFloor"
})
public class TargetCpaBiddingScheme
    extends BiddingScheme
{

    protected Long targetCpa;
    protected Long bidCeiling;
    protected Long bidFloor;

    /**
     * Gets the value of the targetCpa property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getTargetCpa() {
        return targetCpa;
    }

    /**
     * Sets the value of the targetCpa property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setTargetCpa(Long value) {
        this.targetCpa = value;
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


package jp.yahooapis.ss.V6.BiddingStrategyService;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for TargetSpendBiddingScheme complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="TargetSpendBiddingScheme">
 *   &lt;complexContent>
 *     &lt;extension base="{http://ss.yahooapis.jp/V6}BiddingScheme">
 *       &lt;sequence>
 *         &lt;element name="bidCeiling" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="spendTarget" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TargetSpendBiddingScheme", propOrder = {
    "bidCeiling",
    "spendTarget"
})
public class TargetSpendBiddingScheme
    extends BiddingScheme
{

    protected Long bidCeiling;
    protected Long spendTarget;

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
     * Gets the value of the spendTarget property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getSpendTarget() {
        return spendTarget;
    }

    /**
     * Sets the value of the spendTarget property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setSpendTarget(Long value) {
        this.spendTarget = value;
    }

}

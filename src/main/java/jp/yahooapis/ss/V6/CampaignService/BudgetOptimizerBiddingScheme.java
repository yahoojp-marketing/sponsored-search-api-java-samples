
package jp.yahooapis.ss.V6.CampaignService;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for BudgetOptimizerBiddingScheme complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="BudgetOptimizerBiddingScheme">
 *   &lt;complexContent>
 *     &lt;extension base="{http://ss.yahooapis.jp/V6}BiddingScheme">
 *       &lt;sequence>
 *         &lt;element name="bidCeiling" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "BudgetOptimizerBiddingScheme", propOrder = {
    "bidCeiling"
})
public class BudgetOptimizerBiddingScheme
    extends BiddingScheme
{

    protected Long bidCeiling;

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

}

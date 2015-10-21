
package jp.yahooapis.ss.V5.CampaignService;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for BudgetOptimizer complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="BudgetOptimizer">
 *   &lt;complexContent>
 *     &lt;extension base="{http://ss.yahooapis.jp/V5}BiddingStrategy">
 *       &lt;sequence>
 *         &lt;element name="bidCeiling" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "BudgetOptimizer", propOrder = {
    "bidCeiling"
})
public class BudgetOptimizer
    extends BiddingStrategy
{

    protected Integer bidCeiling;

    /**
     * Gets the value of the bidCeiling property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getBidCeiling() {
        return bidCeiling;
    }

    /**
     * Sets the value of the bidCeiling property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setBidCeiling(Integer value) {
        this.bidCeiling = value;
    }

}

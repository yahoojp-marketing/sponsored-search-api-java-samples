
package jp.yahooapis.ss.V5.AdGroupCriterionService;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for AdGroupCriterionBid complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="AdGroupCriterionBid">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="type" type="{http://ss.yahooapis.jp/V5}BiddingStrategyType" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AdGroupCriterionBid", propOrder = {
    "type"
})
@XmlSeeAlso({
    BudgetOptimizerAdGroupCriterionBid.class,
    ManualCPCAdGroupCriterionBid.class
})
public class AdGroupCriterionBid {

    protected BiddingStrategyType type;

    /**
     * Gets the value of the type property.
     * 
     * @return
     *     possible object is
     *     {@link BiddingStrategyType }
     *     
     */
    public BiddingStrategyType getType() {
        return type;
    }

    /**
     * Sets the value of the type property.
     * 
     * @param value
     *     allowed object is
     *     {@link BiddingStrategyType }
     *     
     */
    public void setType(BiddingStrategyType value) {
        this.type = value;
    }

}

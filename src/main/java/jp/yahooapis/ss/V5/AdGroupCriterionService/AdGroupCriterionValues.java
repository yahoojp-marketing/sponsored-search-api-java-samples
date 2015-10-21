
package jp.yahooapis.ss.V5.AdGroupCriterionService;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for AdGroupCriterionValues complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="AdGroupCriterionValues">
 *   &lt;complexContent>
 *     &lt;extension base="{http://ss.yahooapis.jp/V5}ReturnValue">
 *       &lt;sequence>
 *         &lt;element name="adGroupCriterion" type="{http://ss.yahooapis.jp/V5}AdGroupCriterion" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AdGroupCriterionValues", propOrder = {
    "adGroupCriterion"
})
public class AdGroupCriterionValues
    extends ReturnValue
{

    protected AdGroupCriterion adGroupCriterion;

    /**
     * Gets the value of the adGroupCriterion property.
     * 
     * @return
     *     possible object is
     *     {@link AdGroupCriterion }
     *     
     */
    public AdGroupCriterion getAdGroupCriterion() {
        return adGroupCriterion;
    }

    /**
     * Sets the value of the adGroupCriterion property.
     * 
     * @param value
     *     allowed object is
     *     {@link AdGroupCriterion }
     *     
     */
    public void setAdGroupCriterion(AdGroupCriterion value) {
        this.adGroupCriterion = value;
    }

}

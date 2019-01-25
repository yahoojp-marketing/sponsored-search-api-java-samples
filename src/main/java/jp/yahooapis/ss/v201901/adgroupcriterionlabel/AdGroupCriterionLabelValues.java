
package jp.yahooapis.ss.v201901.adgroupcriterionlabel;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;
import jp.yahooapis.ss.v201901.ReturnValue;


/**
 * <p>Java class for AdGroupCriterionLabelValues complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="AdGroupCriterionLabelValues">
 *   &lt;complexContent>
 *     &lt;extension base="{http://ss.yahooapis.jp/V201901}ReturnValue">
 *       &lt;sequence>
 *         &lt;element name="adGroupCriterionLabel" type="{http://ss.yahooapis.jp/V201901/AdGroupCriterionLabel}AdGroupCriterionLabel" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AdGroupCriterionLabelValues", propOrder = {
    "adGroupCriterionLabel"
})
public class AdGroupCriterionLabelValues
    extends ReturnValue
{

    protected AdGroupCriterionLabel adGroupCriterionLabel;

    /**
     * Gets the value of the adGroupCriterionLabel property.
     * 
     * @return
     *     possible object is
     *     {@link AdGroupCriterionLabel }
     *     
     */
    public AdGroupCriterionLabel getAdGroupCriterionLabel() {
        return adGroupCriterionLabel;
    }

    /**
     * Sets the value of the adGroupCriterionLabel property.
     * 
     * @param value
     *     allowed object is
     *     {@link AdGroupCriterionLabel }
     *     
     */
    public void setAdGroupCriterionLabel(AdGroupCriterionLabel value) {
        this.adGroupCriterionLabel = value;
    }

}

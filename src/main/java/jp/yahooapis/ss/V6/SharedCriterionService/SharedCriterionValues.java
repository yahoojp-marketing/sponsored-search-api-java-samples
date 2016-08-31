
package jp.yahooapis.ss.V6.SharedCriterionService;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for SharedCriterionValues complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="SharedCriterionValues">
 *   &lt;complexContent>
 *     &lt;extension base="{http://ss.yahooapis.jp/V6}ReturnValue">
 *       &lt;sequence>
 *         &lt;element name="sharedCriterion" type="{http://ss.yahooapis.jp/V6}SharedCriterion" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SharedCriterionValues", propOrder = {
    "sharedCriterion"
})
public class SharedCriterionValues
    extends ReturnValue
{

    protected SharedCriterion sharedCriterion;

    /**
     * Gets the value of the sharedCriterion property.
     * 
     * @return
     *     possible object is
     *     {@link SharedCriterion }
     *     
     */
    public SharedCriterion getSharedCriterion() {
        return sharedCriterion;
    }

    /**
     * Sets the value of the sharedCriterion property.
     * 
     * @param value
     *     allowed object is
     *     {@link SharedCriterion }
     *     
     */
    public void setSharedCriterion(SharedCriterion value) {
        this.sharedCriterion = value;
    }

}

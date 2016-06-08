
package jp.yahooapis.ss.V6.AdGroupService;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for Settings complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Settings">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="criterionType" type="{http://ss.yahooapis.jp/V6}CriterionType"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Settings", propOrder = {
    "criterionType"
})
@XmlSeeAlso({
    TargetingSetting.class
})
public class Settings {

    @XmlElement(required = true)
    @XmlSchemaType(name = "string")
    protected CriterionType criterionType;

    /**
     * Gets the value of the criterionType property.
     * 
     * @return
     *     possible object is
     *     {@link CriterionType }
     *     
     */
    public CriterionType getCriterionType() {
        return criterionType;
    }

    /**
     * Sets the value of the criterionType property.
     * 
     * @param value
     *     allowed object is
     *     {@link CriterionType }
     *     
     */
    public void setCriterionType(CriterionType value) {
        this.criterionType = value;
    }

}

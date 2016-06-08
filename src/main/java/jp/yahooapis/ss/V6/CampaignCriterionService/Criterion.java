
package jp.yahooapis.ss.V6.CampaignCriterionService;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for Criterion complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Criterion">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="criterionId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="type" type="{http://ss.yahooapis.jp/V6}CriterionType" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Criterion", propOrder = {
    "criterionId",
    "type"
})
@XmlSeeAlso({
    Keyword.class
})
public class Criterion {

    protected Long criterionId;
    @XmlSchemaType(name = "string")
    protected CriterionType type;

    /**
     * Gets the value of the criterionId property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getCriterionId() {
        return criterionId;
    }

    /**
     * Sets the value of the criterionId property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setCriterionId(Long value) {
        this.criterionId = value;
    }

    /**
     * Gets the value of the type property.
     * 
     * @return
     *     possible object is
     *     {@link CriterionType }
     *     
     */
    public CriterionType getType() {
        return type;
    }

    /**
     * Sets the value of the type property.
     * 
     * @param value
     *     allowed object is
     *     {@link CriterionType }
     *     
     */
    public void setType(CriterionType value) {
        this.type = value;
    }

}

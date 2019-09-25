
package jp.yahooapis.ss.v201909.label;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for Label complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Label">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="accountId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="labelId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="labelName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="description" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="color" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="labeledCampaign" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="labeledAdGroup" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="labeledAdGroupAd" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="labeledAdGroupCriterion" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Label", propOrder = {
    "accountId",
    "labelId",
    "labelName",
    "description",
    "color",
    "labeledCampaign",
    "labeledAdGroup",
    "labeledAdGroupAd",
    "labeledAdGroupCriterion"
})
public class Label {

    protected Long accountId;
    protected Long labelId;
    protected String labelName;
    protected String description;
    protected String color;
    protected Long labeledCampaign;
    protected Long labeledAdGroup;
    protected Long labeledAdGroupAd;
    protected Long labeledAdGroupCriterion;

    /**
     * Gets the value of the accountId property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getAccountId() {
        return accountId;
    }

    /**
     * Sets the value of the accountId property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setAccountId(Long value) {
        this.accountId = value;
    }

    /**
     * Gets the value of the labelId property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getLabelId() {
        return labelId;
    }

    /**
     * Sets the value of the labelId property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setLabelId(Long value) {
        this.labelId = value;
    }

    /**
     * Gets the value of the labelName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLabelName() {
        return labelName;
    }

    /**
     * Sets the value of the labelName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLabelName(String value) {
        this.labelName = value;
    }

    /**
     * Gets the value of the description property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets the value of the description property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDescription(String value) {
        this.description = value;
    }

    /**
     * Gets the value of the color property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getColor() {
        return color;
    }

    /**
     * Sets the value of the color property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setColor(String value) {
        this.color = value;
    }

    /**
     * Gets the value of the labeledCampaign property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getLabeledCampaign() {
        return labeledCampaign;
    }

    /**
     * Sets the value of the labeledCampaign property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setLabeledCampaign(Long value) {
        this.labeledCampaign = value;
    }

    /**
     * Gets the value of the labeledAdGroup property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getLabeledAdGroup() {
        return labeledAdGroup;
    }

    /**
     * Sets the value of the labeledAdGroup property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setLabeledAdGroup(Long value) {
        this.labeledAdGroup = value;
    }

    /**
     * Gets the value of the labeledAdGroupAd property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getLabeledAdGroupAd() {
        return labeledAdGroupAd;
    }

    /**
     * Sets the value of the labeledAdGroupAd property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setLabeledAdGroupAd(Long value) {
        this.labeledAdGroupAd = value;
    }

    /**
     * Gets the value of the labeledAdGroupCriterion property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getLabeledAdGroupCriterion() {
        return labeledAdGroupCriterion;
    }

    /**
     * Sets the value of the labeledAdGroupCriterion property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setLabeledAdGroupCriterion(Long value) {
        this.labeledAdGroupCriterion = value;
    }

}

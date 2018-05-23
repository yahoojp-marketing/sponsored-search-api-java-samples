
package jp.yahooapis.ss.v201805.adgroupcriterion;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for AdGroupCriterionAdditionalAdvancedMobileUrls complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="AdGroupCriterionAdditionalAdvancedMobileUrls">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="additionalAdvancedMobileUrl" type="{http://ss.yahooapis.jp/V201805/AdGroupCriterion}AdGroupCriterionAdditionalUrl" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="isRemove" type="{http://ss.yahooapis.jp/V201805/AdGroupCriterion}IsRemove" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AdGroupCriterionAdditionalAdvancedMobileUrls", propOrder = {
    "additionalAdvancedMobileUrl",
    "isRemove"
})
public class AdGroupCriterionAdditionalAdvancedMobileUrls {

    protected List<AdGroupCriterionAdditionalUrl> additionalAdvancedMobileUrl;
    @XmlSchemaType(name = "string")
    protected IsRemove isRemove;

    /**
     * Gets the value of the additionalAdvancedMobileUrl property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the additionalAdvancedMobileUrl property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAdditionalAdvancedMobileUrl().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link AdGroupCriterionAdditionalUrl }
     * 
     * 
     */
    public List<AdGroupCriterionAdditionalUrl> getAdditionalAdvancedMobileUrl() {
        if (additionalAdvancedMobileUrl == null) {
            additionalAdvancedMobileUrl = new ArrayList<AdGroupCriterionAdditionalUrl>();
        }
        return this.additionalAdvancedMobileUrl;
    }

    /**
     * Gets the value of the isRemove property.
     * 
     * @return
     *     possible object is
     *     {@link IsRemove }
     *     
     */
    public IsRemove getIsRemove() {
        return isRemove;
    }

    /**
     * Sets the value of the isRemove property.
     * 
     * @param value
     *     allowed object is
     *     {@link IsRemove }
     *     
     */
    public void setIsRemove(IsRemove value) {
        this.isRemove = value;
    }

}

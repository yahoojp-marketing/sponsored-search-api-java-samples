
package jp.yahooapis.ss.V5.ReportDefinitionService;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ReportDefinitionField complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ReportDefinitionField">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="fieldName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="displayFieldName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="xmlAttributeName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="fieldType" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="enumValues" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="canSelect" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="canFilter" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ReportDefinitionField", propOrder = {
    "fieldName",
    "displayFieldName",
    "xmlAttributeName",
    "fieldType",
    "enumValues",
    "canSelect",
    "canFilter"
})
public class ReportDefinitionField {

    protected String fieldName;
    protected String displayFieldName;
    protected String xmlAttributeName;
    protected String fieldType;
    protected List<String> enumValues;
    protected Boolean canSelect;
    protected Boolean canFilter;

    /**
     * Gets the value of the fieldName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFieldName() {
        return fieldName;
    }

    /**
     * Sets the value of the fieldName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFieldName(String value) {
        this.fieldName = value;
    }

    /**
     * Gets the value of the displayFieldName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDisplayFieldName() {
        return displayFieldName;
    }

    /**
     * Sets the value of the displayFieldName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDisplayFieldName(String value) {
        this.displayFieldName = value;
    }

    /**
     * Gets the value of the xmlAttributeName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getXmlAttributeName() {
        return xmlAttributeName;
    }

    /**
     * Sets the value of the xmlAttributeName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setXmlAttributeName(String value) {
        this.xmlAttributeName = value;
    }

    /**
     * Gets the value of the fieldType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFieldType() {
        return fieldType;
    }

    /**
     * Sets the value of the fieldType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFieldType(String value) {
        this.fieldType = value;
    }

    /**
     * Gets the value of the enumValues property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the enumValues property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getEnumValues().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getEnumValues() {
        if (enumValues == null) {
            enumValues = new ArrayList<String>();
        }
        return this.enumValues;
    }

    /**
     * Gets the value of the canSelect property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isCanSelect() {
        return canSelect;
    }

    /**
     * Sets the value of the canSelect property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setCanSelect(Boolean value) {
        this.canSelect = value;
    }

    /**
     * Gets the value of the canFilter property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isCanFilter() {
        return canFilter;
    }

    /**
     * Sets the value of the canFilter property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setCanFilter(Boolean value) {
        this.canFilter = value;
    }

}

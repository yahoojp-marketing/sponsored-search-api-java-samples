
package jp.yahooapis.ss.V6.AdGroupBidMultiplierService;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ListReturnValue complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ListReturnValue">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ListReturnValue.Type" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Operation.Type" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ListReturnValue", propOrder = {
    "listReturnValueType",
    "operationType"
})
@XmlSeeAlso({
    AdGroupBidMultiplierReturnValue.class
})
public abstract class ListReturnValue {

    @XmlElement(name = "ListReturnValue.Type")
    protected String listReturnValueType;
    @XmlElement(name = "Operation.Type")
    protected String operationType;

    /**
     * Gets the value of the listReturnValueType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getListReturnValueType() {
        return listReturnValueType;
    }

    /**
     * Sets the value of the listReturnValueType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setListReturnValueType(String value) {
        this.listReturnValueType = value;
    }

    /**
     * Gets the value of the operationType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOperationType() {
        return operationType;
    }

    /**
     * Sets the value of the operationType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOperationType(String value) {
        this.operationType = value;
    }

}

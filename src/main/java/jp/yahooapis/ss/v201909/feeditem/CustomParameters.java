
package jp.yahooapis.ss.v201909.feeditem;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for CustomParameters complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="CustomParameters">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="isRemove" type="{http://ss.yahooapis.jp/V201909/FeedItem}IsRemove" minOccurs="0"/>
 *         &lt;element name="parameters" type="{http://ss.yahooapis.jp/V201909/FeedItem}CustomParameter" maxOccurs="3" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CustomParameters", propOrder = {
    "isRemove",
    "parameters"
})
public class CustomParameters {

    @XmlSchemaType(name = "string")
    protected IsRemove isRemove;
    protected List<CustomParameter> parameters;

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

    /**
     * Gets the value of the parameters property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the parameters property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getParameters().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link CustomParameter }
     * 
     * 
     */
    public List<CustomParameter> getParameters() {
        if (parameters == null) {
            parameters = new ArrayList<CustomParameter>();
        }
        return this.parameters;
    }

}

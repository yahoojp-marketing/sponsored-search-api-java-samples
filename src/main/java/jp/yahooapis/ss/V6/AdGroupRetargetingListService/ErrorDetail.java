
package jp.yahooapis.ss.V6.AdGroupRetargetingListService;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ErrorDetail complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ErrorDetail">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="requestKey" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="requestValue" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ErrorDetail", propOrder = {
    "requestKey",
    "requestValue"
})
public class ErrorDetail {

    protected String requestKey;
    protected List<String> requestValue;

    /**
     * Gets the value of the requestKey property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRequestKey() {
        return requestKey;
    }

    /**
     * Sets the value of the requestKey property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRequestKey(String value) {
        this.requestKey = value;
    }

    /**
     * Gets the value of the requestValue property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the requestValue property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getRequestValue().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getRequestValue() {
        if (requestValue == null) {
            requestValue = new ArrayList<String>();
        }
        return this.requestValue;
    }

}

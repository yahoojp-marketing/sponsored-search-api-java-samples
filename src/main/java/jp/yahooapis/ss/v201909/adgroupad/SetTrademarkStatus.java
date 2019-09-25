
package jp.yahooapis.ss.v201909.adgroupad;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="operations" type="{http://ss.yahooapis.jp/V201909/AdGroupAd}AdGroupAdSetTrademarkStatusOperation"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "operations"
})
@XmlRootElement(name = "setTrademarkStatus")
public class SetTrademarkStatus {

    @XmlElement(required = true)
    protected AdGroupAdSetTrademarkStatusOperation operations;

    /**
     * Gets the value of the operations property.
     * 
     * @return
     *     possible object is
     *     {@link AdGroupAdSetTrademarkStatusOperation }
     *     
     */
    public AdGroupAdSetTrademarkStatusOperation getOperations() {
        return operations;
    }

    /**
     * Sets the value of the operations property.
     * 
     * @param value
     *     allowed object is
     *     {@link AdGroupAdSetTrademarkStatusOperation }
     *     
     */
    public void setOperations(AdGroupAdSetTrademarkStatusOperation value) {
        this.operations = value;
    }

}

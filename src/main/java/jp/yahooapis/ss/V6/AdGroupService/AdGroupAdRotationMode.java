
package jp.yahooapis.ss.V6.AdGroupService;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for AdGroupAdRotationMode complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="AdGroupAdRotationMode">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="adRotationMode" type="{http://ss.yahooapis.jp/V6}AdRotationMode" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AdGroupAdRotationMode", propOrder = {
    "adRotationMode"
})
public class AdGroupAdRotationMode {

    @XmlSchemaType(name = "string")
    protected AdRotationMode adRotationMode;

    /**
     * Gets the value of the adRotationMode property.
     * 
     * @return
     *     possible object is
     *     {@link AdRotationMode }
     *     
     */
    public AdRotationMode getAdRotationMode() {
        return adRotationMode;
    }

    /**
     * Sets the value of the adRotationMode property.
     * 
     * @param value
     *     allowed object is
     *     {@link AdRotationMode }
     *     
     */
    public void setAdRotationMode(AdRotationMode value) {
        this.adRotationMode = value;
    }

}

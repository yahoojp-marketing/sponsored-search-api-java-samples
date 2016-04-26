
package jp.yahooapis.ss.V6.AdGroupService;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for AdGroupValues complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="AdGroupValues">
 *   &lt;complexContent>
 *     &lt;extension base="{http://ss.yahooapis.jp/V6}ReturnValue">
 *       &lt;sequence>
 *         &lt;element name="adGroup" type="{http://ss.yahooapis.jp/V6}AdGroup" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AdGroupValues", propOrder = {
    "adGroup"
})
public class AdGroupValues
    extends ReturnValue
{

    protected AdGroup adGroup;

    /**
     * Gets the value of the adGroup property.
     * 
     * @return
     *     possible object is
     *     {@link AdGroup }
     *     
     */
    public AdGroup getAdGroup() {
        return adGroup;
    }

    /**
     * Sets the value of the adGroup property.
     * 
     * @param value
     *     allowed object is
     *     {@link AdGroup }
     *     
     */
    public void setAdGroup(AdGroup value) {
        this.adGroup = value;
    }

}

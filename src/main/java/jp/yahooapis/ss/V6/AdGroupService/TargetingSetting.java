
package jp.yahooapis.ss.V6.AdGroupService;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for TargetingSetting complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="TargetingSetting">
 *   &lt;complexContent>
 *     &lt;extension base="{http://ss.yahooapis.jp/V6}AdGroupSettings">
 *       &lt;sequence>
 *         &lt;element name="targetAll" type="{http://ss.yahooapis.jp/V6}TargetAll" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TargetingSetting", propOrder = {
    "targetAll"
})
public class TargetingSetting
    extends AdGroupSettings
{

    @XmlSchemaType(name = "string")
    protected TargetAll targetAll;

    /**
     * Gets the value of the targetAll property.
     * 
     * @return
     *     possible object is
     *     {@link TargetAll }
     *     
     */
    public TargetAll getTargetAll() {
        return targetAll;
    }

    /**
     * Sets the value of the targetAll property.
     * 
     * @param value
     *     allowed object is
     *     {@link TargetAll }
     *     
     */
    public void setTargetAll(TargetAll value) {
        this.targetAll = value;
    }

}

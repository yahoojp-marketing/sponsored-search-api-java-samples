
package jp.yahooapis.ss.V5.CampaignService;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for KeywordMatchSetting complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="KeywordMatchSetting">
 *   &lt;complexContent>
 *     &lt;extension base="{http://ss.yahooapis.jp/V5}Settings">
 *       &lt;sequence>
 *         &lt;element name="optIn" type="{http://ss.yahooapis.jp/V5}OptInBool" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "KeywordMatchSetting", propOrder = {
    "optIn"
})
public class KeywordMatchSetting
    extends Settings
{

    @XmlSchemaType(name = "string")
    protected OptInBool optIn;

    /**
     * Gets the value of the optIn property.
     * 
     * @return
     *     possible object is
     *     {@link OptInBool }
     *     
     */
    public OptInBool getOptIn() {
        return optIn;
    }

    /**
     * Sets the value of the optIn property.
     * 
     * @param value
     *     allowed object is
     *     {@link OptInBool }
     *     
     */
    public void setOptIn(OptInBool value) {
        this.optIn = value;
    }

}

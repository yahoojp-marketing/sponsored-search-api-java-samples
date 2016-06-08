
package jp.yahooapis.ss.V6.CampaignService;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for Settings complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Settings">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="type" type="{http://ss.yahooapis.jp/V6}SettingType" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Settings", propOrder = {
    "type"
})
@XmlSeeAlso({
    GeoTargetTypeSetting.class
})
public abstract class Settings {

    @XmlSchemaType(name = "string")
    protected SettingType type;

    /**
     * Gets the value of the type property.
     * 
     * @return
     *     possible object is
     *     {@link SettingType }
     *     
     */
    public SettingType getType() {
        return type;
    }

    /**
     * Sets the value of the type property.
     * 
     * @param value
     *     allowed object is
     *     {@link SettingType }
     *     
     */
    public void setType(SettingType value) {
        this.type = value;
    }

}

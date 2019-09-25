
package jp.yahooapis.ss.v201909.campaigntarget;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for PlatformTarget complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="PlatformTarget">
 *   &lt;complexContent>
 *     &lt;extension base="{http://ss.yahooapis.jp/V201909/CampaignTarget}Target">
 *       &lt;sequence>
 *         &lt;element name="platformType" type="{http://ss.yahooapis.jp/V201909/CampaignTarget}PlatformType" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PlatformTarget", propOrder = {
    "platformType"
})
public class PlatformTarget
    extends Target
{

    @XmlSchemaType(name = "string")
    protected PlatformType platformType;

    /**
     * Gets the value of the platformType property.
     * 
     * @return
     *     possible object is
     *     {@link PlatformType }
     *     
     */
    public PlatformType getPlatformType() {
        return platformType;
    }

    /**
     * Sets the value of the platformType property.
     * 
     * @param value
     *     allowed object is
     *     {@link PlatformType }
     *     
     */
    public void setPlatformType(PlatformType value) {
        this.platformType = value;
    }

}

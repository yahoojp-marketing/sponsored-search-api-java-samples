
package jp.yahooapis.ss.v201901.campaign;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for GeoTargetTypeSetting complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="GeoTargetTypeSetting">
 *   &lt;complexContent>
 *     &lt;extension base="{http://ss.yahooapis.jp/V201901/Campaign}CampaignSettings">
 *       &lt;sequence>
 *         &lt;element name="positiveGeoTargetType" type="{http://ss.yahooapis.jp/V201901/Campaign}GeoTargetType" minOccurs="0"/>
 *         &lt;element name="negativeGeoTargetType" type="{http://ss.yahooapis.jp/V201901/Campaign}GeoTargetType" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GeoTargetTypeSetting", propOrder = {
    "positiveGeoTargetType",
    "negativeGeoTargetType"
})
public class GeoTargetTypeSetting
    extends CampaignSettings
{

    @XmlSchemaType(name = "string")
    protected GeoTargetType positiveGeoTargetType;
    @XmlSchemaType(name = "string")
    protected GeoTargetType negativeGeoTargetType;

    /**
     * Gets the value of the positiveGeoTargetType property.
     * 
     * @return
     *     possible object is
     *     {@link GeoTargetType }
     *     
     */
    public GeoTargetType getPositiveGeoTargetType() {
        return positiveGeoTargetType;
    }

    /**
     * Sets the value of the positiveGeoTargetType property.
     * 
     * @param value
     *     allowed object is
     *     {@link GeoTargetType }
     *     
     */
    public void setPositiveGeoTargetType(GeoTargetType value) {
        this.positiveGeoTargetType = value;
    }

    /**
     * Gets the value of the negativeGeoTargetType property.
     * 
     * @return
     *     possible object is
     *     {@link GeoTargetType }
     *     
     */
    public GeoTargetType getNegativeGeoTargetType() {
        return negativeGeoTargetType;
    }

    /**
     * Sets the value of the negativeGeoTargetType property.
     * 
     * @param value
     *     allowed object is
     *     {@link GeoTargetType }
     *     
     */
    public void setNegativeGeoTargetType(GeoTargetType value) {
        this.negativeGeoTargetType = value;
    }

}

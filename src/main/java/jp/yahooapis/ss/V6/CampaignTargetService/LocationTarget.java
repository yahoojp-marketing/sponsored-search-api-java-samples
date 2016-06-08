
package jp.yahooapis.ss.V6.CampaignTargetService;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for LocationTarget complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="LocationTarget">
 *   &lt;complexContent>
 *     &lt;extension base="{http://ss.yahooapis.jp/V6}Target">
 *       &lt;sequence>
 *         &lt;element name="provinceNameJA" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="provinceNameEN" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="cityNameJA" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="cityNameEN" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="excludedType" type="{http://ss.yahooapis.jp/V6}ExcludedType" minOccurs="0"/>
 *         &lt;element name="targetingStatus" type="{http://ss.yahooapis.jp/V6}TargetingStatus" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "LocationTarget", propOrder = {
    "provinceNameJA",
    "provinceNameEN",
    "cityNameJA",
    "cityNameEN",
    "excludedType",
    "targetingStatus"
})
public class LocationTarget
    extends Target
{

    protected String provinceNameJA;
    protected String provinceNameEN;
    protected String cityNameJA;
    protected String cityNameEN;
    @XmlSchemaType(name = "string")
    protected ExcludedType excludedType;
    @XmlSchemaType(name = "string")
    protected TargetingStatus targetingStatus;

    /**
     * Gets the value of the provinceNameJA property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getProvinceNameJA() {
        return provinceNameJA;
    }

    /**
     * Sets the value of the provinceNameJA property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setProvinceNameJA(String value) {
        this.provinceNameJA = value;
    }

    /**
     * Gets the value of the provinceNameEN property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getProvinceNameEN() {
        return provinceNameEN;
    }

    /**
     * Sets the value of the provinceNameEN property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setProvinceNameEN(String value) {
        this.provinceNameEN = value;
    }

    /**
     * Gets the value of the cityNameJA property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCityNameJA() {
        return cityNameJA;
    }

    /**
     * Sets the value of the cityNameJA property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCityNameJA(String value) {
        this.cityNameJA = value;
    }

    /**
     * Gets the value of the cityNameEN property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCityNameEN() {
        return cityNameEN;
    }

    /**
     * Sets the value of the cityNameEN property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCityNameEN(String value) {
        this.cityNameEN = value;
    }

    /**
     * Gets the value of the excludedType property.
     * 
     * @return
     *     possible object is
     *     {@link ExcludedType }
     *     
     */
    public ExcludedType getExcludedType() {
        return excludedType;
    }

    /**
     * Sets the value of the excludedType property.
     * 
     * @param value
     *     allowed object is
     *     {@link ExcludedType }
     *     
     */
    public void setExcludedType(ExcludedType value) {
        this.excludedType = value;
    }

    /**
     * Gets the value of the targetingStatus property.
     * 
     * @return
     *     possible object is
     *     {@link TargetingStatus }
     *     
     */
    public TargetingStatus getTargetingStatus() {
        return targetingStatus;
    }

    /**
     * Sets the value of the targetingStatus property.
     * 
     * @param value
     *     allowed object is
     *     {@link TargetingStatus }
     *     
     */
    public void setTargetingStatus(TargetingStatus value) {
        this.targetingStatus = value;
    }

}

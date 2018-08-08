
package jp.yahooapis.ss.v201808.conversiontracker;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for WebConversion complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="WebConversion">
 *   &lt;complexContent>
 *     &lt;extension base="{http://ss.yahooapis.jp/V201808/ConversionTracker}ConversionTracker">
 *       &lt;sequence>
 *         &lt;element name="snippet" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="markupLanguage" type="{http://ss.yahooapis.jp/V201808/ConversionTracker}MarkupLanguage" minOccurs="0"/>
 *         &lt;element name="trackingCodeType" type="{http://ss.yahooapis.jp/V201808/ConversionTracker}TrackingCodeType" minOccurs="0"/>
 *         &lt;element name="crossDeviceConversionFlag" type="{http://ss.yahooapis.jp/V201808/ConversionTracker}CrossDeviceConversionFlag" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "WebConversion", propOrder = {
    "snippet",
    "markupLanguage",
    "trackingCodeType",
    "crossDeviceConversionFlag"
})
public class WebConversion
    extends ConversionTracker
{

    protected String snippet;
    @XmlSchemaType(name = "string")
    protected MarkupLanguage markupLanguage;
    @XmlSchemaType(name = "string")
    protected TrackingCodeType trackingCodeType;
    @XmlSchemaType(name = "string")
    protected CrossDeviceConversionFlag crossDeviceConversionFlag;

    /**
     * Gets the value of the snippet property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSnippet() {
        return snippet;
    }

    /**
     * Sets the value of the snippet property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSnippet(String value) {
        this.snippet = value;
    }

    /**
     * Gets the value of the markupLanguage property.
     * 
     * @return
     *     possible object is
     *     {@link MarkupLanguage }
     *     
     */
    public MarkupLanguage getMarkupLanguage() {
        return markupLanguage;
    }

    /**
     * Sets the value of the markupLanguage property.
     * 
     * @param value
     *     allowed object is
     *     {@link MarkupLanguage }
     *     
     */
    public void setMarkupLanguage(MarkupLanguage value) {
        this.markupLanguage = value;
    }

    /**
     * Gets the value of the trackingCodeType property.
     * 
     * @return
     *     possible object is
     *     {@link TrackingCodeType }
     *     
     */
    public TrackingCodeType getTrackingCodeType() {
        return trackingCodeType;
    }

    /**
     * Sets the value of the trackingCodeType property.
     * 
     * @param value
     *     allowed object is
     *     {@link TrackingCodeType }
     *     
     */
    public void setTrackingCodeType(TrackingCodeType value) {
        this.trackingCodeType = value;
    }

    /**
     * Gets the value of the crossDeviceConversionFlag property.
     * 
     * @return
     *     possible object is
     *     {@link CrossDeviceConversionFlag }
     *     
     */
    public CrossDeviceConversionFlag getCrossDeviceConversionFlag() {
        return crossDeviceConversionFlag;
    }

    /**
     * Sets the value of the crossDeviceConversionFlag property.
     * 
     * @param value
     *     allowed object is
     *     {@link CrossDeviceConversionFlag }
     *     
     */
    public void setCrossDeviceConversionFlag(CrossDeviceConversionFlag value) {
        this.crossDeviceConversionFlag = value;
    }

}

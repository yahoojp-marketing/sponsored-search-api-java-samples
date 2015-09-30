
package jp.yahooapis.ss.V5.ConversionTrackerService;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for AppConversion complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="AppConversion">
 *   &lt;complexContent>
 *     &lt;extension base="{http://ss.yahooapis.jp/V5}ConversionTracker">
 *       &lt;sequence>
 *         &lt;element name="appId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="appPlatform" type="{http://ss.yahooapis.jp/V5}AppPlatform" minOccurs="0"/>
 *         &lt;element name="appConversionType" type="{http://ss.yahooapis.jp/V5}AppConversionType" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AppConversion", propOrder = {
    "appId",
    "appPlatform",
    "appConversionType"
})
public class AppConversion
    extends ConversionTracker
{

    protected String appId;
    @XmlSchemaType(name = "string")
    protected AppPlatform appPlatform;
    @XmlSchemaType(name = "string")
    protected AppConversionType appConversionType;

    /**
     * Gets the value of the appId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAppId() {
        return appId;
    }

    /**
     * Sets the value of the appId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAppId(String value) {
        this.appId = value;
    }

    /**
     * Gets the value of the appPlatform property.
     * 
     * @return
     *     possible object is
     *     {@link AppPlatform }
     *     
     */
    public AppPlatform getAppPlatform() {
        return appPlatform;
    }

    /**
     * Sets the value of the appPlatform property.
     * 
     * @param value
     *     allowed object is
     *     {@link AppPlatform }
     *     
     */
    public void setAppPlatform(AppPlatform value) {
        this.appPlatform = value;
    }

    /**
     * Gets the value of the appConversionType property.
     * 
     * @return
     *     possible object is
     *     {@link AppConversionType }
     *     
     */
    public AppConversionType getAppConversionType() {
        return appConversionType;
    }

    /**
     * Sets the value of the appConversionType property.
     * 
     * @param value
     *     allowed object is
     *     {@link AppConversionType }
     *     
     */
    public void setAppConversionType(AppConversionType value) {
        this.appConversionType = value;
    }

}

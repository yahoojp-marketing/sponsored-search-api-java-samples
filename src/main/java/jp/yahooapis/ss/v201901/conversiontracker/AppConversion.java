
package jp.yahooapis.ss.v201901.conversiontracker;

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
 *     &lt;extension base="{http://ss.yahooapis.jp/V201901/ConversionTracker}ConversionTracker">
 *       &lt;sequence>
 *         &lt;element name="appId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="appPlatform" type="{http://ss.yahooapis.jp/V201901/ConversionTracker}AppPlatform" minOccurs="0"/>
 *         &lt;element name="appConversionType" type="{http://ss.yahooapis.jp/V201901/ConversionTracker}AppConversionType" minOccurs="0"/>
 *         &lt;element name="snippetId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="snippetLabel" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="appPostbackUrl" type="{http://ss.yahooapis.jp/V201901/ConversionTracker}AppPostbackUrl" minOccurs="0"/>
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
    "appConversionType",
    "snippetId",
    "snippetLabel",
    "appPostbackUrl"
})
public class AppConversion
    extends ConversionTracker
{

    protected String appId;
    @XmlSchemaType(name = "string")
    protected AppPlatform appPlatform;
    @XmlSchemaType(name = "string")
    protected AppConversionType appConversionType;
    protected Long snippetId;
    protected String snippetLabel;
    protected AppPostbackUrl appPostbackUrl;

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

    /**
     * Gets the value of the snippetId property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getSnippetId() {
        return snippetId;
    }

    /**
     * Sets the value of the snippetId property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setSnippetId(Long value) {
        this.snippetId = value;
    }

    /**
     * Gets the value of the snippetLabel property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSnippetLabel() {
        return snippetLabel;
    }

    /**
     * Sets the value of the snippetLabel property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSnippetLabel(String value) {
        this.snippetLabel = value;
    }

    /**
     * Gets the value of the appPostbackUrl property.
     * 
     * @return
     *     possible object is
     *     {@link AppPostbackUrl }
     *     
     */
    public AppPostbackUrl getAppPostbackUrl() {
        return appPostbackUrl;
    }

    /**
     * Sets the value of the appPostbackUrl property.
     * 
     * @param value
     *     allowed object is
     *     {@link AppPostbackUrl }
     *     
     */
    public void setAppPostbackUrl(AppPostbackUrl value) {
        this.appPostbackUrl = value;
    }

}

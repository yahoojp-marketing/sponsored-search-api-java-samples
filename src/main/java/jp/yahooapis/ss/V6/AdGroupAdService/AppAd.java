
package jp.yahooapis.ss.V6.AdGroupAdService;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for AppAd complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="AppAd">
 *   &lt;complexContent>
 *     &lt;extension base="{http://ss.yahooapis.jp/V6}Ad">
 *       &lt;sequence>
 *         &lt;element name="description2" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="appStore" type="{http://ss.yahooapis.jp/V6}AppStore" minOccurs="0"/>
 *         &lt;element name="appId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="devicePreference" type="{http://ss.yahooapis.jp/V6}DevicePreference" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AppAd", propOrder = {
    "description2",
    "appStore",
    "appId",
    "devicePreference"
})
public class AppAd
    extends Ad
{

    protected String description2;
    @XmlSchemaType(name = "string")
    protected AppStore appStore;
    protected String appId;
    @XmlSchemaType(name = "string")
    protected DevicePreference devicePreference;

    /**
     * Gets the value of the description2 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDescription2() {
        return description2;
    }

    /**
     * Sets the value of the description2 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDescription2(String value) {
        this.description2 = value;
    }

    /**
     * Gets the value of the appStore property.
     * 
     * @return
     *     possible object is
     *     {@link AppStore }
     *     
     */
    public AppStore getAppStore() {
        return appStore;
    }

    /**
     * Sets the value of the appStore property.
     * 
     * @param value
     *     allowed object is
     *     {@link AppStore }
     *     
     */
    public void setAppStore(AppStore value) {
        this.appStore = value;
    }

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
     * Gets the value of the devicePreference property.
     * 
     * @return
     *     possible object is
     *     {@link DevicePreference }
     *     
     */
    public DevicePreference getDevicePreference() {
        return devicePreference;
    }

    /**
     * Sets the value of the devicePreference property.
     * 
     * @param value
     *     allowed object is
     *     {@link DevicePreference }
     *     
     */
    public void setDevicePreference(DevicePreference value) {
        this.devicePreference = value;
    }

}

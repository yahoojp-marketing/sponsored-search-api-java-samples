
package jp.yahooapis.ss.v201909.conversiontracker;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for AppPostbackUrl complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="AppPostbackUrl">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="url" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="clearFlag" type="{http://ss.yahooapis.jp/V201909/ConversionTracker}AppPostbackUrlClearFlag" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AppPostbackUrl", propOrder = {
    "url",
    "clearFlag"
})
public class AppPostbackUrl {

    protected String url;
    @XmlSchemaType(name = "string")
    protected AppPostbackUrlClearFlag clearFlag;

    /**
     * Gets the value of the url property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUrl() {
        return url;
    }

    /**
     * Sets the value of the url property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUrl(String value) {
        this.url = value;
    }

    /**
     * Gets the value of the clearFlag property.
     * 
     * @return
     *     possible object is
     *     {@link AppPostbackUrlClearFlag }
     *     
     */
    public AppPostbackUrlClearFlag getClearFlag() {
        return clearFlag;
    }

    /**
     * Sets the value of the clearFlag property.
     * 
     * @param value
     *     allowed object is
     *     {@link AppPostbackUrlClearFlag }
     *     
     */
    public void setClearFlag(AppPostbackUrlClearFlag value) {
        this.clearFlag = value;
    }

}

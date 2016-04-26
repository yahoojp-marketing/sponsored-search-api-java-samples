
package jp.yahooapis.ss.V6.BiddingStrategyService;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for SoapHeader complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="SoapHeader">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="license" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="apiAccountId" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="apiAccountPassword" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="accountId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="onBehalfOfAccountId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="onBehalfOfPassword" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SoapHeader", propOrder = {
    "license",
    "apiAccountId",
    "apiAccountPassword",
    "accountId",
    "onBehalfOfAccountId",
    "onBehalfOfPassword"
})
public class SoapHeader {

    @XmlElement(required = true)
    protected String license;
    @XmlElement(required = true)
    protected String apiAccountId;
    @XmlElement(required = true)
    protected String apiAccountPassword;
    protected Long accountId;
    protected String onBehalfOfAccountId;
    protected String onBehalfOfPassword;

    /**
     * Gets the value of the license property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLicense() {
        return license;
    }

    /**
     * Sets the value of the license property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLicense(String value) {
        this.license = value;
    }

    /**
     * Gets the value of the apiAccountId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getApiAccountId() {
        return apiAccountId;
    }

    /**
     * Sets the value of the apiAccountId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setApiAccountId(String value) {
        this.apiAccountId = value;
    }

    /**
     * Gets the value of the apiAccountPassword property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getApiAccountPassword() {
        return apiAccountPassword;
    }

    /**
     * Sets the value of the apiAccountPassword property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setApiAccountPassword(String value) {
        this.apiAccountPassword = value;
    }

    /**
     * Gets the value of the accountId property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getAccountId() {
        return accountId;
    }

    /**
     * Sets the value of the accountId property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setAccountId(Long value) {
        this.accountId = value;
    }

    /**
     * Gets the value of the onBehalfOfAccountId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOnBehalfOfAccountId() {
        return onBehalfOfAccountId;
    }

    /**
     * Sets the value of the onBehalfOfAccountId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOnBehalfOfAccountId(String value) {
        this.onBehalfOfAccountId = value;
    }

    /**
     * Gets the value of the onBehalfOfPassword property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOnBehalfOfPassword() {
        return onBehalfOfPassword;
    }

    /**
     * Sets the value of the onBehalfOfPassword property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOnBehalfOfPassword(String value) {
        this.onBehalfOfPassword = value;
    }

}

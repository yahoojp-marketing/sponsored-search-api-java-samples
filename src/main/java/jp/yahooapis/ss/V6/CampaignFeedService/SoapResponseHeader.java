
package jp.yahooapis.ss.V6.CampaignFeedService;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for SoapResponseHeader complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="SoapResponseHeader">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="service" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="remainingQuota" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="quotaUsedForThisRequest" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="timeTakenMillis" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SoapResponseHeader", propOrder = {
    "service",
    "remainingQuota",
    "quotaUsedForThisRequest",
    "timeTakenMillis"
})
public class SoapResponseHeader {

    protected String service;
    protected String remainingQuota;
    protected String quotaUsedForThisRequest;
    protected String timeTakenMillis;

    /**
     * Gets the value of the service property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getService() {
        return service;
    }

    /**
     * Sets the value of the service property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setService(String value) {
        this.service = value;
    }

    /**
     * Gets the value of the remainingQuota property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRemainingQuota() {
        return remainingQuota;
    }

    /**
     * Sets the value of the remainingQuota property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRemainingQuota(String value) {
        this.remainingQuota = value;
    }

    /**
     * Gets the value of the quotaUsedForThisRequest property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getQuotaUsedForThisRequest() {
        return quotaUsedForThisRequest;
    }

    /**
     * Sets the value of the quotaUsedForThisRequest property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setQuotaUsedForThisRequest(String value) {
        this.quotaUsedForThisRequest = value;
    }

    /**
     * Gets the value of the timeTakenMillis property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTimeTakenMillis() {
        return timeTakenMillis;
    }

    /**
     * Sets the value of the timeTakenMillis property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTimeTakenMillis(String value) {
        this.timeTakenMillis = value;
    }

}

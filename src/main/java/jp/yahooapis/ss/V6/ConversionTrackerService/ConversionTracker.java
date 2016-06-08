
package jp.yahooapis.ss.V6.ConversionTrackerService;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ConversionTracker complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ConversionTracker">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="accountId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="conversionTrackerId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="conversionTrackerName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="status" type="{http://ss.yahooapis.jp/V6}ConversionTrackerStatus" minOccurs="0"/>
 *         &lt;element name="category" type="{http://ss.yahooapis.jp/V6}ConversionTrackerCategory" minOccurs="0"/>
 *         &lt;element name="numConversionEvents" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="conversionValue" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="mostRecentConversionDate" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="numConvertedClicks" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="conversionTrackerType" type="{http://ss.yahooapis.jp/V6}ConversionTrackerType" minOccurs="0"/>
 *         &lt;element name="userRevenueValue" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ConversionTracker", propOrder = {
    "accountId",
    "conversionTrackerId",
    "conversionTrackerName",
    "status",
    "category",
    "numConversionEvents",
    "conversionValue",
    "mostRecentConversionDate",
    "numConvertedClicks",
    "conversionTrackerType",
    "userRevenueValue"
})
@XmlSeeAlso({
    AppConversion.class,
    WebConversion.class
})
public class ConversionTracker {

    protected Long accountId;
    protected Long conversionTrackerId;
    protected String conversionTrackerName;
    @XmlSchemaType(name = "string")
    protected ConversionTrackerStatus status;
    @XmlSchemaType(name = "string")
    protected ConversionTrackerCategory category;
    protected Integer numConversionEvents;
    protected Long conversionValue;
    protected String mostRecentConversionDate;
    protected Integer numConvertedClicks;
    @XmlSchemaType(name = "string")
    protected ConversionTrackerType conversionTrackerType;
    protected String userRevenueValue;

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
     * Gets the value of the conversionTrackerId property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getConversionTrackerId() {
        return conversionTrackerId;
    }

    /**
     * Sets the value of the conversionTrackerId property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setConversionTrackerId(Long value) {
        this.conversionTrackerId = value;
    }

    /**
     * Gets the value of the conversionTrackerName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getConversionTrackerName() {
        return conversionTrackerName;
    }

    /**
     * Sets the value of the conversionTrackerName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setConversionTrackerName(String value) {
        this.conversionTrackerName = value;
    }

    /**
     * Gets the value of the status property.
     * 
     * @return
     *     possible object is
     *     {@link ConversionTrackerStatus }
     *     
     */
    public ConversionTrackerStatus getStatus() {
        return status;
    }

    /**
     * Sets the value of the status property.
     * 
     * @param value
     *     allowed object is
     *     {@link ConversionTrackerStatus }
     *     
     */
    public void setStatus(ConversionTrackerStatus value) {
        this.status = value;
    }

    /**
     * Gets the value of the category property.
     * 
     * @return
     *     possible object is
     *     {@link ConversionTrackerCategory }
     *     
     */
    public ConversionTrackerCategory getCategory() {
        return category;
    }

    /**
     * Sets the value of the category property.
     * 
     * @param value
     *     allowed object is
     *     {@link ConversionTrackerCategory }
     *     
     */
    public void setCategory(ConversionTrackerCategory value) {
        this.category = value;
    }

    /**
     * Gets the value of the numConversionEvents property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getNumConversionEvents() {
        return numConversionEvents;
    }

    /**
     * Sets the value of the numConversionEvents property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setNumConversionEvents(Integer value) {
        this.numConversionEvents = value;
    }

    /**
     * Gets the value of the conversionValue property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getConversionValue() {
        return conversionValue;
    }

    /**
     * Sets the value of the conversionValue property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setConversionValue(Long value) {
        this.conversionValue = value;
    }

    /**
     * Gets the value of the mostRecentConversionDate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMostRecentConversionDate() {
        return mostRecentConversionDate;
    }

    /**
     * Sets the value of the mostRecentConversionDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMostRecentConversionDate(String value) {
        this.mostRecentConversionDate = value;
    }

    /**
     * Gets the value of the numConvertedClicks property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getNumConvertedClicks() {
        return numConvertedClicks;
    }

    /**
     * Sets the value of the numConvertedClicks property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setNumConvertedClicks(Integer value) {
        this.numConvertedClicks = value;
    }

    /**
     * Gets the value of the conversionTrackerType property.
     * 
     * @return
     *     possible object is
     *     {@link ConversionTrackerType }
     *     
     */
    public ConversionTrackerType getConversionTrackerType() {
        return conversionTrackerType;
    }

    /**
     * Sets the value of the conversionTrackerType property.
     * 
     * @param value
     *     allowed object is
     *     {@link ConversionTrackerType }
     *     
     */
    public void setConversionTrackerType(ConversionTrackerType value) {
        this.conversionTrackerType = value;
    }

    /**
     * Gets the value of the userRevenueValue property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUserRevenueValue() {
        return userRevenueValue;
    }

    /**
     * Sets the value of the userRevenueValue property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUserRevenueValue(String value) {
        this.userRevenueValue = value;
    }

}

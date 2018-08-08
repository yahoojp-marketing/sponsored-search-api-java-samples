
package jp.yahooapis.ss.v201808.conversiontracker;

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
 *         &lt;element name="status" type="{http://ss.yahooapis.jp/V201808/ConversionTracker}ConversionTrackerStatus" minOccurs="0"/>
 *         &lt;element name="category" type="{http://ss.yahooapis.jp/V201808/ConversionTracker}ConversionTrackerCategory" minOccurs="0"/>
 *         &lt;element name="conversions" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="conversionValue" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="allConversions" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="allConversionValue" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="mostRecentConversionDate" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="conversionTrackerType" type="{http://ss.yahooapis.jp/V201808/ConversionTracker}ConversionTrackerType" minOccurs="0"/>
 *         &lt;element name="userRevenueValue" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="countingType" type="{http://ss.yahooapis.jp/V201808/ConversionTracker}ConversionCountingType" minOccurs="0"/>
 *         &lt;element name="excludeFromBidding" type="{http://ss.yahooapis.jp/V201808/ConversionTracker}ExcludeFromBidding" minOccurs="0"/>
 *         &lt;element name="measurementPeriod" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
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
    "conversions",
    "conversionValue",
    "allConversions",
    "allConversionValue",
    "mostRecentConversionDate",
    "conversionTrackerType",
    "userRevenueValue",
    "countingType",
    "excludeFromBidding",
    "measurementPeriod"
})
@XmlSeeAlso({
    WebConversion.class,
    AppConversion.class
})
public class ConversionTracker {

    protected Long accountId;
    protected Long conversionTrackerId;
    protected String conversionTrackerName;
    @XmlSchemaType(name = "string")
    protected ConversionTrackerStatus status;
    @XmlSchemaType(name = "string")
    protected ConversionTrackerCategory category;
    protected Long conversions;
    protected String conversionValue;
    protected Long allConversions;
    protected String allConversionValue;
    protected String mostRecentConversionDate;
    @XmlSchemaType(name = "string")
    protected ConversionTrackerType conversionTrackerType;
    protected String userRevenueValue;
    @XmlSchemaType(name = "string")
    protected ConversionCountingType countingType;
    @XmlSchemaType(name = "string")
    protected ExcludeFromBidding excludeFromBidding;
    protected Integer measurementPeriod;

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
     * Gets the value of the conversions property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getConversions() {
        return conversions;
    }

    /**
     * Sets the value of the conversions property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setConversions(Long value) {
        this.conversions = value;
    }

    /**
     * Gets the value of the conversionValue property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getConversionValue() {
        return conversionValue;
    }

    /**
     * Sets the value of the conversionValue property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setConversionValue(String value) {
        this.conversionValue = value;
    }

    /**
     * Gets the value of the allConversions property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getAllConversions() {
        return allConversions;
    }

    /**
     * Sets the value of the allConversions property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setAllConversions(Long value) {
        this.allConversions = value;
    }

    /**
     * Gets the value of the allConversionValue property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAllConversionValue() {
        return allConversionValue;
    }

    /**
     * Sets the value of the allConversionValue property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAllConversionValue(String value) {
        this.allConversionValue = value;
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

    /**
     * Gets the value of the countingType property.
     * 
     * @return
     *     possible object is
     *     {@link ConversionCountingType }
     *     
     */
    public ConversionCountingType getCountingType() {
        return countingType;
    }

    /**
     * Sets the value of the countingType property.
     * 
     * @param value
     *     allowed object is
     *     {@link ConversionCountingType }
     *     
     */
    public void setCountingType(ConversionCountingType value) {
        this.countingType = value;
    }

    /**
     * Gets the value of the excludeFromBidding property.
     * 
     * @return
     *     possible object is
     *     {@link ExcludeFromBidding }
     *     
     */
    public ExcludeFromBidding getExcludeFromBidding() {
        return excludeFromBidding;
    }

    /**
     * Sets the value of the excludeFromBidding property.
     * 
     * @param value
     *     allowed object is
     *     {@link ExcludeFromBidding }
     *     
     */
    public void setExcludeFromBidding(ExcludeFromBidding value) {
        this.excludeFromBidding = value;
    }

    /**
     * Gets the value of the measurementPeriod property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getMeasurementPeriod() {
        return measurementPeriod;
    }

    /**
     * Sets the value of the measurementPeriod property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setMeasurementPeriod(Integer value) {
        this.measurementPeriod = value;
    }

}

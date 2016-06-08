
package jp.yahooapis.ss.V6.ConversionTrackerService;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ConversionTrackerSelector complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ConversionTrackerSelector">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="accountId" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="conversionTrackerIds" type="{http://www.w3.org/2001/XMLSchema}long" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="statuses" type="{http://ss.yahooapis.jp/V6}ConversionTrackerStatus" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="categories" type="{http://ss.yahooapis.jp/V6}ConversionTrackerCategory" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="conversionTrackerTypes" type="{http://ss.yahooapis.jp/V6}ConversionTrackerType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="trackingCodeTypes" type="{http://ss.yahooapis.jp/V6}TrackingCodeType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="dateRange" type="{http://ss.yahooapis.jp/V6}ConversionDateRange" minOccurs="0"/>
 *         &lt;element name="paging" type="{http://ss.yahooapis.jp/V6}Paging" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ConversionTrackerSelector", propOrder = {
    "accountId",
    "conversionTrackerIds",
    "statuses",
    "categories",
    "conversionTrackerTypes",
    "trackingCodeTypes",
    "dateRange",
    "paging"
})
public class ConversionTrackerSelector {

    protected long accountId;
    @XmlElement(type = Long.class)
    protected List<Long> conversionTrackerIds;
    @XmlSchemaType(name = "string")
    protected List<ConversionTrackerStatus> statuses;
    @XmlSchemaType(name = "string")
    protected List<ConversionTrackerCategory> categories;
    @XmlSchemaType(name = "string")
    protected List<ConversionTrackerType> conversionTrackerTypes;
    @XmlSchemaType(name = "string")
    protected List<TrackingCodeType> trackingCodeTypes;
    protected ConversionDateRange dateRange;
    protected Paging paging;

    /**
     * Gets the value of the accountId property.
     * 
     */
    public long getAccountId() {
        return accountId;
    }

    /**
     * Sets the value of the accountId property.
     * 
     */
    public void setAccountId(long value) {
        this.accountId = value;
    }

    /**
     * Gets the value of the conversionTrackerIds property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the conversionTrackerIds property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getConversionTrackerIds().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Long }
     * 
     * 
     */
    public List<Long> getConversionTrackerIds() {
        if (conversionTrackerIds == null) {
            conversionTrackerIds = new ArrayList<Long>();
        }
        return this.conversionTrackerIds;
    }

    /**
     * Gets the value of the statuses property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the statuses property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getStatuses().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ConversionTrackerStatus }
     * 
     * 
     */
    public List<ConversionTrackerStatus> getStatuses() {
        if (statuses == null) {
            statuses = new ArrayList<ConversionTrackerStatus>();
        }
        return this.statuses;
    }

    /**
     * Gets the value of the categories property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the categories property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getCategories().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ConversionTrackerCategory }
     * 
     * 
     */
    public List<ConversionTrackerCategory> getCategories() {
        if (categories == null) {
            categories = new ArrayList<ConversionTrackerCategory>();
        }
        return this.categories;
    }

    /**
     * Gets the value of the conversionTrackerTypes property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the conversionTrackerTypes property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getConversionTrackerTypes().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ConversionTrackerType }
     * 
     * 
     */
    public List<ConversionTrackerType> getConversionTrackerTypes() {
        if (conversionTrackerTypes == null) {
            conversionTrackerTypes = new ArrayList<ConversionTrackerType>();
        }
        return this.conversionTrackerTypes;
    }

    /**
     * Gets the value of the trackingCodeTypes property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the trackingCodeTypes property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getTrackingCodeTypes().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link TrackingCodeType }
     * 
     * 
     */
    public List<TrackingCodeType> getTrackingCodeTypes() {
        if (trackingCodeTypes == null) {
            trackingCodeTypes = new ArrayList<TrackingCodeType>();
        }
        return this.trackingCodeTypes;
    }

    /**
     * Gets the value of the dateRange property.
     * 
     * @return
     *     possible object is
     *     {@link ConversionDateRange }
     *     
     */
    public ConversionDateRange getDateRange() {
        return dateRange;
    }

    /**
     * Sets the value of the dateRange property.
     * 
     * @param value
     *     allowed object is
     *     {@link ConversionDateRange }
     *     
     */
    public void setDateRange(ConversionDateRange value) {
        this.dateRange = value;
    }

    /**
     * Gets the value of the paging property.
     * 
     * @return
     *     possible object is
     *     {@link Paging }
     *     
     */
    public Paging getPaging() {
        return paging;
    }

    /**
     * Sets the value of the paging property.
     * 
     * @param value
     *     allowed object is
     *     {@link Paging }
     *     
     */
    public void setPaging(Paging value) {
        this.paging = value;
    }

}

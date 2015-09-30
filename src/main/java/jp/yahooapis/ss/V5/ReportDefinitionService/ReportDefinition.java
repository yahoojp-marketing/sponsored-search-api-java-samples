
package jp.yahooapis.ss.V5.ReportDefinitionService;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ReportDefinition complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ReportDefinition">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="reportId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="accountId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="campaignIds" type="{http://www.w3.org/2001/XMLSchema}long" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="adGroupIds" type="{http://www.w3.org/2001/XMLSchema}long" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="kwIds" type="{http://www.w3.org/2001/XMLSchema}long" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="adIds" type="{http://www.w3.org/2001/XMLSchema}long" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="feedFolderIds" type="{http://www.w3.org/2001/XMLSchema}long" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="feedItemIds" type="{http://www.w3.org/2001/XMLSchema}long" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="biddingStrategyIds" type="{http://www.w3.org/2001/XMLSchema}long" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="reportName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="reportType" type="{http://ss.yahooapis.jp/V5}ReportType" minOccurs="0"/>
 *         &lt;element name="dateRangeType" type="{http://ss.yahooapis.jp/V5}ReportDateRangeType" minOccurs="0"/>
 *         &lt;element name="dateRange" type="{http://ss.yahooapis.jp/V5}ReportDateRange" minOccurs="0"/>
 *         &lt;element name="filters" type="{http://ss.yahooapis.jp/V5}ReportFilter" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="segments" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="sort" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="fields" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="format" type="{http://ss.yahooapis.jp/V5}ReportDownloadFormat" minOccurs="0"/>
 *         &lt;element name="encode" type="{http://ss.yahooapis.jp/V5}ReportDownloadEncode" minOccurs="0"/>
 *         &lt;element name="zip" type="{http://ss.yahooapis.jp/V5}ReportZip" minOccurs="0"/>
 *         &lt;element name="lang" type="{http://ss.yahooapis.jp/V5}ReportLang" minOccurs="0"/>
 *         &lt;element name="frequency" type="{http://ss.yahooapis.jp/V5}ReportFrequency" minOccurs="0"/>
 *         &lt;element name="specifyDay" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="addTemplate" type="{http://ss.yahooapis.jp/V5}ReportAddTemplate" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ReportDefinition", propOrder = {
    "reportId",
    "accountId",
    "campaignIds",
    "adGroupIds",
    "kwIds",
    "adIds",
    "feedFolderIds",
    "feedItemIds",
    "biddingStrategyIds",
    "reportName",
    "reportType",
    "dateRangeType",
    "dateRange",
    "filters",
    "segments",
    "sort",
    "fields",
    "format",
    "encode",
    "zip",
    "lang",
    "frequency",
    "specifyDay",
    "addTemplate"
})
public class ReportDefinition {

    protected Long reportId;
    protected Long accountId;
    @XmlElement(type = Long.class)
    protected List<Long> campaignIds;
    @XmlElement(type = Long.class)
    protected List<Long> adGroupIds;
    @XmlElement(type = Long.class)
    protected List<Long> kwIds;
    @XmlElement(type = Long.class)
    protected List<Long> adIds;
    @XmlElement(type = Long.class)
    protected List<Long> feedFolderIds;
    @XmlElement(type = Long.class)
    protected List<Long> feedItemIds;
    @XmlElement(type = Long.class)
    protected List<Long> biddingStrategyIds;
    protected String reportName;
    @XmlSchemaType(name = "string")
    protected ReportType reportType;
    @XmlSchemaType(name = "string")
    protected ReportDateRangeType dateRangeType;
    protected ReportDateRange dateRange;
    protected List<ReportFilter> filters;
    protected List<String> segments;
    protected String sort;
    protected List<String> fields;
    @XmlSchemaType(name = "string")
    protected ReportDownloadFormat format;
    @XmlSchemaType(name = "string")
    protected ReportDownloadEncode encode;
    @XmlSchemaType(name = "string")
    protected ReportZip zip;
    @XmlSchemaType(name = "string")
    protected ReportLang lang;
    @XmlSchemaType(name = "string")
    protected ReportFrequency frequency;
    protected Integer specifyDay;
    @XmlSchemaType(name = "string")
    protected ReportAddTemplate addTemplate;

    /**
     * Gets the value of the reportId property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getReportId() {
        return reportId;
    }

    /**
     * Sets the value of the reportId property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setReportId(Long value) {
        this.reportId = value;
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
     * Gets the value of the campaignIds property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the campaignIds property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getCampaignIds().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Long }
     * 
     * 
     */
    public List<Long> getCampaignIds() {
        if (campaignIds == null) {
            campaignIds = new ArrayList<Long>();
        }
        return this.campaignIds;
    }

    /**
     * Gets the value of the adGroupIds property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the adGroupIds property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAdGroupIds().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Long }
     * 
     * 
     */
    public List<Long> getAdGroupIds() {
        if (adGroupIds == null) {
            adGroupIds = new ArrayList<Long>();
        }
        return this.adGroupIds;
    }

    /**
     * Gets the value of the kwIds property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the kwIds property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getKwIds().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Long }
     * 
     * 
     */
    public List<Long> getKwIds() {
        if (kwIds == null) {
            kwIds = new ArrayList<Long>();
        }
        return this.kwIds;
    }

    /**
     * Gets the value of the adIds property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the adIds property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAdIds().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Long }
     * 
     * 
     */
    public List<Long> getAdIds() {
        if (adIds == null) {
            adIds = new ArrayList<Long>();
        }
        return this.adIds;
    }

    /**
     * Gets the value of the feedFolderIds property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the feedFolderIds property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getFeedFolderIds().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Long }
     * 
     * 
     */
    public List<Long> getFeedFolderIds() {
        if (feedFolderIds == null) {
            feedFolderIds = new ArrayList<Long>();
        }
        return this.feedFolderIds;
    }

    /**
     * Gets the value of the feedItemIds property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the feedItemIds property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getFeedItemIds().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Long }
     * 
     * 
     */
    public List<Long> getFeedItemIds() {
        if (feedItemIds == null) {
            feedItemIds = new ArrayList<Long>();
        }
        return this.feedItemIds;
    }

    /**
     * Gets the value of the biddingStrategyIds property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the biddingStrategyIds property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getBiddingStrategyIds().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Long }
     * 
     * 
     */
    public List<Long> getBiddingStrategyIds() {
        if (biddingStrategyIds == null) {
            biddingStrategyIds = new ArrayList<Long>();
        }
        return this.biddingStrategyIds;
    }

    /**
     * Gets the value of the reportName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getReportName() {
        return reportName;
    }

    /**
     * Sets the value of the reportName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setReportName(String value) {
        this.reportName = value;
    }

    /**
     * Gets the value of the reportType property.
     * 
     * @return
     *     possible object is
     *     {@link ReportType }
     *     
     */
    public ReportType getReportType() {
        return reportType;
    }

    /**
     * Sets the value of the reportType property.
     * 
     * @param value
     *     allowed object is
     *     {@link ReportType }
     *     
     */
    public void setReportType(ReportType value) {
        this.reportType = value;
    }

    /**
     * Gets the value of the dateRangeType property.
     * 
     * @return
     *     possible object is
     *     {@link ReportDateRangeType }
     *     
     */
    public ReportDateRangeType getDateRangeType() {
        return dateRangeType;
    }

    /**
     * Sets the value of the dateRangeType property.
     * 
     * @param value
     *     allowed object is
     *     {@link ReportDateRangeType }
     *     
     */
    public void setDateRangeType(ReportDateRangeType value) {
        this.dateRangeType = value;
    }

    /**
     * Gets the value of the dateRange property.
     * 
     * @return
     *     possible object is
     *     {@link ReportDateRange }
     *     
     */
    public ReportDateRange getDateRange() {
        return dateRange;
    }

    /**
     * Sets the value of the dateRange property.
     * 
     * @param value
     *     allowed object is
     *     {@link ReportDateRange }
     *     
     */
    public void setDateRange(ReportDateRange value) {
        this.dateRange = value;
    }

    /**
     * Gets the value of the filters property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the filters property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getFilters().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ReportFilter }
     * 
     * 
     */
    public List<ReportFilter> getFilters() {
        if (filters == null) {
            filters = new ArrayList<ReportFilter>();
        }
        return this.filters;
    }

    /**
     * Gets the value of the segments property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the segments property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSegments().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getSegments() {
        if (segments == null) {
            segments = new ArrayList<String>();
        }
        return this.segments;
    }

    /**
     * Gets the value of the sort property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSort() {
        return sort;
    }

    /**
     * Sets the value of the sort property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSort(String value) {
        this.sort = value;
    }

    /**
     * Gets the value of the fields property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the fields property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getFields().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getFields() {
        if (fields == null) {
            fields = new ArrayList<String>();
        }
        return this.fields;
    }

    /**
     * Gets the value of the format property.
     * 
     * @return
     *     possible object is
     *     {@link ReportDownloadFormat }
     *     
     */
    public ReportDownloadFormat getFormat() {
        return format;
    }

    /**
     * Sets the value of the format property.
     * 
     * @param value
     *     allowed object is
     *     {@link ReportDownloadFormat }
     *     
     */
    public void setFormat(ReportDownloadFormat value) {
        this.format = value;
    }

    /**
     * Gets the value of the encode property.
     * 
     * @return
     *     possible object is
     *     {@link ReportDownloadEncode }
     *     
     */
    public ReportDownloadEncode getEncode() {
        return encode;
    }

    /**
     * Sets the value of the encode property.
     * 
     * @param value
     *     allowed object is
     *     {@link ReportDownloadEncode }
     *     
     */
    public void setEncode(ReportDownloadEncode value) {
        this.encode = value;
    }

    /**
     * Gets the value of the zip property.
     * 
     * @return
     *     possible object is
     *     {@link ReportZip }
     *     
     */
    public ReportZip getZip() {
        return zip;
    }

    /**
     * Sets the value of the zip property.
     * 
     * @param value
     *     allowed object is
     *     {@link ReportZip }
     *     
     */
    public void setZip(ReportZip value) {
        this.zip = value;
    }

    /**
     * Gets the value of the lang property.
     * 
     * @return
     *     possible object is
     *     {@link ReportLang }
     *     
     */
    public ReportLang getLang() {
        return lang;
    }

    /**
     * Sets the value of the lang property.
     * 
     * @param value
     *     allowed object is
     *     {@link ReportLang }
     *     
     */
    public void setLang(ReportLang value) {
        this.lang = value;
    }

    /**
     * Gets the value of the frequency property.
     * 
     * @return
     *     possible object is
     *     {@link ReportFrequency }
     *     
     */
    public ReportFrequency getFrequency() {
        return frequency;
    }

    /**
     * Sets the value of the frequency property.
     * 
     * @param value
     *     allowed object is
     *     {@link ReportFrequency }
     *     
     */
    public void setFrequency(ReportFrequency value) {
        this.frequency = value;
    }

    /**
     * Gets the value of the specifyDay property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getSpecifyDay() {
        return specifyDay;
    }

    /**
     * Sets the value of the specifyDay property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setSpecifyDay(Integer value) {
        this.specifyDay = value;
    }

    /**
     * Gets the value of the addTemplate property.
     * 
     * @return
     *     possible object is
     *     {@link ReportAddTemplate }
     *     
     */
    public ReportAddTemplate getAddTemplate() {
        return addTemplate;
    }

    /**
     * Sets the value of the addTemplate property.
     * 
     * @param value
     *     allowed object is
     *     {@link ReportAddTemplate }
     *     
     */
    public void setAddTemplate(ReportAddTemplate value) {
        this.addTemplate = value;
    }

}

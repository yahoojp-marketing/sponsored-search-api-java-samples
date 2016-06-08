
package jp.yahooapis.ss.V6.ReportDefinitionService;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
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
 *         &lt;element name="accountId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="reportId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="reportName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="reportType" type="{http://ss.yahooapis.jp/V6}ReportType" minOccurs="0"/>
 *         &lt;element name="dateRangeType" type="{http://ss.yahooapis.jp/V6}ReportDateRangeType" minOccurs="0"/>
 *         &lt;element name="dateRange" type="{http://ss.yahooapis.jp/V6}ReportDateRange" minOccurs="0"/>
 *         &lt;element name="fields" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="sortFields" type="{http://ss.yahooapis.jp/V6}ReportSortField" minOccurs="0"/>
 *         &lt;element name="filters" type="{http://ss.yahooapis.jp/V6}ReportFilter" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="isTemplate" type="{http://ss.yahooapis.jp/V6}ReportIsTemplate" minOccurs="0"/>
 *         &lt;element name="intervalType" type="{http://ss.yahooapis.jp/V6}ReportIntervalType" minOccurs="0"/>
 *         &lt;element name="specifyDay" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="format" type="{http://ss.yahooapis.jp/V6}ReportDownloadFormat" minOccurs="0"/>
 *         &lt;element name="encode" type="{http://ss.yahooapis.jp/V6}ReportDownloadEncode" minOccurs="0"/>
 *         &lt;element name="language" type="{http://ss.yahooapis.jp/V6}ReportLanguage" minOccurs="0"/>
 *         &lt;element name="compress" type="{http://ss.yahooapis.jp/V6}ReportCompressType" minOccurs="0"/>
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
    "accountId",
    "reportId",
    "reportName",
    "reportType",
    "dateRangeType",
    "dateRange",
    "fields",
    "sortFields",
    "filters",
    "isTemplate",
    "intervalType",
    "specifyDay",
    "format",
    "encode",
    "language",
    "compress"
})
public class ReportDefinition {

    protected Long accountId;
    protected Long reportId;
    protected String reportName;
    @XmlSchemaType(name = "string")
    protected ReportType reportType;
    @XmlSchemaType(name = "string")
    protected ReportDateRangeType dateRangeType;
    protected ReportDateRange dateRange;
    protected List<String> fields;
    protected ReportSortField sortFields;
    protected List<ReportFilter> filters;
    @XmlSchemaType(name = "string")
    protected ReportIsTemplate isTemplate;
    @XmlSchemaType(name = "string")
    protected ReportIntervalType intervalType;
    protected Integer specifyDay;
    @XmlSchemaType(name = "string")
    protected ReportDownloadFormat format;
    @XmlSchemaType(name = "string")
    protected ReportDownloadEncode encode;
    @XmlSchemaType(name = "string")
    protected ReportLanguage language;
    @XmlSchemaType(name = "string")
    protected ReportCompressType compress;

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
     * Gets the value of the sortFields property.
     * 
     * @return
     *     possible object is
     *     {@link ReportSortField }
     *     
     */
    public ReportSortField getSortFields() {
        return sortFields;
    }

    /**
     * Sets the value of the sortFields property.
     * 
     * @param value
     *     allowed object is
     *     {@link ReportSortField }
     *     
     */
    public void setSortFields(ReportSortField value) {
        this.sortFields = value;
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
     * Gets the value of the isTemplate property.
     * 
     * @return
     *     possible object is
     *     {@link ReportIsTemplate }
     *     
     */
    public ReportIsTemplate getIsTemplate() {
        return isTemplate;
    }

    /**
     * Sets the value of the isTemplate property.
     * 
     * @param value
     *     allowed object is
     *     {@link ReportIsTemplate }
     *     
     */
    public void setIsTemplate(ReportIsTemplate value) {
        this.isTemplate = value;
    }

    /**
     * Gets the value of the intervalType property.
     * 
     * @return
     *     possible object is
     *     {@link ReportIntervalType }
     *     
     */
    public ReportIntervalType getIntervalType() {
        return intervalType;
    }

    /**
     * Sets the value of the intervalType property.
     * 
     * @param value
     *     allowed object is
     *     {@link ReportIntervalType }
     *     
     */
    public void setIntervalType(ReportIntervalType value) {
        this.intervalType = value;
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
     * Gets the value of the language property.
     * 
     * @return
     *     possible object is
     *     {@link ReportLanguage }
     *     
     */
    public ReportLanguage getLanguage() {
        return language;
    }

    /**
     * Sets the value of the language property.
     * 
     * @param value
     *     allowed object is
     *     {@link ReportLanguage }
     *     
     */
    public void setLanguage(ReportLanguage value) {
        this.language = value;
    }

    /**
     * Gets the value of the compress property.
     * 
     * @return
     *     possible object is
     *     {@link ReportCompressType }
     *     
     */
    public ReportCompressType getCompress() {
        return compress;
    }

    /**
     * Sets the value of the compress property.
     * 
     * @param value
     *     allowed object is
     *     {@link ReportCompressType }
     *     
     */
    public void setCompress(ReportCompressType value) {
        this.compress = value;
    }

}

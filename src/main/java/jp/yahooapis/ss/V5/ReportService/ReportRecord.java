
package jp.yahooapis.ss.V5.ReportService;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ReportRecord complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ReportRecord">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="accountId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="reportJobId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="reportId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="reportName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="requestTime" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="completeTime" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="dateRangeType" type="{http://ss.yahooapis.jp/V5}ReportDateRangeType" minOccurs="0"/>
 *         &lt;element name="dateRange" type="{http://ss.yahooapis.jp/V5}ReportDateRange" minOccurs="0"/>
 *         &lt;element name="status" type="{http://ss.yahooapis.jp/V5}ReportJobStatus" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ReportRecord", propOrder = {
    "accountId",
    "reportJobId",
    "reportId",
    "reportName",
    "requestTime",
    "completeTime",
    "dateRangeType",
    "dateRange",
    "status"
})
@XmlSeeAlso({
    ReportDownloadUrl.class
})
public class ReportRecord {

    protected Long accountId;
    protected Long reportJobId;
    protected Long reportId;
    protected String reportName;
    protected String requestTime;
    protected String completeTime;
    @XmlSchemaType(name = "string")
    protected ReportDateRangeType dateRangeType;
    protected ReportDateRange dateRange;
    @XmlSchemaType(name = "string")
    protected ReportJobStatus status;

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
     * Gets the value of the reportJobId property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getReportJobId() {
        return reportJobId;
    }

    /**
     * Sets the value of the reportJobId property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setReportJobId(Long value) {
        this.reportJobId = value;
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
     * Gets the value of the requestTime property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRequestTime() {
        return requestTime;
    }

    /**
     * Sets the value of the requestTime property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRequestTime(String value) {
        this.requestTime = value;
    }

    /**
     * Gets the value of the completeTime property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCompleteTime() {
        return completeTime;
    }

    /**
     * Sets the value of the completeTime property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCompleteTime(String value) {
        this.completeTime = value;
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
     * Gets the value of the status property.
     * 
     * @return
     *     possible object is
     *     {@link ReportJobStatus }
     *     
     */
    public ReportJobStatus getStatus() {
        return status;
    }

    /**
     * Sets the value of the status property.
     * 
     * @param value
     *     allowed object is
     *     {@link ReportJobStatus }
     *     
     */
    public void setStatus(ReportJobStatus value) {
        this.status = value;
    }

}

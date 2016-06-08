
package jp.yahooapis.ss.V6.ReportService;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSchemaType;
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
 *         &lt;element name="reportId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="reportJobId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="reportJobStatus" type="{http://ss.yahooapis.jp/V6}ReportJobStatus" minOccurs="0"/>
 *         &lt;element name="reportJobErrorDetail" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="requestTime" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="completeTime" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="reportDownloadURL" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
    "reportId",
    "reportJobId",
    "reportJobStatus",
    "reportJobErrorDetail",
    "requestTime",
    "completeTime",
    "reportDownloadURL"
})
public class ReportRecord {

    protected Long accountId;
    protected Long reportId;
    protected Long reportJobId;
    @XmlSchemaType(name = "string")
    protected ReportJobStatus reportJobStatus;
    protected String reportJobErrorDetail;
    protected String requestTime;
    protected String completeTime;
    protected String reportDownloadURL;

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
     * Gets the value of the reportJobStatus property.
     * 
     * @return
     *     possible object is
     *     {@link ReportJobStatus }
     *     
     */
    public ReportJobStatus getReportJobStatus() {
        return reportJobStatus;
    }

    /**
     * Sets the value of the reportJobStatus property.
     * 
     * @param value
     *     allowed object is
     *     {@link ReportJobStatus }
     *     
     */
    public void setReportJobStatus(ReportJobStatus value) {
        this.reportJobStatus = value;
    }

    /**
     * Gets the value of the reportJobErrorDetail property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getReportJobErrorDetail() {
        return reportJobErrorDetail;
    }

    /**
     * Sets the value of the reportJobErrorDetail property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setReportJobErrorDetail(String value) {
        this.reportJobErrorDetail = value;
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
     * Gets the value of the reportDownloadURL property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getReportDownloadURL() {
        return reportDownloadURL;
    }

    /**
     * Sets the value of the reportDownloadURL property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setReportDownloadURL(String value) {
        this.reportDownloadURL = value;
    }

}

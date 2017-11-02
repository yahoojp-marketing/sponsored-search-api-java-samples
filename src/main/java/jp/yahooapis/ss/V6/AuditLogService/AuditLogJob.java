
package jp.yahooapis.ss.V6.AuditLogService;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for AuditLogJob complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="AuditLogJob">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="accountId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="jobId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="jobName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="jobStatus" type="{http://ss.yahooapis.jp/V6}AuditLogJobStatus" minOccurs="0"/>
 *         &lt;element name="downloadUrl" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="eventSelector" type="{http://ss.yahooapis.jp/V6}EventSelector" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="dateRange" type="{http://ss.yahooapis.jp/V6}DateRange" minOccurs="0"/>
 *         &lt;element name="sourceType" type="{http://ss.yahooapis.jp/V6}AuditLogSourceType" minOccurs="0"/>
 *         &lt;element name="output" type="{http://ss.yahooapis.jp/V6}AuditLogOutput" minOccurs="0"/>
 *         &lt;element name="encoding" type="{http://ss.yahooapis.jp/V6}AuditLogEncoding" minOccurs="0"/>
 *         &lt;element name="lang" type="{http://ss.yahooapis.jp/V6}AuditLogLang" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AuditLogJob", propOrder = {
    "accountId",
    "jobId",
    "jobName",
    "jobStatus",
    "downloadUrl",
    "eventSelector",
    "dateRange",
    "sourceType",
    "output",
    "encoding",
    "lang"
})
public class AuditLogJob {

    protected Long accountId;
    protected Long jobId;
    protected String jobName;
    @XmlSchemaType(name = "string")
    protected AuditLogJobStatus jobStatus;
    protected String downloadUrl;
    protected List<EventSelector> eventSelector;
    protected DateRange dateRange;
    @XmlSchemaType(name = "string")
    protected AuditLogSourceType sourceType;
    @XmlSchemaType(name = "string")
    protected AuditLogOutput output;
    @XmlSchemaType(name = "string")
    protected AuditLogEncoding encoding;
    @XmlSchemaType(name = "string")
    protected AuditLogLang lang;

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
     * Gets the value of the jobId property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getJobId() {
        return jobId;
    }

    /**
     * Sets the value of the jobId property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setJobId(Long value) {
        this.jobId = value;
    }

    /**
     * Gets the value of the jobName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getJobName() {
        return jobName;
    }

    /**
     * Sets the value of the jobName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setJobName(String value) {
        this.jobName = value;
    }

    /**
     * Gets the value of the jobStatus property.
     * 
     * @return
     *     possible object is
     *     {@link AuditLogJobStatus }
     *     
     */
    public AuditLogJobStatus getJobStatus() {
        return jobStatus;
    }

    /**
     * Sets the value of the jobStatus property.
     * 
     * @param value
     *     allowed object is
     *     {@link AuditLogJobStatus }
     *     
     */
    public void setJobStatus(AuditLogJobStatus value) {
        this.jobStatus = value;
    }

    /**
     * Gets the value of the downloadUrl property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDownloadUrl() {
        return downloadUrl;
    }

    /**
     * Sets the value of the downloadUrl property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDownloadUrl(String value) {
        this.downloadUrl = value;
    }

    /**
     * Gets the value of the eventSelector property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the eventSelector property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getEventSelector().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link EventSelector }
     * 
     * 
     */
    public List<EventSelector> getEventSelector() {
        if (eventSelector == null) {
            eventSelector = new ArrayList<EventSelector>();
        }
        return this.eventSelector;
    }

    /**
     * Gets the value of the dateRange property.
     * 
     * @return
     *     possible object is
     *     {@link DateRange }
     *     
     */
    public DateRange getDateRange() {
        return dateRange;
    }

    /**
     * Sets the value of the dateRange property.
     * 
     * @param value
     *     allowed object is
     *     {@link DateRange }
     *     
     */
    public void setDateRange(DateRange value) {
        this.dateRange = value;
    }

    /**
     * Gets the value of the sourceType property.
     * 
     * @return
     *     possible object is
     *     {@link AuditLogSourceType }
     *     
     */
    public AuditLogSourceType getSourceType() {
        return sourceType;
    }

    /**
     * Sets the value of the sourceType property.
     * 
     * @param value
     *     allowed object is
     *     {@link AuditLogSourceType }
     *     
     */
    public void setSourceType(AuditLogSourceType value) {
        this.sourceType = value;
    }

    /**
     * Gets the value of the output property.
     * 
     * @return
     *     possible object is
     *     {@link AuditLogOutput }
     *     
     */
    public AuditLogOutput getOutput() {
        return output;
    }

    /**
     * Sets the value of the output property.
     * 
     * @param value
     *     allowed object is
     *     {@link AuditLogOutput }
     *     
     */
    public void setOutput(AuditLogOutput value) {
        this.output = value;
    }

    /**
     * Gets the value of the encoding property.
     * 
     * @return
     *     possible object is
     *     {@link AuditLogEncoding }
     *     
     */
    public AuditLogEncoding getEncoding() {
        return encoding;
    }

    /**
     * Sets the value of the encoding property.
     * 
     * @param value
     *     allowed object is
     *     {@link AuditLogEncoding }
     *     
     */
    public void setEncoding(AuditLogEncoding value) {
        this.encoding = value;
    }

    /**
     * Gets the value of the lang property.
     * 
     * @return
     *     possible object is
     *     {@link AuditLogLang }
     *     
     */
    public AuditLogLang getLang() {
        return lang;
    }

    /**
     * Sets the value of the lang property.
     * 
     * @param value
     *     allowed object is
     *     {@link AuditLogLang }
     *     
     */
    public void setLang(AuditLogLang value) {
        this.lang = value;
    }

}

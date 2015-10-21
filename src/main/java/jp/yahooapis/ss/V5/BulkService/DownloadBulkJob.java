
package jp.yahooapis.ss.V5.BulkService;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for DownloadBulkJob complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="DownloadBulkJob">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="accountId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="downloadBulkJobId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="downloadBulkJobName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="downloadBulkUserName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="downloadBulkStartDate" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="downloadBulkEndDate" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="downloadJobStatus" type="{http://ss.yahooapis.jp/V5}DownloadBulkJobStatus" minOccurs="0"/>
 *         &lt;element name="progress" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="downloadBulkDownloadUrl" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DownloadBulkJob", propOrder = {
    "accountId",
    "downloadBulkJobId",
    "downloadBulkJobName",
    "downloadBulkUserName",
    "downloadBulkStartDate",
    "downloadBulkEndDate",
    "downloadJobStatus",
    "progress",
    "downloadBulkDownloadUrl"
})
public class DownloadBulkJob {

    protected String accountId;
    protected String downloadBulkJobId;
    protected String downloadBulkJobName;
    protected String downloadBulkUserName;
    protected String downloadBulkStartDate;
    protected String downloadBulkEndDate;
    @XmlSchemaType(name = "string")
    protected DownloadBulkJobStatus downloadJobStatus;
    protected Integer progress;
    protected String downloadBulkDownloadUrl;

    /**
     * Gets the value of the accountId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAccountId() {
        return accountId;
    }

    /**
     * Sets the value of the accountId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAccountId(String value) {
        this.accountId = value;
    }

    /**
     * Gets the value of the downloadBulkJobId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDownloadBulkJobId() {
        return downloadBulkJobId;
    }

    /**
     * Sets the value of the downloadBulkJobId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDownloadBulkJobId(String value) {
        this.downloadBulkJobId = value;
    }

    /**
     * Gets the value of the downloadBulkJobName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDownloadBulkJobName() {
        return downloadBulkJobName;
    }

    /**
     * Sets the value of the downloadBulkJobName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDownloadBulkJobName(String value) {
        this.downloadBulkJobName = value;
    }

    /**
     * Gets the value of the downloadBulkUserName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDownloadBulkUserName() {
        return downloadBulkUserName;
    }

    /**
     * Sets the value of the downloadBulkUserName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDownloadBulkUserName(String value) {
        this.downloadBulkUserName = value;
    }

    /**
     * Gets the value of the downloadBulkStartDate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDownloadBulkStartDate() {
        return downloadBulkStartDate;
    }

    /**
     * Sets the value of the downloadBulkStartDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDownloadBulkStartDate(String value) {
        this.downloadBulkStartDate = value;
    }

    /**
     * Gets the value of the downloadBulkEndDate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDownloadBulkEndDate() {
        return downloadBulkEndDate;
    }

    /**
     * Sets the value of the downloadBulkEndDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDownloadBulkEndDate(String value) {
        this.downloadBulkEndDate = value;
    }

    /**
     * Gets the value of the downloadJobStatus property.
     * 
     * @return
     *     possible object is
     *     {@link DownloadBulkJobStatus }
     *     
     */
    public DownloadBulkJobStatus getDownloadJobStatus() {
        return downloadJobStatus;
    }

    /**
     * Sets the value of the downloadJobStatus property.
     * 
     * @param value
     *     allowed object is
     *     {@link DownloadBulkJobStatus }
     *     
     */
    public void setDownloadJobStatus(DownloadBulkJobStatus value) {
        this.downloadJobStatus = value;
    }

    /**
     * Gets the value of the progress property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getProgress() {
        return progress;
    }

    /**
     * Sets the value of the progress property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setProgress(Integer value) {
        this.progress = value;
    }

    /**
     * Gets the value of the downloadBulkDownloadUrl property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDownloadBulkDownloadUrl() {
        return downloadBulkDownloadUrl;
    }

    /**
     * Sets the value of the downloadBulkDownloadUrl property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDownloadBulkDownloadUrl(String value) {
        this.downloadBulkDownloadUrl = value;
    }

}

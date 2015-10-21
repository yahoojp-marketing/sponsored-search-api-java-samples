
package jp.yahooapis.ss.V5.BulkService;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for UploadBulkJob complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="UploadBulkJob">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="accountId" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="uploadBulkJobId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="uploadBulkJobName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="uploadBulkUserName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="uploadBulkStartDate" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="uploadBulkEndDate" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="uploadBulkJobStatus" type="{http://ss.yahooapis.jp/V5}UploadBulkJobStatus" minOccurs="0"/>
 *         &lt;element name="processingItemsCount" type="{http://ss.yahooapis.jp/V5}ProcessingItemsCount" minOccurs="0"/>
 *         &lt;element name="progress" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="downloadBulkUploadFileUrl" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="downloadBulkUploadErrorFileUrl" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "UploadBulkJob", propOrder = {
    "accountId",
    "uploadBulkJobId",
    "uploadBulkJobName",
    "uploadBulkUserName",
    "uploadBulkStartDate",
    "uploadBulkEndDate",
    "uploadBulkJobStatus",
    "processingItemsCount",
    "progress",
    "downloadBulkUploadFileUrl",
    "downloadBulkUploadErrorFileUrl"
})
public class UploadBulkJob {

    protected long accountId;
    protected Long uploadBulkJobId;
    protected String uploadBulkJobName;
    protected String uploadBulkUserName;
    protected String uploadBulkStartDate;
    protected String uploadBulkEndDate;
    @XmlSchemaType(name = "string")
    protected UploadBulkJobStatus uploadBulkJobStatus;
    protected ProcessingItemsCount processingItemsCount;
    protected Integer progress;
    protected String downloadBulkUploadFileUrl;
    protected String downloadBulkUploadErrorFileUrl;

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
     * Gets the value of the uploadBulkJobId property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getUploadBulkJobId() {
        return uploadBulkJobId;
    }

    /**
     * Sets the value of the uploadBulkJobId property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setUploadBulkJobId(Long value) {
        this.uploadBulkJobId = value;
    }

    /**
     * Gets the value of the uploadBulkJobName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUploadBulkJobName() {
        return uploadBulkJobName;
    }

    /**
     * Sets the value of the uploadBulkJobName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUploadBulkJobName(String value) {
        this.uploadBulkJobName = value;
    }

    /**
     * Gets the value of the uploadBulkUserName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUploadBulkUserName() {
        return uploadBulkUserName;
    }

    /**
     * Sets the value of the uploadBulkUserName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUploadBulkUserName(String value) {
        this.uploadBulkUserName = value;
    }

    /**
     * Gets the value of the uploadBulkStartDate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUploadBulkStartDate() {
        return uploadBulkStartDate;
    }

    /**
     * Sets the value of the uploadBulkStartDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUploadBulkStartDate(String value) {
        this.uploadBulkStartDate = value;
    }

    /**
     * Gets the value of the uploadBulkEndDate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUploadBulkEndDate() {
        return uploadBulkEndDate;
    }

    /**
     * Sets the value of the uploadBulkEndDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUploadBulkEndDate(String value) {
        this.uploadBulkEndDate = value;
    }

    /**
     * Gets the value of the uploadBulkJobStatus property.
     * 
     * @return
     *     possible object is
     *     {@link UploadBulkJobStatus }
     *     
     */
    public UploadBulkJobStatus getUploadBulkJobStatus() {
        return uploadBulkJobStatus;
    }

    /**
     * Sets the value of the uploadBulkJobStatus property.
     * 
     * @param value
     *     allowed object is
     *     {@link UploadBulkJobStatus }
     *     
     */
    public void setUploadBulkJobStatus(UploadBulkJobStatus value) {
        this.uploadBulkJobStatus = value;
    }

    /**
     * Gets the value of the processingItemsCount property.
     * 
     * @return
     *     possible object is
     *     {@link ProcessingItemsCount }
     *     
     */
    public ProcessingItemsCount getProcessingItemsCount() {
        return processingItemsCount;
    }

    /**
     * Sets the value of the processingItemsCount property.
     * 
     * @param value
     *     allowed object is
     *     {@link ProcessingItemsCount }
     *     
     */
    public void setProcessingItemsCount(ProcessingItemsCount value) {
        this.processingItemsCount = value;
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
     * Gets the value of the downloadBulkUploadFileUrl property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDownloadBulkUploadFileUrl() {
        return downloadBulkUploadFileUrl;
    }

    /**
     * Sets the value of the downloadBulkUploadFileUrl property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDownloadBulkUploadFileUrl(String value) {
        this.downloadBulkUploadFileUrl = value;
    }

    /**
     * Gets the value of the downloadBulkUploadErrorFileUrl property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDownloadBulkUploadErrorFileUrl() {
        return downloadBulkUploadErrorFileUrl;
    }

    /**
     * Sets the value of the downloadBulkUploadErrorFileUrl property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDownloadBulkUploadErrorFileUrl(String value) {
        this.downloadBulkUploadErrorFileUrl = value;
    }

}

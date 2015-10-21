
package jp.yahooapis.ss.V5.BulkService;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for UploadUrlValue complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="UploadUrlValue">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="accountId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="acceptableUploadStatus" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="uploadUrl" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "UploadUrlValue", propOrder = {
    "accountId",
    "acceptableUploadStatus",
    "uploadUrl"
})
public class UploadUrlValue {

    protected Long accountId;
    protected Boolean acceptableUploadStatus;
    protected String uploadUrl;

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
     * Gets the value of the acceptableUploadStatus property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isAcceptableUploadStatus() {
        return acceptableUploadStatus;
    }

    /**
     * Sets the value of the acceptableUploadStatus property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setAcceptableUploadStatus(Boolean value) {
        this.acceptableUploadStatus = value;
    }

    /**
     * Gets the value of the uploadUrl property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUploadUrl() {
        return uploadUrl;
    }

    /**
     * Sets the value of the uploadUrl property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUploadUrl(String value) {
        this.uploadUrl = value;
    }

}

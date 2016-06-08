
package jp.yahooapis.ss.V6.AccountTrackingURLService;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for AccountTrackingUrl complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="AccountTrackingUrl">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="accountId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="accountName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="trackingUrl" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="inReviewUrl" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="disapprovalReviewUrl" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="urlApprovalStatus" type="{http://ss.yahooapis.jp/V6}UrlApprovalStatus" minOccurs="0"/>
 *         &lt;element name="disapprovalReasonCodes" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AccountTrackingUrl", propOrder = {
    "accountId",
    "accountName",
    "trackingUrl",
    "inReviewUrl",
    "disapprovalReviewUrl",
    "urlApprovalStatus",
    "disapprovalReasonCodes"
})
public class AccountTrackingUrl {

    protected Long accountId;
    protected String accountName;
    protected String trackingUrl;
    protected String inReviewUrl;
    protected String disapprovalReviewUrl;
    @XmlSchemaType(name = "string")
    protected UrlApprovalStatus urlApprovalStatus;
    protected List<String> disapprovalReasonCodes;

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
     * Gets the value of the accountName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAccountName() {
        return accountName;
    }

    /**
     * Sets the value of the accountName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAccountName(String value) {
        this.accountName = value;
    }

    /**
     * Gets the value of the trackingUrl property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTrackingUrl() {
        return trackingUrl;
    }

    /**
     * Sets the value of the trackingUrl property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTrackingUrl(String value) {
        this.trackingUrl = value;
    }

    /**
     * Gets the value of the inReviewUrl property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getInReviewUrl() {
        return inReviewUrl;
    }

    /**
     * Sets the value of the inReviewUrl property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setInReviewUrl(String value) {
        this.inReviewUrl = value;
    }

    /**
     * Gets the value of the disapprovalReviewUrl property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDisapprovalReviewUrl() {
        return disapprovalReviewUrl;
    }

    /**
     * Sets the value of the disapprovalReviewUrl property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDisapprovalReviewUrl(String value) {
        this.disapprovalReviewUrl = value;
    }

    /**
     * Gets the value of the urlApprovalStatus property.
     * 
     * @return
     *     possible object is
     *     {@link UrlApprovalStatus }
     *     
     */
    public UrlApprovalStatus getUrlApprovalStatus() {
        return urlApprovalStatus;
    }

    /**
     * Sets the value of the urlApprovalStatus property.
     * 
     * @param value
     *     allowed object is
     *     {@link UrlApprovalStatus }
     *     
     */
    public void setUrlApprovalStatus(UrlApprovalStatus value) {
        this.urlApprovalStatus = value;
    }

    /**
     * Gets the value of the disapprovalReasonCodes property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the disapprovalReasonCodes property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getDisapprovalReasonCodes().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getDisapprovalReasonCodes() {
        if (disapprovalReasonCodes == null) {
            disapprovalReasonCodes = new ArrayList<String>();
        }
        return this.disapprovalReasonCodes;
    }

}

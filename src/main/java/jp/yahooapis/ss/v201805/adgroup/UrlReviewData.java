
package jp.yahooapis.ss.v201805.adgroup;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for UrlReviewData complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="UrlReviewData">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="inReviewUrl" type="{http://ss.yahooapis.jp/V201805/AdGroup}ReviewUrl" minOccurs="0"/>
 *         &lt;element name="disapprovalReviewUrl" type="{http://ss.yahooapis.jp/V201805/AdGroup}ReviewUrl" minOccurs="0"/>
 *         &lt;element name="urlApprovalStatus" type="{http://ss.yahooapis.jp/V201805/AdGroup}UrlApprovalStatus" minOccurs="0"/>
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
@XmlType(name = "UrlReviewData", propOrder = {
    "inReviewUrl",
    "disapprovalReviewUrl",
    "urlApprovalStatus",
    "disapprovalReasonCodes"
})
public class UrlReviewData {

    protected ReviewUrl inReviewUrl;
    protected ReviewUrl disapprovalReviewUrl;
    @XmlSchemaType(name = "string")
    protected UrlApprovalStatus urlApprovalStatus;
    protected List<String> disapprovalReasonCodes;

    /**
     * Gets the value of the inReviewUrl property.
     * 
     * @return
     *     possible object is
     *     {@link ReviewUrl }
     *     
     */
    public ReviewUrl getInReviewUrl() {
        return inReviewUrl;
    }

    /**
     * Sets the value of the inReviewUrl property.
     * 
     * @param value
     *     allowed object is
     *     {@link ReviewUrl }
     *     
     */
    public void setInReviewUrl(ReviewUrl value) {
        this.inReviewUrl = value;
    }

    /**
     * Gets the value of the disapprovalReviewUrl property.
     * 
     * @return
     *     possible object is
     *     {@link ReviewUrl }
     *     
     */
    public ReviewUrl getDisapprovalReviewUrl() {
        return disapprovalReviewUrl;
    }

    /**
     * Sets the value of the disapprovalReviewUrl property.
     * 
     * @param value
     *     allowed object is
     *     {@link ReviewUrl }
     *     
     */
    public void setDisapprovalReviewUrl(ReviewUrl value) {
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


package jp.yahooapis.ss.V6.RetargetingListService;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for RetargetingAccountStatus complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="RetargetingAccountStatus">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="agreeDate" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="reviewStatus" type="{http://ss.yahooapis.jp/V6}ReviewStatus" minOccurs="0"/>
 *         &lt;element name="reviewRequestDate" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "RetargetingAccountStatus", propOrder = {
    "agreeDate",
    "reviewStatus",
    "reviewRequestDate"
})
public class RetargetingAccountStatus {

    protected String agreeDate;
    @XmlSchemaType(name = "string")
    protected ReviewStatus reviewStatus;
    protected String reviewRequestDate;

    /**
     * Gets the value of the agreeDate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAgreeDate() {
        return agreeDate;
    }

    /**
     * Sets the value of the agreeDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAgreeDate(String value) {
        this.agreeDate = value;
    }

    /**
     * Gets the value of the reviewStatus property.
     * 
     * @return
     *     possible object is
     *     {@link ReviewStatus }
     *     
     */
    public ReviewStatus getReviewStatus() {
        return reviewStatus;
    }

    /**
     * Sets the value of the reviewStatus property.
     * 
     * @param value
     *     allowed object is
     *     {@link ReviewStatus }
     *     
     */
    public void setReviewStatus(ReviewStatus value) {
        this.reviewStatus = value;
    }

    /**
     * Gets the value of the reviewRequestDate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getReviewRequestDate() {
        return reviewRequestDate;
    }

    /**
     * Sets the value of the reviewRequestDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setReviewRequestDate(String value) {
        this.reviewRequestDate = value;
    }

}


package jp.yahooapis.ss.v201808.pagefeeditem;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for PageFeedItemReviewSummary complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="PageFeedItemReviewSummary">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="accountId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="feedFolderId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="entityCount" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="approvedCount" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="approvedWithReviewCount" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="reviewCount" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="preDisapprovedCount" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="postDisapprovedCount" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PageFeedItemReviewSummary", propOrder = {
    "accountId",
    "feedFolderId",
    "entityCount",
    "approvedCount",
    "approvedWithReviewCount",
    "reviewCount",
    "preDisapprovedCount",
    "postDisapprovedCount"
})
public class PageFeedItemReviewSummary {

    protected Long accountId;
    protected Long feedFolderId;
    protected Long entityCount;
    protected Long approvedCount;
    protected Long approvedWithReviewCount;
    protected Long reviewCount;
    protected Long preDisapprovedCount;
    protected Long postDisapprovedCount;

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
     * Gets the value of the feedFolderId property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getFeedFolderId() {
        return feedFolderId;
    }

    /**
     * Sets the value of the feedFolderId property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setFeedFolderId(Long value) {
        this.feedFolderId = value;
    }

    /**
     * Gets the value of the entityCount property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getEntityCount() {
        return entityCount;
    }

    /**
     * Sets the value of the entityCount property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setEntityCount(Long value) {
        this.entityCount = value;
    }

    /**
     * Gets the value of the approvedCount property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getApprovedCount() {
        return approvedCount;
    }

    /**
     * Sets the value of the approvedCount property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setApprovedCount(Long value) {
        this.approvedCount = value;
    }

    /**
     * Gets the value of the approvedWithReviewCount property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getApprovedWithReviewCount() {
        return approvedWithReviewCount;
    }

    /**
     * Sets the value of the approvedWithReviewCount property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setApprovedWithReviewCount(Long value) {
        this.approvedWithReviewCount = value;
    }

    /**
     * Gets the value of the reviewCount property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getReviewCount() {
        return reviewCount;
    }

    /**
     * Sets the value of the reviewCount property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setReviewCount(Long value) {
        this.reviewCount = value;
    }

    /**
     * Gets the value of the preDisapprovedCount property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getPreDisapprovedCount() {
        return preDisapprovedCount;
    }

    /**
     * Sets the value of the preDisapprovedCount property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setPreDisapprovedCount(Long value) {
        this.preDisapprovedCount = value;
    }

    /**
     * Gets the value of the postDisapprovedCount property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getPostDisapprovedCount() {
        return postDisapprovedCount;
    }

    /**
     * Sets the value of the postDisapprovedCount property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setPostDisapprovedCount(Long value) {
        this.postDisapprovedCount = value;
    }

}

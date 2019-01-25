
package jp.yahooapis.ss.v201901.pagefeeditem;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for PageFeedItem complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="PageFeedItem">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="accountId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="feedFolderId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="pageFeedItemId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="approvalStatus" type="{http://ss.yahooapis.jp/V201901/PageFeedItem}PageFeedItemApprovalStatus" minOccurs="0"/>
 *         &lt;element name="disapprovalReasonCodes" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="disapprovalReasonComment" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="pageFeedUrl" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="pageFeedCustomLabel" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PageFeedItem", propOrder = {
    "accountId",
    "feedFolderId",
    "pageFeedItemId",
    "approvalStatus",
    "disapprovalReasonCodes",
    "disapprovalReasonComment",
    "pageFeedUrl",
    "pageFeedCustomLabel"
})
public class PageFeedItem {

    protected Long accountId;
    protected Long feedFolderId;
    protected Long pageFeedItemId;
    @XmlSchemaType(name = "string")
    protected PageFeedItemApprovalStatus approvalStatus;
    protected List<String> disapprovalReasonCodes;
    protected String disapprovalReasonComment;
    protected String pageFeedUrl;
    protected String pageFeedCustomLabel;

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
     * Gets the value of the pageFeedItemId property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getPageFeedItemId() {
        return pageFeedItemId;
    }

    /**
     * Sets the value of the pageFeedItemId property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setPageFeedItemId(Long value) {
        this.pageFeedItemId = value;
    }

    /**
     * Gets the value of the approvalStatus property.
     * 
     * @return
     *     possible object is
     *     {@link PageFeedItemApprovalStatus }
     *     
     */
    public PageFeedItemApprovalStatus getApprovalStatus() {
        return approvalStatus;
    }

    /**
     * Sets the value of the approvalStatus property.
     * 
     * @param value
     *     allowed object is
     *     {@link PageFeedItemApprovalStatus }
     *     
     */
    public void setApprovalStatus(PageFeedItemApprovalStatus value) {
        this.approvalStatus = value;
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

    /**
     * Gets the value of the disapprovalReasonComment property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDisapprovalReasonComment() {
        return disapprovalReasonComment;
    }

    /**
     * Sets the value of the disapprovalReasonComment property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDisapprovalReasonComment(String value) {
        this.disapprovalReasonComment = value;
    }

    /**
     * Gets the value of the pageFeedUrl property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPageFeedUrl() {
        return pageFeedUrl;
    }

    /**
     * Sets the value of the pageFeedUrl property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPageFeedUrl(String value) {
        this.pageFeedUrl = value;
    }

    /**
     * Gets the value of the pageFeedCustomLabel property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPageFeedCustomLabel() {
        return pageFeedCustomLabel;
    }

    /**
     * Sets the value of the pageFeedCustomLabel property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPageFeedCustomLabel(String value) {
        this.pageFeedCustomLabel = value;
    }

}

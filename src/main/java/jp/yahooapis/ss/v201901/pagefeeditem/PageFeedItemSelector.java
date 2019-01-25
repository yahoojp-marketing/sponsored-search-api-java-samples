
package jp.yahooapis.ss.v201901.pagefeeditem;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import jp.yahooapis.ss.v201901.Paging;


/**
 * <p>Java class for PageFeedItemSelector complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="PageFeedItemSelector">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="accountId" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="feedFolderIds" type="{http://www.w3.org/2001/XMLSchema}long" maxOccurs="unbounded"/>
 *         &lt;element name="approvalStatuses" type="{http://ss.yahooapis.jp/V201901/PageFeedItem}PageFeedItemApprovalStatus" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="pageFeedUrl" type="{http://ss.yahooapis.jp/V201901/PageFeedItem}PageFeedUrl" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="pageFeedCustomLabel" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="paging" type="{http://ss.yahooapis.jp/V201901}Paging" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PageFeedItemSelector", propOrder = {
    "accountId",
    "feedFolderIds",
    "approvalStatuses",
    "pageFeedUrl",
    "pageFeedCustomLabel",
    "paging"
})
public class PageFeedItemSelector {

    protected long accountId;
    @XmlElement(type = Long.class)
    protected List<Long> feedFolderIds;
    @XmlSchemaType(name = "string")
    protected List<PageFeedItemApprovalStatus> approvalStatuses;
    protected List<PageFeedUrl> pageFeedUrl;
    protected List<String> pageFeedCustomLabel;
    protected Paging paging;

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
     * Gets the value of the feedFolderIds property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the feedFolderIds property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getFeedFolderIds().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Long }
     * 
     * 
     */
    public List<Long> getFeedFolderIds() {
        if (feedFolderIds == null) {
            feedFolderIds = new ArrayList<Long>();
        }
        return this.feedFolderIds;
    }

    /**
     * Gets the value of the approvalStatuses property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the approvalStatuses property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getApprovalStatuses().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link PageFeedItemApprovalStatus }
     * 
     * 
     */
    public List<PageFeedItemApprovalStatus> getApprovalStatuses() {
        if (approvalStatuses == null) {
            approvalStatuses = new ArrayList<PageFeedItemApprovalStatus>();
        }
        return this.approvalStatuses;
    }

    /**
     * Gets the value of the pageFeedUrl property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the pageFeedUrl property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getPageFeedUrl().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link PageFeedUrl }
     * 
     * 
     */
    public List<PageFeedUrl> getPageFeedUrl() {
        if (pageFeedUrl == null) {
            pageFeedUrl = new ArrayList<PageFeedUrl>();
        }
        return this.pageFeedUrl;
    }

    /**
     * Gets the value of the pageFeedCustomLabel property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the pageFeedCustomLabel property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getPageFeedCustomLabel().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getPageFeedCustomLabel() {
        if (pageFeedCustomLabel == null) {
            pageFeedCustomLabel = new ArrayList<String>();
        }
        return this.pageFeedCustomLabel;
    }

    /**
     * Gets the value of the paging property.
     * 
     * @return
     *     possible object is
     *     {@link Paging }
     *     
     */
    public Paging getPaging() {
        return paging;
    }

    /**
     * Sets the value of the paging property.
     * 
     * @param value
     *     allowed object is
     *     {@link Paging }
     *     
     */
    public void setPaging(Paging value) {
        this.paging = value;
    }

}

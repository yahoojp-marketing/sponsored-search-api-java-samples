
package jp.yahooapis.ss.V6.FeedItemService;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for FeedItemSelector complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="FeedItemSelector">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="accountId" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="feedItemIds" type="{http://www.w3.org/2001/XMLSchema}long" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="placeholderTypes" type="{http://ss.yahooapis.jp/V6}FeedItemPlaceholderType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="approvalStatuses" type="{http://ss.yahooapis.jp/V6}ApprovalStatus" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="advanced" type="{http://ss.yahooapis.jp/V6}Advanced" minOccurs="0"/>
 *         &lt;element name="paging" type="{http://ss.yahooapis.jp/V6}Paging" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "FeedItemSelector", propOrder = {
    "accountId",
    "feedItemIds",
    "placeholderTypes",
    "approvalStatuses",
    "advanced",
    "paging"
})
public class FeedItemSelector {

    protected long accountId;
    @XmlElement(type = Long.class)
    protected List<Long> feedItemIds;
    @XmlSchemaType(name = "string")
    protected List<FeedItemPlaceholderType> placeholderTypes;
    @XmlSchemaType(name = "string")
    protected List<ApprovalStatus> approvalStatuses;
    @XmlSchemaType(name = "string")
    protected Advanced advanced;
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
     * Gets the value of the feedItemIds property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the feedItemIds property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getFeedItemIds().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Long }
     * 
     * 
     */
    public List<Long> getFeedItemIds() {
        if (feedItemIds == null) {
            feedItemIds = new ArrayList<Long>();
        }
        return this.feedItemIds;
    }

    /**
     * Gets the value of the placeholderTypes property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the placeholderTypes property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getPlaceholderTypes().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link FeedItemPlaceholderType }
     * 
     * 
     */
    public List<FeedItemPlaceholderType> getPlaceholderTypes() {
        if (placeholderTypes == null) {
            placeholderTypes = new ArrayList<FeedItemPlaceholderType>();
        }
        return this.placeholderTypes;
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
     * {@link ApprovalStatus }
     * 
     * 
     */
    public List<ApprovalStatus> getApprovalStatuses() {
        if (approvalStatuses == null) {
            approvalStatuses = new ArrayList<ApprovalStatus>();
        }
        return this.approvalStatuses;
    }

    /**
     * Gets the value of the advanced property.
     * 
     * @return
     *     possible object is
     *     {@link Advanced }
     *     
     */
    public Advanced getAdvanced() {
        return advanced;
    }

    /**
     * Sets the value of the advanced property.
     * 
     * @param value
     *     allowed object is
     *     {@link Advanced }
     *     
     */
    public void setAdvanced(Advanced value) {
        this.advanced = value;
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

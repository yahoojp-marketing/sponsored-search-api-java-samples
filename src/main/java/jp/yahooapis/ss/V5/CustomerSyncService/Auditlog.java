
package jp.yahooapis.ss.V5.CustomerSyncService;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for Auditlog complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Auditlog">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="updatedTime" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="entityType" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="eventType" type="{http://ss.yahooapis.jp/V5}EventType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="sourceType" type="{http://ss.yahooapis.jp/V5}SourceType" minOccurs="0"/>
 *         &lt;element name="accountId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="campaignId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="adGroupId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="criterionId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="adId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="feedItemId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="biddingStrategyId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Auditlog", propOrder = {
    "updatedTime",
    "entityType",
    "eventType",
    "sourceType",
    "accountId",
    "campaignId",
    "adGroupId",
    "criterionId",
    "adId",
    "feedItemId",
    "biddingStrategyId"
})
public class Auditlog {

    protected String updatedTime;
    protected String entityType;
    @XmlSchemaType(name = "string")
    protected List<EventType> eventType;
    @XmlSchemaType(name = "string")
    protected SourceType sourceType;
    protected Long accountId;
    protected Long campaignId;
    protected Long adGroupId;
    protected Long criterionId;
    protected Long adId;
    protected Long feedItemId;
    protected Long biddingStrategyId;

    /**
     * Gets the value of the updatedTime property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUpdatedTime() {
        return updatedTime;
    }

    /**
     * Sets the value of the updatedTime property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUpdatedTime(String value) {
        this.updatedTime = value;
    }

    /**
     * Gets the value of the entityType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEntityType() {
        return entityType;
    }

    /**
     * Sets the value of the entityType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEntityType(String value) {
        this.entityType = value;
    }

    /**
     * Gets the value of the eventType property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the eventType property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getEventType().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link EventType }
     * 
     * 
     */
    public List<EventType> getEventType() {
        if (eventType == null) {
            eventType = new ArrayList<EventType>();
        }
        return this.eventType;
    }

    /**
     * Gets the value of the sourceType property.
     * 
     * @return
     *     possible object is
     *     {@link SourceType }
     *     
     */
    public SourceType getSourceType() {
        return sourceType;
    }

    /**
     * Sets the value of the sourceType property.
     * 
     * @param value
     *     allowed object is
     *     {@link SourceType }
     *     
     */
    public void setSourceType(SourceType value) {
        this.sourceType = value;
    }

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
     * Gets the value of the campaignId property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getCampaignId() {
        return campaignId;
    }

    /**
     * Sets the value of the campaignId property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setCampaignId(Long value) {
        this.campaignId = value;
    }

    /**
     * Gets the value of the adGroupId property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getAdGroupId() {
        return adGroupId;
    }

    /**
     * Sets the value of the adGroupId property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setAdGroupId(Long value) {
        this.adGroupId = value;
    }

    /**
     * Gets the value of the criterionId property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getCriterionId() {
        return criterionId;
    }

    /**
     * Sets the value of the criterionId property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setCriterionId(Long value) {
        this.criterionId = value;
    }

    /**
     * Gets the value of the adId property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getAdId() {
        return adId;
    }

    /**
     * Sets the value of the adId property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setAdId(Long value) {
        this.adId = value;
    }

    /**
     * Gets the value of the feedItemId property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getFeedItemId() {
        return feedItemId;
    }

    /**
     * Sets the value of the feedItemId property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setFeedItemId(Long value) {
        this.feedItemId = value;
    }

    /**
     * Gets the value of the biddingStrategyId property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getBiddingStrategyId() {
        return biddingStrategyId;
    }

    /**
     * Sets the value of the biddingStrategyId property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setBiddingStrategyId(Long value) {
        this.biddingStrategyId = value;
    }

}

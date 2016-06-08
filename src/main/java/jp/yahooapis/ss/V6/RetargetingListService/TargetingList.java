
package jp.yahooapis.ss.V6.RetargetingListService;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for TargetingList complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="TargetingList">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="accountId" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="retargetingAccountStatus" type="{http://ss.yahooapis.jp/V6}RetargetingAccountStatus" minOccurs="0"/>
 *         &lt;element name="targetListId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="targetListType" type="{http://ss.yahooapis.jp/V6}TargetListType"/>
 *         &lt;element name="targetListName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="targetListDescription" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="reachStorageStatus" type="{http://ss.yahooapis.jp/V6}ReachStorageStatus" minOccurs="0"/>
 *         &lt;element name="reachStorageSpan" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="reach" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="targetListTrackId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TargetingList", propOrder = {
    "accountId",
    "retargetingAccountStatus",
    "targetListId",
    "targetListType",
    "targetListName",
    "targetListDescription",
    "reachStorageStatus",
    "reachStorageSpan",
    "reach",
    "targetListTrackId"
})
@XmlSeeAlso({
    RuleBaseTargetList.class,
    LogicalTargetList.class,
    DefaultTargetList.class
})
public class TargetingList {

    protected long accountId;
    protected RetargetingAccountStatus retargetingAccountStatus;
    protected Long targetListId;
    @XmlElement(required = true)
    @XmlSchemaType(name = "string")
    protected TargetListType targetListType;
    protected String targetListName;
    protected String targetListDescription;
    @XmlSchemaType(name = "string")
    protected ReachStorageStatus reachStorageStatus;
    protected Long reachStorageSpan;
    protected Long reach;
    protected Long targetListTrackId;

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
     * Gets the value of the retargetingAccountStatus property.
     * 
     * @return
     *     possible object is
     *     {@link RetargetingAccountStatus }
     *     
     */
    public RetargetingAccountStatus getRetargetingAccountStatus() {
        return retargetingAccountStatus;
    }

    /**
     * Sets the value of the retargetingAccountStatus property.
     * 
     * @param value
     *     allowed object is
     *     {@link RetargetingAccountStatus }
     *     
     */
    public void setRetargetingAccountStatus(RetargetingAccountStatus value) {
        this.retargetingAccountStatus = value;
    }

    /**
     * Gets the value of the targetListId property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getTargetListId() {
        return targetListId;
    }

    /**
     * Sets the value of the targetListId property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setTargetListId(Long value) {
        this.targetListId = value;
    }

    /**
     * Gets the value of the targetListType property.
     * 
     * @return
     *     possible object is
     *     {@link TargetListType }
     *     
     */
    public TargetListType getTargetListType() {
        return targetListType;
    }

    /**
     * Sets the value of the targetListType property.
     * 
     * @param value
     *     allowed object is
     *     {@link TargetListType }
     *     
     */
    public void setTargetListType(TargetListType value) {
        this.targetListType = value;
    }

    /**
     * Gets the value of the targetListName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTargetListName() {
        return targetListName;
    }

    /**
     * Sets the value of the targetListName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTargetListName(String value) {
        this.targetListName = value;
    }

    /**
     * Gets the value of the targetListDescription property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTargetListDescription() {
        return targetListDescription;
    }

    /**
     * Sets the value of the targetListDescription property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTargetListDescription(String value) {
        this.targetListDescription = value;
    }

    /**
     * Gets the value of the reachStorageStatus property.
     * 
     * @return
     *     possible object is
     *     {@link ReachStorageStatus }
     *     
     */
    public ReachStorageStatus getReachStorageStatus() {
        return reachStorageStatus;
    }

    /**
     * Sets the value of the reachStorageStatus property.
     * 
     * @param value
     *     allowed object is
     *     {@link ReachStorageStatus }
     *     
     */
    public void setReachStorageStatus(ReachStorageStatus value) {
        this.reachStorageStatus = value;
    }

    /**
     * Gets the value of the reachStorageSpan property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getReachStorageSpan() {
        return reachStorageSpan;
    }

    /**
     * Sets the value of the reachStorageSpan property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setReachStorageSpan(Long value) {
        this.reachStorageSpan = value;
    }

    /**
     * Gets the value of the reach property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getReach() {
        return reach;
    }

    /**
     * Sets the value of the reach property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setReach(Long value) {
        this.reach = value;
    }

    /**
     * Gets the value of the targetListTrackId property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getTargetListTrackId() {
        return targetListTrackId;
    }

    /**
     * Sets the value of the targetListTrackId property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setTargetListTrackId(Long value) {
        this.targetListTrackId = value;
    }

}

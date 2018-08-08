
package jp.yahooapis.ss.v201808.campaignretargetinglist;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for CampaignRetargetingList complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="CampaignRetargetingList">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="accountId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="campaignId" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="campaignName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="criterionTargetList" type="{http://ss.yahooapis.jp/V201808/CampaignRetargetingList}CriterionTargetList"/>
 *         &lt;element name="excludedType" type="{http://ss.yahooapis.jp/V201808/CampaignRetargetingList}ExcludedType" minOccurs="0"/>
 *         &lt;element name="bidMultiplier" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CampaignRetargetingList", propOrder = {
    "accountId",
    "campaignId",
    "campaignName",
    "criterionTargetList",
    "excludedType",
    "bidMultiplier"
})
public class CampaignRetargetingList {

    protected Long accountId;
    protected long campaignId;
    protected String campaignName;
    @XmlElement(required = true)
    protected CriterionTargetList criterionTargetList;
    @XmlSchemaType(name = "string")
    protected ExcludedType excludedType;
    protected Double bidMultiplier;

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
     */
    public long getCampaignId() {
        return campaignId;
    }

    /**
     * Sets the value of the campaignId property.
     * 
     */
    public void setCampaignId(long value) {
        this.campaignId = value;
    }

    /**
     * Gets the value of the campaignName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCampaignName() {
        return campaignName;
    }

    /**
     * Sets the value of the campaignName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCampaignName(String value) {
        this.campaignName = value;
    }

    /**
     * Gets the value of the criterionTargetList property.
     * 
     * @return
     *     possible object is
     *     {@link CriterionTargetList }
     *     
     */
    public CriterionTargetList getCriterionTargetList() {
        return criterionTargetList;
    }

    /**
     * Sets the value of the criterionTargetList property.
     * 
     * @param value
     *     allowed object is
     *     {@link CriterionTargetList }
     *     
     */
    public void setCriterionTargetList(CriterionTargetList value) {
        this.criterionTargetList = value;
    }

    /**
     * Gets the value of the excludedType property.
     * 
     * @return
     *     possible object is
     *     {@link ExcludedType }
     *     
     */
    public ExcludedType getExcludedType() {
        return excludedType;
    }

    /**
     * Sets the value of the excludedType property.
     * 
     * @param value
     *     allowed object is
     *     {@link ExcludedType }
     *     
     */
    public void setExcludedType(ExcludedType value) {
        this.excludedType = value;
    }

    /**
     * Gets the value of the bidMultiplier property.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getBidMultiplier() {
        return bidMultiplier;
    }

    /**
     * Sets the value of the bidMultiplier property.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setBidMultiplier(Double value) {
        this.bidMultiplier = value;
    }

}

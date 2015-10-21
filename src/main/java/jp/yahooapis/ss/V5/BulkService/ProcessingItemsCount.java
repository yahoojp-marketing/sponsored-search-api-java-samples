
package jp.yahooapis.ss.V5.BulkService;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ProcessingItemsCount complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ProcessingItemsCount">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="campaignCount" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="negativeCampaignCriterionCount" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="adGroupCount" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="negativeAdGroupCriterionCount" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="biddableAdGroupCriterionCount" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="adGroupAdCount" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="campaignErrorCount" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="negativeCampaignCriterionErrorCount" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="adGroupErrorCount" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="negativeAdGroupCriterionErrorCount" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="biddableAdGroupCriterionErrorCount" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="adGroupAdErrorCount" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ProcessingItemsCount", propOrder = {
    "campaignCount",
    "negativeCampaignCriterionCount",
    "adGroupCount",
    "negativeAdGroupCriterionCount",
    "biddableAdGroupCriterionCount",
    "adGroupAdCount",
    "campaignErrorCount",
    "negativeCampaignCriterionErrorCount",
    "adGroupErrorCount",
    "negativeAdGroupCriterionErrorCount",
    "biddableAdGroupCriterionErrorCount",
    "adGroupAdErrorCount"
})
public class ProcessingItemsCount {

    protected Long campaignCount;
    protected Long negativeCampaignCriterionCount;
    protected Long adGroupCount;
    protected Long negativeAdGroupCriterionCount;
    protected Long biddableAdGroupCriterionCount;
    protected Long adGroupAdCount;
    protected Long campaignErrorCount;
    protected Long negativeCampaignCriterionErrorCount;
    protected Long adGroupErrorCount;
    protected Long negativeAdGroupCriterionErrorCount;
    protected Long biddableAdGroupCriterionErrorCount;
    protected Long adGroupAdErrorCount;

    /**
     * Gets the value of the campaignCount property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getCampaignCount() {
        return campaignCount;
    }

    /**
     * Sets the value of the campaignCount property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setCampaignCount(Long value) {
        this.campaignCount = value;
    }

    /**
     * Gets the value of the negativeCampaignCriterionCount property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getNegativeCampaignCriterionCount() {
        return negativeCampaignCriterionCount;
    }

    /**
     * Sets the value of the negativeCampaignCriterionCount property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setNegativeCampaignCriterionCount(Long value) {
        this.negativeCampaignCriterionCount = value;
    }

    /**
     * Gets the value of the adGroupCount property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getAdGroupCount() {
        return adGroupCount;
    }

    /**
     * Sets the value of the adGroupCount property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setAdGroupCount(Long value) {
        this.adGroupCount = value;
    }

    /**
     * Gets the value of the negativeAdGroupCriterionCount property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getNegativeAdGroupCriterionCount() {
        return negativeAdGroupCriterionCount;
    }

    /**
     * Sets the value of the negativeAdGroupCriterionCount property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setNegativeAdGroupCriterionCount(Long value) {
        this.negativeAdGroupCriterionCount = value;
    }

    /**
     * Gets the value of the biddableAdGroupCriterionCount property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getBiddableAdGroupCriterionCount() {
        return biddableAdGroupCriterionCount;
    }

    /**
     * Sets the value of the biddableAdGroupCriterionCount property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setBiddableAdGroupCriterionCount(Long value) {
        this.biddableAdGroupCriterionCount = value;
    }

    /**
     * Gets the value of the adGroupAdCount property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getAdGroupAdCount() {
        return adGroupAdCount;
    }

    /**
     * Sets the value of the adGroupAdCount property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setAdGroupAdCount(Long value) {
        this.adGroupAdCount = value;
    }

    /**
     * Gets the value of the campaignErrorCount property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getCampaignErrorCount() {
        return campaignErrorCount;
    }

    /**
     * Sets the value of the campaignErrorCount property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setCampaignErrorCount(Long value) {
        this.campaignErrorCount = value;
    }

    /**
     * Gets the value of the negativeCampaignCriterionErrorCount property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getNegativeCampaignCriterionErrorCount() {
        return negativeCampaignCriterionErrorCount;
    }

    /**
     * Sets the value of the negativeCampaignCriterionErrorCount property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setNegativeCampaignCriterionErrorCount(Long value) {
        this.negativeCampaignCriterionErrorCount = value;
    }

    /**
     * Gets the value of the adGroupErrorCount property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getAdGroupErrorCount() {
        return adGroupErrorCount;
    }

    /**
     * Sets the value of the adGroupErrorCount property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setAdGroupErrorCount(Long value) {
        this.adGroupErrorCount = value;
    }

    /**
     * Gets the value of the negativeAdGroupCriterionErrorCount property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getNegativeAdGroupCriterionErrorCount() {
        return negativeAdGroupCriterionErrorCount;
    }

    /**
     * Sets the value of the negativeAdGroupCriterionErrorCount property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setNegativeAdGroupCriterionErrorCount(Long value) {
        this.negativeAdGroupCriterionErrorCount = value;
    }

    /**
     * Gets the value of the biddableAdGroupCriterionErrorCount property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getBiddableAdGroupCriterionErrorCount() {
        return biddableAdGroupCriterionErrorCount;
    }

    /**
     * Sets the value of the biddableAdGroupCriterionErrorCount property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setBiddableAdGroupCriterionErrorCount(Long value) {
        this.biddableAdGroupCriterionErrorCount = value;
    }

    /**
     * Gets the value of the adGroupAdErrorCount property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getAdGroupAdErrorCount() {
        return adGroupAdErrorCount;
    }

    /**
     * Sets the value of the adGroupAdErrorCount property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setAdGroupAdErrorCount(Long value) {
        this.adGroupAdErrorCount = value;
    }

}

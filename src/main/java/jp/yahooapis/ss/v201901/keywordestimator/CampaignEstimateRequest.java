
package jp.yahooapis.ss.v201901.keywordestimator;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for CampaignEstimateRequest complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="CampaignEstimateRequest">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="campaignId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="adGroupEstimateRequests" type="{http://ss.yahooapis.jp/V201901/KeywordEstimator}adGroupEstimateRequest" maxOccurs="unbounded"/>
 *         &lt;element name="provinces" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="dailyBudget" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CampaignEstimateRequest", propOrder = {
    "campaignId",
    "adGroupEstimateRequests",
    "provinces",
    "dailyBudget"
})
public class CampaignEstimateRequest {

    protected Long campaignId;
    @XmlElement(required = true)
    protected List<AdGroupEstimateRequest> adGroupEstimateRequests;
    protected List<String> provinces;
    protected Long dailyBudget;

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
     * Gets the value of the adGroupEstimateRequests property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the adGroupEstimateRequests property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAdGroupEstimateRequests().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link AdGroupEstimateRequest }
     * 
     * 
     */
    public List<AdGroupEstimateRequest> getAdGroupEstimateRequests() {
        if (adGroupEstimateRequests == null) {
            adGroupEstimateRequests = new ArrayList<AdGroupEstimateRequest>();
        }
        return this.adGroupEstimateRequests;
    }

    /**
     * Gets the value of the provinces property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the provinces property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getProvinces().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getProvinces() {
        if (provinces == null) {
            provinces = new ArrayList<String>();
        }
        return this.provinces;
    }

    /**
     * Gets the value of the dailyBudget property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getDailyBudget() {
        return dailyBudget;
    }

    /**
     * Sets the value of the dailyBudget property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setDailyBudget(Long value) {
        this.dailyBudget = value;
    }

}

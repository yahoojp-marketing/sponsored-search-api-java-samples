
package jp.yahooapis.ss.v201805.keywordestimator;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for KeywordEstimatorSelector complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="KeywordEstimatorSelector">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="accountId" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="campaignEstimateRequest" type="{http://ss.yahooapis.jp/V201805/KeywordEstimator}CampaignEstimateRequest"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "KeywordEstimatorSelector", propOrder = {
    "accountId",
    "campaignEstimateRequest"
})
public class KeywordEstimatorSelector {

    protected long accountId;
    @XmlElement(required = true)
    protected CampaignEstimateRequest campaignEstimateRequest;

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
     * Gets the value of the campaignEstimateRequest property.
     * 
     * @return
     *     possible object is
     *     {@link CampaignEstimateRequest }
     *     
     */
    public CampaignEstimateRequest getCampaignEstimateRequest() {
        return campaignEstimateRequest;
    }

    /**
     * Sets the value of the campaignEstimateRequest property.
     * 
     * @param value
     *     allowed object is
     *     {@link CampaignEstimateRequest }
     *     
     */
    public void setCampaignEstimateRequest(CampaignEstimateRequest value) {
        this.campaignEstimateRequest = value;
    }

}

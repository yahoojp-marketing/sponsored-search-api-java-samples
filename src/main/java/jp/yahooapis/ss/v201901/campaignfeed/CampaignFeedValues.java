
package jp.yahooapis.ss.v201901.campaignfeed;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;
import jp.yahooapis.ss.v201901.ReturnValue;


/**
 * <p>Java class for CampaignFeedValues complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="CampaignFeedValues">
 *   &lt;complexContent>
 *     &lt;extension base="{http://ss.yahooapis.jp/V201901}ReturnValue">
 *       &lt;sequence>
 *         &lt;element name="campaignFeedList" type="{http://ss.yahooapis.jp/V201901/CampaignFeed}CampaignFeedList" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CampaignFeedValues", propOrder = {
    "campaignFeedList"
})
public class CampaignFeedValues
    extends ReturnValue
{

    protected CampaignFeedList campaignFeedList;

    /**
     * Gets the value of the campaignFeedList property.
     * 
     * @return
     *     possible object is
     *     {@link CampaignFeedList }
     *     
     */
    public CampaignFeedList getCampaignFeedList() {
        return campaignFeedList;
    }

    /**
     * Sets the value of the campaignFeedList property.
     * 
     * @param value
     *     allowed object is
     *     {@link CampaignFeedList }
     *     
     */
    public void setCampaignFeedList(CampaignFeedList value) {
        this.campaignFeedList = value;
    }

}

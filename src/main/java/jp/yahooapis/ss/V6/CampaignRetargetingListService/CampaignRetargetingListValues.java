
package jp.yahooapis.ss.V6.CampaignRetargetingListService;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for CampaignRetargetingListValues complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="CampaignRetargetingListValues">
 *   &lt;complexContent>
 *     &lt;extension base="{http://ss.yahooapis.jp/V6}ReturnValue">
 *       &lt;sequence>
 *         &lt;element name="campaignRetargetingList" type="{http://ss.yahooapis.jp/V6}CampaignRetargetingList" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CampaignRetargetingListValues", propOrder = {
    "campaignRetargetingList"
})
public class CampaignRetargetingListValues
    extends ReturnValue
{

    protected CampaignRetargetingList campaignRetargetingList;

    /**
     * Gets the value of the campaignRetargetingList property.
     * 
     * @return
     *     possible object is
     *     {@link CampaignRetargetingList }
     *     
     */
    public CampaignRetargetingList getCampaignRetargetingList() {
        return campaignRetargetingList;
    }

    /**
     * Sets the value of the campaignRetargetingList property.
     * 
     * @param value
     *     allowed object is
     *     {@link CampaignRetargetingList }
     *     
     */
    public void setCampaignRetargetingList(CampaignRetargetingList value) {
        this.campaignRetargetingList = value;
    }

}

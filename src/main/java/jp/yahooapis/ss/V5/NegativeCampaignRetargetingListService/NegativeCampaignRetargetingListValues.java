
package jp.yahooapis.ss.V5.NegativeCampaignRetargetingListService;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for NegativeCampaignRetargetingListValues complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="NegativeCampaignRetargetingListValues">
 *   &lt;complexContent>
 *     &lt;extension base="{http://ss.yahooapis.jp/V5}ReturnValue">
 *       &lt;sequence>
 *         &lt;element name="negativeCampaignRetargetingList" type="{http://ss.yahooapis.jp/V5}NegativeCampaignRetargetingList" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "NegativeCampaignRetargetingListValues", propOrder = {
    "negativeCampaignRetargetingList"
})
public class NegativeCampaignRetargetingListValues
    extends ReturnValue
{

    protected NegativeCampaignRetargetingList negativeCampaignRetargetingList;

    /**
     * Gets the value of the negativeCampaignRetargetingList property.
     * 
     * @return
     *     possible object is
     *     {@link NegativeCampaignRetargetingList }
     *     
     */
    public NegativeCampaignRetargetingList getNegativeCampaignRetargetingList() {
        return negativeCampaignRetargetingList;
    }

    /**
     * Sets the value of the negativeCampaignRetargetingList property.
     * 
     * @param value
     *     allowed object is
     *     {@link NegativeCampaignRetargetingList }
     *     
     */
    public void setNegativeCampaignRetargetingList(NegativeCampaignRetargetingList value) {
        this.negativeCampaignRetargetingList = value;
    }

}

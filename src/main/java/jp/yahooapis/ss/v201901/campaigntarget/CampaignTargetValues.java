
package jp.yahooapis.ss.v201901.campaigntarget;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;
import jp.yahooapis.ss.v201901.ReturnValue;


/**
 * <p>Java class for CampaignTargetValues complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="CampaignTargetValues">
 *   &lt;complexContent>
 *     &lt;extension base="{http://ss.yahooapis.jp/V201901}ReturnValue">
 *       &lt;sequence>
 *         &lt;element name="campaignTarget" type="{http://ss.yahooapis.jp/V201901/CampaignTarget}CampaignTarget" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CampaignTargetValues", propOrder = {
    "campaignTarget"
})
public class CampaignTargetValues
    extends ReturnValue
{

    protected CampaignTarget campaignTarget;

    /**
     * Gets the value of the campaignTarget property.
     * 
     * @return
     *     possible object is
     *     {@link CampaignTarget }
     *     
     */
    public CampaignTarget getCampaignTarget() {
        return campaignTarget;
    }

    /**
     * Sets the value of the campaignTarget property.
     * 
     * @param value
     *     allowed object is
     *     {@link CampaignTarget }
     *     
     */
    public void setCampaignTarget(CampaignTarget value) {
        this.campaignTarget = value;
    }

}

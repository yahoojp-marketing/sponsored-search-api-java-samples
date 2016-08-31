
package jp.yahooapis.ss.V6.CampaignSharedSetService;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for CampaignSharedSetValues complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="CampaignSharedSetValues">
 *   &lt;complexContent>
 *     &lt;extension base="{http://ss.yahooapis.jp/V6}ReturnValue">
 *       &lt;sequence>
 *         &lt;element name="campaignSharedSet" type="{http://ss.yahooapis.jp/V6}CampaignSharedSet" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CampaignSharedSetValues", propOrder = {
    "campaignSharedSet"
})
public class CampaignSharedSetValues
    extends ReturnValue
{

    protected CampaignSharedSet campaignSharedSet;

    /**
     * Gets the value of the campaignSharedSet property.
     * 
     * @return
     *     possible object is
     *     {@link CampaignSharedSet }
     *     
     */
    public CampaignSharedSet getCampaignSharedSet() {
        return campaignSharedSet;
    }

    /**
     * Sets the value of the campaignSharedSet property.
     * 
     * @param value
     *     allowed object is
     *     {@link CampaignSharedSet }
     *     
     */
    public void setCampaignSharedSet(CampaignSharedSet value) {
        this.campaignSharedSet = value;
    }

}

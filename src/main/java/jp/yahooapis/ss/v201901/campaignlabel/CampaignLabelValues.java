
package jp.yahooapis.ss.v201901.campaignlabel;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;
import jp.yahooapis.ss.v201901.ReturnValue;


/**
 * <p>Java class for CampaignLabelValues complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="CampaignLabelValues">
 *   &lt;complexContent>
 *     &lt;extension base="{http://ss.yahooapis.jp/V201901}ReturnValue">
 *       &lt;sequence>
 *         &lt;element name="campaignLabel" type="{http://ss.yahooapis.jp/V201901/CampaignLabel}CampaignLabel" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CampaignLabelValues", propOrder = {
    "campaignLabel"
})
public class CampaignLabelValues
    extends ReturnValue
{

    protected CampaignLabel campaignLabel;

    /**
     * Gets the value of the campaignLabel property.
     * 
     * @return
     *     possible object is
     *     {@link CampaignLabel }
     *     
     */
    public CampaignLabel getCampaignLabel() {
        return campaignLabel;
    }

    /**
     * Sets the value of the campaignLabel property.
     * 
     * @param value
     *     allowed object is
     *     {@link CampaignLabel }
     *     
     */
    public void setCampaignLabel(CampaignLabel value) {
        this.campaignLabel = value;
    }

}

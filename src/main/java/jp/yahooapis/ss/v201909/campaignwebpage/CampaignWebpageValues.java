
package jp.yahooapis.ss.v201909.campaignwebpage;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;
import jp.yahooapis.ss.v201909.ReturnValue;


/**
 * <p>Java class for CampaignWebpageValues complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="CampaignWebpageValues">
 *   &lt;complexContent>
 *     &lt;extension base="{http://ss.yahooapis.jp/V201909}ReturnValue">
 *       &lt;sequence>
 *         &lt;element name="campaignWebpage" type="{http://ss.yahooapis.jp/V201909/CampaignWebpage}CampaignWebpage" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CampaignWebpageValues", propOrder = {
    "campaignWebpage"
})
public class CampaignWebpageValues
    extends ReturnValue
{

    protected CampaignWebpage campaignWebpage;

    /**
     * Gets the value of the campaignWebpage property.
     * 
     * @return
     *     possible object is
     *     {@link CampaignWebpage }
     *     
     */
    public CampaignWebpage getCampaignWebpage() {
        return campaignWebpage;
    }

    /**
     * Sets the value of the campaignWebpage property.
     * 
     * @param value
     *     allowed object is
     *     {@link CampaignWebpage }
     *     
     */
    public void setCampaignWebpage(CampaignWebpage value) {
        this.campaignWebpage = value;
    }

}

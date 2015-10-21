
package jp.yahooapis.ss.V5.AdGroupBidMultiplierService;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for AdGroupBidMultiplierValues complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="AdGroupBidMultiplierValues">
 *   &lt;complexContent>
 *     &lt;extension base="{http://ss.yahooapis.jp/V5}ReturnValue">
 *       &lt;sequence>
 *         &lt;element name="adGroupBidMultiplier" type="{http://ss.yahooapis.jp/V5}AdGroupBidMultiplier" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AdGroupBidMultiplierValues", propOrder = {
    "adGroupBidMultiplier"
})
public class AdGroupBidMultiplierValues
    extends ReturnValue
{

    protected AdGroupBidMultiplier adGroupBidMultiplier;

    /**
     * Gets the value of the adGroupBidMultiplier property.
     * 
     * @return
     *     possible object is
     *     {@link AdGroupBidMultiplier }
     *     
     */
    public AdGroupBidMultiplier getAdGroupBidMultiplier() {
        return adGroupBidMultiplier;
    }

    /**
     * Sets the value of the adGroupBidMultiplier property.
     * 
     * @param value
     *     allowed object is
     *     {@link AdGroupBidMultiplier }
     *     
     */
    public void setAdGroupBidMultiplier(AdGroupBidMultiplier value) {
        this.adGroupBidMultiplier = value;
    }

}

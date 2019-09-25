
package jp.yahooapis.ss.v201909.adgroupad;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;
import jp.yahooapis.ss.v201909.ReturnValue;


/**
 * <p>Java class for AdGroupAdValues complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="AdGroupAdValues">
 *   &lt;complexContent>
 *     &lt;extension base="{http://ss.yahooapis.jp/V201909}ReturnValue">
 *       &lt;sequence>
 *         &lt;element name="adGroupAd" type="{http://ss.yahooapis.jp/V201909/AdGroupAd}AdGroupAd" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AdGroupAdValues", propOrder = {
    "adGroupAd"
})
public class AdGroupAdValues
    extends ReturnValue
{

    protected AdGroupAd adGroupAd;

    /**
     * Gets the value of the adGroupAd property.
     * 
     * @return
     *     possible object is
     *     {@link AdGroupAd }
     *     
     */
    public AdGroupAd getAdGroupAd() {
        return adGroupAd;
    }

    /**
     * Sets the value of the adGroupAd property.
     * 
     * @param value
     *     allowed object is
     *     {@link AdGroupAd }
     *     
     */
    public void setAdGroupAd(AdGroupAd value) {
        this.adGroupAd = value;
    }

}

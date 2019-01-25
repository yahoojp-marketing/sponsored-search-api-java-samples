
package jp.yahooapis.ss.v201901.adgroupwebpage;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;
import jp.yahooapis.ss.v201901.ReturnValue;


/**
 * <p>Java class for AdGroupWebpageValues complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="AdGroupWebpageValues">
 *   &lt;complexContent>
 *     &lt;extension base="{http://ss.yahooapis.jp/V201901}ReturnValue">
 *       &lt;sequence>
 *         &lt;element name="adGroupWebpage" type="{http://ss.yahooapis.jp/V201901/AdGroupWebpage}AdGroupWebpage" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AdGroupWebpageValues", propOrder = {
    "adGroupWebpage"
})
public class AdGroupWebpageValues
    extends ReturnValue
{

    protected AdGroupWebpage adGroupWebpage;

    /**
     * Gets the value of the adGroupWebpage property.
     * 
     * @return
     *     possible object is
     *     {@link AdGroupWebpage }
     *     
     */
    public AdGroupWebpage getAdGroupWebpage() {
        return adGroupWebpage;
    }

    /**
     * Sets the value of the adGroupWebpage property.
     * 
     * @param value
     *     allowed object is
     *     {@link AdGroupWebpage }
     *     
     */
    public void setAdGroupWebpage(AdGroupWebpage value) {
        this.adGroupWebpage = value;
    }

}

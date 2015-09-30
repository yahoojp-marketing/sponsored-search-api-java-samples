
package jp.yahooapis.ss.V5.AdGroupFeedService;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for AdGroupFeedValues complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="AdGroupFeedValues">
 *   &lt;complexContent>
 *     &lt;extension base="{http://ss.yahooapis.jp/V5}ReturnValue">
 *       &lt;sequence>
 *         &lt;element name="adGroupFeedList" type="{http://ss.yahooapis.jp/V5}AdGroupFeedList" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AdGroupFeedValues", propOrder = {
    "adGroupFeedList"
})
public class AdGroupFeedValues
    extends ReturnValue
{

    protected AdGroupFeedList adGroupFeedList;

    /**
     * Gets the value of the adGroupFeedList property.
     * 
     * @return
     *     possible object is
     *     {@link AdGroupFeedList }
     *     
     */
    public AdGroupFeedList getAdGroupFeedList() {
        return adGroupFeedList;
    }

    /**
     * Sets the value of the adGroupFeedList property.
     * 
     * @param value
     *     allowed object is
     *     {@link AdGroupFeedList }
     *     
     */
    public void setAdGroupFeedList(AdGroupFeedList value) {
        this.adGroupFeedList = value;
    }

}

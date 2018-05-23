
package jp.yahooapis.ss.v201805.adgroupretargetinglist;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;
import jp.yahooapis.ss.v201805.ReturnValue;


/**
 * <p>Java class for AdGroupRetargetingListValues complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="AdGroupRetargetingListValues">
 *   &lt;complexContent>
 *     &lt;extension base="{http://ss.yahooapis.jp/V201805}ReturnValue">
 *       &lt;sequence>
 *         &lt;element name="adGroupRetargetingList" type="{http://ss.yahooapis.jp/V201805/AdGroupRetargetingList}AdGroupRetargetingList" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AdGroupRetargetingListValues", propOrder = {
    "adGroupRetargetingList"
})
public class AdGroupRetargetingListValues
    extends ReturnValue
{

    protected AdGroupRetargetingList adGroupRetargetingList;

    /**
     * Gets the value of the adGroupRetargetingList property.
     * 
     * @return
     *     possible object is
     *     {@link AdGroupRetargetingList }
     *     
     */
    public AdGroupRetargetingList getAdGroupRetargetingList() {
        return adGroupRetargetingList;
    }

    /**
     * Sets the value of the adGroupRetargetingList property.
     * 
     * @param value
     *     allowed object is
     *     {@link AdGroupRetargetingList }
     *     
     */
    public void setAdGroupRetargetingList(AdGroupRetargetingList value) {
        this.adGroupRetargetingList = value;
    }

}

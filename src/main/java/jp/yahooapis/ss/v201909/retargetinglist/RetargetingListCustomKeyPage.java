
package jp.yahooapis.ss.v201909.retargetinglist;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;
import jp.yahooapis.ss.v201909.Page;


/**
 * <p>Java class for RetargetingListCustomKeyPage complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="RetargetingListCustomKeyPage">
 *   &lt;complexContent>
 *     &lt;extension base="{http://ss.yahooapis.jp/V201909}Page">
 *       &lt;sequence>
 *         &lt;element name="customKeys" type="{http://ss.yahooapis.jp/V201909/RetargetingList}CustomKey" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "RetargetingListCustomKeyPage", propOrder = {
    "customKeys"
})
public class RetargetingListCustomKeyPage
    extends Page
{

    protected CustomKey customKeys;

    /**
     * Gets the value of the customKeys property.
     * 
     * @return
     *     possible object is
     *     {@link CustomKey }
     *     
     */
    public CustomKey getCustomKeys() {
        return customKeys;
    }

    /**
     * Sets the value of the customKeys property.
     * 
     * @param value
     *     allowed object is
     *     {@link CustomKey }
     *     
     */
    public void setCustomKeys(CustomKey value) {
        this.customKeys = value;
    }

}

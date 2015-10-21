
package jp.yahooapis.ss.V5.AdGroupService;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ManualCPCAdGroupBid complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ManualCPCAdGroupBid">
 *   &lt;complexContent>
 *     &lt;extension base="{http://ss.yahooapis.jp/V5}AdGroupBid">
 *       &lt;sequence>
 *         &lt;element name="keywordMaxCpc" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ManualCPCAdGroupBid", propOrder = {
    "keywordMaxCpc"
})
public class ManualCPCAdGroupBid
    extends AdGroupBid
{

    protected Long keywordMaxCpc;

    /**
     * Gets the value of the keywordMaxCpc property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getKeywordMaxCpc() {
        return keywordMaxCpc;
    }

    /**
     * Sets the value of the keywordMaxCpc property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setKeywordMaxCpc(Long value) {
        this.keywordMaxCpc = value;
    }

}

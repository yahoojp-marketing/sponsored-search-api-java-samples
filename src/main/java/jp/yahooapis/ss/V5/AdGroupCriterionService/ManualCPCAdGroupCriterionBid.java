
package jp.yahooapis.ss.V5.AdGroupCriterionService;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ManualCPCAdGroupCriterionBid complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ManualCPCAdGroupCriterionBid">
 *   &lt;complexContent>
 *     &lt;extension base="{http://ss.yahooapis.jp/V5}AdGroupCriterionBid">
 *       &lt;sequence>
 *         &lt;element name="maxCpc" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="bidSource" type="{http://ss.yahooapis.jp/V5}BidSource" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ManualCPCAdGroupCriterionBid", propOrder = {
    "maxCpc",
    "bidSource"
})
public class ManualCPCAdGroupCriterionBid
    extends AdGroupCriterionBid
{

    protected Long maxCpc;
    protected BidSource bidSource;

    /**
     * Gets the value of the maxCpc property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getMaxCpc() {
        return maxCpc;
    }

    /**
     * Sets the value of the maxCpc property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setMaxCpc(Long value) {
        this.maxCpc = value;
    }

    /**
     * Gets the value of the bidSource property.
     * 
     * @return
     *     possible object is
     *     {@link BidSource }
     *     
     */
    public BidSource getBidSource() {
        return bidSource;
    }

    /**
     * Sets the value of the bidSource property.
     * 
     * @param value
     *     allowed object is
     *     {@link BidSource }
     *     
     */
    public void setBidSource(BidSource value) {
        this.bidSource = value;
    }

}

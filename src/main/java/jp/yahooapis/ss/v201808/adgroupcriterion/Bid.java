
package jp.yahooapis.ss.v201808.adgroupcriterion;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for Bid complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Bid">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="maxCpc" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="bidSource" type="{http://ss.yahooapis.jp/V201808/AdGroupCriterion}BidSource" minOccurs="0"/>
 *         &lt;element name="adGroupMaxCpc" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="keywordMaxCpc" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Bid", propOrder = {
    "maxCpc",
    "bidSource",
    "adGroupMaxCpc",
    "keywordMaxCpc"
})
public class Bid {

    protected Long maxCpc;
    @XmlSchemaType(name = "string")
    protected BidSource bidSource;
    protected Long adGroupMaxCpc;
    protected Long keywordMaxCpc;

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

    /**
     * Gets the value of the adGroupMaxCpc property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getAdGroupMaxCpc() {
        return adGroupMaxCpc;
    }

    /**
     * Sets the value of the adGroupMaxCpc property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setAdGroupMaxCpc(Long value) {
        this.adGroupMaxCpc = value;
    }

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

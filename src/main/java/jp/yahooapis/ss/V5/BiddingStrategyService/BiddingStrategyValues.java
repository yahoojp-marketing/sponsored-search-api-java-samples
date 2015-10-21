
package jp.yahooapis.ss.V5.BiddingStrategyService;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for BiddingStrategyValues complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="BiddingStrategyValues">
 *   &lt;complexContent>
 *     &lt;extension base="{http://ss.yahooapis.jp/V5}ReturnValue">
 *       &lt;sequence>
 *         &lt;element name="biddingStrategy" type="{http://ss.yahooapis.jp/V5}BiddingStrategy" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "BiddingStrategyValues", propOrder = {
    "biddingStrategy"
})
public class BiddingStrategyValues
    extends ReturnValue
{

    protected BiddingStrategy biddingStrategy;

    /**
     * Gets the value of the biddingStrategy property.
     * 
     * @return
     *     possible object is
     *     {@link BiddingStrategy }
     *     
     */
    public BiddingStrategy getBiddingStrategy() {
        return biddingStrategy;
    }

    /**
     * Sets the value of the biddingStrategy property.
     * 
     * @param value
     *     allowed object is
     *     {@link BiddingStrategy }
     *     
     */
    public void setBiddingStrategy(BiddingStrategy value) {
        this.biddingStrategy = value;
    }

}

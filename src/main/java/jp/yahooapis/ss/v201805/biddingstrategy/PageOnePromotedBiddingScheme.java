
package jp.yahooapis.ss.v201805.biddingstrategy;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for PageOnePromotedBiddingScheme complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="PageOnePromotedBiddingScheme">
 *   &lt;complexContent>
 *     &lt;extension base="{http://ss.yahooapis.jp/V201805/BiddingStrategy}BiddingScheme">
 *       &lt;sequence>
 *         &lt;element name="targetPositionType" type="{http://ss.yahooapis.jp/V201805/BiddingStrategy}TargetPositionType" minOccurs="0"/>
 *         &lt;element name="bidCeiling" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="bidMultiplier" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *         &lt;element name="bidChangesForRaisesOnly" type="{http://ss.yahooapis.jp/V201805/BiddingStrategy}BidChangesForRaisesOnly" minOccurs="0"/>
 *         &lt;element name="raiseBidWhenBudgetConstrained" type="{http://ss.yahooapis.jp/V201805/BiddingStrategy}RaiseBidWhenBudgetConstrained" minOccurs="0"/>
 *         &lt;element name="raiseBidWhenLowQualityScore" type="{http://ss.yahooapis.jp/V201805/BiddingStrategy}RaiseBidWhenLowQualityScore" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PageOnePromotedBiddingScheme", propOrder = {
    "targetPositionType",
    "bidCeiling",
    "bidMultiplier",
    "bidChangesForRaisesOnly",
    "raiseBidWhenBudgetConstrained",
    "raiseBidWhenLowQualityScore"
})
public class PageOnePromotedBiddingScheme
    extends BiddingScheme
{

    @XmlSchemaType(name = "string")
    protected TargetPositionType targetPositionType;
    protected Long bidCeiling;
    protected Double bidMultiplier;
    @XmlSchemaType(name = "string")
    protected BidChangesForRaisesOnly bidChangesForRaisesOnly;
    @XmlSchemaType(name = "string")
    protected RaiseBidWhenBudgetConstrained raiseBidWhenBudgetConstrained;
    @XmlSchemaType(name = "string")
    protected RaiseBidWhenLowQualityScore raiseBidWhenLowQualityScore;

    /**
     * Gets the value of the targetPositionType property.
     * 
     * @return
     *     possible object is
     *     {@link TargetPositionType }
     *     
     */
    public TargetPositionType getTargetPositionType() {
        return targetPositionType;
    }

    /**
     * Sets the value of the targetPositionType property.
     * 
     * @param value
     *     allowed object is
     *     {@link TargetPositionType }
     *     
     */
    public void setTargetPositionType(TargetPositionType value) {
        this.targetPositionType = value;
    }

    /**
     * Gets the value of the bidCeiling property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getBidCeiling() {
        return bidCeiling;
    }

    /**
     * Sets the value of the bidCeiling property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setBidCeiling(Long value) {
        this.bidCeiling = value;
    }

    /**
     * Gets the value of the bidMultiplier property.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getBidMultiplier() {
        return bidMultiplier;
    }

    /**
     * Sets the value of the bidMultiplier property.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setBidMultiplier(Double value) {
        this.bidMultiplier = value;
    }

    /**
     * Gets the value of the bidChangesForRaisesOnly property.
     * 
     * @return
     *     possible object is
     *     {@link BidChangesForRaisesOnly }
     *     
     */
    public BidChangesForRaisesOnly getBidChangesForRaisesOnly() {
        return bidChangesForRaisesOnly;
    }

    /**
     * Sets the value of the bidChangesForRaisesOnly property.
     * 
     * @param value
     *     allowed object is
     *     {@link BidChangesForRaisesOnly }
     *     
     */
    public void setBidChangesForRaisesOnly(BidChangesForRaisesOnly value) {
        this.bidChangesForRaisesOnly = value;
    }

    /**
     * Gets the value of the raiseBidWhenBudgetConstrained property.
     * 
     * @return
     *     possible object is
     *     {@link RaiseBidWhenBudgetConstrained }
     *     
     */
    public RaiseBidWhenBudgetConstrained getRaiseBidWhenBudgetConstrained() {
        return raiseBidWhenBudgetConstrained;
    }

    /**
     * Sets the value of the raiseBidWhenBudgetConstrained property.
     * 
     * @param value
     *     allowed object is
     *     {@link RaiseBidWhenBudgetConstrained }
     *     
     */
    public void setRaiseBidWhenBudgetConstrained(RaiseBidWhenBudgetConstrained value) {
        this.raiseBidWhenBudgetConstrained = value;
    }

    /**
     * Gets the value of the raiseBidWhenLowQualityScore property.
     * 
     * @return
     *     possible object is
     *     {@link RaiseBidWhenLowQualityScore }
     *     
     */
    public RaiseBidWhenLowQualityScore getRaiseBidWhenLowQualityScore() {
        return raiseBidWhenLowQualityScore;
    }

    /**
     * Sets the value of the raiseBidWhenLowQualityScore property.
     * 
     * @param value
     *     allowed object is
     *     {@link RaiseBidWhenLowQualityScore }
     *     
     */
    public void setRaiseBidWhenLowQualityScore(RaiseBidWhenLowQualityScore value) {
        this.raiseBidWhenLowQualityScore = value;
    }

}

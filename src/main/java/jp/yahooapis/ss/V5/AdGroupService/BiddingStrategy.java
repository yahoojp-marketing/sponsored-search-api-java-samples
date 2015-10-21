
package jp.yahooapis.ss.V5.AdGroupService;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for BiddingStrategy complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="BiddingStrategy">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="biddingStrategyId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="biddingStrategyName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="biddingStrategyType" type="{http://ss.yahooapis.jp/V5}BiddingStrategyType" minOccurs="0"/>
 *         &lt;element name="biddingStrategySource" type="{http://ss.yahooapis.jp/V5}BiddingStrategySource" minOccurs="0"/>
 *         &lt;element name="biddingScheme" type="{http://ss.yahooapis.jp/V5}BiddingScheme" minOccurs="0"/>
 *         &lt;element name="initialBid" type="{http://ss.yahooapis.jp/V5}Bid" minOccurs="0"/>
 *         &lt;element name="parentBiddingStrategyConfigurations" type="{http://ss.yahooapis.jp/V5}BiddingStrategy" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "BiddingStrategy", propOrder = {
    "biddingStrategyId",
    "biddingStrategyName",
    "biddingStrategyType",
    "biddingStrategySource",
    "biddingScheme",
    "initialBid",
    "parentBiddingStrategyConfigurations"
})
public class BiddingStrategy {

    protected Long biddingStrategyId;
    protected String biddingStrategyName;
    @XmlSchemaType(name = "string")
    protected BiddingStrategyType biddingStrategyType;
    @XmlSchemaType(name = "string")
    protected BiddingStrategySource biddingStrategySource;
    protected BiddingScheme biddingScheme;
    protected Bid initialBid;
    protected List<BiddingStrategy> parentBiddingStrategyConfigurations;

    /**
     * Gets the value of the biddingStrategyId property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getBiddingStrategyId() {
        return biddingStrategyId;
    }

    /**
     * Sets the value of the biddingStrategyId property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setBiddingStrategyId(Long value) {
        this.biddingStrategyId = value;
    }

    /**
     * Gets the value of the biddingStrategyName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBiddingStrategyName() {
        return biddingStrategyName;
    }

    /**
     * Sets the value of the biddingStrategyName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBiddingStrategyName(String value) {
        this.biddingStrategyName = value;
    }

    /**
     * Gets the value of the biddingStrategyType property.
     * 
     * @return
     *     possible object is
     *     {@link BiddingStrategyType }
     *     
     */
    public BiddingStrategyType getBiddingStrategyType() {
        return biddingStrategyType;
    }

    /**
     * Sets the value of the biddingStrategyType property.
     * 
     * @param value
     *     allowed object is
     *     {@link BiddingStrategyType }
     *     
     */
    public void setBiddingStrategyType(BiddingStrategyType value) {
        this.biddingStrategyType = value;
    }

    /**
     * Gets the value of the biddingStrategySource property.
     * 
     * @return
     *     possible object is
     *     {@link BiddingStrategySource }
     *     
     */
    public BiddingStrategySource getBiddingStrategySource() {
        return biddingStrategySource;
    }

    /**
     * Sets the value of the biddingStrategySource property.
     * 
     * @param value
     *     allowed object is
     *     {@link BiddingStrategySource }
     *     
     */
    public void setBiddingStrategySource(BiddingStrategySource value) {
        this.biddingStrategySource = value;
    }

    /**
     * Gets the value of the biddingScheme property.
     * 
     * @return
     *     possible object is
     *     {@link BiddingScheme }
     *     
     */
    public BiddingScheme getBiddingScheme() {
        return biddingScheme;
    }

    /**
     * Sets the value of the biddingScheme property.
     * 
     * @param value
     *     allowed object is
     *     {@link BiddingScheme }
     *     
     */
    public void setBiddingScheme(BiddingScheme value) {
        this.biddingScheme = value;
    }

    /**
     * Gets the value of the initialBid property.
     * 
     * @return
     *     possible object is
     *     {@link Bid }
     *     
     */
    public Bid getInitialBid() {
        return initialBid;
    }

    /**
     * Sets the value of the initialBid property.
     * 
     * @param value
     *     allowed object is
     *     {@link Bid }
     *     
     */
    public void setInitialBid(Bid value) {
        this.initialBid = value;
    }

    /**
     * Gets the value of the parentBiddingStrategyConfigurations property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the parentBiddingStrategyConfigurations property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getParentBiddingStrategyConfigurations().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link BiddingStrategy }
     * 
     * 
     */
    public List<BiddingStrategy> getParentBiddingStrategyConfigurations() {
        if (parentBiddingStrategyConfigurations == null) {
            parentBiddingStrategyConfigurations = new ArrayList<BiddingStrategy>();
        }
        return this.parentBiddingStrategyConfigurations;
    }

}


package jp.yahooapis.ss.V6.BiddingStrategyService;

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
 *         &lt;element name="accountId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="biddingStrategyId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="biddingStrategyName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="biddingStrategyType" type="{http://ss.yahooapis.jp/V6}BiddingStrategyType" minOccurs="0"/>
 *         &lt;element name="biddingScheme" type="{http://ss.yahooapis.jp/V6}BiddingScheme" minOccurs="0"/>
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
    "accountId",
    "biddingStrategyId",
    "biddingStrategyName",
    "biddingStrategyType",
    "biddingScheme"
})
public class BiddingStrategy {

    protected Long accountId;
    protected Long biddingStrategyId;
    protected String biddingStrategyName;
    @XmlSchemaType(name = "string")
    protected BiddingStrategyType biddingStrategyType;
    protected BiddingScheme biddingScheme;

    /**
     * Gets the value of the accountId property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getAccountId() {
        return accountId;
    }

    /**
     * Sets the value of the accountId property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setAccountId(Long value) {
        this.accountId = value;
    }

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

}

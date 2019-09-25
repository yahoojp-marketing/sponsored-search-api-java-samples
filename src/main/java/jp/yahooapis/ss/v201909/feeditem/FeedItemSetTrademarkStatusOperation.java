
package jp.yahooapis.ss.v201909.feeditem;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for FeedItemSetTrademarkStatusOperation complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="FeedItemSetTrademarkStatusOperation">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="accountId" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="placeholderType" type="{http://ss.yahooapis.jp/V201909/FeedItem}FeedItemPlaceholderType"/>
 *         &lt;element name="operand" type="{http://ss.yahooapis.jp/V201909/FeedItem}FeedItemSetTrademarkStatus" maxOccurs="unbounded"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "FeedItemSetTrademarkStatusOperation", propOrder = {
    "accountId",
    "placeholderType",
    "operand"
})
public class FeedItemSetTrademarkStatusOperation {

    protected long accountId;
    @XmlElement(required = true)
    @XmlSchemaType(name = "string")
    protected FeedItemPlaceholderType placeholderType;
    @XmlElement(required = true)
    protected List<FeedItemSetTrademarkStatus> operand;

    /**
     * Gets the value of the accountId property.
     * 
     */
    public long getAccountId() {
        return accountId;
    }

    /**
     * Sets the value of the accountId property.
     * 
     */
    public void setAccountId(long value) {
        this.accountId = value;
    }

    /**
     * Gets the value of the placeholderType property.
     * 
     * @return
     *     possible object is
     *     {@link FeedItemPlaceholderType }
     *     
     */
    public FeedItemPlaceholderType getPlaceholderType() {
        return placeholderType;
    }

    /**
     * Sets the value of the placeholderType property.
     * 
     * @param value
     *     allowed object is
     *     {@link FeedItemPlaceholderType }
     *     
     */
    public void setPlaceholderType(FeedItemPlaceholderType value) {
        this.placeholderType = value;
    }

    /**
     * Gets the value of the operand property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the operand property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getOperand().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link FeedItemSetTrademarkStatus }
     * 
     * 
     */
    public List<FeedItemSetTrademarkStatus> getOperand() {
        if (operand == null) {
            operand = new ArrayList<FeedItemSetTrademarkStatus>();
        }
        return this.operand;
    }

}

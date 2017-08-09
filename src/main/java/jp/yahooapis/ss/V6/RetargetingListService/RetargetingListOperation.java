
package jp.yahooapis.ss.V6.RetargetingListService;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for RetargetingListOperation complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="RetargetingListOperation">
 *   &lt;complexContent>
 *     &lt;extension base="{http://ss.yahooapis.jp/V6}Operation">
 *       &lt;sequence>
 *         &lt;element name="accountId" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="owner" type="{http://ss.yahooapis.jp/V6}TargetListOwner" minOccurs="0"/>
 *         &lt;element name="operand" type="{http://ss.yahooapis.jp/V6}TargetingList" maxOccurs="unbounded"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "RetargetingListOperation", propOrder = {
    "accountId",
    "owner",
    "operand"
})
public class RetargetingListOperation
    extends Operation
{

    protected long accountId;
    @XmlSchemaType(name = "string")
    protected TargetListOwner owner;
    @XmlElement(required = true)
    protected List<TargetingList> operand;

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
     * Gets the value of the owner property.
     * 
     * @return
     *     possible object is
     *     {@link TargetListOwner }
     *     
     */
    public TargetListOwner getOwner() {
        return owner;
    }

    /**
     * Sets the value of the owner property.
     * 
     * @param value
     *     allowed object is
     *     {@link TargetListOwner }
     *     
     */
    public void setOwner(TargetListOwner value) {
        this.owner = value;
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
     * {@link TargetingList }
     * 
     * 
     */
    public List<TargetingList> getOperand() {
        if (operand == null) {
            operand = new ArrayList<TargetingList>();
        }
        return this.operand;
    }

}

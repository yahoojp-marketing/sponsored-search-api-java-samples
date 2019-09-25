
package jp.yahooapis.ss.v201909.accounttrackingurl;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for AccountTrackingUrlOperation complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="AccountTrackingUrlOperation">
 *   &lt;complexContent>
 *     &lt;extension base="{http://ss.yahooapis.jp/V201909/AccountTrackingUrl}Operation">
 *       &lt;sequence>
 *         &lt;element name="operand" type="{http://ss.yahooapis.jp/V201909/AccountTrackingUrl}AccountTrackingUrl" maxOccurs="unbounded"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AccountTrackingUrlOperation", propOrder = {
    "operand"
})
public class AccountTrackingUrlOperation
    extends Operation
{

    @XmlElement(required = true)
    protected List<AccountTrackingUrl> operand;

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
     * {@link AccountTrackingUrl }
     * 
     * 
     */
    public List<AccountTrackingUrl> getOperand() {
        if (operand == null) {
            operand = new ArrayList<AccountTrackingUrl>();
        }
        return this.operand;
    }

}

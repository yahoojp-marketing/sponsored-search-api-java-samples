
package jp.yahooapis.ss.v201909.dictionary;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;
import jp.yahooapis.ss.v201909.ReturnValue;


/**
 * <p>Java class for DisapprovalReasonValues complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="DisapprovalReasonValues">
 *   &lt;complexContent>
 *     &lt;extension base="{http://ss.yahooapis.jp/V201909}ReturnValue">
 *       &lt;sequence>
 *         &lt;element name="disapprovalReason" type="{http://ss.yahooapis.jp/V201909/Dictionary}DisapprovalReason" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DisapprovalReasonValues", propOrder = {
    "disapprovalReason"
})
public class DisapprovalReasonValues
    extends ReturnValue
{

    protected DisapprovalReason disapprovalReason;

    /**
     * Gets the value of the disapprovalReason property.
     * 
     * @return
     *     possible object is
     *     {@link DisapprovalReason }
     *     
     */
    public DisapprovalReason getDisapprovalReason() {
        return disapprovalReason;
    }

    /**
     * Sets the value of the disapprovalReason property.
     * 
     * @param value
     *     allowed object is
     *     {@link DisapprovalReason }
     *     
     */
    public void setDisapprovalReason(DisapprovalReason value) {
        this.disapprovalReason = value;
    }

}

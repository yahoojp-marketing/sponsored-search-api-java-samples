
package jp.yahooapis.ss.V6.AccountSharedService;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for AccountSharedValues complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="AccountSharedValues">
 *   &lt;complexContent>
 *     &lt;extension base="{http://ss.yahooapis.jp/V6}ReturnValue">
 *       &lt;sequence>
 *         &lt;element name="accountShared" type="{http://ss.yahooapis.jp/V6}AccountShared" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AccountSharedValues", propOrder = {
    "accountShared"
})
public class AccountSharedValues
    extends ReturnValue
{

    protected AccountShared accountShared;

    /**
     * Gets the value of the accountShared property.
     * 
     * @return
     *     possible object is
     *     {@link AccountShared }
     *     
     */
    public AccountShared getAccountShared() {
        return accountShared;
    }

    /**
     * Sets the value of the accountShared property.
     * 
     * @param value
     *     allowed object is
     *     {@link AccountShared }
     *     
     */
    public void setAccountShared(AccountShared value) {
        this.accountShared = value;
    }

}

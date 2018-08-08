
package jp.yahooapis.ss.v201808.accounttrackingurl;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;
import jp.yahooapis.ss.v201808.ReturnValue;


/**
 * <p>Java class for AccountTrackingUrlValues complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="AccountTrackingUrlValues">
 *   &lt;complexContent>
 *     &lt;extension base="{http://ss.yahooapis.jp/V201808}ReturnValue">
 *       &lt;sequence>
 *         &lt;element name="accountTrackingUrl" type="{http://ss.yahooapis.jp/V201808/AccountTrackingUrl}AccountTrackingUrl" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AccountTrackingUrlValues", propOrder = {
    "accountTrackingUrl"
})
public class AccountTrackingUrlValues
    extends ReturnValue
{

    protected AccountTrackingUrl accountTrackingUrl;

    /**
     * Gets the value of the accountTrackingUrl property.
     * 
     * @return
     *     possible object is
     *     {@link AccountTrackingUrl }
     *     
     */
    public AccountTrackingUrl getAccountTrackingUrl() {
        return accountTrackingUrl;
    }

    /**
     * Sets the value of the accountTrackingUrl property.
     * 
     * @param value
     *     allowed object is
     *     {@link AccountTrackingUrl }
     *     
     */
    public void setAccountTrackingUrl(AccountTrackingUrl value) {
        this.accountTrackingUrl = value;
    }

}

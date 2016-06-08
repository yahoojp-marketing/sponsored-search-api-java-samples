
package jp.yahooapis.ss.V6.AccountService;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for AccountStatus.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="AccountStatus">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="INPROGRESS"/>
 *     &lt;enumeration value="PENDING"/>
 *     &lt;enumeration value="WAIT_DECIDE"/>
 *     &lt;enumeration value="SUSPENDED"/>
 *     &lt;enumeration value="SERVING"/>
 *     &lt;enumeration value="ENDED"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "AccountStatus")
@XmlEnum
public enum AccountStatus {

    INPROGRESS,
    PENDING,
    WAIT_DECIDE,
    SUSPENDED,
    SERVING,
    ENDED;

    public String value() {
        return name();
    }

    public static AccountStatus fromValue(String v) {
        return valueOf(v);
    }

}

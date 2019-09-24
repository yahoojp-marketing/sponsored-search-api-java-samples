
package jp.yahooapis.ss.v201909.account;

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
 *     &lt;enumeration value="WAIT_DECIDE"/>
 *     &lt;enumeration value="SUSPENDED"/>
 *     &lt;enumeration value="SERVING"/>
 *     &lt;enumeration value="ENDED"/>
 *     &lt;enumeration value="CANCELED"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "AccountStatus")
@XmlEnum
public enum AccountStatus {

    INPROGRESS,
    WAIT_DECIDE,
    SUSPENDED,
    SERVING,
    ENDED,
    CANCELED;

    public String value() {
        return name();
    }

    public static AccountStatus fromValue(String v) {
        return valueOf(v);
    }

}

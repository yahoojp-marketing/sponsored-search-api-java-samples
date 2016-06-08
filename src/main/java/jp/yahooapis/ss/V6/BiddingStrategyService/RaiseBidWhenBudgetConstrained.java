
package jp.yahooapis.ss.V6.BiddingStrategyService;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for RaiseBidWhenBudgetConstrained.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="RaiseBidWhenBudgetConstrained">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="ACTIVE"/>
 *     &lt;enumeration value="DEACTIVE"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "RaiseBidWhenBudgetConstrained")
@XmlEnum
public enum RaiseBidWhenBudgetConstrained {

    ACTIVE,
    DEACTIVE;

    public String value() {
        return name();
    }

    public static RaiseBidWhenBudgetConstrained fromValue(String v) {
        return valueOf(v);
    }

}

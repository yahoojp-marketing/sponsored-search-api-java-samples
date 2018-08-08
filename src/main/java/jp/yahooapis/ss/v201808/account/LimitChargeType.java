
package jp.yahooapis.ss.v201808.account;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for LimitChargeType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="LimitChargeType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="SUM"/>
 *     &lt;enumeration value="MONTHLY"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "LimitChargeType")
@XmlEnum
public enum LimitChargeType {

    SUM,
    MONTHLY;

    public String value() {
        return name();
    }

    public static LimitChargeType fromValue(String v) {
        return valueOf(v);
    }

}

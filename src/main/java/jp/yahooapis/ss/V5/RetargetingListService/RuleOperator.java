
package jp.yahooapis.ss.V5.RetargetingListService;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for RuleOperator.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="RuleOperator">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="UNKNOWN"/>
 *     &lt;enumeration value="EQUALS"/>
 *     &lt;enumeration value="NOT_EQUAL"/>
 *     &lt;enumeration value="CONTAINS"/>
 *     &lt;enumeration value="NOT_CONTAIN"/>
 *     &lt;enumeration value="STARTS_WITH"/>
 *     &lt;enumeration value="NOT_START_WITH"/>
 *     &lt;enumeration value="ENDS_WITH"/>
 *     &lt;enumeration value="NOT_END_WITH"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "RuleOperator")
@XmlEnum
public enum RuleOperator {

    UNKNOWN,
    EQUALS,
    NOT_EQUAL,
    CONTAINS,
    NOT_CONTAIN,
    STARTS_WITH,
    NOT_START_WITH,
    ENDS_WITH,
    NOT_END_WITH;

    public String value() {
        return name();
    }

    public static RuleOperator fromValue(String v) {
        return valueOf(v);
    }

}

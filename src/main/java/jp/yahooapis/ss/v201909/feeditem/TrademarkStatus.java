
package jp.yahooapis.ss.v201909.feeditem;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for TrademarkStatus.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="TrademarkStatus">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="NO_RESTRICTION"/>
 *     &lt;enumeration value="CONFLICT_WITH_TRADEMARK"/>
 *     &lt;enumeration value="CLAIM_IN_PROGRESS"/>
 *     &lt;enumeration value="DISAPPROVED_CLAIM"/>
 *     &lt;enumeration value="DISAPPROVED_REVIEWER"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "TrademarkStatus")
@XmlEnum
public enum TrademarkStatus {

    NO_RESTRICTION,
    CONFLICT_WITH_TRADEMARK,
    CLAIM_IN_PROGRESS,
    DISAPPROVED_CLAIM,
    DISAPPROVED_REVIEWER;

    public String value() {
        return name();
    }

    public static TrademarkStatus fromValue(String v) {
        return valueOf(v);
    }

}

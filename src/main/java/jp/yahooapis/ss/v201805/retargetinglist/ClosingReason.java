
package jp.yahooapis.ss.v201805.retargetinglist;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ClosingReason.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="ClosingReason">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="UNUSED_LIST"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "ClosingReason")
@XmlEnum
public enum ClosingReason {

    UNUSED_LIST;

    public String value() {
        return name();
    }

    public static ClosingReason fromValue(String v) {
        return valueOf(v);
    }

}

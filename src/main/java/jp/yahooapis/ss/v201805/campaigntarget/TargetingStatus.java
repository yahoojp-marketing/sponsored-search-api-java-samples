
package jp.yahooapis.ss.v201805.campaigntarget;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for TargetingStatus.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="TargetingStatus">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="ACTIVE"/>
 *     &lt;enumeration value="OBSOLETE"/>
 *     &lt;enumeration value="PHASING_OUT"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "TargetingStatus")
@XmlEnum
public enum TargetingStatus {

    ACTIVE,
    OBSOLETE,
    PHASING_OUT;

    public String value() {
        return name();
    }

    public static TargetingStatus fromValue(String v) {
        return valueOf(v);
    }

}


package jp.yahooapis.ss.v201808.retargetinglist;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for TargetListType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="TargetListType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="DEFAULT"/>
 *     &lt;enumeration value="RULE"/>
 *     &lt;enumeration value="LOGICAL"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "TargetListType")
@XmlEnum
public enum TargetListType {

    DEFAULT,
    RULE,
    LOGICAL;

    public String value() {
        return name();
    }

    public static TargetListType fromValue(String v) {
        return valueOf(v);
    }

}

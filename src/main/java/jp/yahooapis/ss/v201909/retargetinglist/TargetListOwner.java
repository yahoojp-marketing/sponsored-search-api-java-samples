
package jp.yahooapis.ss.v201909.retargetinglist;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for TargetListOwner.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="TargetListOwner">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="OWNER"/>
 *     &lt;enumeration value="SHARED"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "TargetListOwner")
@XmlEnum
public enum TargetListOwner {

    OWNER,
    SHARED;

    public String value() {
        return name();
    }

    public static TargetListOwner fromValue(String v) {
        return valueOf(v);
    }

}


package jp.yahooapis.ss.v201909.retargetinglist;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ReachStorageStatus.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="ReachStorageStatus">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="OPEN"/>
 *     &lt;enumeration value="CLOSED"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "ReachStorageStatus")
@XmlEnum
public enum ReachStorageStatus {

    OPEN,
    CLOSED;

    public String value() {
        return name();
    }

    public static ReachStorageStatus fromValue(String v) {
        return valueOf(v);
    }

}

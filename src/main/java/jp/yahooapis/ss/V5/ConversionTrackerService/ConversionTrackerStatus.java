
package jp.yahooapis.ss.V5.ConversionTrackerService;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ConversionTrackerStatus.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="ConversionTrackerStatus">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="ENABLED"/>
 *     &lt;enumeration value="DISABLED"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "ConversionTrackerStatus")
@XmlEnum
public enum ConversionTrackerStatus {

    ENABLED,
    DISABLED;

    public String value() {
        return name();
    }

    public static ConversionTrackerStatus fromValue(String v) {
        return valueOf(v);
    }

}

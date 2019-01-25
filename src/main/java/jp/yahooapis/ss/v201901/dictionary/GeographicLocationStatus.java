
package jp.yahooapis.ss.v201901.dictionary;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for GeographicLocationStatus.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="GeographicLocationStatus">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="ACTIVE"/>
 *     &lt;enumeration value="OBSOLETE"/>
 *     &lt;enumeration value="PHASING_OUT"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "GeographicLocationStatus")
@XmlEnum
public enum GeographicLocationStatus {

    ACTIVE,
    OBSOLETE,
    PHASING_OUT;

    public String value() {
        return name();
    }

    public static GeographicLocationStatus fromValue(String v) {
        return valueOf(v);
    }

}


package jp.yahooapis.ss.v201805.campaign;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for GeoTargetType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="GeoTargetType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="DONT_CARE"/>
 *     &lt;enumeration value="AREA_OF_INTENT"/>
 *     &lt;enumeration value="LOCATION_OF_PRESENCE"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "GeoTargetType")
@XmlEnum
public enum GeoTargetType {

    DONT_CARE,
    AREA_OF_INTENT,
    LOCATION_OF_PRESENCE;

    public String value() {
        return name();
    }

    public static GeoTargetType fromValue(String v) {
        return valueOf(v);
    }

}

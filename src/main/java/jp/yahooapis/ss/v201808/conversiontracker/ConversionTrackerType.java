
package jp.yahooapis.ss.v201808.conversiontracker;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ConversionTrackerType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="ConversionTrackerType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="WEB_CONVERSION"/>
 *     &lt;enumeration value="APP_CONVERSION"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "ConversionTrackerType")
@XmlEnum
public enum ConversionTrackerType {

    WEB_CONVERSION,
    APP_CONVERSION;

    public String value() {
        return name();
    }

    public static ConversionTrackerType fromValue(String v) {
        return valueOf(v);
    }

}

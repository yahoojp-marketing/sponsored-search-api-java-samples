
package jp.yahooapis.ss.v201901.feeditem;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for DevicePreference.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="DevicePreference">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="SMART_PHONE"/>
 *     &lt;enumeration value="NONE"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "DevicePreference")
@XmlEnum
public enum DevicePreference {

    SMART_PHONE,
    NONE;

    public String value() {
        return name();
    }

    public static DevicePreference fromValue(String v) {
        return valueOf(v);
    }

}


package jp.yahooapis.ss.v201805.adgroupfeed;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for DevicePlatform.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="DevicePlatform">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="DESKTOP"/>
 *     &lt;enumeration value="SMART_PHONE"/>
 *     &lt;enumeration value="NONE"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "DevicePlatform")
@XmlEnum
public enum DevicePlatform {

    DESKTOP,
    SMART_PHONE,
    NONE;

    public String value() {
        return name();
    }

    public static DevicePlatform fromValue(String v) {
        return valueOf(v);
    }

}


package jp.yahooapis.ss.v201805.adgroupbidmultiplier;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for PlatformType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="PlatformType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="SMART_PHONE"/>
 *     &lt;enumeration value="TABLET"/>
 *     &lt;enumeration value="DESKTOP"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "PlatformType")
@XmlEnum
public enum PlatformType {

    SMART_PHONE,
    TABLET,
    DESKTOP;

    public String value() {
        return name();
    }

    public static PlatformType fromValue(String v) {
        return valueOf(v);
    }

}

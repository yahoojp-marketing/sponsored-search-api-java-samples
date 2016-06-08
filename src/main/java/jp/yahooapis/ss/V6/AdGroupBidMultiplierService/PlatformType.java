
package jp.yahooapis.ss.V6.AdGroupBidMultiplierService;

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
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "PlatformType")
@XmlEnum
public enum PlatformType {

    SMART_PHONE;

    public String value() {
        return name();
    }

    public static PlatformType fromValue(String v) {
        return valueOf(v);
    }

}

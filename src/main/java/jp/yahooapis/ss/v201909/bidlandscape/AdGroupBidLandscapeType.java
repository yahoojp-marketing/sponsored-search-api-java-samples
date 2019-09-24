
package jp.yahooapis.ss.v201909.bidlandscape;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for AdGroupBidLandscapeType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="AdGroupBidLandscapeType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="UNIFORM"/>
 *     &lt;enumeration value="DEFAULT"/>
 *     &lt;enumeration value="UNKNOWN"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "AdGroupBidLandscapeType")
@XmlEnum
public enum AdGroupBidLandscapeType {

    UNIFORM,
    DEFAULT,
    UNKNOWN;

    public String value() {
        return name();
    }

    public static AdGroupBidLandscapeType fromValue(String v) {
        return valueOf(v);
    }

}


package jp.yahooapis.ss.v201909.conversiontracker;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for TrackingCodeType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="TrackingCodeType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="WEBPAGE"/>
 *     &lt;enumeration value="CLICK_TO_CALL"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "TrackingCodeType")
@XmlEnum
public enum TrackingCodeType {

    WEBPAGE,
    CLICK_TO_CALL;

    public String value() {
        return name();
    }

    public static TrackingCodeType fromValue(String v) {
        return valueOf(v);
    }

}

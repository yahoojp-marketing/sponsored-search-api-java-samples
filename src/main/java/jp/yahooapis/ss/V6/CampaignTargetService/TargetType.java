
package jp.yahooapis.ss.V6.CampaignTargetService;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for TargetType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="TargetType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="LOCATION"/>
 *     &lt;enumeration value="SCHEDULE"/>
 *     &lt;enumeration value="NETWORK"/>
 *     &lt;enumeration value="PLATFORM"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "TargetType")
@XmlEnum
public enum TargetType {

    LOCATION,
    SCHEDULE,
    NETWORK,
    PLATFORM;

    public String value() {
        return name();
    }

    public static TargetType fromValue(String v) {
        return valueOf(v);
    }

}

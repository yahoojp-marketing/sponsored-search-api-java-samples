
package jp.yahooapis.ss.v201909.feeditem;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for FeedItemGeoRestriction.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="FeedItemGeoRestriction">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="NONE"/>
 *     &lt;enumeration value="LOCATION_OF_PRESENCE"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "FeedItemGeoRestriction")
@XmlEnum
public enum FeedItemGeoRestriction {

    NONE,
    LOCATION_OF_PRESENCE;

    public String value() {
        return name();
    }

    public static FeedItemGeoRestriction fromValue(String v) {
        return valueOf(v);
    }

}

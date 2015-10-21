
package jp.yahooapis.ss.V5.ReportDefinitionService;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ReportType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="ReportType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="ACCOUNT"/>
 *     &lt;enumeration value="CAMPAIGN"/>
 *     &lt;enumeration value="ADGROUP"/>
 *     &lt;enumeration value="AD"/>
 *     &lt;enumeration value="KEYWORDS"/>
 *     &lt;enumeration value="SEARCH_QUERY"/>
 *     &lt;enumeration value="DESTINATION_URL"/>
 *     &lt;enumeration value="GEO"/>
 *     &lt;enumeration value="FEED_ITEM"/>
 *     &lt;enumeration value="GEO_TARGET"/>
 *     &lt;enumeration value="SCHEDULE_TARGET"/>
 *     &lt;enumeration value="DEVICE_TARGET"/>
 *     &lt;enumeration value="BID_STRATEGY"/>
 *     &lt;enumeration value="AD_CUSTOMIZERS"/>
 *     &lt;enumeration value="TARGET_LIST"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "ReportType")
@XmlEnum
public enum ReportType {

    ACCOUNT,
    CAMPAIGN,
    ADGROUP,
    AD,
    KEYWORDS,
    SEARCH_QUERY,
    DESTINATION_URL,
    GEO,
    FEED_ITEM,
    GEO_TARGET,
    SCHEDULE_TARGET,
    DEVICE_TARGET,
    BID_STRATEGY,
    AD_CUSTOMIZERS,
    TARGET_LIST;

    public String value() {
        return name();
    }

    public static ReportType fromValue(String v) {
        return valueOf(v);
    }

}

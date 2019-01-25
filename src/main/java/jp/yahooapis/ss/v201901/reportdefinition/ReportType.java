
package jp.yahooapis.ss.v201901.reportdefinition;

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
 *     &lt;enumeration value="GEO"/>
 *     &lt;enumeration value="FEED_ITEM"/>
 *     &lt;enumeration value="GEO_TARGET"/>
 *     &lt;enumeration value="SCHEDULE_TARGET"/>
 *     &lt;enumeration value="BID_STRATEGY"/>
 *     &lt;enumeration value="AD_CUSTOMIZERS"/>
 *     &lt;enumeration value="TARGET_LIST"/>
 *     &lt;enumeration value="LANDING_PAGE_URL"/>
 *     &lt;enumeration value="KEYWORDLESS_QUERY"/>
 *     &lt;enumeration value="WEBPAGE_CRITERION"/>
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
    GEO,
    FEED_ITEM,
    GEO_TARGET,
    SCHEDULE_TARGET,
    BID_STRATEGY,
    AD_CUSTOMIZERS,
    TARGET_LIST,
    LANDING_PAGE_URL,
    KEYWORDLESS_QUERY,
    WEBPAGE_CRITERION;

    public String value() {
        return name();
    }

    public static ReportType fromValue(String v) {
        return valueOf(v);
    }

}

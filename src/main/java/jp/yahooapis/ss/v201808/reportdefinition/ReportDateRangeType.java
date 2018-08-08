
package jp.yahooapis.ss.v201808.reportdefinition;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ReportDateRangeType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="ReportDateRangeType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="TODAY"/>
 *     &lt;enumeration value="YESTERDAY"/>
 *     &lt;enumeration value="LAST_7_DAYS"/>
 *     &lt;enumeration value="LAST_WEEK"/>
 *     &lt;enumeration value="LAST_14_DAYS"/>
 *     &lt;enumeration value="LAST_30_DAYS"/>
 *     &lt;enumeration value="LAST_BUSINESS_WEEK"/>
 *     &lt;enumeration value="THIS_MONTH"/>
 *     &lt;enumeration value="LAST_MONTH"/>
 *     &lt;enumeration value="ALL_TIME"/>
 *     &lt;enumeration value="CUSTOM_DATE"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "ReportDateRangeType")
@XmlEnum
public enum ReportDateRangeType {

    TODAY,
    YESTERDAY,
    LAST_7_DAYS,
    LAST_WEEK,
    LAST_14_DAYS,
    LAST_30_DAYS,
    LAST_BUSINESS_WEEK,
    THIS_MONTH,
    LAST_MONTH,
    ALL_TIME,
    CUSTOM_DATE;

    public String value() {
        return name();
    }

    public static ReportDateRangeType fromValue(String v) {
        return valueOf(v);
    }

}

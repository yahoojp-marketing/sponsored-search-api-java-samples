
package jp.yahooapis.ss.v201805.reportdefinition;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ReportIncludeZeroImpressions.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="ReportIncludeZeroImpressions">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="TRUE"/>
 *     &lt;enumeration value="FALSE"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "ReportIncludeZeroImpressions")
@XmlEnum
public enum ReportIncludeZeroImpressions {

    TRUE,
    FALSE;

    public String value() {
        return name();
    }

    public static ReportIncludeZeroImpressions fromValue(String v) {
        return valueOf(v);
    }

}

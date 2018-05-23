
package jp.yahooapis.ss.v201805.reportdefinition;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ReportIncludeDeleted.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="ReportIncludeDeleted">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="TRUE"/>
 *     &lt;enumeration value="FALSE"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "ReportIncludeDeleted")
@XmlEnum
public enum ReportIncludeDeleted {

    TRUE,
    FALSE;

    public String value() {
        return name();
    }

    public static ReportIncludeDeleted fromValue(String v) {
        return valueOf(v);
    }

}

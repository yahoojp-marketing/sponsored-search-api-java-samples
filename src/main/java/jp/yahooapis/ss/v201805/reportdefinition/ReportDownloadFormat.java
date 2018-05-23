
package jp.yahooapis.ss.v201805.reportdefinition;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ReportDownloadFormat.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="ReportDownloadFormat">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="CSV"/>
 *     &lt;enumeration value="XML"/>
 *     &lt;enumeration value="TSV"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "ReportDownloadFormat")
@XmlEnum
public enum ReportDownloadFormat {

    CSV,
    XML,
    TSV;

    public String value() {
        return name();
    }

    public static ReportDownloadFormat fromValue(String v) {
        return valueOf(v);
    }

}

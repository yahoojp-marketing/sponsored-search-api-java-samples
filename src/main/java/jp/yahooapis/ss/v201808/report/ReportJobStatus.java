
package jp.yahooapis.ss.v201808.report;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ReportJobStatus.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="ReportJobStatus">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="WAIT"/>
 *     &lt;enumeration value="COMPLETED"/>
 *     &lt;enumeration value="IN_PROGRESS"/>
 *     &lt;enumeration value="FAILED"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "ReportJobStatus")
@XmlEnum
public enum ReportJobStatus {

    WAIT,
    COMPLETED,
    IN_PROGRESS,
    FAILED;

    public String value() {
        return name();
    }

    public static ReportJobStatus fromValue(String v) {
        return valueOf(v);
    }

}

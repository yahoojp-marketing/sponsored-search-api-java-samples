
package jp.yahooapis.ss.v201901.auditlog;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for AuditLogOutput.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="AuditLogOutput">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="CSV"/>
 *     &lt;enumeration value="TSV"/>
 *     &lt;enumeration value="ZIPPED_CSV"/>
 *     &lt;enumeration value="ZIPPED_TSV"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "AuditLogOutput")
@XmlEnum
public enum AuditLogOutput {

    CSV,
    TSV,
    ZIPPED_CSV,
    ZIPPED_TSV;

    public String value() {
        return name();
    }

    public static AuditLogOutput fromValue(String v) {
        return valueOf(v);
    }

}

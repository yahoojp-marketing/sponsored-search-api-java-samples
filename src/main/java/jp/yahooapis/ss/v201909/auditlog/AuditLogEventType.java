
package jp.yahooapis.ss.v201909.auditlog;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for AuditLogEventType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="AuditLogEventType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="ADD"/>
 *     &lt;enumeration value="SET"/>
 *     &lt;enumeration value="REMOVE"/>
 *     &lt;enumeration value="ALL"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "AuditLogEventType")
@XmlEnum
public enum AuditLogEventType {

    ADD,
    SET,
    REMOVE,
    ALL;

    public String value() {
        return name();
    }

    public static AuditLogEventType fromValue(String v) {
        return valueOf(v);
    }

}

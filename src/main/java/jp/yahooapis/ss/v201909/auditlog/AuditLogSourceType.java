
package jp.yahooapis.ss.v201909.auditlog;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for AuditLogSourceType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="AuditLogSourceType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="API"/>
 *     &lt;enumeration value="YAHOO_JAPAN"/>
 *     &lt;enumeration value="CAMPAIGN_MANAGEMENT_TOOL"/>
 *     &lt;enumeration value="ALL"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "AuditLogSourceType")
@XmlEnum
public enum AuditLogSourceType {

    API,
    YAHOO_JAPAN,
    CAMPAIGN_MANAGEMENT_TOOL,
    ALL;

    public String value() {
        return name();
    }

    public static AuditLogSourceType fromValue(String v) {
        return valueOf(v);
    }

}

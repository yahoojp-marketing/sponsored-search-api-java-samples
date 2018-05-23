
package jp.yahooapis.ss.v201805.auditlog;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for AuditLogEncoding.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="AuditLogEncoding">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="SJIS"/>
 *     &lt;enumeration value="UTF_8"/>
 *     &lt;enumeration value="UTF_16LE"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "AuditLogEncoding")
@XmlEnum
public enum AuditLogEncoding {

    SJIS("SJIS"),
    UTF_8("UTF_8"),
    @XmlEnumValue("UTF_16LE")
    UTF_16_LE("UTF_16LE");
    private final String value;

    AuditLogEncoding(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static AuditLogEncoding fromValue(String v) {
        for (AuditLogEncoding c: AuditLogEncoding.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}


package jp.yahooapis.ss.V6.CustomerSyncService;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for IncludeUnset.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="IncludeUnset">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="INCLUDED"/>
 *     &lt;enumeration value="EXCLUDE"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "IncludeUnset")
@XmlEnum
public enum IncludeUnset {

    INCLUDED,
    EXCLUDE;

    public String value() {
        return name();
    }

    public static IncludeUnset fromValue(String v) {
        return valueOf(v);
    }

}

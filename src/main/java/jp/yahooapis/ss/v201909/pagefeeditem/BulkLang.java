
package jp.yahooapis.ss.v201909.pagefeeditem;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for BulkLang.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="BulkLang">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="JA"/>
 *     &lt;enumeration value="EN"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "BulkLang")
@XmlEnum
public enum BulkLang {

    JA,
    EN;

    public String value() {
        return name();
    }

    public static BulkLang fromValue(String v) {
        return valueOf(v);
    }

}

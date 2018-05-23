
package jp.yahooapis.ss.v201805.campaignexport;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for Encoding.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="Encoding">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="UTF-8"/>
 *     &lt;enumeration value="SJIS"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "Encoding")
@XmlEnum
public enum Encoding {

    @XmlEnumValue("UTF-8")
    UTF_8("UTF-8"),
    SJIS("SJIS");
    private final String value;

    Encoding(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static Encoding fromValue(String v) {
        for (Encoding c: Encoding.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}


package jp.yahooapis.ss.V5.BulkService;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for BulkEncoding.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="BulkEncoding">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="UTF-8"/>
 *     &lt;enumeration value="SJIS"/>
 *     &lt;enumeration value="EUC"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "BulkEncoding")
@XmlEnum
public enum BulkEncoding {

    @XmlEnumValue("UTF-8")
    UTF_8("UTF-8"),
    SJIS("SJIS"),
    EUC("EUC");
    private final String value;

    BulkEncoding(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static BulkEncoding fromValue(String v) {
        for (BulkEncoding c: BulkEncoding.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}

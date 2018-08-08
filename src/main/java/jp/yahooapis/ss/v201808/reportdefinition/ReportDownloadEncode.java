
package jp.yahooapis.ss.v201808.reportdefinition;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ReportDownloadEncode.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="ReportDownloadEncode">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="UTF-8"/>
 *     &lt;enumeration value="SJIS"/>
 *     &lt;enumeration value="EUC"/>
 *     &lt;enumeration value="UTF16LE"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "ReportDownloadEncode")
@XmlEnum
public enum ReportDownloadEncode {

    @XmlEnumValue("UTF-8")
    UTF_8("UTF-8"),
    SJIS("SJIS"),
    EUC("EUC"),
    @XmlEnumValue("UTF16LE")
    UTF_16_LE("UTF16LE");
    private final String value;

    ReportDownloadEncode(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static ReportDownloadEncode fromValue(String v) {
        for (ReportDownloadEncode c: ReportDownloadEncode.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}

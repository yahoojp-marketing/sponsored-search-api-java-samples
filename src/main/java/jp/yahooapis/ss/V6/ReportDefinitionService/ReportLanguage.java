
package jp.yahooapis.ss.V6.ReportDefinitionService;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ReportLanguage.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="ReportLanguage">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="JA"/>
 *     &lt;enumeration value="EN"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "ReportLanguage")
@XmlEnum
public enum ReportLanguage {

    JA,
    EN;

    public String value() {
        return name();
    }

    public static ReportLanguage fromValue(String v) {
        return valueOf(v);
    }

}

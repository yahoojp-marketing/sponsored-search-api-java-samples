
package jp.yahooapis.ss.V5.ReportDefinitionService;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ReportZip.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="ReportZip">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="ON"/>
 *     &lt;enumeration value="OFF"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "ReportZip")
@XmlEnum
public enum ReportZip {

    ON,
    OFF;

    public String value() {
        return name();
    }

    public static ReportZip fromValue(String v) {
        return valueOf(v);
    }

}


package jp.yahooapis.ss.V6.ReportDefinitionService;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ReportIsTemplate.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="ReportIsTemplate">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="TRUE"/>
 *     &lt;enumeration value="FALSE"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "ReportIsTemplate")
@XmlEnum
public enum ReportIsTemplate {

    TRUE,
    FALSE;

    public String value() {
        return name();
    }

    public static ReportIsTemplate fromValue(String v) {
        return valueOf(v);
    }

}

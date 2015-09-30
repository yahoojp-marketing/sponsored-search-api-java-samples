
package jp.yahooapis.ss.V5.ReportDefinitionService;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ReportAddTemplate.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="ReportAddTemplate">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="YES"/>
 *     &lt;enumeration value="NO"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "ReportAddTemplate")
@XmlEnum
public enum ReportAddTemplate {

    YES,
    NO;

    public String value() {
        return name();
    }

    public static ReportAddTemplate fromValue(String v) {
        return valueOf(v);
    }

}

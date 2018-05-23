
package jp.yahooapis.ss.v201805.conversiontracker;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for MarkupLanguage.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="MarkupLanguage">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="HTML"/>
 *     &lt;enumeration value="CHTML"/>
 *     &lt;enumeration value="XHTML"/>
 *     &lt;enumeration value="WML"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "MarkupLanguage")
@XmlEnum
public enum MarkupLanguage {

    HTML,
    CHTML,
    XHTML,
    WML;

    public String value() {
        return name();
    }

    public static MarkupLanguage fromValue(String v) {
        return valueOf(v);
    }

}

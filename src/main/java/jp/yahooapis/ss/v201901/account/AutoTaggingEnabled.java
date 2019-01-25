
package jp.yahooapis.ss.v201901.account;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for AutoTaggingEnabled.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="AutoTaggingEnabled">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="FALSE"/>
 *     &lt;enumeration value="TRUE"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "AutoTaggingEnabled")
@XmlEnum
public enum AutoTaggingEnabled {

    FALSE,
    TRUE;

    public String value() {
        return name();
    }

    public static AutoTaggingEnabled fromValue(String v) {
        return valueOf(v);
    }

}

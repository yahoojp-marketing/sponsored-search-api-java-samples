
package jp.yahooapis.ss.v201901.campaign;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for EnhancedCpcEnabled.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="EnhancedCpcEnabled">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="FALSE"/>
 *     &lt;enumeration value="TRUE"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "EnhancedCpcEnabled")
@XmlEnum
public enum EnhancedCpcEnabled {

    FALSE,
    TRUE;

    public String value() {
        return name();
    }

    public static EnhancedCpcEnabled fromValue(String v) {
        return valueOf(v);
    }

}


package jp.yahooapis.ss.V6.AdGroupAdService;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for IsRemove.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="IsRemove">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="TRUE"/>
 *     &lt;enumeration value="FALSE"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "IsRemove")
@XmlEnum
public enum IsRemove {

    TRUE,
    FALSE;

    public String value() {
        return name();
    }

    public static IsRemove fromValue(String v) {
        return valueOf(v);
    }

}

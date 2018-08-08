
package jp.yahooapis.ss.v201808.adgroup;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for AdRotationMode.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="AdRotationMode">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="OPTIMIZE"/>
 *     &lt;enumeration value="ROTATE_FOREVER"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "AdRotationMode")
@XmlEnum
public enum AdRotationMode {

    OPTIMIZE,
    ROTATE_FOREVER;

    public String value() {
        return name();
    }

    public static AdRotationMode fromValue(String v) {
        return valueOf(v);
    }

}

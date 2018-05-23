
package jp.yahooapis.ss.v201805.keywordestimator;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for IsNegativeBool.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="IsNegativeBool">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="TRUE"/>
 *     &lt;enumeration value="FALSE"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "IsNegativeBool")
@XmlEnum
public enum IsNegativeBool {

    TRUE,
    FALSE;

    public String value() {
        return name();
    }

    public static IsNegativeBool fromValue(String v) {
        return valueOf(v);
    }

}

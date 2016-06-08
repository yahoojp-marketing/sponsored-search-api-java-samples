
package jp.yahooapis.ss.V6.TargetingIdeaService;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for AttributeType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="AttributeType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="KEYWORD"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "AttributeType")
@XmlEnum
public enum AttributeType {

    KEYWORD;

    public String value() {
        return name();
    }

    public static AttributeType fromValue(String v) {
        return valueOf(v);
    }

}

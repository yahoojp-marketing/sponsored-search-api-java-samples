
package jp.yahooapis.ss.v201909.label;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for CountLabeledEntity.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="CountLabeledEntity">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="TRUE"/>
 *     &lt;enumeration value="FALSE"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "CountLabeledEntity")
@XmlEnum
public enum CountLabeledEntity {

    TRUE,
    FALSE;

    public String value() {
        return name();
    }

    public static CountLabeledEntity fromValue(String v) {
        return valueOf(v);
    }

}

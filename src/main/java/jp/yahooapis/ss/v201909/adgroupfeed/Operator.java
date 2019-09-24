
package jp.yahooapis.ss.v201909.adgroupfeed;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for Operator.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="Operator">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="SET"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "Operator")
@XmlEnum
public enum Operator {

    SET;

    public String value() {
        return name();
    }

    public static Operator fromValue(String v) {
        return valueOf(v);
    }

}

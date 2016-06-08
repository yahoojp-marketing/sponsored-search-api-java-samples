
package jp.yahooapis.ss.V6.ConversionTrackerService;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for CountingType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="CountingType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="ONE_PER_CLICK"/>
 *     &lt;enumeration value="MANY_PER_CLICK"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "CountingType")
@XmlEnum
public enum CountingType {

    ONE_PER_CLICK,
    MANY_PER_CLICK;

    public String value() {
        return name();
    }

    public static CountingType fromValue(String v) {
        return valueOf(v);
    }

}

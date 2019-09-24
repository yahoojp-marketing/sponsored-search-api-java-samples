
package jp.yahooapis.ss.v201909.conversiontracker;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ConversionCountingType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="ConversionCountingType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="ONE_PER_CLICK"/>
 *     &lt;enumeration value="MANY_PER_CLICK"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "ConversionCountingType")
@XmlEnum
public enum ConversionCountingType {

    ONE_PER_CLICK,
    MANY_PER_CLICK;

    public String value() {
        return name();
    }

    public static ConversionCountingType fromValue(String v) {
        return valueOf(v);
    }

}

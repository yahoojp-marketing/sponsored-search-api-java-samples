
package jp.yahooapis.ss.v201909.conversiontracker;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ExcludeFromBidding.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="ExcludeFromBidding">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="TRUE"/>
 *     &lt;enumeration value="FALSE"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "ExcludeFromBidding")
@XmlEnum
public enum ExcludeFromBidding {

    TRUE,
    FALSE;

    public String value() {
        return name();
    }

    public static ExcludeFromBidding fromValue(String v) {
        return valueOf(v);
    }

}

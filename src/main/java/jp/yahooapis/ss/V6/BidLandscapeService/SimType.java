
package jp.yahooapis.ss.V6.BidLandscapeService;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for SimType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="SimType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="ADGROUP"/>
 *     &lt;enumeration value="CRITERION"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "SimType")
@XmlEnum
public enum SimType {

    ADGROUP,
    CRITERION;

    public String value() {
        return name();
    }

    public static SimType fromValue(String v) {
        return valueOf(v);
    }

}


package jp.yahooapis.ss.V6.TrafficEstimatorService;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for WapType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="WapType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="WAP_ONLY"/>
 *     &lt;enumeration value="WAP_INCLUDED"/>
 *     &lt;enumeration value="WAP_NONE"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "WapType")
@XmlEnum
public enum WapType {

    WAP_ONLY,
    WAP_INCLUDED,
    WAP_NONE;

    public String value() {
        return name();
    }

    public static WapType fromValue(String v) {
        return valueOf(v);
    }

}

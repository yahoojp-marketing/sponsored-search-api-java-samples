
package jp.yahooapis.ss.V5.TrafficEstimatorService;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for EstimateResultType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="EstimateResultType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="TOTAL"/>
 *     &lt;enumeration value="DESKTOP"/>
 *     &lt;enumeration value="SMART_PHONE"/>
 *     &lt;enumeration value="WAP_MOBILE"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "EstimateResultType")
@XmlEnum
public enum EstimateResultType {

    TOTAL,
    DESKTOP,
    SMART_PHONE,
    WAP_MOBILE;

    public String value() {
        return name();
    }

    public static EstimateResultType fromValue(String v) {
        return valueOf(v);
    }

}


package jp.yahooapis.ss.V6.TrafficEstimatorService;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for EstimateNetwork.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="EstimateNetwork">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="YAHOO_SEARCH"/>
 *     &lt;enumeration value="ALL"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "EstimateNetwork")
@XmlEnum
public enum EstimateNetwork {

    YAHOO_SEARCH,
    ALL;

    public String value() {
        return name();
    }

    public static EstimateNetwork fromValue(String v) {
        return valueOf(v);
    }

}

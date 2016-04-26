
package jp.yahooapis.ss.V6.AdGroupBidMultiplierService;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for BidMultiplierType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="BidMultiplierType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="PLATFORM"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "BidMultiplierType")
@XmlEnum
public enum BidMultiplierType {

    PLATFORM;

    public String value() {
        return name();
    }

    public static BidMultiplierType fromValue(String v) {
        return valueOf(v);
    }

}

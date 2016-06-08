
package jp.yahooapis.ss.V6.AdGroupCriterionService;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for BidSource.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="BidSource">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="ADGROUP"/>
 *     &lt;enumeration value="CRITERION"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "BidSource")
@XmlEnum
public enum BidSource {

    ADGROUP,
    CRITERION;

    public String value() {
        return name();
    }

    public static BidSource fromValue(String v) {
        return valueOf(v);
    }

}

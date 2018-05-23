
package jp.yahooapis.ss.v201805.biddingstrategy;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for BiddingStrategyType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="BiddingStrategyType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="PAGE_ONE_PROMOTED"/>
 *     &lt;enumeration value="TARGET_ROAS"/>
 *     &lt;enumeration value="TARGET_SPEND"/>
 *     &lt;enumeration value="TARGET_CPA"/>
 *     &lt;enumeration value="ENHANCED_CPC"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "BiddingStrategyType")
@XmlEnum
public enum BiddingStrategyType {

    PAGE_ONE_PROMOTED,
    TARGET_ROAS,
    TARGET_SPEND,
    TARGET_CPA,
    ENHANCED_CPC;

    public String value() {
        return name();
    }

    public static BiddingStrategyType fromValue(String v) {
        return valueOf(v);
    }

}

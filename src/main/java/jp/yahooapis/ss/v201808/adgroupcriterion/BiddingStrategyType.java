
package jp.yahooapis.ss.v201808.adgroupcriterion;

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
 *     &lt;enumeration value="MANUAL_CPC"/>
 *     &lt;enumeration value="BUDGET_OPTIMIZER"/>
 *     &lt;enumeration value="PAGE_ONE_PROMOTED"/>
 *     &lt;enumeration value="TARGET_ROAS"/>
 *     &lt;enumeration value="TARGET_SPEND"/>
 *     &lt;enumeration value="ENHANCED_CPC"/>
 *     &lt;enumeration value="TARGET_CPA"/>
 *     &lt;enumeration value="NONE"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "BiddingStrategyType")
@XmlEnum
public enum BiddingStrategyType {

    MANUAL_CPC,
    BUDGET_OPTIMIZER,
    PAGE_ONE_PROMOTED,
    TARGET_ROAS,
    TARGET_SPEND,
    ENHANCED_CPC,
    TARGET_CPA,
    NONE;

    public String value() {
        return name();
    }

    public static BiddingStrategyType fromValue(String v) {
        return valueOf(v);
    }

}

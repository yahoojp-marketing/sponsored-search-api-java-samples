
package jp.yahooapis.ss.v201805.adgroupcriterion;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for BiddingStrategyFailedReason.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="BiddingStrategyFailedReason">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="FAILURE"/>
 *     &lt;enumeration value="CONVERSION_TRACKING_NOT_ENABLED"/>
 *     &lt;enumeration value="NOT_ENOUGH_CONVERSIONS"/>
 *     &lt;enumeration value="CANNOT_CREATE_CAMPAIGN_WITH_CONVERSION_OPTIMIZER"/>
 *     &lt;enumeration value="BIDDING_STRATEGY_CANNOT_BE_OVERRIDDEN"/>
 *     &lt;enumeration value="NOT_CPC_CAMPAIGN"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "BiddingStrategyFailedReason")
@XmlEnum
public enum BiddingStrategyFailedReason {

    FAILURE,
    CONVERSION_TRACKING_NOT_ENABLED,
    NOT_ENOUGH_CONVERSIONS,
    CANNOT_CREATE_CAMPAIGN_WITH_CONVERSION_OPTIMIZER,
    BIDDING_STRATEGY_CANNOT_BE_OVERRIDDEN,
    NOT_CPC_CAMPAIGN;

    public String value() {
        return name();
    }

    public static BiddingStrategyFailedReason fromValue(String v) {
        return valueOf(v);
    }

}

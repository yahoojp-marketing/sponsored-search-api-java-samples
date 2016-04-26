
package jp.yahooapis.ss.V6.CampaignService;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ConversionOptimizerEligibility.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="ConversionOptimizerEligibility">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="ENABLE"/>
 *     &lt;enumeration value="DISABLE"/>
 *     &lt;enumeration value="CAMPAIGN_IS_NOT_ACTIVE"/>
 *     &lt;enumeration value="NOT_CPC_CAMPAIGN"/>
 *     &lt;enumeration value="CONVERSION_TRACKING_NOT_ENABLED"/>
 *     &lt;enumeration value="NOT_ENOUGH_CONVERSIONS"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "ConversionOptimizerEligibility")
@XmlEnum
public enum ConversionOptimizerEligibility {

    ENABLE,
    DISABLE,
    CAMPAIGN_IS_NOT_ACTIVE,
    NOT_CPC_CAMPAIGN,
    CONVERSION_TRACKING_NOT_ENABLED,
    NOT_ENOUGH_CONVERSIONS;

    public String value() {
        return name();
    }

    public static ConversionOptimizerEligibility fromValue(String v) {
        return valueOf(v);
    }

}

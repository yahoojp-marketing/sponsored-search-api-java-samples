
package jp.yahooapis.ss.v201909.campaigncriterion;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for CampaignCriterionUse.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="CampaignCriterionUse">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="NEGATIVE"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "CampaignCriterionUse")
@XmlEnum
public enum CampaignCriterionUse {

    NEGATIVE;

    public String value() {
        return name();
    }

    public static CampaignCriterionUse fromValue(String v) {
        return valueOf(v);
    }

}

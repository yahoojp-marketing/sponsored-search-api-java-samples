
package jp.yahooapis.ss.v201901.campaign;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for CampaignType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="CampaignType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="STANDARD"/>
 *     &lt;enumeration value="MOBILE_APP"/>
 *     &lt;enumeration value="DYNAMIC_ADS_FOR_SEARCH"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "CampaignType")
@XmlEnum
public enum CampaignType {

    STANDARD,
    MOBILE_APP,
    DYNAMIC_ADS_FOR_SEARCH;

    public String value() {
        return name();
    }

    public static CampaignType fromValue(String v) {
        return valueOf(v);
    }

}

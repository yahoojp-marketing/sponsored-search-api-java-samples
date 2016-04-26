
package jp.yahooapis.ss.V6.CampaignService;

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
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "CampaignType")
@XmlEnum
public enum CampaignType {

    STANDARD,
    MOBILE_APP;

    public String value() {
        return name();
    }

    public static CampaignType fromValue(String v) {
        return valueOf(v);
    }

}

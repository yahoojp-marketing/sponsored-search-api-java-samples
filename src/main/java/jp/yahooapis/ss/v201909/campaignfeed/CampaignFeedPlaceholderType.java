
package jp.yahooapis.ss.v201909.campaignfeed;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for CampaignFeedPlaceholderType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="CampaignFeedPlaceholderType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="QUICKLINK"/>
 *     &lt;enumeration value="CALLEXTENSION"/>
 *     &lt;enumeration value="CALLOUT"/>
 *     &lt;enumeration value="STRUCTURED_SNIPPET"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "CampaignFeedPlaceholderType")
@XmlEnum
public enum CampaignFeedPlaceholderType {

    QUICKLINK,
    CALLEXTENSION,
    CALLOUT,
    STRUCTURED_SNIPPET;

    public String value() {
        return name();
    }

    public static CampaignFeedPlaceholderType fromValue(String v) {
        return valueOf(v);
    }

}

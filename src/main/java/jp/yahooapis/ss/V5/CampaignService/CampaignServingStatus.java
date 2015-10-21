
package jp.yahooapis.ss.V5.CampaignService;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for CampaignServingStatus.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="CampaignServingStatus">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="SERVING"/>
 *     &lt;enumeration value="ENDED"/>
 *     &lt;enumeration value="PENDING"/>
 *     &lt;enumeration value="STOP"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "CampaignServingStatus")
@XmlEnum
public enum CampaignServingStatus {

    SERVING,
    ENDED,
    PENDING,
    STOP;

    public String value() {
        return name();
    }

    public static CampaignServingStatus fromValue(String v) {
        return valueOf(v);
    }

}


package jp.yahooapis.ss.V5.CampaignService;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for BidChangesForRaisesOnly.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="BidChangesForRaisesOnly">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="ACTIVE"/>
 *     &lt;enumeration value="DEACTIVE"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "BidChangesForRaisesOnly")
@XmlEnum
public enum BidChangesForRaisesOnly {

    ACTIVE,
    DEACTIVE;

    public String value() {
        return name();
    }

    public static BidChangesForRaisesOnly fromValue(String v) {
        return valueOf(v);
    }

}

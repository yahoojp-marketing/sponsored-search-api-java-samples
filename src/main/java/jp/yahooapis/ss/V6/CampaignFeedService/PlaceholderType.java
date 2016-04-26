
package jp.yahooapis.ss.V6.CampaignFeedService;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for PlaceholderType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="PlaceholderType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="QUICKLINK"/>
 *     &lt;enumeration value="CALLEXTENSION"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "PlaceholderType")
@XmlEnum
public enum PlaceholderType {

    QUICKLINK,
    CALLEXTENSION;

    public String value() {
        return name();
    }

    public static PlaceholderType fromValue(String v) {
        return valueOf(v);
    }

}

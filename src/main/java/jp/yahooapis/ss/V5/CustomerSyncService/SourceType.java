
package jp.yahooapis.ss.V5.CustomerSyncService;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for SourceType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="SourceType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="CAMPAIGN_MANAGEMENT_TOOL"/>
 *     &lt;enumeration value="YAHOO!JAPAN_KK"/>
 *     &lt;enumeration value="API"/>
 *     &lt;enumeration value="BULKUPLOAD"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "SourceType")
@XmlEnum
public enum SourceType {

    CAMPAIGN_MANAGEMENT_TOOL("CAMPAIGN_MANAGEMENT_TOOL"),
    @XmlEnumValue("YAHOO!JAPAN_KK")
    YAHOO_JAPAN_KK("YAHOO!JAPAN_KK"),
    API("API"),
    BULKUPLOAD("BULKUPLOAD");
    private final String value;

    SourceType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static SourceType fromValue(String v) {
        for (SourceType c: SourceType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}

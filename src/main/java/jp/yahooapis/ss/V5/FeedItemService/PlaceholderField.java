
package jp.yahooapis.ss.V5.FeedItemService;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for PlaceholderField.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="PlaceholderField">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="LINK_TEXT"/>
 *     &lt;enumeration value="LINK_URL"/>
 *     &lt;enumeration value="CALL_PHONE_NUMBER"/>
 *     &lt;enumeration value="AD_CUSTOMIZER_INTEGER"/>
 *     &lt;enumeration value="AD_CUSTOMIZER_PRICE"/>
 *     &lt;enumeration value="AD_CUSTOMIZER_DATE"/>
 *     &lt;enumeration value="AD_CUSTOMIZER_STRING"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "PlaceholderField")
@XmlEnum
public enum PlaceholderField {

    LINK_TEXT,
    LINK_URL,
    CALL_PHONE_NUMBER,
    AD_CUSTOMIZER_INTEGER,
    AD_CUSTOMIZER_PRICE,
    AD_CUSTOMIZER_DATE,
    AD_CUSTOMIZER_STRING;

    public String value() {
        return name();
    }

    public static PlaceholderField fromValue(String v) {
        return valueOf(v);
    }

}

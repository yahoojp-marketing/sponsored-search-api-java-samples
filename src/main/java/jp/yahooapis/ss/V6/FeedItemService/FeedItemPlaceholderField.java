
package jp.yahooapis.ss.V6.FeedItemService;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for FeedItemPlaceholderField.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="FeedItemPlaceholderField">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="LINK_TEXT"/>
 *     &lt;enumeration value="LINK_URL"/>
 *     &lt;enumeration value="ADVANCED_URL"/>
 *     &lt;enumeration value="ADVANCED_MOBILE_URL"/>
 *     &lt;enumeration value="TRACKING_URL"/>
 *     &lt;enumeration value="CALL_PHONE_NUMBER"/>
 *     &lt;enumeration value="AD_CUSTOMIZER_INTEGER"/>
 *     &lt;enumeration value="AD_CUSTOMIZER_PRICE"/>
 *     &lt;enumeration value="AD_CUSTOMIZER_DATE"/>
 *     &lt;enumeration value="AD_CUSTOMIZER_STRING"/>
 *     &lt;enumeration value="CALLOUT_TEXT"/>
 *     &lt;enumeration value="ADDITIONAL_ADVANCED_URLS"/>
 *     &lt;enumeration value="ADDITIONAL_ADVANCED_MOBILE_URLS"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "FeedItemPlaceholderField")
@XmlEnum
public enum FeedItemPlaceholderField {

    LINK_TEXT,
    LINK_URL,
    ADVANCED_URL,
    ADVANCED_MOBILE_URL,
    TRACKING_URL,
    CALL_PHONE_NUMBER,
    AD_CUSTOMIZER_INTEGER,
    AD_CUSTOMIZER_PRICE,
    AD_CUSTOMIZER_DATE,
    AD_CUSTOMIZER_STRING,
    CALLOUT_TEXT,
    ADDITIONAL_ADVANCED_URLS,
    ADDITIONAL_ADVANCED_MOBILE_URLS;

    public String value() {
        return name();
    }

    public static FeedItemPlaceholderField fromValue(String v) {
        return valueOf(v);
    }

}


package jp.yahooapis.ss.v201909.feeditem;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for FeedItemPlaceholderType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="FeedItemPlaceholderType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="QUICKLINK"/>
 *     &lt;enumeration value="CALLEXTENSION"/>
 *     &lt;enumeration value="AD_CUSTOMIZER"/>
 *     &lt;enumeration value="CALLOUT"/>
 *     &lt;enumeration value="STRUCTURED_SNIPPET"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "FeedItemPlaceholderType")
@XmlEnum
public enum FeedItemPlaceholderType {

    QUICKLINK,
    CALLEXTENSION,
    AD_CUSTOMIZER,
    CALLOUT,
    STRUCTURED_SNIPPET;

    public String value() {
        return name();
    }

    public static FeedItemPlaceholderType fromValue(String v) {
        return valueOf(v);
    }

}

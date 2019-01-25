
package jp.yahooapis.ss.v201901.adgroupfeed;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for AdGroupFeedPlaceholderType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="AdGroupFeedPlaceholderType">
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
@XmlType(name = "AdGroupFeedPlaceholderType")
@XmlEnum
public enum AdGroupFeedPlaceholderType {

    QUICKLINK,
    CALLEXTENSION,
    CALLOUT,
    STRUCTURED_SNIPPET;

    public String value() {
        return name();
    }

    public static AdGroupFeedPlaceholderType fromValue(String v) {
        return valueOf(v);
    }

}

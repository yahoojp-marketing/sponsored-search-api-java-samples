
package jp.yahooapis.ss.v201909.pagefeeditem;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for PageFeedUrlMatchType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="PageFeedUrlMatchType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="EXACT"/>
 *     &lt;enumeration value="BROAD"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "PageFeedUrlMatchType")
@XmlEnum
public enum PageFeedUrlMatchType {

    EXACT,
    BROAD;

    public String value() {
        return name();
    }

    public static PageFeedUrlMatchType fromValue(String v) {
        return valueOf(v);
    }

}

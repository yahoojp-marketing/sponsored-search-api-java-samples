
package jp.yahooapis.ss.v201909.pagefeeditem;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for PageFeedItemJobType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="PageFeedItemJobType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="UPLOAD"/>
 *     &lt;enumeration value="DOWNLOAD"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "PageFeedItemJobType")
@XmlEnum
public enum PageFeedItemJobType {

    UPLOAD,
    DOWNLOAD;

    public String value() {
        return name();
    }

    public static PageFeedItemJobType fromValue(String v) {
        return valueOf(v);
    }

}

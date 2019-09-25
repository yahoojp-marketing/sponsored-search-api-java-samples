
package jp.yahooapis.ss.v201909.pagefeeditem;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for PageFeedItemUploadType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="PageFeedItemUploadType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="NEW_OR_REPLACE"/>
 *     &lt;enumeration value="MODIFY"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "PageFeedItemUploadType")
@XmlEnum
public enum PageFeedItemUploadType {

    NEW_OR_REPLACE,
    MODIFY;

    public String value() {
        return name();
    }

    public static PageFeedItemUploadType fromValue(String v) {
        return valueOf(v);
    }

}

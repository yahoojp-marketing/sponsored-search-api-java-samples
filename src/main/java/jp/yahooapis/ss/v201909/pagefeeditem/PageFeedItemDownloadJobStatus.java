
package jp.yahooapis.ss.v201909.pagefeeditem;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for PageFeedItemDownloadJobStatus.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="PageFeedItemDownloadJobStatus">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="IN_PROGRESS"/>
 *     &lt;enumeration value="COMPLETED"/>
 *     &lt;enumeration value="FIELDS_ERROR"/>
 *     &lt;enumeration value="TIMEOUT"/>
 *     &lt;enumeration value="SYSTEM_ERROR"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "PageFeedItemDownloadJobStatus")
@XmlEnum
public enum PageFeedItemDownloadJobStatus {

    IN_PROGRESS,
    COMPLETED,
    FIELDS_ERROR,
    TIMEOUT,
    SYSTEM_ERROR;

    public String value() {
        return name();
    }

    public static PageFeedItemDownloadJobStatus fromValue(String v) {
        return valueOf(v);
    }

}

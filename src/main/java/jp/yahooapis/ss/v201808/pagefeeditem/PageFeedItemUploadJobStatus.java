
package jp.yahooapis.ss.v201808.pagefeeditem;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for PageFeedItemUploadJobStatus.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="PageFeedItemUploadJobStatus">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="IN_PROGRESS"/>
 *     &lt;enumeration value="COMPLETED"/>
 *     &lt;enumeration value="COMPLETED_WITH_VALIDATION_ERROR"/>
 *     &lt;enumeration value="FILE_FORMAT_ERROR"/>
 *     &lt;enumeration value="FILE_ENCODING_ERROR"/>
 *     &lt;enumeration value="COLUMN_HEADER_ERROR"/>
 *     &lt;enumeration value="EXCEED_ROW_LINES"/>
 *     &lt;enumeration value="EXCEED_FILE_COUNTS"/>
 *     &lt;enumeration value="INVALID_FEED_FOLDER_ID"/>
 *     &lt;enumeration value="TIMEOUT"/>
 *     &lt;enumeration value="SYSTEM_ERROR"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "PageFeedItemUploadJobStatus")
@XmlEnum
public enum PageFeedItemUploadJobStatus {

    IN_PROGRESS,
    COMPLETED,
    COMPLETED_WITH_VALIDATION_ERROR,
    FILE_FORMAT_ERROR,
    FILE_ENCODING_ERROR,
    COLUMN_HEADER_ERROR,
    EXCEED_ROW_LINES,
    EXCEED_FILE_COUNTS,
    INVALID_FEED_FOLDER_ID,
    TIMEOUT,
    SYSTEM_ERROR;

    public String value() {
        return name();
    }

    public static PageFeedItemUploadJobStatus fromValue(String v) {
        return valueOf(v);
    }

}

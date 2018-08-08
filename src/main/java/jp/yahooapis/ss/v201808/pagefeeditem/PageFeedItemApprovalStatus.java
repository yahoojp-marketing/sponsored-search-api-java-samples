
package jp.yahooapis.ss.v201808.pagefeeditem;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for PageFeedItemApprovalStatus.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="PageFeedItemApprovalStatus">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="APPROVED"/>
 *     &lt;enumeration value="APPROVED_WITH_REVIEW"/>
 *     &lt;enumeration value="REVIEW"/>
 *     &lt;enumeration value="PRE_DISAPPROVED"/>
 *     &lt;enumeration value="POST_DISAPPROVED"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "PageFeedItemApprovalStatus")
@XmlEnum
public enum PageFeedItemApprovalStatus {

    APPROVED,
    APPROVED_WITH_REVIEW,
    REVIEW,
    PRE_DISAPPROVED,
    POST_DISAPPROVED;

    public String value() {
        return name();
    }

    public static PageFeedItemApprovalStatus fromValue(String v) {
        return valueOf(v);
    }

}


package jp.yahooapis.ss.V5.AdGroupAdService;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ApprovalStatus.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="ApprovalStatus">
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
@XmlType(name = "ApprovalStatus")
@XmlEnum
public enum ApprovalStatus {

    APPROVED,
    APPROVED_WITH_REVIEW,
    REVIEW,
    PRE_DISAPPROVED,
    POST_DISAPPROVED;

    public String value() {
        return name();
    }

    public static ApprovalStatus fromValue(String v) {
        return valueOf(v);
    }

}

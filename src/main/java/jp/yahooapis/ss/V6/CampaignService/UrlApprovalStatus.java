
package jp.yahooapis.ss.V6.CampaignService;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for UrlApprovalStatus.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="UrlApprovalStatus">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="NONE"/>
 *     &lt;enumeration value="APPROVED"/>
 *     &lt;enumeration value="APPROVED_WITH_REVIEW"/>
 *     &lt;enumeration value="REVIEW"/>
 *     &lt;enumeration value="DISAPPROVED"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "UrlApprovalStatus")
@XmlEnum
public enum UrlApprovalStatus {

    NONE,
    APPROVED,
    APPROVED_WITH_REVIEW,
    REVIEW,
    DISAPPROVED;

    public String value() {
        return name();
    }

    public static UrlApprovalStatus fromValue(String v) {
        return valueOf(v);
    }

}

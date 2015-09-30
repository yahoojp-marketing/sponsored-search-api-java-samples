
package jp.yahooapis.ss.V5.CampaignService;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for TargetPositionType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="TargetPositionType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="PAGE_ONE"/>
 *     &lt;enumeration value="PAGE_ONE_PROMOTED"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "TargetPositionType")
@XmlEnum
public enum TargetPositionType {

    PAGE_ONE,
    PAGE_ONE_PROMOTED;

    public String value() {
        return name();
    }

    public static TargetPositionType fromValue(String v) {
        return valueOf(v);
    }

}

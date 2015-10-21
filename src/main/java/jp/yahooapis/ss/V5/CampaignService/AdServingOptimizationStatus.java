
package jp.yahooapis.ss.V5.CampaignService;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for AdServingOptimizationStatus.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="AdServingOptimizationStatus">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="OPTIMIZE"/>
 *     &lt;enumeration value="ROTATE"/>
 *     &lt;enumeration value="ROTATE_INDEFINITELY"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "AdServingOptimizationStatus")
@XmlEnum
public enum AdServingOptimizationStatus {

    OPTIMIZE,
    ROTATE,
    ROTATE_INDEFINITELY;

    public String value() {
        return name();
    }

    public static AdServingOptimizationStatus fromValue(String v) {
        return valueOf(v);
    }

}

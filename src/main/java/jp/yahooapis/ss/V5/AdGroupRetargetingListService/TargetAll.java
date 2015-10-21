
package jp.yahooapis.ss.V5.AdGroupRetargetingListService;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for TargetAll.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="TargetAll">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="ACTIVE"/>
 *     &lt;enumeration value="DEACTIVE"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "TargetAll")
@XmlEnum
public enum TargetAll {

    ACTIVE,
    DEACTIVE;

    public String value() {
        return name();
    }

    public static TargetAll fromValue(String v) {
        return valueOf(v);
    }

}

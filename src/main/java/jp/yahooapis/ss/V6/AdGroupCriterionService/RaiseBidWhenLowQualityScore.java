
package jp.yahooapis.ss.V6.AdGroupCriterionService;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for RaiseBidWhenLowQualityScore.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="RaiseBidWhenLowQualityScore">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="ACTIVE"/>
 *     &lt;enumeration value="DEACTIVE"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "RaiseBidWhenLowQualityScore")
@XmlEnum
public enum RaiseBidWhenLowQualityScore {

    ACTIVE,
    DEACTIVE;

    public String value() {
        return name();
    }

    public static RaiseBidWhenLowQualityScore fromValue(String v) {
        return valueOf(v);
    }

}

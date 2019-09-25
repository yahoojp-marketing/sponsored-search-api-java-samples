
package jp.yahooapis.ss.v201909.adgroupcriterion;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for AdGroupCriterionUse.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="AdGroupCriterionUse">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="BIDDABLE"/>
 *     &lt;enumeration value="NEGATIVE"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "AdGroupCriterionUse")
@XmlEnum
public enum AdGroupCriterionUse {

    BIDDABLE,
    NEGATIVE;

    public String value() {
        return name();
    }

    public static AdGroupCriterionUse fromValue(String v) {
        return valueOf(v);
    }

}

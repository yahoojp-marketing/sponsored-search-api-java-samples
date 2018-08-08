
package jp.yahooapis.ss.v201808.retargetinglist;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for IsDateSpecificRule.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="IsDateSpecificRule">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="FALSE"/>
 *     &lt;enumeration value="TRUE"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "IsDateSpecificRule")
@XmlEnum
public enum IsDateSpecificRule {

    FALSE,
    TRUE;

    public String value() {
        return name();
    }

    public static IsDateSpecificRule fromValue(String v) {
        return valueOf(v);
    }

}

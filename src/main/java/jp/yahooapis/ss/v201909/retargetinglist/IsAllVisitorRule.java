
package jp.yahooapis.ss.v201909.retargetinglist;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for IsAllVisitorRule.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="IsAllVisitorRule">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="FALSE"/>
 *     &lt;enumeration value="TRUE"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "IsAllVisitorRule")
@XmlEnum
public enum IsAllVisitorRule {

    FALSE,
    TRUE;

    public String value() {
        return name();
    }

    public static IsAllVisitorRule fromValue(String v) {
        return valueOf(v);
    }

}

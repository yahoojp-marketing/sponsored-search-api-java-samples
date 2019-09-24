
package jp.yahooapis.ss.v201909.retargetinglist;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for UrlRuleKey.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="UrlRuleKey">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="URL"/>
 *     &lt;enumeration value="REFFER_URL"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "UrlRuleKey")
@XmlEnum
public enum UrlRuleKey {

    URL,
    REFFER_URL;

    public String value() {
        return name();
    }

    public static UrlRuleKey fromValue(String v) {
        return valueOf(v);
    }

}

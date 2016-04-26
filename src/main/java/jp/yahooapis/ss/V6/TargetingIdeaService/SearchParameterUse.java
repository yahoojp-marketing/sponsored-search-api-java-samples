
package jp.yahooapis.ss.V6.TargetingIdeaService;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for SearchParameterUse.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="SearchParameterUse">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="RELATED_TO_KEYWORD"/>
 *     &lt;enumeration value="RELATED_TO_URL"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "SearchParameterUse")
@XmlEnum
public enum SearchParameterUse {

    RELATED_TO_KEYWORD,
    RELATED_TO_URL;

    public String value() {
        return name();
    }

    public static SearchParameterUse fromValue(String v) {
        return valueOf(v);
    }

}

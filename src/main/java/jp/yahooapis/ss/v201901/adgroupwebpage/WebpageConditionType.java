
package jp.yahooapis.ss.v201901.adgroupwebpage;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for WebpageConditionType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="WebpageConditionType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="URL"/>
 *     &lt;enumeration value="PAGE_TITLE"/>
 *     &lt;enumeration value="PAGE_CONTENT"/>
 *     &lt;enumeration value="CUSTOM_LABEL"/>
 *     &lt;enumeration value="ALL_PAGES"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "WebpageConditionType")
@XmlEnum
public enum WebpageConditionType {

    URL,
    PAGE_TITLE,
    PAGE_CONTENT,
    CUSTOM_LABEL,
    ALL_PAGES;

    public String value() {
        return name();
    }

    public static WebpageConditionType fromValue(String v) {
        return valueOf(v);
    }

}

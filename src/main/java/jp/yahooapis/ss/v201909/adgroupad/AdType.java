
package jp.yahooapis.ss.v201909.adgroupad;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for AdType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="AdType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="TEXT_AD2"/>
 *     &lt;enumeration value="APP_AD"/>
 *     &lt;enumeration value="EXTENDED_TEXT_AD"/>
 *     &lt;enumeration value="DYNAMIC_SEARCH_LINKED_AD"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "AdType")
@XmlEnum
public enum AdType {

    @XmlEnumValue("TEXT_AD2")
    TEXT_AD_2("TEXT_AD2"),
    APP_AD("APP_AD"),
    EXTENDED_TEXT_AD("EXTENDED_TEXT_AD"),
    DYNAMIC_SEARCH_LINKED_AD("DYNAMIC_SEARCH_LINKED_AD");
    private final String value;

    AdType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static AdType fromValue(String v) {
        for (AdType c: AdType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}

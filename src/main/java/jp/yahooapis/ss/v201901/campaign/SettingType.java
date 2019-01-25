
package jp.yahooapis.ss.v201901.campaign;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for SettingType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="SettingType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="GEO_TARGET_TYPE_SETTING"/>
 *     &lt;enumeration value="TARGET_LIST_SETTING"/>
 *     &lt;enumeration value="DYNAMIC_ADS_FOR_SEARCH_SETTING"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "SettingType")
@XmlEnum
public enum SettingType {

    GEO_TARGET_TYPE_SETTING,
    TARGET_LIST_SETTING,
    DYNAMIC_ADS_FOR_SEARCH_SETTING;

    public String value() {
        return name();
    }

    public static SettingType fromValue(String v) {
        return valueOf(v);
    }

}

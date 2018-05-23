
package jp.yahooapis.ss.v201805.conversiontracker;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for AppPostbackUrlClearFlag.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="AppPostbackUrlClearFlag">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="TRUE"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "AppPostbackUrlClearFlag")
@XmlEnum
public enum AppPostbackUrlClearFlag {

    TRUE;

    public String value() {
        return name();
    }

    public static AppPostbackUrlClearFlag fromValue(String v) {
        return valueOf(v);
    }

}

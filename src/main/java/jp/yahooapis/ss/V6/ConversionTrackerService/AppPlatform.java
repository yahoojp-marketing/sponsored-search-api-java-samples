
package jp.yahooapis.ss.V6.ConversionTrackerService;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for AppPlatform.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="AppPlatform">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="ANDROID_MARKET"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "AppPlatform")
@XmlEnum
public enum AppPlatform {

    ANDROID_MARKET;

    public String value() {
        return name();
    }

    public static AppPlatform fromValue(String v) {
        return valueOf(v);
    }

}

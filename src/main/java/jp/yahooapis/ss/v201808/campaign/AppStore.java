
package jp.yahooapis.ss.v201808.campaign;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for AppStore.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="AppStore">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="IOS"/>
 *     &lt;enumeration value="ANDROID"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "AppStore")
@XmlEnum
public enum AppStore {

    IOS,
    ANDROID;

    public String value() {
        return name();
    }

    public static AppStore fromValue(String v) {
        return valueOf(v);
    }

}

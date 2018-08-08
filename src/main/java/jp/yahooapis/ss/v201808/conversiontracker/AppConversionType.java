
package jp.yahooapis.ss.v201808.conversiontracker;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for AppConversionType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="AppConversionType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="DOWNLOAD"/>
 *     &lt;enumeration value="IN_APP_PURCHASE"/>
 *     &lt;enumeration value="FIRST_OPEN"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "AppConversionType")
@XmlEnum
public enum AppConversionType {

    DOWNLOAD,
    IN_APP_PURCHASE,
    FIRST_OPEN;

    public String value() {
        return name();
    }

    public static AppConversionType fromValue(String v) {
        return valueOf(v);
    }

}

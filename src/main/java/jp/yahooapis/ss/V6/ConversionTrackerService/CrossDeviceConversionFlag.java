
package jp.yahooapis.ss.V6.ConversionTrackerService;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for CrossDeviceConversionFlag.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="CrossDeviceConversionFlag">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="TRUE"/>
 *     &lt;enumeration value="FALSE"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "CrossDeviceConversionFlag")
@XmlEnum
public enum CrossDeviceConversionFlag {

    TRUE,
    FALSE;

    public String value() {
        return name();
    }

    public static CrossDeviceConversionFlag fromValue(String v) {
        return valueOf(v);
    }

}

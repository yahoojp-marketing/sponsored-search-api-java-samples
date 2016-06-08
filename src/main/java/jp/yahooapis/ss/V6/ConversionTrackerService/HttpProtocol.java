
package jp.yahooapis.ss.V6.ConversionTrackerService;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for HttpProtocol.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="HttpProtocol">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="HTTP"/>
 *     &lt;enumeration value="HTTPS"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "HttpProtocol")
@XmlEnum
public enum HttpProtocol {

    HTTP,
    HTTPS;

    public String value() {
        return name();
    }

    public static HttpProtocol fromValue(String v) {
        return valueOf(v);
    }

}

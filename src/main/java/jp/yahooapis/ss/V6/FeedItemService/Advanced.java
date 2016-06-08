
package jp.yahooapis.ss.V6.FeedItemService;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for Advanced.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="Advanced">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="FALSE"/>
 *     &lt;enumeration value="TRUE"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "Advanced")
@XmlEnum
public enum Advanced {

    FALSE,
    TRUE;

    public String value() {
        return name();
    }

    public static Advanced fromValue(String v) {
        return valueOf(v);
    }

}


package jp.yahooapis.ss.v201909.adgroupad;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ContainsLabelId.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="ContainsLabelId">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="TRUE"/>
 *     &lt;enumeration value="FALSE"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "ContainsLabelId")
@XmlEnum
public enum ContainsLabelId {

    TRUE,
    FALSE;

    public String value() {
        return name();
    }

    public static ContainsLabelId fromValue(String v) {
        return valueOf(v);
    }

}

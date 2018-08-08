
package jp.yahooapis.ss.v201808.sharedcriterion;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for SharedCriterionUse.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="SharedCriterionUse">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="NEGATIVE"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "SharedCriterionUse")
@XmlEnum
public enum SharedCriterionUse {

    NEGATIVE;

    public String value() {
        return name();
    }

    public static SharedCriterionUse fromValue(String v) {
        return valueOf(v);
    }

}

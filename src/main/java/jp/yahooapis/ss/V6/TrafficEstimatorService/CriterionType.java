
package jp.yahooapis.ss.V6.TrafficEstimatorService;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for CriterionType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="CriterionType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="KEYWORD"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "CriterionType")
@XmlEnum
public enum CriterionType {

    KEYWORD;

    public String value() {
        return name();
    }

    public static CriterionType fromValue(String v) {
        return valueOf(v);
    }

}

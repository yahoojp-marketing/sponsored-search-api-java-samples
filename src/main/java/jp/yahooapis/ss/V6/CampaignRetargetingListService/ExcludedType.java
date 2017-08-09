
package jp.yahooapis.ss.V6.CampaignRetargetingListService;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ExcludedType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="ExcludedType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="INCLUDED"/>
 *     &lt;enumeration value="EXCLUDED"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "ExcludedType")
@XmlEnum
public enum ExcludedType {

    INCLUDED,
    EXCLUDED;

    public String value() {
        return name();
    }

    public static ExcludedType fromValue(String v) {
        return valueOf(v);
    }

}


package jp.yahooapis.ss.V6.CampaignTargetService;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for NetworkCoverageType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="NetworkCoverageType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="YAHOO_SEARCH"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "NetworkCoverageType")
@XmlEnum
public enum NetworkCoverageType {

    YAHOO_SEARCH;

    public String value() {
        return name();
    }

    public static NetworkCoverageType fromValue(String v) {
        return valueOf(v);
    }

}

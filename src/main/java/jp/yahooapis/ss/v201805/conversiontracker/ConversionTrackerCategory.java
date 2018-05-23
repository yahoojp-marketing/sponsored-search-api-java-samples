
package jp.yahooapis.ss.v201805.conversiontracker;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ConversionTrackerCategory.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="ConversionTrackerCategory">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="DEFAULT"/>
 *     &lt;enumeration value="PAGE_VIEW"/>
 *     &lt;enumeration value="PURCHASE"/>
 *     &lt;enumeration value="SIGNUP"/>
 *     &lt;enumeration value="LEAD"/>
 *     &lt;enumeration value="DOWNLOAD"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "ConversionTrackerCategory")
@XmlEnum
public enum ConversionTrackerCategory {

    DEFAULT,
    PAGE_VIEW,
    PURCHASE,
    SIGNUP,
    LEAD,
    DOWNLOAD;

    public String value() {
        return name();
    }

    public static ConversionTrackerCategory fromValue(String v) {
        return valueOf(v);
    }

}

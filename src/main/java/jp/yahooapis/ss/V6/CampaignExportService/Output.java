
package jp.yahooapis.ss.V6.CampaignExportService;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for Output.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="Output">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="CSV"/>
 *     &lt;enumeration value="ZIPPED_CSV"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "Output")
@XmlEnum
public enum Output {

    CSV,
    ZIPPED_CSV;

    public String value() {
        return name();
    }

    public static Output fromValue(String v) {
        return valueOf(v);
    }

}

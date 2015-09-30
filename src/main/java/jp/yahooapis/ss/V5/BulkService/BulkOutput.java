
package jp.yahooapis.ss.V5.BulkService;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for BulkOutput.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="BulkOutput">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="XML"/>
 *     &lt;enumeration value="CSV"/>
 *     &lt;enumeration value="ZIPPED_XML"/>
 *     &lt;enumeration value="ZIPPED_CSV"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "BulkOutput")
@XmlEnum
public enum BulkOutput {

    XML,
    CSV,
    ZIPPED_XML,
    ZIPPED_CSV;

    public String value() {
        return name();
    }

    public static BulkOutput fromValue(String v) {
        return valueOf(v);
    }

}

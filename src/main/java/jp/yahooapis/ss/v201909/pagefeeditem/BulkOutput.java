
package jp.yahooapis.ss.v201909.pagefeeditem;

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
 *     &lt;enumeration value="CSV"/>
 *     &lt;enumeration value="TSV"/>
 *     &lt;enumeration value="ZIPPED_CSV"/>
 *     &lt;enumeration value="ZIPPED_TSV"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "BulkOutput")
@XmlEnum
public enum BulkOutput {

    CSV,
    TSV,
    ZIPPED_CSV,
    ZIPPED_TSV;

    public String value() {
        return name();
    }

    public static BulkOutput fromValue(String v) {
        return valueOf(v);
    }

}

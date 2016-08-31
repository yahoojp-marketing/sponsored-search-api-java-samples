
package jp.yahooapis.ss.V6.FeedFolderService;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for FeedFolderPlaceholderField.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="FeedFolderPlaceholderField">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="AD_CUSTOMIZER_INTEGER"/>
 *     &lt;enumeration value="AD_CUSTOMIZER_PRICE"/>
 *     &lt;enumeration value="AD_CUSTOMIZER_DATE"/>
 *     &lt;enumeration value="AD_CUSTOMIZER_STRING"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "FeedFolderPlaceholderField")
@XmlEnum
public enum FeedFolderPlaceholderField {

    AD_CUSTOMIZER_INTEGER,
    AD_CUSTOMIZER_PRICE,
    AD_CUSTOMIZER_DATE,
    AD_CUSTOMIZER_STRING;

    public String value() {
        return name();
    }

    public static FeedFolderPlaceholderField fromValue(String v) {
        return valueOf(v);
    }

}


package jp.yahooapis.ss.V6.DictionaryService;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for DictionaryLang.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="DictionaryLang">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="JA"/>
 *     &lt;enumeration value="EN"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "DictionaryLang")
@XmlEnum
public enum DictionaryLang {

    JA,
    EN;

    public String value() {
        return name();
    }

    public static DictionaryLang fromValue(String v) {
        return valueOf(v);
    }

}


package jp.yahooapis.ss.V6.CustomerSyncService;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for EventType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="EventType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="ADD"/>
 *     &lt;enumeration value="SET"/>
 *     &lt;enumeration value="REMOVE"/>
 *     &lt;enumeration value="REVIEW"/>
 *     &lt;enumeration value="BID"/>
 *     &lt;enumeration value="STATUS"/>
 *     &lt;enumeration value="BUDGET"/>
 *     &lt;enumeration value="ALL"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "EventType")
@XmlEnum
public enum EventType {

    ADD,
    SET,
    REMOVE,
    REVIEW,
    BID,
    STATUS,
    BUDGET,
    ALL;

    public String value() {
        return name();
    }

    public static EventType fromValue(String v) {
        return valueOf(v);
    }

}

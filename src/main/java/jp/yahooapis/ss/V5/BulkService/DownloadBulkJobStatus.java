
package jp.yahooapis.ss.V5.BulkService;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for DownloadBulkJobStatus.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="DownloadBulkJobStatus">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="IN_PROGRESS"/>
 *     &lt;enumeration value="COMPLETED"/>
 *     &lt;enumeration value="TIMEOUT"/>
 *     &lt;enumeration value="SYSTEM_ERROR"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "DownloadBulkJobStatus")
@XmlEnum
public enum DownloadBulkJobStatus {

    IN_PROGRESS,
    COMPLETED,
    TIMEOUT,
    SYSTEM_ERROR;

    public String value() {
        return name();
    }

    public static DownloadBulkJobStatus fromValue(String v) {
        return valueOf(v);
    }

}


package jp.yahooapis.ss.v201901.auditlog;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;
import jp.yahooapis.ss.v201901.ReturnValue;


/**
 * <p>Java class for AuditLogValues complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="AuditLogValues">
 *   &lt;complexContent>
 *     &lt;extension base="{http://ss.yahooapis.jp/V201901}ReturnValue">
 *       &lt;sequence>
 *         &lt;element name="job" type="{http://ss.yahooapis.jp/V201901/AuditLog}AuditLogJob" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AuditLogValues", propOrder = {
    "job"
})
public class AuditLogValues
    extends ReturnValue
{

    protected AuditLogJob job;

    /**
     * Gets the value of the job property.
     * 
     * @return
     *     possible object is
     *     {@link AuditLogJob }
     *     
     */
    public AuditLogJob getJob() {
        return job;
    }

    /**
     * Sets the value of the job property.
     * 
     * @param value
     *     allowed object is
     *     {@link AuditLogJob }
     *     
     */
    public void setJob(AuditLogJob value) {
        this.job = value;
    }

}


package jp.yahooapis.ss.V6.CustomerSyncService;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ChangeDataValues complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ChangeDataValues">
 *   &lt;complexContent>
 *     &lt;extension base="{http://ss.yahooapis.jp/V6}ReturnValue">
 *       &lt;sequence>
 *         &lt;element name="auditlog" type="{http://ss.yahooapis.jp/V6}Auditlog" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ChangeDataValues", propOrder = {
    "auditlog"
})
public class ChangeDataValues
    extends ReturnValue
{

    protected List<Auditlog> auditlog;

    /**
     * Gets the value of the auditlog property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the auditlog property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAuditlog().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Auditlog }
     * 
     * 
     */
    public List<Auditlog> getAuditlog() {
        if (auditlog == null) {
            auditlog = new ArrayList<Auditlog>();
        }
        return this.auditlog;
    }

}

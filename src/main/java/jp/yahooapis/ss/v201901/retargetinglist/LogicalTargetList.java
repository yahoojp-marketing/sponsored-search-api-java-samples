
package jp.yahooapis.ss.v201901.retargetinglist;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for LogicalTargetList complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="LogicalTargetList">
 *   &lt;complexContent>
 *     &lt;extension base="{http://ss.yahooapis.jp/V201901/RetargetingList}TargetingList">
 *       &lt;sequence>
 *         &lt;element name="logicalGroup" type="{http://ss.yahooapis.jp/V201901/RetargetingList}LogicalGroup" maxOccurs="20"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "LogicalTargetList", propOrder = {
    "logicalGroup"
})
public class LogicalTargetList
    extends TargetingList
{

    @XmlElement(required = true)
    protected List<LogicalGroup> logicalGroup;

    /**
     * Gets the value of the logicalGroup property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the logicalGroup property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getLogicalGroup().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link LogicalGroup }
     * 
     * 
     */
    public List<LogicalGroup> getLogicalGroup() {
        if (logicalGroup == null) {
            logicalGroup = new ArrayList<LogicalGroup>();
        }
        return this.logicalGroup;
    }

}

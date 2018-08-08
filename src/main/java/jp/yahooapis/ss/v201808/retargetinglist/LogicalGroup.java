
package jp.yahooapis.ss.v201808.retargetinglist;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for LogicalGroup complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="LogicalGroup">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="condition" type="{http://ss.yahooapis.jp/V201808/RetargetingList}LogicalCondition" minOccurs="0"/>
 *         &lt;element name="logicalOperand" type="{http://ss.yahooapis.jp/V201808/RetargetingList}LogicalRuleOperand" maxOccurs="20"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "LogicalGroup", propOrder = {
    "condition",
    "logicalOperand"
})
public class LogicalGroup {

    @XmlSchemaType(name = "string")
    protected LogicalCondition condition;
    @XmlElement(required = true)
    protected List<LogicalRuleOperand> logicalOperand;

    /**
     * Gets the value of the condition property.
     * 
     * @return
     *     possible object is
     *     {@link LogicalCondition }
     *     
     */
    public LogicalCondition getCondition() {
        return condition;
    }

    /**
     * Sets the value of the condition property.
     * 
     * @param value
     *     allowed object is
     *     {@link LogicalCondition }
     *     
     */
    public void setCondition(LogicalCondition value) {
        this.condition = value;
    }

    /**
     * Gets the value of the logicalOperand property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the logicalOperand property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getLogicalOperand().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link LogicalRuleOperand }
     * 
     * 
     */
    public List<LogicalRuleOperand> getLogicalOperand() {
        if (logicalOperand == null) {
            logicalOperand = new ArrayList<LogicalRuleOperand>();
        }
        return this.logicalOperand;
    }

}

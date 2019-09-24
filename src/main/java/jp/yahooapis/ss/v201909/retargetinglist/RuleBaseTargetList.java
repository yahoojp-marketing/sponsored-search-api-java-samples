
package jp.yahooapis.ss.v201909.retargetinglist;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for RuleBaseTargetList complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="RuleBaseTargetList">
 *   &lt;complexContent>
 *     &lt;extension base="{http://ss.yahooapis.jp/V201909/RetargetingList}TargetingList">
 *       &lt;sequence>
 *         &lt;element name="rules" type="{http://ss.yahooapis.jp/V201909/RetargetingList}RuleGroup" maxOccurs="20" minOccurs="0"/>
 *         &lt;element name="isAllVisitor" type="{http://ss.yahooapis.jp/V201909/RetargetingList}IsAllVisitorRule"/>
 *         &lt;element name="isDateSpecific" type="{http://ss.yahooapis.jp/V201909/RetargetingList}IsDateSpecificRule" minOccurs="0"/>
 *         &lt;element name="startDate" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="endDate" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "RuleBaseTargetList", propOrder = {
    "rules",
    "isAllVisitor",
    "isDateSpecific",
    "startDate",
    "endDate"
})
public class RuleBaseTargetList
    extends TargetingList
{

    protected List<RuleGroup> rules;
    @XmlElement(required = true)
    @XmlSchemaType(name = "string")
    protected IsAllVisitorRule isAllVisitor;
    @XmlSchemaType(name = "string")
    protected IsDateSpecificRule isDateSpecific;
    protected String startDate;
    protected String endDate;

    /**
     * Gets the value of the rules property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the rules property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getRules().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link RuleGroup }
     * 
     * 
     */
    public List<RuleGroup> getRules() {
        if (rules == null) {
            rules = new ArrayList<RuleGroup>();
        }
        return this.rules;
    }

    /**
     * Gets the value of the isAllVisitor property.
     * 
     * @return
     *     possible object is
     *     {@link IsAllVisitorRule }
     *     
     */
    public IsAllVisitorRule getIsAllVisitor() {
        return isAllVisitor;
    }

    /**
     * Sets the value of the isAllVisitor property.
     * 
     * @param value
     *     allowed object is
     *     {@link IsAllVisitorRule }
     *     
     */
    public void setIsAllVisitor(IsAllVisitorRule value) {
        this.isAllVisitor = value;
    }

    /**
     * Gets the value of the isDateSpecific property.
     * 
     * @return
     *     possible object is
     *     {@link IsDateSpecificRule }
     *     
     */
    public IsDateSpecificRule getIsDateSpecific() {
        return isDateSpecific;
    }

    /**
     * Sets the value of the isDateSpecific property.
     * 
     * @param value
     *     allowed object is
     *     {@link IsDateSpecificRule }
     *     
     */
    public void setIsDateSpecific(IsDateSpecificRule value) {
        this.isDateSpecific = value;
    }

    /**
     * Gets the value of the startDate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStartDate() {
        return startDate;
    }

    /**
     * Sets the value of the startDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStartDate(String value) {
        this.startDate = value;
    }

    /**
     * Gets the value of the endDate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEndDate() {
        return endDate;
    }

    /**
     * Sets the value of the endDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEndDate(String value) {
        this.endDate = value;
    }

}

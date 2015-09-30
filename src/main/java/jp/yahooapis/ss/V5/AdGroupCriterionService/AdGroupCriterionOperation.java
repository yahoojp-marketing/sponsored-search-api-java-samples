
package jp.yahooapis.ss.V5.AdGroupCriterionService;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for AdGroupCriterionOperation complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="AdGroupCriterionOperation">
 *   &lt;complexContent>
 *     &lt;extension base="{http://ss.yahooapis.jp/V5}Operation">
 *       &lt;sequence>
 *         &lt;element name="accountId" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="campaignId" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="adGroupId" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="criterionUse" type="{http://ss.yahooapis.jp/V5}CriterionUse"/>
 *         &lt;element name="operand" type="{http://ss.yahooapis.jp/V5}AdGroupCriterion" maxOccurs="unbounded"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AdGroupCriterionOperation", propOrder = {
    "accountId",
    "campaignId",
    "adGroupId",
    "criterionUse",
    "operand"
})
public class AdGroupCriterionOperation
    extends Operation
{

    protected long accountId;
    protected long campaignId;
    protected long adGroupId;
    @XmlElement(required = true)
    @XmlSchemaType(name = "string")
    protected CriterionUse criterionUse;
    @XmlElement(required = true)
    protected List<AdGroupCriterion> operand;

    /**
     * Gets the value of the accountId property.
     * 
     */
    public long getAccountId() {
        return accountId;
    }

    /**
     * Sets the value of the accountId property.
     * 
     */
    public void setAccountId(long value) {
        this.accountId = value;
    }

    /**
     * Gets the value of the campaignId property.
     * 
     */
    public long getCampaignId() {
        return campaignId;
    }

    /**
     * Sets the value of the campaignId property.
     * 
     */
    public void setCampaignId(long value) {
        this.campaignId = value;
    }

    /**
     * Gets the value of the adGroupId property.
     * 
     */
    public long getAdGroupId() {
        return adGroupId;
    }

    /**
     * Sets the value of the adGroupId property.
     * 
     */
    public void setAdGroupId(long value) {
        this.adGroupId = value;
    }

    /**
     * Gets the value of the criterionUse property.
     * 
     * @return
     *     possible object is
     *     {@link CriterionUse }
     *     
     */
    public CriterionUse getCriterionUse() {
        return criterionUse;
    }

    /**
     * Sets the value of the criterionUse property.
     * 
     * @param value
     *     allowed object is
     *     {@link CriterionUse }
     *     
     */
    public void setCriterionUse(CriterionUse value) {
        this.criterionUse = value;
    }

    /**
     * Gets the value of the operand property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the operand property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getOperand().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link AdGroupCriterion }
     * 
     * 
     */
    public List<AdGroupCriterion> getOperand() {
        if (operand == null) {
            operand = new ArrayList<AdGroupCriterion>();
        }
        return this.operand;
    }

}


package jp.yahooapis.ss.V6.CampaignCriterionService;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for CampaignCriterionOperation complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="CampaignCriterionOperation">
 *   &lt;complexContent>
 *     &lt;extension base="{http://ss.yahooapis.jp/V6}Operation">
 *       &lt;sequence>
 *         &lt;element name="accountId" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="campaignId" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="criterionUse" type="{http://ss.yahooapis.jp/V6}CampaignCriterionUse"/>
 *         &lt;element name="operand" type="{http://ss.yahooapis.jp/V6}CampaignCriterion" maxOccurs="unbounded"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CampaignCriterionOperation", propOrder = {
    "accountId",
    "campaignId",
    "criterionUse",
    "operand"
})
public class CampaignCriterionOperation
    extends Operation
{

    protected long accountId;
    protected long campaignId;
    @XmlElement(required = true)
    @XmlSchemaType(name = "string")
    protected CampaignCriterionUse criterionUse;
    @XmlElement(required = true)
    protected List<CampaignCriterion> operand;

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
     * Gets the value of the criterionUse property.
     * 
     * @return
     *     possible object is
     *     {@link CampaignCriterionUse }
     *     
     */
    public CampaignCriterionUse getCriterionUse() {
        return criterionUse;
    }

    /**
     * Sets the value of the criterionUse property.
     * 
     * @param value
     *     allowed object is
     *     {@link CampaignCriterionUse }
     *     
     */
    public void setCriterionUse(CampaignCriterionUse value) {
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
     * {@link CampaignCriterion }
     * 
     * 
     */
    public List<CampaignCriterion> getOperand() {
        if (operand == null) {
            operand = new ArrayList<CampaignCriterion>();
        }
        return this.operand;
    }

}

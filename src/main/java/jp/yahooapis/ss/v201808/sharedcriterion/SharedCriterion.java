
package jp.yahooapis.ss.v201808.sharedcriterion;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for SharedCriterion complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="SharedCriterion">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="accountId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="sharedListId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="criterionId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="text" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="matchType" type="{http://ss.yahooapis.jp/V201808/SharedCriterion}KeywordMatchType" minOccurs="0"/>
 *         &lt;element name="criterionUseType" type="{http://ss.yahooapis.jp/V201808/SharedCriterion}SharedCriterionUse" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SharedCriterion", propOrder = {
    "accountId",
    "sharedListId",
    "criterionId",
    "text",
    "matchType",
    "criterionUseType"
})
public class SharedCriterion {

    protected Long accountId;
    protected Long sharedListId;
    protected Long criterionId;
    protected String text;
    @XmlSchemaType(name = "string")
    protected KeywordMatchType matchType;
    @XmlSchemaType(name = "string")
    protected SharedCriterionUse criterionUseType;

    /**
     * Gets the value of the accountId property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getAccountId() {
        return accountId;
    }

    /**
     * Sets the value of the accountId property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setAccountId(Long value) {
        this.accountId = value;
    }

    /**
     * Gets the value of the sharedListId property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getSharedListId() {
        return sharedListId;
    }

    /**
     * Sets the value of the sharedListId property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setSharedListId(Long value) {
        this.sharedListId = value;
    }

    /**
     * Gets the value of the criterionId property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getCriterionId() {
        return criterionId;
    }

    /**
     * Sets the value of the criterionId property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setCriterionId(Long value) {
        this.criterionId = value;
    }

    /**
     * Gets the value of the text property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getText() {
        return text;
    }

    /**
     * Sets the value of the text property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setText(String value) {
        this.text = value;
    }

    /**
     * Gets the value of the matchType property.
     * 
     * @return
     *     possible object is
     *     {@link KeywordMatchType }
     *     
     */
    public KeywordMatchType getMatchType() {
        return matchType;
    }

    /**
     * Sets the value of the matchType property.
     * 
     * @param value
     *     allowed object is
     *     {@link KeywordMatchType }
     *     
     */
    public void setMatchType(KeywordMatchType value) {
        this.matchType = value;
    }

    /**
     * Gets the value of the criterionUseType property.
     * 
     * @return
     *     possible object is
     *     {@link SharedCriterionUse }
     *     
     */
    public SharedCriterionUse getCriterionUseType() {
        return criterionUseType;
    }

    /**
     * Sets the value of the criterionUseType property.
     * 
     * @param value
     *     allowed object is
     *     {@link SharedCriterionUse }
     *     
     */
    public void setCriterionUseType(SharedCriterionUse value) {
        this.criterionUseType = value;
    }

}

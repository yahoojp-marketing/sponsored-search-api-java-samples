
package jp.yahooapis.ss.v201901.campaign;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for Budget complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Budget">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="period" type="{http://ss.yahooapis.jp/V201901/Campaign}BudgetPeriod" minOccurs="0"/>
 *         &lt;element name="amount" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="deliveryMethod" type="{http://ss.yahooapis.jp/V201901/Campaign}BudgetDeliveryMethod" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Budget", propOrder = {
    "period",
    "amount",
    "deliveryMethod"
})
public class Budget {

    @XmlSchemaType(name = "string")
    protected BudgetPeriod period;
    protected Long amount;
    @XmlSchemaType(name = "string")
    protected BudgetDeliveryMethod deliveryMethod;

    /**
     * Gets the value of the period property.
     * 
     * @return
     *     possible object is
     *     {@link BudgetPeriod }
     *     
     */
    public BudgetPeriod getPeriod() {
        return period;
    }

    /**
     * Sets the value of the period property.
     * 
     * @param value
     *     allowed object is
     *     {@link BudgetPeriod }
     *     
     */
    public void setPeriod(BudgetPeriod value) {
        this.period = value;
    }

    /**
     * Gets the value of the amount property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getAmount() {
        return amount;
    }

    /**
     * Sets the value of the amount property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setAmount(Long value) {
        this.amount = value;
    }

    /**
     * Gets the value of the deliveryMethod property.
     * 
     * @return
     *     possible object is
     *     {@link BudgetDeliveryMethod }
     *     
     */
    public BudgetDeliveryMethod getDeliveryMethod() {
        return deliveryMethod;
    }

    /**
     * Sets the value of the deliveryMethod property.
     * 
     * @param value
     *     allowed object is
     *     {@link BudgetDeliveryMethod }
     *     
     */
    public void setDeliveryMethod(BudgetDeliveryMethod value) {
        this.deliveryMethod = value;
    }

}

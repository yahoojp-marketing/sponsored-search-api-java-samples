
package jp.yahooapis.ss.V6.KeywordEstimatorService;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for keywordEstimateRequest complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="keywordEstimateRequest">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="keyword" type="{http://ss.yahooapis.jp/V6}EstimateKeyword"/>
 *         &lt;element name="isNegative" type="{http://ss.yahooapis.jp/V6}IsNegativeBool" minOccurs="0"/>
 *         &lt;element name="maxCpc" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "keywordEstimateRequest", propOrder = {
    "keyword",
    "isNegative",
    "maxCpc"
})
public class KeywordEstimateRequest {

    @XmlElement(required = true)
    protected EstimateKeyword keyword;
    @XmlSchemaType(name = "string")
    protected IsNegativeBool isNegative;
    protected Long maxCpc;

    /**
     * Gets the value of the keyword property.
     * 
     * @return
     *     possible object is
     *     {@link EstimateKeyword }
     *     
     */
    public EstimateKeyword getKeyword() {
        return keyword;
    }

    /**
     * Sets the value of the keyword property.
     * 
     * @param value
     *     allowed object is
     *     {@link EstimateKeyword }
     *     
     */
    public void setKeyword(EstimateKeyword value) {
        this.keyword = value;
    }

    /**
     * Gets the value of the isNegative property.
     * 
     * @return
     *     possible object is
     *     {@link IsNegativeBool }
     *     
     */
    public IsNegativeBool getIsNegative() {
        return isNegative;
    }

    /**
     * Sets the value of the isNegative property.
     * 
     * @param value
     *     allowed object is
     *     {@link IsNegativeBool }
     *     
     */
    public void setIsNegative(IsNegativeBool value) {
        this.isNegative = value;
    }

    /**
     * Gets the value of the maxCpc property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getMaxCpc() {
        return maxCpc;
    }

    /**
     * Sets the value of the maxCpc property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setMaxCpc(Long value) {
        this.maxCpc = value;
    }

}

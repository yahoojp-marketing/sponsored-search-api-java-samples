
package jp.yahooapis.ss.v201901.keywordestimator;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;
import jp.yahooapis.ss.v201901.ReturnValue;


/**
 * <p>Java class for KeywordEstimateValues complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="KeywordEstimateValues">
 *   &lt;complexContent>
 *     &lt;extension base="{http://ss.yahooapis.jp/V201901}ReturnValue">
 *       &lt;sequence>
 *         &lt;element name="data" type="{http://ss.yahooapis.jp/V201901/KeywordEstimator}KeywordEstimateResult" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "KeywordEstimateValues", propOrder = {
    "data"
})
public class KeywordEstimateValues
    extends ReturnValue
{

    protected KeywordEstimateResult data;

    /**
     * Gets the value of the data property.
     * 
     * @return
     *     possible object is
     *     {@link KeywordEstimateResult }
     *     
     */
    public KeywordEstimateResult getData() {
        return data;
    }

    /**
     * Sets the value of the data property.
     * 
     * @param value
     *     allowed object is
     *     {@link KeywordEstimateResult }
     *     
     */
    public void setData(KeywordEstimateResult value) {
        this.data = value;
    }

}

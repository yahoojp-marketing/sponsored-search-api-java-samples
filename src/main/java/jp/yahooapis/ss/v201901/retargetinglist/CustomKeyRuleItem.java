
package jp.yahooapis.ss.v201901.retargetinglist;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for CustomKeyRuleItem complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="CustomKeyRuleItem">
 *   &lt;complexContent>
 *     &lt;extension base="{http://ss.yahooapis.jp/V201901/RetargetingList}RuleItem">
 *       &lt;sequence>
 *         &lt;element name="textKey" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CustomKeyRuleItem", propOrder = {
    "textKey"
})
public class CustomKeyRuleItem
    extends RuleItem
{

    @XmlElement(required = true)
    protected String textKey;

    /**
     * Gets the value of the textKey property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTextKey() {
        return textKey;
    }

    /**
     * Sets the value of the textKey property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTextKey(String value) {
        this.textKey = value;
    }

}

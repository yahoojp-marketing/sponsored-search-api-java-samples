
package jp.yahooapis.ss.v201808.targetingidea;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for KeywordAttribute complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="KeywordAttribute">
 *   &lt;complexContent>
 *     &lt;extension base="{http://ss.yahooapis.jp/V201808/TargetingIdea}Attribute">
 *       &lt;sequence>
 *         &lt;element name="value" type="{http://ss.yahooapis.jp/V201808/TargetingIdea}ProposalKeyword" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "KeywordAttribute", propOrder = {
    "value"
})
public class KeywordAttribute
    extends Attribute
{

    protected ProposalKeyword value;

    /**
     * Gets the value of the value property.
     * 
     * @return
     *     possible object is
     *     {@link ProposalKeyword }
     *     
     */
    public ProposalKeyword getValue() {
        return value;
    }

    /**
     * Sets the value of the value property.
     * 
     * @param value
     *     allowed object is
     *     {@link ProposalKeyword }
     *     
     */
    public void setValue(ProposalKeyword value) {
        this.value = value;
    }

}


package jp.yahooapis.ss.V6.CampaignCriterionService;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for Keyword complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Keyword">
 *   &lt;complexContent>
 *     &lt;extension base="{http://ss.yahooapis.jp/V6}Criterion">
 *       &lt;sequence>
 *         &lt;element name="text" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="matchType" type="{http://ss.yahooapis.jp/V6}KeywordMatchType" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Keyword", propOrder = {
    "text",
    "matchType"
})
public class Keyword
    extends Criterion
{

    protected String text;
    @XmlSchemaType(name = "string")
    protected KeywordMatchType matchType;

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

}

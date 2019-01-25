
package jp.yahooapis.ss.v201901.retargetinglist;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for UrlRuleItem complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="UrlRuleItem">
 *   &lt;complexContent>
 *     &lt;extension base="{http://ss.yahooapis.jp/V201901/RetargetingList}RuleItem">
 *       &lt;sequence>
 *         &lt;element name="urlKey" type="{http://ss.yahooapis.jp/V201901/RetargetingList}UrlRuleKey"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "UrlRuleItem", propOrder = {
    "urlKey"
})
public class UrlRuleItem
    extends RuleItem
{

    @XmlElement(required = true)
    @XmlSchemaType(name = "string")
    protected UrlRuleKey urlKey;

    /**
     * Gets the value of the urlKey property.
     * 
     * @return
     *     possible object is
     *     {@link UrlRuleKey }
     *     
     */
    public UrlRuleKey getUrlKey() {
        return urlKey;
    }

    /**
     * Sets the value of the urlKey property.
     * 
     * @param value
     *     allowed object is
     *     {@link UrlRuleKey }
     *     
     */
    public void setUrlKey(UrlRuleKey value) {
        this.urlKey = value;
    }

}

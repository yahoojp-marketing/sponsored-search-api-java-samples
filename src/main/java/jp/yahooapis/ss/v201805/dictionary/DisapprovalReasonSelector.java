
package jp.yahooapis.ss.v201805.dictionary;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for DisapprovalReasonSelector complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="DisapprovalReasonSelector">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="lang" type="{http://ss.yahooapis.jp/V201805/Dictionary}DictionaryLang"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DisapprovalReasonSelector", propOrder = {
    "lang"
})
public class DisapprovalReasonSelector {

    @XmlElement(required = true)
    @XmlSchemaType(name = "string")
    protected DictionaryLang lang;

    /**
     * Gets the value of the lang property.
     * 
     * @return
     *     possible object is
     *     {@link DictionaryLang }
     *     
     */
    public DictionaryLang getLang() {
        return lang;
    }

    /**
     * Sets the value of the lang property.
     * 
     * @param value
     *     allowed object is
     *     {@link DictionaryLang }
     *     
     */
    public void setLang(DictionaryLang value) {
        this.lang = value;
    }

}

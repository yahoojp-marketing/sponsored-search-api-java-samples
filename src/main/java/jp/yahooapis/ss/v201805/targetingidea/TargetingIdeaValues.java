
package jp.yahooapis.ss.v201805.targetingidea;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for TargetingIdeaValues complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="TargetingIdeaValues">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="data" type="{http://ss.yahooapis.jp/V201805/TargetingIdea}TypeAttributeMapEntry" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TargetingIdeaValues", propOrder = {
    "data"
})
public class TargetingIdeaValues {

    protected TypeAttributeMapEntry data;

    /**
     * Gets the value of the data property.
     * 
     * @return
     *     possible object is
     *     {@link TypeAttributeMapEntry }
     *     
     */
    public TypeAttributeMapEntry getData() {
        return data;
    }

    /**
     * Sets the value of the data property.
     * 
     * @param value
     *     allowed object is
     *     {@link TypeAttributeMapEntry }
     *     
     */
    public void setData(TypeAttributeMapEntry value) {
        this.data = value;
    }

}

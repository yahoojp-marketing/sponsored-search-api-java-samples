
package jp.yahooapis.ss.v201808.campaign;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ManualCpcBiddingScheme complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ManualCpcBiddingScheme">
 *   &lt;complexContent>
 *     &lt;extension base="{http://ss.yahooapis.jp/V201808/Campaign}BiddingScheme">
 *       &lt;sequence>
 *         &lt;element name="enhancedCpcEnabled" type="{http://ss.yahooapis.jp/V201808/Campaign}EnhancedCpcEnabled" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ManualCpcBiddingScheme", propOrder = {
    "enhancedCpcEnabled"
})
public class ManualCpcBiddingScheme
    extends BiddingScheme
{

    @XmlSchemaType(name = "string")
    protected EnhancedCpcEnabled enhancedCpcEnabled;

    /**
     * Gets the value of the enhancedCpcEnabled property.
     * 
     * @return
     *     possible object is
     *     {@link EnhancedCpcEnabled }
     *     
     */
    public EnhancedCpcEnabled getEnhancedCpcEnabled() {
        return enhancedCpcEnabled;
    }

    /**
     * Sets the value of the enhancedCpcEnabled property.
     * 
     * @param value
     *     allowed object is
     *     {@link EnhancedCpcEnabled }
     *     
     */
    public void setEnhancedCpcEnabled(EnhancedCpcEnabled value) {
        this.enhancedCpcEnabled = value;
    }

}

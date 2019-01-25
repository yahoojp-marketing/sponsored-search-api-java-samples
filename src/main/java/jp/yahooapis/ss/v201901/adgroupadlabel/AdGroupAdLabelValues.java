
package jp.yahooapis.ss.v201901.adgroupadlabel;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;
import jp.yahooapis.ss.v201901.ReturnValue;


/**
 * <p>Java class for AdGroupAdLabelValues complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="AdGroupAdLabelValues">
 *   &lt;complexContent>
 *     &lt;extension base="{http://ss.yahooapis.jp/V201901}ReturnValue">
 *       &lt;sequence>
 *         &lt;element name="adGroupAdLabel" type="{http://ss.yahooapis.jp/V201901/AdGroupAdLabel}AdGroupAdLabel" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AdGroupAdLabelValues", propOrder = {
    "adGroupAdLabel"
})
public class AdGroupAdLabelValues
    extends ReturnValue
{

    protected AdGroupAdLabel adGroupAdLabel;

    /**
     * Gets the value of the adGroupAdLabel property.
     * 
     * @return
     *     possible object is
     *     {@link AdGroupAdLabel }
     *     
     */
    public AdGroupAdLabel getAdGroupAdLabel() {
        return adGroupAdLabel;
    }

    /**
     * Sets the value of the adGroupAdLabel property.
     * 
     * @param value
     *     allowed object is
     *     {@link AdGroupAdLabel }
     *     
     */
    public void setAdGroupAdLabel(AdGroupAdLabel value) {
        this.adGroupAdLabel = value;
    }

}

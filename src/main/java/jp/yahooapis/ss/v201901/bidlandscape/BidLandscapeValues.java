
package jp.yahooapis.ss.v201901.bidlandscape;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;
import jp.yahooapis.ss.v201901.ReturnValue;


/**
 * <p>Java class for BidLandscapeValues complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="BidLandscapeValues">
 *   &lt;complexContent>
 *     &lt;extension base="{http://ss.yahooapis.jp/V201901}ReturnValue">
 *       &lt;sequence>
 *         &lt;element name="data" type="{http://ss.yahooapis.jp/V201901/BidLandscape}BidLandscape" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "BidLandscapeValues", propOrder = {
    "data"
})
public class BidLandscapeValues
    extends ReturnValue
{

    protected BidLandscape data;

    /**
     * Gets the value of the data property.
     * 
     * @return
     *     possible object is
     *     {@link BidLandscape }
     *     
     */
    public BidLandscape getData() {
        return data;
    }

    /**
     * Sets the value of the data property.
     * 
     * @param value
     *     allowed object is
     *     {@link BidLandscape }
     *     
     */
    public void setData(BidLandscape value) {
        this.data = value;
    }

}

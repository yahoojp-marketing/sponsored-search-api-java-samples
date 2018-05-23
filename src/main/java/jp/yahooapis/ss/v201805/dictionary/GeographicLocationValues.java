
package jp.yahooapis.ss.v201805.dictionary;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;
import jp.yahooapis.ss.v201805.ReturnValue;


/**
 * <p>Java class for GeographicLocationValues complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="GeographicLocationValues">
 *   &lt;complexContent>
 *     &lt;extension base="{http://ss.yahooapis.jp/V201805}ReturnValue">
 *       &lt;sequence>
 *         &lt;element name="geographicLocation" type="{http://ss.yahooapis.jp/V201805/Dictionary}GeographicLocation" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GeographicLocationValues", propOrder = {
    "geographicLocation"
})
public class GeographicLocationValues
    extends ReturnValue
{

    protected GeographicLocation geographicLocation;

    /**
     * Gets the value of the geographicLocation property.
     * 
     * @return
     *     possible object is
     *     {@link GeographicLocation }
     *     
     */
    public GeographicLocation getGeographicLocation() {
        return geographicLocation;
    }

    /**
     * Sets the value of the geographicLocation property.
     * 
     * @param value
     *     allowed object is
     *     {@link GeographicLocation }
     *     
     */
    public void setGeographicLocation(GeographicLocation value) {
        this.geographicLocation = value;
    }

}


package jp.yahooapis.ss.V5.ConversionTrackerService;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ConversionTrackerPage complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ConversionTrackerPage">
 *   &lt;complexContent>
 *     &lt;extension base="{http://ss.yahooapis.jp/V5}Page">
 *       &lt;sequence>
 *         &lt;element name="totalNumConvertedClicks" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="totalNumConversionEvents" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="totalConversionValue" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="values" type="{http://ss.yahooapis.jp/V5}ConversionTrackerValues" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ConversionTrackerPage", propOrder = {
    "totalNumConvertedClicks",
    "totalNumConversionEvents",
    "totalConversionValue",
    "values"
})
public class ConversionTrackerPage
    extends Page
{

    protected Long totalNumConvertedClicks;
    protected Long totalNumConversionEvents;
    protected Long totalConversionValue;
    protected List<ConversionTrackerValues> values;

    /**
     * Gets the value of the totalNumConvertedClicks property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getTotalNumConvertedClicks() {
        return totalNumConvertedClicks;
    }

    /**
     * Sets the value of the totalNumConvertedClicks property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setTotalNumConvertedClicks(Long value) {
        this.totalNumConvertedClicks = value;
    }

    /**
     * Gets the value of the totalNumConversionEvents property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getTotalNumConversionEvents() {
        return totalNumConversionEvents;
    }

    /**
     * Sets the value of the totalNumConversionEvents property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setTotalNumConversionEvents(Long value) {
        this.totalNumConversionEvents = value;
    }

    /**
     * Gets the value of the totalConversionValue property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getTotalConversionValue() {
        return totalConversionValue;
    }

    /**
     * Sets the value of the totalConversionValue property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setTotalConversionValue(Long value) {
        this.totalConversionValue = value;
    }

    /**
     * Gets the value of the values property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the values property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getValues().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ConversionTrackerValues }
     * 
     * 
     */
    public List<ConversionTrackerValues> getValues() {
        if (values == null) {
            values = new ArrayList<ConversionTrackerValues>();
        }
        return this.values;
    }

}


package jp.yahooapis.ss.v201808.conversiontracker;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;
import jp.yahooapis.ss.v201808.Page;


/**
 * <p>Java class for ConversionTrackerPage complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ConversionTrackerPage">
 *   &lt;complexContent>
 *     &lt;extension base="{http://ss.yahooapis.jp/V201808}Page">
 *       &lt;sequence>
 *         &lt;element name="totalConversions" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="totalAllConversions" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="totalConversionValue" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="totalAllConversionValue" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="values" type="{http://ss.yahooapis.jp/V201808/ConversionTracker}ConversionTrackerValues" maxOccurs="unbounded" minOccurs="0"/>
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
    "totalConversions",
    "totalAllConversions",
    "totalConversionValue",
    "totalAllConversionValue",
    "values"
})
public class ConversionTrackerPage
    extends Page
{

    protected Long totalConversions;
    protected Long totalAllConversions;
    protected String totalConversionValue;
    protected String totalAllConversionValue;
    protected List<ConversionTrackerValues> values;

    /**
     * Gets the value of the totalConversions property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getTotalConversions() {
        return totalConversions;
    }

    /**
     * Sets the value of the totalConversions property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setTotalConversions(Long value) {
        this.totalConversions = value;
    }

    /**
     * Gets the value of the totalAllConversions property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getTotalAllConversions() {
        return totalAllConversions;
    }

    /**
     * Sets the value of the totalAllConversions property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setTotalAllConversions(Long value) {
        this.totalAllConversions = value;
    }

    /**
     * Gets the value of the totalConversionValue property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTotalConversionValue() {
        return totalConversionValue;
    }

    /**
     * Sets the value of the totalConversionValue property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTotalConversionValue(String value) {
        this.totalConversionValue = value;
    }

    /**
     * Gets the value of the totalAllConversionValue property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTotalAllConversionValue() {
        return totalAllConversionValue;
    }

    /**
     * Sets the value of the totalAllConversionValue property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTotalAllConversionValue(String value) {
        this.totalAllConversionValue = value;
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

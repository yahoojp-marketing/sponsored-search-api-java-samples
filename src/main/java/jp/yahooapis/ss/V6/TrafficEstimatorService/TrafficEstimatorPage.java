
package jp.yahooapis.ss.V6.TrafficEstimatorService;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for TrafficEstimatorPage complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="TrafficEstimatorPage">
 *   &lt;complexContent>
 *     &lt;extension base="{http://ss.yahooapis.jp/V6}Page">
 *       &lt;sequence>
 *         &lt;element name="values" type="{http://ss.yahooapis.jp/V6}EstimateValues" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TrafficEstimatorPage", propOrder = {
    "values"
})
public class TrafficEstimatorPage
    extends Page
{

    protected List<EstimateValues> values;

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
     * {@link EstimateValues }
     * 
     * 
     */
    public List<EstimateValues> getValues() {
        if (values == null) {
            values = new ArrayList<EstimateValues>();
        }
        return this.values;
    }

}

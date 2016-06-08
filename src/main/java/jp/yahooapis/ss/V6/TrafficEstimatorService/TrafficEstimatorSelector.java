
package jp.yahooapis.ss.V6.TrafficEstimatorService;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for TrafficEstimatorSelector complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="TrafficEstimatorSelector">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="estimateRequest" type="{http://ss.yahooapis.jp/V6}EstimateRequest" maxOccurs="unbounded"/>
 *         &lt;element name="month" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TrafficEstimatorSelector", propOrder = {
    "estimateRequest",
    "month"
})
public class TrafficEstimatorSelector {

    @XmlElement(required = true)
    protected List<EstimateRequest> estimateRequest;
    protected Integer month;

    /**
     * Gets the value of the estimateRequest property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the estimateRequest property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getEstimateRequest().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link EstimateRequest }
     * 
     * 
     */
    public List<EstimateRequest> getEstimateRequest() {
        if (estimateRequest == null) {
            estimateRequest = new ArrayList<EstimateRequest>();
        }
        return this.estimateRequest;
    }

    /**
     * Gets the value of the month property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getMonth() {
        return month;
    }

    /**
     * Sets the value of the month property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setMonth(Integer value) {
        this.month = value;
    }

}

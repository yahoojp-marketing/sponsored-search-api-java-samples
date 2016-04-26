
package jp.yahooapis.ss.V6.TrafficEstimatorService;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for EstimateTarget complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="EstimateTarget">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="network" type="{http://ss.yahooapis.jp/V6}EstimateNetwork"/>
 *         &lt;element name="mobileCarrier" type="{http://ss.yahooapis.jp/V6}CarrierName" minOccurs="0"/>
 *         &lt;element name="province" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "EstimateTarget", propOrder = {
    "network",
    "mobileCarrier",
    "province"
})
public class EstimateTarget {

    @XmlElement(required = true)
    @XmlSchemaType(name = "string")
    protected EstimateNetwork network;
    @XmlSchemaType(name = "string")
    protected CarrierName mobileCarrier;
    protected List<String> province;

    /**
     * Gets the value of the network property.
     * 
     * @return
     *     possible object is
     *     {@link EstimateNetwork }
     *     
     */
    public EstimateNetwork getNetwork() {
        return network;
    }

    /**
     * Sets the value of the network property.
     * 
     * @param value
     *     allowed object is
     *     {@link EstimateNetwork }
     *     
     */
    public void setNetwork(EstimateNetwork value) {
        this.network = value;
    }

    /**
     * Gets the value of the mobileCarrier property.
     * 
     * @return
     *     possible object is
     *     {@link CarrierName }
     *     
     */
    public CarrierName getMobileCarrier() {
        return mobileCarrier;
    }

    /**
     * Sets the value of the mobileCarrier property.
     * 
     * @param value
     *     allowed object is
     *     {@link CarrierName }
     *     
     */
    public void setMobileCarrier(CarrierName value) {
        this.mobileCarrier = value;
    }

    /**
     * Gets the value of the province property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the province property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getProvince().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getProvince() {
        if (province == null) {
            province = new ArrayList<String>();
        }
        return this.province;
    }

}

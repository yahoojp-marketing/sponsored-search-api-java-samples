
package jp.yahooapis.ss.V6.CampaignTargetService;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for NetworkTarget complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="NetworkTarget">
 *   &lt;complexContent>
 *     &lt;extension base="{http://ss.yahooapis.jp/V6}Target">
 *       &lt;sequence>
 *         &lt;element name="networkCoverageType" type="{http://ss.yahooapis.jp/V6}NetworkCoverageType" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "NetworkTarget", propOrder = {
    "networkCoverageType"
})
public class NetworkTarget
    extends Target
{

    @XmlSchemaType(name = "string")
    protected NetworkCoverageType networkCoverageType;

    /**
     * Gets the value of the networkCoverageType property.
     * 
     * @return
     *     possible object is
     *     {@link NetworkCoverageType }
     *     
     */
    public NetworkCoverageType getNetworkCoverageType() {
        return networkCoverageType;
    }

    /**
     * Sets the value of the networkCoverageType property.
     * 
     * @param value
     *     allowed object is
     *     {@link NetworkCoverageType }
     *     
     */
    public void setNetworkCoverageType(NetworkCoverageType value) {
        this.networkCoverageType = value;
    }

}


package jp.yahooapis.ss.V6.CampaignTargetService;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for Target complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Target">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="targetId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="targetType" type="{http://ss.yahooapis.jp/V6}TargetType" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Target", propOrder = {
    "targetId",
    "targetType"
})
@XmlSeeAlso({
    ScheduleTarget.class,
    LocationTarget.class,
    PlatformTarget.class,
    NetworkTarget.class
})
public class Target {

    protected String targetId;
    @XmlSchemaType(name = "string")
    protected TargetType targetType;

    /**
     * Gets the value of the targetId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTargetId() {
        return targetId;
    }

    /**
     * Sets the value of the targetId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTargetId(String value) {
        this.targetId = value;
    }

    /**
     * Gets the value of the targetType property.
     * 
     * @return
     *     possible object is
     *     {@link TargetType }
     *     
     */
    public TargetType getTargetType() {
        return targetType;
    }

    /**
     * Sets the value of the targetType property.
     * 
     * @param value
     *     allowed object is
     *     {@link TargetType }
     *     
     */
    public void setTargetType(TargetType value) {
        this.targetType = value;
    }

}

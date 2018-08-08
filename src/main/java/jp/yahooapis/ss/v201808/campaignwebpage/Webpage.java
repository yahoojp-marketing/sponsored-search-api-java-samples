
package jp.yahooapis.ss.v201808.campaignwebpage;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for Webpage complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Webpage">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="targetId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="targetTrackId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="parameter" type="{http://ss.yahooapis.jp/V201808/CampaignWebpage}WebpageParameter" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Webpage", propOrder = {
    "targetId",
    "targetTrackId",
    "parameter"
})
public class Webpage {

    protected Long targetId;
    protected Long targetTrackId;
    protected WebpageParameter parameter;

    /**
     * Gets the value of the targetId property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getTargetId() {
        return targetId;
    }

    /**
     * Sets the value of the targetId property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setTargetId(Long value) {
        this.targetId = value;
    }

    /**
     * Gets the value of the targetTrackId property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getTargetTrackId() {
        return targetTrackId;
    }

    /**
     * Sets the value of the targetTrackId property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setTargetTrackId(Long value) {
        this.targetTrackId = value;
    }

    /**
     * Gets the value of the parameter property.
     * 
     * @return
     *     possible object is
     *     {@link WebpageParameter }
     *     
     */
    public WebpageParameter getParameter() {
        return parameter;
    }

    /**
     * Sets the value of the parameter property.
     * 
     * @param value
     *     allowed object is
     *     {@link WebpageParameter }
     *     
     */
    public void setParameter(WebpageParameter value) {
        this.parameter = value;
    }

}

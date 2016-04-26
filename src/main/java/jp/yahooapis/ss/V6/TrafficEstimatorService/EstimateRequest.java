
package jp.yahooapis.ss.V6.TrafficEstimatorService;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for EstimateRequest complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="EstimateRequest">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="target" type="{http://ss.yahooapis.jp/V6}EstimateTarget"/>
 *         &lt;element name="keyword" type="{http://ss.yahooapis.jp/V6}ProposalKeyword"/>
 *         &lt;element name="bid" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="platform" type="{http://ss.yahooapis.jp/V6}ProposalPlatformTarget" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="wap" type="{http://ss.yahooapis.jp/V6}WapType" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "EstimateRequest", propOrder = {
    "target",
    "keyword",
    "bid",
    "platform",
    "wap"
})
public class EstimateRequest {

    @XmlElement(required = true)
    protected EstimateTarget target;
    @XmlElement(required = true)
    protected ProposalKeyword keyword;
    protected long bid;
    protected List<ProposalPlatformTarget> platform;
    @XmlSchemaType(name = "string")
    protected WapType wap;

    /**
     * Gets the value of the target property.
     * 
     * @return
     *     possible object is
     *     {@link EstimateTarget }
     *     
     */
    public EstimateTarget getTarget() {
        return target;
    }

    /**
     * Sets the value of the target property.
     * 
     * @param value
     *     allowed object is
     *     {@link EstimateTarget }
     *     
     */
    public void setTarget(EstimateTarget value) {
        this.target = value;
    }

    /**
     * Gets the value of the keyword property.
     * 
     * @return
     *     possible object is
     *     {@link ProposalKeyword }
     *     
     */
    public ProposalKeyword getKeyword() {
        return keyword;
    }

    /**
     * Sets the value of the keyword property.
     * 
     * @param value
     *     allowed object is
     *     {@link ProposalKeyword }
     *     
     */
    public void setKeyword(ProposalKeyword value) {
        this.keyword = value;
    }

    /**
     * Gets the value of the bid property.
     * 
     */
    public long getBid() {
        return bid;
    }

    /**
     * Sets the value of the bid property.
     * 
     */
    public void setBid(long value) {
        this.bid = value;
    }

    /**
     * Gets the value of the platform property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the platform property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getPlatform().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ProposalPlatformTarget }
     * 
     * 
     */
    public List<ProposalPlatformTarget> getPlatform() {
        if (platform == null) {
            platform = new ArrayList<ProposalPlatformTarget>();
        }
        return this.platform;
    }

    /**
     * Gets the value of the wap property.
     * 
     * @return
     *     possible object is
     *     {@link WapType }
     *     
     */
    public WapType getWap() {
        return wap;
    }

    /**
     * Sets the value of the wap property.
     * 
     * @param value
     *     allowed object is
     *     {@link WapType }
     *     
     */
    public void setWap(WapType value) {
        this.wap = value;
    }

}

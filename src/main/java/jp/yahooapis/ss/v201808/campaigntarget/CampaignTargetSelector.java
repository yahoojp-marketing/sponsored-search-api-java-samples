
package jp.yahooapis.ss.v201808.campaigntarget;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import jp.yahooapis.ss.v201808.Paging;


/**
 * <p>Java class for CampaignTargetSelector complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="CampaignTargetSelector">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="accountId" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="campaignIds" type="{http://www.w3.org/2001/XMLSchema}long" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="targetIds" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="targetTypes" type="{http://ss.yahooapis.jp/V201808/CampaignTarget}TargetType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="excludedType" type="{http://ss.yahooapis.jp/V201808/CampaignTarget}ExcludedType" minOccurs="0"/>
 *         &lt;element name="platformTypes" type="{http://ss.yahooapis.jp/V201808/CampaignTarget}PlatformType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="paging" type="{http://ss.yahooapis.jp/V201808}Paging" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CampaignTargetSelector", propOrder = {
    "accountId",
    "campaignIds",
    "targetIds",
    "targetTypes",
    "excludedType",
    "platformTypes",
    "paging"
})
public class CampaignTargetSelector {

    protected long accountId;
    @XmlElement(type = Long.class)
    protected List<Long> campaignIds;
    protected List<String> targetIds;
    @XmlSchemaType(name = "string")
    protected List<TargetType> targetTypes;
    @XmlSchemaType(name = "string")
    protected ExcludedType excludedType;
    @XmlSchemaType(name = "string")
    protected List<PlatformType> platformTypes;
    protected Paging paging;

    /**
     * Gets the value of the accountId property.
     * 
     */
    public long getAccountId() {
        return accountId;
    }

    /**
     * Sets the value of the accountId property.
     * 
     */
    public void setAccountId(long value) {
        this.accountId = value;
    }

    /**
     * Gets the value of the campaignIds property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the campaignIds property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getCampaignIds().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Long }
     * 
     * 
     */
    public List<Long> getCampaignIds() {
        if (campaignIds == null) {
            campaignIds = new ArrayList<Long>();
        }
        return this.campaignIds;
    }

    /**
     * Gets the value of the targetIds property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the targetIds property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getTargetIds().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getTargetIds() {
        if (targetIds == null) {
            targetIds = new ArrayList<String>();
        }
        return this.targetIds;
    }

    /**
     * Gets the value of the targetTypes property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the targetTypes property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getTargetTypes().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link TargetType }
     * 
     * 
     */
    public List<TargetType> getTargetTypes() {
        if (targetTypes == null) {
            targetTypes = new ArrayList<TargetType>();
        }
        return this.targetTypes;
    }

    /**
     * Gets the value of the excludedType property.
     * 
     * @return
     *     possible object is
     *     {@link ExcludedType }
     *     
     */
    public ExcludedType getExcludedType() {
        return excludedType;
    }

    /**
     * Sets the value of the excludedType property.
     * 
     * @param value
     *     allowed object is
     *     {@link ExcludedType }
     *     
     */
    public void setExcludedType(ExcludedType value) {
        this.excludedType = value;
    }

    /**
     * Gets the value of the platformTypes property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the platformTypes property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getPlatformTypes().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link PlatformType }
     * 
     * 
     */
    public List<PlatformType> getPlatformTypes() {
        if (platformTypes == null) {
            platformTypes = new ArrayList<PlatformType>();
        }
        return this.platformTypes;
    }

    /**
     * Gets the value of the paging property.
     * 
     * @return
     *     possible object is
     *     {@link Paging }
     *     
     */
    public Paging getPaging() {
        return paging;
    }

    /**
     * Sets the value of the paging property.
     * 
     * @param value
     *     allowed object is
     *     {@link Paging }
     *     
     */
    public void setPaging(Paging value) {
        this.paging = value;
    }

}

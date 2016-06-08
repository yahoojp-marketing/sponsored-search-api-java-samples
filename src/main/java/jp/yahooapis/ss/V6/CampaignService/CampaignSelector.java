
package jp.yahooapis.ss.V6.CampaignService;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for CampaignSelector complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="CampaignSelector">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="accountId" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="campaignIds" type="{http://www.w3.org/2001/XMLSchema}long" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="userStatuses" type="{http://ss.yahooapis.jp/V6}UserStatus" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="biddingStrategyIds" type="{http://www.w3.org/2001/XMLSchema}long" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="paging" type="{http://ss.yahooapis.jp/V6}Paging" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CampaignSelector", propOrder = {
    "accountId",
    "campaignIds",
    "userStatuses",
    "biddingStrategyIds",
    "paging"
})
public class CampaignSelector {

    protected long accountId;
    @XmlElement(type = Long.class)
    protected List<Long> campaignIds;
    @XmlSchemaType(name = "string")
    protected List<UserStatus> userStatuses;
    @XmlElement(type = Long.class)
    protected List<Long> biddingStrategyIds;
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
     * Gets the value of the userStatuses property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the userStatuses property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getUserStatuses().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link UserStatus }
     * 
     * 
     */
    public List<UserStatus> getUserStatuses() {
        if (userStatuses == null) {
            userStatuses = new ArrayList<UserStatus>();
        }
        return this.userStatuses;
    }

    /**
     * Gets the value of the biddingStrategyIds property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the biddingStrategyIds property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getBiddingStrategyIds().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Long }
     * 
     * 
     */
    public List<Long> getBiddingStrategyIds() {
        if (biddingStrategyIds == null) {
            biddingStrategyIds = new ArrayList<Long>();
        }
        return this.biddingStrategyIds;
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

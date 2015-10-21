
package jp.yahooapis.ss.V5.BulkService;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for BulkDownloadSelector complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="BulkDownloadSelector">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="accountId" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="campaignIds" type="{http://www.w3.org/2001/XMLSchema}long" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="campaignCriterionIds" type="{http://www.w3.org/2001/XMLSchema}long" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="adGroupIds" type="{http://www.w3.org/2001/XMLSchema}long" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="adIds" type="{http://www.w3.org/2001/XMLSchema}long" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="adGroupCriterionIds" type="{http://www.w3.org/2001/XMLSchema}long" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="campaignUserStatuses" type="{http://ss.yahooapis.jp/V5}UserStatus" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="adGroupUserStatuses" type="{http://ss.yahooapis.jp/V5}UserStatus" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="adGroupAdUserStatuses" type="{http://ss.yahooapis.jp/V5}UserStatus" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="adGroupCriterionUserStatuses" type="{http://ss.yahooapis.jp/V5}UserStatus" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="adGroupAdApprovalStatuses" type="{http://ss.yahooapis.jp/V5}ApprovalStatus" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="adGroupCriterionApprovalStatuses" type="{http://ss.yahooapis.jp/V5}ApprovalStatus" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="entityTypes" type="{http://ss.yahooapis.jp/V5}BulkEntityType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="downloadBulkJob" type="{http://ss.yahooapis.jp/V5}DownloadBulkJob" minOccurs="0"/>
 *         &lt;element name="lang" type="{http://ss.yahooapis.jp/V5}BulkLang"/>
 *         &lt;element name="output" type="{http://ss.yahooapis.jp/V5}BulkOutput"/>
 *         &lt;element name="encoding" type="{http://ss.yahooapis.jp/V5}BulkEncoding"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "BulkDownloadSelector", propOrder = {
    "accountId",
    "campaignIds",
    "campaignCriterionIds",
    "adGroupIds",
    "adIds",
    "adGroupCriterionIds",
    "campaignUserStatuses",
    "adGroupUserStatuses",
    "adGroupAdUserStatuses",
    "adGroupCriterionUserStatuses",
    "adGroupAdApprovalStatuses",
    "adGroupCriterionApprovalStatuses",
    "entityTypes",
    "downloadBulkJob",
    "lang",
    "output",
    "encoding"
})
public class BulkDownloadSelector {

    protected long accountId;
    @XmlElement(type = Long.class)
    protected List<Long> campaignIds;
    @XmlElement(type = Long.class)
    protected List<Long> campaignCriterionIds;
    @XmlElement(type = Long.class)
    protected List<Long> adGroupIds;
    @XmlElement(type = Long.class)
    protected List<Long> adIds;
    @XmlElement(type = Long.class)
    protected List<Long> adGroupCriterionIds;
    @XmlSchemaType(name = "string")
    protected List<UserStatus> campaignUserStatuses;
    @XmlSchemaType(name = "string")
    protected List<UserStatus> adGroupUserStatuses;
    @XmlSchemaType(name = "string")
    protected List<UserStatus> adGroupAdUserStatuses;
    @XmlSchemaType(name = "string")
    protected List<UserStatus> adGroupCriterionUserStatuses;
    @XmlSchemaType(name = "string")
    protected List<ApprovalStatus> adGroupAdApprovalStatuses;
    @XmlSchemaType(name = "string")
    protected List<ApprovalStatus> adGroupCriterionApprovalStatuses;
    @XmlSchemaType(name = "string")
    protected List<BulkEntityType> entityTypes;
    protected DownloadBulkJob downloadBulkJob;
    @XmlElement(required = true)
    @XmlSchemaType(name = "string")
    protected BulkLang lang;
    @XmlElement(required = true)
    @XmlSchemaType(name = "string")
    protected BulkOutput output;
    @XmlElement(required = true)
    @XmlSchemaType(name = "string")
    protected BulkEncoding encoding;

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
     * Gets the value of the campaignCriterionIds property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the campaignCriterionIds property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getCampaignCriterionIds().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Long }
     * 
     * 
     */
    public List<Long> getCampaignCriterionIds() {
        if (campaignCriterionIds == null) {
            campaignCriterionIds = new ArrayList<Long>();
        }
        return this.campaignCriterionIds;
    }

    /**
     * Gets the value of the adGroupIds property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the adGroupIds property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAdGroupIds().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Long }
     * 
     * 
     */
    public List<Long> getAdGroupIds() {
        if (adGroupIds == null) {
            adGroupIds = new ArrayList<Long>();
        }
        return this.adGroupIds;
    }

    /**
     * Gets the value of the adIds property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the adIds property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAdIds().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Long }
     * 
     * 
     */
    public List<Long> getAdIds() {
        if (adIds == null) {
            adIds = new ArrayList<Long>();
        }
        return this.adIds;
    }

    /**
     * Gets the value of the adGroupCriterionIds property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the adGroupCriterionIds property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAdGroupCriterionIds().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Long }
     * 
     * 
     */
    public List<Long> getAdGroupCriterionIds() {
        if (adGroupCriterionIds == null) {
            adGroupCriterionIds = new ArrayList<Long>();
        }
        return this.adGroupCriterionIds;
    }

    /**
     * Gets the value of the campaignUserStatuses property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the campaignUserStatuses property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getCampaignUserStatuses().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link UserStatus }
     * 
     * 
     */
    public List<UserStatus> getCampaignUserStatuses() {
        if (campaignUserStatuses == null) {
            campaignUserStatuses = new ArrayList<UserStatus>();
        }
        return this.campaignUserStatuses;
    }

    /**
     * Gets the value of the adGroupUserStatuses property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the adGroupUserStatuses property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAdGroupUserStatuses().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link UserStatus }
     * 
     * 
     */
    public List<UserStatus> getAdGroupUserStatuses() {
        if (adGroupUserStatuses == null) {
            adGroupUserStatuses = new ArrayList<UserStatus>();
        }
        return this.adGroupUserStatuses;
    }

    /**
     * Gets the value of the adGroupAdUserStatuses property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the adGroupAdUserStatuses property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAdGroupAdUserStatuses().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link UserStatus }
     * 
     * 
     */
    public List<UserStatus> getAdGroupAdUserStatuses() {
        if (adGroupAdUserStatuses == null) {
            adGroupAdUserStatuses = new ArrayList<UserStatus>();
        }
        return this.adGroupAdUserStatuses;
    }

    /**
     * Gets the value of the adGroupCriterionUserStatuses property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the adGroupCriterionUserStatuses property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAdGroupCriterionUserStatuses().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link UserStatus }
     * 
     * 
     */
    public List<UserStatus> getAdGroupCriterionUserStatuses() {
        if (adGroupCriterionUserStatuses == null) {
            adGroupCriterionUserStatuses = new ArrayList<UserStatus>();
        }
        return this.adGroupCriterionUserStatuses;
    }

    /**
     * Gets the value of the adGroupAdApprovalStatuses property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the adGroupAdApprovalStatuses property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAdGroupAdApprovalStatuses().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ApprovalStatus }
     * 
     * 
     */
    public List<ApprovalStatus> getAdGroupAdApprovalStatuses() {
        if (adGroupAdApprovalStatuses == null) {
            adGroupAdApprovalStatuses = new ArrayList<ApprovalStatus>();
        }
        return this.adGroupAdApprovalStatuses;
    }

    /**
     * Gets the value of the adGroupCriterionApprovalStatuses property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the adGroupCriterionApprovalStatuses property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAdGroupCriterionApprovalStatuses().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ApprovalStatus }
     * 
     * 
     */
    public List<ApprovalStatus> getAdGroupCriterionApprovalStatuses() {
        if (adGroupCriterionApprovalStatuses == null) {
            adGroupCriterionApprovalStatuses = new ArrayList<ApprovalStatus>();
        }
        return this.adGroupCriterionApprovalStatuses;
    }

    /**
     * Gets the value of the entityTypes property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the entityTypes property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getEntityTypes().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link BulkEntityType }
     * 
     * 
     */
    public List<BulkEntityType> getEntityTypes() {
        if (entityTypes == null) {
            entityTypes = new ArrayList<BulkEntityType>();
        }
        return this.entityTypes;
    }

    /**
     * Gets the value of the downloadBulkJob property.
     * 
     * @return
     *     possible object is
     *     {@link DownloadBulkJob }
     *     
     */
    public DownloadBulkJob getDownloadBulkJob() {
        return downloadBulkJob;
    }

    /**
     * Sets the value of the downloadBulkJob property.
     * 
     * @param value
     *     allowed object is
     *     {@link DownloadBulkJob }
     *     
     */
    public void setDownloadBulkJob(DownloadBulkJob value) {
        this.downloadBulkJob = value;
    }

    /**
     * Gets the value of the lang property.
     * 
     * @return
     *     possible object is
     *     {@link BulkLang }
     *     
     */
    public BulkLang getLang() {
        return lang;
    }

    /**
     * Sets the value of the lang property.
     * 
     * @param value
     *     allowed object is
     *     {@link BulkLang }
     *     
     */
    public void setLang(BulkLang value) {
        this.lang = value;
    }

    /**
     * Gets the value of the output property.
     * 
     * @return
     *     possible object is
     *     {@link BulkOutput }
     *     
     */
    public BulkOutput getOutput() {
        return output;
    }

    /**
     * Sets the value of the output property.
     * 
     * @param value
     *     allowed object is
     *     {@link BulkOutput }
     *     
     */
    public void setOutput(BulkOutput value) {
        this.output = value;
    }

    /**
     * Gets the value of the encoding property.
     * 
     * @return
     *     possible object is
     *     {@link BulkEncoding }
     *     
     */
    public BulkEncoding getEncoding() {
        return encoding;
    }

    /**
     * Sets the value of the encoding property.
     * 
     * @param value
     *     allowed object is
     *     {@link BulkEncoding }
     *     
     */
    public void setEncoding(BulkEncoding value) {
        this.encoding = value;
    }

}

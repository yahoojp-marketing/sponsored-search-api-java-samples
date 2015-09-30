
package jp.yahooapis.ss.V5.BulkService;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for BulkDownloadStatusSelector complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="BulkDownloadStatusSelector">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="accountId" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="downloadBulkJobIds" type="{http://www.w3.org/2001/XMLSchema}long" maxOccurs="unbounded"/>
 *         &lt;element name="downloadBulkJobStatuses" type="{http://ss.yahooapis.jp/V5}DownloadBulkJobStatus" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="paging" type="{http://ss.yahooapis.jp/V5}Paging" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "BulkDownloadStatusSelector", propOrder = {
    "accountId",
    "downloadBulkJobIds",
    "downloadBulkJobStatuses",
    "paging"
})
public class BulkDownloadStatusSelector {

    protected long accountId;
    @XmlElement(type = Long.class)
    protected List<Long> downloadBulkJobIds;
    @XmlSchemaType(name = "string")
    protected List<DownloadBulkJobStatus> downloadBulkJobStatuses;
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
     * Gets the value of the downloadBulkJobIds property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the downloadBulkJobIds property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getDownloadBulkJobIds().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Long }
     * 
     * 
     */
    public List<Long> getDownloadBulkJobIds() {
        if (downloadBulkJobIds == null) {
            downloadBulkJobIds = new ArrayList<Long>();
        }
        return this.downloadBulkJobIds;
    }

    /**
     * Gets the value of the downloadBulkJobStatuses property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the downloadBulkJobStatuses property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getDownloadBulkJobStatuses().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link DownloadBulkJobStatus }
     * 
     * 
     */
    public List<DownloadBulkJobStatus> getDownloadBulkJobStatuses() {
        if (downloadBulkJobStatuses == null) {
            downloadBulkJobStatuses = new ArrayList<DownloadBulkJobStatus>();
        }
        return this.downloadBulkJobStatuses;
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

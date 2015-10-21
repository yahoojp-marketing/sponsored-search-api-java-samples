
package jp.yahooapis.ss.V5.BulkService;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for BulkUploadStatusSelector complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="BulkUploadStatusSelector">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="accountId" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="uploadBulkJobIds" type="{http://www.w3.org/2001/XMLSchema}long" maxOccurs="unbounded"/>
 *         &lt;element name="uploadBulkJobStatuses" type="{http://ss.yahooapis.jp/V5}UploadBulkJobStatus" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="lang" type="{http://ss.yahooapis.jp/V5}BulkLang"/>
 *         &lt;element name="output" type="{http://ss.yahooapis.jp/V5}BulkOutput"/>
 *         &lt;element name="encoding" type="{http://ss.yahooapis.jp/V5}BulkEncoding"/>
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
@XmlType(name = "BulkUploadStatusSelector", propOrder = {
    "accountId",
    "uploadBulkJobIds",
    "uploadBulkJobStatuses",
    "lang",
    "output",
    "encoding",
    "paging"
})
public class BulkUploadStatusSelector {

    protected long accountId;
    @XmlElement(type = Long.class)
    protected List<Long> uploadBulkJobIds;
    @XmlSchemaType(name = "string")
    protected List<UploadBulkJobStatus> uploadBulkJobStatuses;
    @XmlElement(required = true)
    @XmlSchemaType(name = "string")
    protected BulkLang lang;
    @XmlElement(required = true)
    @XmlSchemaType(name = "string")
    protected BulkOutput output;
    @XmlElement(required = true)
    @XmlSchemaType(name = "string")
    protected BulkEncoding encoding;
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
     * Gets the value of the uploadBulkJobIds property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the uploadBulkJobIds property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getUploadBulkJobIds().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Long }
     * 
     * 
     */
    public List<Long> getUploadBulkJobIds() {
        if (uploadBulkJobIds == null) {
            uploadBulkJobIds = new ArrayList<Long>();
        }
        return this.uploadBulkJobIds;
    }

    /**
     * Gets the value of the uploadBulkJobStatuses property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the uploadBulkJobStatuses property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getUploadBulkJobStatuses().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link UploadBulkJobStatus }
     * 
     * 
     */
    public List<UploadBulkJobStatus> getUploadBulkJobStatuses() {
        if (uploadBulkJobStatuses == null) {
            uploadBulkJobStatuses = new ArrayList<UploadBulkJobStatus>();
        }
        return this.uploadBulkJobStatuses;
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

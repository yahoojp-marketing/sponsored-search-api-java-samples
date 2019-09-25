
package jp.yahooapis.ss.v201909.reportdefinition;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import jp.yahooapis.ss.v201909.Paging;


/**
 * <p>Java class for ReportDefinitionSelector complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ReportDefinitionSelector">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="accountId" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="reportJobIds" type="{http://www.w3.org/2001/XMLSchema}long" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="reportTypes" type="{http://ss.yahooapis.jp/V201909/ReportDefinition}ReportType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="reportJobStatuses" type="{http://ss.yahooapis.jp/V201909/ReportDefinition}ReportJobStatus" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="paging" type="{http://ss.yahooapis.jp/V201909}Paging" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ReportDefinitionSelector", propOrder = {
    "accountId",
    "reportJobIds",
    "reportTypes",
    "reportJobStatuses",
    "paging"
})
public class ReportDefinitionSelector {

    protected long accountId;
    @XmlElement(type = Long.class)
    protected List<Long> reportJobIds;
    @XmlSchemaType(name = "string")
    protected List<ReportType> reportTypes;
    @XmlSchemaType(name = "string")
    protected List<ReportJobStatus> reportJobStatuses;
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
     * Gets the value of the reportJobIds property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the reportJobIds property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getReportJobIds().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Long }
     * 
     * 
     */
    public List<Long> getReportJobIds() {
        if (reportJobIds == null) {
            reportJobIds = new ArrayList<Long>();
        }
        return this.reportJobIds;
    }

    /**
     * Gets the value of the reportTypes property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the reportTypes property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getReportTypes().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ReportType }
     * 
     * 
     */
    public List<ReportType> getReportTypes() {
        if (reportTypes == null) {
            reportTypes = new ArrayList<ReportType>();
        }
        return this.reportTypes;
    }

    /**
     * Gets the value of the reportJobStatuses property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the reportJobStatuses property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getReportJobStatuses().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ReportJobStatus }
     * 
     * 
     */
    public List<ReportJobStatus> getReportJobStatuses() {
        if (reportJobStatuses == null) {
            reportJobStatuses = new ArrayList<ReportJobStatus>();
        }
        return this.reportJobStatuses;
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

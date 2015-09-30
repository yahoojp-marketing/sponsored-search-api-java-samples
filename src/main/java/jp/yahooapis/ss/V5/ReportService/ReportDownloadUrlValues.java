
package jp.yahooapis.ss.V5.ReportService;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ReportDownloadUrlValues complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ReportDownloadUrlValues">
 *   &lt;complexContent>
 *     &lt;extension base="{http://ss.yahooapis.jp/V5}ReturnValue">
 *       &lt;sequence>
 *         &lt;element name="reportDownloadUrl" type="{http://ss.yahooapis.jp/V5}ReportDownloadUrl" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ReportDownloadUrlValues", propOrder = {
    "reportDownloadUrl"
})
public class ReportDownloadUrlValues
    extends ReturnValue
{

    protected ReportDownloadUrl reportDownloadUrl;

    /**
     * Gets the value of the reportDownloadUrl property.
     * 
     * @return
     *     possible object is
     *     {@link ReportDownloadUrl }
     *     
     */
    public ReportDownloadUrl getReportDownloadUrl() {
        return reportDownloadUrl;
    }

    /**
     * Sets the value of the reportDownloadUrl property.
     * 
     * @param value
     *     allowed object is
     *     {@link ReportDownloadUrl }
     *     
     */
    public void setReportDownloadUrl(ReportDownloadUrl value) {
        this.reportDownloadUrl = value;
    }

}

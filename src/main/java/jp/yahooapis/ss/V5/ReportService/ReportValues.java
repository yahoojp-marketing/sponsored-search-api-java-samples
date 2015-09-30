
package jp.yahooapis.ss.V5.ReportService;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ReportValues complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ReportValues">
 *   &lt;complexContent>
 *     &lt;extension base="{http://ss.yahooapis.jp/V5}ReturnValue">
 *       &lt;sequence>
 *         &lt;element name="reportRecord" type="{http://ss.yahooapis.jp/V5}ReportRecord" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ReportValues", propOrder = {
    "reportRecord"
})
public class ReportValues
    extends ReturnValue
{

    protected ReportRecord reportRecord;

    /**
     * Gets the value of the reportRecord property.
     * 
     * @return
     *     possible object is
     *     {@link ReportRecord }
     *     
     */
    public ReportRecord getReportRecord() {
        return reportRecord;
    }

    /**
     * Sets the value of the reportRecord property.
     * 
     * @param value
     *     allowed object is
     *     {@link ReportRecord }
     *     
     */
    public void setReportRecord(ReportRecord value) {
        this.reportRecord = value;
    }

}

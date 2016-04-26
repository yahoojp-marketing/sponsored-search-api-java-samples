
package jp.yahooapis.ss.V6.ReportDefinitionService;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ReportDefinitionValues complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ReportDefinitionValues">
 *   &lt;complexContent>
 *     &lt;extension base="{http://ss.yahooapis.jp/V6}ReturnValue">
 *       &lt;sequence>
 *         &lt;element name="reportDefinition" type="{http://ss.yahooapis.jp/V6}ReportDefinition" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ReportDefinitionValues", propOrder = {
    "reportDefinition"
})
public class ReportDefinitionValues
    extends ReturnValue
{

    protected ReportDefinition reportDefinition;

    /**
     * Gets the value of the reportDefinition property.
     * 
     * @return
     *     possible object is
     *     {@link ReportDefinition }
     *     
     */
    public ReportDefinition getReportDefinition() {
        return reportDefinition;
    }

    /**
     * Sets the value of the reportDefinition property.
     * 
     * @param value
     *     allowed object is
     *     {@link ReportDefinition }
     *     
     */
    public void setReportDefinition(ReportDefinition value) {
        this.reportDefinition = value;
    }

}

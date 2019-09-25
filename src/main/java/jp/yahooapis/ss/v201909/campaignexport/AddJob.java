
package jp.yahooapis.ss.v201909.campaignexport;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="setting" type="{http://ss.yahooapis.jp/V201909/CampaignExport}ExportSetting"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "setting"
})
@XmlRootElement(name = "addJob")
public class AddJob {

    @XmlElement(required = true)
    protected ExportSetting setting;

    /**
     * Gets the value of the setting property.
     * 
     * @return
     *     possible object is
     *     {@link ExportSetting }
     *     
     */
    public ExportSetting getSetting() {
        return setting;
    }

    /**
     * Sets the value of the setting property.
     * 
     * @param value
     *     allowed object is
     *     {@link ExportSetting }
     *     
     */
    public void setSetting(ExportSetting value) {
        this.setting = value;
    }

}

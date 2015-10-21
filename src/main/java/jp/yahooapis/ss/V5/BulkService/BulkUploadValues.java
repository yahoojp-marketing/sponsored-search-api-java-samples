
package jp.yahooapis.ss.V5.BulkService;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for BulkUploadValues complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="BulkUploadValues">
 *   &lt;complexContent>
 *     &lt;extension base="{http://ss.yahooapis.jp/V5}ReturnValue">
 *       &lt;sequence>
 *         &lt;element name="uploadBulkJob" type="{http://ss.yahooapis.jp/V5}UploadBulkJob" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "BulkUploadValues", propOrder = {
    "uploadBulkJob"
})
public class BulkUploadValues
    extends ReturnValue
{

    protected UploadBulkJob uploadBulkJob;

    /**
     * Gets the value of the uploadBulkJob property.
     * 
     * @return
     *     possible object is
     *     {@link UploadBulkJob }
     *     
     */
    public UploadBulkJob getUploadBulkJob() {
        return uploadBulkJob;
    }

    /**
     * Sets the value of the uploadBulkJob property.
     * 
     * @param value
     *     allowed object is
     *     {@link UploadBulkJob }
     *     
     */
    public void setUploadBulkJob(UploadBulkJob value) {
        this.uploadBulkJob = value;
    }

}

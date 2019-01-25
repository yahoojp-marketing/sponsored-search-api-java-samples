
package jp.yahooapis.ss.v201901.pagefeeditem;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for PageFeedItemUploadJob complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="PageFeedItemUploadJob">
 *   &lt;complexContent>
 *     &lt;extension base="{http://ss.yahooapis.jp/V201901/PageFeedItem}PageFeedItemJob">
 *       &lt;sequence>
 *         &lt;element name="uploadJobStatus" type="{http://ss.yahooapis.jp/V201901/PageFeedItem}PageFeedItemUploadJobStatus" minOccurs="0"/>
 *         &lt;element name="errorCount" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="errorFileUrl" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PageFeedItemUploadJob", propOrder = {
    "uploadJobStatus",
    "errorCount",
    "errorFileUrl"
})
public class PageFeedItemUploadJob
    extends PageFeedItemJob
{

    @XmlSchemaType(name = "string")
    protected PageFeedItemUploadJobStatus uploadJobStatus;
    protected Integer errorCount;
    protected String errorFileUrl;

    /**
     * Gets the value of the uploadJobStatus property.
     * 
     * @return
     *     possible object is
     *     {@link PageFeedItemUploadJobStatus }
     *     
     */
    public PageFeedItemUploadJobStatus getUploadJobStatus() {
        return uploadJobStatus;
    }

    /**
     * Sets the value of the uploadJobStatus property.
     * 
     * @param value
     *     allowed object is
     *     {@link PageFeedItemUploadJobStatus }
     *     
     */
    public void setUploadJobStatus(PageFeedItemUploadJobStatus value) {
        this.uploadJobStatus = value;
    }

    /**
     * Gets the value of the errorCount property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getErrorCount() {
        return errorCount;
    }

    /**
     * Sets the value of the errorCount property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setErrorCount(Integer value) {
        this.errorCount = value;
    }

    /**
     * Gets the value of the errorFileUrl property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getErrorFileUrl() {
        return errorFileUrl;
    }

    /**
     * Sets the value of the errorFileUrl property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setErrorFileUrl(String value) {
        this.errorFileUrl = value;
    }

}

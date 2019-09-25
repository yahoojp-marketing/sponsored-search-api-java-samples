
package jp.yahooapis.ss.v201909.pagefeeditem;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for PageFeedItemDownloadJob complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="PageFeedItemDownloadJob">
 *   &lt;complexContent>
 *     &lt;extension base="{http://ss.yahooapis.jp/V201909/PageFeedItem}PageFeedItemJob">
 *       &lt;sequence>
 *         &lt;element name="lang" type="{http://ss.yahooapis.jp/V201909/PageFeedItem}BulkLang" minOccurs="0"/>
 *         &lt;element name="output" type="{http://ss.yahooapis.jp/V201909/PageFeedItem}BulkOutput" minOccurs="0"/>
 *         &lt;element name="encoding" type="{http://ss.yahooapis.jp/V201909/PageFeedItem}BulkEncoding" minOccurs="0"/>
 *         &lt;element name="downloadJobStatus" type="{http://ss.yahooapis.jp/V201909/PageFeedItem}PageFeedItemDownloadJobStatus" minOccurs="0"/>
 *         &lt;element name="downloadUrl" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PageFeedItemDownloadJob", propOrder = {
    "lang",
    "output",
    "encoding",
    "downloadJobStatus",
    "downloadUrl"
})
public class PageFeedItemDownloadJob
    extends PageFeedItemJob
{

    @XmlSchemaType(name = "string")
    protected BulkLang lang;
    @XmlSchemaType(name = "string")
    protected BulkOutput output;
    @XmlSchemaType(name = "string")
    protected BulkEncoding encoding;
    @XmlSchemaType(name = "string")
    protected PageFeedItemDownloadJobStatus downloadJobStatus;
    protected String downloadUrl;

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
     * Gets the value of the downloadJobStatus property.
     * 
     * @return
     *     possible object is
     *     {@link PageFeedItemDownloadJobStatus }
     *     
     */
    public PageFeedItemDownloadJobStatus getDownloadJobStatus() {
        return downloadJobStatus;
    }

    /**
     * Sets the value of the downloadJobStatus property.
     * 
     * @param value
     *     allowed object is
     *     {@link PageFeedItemDownloadJobStatus }
     *     
     */
    public void setDownloadJobStatus(PageFeedItemDownloadJobStatus value) {
        this.downloadJobStatus = value;
    }

    /**
     * Gets the value of the downloadUrl property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDownloadUrl() {
        return downloadUrl;
    }

    /**
     * Sets the value of the downloadUrl property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDownloadUrl(String value) {
        this.downloadUrl = value;
    }

}

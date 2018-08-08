
package jp.yahooapis.ss.v201808.pagefeeditem;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for PageFeedItemUploadUrl complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="PageFeedItemUploadUrl">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="accountId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="uploadType" type="{http://ss.yahooapis.jp/V201808/PageFeedItem}PageFeedItemUploadType" minOccurs="0"/>
 *         &lt;element name="feedFolderId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="url" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PageFeedItemUploadUrl", propOrder = {
    "accountId",
    "uploadType",
    "feedFolderId",
    "url"
})
public class PageFeedItemUploadUrl {

    protected Long accountId;
    @XmlSchemaType(name = "string")
    protected PageFeedItemUploadType uploadType;
    protected Long feedFolderId;
    protected String url;

    /**
     * Gets the value of the accountId property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getAccountId() {
        return accountId;
    }

    /**
     * Sets the value of the accountId property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setAccountId(Long value) {
        this.accountId = value;
    }

    /**
     * Gets the value of the uploadType property.
     * 
     * @return
     *     possible object is
     *     {@link PageFeedItemUploadType }
     *     
     */
    public PageFeedItemUploadType getUploadType() {
        return uploadType;
    }

    /**
     * Sets the value of the uploadType property.
     * 
     * @param value
     *     allowed object is
     *     {@link PageFeedItemUploadType }
     *     
     */
    public void setUploadType(PageFeedItemUploadType value) {
        this.uploadType = value;
    }

    /**
     * Gets the value of the feedFolderId property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getFeedFolderId() {
        return feedFolderId;
    }

    /**
     * Sets the value of the feedFolderId property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setFeedFolderId(Long value) {
        this.feedFolderId = value;
    }

    /**
     * Gets the value of the url property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUrl() {
        return url;
    }

    /**
     * Sets the value of the url property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUrl(String value) {
        this.url = value;
    }

}


package jp.yahooapis.ss.v201808.pagefeeditem;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;
import jp.yahooapis.ss.v201808.ReturnValue;


/**
 * <p>Java class for PageFeedItemUploadUrlValues complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="PageFeedItemUploadUrlValues">
 *   &lt;complexContent>
 *     &lt;extension base="{http://ss.yahooapis.jp/V201808}ReturnValue">
 *       &lt;sequence>
 *         &lt;element name="uploadUrl" type="{http://ss.yahooapis.jp/V201808/PageFeedItem}PageFeedItemUploadUrl" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PageFeedItemUploadUrlValues", propOrder = {
    "uploadUrl"
})
public class PageFeedItemUploadUrlValues
    extends ReturnValue
{

    protected PageFeedItemUploadUrl uploadUrl;

    /**
     * Gets the value of the uploadUrl property.
     * 
     * @return
     *     possible object is
     *     {@link PageFeedItemUploadUrl }
     *     
     */
    public PageFeedItemUploadUrl getUploadUrl() {
        return uploadUrl;
    }

    /**
     * Sets the value of the uploadUrl property.
     * 
     * @param value
     *     allowed object is
     *     {@link PageFeedItemUploadUrl }
     *     
     */
    public void setUploadUrl(PageFeedItemUploadUrl value) {
        this.uploadUrl = value;
    }

}
